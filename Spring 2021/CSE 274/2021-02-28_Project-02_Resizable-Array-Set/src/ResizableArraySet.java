import java.util.Arrays;
/**
 * Implementation of a resizable array set, implements SetInterface and has extra methods to
 * 	supply the client with more usability. The set will contain no duplicate values, elements
 * 	are case sensitive, and if the client tries to add when the array is full, it will
 * 	automatically resize to double its length
 * 
 * @author Nick Rybicki
 * 
 */
public class ResizableArraySet implements SetInterface {
	
	// ==================== Properties ====================
	private int size;		// variable for the size of the set (number of items in the set)
	private String[] data;	// variable for the array set containing String values
	private final static int DEFAULT_CAPACITY = 10; // default size of the array
	
	// ==================== Constructors ====================
	/**
	 * Workhorse constructor that takes in a capacity and creates an empty set of
	 * 	length capacity
	 * 
	 * @param capacity - int denoting the capacity of this array set
	 */
	public ResizableArraySet(int capacity) {
		data = new String[capacity];
		size = 0;
	}
	
	/**
	 * Default constructor that calls workhorse constructor with a default capacity of 10
	 */
	public ResizableArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor with input of a string of words, calls workhorse constructor with
	 * 	capacity of the length of the words array, then adds unique values to array
	 * 
	 * @param words - string array of values, might contain duplicates but duplicates
	 * 	will not be add
	 */
	public ResizableArraySet(String[] words) {
		this(words.length);
		
		// loop through words and add to data
		for (String word : words) {
			add(word);
		}
	}
	
	// ==================== Methods ====================
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(String s) {
		resize();
		
		if (!contains(s)) {
			data[size] = s;
			size++;
			return true;
		}
		
		return false;
	}

	@Override
	public String remove() {
		if (size != 0) {
			String word = data[size - 1];
			data[size - 1] = null;
			size--;
			return word;
		}
		
		// if here, array is empty
		return null;
	}

	@Override
	public boolean remove(String s) {
		if (contains(s)) {
			int foundAt = 0;
			for (int i = 0; i < size; i++) {
				if (!data[i].equals(s)) {
					foundAt++;
				} else {
					break;
				}
			}
			data[foundAt] = data[size - 1];
			data[size - 1] = null;
			size--;
			return true;
		}
		
		// if here, s was not found
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(String s) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(s))
				return true;
		}
		return false;
	}

	@Override
	public String[] toArray() {
		return Arrays.copyOf(data, size);
	}
	
	/**
	 * Returns a string of all the data in the array set with each item separated
	 * 	by a space
	 * 
	 * @return a string of all the data in the array set separated by a space
	 */
	@Override
	public String toString() {
		String str = "";
		
		for (int i = 0; i < size; i++)
			str += data[i] + " ";
		
		return str.trim();
	}
	
	/**
	 * Accepts a ResizableArraySet object and adds the common values between this set
	 * 	and other set into and returns a new ResizableArraySet
	 * 
	 * @param other - other resizable array set to compare and get values from
	 * @return new resizable array set that contains values appearing in both this
	 * 	set and other set
	 */
	public ResizableArraySet intersection(ResizableArraySet other) {
		ResizableArraySet intersectSet = new ResizableArraySet(this.size);
		
		// loop through this set, checking to see if other set contains the 
		//	string, if it does add to new set
		for (int i = 0; i < this.size; i++) {
			if (other.contains(this.data[i])) {
				intersectSet.add(this.data[i]);
			}
		}
		
		return intersectSet;
	}
	
	/**
	 * Returns a new ResizableArraySet that contains the values from this set and 
	 * 	other set that is passed in as a parameter
	 * 
	 * @param other - other resizable array set to get values from
	 * @return new resizable array set that contains all values from other set
	 * 	and this set
	 */
	public ResizableArraySet union(ResizableArraySet other) {
		// create a copy of this resizable array set for the returned set, can do
		//	this because implementation implies all unique values in this set
		ResizableArraySet unionSet = new ResizableArraySet(this.data);
		
		// loop through other set and add unique data
		for (int j = 0; j < other.size; j++) {
			unionSet.add(other.data[j]);
		}
		
		return unionSet;
	}
	
	/**
	 * Returns new ResizableArraySet object that contains each element paired
	 * 	up with all other elements contained in this set
	 * 
	 * @return ResizableArraySet - new resizable array set object with its elements 
	 * 	being all combinations of pairs of elements originally in this set
	 */
	public ResizableArraySet allPairs() {
		ResizableArraySet allPairSet = new ResizableArraySet(this.size);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (j != i) {
					allPairSet.add(this.data[i] + this.data[j]);
				}
			}
		}
		
		return allPairSet;
	}
	
	/**
	 * Method that goes through all strings in the set and finds the word that
	 * 	comes first alphabetically among all strings in the array
	 * 
	 * @return String - the earliest word alphabetically (lexicographically)
	 */
	public String getEarliestWord() {
		String earliestWord = data[0];
		
		for (int i = 1; i < size; i++) {
			if (earliestWord.toLowerCase().compareTo(data[i].toLowerCase()) > 0) {
				earliestWord = data[i];
			}
		}
		
		return earliestWord;
	}
	
	// ==================== Helper Methods ====================
	/**
	 * Helper method that checks if the array set is full (reached capacity), if it
	 * 	is then it creates a new array with twice the capacity and copies all the
	 * 	values into the new array and sets data equal to it
	 */
	private void resize() {
		if (size >= data.length) {
			this.data = Arrays.copyOf(this.data, size * 2);
		}
	}
	
}
