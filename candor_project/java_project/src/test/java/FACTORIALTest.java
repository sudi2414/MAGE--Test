package humaneval.correct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class FACTORIALTest {

    @Test
    public void testFactorialWithZero() {
        ArrayList<Integer> result = FACTORIAL.factorial(0);
        assertEquals(new ArrayList<>(), result, "Expected an empty list for n=0");
    }

    @Test
    public void testFactorialWithOne() {
        ArrayList<Integer> result = FACTORIAL.factorial(1);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1)), result, "Expected [1] for n=1");
    }

    @Test
    public void testFactorialWithTwo() {
        ArrayList<Integer> result = FACTORIAL.factorial(2);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1, 2)), result, "Expected [1, 2] for n=2");
    }

    @Test
    public void testFactorialWithThree() {
        ArrayList<Integer> result = FACTORIAL.factorial(3);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1, 2, 6)), result, "Expected [1, 2, 6] for n=3");
    }

    @Test
    public void testFactorialWithFour() {
        ArrayList<Integer> result = FACTORIAL.factorial(4);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1, 2, 6, 24)), result, "Expected [1, 2, 6, 24] for n=4");
    }

    @Test
    public void testFactorialWithFive() {
        ArrayList<Integer> result = FACTORIAL.factorial(5);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1, 2, 6, 24, 120)), result, "Expected [1, 2, 6, 24, 120] for n=5");
    }

    @Test
    public void testFactorialWithTen() {
        ArrayList<Integer> result = FACTORIAL.factorial(10);
        assertEquals(new ArrayList<>(java.util.Arrays.asList(1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800)), result, "Expected [1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800] for n=10");
    }

    @Test
    public void testFactorialWithNegativeOne() {
        ArrayList<Integer> result = FACTORIAL.factorial(-1);
        assertEquals(new ArrayList<>(), result, "Expected an empty list for negative input");
    }

    @Test
    public void testFactorialWithNegativeFive() {
        ArrayList<Integer> result = FACTORIAL.factorial(-5);
        assertEquals(new ArrayList<>(), result, "Expected an empty list for negative input");
    }

    // Uncomment and run if necessary
    // @Test
    // public void testFactorialWithIntegerMaxValue() {
    //     ArrayList<Integer> result = FACTORIAL.factorial(Integer.MAX_VALUE);
    //     assertEquals(new ArrayList<>(...), result, "Expected ... for Integer.MAX_VALUE");
    // }

    // Uncomment and run if necessary
    // @Test
    // public void testFactorialWithIntegerMinValue() {
    //     ArrayList<Integer> result = FACTORIAL.factorial(Integer.MIN_VALUE);
    //     assertEquals(new ArrayList<>(...), result, "Expected ... for Integer.MIN_VALUE");
    // }
}