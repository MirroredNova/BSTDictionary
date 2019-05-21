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
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * class to manage the words in the dictionary
 * 
 * @author Nate Wiltzius
 *
 */
public class DictionaryBST implements Dictionary {

  // instance fields
  private DictionaryWord root; // is the base node of the dictionary

  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if the dictionary is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {

    // checks if root is null, if it is, the dictionary is empty and true is returned, otherwise
    // false
    if (root == null)
      return true;
    else
      return false;
  }

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * 
   * @param word
   * @param meaning
   * @return true if the word was successfully added to this dictionary, false if the word was
   *         already in the dictionary
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  @Override
  public boolean addWord(String word, String meaning) {
    boolean pass; // variable to store if the word was added or not
    DictionaryWord newWord = new DictionaryWord(word, meaning); // creates a new word

    // checks to see if the array has words already
    if (this.isEmpty()) {
      // if it is empty, it puts the new word in the root
      this.root = newWord; // puts the new word in the root
      this.root.setLeftChild(null); // sets the children of the root to null
      this.root.setRightChild(null);
      return true;
    } else { // if the dictionary already has words
      pass = addWordHelper(newWord, root); // calls the helper method, pass depends on the return
      newWord.setLeftChild(null); // sets the children of the new word to null
      newWord.setRightChild(null);
      return pass;
    }
  }

  /**
   * looks up the meaning of a specified word in the dictionary
   * 
   * @param s is the word you are looking for
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if the word s was not found in this dictionary
   */
  @Override
  public String lookup(String s) {
    // sets string 'lookup' equal to the return of the lookup helper method
    return lookupHelper(s, root);
  }

  /**
   * finds the number of words stored in this dictionary
   * 
   * @return the number of words stored in this dictionary
   */
  @Override
  public int size() {
    return sizeHelper(root); // returns the int return value of the size helper method
  }


  // Public methods not defined in the Dictionary interface

  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root); // returns the int return value of the height helper method
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {

    return getAllWordsHelper(root); // returns the array list that is returned by the helper method
  }

  // Recursive private helper methods

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {

    boolean pass; // boolean to store if the word was added successfully or not

    // checks to see if the current node stores the word we are looking for, which would mean that
    // that word is already in the dictionary
    if (current.getWord().equalsIgnoreCase(newWordNode.getWord())) {
      pass = false; // pass is set to false
      return pass;
    }

    // checks to see if the new word comes before or after the word in the current node
    // alphabetically. If it comes before, we move to the left nodes
    if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      // checks to see if the left child of the current node is null. If it is, the new node is
      // added there
      if (current.getLeftChild() == null) {
        current.setLeftChild(newWordNode); // sets the left child of the current node to the new
                                           // node
        pass = true;
        return pass;
      } else { // if the left child isn't null, the helper method is called again but where the
               // current node is equal to the left child
        pass = addWordHelper(newWordNode, current.getLeftChild());
      }
    } else { // if the new word come after, we move to the right nodes
      // checks to see if the right child of the current node is null. If it is, the new node is
      // added there
      if (current.getRightChild() == null) {
        current.setRightChild(newWordNode);
        pass = true;
        return pass;
      } else { // if the right child isn't null, the helper method is called again but where the
               // current node is equal to the right child
        pass = addWordHelper(newWordNode, current.getRightChild());
      }
    }
    return pass;
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {

    // checks to see if the current node is null, which would mean that there is no definition for
    // the word. If there is no definition, an exception is thrown with a message
    if (current == null) {
      throw new NoSuchElementException("No definition found for the word " + s);
    }

    // checks to see if the word at the current node is equal to the string
    if (current.getWord().equalsIgnoreCase(s)) { // base case
      return current.getMeaning(); // returns the meaning of the word at the current node
    }

    // if the string s comes before the word at the current node alphabetically, the string returned
    // by the next recursive call of the lookup helper method on the left child node is returned
    if (s.compareToIgnoreCase(current.getWord()) < 0) {
      return lookupHelper(s, current.getLeftChild());
    }

    // if the string s comes after the word at the current node, the string returned by the next
    // recursive call of the lookup helper method on the right child is returned
    return lookupHelper(s, current.getRightChild());

  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    int count = 0; // counter variable

    // if the current node is null, count is returned
    if (current == null) {
      return count;
    }

    // count is incremented for each nodes left child, then one is added, then count is incremented
    // for each nodes right child
    count += sizeHelper(current.getLeftChild());
    count++;
    count += sizeHelper(current.getRightChild());

    return count;
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {

    // if the current node is null, 0 is returned
    if (current == null) {
      return 0;
    } else {
      int leftHeight = heightHelper(current.getLeftChild()); // int to count the amount of left
                                                             // children
      int rightHeight = heightHelper(current.getRightChild()); // int to count the amount of right
                                                               // children

      // if the left height is bigger than the right height, left height is incremented
      if (leftHeight > rightHeight) {
        return (leftHeight + 1);
      } else { // otherwise the right height is incremented
        return (rightHeight + 1);
      }
    }
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    ArrayList<String> array = new ArrayList<String>(); // creates an array list to return

    // if current is null, array is returned with all of its current words
    if (current == null) {
      return array;
    }

    // the program goes through and recursively gathers and adds the left children, then the right
    // children of each node and adds them to the array. It starts on the left, then moves right
    array.addAll(getAllWordsHelper(current.getLeftChild()));
    array.add(current.getWord());
    array.addAll(getAllWordsHelper(current.getRightChild()));

    return array;
  }

}
