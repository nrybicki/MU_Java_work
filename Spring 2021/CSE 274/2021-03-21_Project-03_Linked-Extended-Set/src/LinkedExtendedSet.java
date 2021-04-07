import java.util.Arrays;

/**
 * Node implementation of a set that utilizes generics to allow use of any java object.
 * Allows for a specified number of duplicates, number of duplicates defaults to 1 if
 * not specified by user in constructor.
 * 
 * @author NickR
 *
 * @param <T> - Generic
 */
public class LinkedExtendedSet<T> implements ExtendedSet<T> {
	
	// ==================== Properties ====================
	private Node<T> head;
	private int size;
	private final int MAX_FREQUENCY;
	
	
	// ==================== Constructors ====================
	/**
	 * Workhorse constructor that takes in a maximum frequency and constructs a new empty
	 * extended set.
	 * 
	 * @param frequency - desired max allowed frequency of a particular item
	 */
	public LinkedExtendedSet(int frequency) {
		this.MAX_FREQUENCY = frequency;
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Empty constructor that calls workhorse constructor to create a new extended set
	 * with a default maximum frequency of 1.
	 */
	public LinkedExtendedSet() {
		this(1);
	}
	
	
	// ==================== Methods ====================
	@Override
	public boolean add(T item) {
		Node<T> temp = new Node<>(item);
		
		if (this.getFrequency(item) < this.MAX_FREQUENCY) {
			temp.next = this.head;
			this.head = temp;
			this.size++;
			return true;
		}
		
		// if here, max frequency for specified item reached
		return false;
	}

	@Override
	public boolean remove(T item) {
		Node<T> foundAt = find(item);
		
		if (foundAt == null) {
			return false;
		}
		
		foundAt.data = head.data;
		head = head.next;
		size--;
		
		return true;
	}

	@Override
	public boolean removeAll(T item) {
		int freq = getFrequency(item);
		boolean success = false;
		
		for (int i = 0; i < freq; i++) {
			success = remove(item);
		}
		
		return success;
	}

	@Override
	public boolean contains(T item) {
		Node<T> curr = this.head;
		
		while (curr != null) {
			if (curr.data.equals(item)) {
				return true;
			}
			curr = curr.next;
		}
		
		return false;
	}

	@Override
	public int getFrequency(T item) {
		Node<T> curr = this.head;
		int freq = 0;
		
		while (curr != null) {
			if (curr.data.equals(item)) {
				freq++;
			}
			curr = curr.next;
		}
		
		return freq;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int uniqueCount() {
		Node<T> curr = this.head;
		int count = 0;
		boolean unique = true;
		while (curr != null) {
			unique = true;
			// check all values left of i to determine if first occurrence
			Node<T> check = this.head;
			while (check != curr) {
				if (curr.data.equals(check.data)) {
					unique = false;
					check = curr;
					break;
				}
				check = check.next;
			}
			if (unique) {
				count++;
			}
			// increment curr
			curr = curr.next;
		}
		
		return count;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int maxFrequency() {
		return this.MAX_FREQUENCY;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.head = null;
	}

	@Override
	public Object[] toArray() {
		Node<T> curr = this.head;
		Object[] arr = new Object[this.size];
		
		for (int i = 0; i < this.size; i++) {
			arr[i] = curr.data;
			curr = curr.next;
		}
		
		return arr;
	}

	@Override
	public Object[] toUniqueArray() {
		Node<T> curr = this.head;
		Object[] uniqueArr = new Object[uniqueCount()];
		int index = 0;
		
		boolean unique = true;
		while (curr != null) {
			unique = true;
			// check all values left of i to determine if first occurrence
			Node<T> check = this.head;
			while (check != curr) {
				if (curr.data.equals(check.data)) {
					unique = false;
					check = curr;
					break;
				}
				check = check.next;
			}
			if (unique) {
				uniqueArr[index++] = curr.data;
			}
			// increment curr
			curr = curr.next;
		}
		
		return uniqueArr;
	}

	@Override
	public Object[] toSortedArray() {
		Object[] sortedArray = this.toArray();
		Arrays.sort(sortedArray);
		return sortedArray;
	}
	
	@Override
	public String toString() {
		if (this.size == 0) {
			return "(empty)";
		}
		
		String str = "";
		Node<T> curr = this.head;
		
		while (curr != null) {
			str += curr.data.toString() + " ";
			curr = curr.next;
		}
		
		return str.trim();
	}
	
	
	// ==================== Helper methods ====================
	/**
	 * Helper method used to find the node containing the specified item
	 * 
	 * @param item - the item being searched for
	 * @return the node reference containing the item, null if not found
	 */
	private Node<T> find(T item) {
		Node<T> curr = head;
		
		while (curr != null) {
			if (curr.data.equals(item)) {
				return curr;
			}
			curr = curr.next;
		}
		
		return null;
	}
	
	
	// ==================== Private inner Node class ====================
	/**
	 * Inner node class that implements generics only to be used
	 * 	by LinkedExtendedSet
	 * 
	 * @author NickR
	 *
	 * @param <E> - generic data type
	 */
	private class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
