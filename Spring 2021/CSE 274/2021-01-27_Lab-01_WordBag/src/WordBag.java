/**
 * A fixed-size bag of String objects, implemented
 * with an array.
 * 
 * @author Norm Krumpe
 * 
 * edited by Nicholas Rybicki
 * CSE 274 - Lab 01
 * 01-27-2021
 */
public class WordBag {
	private String[] words;
	private int size;
	/**
	 * The capacity of the bag if no capacity is specified
	 */
	public static final int DEFAULT_CAPACITY = 5;

	/**
	 * Constructs an empty bag with the specified
	 * capacity.
	 * @param capacity the maximum number of elements
	 * in the bag
	 */
	public WordBag(int capacity) {
		this.words = new String[capacity];
		this.size = 0;
	}

	/**
	 * Constructs an empty bag with the default
	 * capacity as defined by WordBag.DEFAULT_CAPACITY.
	 */
	public WordBag() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Adds the specified word to the bag, if there 
	 * is room.
	 * @param word the word to be added
	 * @return true if the word is successfully added,
	 * and false otherwise (which would happen if the
	 * bag were full)
	 */
	public boolean add(String word) {
		if (size >= words.length) // the capacity is words.length
			return false;
		words[size++] = word;
		return true;
	}

	/**
	 * Determines whether the specified word is
	 * in the bag.
	 * @param word the word to check for in the bag
	 * @return true if the word exists, and false otherwise
	 */
	public boolean contains(String word) {
		return indexOf(word) != -1;
	}

	/**
	 * Removes an instance of the specified word
	 * from the bag, if it exists.
	 * @param word the word to be removed
	 * @return true if an instance of the word was
	 * removed, and false otherwise.
	 */
	public boolean remove(String word) {
		int index = indexOf(word);
		if (index == -1)
			return false;
		else {
			size--;
			words[index] = words[size];
			words[size] = null;
			return true;
		}
	}
	
	/*
	 * Private helper method to find the first occurrence of a word
	 * Returns index of first occurrence, or -1 if not found
	 */
	private int indexOf(String word) {
		for (int i = 0; i < size; i++)
			if (word.equals(words[i]))
				return i;
		return -1;
	}
	
	/**
	 * Gets the number of words in the bag
	 * @return the number of words in the bag
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Determines whether the bag is empty.
	 * @return true if the bag contains no words, and false otherwise
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Removes all words from the bag.
	 */
	public void clear() {
		for (int i = 0; i < size; i++)
			words[i] = null;
		size = 0;
	}
	
	/**
	 * Gets the number of times that a specified word is in the bag.
	 * @param word the word to be checked
	 * @return the number of times that word is in the bag
	 */
	public int getFrequency(String word) {
		int ct = 0;
		for (int i = 0; i < size; i++)
			if (word.equals(words[i]))
				ct++;
		return ct;
	}
	
	/**
	 * Removes an element from the bag, if one exists.
	 * The client should have no expectations about which 
	 * element will be returned.
	 * @return an element from the bag, or null if the bag is empty
	 */
	public String remove() {
		String str;
		if (size == 0)
			str = null;
		else {
			str = words[--size];
			words[size] = null;
		}
		return str;
	}
	
	/**
	 * Gets an array of all the elements in the bag.
	 * @return a String array containing all elements in the bag. If
	 * the bag is empty, an array of length 0 will be returned.
	 */
	public String[] toArray() {
		// Don't return the original array. Create a new one with the right size
		String[] array = new String[size];
		for (int i = 0; i < size; i++)
			array[i] = words[i];
		return array;
	}
	
	/*
	 * Returns a space-separated list of words in the bag.
	 */
	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < size; i++) {
			ret += words[i] + " ";
		}
		return ret;
	}

}
