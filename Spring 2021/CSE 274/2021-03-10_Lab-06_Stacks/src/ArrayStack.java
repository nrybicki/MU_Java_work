import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A resizable-array based stack.
 * 
 * @author Norm Krumpe
 *
 * @param <T> the type of items to store in the stack. Any object type is valid.
 */

////////////////////////////////////////////////////////////////////
//
// Implement the methods below. Do not add any additional methods.
//
///////////////////////////////////////////////////////////////////
public class ArrayStack<T> implements StackInterface<T> {

	private int topIndex;
	private T[] stackData;

	/**
	 * Constructs a new stack with underlying array of length 10
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.topIndex = -1;
		this.stackData = (T[])new Object[10];
	}

	// Resize if stack is full
	@Override
	public void push(T item) {
		// resize if needed
		if (this.topIndex == this.stackData.length - 1) {
			this.stackData = Arrays.copyOf(this.stackData, this.stackData.length * 2);
		}
		
		topIndex++;
		this.stackData[topIndex] = item;
	}

	@Override
	public T pop() {
		T ret = this.peek();
		
		// now remove
		this.stackData[topIndex] = null; // memory management: gets rid of unneeded object references 
		this.topIndex--;
		
		return ret;
	}

	@Override
	public T peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.stackData[this.topIndex];
	}

	@Override
	public boolean isEmpty() {
		return this.topIndex == -1;
	}

	@Override
	public void clear() {
		for (int i = 0; i <= this.topIndex; i++) {
			this.stackData[i] = null;
		}
		this.topIndex = -1;
	}

	// A method for making testing easier
	public void showStack() {
		System.out.print("Top: ");

		// loop to print all items from top to bottom
		for (int i = this.topIndex; i >= 0; i--) {
			System.out.print(this.stackData[i] + " ");
		}

		System.out.println();
	}

}
