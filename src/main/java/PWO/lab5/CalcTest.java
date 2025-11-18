package PWO.lab5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalcTest {
    Calc calc;

    @BeforeEach
    void init() {
        calc = new Calc();
    }

    @Test
    @DisplayName("Multiplication of calculator")
    void testMultiply() {
        assertEquals(10, calc.multiply(2, 5), "Multiplication should work");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by zero")
    void testMultiplicationByZero() {
        assertEquals(0, calc.multiply(0, 10), "Multiplication by zero should be zero");
        assertEquals(0, calc.multiply(1, 0), "Multiplication by zero should be zero");
    }

    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by one")
    void testMultiplicationByOne() {
        assertEquals(10, calc.multiply(1, 10), "Multiplication ten by one should be ten");
        assertEquals(5, calc.multiply(1, 5), "Multiplication five by one should be five");
    }

    @Test
    @DisplayName("Addition of calculator")
    void testAdd() {
        assertEquals(7, calc.add(2, 5), "Addition should work");
    }

    @Test
    @DisplayName("Subtraction of calculator")
    void testSubtract() {
        assertEquals(3, calc.subtract(5, 2), "Subtraction should work");
    }

    @Test
    @DisplayName("Division of calculator should return a double")
    void testDivideDouble() {
        double result = calc.divide(10, 5);
        assertEquals(2.0, result, 0.001, "Division should work and return a double");
        assertEquals(0.5, calc.divide(1, 2), 0.001, "Division should return a double");
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0), "Division by zero should throw exception");
    }

    @Test
    @DisplayName("Sqrt < 0 -> throws IllegalArgumentException")
    void testSqrtLessZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.square(-1), "Sqrt must be positive");
    }

    @Test
    @DisplayName("Sqrt 0 returns 0")
    void testSqrtZero() {
        assertEquals(0.0, calc.square(0));
    }

    @RepeatedTest(99)
    @DisplayName("Sqrt 5 returns 2.14")
    void testSqrtStability() {
        assertEquals(2.236, calc.square(5), 0.001);
    }

    @Test
    @DisplayName("Sqrt of null throws")
    void testSqrtNull() {
        //assertEquals(calc.square(null));
    }
}
