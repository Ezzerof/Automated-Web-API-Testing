package api.katietest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static api.endpoints.Routes.postLoginDetails_url;
import static api.endpoints.Routes.postSearchProduct_url;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginInvalidDetailsTest {
    private static Response response;
    @BeforeAll
    public static void inti(){
        response = CreateResponseWithParams.addLoginCredentials(postLoginDetails_url, "bob@bob.com", "12345");
//        response = given().log().all().contentType("application/x-www-form-urlencoded")
//                .formParams("email", "bob@bob.com", "password", "12345")
//                .post(postLoginDetails_url);

//        response = given().log().all().when().post(postLoginDetails_url + "?password=1234&email=bob@bob.com");
    }

    @Test
    @DisplayName("Check the Content Type")
    void checkTheContentType() {
        response
                .then()
                .assertThat()
                .contentType(ContentType.HTML);
    }

    @Nested
    @DisplayName("Tests for the body")
    class TestsForTheBody{

        @Test
        @DisplayName("Invalid Login test Message")
        void invalidLoginTestMessage() {
            assertThat(response.jsonPath().getString("message"), equalTo("User not found!"));
        }

        @Test
        @DisplayName("Invalid Login test response Code")
        void invalidLoginTestResponseCode() {
            assertThat(response.jsonPath().getInt("responseCode"), equalTo(404));

        }

    }

    @Nested
    @DisplayName("Testing Headers and Status Code")
    class TestingHeadersAndStatusCode {

        @Test
        @DisplayName("Testing Status Code")
        void testingStatusCode() {
            response
                    .then()
                    .assertThat()
                    .statusCode(200);
        }
        
        @Test
        @DisplayName("Test The Amount Of Headers")
        void testTheAmountOfHeaders() {
            int sizeOfHeaders = response.getHeaders().size();
            MatcherAssert.assertThat(sizeOfHeaders, is(18));
        
        }

        @Test
        @DisplayName("Test Server Name")
        void testServerName() {
            response
                    .then()
                    .assertThat()
                    .header("server", "cloudflare");

        }
    }
}
