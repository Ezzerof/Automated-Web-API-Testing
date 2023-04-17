package api;

import api.endpoints.Routes;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

    @Test
    @DisplayName("Testing API POST request for logging in without e-mail parameter")
    void verifyForbiddenLoginWithoutEmailParameter(){
        //System.out.println(when().post(Routes.postLoginDetails_url).getStatusCode());
        when().post("https://automationexercise.com/api/verifyLogin/")
                .then().body("message", Matchers.equalTo("This request method is not supported."));

    }

    @Test
    @DisplayName("Testing API GET request for accessing user details by email")
    void GETUserAccountByEmail(){

        //when().get(Routes.getUserAccountByEmail_url).then().body("message",
        //        Matchers.equalTo("Bad request, email parameter is missing in GET request."));

        when().get(Routes.getUserAccountByEmail_url).getBody().print();
        assertThat(when().get(Routes.getUserAccountByEmail_url).jsonPath().get("message")
                ,Matchers.equalTo("Bad request, email parameter is missing in GET request."));


    }





}
