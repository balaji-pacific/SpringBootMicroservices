/**
 * 
 */
package com.learning.currency.conversion.currencyserviceconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.currency.conversion.currencyserviceconversion.bean.CurrencyConversion;
import com.learning.currency.conversion.currencyserviceconversion.bean.CurrencyExchangeProxy;

/**
 * @author Balaji
 *
 */
@RestController
public class CurrencyServiceConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion currencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariable);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), currencyConversion.getConversionMultiple().multiply(quantity), currencyConversion.getEnvironment() + " From Rest Template");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion currencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), currencyConversion.getConversionMultiple().multiply(quantity), currencyConversion.getEnvironment() + " From Feigh");
	}
}
