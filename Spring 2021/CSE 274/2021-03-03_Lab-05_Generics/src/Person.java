/**
 * A person class. We would like to be able to use the Person
 * class with collections such as our Set implementations, but
 * also with Java's own collection classes such as ArrayList,
 * HashSet, TreeSet, LinkedList, etc.
 * @author Norm Krumpe
 *
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    
    /**
     * Constructs a new person with a specified name and age.
     * @param name the person's name
     * @param age the person's age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person other) {
		int compareNames = this.name.compareTo(other.name);
		
		if (compareNames == 0) { // names match, compare ages
			return this.age - other.age;
		}
		
		return compareNames;
	}
    
    
    
}
