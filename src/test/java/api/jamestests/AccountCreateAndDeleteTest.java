package api.jamestests;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;
import api.JsonParser;
import api.endpoints.Routes;


@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class AccountCreateAndDeleteTest {

  static Response response;
  static Map<String, String> item;

  public static Response createUser(){
    response=given().contentType("application/x-www-form-urlencoded").formParams(item).post(Routes.postUserAccount_url);
    return response;
  }

  public static Response deleteUser(){
    response=given().contentType("application/x-www-form-urlencoded").formParams(item.keySet().toArray()[1].toString(), item.get("email"), item.keySet().toArray()[2].toString(), item.get("password")).delete(Routes.deleteUserAccount_url);
    return response;
  }
  @BeforeAll
  static void init(){
    item = JsonParser.createMap("src/test/resources/user.json");
  }
  @Order(1)
  @Nested
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  @DisplayName("Delete requests checks")
  class DeleteRequestChecks {
    @BeforeAll
     void delete(){
      AccountCreateAndDeleteTest.deleteUser();
    }
    @Test
    @DisplayName("Check the response code")
    void checkTheResponseCode() {
      assertThat(response.jsonPath().getString("responseCode"), equalTo("200"));
    }
    @Test
    @DisplayName("Check the status code")
    void checkTheStatusCode() {
      assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test
    @DisplayName("Check response body for success message")
    void checkResponseBodyForSuccessMesssage(){
      assertThat(response.body().jsonPath().getString("message"), equalTo("Account deleted!"));
    }
  }
  @Order(2)
  @Nested
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  @DisplayName("Post request tests")
  class  PostRequestChecks{

    @BeforeAll
    void createUser(){
      AccountCreateAndDeleteTest.createUser();
    }

    @Test
    @DisplayName("Check the response code")
    void checkTheStatusCode() {
      assertThat(response.jsonPath().getString("responseCode"), equalTo("201"));
    }

    @Test
    @DisplayName("Check the status code")
    void checkTheResponseCode() {
      assertThat(response.getStatusCode(), equalTo(200));
    }
    @Test
    @DisplayName("Check response body for success message")
    void checkResponseBodyForSuccessMesssage(){
      assertThat(response.body().jsonPath().getString("message"), equalTo("User created!"));
    }

  }

}
