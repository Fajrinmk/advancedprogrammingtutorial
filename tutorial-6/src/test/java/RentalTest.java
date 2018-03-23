import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
    private Movie childrenMovie;
    private Movie newReleaseMovie;
    private Movie movie;
    private Rental rent;
    private Rental rentChildrenMovie;
    private Rental rentNewReleaseMovie;

    @Before
    public void setUp() {
        movie = new Movie("Who Killed Captain Alex?", Movie.REGULAR);
        rent = new Rental(movie, 3);

        childrenMovie = new Movie("Thomas and Friends", Movie.CHILDREN);
        rentChildrenMovie = new Rental(childrenMovie,4);

        newReleaseMovie = new Movie("Tomb Rider", Movie.NEW_RELEASE);
        rentNewReleaseMovie = new Rental(newReleaseMovie,3);
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rent.getMovie());
    }

    @Test
    public void getDaysRented() {
        assertEquals(3, rent.getDaysRented());
    }

    @Test
    public void chargeTest() {
        assertEquals("3.5", String.valueOf(rent.lineAmount()));
        assertEquals("3.0", String.valueOf(rentChildrenMovie.lineAmount()));
        assertEquals("9.0", String.valueOf(rentNewReleaseMovie.lineAmount()));
    }

    @Test
    public void frequentRenterPointTest() {
        assertTrue(rent.addRenterPoints() == 1);

        movie.setPriceCode(Movie.NEW_RELEASE);

        assertTrue(rent.addRenterPoints() == 2);
    }


}
