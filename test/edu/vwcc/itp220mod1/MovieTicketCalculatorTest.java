package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your movie ticket calculator.
 */
class MovieTicketCalculatorTest {

    @Test
    void usesTheAgeBoundaries() {
        assertEquals(8.0, MovieTicketCalculator.calculatePrice(12, 18, false));
        assertEquals(12.0, MovieTicketCalculator.calculatePrice(13, 18, false));
        assertEquals(12.0, MovieTicketCalculator.calculatePrice(64, 18, false));
        assertEquals(9.0, MovieTicketCalculator.calculatePrice(65, 18, false));
    }

    @Test
    void appliesTheMatineeDiscount() {
        assertEquals(10.0, MovieTicketCalculator.calculatePrice(30, 16, false));
    }

    @Test
    void appliesTheWeekendCharge() {
        assertEquals(15.0, MovieTicketCalculator.calculatePrice(30, 18, true));
    }

    @Test
    void appliesBothPriceChanges() {
        assertEquals(9.0, MovieTicketCalculator.calculatePrice(12, 16, true));
    }
}
