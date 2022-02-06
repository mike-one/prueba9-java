package com.cuenca;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class CuencaClient {

    private String apiKeyId;
    private String apiSecret;
    private HttpClient client;

    public CuencaClient(String apiKeyId, String apiSecret) {
        this.apiKeyId = apiKeyId;
        this.apiSecret = apiSecret;
        if (client == null) this.client = HttpClient.newBuilder().build();
    }

    public CuencaClient(String apiKeyId, String apiSecret, HttpClient client) {
        this.apiKeyId = apiKeyId;
        this.apiSecret = apiSecret;
        this.client = client;
    }

    public HttpResponse<String> post(String endpoint, String body) throws Exception {
        return request("POST", endpoint, body);
    }

    public HttpResponse<String> get(String endpoint) throws Exception {
        return request("GET", endpoint, "");
    }
    public HttpResponse<String> get(String endpoint, String body) throws Exception {
        return request("GET", endpoint, body);
    }

    public HttpResponse<String> patch(String endpoint, String body) throws Exception {
        return request("PATCH", endpoint, body);
    }

    public HttpResponse<String> delete(String endpoint) throws Exception {
        return request("DELETE", endpoint, "");
    }

    public HttpResponse<String> delete(String endpoint, String body) throws Exception {
        return request("DELETE", endpoint, body);
    }

    private HttpResponse<String> request(String method, String endpoint, String body) throws Exception {
        HttpRequest.BodyPublisher jsonPayload = HttpRequest.BodyPublishers.ofString(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .method(method, jsonPayload)
                .setHeader("Authorization", getAuthHeader())
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    private String getAuthHeader() {
        String plainCredentials = apiKeyId + ":" + apiSecret;
        String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
        return  "Basic " + base64Credentials;
    }
}
