package bigint_retry;

import java.util.Arrays;

public class BigInt implements Comparable<BigInt>, BigIntInterface {
	// ==================== Properties ====================
	private int[] num;
	private boolean isNeg;

	// ==================== Constructors ====================
	public BigInt() {
		this("0");
	}

	public BigInt(long value) {
		this("" + value);
	}

	public BigInt(String str) {
		if (str.charAt(0) == '-') {
			this.isNeg = true;
			str = str.substring(1);
		}

		while (str.length() > 1 && str.charAt(0) == '0') {
			str = str.substring(1);
		}

		this.num = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			this.num[str.length() - i - 1] = Integer.parseInt(str.substring(i, i + 1)) * (isNeg ? -1 : 1);
		}
	}

	// ==================== Methods ====================
	@Override
	public BigInt add(BigInt other) {
		int shorter = Math.min(this.num.length, other.num.length), longer = Math.max(this.num.length, other.num.length);
		int[] newNum = new int[longer + 1];
		int i = 0;

		for (; i < shorter; i++) {
			newNum[i] = this.num[i] + other.num[i];
		}
		while (i < this.num.length) {
			newNum[i] = this.num[i];
			i++;
		}
		while (i < other.num.length) {
			newNum[i] = other.num[i];
			i++;
		}
		
		boolean numIsNeg = fix(newNum);
		String number = "";
		for (int n : newNum) {
			if (n < 0) {
				numIsNeg = true;
			}
			number = (n * (n < 0 ? -1 : 1)) + number;
		}
		
		number = (numIsNeg ? "-" : "") + number;

		return new BigInt(number);
	}

	// =============================
	// Private helper method for add
	private boolean fix(int[] num) {
		boolean numNeg = false;
		
		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] > 0) {
				i = 0;
			} else if (num[i] < 0) {
				numNeg = true;
				i = 0;
			}
		}
		
		for (int i = 0; i < num.length - 1; i++) {
			if (numNeg) {
				if (num[i] < -9) {
					num[i] += 10;
					num[i+1]--;
				} else if (num[i] > 0) {
					num[i] -= 10;
					num[i+1]++;
				}
			} else {
				if (num[i] > 9) {
					num[i] -= 10;
					num[i+1]++;
				} else if (num[i] < 0) {
					num[i] += 10;
					num[i+1]--;
				}
			}
		}
		
		return numNeg;
	}
	// =============================

	@Override
	public BigInt subtract(BigInt other) {
		other = other.negate();
		return this.add(other);
	}

	@Override
	public BigInt negate() {
		if (this.num.length == 1 && this.num[0] == 0) {
			return this;
		} else if (this.isNeg) {
			return new BigInt(this.toString().substring(1));
		} else {
			return new BigInt("-" + this.toString());
		}
	}

	@Override
	public BigInt abs() {
		if (!this.isNeg) {
			return this;
		} else {
			return new BigInt(this.toString().substring(1));
		}
	}

	@Override
	public BigInt max(BigInt other) {
		BigInt subtract = this.subtract(other);
		return subtract.isNeg ? other : this;
	}

	@Override
	public BigInt min(BigInt other) {
		BigInt subtract = this.subtract(other);
		return subtract.isNeg ? this : other;
	}

	@Override
	public int signum() {
		if (this.num.length == 1 && this.num[0] == 0) {
			return 0;
		} else if (this.isNeg) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public BigInt valueOf(long value) {
		return new BigInt(value);
	}

	@Override
	public int compareTo(BigInt other) {
		if (this.subtract(other).isNeg) {
			return -1;
		} else if (other.subtract(this).isNeg) {
			return 1;
		} else {
			return 0;
		}
	}

	public String toString() {
		String number = "";

		for (int i = this.num.length - 1; i >= 0; i--) {
			number += "" + (this.isNeg ? -1 : 1) * this.num[i];
		}

		return (this.isNeg ? "-" : "") + number;
	}

}
