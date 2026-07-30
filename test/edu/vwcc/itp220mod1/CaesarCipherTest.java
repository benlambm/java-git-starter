package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your Caesar cipher.
 */
class CaesarCipherTest {

    @Test
    void shiftsUppercaseLetters() {
        assertEquals("DEF", CaesarCipher.shift("ABC", 3));
    }

    @Test
    void wrapsPastZ() {
        assertEquals("ABC", CaesarCipher.shift("XYZ", 3));
    }

    @Test
    void supportsNegativeShifts() {
        assertEquals("ZAB", CaesarCipher.shift("ABC", -1));
    }

    @Test
    void preservesSpacesAndPunctuation() {
        assertEquals("MJQQT, BTWQI!", CaesarCipher.shift("HELLO, WORLD!", 31));
    }
}
