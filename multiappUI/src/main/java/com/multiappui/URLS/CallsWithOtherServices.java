package com.multiappui.URLS;


import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class CallsWithOtherServices {
	private Logger logger = LoggerFactory.getLogger(CallsWithOtherServices.class);

	@Autowired
	private Environment env;

	private String API_GATEWAY_URL;
	
	@PostConstruct
	private void postConstruct() {
	    this.API_GATEWAY_URL = env.getProperty("multiapp.auth_service_url");
	}

	public HttpResponse<String> checkUserCredentials(String username,String password) {
		try {
			logger.info("Checking usercredentials , {} ", username);
			logger.info("Checking with url ,{} ,",API_GATEWAY_URL,"/auth/authenticate");
			String json = new StringBuilder()
	                .append("{\"username\":\""+username+"\",\"password\":\""+password+"\"}").toString();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(API_GATEWAY_URL + "/auth/authenticate"))
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.header("Content-Type", "application/json")
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> resp = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

