/**
 * A basic 3D point with x, y, and z coordinates.
 * @author Norm Krumpe
 *
 */
public class Point3D implements Comparable<Point3D> {
    
    private int x;
    private int y;
    private int z;
    
    /**
     * Constructs a new point with the specified coordinates
     * @param x the x-coordinate of this point
     * @param y the y-coordinate of this point
     * @param z the z-coordinate of this point
     */
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

	@Override
	public int compareTo(Point3D o) {
		Point3D other = (Point3D) o;
		if (this.x != other.x) {
			return this.x - other.x;
		} else if (this.y != other.y) {
			return this.y - other.y;
		} else if (this.z != other.z) {
			return this.z - other.z;
		} else { // if reach here, points are equal
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Point3D))
			return false;
		Point3D other = (Point3D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
}
