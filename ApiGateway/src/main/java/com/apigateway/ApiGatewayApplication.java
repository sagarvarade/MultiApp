package com.apigateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public HttpClient httpClient() {
	    return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}
	
}
//http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/INR
//http://localhost:8100/currency-conversion-feign/from/USD/INR/quantity/200
//http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/INR/quantity/200


//http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/INR/quantity/200
//http://localhost:8765/currency-exchange/currency-exchange/from/USD/INR