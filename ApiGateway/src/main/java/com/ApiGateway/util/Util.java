package com.ApiGateway.util;

import java.io.IOException;
import java.net.URISyntaxException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Util {
	public static void main(String[] args) throws URISyntaxException ,IOException{
		test1();
	}

	private static void test1() throws URISyntaxException, IOException {

		OkHttpClient client=new OkHttpClient();
		Request request = new Request.Builder().url("http://localhost:8200/auth/testtoken")
				.addHeader("Authorization",
						"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYWdhciIsImlhdCI7MTY3NzM5MTU2MCwiZXhwIjoxNjc3MzkzMzYwfQ.5XaijOKUO8suRLiGkP9t2y9f_Os2xxSYIM8KP7NlweQ")
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.code());

		System.out.println(response.body().toString());
	}
}
