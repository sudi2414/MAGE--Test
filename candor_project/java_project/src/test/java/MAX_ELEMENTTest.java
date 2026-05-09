package humaneval.correct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MAX_ELEMENTTest {

    @Test
    public void testMaxElementWithPositiveNumbers() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        int result = MAX_ELEMENT.max_element(list);
        assertEquals(9, result);
    }

    @Test
    public void testMaxElementWithNegativeNumbers() {
        List<Integer> list = Arrays.asList(-5, -3, -1, -4, -2);
        int result = MAX_ELEMENT.max_element(list);
        assertEquals(-1, result);
    }

    @Test
    public void testMaxElementWithMixedNumbers() {
        List<Integer> list = Arrays.asList(-5, 3, -1, 7, -2);
        int result = MAX_ELEMENT.max_element(list);
        assertEquals(7, result);
    }

    @Test
    public void testMaxElementWithSingleElementList() {
        List<Integer> list = Arrays.asList(42);
        int result = MAX_ELEMENT.max_element(list);
        assertEquals(42, result);
    }

    @Test
    public void testMaxElementWithEmptyList() {
        List<Integer> list = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> MAX_ELEMENT.max_element(list));
    }

    @Test
    public void testMaxElementWithZero() {
        List<Integer> list = Arrays.asList(0, -1, 1);
        int result = MAX_ELEMENT.max_element(list);
        assertEquals(1, result);
    }
}