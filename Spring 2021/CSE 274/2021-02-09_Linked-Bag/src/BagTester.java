import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagTester {

	@Test
	void testAdd() {
		LinkedBag b = new LinkedBag();
		assertTrue(b.add(7));
		assertTrue(b.contains(7));
		assertEquals(1, b.size());
		
		assertTrue(b.add(7));
		assertTrue(b.contains(7));
		assertEquals(2, b.size());
		
		assertTrue(b.add(6));
		assertTrue(b.contains(6));
		assertEquals(3, b.size());
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveInt() {
		fail("Not yet implemented");
	}

	@Test
	void testContains() {
		fail("Not yet implemented");
	}

}
