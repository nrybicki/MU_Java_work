import java.util.Arrays;

/**
 * This class produces objects that are analogous to integers and implements
 * methods that allow the user to use the BigInt objects as though they are
 * integers. These numbers are in the range of -2^2147483647 (exclusive) to
 * 2^2147483647 (exclusive), as opposed to the normal integer range of
 * -2147483648 to 2147483647.
 * 
 * The user will be able to use the BigInt objects to add and subtract with
 * other BigInt objects. BigInt also provides access to functions such as
 * negate, abs, compareTo, max, min, signum, valueOf, and toString.
 * 
 * @author Nicholas Rybicki
 *
 */

public class BigInt implements Comparable<BigInt> {
	// ==================== Properties ====================
	private int[] num;
	private boolean isNeg;

	// ==================== Constructors ====================
	/**
	 * Creates a new BigInt object with a value of 0, calls on string constructor
	 */
	public BigInt() {
		this("0");
	}
	
	/**
	 * Creates a new BigInt object with the value specified by the input long value, and
	 * 	calls on the String constructor
	 * 
	 * @param value - a long value for the new BigInt object
	 */
	public BigInt(long value) {
		this("" + value);
	}
	
	/**
	 * Creates a new BigInt object with the value specified by the input string
	 * 
	 * @param str - a string object with the value of the BigInt object (assumes the 
	 * 				user knows to only input integers and a negative sign if desired
	 */
	public BigInt(String str) {
		this.isNeg = (str.charAt(0) == '-');
		this.num = (this.isNeg) ? toArray(str.substring(1)) : toArray(str);
	}

	// ==================== Methods ====================
	/**
	 * Returns the BigInt value as a string
	 * 
	 * @return the value of the BigInt as a string
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < num.length; i++)
			str += "" + (num[i] * ((this.isNeg) ? -1 : 1));
		return (this.isNeg) ? "-" + str : str;
	}
	
	/**
	 * Returns a new BigInt with the value specified
	 * 	
	 * @param value - specified value for the BigInt
	 * @return new BigInt with specified value
	 */
	public static BigInt valueOf(long value) {
		return new BigInt(value);
	}

	/**
	 * Returns a BigInt whose new value is this BigInt plus other BigInt
	 * 
	 * @param other - second BigInt object to be added to this BigInt
	 * @return new BigInt object that is the sum of the original BigInt and the
	 *         input BigInt
	 */
	public BigInt add(BigInt other) {
		String str = "";
		int[][] add = fill2DArray(this.num, other.num);
		int i = add[0].length - 1, carry = 0;

		for (; i >= 0; i--) {
			str = ((add[0][i] + add[1][i] + carry) % 10) + str;
			carry = (add[0][i] + add[1][i] + carry) / 10;
		}

		if (carry == 1)
			str = "1" + str;

		return new BigInt(str);
	}
	
	/**
	 * Returns a BigInt whose new value is this BigInt minus other BigInt
	 * 
	 * @param other - BigInt object to subtract from this BigInt
	 * @return new BigInt object with the new value being the result of this minus other
	 */
	public BigInt subtract(BigInt other) {
		String str = "";
		int[][] sub;
		int carry = 0;
		boolean thisLarger = (compareTo(other) != -1);
		
		if (!this.isNeg && other.isNeg) {
			return add(other);
		}
		
		if (thisLarger) {
			sub = fill2DArray(this.num, other.num);
			for (int i = sub[0].length - 1; i >= 0; i--) {
				if (i > 0 && sub[1][i] > sub[0][i]) {
					sub[0][i-1]--;
					sub[0][i] += 10;
				}
				str = ((sub[0][i] - sub[1][i]) % 10) + str;
			}
			str = cleanString(str);
			return new BigInt(str);
		} else {
			sub = fill2DArray(other.num, this.num);
			for (int i = sub[0].length - 1; i >= 0; i--) {
				if (i > 0 && sub[1][i] > sub[0][i]) {
					sub[0][i-1]--;
					sub[0][i] += 10;
				}
				str = ((sub[0][i] - sub[1][i]) % 10) + str;
			}
			str = cleanString(str);
			return new BigInt("-" + str);
		}
		
	}

	/**
	 * Returns the negated value of this BigInt
	 * 
	 * @return new BigInt object with the value of the negated value of this BigInt
	 */
	public BigInt negate() {
		if (this.isNeg)
			return new BigInt(this.toString().substring(1));
		else
			return new BigInt("-" + this.toString());
	}
	
	/**
	 * Returns the absolute value of this BigInt
	 * 
	 * @return new BigInt object with the value of the absolute value of this BigInt
	 */
	public BigInt abs() {
		if (!this.isNeg)
			return this;
		else
			return new BigInt(this.toString().substring(1));
	}
	
	/**
	 * Determines the maximum between this BigInt and other BigInt
	 * 
	 * @param other - BigInt object to be compared with this BigInt
	 * @return the BigInt object which is the maximum, if they are equal, return this BigInt
	 */
	public BigInt max(BigInt other) {
		int choice = compareTo(other);
		return (choice == -1) ? other : this;
	}
	
	/**
	 * Determines the minimum between this BigInt and other BigInt
	 * 
	 * @param other - BigInt object to be compared with this BigInt
	 * @return the BigInt object which is the minimum, if they are equal, return this BigInt
	 */
	public BigInt min(BigInt other) {
		int choice = compareTo(other);
		return (choice == 1) ? other : this;
	}
	
	/**
	 * Determines the sign of this BigInt
	 * 
	 * @return an int, either -1, 0 or 1, if this BigInt is negative, zero or positive
	 */
	public int signum() {
		if (num.length == 1 && num[0] == 0)
			return 0;
		else
			return (isNeg) ? -1 : 1;
	}

	/**
	 * Compares this BigInt to the input BigInt
	 * 
	 * @param other - second BigInt to compare with this BigInt
	 * @return an int, either -1, 0 or 1, if this BigInt is less than, equal to or greater
	 * 			than the other BigInt
	 */
	public int compareTo(BigInt other) {
		// if this is pos. and other is neg., return 1
		if (!this.isNeg && other.isNeg) {
			return 1;
		}
		// if this is neg. and other is pos., return -1
		else if (this.isNeg && !other.isNeg) {
			return -1;
		}
		// if both are neg., if the same length check for which is more positive, if not
		// same
		// length check which is shorter
		else if (this.isNeg && other.isNeg) {
			if (this.num.length == other.num.length) {
				for (int i = 0; i < this.num.length; i++) {
					if (this.num[i] < other.num[i])
						return 1;
					if (this.num[i] > other.num[i])
						return -1;
				}
			} else if (this.num.length > other.num.length) {
				return -1;
			} else {
				return 1;
			}
		}
		// if both are pos., if the same length check for which is more positive, if not
		// same
		// length check which is longer
		else {
			if (this.num.length == other.num.length) {
				for (int i = 0; i < this.num.length; i++) {
					if (this.num[i] < other.num[i])
						return -1;
					if (this.num[i] > other.num[i])
						return 1;
				}
			} else if (this.num.length > other.num.length) {
				return 1;
			} else {
				return -1;
			}
		}

		return 0; // return if both are equal
	}


	// ==================== Helper Methods ====================
	/**
	 * Helper method that takes in a string and returns a new int array with each
	 * character in the string, in this case it will always be integers, as a value
	 * in the array
	 * 
	 * @param str - a string of integers, and possibly a negative sign in front
	 * @return a new 1-D int array with the integers from the string as its values
	 */
	private int[] toArray(String str) {
		int[] ret = new int[str.length()];
		for (int i = 0; i < str.length(); i++)
			ret[i] = Integer.parseInt(str.substring(i, i + 1)) * ((this.isNeg) ? -1 : 1);
		return ret;
	}

	/**
	 * Helper method that takes in two 1-D arrays, of possibly different sizes, and
	 * returns a new 2-D array with the longer number in the first row and the
	 * smaller one in the second row with zeros in front of it
	 * 
	 * @param num1 - 1-D int array with the first number in it
	 * @param num2 - 1-D int array with the second number in it
	 * @return a new 2-D int array with the first number in the first row and the
	 *         second number in the second row
	 */
	private int[][] fill2DArray(int[] num1, int[] num2) {
		boolean num1Longer = (num1.length > num2.length);
		int[][] num12 = new int[2][(num1Longer) ? num1.length : num2.length];
		
		if (num1.length == num2.length) {
			for (int i = 0; i < num1.length; i++) {
				num12[0][i] = num1[i];
				num12[1][i] = num2[i];
			}
		}
		
		if (num1Longer) {
			int i = 0, j = 0;
			for (int n : num1)
				num12[0][j++] = n;
			for (; i < num1.length - num2.length; i++)
				num12[1][i] = 0;
			for (int k = 0; i < num12[1].length; i++, k++)
				num12[1][i] = num2[k];
		} else {
			int i = 0, j = 0;
			for (int n : num2)
				num12[0][j++] = n;
			for (; i < num2.length - num1.length; i++)
				num12[1][i] = 0;
			for (int k = 0; i < num12[1].length; i++, k++)
				num12[1][i] = num1[k];
		}

		return num12;
	}
	
	/**
	 * Helper method that cleans up the entered string, removes any leading zeros from the
	 * 	input string
	 * 
	 * @param str - string number with possible leading zeros
	 * @return
	 */
	private String cleanString(String str) {
		boolean strIsNeg = (str.charAt(0) == '-');
		
		if (strIsNeg)
			str = str.substring(1);
		
		while (str.charAt(0) == '0') {
			str = str.substring(1);
		}
		
		return (strIsNeg)? "-" + str : str;
	}

}
