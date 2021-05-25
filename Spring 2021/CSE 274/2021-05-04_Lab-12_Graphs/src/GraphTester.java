
public class GraphTester {

	public static void main(String[] args) {
		
		Graph g = slideSample41();
		
//		System.out.println(g);
		g.makeComplete();
		System.out.println(g);
		System.out.println(g.edgeCount()); // 36
		
		
		
//		Graph g = new UndirectedGraph();
//		g.addVertex('a');
//		g.addVertex('b');
//		g.addVertex('c');
//		
//		g.addEdge('a', 'b');
//		g.addEdge('b', 'c');
//		g.addEdge('a', 'c');
//		
//		System.out.println(g);
//		System.out.println(g.vertexCount()); // 3
//		System.out.println(g.edgeCount() + "\n"); // 3
//		
//		g.removeEdge('a', 'b');
//		System.out.println(g);
		
		
//		Graph g = new DirectedGraph();
//		for (char v = 'a'; v <= 'z'; v++) {
//			g.addVertex(v);
//		}
//		
//		g.makeComplete();
//		
//		g.removeEdge('a', 'z');
//		
//		System.out.println(g);
		
		
//		Graph g = slideSample41();
//		System.out.println(g);
//
//		System.out.println(g.vertexCount()); // 9
//		System.out.println(g.edgeCount() + "\n"); // 13
//
//		g.makeComplete();
//
//		System.out.println(g.vertexCount()); // 9
//		System.out.println(g.edgeCount()); // 72
//		System.out.println(g);
		
		
		// print the traversals
//        System.out.println(g.breadthFirstTraversal('b')); // befhci
//        System.out.println(g.breadthFirstTraversal('a') + "\n"); // abdegfhci
//        
//        System.out.println(g.depthFirstTraversal('b')); // befchi
//        System.out.println(g.depthFirstTraversal('a') + "\n"); // abefchidg

	}

	// See slide 41 in this week's notes. A directed graph with
	// 9 nodes and 13 edges
	public static Graph slideSample41() {
		Graph dg = new UndirectedGraph();
		dg.addVertex('a');
		dg.addVertex('b');
		dg.addVertex('c');
		dg.addVertex('d');
		dg.addVertex('e');
		dg.addVertex('f');
		dg.addVertex('g');
		dg.addVertex('h');
		dg.addVertex('i');

		dg.addEdge('a', 'b');
		dg.addEdge('a', 'e');
		dg.addEdge('a', 'd');
		dg.addEdge('b', 'e');
		dg.addEdge('c', 'b');
		dg.addEdge('d', 'g');
		dg.addEdge('e', 'f');
		dg.addEdge('e', 'h');
		dg.addEdge('g', 'h');
		dg.addEdge('h', 'i');
		dg.addEdge('i', 'f');
		dg.addEdge('f', 'h');
		dg.addEdge('f', 'c');

		return dg;
	}

}
