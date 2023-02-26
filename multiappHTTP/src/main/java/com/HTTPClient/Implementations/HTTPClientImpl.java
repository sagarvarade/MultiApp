package com.HTTPClient.Implementations;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.HTTPClient.Entity.ResponseBody;
import com.HTTPClient.Interfaces.HTTPClient;

public class HTTPClientImpl implements HTTPClient {

	HttpClient httpClient = HttpClient.newHttpClient();

	public ResponseBody get(String uri, Map<String, String> headers, Version version) {
		ResponseBody rsp = new ResponseBody();
		try {
			Builder bltRequest = HttpRequest.newBuilder().uri(new URI(uri))
					.version(version == null ? Version.HTTP_1_1 : version);
			for (Entry<String, String> ent : headers.entrySet()) {
				bltRequest.header(ent.getKey(), ent.getValue());
			}
			HttpRequest request = bltRequest.GET().build();
			HttpResponse<String> resp = httpClient.send(request, BodyHandlers.ofString());
			rsp.setBody(resp.body()).setClazz(resp.getClass()).setHashcode(resp.hashCode()).setHeaders(resp.headers())
					.setStatuscode(resp.statusCode()).setRespToString(resp.toString()).setUri(resp.uri())
					.setVersion(resp.version());
			return rsp;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResponseBody delete(String uri, Map<String, String> headers, Version version) {
		ResponseBody rsp = new ResponseBody();
		try {
			Builder bltRequest = HttpRequest.newBuilder().uri(new URI(uri))
					.version(version == null ? Version.HTTP_1_1 : version);
			for (Entry<String, String> ent : headers.entrySet()) {
				bltRequest.header(ent.getKey(), ent.getValue());
			}
			HttpRequest request = bltRequest.DELETE().build();
			HttpResponse<String> resp = httpClient.send(request, BodyHandlers.ofString());
			rsp.setBody(resp.body()).setClazz(resp.getClass()).setHashcode(resp.hashCode()).setHeaders(resp.headers())
					.setStatuscode(resp.statusCode()).setRespToString(resp.toString()).setUri(resp.uri())
					.setVersion(resp.version());
			return rsp;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResponseBody patch(String uri, Map<String, String> headers, Version version) {
		ResponseBody rsp = new ResponseBody();
		try {
			Builder bltRequest = HttpRequest.newBuilder().uri(new URI(uri))
					.version(version == null ? Version.HTTP_1_1 : version);
			for (Entry<String, String> ent : headers.entrySet()) {
				bltRequest.header(ent.getKey(), ent.getValue());
			}
			HttpRequest request = bltRequest.method("PATCH", ofFormData(Collections.emptyMap())).build();
			HttpResponse<String> resp = httpClient.send(request, BodyHandlers.ofString());
			rsp.setBody(resp.body()).setClazz(resp.getClass()).setHashcode(resp.hashCode()).setHeaders(resp.headers())
					.setStatuscode(resp.statusCode()).setRespToString(resp.toString()).setUri(resp.uri())
					.setVersion(resp.version());
			return rsp;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseBody post(String uri,String body, Map<String, String> headers, Version version) {
		ResponseBody rsp = new ResponseBody();
		BodyPublisher br= HttpRequest.BodyPublishers.ofString(body);
		try {
			Builder bltRequest = HttpRequest.newBuilder().uri(new URI(uri))
					.version(version == null ? Version.HTTP_1_1 : version);
			for (Entry<String, String> ent : headers.entrySet()) {
				bltRequest.header(ent.getKey(), ent.getValue());
			}
			HttpRequest request = bltRequest.POST(br).build();
			HttpResponse<String> resp = httpClient.send(request, BodyHandlers.ofString());
			rsp.setBody(resp.body()).setClazz(resp.getClass()).setHashcode(resp.hashCode()).setHeaders(resp.headers())
					.setStatuscode(resp.statusCode()).setRespToString(resp.toString()).setUri(resp.uri())
					.setVersion(resp.version());
			return rsp;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseBody put(String uri,String body, Map<String, String> headers, Version version) {
		ResponseBody rsp = new ResponseBody();
		BodyPublisher br= HttpRequest.BodyPublishers.ofString(body);
		try {
			Builder bltRequest = HttpRequest.newBuilder().uri(new URI(uri))
					.version(version == null ? Version.HTTP_1_1 : version);
			for (Entry<String, String> ent : headers.entrySet()) {
				bltRequest.header(ent.getKey(), ent.getValue());
			}
			HttpRequest request = bltRequest.PUT(br).build();
			HttpResponse<String> resp = httpClient.send(request, BodyHandlers.ofString());
			rsp.setBody(resp.body()).setClazz(resp.getClass()).setHashcode(resp.hashCode()).setHeaders(resp.headers())
					.setStatuscode(resp.statusCode()).setRespToString(resp.toString()).setUri(resp.uri())
					.setVersion(resp.version());
			return rsp;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
