package com.HTTPClient.Entity;

import java.net.URI;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
public class ResponseBody {
	private String body;
	private Object clazz;
	private int hashcode;
	private HttpHeaders headers;
	private int statuscode;
	private String respToString;
	private URI uri;
	private Version version;
	public String getBody() {
		return body;
	}
	public ResponseBody setBody(String body) {
		this.body = body;
		return this;
	}
	public Object getClazz() {
		return clazz;
	}
	public ResponseBody setClazz(Object clazz) {
		this.clazz = clazz;
		return this;
	}
	public int getHashcode() {
		return hashcode;
	}
	public ResponseBody setHashcode(int hashcode) {
		this.hashcode = hashcode;
		return this;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public ResponseBody setHeaders(HttpHeaders headers) {
		this.headers = headers;
		return this;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public ResponseBody setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getRespToString() {
		return respToString;
	}
	public ResponseBody setRespToString(String respToString) {
		this.respToString = respToString;
		return this;
	}
	public URI getUri() {
		return uri;
	}
	public ResponseBody setUri(URI uri) {
		this.uri = uri;
		return this;
	}
	public Version getVersion() {
		return version;
	}
	public ResponseBody setVersion(Version version) {
		this.version = version;
		return this;
	}
	@Override
	public String toString() {
		return "ResponseBody [body=" + body + ", clazz=" + clazz + ", hashcode=" + hashcode + ", headers=" + headers
				+ ", statuscode=" + statuscode + ", respToString=" + respToString + ", uri=" + uri + ", version="
				+ version + "]";
	}
	
}
