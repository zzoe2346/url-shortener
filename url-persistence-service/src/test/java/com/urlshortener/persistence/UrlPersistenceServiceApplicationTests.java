package com.urlshortener.persistence;

import com.urlshortener.persistence.dto.UrlPersistenceRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlPersistenceServiceApplicationTests {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Order(1)
    void shouldSaveOriginUrlAndShortUrl() {
        UrlPersistenceRequest urlPersistenceRequest = new UrlPersistenceRequest("origin0", "short0");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(urlPersistenceRequest)

                .when()
                .post("/api/persistence")

                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @Order(2)
    void shouldGetOriginalUrlWhenExistShortUrlPath() {
        RestAssured
                .given()

                .when()
                .get("/api/persistence/{shortUrl}", "short0")

                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("originalUrl", Matchers.equalTo("origin0"));
    }

    @Test
    @Order(2)
    void shouldGet404ResponseWhenNotExistShortUrlPath() {
        RestAssured
                .given()

                .when()
                .get("/api/persistence/{shortUrl}", "short999")

                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
