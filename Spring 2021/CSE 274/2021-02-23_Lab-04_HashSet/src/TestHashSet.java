import static org.junit.Assert.*;
import org.junit.Test;

public class TestHashSet {

	@Test
	public void testHashSet() {
		SetInterface s = new HashSet();
		assertEquals(0, s.size());
	}

	/*
	 * JUnit lets us test whether code throws exceptions correctly. In HashSet, we
	 * want the number of buckets to be a prime number. Creating a HashSet with a
	 * non- prime should throw an IllegalArgumentException. This test below will
	 * PASS if the correct exception is thrown.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHashSetIntThrowsException() {
		new HashSet(10); // not prime
	}

	@Test
	public void testHashSetStringArray() {
		String[] toBeAdded = { "cat", "dog", "house", "mouse", "tree", "ant", "book", "cat" };
		SetInterface s = new HashSet(toBeAdded);
		
		// If implemented correctly, the items will be in this order
		String[] result1 = { "house", "dog", "book", "mouse", "ant", "tree", "cat" };
		assertArrayEquals(result1, s.toArray());
	}

	@Test
	public void testAdd() {
		SetInterface s = new HashSet();
		assertTrue(s.add("A"));
		assertEquals(1, s.size());
		assertFalse(s.add("A"));
		assertEquals(1, s.size());
		assertTrue(s.add("C"));
		assertTrue(s.add("D"));
		assertEquals(3, s.size());
	}

	@Test
	public void testAddWithResize() {
		SetInterface s = new HashSet();

		for (int i = 1; i <= 6; i++) {
			assertTrue(s.add("" + i));
			assertFalse(s.add("" + i));
			assertEquals(i, s.size());
			assertTrue(s.contains(new String("" + i)));
		}

		// This will require resizing
		for (int i = 7; i <= 50; i++) {
			assertTrue(s.add("" + i));
			assertFalse(s.add("" + i));
			assertEquals(i, s.size());
			assertTrue(s.contains(new String("" + i)));
		}

	}

	// Assumes add is working
	/*
	 * Tests whether remove() is removing the first string
	 * it finds by traversing the array until it finds the first
	 * non-empty bucket
	 */
	@Test
	public void testRemove() {
		SetInterface s = new HashSet();
		String[] toBeAdded = { "cat", "dog", "house", "mouse", "tree", "ant", "book" };

		for (String str : toBeAdded) {
			s.add(str);
		}
		
		System.out.println(s);
		
		String[] result = { "house", "dog", "book", "mouse", "ant", "tree", "cat" };
		for (int i = 0; i < result.length; i++) {
			assertEquals(result[i], s.remove());
			assertEquals(6 - i, s.size());
		}
		
		// Now set is empty. remove() should return null:
		assertNull(s.remove());
	}
	
	
	// Assumes add is working
	@Test
	public void testRemoveString() {
		SetInterface s = new HashSet();

		for (int i = 1; i <= 8; i++) {
			s.add("" + i);
			assertEquals(i, s.size());
		}

		int size = s.size();

		// Remove the odds
		for (int i = 1; i <= 7; i += 2) {
			assertTrue(s.remove(new String("" + i)));
			size--;
			assertFalse(s.contains(new String("" + i)));
			assertEquals(size, s.size());
			assertFalse(s.remove(new String("" + i)));
			assertFalse(s.contains(new String("" + i)));
			assertEquals(size, s.size());
		}

		// Remove the evens, backwards
		for (int i = 8; i >= 2; i -= 2) {
			assertTrue(s.remove(new String("" + i)));
			size--;
			assertFalse(s.contains(new String("" + i)));
			assertEquals(size, s.size());
			assertFalse(s.remove(new String("" + i)));
			assertFalse(s.contains(new String("" + i)));
			assertEquals(size, s.size());
		}

		assertTrue(s.isEmpty());
		assertFalse(s.remove("2"));
		assertTrue(s.add("2"));
		assertTrue(s.remove("2"));
	}

	@Test
	public void testContains() {
		SetInterface s = new HashSet();
		assertFalse(s.contains(new String("A")));
		s.add("A");
		assertTrue(s.contains(new String("A")));
		s.add("H");
		assertTrue(s.contains(new String("A")));
		assertTrue(s.contains(new String("H")));
	}

	@Test
	public void testSize() {
		SetInterface s = new HashSet();
		assertEquals(0, s.size());
		for (int i = 1; i <= 4; i++) {
			s.add("" + i);
			assertEquals(i, s.size());
		}
	}

	@Test
	public void testIsEmpty() {
		SetInterface s = new HashSet();
		assertTrue(s.isEmpty());
		s.add("A");
		assertFalse(s.isEmpty());
	}

	@Test
	public void testClear() {
		SetInterface s = new HashSet();

		s.add("A");
		s.add("B");
		s.add("C");

		assertEquals(3, s.size());
		assertFalse(s.isEmpty());
		assertTrue(s.contains("A"));
		assertTrue(s.contains("B"));
		assertTrue(s.contains("C"));

		s.clear();
		assertEquals(0, s.size());
		assertTrue(s.isEmpty());
		assertFalse(s.contains("A"));
		assertFalse(s.contains("B"));
		assertFalse(s.contains("C"));

	}

	@Test
	public void testToArray() {
		SetInterface s = new HashSet();
		String[] toBeAdded = { "cat", "dog", "house", "mouse", "tree", "ant", "book" };
		String[] result1 = { "house", "dog", "book", "mouse", "ant", "tree", "cat" };

		for (String str : toBeAdded) {
			s.add(str);
		}

		assertArrayEquals(result1, s.toArray());
	}

	@Test
	public void testToArrayWithResizing() {
		SetInterface s = new HashSet();
		String[] toBeAdded = { "cat", "dog", "house", "mouse", "tree", "ant", "book", "spaghetti" };
		String[] result2 = { "spaghetti", "tree", "ant", "cat", "dog", "mouse", "book", "house" };

		for (String str : toBeAdded) {
			s.add(str);
		}

		assertArrayEquals(result2, s.toArray());
	}

}
