# Project 1 - UnixTools
### Due - Thursday, January 23, 4:50pm

Assignment Link:
[https://classroom.github.com/a/uGQSdtWr](https://classroom.github.com/a/uGQSdtWr)

In this assignment, you will implement a program that provides the functionality
of the unix tools [wc](https://en.wikipedia.org/wiki/Wc_(Unix)) and [tail](https://en.wikipedia.org/wiki/Tail_(Unix)). 

<hr/>

The starter code provides you with the design that you must implement. You are
welcome to add additional methods and/or classes; however, the provided classes
and methods must be implemented as specified in order to earn full credit.

Before you begin, it is highly recommended that you take some time to
familiarize yourself with the starter code and understand the design.

### Execution

The program will expect two command line parameters to be passed when the
program is run. The first is the unix command, either `wc` or `tail` and the
second is a filename. In VS Code, there are a couple of ways to execute a
program that requires command line arguments. It is recommended that you execute
the program from the Terminal as follows:

```
java -cp build/classes/java/main unixtools.UnixTools <command> <filename>
```

`-cp app/build/classes/java/main` sets the
[classpath](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html).
The classpath tells the JDK tools where to find the classes that have been
generated from your java files. 

`unixtools.UnixTools` is the name of the class where the main method is
implemented. The class itself is called `UnixTools` and it is a
[package](https://www.w3schools.com/java/java_packages.asp) called `unixtools`.
It is required that you specify the package name DOT classname when executing
the program.

`<command>` must be replaced by the unix command to be executed. Your program
must accept `wc` and `tail` as valid values here.

`filename` is the name of a file. This may be a relative path, such as
`texts/haiku.txt`. There is a `texts` directory that contains two sample files.
`haiku.txt` contains 11 words and `frankenstein.txt` contains 75766 words.

## Classes in `unixtools` package

### `UnixTools`

The `UnixTools` class is the *driver* that includes the `main` method. It parses
the command line arguments, creates the appropriate class to execute the
command, and uses the `ConsoleView` to display the output and results.

You will not need to modify anything in the UnixTools class; however, you may
wish to create a different class where you implement a `main` method you use for
your own manual testing as you develop your solution.

### `ConsoleView`

This is the only place in the program that uses `System.out` to display output
to the console. If you add any functionality to print to the terminal, it is
advised that you put that functionality in `ConsoleView`.

### `Constants`

This class is a set of constants that may be used in other parts of the program.

### `CommandArgs`

The `CommandArgs` class is instantiated with the array of arguments that were
passed as input at the command line. It will verify that (1) there were two
arguments passed; (2) the first argument is either `wc` or `tail`; and (3) the
filename refers to a file that exists.

You are required to implement the following methods. See the starter code for
complete documentation that describes the behavior of the methods.

- `checkNumberArgs`: this method verifies that args array includes two values. 
- `parseUnixCommand`: verifies that the first argument is a valid unix command
  supported by this program. It will set the `validUnixCommand` data member and
  the `unixCommand` data member appropriately based on the `commandArg` parameter.
- `isCommandValid`: returns true if the unix command was valid and the file exists.
- `toString`: returns a string representation of the object.

### `WC`

The `WC` class carries out the `wc` command. The constructor takes the
filename as a parameter and, after the constructor completes, the `wordCount` data
member will contain the number of words in the file.

You are required to implement the following methods. See the starter code for
complete documentation that describes the behavior of the methods.

- `countWords`: this is a private helper method called by the constructor. It
  will count the number of words in the file.

### `Tail`

The `Tail` class carries out the `tail` command. The constructor takes the
filename as a parameter and, after the constructor completes, the `content` data
member will contain the last 10 lines of the file or, if the file is less than
10 lines, all lines of the file.

You are required to implement the following methods. See the starter code for
complete documentation that describes the behavior of the methods.

- `buildContent`: this is a private helper method called by the constructor. It
  will populate the `content` data member. *Hint:* in my solution, I use another
  helper method that counts the total number of lines in the file. You are
  expected to spend some time thinking about how to design an algorithm to get
  the last 10 lines of the file using the mechanisms we have discussed in class.
  Students who use `RandomAccessFile` or a queue or circular buffer will be
  asked to come in for code review before earning a grade as those are the
  solutions suggested by Chat GPT.

## Test classes

Your solution must pass all of the test cases provided in `TailTest`, `WcTest`,
and `CommandArgsTest`. In addition, you are required to implement four
additional JUnit test methods as follows:

`TailTest#testTailOnNonExistingFile`: verify that the `Tail` solution works correctly when the constructor is pass a
non-existent filename as a parameter.

`WcTest#testWordCountInNonExistingFile`: verify that the `WC` solution works correctly when the constructor is pass a
non-existent filename as a parameter.

`CommandArgsTest#testInsufficientArguments`: verify that the `CommandArgs`
solution words correctly if there are insufficient arguments in the `args`
parameter passed to the constructor.

`CommandArgsTest#testNoArguments`: verify that the `CommandArgs`
solution words correctly if there are no arguments in the `args`
parameter passed to the constructor.

## Reflection

You are required to complete a thoughtful and thorough reflection on your
solution, your experience implementing it, and what you learned. You will
complete the questions outlined in [REFLECTION.md](REFLECTION.md).

## Grading Rubric

The assignment is worth 25 points in total. For criteria worth two points,
partial credit may be awarded. For criteria worth one point, the solution must
be completely correct to earn credit.

| Criterion | Points | 
| --------- | ------ |
| Passes test cases provided | 1 | 
| Passes style check | 1 | 
| `CommandArgs#checkNumberArgs` | 2 |
| `CommandArgs#parseUnixCommand` | 2 |
| `CommandArgs#isCommandValid` | 2 |
| `CommandArgs#toString` | 2 |
| `WC#countWords` | 2 |
| `Tail#buildContent` | 2 |
| `TailTest#testTailOnNonExistingFile` | 2 | 
| `WcTest#testWordCountInNonExistingFile` | 2 | 
| `CommandArgsTest#testInsufficientArguments` | 2 | 
| `CommandArgsTest#testNoArguments` | 2 | 
| Javadoc | 1 | 
| Reflection | 2 | 