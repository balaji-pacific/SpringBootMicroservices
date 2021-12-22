/**
 * 
 */
package com.learning.limit.server.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.limit.server.limitservice.bean.Limits;
import com.learning.limit.server.limitservice.configuration.Configuration;

/**
 * @author Balaji
 *
 */
@RestController
public class LimitController {
	
	@Autowired
	private Configuration configuration;

	/**
	 * 
	 */
	public LimitController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}

}
