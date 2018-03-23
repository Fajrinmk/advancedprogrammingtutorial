import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> iterator = rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";

        while (iterator.hasNext()) {
            Rental each = iterator.next();

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.lineAmount()) + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(lineAmount()) + "\n";
        result += "You earned " + String.valueOf(addRenterPoints())
                + " frequent renter points";

        return result;
    }


    private double lineAmount() {
        double result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += each.lineAmount();
        }
        return result;
    }

    private int addRenterPoints() {
        int result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += each.addRenterPoints();
        }
        return result;
    }
    
    public String htmlStatement() {

        Iterator<Rental> iterator = rentals.iterator();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        while (iterator.hasNext()) {
            Rental each = iterator.next();

            //show figures for each rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                + String.valueOf(each.lineAmount()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(lineAmount()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(addRenterPoints())
            + "</EM> frequent renter points<P>";
        return result;

    }


}