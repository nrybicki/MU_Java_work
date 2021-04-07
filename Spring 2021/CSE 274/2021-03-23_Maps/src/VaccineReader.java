import java.io.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class VaccineReader {

	public static void main(String[] args) throws Exception {
//		mapPractice();
		List<VacInfo> data = getDataFromFile();

//		Map<String, String> result = codeToCountry(data);
//		System.out.println("AFG"); // "Afghanistan"
		
		Map<String, Integer> result = codeToTotalVaccines(data);
		
		// loop to print the key-value pair one line at a time:
		Set<String> codes = result.keySet();
		for (String code : codes) {
			System.out.println(code + "-->" + result.get(code));
		}
		
		

	}
	
	// These questions are based on the data in the vaccines.csv file.
	// The method getDataFromFile() reads the data in from the file, and
	// returns the data as an arraylist of VacInfo objects. We will solve
	// some of these by writing methods, and then calling those methods from
	// main()
	
	// Problem 1: Map each country code (such as ALB) to its corresponding
	//            name. Return the map. AFG --> Afghanistan
	public static Map<String, String> codeToCountry(List<VacInfo> list) {
		Map<String, String> result = new TreeMap<>();
		for (VacInfo v : list) {
			result.put(v.code, v.country);
		}
		return result;
	}
	
	
	// Problem 2: Map each country code to the total number of vaccines
	//            given in that country
	public static Map<String, Integer> codeToTotalVaccines(List<VacInfo> list) {
		Map<String, Integer> result = new TreeMap<>();
		for (VacInfo v : list) {
			if (!result.containsKey(v.code)) {
				result.put(v.code, v.count);
			} else {
				result.put(v.code, result.get(v.code) + v.count);
			}
		}
		return result;
	}
	
	
	// Problem 3: Map each date to the total number of vaccines
	//            given on that date.	
 	
	// Problem 4: On which date were the most vaccines given?
	
	// Problem 5: On which DATES were more than 2 million vaccines given?
	
	// Problem 6: Create a map where the key is the date, and the value
	//            is the set of all countries that had at least 5000 
	//            vaccinations on that date.
	
	
	
	
	public static void mapPractice() {
		// Getting started: some basic practice with Maps
				String[] words = {"cat", "house", "tree", "encyclopedia", "apple",
						"computer", "science", "truck", "software", "engineering",
						"windows", "mac"};
				
				// Create a map using the above strings, where the key is a length, and
				// the value is the set of all strings with that length
				// 3 --> {"cat", "mac"}
				Map<Integer, HashSet<String>> map = new HashMap<>();
				
				for (String w : words) {
					// case 1: the length of w is not in the map yet
					//			need to create the set and add w to it
					if (!map.containsKey(w.length())) {
						HashSet<String> wordsOfACertainLength = new HashSet<>();
						wordsOfACertainLength.add(w);
						map.put(w.length(), wordsOfACertainLength);
					} else {
						map.get(w.length()).add(w);
					}
					// case 2: the length of w IS in the map already
					//			the set already exists. add w to it
					
				} // end loop
				
				System.out.println(map);
				
				// Create a map using the above strings, where the key is the word,
				// and the value is the length of that word. Then print the map.
//				Map<String, Integer> map = new HashMap<>();
//				
//				for (String w : words) {
//					map.put(w, w.length());
//				}
//				
//				System.out.println(map);
	}
	
	
	///////////////////////////////////////////
	// Enjoy, but don't modify, the code below.
	///////////////////////////////////////////
	
	
	// Gets all the data and returns it as a list of VacInfo objects
	private static List<VacInfo> getDataFromFile() throws Exception {

		ArrayList<VacInfo> vacData = new ArrayList<>();
		Scanner in = new Scanner(new File("vaccines.csv"));

		in.nextLine(); // ignores header line

		// An object that will help me turn date strings
		// into Date objects.
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

		while (in.hasNextLine()) {
			String line = in.nextLine();
			
			// .split turns a string into an array of strings,
			// splitting it at each comma.
			// So, for example:
			// "Afghanistan,AFG,2/23/2021,1367"
			// becomes ["Afghanistan", "AFG", "2/23/2021", "1367"]
			String[] data = line.split(",");

			// Now grab the 4 pieces of data from the array
			String country = data[0];
			String code = data[1];
			Date date = simpleDateFormat.parse(data[2], new ParsePosition(0));
			int vacCount = Integer.parseInt(data[3]);

			// Create an object from that data, and add to list
			VacInfo v = new VacInfo(country, code, date, vacCount);
			vacData.add(v);
		}

		in.close();
		return vacData;
	}

	/*
	 * How I did this: I looked at my data and created a class that gathers all the
	 * data.
	 */
	private static class VacInfo {
		private String country;
		private String code;
		private Date date;
		private int count;

		public VacInfo(String country, String code, Date date, int count) {
			this.country = country;
			this.code = code;
			this.date = date;
			this.count = count;
		}

		@Override
		public String toString() {
			return "VacInfo [country=" + country + ", code=" + code + ", date=" + date + ", count=" + count + "]";
		}

	}

}
