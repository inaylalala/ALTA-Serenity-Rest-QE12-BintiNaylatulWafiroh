package starter.stepdef.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.PostRegisterSuccessfulAPI;
import starter.utils.Constans;

import java.io.File;

public class PostRegisterSuccessfulStepDef {
    @Steps
    PostRegisterSuccessfulAPI postRegisterSuccessfulAPI;
    @Given("Post register with json {string}")
    public void postRegisterWithJson(String jsonFile) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        postRegisterSuccessfulAPI.postRegisterSuccessful(json);
    }

    @When("Send request post register successful")
    public void sendRequestPostRegisterSuccessful() {
        SerenityRest.when().post(PostRegisterSuccessfulAPI.POST_REGISTER_SUCCESSFUL);
    }
//  Scenario 2
    @Given("Post register with invalid email {string} or password {string}")
    public void postRegisterWithInvalidEmailOrPassword(String email, String password) {
        postRegisterSuccessfulAPI.postRegisterSuccessful(email,password);
    }

    @And("Validate register success JSON schema {string}")
    public void validateRegisterSuccessJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
