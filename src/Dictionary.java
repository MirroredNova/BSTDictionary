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
 * interface to manage the dictionaryBST
 * 
 * @author Nate Wiltzius
 *
 */
public interface Dictionary {

  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if the dictionary is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * 
   * @param word
   * @param meaning
   * @return true if the word was successfully added to this dictionary, false if the word was
   *         already in the dictionary
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  public boolean addWord(String word, String meaning);

  /**
   * looks up the meaning of a specified word in the dictionary
   * 
   * @param s is the word you are looking for
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if the word s was not found in this dictionary
   */
  public String lookup(String s);

  /**
   * finds the number of words stored in this dictionary
   * 
   * @return the number of words stored in this dictionary
   */
  public int size();
}
