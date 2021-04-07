
public class quiz4 {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(3);
		
		System.out.println("problem 1");
		n1.next = n2;
		n2.next = n3;
		printAll(n1);
		printAll(n2);
		printAll(n3);
		System.out.println();
		
		System.out.println("problem 2");
		
		
		Node head = null;
		for (int i = 1; i <= 4; i++) {
			Node ni = new Node(i);
			Node n2i = new Node(i*2);
			n2i.next = head;
			ni.next = n2i;
			head = ni;
		}
		printAll(head);
		
	}
	
	public static void printAll(Node start) {
		Node curr = start;
		while (curr != null) {
			System.out.print(curr.data);
			curr = curr.next;
		}
		System.out.println();
	}
	
}
