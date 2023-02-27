package com.HTTPClient.Interfaces;

public enum HTTPMethods {
	GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE"), PATCH("PATCH"), COPY("COPY");

	private String HTTPMethod;

	HTTPMethods(String string) {
		this.HTTPMethod = string;
	}

	public String getHTTPMethod() {
		return HTTPMethod.toString();
	}

}
