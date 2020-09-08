import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    // TODO: Remove redundancy in setting up test fixture in each test methods
    // Hint: Make the test fixture into an instance variable
    private Customer customer;
    private Movie movie;
    private Rental rent;
    private Rental rentAgain;

    @Before
    public void setUp() {
        customer = new Customer("Alice");
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rent = new Rental(movie, 3);
        rentAgain = new Rental(movie, 2);
    }

    @Test
    public void getName() {
        assertEquals("Alice", customer.getName());
    }

    @Test
    public void statementWithSingleMovie() {

        customer.addRental(rent);

        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("1 frequent renter points"));
    }

    @Test
    public void statementWithMultipleMovies() {
        customer.addRental(rent);
        customer.addRental(rentAgain);

        String result = customer.statement();
        String[] lines = result.split("\n");

        assertEquals(5, lines.length);
        assertTrue(result.contains("2 frequent renter points"));

    }

    @Test
    public void htmlStatementTest() {
        customer.addRental(rent);

        String result = customer.htmlStatement();
        String[] lines = result.split("\n");

        assertEquals(4, lines.length);
        assertTrue(result.contains("On this rental you earned"));
    }


}
