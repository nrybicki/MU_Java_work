/**
 * Queue implementation using the LinkedDeque data structure. First-In-First-Out
 * data structure, add things to the back of the queue and remove and peek from
 * the front of the queue
 * 
 * @author Nick Rybicki
 *
 * @param <T> generic object
 */
public class DequeQueue<T> implements QueueInterface<T> {
	// ==================== Properties ====================
	private LinkedDeque<T> queue;

	// ==================== Constructors ====================
	/**
	 * No-parameter constructor that initializes the queue
	 */
	public DequeQueue() {
		queue = new LinkedDeque<T>();
	}

	// ==================== Methods ====================
	@Override
	public void add(T newEntry) {
		queue.addToBack(newEntry);
	}

	@Override
	public T remove() {
		return queue.removeFront();
	}

	@Override
	public T peek() {
		return queue.getFront();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void clear() {
		queue.clear();
	}

}
