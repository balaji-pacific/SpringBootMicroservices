/**
 * 
 */
package com.learning.limit.server.limitservice.bean;

/**
 * @author Balaji
 *
 */
public class Limits {

	/**
	 * 
	 */
	public Limits() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param minimum
	 * @param maximum
	 */
	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}



	private int minimum;
	private int maximum;
	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}
	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}
	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
