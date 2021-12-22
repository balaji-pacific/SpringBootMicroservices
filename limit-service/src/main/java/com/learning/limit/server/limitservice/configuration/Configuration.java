/**
 * 
 */
package com.learning.limit.server.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Balaji
 *
 */
@Component
@ConfigurationProperties("limits-service")
public class Configuration {

	/**
	 * 
	 */
	public Configuration() {
		// TODO Auto-generated constructor stub
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
