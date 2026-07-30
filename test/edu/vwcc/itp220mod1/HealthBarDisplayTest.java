package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your health bar display.
 */
class HealthBarDisplayTest {

    @Test
    void displaysPartOfTheHealthBar() {
        assertEquals("[######----] 60%", HealthBarDisplay.display(60, 100));
    }

    @Test
    void usesIntegerDivisionForFilledPositions() {
        assertEquals("[----------] 9%", HealthBarDisplay.display(9, 100));
    }

    @Test
    void displaysEmptyAndFullHealthBars() {
        assertEquals("[----------] 0%", HealthBarDisplay.display(0, 100));
        assertEquals("[##########] 100%", HealthBarDisplay.display(100, 100));
    }

    @Test
    void keepsHealthWithinTheAvailableRange() {
        assertEquals("[----------] 0%", HealthBarDisplay.display(-10, 100));
        assertEquals("[##########] 100%", HealthBarDisplay.display(120, 100));
    }

    @Test
    void handlesAZeroMaximum() {
        assertEquals("[----------] 0%", HealthBarDisplay.display(10, 0));
    }
}
