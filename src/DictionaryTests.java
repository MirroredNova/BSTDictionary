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

/**
 * class to manage all the tests for the dictionary
 * 
 * @author Nate Wiltzius
 *
 */
public class DictionaryTests {

  /**
   * this method tests that the dictionary adds words correctly
   * 
   * @return true if the words are added correctly, false otherwise
   */
  public static boolean testDictionaryBSTAddWord() {
    boolean testPassed = false;
    DictionaryBST dictionary = new DictionaryBST(); // new dictionary
    dictionary.addWord("Aword1", "a definition"); // three different words added
    dictionary.addWord("Zword1", "a definition");
    dictionary.addWord("Tword1", "a definition");

    // checks that the words in the dictionary are in actually there, and in the correct order, and
    // checks that a new duplicate word cannot be added. If true, the test passes, otherwise it
    // fails
    if (dictionary.getAllWords().get(0).equalsIgnoreCase("Aword1")
        && dictionary.getAllWords().get(1).equalsIgnoreCase("Tword1")
        && dictionary.getAllWords().get(2).equalsIgnoreCase("Zword1")
        && !dictionary.addWord("Aword1", "a definition")) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * this method tests that the dictionary can correctly look up words
   * 
   * @return true if the word is looked up correctly, false otherwise
   */
  public static boolean testDictionaryBSTLookup() {
    boolean testPassed = false;
    DictionaryBST dictionary = new DictionaryBST(); // new dictionary
    dictionary.addWord("c", "definitionC"); // three different words added
    dictionary.addWord("b", "definitionB");
    dictionary.addWord("f", "definitionF");
    String lookedUp = dictionary.lookup("B"); // a string variable is set to the meaning of the word
                                              // looked up

    // checks that the meaning of the correct word was returned. If it was, the test passes,
    // otherwise it fails
    if (lookedUp.equals("definitionB")) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * this method tests that the dictionaries size can be correctly determined
   * 
   * @return true if the size of the dictionary is correct, false otherwise
   */
  public static boolean testDictionaryBSTSize() {
    boolean testPassed = false;
    DictionaryBST dictionary = new DictionaryBST(); // new dictionary
    int sizeBefore = dictionary.size(); // checks size before anything is added
    dictionary.addWord("word1", "definition"); // adds one word
    int sizeAfter = dictionary.size(); // makes sure that the size changed

    // checks that the sizes were correct. If they were, the test passes, otherwise it fails
    if (sizeBefore == 0 && sizeAfter == 1) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * this method tests that the dictionaries height can be correctly determined
   * 
   * @return true if the height of the dictionary is correct, false otherwise
   */
  public static boolean testDictionaryBSTHeight() {
    boolean testPassed = false;
    DictionaryBST dictionary = new DictionaryBST(); // new dictionary
    int sizeBefore = dictionary.height(); // height before any words are added, should be 0
    dictionary.addWord("lword", "definition"); // adds one word
    int sizeAfter1 = dictionary.height(); // gets the height, should be 1
    dictionary.addWord("aword", "definition"); // adds another word
    int sizeAfter2 = dictionary.height(); // gets the height, should be 2
    dictionary.addWord("zword", "definition"); // adds another word
    int sizeAfter3 = dictionary.height(); // gets the height, should still be 2

    // checks that the heights are correct. If they are, the test passes, otherwise it fails
    if (sizeBefore == 0 && sizeAfter1 == 1 && sizeAfter2 == 2 && sizeAfter3 == 2) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * this method tests that the words in the dictionary can be printed correctly
   * 
   * @return true if the output of the dictionary is correct, false otherwise
   */
  public static boolean testDictionaryBSTGetAllWords() {
    boolean testPassed = false;
    DictionaryBST dictionary = new DictionaryBST(); // new dictionary
    dictionary.addWord("c", "definition"); // adds a bunch of words in a random order
    dictionary.addWord("b", "definition");
    dictionary.addWord("f", "definition");
    dictionary.addWord("d", "definition");
    dictionary.addWord("a", "definition");
    dictionary.addWord("e", "definition");

    // checks that the words are printed in the correct order, if so, the test passes, otherwise it
    // fails
    if (dictionary.getAllWords().toString().equalsIgnoreCase("[a, b, c, d, e, f]")) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * main to run all of the tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testDictionaryBSTAddWord: " + testDictionaryBSTAddWord());
    System.out.println("testDictionaryBSTLookup: " + testDictionaryBSTLookup());
    System.out.println("testDictionaryBSTSize: " + testDictionaryBSTSize());
    System.out.println("testDictionaryBSTHeight: " + testDictionaryBSTHeight());
    System.out.println("testDictionaryBSTGetAllWords: " + testDictionaryBSTGetAllWords());
  }

}
