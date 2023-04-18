package api.sahan;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.MatcherAssert.*;

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

       @Test
       @DisplayName("Test response code is correct")
       public void testResponseCodeIsCorrect() {
           assertThat(
                   responseWithVariable
                           .jsonPath()
                           .getInt("responseCode"), equalTo(200));
           }

       @Test
       @DisplayName("Test that response code is 400 when no email parameters are inserted")
       public void testThatResponseCodeIs400WhenNoEmailParametersAreInserted() {
           assertThat(
                   response
                           .jsonPath()
                           .getInt("responseCode"), equalTo(400));
           }
   }


   @Nested
   public class HeaderTests{
        @Test
        @DisplayName("Test header size is always 18")
        public void testHeaderSizeIsAlways18() {

            int sizeOfHeaders = response.getHeaders().size();
            MatcherAssert.assertThat(sizeOfHeaders, is(18));

            }

        @Test
        @DisplayName("Check the server is cloudflare")
        public void checkTheServerIsCloudflare() {


            response
                    .then()
                    .assertThat()
                    .header("Server", "cloudflare");
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
                           .getString("user.name"),equalTo("Rana"));
           }




   }

}
