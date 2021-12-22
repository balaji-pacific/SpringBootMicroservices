/**
 * 
 */
package com.learning.api.gateway.apigateway.bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Balaji
 *
 */

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f-> f.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("MyParameter", "MyParam"))
				.uri("http://httpbin.org:80"))
				
				.route(p -> p.path("/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE"))
				
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
				
				.route(p -> p.path("/currency-conversion-balaji/**").filters(f -> f.rewritePath("/currency-conversion-balaji/", "/currency-conversion-feign/"))
						.uri("lb://currency-conversion"))
				
				.route(p -> p.path("/currency-conversion-vasuki/**").filters(f -> f.rewritePath("/currency-conversion-vasuki/", "/currency-conversion-feign/"))
						.uri("lb://currency-conversion"))
				
				.route(p -> p.path("/currency-conversion-yashika/**").filters(f -> f.rewritePath("/currency-conversion-yashika/", "/currency-conversion-feign/"))
						.uri("lb://currency-conversion"))
				.build();
	}

}
