package com.HTTPClient.Implementations.emptyObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.http.HttpClient.Version;
import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.HTTPClient.Entity.RequestBody;
import com.HTTPClient.Entity.ResponseBody;
import com.HTTPClient.Implementations.HTTPClientImpl;
import com.HTTPClient.Interfaces.HTTPMethods;

public class HTTPClientObjectDeleteTest {
	HTTPClientImpl imp = new HTTPClientImpl();
	@Test
	void getTest() {
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org/delete")
				.setHeaders(Map.of("accept", "application/json"))
				.setMethod(HTTPMethods.DELETE)
				.setVersion(Version.HTTP_1_1)
				.setBodyData(Collections.emptyMap());
		
		ResponseBody responseBody = imp.get(req);

		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	void getTest2() {
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org/delete")
				.setHeaders(Map.of("accept", "application/json"))
				.setMethod(HTTPMethods.DELETE)
				.setVersion(Version.HTTP_1_1);
		
		ResponseBody responseBody = imp.get(req);

		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	void getTest3() {
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org/delete")
				.setMethod(HTTPMethods.DELETE)
				.setVersion(Version.HTTP_1_1);
		
		ResponseBody responseBody = imp.get(req);

		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	void getTest4() {
		RequestBody req = new RequestBody();
		req.setURI("http://httpbin.org/delete")
				.setMethod(HTTPMethods.DELETE);
		ResponseBody responseBody = imp.get(req);
		assertEquals(200, responseBody.getStatuscode());
	}
}
