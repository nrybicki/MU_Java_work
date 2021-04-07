import java.awt.Point;
import java.util.*; // Gets us access to lists and sets

public class Tester {

    public static void main(String[] args) {
        // Goal 1: update SetInterface to use generics
        // Goal 2: update ResizableArraySet to use generics
        // Goal 3: test our implementations by creating sets of Point objects
        // Goal 4: test our implementations by creating sets of Person objects
        // Goal 5: fix the Person class so that it can work with our Sets (and Java's collections too)
        
    	SetInterface<Person> col = new ResizableArraySet<>(); // dont need to include data type in RHS argument
    	col.add(new Person("Amy", 20));
    	col.add(new Person("Amy", 20));
    	col.add(new Person("Steve", 24));
    	
    	for (int i = 0; i < 10; i++) {
    		col.add(new Person("Bob", i));
    	}
    	
    	System.out.println(col.size());
    	System.out.println(col);
    	System.out.println(col.contains(new Person("Amy", 20)));
    	
    }

}
