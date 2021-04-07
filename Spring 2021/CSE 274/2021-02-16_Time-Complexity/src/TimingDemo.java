import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
 * Examines the performance of bubble sort vs Java's
 * Arrays.sort. Arrays.sort() uses a variation of quicksort
 * to sort int values (but uses merge sort when sorting objects).
 * 
 * 1. What is the average time complexity of each sorting algorithm?
 * 2. Can you predict how long it will take to sort an array using each algorithm?
 * 3. We will also graph array size vs time in a spreadsheet, by writing timing
 * data to a file and opening it in Google Sheets.
 *
 */

public class TimingDemo {

	public static void main(String[] args) throws Exception {
		
		// Arrays.sort() sorts arrays of primitives using a variation of quicksort
		//	and sorts objects using mergesort
		
		// 200000 took 64 seconds
		// 400000 took 256 seconds
		// 800000 took 1024 seconds = 17 minutes
		
		PrintWriter out = new PrintWriter("data.csv");
		
		for (int size = 100; size < 100000; size *= 2) {
			int[] data = randomArray(size, 100);
			// exact copy of the array for comparing
			int[] data2 = Arrays.copyOf(data, data.length);
			
			long startTime = System.nanoTime();
			bubbleSort(data);
			long endTime = System.nanoTime();
			
			// sort data2 with arrays.sort too, and use two more variables
			//	to store the time
			
			double totalTime = (endTime - startTime) / 1.0E9;
			out.println(size + ", " + totalTime);
		}
		
		out.close();
		
		System.out.println("DONE");
		
	}

	/*
	 * Standard bubble-sort, making passes that compare side-by-side values,
	 * swapping when a pair is out of order. Each pass is shorter than the previous
	 * pass, and if a swapless pass is made, then the sort exits.
	 */
	public static void bubbleSort(int[] data) {
		boolean swapped;
		int pass = 0;

		do {
			swapped = false;
			for (int i = 0; i < data.length - 1 - pass; i++) {
				if (data[i] > data[i + 1]) {
					int temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					swapped = true;
				}
			}
			pass++;
		} while (swapped);
	}

	// Returns an array of the specified length,
	// filled with random values in the range [0, max)
	public static int[] randomArray(int length, int max) {
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			result[i] = (int) (max * Math.random());
		}

		return result;
	}

}
