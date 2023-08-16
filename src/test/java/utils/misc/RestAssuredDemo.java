package utils.misc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredDemo {


    @Test
    public void basicDemo(){

        //https://api.github.com/v2/users/drgonzo21

        RestAssured.baseURI = "https://api.github.com";
//        RestAssured.basePath = "v1";

        // Chained syntax
//               given().
//                    header("Accept", "application/vnd.github+json").
//                when(). log().all().
//                    get("/users/drgonzo21").
//                then(). log().all().
//                     assertThat().
//                     statusCode(200);

        //Syntax with each section divided and stored in their own objects

        // given
        RequestSpecification requestSpecification = given().   // given represents specifications of the request
                              header("Accept", "application/vnd.github+json");
//
        //when
        Response response = requestSpecification.when().log().all().  // when() represents the actual request and it returns a Response object which contains the response
                                                  get("/users/drgonzo21");

        //then
        response.then(). log().all().
                statusCode(200).
                header("Server", "GitHub.com");


    }


}
