import java.util.Arrays;

// What's so special about a bag?
// 1. Easy abstract data type to talk about, and one of the easiest to implement
// 2. Has simple features: allows duplicates, order is unimportant

// Also: what is an ABSTRACT data type?
//			Talking about a collection at a "high level".
//		 what behavior do we expect from a bag?
//			How would a client want to use the bag?
//		 how is it different from a data structure?
//			The actual implementation of the ADT. It's where the programmer
//			decides how to make the logic of the ADT happen.

public class BagTester {
	
	public static void main(String[] args) {
		// Demonstrates how a Bag works, from the client perspective
		WordBag bag = new WordBag(10); // 10 is the capacity; once full, can no longer add items
		System.out.println(bag.size());	// 0
		
		System.out.println(bag.add("cat"));	//true
		bag.add("cat");
		bag.add("dog");
		System.out.println(bag.size());	// 3
		
		String[] animals = bag.toArray();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(bag.add("salamander")); 
		}
		
		System.out.println(bag.size()); // 8
		System.out.println(bag); // cat cat dog salamander salamander salamander salamander salamander
		System.out.println(Arrays.toString(animals));
		
		System.out.println(bag.contains("salamander")); // true
		
		String result = bag.remove(); // removes and returns some element
		System.out.println(result); // salamander
		
		bag.remove("cat"); // returns true
		System.out.println(bag); // salamander cat dog salamander salamander salamander
		
		bag.remove("cat"); // returns true
		System.out.println(bag); // salamander salamander dog salamander salamander
		
		bag.clear(); // removes everything
		result = bag.remove();
		System.out.println(result); // null
		System.out.println(bag.size()); // 0
		
	}
	
}
