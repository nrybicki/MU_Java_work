import java.util.*;

/**
 * Implement the Graph interface using a Map The map will act somewhat like
 * using adjacency lists
 * 
 * @author NickR
 *
 */
public class DirectedGraph implements Graph {
	// ==================== Properties ====================
	// The character is a vertex
	// The set of characters is all the neighbors of that vertex.
	// addVertex should put a new key-value pair in the map
	// addEdge('a', 'b') would find key 'a' and put 'b' in its set
	private Map<Character, Set<Character>> map;

	// ==================== Constructors ====================
	/**
	 * Constructs a new graph by creating an empty map
	 */
	public DirectedGraph() {
		map = new TreeMap<Character, Set<Character>>();
	}

	// ==================== Methods ====================
	/*
	 * addVertex('a') should put a key-value pair in the map with no neighbors for
	 * 'a' yet
	 */
	@Override
	public boolean addVertex(Character vertex) {
		// if vertex is already in graph, return false
		if (map.containsKey(vertex)) {
			return false;
		}

		map.put(vertex, new TreeSet<>());
		return true;
	}

	@Override
	public boolean removeVertex(Character vertex) {
		if (!hasVertex(vertex)) {
			return false;
		}

		// Vertex exists, remove it and return true
		for (Character v : map.keySet()) {
			map.get(v).remove(vertex);
		}

		// now remove the key vertex itself
		map.remove(vertex);

		return true;
	}

	/*
	 * addEdge('a', 'b') should find key 'a' and put 'b' in its set
	 */
	@Override
	public boolean addEdge(Character vertex1, Character vertex2) {
		// Thinds that could go wrong that should result in returning false:
		if (vertex1 == null || vertex2 == null) {
			return false;
		}

		if (!map.containsKey(vertex1) || !map.containsKey(vertex2)) {
			return false;
		}

		if (vertex1 == vertex2) {
			return false;
		}

		return map.get(vertex1).add(vertex2);
	}

	@Override
	public boolean removeEdge(Character vertex1, Character vertex2) {
		if (!hasEdge(vertex1, vertex2)) {
			return false;
		}

		// We know edge exists, so remove it and return true
		map.get(vertex1).remove(vertex2);
		return true;
	}

	@Override
	public boolean hasVertex(Character vertex) {
		return map.containsKey(vertex);
	}

	@Override
	public boolean hasEdge(Character vertex1, Character vertex2) {
		return hasVertex(vertex1) && map.get(vertex1).contains(vertex2);
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public int vertexCount() {

		return 0;
	}

	@Override
	public int edgeCount() {

		return 0;
	}

	@Override
	public List<Character> breadthFirstTraversal(Character vertex) {

		return null;
	}

	@Override
	public List<Character> depthFirstTraversal(Character vertex) {

		return null;
	}

	@Override
	public List<Character> shortestPath(Character start, Character end) {

		return null;
	}

	@Override
	public void makeComplete() {

	}

	/*
	 * Returns a string representation of the graph Each line is a vertex followed
	 * by its neighbors
	 */
	public String toString() {
		String result = "";

		for (Character v : map.keySet()) {
			result += v;
			result += " --> " + map.get(v); // grabs the set of neigbors
			result += "\n";
		}

		return result;
	}

}
