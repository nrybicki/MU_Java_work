/**
 * Stack implementation using the LinkedDeque data structure. Last-In-First-Out
 * data structure, add things to the top of the stack and remove and peek from
 * the top of the stack
 * 
 * @author Nick Rybicki
 *
 * @param <T> generic object
 */
public class DequeStack<T> implements StackInterface<T> {
	// ==================== Properties ====================
	private LinkedDeque<T> deque;

	// ==================== Constructors ====================
	/**
	 * No-parameter constructor that simply initializes the stack
	 */
	public DequeStack() {
		deque = new LinkedDeque<T>();
	}

	// ==================== Methods ====================
	@Override
	public void push(T item) {
		deque.addToBack(item);
	}

	@Override
	public T pop() {
		return deque.removeBack();
	}

	@Override
	public T peek() {
		return deque.getBack();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public void clear() {
		deque.clear();
	}

}
