
public class BinaryTreeTester {
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(7);
		bt.add(5);
		bt.add(20);
		bt.add(50);
		bt.add(-10);
		
		System.out.println("Number of nodes:  " + bt.nodeCount()); // 5
		System.out.println("Number of leaves: " + bt.leafCount()); // 3
		System.out.println("All leaves: " + bt.allLeaves()); // -10 20 50
		System.out.println("All sums: " + bt.allSums()); // 62 27 2 in some order
		System.out.println(bt.allSumsIncludingPartial()); // 2 7 12 27 62
		System.out.println(bt.allPaths()); // "7 5 50" "7 5 -10" "7 20"
//		bt.postOrderTraversal();
		System.out.println(bt.postOrderTraversalPath()); // 50 -10 5 20 7
		System.out.println(bt.levelOrderTraversalPath()); // 7 5 20 50 -10
		
//		System.out.println(bt.greedySum()); // 27
//		System.out.println(bt.maxSum()); // 62
//		System.out.println(bt.max()); // 50
		
		BinaryTree bt2 = new BinaryTree();
		bt2.add(5);
		bt2.add(10);
		bt2.add(20);
		bt2.add(30);
		bt2.add(40);
		bt2.add(50);
		
		System.out.println(bt2.levelOrderTraversalPath()); // 5 10 20 30 40 50
//		System.out.println(bt2.allSumsIncludingPartial());
//		System.out.println(bt2.maxSum());
//		System.out.println(bt2.greedySum()); // 75
//		System.out.println(bt2.max()); // 50
	}
	
}
