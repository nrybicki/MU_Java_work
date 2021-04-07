import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExtSetTester {

	public static void main(String[] args) {
//		LinkedExtendedSet<String> testerStr = new LinkedExtendedSet<>();
//		testerStr.add("apple");
//		System.out.println(testerStr.toString());
//
//		testerStr.add("pants");
//		testerStr.add("computer");
//		testerStr.add("textbook");
//		testerStr.add("apple");
//		System.out.println(testerStr.toString()); // textbook computer pants apple
//		System.out.println(testerStr.size()); // 4
//		System.out.println(testerStr.isEmpty()); // false
//		testerStr.clear();
//		System.out.println(testerStr.size()); // 0
//		System.out.println(testerStr.isEmpty()); // true
//		System.out.println(testerStr.toString()); // (empty)
//
//		testerStr = new LinkedExtendedSet<>(3);
//		testerStr.add("apple");
//		testerStr.add("apple");
//		testerStr.add("banana");
//		testerStr.add("potato");
//		testerStr.add("apple");
//		testerStr.add("tomato");
//		testerStr.add("apple");
//		testerStr.add("apple");
//		testerStr.add("pear");
//		System.out.println(testerStr.toString()); // pear tomato apple potato banana apple apple
//		System.out.println(testerStr.size()); // 7
//		System.out.println(Arrays.toString(testerStr.toArray())); // [pear, tomato, apple, potato, banana, apple, apple]
//
//		System.out.println(testerStr.maxFrequency()); // 3
//		System.out.println(testerStr.contains("apple")); // true
//		System.out.println(testerStr.contains("astronaut")); // false
//		System.out.println(testerStr.getFrequency("apple")); // 3
//		System.out.println(testerStr.getFrequency("pear")); // 1
//		System.out.println(testerStr.getFrequency("astronaut")); // 0
//
//		System.out.println(testerStr.uniqueCount()); // 5
//		testerStr.add("pear");
//		testerStr.add("potato");
//		testerStr.add("tomato");
//		System.out.println(testerStr.size()); // 10
//		System.out.println(testerStr.uniqueCount()); // 5
//		testerStr.add("passionfruit");
//		System.out.println(testerStr.size()); // 11
//		System.out.println(testerStr.uniqueCount()); // 6
//
//		Object[] array = testerStr.toArray(), arraySorted = testerStr.toSortedArray();
//		System.out.println("Unsorted array: " + Arrays.toString(array));
//		System.out.println("Sorted array:   " + Arrays.toString(arraySorted));
//
//		Object[] uniqueArray = testerStr.toUniqueArray();
//		System.out.println("Original Array: " + Arrays.toString(array));
//		System.out.println("Unique Array:   " + Arrays.toString(uniqueArray));
//
//		System.out.println(testerStr);
//		System.out.println(testerStr.size());
//		System.out.println(testerStr.remove("tomato"));
//		System.out.println(testerStr);
//		System.out.println(testerStr.size());
//		System.out.println(testerStr.remove("chair"));
//		System.out.println(testerStr.size());
//
//		System.out.println(testerStr);
//		System.out.println(testerStr.size());
//		System.out.println(testerStr.removeAll("apple"));
//		System.out.println(testerStr);
//		System.out.println(testerStr.size());
//		System.out.println(testerStr.removeAll("piano"));
//		System.out.println(testerStr);
//		System.out.println(testerStr.size());
//
//		System.out.println();
//		LinkedExtendedSet<Point> setPt = new LinkedExtendedSet<>();
//		setPt.add(new Point(10, 4));
//		setPt.add(new Point(1, 5));
//		setPt.add(new Point(-9, 2));
//		setPt.add(new Point(1, -34));
//		Object[] sortedPts = setPt.toSortedArray(); // throws ClassCastException
		
		LinkedExtendedSet<Point3D> setPt3D = new LinkedExtendedSet<>(3);
		setPt3D.add(new Point3D(1, 1, 1));
		setPt3D.add(new Point3D(1, 1, 2));
		setPt3D.add(new Point3D(1, 1, 1));
		setPt3D.add(new Point3D(1, 2, 2));
		setPt3D.add(new Point3D(1, 2, 1));
		Object[] arr = setPt3D.toArray(), sortedArr = setPt3D.toSortedArray();
		System.out.println("Unsorted array: " + Arrays.toString(arr));
		System.out.println("Sorted array:   " + Arrays.toString(sortedArr));
		
		
		Map<String, Integer> myMap = new TreeMap<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Set<Integer>> map1 = new HashMap<>();
	}

}
