import java.util.NoSuchElementException;

/**
 * A doubly-linked node implementation of a Deque, or double-ended queue. Allows
 * client to add, remove and get items from both ends of the queue.
 * 
 * @author Nick Rybicki
 *
 * @param <T> generic object
 */
public class LinkedDeque<T> implements DequeInterface<T> {
	// ==================== Properties ====================
	private Node<T> firstNode;

	// ==================== Constructors ====================
	/**
	 * Empty constructor that initializes firstNode as null
	 */
	public LinkedDeque() {
		firstNode = null;
	}

	// ==================== Methods ====================
	@Override
	public void addToFront(T item) {
		Node<T> temp = new Node<>(item);
		if (isEmpty()) {
			firstNode = temp;
			firstNode.next = firstNode;
			firstNode.previous = firstNode;
		} else {
			temp.next = firstNode;
			temp.previous = firstNode.previous;
			firstNode.previous = temp;
			temp.previous.next = temp;
			firstNode = temp;
		}
	}

	@Override
	public void addToBack(T item) {
		Node<T> temp = new Node<>(item);
		if (isEmpty()) {
			firstNode = temp;
			firstNode.next = firstNode;
			firstNode.previous = firstNode;
		} else {
			temp.next = firstNode;
			temp.previous = firstNode.previous;
			firstNode.previous = temp;
			temp.previous.next = temp;
		}
	}

	@Override
	public T removeFront() {
		// if deque is empty, throw NoSuchElementException
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = firstNode.data;

		if (firstNode.next.equals(firstNode)) {
			firstNode = null;
		} else {
			firstNode.next.previous = firstNode.previous;
			firstNode.previous.next = firstNode.next;
			firstNode = firstNode.next;
		}
		
		return data;
	}

	@Override
	public T removeBack() {
		// if deque is empty, throw NoSuchElementException
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = firstNode.previous.data;
		
		if (firstNode.next.equals(firstNode)) {
			firstNode = null;
		} else {
			firstNode.previous.previous.next = firstNode;
			firstNode.previous = firstNode.previous.previous;
		}

		return data;
	}

	@Override
	public T getFront() {
		// if deque is empty, throw NoSuchElementException
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return firstNode.data;
	}

	@Override
	public T getBack() {
		// if deque is empty, throw NoSuchElementException
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return firstNode.previous.data;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
	}
	
	/**
	 * Simple toString method that returns a string with the deque printed
	 * front to back and back to front
	 */
	public String toString() {
		String str = "FRONT-TO-BACK: [";
		Node<T> curr = firstNode;

		if (!isEmpty()) {
			do {
				str +=curr.data + " ";
				curr = curr.next;
			} while (curr != firstNode);
		}

		str = str.trim() + "], BACK-TO-FRONT: [";
		if (!isEmpty()) {
			curr = firstNode.previous;
			do {
				str += curr.data + " ";
				curr = curr.previous;
			} while (curr != firstNode.previous);
		}

		return str.trim() + "]";
	}

	// ==================== Inner Node Class ====================
	/**
	 * Doubly-linked node class that has three instance variables, data, and two references
	 * to previous and next nodes, and one constructor, initializing the data variable and
	 * setting next and previous nodes to null
	 * 
	 * @author Nick Rybicki
	 *
	 * @param <E> generic object
	 */
	private class Node<E> {
		private E data;
		private Node<E> previous;
		private Node<E> next;

		private Node(E data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}

}
