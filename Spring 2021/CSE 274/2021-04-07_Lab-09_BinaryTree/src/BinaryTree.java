import java.util.*;

public class BinaryTree {

	private BinaryNode root;

	// constructs an empty binary tree
	public BinaryTree() {
		root = null;
	}

	/*
	 * Returns a count of the number of nodes in the tree see video, part1 Make a
	 * public method for the client to simply use (no params, if possible) But in
	 * order to do recursion we will make a private, recursive helper method that
	 * has a node parameter that will do the work
	 */
	public int nodeCount() {
		return nodeCount(root);
	}

	// private recursive helper method
	private int nodeCount(BinaryNode top) {
		if (top == null) {
			return 0;
		}

		return 1 + nodeCount(top.left) + nodeCount(top.right);
	}

	/*
	 * Returns max value in the tree See video, part1
	 */
	public int max() { // recursive
		if (root == null) {
			throw new IllegalStateException("Tree is empty");
		}
		return max(root);
	}
	
	// private recursive helper method
	private int max(BinaryNode top) {
		int max  = top.data;
		
		if (top.left != null) {
			max = Math.max(max, max(top.left));
		}
		if (top.right != null) {
			max = Math.max(max, max(top.right));
		}
		
		return max;
	}

	/*
	 * returns the number of leaves in a tree see video part2
	 */
	public int leafCount() {
		return leafCount(root);
	}

	// private recursive helper method
	private int leafCount(BinaryNode top) {
		if (top == null) { // no node case
			return 0;
		}

		// check if top is a leaf...
		if (top.left == null && top.right == null) {
			return 1;
		}

		return leafCount(top.left) + leafCount(top.right);
	}

	/*
	 * Returns a set of all leaf values. see video, part2 This builds a collection.
	 * So, for the recursion, we will pass the collection along in the recursive
	 * call
	 */
	public Set<Integer> allLeaves() {
		Set<Integer> result = new TreeSet<>();

		// use recursion by passing the set to the recursive call
		allLeaves(root, result);

		return result;
	}

	// private recursive helper method, needs top node and set to put data
	public void allLeaves(BinaryNode top, Set<Integer> leavesSoFar) {
		if (top == null) {
			return; // end because there are no nodes
		}

		// if top is a leaf, add data to set
		if (top.left == null && top.right == null) {
			leavesSoFar.add(top.data);
			return; // increases efficiency, no recursion needed since no children
		}

		allLeaves(top.left, leavesSoFar);
		allLeaves(top.right, leavesSoFar);
	}

	/*
	 * Returns a set of all sums that can be obtained by starting at the root and
	 * traveling to each leaf see video, part2
	 */
	public Set<Integer> allSums() {
		Set<Integer> result = new TreeSet<>();
		
		// For recursive call, need to pass node, set and int
		allSums(root, result, 0);
		
		return result;
	}
	
	// private recursive helper method
	public void allSums(BinaryNode top, Set<Integer> sumsSoFar, int runningTotal) {
		if (top == null) {
			return; // nothing to add
		}
		
		// if we reach a leaf, put something in set
		if (top.left == null & top.right == null) {
			sumsSoFar.add(runningTotal + top.data);
			return; // no children, no more recursion
		}
		
		allSums(top.left, sumsSoFar, runningTotal + top.data);
		allSums(top.right, sumsSoFar, runningTotal + top.data);
	}

	/*
	 * Returns a set of all possible paths from the root to the leaves. Similar to
	 * allSums, but rather than computing sums along the way, builds a string along
	 * the way, space-separated. Trim the strings that get added to the sets. So,
	 * for example, in this tree:
	 *        5 
	 *       / \
	 *      /   \ 
	 *     10   20
	 *    /  \    \ 
	 *   30  40   50
	 * 
	 * allPaths() would return this set (order might be different): {"5 10 30",
	 * "5 10 40", "5 20 50"}
	 */
	public Set<String> allPaths() { // recursive
		Set<String> result = new TreeSet<>();
		
		allPaths(root, result, "");
		
		return result;
	}
	
	// private recursive helper method
	private void allPaths(BinaryNode top, Set<String> pathsSoFar, String path) {
		if (top == null) {
			return;
		}
		
		if (top.left == null & top.right == null) {
			pathsSoFar.add(path + top.data + " ");
			return; // no children, no more recursion
		}
		
		allPaths(top.left, pathsSoFar, path + top.data + " ");
		allPaths(top.right, pathsSoFar, path + top.data + " ");
	}

	/*
	 * Returns a set of all possible sums that can be obtained in the tree by
	 * starting at the root and traveling any path. This is similar to allSums() (in
	 * fact, it will include all the sums that are returned by allSums(), but it
	 * also includes all sums that can be obtained by stopping part-way. So, for
	 * example, in this tree:
	 *        5 
	 *       / \
	 *      /   \ 
	 *     10   20
	 *    /  \    \ 
	 *   30  40   50
	 * 
	 * allSumsIncludingPartial() would return {5, 15, 25, 45, 55, 75} whereas
	 * allSums() would only return {45, 55, 75}
	 */
	public Set<Integer> allSumsIncludingPartial() { // recursive (just take out leaf check)
		Set<Integer> result = new TreeSet<>();
		
		allSumsIncludingPartial(root, result, 0);
		
		return result;
	}
	
	private void allSumsIncludingPartial(BinaryNode top, Set<Integer> sumsSoFar, int runningTotal) {
		if (top == null) {
			return; // nothing to add
		}
		
		sumsSoFar.add(runningTotal + top.data);
		
		allSumsIncludingPartial(top.left, sumsSoFar, runningTotal + top.data);
		allSumsIncludingPartial(top.right, sumsSoFar, runningTotal + top.data);
	}

	/*
	 * Returns the sum obtained using a "greedy algorithm" by starting at the root
	 * and going left or right depending on which node has the larger value (in case
	 * of a tie, go left). If the tree is empty, throw an IllegalStateException();
	 * 
	 * So, for example, in this tree:
	 *        5 
	 *       / \
	 *      /   \ 
	 *     10   20
	 *    /  \    \ 
	 *   30  40   50
	 * 
	 * greedySum() would return 95 (5 + 20 + 70). Notice that greedySum() is not
	 * necessarily the same as maxSum()
	 */
	public int greedySum() { 
		if (root == null)
			throw new IllegalStateException("Empty tree");
		
		return root.data + greedySum(root);
	}
	
	// private recursive helper method
	private int greedySum(BinaryNode top) {
		int sum = 0;
		
		if (top.left == null && top.right == null) {
			return 0;
		}
		
		if (top.left != null && top.right != null) {
			if (top.left.data >= top.right.data) { 
				sum += top.left.data + greedySum(top.left);
			} else { 
				sum += top.right.data + greedySum(top.right);
			}
		} else {
			if (top.left != null) {
				sum += top.left.data + greedySum(top.left);
			}
			if (top.right != null) {
				sum += top.right.data + greedySum(top.right);
			}
		}
		
		return sum;
	}

	/*
	 * Returns the largest possible sum that can be obtained by starting at the root
	 * and traveling to a leaf. If the tree is empty, throw an
	 * IllegalStateException();
	 */
	public int maxSum() { // call and use allSums(), loop through to find max
		if (root == null)
			throw new IllegalStateException("Empty tree");
		
		Set<Integer> allSums = this.allSums();
		int max = Integer.MIN_VALUE;
		
		for (Integer i : allSums) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	/*
	 * Returns a queue of all the node data in the tree, in the order that they
	 * would be visited in a post-order traversal. Solve this one recursively,
	 * building the queue as you go (rather than printing the data).
	 */
	public Queue<Integer> postOrderTraversalPath() { // recursive
		Queue<Integer> result = new LinkedList<>();
		
		postOrderTraversalPath(root, result);
		
		return result;
	}
	
	// private recursive helper method
	private void postOrderTraversalPath(BinaryNode top, Queue<Integer> pathSoFar) {
		if (top != null) {
			postOrderTraversalPath(top.left, pathSoFar);
			postOrderTraversalPath(top.right, pathSoFar);
			pathSoFar.add(top.data);
		}
	}

	/*
	 * Returns the queue of all the node data in the tree, in the order that they
	 * would be visited in a level-order traversal. Solve this one using a queue and
	 * a loop, rather than recursively.
	 */
	public Queue<Integer> levelOrderTraversalPath() { // NOT recursive
		Queue<Integer> result = new LinkedList<>();
		Queue<BinaryNode> q = new LinkedList<>();
		
		q.add(root);
		
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();
			
			result.add(front.data);
			
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}
		
		return result;
	}

	// Postorder traversal that prints the nodes as they are visited
	public void postOrderTraversal() {
		postOrderTraversal(root);
		System.out.println();
	}

	// recursive helper
	private void postOrderTraversal(BinaryNode top) {
		if (top != null) {
			postOrderTraversal(top.left);
			postOrderTraversal(top.right);
			System.out.print(top.data + " ");
		}
	}

	// Adds a node to this tree
	// Find the first open spot in my tree and that
	// is where I will put num in a new node.
	public void add(int num) {
		BinaryNode temp = new BinaryNode(num);

		if (root == null) { // empty tree? make root the new node
			root = temp;
			return;
		}

		// move through the tree using level-order traversal until
		// I find an open spot for the new node
		Queue<BinaryNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			BinaryNode first = q.remove();
			// see if the left or right is null. If so, put
			// the new node in that location.
			if (first.left == null) { // add new node to left
				first.left = temp;
				return;
			} else { // left is occupied, so try the right:
				if (first.right == null) {
					first.right = temp;
					return;
				} else { // first has two children
					q.add(first.left);
					q.add(first.right);
				}
			}
		}
	}

	// Adds the specified value to a random location in the tree
	public void addRandomLocation(int n) {
		BinaryNode temp = new BinaryNode(n);

		if (root == null) {
			root = temp;
			return;
		} else {
			BinaryNode parent = root;

			while (true) {
				// randomly look right or left until a null is found
				if (Math.random() < .5) {
					if (parent.left == null) {
						parent.left = temp;
						return;
					} else {
						parent = parent.left;
					}
				} else {
					if (parent.right == null) {
						parent.right = temp;
						return;
					} else {
						parent = parent.right;
					}
				}
			}

		}

	}

	private class BinaryNode {
		int data;
		BinaryNode left, right;

		BinaryNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}