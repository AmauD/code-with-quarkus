package org.acme.rest.client;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class IssRessourceTest {

    @TestHTTPEndpoint(IssRessource.class)

    @Test
    void getExposition() {
        given()
                .when().get("/iss")
                .then()
                .statusCode(404)
                .body(isA(String.class));
    }
}