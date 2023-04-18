package api.chrisTests;

import api.JsonParser;
import api.endpoints.Routes;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerifyLoginWithValidDetailsTest {

    static Response response;
    static Map<String, String> items;

    @Order(1)
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class VerifyAccount {
        @Order(1)
        @Test
        @DisplayName("Login with Valid Details")
        void testLoginWithValidDetails() {
            items = JsonParser.createMap("src\\test\\resources\\user.json");
            response = given()
                    .contentType("application/x-www-form-urlencoded")
                    .formParams("email", items.get("email"), "password", items.get("password"))
                    .post(Routes.postLoginDetails_url);
            System.out.println(response.getBody().asString());
        }

        @Order(2)
        @Test
        @DisplayName("Test Login with Valid details response message")
        void testLoginWithValidDetailsResponseMessage() {
            assertThat(response.jsonPath().getString("message"), equalTo("User exists!"));
        }

        @Order(3)
        @Test
        @DisplayName("Test Login with Valid details response code should be 200")
        void testLoginWithValidDetailsResponseCodeShouldBe200() {
            assertThat(response.jsonPath().getString("responseCode"), equalTo("200"));
        }
    }


}
