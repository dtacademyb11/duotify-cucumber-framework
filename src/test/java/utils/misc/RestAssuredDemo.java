package utils.misc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.*;

public class RestAssuredDemo {

    @BeforeClass
    public static void beforeClass(){
        RestAssured.baseURI = "https://api.github.com";
    }



    @Test
    public void basicDemo(){

        //https://api.github.com/v2/users/drgonzo21

        RestAssured.baseURI = "https://api.github.com";
//        RestAssured.basePath = "v1";

        // Chained syntax
               given().
                    header("Accept", "application/vnd.github+json").
                    pathParam("username", "drgonzo21"). // path params are added here
                    queryParam("pages","1").
                when(). log().all().  //log().all(). is used to display command line logs of the request or response content, added after given,when,then methods
//                    get("/users/drgonzo21").
                    get("/users/{username}").   // {username} will be replaced with the actual value in pathParams

                then(). log().all().
                     assertThat().
                     statusCode(200);

        //Syntax with each section divided and stored in their own objects

        // given
        RequestSpecification requestSpecification = given().   // given() represents specifications of the request such as headers, parameters, body, authorization/authentication that are sent along with the request
                              header("Accept", "application/vnd.github+json");
//
        //when
        Response response = requestSpecification.when().log().all().  // when() represents the actual request method and endpoint where you are sending the request.
                                                                       // It returns a Response object which represents the returned response
                                                  get("/users/drgonzo21");

        //then
        response.then(). log().all().   // then() represents the assertions performed on the returned response such as status code, headers, body, etc
                statusCode(200).
                header("Server", "GitHub.com");


    }

    @Test
    public void demoPost(){

        String email = "duotechtest"+new Random().nextInt(1000) + "@gmail.com";
       //Test creation of the email
//
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                header("Content-Type", "application/json").
                body("{\n" +
                "    \"emails\" : [\""+email+"\"]\n" +
                "}").
        when(). log().all().
                post("/user/emails").

        then(). log().all().
                assertThat().
                statusCode(201).
                header("Content-Type", "application/json; charset=utf-8");

        // After the test cleanup by calling delete endpoint

        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\" : [\""+email+"\"]\n" +
                        "}").
                when(). log().all().
                delete("/user/emails").

                then(). log().all().
                assertThat().
                statusCode(204).
                header("X-Accepted-OAuth-Scopes", "user");


    }

    @Test
    public void demoPatch(){


//
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"visibility\" : \"public\"\n" +
                        "}").
                when(). log().all().
                patch("/user/email/visibility").

                then(). log().all().
                assertThat().
                statusCode(200).
                header("X-RateLimit-Limit", "5000");


    }


    @Test
    public void demoDelete(){

        String email = "duotechtest"+new Random().nextInt(1000) + "@gmail.com";
        // Create the email first
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\" : [\""+email+"\"]\n" +
                        "}").
                when(). log().all().
                post("/user/emails").

                then(). log().all().
                assertThat().
                statusCode(201).
                header("Content-Type", "application/json; charset=utf-8");

//
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\" : [\""+email+"\"]\n" +
                        "}").
                when(). log().all().
                delete("/user/emails").

                then(). log().all().
                assertThat().
                statusCode(204).
                header("X-Accepted-OAuth-Scopes", "user");


    }





}
