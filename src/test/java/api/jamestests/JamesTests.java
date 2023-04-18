package api.jamestests;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;
import api.jamestests.PostReqStarter;

/**
 * Unit test for simple App.
 */
public class JamesTests{

  static Response response;
  static Map<String, String> item;

  @BeforeAll
  static void init(){
    item = PostReqStarter.starter();
  }
  public static Response getResponse(){
    response=given().contentType("application/x-www-form-urlencoded").formParams(item).post("https://automationexercise.com/api/createAccount");
    return response;
  }

  public static Response deleteUser(){
    response=given().contentType("application/x-www-form-urlencoded").formParams(item.keySet().toArray()[1].toString(), item.get("email"), item.keySet().toArray()[2].toString(), item.get("password")).delete("https://automationexercise.com/api/deleteAccount");
    return response;
  }
  @Nested
  @DisplayName("Post request tests")
  class  PostRequestChecks{

    @Test
    @DisplayName("Check the response code")
    void checkTheStatusCode() {
      deleteUser();
      assertThat(getResponse().jsonPath().getString("responseCode"), equalTo("201"));
    }

    @Test
    @DisplayName("Check the status code")
    void checkTheResponseCode() {
      deleteUser();
      assertThat(getResponse().getStatusCode(), equalTo(200));
    }
    @Test
    @DisplayName("Check response body for success message")
    void checkResponseBodyForSuccessMesssage(){
      deleteUser();
      assertThat(getResponse().body().jsonPath().getString("message"), equalTo("User created!"));
    }

  }

  @Nested
  @DisplayName("Delete requests checks")
  class DeleteRequestChecks {
    @Test
    @DisplayName("Check the response code")
    void checkTheResponseCode() {
      getResponse();
      assertThat(deleteUser().jsonPath().getString("responseCode"), equalTo("200"));
    }

    @Test
    @DisplayName("Check the status code")
    void checkTheStatusCode() {
      getResponse();
      assertThat(deleteUser().getStatusCode(), equalTo(200));
    }
    @Test
    @DisplayName("Check response body for success message")
    void checkResponseBodyForSuccessMesssage(){
      getResponse();
      assertThat(deleteUser().body().jsonPath().getString("message"), equalTo("Account deleted!"));
    }
  }

}
