package humaneval.correct;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IS_PRIMETest {

    @Test
    public void testIsPrimeWithNegativeNumber() {
        assertFalse(IS_PRIME.is_prime(-5));
    }

    @Test
    public void testIsPrimeWithZero() {
        assertFalse(IS_PRIME.is_prime(0));
    }

    @Test
    public void testIsPrimeWithOne() {
        assertFalse(IS_PRIME.is_prime(1));
    }

    @Test
    public void testIsPrimeWithTwo() {
        assertTrue(IS_PRIME.is_prime(2));
    }

    @Test
    public void testIsPrimeWithThree() {
        assertTrue(IS_PRIME.is_prime(3));
    }

    @Test
    public void testIsPrimeWithFour() {
        assertFalse(IS_PRIME.is_prime(4));
    }

    @Test
    public void testIsPrimeWithFive() {
        assertTrue(IS_PRIME.is_prime(5));
    }

    @Test
    public void testIsPrimeWithSix() {
        assertFalse(IS_PRIME.is_prime(6));
    }

    @Test
    public void testIsPrimeWithSeven() {
        assertTrue(IS_PRIME.is_prime(7));
    }

    @Test
    public void testIsPrimeWithEight() {
        assertFalse(IS_PRIME.is_prime(8));
    }

    @Test
    public void testIsPrimeWithNine() {
        assertFalse(IS_PRIME.is_prime(9));
    }

    @Test
    public void testIsPrimeWithTen() {
        assertFalse(IS_PRIME.is_prime(10));
    }

    @Test
    public void testIsPrimeWithLargeNumber() {
        assertTrue(IS_PRIME.is_prime(97));
    }

    // Additional Tests for Missing Branch Coverage

    @Test
    public void testIsPrimeWithSmallPrimeNumber() {
        assertTrue(IS_PRIME.is_prime(31)); // Prime number less than 50
    }

    @Test
    public void testIsPrimeWithLargePrimeNumber() {
        assertTrue(IS_PRIME.is_prime(97)); // Large prime number
    }

    @Test
    public void testIsPrimeWithSmallNonPrimeNumber() {
        assertFalse(IS_PRIME.is_prime(49)); // Non-prime number less than 50
    }
}