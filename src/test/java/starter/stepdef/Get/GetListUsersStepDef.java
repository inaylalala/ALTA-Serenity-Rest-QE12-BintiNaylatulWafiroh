package starter.stepdef.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetListUserAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUsersStepDef {
    @Steps
    GetListUserAPI getListUserAPI;


//    Scenario 1 : get list users
    @Given("Get list users with valid parameter page {int}")
    public void getListUserWithValidParameter(int page) {
        getListUserAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(GetListUserAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list users json schema {string}")
    public void validateGetListUsersJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//  Scenario 2


    @When("Send request get list users without parameter page")
    public void sendRequestGetListUsersWithoutParameterPage() {
        SerenityRest.when().get(GetListUserAPI.GET_LIST_USERS);
    }


    @Given("Get list users with alphabet {string}")
    public void getListUsersWithAlphabet(String page) {
        getListUserAPI.getListUsers(page);
    }

    @Given("Get list users with special char {string}")
    public void getListUsersWithSpecialChar(String page) {
        getListUserAPI.getListUsers(page);
    }
}
