import java.util.Arrays;

/**
 * An implementation of Set that uses a resizable array. Basically,
 * when the underlying array is full, and an add is attempted, a new
 * array will be created that has twice the capacity of the old array.
 * 
 * Although the resize operation is O(n), it only happens occasionally. 
 * So, most of the time, the add() operation is O(1), but occasionally, it is
 * O(n). We say that the "cost" of resizing is "amortized" (spread out) across
 * all operations, making the average time complexity of the add() operation O(1). 
 * 
 * @author Norm Krumpe
 *
 */


public class ResizableArraySet<T> implements SetInterface<T> {

    private T[] words;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty set with the specified
     * capacity.
     * @param capacity the initial capacity of the set
     */
    @SuppressWarnings("unchecked")
	public ResizableArraySet(int capacity) {
    	// JUST DO IT THIS WAY. LOOK UP THE PATTERN IF YOU FORGET
    	// If you want to ask why, set up a meeting with me
        words = (T[])(new Object[capacity]);
        size = 0;
    }

    /**
     * Constructs an empty set with the default
     * capacity.
     */
    public ResizableArraySet() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs a set containing the words in the given array.
     * The initial capacity of the set will be equal to the length of
     * the specified array (even if it contains duplicates)
     * @param words an array of words to be added
     */
    public ResizableArraySet(T[] wordsNew) {
        this(wordsNew.length);
        
        for (T s : wordsNew) {
            add(s);
        }
    }

    @Override
    public boolean add(T word) {
        if (contains(word)) {
            return false;
        }
        
        checkCapacity();
        words[size++] = word;
        return true;
    }
    
    /*
     * If the array is full, switch to a new array with
     * twice as many elements.
     */
    private void checkCapacity() {
        if (size == words.length) {
            words = Arrays.copyOf(words, 2 * words.length);
        }
    }

    /*
     * A useful helper method for any method
     * that needs to know the location of
     * a specified word.
     */
    private int indexOf(T word) {
        for (int i = 0; i < size; i++) {
            if (word.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T word) {
        return indexOf(word) != -1;
    }

    @Override
    public boolean remove(T word) {
        int loc = indexOf(word);
        if (loc == -1) {
            return false;
        }

        words[loc] = words[size - 1];
        words[size - 1] = null;
        size--;
        return true;
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
    public void clear() {
        for (int i = 0; i < size; i++) {
            words[i] = null;
        }
        size = 0;
    }
        
    @Override
    public T remove() {
        if (size == 0) {
            return null;
        } else {
            T result = words[size - 1];
            words[size - 1] = null;
            size--;     
            return result;
        }
    }
    
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = words[i];
        }
        return result;
    }
    
    /*
     * Returns a space-separated list of words in the set.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += words[i] + " ";
        }
        return result.trim();
    }
    
    /**
     * Computes the intersection of this set and another set (items common to both sets)
     * @param other another set
     * @return a set with all elements that are common to both sets.
     */
    public ResizableArraySet<T> intersection(ResizableArraySet<T> other) {
        // The intersection will contain no more than the number of elements
        // in the smaller set. this.size is sufficient for avoiding resizing,
        // but really, any capacity is fine since the set will resize as needed.
        // But it's nice to avoid resizing.
        ResizableArraySet<T> result = new ResizableArraySet<T>(this.size);
        
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.words[i])) {
                result.add(this.words[i]);
            }
        }
        
        return result;
    }
    
    /**
     * Computes the union of this set and another set (items in either or both sets)
     * @param other another set
     * @return a set with all elements that are in either or both sets.
     */
    public ResizableArraySet<T> union(ResizableArraySet<T> other) {
        // The union will contain no more than the total number of elements
        // in both sets. this.size + other.size is sufficient for avoiding resizing,
        // but really, any capacity is fine since the set will resize as needed.
        // But it's nice to avoid resizing.
        ResizableArraySet<T> result = new ResizableArraySet<T>(this.size + other.size);
        
        // Add the items from this set
        for (int i = 0; i < this.size; i++) {
            result.add(this.words[i]);
        }
        // Add the items from the other set
        for (int i = 0; i < other.size; i++) {
            result.add(other.words[i]);
        }
        
        return result;
    }

}
