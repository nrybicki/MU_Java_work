import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		// Things to test for:
		// Does a new bag have size 0
		WordBag b = new WordBag(7);
		System.out.println("new bag size should be 0? " + b.size());
		
		// Does contains work before and after adding an element
		System.out.println("before adding cat, contains should be false: " + b.contains("cat"));
		System.out.println("adding cat should be true: " + b.add("cat"));
		System.out.println("bag contents should be cat: " + b);
		System.out.println("after adding cat, contains should be true: " + b.contains("cat"));
		
		// Successful add should cause the size to increase
		System.out.println("bag size should be 1: " + b.size());
		
		System.out.println("adding dog should be true: " + b.add("dog"));
		System.out.println("bag size should be 2: " + b.size());
		
		System.out.println("adding dog should be true: " + b.add("dog"));
		System.out.println("bag size should be 3: " + b.size());
		
		for (int i = 4; i < 8; i++) {
			System.out.println("adding salamander should be true: " + b.add("salamander"));
			System.out.println("bag size should be " + i + ": " + b.size());
		}
		
		// Unsuccessful add should not change the size
		System.out.println("adding goat should be false: " + b.add("goat"));
		
		// If you add 3 items to an empty bag, toArray() should return an array
		//   of size 3.
		WordBag bag = new WordBag();
		System.out.println("size of new bag should be 0: " + bag.size());
		
		for (int i = 0; i < 3; i++) {
			System.out.println("adding tomato should be true: " + bag.add("tomato"));
			System.out.println("size of bag should be " + (i+1) + ": " + bag.size());
		}
		
		System.out.println("bag toArray should be array of size 3: " + Arrays.toString(bag.toArray()));
		
		// Removing a particular item should remove only one instance
		System.out.println("bag size should be 3: " + bag.size());
		System.out.println("removing tomato specifically should return true: " + bag.remove("tomato"));
		System.out.println("the bag should still have two tomatoes in it: " + bag.toString());
		System.out.println("bag size should now be 2: " + bag.size());
		
		// Successful remove should cause the size to decrease
		System.out.println("remove should return a random item: " + bag.remove());
		System.out.println("bag size should now be 1: " + bag.size());
		System.out.println("remove should return a random item: " + bag.remove());
		System.out.println("bag size should now be 0: " + bag.size());
		System.out.println("remove should return null since the bag is empty: " + bag.remove());
		
		// Unsuccessful remove should not change the size
		System.out.println("contents of bag b are: " + b.toString());
		System.out.println("removing cow should return false: " + b.remove("cow"));
		System.out.println("bag size should still be 7: " + b.size());
		
		// Check that the bag does not contain null value after removing specific item
		System.out.println("removing dog should return true: " + b.remove("dog"));
		System.out.println("the contents of the bag b are now: " + b.toString());
		System.out.println("removing cat should return true: " + b.remove("cat"));
		System.out.println("the contents of the bag b are now: " + b.toString());
		
		// Clear should change the size to 0. toArray() should then return empty array.
		System.out.println("size of bag b should be 5: " + b.size());
		System.out.println("the contents of bag b are: " + Arrays.toString(b.toArray()));
		b.clear();
		System.out.println("size of bag b should be 0: " + b.size());
		System.out.println("bag b isEmpty should be true: " + b.isEmpty());
		System.out.println("the bag b should be empty: " + Arrays.toString(b.toArray()));
		
		
		
		// Edge cases:
		// If you try removing from an empty bag, does the size stay at 0?
		System.out.println("removing something from bag b should return null: " + b.remove());
		System.out.println("size should be 0: " + b.size());
		System.out.println("removing dog from bag b should return false: " + b.remove("dog"));
		System.out.println("size should be 0: " + b.size());
		
		
		WordBag full = new WordBag(3);
		for (int i = 0; i < 3; i++) {
			System.out.println("adding pie should be true: " + full.add("pie"));
			System.out.println("size should be " + (i+1) + ": " + full.size());
		}
		// If you try adding to a full bag, does the size stay at capacity?
		System.out.println("adding vegetables should be false: " + full.add("vegetables"));
		System.out.println("size should be 3: " + full.size());
		
	}

}























