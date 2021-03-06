
public class BinaryNode {
	// ==================== Properties ====================
	int data;
	BinaryNode left;
	BinaryNode right;
	
	
	// ==================== Constructors ====================
	BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	
	// ==================== Methods ====================
	// recursively computes the number of nodes in the tree rooted at this node
	public int nodeCount() {
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
	
	// Returns the height of the tree rooted at this node
	public int height() {
		// get height of subtrees
		int leftHeight = (left == null) ? -1 : left.height();
		int rightHeight = (right == null) ? -1 : right.height();
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public void preOrderTraversal() {
		System.out.print(data + " ");
		if (left != null) {
			left.preOrderTraversal();
		}
		if (right != null) {
			right.preOrderTraversal();
		}
	}
	
}
