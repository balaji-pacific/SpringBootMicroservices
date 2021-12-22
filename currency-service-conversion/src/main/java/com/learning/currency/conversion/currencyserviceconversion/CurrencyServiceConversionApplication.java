package com.learning.currency.conversion.currencyserviceconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyServiceConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyServiceConversionApplication.class, args);
	}

}
