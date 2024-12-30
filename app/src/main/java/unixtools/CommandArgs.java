package unixtools;

import java.io.File;

/**
 * A class to parse command line arguments.
 */
public class CommandArgs {

    /* The unix command to be executed. */
    private String unixCommand;

    /* The file on which to operate. */
    private String filename;

    /*
     * After the constructor is invoked, validUnixCommand will be true if the
     * command (wc or tail_ was valid and false otherwise.
     */
    private boolean validUnixCommand;

    /*
     * After the constructor is invoked, validFilename will be true if the
     * filename refers to a valid file that exists and false otherwise.
     */
    private boolean validFilename;

    /**
     * Constructs a new CommandArgs object.
     *
     * @param args the command line args
     */
    public CommandArgs(String[] args) {

        // Initialize data members to false/invalid values
        validUnixCommand = validFilename = false;
        unixCommand = filename = Constants.INVALID;

        /*
         * Exit constructor if number of args is
         * not correct.
         */
        if (!checkNumberArgs(args)) {
            return;
        }

        parseUnixCommand(args[0]);
        if (validUnixCommand) {
            // If the unix command is invalid then the filename will not be
            // parsed as the command will not be valid.
            parseFilename(args[1]);
        }
    }

    /**
     * Verify that two command line args are passed.
     *
     * @param args the array passed to main
     * @return true if there were two arguments and false otherwise
     */

    private boolean checkNumberArgs(String[] args) {
        // TODO: replace this code with your solution
        return false;
    }

    /**
     * Verify that the commandArg is one of the accepted
     * commands -- wc or tail.
     * If the commandArg is not a valid command, validUnixCommand will be set to
     * false.
     * If the the commandArg is valid, the unixCommand data member will be
     * set to the appropriate argument and validUnixCommand will be set to true.
     *
     * @param commandArg argument
     */
    private void parseUnixCommand(String commandArg) {
        // TODO: replace this code with your solution
    }

    /**
     * Verify that filenameArg refers to a file that exists.
     * See the {@link File#exists() exists} method of File.
     * If the filenameArg does not refer to a valid file, validFilename
     * will be set to false.
     * If the filenameArg does refer to a valid file, filename will be set to
     * the filenameArg and validFilename will be set to true.
     *
     * @param filenameArg argument
     */
    private void parseFilename(String filenameArg) {
        File file = new File(filenameArg);
        if (!file.exists()) {
            validFilename = false;
        } else {
            validFilename = true;
            filename = filenameArg;
        }
    }

    /**
     * Returns true if this was a valid command. A valid command must have a
     * valid unix command and specify a filename of a file that exists.
     *
     * @return true if the command is valid
     */
    public boolean isCommandValid() {
        // TODO: replace this code with your solution
        return false;
    }

    /**
     * Return true if the command was valid.
     *
     * @return whether the command args are valid
     */
    public boolean isValidUnixCommand() {
        return validUnixCommand;
    }

    /**
     * Return the command (wc or tail) or "Invalid" if the command was not
     * valid.
     *
     * @return command
     */
    public String getUnixCommand() {
        return unixCommand;
    }

    /**
     * Return the filename or "Invalid" if the filename or command was invalid.
     *
     * @return filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * If the command is valid and the filename exists, return a String of
     * the format
     * Command: COMMAND; Filename: FILENAME
     * Return the String "Invalid" otherwise.
     */
    public String toString() {
        // TODO: replace this code with your solution
        return null;
    }
}
