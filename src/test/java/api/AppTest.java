package api;

import api.endpoints.Routes;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

//    @Order(8)
//    @Test
//    @DisplayName("Testing API POST request for logging in without e-mail parameter")
//    void verifyForbiddenLoginWithoutEmailParameter(){
//
//        Response response = given().contentType("application/x-www-form-urlencoded").formParams("password","password")
//                .post(Routes.postLoginDetails_url);
//
//        response.jsonPath().get("message").equals("This request method is not supported.");
//
//    }
//
//    @Order(14)
//    @Test
//    @DisplayName("Testing API GET request for accessing user details by email")
//    void GETUserAccountByEmail(){
//
//        //when().get(Routes.getUserAccountByEmail_url).then().body("message",
//        //        Matchers.equalTo("Bad request, email parameter is missing in GET request."));
//
//        when().get(Routes.getUserAccountByEmail_url).getBody().print();
//        assertThat(when().get(Routes.getUserAccountByEmail_url).jsonPath().get("message")
//                ,Matchers.equalTo("Bad request, email parameter is missing in GET request."));
//
//
//    }





}
