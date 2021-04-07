import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SetTester {

	@Test
	void testResizableArraySetInt() {
		ResizableArraySet set1 = new ResizableArraySet(0);
		assertEquals(0, set1.size());
		assertTrue(set1.isEmpty());
		ResizableArraySet set2 = new ResizableArraySet(5100);
		assertEquals(0, set2.size());
		assertTrue(set2.isEmpty());
		ResizableArraySet set3 = new ResizableArraySet(1274781);
		assertEquals(0, set3.size());
		assertTrue(set3.isEmpty());
	}

	@Test
	void testResizableArraySet() {
		ResizableArraySet set = new ResizableArraySet();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
	}

	@Test
	void testResizableArraySetStringArray() {
		String[] strArr1 = {"dog", "cat", "house"};
		ResizableArraySet set1 = new ResizableArraySet(strArr1);
		assertEquals(3, set1.size());
		assertFalse(set1.isEmpty());
		String[] strArr2 = {"dog", "cat", "house", "dog", "Dog", "DOG"};
		ResizableArraySet set2 = new ResizableArraySet(strArr2);
		assertEquals(5, set2.size());
		assertFalse(set2.isEmpty());
		String[] strArr3 = new String[0];
		ResizableArraySet set3 = new ResizableArraySet(strArr3);
		assertEquals(0, set3.size());
		assertTrue(set3.isEmpty());
	}

	@Test
	void testSize() {
		ResizableArraySet set = new ResizableArraySet();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		String[] strArr = {"dog", "cat", "house", "PEN", "refrigerator", "apple", "spaghetti", "potato", "computer"};
		for (String str : strArr) {
			set.add(str);
		}
		assertEquals(9, set.size());
		assertFalse(set.isEmpty());
		String[] moreStr = {"keyboard", "mouse", "headphones"};
		for (String str : moreStr) {
			set.add(str);
		}
		assertEquals(12, set.size());
		assertFalse(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
	}

	@Test
	void testIsEmpty() {
		ResizableArraySet set = new ResizableArraySet();
		assertTrue(set.isEmpty());
		set = new ResizableArraySet(10);
		for (int i = 0; i < 21;) {
			set.add("" + (char)(i++ + 97) + (char)(i++ + 97) + (char)(i++ + 97) + "");
		}
		assertFalse(set.isEmpty());
		set.clear();
		assertTrue(set.isEmpty());
	}

	@Test
	void testAdd() {
		ResizableArraySet set = new ResizableArraySet(3);
		assertTrue(set.add("dog"));
		assertEquals(1, set.size());
		assertTrue(set.contains("dog"));
		
		assertTrue(set.add("cat"));
		assertEquals(2, set.size());
		assertTrue(set.contains("cat"));
		
		assertFalse(set.add("cat"));
		assertEquals(2, set.size());
		
		assertTrue(set.add("Cat"));
		assertEquals(3, set.size());
		assertTrue(set.contains("Cat"));
		
		assertTrue(set.add("DOG"));
		assertEquals(4, set.size());
		assertTrue(set.contains("DOG"));
		
		set = new ResizableArraySet(1);
		assertTrue(set.add("apple"));
		assertEquals(1, set.size());
		assertTrue(set.contains("apple"));
	}

	@Test
	void testRemove() {
		String[] str = {"mint chocolate chip", "vanilla", "coffee", "cookie dough"};
		ResizableArraySet set = new ResizableArraySet(str);
		assertEquals(4, set.size());
		assertTrue(set.contains("cookie dough"));
		assertEquals("cookie dough", set.remove());
		assertFalse(set.contains("cookie dough"));
		assertEquals(3, set.size());
		
		assertEquals("coffee", set.remove());
		assertFalse(set.contains("coffee"));
		assertEquals(2, set.size());
		
		assertEquals("vanilla", set.remove());
		assertFalse(set.contains("vanilla"));
		assertEquals(1, set.size());
		
		assertEquals("mint chocolate chip", set.remove());
		assertFalse(set.contains("mint chocolate chip"));
		assertEquals(0, set.size());
		
		assertTrue(set.isEmpty());
		assertNull(set.remove());
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		
		set.add("banana split");
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
		assertEquals("banana split", set.remove());
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
	}

	@Test
	void testRemoveString() {
		String[] str = {"cat", "Dog", "HOUSE"};
		ResizableArraySet set = new ResizableArraySet(str);
		assertEquals(3, set.size());
		assertTrue(set.remove("cat"));
		assertFalse(set.contains("cat"));
		assertEquals(2, set.size());
		
		assertTrue(set.remove("Dog"));
		assertFalse(set.contains("Dog"));
		assertEquals(1, set.size());
		
		assertTrue(set.remove("HOUSE"));
		assertFalse(set.contains("HOUSE"));
		assertEquals(0, set.size());
		
		assertTrue(set.isEmpty());
		assertFalse(set.remove("banana"));
		assertFalse(set.remove("apples"));
		
		set.add("APPLE");
		set.add("Apple");
		set.add("apple");
		set.add("potato");
		set.add("apples");
		
		assertEquals(5, set.size());
		assertTrue(set.contains("apple"));
		assertTrue(set.remove("apple"));
		assertFalse(set.contains("apple"));
		assertEquals(4, set.size());
		
		assertTrue(set.contains("APPLE"));
		assertTrue(set.contains("Apple"));
		assertTrue(set.contains("apples"));
		assertEquals(4, set.size());
	}

	@Test
	void testClear() {
		String[] str = {"cat", "Dog", "HOUSE"};
		ResizableArraySet set = new ResizableArraySet(str);
		assertEquals(3, set.size());
		assertFalse(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		
		set.add("computer");
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		
		set.add("apple");
		set.add("banana");
		set.add("POTATO");
		set.add("Spaghetti");
		set.add("empanadas");
		assertEquals(5, set.size());
		assertFalse(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		set.clear();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
	}

	@Test
	void testContains() {
		String[] str = {"cat", "Dog", "HOUSE", "computer"};
		ResizableArraySet set = new ResizableArraySet(str);
		assertTrue(set.contains("cat"));
		assertTrue(set.contains("Dog"));
		assertTrue(set.contains("HOUSE"));
		assertTrue(set.contains("computer"));
		
		assertFalse(set.contains("pineapple"));
		assertFalse(set.contains("catt"));
		assertFalse(set.contains("house"));
		
		set.add("apple");
		assertTrue(set.contains("apple"));
		set.remove("apple");
		assertFalse(set.contains("apple"));
		
		set.clear();
		assertFalse(set.contains("cat"));
		assertFalse(set.contains("Dog"));
		assertFalse(set.contains("HOUSE"));
		assertFalse(set.contains("computer"));
	}

	@Test
	void testToArray() {
		String[] str1 = {"apple", "banana", "PinEApplE", "PEAR"}, str2 = {"PEAR", "banana", "apple", "PinEApplE"};
		ResizableArraySet set1 = new ResizableArraySet(str1), set2 = new ResizableArraySet(str2);
		assertArrayEquals(str1, set1.toArray());
		assertArrayEquals(str2, set2.toArray());
		
		String[] set1Arr = set1.toArray(), set2Arr = set2.toArray();
		Arrays.sort(set1Arr);
		Arrays.sort(set2Arr);
		assertArrayEquals(set1Arr, set2Arr);
	}

	@Test
	void testIntersection() {
		String[] str1 = {"dog", "cat", "house", "pineapple"}, str2 = {"cat", "DOG", "pineapple", "HOUSE"};
		ResizableArraySet set1 = new ResizableArraySet(str1), set2 = new ResizableArraySet(str2);
		ResizableArraySet intersection1 = set1.intersection(set2), intersection2 = set2.intersection(set1);
		assertEquals(2, intersection1.size());
		assertEquals(2, intersection2.size());
		assertTrue(intersection1.contains("cat"));
		assertFalse(intersection1.contains("dog"));
		assertFalse(intersection1.contains("house"));
		assertFalse(intersection1.contains("DOG"));
		assertFalse(intersection1.contains("HOUSE"));
		assertTrue(intersection1.contains("pineapple"));
		
		assertTrue(intersection2.contains("cat"));
		assertFalse(intersection2.contains("dog"));
		assertFalse(intersection2.contains("house"));
		assertFalse(intersection2.contains("DOG"));
		assertFalse(intersection2.contains("HOUSE"));
		assertTrue(intersection2.contains("pineapple"));
		
		String[] str3 = {"apple"}, str4 = {"APPLE"};
		ResizableArraySet set3 = new ResizableArraySet(str3), set4 = new ResizableArraySet(str4);
		ResizableArraySet intersection3 = set3.intersection(set4);
		assertEquals(0, intersection3.size());
		assertFalse(intersection3.contains("apple"));
		assertFalse(intersection3.contains("APPLE"));
		assertTrue(intersection3.isEmpty());
	}

	@Test
	void testUnion() {
		String[] str1 = {"cat", "dog", "house"}, str2 = {"DOG", "HOUSE", "cat"};
		ResizableArraySet set1 = new ResizableArraySet(str1), set2 = new ResizableArraySet(str2);
		ResizableArraySet union1 = set1.union(set2), union2 = set2.union(set1);
		assertEquals(5, union1.size());
		assertEquals(5, union2.size());
		assertTrue(union1.contains("cat"));
		assertTrue(union1.contains("dog"));
		assertTrue(union1.contains("house"));
		assertTrue(union1.contains("DOG"));
		assertTrue(union1.contains("HOUSE"));
		
		assertTrue(union2.contains("cat"));
		assertTrue(union2.contains("dog"));
		assertTrue(union2.contains("house"));
		assertTrue(union2.contains("DOG"));
		assertTrue(union2.contains("HOUSE"));
		
		String[] str3 = {"apple"}, str4 = {"apple"};
		ResizableArraySet set3 = new ResizableArraySet(str3), set4 = new ResizableArraySet(str4);
		ResizableArraySet union3 = set3.union(set4);
		assertEquals(1, union3.size());
		assertTrue(union3.contains("apple"));
	}

	@Test
	void testAllPairs() {
		String[] str = {"single"};
		ResizableArraySet set = new ResizableArraySet(str);
		ResizableArraySet pairsSet = set.allPairs();
		assertEquals(0, pairsSet.size());
		assertTrue(pairsSet.isEmpty());
		
		String[] str1 = {"cat", "dog", "house"}, str2 = {"cat", "DOG", "HOUSE"};
		ResizableArraySet set1 = new ResizableArraySet(str1), set2 = new ResizableArraySet(str2);
		ResizableArraySet pairsSet1 = set1.allPairs(), pairsSet2 = set2.allPairs();
		assertEquals(6, pairsSet1.size());
		assertEquals(6, pairsSet2.size());
	}

	@Test
	void testGetEarliestWord() {
		String[] str = {"diamond", "apple", "LaKe", "aardvark", "tunisia", "DIAMONDS", "lake",
				"xylophone", "tornado", "tulip", "banana"};
		ResizableArraySet set = new ResizableArraySet(str);
		assertEquals("aardvark", set.getEarliestWord());
		set.remove("aardvark");
		set.remove("apple");
		set.remove("banana");
		assertEquals("diamond", set.getEarliestWord());
		set.remove("diamond");
		assertEquals("DIAMONDS", set.getEarliestWord());
		set.clear();
		assertNull(set.getEarliestWord());
		set.add("item");
		assertEquals("item", set.getEarliestWord());
		set.add("Item");
		set.add("ITEM");
		assertEquals("item", set.getEarliestWord());
	}

}
