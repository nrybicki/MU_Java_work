
public class Tester {
	
	public static void main(String[] args) {
		// prob 1
		Node head = new Node('A');
		head.next = new Node('B');
		
		// prob 2
		head.next.next = new Node('Z');
		System.out.println(head.next.next.data);
		
		// prob 3 - squeezing in F at the beginning
		Node temp = new Node('F');
		temp.next = head;
		head = temp;
		
		System.out.println(head.data);
		System.out.println(head.next.data);
		
		// prob 4 - remove the third node
		head.next.next = head.next.next.next;
		
		// this line would cause an endless loop
		// head.next.next.next = head;
		
		// prob 5 - print the data in all the nodes
		System.out.print("FAZ? ");
		printAll(head);
		
		// prob 6 - print the data in just the last node
		System.out.print("Z? ");
		printLast(head);
		
		// prob 7 - create a chain of nodes with the data from an inputted string
		String word = "HOUSE";
		System.out.print("HOUSE? ");
		printAll(makeChain(word));
		
	} // end main method
	
	// prints the data in all nodes in a chain beginning with the start node
	public static void printAll(Node start) {
		Node curr = start;
		while (curr != null) {
			System.out.print(curr.data);
			curr = curr.next;
		}
		System.out.println();
	}
	
	// prints the data only in the last node
	public static void printLast(Node start) {
		Node curr = start;
		while (curr.next != null) {
			curr = curr.next;
		} // if we exit the loop, we have reached the last node
		System.out.println(curr.data);
	}
	
	// takes a string, turns it into a chain of node and returns a node
	public static Node makeChain(String word) {
		Node start = new Node(word.charAt(0));
		Node end = start; // start and end point to node with first letter
		for (int i = 1; i < word.length(); i++) {
			// make a node from the current letter
			Node temp = new Node(word.charAt(i));
			end.next = temp;
			end = end.next;
			
		}
		return start;
	}
	
}
