/**
 * 
 */
package com.learning.microservices.springcloudconfigserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Balaji
 *
 */
@RestController
public class PingController {

	/**
	 * 
	 */
	public PingController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "Success";
	}

}
