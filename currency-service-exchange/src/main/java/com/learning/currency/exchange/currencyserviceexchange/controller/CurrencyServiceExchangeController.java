/**
 * 
 */
package com.learning.currency.exchange.currencyserviceexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.currency.exchange.currencyserviceexchange.bean.CurrencyExchange;
import com.learning.currency.exchange.currencyserviceexchange.data.CurrencyServiceRepository;

/**
 * @author Balaji
 *
 */

@RestController
public class CurrencyServiceExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyServiceRepository currencyServiceRepo;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange =currencyServiceRepo.findExchangeByFromAndTo(from, to);	
		if(currencyExchange == null) {
			
			throw new RuntimeException("Unable to find the data for " + from + " and " + to);
			
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));		
		return currencyExchange ;				
	}

}
