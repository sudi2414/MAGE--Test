package humaneval.correct;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ADD_ELEMENTSTest {

    @Test
    public void testAddElementsWithEmptyList() {
        ArrayList<Integer> arr = new ArrayList<>();
        int k = 5;
        assertEquals(0, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithSingleElement() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        int k = 1;
        assertEquals(1, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithLargeNumbers() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);
        arr.add(200);
        arr.add(300);
        arr.add(400);
        arr.add(500);
        int k = 3;
        assertEquals(600, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithKEqualToListSize() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int k = 3;
        assertEquals(6, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithKLessThanListSize() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int k = 2;
        assertEquals(3, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithKGreaterThanListSize() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int k = 5;
        assertEquals(6, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithEmptyStringRepresentation() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(3); // String length is exactly 1
        int k = 3;
        assertEquals(6, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithLargeStringRepresentation() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1000);
        arr.add(2000);
        arr.add(3); // String length exceeds 2
        int k = 3;
        assertEquals(0, ADD_ELEMENTS.add_elements(arr, k));
    }

    @Test
    public void testAddElementsWithNonIntegerElements() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3); // Non-integer element
        int k = 3;
        assertEquals(6, ADD_ELEMENTS.add_elements(arr, k));
    }
}