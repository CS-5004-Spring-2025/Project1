package unixtools;

/**
 * Driver class for executing the unix commands wc and tail.
 */
public class UnixTools {

    public static void main(String[] args) {
        CommandArgs argParser = new CommandArgs(args);
        if (!argParser.isCommandValid()) {
            ConsoleView.usage();
            System.exit(1);
        }

        if (argParser.getUnixCommand().equals(Constants.WC)) {
            WC wc = new WC(argParser.getFilename());
            ConsoleView.showWordCount(wc.getWordCount());
        } else if (argParser.getUnixCommand().equals(Constants.TAIL)) {
            Tail tail = new Tail(argParser.getFilename());
            ConsoleView.showTailContent(tail.getContent());
        }

    }

}
