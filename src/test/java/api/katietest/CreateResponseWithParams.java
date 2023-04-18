package api.katietest;

package api.katietest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class CreateResponseWithParams {

    private static Response response;

    public static<T> Response addLoginCredentials(String url, T email, T password){
        response = given().log().all().contentType("application/x-www-form-urlencoded")
                .formParams("email", email, "password", password)
                .post(url);

        return response;

    }

    public static<T> Response addProductToSearch(String url, T product){
        response = given().log().all().contentType("application/x-www-form-urlencoded")
                .formParams("products", product)
                .post(url);

        return response;

    }
}
