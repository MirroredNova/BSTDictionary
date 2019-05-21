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
 * class to manage each word that is added to the dictionary
 * 
 * @author Nate Wiltzius
 *
 */
public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

  /**
   * creates a new dictionary word with the provided word and its meaning pair
   * 
   * @param word    is the string word
   * @param meaning is the string meaning
   * @throws IllegalArgumentException when the word or meaning are either references to an empty
   *                                  string or null references
   */
  public DictionaryWord(String word, String meaning) {

    // checks to see if either string is either null or has no content and if so, throws an
    // IllegalArgumentException
    if (word == null || word.length() == 0 || meaning == null || meaning.length() == 0)
      throw new IllegalArgumentException("Invalid String");

    // sets the word and meaning of this object
    this.word = word;
    this.meaning = meaning;
  }

  /**
   * getter for the left child of this dictionary word
   * 
   * @return the left child of this dictionary word
   */
  public DictionaryWord getLeftChild() {
    return this.leftChild;
  }

  /**
   * setter for the left child of this dictionary word
   * 
   * @param leftChild is the new left child of this word
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * getter for the right child of this dictionary word
   * 
   * @return the right child of this dictionary word
   */
  public DictionaryWord getRightChild() {
    return this.rightChild;
  }

  /**
   * setter for the right child of this dictionary word
   * 
   * @param rightChild is the new right child of this word
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * getter for the word of this dictionary word
   * 
   * @return the word of this object
   */
  public String getWord() {
    return this.word;
  }

  /**
   * getter for the meaning of the word of this dictionary word
   * 
   * @return the meaning of the word of this object
   */
  public String getMeaning() {
    return this.meaning;
  }

  /**
   * Returns a String representation of this DictionaryWord. This String should be formatted as
   * follows. "<word>: <meaning>" For instance, for a dictionaryWord that has the String "Awesome"
   * for the instance field word and the String "adj. Inspiring awe; dreaded." as value for meaning
   * field, the String representing that dictionaryWord is "Awesome: adj. Inspiring awe; dreaded."
   */
  public String toString() {
    return this.word + ": " + this.meaning;
  }
}
