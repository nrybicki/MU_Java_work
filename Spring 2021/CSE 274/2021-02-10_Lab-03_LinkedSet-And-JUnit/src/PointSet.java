import java.awt.Point;

/**
 * An interface for a set of points. The set allows items to be added, but
 * prevents duplicates from being added. There should be no expectation that
 * the order of elements will be maintained.
 * @author Norm Krumpe
 *
 */

public interface PointSet {

    /**
     * Adds the specified point to this set if it does not already exist
     * @param p the point to be added
     * @return true if the point was successfully added, and false otherwise.
     */
    public boolean add(Point p);
    
    /**
     * Removes the specified point from this set
     * @param p the point to be removed
     * @return true if the point was successfully removed, and false otherwise.
     */
    public boolean remove(Point p);
    
    /**
     * Checks whether specified point is in this set
     * @param p the point to be searched for
     * @return true if the point was found, and false otherwise.
     */
    public boolean contains(Point p);
    
    /**
     * Gets the size of this set
     * @return the number of elements in this set
     */
    public int size();
    
    /**
     * Returns whether this set is empty
     * @return true if this set is empty, and false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Removes all elements from this set
     */
    public void clear();
    
    /**
     * Gets an array containing all the points in this set
     * @return an array containing all the points in this set
     */
    public Point[] toArray();
}
