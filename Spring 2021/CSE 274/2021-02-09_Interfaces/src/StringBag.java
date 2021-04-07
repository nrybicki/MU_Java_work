
public interface StringBag {
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean add(String str);
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean remove(String str);
	
	/**
	 * 
	 * @return
	 */
	public String remove();
	
	/**
	 * 
	 * @return
	 */
	public int size();
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public boolean contains(String str);
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public int getFrequency(String str);
	
	/**
	 * 
	 * @return
	 */
	public String[] toArray();
	
	/**
	 * 
	 */
	public void clear();
	
}
