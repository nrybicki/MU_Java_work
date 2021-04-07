import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A person that can be part of a social network. Note that in this social
 * network, friendship is bidirectional (like Facebook, not like Instagram). So,
 * if Person a is friends with Person b, it implies that b is friends with a.
 * 
 * @author Norm Krumpe
 *
 */
public class Person implements Comparable<Person> {
	private String name;
	private Set<Person> friends;

	/**
	 * Creates a person with a specified name, and no friends
	 * 
	 * @param name the name of the new person
	 * @throws IllegalArgumentException if name is null
	 */
	public Person(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name must not be null");
		}
		this.name = name;
		this.friends = new TreeSet<>();
	}

	/**
	 * Adds a person to this user's friends, and adds this person to the other
	 * user's friends. A person cannot be friends with oneself.
	 * 
	 * @param other the friend to be removed
	 */
	public void addFriend(Person other) {
		if (this != other) {
			this.friends.add(other);
			other.friends.add(this);
		}
	}

	/**
	 * Removes a friend from this user's friends, and removes this user from the
	 * other user's friends
	 * 
	 * @param other the friend to be removed
	 */
	public void unFriend(Person other) {
		this.friends.remove(other);
		other.friends.remove(this);
	}

	/**
	 * Gets this user's name
	 * 
	 * @return this user's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the number of friends this user has.
	 * 
	 * @return the number of friends this user has
	 */
	public int friendCount() {
		return friends.size();
	}

	/**
	 * Gets an array of this user's friends
	 * 
	 * @return an array of this user's friends.
	 */
	public Person[] getFriends() {
		Person[] result = new Person[friends.size()];

		int index = 0;
		for (Person p : friends) {
			result[index++] = p;
		}

		return result;
	}

	// hashCode() and equals() and compareTo() are based only on the person's name
	// That means that two users are the same if they have the first name.
	// That means, if you have a set of users, no two can have the same name.
	// That makes our network easier to manage.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * Compares this person to another person based solely on names.
	 */
	@Override
	public int compareTo(Person other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		String result = this.name + ": {";
		for (Person p : this.friends) {
			result += p.name + " ";
		}
		return result.trim() + "}";
	}

}
