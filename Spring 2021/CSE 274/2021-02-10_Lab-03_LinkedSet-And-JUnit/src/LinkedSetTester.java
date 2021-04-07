import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

/**
 * My JUnit tester for LinkedSet class, key functionality tests are in the methods
 *	remove() and toArray(), mostly to highlight the movement of data in the linked
 *	nodes and its affect on the toArray output
 *
 * @author NickR
 *
 */
class LinkedSetTester {

	@Test
	void testLinkedSet() {
		// Tests the constructor
		LinkedSet b = new LinkedSet();
		assertEquals(0, b.size());
		assertTrue(b.isEmpty());
	}

	@Test
	void testAdd() {
		LinkedSet b = new LinkedSet();
		assertTrue(b.add(new Point(1, 2)));
		Point p = new Point(3, 4);
		assertTrue(b.add(p));
		assertFalse(b.add(new Point(1, 2)));
	}

	@Test
	void testRemove() {
		// Create a new set.
		// try remove() and should get back false
		// add an item and try to remove it. should get true AND size should
		//	be 0. AND contains should give false.
		// Add a few items. and try removing from the head node. and removing
		//	from the tail node. removing things that ARE in the set. removing
		//	things that are not. check using contains and size
		LinkedSet b = new LinkedSet();
		assertFalse(b.remove(new Point(1, 2)));
		
		b.add(new Point(1, 2));
		assertTrue(b.remove(new Point(1, 2)));
		assertEquals(0, b.size());
		assertFalse(b.contains(new Point(1, 2)));
		
		b.add(new Point(2, 5));
		b.add(new Point(9, 4));
		b.add(new Point(-5, -1));
		b.add(new Point(-1, -2));
		assertTrue(b.remove(new Point(9, 4))); // remove a node
		assertFalse(b.contains(new Point(9, 4)));
		
		assertTrue(b.remove(new Point(-1, -2))); // remove the head node
		assertFalse(b.contains(new Point(-1, -2)));
		
		assertTrue(b.remove(new Point(2, 5))); // remove the last node
		assertFalse(b.contains(new Point(2, 5)));
		
		assertEquals(1, b.size());
		assertFalse(b.remove(new Point(0, 0))); // point not in set
		assertEquals(1, b.size());
		
		assertTrue(b.remove(new Point(-5, -1)));
		assertFalse(b.contains(new Point(-5, -1)));
		assertEquals(0, b.size());
	}

	@Test
	void testContains() {
		LinkedSet b = new LinkedSet();
		assertFalse(b.contains(new Point(1, 1))); // nothing in the bag yet
		
		b.add(new Point(1, 1));
		assertTrue(b.contains(new Point(1, 1)));
		
		b.add(new Point(0, 0));
		b.add(new Point(0, 0));
		b.add(new Point(2, 3));
		
		assertTrue(b.contains(new Point(0,0)));
		b.remove(new Point(0, 0));
		assertFalse(b.contains(new Point(0, 0)));
	}

	@Test
	void testSize() {
		LinkedSet b = new LinkedSet();
		assertEquals(0, b.size());
		
		b.add(new Point(1, 2));
		b.add(new Point(4, 1));
		b.add(new Point(1, 2));
		
		assertEquals(2, b.size());
		
		b.add(new Point(5, -3));
		b.add(new Point(9, 0));
		assertEquals(4, b.size());
		
		b.remove(new Point(9, 0));
		assertEquals(3, b.size());
		
		b.add(new Point(1, 2));
		b.remove(new Point(1, 2));
		assertEquals(2, b.size());
	}

	@Test
	void testIsEmpty() {
		LinkedSet b = new LinkedSet();
		assertTrue(b.isEmpty());
		
		b.add(new Point(0, 0));
		b.add(new Point(1, 3));
		assertFalse(b.isEmpty());
		
		b.add(new Point(6, 8));
		b.add(new Point(0, 0));
		assertFalse(b.isEmpty());
		
		b.remove(new Point(6, 8));
		b.remove(new Point(1, 3));
		assertFalse(b.isEmpty());
		
		b.remove(new Point(0, 0));
		assertTrue(b.isEmpty());
	}

	@Test
	void testClear() {
		LinkedSet b = new LinkedSet();
		b.add(new Point(0, 0));
		assertEquals(1, b.size());
		b.clear();
		assertEquals(0, b.size());
		
		b.add(new Point(1, 5));
		b.add(new Point(6, -1));
		b.add(new Point(0, -4));
		b.add(new Point(8, 7));
		
		assertEquals(4, b.size());
		b.clear();
		assertEquals(0, b.size());
		
		b.clear();
		assertEquals(0, b.size());
	}

	@Test
	void testToArray() {
		LinkedSet b = new LinkedSet();
		Point[] p = new Point[0];
		assertArrayEquals(p, b.toArray());
		assertEquals(0, b.toArray().length);
		
		Point[] points = {new Point(1, 1), new Point(2, 8), new Point(-5, 4), new Point(6, -1), new Point(7, 3)};
		b.add(new Point(7, 3));
		b.add(new Point(6, -1));
		b.add(new Point(-5, 4));
		b.add(new Point(2, 8));
		b.add(new Point(1, 1));
		assertArrayEquals(points, b.toArray());
		
		// need to pay attention to expected outcome order when removing items that are not the head, however this
		//	does not matter to client since order does not matter in a set
		Point[] points1 = {new Point(-5, 4), new Point(2, 8), new Point(1, 1)};
		b.remove(new Point(7, 3));
		b.remove(new Point(6, -1));
		assertArrayEquals(points1, b.toArray());
		
		Point[] points2 = {new Point(2, 8), new Point(-5, 4)};
		b.remove(new Point(1, 1));
		assertArrayEquals(points2, b.toArray());
	}

}
