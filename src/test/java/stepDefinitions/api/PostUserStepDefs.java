package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pojos.User;
import stepDefinitions.SharedData;
import utils.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostUserStepDefs {

    SharedData sharedData;

    public PostUserStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("the request body is set to the following payload")
    public void the_request_body_is_set_to_the_following_payload(String body) {

        sharedData.getRequestSpecification().body(body);
    }

    @And("I delete the created user")
    public void iDeleteTheCreatedUser() {

      Integer userId =   sharedData.getResponse().path("user_id");

      sharedData.setRequestSpecification(given().queryParam("id", userId).queryParam("api_key", ConfigReader.getProperty("api.key.duotify")));

      sharedData.getRequestSpecification().when().log().all().delete("/user").then().log().all().assertThat().statusCode(200);
    }

    @And("the request body is set to the following payload as map")
    public void theRequestBodyIsSetToTheFollowingPayloadAsMap(Map<String, Object> payload) {
        sharedData.getRequestSpecification().body(payload);
    }

    @And("the request body is set to the following payload as pojo")
    public void theRequestBodyIsSetToTheFollowingPayloadAsPojo(Map<String, String> map) {

        sharedData.getRequestSpecification().body(
                User.builder().
                        email(map.get("email")).
                        password(map.get("password")).
                        firstName(map.get("firstName")).
                        lastName(map.get("lastName")).
                        username(map.get("username")).build()
        );
    }


    @And("the request body is set to the random values")
    public void theRequestBodyIsSetToTheRandomValues() {

        Faker faker = new Faker();
        sharedData.getRequestSpecification().body(
                User.builder().
                        email(faker.internet().emailAddress()).
                        password(faker.internet().password()).
                        firstName(faker.name().firstName()).
                        lastName(faker.name().lastName()).
                        username(faker.name().username()).build()
        );
    }

    @And("the user id is stored")
    public void theUserIdIsStored() {

        Integer userId = sharedData.getResponse().path("user_id");
        sharedData.setUserIdFromPostRequest(userId);
    }
}
