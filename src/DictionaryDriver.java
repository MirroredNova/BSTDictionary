//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BST Dictionary
// Files: Dictionary.java, DictionaryWord.java, DictionaryBST.java, DictionaryTests.java,
//////////////////// DictionaryDriver.java
// Course: CS300 Spring 2019
//
// Author: Nate Wiltzius
// Email: nwiltzius@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

// imports
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * class to manage the user inputs and outputs for the dictionary
 * 
 * @author Nate Wiltzius
 *
 */
public class DictionaryDriver {

  /**
   * this method prints the specially formatted menu whenever called
   */
  private static void printMenu() {
    String userCommands = "\n=========================== Dictionary ============================\n"
        + "Enter one of the following options:\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
        + "[L <word>] to search a word in the dictionary and display its definition\n"
        + "[G] to print all the words in the dictionary in sorted order\n"
        + "[S] to get the count of all words in the dictionary\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\n"
        + "[Q] to quit the program\n"
        + "======================================================================\n";
    System.out.println(userCommands);
  }

  /**
   * this method processes and manages the user input
   * 
   * @param in         is the scanner that gets the user input
   * @param dictionary is the dictionary that will be manipulated
   */
  private static void processInput(Scanner in, DictionaryBST dictionary) {
    printMenu(); // prints the menu whenever called

    // local variables
    String command = null;
    String[] commands = null;
    String getInput = "Please enter your command: ";
    System.out.print(getInput); // prints the prompt

    command = in.nextLine(); // sets the input to the variable 'command'
    commands = command.trim().split(" "); // split user command

    // try/catch block to manage the exceptions that will be thrown
    try {
      // switch case to do different things based on the user inputs
      switch (commands[0].toUpperCase()) {
        case "A": // add word case
          // checks to see if the command is less than three different parts
          if (commands.length < 3) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [A <word> <meaning>] command line.",
                0);
          }
          boolean success; // boolean to store if the add was a success
          String meaning = ""; // variable to store the meaning

          // since the commands are split up by spaces, and the meaning of the word is given by
          // everything after the first two parts. This for loop compiles the rest of the parts of
          // the command into one string that represents the meaning of the word
          for (int i = 2; i < commands.length; i++) {
            meaning += commands[i] + " "; // compiles the command parts into the meaning String
          }

          // calls the addWord method with the word and the meaning and sets the result to 'success'
          success = dictionary.addWord(commands[1], meaning);

          // if success is false, that means that the word was a duplicated, and it wasn't added
          if (!success) { // if it wasn't added, this warning is printed
            System.out.println("WARNING: failed to add duplicate word: " + commands[1]);
          }

          break;

        case "L": // lookup word case
          // checks to see if the command is greater than two different parts
          if (commands.length != 2) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [L <word>] command line.", 0);
          }
          // checks to see if there are words in the dictionary
          if (dictionary.getAllWords().size() == 0) {
            // if there are no words, this message is printed
            System.out.println("There are no definitions in this empty dictionary.");
          } else { // if there are words, the lookup method is called on the dictionary and the word
                   // and its meaning are printed
            System.out.println(commands[1] + ": " + dictionary.lookup(commands[1]));
          }

          break;

        case "G": // print all words case
          // checks to see if the command is greater than the one required part
          if (commands.length > 1) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [G] command line.", 0);
          } 
          // checks to see if there are words in the dictionary
          if (dictionary.getAllWords().size() == 0) {
            // if there are no words, this message is printed
            System.out.println("Dictionary is empty");
          } else { // if there are words
            ArrayList<String> words = new ArrayList<String>(); // new array list to store the words
            words = dictionary.getAllWords(); // getAllWords method is called
            // the brackets around the array list are removed and its converted into a string
            String output = words.toString().substring(1, words.toString().length() - 1);
            System.out.println(output); // the output is printed
          }

          break;

        case "S": // size case
          // checks to see if the command is greater than the one required
          if (commands.length > 1) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [S] command line.", 0);
          }
          // prints the returned value of the dictionary size method call
          System.out.println(dictionary.size());

          break;

        case "H": // height case
          // checks to see if the command is greater than the one required
          if (commands.length > 1) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [H] command line.", 0);
          }
          // prints the returned value of the diction height method call
          System.out.println(dictionary.height());

          break;

        case "Q": // quit case
          // checks to see if the command is greater than the one required
          if (commands.length > 1) { // throws an exception if the command was incorrect
            throw new ParseException("WARNING: Syntax Error for [Q] command line.", 0);
          }

          return; // returns to the main method

        default:
          // if command didn't match one of the other cases, this message is printed
          System.out.println("WARNING: Unrecognized command.");
          break;
      }

      // catch the exceptions and print the messages that they are thrown with
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }

    // calls this method recursively until the 'Q case' returns it to the main method
    processInput(in, dictionary);
  }

  /**
   * main method to manage the initial method calls and also the program exit
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); // creates a scanner
    DictionaryBST dictionary = new DictionaryBST(); // creates a dictionary
    processInput(in, dictionary); // starts the user input processing and loops it until q is
                                  // entered
    // prints the end prompt
    System.out.println("============================== END ===================================");
    in.close(); // closes the scanner
  }
}
