import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Tester {
	
	static private Random rnd = new Random();
	
	public static void main(String[] args) {
		
		Queue<String> myQueue = new LinkedList<>();
		myQueue.add("Jane");
		myQueue.add("Jess");
		myQueue.add("Jill");
		myQueue.add(myQueue.remove());
		myQueue.add(myQueue.peek());
		myQueue.add("Jim");
		String name = myQueue.remove();
		myQueue.add(myQueue.peek());
		
		while (!myQueue.isEmpty()) {
			System.out.print(myQueue.remove() + " ");
		}
		System.out.println();
		
		Deque<String> deq = new LinkedList<>();
		deq.add(null);
		System.out.println(deq.remove());
		
//		PriorityQueue<String> pq = new PriorityQueue<>();
//		pq.add(null);
		
		Stack<String> s = new Stack<>();
		s.push(null);
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		
		
		
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
//		System.out.println(passwordGen());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static String passwordGen() {
		String str = "", chars = "x12fIJYe%OZ^PFGQE9gjyzUHMNV0Xi@h3klt4&v#$w5KLu6CbcadWD8RST7*AB";
		
		for (int i = 0; i < (rnd.nextInt(10) + 15); i++) {
			if (rnd.nextInt(100) % 2 == 0) {
				str += chars.charAt( rnd.nextInt(chars.length()) );
			} else {
				str = chars.charAt( rnd.nextInt(chars.length()) ) + str;
			}
		}
		return str;
	}
	
}
