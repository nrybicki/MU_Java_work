// A node stores data and a link to another node.

public class Node {
	
	int data;
	Node next;
	
	// constructs a node that "wraps" the data
	Node(int data) {
		this.data = data;
		next = null;
	}
	
	// constructs a new node with the given data, and 
	//	sets its next reference to another node
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
}
