import java.util.LinkedList;
import java.util.Queue;

// This builds the sample binary tree shown at the end of this week's 
// slides, and then tests some algorithms related to that tree.
public class MyTester {

    public static void main(String[] args) {
        // Do some basic testing here:
        BinaryNode root = sampleTree1();
        root.preOrderTraversal();
        
//        System.out.println(root.nodeCount());
        
        BinaryNode repeats = manyRepeats();
        System.out.println();
        repeats.inOrderTraversal();
        System.out.println();
        System.out.println(repeats.find(11));
    }

    // These will build the various sample trees shown in the slides
    // You should also be testing your code with edge cases.

    public static BinaryNode sampleTree1() {
        BinaryNode root = new BinaryNode(10); // root

        // Build left subtree:
        BinaryNode leftST = new BinaryNode(11);
        leftST.left = new BinaryNode(7);

        // Build right subtree:
        BinaryNode rightST = new BinaryNode(9);
        rightST.left = new BinaryNode(15);
        rightST.right = new BinaryNode(8);

        root.left = leftST;
        root.right = rightST;

        return root;
    }

    public static BinaryNode manyRepeats() {
        BinaryNode root = new BinaryNode(10); // root

        // Build left subtree:
        BinaryNode leftST = new BinaryNode(11);
        leftST.left = new BinaryNode(10);

        // Build right subtree:
        BinaryNode rightST = new BinaryNode(9);
        rightST.left = new BinaryNode(10);
        rightST.right = new BinaryNode(11);

        root.left = leftST;
        root.right = rightST;

        return root;
    }

    public static BinaryNode lotsOfRights(int n) {
        BinaryNode root = new BinaryNode(n);

        for (int i = n - 1; i >= 1; i--) {
            BinaryNode temp = new BinaryNode(i);
            temp.right = root;
            root = temp;
        }

        return root;
    }

    public static BinaryNode lotsOfLefts(int n) {
        BinaryNode root = new BinaryNode(n);

        for (int i = n - 1; i >= 1; i--) {
            BinaryNode temp = new BinaryNode(i);
            temp.left = root;
            root = temp;
        }

        return root;
    }

    // A zig-zagging binary tree, with 1 at the top, 2 to the right of 1
    // 3 to the left of 2, etc.
    public static BinaryNode zigZag(int n) {
        BinaryNode root = new BinaryNode(1);
        BinaryNode curr = root;

        for (int i = 2; i <= n; i++) {
            BinaryNode temp = new BinaryNode(i);
            if (i % 2 == 0)
                curr.right = temp;
            else
                curr.left = temp;
            curr = temp;
        }

        return root;
    }

    // A complete binary tree, with level-order traversal
    // producing 1, 2, 3, 4, 5, 6, ... , n.
    // Assumes n >= 1
    public static BinaryNode completeTree(int n) {
        BinaryNode root = new BinaryNode(1);

        // Nodes get in line to have children attached
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);

        int i = 2;

        while (i <= n) {
            BinaryNode temp = new BinaryNode(i);
            BinaryNode front = q.peek();
            if (front.left == null)
                front.left = temp;
            else {
                front.right = temp;
                q.remove();
                q.add(front.left);
                q.add(front.right);
            }
            i++;
        }

        return root;
    }

}
