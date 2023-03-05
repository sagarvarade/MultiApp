package com.multiappui.URLS;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CallsWithOtherServicesTest {

	
	@Test
	public void checkUserCredentials() {
		try {
			
			String json = new StringBuilder().append("{\"username\":\"sagar\",\"password\":\"sagar\"}").toString();
			
			Map<Object, Object> userBody= Map.of("username","sagar","password","sagar");
			System.out.println(userBody.toString());
			HttpRequest request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(json))
					//.POST(ofFormData(userBody))
					.uri(new URI("http://localhost:8200/auth/authenticate"))
					.header("Content-Type", "application/json")
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> resp = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(resp.statusCode());
			System.out.println(resp.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
	        var builder = new StringBuilder();
	        for (Map.Entry<Object, Object> entry : data.entrySet()) {
	            if (builder.length() > 0) {
	                builder.append("&");
	            }
	            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
	            builder.append("=");
	            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
	        }
	        return HttpRequest.BodyPublishers.ofString(builder.toString());
	    }

}
