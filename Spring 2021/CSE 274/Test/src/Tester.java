import java.awt.Point;
import java.util.*;

public class Tester {
	
	static private Random rnd = new Random();
	
	public static void main(String[] args) {
		
		Point a = new Point(5, 12);
		Point b = new Point(3, 0);
		Point c = new Point(10, 11);
		Point d = new Point(4, 7);

		Comparator<Point> cmp = new Comparator<Point>() {
		   public int compare(Point p1, Point p2) {
		      return p2.y - p1.y;
		   }
		};

		PriorityQueue<Point> q= new PriorityQueue<Point>(cmp);
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);

		while (!q.isEmpty()) {
		   System.out.println(q.remove());
		}
		
		
		
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String passwordGen() {
		String str = "", chars = "x12fIJYe%OZ^PFGQE9gjyzUHMNV0Xi@h3klt4&v#$w5KLu6CbcadWD8RST7*AB";
		
		for (int i = 0; i < (rnd.nextInt(10) + 15); i++) {
			if (rnd.nextInt(100) % 2 == 0) {
				str += chars.charAt( rnd.nextInt(chars.length()) );
			} else {
				str = chars.charAt( rnd.nextInt(chars.length()) ) + str;
			}
		}
		return str;
	}
	
}
