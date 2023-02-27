package com.HTTPClient.Entity;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.BodyPublisher;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import com.HTTPClient.Interfaces.HTTPMethods;

public class RequestBody {
	private String URI;
	private Map<String, String> headers;
	private Version version;
	private HTTPMethods method;
	private BodyPublisher bodyPublisher;
	private Map<Object, Object> bodyData;

	public String getURI() {
		return URI;
	}

	public RequestBody setURI(String uRI) {
		URI = uRI;
		return this;
	}

	public Map<String, String> getHeaders() {
		if (this.headers == null || this.headers.isEmpty())
			return Collections.emptyMap();
		return headers;
	}

	public RequestBody setHeaders(Map<String, String> headers) {
		this.headers = headers;
		return this;
	}

	public Version getVersion() {
		if (this.version == null)
			return Version.HTTP_1_1;
		return version;
	}

	public RequestBody setVersion(Version version) {
		this.version = version;
		return this;
	}

	public String getMethod() {
		if (this.method == null)
			throw new RuntimeException("Method Must be set to run HTTPClient");
		return method.toString();
	}

	public RequestBody setMethod(HTTPMethods method) {
		this.method = method;
		return this;
	}

	public BodyPublisher getBodyPublisher() {
		if (this.bodyPublisher == null)
			return ofFormData(Collections.emptyMap());
		return bodyPublisher;
	}

	public Map<Object, Object> getBodyData() {
		if (this.bodyData == null || this.bodyData.isEmpty())
			return Collections.emptyMap();
		return bodyData;
	}

	public RequestBody setBodyData(Map<Object, Object> bodyData) {
		this.bodyPublisher = ofFormData(bodyData);
		this.bodyData = bodyData;
		return this;
	}

	@Override
	public String toString() {
		return "RequestBody [URI=" + URI + ", headers=" + headers + ", version=" + version + ", method=" + method
				+ ", bodyPublisher=" + bodyPublisher + ", bodyData=" + bodyData + "]";
	}

	public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
		StringBuilder builder = new StringBuilder();
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
