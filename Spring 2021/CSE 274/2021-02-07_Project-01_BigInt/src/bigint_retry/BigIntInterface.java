package bigint_retry;

public interface BigIntInterface {
	
	public BigInt add(BigInt other);
	public BigInt subtract(BigInt other);
	public BigInt negate();
	public BigInt abs();
	
	public int compareTo(BigInt other);
	public BigInt max(BigInt other);
	public BigInt min(BigInt other);
	public int signum();
	
	public BigInt valueOf(long value);
	
}
