/**
 * Implements a set of strings using hashing, ideally giving O(1)
 * performance for add, remove, and contains.  We say "ideally" because
 * efficiency depends on keeping the number of collisions low.
 * 
 * @author Norm Krumpe
 *
 */
public class HashSet<T> implements SetInterface<T> {

	private Node<T>[] buckets;
	private int size;
	private static final double LOAD_FACTOR = .6;
	private static final int DEFAULT_SIZE = 11; // should be prime

	/**
	 * Constructs a hash set with an initial array length of 11
	 */
	public HashSet() {
		this(DEFAULT_SIZE);
	}
	
	/**
	 * Constructs a new hash set with the specified capacity
	 * @param capacity the desired capacity (number of buckets)
	 * @throws IllegalArgumentException if the capacity is not prime
	 */
	@SuppressWarnings("unchecked")
    public HashSet(int capacity) {
		if (!isPrime(capacity)) {
			throw new IllegalArgumentException("capacity must be prime");
		}
		buckets = (Node<T>[])(new Node[capacity]);
		size = 0;
	}
	
	/**
	 * Constructs a new hash set with default capacity
	 * @param words a collection of words to be added to the set
	 */
	public HashSet(T[] words) {
		this(DEFAULT_SIZE);
		for (T s : words) {
			add(s);
		}
	}

	@Override
	public boolean add(T s) {
		// Will need to recompute the hash index later
		// if we resize.
		int correctIndex = getHashIndex(s); 
		Node<T> foundAt = find(s, buckets[correctIndex]);
		
		if (foundAt == null) { // not found, so add
			if (1.0 * size / buckets.length > LOAD_FACTOR) {
				resize();
				// recompute index because old computation
				// was based on % buckets.length
				correctIndex = getHashIndex(s); 
			}

			Node<T> temp = new Node<T>(s);
			temp.next = buckets[correctIndex];
			buckets[correctIndex] = temp;
			size++;
			return true;
		}

		// already exists, nothing added, so return false
		return false;
	}

	@Override
	public boolean remove(T s) {
		boolean success = false;
		int correctIndex = getHashIndex(s);
		Node<T> foundAt = find(s, buckets[correctIndex]);
		
		if (foundAt != null) {
			// copy data from first node in bucket into node to be removed
			foundAt.data = buckets[correctIndex].data;
			// remove first node in bucket
			buckets[correctIndex] = buckets[correctIndex].next;
			size--;
			success = true;
		}

		return success;
	}

	@Override
	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(T s) {
		Node<T> correctBucket = buckets[getHashIndex(s)];
		return find(s, correctBucket) != null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		int ind = 0;
		for (int i = 0; i < buckets.length; i++) {
			Node<T> curr = buckets[i];
			while (curr != null) {
				result[ind++] = curr.data;
				curr = curr.next;
			}
		}

		return result;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < buckets.length; i++) {
			result += ("[" + i + "] ");
			Node<T> curr = buckets[i];
			while (curr != null) {
				result += (curr.data + " ");
				curr = curr.next;
			}
			result += "\n";
		}
		return result;
	}

	// helper methods
	private void resize() {
		int newSize = firstPrime(this.buckets.length * 2);
		HashSet<T> bigger = new HashSet<T>(newSize);
		
		@SuppressWarnings("unchecked")
        T[] data = (T[])(this.toArray());
		for (T s : data) {
			bigger.add(s);
		}
		
		this.buckets = bigger.buckets;
	}

	// Returns the node containing a particular string, or null if not found.
	// Useful for add, remove, and contains
	private Node<T> find(T s, Node<T> head) {
		Node<T> curr = head;

		while (curr != null) {
			if (curr.data.equals(s))
				return curr;
			curr = curr.next;
		}

		return null;
	}

	// Gets the index of the bucket where a given string should go,
	// by computing the hashCode, and then compressing it to a valid index.
	private int getHashIndex(T s) {
		int index = s.hashCode() % buckets.length;
		if (index < 0)
			index += buckets.length;
		return index;
	}

	// Returns true if a number is prime, and false otherwise
	private boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;

		// See if n has a factor between 2 and
		// the square root of n. This could be made
		// a bit more efficient by checking only odd factors
		// instead, but then we would have to check for 2 separately.
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	// Returns the first prime >= n
	private int firstPrime(int n) {
		while (!isPrime(n))
			n++;
		return n;
	}

	// Inner node class
	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	/*
	 * Our algorithm: find the first non-empty bucket
	 * and return the data from the first node in that
	 * bucket. Not O(1) because it doesn't use hashing.
	 */
	@Override
	public T remove() {
		if (size == 0) {
			return null;
		}
		
		T result = null;
		
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				result = buckets[i].data;
				buckets[i] = buckets[i].next;
				size--;
				break;
			}
		}
		return result;
	}

}
