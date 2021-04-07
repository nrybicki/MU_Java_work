import java.awt.Point;
import java.io.*;
import java.util.*;

public class SocialNetworking {

	public static void main(String[] args) throws Exception {
//    	queuePractice();

		Person a = new Person("Amy");
		Person b = new Person("Bob");
		Person c = new Person("Carrie");
		Person d = new Person("Dave");
		Person e = new Person("Ellie");
		Person f = new Person("Fred");

		a.addFriend(c);
		c.addFriend(b);
		b.addFriend(f);
		d.addFriend(e);
		b.addFriend(d);
		a.unFriend(c);

		Set<Person> facebook = new TreeSet<>();
		facebook.add(a);
		facebook.add(b);
		facebook.add(c);
		facebook.add(d);
		facebook.add(e);
		facebook.add(f);

		for (Person p : facebook) {
			System.out.println(p);
		}

		// Find everyone in Amy's network:
		Queue<Person> q = new LinkedList<>();
//		q.add(a);
		List<Person> myNetwork = buildNetwork(200, 10);
		for (Person p : myNetwork) {
			System.out.println(p);
		}

		// keep track of who has already been in the queue once
		Set<Person> visited = new HashSet<>();
		q.add(myNetwork.get(0));
		visited.add(myNetwork.get(0));

		while (!q.isEmpty()) {
			Person front = q.remove();
			System.out.print(front.getName() + " ");
			// add all of that person's friends to the queue
			Person[] frontFriends = front.getFriends();
			for (Person p : frontFriends) {
				if (!visited.contains(p)) {
					q.add(p);
					visited.add(p);
				}
			}
		}

	} // end of main

	public static void queuePractice() {

//    	PriorityQueue<String> q = new PriorityQueue<>();
//    	q.add("cat");
//    	q.add("apple");
//    	q.add("boy");
//    	Queue<Integer> q = new LinkedList<>();
//    	q.add(10);
//    	q.add(5);
//    	q.add(3);

		PriorityQueue<Person> q = new PriorityQueue<>();
		q.add(new Person("Ami"));
		q.add(new Person("Steve"));

		System.out.println(q.remove());

	}

	// Returns a set of Person objects
	public static List<Person> buildNetwork(int userCount, int maxFriends) throws Exception {

		// A random number generator. Pseudorandom, really. Just uses a math formula.
		// The no-parameter constructor uses a variety of system information
		// (including the current time) to "seed" the formula.
		Random rnd = new Random();

		ArrayList<Person> users = new ArrayList<>();

		// Read names from a file, and scramble
		ArrayList<String> allNames = new ArrayList<>();
		Scanner in = new Scanner(new File("names.txt"));
		while (in.hasNext()) {
			allNames.add(in.next());
		}
		in.close();
		Collections.shuffle(allNames, rnd);

		for (int i = 0; i < userCount; i++) {
			Person p = new Person(allNames.get(i));
			users.add(p);
		}

		// Give each user a random number of friends
		for (Person p : users) {
			int friendsCount = (int) (rnd.nextInt(maxFriends + 1));

			while (p.friendCount() < friendsCount) {
				Person possibleFriend = users.get(rnd.nextInt(users.size()));
				if (possibleFriend.friendCount() < maxFriends) {
					p.addFriend(possibleFriend);
				}
			}
		}

		return users;
	}

}
