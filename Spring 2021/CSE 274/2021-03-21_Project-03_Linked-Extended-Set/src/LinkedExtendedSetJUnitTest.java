import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class LinkedExtendedSetJUnitTest {

	@Test
	void testLinkedExtendedSetInt() {
		LinkedExtendedSet<String> setStr = new LinkedExtendedSet<>(5);
		assertTrue(setStr.isEmpty());
		assertEquals(5, setStr.maxFrequency());

		LinkedExtendedSet<Integer> setInt = new LinkedExtendedSet<>(3);
		assertTrue(setInt.isEmpty());
		assertEquals(3, setInt.maxFrequency());

		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>(10);
		assertTrue(setPt.isEmpty());
		assertEquals(10, setPt.maxFrequency());

		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(-1);
		assertTrue(setPt3D.isEmpty());
		assertEquals(-1, setPt3D.maxFrequency());
	}

	@Test
	void testLinkedExtendedSet() {
		LinkedExtendedSet<String> setStr = new LinkedExtendedSet<>();
		assertTrue(setStr.isEmpty());
		assertEquals(1, setStr.maxFrequency());

		LinkedExtendedSet<Integer> setInt = new LinkedExtendedSet<>();
		assertTrue(setInt.isEmpty());
		assertEquals(1, setInt.maxFrequency());

		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>();
		assertTrue(setPt.isEmpty());
		assertEquals(1, setPt.maxFrequency());

		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>();
		assertTrue(setPt3D.isEmpty());
		assertEquals(1, setPt3D.maxFrequency());
	}

	@Test
	void testAdd() {
		LinkedExtendedSet<Character> setChar = new LinkedExtendedSet<>(2);
		assertEquals(0, setChar.size());
		assertTrue(setChar.add('a'));
		assertEquals(1, setChar.size());
		assertTrue(setChar.add('b'));
		assertTrue(setChar.add('a'));
		assertFalse(setChar.add('a'));
		assertTrue(setChar.add('x'));
		assertEquals(4, setChar.size());

		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>(-1);
		assertFalse(setPt.add(new Point(1, 2)));
		assertFalse(setPt.add(new Point(3, 4)));
		assertFalse(setPt.add(new Point(1, 2)));
		assertFalse(setPt.add(new Point(11, -9)));
		assertEquals(0, setPt.size());

		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(10);
		assertTrue(setPt3D.add(new Point3D(1, 2, -3)));
		for (int i = 0; i < 10; i++) {
			assertTrue(setPt3D.add(new Point3D(11, -9, 2)));
		}
		assertFalse(setPt3D.add(new Point3D(11, -9, 2)));
		assertTrue(setPt3D.add(new Point3D(21, -30, 4)));
		assertFalse(setPt3D.add(new Point3D(11, -9, 2)));
		assertEquals(12, setPt3D.size());
	}

	@Test
	void testRemove() {
		LinkedExtendedSet<Integer> setInt = new LinkedExtendedSet<>(2);
		for (int i = -5; i < 5; i++) {
			setInt.add(i);
			setInt.add(i + 5);
		}
		assertEquals(20, setInt.size());
		assertTrue(setInt.remove(-5));
		assertFalse(setInt.contains(-5));
		assertEquals(19, setInt.size());
		assertFalse(setInt.remove(-5));
		assertEquals(19, setInt.size());
		assertTrue(setInt.remove(0));
		assertTrue(setInt.contains(0));
		assertTrue(setInt.remove(0));
		assertFalse(setInt.remove(0));
		assertFalse(setInt.contains(0));
		assertEquals(17, setInt.size());
		
		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>();
		setPt.add(new Point(1, 2));
		setPt.add(new Point(-2, 9));
		setPt.add(new Point(2, 1));
		assertEquals(3, setPt.size());
		assertTrue(setPt.remove(new Point(1, 2)));
		assertEquals(2, setPt.size());
		assertFalse(setPt.contains(new Point(1, 2)));
		assertTrue(setPt.contains(new Point(2, 1)));
		assertFalse(setPt.remove(new Point(1, 2)));
		assertTrue(setPt.remove(new Point(-2, 9)));
		assertTrue(setPt.remove(new Point(2, 1)));
		assertTrue(setPt.isEmpty());
		assertFalse(setPt.remove(new Point(2, 1)));
		assertFalse(setPt.remove(new Point(-9, 2)));
		assertFalse(setPt.remove(new Point(8, -10)));
		assertFalse(setPt.remove(new Point(4, 0)));
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(5);
		for (int i = 0; i < 5; i++) {
			setPt3D.add(new Point3D(1, 1, 1));
			setPt3D.add(new Point3D(i, i, i));
		}
		assertEquals(9, setPt3D.size());
		assertTrue(setPt3D.remove(new Point3D(1, 1, 1)));
		assertTrue(setPt3D.remove(new Point3D(4, 4, 4)));
		assertFalse(setPt3D.remove(new Point3D(-1, -1, -1)));
		assertEquals(7, setPt3D.size());
	}

	@Test
	void testRemoveAll() {
		LinkedExtendedSet<String> setStr = new LinkedExtendedSet<>(3);
		for (int i = 0; i < 3; i++) {
			setStr.add("cat");
			setStr.add("dog");
		}
		setStr.add("Cat");
		assertEquals(7, setStr.size());
		assertTrue(setStr.removeAll("cat"));
		assertEquals(4, setStr.size());
		assertFalse(setStr.contains("cat"));
		assertTrue(setStr.contains("Cat"));
		assertFalse(setStr.removeAll("apple"));
		assertTrue(setStr.removeAll("Cat"));
		assertEquals(3, setStr.size());
		
		LinkedExtendedSet<Double> setDbl = new LinkedExtendedSet<>(0);
		for (int i = 0; i < 5; i++) {
			setDbl.add(1.0);
			setDbl.add(3.14);
		}
		setDbl.add(5.91);
		setDbl.add(-9.12);
		assertEquals(0, setDbl.size());
		assertFalse(setDbl.removeAll(1.0));
		assertFalse(setDbl.removeAll(3.14));
		assertFalse(setDbl.removeAll(5.91));
		assertFalse(setDbl.removeAll(-9.12));
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(10);
		for (int i = 0; i < 10; i++) {
			setPt3D.add(new Point3D(1, 1, 1));
		}
		setPt3D.add(new Point3D(-1, -1, -1));
		assertEquals(11, setPt3D.size());
		setPt3D.removeAll(new Point3D(1, 1, 1));
		assertEquals(1, setPt3D.size());
		assertFalse(setPt3D.contains(new Point3D(1, 1, 1)));
	}

	@Test
	void testContains() {
		LinkedExtendedSet<Double> setDbl = new LinkedExtendedSet<>(2);
		setDbl.add(1.1);
		assertTrue(setDbl.contains(1.1));
		for (int i = -5; i < 5; i++) {
			setDbl.add(i + (i + 15) / 100.0);
		}
		for (int i = -5; i < 5; i++) {
			assertTrue(setDbl.contains(i + (i + 15) / 100.0));
		}
		assertFalse(setDbl.contains(100.0));
		setDbl.clear();
		assertFalse(setDbl.contains(1.1));
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>();
		setPt3D.add(new Point3D(1, 1, 1));
		setPt3D.add(new Point3D(-1, -1, -1));
		setPt3D.add(new Point3D(1, 2, 3));
		setPt3D.add(new Point3D(3, 1, 2));
		assertTrue(setPt3D.contains(new Point3D(1, 1, 1)));
		assertTrue(setPt3D.remove(new Point3D(1, 1, 1)));
		assertFalse(setPt3D.contains(new Point3D(1, 1, 1)));
		assertTrue(setPt3D.remove(new Point3D(1, 2, 3)));
		assertFalse(setPt3D.contains(new Point3D(1, 2, 3)));
		assertTrue(setPt3D.contains(new Point3D(3, 1, 2)));
	}

	@Test
	void testGetFrequency() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		LinkedExtendedSet<Integer> setInt = new LinkedExtendedSet<>(2);
		for (int i = 0; i < 98; i++) {
			setInt.add(i);
		}
		assertEquals(98, setInt.size());
		setInt.add(98);
		assertEquals(99, setInt.size());
		setInt.add(99);
		assertEquals(100, setInt.size());
		setInt.add(100);
		assertEquals(101, setInt.size());
		setInt.clear();
		assertEquals(0, setInt.size());
	}

	@Test
	void testUniqueCount() {
		fail("Not yet implemented");
	}

	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testMaxFrequency() {
		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>(100);
		assertEquals(100, setPt.maxFrequency());
		setPt.add(new Point(1, 1));
		assertEquals(100, setPt.maxFrequency());
		
		LinkedExtendedSet<String> setStr = new LinkedExtendedSet<>(-1);
		assertEquals(-1, setStr.maxFrequency());
		setStr.add("apple");
		assertEquals(-1, setStr.maxFrequency());
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(7);
		assertEquals(7, setPt3D.maxFrequency());
		setPt3D.add(new Point3D(1, 1, 0));
		assertEquals(7, setPt3D.maxFrequency());
	}

	@Test
	void testClear() {
		LinkedExtendedSet<Integer> setInt = new LinkedExtendedSet<>(2);
		for (int i = 0; i < 10; i++) {
			setInt.add(i * 2 + 3);
		}
		assertEquals(10, setInt.size());
		assertFalse(setInt.isEmpty());
		setInt.clear();
		assertEquals(0, setInt.size());
		assertTrue(setInt.isEmpty());
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(3);
		for (int i = 0; i < 20; i++) {
			setPt3D.add(new Point3D(i, i, i));
		}
		assertEquals(20, setPt3D.size());
		assertFalse(setPt3D.isEmpty());
		setPt3D.clear();
		assertEquals(0, setPt3D.size());
		assertTrue(setPt3D.isEmpty());
	}

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToUniqueArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToSortedArray() {
		fail("Not yet implemented");
		// test that this throws ClassCastException with Points
	}

}
