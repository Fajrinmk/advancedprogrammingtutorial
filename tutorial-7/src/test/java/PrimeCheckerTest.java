import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeCheckerTest {

    private static final List<Integer> PRIME_NUMBERS = Arrays.asList(2, 3, 5, 7);
    private static final List<Integer> NON_PRIME_NUMBERS = Arrays.asList(4, 8, 10, 12);

    @Test
    public void testIsPrimeTrueGivenPrimeNumbers() {
        PRIME_NUMBERS.forEach(number -> assertTrue(PrimeChecker.isPrime(number)));
    }

    @Test
    public void testIsPrimeFalseGivenNonPrimeNumbers() {
        NON_PRIME_NUMBERS.forEach(number -> assertFalse(PrimeChecker.isPrime(number)));
        // Given non-prime numbers
        // When isPrime is invoked
        // It should return false
    }
}