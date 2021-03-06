
public class LinkedDequeTester {
	
	public static void main(String[] args) {
		LinkedDeque<Integer> deq = new LinkedDeque<>();
		System.out.println("empty? " + deq.isEmpty() + " (true)");
		System.out.println(deq);
		deq.addToFront(3);
		deq.addToFront(2);
		deq.addToFront(1);
		System.out.println("empty? " + deq.isEmpty() + " (false)");
		System.out.println(deq); // FTB: 1 2 3, BTF: 3 2 1
		deq.addToBack(4);
		deq.addToBack(5);
		deq.addToBack(6);
		System.out.println(deq); // FTB: 1 2 3 4 5 6, BTF: 6 5 4 3 2 1
		deq.removeFront();
		System.out.println(deq); // FTB: 2 3 4 5 6, BTF: 6 5 4 3 2
		deq.removeFront();
		System.out.println(deq); // FTB: 3 4 5 6, BTF: 6 5 4 3
		deq.removeBack();
		System.out.println(deq); // FTB: 3 4, BTF: 5 4 3
		deq.removeBack();
		System.out.println(deq); // FTB: 3 4, BTF: 4 3
		deq.removeBack();
		System.out.println(deq); // FTB: 3, BTF: 3
		deq.removeBack();
		System.out.println(deq); // FTB: [], BTF: []
		System.out.println("empty? " + deq.isEmpty() + " (true)\n");
		
		LinkedDeque<String> deqStr = new LinkedDeque<>();
		System.out.println("empty? " + deqStr.isEmpty() + " (true)");
		System.out.println(deqStr);
		deqStr.addToFront("C");
		deqStr.addToFront("B");
		deqStr.addToFront("A");
		deqStr.addToBack("D");
		deqStr.addToBack("E");
		deqStr.addToBack("F");
		System.out.println(deqStr); // ABCDEF, FEDCBA
		System.out.println(deqStr.getBack()); // F
		System.out.println(deqStr.getFront()); // A
		System.out.println(deqStr.getFront()); // A
		System.out.println(deqStr.removeFront()); // A
		System.out.println(deqStr.getFront()); // B
		System.out.println(deqStr.getBack()); // F
		deqStr.clear();
		System.out.println("empty? " + deqStr.isEmpty() + " (true)");
		System.out.println(deqStr);
		deqStr.addToBack("X");
		System.out.println(deqStr.getBack()); // X
		System.out.println(deqStr.getFront()); // X
		deqStr.addToBack("Y");
		System.out.println(deqStr.getBack()); // Y
		System.out.println(deqStr.getFront()); // X
	}
	
}
