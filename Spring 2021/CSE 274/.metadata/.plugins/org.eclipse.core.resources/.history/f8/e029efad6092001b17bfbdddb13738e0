import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class TestAll {

    BinaryNode sampleTree1, singleNode, rootPlusLeft, rootPlusRight,
            rootPlusLeftRight, rights, lefts, zigZag, complete31, complete32,
            complete47, repeats;

    @Before
    public void setup() {
        sampleTree1 = sampleTree1();

        singleNode = new BinaryNode(1); // single-node

        rootPlusLeft = new BinaryNode(1); // root + left
        rootPlusLeft.left = new BinaryNode(2);

        rootPlusRight = new BinaryNode(1); // root + right
        rootPlusRight.right = new BinaryNode(2);

        rootPlusLeftRight = new BinaryNode(1); // root + left + right
        rootPlusLeftRight.left = new BinaryNode(2);
        rootPlusLeftRight.right = new BinaryNode(3);

        rights = lotsOfRights(5);
        lefts = lotsOfLefts(9);
        zigZag = zigZag(20);
        complete31 = completeTree(31); // full, balanced, complete
        complete32 = completeTree(32); // full+1: not full, but balanced,
                                       // complete
        complete47 = completeTree(47); // full+ half of next level: not full,
                                       // but balanced, complete, left full,
                                       // right
        // full
        repeats = manyRepeats();
    }

    @Test
    public void testRightMostValue() {
        assertEquals(8, sampleTree1.rightMostValue());
        assertEquals(1, singleNode.rightMostValue());
        assertEquals(1, rootPlusLeft.rightMostValue());
        assertEquals(2, rootPlusRight.rightMostValue());
        assertEquals(3, rootPlusLeftRight.rightMostValue());
        assertEquals(31, completeTree(50).rightMostValue());
        assertEquals(63, completeTree(63).rightMostValue());
        assertEquals(63, completeTree(64).rightMostValue());
        assertEquals(2, zigZag(20).rightMostValue());
    }

    @Test
    public void testMax() {
        assertEquals(15, sampleTree1.max());
        assertEquals(1, singleNode.max());
        assertEquals(2, rootPlusLeft.max());
        assertEquals(2, rootPlusRight.max());
        assertEquals(3, rootPlusLeftRight.max());
        assertEquals(50, completeTree(50).max());
        assertEquals(63, completeTree(63).max());
        assertEquals(64, completeTree(64).max());
        assertEquals(37, zigZag(37).max());
    }

    @Test
    public void testGetHeight() {
        assertEquals(2, sampleTree1.height());
        assertEquals(0, singleNode.height());
        assertEquals(1, rootPlusLeft.height());
        assertEquals(1, rootPlusRight.height());
        assertEquals(1, rootPlusLeftRight.height());
        assertEquals(5, completeTree(50).height());
        assertEquals(5, completeTree(63).height());
        assertEquals(6, completeTree(64).height());
        assertEquals(19, zigZag(20).height());
    }

    @Test
    public void testNumberOfLeaves() {
        assertEquals(3, sampleTree1.numberOfLeaves());
        assertEquals(1, singleNode.numberOfLeaves());
        assertEquals(1, rootPlusLeft.numberOfLeaves());
        assertEquals(1, rootPlusRight.numberOfLeaves());
        assertEquals(2, rootPlusLeftRight.numberOfLeaves());
        assertEquals(25, completeTree(50).numberOfLeaves());
        assertEquals(32, completeTree(63).numberOfLeaves());
        assertEquals(32, completeTree(64).numberOfLeaves());
        assertEquals(1, zigZag(20).numberOfLeaves());
    }

    @Test
    public void testIsFull() {
        assertFalse(sampleTree1.isFull());
        assertTrue(singleNode.isFull());
        assertFalse(rootPlusLeft.isFull());
        assertFalse(rootPlusRight.isFull());
        assertTrue(rootPlusLeftRight.isFull());

        assertTrue(completeTree(31).isFull());
        assertFalse(completeTree(32).isFull());
        assertFalse(completeTree(47).isFull());
        assertFalse(completeTree(62).isFull());
    }

    @Test
    public void testGetFrequencyMap() {
        Map<Integer, Integer> map = repeats.frequencyMap();
        Integer freq = 1;
        assertEquals(freq, map.get(9));
        freq++;
        assertEquals(freq, map.get(11));
        freq++;
        assertEquals(freq, map.get(10));
        freq = 0;
        assertNull(map.get(14));

        map = zigZag.frequencyMap();
        freq = 1;
        for (Integer i = 1; i <= 20; i++) {
            assertEquals(freq, map.get(i));
        }

    }

    @Test
    public void testIsLeaf() {
        assertTrue(singleNode.isLeaf());
        assertFalse(rootPlusLeft.isLeaf());
        assertTrue(rootPlusLeft.left.isLeaf());
        assertFalse(rootPlusRight.isLeaf());
        assertFalse(rootPlusLeftRight.isLeaf());
    }

    @Test
    public void testGetFrequency() {
        assertEquals(0, repeats.getFrequency(0));
        assertEquals(3, repeats.getFrequency(10));
        assertEquals(2, repeats.getFrequency(11));
        assertEquals(1, repeats.getFrequency(9));

        BinaryNode b = completeTree(64);
        for (int i = 1; i <= 64; i++) {
            assertEquals(1, b.getFrequency(1));
        }

        for (int i = 1; i <= 20; i++) {
            assertEquals(1, zigZag.getFrequency(1));
        }
        assertEquals(0, zigZag.getFrequency(21));
        assertEquals(1, singleNode.getFrequency(1));
        assertEquals(0, singleNode.getFrequency(2));
    }

    @Test
    public void testNodeCount() {
        assertEquals(6, sampleTree1.nodeCount());
        assertEquals(1, singleNode.nodeCount());
        assertEquals(2, rootPlusLeft.nodeCount());
        assertEquals(2, rootPlusRight.nodeCount());
        assertEquals(3, rootPlusLeftRight.nodeCount());
        assertEquals(50, completeTree(50).nodeCount());
        assertEquals(63, completeTree(63).nodeCount());
        assertEquals(64, completeTree(64).nodeCount());
        assertEquals(20, zigZag(20).nodeCount());
    }

    @Test
    public void testFind() {
        assertTrue(singleNode.find(1));
        assertTrue(rootPlusLeft.find(1));
        assertTrue(rootPlusRight.find(1));
        assertTrue(rootPlusLeftRight.find(1));

        assertFalse(singleNode.find(15));
        assertFalse(rootPlusLeft.find(15));
        assertFalse(rootPlusRight.find(15));
        assertFalse(rootPlusLeftRight.find(15));

        assertTrue(repeats.find(11));

        for (int i = 1; i <= 20; i++) {
            assertTrue(zigZag.find(i));
        }
        for (int i = 1; i <= 32; i++) {
            assertTrue(completeTree(32).find(i));
        }
    }

    @Test
    public void testPreOrderString() {
        String result = sampleTree1.preOrderString();
        System.out.println(result.trim());
        assertEquals("10 11 7 9 15 8", result.trim());

        result = singleNode.preOrderString();
        System.out.println(result.trim());
        assertEquals("1", result.trim());

        result = rootPlusLeft.preOrderString();
        System.out.println(result.trim());
        assertEquals("1 2", result.trim());

        result = rootPlusRight.preOrderString();
        System.out.println(result.trim());
        assertEquals("1 2", result.trim());

        result = rootPlusLeftRight.preOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 3", result.trim());

        result = completeTree(10).preOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 4 8 9 5 10 3 6 7", result.trim());

        result = zigZag(10).preOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 3 4 5 6 7 8 9 10", result.trim());

    }

    @Test
    public void testLevelOrderString() {
        String result = sampleTree1.levelOrderString();
        System.out.println(result.trim());
        assertEquals("10 11 9 7 15 8", result.trim());

        result = singleNode.levelOrderString();
        System.out.println(result.trim());
        assertEquals("1", result.trim());

        result = rootPlusLeft.levelOrderString();
        System.out.println(result.trim());
        assertEquals("1 2", result.trim());

        result = rootPlusRight.levelOrderString();
        System.out.println(result.trim());
        assertEquals("1 2", result.trim());

        result = rootPlusLeftRight.levelOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 3", result.trim());

        result = completeTree(10).levelOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 3 4 5 6 7 8 9 10", result.trim());

        result = zigZag(10).levelOrderString();
        System.out.println(result.trim());
        assertEquals("1 2 3 4 5 6 7 8 9 10", result.trim());

    }

    public BinaryNode sampleTree1() {
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

    public BinaryNode manyRepeats() {
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

    public BinaryNode lotsOfRights(int n) {
        BinaryNode root = new BinaryNode(n);

        for (int i = n - 1; i >= 1; i--) {
            BinaryNode temp = new BinaryNode(i);
            temp.right = root;
            root = temp;
        }

        return root;
    }

    public BinaryNode lotsOfLefts(int n) {
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
    public BinaryNode zigZag(int n) {
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
    public BinaryNode completeTree(int n) {
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
