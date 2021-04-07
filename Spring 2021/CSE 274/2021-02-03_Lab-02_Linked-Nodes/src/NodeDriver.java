/*
 * YOUR INFORMATION HERE:
 * Name: Nicholas Rybicki
 * Lab2
 * Practice working with a Node class.
 * Before writing the code below, we need to write our own Node class.
 * We will make it a node where the data is an int.
 */

public class NodeDriver {

	public static void main(String[] args) {
		// Do testing of your own here. It's still a reliable way
		// to test as you go. But once you think a method is
		// complete, check the JUnit tester to see if it passes.
		// Test dataToString
		System.out.println("Testing dataToString");
		Node n = new Node(10);
		n.next = new Node(15);
		System.out.println("should be 10 15: " + dataToString(n));
		
		// Test buildChain
		System.out.println("\nTesting buildChain");
		int[] data = {4, 5, 6, 7};
		Node myChain = buildChain(data);
		System.out.println("should be 4: " + myChain.data); // 4
		System.out.println("should be 4 5 6 7: " + dataToString(myChain)); // 4 5 6 7
		
		// Test sum
		System.out.println("\nTesting sum");
		System.out.println("sum should be 22: " + sum(myChain));
		System.out.println("sum should be 18: " + sum(myChain.next));
		
		// Test removeLast
		System.out.println("\nTesting removeLast");
		removeLast(myChain);
		System.out.println("should now be 4 5 6: " + dataToString(myChain)); // 4 5 6
		removeLast(myChain);
		System.out.println("should now be 4 5: " + dataToString(myChain)); // 4 5
		removeLast(myChain);
		
		// Test removeFirst
		System.out.println("\nTesting removeFirst");
		myChain = buildChain(data);
		myChain = removeFirst(myChain);
		System.out.println("should now be 5 6 7: " + dataToString(myChain));
		myChain = removeFirst(myChain);
		System.out.println("should now be 6 7: " + dataToString(myChain));
		
		// Test foundPair
		System.out.println("\nTesting foundPair");
		int[] pair = {4, 5, 6, 6, 7};
		Node noPair = buildChain(data);
		Node yesPair = buildChain(pair);
		System.out.println("pair will be true: " + foundPair(yesPair));
		System.out.println("data will be false: " + foundPair(noPair));
		
		// Test swapEnds
		System.out.println("\nTesting swapEnds");
		myChain = buildChain(data);
		swapEnds(myChain);
		System.out.println("should be 7 5 6 4: " + dataToString(myChain));
		swapEnds(myChain);
		System.out.println("should be 4 5 6 7: " + dataToString(myChain));
		
		// Test getLast
		System.out.println("\nTesting getLast");
		System.out.println("should get 7: " + getLast(myChain));
		swapEnds(myChain);
		System.out.println("should get 4: " + getLast(myChain));
		
		// Test sumAfter10
		System.out.println("\nTesting sumAfter10");
		int[] ten = {10, 1, 4, 10, 9, 10, 10};
		Node tenChain = buildChain(ten);
		System.out.println("sumAfter10 is 20: " + sumAfter10(tenChain));
		
		// Test removeFirstOccurrence
		System.out.println("\nTesting removeFirstOccurrence");
		int[] remove = {1, 2, 3, 4, 5};
		Node removeChain = buildChain(remove);
		removeChain = removeFirstOccurrence(removeChain, 3);
		System.out.println("should be 1 2 4 5: " + dataToString(removeChain));
		
		// Test getFrequency
		System.out.println("\nTesting getFrequency");
		int[] repeats = {1, 5, 3, 12, 12, 1, 7, 12};
		Node repeatsChain = buildChain(repeats);
		System.out.println("frequency of 12 is 3: " + getFrequency(repeatsChain, 12));
		
		// Test append
		System.out.println("\nTesting append");
		int[] oneData = {1, 2, 3}, twoData = {4, 5, 6};
		Node one = buildChain(oneData), two = buildChain(twoData);
		append(one, two);
		System.out.println("should get 1 2 3 4 5 6: " + dataToString(one));
		
	}
	
	
	/*
	 * Creates a node from the specified non-empty array of
	 * data, where the head node will contain the data at index 0.
	 * Returns the head of the chain of nodes
	 */
	public static Node buildChain(int[] nums) {
		Node start = null;
		
		// Loop to chain together all the nodes in nums
		for (int i = nums.length - 1; i >= 0; i--) {
			Node temp = new Node(nums[i]);
			temp.next = start;
			start = temp;
		}
		
		return start;
	}
	
	/*
	 * Returns a String containing all the data in a
	 * chain of nodes starting at the specified node.
	 * The data is space-separated, with no leading or
	 * trailing spaces.
	 */
	public static String dataToString(Node start) {
		String result = "";
		
		// loop through all nodes, grabbing data until I
		//	reach the end
		Node curr = start;
		while (curr != null) {
			result += curr.data + " ";
			curr = curr.next;
		}
		
		return result.trim();
	}
	
	/*
	 * Returns the sum of the data in a non-empty chain of nodes
	 * beginning at the specified node.
	 */
	public static int sum(Node start) {
		int sum = 0;
		
		// loop through nodes and sum each data
		Node curr = start;
		while (curr != null) {
			sum += curr.data;
			curr = curr.next;
		}
		
		return sum;
	}
	
	/*
	 * Modifies a non-empty chain of nodes by swapping the data
	 * in the first and last nodes. This does NOT rewire nodes
	 * but just changes the data.
	 */
	public static void swapEnds(Node start) {
		int first = start.data, last;
		Node curr = start;
		
		while (curr.next != null)
			curr = curr.next;
		
		last = curr.data;
		
		curr.data = first;
		start.data = last;
	}
	
	/*
	 * Returns the number of Nodes that the key appears
	 * as data in the chain of nodes beginning at the specified
	 * start node.
	 */
	public static int getFrequency(Node start, int key) {
		int ct = 0;
		Node curr = start;
		
		while (curr != null) {
			if (curr.data == key)
				ct++;
			curr = curr.next;
		}
		
		return ct;
	}
	
	/*
	 * Appends the second chain of linked nodes to the end
	 * of the first chain of linked nodes. For example,
	 * if first were: 3, 4, 5, and second were 8, 4, 9,
	 * then at the end of this method, first will be 3, 4, 5, 8, 4, 9
	 * Assume each chain contains at least one node.
	 */
	public static void append(Node first, Node second) {
		Node curr = first;
		
		while (curr.next != null)
			curr = curr.next;
		
		curr.next = second;
	}
	
	/*
	 * Gets the data in the last node of a chain of nodes
	 */
	public static int getLast(Node start) {
		Node curr = start;
		
		while (curr.next != null)
			curr = curr.next;
		
		return curr.data;
	}
	
	/*
	 * Removes the last node of a chain of nodes. Assume
	 * that the chain contains at least 2 nodes.
	 */
	public static void removeLast(Node start) {
		Node curr = start;
		
		while (curr.next.next != null) 
			curr = curr.next;
		
		curr.next = null;
	}
	
	/*
	 * Removes the first node of a non-empty chain of nodes. 
	 * NOTE: this will change the object that start refers to,
	 * but start is just a parameter variable, it is necessary to 
	 * RETURN the reference to the new starting node.
	 * Generally speaking when we are writing code that changes
	 * what the starting node points to, we will need to treat
	 * that in a special way.
	 */
	public static Node removeFirst(Node start) {
		return start.next;
	}
	
	/*
	 * Given a non-empty chain of nodes, compute the sum
	 * of all values that appear immediately after a 10.
	 * For example:
	 * if the chain were 10, 7, 5, 10, 8, 10 then return 15 (7 + 8)
	 * if the chain were 10, 10, 10, 10 then return 30 (10 + 10 + 10)
	 */
	public static int sumAfter10(Node start) {
		int sum = 0;
		Node curr = start;
		
		while (curr.next != null) {
			if (curr.data == 10)
				sum += curr.next.data;
			curr = curr.next;
		}
		
		return sum;
	}
	
	/*
	 * Given a non-empty chain of nodes, return true
	 * if the chain contains two side-by-side nodes that have
	 * the same value.
	 * if the chain were 10, 7, 5, 10, 8, 10 then return false
	 * if the chain were 1, 7, 8, 8 then return true
	 * if the chain were 15 then return false
	 */
	public static boolean foundPair(Node start) {
		Node curr = start;
		
		while (curr.next != null) {
			if (curr.data == curr.next.data)
				return true;
			curr = curr.next;
		}
		
		return false;
	}
	
	/*
	 * Removes the node containing the first occurrence of the specified key,
	 * if it exists. Otherwise, makes no changes. The method returns the head
	 * of the resulting chain of nodes. Assume the chain has at least
	 * two nodes.
	 * NOTE: this method could end up removing the head node. That's why
	 * it can't be a void method. Any method that changes what the head node
	 * points to needs to be treated in a special way.
	 */
	public static Node removeFirstOccurrence(Node start, int key) {
		Node curr = start, prev = null;
		
		if (start.data == key)
			return start.next;
		
		while (curr != null) {
			if (curr.data == key) {
				prev.next = curr.next;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		
		return start;
	}
	
}
