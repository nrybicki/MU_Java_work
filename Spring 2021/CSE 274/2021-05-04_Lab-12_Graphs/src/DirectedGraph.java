import java.util.*;

/**
 * Implements the Graph interface using a Map The map will act somewhat like
 * using adjacency lists.
 * 
 * @author Norm Krumpe
 *
 */
public class DirectedGraph implements Graph {

	// The character is a vertex
	// The set of characters is all the neighbors of that vertex.
	// addVertex should put a new key-value pair in the map
	// addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	private Map<Character, Set<Character>> map;

	/*
	 * Constructs a new graph by creating an empty map
	 * 
	 */
	public DirectedGraph() {
		map = new TreeMap<Character, Set<Character>>();
	}

	/*
	 * addVertex('a') should put a key-value pair in the map with no neighbors for
	 * 'a' yet.
	 */
	@Override
	public boolean addVertex(Character vertex) {
		// if vertex is already in graph, return false
		if (vertex == null || map.containsKey(vertex)) {
			return false;
		}

		map.put(vertex, new TreeSet<Character>());
		return true;
	}

	@Override
	public boolean removeVertex(Character vertex) {
		if (!hasVertex(vertex)) {
			return false;
		}

		// vertex exists:
		// loop to remove the vertex as a neighbor from
		// all the other vertices:
		for (Character v : map.keySet()) {
			// map.get(v).remove(vertex);
			removeEdge(v, vertex);
		}

		// now remove the key vertex itself
		map.remove(vertex);
		return true;
	}

	/*
	 * addEdge('a', 'b') would find key 'a' and put 'b' in its set.
	 */
	@Override
	public boolean addEdge(Character vertex1, Character vertex2) {
		// Things that could go wrong that should result in
		// returning false:
		if (vertex1 == null || vertex2 == null) {
			return false;
		}

		if (vertex1 == vertex2) {
			return false;
		}

		if (!map.containsKey(vertex1) || !map.containsKey(vertex2)) {
			return false;
		}

		return map.get(vertex1).add(vertex2);

	}

	@Override
	public boolean removeEdge(Character vertex1, Character vertex2) {
		if (!hasEdge(vertex1, vertex2)) {
			return false;
		}

		// We know the edge exists, so remove it
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
		return map.isEmpty();
	}

	@Override
	public int vertexCount() {
		return map.size(); // same as map.keySet().size()
	}

	@Override
	public int edgeCount() {
		int edges = 0;

		for (Character c : map.keySet()) {
			edges += map.get(c).size();
		}

		return edges;
	}

	/*
	 * Use a queue to manage the traversal
	 */
	@Override
	public List<Character> breadthFirstTraversal(Character vertex) {
		List<Character> result = new ArrayList<>(); // stores the answer
		Set<Character> visited = new HashSet<>(); // tracks which nodes have been "visited"
		Queue<Character> q = new LinkedList<>(); // manages the algorithm

		q.add(vertex);
		visited.add(vertex);

		while (!q.isEmpty()) {
			// Removes front item, and puts its unvisited neighbors at the end
			Character front = q.remove();

			for (Character neighbor : map.get(front)) {
				// only add neighbor to queue if it is not (in) visited
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					q.add(neighbor);
				}
			}

			result.add(front);
		}

		return result;
	}

	@Override
	public List<Character> depthFirstTraversal(Character vertex) {
		List<Character> result = new ArrayList<>(); // stores the answer
		Set<Character> visited = new HashSet<>(); // tracks which nodes have been "visited"
		Stack<Character> stk = new Stack<>(); // manages the algorithm

		stk.push(vertex);
		visited.add(vertex);
		result.add(vertex);

		while (!stk.isEmpty()) {
			Character top = stk.peek();

			// does top have an unvisited neighbor
			// if it does, push to stack, if not, pop
			boolean foundUnvisitedNeighbor = false;
			for (Character neighbor : map.get(top)) {
				if (!visited.contains(neighbor)) {
					stk.push(neighbor);
					visited.add(neighbor);
					result.add(neighbor);
					foundUnvisitedNeighbor = true;
					break;
				}
			}

			if (!foundUnvisitedNeighbor) {
				stk.pop();
			}
		}

		return result;
	}

	/*
	 * Given that we used aMAP of character as our implementation, it gets ugly
	 * trying to solve this algorithm because of the trouble trying to store the
	 * previous node. So, we won't solve it. Challenge: try solving it anyway
	 */
	@Override
	public List<Character> shortestPath(Character start, Character end) {
		throw new UnsupportedOperationException("can't use this method");
	}

	@Override
	public void makeComplete() {
		// loop through all vertices and for each one add all other vertices as
		// neighbors
		for (Character key : map.keySet()) {
			for (Character value : map.keySet()) {
//				addEdge(key, value);
				if (key != value) {
					map.get(key).add(value);
				}
			}
		}
	}

	// Returns a string representation of the graph
	// Each line is a vertex followed by its neighbors
	public String toString() {
		String result = "";

		// loop through the map
		for (Character v : map.keySet()) {
			result += v + " --> ";
			result += map.get(v); // grabs the set of neighbors
			result += "\n";
		}

		return result;
	}
}
