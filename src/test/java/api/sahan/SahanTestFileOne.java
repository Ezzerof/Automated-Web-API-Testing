package api.sahan;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SahanTestFileOne {




    private static ResponseSpecification responseSpecification;
    private static Response response;

    public static Response responseWithVariable;
    @BeforeAll
    public static void createResponseSpecification(){
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

    }


    @BeforeAll
    public static void init(){
        response =
                given()
                        .when()
                        .get("https://automationexercise.com/api/getUserDetailByEmail")
                        .then().extract().response();
        responseWithVariable =
                given()
                .when()
                .get("https://automationexercise.com/api/getUserDetailByEmail?email")
                        .then().extract().response();


        //url one gets a response code 200. the other does not

       // response = get("https://automationexercise.com/api/getUserDetailByEmail");

    }


    @Test
    @DisplayName("test 1")
    public void test1() {
        System.out.println(response.asString());
        System.out.println(responseWithVariable.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

      //  System.out.println(get("/email").then().body("user.id", equalTo(17867)));
   //     System.out.println(response.getClass());

        }

   @Nested
   public class StatusCheckers{

       //test status code
       @Test
       @DisplayName("Check status code is correct")
       public void checkStatusCodeIsCorrect() {
           response
                   .then()
                   .assertThat()
                   .statusCode(200);
       }



   }


   @Nested
   public class TestDataGotten{

       @Test
       @DisplayName("JIR-12 Check ID is gotten from params")
       public void jir12CheckIdIsGottenFromParams() {
           //when email parameter is in the URL, user id will return this value
           assertThat(
                   responseWithVariable
                           .jsonPath()
                           .getString("user.id"), equalTo("17867"));
       }

       @Test
       @DisplayName("JIR-12 Check name is gotten")
       public void jir12CheckNameIsGotten() {
           assertThat(
                   responseWithVariable
                           .jsonPath()
                           .getString("user.name"),equalTo("Rana")
           );
           }




   }











}
