
public class Tester {

	public static void main(String[] args) {
//		String[] words = {"boy", "apple", "cat", "house", "zoo", "run", "pizza"};
//		PriQ pq = new PriQ(words);
		
		
		PriQ pq = new PriQ();
		System.out.println(pq);
		
		pq.add("eggs");
		System.out.println(pq); // eggs
		
		pq.add("garlic");
		System.out.println(pq); // garlic eggs
		
		pq.add("fish");
		System.out.println(pq); // garlic eggs fish
		
		pq.add("tree");
		System.out.println(pq); // tree garlic fish eggs
		
		pq.add("game");
		System.out.println(pq); // tree garlic fish eggs game
		
		pq.add("gate");
		System.out.println(pq); // tree garlic gate eggs game fish
		
		pq.add("apple");
		System.out.println(pq); // tree garlic gate eggs game fish apple
		
		
		System.out.println(pq.remove()); // tree
		System.out.println(pq); // gate garlic fish eggs game apple
		
		System.out.println(pq.remove()); // gate
		System.out.println(pq); // garlic game fish eggs apple
		
	}

}
