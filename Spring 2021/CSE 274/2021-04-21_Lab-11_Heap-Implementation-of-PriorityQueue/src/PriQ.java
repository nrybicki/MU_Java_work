import java.util.Arrays;

// A priority queue of strings, implemented with a resizable array maxheap
// Since this is a max heap, the item with the highest priority will be the
// string that is lexicographically LAST
public class PriQ {
	private String[] heap;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * Constructs an empty priority queue with the specified initial capacity.
	 * 
	 * @param capacity initial capacity of the priority queue
	 */
	public PriQ(int capacity) {
		heap = new String[capacity + 1];
		size = 0;
		// Just to make it easy for us to debug
		heap[0] = "***NOT USED***";
	}

	/**
	 * Constructs an empty priority queue with default capacity.
	 */
	public PriQ() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs a priority queue from an array of strings. The initial capacity
	 * will be the number of strings in the array.
	 * 
	 * @param ary an array of strings that will be put in the priority queue. The
	 *            strings can be in any order, and this constructor will arrange
	 *            them to form a priority queue.
	 */
	public PriQ(String[] ary) {
		this(ary.length);

		for (int i = 0; i < ary.length; i++) {
			heap[i + 1] = ary[i];
		}
		size = ary.length;
		convertToMaxheap();
	}

	/**
	 * Adds a string to this priority queue. SHOULD MAKE USE OF one of the fixHeap
	 * helper methods. Recall that the algorithm we are using is to place the item
	 * after the last node, and then swap the new item upward until the item is in
	 * place.
	 * 
	 * @param s string to be added
	 */
	public void add(String s) {
		checkCapacity(); // first resize if necessary

		// call fixHeapUp() at some point
		size++;
		heap[size] = s;
		fixHeapUp(size);
	}

	/**
	 * Removes and returns the highest priority string in this priority queue (the
	 * string that is last alphabetically), or null if this priority queue is empty.
	 * Recall that the algorithm for fixing the heap is to put the last item of the
	 * heap into index 1, and then swap that item downward until it is in place.
	 * Call fixHeapDown
	 * 
	 * @return the highest priority string, or null if this priority queue is emtpy
	 */
	public String remove() {
		if (size == 0) {
			return null;
		}
		String str = heap[1];
		heap[1] = heap[size];
		fixHeapDown(1);
		heap[size] = null;
		size--;
		return str;
	}
/*
	/**
	 * Returns true if this priority queue is empty, and false otherwise
	 * 
	 * @return true if this priority queue is empty, and false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the size of this priority queue: the number of elements in it
	 * 
	 * @return the size of this priority queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Gets the highest priority string in this priority queue (the string that is
	 * first alphabetically), or null if this priority queue is empty
	 * 
	 * @return the highest priority string, or null if this priority queue is empty
	 */
	public String peek() {
		return heap[1];
	}

	/**
	 * Returns the INDEX of the first leaf in the heap, or -1 if the heap is empty.
	 * This does not need a loop (and should not use a loop). You can calculate this
	 * index with a formula based on the size of the heap. NORMALLY, a helper method
	 * like this would be private, but here it is public so that we can test it.
	 * 
	 * @return the index of the first leaf in the heap, or -1 if the heap is empty
	 */
	public int getIndexOfFirstLeaf() {
		if (size == 0) {
			return -1;
		}
		return 1 + size / 2;
	}

	/**
	 * Fixes a heap downward, beginning at the specified node. When this method is
	 * run, all the nodes in the subtree rooted at heap[index] index will form a
	 * maxheap. This algorithm ASSUMES: that the node's left subtree and right
	 * subtree are already maxheaps (we call these subtrees "semi-heaps") The
	 * algorithm is: if either child node has higher priority than the parent node,
	 * then swap the parent node downward with the child node that has highest
	 * priority. Repeat with the new location of that node.
	 * 
	 * @param index index where the downward fix should begin
	 */
	private void fixHeapDown(int index) {
		if (isLeaf(index)) {
			return;
		}
		
		if (heap[index].compareTo(heap[index * 2]) < 0 || heap[index].compareTo(heap[index * 2 + 1]) < 0) {
			// compare left and right children
			if (heap[index * 2].compareTo(heap[index * 2 + 1]) > 0) {
				String temp = heap[index];
				heap[index] = heap[index * 2];
				heap[index * 2] = temp;
				fixHeapDown(index * 2);
			} else {
				String temp = heap[index];
				heap[index] = heap[index * 2 + 1];
				heap[index * 2 + 1] = temp;
				fixHeapDown(index * 2 + 1);
			}
		}
	}
	
	// private helper method to determine if the given index is a leaf
	private boolean isLeaf(int index) {
		// the children of this index would be 2*index and 2*index + 1
		// so if index is more than half the heap size, there is no possible
		// way for it to have children, thus it is a leaf (index is also 
		// constrained to be less than the heap size)
		return (index <= size && index > size / 2);
	}

	/**
	 * Fixes a heap upward, beginning at the specified node, swapping it with the
	 * parent node if the parent node has lower priority.
	 * 
	 * @param index the index where the upward fix should begin
	 */
	private void fixHeapUp(int index) {
		// could be a loop, or can be done recursively without helper methods
		if (index == 1) {
			return;
		}
		
		if (heap[index].compareTo(heap[index / 2]) > 0) {
			String temp = heap[index];
			heap[index] = heap[index / 2];
			heap[index / 2] = temp;
		}
		fixHeapUp(index / 2);
	}

	/**
	 * Checks to see if the heap is full and, if so, doubles its capacity. Example:
	 * suppose the size of the heap is 10 (so the array's length is 11). The new
	 * capacity of the heap should become 20 (so the array's length is 21).
	 */
	private void checkCapacity() {
		if (size == heap.length - 1) {
			heap = Arrays.copyOf(heap, size * 2 + 1);
		}
	}

	/**
	 * Converts this priority queue's array to a maxheap. This is needed for the
	 * constructor that takes in an array of strings. The strategy used here should
	 * be the second strategy discussed in the notes and demos: Start at the bottom
	 * of the heap, and work backward until you encounter the first node that is NOT
	 * a leaf. Perform a fixheapDown starting at that node. Continue working
	 * backward, all the way to the root. In other words, this method should call
	 * fixHeapDown roughly size/2 times, and it should not call fixHeapUp at all.
	 * This only requires roughly 3 or 4 lines of code, because it can (and should)
	 * make use of other helper methods.
	 */
	private void convertToMaxheap() {
		for (int i = size / 2; i > 0; i--) {
			fixHeapDown(i);
		}
	}

	@Override
	public String toString() {
		return "PriQ [heap=" + Arrays.toString(heap) + ", size=" + size + "]";
	}

}
