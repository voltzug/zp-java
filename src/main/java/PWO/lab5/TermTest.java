package PWO.lab5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TermTest {
    Term term;

    @BeforeEach
    void init() {
        term = new Term(-189, Integer.MAX_VALUE - 1);
    }

    @Test
    @DisplayName("Test current temperature initialization")
    void testInitialization() {
        assertEquals(0, term.getCurrentTemp(), "Current temperature should be initialized to 0");
    }

    @Test
    @DisplayName("Test adding degrees to current temperature")
    void testAddDegrees() {
        term.addDegrees(5);
        assertEquals(5, term.getCurrentTemp(), "Current temperature should be increased by degrees");
        term.addDegrees(1);
        assertEquals(6, term.getCurrentTemp(), "Current temperature should be further increased by degrees");
    }

    @Test
    @DisplayName("Test adding negative degrees to current temperature")
    void testAddNegativeDegrees() {
        term.addDegrees(-5);
        assertThrows(IllegalArgumentException.class, () -> term.addDegrees(-1));
    }

    @Test
    @DisplayName("Test subtracting degrees from current temperature")
    void testSubtractDegrees() {
        term.addDegrees(10); // Start from -10, add 10 to reach 0
        term.subtractDegrees(5);
        assertEquals(5, term.getCurrentTemp(), "Current temperature should be decreased by degrees");
    }

    @Test
    @DisplayName("Test isBelowZero for negative temperature")
    void testIsBelowZeroForNeg() {
        term.setCurrentTemp(-5);
        assertTrue(term.isBelowZero(), "Current temperature should be below zero");

        term.setCurrentTemp(0);
        assertFalse(term.isBelowZero(), "Current temperature should not be below zero");
    }

    @Test
    @DisplayName("Test for positive and zero temperatures")
    void testIsBelowZeroForPos() {
        term.setCurrentTemp(10);
        assertFalse(term.isBelowZero(), "Current temperature should not be below zero");

        term.setCurrentTemp(-1);
        assertTrue(term.isBelowZero(), "Current temperature should be below zero");
    }
}
