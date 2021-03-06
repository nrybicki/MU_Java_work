
public class Tester {
	
	public static void main(String[] args) {
		System.out.println("Testing DequeStack");
		DequeStack<Integer> s = new DequeStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop()); // 5
		System.out.println(s.peek()); // 4
		System.out.println(s.peek()); // 4
		System.out.println(s.pop()); // 4
		System.out.println(s.isEmpty()); // false
		s.clear();
		System.out.println(s.isEmpty()); // true
		
		
		System.out.println("\nTesting DequeQueue");
		DequeQueue<String> q = new DequeQueue<>();
		q.add("A");
		q.add("B");
		q.add("C");
		q.add("D");
		System.out.println(q.peek()); // A
		System.out.println(q.peek()); // A
		System.out.println(q.remove()); // A
		System.out.println(q.peek()); // B
		System.out.println(q.remove()); // B
		System.out.println(q.isEmpty()); // false
		q.clear();
		System.out.println(q.isEmpty()); // true
		
	}
	
}
