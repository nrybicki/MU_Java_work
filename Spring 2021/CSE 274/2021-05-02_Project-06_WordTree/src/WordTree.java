import java.util.*;

/**
 * A tree implementation using nodes that will store different words, with
 * consecutive letters being the children of previous letters in the word.
 * 
 * @author NickR
 */
public class WordTree {
	// ==================== Properties ====================
	private Node root;

	// ==================== Constructors ====================
	/**
	 * Empty constructor that just sets up the root node; set to ' ' just as a
	 * placeholder
	 */
	public WordTree() {
		root = new Node(' ');
	}

	// ==================== Methods ====================
	/**
	 * Adds a word to the tree, returns true if successful or false if not added
	 * (already in tree or if empty string)
	 * 
	 * @param word - word to be added to the tree
	 * @return true if word is added or false if it isn't
	 */
	public boolean add(String word) {
		// check if word is null or empty string
		if (word == null || word.isBlank()) {
			return false;
		}

		// check if tree already contains word
		if (contains(word)) {
			return false;
		}

		// word is not null or empty, and is not in the tree, now add
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (curr.getChild(letter) == null) {
				// letter IS NOT currently a node in the tree, create and set curr equal to it
				curr = curr.addChild(letter);
			} else {
				// letter IS in tree, set curr equal to it
				curr = curr.getChild(letter);
			}
		}
		// set the endOfWord variable in curr to true
		curr.endOfWord = true;

		return true;
	}

	/**
	 * Checks if the tree contains the word, return true if it does, false if it
	 * doesn't
	 * 
	 * @param word - word to be found
	 * @return true if found, false if not or if word is empty string
	 */
	public boolean contains(String word) {
		if (word == null || word.isBlank()) {
			return false;
		}
		Node curr = root;

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (curr.getChild(letter) == null) {
				return false;
			}
			curr = curr.getChild(letter);
		}

		return curr.endOfWord;
	}

	/**
	 * Removes the given word from the tree, returns true if successful and false
	 * otherwise (word is not in the tree or it is empty/null)
	 * 
	 * @param word - the word to be removed from the tree
	 * @return true if remove is successful and false if unsuccessful
	 */
	public boolean remove(String word) {
		if (word == null || word.isBlank()) {
			return false;
		}

		Stack<Node> stk = new Stack<>();
		Node curr = root;
		// traverse tree to find end node of word and populate stack
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (curr.getChild(letter) == null) {
				return false;
			}
			curr = curr.getChild(letter);
			stk.push(curr);
		}
		
		// remove top of stack and check if it has children
		// if it does, just set endOfWord to false
		curr = stk.pop();
		if (!curr.children.isEmpty()) {
			curr.endOfWord = false;
			return true;
		}

		// end node does not have children so remove the node
		stk.peek().children.remove(curr);
		// continue to remove nodes until you reach root or the end of a word
		while (!stk.isEmpty()) {
			if (stk.peek().endOfWord) {
				return true;
			} else {
				curr = stk.pop();
				if (curr.children.isEmpty()) {
					stk.peek().children.remove(curr);
				}
			}
		}

		return true;
	}

	/**
	 * Counts the number of nodes, or letters, in the tree
	 * 
	 * @return the number of nodes
	 */
	public int nodeCount() {
		return nodeCount(root) - 1; // subtract one for the root
	}

	// private recursive helper method for nodeCount
	private int nodeCount(Node top) {
		if (top == null) {
			return 0;
		}

		int count = 1;
		for (Node n : top.children) {
			count += nodeCount(n);
		}

		return count;
	}

	/**
	 * Counts the number of words in the tree
	 * 
	 * @return the number of words
	 */
	public int wordCount() {
		return wordCount(root);
	}

	// private recursive helper method for wordCount
	private int wordCount(Node top) {
		if (top == null) {
			return 0;
		}

		int count = 0;
		for (Node n : top.children) {
			if (n.endOfWord) {
				count++;
			}
			count += wordCount(n);
		}

		return count;
	}

	/**
	 * Counts the number of letters saved by using the word tree layout, which is
	 * equal to the number of letters in all words subtracted by the number of
	 * letters in the tree
	 * 
	 * @return the number of letters saved by using the word tree
	 */
	public int lettersSaved() {
		int lettersInTree = nodeCount(), totalLetters = lettersSaved(0, root, "");
		return totalLetters - lettersInTree;
	}

	// private recursive helper method for lettersSaved
	private int lettersSaved(int lettersSoFar, Node top, String wordSoFar) {
		if (top == null) {
			return 0;
		}

		wordSoFar += top.data;

		if (top.endOfWord) {
			lettersSoFar += wordSoFar.length() - 1;
		}

		for (Node n : top.children) {
			lettersSoFar = lettersSaved(lettersSoFar, n, wordSoFar);
		}

		return lettersSoFar;
	}

	/**
	 * Clears the WordTree
	 */
	public void clear() {
		root = new Node(' ');
	}

	/**
	 * Returns a set of all the words in the tree
	 * 
	 * @return set containing all the words in the tree
	 */
	public Set<String> allWords() {
		Set<String> words = new HashSet<>();
		allWords(words, "", root);
		return words;
	}

	// private recursive helper method for allWords
	private void allWords(Set<String> setSoFar, String wordSoFar, Node top) {
		if (top == null) {
			return;
		}

		wordSoFar += top.data;

		if (top.endOfWord) {
			setSoFar.add(wordSoFar.trim());
		}

		for (Node n : top.children) {
			allWords(setSoFar, wordSoFar, n);
		}
	}

	/**
	 * Returns a set of all the words in the tree starting with a specified prefix
	 * 
	 * @param prefix - the specified prefix to search for
	 * @return set containing all words with specified prefix
	 */
	public Set<String> allStartingWith(String prefix) {
		Set<String> result = new HashSet<>();
		allStartingWith(prefix, "", result, root);
		return result;
	}

	// private recursive helper method for allStartingWith
	private void allStartingWith(String prefix, String wordSoFar, Set<String> setSoFar, Node top) {
		if (top == null) {
			return;
		}

		wordSoFar += top.data;

		if (top.endOfWord && wordSoFar.trim().indexOf(prefix) == 0) {
			setSoFar.add(wordSoFar.trim());
		}

		for (Node n : top.children) {
			allStartingWith(prefix, wordSoFar, setSoFar, n);
		}
	}

	/**
	 * Returns a map with a character key and the value being a set of strings that
	 * all start with that letter
	 * 
	 * @return map of character and set of strings key-value pairs
	 */
	public Map<Character, Set<String>> wordMap() {
		Map<Character, Set<String>> result = new HashMap<>();

		for (Node n : root.children) {
			result.put(n.data, allStartingWith(n.data + ""));
		}

		return result;
	}

	/*
	 * toString method to be used for debugging
	 */
	public String toString() {
		return "root" + root + "";
	}

	// ********************************************************
	// *************** Private Inner Node Class ***************
	// ********************************************************
	/**
	 * Private inner node class with character type data, a set of child nodes, and
	 * a boolean signifying if this node is the end of a word
	 * 
	 * @author NickR
	 */
	private class Node {
		// ==================== Properties ====================
		private char data;
		private Set<Node> children;
		private boolean endOfWord;

		// ==================== Constructors ====================
		private Node(char data) {
			this.data = data;
			children = new HashSet<>();
			endOfWord = false;
		}

		// ==================== Methods ====================
		/**
		 * Adds new child node to this node's children and returns it
		 * 
		 * @param data - data for new child node to be added
		 * @return the node with the specified data
		 */
		private Node addChild(char data) {
			Node getChild = getChild(data);

			if (getChild != null) {
				return getChild;
			} else {
				Node child = new Node(data);
				children.add(child);
				return child;
			}
		}

		/**
		 * Checks if the node containing data is in the set of children for this node
		 * and returns it, or returns null if not found
		 * 
		 * @param data
		 * @return
		 */
		private Node getChild(char data) {
			Node child = null;

			for (Node n : children) {
				if (n.data == data) {
					child = n;
					break;
				}
			}

			return child;
		}

		public String toString() {
			return (endOfWord ? (data + "").toUpperCase() : data) + " " + children;
		}
	}
}
