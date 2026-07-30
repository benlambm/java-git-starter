package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your rectangle hit detection.
 */
class HitDetectionTest {

    @Test
    void detectsAPointInsideTheRectangle() {
        assertTrue(HitDetection.isInside(5, 5, 0, 0, 10, 10));
    }

    @Test
    void includesTheTopAndLeftEdges() {
        assertTrue(HitDetection.isInside(0, 0, 0, 0, 10, 10));
    }

    @Test
    void includesTheBottomAndRightEdges() {
        assertTrue(HitDetection.isInside(10, 10, 0, 0, 10, 10));
    }

    @Test
    void rejectsAPointOutsideTheRectangle() {
        assertFalse(HitDetection.isInside(10.1, 5, 0, 0, 10, 10));
        // Paired with a nearby hit, so a method that always returns false
        // cannot pass this test.
        assertTrue(HitDetection.isInside(9.9, 5, 0, 0, 10, 10));
    }
}
