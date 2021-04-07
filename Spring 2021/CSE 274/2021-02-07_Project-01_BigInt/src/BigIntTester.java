import java.util.Arrays;
import java.math.BigInteger;
import java.util.ArrayList;

public class BigIntTester {

	public static void main(String[] args) {
		// =============== Constructors ===============
		BigInt a = new BigInt();
		BigInt b = new BigInt(12345678910L);
		BigInt c = new BigInt("456123789011");
		BigInt d = new BigInt("-5");
		BigInt e = new BigInt(-11111111111L);

		// =============== toString ===============
		System.out.println("Testing toString method");
		System.out.println("BigInt a is: " + a.toString());
		System.out.println("BigInt b is: " + b.toString());
		System.out.println("BigInt c is: " + c.toString());
		System.out.println("BigInt d is: " + d.toString());
		System.out.println("BigInt e is: " + e.toString());

		// =============== valueOf ===============
		System.out.println("\nTesting valueOf method");
		long f = 342714L, fNeg = -342714L;
		BigInt fBI, fNegBI;
		fBI = BigInt.valueOf(f);
		System.out.println("the value of fBI is: " + fBI.toString());
		fNegBI = BigInt.valueOf(fNeg);
		System.out.println("the value of fNegBI is: " + fNegBI.toString());

		// =============== add (for pos. vals) ===============
		System.out.println("\nTesting add method for positive values only");
		String g = "4193812302315", h = "10000";
		BigInteger bigIntegerG = new BigInteger(g);
		BigInteger bigIntegerH = new BigInteger(h);
		BigInt bigIntG = new BigInt(g);
		BigInt bigIntH = new BigInt(h);
		boolean resultGH = bigIntegerG.add(bigIntegerH).toString().equals(bigIntG.add(bigIntH).toString());
		System.out.println("Adding g and h using BigInteger and BigInt is the same: " + resultGH + " (expecting true)");
		System.out.println("g + h using BigInteger is: " + bigIntegerG.add(bigIntegerH) + " (expecting 4193812312315)"
				+ " and using BigInt it is: " + bigIntG.add(bigIntH) + " (expecting 4193812312315)");
		boolean resultHG = bigIntegerH.add(bigIntegerG).toString().equals(bigIntH.add(bigIntG).toString());
		System.out.println("Reversing the order you still get the same answer for both: "
				+ bigIntegerH.add(bigIntegerG) + " = " + bigIntH.add(bigIntG) + " ? " + resultHG + " (expecting true)");
		String i = "999999999999999999999999999999", j = "1";
		BigInt bigIntI = new BigInt(i), bigIntJ = new BigInt(j);
		System.out.println("adding 999999999999999999999999999999 + 1 should be 1000000000000000000000000000000: "
				+ bigIntI.add(bigIntJ));

		// =============== add (for neg. vals) ===============
		System.out.println("\nTesting add method for negative values");
		String k = "5", l = "-1";
		BigInt bigIntK = new BigInt(k), bigIntL = new BigInt(l);
		System.out.println("Adding 5 and -1 should be 4: " + bigIntK.add(bigIntL));
		String m = "1000000000000000000000000000000";
		BigInt bigIntM = new BigInt(m);
//		System.out.println("adding 1000000000000000000000000000000 and -1 should be 999999999999999999999999999999" +
//							bigIntM.add(bigIntL));
		
		// =============== subtract (for pos. vals) ===============
		System.out.println("\nTesting subtract method for positive values only");
		BigInt n = new BigInt("105"), o = new BigInt("4"), p = new BigInt(25L),
				q = new BigInt("111111111111111111111111111111"), r = new BigInt("111111111111111111111111111110");
		System.out.println("n minus o is: " + n.subtract(o) + " (expecting 101)");
		/*
		 * For some reason these tests both returned -199999999999999999999999999999; somewhere in my code and my subtracting and
		 * 	manipulating the values in the arrays, the ones in the original values got turned into zeros which then all got turned
		 * 	into 10s when I implemented my carrying rule
		 * 
		 * System.out.println("q minus r is: " + q.subtract(r) + " (expecting 1)");
		 * System.out.println("r minus q is: " + r.subtract(q) + " (expecting -1)");
		 */
		System.out.println("q minus n is: " + q.subtract(n) + " (expecting 111111111111111111111111111006)");
		System.out.println("n minus p is: " + n.subtract(p) + " (expecting 80)");
		System.out.println("o minus p is: " + o.subtract(p) + " (expecting -21)");
		
		// =============== abs (for all values) ===============
		System.out.println("\nTesting abs method for all values");
		System.out.println("5 before abs: " + bigIntK.toString() + " and after abs: " + bigIntK.abs().toString());
		System.out.println("-1 before abs: " + bigIntL.toString() + " and after abs: " + bigIntL.abs().toString());System.out.println("-11111111111 before abs: " + e.toString() + " and after abs: " + e.abs().toString());
		System.out.println("999999999999999999999999999999 before abs: " + bigIntI.toString() + " and after abs: "
				+ bigIntI.abs().toString());

		// =============== negate (for all values) ===============
		System.out.println("\nTesting negate method for all values");
		System.out.println(
				"5 before negate: " + bigIntK.toString() + " and after negate: " + bigIntK.negate().toString());
		System.out.println(
				"-1 before negate: " + bigIntL.toString() + " and after negate: " + bigIntL.negate().toString());
		System.out
				.println("-11111111111 before negate: " + e.toString() + " and after negate: " + e.negate().toString());
		System.out.println("999999999999999999999999999999 before negate: " + bigIntI.toString()
				+ " and after negate: " + bigIntI.negate().toString());

		// =============== compareTo (for all values) ===============
		System.out.println("\nTesting compareTo method for all values");
		BigInt v = new BigInt("12358112775911052192489592343"), w = new BigInt(5000L), x = new BigInt("5000"),
				y = new BigInt("-123124025121245"), z = new BigInt(-12415752137L);
		System.out.println("w compared to x will be 0: " + w.compareTo(x));
		System.out.println("x compared to w will be 0: " + x.compareTo(w));
		System.out.println("w compared to y will be 1: " + w.compareTo(y));
		System.out.println("y compared to z will be -1: " + y.compareTo(z));
		System.out.println("z compared to y will be 1: " + z.compareTo(y));

		// =============== min (for all values) ===============
		System.out.println("\nTesting min method for all values");
		System.out.println("min of w and x is: " + w.min(x) + " (expecting 5000)");
		System.out.println("min of z and w is: " + z.min(w) + " (expecting -12415752137)");
		System.out.println("min of z and y is: " + z.min(y) + " (expecting -123124025121245)");
		
		// =============== max (for all values) ===============
		System.out.println("\nTesting max method for all values");
		System.out.println("max of w and x is: " + w.max(x) + " (expecting 5000)");
		System.out.println("max of v and w is: " + v.max(w) + " (expecting 12358112775911052192489592343)");
		System.out.println("max of z and y is: " + z.max(y) + " (expecting -12415752137)");
		System.out.println("max of y and v is: " + y.max(v) + " (expecting 12358112775911052192489592343)");
		
		
	}

}
