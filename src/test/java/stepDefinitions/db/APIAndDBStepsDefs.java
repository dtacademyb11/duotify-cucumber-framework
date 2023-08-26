package stepDefinitions.db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class APIAndDBStepsDefs {

    SharedData sharedData;

    public APIAndDBStepsDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I send a query to retrieve the user with the stored user id")
    public void iSendAQueryToRetrieveTheUserWithTheStoredUserId() {

        sharedData.setQueryResultListOfMaps(DBUtils.getQueryResultListOfMaps("Select * FROM users where id=" + sharedData.getUserIdFromPostRequest() + ""));

    }

    @Then("The user should exist in the database")
    public void theUserShouldExistInTheDatabase() {

        Assert.assertFalse(sharedData.getQueryResultListOfMaps().isEmpty());
    }
}
