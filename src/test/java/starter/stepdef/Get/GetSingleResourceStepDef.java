package starter.stepdef.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetSingleUserResourceAPI;
import starter.utils.Constans;

import java.io.File;

public class GetSingleResourceStepDef {
    @Steps
    GetSingleUserResourceAPI getSingleUserResourceAPI;

    //    Scenario 1
    @Given("Get single resource with value {int}")
    public void getSingleResourceWithValue(int page) {
        getSingleUserResourceAPI.getSingleUsersResource(page);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(GetSingleUserResourceAPI.GET_SINGLE_USERS_RESOURCE);
    }

    @And("Validate get single resource json schema {string}")
    public void validateGetSingleResourceJsonSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //  Scenario 2
    @Given("Get single resource with special char {string}")
    public void getSingleResourceWithSpecialChar(String page) {
        getSingleUserResourceAPI.getSingleUsersResourceWithExitIdOnParameterPage(page);
    }


}
