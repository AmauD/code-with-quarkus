package org.acme.rest.client;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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
import java.util.Date;

//@RegisterRestClient(baseUri = "http://localhost:8080")
//@Path("/iss")
public interface IssService {
//    String ISS_URL = "https://api.wheretheiss.at/v1/satellites/25544";
//    public static ISSResponse issResponse = new ISSResponse();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    default Response getExposition() {
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ISS_URL)).build();
//        JsonObject issValue = new JsonObject(client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).join());
//        Long timestampIss = issValue.getLong("timestamp");
//        Timestamp ts = new Timestamp(timestampIss);
//        issResponse.setLastExposedDate(new Date(ts.getTime()));
//        return Response.ok(issResponse).build();
//    }

}
