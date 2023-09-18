package starter.stepdef.Get;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetSingleResourceNotFoundAPI;
import starter.reqres.GetMethod.GetSingleUserNotFoundAPI;

public class GetSingleUserNotFoundStepDef {
    @Steps
    GetSingleUserNotFoundAPI getSingleUserNotFoundAPI;
    @Given("Get single user not found with more than twelve {int}")
    public void getSingleUserNotFoundWithMoreThanTwelve(int page) {
        getSingleUserNotFoundAPI.getSingleUserNotFound(page);
    }

    @When("Send request get single user not found")
    public void sendRequestGetSingleUserNotFound() {
        SerenityRest.when().get(GetSingleUserNotFoundAPI.GET_SINGLE_USER_NOT_FOUND);
    }

    @Given("Get single user not found with less than twelve {int}")
    public void getSingleUserNotFoundWithLessThanTwelve(int page) {
        getSingleUserNotFoundAPI.getSingleUserNotFound(page);
    }
}
