/**
 * 
 */
package com.learning.currency.exchange.currencyserviceexchange.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.currency.exchange.currencyserviceexchange.bean.CurrencyExchange;

/**
 * @author Balaji
 *
 */
@Repository
public interface CurrencyServiceRepository extends JpaRepository<CurrencyExchange, Integer>{
	CurrencyExchange findExchangeByFromAndTo(String from, String to);
}
