import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class BinaryNode {
	int data;
	BinaryNode left, right;

	BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	// Returns the number of nodes in the binary tree
	// that is rooted at this node. Write recursively.
	int nodeCount() {
		// node count of this node is 1 + nodeCount(left tree) + nodeCount(right tree)
		int count = 1; // counting myself as one node

		if (left != null) {
			count += left.nodeCount();
		}

		if (right != null) {
			count += right.nodeCount();
		}

		return count;
	}

	// returns the height of the tree. If the tree has only
	// one node, its height is 0
	int height() {
		// get height of subtrees
		int leftHeight = (left == null) ? -1 : left.height();
		int rightHeight = (right == null) ? -1 : right.height();

		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Returns true if this tree is full, and false otherwise
	// A tree with exactly one node is full.
	boolean isFull() {
		return Math.pow(2, this.height() + 1) - 1 == this.nodeCount();
	}

	// Returns true if this node is a leaf, and false otherwise
	boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	// Returns the number of leaves in the tree rooted at this node
	int numberOfLeaves() {
		int count = 0;

		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			if (front.isLeaf()) {
				count++;
			} else { // if here, child(ren) exist
				// add its children to the queue
				if (front.left != null) {
					q.add(front.left);
				}
				if (front.right != null) {
					q.add(front.right);
				}
			}
		}

		return count;
	}

	// Returns the largest value in the tree
	int max() {
		int max = this.data;

		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			max = Math.max(front.data, max);

			// add its children to the queue
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}

		return max;
	}

	// Return true if a value is in the tree, and false otherwise
	boolean find(int key) {
		if (this.data == key) {
			return true;
		}

		// not in root? check recursively
		boolean foundLeft = false, foundRight = false;
		if (left != null) {
			foundLeft = left.find(key);
		}
		if (right != null) {
			foundRight = right.find(key);
		}

		return foundLeft || foundRight;
	}

	// Returns the rightmost value in the tree. That is: start at
	// the root and travel right until you can travel no more. Return
	// the value in the last node you reach (which could turn out to be
	// the value in the root node).
	int rightMostValue() {
		BinaryNode curr = this;

		while (curr.right != null) {
			curr = curr.right;
		}

		return curr.data;
	}

	// Returns a count of the number of times that the given
	// value appears in the tree rooted at this node
	int getFrequency(int key) {
		int count = 0;

		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			if (front.data == key) {
				count++;
			}

			// add its children to the queue
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}

		return count;
	}

	// Prints the pre-order traversal of the tree rooted at this node
	// Space separated. all on one line
	void preOrderTraversal() {
		System.out.print(data + " ");
		if (left != null) {
			left.preOrderTraversal();
		}
		if (right != null) {
			right.preOrderTraversal();
		}
	}

	// Print all the nodes in the tree rooted at this node,
	// using post-order traversal: left subtree, right subtree, then root data
	void postOrderTraversal() {
		if (left != null) {
			left.postOrderTraversal();
		}
		if (right != null) {
			right.postOrderTraversal();
		}
		System.out.print(data + " ");
	}

	// Prints the in-order traversal of the tree rooted at this node
	// Space separated. all on one line
	void inOrderTraversal() {
		if (left != null) {
			left.inOrderTraversal();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inOrderTraversal();
		}
	}

	// Print all the nodes in the tree rooted at this node,
	// using level-order traversal: top-to-bottom, left-to-right
	// Use a queue and a loop to solve this. Recursion doesn't work
	// well here.
	void levelOrderTraversal() {
		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			System.out.print(front.data + " ");

			// add its children to the queue
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}
	}

	// Returns a map of all the data in the tree rooted at this node,
	// with the key being the value in the tree, and the value being the
	// number of times that value appears in the tree. Note: this should be
	// solved
	// in O(n) time, where n is the number of nodes. If you solve this using
	// getFrequency(), then your solution will be too inefficient, O(n^2)
	// Try traversing the nodes so that each node is visited exactly one time.
	Map<Integer, Integer> frequencyMap() {
		Map<Integer, Integer> map = new HashMap<>();
		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			if (map.containsKey(front.data)) {
				map.put(front.data, map.get(front.data) + 1);
			} else {
				map.put(front.data, 1);
			}

			// add its children to the queue
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}

		return map;
	}

	///////////////////////////////////////////////////////////////////
	// These next two traversal methods are just like the methods above, except
	// they RETURN a string, rather than printing a string. So, the traversals above
	// are void, but the next two are not.
	///////////////////////////////////////////////////////////////////

	// Returns a space-delimited string containing the
	// pre-order traversal, rather than printing it.
	String preOrderString() {
		String str = "";
		str += data + " ";
		if (left != null) {
			str += left.preOrderString();
		}
		if (right != null) {
			str += right.preOrderString();
		}
		return str;
	}

	// Returns a space-delimited string containing the
	// level-order traversal.
	String levelOrderString() {
		String str = "";

		Queue<BinaryNode> q = new LinkedList<>();

		// put the root in the queue
		q.add(this);

		// loop until the queue is empty, removing front, processing it,
		// and adding its children
		while (!q.isEmpty()) {
			BinaryNode front = q.remove();

			// print whats in that node
			str += front.data + " ";

			// add its children to the queue
			if (front.left != null) {
				q.add(front.left);
			}
			if (front.right != null) {
				q.add(front.right);
			}
		}

		return str;
	}

}
