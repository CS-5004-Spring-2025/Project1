package unixtools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Executes the tail command by retrieving the last 10 lines of a file.
 */
public class Tail {

    private static final int TAIL_LINES = 10;
    private String filename;
    private String content;

    /**
     * Construct a Tail object that will be used to retrieve the last 10 lines
     * of the file specified by the filename parameter.
     *
     * @param filename file specified
     */
    public Tail(String filename) {
        this.filename = filename;
        this.content = "";

        try {
            buildContent();
        } catch (FileNotFoundException fnf) {
            ConsoleView.log(fnf.getMessage());
        }
    }

    /**
     * Called by the constructor to retrieve the last 10 lines of the file. When
     * complete, the data member content will contain the last 10 lines of the
     * file specified by the data member filename. If the file contains less
     * than 10 lines, the data member content will contain all content of the
     * file. 
     *
     * @throws FileNotFoundException thrown if the file does not exist.
     */
    private void buildContent() throws FileNotFoundException {
        // TODO: replace this code with your solution
    }

    /**
     * Getter for the content.
     *
     * @return a String containing the last 10 lines of the file
     */
    public String getContent() {
        return content;
    }

}
