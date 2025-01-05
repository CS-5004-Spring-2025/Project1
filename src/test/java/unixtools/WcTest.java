package unixtools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests generated with the help of Chat GPT.
 */

class WcTest {

    private static final String EXISTING_FILE = "existingFile.txt";
    private static final String NON_EXISTING_FILE = "nonExistingFile.txt";

    @BeforeEach
    void setUp() {
        // Create a file with some content for testing
        try (FileWriter writer = new FileWriter(EXISTING_FILE)) {
            writer.write("Hello World\n");
            writer.write("This is a test file.\n");
            writer.write("It contains multiple lines and words.\n");
        } catch (IOException e) {
            fail("Failed to set up test file: " + e.getMessage());
        }

        // Ensure non-existing file is deleted if present
        File nonExistingFile = new File(NON_EXISTING_FILE);
        if (nonExistingFile.exists()) {
            assertTrue(nonExistingFile.delete(), "Failed to delete non-existing file stub");
        }
    }

    @Test
    void testWordCountInExistingFile() {
        WC wc = new WC(EXISTING_FILE);
        assertEquals(13, wc.getWordCount(), "Word count should match the number of words in the file");
    }

    @Test
    void testWordCountInNonExistingFile() {
        // TODO: replace this code with your solution
    }

    @Test
    void testWordCountForEmptyFile() {
        String emptyFile = "emptyFile.txt";
        try (FileWriter writer = new FileWriter(emptyFile)) {
            // Create an empty file
        } catch (IOException e) {
            fail("Failed to create empty file for test: " + e.getMessage());
        }

        WC wc = new WC(emptyFile);
        assertEquals(0, wc.getWordCount(), "Word count should be zero for an empty file");

        // Clean up
        assertTrue(new File(emptyFile).delete(), "Failed to delete empty file after test");
    }

    @Test
    void testWordCountForFileWithSpecialCharacters() {
        String specialCharFile = "specialCharFile.txt";
        try (FileWriter writer = new FileWriter(specialCharFile)) {
            writer.write("@#$%^&*()\n");
            writer.write("12345 67890\n");
            writer.write("Word1\tWord2\n");
        } catch (IOException e) {
            fail("Failed to create special character file for test: " + e.getMessage());
        }

        WC wc = new WC(specialCharFile);
        assertEquals(5, wc.getWordCount(), "Word count should include valid words split by spaces or tabs");

        // Clean up
        assertTrue(new File(specialCharFile).delete(), "Failed to delete special character file after test");
    }

    @AfterAll
    static void tearDown() {
        File toDelete = new File(EXISTING_FILE);
        toDelete.delete();
    }
}
