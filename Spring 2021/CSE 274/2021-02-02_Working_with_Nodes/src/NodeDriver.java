
public class NodeDriver {
	
	public static void main(String[] args) {
//		Node n = new Node(8);
//		
//		n.next = new Node(13);
//		n.next.next = new Node(5);
//		
//		System.out.println(n.data);
//		System.out.println(n.next.data);
//		System.out.println(n.next.next.data);
		
//		Node n1 = new Node(20);
//		Node n2 = new Node(13, n1); // new node, 13 is the data, and it points to n1
//		
//		System.out.println(n1.data);		// 20
//		System.out.println(n2.data);		// 13
//		System.out.println(n2.next.data);	// 20
//		System.out.println(n1.next.data);	// n1.next is null, so this gives NullPointerException
		
		Node a = new Node(10);
		a.next = new Node(20);
		
		Node c = new Node(30, a);
		
		// Create a list of nodes: head is 1, points to 2, then 3, 4, 5, 6, 7
		Node head = null;
		
		for (int i = 7; i >= 1; i--) {
			Node temp = new Node(i);
			temp.next = head;
			head = temp;
		}
		
		// print all the data in the list using a loop
		head.next = null;
		Node curr = head;
		
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
//		
//		System.out.println(head.data); // should still be 1
		
		
		// testing
		System.out.println();
		Node head1 = null;
		Node head2 = new Node(1);
		Node head3 = null;
		for (int i = 5; i >= 1; i--) {
			Node temp = new Node(i);
			temp.next = head3;
			head3 = temp;
		}
		
		Node curr1 = head3;
		while (curr1.next != null)
			curr1 = curr1.next;
		System.out.println(curr1.data);
		
		Node curr2 = head3;
		Node prev = null;
		while (curr2.next != null) {
			prev = curr2;
			curr2 = curr2.next;
		}
		if (prev != null)
			System.out.println(prev.data);
		else
			System.out.println("None");
		
		if (head3 == null || head3.next == null) {
			System.out.println("None");
		}
		else {
			Node curr3 = head3;
			while (curr3.next.next != null) {
				curr3 = curr3.next;
			}
			System.out.println(curr3.data);
		}
		
	}
	
}
