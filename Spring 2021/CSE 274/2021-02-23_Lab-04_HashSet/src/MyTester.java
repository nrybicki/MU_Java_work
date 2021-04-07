import java.util.Arrays;

public class MyTester {
	
	public static void main(String[] args) {
		
		String[] myWords = {"computer", "light", "coaster", "LIGHT", "COMPUTER", "temp", "char", "jack", "star", "pineapple", "train"};
		HashSet s = new HashSet(myWords);
		System.out.println(s);
		
		System.out.println(Arrays.toString(s.toArray()));
		
//		HashSet s = new HashSet(7);
//		System.out.println(s.add("cat")); // true (and i think it's at index 10)
//		System.out.println(s.add("encyclopedia")); // true (and i think it's at index 0)
//		System.out.println(s.add("cat")); // false
//		s.add("dog");
//		s.add("fish");
//		s.add("car");
//		s.add("truck");
//		s.add("apple");
//		s.add("pear");
//		
//		for (int i = 0; i < 100; i++) {
//			s.add("" + i);
//		}
//		
//		System.out.println(s);
//		
//		System.out.println(s.contains("cat"));
//		System.out.println(s.contains("pineapple"));
//		System.out.println(s.contains("apple"));
		
		// where in my array will it end up?
//		System.out.println("cat".hashCode() % 11);
		
	}
	
}
