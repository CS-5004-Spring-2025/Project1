package unixtools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Executes the wc command by counting the lines of a file.
 */
public class WC {

    private String filename;
    private int wordCount;

    /**
     * Construct a wc object that will be used to count the number of lines in
     * the file.
     *
     * @param filename location of the file
     */
    public WC(String filename) {
        this.filename = filename;
        try {
            this.wordCount = countWords();
        } catch (FileNotFoundException fnf) {
            ConsoleView.log(fnf.getMessage());
        }
    }

    /**
     * Count the number of words in the file.
     *
     * @return number of words found
     * @throws FileNotFoundException if the file does not exist
     */
    private int countWords() throws FileNotFoundException {
        // TODO: replace this code with your solution
        return 0;
    }

    /**
     * Getter for word count.
     *
     * @return number of words in the file
     */
    public int getWordCount() {
        return wordCount;
    }

}
