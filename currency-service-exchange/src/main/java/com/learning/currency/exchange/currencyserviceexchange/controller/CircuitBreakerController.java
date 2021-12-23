/**
 * 
 */
package com.learning.currency.exchange.currencyserviceexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Balaji
 *
 */
@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod="hardcodedResponse")
	public String sampleAPI() {
		logger.info("Entering Sample API");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummysite", String.class);
		return responseEntity.getBody();
	}
	
	@GetMapping("rate-limiter")
	@RateLimiter(name="default")
	public String sampleAPIRateLimiter() {
		logger.info("Rate Limiter");
		return "rate-limiter";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Hardcoded response";		
	}
}
