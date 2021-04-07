// A linked-node implementation of bag

/**
 * @author NickR
 *
 */
public class LinkedBag {
	
	private Node head;
	private int size;
	
	/**
	 * Constructs an empty bag
	 */
	public LinkedBag() {
		this.head = null;
		this.size = 0;
	}
	/**
	 * Adds the number to the bag, returning whether it was successful
	 * 
	 * @param num - the number to be added
	 * @return true if successful, false otherwise
	 */
	public boolean add(int num) {
		// in this case, this code should work even if list is empty
		Node temp = new Node(num);
		temp.next = head;
		head = temp;
		size++;
		return true;
	}
	
	/**
	 * Clears the bag
	 */
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Returns the value for size
	 * 
	 * @return the size of the bag
	 */
	public int size() {
		return this.size;
	}
	
	public int[] toArray() {
		int[] result = new int[size];
		
		Node curr = head;
		int i = 0;
		while (curr != null) {
			result[i++] = curr.data;
			curr = curr.next;
		}
		return result;
	}
	
	/**
	 * Returns a space-separated list of numbers in the bag starting at head
	 */
	public String toString() {
		String str = "";
		
		Node curr = head;
		while (curr != null) {
			str += curr.data + " ";
			curr = curr.next;
		}
		
		return str.trim();
	}
	
	/**
	 * Removes an arbitrary element (based on client pov), but specifically choose the head
	 * 	element because it is easiest to access
	 * 
	 * @return the item that is removed
	 */
	public int remove() {
		if (size == 0)
			throw new IllegalStateException("bag is empty!");
		
		int result = head.data;
		head = head.next;
		size--;
		return result;
	}
	
	/**
	 * Removes a specified value num, returns true if successful, false otherwise
	 * 
	 * @param num - the element to be removed
	 * @return true if element is in the bag, false otherwise
	 */
	public boolean remove(int num) {
		Node foundAt = find(num);
		
		if (foundAt == null)
			return false;
		
		foundAt.data = head.data;
		head = head.next;
		size--;
		
		return true;
	}
	
	/**
	 * Checks if a particular value is in the bag
	 * 
	 * @returns true if found, false otherwise
	 */
	public boolean contains(int num) {
		return find(num) != null;
	}
	
	/**
	 * Private helper method for remove(n) and contains() to find the first occurrence
	 * 	of a value
	 * 
	 * @param num - the value to be searched for
	 * @return the first node that contains the value
	 */
	private Node find(int num) {
		Node curr = head;
		
		while (curr != null) {
			if (curr.data == num)
				return curr;
			
			curr = curr.next;
		}
		
		// num not found in bag
		return null;
	}
	
	
	
	/* Inner node class:
	 * Inner because it only exists to support LinkedBag
	 * private prevents other classes from using it. BUT
	 * the outer class LinkedBag can freely access.
	 */
	private class Node {
		 private int data;
		 private Node next;
		 
		 private Node(int data) {
			 this.data = data;
			 this.next = null;
		 }
	}
	
} // end of LinkedBag class
