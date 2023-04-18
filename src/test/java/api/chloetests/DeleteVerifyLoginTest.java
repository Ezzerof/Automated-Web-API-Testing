package api.chloetests;

import api.endpoints.Routes;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;




public class DeleteVerifyLoginTest {
    private static Response response;

    @BeforeAll
    public static void createResponse() {
      response = given().when().delete(Routes.postLoginDetails_url).then().extract().response();

    }

    @Test
    @DisplayName("Test that a delete request with verify Login returns a 405 status code")
    void TestThatADeleteRequestWithVerifyLoginReturnsA405StatusCode() {
           assertThat(response.jsonPath().getInt("responseCode"), equalTo(405));
    }

    @Test
    @DisplayName("Test that a delete request with verify login returns the correct message")
    void testThatADeleteRequestWithVerifyLoginReturnsTheCorrectMessage() {
        assertThat(response.jsonPath().getString("message"), equalTo("This request method is not supported."));
    }

    @Test
    @DisplayName("Test status code")
    void testStatusCode() {
     assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test
    @DisplayName("Test server header")
    void testServerHeader() {
     assertThat(response.header("server"), equalTo("cloudflare"));

    }

    @Test
    @DisplayName("Test content type is text/html")
    void testContentTypeIsTextHtml() {
     assertThat(response.contentType(), equalTo("text/html; charset=utf-8"));
    }


}
