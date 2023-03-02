package com.apigateway;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path ,{} ", exchange.getRequest().getPath());
		String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
		String[] parts = authHeader.split(" ");
		System.out.println("Parts : " + Arrays.toString(parts));
		if (parts.length != 2 || !"Bearer".equals(parts[0])) {
			throw new RuntimeException("Incorrect authorization structure");
		}

		int response = httpClient(parts[1]);
		System.out.println("Response from Auth " + response);
		if (response != 200) {
			throw new RuntimeException("Token is not valid " + response);
		}
		return chain.filter(exchange);
	}
	
	public int httpClient(String string) {
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8200/auth/testtoken"))
					.header("Authorization", "Bearer " + string).GET().build();
			HttpClient httpClient = HttpClient.newHttpClient();
			java.net.http.HttpResponse<String> resp = httpClient.send(request,
					java.net.http.HttpResponse.BodyHandlers.ofString());
			String body = resp.body();
			int respCode = resp.statusCode();
			System.out.println("F!1" +body);
			System.out.println("F!1 respCode respCode" +body);
			return respCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
