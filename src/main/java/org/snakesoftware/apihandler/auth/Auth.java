package org.snakesoftware.apihandler.auth;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Auth {
    private String authToken;

    private String email = "aludwig@paradigma.com";



    public void performConnection () {
        HttpClient client = HttpClient.newHttpClient();


        // JSON data payload from curl
        String jsonData = "{\n" +
                "  \"email\": \"aludwig@paradigma.com\",\n" +
                "  \"password\": \"51040336Millo\"\n" +
                "}";

        // Create HttpRequest with POST method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.aivo.co/api/v1/user/login-simple"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();

        // Send the request asynchronously and handle the response
       authToken = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
               .thenApply(HttpResponse::body) // Extract the body of the response
               .join(); // Wait for the completion and retrieve the result// Wait for the completion
    }

    public String getAuthToken() {
        return authToken;
    }

}
