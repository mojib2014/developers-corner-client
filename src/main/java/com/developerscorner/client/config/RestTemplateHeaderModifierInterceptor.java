package com.developerscorner.client.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
	
	private String token;
	
	public RestTemplateHeaderModifierInterceptor(String token) {
		this.token = token;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add(HttpHeaders.AUTHORIZATION, " " +  token);
		ClientHttpResponse response = execution.execute(request, body);
		return response;
	}

}
