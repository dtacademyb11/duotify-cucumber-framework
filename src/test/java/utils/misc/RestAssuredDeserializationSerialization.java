package utils.misc;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredDeserializationSerialization {



    @Test
    public void serializeAsString(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();

        given().
                header("Content-Type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
//                body("""
//                          {
//                            "username": "coolherc205599889",
//                            "firstName": "Cool",
//                            "lastName": "Herc",
//                            "email": "coolherc205599889@mail.com",
//                            "password": "coolherc"
//                          }
//      """ ).

           body("{\n" +
        "  \"username\": \""+username+"\",\n" +
        "  \"firstName\": \"Cool\",\n" +
        "  \"lastName\": \"Herc\",\n" +
        "  \"email\": \""+email+"\",\n" +
        "  \"password\": \"dhsjjfhdsf\"\n" +
        "}").

        when().log().all().
                post("/user").
        then().log().all().
                statusCode(201);

    }

    @Test
    public void serializeAsFile(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";



     Integer userId =    given().
                header("Content-Type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                body(new File("src/test/java/utils/misc/userPayload.json")).

                when().log().all().
                post("/user").
                then().log().all().
                statusCode(201).extract().path("user_id");

        given().

                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                queryParam("id", userId).
//
                when().log().all().
                delete("/user").
                then().log().all().
                statusCode(200);

    }

    @Test
    public void serializeAsMap(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

      Map<String, Object> userAsMap = new LinkedHashMap<>();

      userAsMap.put("username", new Faker().name().username());
      userAsMap.put("lastName", new Faker().name().lastName());
      userAsMap.put("firstName", new Faker().name().firstName());
      userAsMap.put("email", new Faker().internet().emailAddress());
      userAsMap.put("password", new Faker().internet().password());



       given().
                header("Content-Type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                body(userAsMap).
                when().log().all().
                post("/user").
                then().log().all().
                statusCode(201);



    }

    @Test
    public void serializeAsList(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

        List<String> payloadAsList = List.of("email1@gmail.com", "email2@gmail.com", "email3@gmail.com", "email4@gmail.com");


        given().
                header("Content-Type", "application/json").
                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
//                body(payloadAsList, ObjectMapperType.JACKSON_2). // for json
//                body(payloadAsList, ObjectMapperType.JAXB). // for xml
                body(payloadAsList). // for xml
                when().log().all().
                post("/user").
                then().log().all().
                statusCode(422);



    }

}
