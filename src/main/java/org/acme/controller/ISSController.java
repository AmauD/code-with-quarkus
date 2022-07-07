package org.acme.controller;

import org.acme.model.ISS;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ISSController {
    private static final String ISS_URL = "https://api.wheretheiss.at/v1/satellites/25544";
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Void getExposition() {
        HttpClient client = HttpClient.newHttpClient();
        ISS iss = new ISS();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ISS_URL)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join();
    }
}
