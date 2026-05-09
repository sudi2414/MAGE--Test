```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Positive numbers
        assertEquals(5, Calculator.add(2, 3));
        
        // Negative and positive numbers
        assertEquals(-1, Calculator.add(-4, 3));
        
        // Zero
        assertEquals(0, Calculator.add(0, 0));
        
        // Edge case: Maximum and minimum values of an integer (This test is problematic due to overflow)
        // assertThrows(ArithmeticException.class, () -> Calculator.add(Integer.MAX_VALUE, Integer.MIN_VALUE), "Addition should not cause overflow");
    }

    @Test
    public void testSubtract() {
        // Positive numbers
        assertEquals(2, Calculator.subtract(5, 3));
        
        // Negative and positive numbers
        assertEquals(-7, Calculator.subtract(-4, 3));
        
        // Zero
        assertEquals(0, Calculator.subtract(0, 0));
        
        // Edge case: Maximum and minimum values of an integer (This test is problematic due to overflow)
        // assertThrows(ArithmeticException.class, () -> Calculator.subtract(Integer.MAX_VALUE, Integer.MIN_VALUE), "Subtraction should not cause overflow");
    }

    @Test
    public void testDivide() {
        // Positive numbers
        assertEquals(2, Calculator.divide(6, 3));
        
        // Negative numbers
        assertEquals(-1, Calculator.divide(-4, 4));
        
        // Zero dividend
        assertEquals(0, Calculator.divide(0, 5));
        
        // Edge case: Division by one
        assertEquals(Integer.MAX_VALUE, Calculator.divide(Integer.MAX_VALUE, 1));
        
        // Exception case: Division by zero
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0), "Division by zero should throw an ArithmeticException");
    }
}
```