package unixtools;

/**
 * A collection of methods used to display output to the console.
 */
public class ConsoleView {

    /*
     * Private constructor used to restrict instantiation of the class.
     * https://www.baeldung.com/java-private-constructors
     */
    private ConsoleView() {
        // no-op
    }

    /**
     * Display a usage message to indicate how the program is to be executed
     * from the command line.
     */
    public static void usage() {
        System.out.println("usage: java UnixTools <command> <filename>");
    }

    /**
     * Used to display a log message to the console window.
     * @param message text to be displayed
     */
    public static void log(String message) {
        System.out.println(message);
    }

    /**
     * Used to display a message of the format
     * word count: NUMBER WORDS IN TEXT
     * @param wordCount number of words in the text
     */
    public static void showWordCount(int wordCount) {
        System.out.println("word count: " + wordCount);
    }

    /**
     * Used to display the tail of a file.
     * @param content last 10 lines of a file
     */
    public static void showTailContent(String content) {
        System.out.println(content);
    }

}

