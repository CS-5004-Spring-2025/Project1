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
class TailTest {

    private static final String EXISTING_FILE = "existingFile.txt";
    private static final String NON_EXISTING_FILE = "nonExistingFile.txt";

    @BeforeEach
    void setUp() {
        // Create a file with multiple lines for testing
        try (FileWriter writer = new FileWriter(EXISTING_FILE)) {
            for (int i = 1; i <= 20; i++) {
                writer.write("Line " + i + "\n");
            }
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
    void testTailOnExistingFile() {
        Tail tail = new Tail(EXISTING_FILE);
        String expectedContent = "";
        for (int i = 11; i <= 20; i++) {
            expectedContent += "Line " + i + Constants.EOL;
        }

        assertEquals(expectedContent, tail.getContent(), "Tail content should match the last 10 lines of the file");
    }

    @Test
    void testTailOnNonExistingFile() {
        // TODO: replace this code with your solution
    }

    @Test
    void testTailOnSmallFile() {
        String smallFile = "smallFile.txt";
        try (FileWriter writer = new FileWriter(smallFile)) {
            writer.write("Line 1\n");
            writer.write("Line 2\n");
            writer.write("Line 3\n");
        } catch (IOException e) {
            fail("Failed to create small file for test: " + e.getMessage());
        }

        Tail tail = new Tail(smallFile);
        String expectedContent = "Line 1" + Constants.EOL + "Line 2" + Constants.EOL + "Line 3" + Constants.EOL;

        assertEquals(expectedContent,
                    tail.getContent(),
                    "Tail content should match all lines for a file with fewer than 10 lines");

        // Clean up
        assertTrue(new File(smallFile).delete(), "Failed to delete small file after test");
    }

    @Test
    void testTailOnEmptyFile() {
        String emptyFile = "emptyFile.txt";
        try (FileWriter writer = new FileWriter(emptyFile)) {
            // Create an empty file
        } catch (IOException e) {
            fail("Failed to create empty file for test: " + e.getMessage());
        }

        Tail tail = new Tail(emptyFile);
        assertEquals("", tail.getContent(), "Tail content should be empty for an empty file");

        // Clean up
        assertTrue(new File(emptyFile).delete(), "Failed to delete empty file after test");
    }

    @AfterAll
    static void tearDown() {
        File toDelete = new File(EXISTING_FILE);
        toDelete.delete();
    }

}
