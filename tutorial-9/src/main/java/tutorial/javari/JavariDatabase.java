package tutorial.javari;

import org.json.JSONException;
import org.json.JSONObject;
import tutorial.javari.animal.Animal;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavariDatabase {
    static final List<Animal> animalList = new ArrayList<Animal>();

    public static  Animal deleteFromCsv(Integer id) {
        readCsv();
        Animal removedAnimal = null;
        try {
            Scanner reader = new Scanner(new FileReader("animal_data.csv"));
            String[] splitLine;
            String line;
            List<String> updatedCsv = new ArrayList<String>();
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                splitLine = line.split(",");
                if (Integer.parseInt(splitLine[0]) == id) {
                    removedAnimal = new Animal(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2],
                            Gender.parseGender(splitLine[3]), Double.parseDouble(splitLine[4]),
                            Double.parseDouble(splitLine[5]), Condition.parseCondition(splitLine[6]));
                    animalList.remove(removedAnimal);
                } else {
                    updatedCsv.add(line);
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("animal_data.csv"));
            for (String s : updatedCsv) {
                writer.append(s).append("\n");
                writer.flush();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return removedAnimal;
    }

    private static void addToCsv(String line) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("animal_data.csv"));
            for (Animal animal : animalList) {
                writer.append(animalToCsv(animal)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Animal addAnimalToDatabase(String json) throws JSONException {
        Animal newAnimal = jsonToAnimal(json);
        animalToCsv(newAnimal);
        return newAnimal;
    }


    public static void readCsv() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("animal_data.csv"));
            scanner.useDelimiter(",");
            String[] line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().split(",");
                animalList.add(new Animal(Integer.parseInt(line[0]), line[1], line[2],
                        Gender.parseGender(line[3]), Double.parseDouble(line[4]),
                        Double.parseDouble(line[5]), Condition.parseCondition(line[6])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Animal jsonToAnimal(String input) throws JSONException {
        JSONObject json = new JSONObject(input);
        Animal animal = new Animal(json.getInt("id"), json.getString("type"),
                json.getString("name"), Gender.parseGender(json.getString("gender")),
                json.getDouble("length"), json.getDouble("weight"),
                Condition.parseCondition(json.getString("condition")));
        animalList.add(animal);
        return animal;
    }

    private static String animalToCsv(Animal animal) {
        String[] attrs = {animal.getId().toString(), animal.getType(),
                animal.getName(), animal.getGender().toString(), String.valueOf(animal.getLength()),
                String.valueOf(animal.getWeight()), animal.getCondition().toString()};
        return String.join(",", attrs);
    }

}
