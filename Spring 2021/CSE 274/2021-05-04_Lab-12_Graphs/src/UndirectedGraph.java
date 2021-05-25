
public class UndirectedGraph extends DirectedGraph {

	// Most methods in UG will be identical in those in DG, but with three
	// exceptions:
	// addEdge(), removeEdge(), edgeCount()

	// In a UG, adding an edge needs to put vertex1 in vertex2's list and vice versa
	@Override
	public boolean addEdge(Character vertex1, Character vertex2) {
		return super.addEdge(vertex1, vertex2) && super.addEdge(vertex2, vertex1);
	}

	// In a UG, an edge can only occur once between vertices, so divide by 2
	@Override
	public int edgeCount() {
		return super.edgeCount() / 2;
	}

	// In a UG, removing an edge needs to remove vertex1 from vertex2's list and
	// vice versa
	@Override
	public boolean removeEdge(Character vertex1, Character vertex2) {
		return super.removeEdge(vertex1, vertex2) && super.removeEdge(vertex2, vertex1);
	}

}
