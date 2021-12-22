/**
 * 
 */
package com.learning.currency.conversion.currencyserviceconversion.bean;

import java.math.BigDecimal;

/**
 * @author Balaji
 *
 */
public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal conversionMultiple;
	private String environment;
	/**
	 * 
	 */
	public CurrencyConversion() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param from
	 * @param to
	 * @param quantity
	 * @param totalCalculatedAmount
	 * @param conversionMultiple
	 * @param environment
	 */
	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal totalCalculatedAmount,
			BigDecimal conversionMultiple, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the totalCalculatedAmount
	 */
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	/**
	 * @param totalCalculatedAmount the totalCalculatedAmount to set
	 */
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	/**
	 * @return the conversionMultiple
	 */
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	/**
	 * @param conversionMultiple the conversionMultiple to set
	 */
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}
	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	
	

}
