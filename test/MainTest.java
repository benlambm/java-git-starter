import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Main class.
 *
 * A test class does not have a main method. Instead, each method marked
 * with @Test is run automatically by JUnit, and an assertion that fails
 * reports that one test as failed without stopping the others.
 *
 * Run these three ways -- all three run this same file:
 *   Eclipse:  right-click the file, Run As, JUnit Test
 *   VS Code:  click the beaker icon in the left sidebar, or the arrow in the
 *             gutter next to a test method
 *   Terminal: see "Run the tests without an IDE" in README.md
 */
class MainTest {

    @Test
    @DisplayName("greet uses the name it is given")
    void greetUsesTheGivenName() {
        assertEquals("Hello, ITP 220!", Main.greet("ITP 220"));
    }

    @Test
    @DisplayName("greet falls back to \"world\" when the name is blank")
    void greetFallsBackToWorld() {
        assertEquals("Hello, world!", Main.greet("   "));
    }

    @Test
    @DisplayName("greet falls back to \"world\" when the name is null")
    void greetHandlesNull() {
        assertEquals("Hello, world!", Main.greet(null));
    }
}
