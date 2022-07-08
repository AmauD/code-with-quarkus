package org.acme.controller;

import io.vertx.core.json.JsonObject;
import org.acme.model.ISSResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.util.Date;

@Path("/iss")

public class ISSController {
    private static final String ISS_URL = "https://api.wheretheiss.at/v1/satellites/25544";

    @GET
    @Produces
    public ISSResponse getExposition() {
        long issSunRateExposure = 16;
        boolean issSunExposition = true;
        // Calculer le nombre de cycle, prendre en compte le timestamp de l'url pour savoir si l'ISS est exposé ou non.


        HttpClient client = HttpClient.newHttpClient();
        ISSResponse response = new ISSResponse();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ISS_URL)).build();
        JsonObject issValue = new JsonObject(client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).join());
        Long timestampIss = issValue.getLong("timestamp");
        Timestamp ts = new Timestamp(timestampIss);
        response.setLastExposedDate(new Date(ts.getTime()));
        return response;
    }
}
