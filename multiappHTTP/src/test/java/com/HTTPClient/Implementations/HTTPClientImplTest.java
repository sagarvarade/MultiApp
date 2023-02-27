package com.HTTPClient.Implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.HTTPClient.Entity.ResponseBody;

class HTTPClientImplTest {
	// curl -X GET "https://httpbin.org/get" -H "accept: application/json"
	// curl -X GET "https://httpbin.org/get" -H "accept: application/json"
	// curl -X PATCH "https://httpbin.org/patch" -H "accept: application/json"
	HTTPClientImpl imp = new HTTPClientImpl();

	@Test
	@Disabled
	void getTest() {
		ResponseBody responseBody = imp.get("http://httpbin.org/get", Map.of("accept", "application/json"),
				Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void getTest2() {
		ResponseBody responseBody = imp.get("http://httpbin.org/get", Collections.emptyMap(), Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void getTest3() {
		ResponseBody responseBody = imp.get("http://httpbin.org/get", Collections.emptyMap(), null);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void deleteTest() {
		ResponseBody responseBody = imp.delete("http://httpbin.org/delete", Map.of("accept", "application/json"),
				Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void deleteTest2() {
		ResponseBody responseBody = imp.delete("http://httpbin.org/delete", Collections.emptyMap(), Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void deleteTest3() {
		ResponseBody responseBody = imp.delete("http://httpbin.org/delete", Collections.emptyMap(), null);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void patchTest() {
		ResponseBody responseBody = imp.patch("http://httpbin.org/patch", Map.of("accept", "application/json"),
				Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}

	@Test
	@Disabled
	void postTest() {
		ResponseBody responseBody = imp.post("http://httpbin.org/post","",Map.of("accept", "application/json"),
				Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}
	
	@Test
	@Disabled
	void putTest() {
		ResponseBody responseBody = imp.put("http://httpbin.org/put","",Map.of("accept", "application/json"),
				Version.HTTP_2);
		assertEquals(200, responseBody.getStatuscode());
	}


	public int httpClient(String string) {
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8200/auth/testtoken"))
					.header("Authorization", "Bearer " + string).GET().build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> resp = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
			String body = resp.body();
			int respCode = resp.statusCode();
			System.out.println("F!1" + body);
			System.out.println("F!1 respCode respCode" + body);
			return respCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
