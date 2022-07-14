package org.acme.rest.client;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@Path("/iss")
public class IssRessource {
    private static final String ISS_URL = "https://api.wheretheiss.at/v1/satellites/25544";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ISSResponse getExposition() {

        HttpClient client = HttpClient.newHttpClient();
        ISSResponse response = new ISSResponse();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ISS_URL)).build();
        JsonObject issValue = new JsonObject(client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).join());
        Long timestampIss = issValue.getLong("timestamp");
        String visibilityIss = issValue.getString("visibility");
        if (Objects.equals(visibilityIss, "daylight")) {
            response.setExposed(true);
        }
        ZonedDateTime utc = Instant.ofEpochSecond(timestampIss).atZone(ZoneOffset.UTC);
        response.setLastExposedDate(Date.from(utc.toInstant()));
        return response;
    }
}
