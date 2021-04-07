/**
 * Implements a set of strings using hashing, ideally giving O(1)
 * performance for add, remove, and contains.  We say "ideally" because
 * efficiency depends on keeping the number of collisions low.
 * 
 * @author Norm Krumpe
 *
 */
public class HashSet implements SetInterface {
	
	private Node[] buckets;
	private int size;
	public static final int DEFAULT_CAPACITY = 11;
	public static final double LOAD_FACTOR = 0.6; // max load factor
	
	/**
	 * Constructs a hash set with an initial array length of 11
	 */
	public HashSet() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructs a hash set with the initial specified capacity.
	 * The capacity must be a prime number. 
	 * @throws IllegalArgumentException if capacity is not prime
	 * @param capacity
	 */
	public HashSet(int capacity) {
		if (!isPrime(capacity)) {
			throw new IllegalArgumentException(capacity + " is not a prime number");
		}
		
		buckets = new Node[capacity];
		size = 0;
	}
	
	/**
	 * Constructs a new hash set by beginning
	 * with the default capacity, and then adding
	 * the words from the specified array
	 * @param words the words to be added
	 */
	public HashSet(String[] words) {
		this(DEFAULT_CAPACITY);
		
		// loop to add all strings to the set
		for (String word : words) {
			add(word);
		}
	}
	
	// O(1) time complexity, assuming a well structured hash set
	@Override
	public boolean add(String s) {
		int bucketIndex = getHashIndex(s);
		
		// buckets[bucketIndex] is where we would expect to find s
		Node foundAt = find(s, buckets[bucketIndex]);
		
		if (foundAt != null) { // already exists
			return false;
		} else {
			// check if need to resize
			if (1.0 * size / buckets.length >= LOAD_FACTOR) {
				resize();
				bucketIndex = getHashIndex(s);
			}
			
			// insert new item in front of the head node
			//	in the right bucket
			Node temp = new Node(s);
			temp.next = buckets[bucketIndex];
			buckets[bucketIndex] = temp;
			size++;
			
			return true;
		}
	}
	
	// O(1) time complexity, assuming a well structured hash set
	@Override
	public boolean remove(String s) {
		int bucketIndex = getHashIndex(s);
		Node foundAt = find(s, buckets[bucketIndex]);
		
		// if found, then remove
		// do a data "transplant" to move the data from the head node
		//	to the foundAt node
		if (foundAt != null) {
			foundAt.data = buckets[bucketIndex].data;
			buckets[bucketIndex] = buckets[bucketIndex].next;
			size--;
			return true;
		}
		
		return false;
	}
	
	// Note: This is not O(1) time complexity, bc it doesnt use hashing
	/*
	 * Returns an arbitrary string from the set, if the set is not empty. Otherwise, returns null;
	 * Our algorithm: find the first non-empty bucket and return the data from the first node in that
	 * bucket.
	 */
	@Override
	public String remove() {
		if (size == 0) {
			return null;
		}
		
		Node ret = null;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				ret = buckets[i];
				buckets[i] = buckets[i].next;
				size--;
				return ret.data;
			}
		}
		
		return null;
	}

	@Override
	public void clear() {
		// loop to null out each bucket
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;
	}
	
	// O(1) time complexity, assuming a well structured hash set
	@Override
	public boolean contains(String s) {
		int bucketIndex = getHashIndex(s);
		return find(s, buckets[bucketIndex]) != null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String[] toArray() {
		String[] words = new String[size];
		
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			Node curr = buckets[i];
			while (curr != null) {
				words[index++] = curr.data;
				curr = curr.next;
			}
		}
		
		return words;
	}

	public String toString() {
		String str = "";
		
		for (int i = 0; i < buckets.length; i++) {
			str += "[" + i + "] ";
			
			// grab all strings from bucket i
			Node curr = buckets[i];
			while (curr != null) {
				str += curr.data + " ";
				curr = curr.next;
			}
			
			str += "\n";
		}
		
		return str;
	}

	////////////////////////////////////////////
	// helper methods
	////////////////////////////////////////////
	/*
	 * Modifies this set by moving the items in the
	 * array to a new array whose size is the first prime
	 * number >= length of the current array
	 */
	private void resize() {
//		// 1. create a bigger hash set with the correct capacity
//		// 2. use toArray to get the words from the current hash set
//		// 3. loop to add those words from the array to the bigger hash set
//		// 4. tell this.buckets to point to the new buckets
		HashSet resized = new HashSet(firstPrime(buckets.length * 2));
		String[] words = this.toArray();
		for (String word : words) {
			resized.add(word);
		}
		this.buckets = resized.buckets;
	}

	// Returns the node containing a particular string, or null if not found.
	// Useful for add, remove, and contains.
	private Node find(String s, Node head) {
		Node curr = head;
		
		while (curr != null) {
			if (curr.data.equals(s)) {
				return curr;
			}
			curr = curr.next;
		}
		
		// made it here? s was not found
		return null;
	}

	// What does this do?
	//	This creates an index into buckets based on the objects hash code
	private int getHashIndex(String s) {
		int index = s.hashCode() % buckets.length;
		
		if (index < 0) {
			index += buckets.length;
		}
		return index;
	}

	// Returns true if a number is prime, and false otherwise
	private boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	// Returns the first prime >= n
	private int firstPrime(int n) {
		while (!isPrime(n)) {
			n++;
		}
		
		return n;
	}

	// Inner node class
	private class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	

}
