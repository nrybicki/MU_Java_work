/**
 * An interface for a set. Clients using this set do not have any
 * expectations about order of elements.
 * 
 * @author Norm Krumpe
 *
 */

public interface SetInterface {
    
    
    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set
     */
    public int size();
    
    /**
     * Returns true if this set contains no elements, and false otherwise.
     * @return true if this set contains no elements, and false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Adds the specified string to this set.
     * @param s the string to be added
     * @return true if the add was successful
     */
    public boolean add(String s);
    
    /**
     * Removes one unspecified entry from this set, if possible.
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public String remove();
    
    /**
     * Removes the specified string from this set.
     * @param s the string to be removed
     * @return true if the remove was successful
     */
    public boolean remove(String s);
    
    
    /**
     * Removes all strings from this set.
     */
    public void clear();    
    
    /**
     * Determines whether the specified string is in this set.
     * @param s the string whose presence is to be tested
     * @return true if the string is in this set
     */
    public boolean contains(String s);

    
    /**
     * Returns an array containing all of the strings in this set.  If the set
     * contains no elements, an empty array is returned.
     * @return an array of all the elements in this set
     */
    public String[] toArray();
    
}