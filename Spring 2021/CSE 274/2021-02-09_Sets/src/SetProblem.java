import java.util.HashSet;
import java.util.Set;

public class SetProblem {
	
	public static void main(String[] args) {
		// Problem: A normal six-sided die, when rolled, will randomly show the number,
		//	1, 2, 3, 4, 5, or 6. How many times do you need to roll a die before you
		//	roll all six values?
		
		Set<Integer> rolls = new HashSet<>();
		int count = 0;
		
		while (rolls.size() < 6) {
			int roll = (int)(6 * Math.random() + 1);
			System.out.print(roll + " ");
			rolls.add(roll);
			count++;
		}
		
		System.out.println();
		System.out.println(count + " rolls");
		
	}
	
}
