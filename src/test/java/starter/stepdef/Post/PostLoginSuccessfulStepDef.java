package starter.stepdef.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.PostCreateAPI;
import starter.reqres.PostMethod.PostLoginSuccessfulAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginSuccessfulStepDef {
    @Steps
    PostLoginSuccessfulAPI postLoginSuccessfulAPI;

//    Scenario 1
    @Given("Post login with json {string}")
    public void postLoginWithJson(String jsonFile) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        postLoginSuccessfulAPI.postLoginSuccessful(json);
    }

    @When("Send request post login successful")
    public void sendRequestPostLoginSuccessful() {
        SerenityRest.when().post(PostLoginSuccessfulAPI.POST_LOGIN_SUCCESSFUL);
    }

    @Then("Status code login success should be {int} OK")
    public void statusCodeLoginSuccessShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate login success JSON schema {string}")
    public void validateLoginSuccessJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Scenario 2
    @Given("Post login with invalid email {string} or password {string}")
    public void postLoginWithInvalidEmailOrPassword(String email, String password) {
        postLoginSuccessfulAPI.postLoginSuccessful(email,password);
    }
}
