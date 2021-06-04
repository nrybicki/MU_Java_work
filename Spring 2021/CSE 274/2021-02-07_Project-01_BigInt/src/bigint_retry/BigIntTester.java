package bigint_retry;

public class BigIntTester {

	public static void main(String[] args) {
//		BigInt bi = new BigInt("-4567989");
//		System.out.println(bi);
		
//		BigInt bi1, bi2;
//		bi1 = new BigInt("-123123123123");
//		bi2 = new BigInt("-123123123123");
//		BigInt result = new BigInt("0");
//		System.out.println(bi1.subtract(bi2));
//		System.out.println( result.compareTo(bi1.subtract(bi2)) == 0 );
		
//		BigInt bi1, bi2;
//		bi1 = new BigInt("-45");
//		bi2 = new BigInt("-54");
//		System.out.println(bi1.compareTo(bi2)); // 1
//		System.out.println(bi2.compareTo(bi1)); // -1
		
//		BigInt bi1, bi2, bi3;
//		bi1 = new BigInt("999");
//		bi2 = new BigInt("-1111");
//		bi3 = new BigInt();
//		System.out.println(bi1.negate()); // -999
//		System.out.println(bi2.negate()); // 1111
//		System.out.println(bi3.negate()); // 0
		
		BigInt bi1, bi2;
		bi1 = new BigInt("-45");
		bi2 = new BigInt("-54");
		System.out.println(bi1.max(bi2)); // -45
		System.out.println(bi2.max(bi1)); // -45
		System.out.println(bi1.min(bi2)); // -54
		System.out.println(bi2.min(bi1)); // -54
		
	}

}
