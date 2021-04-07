import java.util.Set;
import java.util.HashSet;

public class SetDemo {
	
	public static void main(String[] args) {
		Set<String> words = new HashSet<>();
		
		words.add("cat");
		words.add("dog");
		words.add("cat");
		
		System.out.println(words.size());
		System.out.println(words);
		
	}
	
}
