
public class Tester {
	
	public static void main(String[] args) {
		
		LinkedBag b = new LinkedBag();
		for (int i = 1; i <= 10; i++) {
			b.add(2 * i);
		}
		
		System.out.println( b.remove() + " (20?)"); // 20
		System.out.println(b);
		System.out.println( b.remove(6) + " (true?)"); // true
		System.out.println(b); // 16 14 12 10 8 18 4 2
		
		
		
		
//		LinkedBag bag = new LinkedBag();
//		bag.add(4); // head -> 4
//		bag.add(9);	// head -> 9 -> 4
//		bag.add(5); // head -> 5 -> 9 -> 4
//		bag.add(1); 
//		bag.add(8); 
//		
//		System.out.println(bag); // 8 1 5 9 4
//		System.out.println(bag.size()); // 5
		
	}
	
}
