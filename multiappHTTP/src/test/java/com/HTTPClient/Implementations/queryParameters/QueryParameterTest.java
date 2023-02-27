package com.HTTPClient.Implementations.queryParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.http.HttpClient.Version;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.HTTPClient.Entity.RequestBody;
import com.HTTPClient.Entity.ResponseBody;
import com.HTTPClient.Implementations.HTTPClientImpl;
import com.HTTPClient.Interfaces.HTTPMethods;

public class QueryParameterTest {

	HTTPClientImpl imp = new HTTPClientImpl();
	@Test
	void getTest() {
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org/delete")
				.setHeaders(Map.of("accept", "application/json"))
				.setMethod(HTTPMethods.DELETE)
				.setVersion(Version.HTTP_1_1)
				.setBodyData(Collections.emptyMap())
				.setPathParameters(List.of("abc","xyz"))
				.setQueryParameters(Map.of("id","13","srno","988"));
		
		ResponseBody responseBody = imp.get(req);

		assertEquals(200, responseBody.getStatuscode());
	}
	@Test
	void getTest2() {
		//curl -X GET "https://httpbin.org/robots.txt" -H "accept: text/plain"
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org")
				.setHeaders(Map.of("accept", "text/plain"))
				.setMethod(HTTPMethods.GET)
				.setVersion(Version.HTTP_2)
				.setPathParameters(List.of("robots.txt"));
		
		ResponseBody responseBody = imp.get(req);
		System.out.println(responseBody.getBody());

		assertEquals(200, responseBody.getStatuscode());
	}
}
