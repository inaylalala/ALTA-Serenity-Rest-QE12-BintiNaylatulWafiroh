package starter.stepdef.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.PostRegisterUnsuccessfulAPI;
import starter.utils.Constans;

import java.io.File;

public class PostRegisterUnsuccessfulStepDef {
    @Steps
    PostRegisterUnsuccessfulAPI postRegisterUnsuccessfulAPI;
    @Given("Post register unsuccessful with json {string}")
    public void postRegisterUnsuccessfulWithJson(String jsonFile) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        postRegisterUnsuccessfulAPI.postRegisterUnsuccessful(json);
    }
    @When("Send request post register unsuccessful")
    public void sendRequestPostRegisterUnsuccessful() {
        SerenityRest.when().post(PostRegisterUnsuccessfulAPI.POST_REGISTER_UNSUCCESSFUL);
    }

    @And("Validate register unsuccessful JSON schema {string}")
    public void validateRegisterUnsuccessfulJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
