package edu.vwcc.itp220mod1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Instructions: Use these tests to check your password rules.
 */
class PasswordRuleCheckerTest {

    @Test
    void acceptsAValidPassword() {
        assertTrue(PasswordRuleChecker.isValid("Java220!"));
    }

    // The "rejects" tests below each end with a password that IS valid. Without
    // that, a method that always returns false would pass them all.

    @Test
    void rejectsEmptyAndNullPasswords() {
        assertFalse(PasswordRuleChecker.isValid(""));
        assertFalse(PasswordRuleChecker.isValid(null));
        assertTrue(PasswordRuleChecker.isValid("Passw0rd!"));
    }

    @Test
    void rejectsPasswordsWithMissingRequirements() {
        assertFalse(PasswordRuleChecker.isValid("Java2!"));
        assertFalse(PasswordRuleChecker.isValid("java220!"));
        assertFalse(PasswordRuleChecker.isValid("JAVA220!"));
        assertFalse(PasswordRuleChecker.isValid("JavaTest!"));
        assertFalse(PasswordRuleChecker.isValid("Java2200"));
        assertTrue(PasswordRuleChecker.isValid("Str0ng#Pass"));
    }

    @Test
    void rejectsCharactersOutsideTheAllowedSet() {
        assertFalse(PasswordRuleChecker.isValid("Java220!?"));
        assertTrue(PasswordRuleChecker.isValid("Safe*Pass1"));
    }
}
