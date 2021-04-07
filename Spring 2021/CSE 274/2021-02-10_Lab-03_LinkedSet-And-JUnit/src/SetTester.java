import java.awt.Point;
import java.util.Arrays;

public class SetTester {
	
	public static void main(String[] args) {
		System.out.println("Test add");
		LinkedSet s = new LinkedSet();
		System.out.println(s.add(new Point(2, 3))); // true
		System.out.println(s.add(new Point(2, 3))); // false
		System.out.println(s.add(new Point(1, 5))); // true
		System.out.println(s); // (1, 5) (2, 3) formatted a bit differently
		
		System.out.println(s.size()); // 2
		System.out.println(s.isEmpty()); // false
		System.out.println(s.contains(new Point(1, 5))); // true
		
		System.out.println("\nTest toArray");
		System.out.println(Arrays.toString(s.toArray()));
		Point[] points = s.toArray();
		for (Point p : points)
			System.out.println("(" + p.getX() + ", " + p.getY() + ")");
		
		System.out.println("\nTest remove");
		System.out.println(s.remove(new Point(1, 5))); // true
		System.out.println(s.remove(new Point(1, 1))); // false
		System.out.println(s.contains(new Point(1, 5))); // false
		System.out.println(s.size()); // 1
		System.out.println(s); // (2, 3)
		System.out.println(s.remove(new Point(2, 3))); // true
		System.out.println(s.isEmpty()); // true
		System.out.println(s.remove(new Point(2, 4))); // false
		
		
		System.out.println("\nTest clear and isEmpty");
		s.clear();
		System.out.println(s.size()); // 0
		System.out.println(s.isEmpty()); // true
		System.out.println(s.toArray().length); // 0
		System.out.println("the set contains: " + s); // nothing
		
	}
	
}
