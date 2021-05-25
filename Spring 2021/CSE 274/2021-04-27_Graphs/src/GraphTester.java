
public class GraphTester {
	
	public static void main(String[] args) {
		Graph dg = new DirectedGraph();
		
		System.out.println(dg.addVertex('a')); // true
		System.out.println(dg.addVertex('a')); // false
		dg.addVertex('b');
		dg.addEdge('b', 'a');
		dg.addVertex('c');
		dg.addVertex('d');
		dg.addEdge('a', 'c');
		dg.addEdge('b', 'a');
		dg.addEdge('c', 'b');
		dg.addEdge('c', 'd');
		dg.addEdge('d', 'a');
		dg.addEdge('d', 'b');
		
//		System.out.println(dg.hasEdge('a', 'b')); // false
//		System.out.println(dg.hasEdge('a', 'w')); // false
//		System.out.println(dg.hasEdge('w', 'a')); // false
//		System.out.println(dg.hasEdge('b', 'a')); // true
		
//		dg.removeEdge('b', 'a');
//		System.out.println(dg.hasEdge('b', 'a')); // false
		
		System.out.println(dg);
		
		dg.removeVertex('d');
		
		System.out.println(dg);
		
//		dg.addVertex('b');
//		System.out.println(dg); // doesnt wipe out b's neighbors
		
	}
	
}
