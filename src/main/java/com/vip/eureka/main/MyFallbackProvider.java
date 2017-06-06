package com.vip.eureka.main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {
	
    public String getRoute() {
        return "app-service2";
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            public int getRawStatusCode() throws IOException {
                return 200;
            }

            public String getStatusText() throws IOException {
                return "OK";
            }

            public void close() {

            }

            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("fallback"+MyFallbackProvider.this.getRoute()).getBytes());
            }

            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}