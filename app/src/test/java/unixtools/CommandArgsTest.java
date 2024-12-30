package unixtools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests generated with the help of Chat GPT.
 */
public class CommandArgsTest {

    private static final String VALID_WC_COMMAND = "wc";
    private static final String VALID_TAIL_COMMAND = "tail";
    private static final String INVALID_COMMAND = "invalid";
    private static final String EXISTING_FILE = "existingFile.txt";
    private static final String NON_EXISTING_FILE = "nonExistingFile.txt";

    @BeforeEach
    void setUp() {
        // Create a dummy file to simulate an existing file
        File file = new File(EXISTING_FILE);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            fail("Failed to set up existing file for tests: " + e.getMessage());
        }
    }

    @Test
    void testValidCommandAndValidFile() {
        String[] args = { VALID_WC_COMMAND, EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertTrue(commandArgs.isCommandValid());
        assertEquals(VALID_WC_COMMAND, commandArgs.getUnixCommand());
        assertEquals(EXISTING_FILE, commandArgs.getFilename());
    }

    @Test
    void testValidCommandAndInvalidFile() {
        String[] args = { VALID_TAIL_COMMAND, NON_EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertFalse(commandArgs.isCommandValid());
        assertTrue(commandArgs.isValidUnixCommand());
        assertEquals(VALID_TAIL_COMMAND, commandArgs.getUnixCommand());
        assertEquals(Constants.INVALID, commandArgs.getFilename());
    }

    @Test
    void testInvalidCommandAndValidFile() {
        String[] args = { INVALID_COMMAND, EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertFalse(commandArgs.isCommandValid());
        assertFalse(commandArgs.isValidUnixCommand());
        assertEquals(Constants.INVALID, commandArgs.getUnixCommand());
        assertEquals(Constants.INVALID, commandArgs.getFilename());
    }

    @Test
    void testInvalidCommandAndInvalidFile() {
        String[] args = { INVALID_COMMAND, NON_EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertFalse(commandArgs.isCommandValid());
        assertFalse(commandArgs.isValidUnixCommand());
        assertEquals(Constants.INVALID, commandArgs.getUnixCommand());
        assertEquals(Constants.INVALID, commandArgs.getFilename());
    }

    @Test
    void testInsufficientArguments() {
        // TODO: replace this code with your solution
    }

    @Test
    void testNoArguments() {
        // TODO: replace this code with your solution
    }

    @Test
    void testToStringWithValidCommandAndFile() {
        String[] args = { VALID_TAIL_COMMAND, EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertEquals(String.format("Command: %s; Filename: %s", VALID_TAIL_COMMAND, EXISTING_FILE),
                commandArgs.toString());
    }

    @Test
    void testToStringWithInvalidCommand() {
        String[] args = { INVALID_COMMAND, EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertEquals("Invalid", commandArgs.toString());
    }

    @Test
    void testToStringWithInvalidFile() {
        String[] args = { VALID_WC_COMMAND, NON_EXISTING_FILE };
        CommandArgs commandArgs = new CommandArgs(args);

        assertEquals("Invalid", commandArgs.toString());
    }

    @AfterAll
    static void tearDown() {
        File toDelete = new File(EXISTING_FILE);
        toDelete.delete();
    }

}
