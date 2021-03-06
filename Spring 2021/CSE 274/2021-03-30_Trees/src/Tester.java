
public class Tester {
	
	public static void main(String[] args) {
//		BinaryNode root = new BinaryNode(5);
//		System.out.println(root.data); // 5
//		System.out.println(root.left); // null
//		System.out.println(root.right); // null
//		
//		root.left = new BinaryNode(99);
//		System.out.println(root.left.data);
		
		BinaryNode sample = sampleTree1();
		System.out.println(sample.right.left.data); // 15
		System.out.println(sample.nodeCount()); // 6
		System.out.println(sample.height()); // 2
		sample.preOrderTraversal();
		
		System.out.println();
		sample = rightsOnly(100);
		System.out.println(sample.right.right.data); // 3
		System.out.println(sample.nodeCount()); // 100
		System.out.println(sample.height()); // 99
		sample.preOrderTraversal();
		System.out.println();
		
	}
	
	// Builds and returns sample tree 1:
	public static BinaryNode sampleTree1() {
		BinaryNode leftSubTree = new BinaryNode(11);
		leftSubTree.left = new BinaryNode(7);
		
		BinaryNode rightSubTree = new BinaryNode(9);
		rightSubTree.left = new BinaryNode(15);
		rightSubTree.right = new BinaryNode(8);
		
		BinaryNode root = new BinaryNode(10);
		root.left = leftSubTree;
		root.right = rightSubTree;
		
		return root;
	}
	
	// Build and returns a tree that only goes right, 1 through n
	public static BinaryNode rightsOnly(int n) {
		BinaryNode root = new BinaryNode(n), temp;
		
		for (int i = n - 1; i > 0; i--) {
			temp = new BinaryNode(i);
			temp.right = root;
			root = temp;
		}
		
		return root;
	}
	
}
