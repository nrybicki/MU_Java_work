import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NodeDriverTest {

	@Test
	void testBuildChain() {
		int[] data = { 5, 17, 11, 10 };
		Node head = NodeDriver.buildChain(data);

		Node curr = head;
		for (int n : data) {
			assertEquals(n, curr.data);
			curr = curr.next;
		}

		assertNull(curr);
	}

	@Test
	void testDataToString() {
		int[] data = { 5, 17, 11, 10 };
		Node head = NodeDriver.buildChain(data);

		assertEquals("5 17 11 10", NodeDriver.dataToString(head));

		data = new int[] { -9 };
		head = NodeDriver.buildChain(data);

		assertEquals("-9", NodeDriver.dataToString(head));
	}

	@Test
	void testSum() {
		int[] data = { 5, 17, 11, 10 };
		Node head = NodeDriver.buildChain(data);

		assertEquals(43, NodeDriver.sum(head));
		assertEquals(38, NodeDriver.sum(head.next));
		assertEquals(21, NodeDriver.sum(head.next.next));
		assertEquals(10, NodeDriver.sum(head.next.next.next));
	}

	@Test
	void testSwapEnds() {
		int[] data = { 5, 17, 11, 10 };
		Node head = NodeDriver.buildChain(data);
		NodeDriver.swapEnds(head);

		assertEquals("10 17 11 5", NodeDriver.dataToString(head));

		data = new int[] { 42 };
		head = NodeDriver.buildChain(data);
		NodeDriver.swapEnds(head);

		assertEquals("42", NodeDriver.dataToString(head));
	}

	@Test
	void testGetFrequency() {
		int[] data1 = { 3, 9, 2, 3, 3, 4, 5, 6, 3, 3 };
		int[] data2 = { -13 };
		Node head1 = NodeDriver.buildChain(data1);
		Node head2 = NodeDriver.buildChain(data2);

		assertEquals(1, NodeDriver.getFrequency(head1, 9));
		assertEquals(5, NodeDriver.getFrequency(head1, 3));
		assertEquals(0, NodeDriver.getFrequency(head1, 99));

		assertEquals(1, NodeDriver.getFrequency(head2, -13));
		assertEquals(0, NodeDriver.getFrequency(head2, 9));
	}

	@Test
	void testAppend() {
		int[] data1 = { 5, 6, 7 };
		int[] data2 = { 4, 3 };
		int[] data3 = { 6 };
		int[] data4 = { 15, 22, 11, 86 };
		int[] data5 = { 15, 22, 11, 86 };
		int[] data6 = { 6 };

		Node head1 = NodeDriver.buildChain(data1);
		Node head2 = NodeDriver.buildChain(data2);
		Node head3 = NodeDriver.buildChain(data3);
		Node head4 = NodeDriver.buildChain(data4);
		Node head5 = NodeDriver.buildChain(data5);
		Node head6 = NodeDriver.buildChain(data6);

		NodeDriver.append(head1, head2);
		NodeDriver.append(head3, head4);
		NodeDriver.append(head5, head6);

		assertEquals("5 6 7 4 3", NodeDriver.dataToString(head1));
		assertEquals("6 15 22 11 86", NodeDriver.dataToString(head3));
		assertEquals("15 22 11 86 6", NodeDriver.dataToString(head5));

	}

	@Test
	void testGetLast() {
		int[] data = { 5 };
		Node head = NodeDriver.buildChain(data);
		assertEquals(5, NodeDriver.getLast(head));

		data = new int[] { 8, 6, 7, 5, 3, 0, 9 };
		head = NodeDriver.buildChain(data);
		assertEquals(9, NodeDriver.getLast(head));
	}

	@Test
	void testRemoveLast() {
		int[] data = { 8, 6, 7, 5, 3, 0, 9 };
		Node head = NodeDriver.buildChain(data);
		NodeDriver.removeLast(head);
		assertEquals("8 6 7 5 3 0", NodeDriver.dataToString(head));
		NodeDriver.removeLast(head);
		assertEquals("8 6 7 5 3", NodeDriver.dataToString(head));
		NodeDriver.removeLast(head);
		assertEquals("8 6 7 5", NodeDriver.dataToString(head));
		NodeDriver.removeLast(head);
		assertEquals("8 6 7", NodeDriver.dataToString(head));
		NodeDriver.removeLast(head);
		assertEquals("8 6", NodeDriver.dataToString(head));
		NodeDriver.removeLast(head);
		assertEquals("8", NodeDriver.dataToString(head));
	}

	@Test
	void testRemoveFirst() {
		int[] data = { 8, 6, 7, 5, 3, 0, 9 };
		Node head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirst(head);
		assertEquals("6 7 5 3 0 9", NodeDriver.dataToString(head));
		head = NodeDriver.removeFirst(head);
		assertEquals("7 5 3 0 9", NodeDriver.dataToString(head));
		head = NodeDriver.removeFirst(head);
		assertEquals("5 3 0 9", NodeDriver.dataToString(head));
		head = NodeDriver.removeFirst(head);
		assertEquals("3 0 9", NodeDriver.dataToString(head));
		head = NodeDriver.removeFirst(head);
		assertEquals("0 9", NodeDriver.dataToString(head));
		head = NodeDriver.removeFirst(head);
		assertEquals("9", NodeDriver.dataToString(head));
	}

	@Test
	void testSumAfter10() {
		int[] data = { 8, 6, 7, 5, 3, 0, 9 };
		Node head = NodeDriver.buildChain(data);
		assertEquals(0, NodeDriver.sumAfter10(head));
		
		data = new int[] { 10 };
		head = NodeDriver.buildChain(data);
		assertEquals(0, NodeDriver.sumAfter10(head));
		
		data = new int[] { 1, 10, 2, 10, 3, 10 };
		head = NodeDriver.buildChain(data);
		assertEquals(5, NodeDriver.sumAfter10(head));
		
		data = new int[] { 10, 2, 10, 3, 10, 4 };
		head = NodeDriver.buildChain(data);
		assertEquals(9, NodeDriver.sumAfter10(head));
		
		data = new int[] { 10, 10, 10, 10 };
		head = NodeDriver.buildChain(data);
		assertEquals(30, NodeDriver.sumAfter10(head));
	}

	@Test
	void testFoundPair() {
		int[] data = { 8, 6, 7, 5, 3, 0, 9 };
		Node head = NodeDriver.buildChain(data);
		assertFalse(NodeDriver.foundPair(head));
		
		data = new int[] { 8, 6, 7, 5, 0, 0, 9 };
		head = NodeDriver.buildChain(data);
		assertTrue(NodeDriver.foundPair(head));
		
		data = new int[] { 8, 6 };
		head = NodeDriver.buildChain(data);
		assertFalse(NodeDriver.foundPair(head));
		
		data = new int[] { 6, 6 };
		head = NodeDriver.buildChain(data);
		assertTrue(NodeDriver.foundPair(head));
		
		data = new int[] { 8, 6, 7, 5, 3, 0, 9, 9 };
		head = NodeDriver.buildChain(data);
		assertTrue(NodeDriver.foundPair(head));
		
		data = new int[] { 18 };
		head = NodeDriver.buildChain(data);
		assertFalse(NodeDriver.foundPair(head));
	}

	@Test
	void testRemoveFirstOccurrence() {
		int[] data = { 8, 6, 7, 5, 3, 0, 9, 7, 99 };
		Node head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 7);		
		assertEquals("8 6 5 3 0 9 7 99", NodeDriver.dataToString(head));
		
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 4);		
		assertEquals("8 6 7 5 3 0 9 7 99", NodeDriver.dataToString(head));
		
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 8);		
		assertEquals("6 7 5 3 0 9 7 99", NodeDriver.dataToString(head));
		
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 99);		
		assertEquals("8 6 7 5 3 0 9 7", NodeDriver.dataToString(head));
		
		data = new int[] { 7, 11 };
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 7);		
		assertEquals("11", NodeDriver.dataToString(head));
		
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 11);		
		assertEquals("7", NodeDriver.dataToString(head));
		
		head = NodeDriver.buildChain(data);
		head = NodeDriver.removeFirstOccurrence(head, 8);		
		assertEquals("7 11", NodeDriver.dataToString(head));
	}

}
