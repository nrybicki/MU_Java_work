/** * Basic tests for queues and deques */public class Tester {	public static void main(String[] args) {	    QueueInterface<String> q = new ArrayQueue<>();		testQueueOperations(q);					} 	public static void testQueueOperations(QueueInterface<String> myQueue) {	    // Write constructor and add()	    // toString() is already written.	    // Test add. What edge cases should we consider?//		System.out.println(myQueue.peek()); // should be NoSuchElementException		myQueue.add("A");		myQueue.add("B");		myQueue.add("C");		myQueue.add("D");		myQueue.add("E");		System.out.println(myQueue); // Front [A B C D E] Back	    	    	    // Test peek(). What edge cases should we consider?	    //	    System.out.println(myQueue.peek()); // A//	    System.out.println(myQueue); // Front [A B C D E] Back			    	    // Test remove(). What edge cases should we consider?	    System.out.println(myQueue.remove()); // A	    System.out.println(myQueue); // Front [B C D E] Back//	    System.out.println(myQueue.remove()); // B//	    System.out.println(myQueue.remove()); // C//	    System.out.println(myQueue.remove()); // D//	    System.out.println(myQueue.remove()); // E//	    System.out.println(myQueue);	    	    // Test clear()	    myQueue.clear();	    System.out.println(myQueue);	    	} } 