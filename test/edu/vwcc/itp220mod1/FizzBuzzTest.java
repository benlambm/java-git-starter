package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your FizzBuzz method.
 */
class FizzBuzzTest {

    @Test
    void returnsTheNumberForOtherValues() {
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }

    @Test
    void returnsFizzForMultiplesOfThree() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void returnsBuzzForMultiplesOfFive() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void returnsFizzBuzzForMultiplesOfThreeAndFive() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }
}
