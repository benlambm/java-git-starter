/**
 * Starting point for the project.
 *
 * Notice that the interesting work lives in greet(), not in main(). That is
 * deliberate: main() talks to the console, and console output is awkward to
 * test. A method that takes a value and returns a value can be tested
 * directly -- see test/MainTest.java.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(greet(""));
    }

    /**
     * Builds a greeting for the given name.
     *
     * @param name who to greet; blank or null falls back to "world"
     * @return the greeting, for example "Hello, Java!"
     */
    public static String greet(String name) {
        if (name == null || name.isBlank()) {
            name = "world";
        }
        return "Hello, " + name + "!";
    }
}
