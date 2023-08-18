package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ApiDemoStepDefs2 {



//
//    @Given("The base uri is set")
//    public void the_base_uri_is_set() {
//        RestAssured.baseURI = "https://api.github.com";
//    }
//
//    RequestSpecification header;
//    @Given("{string} header is set to {string}")
//    public void header_is_set_to(String key, String value) {
//       header = given().
//                header(key, value);
//
//
//    }
//    @Given("{string} path Parameter is set to {string}")
//    public void path_parameter_is_set_to(String key, String value) {
//        header.given().pathParam(key, value);
//
//    }
//    @Given("{string} query Parameter is set to {string}")
//    public void query_parameter_is_set_to(String key, String value) {
//        header.given().queryParam(key, value);
//    }
//
//    Response response;
//    @When("I send a {string} request to endpoint {string}")
//    public void i_send_a_request_to_endpoint(String string, String string2) {
//        response = header.when().log().all().get("/users/{username}");
//
//
//    }
//    @Then("the status code should be {int}")
//    public void the_status_code_should_be(Integer int1) {
//       response.then(). log().all().
//                assertThat().
//                statusCode((200)).
//                time(lessThan(2000L)); // verify basic response time
//    }
//    @Then("response time should be less than {int} ms")
//    public void response_time_should_be_less_than_ms(Integer int1) {
//
//    }
}
