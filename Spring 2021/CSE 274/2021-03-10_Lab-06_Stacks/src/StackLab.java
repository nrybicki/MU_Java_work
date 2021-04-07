import java.util.HashSet;
import java.util.Set;

// lab6 - Implement the methods in this class
// Name: Nicholas Rybicki

public class StackLab {

	public static void main(String[] args) {
		// ================== TEST IMPLEMENTATION OF STACK ==================
//		// Do your testing here. Write test code BEFORE writing the method.
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		System.out.println(stk.peek()); // Should be EmptyStackException
//		
//		for (int i = 1; i <= 11; i++) {
//			stk.push(i);
//		}
//		
//		System.out.println(stk.peek()); // 11
//		stk.showStack(); // Top: 11 10 9 ... 1
//		
//		System.out.println(stk.pop()); // 11
//		stk.showStack(); // Top: 10 9 ... 1
//		
//		stk.clear();
//		stk.showStack(); // Top: 
		
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(5);
//		stk.push(7);
//		
//		System.out.println(sum(stk)); // 12
//		stk.showStack(); // Top: 
		
		
		// ========== Test sum ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(0);
//		stk.push(3);
//		stk.push(7);
//		stk.push(5);
//		stk.push(10);
//		
//		System.out.println(sum(stk)); // 25
//		System.out.println(stk.isEmpty()); // true
//		System.out.println(sum(stk)); // 0
		
		
		// ========== Test pushUnder ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(5);
//		stk.push(6);
//		stk.push(7);
//		stk.push(9);
//		
//		stk.showStack(); // Top: 9 7 6 5
//		pushUnder(stk, 8);
//		stk.showStack(); // Top: 9 8 7 6 5
//		pushUnder(stk, 8);
//		stk.showStack(); // Top: 9 8 8 7 6 5
//		
//		ArrayStack<Integer> stk1 = new ArrayStack<>();
//		stk1.showStack();
//		pushUnder(stk1, 8);
//		stk1.showStack(); // Top: 8 8
		
		
		// ========== Test fillStack ==========
//		ArrayStack<Integer> stk = fillStack(10);
//		stk.showStack();
//		
//		ArrayStack<Integer> stk1 = fillStack(0);
//		stk1.showStack();
		
		
		// ========== Test sumSkipDuplicates ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(4);
//		stk.push(1);
//		stk.push(2);
//		stk.push(2);
//		stk.push(7);
//		stk.push(2);
//		stk.push(8);
//		stk.push(8);
//		stk.push(8);
//		stk.push(4);
//		// sumStackDuplicates should give: 4 + 1 + 2 + 7 + 2 + 8 + 4
//		System.out.println(sumSkipDuplicates(stk)); // 28
//		
//		stk.clear();
//		System.out.println(sumSkipDuplicates(stk)); // 0
//		
//		stk.push(1);
//		stk.push(1);
//		stk.push(1);
//		System.out.println(sumSkipDuplicates(stk)); // 1
//		
//		stk.clear();
//		stk.push(99);
//		System.out.println(sumSkipDuplicates(stk)); // 99
		
		
		// ========== Test stringToStack ==========
//		ArrayStack<Character> chars;
//		String str = "fedcba";
//		chars = stringToStack(str);
//		chars.showStack(); // Top: a b c d e f
//		
//		str = "";
//		chars = stringToStack(str);
//		chars.showStack(); // Top:
//		
//		str = "a";
//		chars = stringToStack(str);
//		chars.showStack(); // Top: a
		
		
		// ========== Test reverseStack ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(1);
//		stk.push(2);
//		stk.push(3);
//		stk.push(4);
//		stk.push(5);
//		
//		stk.showStack();
//		reverseStack(stk);
//		stk.showStack();
//		
//		ArrayStack<Integer> stk1 = new ArrayStack<>();
//		stk1.showStack(); // Top: 
//		reverseStack(stk1);
//		stk1.showStack(); // Top: 
//		
//		stk1.push(1);
//		stk1.showStack(); // Top: 1
//		reverseStack(stk1);
//		stk1.showStack(); // Top: 1
		
		
		// ========== Test copyStack ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(5);
//		stk.push(7);
//		
//		ArrayStack<Integer> copy = copyStack(stk);
//		copy.push(99);
//		
//		stk.showStack(); // 7 5
//		copy.showStack(); // 99 7 5
//		
//		stk.clear();
//		copy = copyStack(stk);
//		stk.showStack(); // Top: 
//		copy.showStack(); // Top: 
		
		
		// ========== Test removeNulls ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(null);
//		stk.push(1);
//		stk.push(null);
//		stk.push(null);
//		stk.push(4);
//		
//		stk.showStack(); // Top: 4 null null 1 null
//		removeNulls(stk);
//		stk.showStack(); // Top: 4 1
//		
//		ArrayStack<Integer> stk1 = new ArrayStack<>();
//		stk1.push(null);
//		stk1.push(null);
//		stk1.push(null);
//		stk1.push(null);
//		
//		stk1.showStack(); // Top: null null null null
//		removeNulls(stk1);
//		stk1.showStack(); // Top: 
		
		
		// ========== Test getUniqueItems ==========
//		ArrayStack<String> stk = new ArrayStack<>();
//		stk.push("bird");
//		stk.push("cat");
//		stk.push("dog");
//		stk.push("cat");
//		stk.push("Bird");
//		
//		Set<String> stkSet = getUniqueItems(stk);
//		System.out.println(stkSet.toString());
//		stk.showStack();
		
		
		// ========== Test getBottom ==========
//		ArrayStack<Integer> stk = new ArrayStack<>();
//		stk.push(null);
//		stk.push(1);
//		stk.push(2);
//		stk.push(3);
//		stk.push(4);
//		
//		System.out.println(getBottom(stk)); // null
//		stk.showStack();
//		
//		ArrayStack<Integer> stk1 = new ArrayStack<>();
//		System.out.println(getBottom(stk1)); // null
//		stk1.showStack(); // Top: 
		
	}

	/*
	 * Computes the sum of all the numbers in the stack. It's ok 
	 * to destroy the stack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		int sum = 0;
		
		// loop to pop all items off the stack
		while (!data.isEmpty()) {
			sum += data.pop();
		}
		
		return sum;
	}

	/*
	 * Puts an integer under the top item in a stack.  If the stack is empty,
	 * just put the item on the top two times.
	 * For example: if stk starting at the top is: 7, 8, 5, 11, 
	 * then pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11
	 * For example: if stk is empty,  
	 * then pushUnder(stk, 20) would result in: 20, 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		// pop and store, push new item, then push old top item
		if (data.isEmpty()) {
			data.push(value);
			data.push(value);
		} else {
			int top = data.pop();
			data.push(value);
			data.push(top);
		}
	}

	/*
	 * Returns a stack with n items, where each item is the value n.
	 * Assume that n is non-negative.
	 * For example: 
	 * fillStack(5) returns a stack containing 5, 5, 5, 5, 5
	 * fillStack(2) returns a stack containing 2, 2
	 * fillStack(0) returns an empty stack.	 * 
	 */
	public static ArrayStack<Integer> fillStack(int n){
		ArrayStack<Integer> stk = new ArrayStack<>();
		
		for (int i = 0; i < n; i++) {
			stk.push(n);
		}
		
		return stk;
	}

	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers in a row are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		if (data.isEmpty()) {
			return 0;
		}
		
		int sum = data.peek(), lastNum = data.pop();
		
		while (!data.isEmpty()) {
			if (lastNum != data.peek()) {
				sum += data.peek();
			}
			lastNum = data.pop();
		}
		
		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, in order, with the first
	 * character of the string at the bottom of the stack and the last character
	 * of the string at the top of the stack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> stk = new ArrayStack<>();
		
		for (int i = 0; i < s.length(); i++) {
			stk.push(s.charAt(i));
		}
		
		return stk;
	}

	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom
	 * and the bottom becomes the top. YOU MAY USE ADDITIONAL STACKS AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> reverse = new ArrayStack<>(), hold = new ArrayStack<>();
		
		while (!s.isEmpty()) {
			reverse.push(s.pop());
		}
		
		while (!reverse.isEmpty()) {
			hold.push(reverse.pop());
		}
		
		while (!hold.isEmpty()) {
			s.push(hold.pop());
		}
	}

	/*
	 * Returns an exact copy of the given stack.  At the end of this method
	 * the original stack should be the same as when it started, and a new copy
	 * of that stack should be returned.  YOU MAY USE ADDITIONAL STACKS AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		// returns a new stack, so create a new stack and fill it
		// probably want a third stack to help. will definitely use loops
		ArrayStack<Integer> hold = new ArrayStack<>(), copy = new ArrayStack<>();
		
		while (!s.isEmpty()) {
			hold.push(s.pop());
		}
		
		while (!hold.isEmpty()) {
			s.push(hold.peek());
			copy.push(hold.pop());
		}
		
		return copy;
	}

	/*
	 * Modify a stack of Integers, remove all occurrences of null
	 * from the stack. For example, if the stack from top to bottom were: 3, 0, null, -5, null,
	 * then at the end of the method the stack should be 3, 0, -5
	 * You may use another stack, but don't use any other collections to solve this.
	 * NOTE: you cannot store null in a primitive.
	 * BAD: int i = null; 
	 * OK:  Integer i = null;
	 */
	public static void removeNulls(ArrayStack<Integer> stk) {
		ArrayStack<Integer> copy = new ArrayStack<>();
		
		while (!stk.isEmpty()) {
			copy.push(stk.pop());
		}
		
		Integer value = 0;
		while (!copy.isEmpty()) {
			value = copy.pop();
			if (value != null) {
				stk.push(value);
			}
		}
	}

	/*
	 * Returns a set of all values in the stack. At the end of this method, the stack
	 * should be in the same order as when it started. Use another
	 * stack to help solve this problem. 
	 */
	public static Set<String> getUniqueItems(StackInterface<String> stk) {
		ArrayStack<String> hold = new ArrayStack<>();
		Set<String> uniqueItems = new HashSet<>();
		
		while (!stk.isEmpty()) {
			uniqueItems.add(stk.peek());
			hold.push(stk.pop());
		}
		
		while (!hold.isEmpty()) {
			stk.push(hold.pop());
		}
		
		return uniqueItems;
	}

	/*
	 * Returns the value at the bottom of the stack. If the
	 * stack is empty, return null. At the end of this method, the stack
	 * should be in the same order as when it started. Use another
	 * stack to help solve this problem.
	 */
	public static Integer getBottom(StackInterface<Integer> stk) {
		if (stk.isEmpty()) {
			return null;
		}
		ArrayStack<Integer> copy = new ArrayStack<>();
		
		while (!stk.isEmpty()) {
			copy.push(stk.pop());
		}
		
		Integer bottom = copy.peek();
		
		while (!copy.isEmpty()) {
			stk.push(copy.pop());
		}
		
		return bottom;	    
	}

}
