import java.util.Arrays;

public class MySetTester {
	
	public static void main(String[] args) {
//		String[] strArr = {"cat", "dog", "cat", "house", "tomato", "apple", "refrigerator", "computer", "keyboard"};
//		ResizableArraySet set = new ResizableArraySet(strArr);
//		System.out.println("size is: " + set.size() + "\nis it empty? " + set.isEmpty() + " (false)");
//		
//		System.out.println(set.add("soccer") + " (true)");
//		System.out.println(set.add("soccer") + " (false)");
//		System.out.println(set.add("Soccer") + " (true)");
//		
//		System.out.println("size is: " + set.size());
//		
//		System.out.println(Arrays.toString(set.toArray()));
//		
//		System.out.println("size is: " + set.size());
//		System.out.println(set.remove());
//		System.out.println("size is: " + set.size());
//		System.out.println(Arrays.toString(set.toArray()));
//		System.out.println(set.remove());
//		System.out.println(Arrays.toString(set.toArray()));
//		
//		System.out.println("size is: " + set.size());
//		System.out.println("remove dog successful? " + set.remove("dog") + " (true)");
//		System.out.println("size is: " + set.size());
//		System.out.println(Arrays.toString(set.toArray()));
//		
//		System.out.println("contains dog? " + set.contains("dog") + " (false)");
//		System.out.println("contains cat? " + set.contains("cat") + " (true)");
//		System.out.println("contains Cat? " + set.contains("Cat") + " (false)");
		
		
//		String[] str1 = {"cat", "dog", "house"}, str2 = {"cat", "DOG", "HOUSE"};
//		ResizableArraySet set1 = new ResizableArraySet(str1), set2 = new ResizableArraySet(str2);
//		
//		ResizableArraySet union = set1.union(set2), intersect = set1.intersection(set2);
//		System.out.println(union.toString());
//		System.out.println(intersect.toString());
//		System.out.println("done part 1");
//		
//		ResizableArraySet pairsSet1 = set1.allPairs(), pairsSet2 = set2.allPairs();
//		System.out.println(pairsSet1.toString());
//		System.out.println(pairsSet2.toString());
//		System.out.println("done part 2");
		
		
		String[] str3 = {"diamond", "apple", "LaKe", "aardvark", "tunisia", "DIAMONDS", "lake", "xylophone", "tornado", "tulip", "banana"};
		ResizableArraySet set3 = new ResizableArraySet(str3);
		System.out.println("earliest word? " + set3.getEarliestWord() + " (aardvark)");
		System.out.println(Arrays.toString(set3.toArray()));
		System.out.println(set3.remove("aardvark") + " (true)");
		System.out.println(Arrays.toString(set3.toArray()));
		System.out.println(set3.remove("apple") + " (true)");
		System.out.println(set3.remove("banana") + " (true)");
		System.out.println("earliest word? " + set3.getEarliestWord() + " (diamond)");
		System.out.println(set3.remove("diamond") + " (true)");
		System.out.println("earliest word? " + set3.getEarliestWord() + " (DIAMONDS)");
		
	}
	
}
