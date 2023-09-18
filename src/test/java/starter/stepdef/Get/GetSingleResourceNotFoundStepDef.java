package starter.stepdef.Get;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetSingleResourceNotFoundAPI;

public class GetSingleResourceNotFoundStepDef {
    @Steps
    GetSingleResourceNotFoundAPI getSingleResourceNotFoundAPI;
    @Given("Get single resource not found with more than twelve {int}")
    public void getSingleResourceNotFoundWithMoreThanTwelve(int page) {
        getSingleResourceNotFoundAPI.getSingleResourceNotFound(page);
    }

    @When("Send request get single resource not found")
    public void sendRequestGetSingleResourceNotFound() {
        SerenityRest.when().get(GetSingleResourceNotFoundAPI.GET_SINGLE_RESOURCE_NOT_FOUND);
    }
//  Scenario 2
    @Given("Get single resource not found with less than twelve {int}")
    public void getSingleResourceNotFoundWithLessThanTwelve(int page) {
        getSingleResourceNotFoundAPI.getSingleResourceNotFound(page);
    }
}
