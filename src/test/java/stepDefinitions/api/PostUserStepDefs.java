package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import stepDefinitions.SharedData;
import utils.ConfigReader;

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
}
