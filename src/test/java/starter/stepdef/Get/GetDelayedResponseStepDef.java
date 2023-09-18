package starter.stepdef.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetDelayedResponseAPI;
import starter.reqres.GetMethod.GetListUserAPI;
import starter.utils.Constans;

import java.io.File;

public class GetDelayedResponseStepDef {
    @Steps
    GetDelayedResponseAPI getDelayedResponseAPI;

//    Scenario 1
    @Given("Get delayed response with delayed time {int}")
    public void getDelayedResponseWithDelayedTime(int time) {
        getDelayedResponseAPI.getDelayedResponse(time);
    }

    @When("Send request get delayed response")
    public void sendRequestGetListUsersGetDelayedResponse() {
        SerenityRest.when().get(GetDelayedResponseAPI.GET_DELAYED_RESPONSE);
    }

    @And("Validate get delayed response users json schema {string}")
    public void validateGetDelayedResponseUsersJsonSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Scenario 2
    @Given("Get delayed with time was {string}")
    public void getDelayedResponseWithExitNumeric(String alphabet){
        getDelayedResponseAPI.getDelayedResponse(alphabet);

    }


}
