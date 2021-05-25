// 
// Implements a binary search tree containing int data
// Implement each of the unimplemented methods.
// In the video intro to this lab, I implement add(), both
// recursively and iteratively. Try to write add() on your own,
// but feel free to use my implementation if you want.
// Solve problems recursively or iteratively...your choice.
// Don't use arrays or any other Java collections.

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * We'll solve iteratively and recursively
	 */
	// iterative add
	public void addIterative(int n) {
		if (root == null) {
			root = new Node(n);
			return;
		}

		// root is not null, must figure out where to add
		Node curr = root, parent = null;

		while (curr != null) {
			parent = curr;
			
			if (n < curr.data) {
				curr = curr.left;
			} else if (n > curr.data) {
				curr = curr.right;
			} else { // found duplicate, so stop
				return;
			}
		}
		
		if (n < parent.data) {
			parent.left = new Node(n);
		} else {
			parent.right = new Node(n);
		}
	}
	
	// recursive add
	public void add(int n) {
		root = add(root, n);
	}
	
	// recursive helper add method
	private Node add(Node top, int n) {
		if (top == null) {
			return new Node(n);
		}
		
		if (n < top.data) {
			top.left = add(top.left, n);
		} else if (n > top.data) {
			top.right = add(top.right, n);
		}
		
		return top;
	}
	
	// prints the inorder traversal of this tree, space-separated
	public void inOrderTraversal() {
		inOrderTraversal(root);
		System.out.println();
	}

	private void inOrderTraversal(Node top) {
		if (top == null) {
			return;
		}
		inOrderTraversal(top.left);
		System.out.print(top.data + " ");
		inOrderTraversal(top.right);
	}

	// Since this is a binary SEARCH tree, you should write
	// an efficient solution to this that takes advantage of the order
	// of the nodes in a BST. Your algorithm should be, on average,
	// O(log n) where n is the number of nodes in the BST, assuming
	// a well balanced tree.
	public boolean contains(int n) {
		if (root == null) {
			return false;
		}
		
		Node curr = root;
		while (curr != null) {
			if (n < curr.data) {
				curr = curr.left;
			} else if (n > curr.data) {
				curr = curr.right;
			} else {
				return true;
			}
		}
		
		return false;
	}

	// returns the smallest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty. Write an O(h) solution, where
	// h is the height of the tree.
	public int min() {
		if (root == null) {
			throw new IllegalStateException();
		}
		Node curr = root;
		
		while (curr.left != null) {
			curr = curr.left;
		}
		
		return curr.data;
	}

	// returns the largest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty. Write an O(h) solution, where
	// h is the height of the tree
	public int max() {
		if (root == null) {
			throw new IllegalStateException();
		}
		Node curr = root;
		
		while (curr.right != null) {
			curr = curr.right;
		}
		
		return curr.data;
	}

	// Returns whether the tree is empty
	public boolean isEmpty() {
		return root == null;
	}

	// returns the height of this BST. If a BST is empty, then
	// consider its height to be -1.
	public int getHeight() {
		if (root == null) {
			return -1;
		}
		return getHeight(root);
	}
	
	// private recursive helper method
	private int getHeight(Node top) {
		if (top == null) {
			return 0;
		}
		
		int leftHeight = 0, rightHeight = 0;
		
		if (top.left != null) {
			leftHeight += 1 + getHeight(top.left);
		}
		if (top.right != null) {
			rightHeight += 1 + getHeight(top.right);
		}
		
		return (leftHeight > rightHeight)? leftHeight : rightHeight;
	}

	// tree is height-balanced if at each node, the heights
	// of the node's two subtrees differs by no more than 1.
	// Special note about null subtrees:
	// 10
	// \
	// 20
	// Notice in this example that 10's left subtree is null,
	// and its right subtree has height 0. We would consider this
	// to be a balanced tree. If the tree is empty, return true;
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	// private recursive helper method
	private boolean isBalanced(Node top) {
		if (top == null) {
			return true;
		}
		
		return Math.abs(getHeight(top.left) - getHeight(top.right) ) < 1 && isBalanced(top.left) && isBalanced(top.right);
	}

	// computes the sum of the nodes in this BST.
	public int sum() {
		return sum(root);
	}
	
	// private recursive helper method
	private int sum(Node top) {
		int sum = 0;
		
		if (top == null) {
			return 0;
		}

		sum += top.data;
		sum += sum(top.left);
		sum += sum(top.right);
		
		return sum;
	}

	// returns the largest value of all the leaves
	// If the tree is empty, throw an IllegalStateException()
	public int maxLeaf() {
		if (root == null) {
			throw new IllegalStateException();
		}
		Node curr = root, parent = null;
		
		while (curr != null) {
			parent = curr;
			if (curr.right != null) {
				curr = curr.right;
			} else if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = null;
			}
		}
		
		return parent.data;
	}

	// counts the number of nodes in this BST
	public int nodeCount() {
		return nodeCount(root);
	}
	
	// private recursive helper method
	private int nodeCount(Node top) {
		if (top == null) {
			return 0;
		}
		
		return 1 + nodeCount(top.left)+ nodeCount(top.right);
	}

	// returns the "level" of the value in a tree.
	// the root is considered level 0
	// the children of the root are level 1
	// the children of the children of the root are level 2
	// and so on. If a value does not appear in the tree, return -1
	//     15
	//    /  \
	//   10  28
	//     \   \
	//     12  40
	//    /
	//   30
	// In the tree above:
	// getLevel(15) would return 0
	// getLevel(10) would return 1
	// getLevel(30) would return 3
	// getLevel(8) would return -1
	public int getLevel(int n) {
		if (root == null) {
			return -1;
		}
		
		int level = 0;
		Node curr = root;
		while (curr != null) {
			if (n < curr.data) {
				curr = curr.left;
				level++;
			} else if (n > curr.data) {
				curr = curr.right;
				level++;
			} else {
				return level;
			}
		}
		
		return -1;
	}

	private class Node {
		private int data;
		private Node left, right;

		private Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
