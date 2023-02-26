package com.ApiGateway;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path ,{} ", exchange.getRequest().getPath());
		String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
		String[] parts = authHeader.split(" ");
		System.out.println("Parts : "+Arrays.toString(parts));
		if (parts.length != 2 || !"Bearer".equals(parts[0])) {
			throw new RuntimeException("Incorrect authorization structure");
		}
		
		int response=checkTokenWithAuthorizationServer(parts[1]);
		System.out.println("Response from Auth "+response);
		if (response!=200) {
			throw new RuntimeException("Token is not valid "+response);
		}
		return chain.filter(exchange);
	}

	private int checkTokenWithAuthorizationServer(String string) {
		int responseCode=0;
		try {
			OkHttpClient client=new OkHttpClient();
			Request request = new Request.Builder().url("http://localhost:8200/auth/testtoken")
					.addHeader("Authorization",
							"Bearer "+string)
					.build();
			Response response=client.newCall(request).execute();
			System.out.println("Response :"+response);
			responseCode=response.code();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseCode;
	}

}
