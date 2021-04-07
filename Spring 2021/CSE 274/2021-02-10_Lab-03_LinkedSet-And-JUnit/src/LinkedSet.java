import java.awt.Point;

/**
 * A linked-node implementation of set of point objects
 * 
 * @author NickR
 *
 */
public class LinkedSet implements PointSet {
	
	// ==================== Properties ====================
	private Node head;
	private int size;
	
	// ==================== Constructors ====================
	/**
	 * Constructs an empty set
	 */
	public LinkedSet() {
		this.head = null;
		this.size = 0;
	}
	
	// ==================== Methods ====================
	/**
	 * Helper method that looks for a point and returns the first nod that contains
	 * 	the point, or null if it's not found
	 * 
	 * @param p - point object to be searched for
	 * @return the Node that contains the point object, null if not found
	 */
	private Node find(Point p) {
		Node curr = head;
		
		while (curr != null) {
			if (curr.data.equals(p))
				return curr;
			
			curr = curr.next;
		}
		
		// p not found in bag
		return null;
	}
	
	@Override
	public boolean add(Point p) {
		// call find() and look at result
		// it it's null, go ahead and add and return true
		Node foundAt = find(p);
		
		if (foundAt == null) {
			Node temp = new Node(p);
			temp.next = head;
			head = temp;
			size++;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean remove(Point p) {
		// call find() and look at result
		// if null return false, else rewire and return false
		Node foundAt = find(p);
		
		if (foundAt == null) 
			return false;
		
		foundAt.data = head.data;
		head = head.next;
		size--;
		
		return true;
	}

	@Override
	public boolean contains(Point p) {
		if (find(p) == null)
			return false;
		return true;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public Point[] toArray() {
		Point[] points = new Point[size];
		
		Node curr = head;
		for (int i = 0; curr != null; i++) {
			points[i] = curr.data;
			curr = curr.next;
		}
		
		return points;
	}
	
	/**
	 * Returns a string containing the points in the set.
	 * This is ONLY FOR YOU THE PROGRAMMER
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
	
	
	
	/*
	 * private inner Node class
	 */
	private class Node {
		private Point data;
		private Node next;
		
		private Node(Point data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
} // end LinkedList













