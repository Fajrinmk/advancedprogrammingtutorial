package tutorial.javari;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
import tutorial.javari.animal.Animal;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static tutorial.javari.JavariDatabase.animalList;
import static tutorial.javari.JavariDatabase.deleteFromCsv;
import static tutorial.javari.JavariDatabase.readCsv;

@RestController

public class JavariController {
    // TODO Implement me!
	private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/javari", method = GET)
    public String listAnimal() throws JsonProcessingException {
        readCsv();

        if (animalList.size() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            return (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(animalList));
        } else {
            return "There is no animal in da zoo";
        }
    }

    @RequestMapping(value = "/javari/{id}", method = GET)
    public String findAnimal(@PathVariable Integer id) throws JsonProcessingException {
        readCsv();

        Optional<Animal> findAnimal = animalList.stream().filter(s -> s.getId().equals(id)).findFirst();
        if (!findAnimal.isPresent()) {
            return "No animal with dat id " + id ;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(findAnimal.get()));
        }
    }

    @DeleteMapping(value = "javari/{id}")
    public String removeAnimal(@PathVariable Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Animal target = deleteFromCsv(id);
        if (target != null)
            return (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(target));
        else return "No matched animal with id " + id + " to be deleted";
    }

    @PostMapping(value = "javari/{JSON}")
    public String addAnimal(@PathVariable String JSON) throws JSONException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Animal animal = JavariDatabase.addAnimalToDatabase(JSON);
        return (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(animal));
    }
}
