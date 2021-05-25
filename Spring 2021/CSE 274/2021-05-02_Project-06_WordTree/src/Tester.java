import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tester {
	
	public static void main(String[] args) throws FileNotFoundException {
//		WordTree wt = new WordTree();
//		
//		System.out.println("true? " + wt.add("cat"));
//		System.out.println("true? " + wt.contains("cat"));
//		System.out.println(wt);
//		
//		System.out.println("false? " + wt.add(""));
//		System.out.println("false? " + wt.add(null));
//		
//		System.out.println("true? " + wt.add("barn"));
//		System.out.println("true? " + wt.add("cars"));
//		System.out.println("true? " + wt.add("bar"));
//		System.out.println(wt);
//		
//		System.out.println("false? " + wt.add("barn"));
//		System.out.println("false? " + wt.add("bar"));
//		System.out.println("true? " + wt.add("bars"));
//		
//		wt.add("catchy");
//		wt.add("apple");
//		wt.add("cash");
//		wt.add("bark");
//		
//		System.out.println(wt);
//		
//		System.out.println("21? " + wt.nodeCount());
//		System.out.println("9? " + wt.wordCount());
//		
//		Set<String> allWords = wt.allWords();
//		System.out.println(allWords);
//		
//		System.out.println("16? " + wt.lettersSaved());
//		
//		Set<String> allStartingWith = wt.allStartingWith("ca");
//		System.out.println(allStartingWith);
//		
//		Map<Character, Set<String>> wordMap = wt.wordMap();
//		System.out.println(wordMap);
//		
//		Set<String> allStartingWithBlank = wt.allStartingWith("");
//		System.out.println(allStartingWithBlank);
//		System.out.println(wt.allWords());
//		
//		System.out.println(wt);
//		System.out.println("true? " + wt.remove("bark"));
//		System.out.println(wt);
//		System.out.println(wt.allWords());
//		
//		System.out.println(wt);
//		wt.clear();
//		System.out.println(wt);
		
		
		// TEST USING WORDS.TXT
		Scanner in = new Scanner(new File("words.txt"));
		WordTree wordsTXT = new WordTree();
		System.out.println("STARTING");
		while(in.hasNext()) {
			wordsTXT.add(in.next());
		}
		
		int words = wordsTXT.wordCount(), letters = wordsTXT.nodeCount(), lettersSaved = wordsTXT.lettersSaved();
		String wordsCheck = "" + (words == 370103);
		String lettersCheck = "" + (letters == 1027814);
		String lettersSavedCheck = "" + (lettersSaved == 2466883);
		
		System.out.println("370103? " + words + " " + wordsCheck.toUpperCase());
		System.out.println("1027814? " + letters + " " + lettersCheck.toUpperCase());
		System.out.println("2466883? " + lettersSaved + " " + lettersSavedCheck.toUpperCase());
		
		System.out.println("DONE");
		in.close();
		
	}
	
}
