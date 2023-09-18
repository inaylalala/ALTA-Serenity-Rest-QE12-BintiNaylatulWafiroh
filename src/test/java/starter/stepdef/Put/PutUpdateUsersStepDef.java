package starter.stepdef.Put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PutMethod.PutUpdateAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUsersStepDef {
    @Steps
    PutUpdateAPI putUpdateAPI;

//    Scenario 1
    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        putUpdateAPI.putUpdateUser(json,id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(PutUpdateAPI.PUT_UPDATE_USER);
    }

    @And("Validate put update user JSON schema {string}")
    public void validatePutUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    @And("Response put update body name was {string} and job was {string}")
    public void responsePutUpdateBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

// Scenario 2
    @Given("Put update user with id {int}, name {string} and job {string}")
    public void putUpdateUserWithNumericAndSpecialCharSpecialChar(int id, String name,String job) {
    putUpdateAPI.putUpdateUser(name, job, id);
    }


    @And("Validate put update user  JSON schema {string}")
    public void validatePutUpdateUserNegativeJSONSchema(String jsonFile) {
            File json = new File(Constans.JSON_SCHEMA+jsonFile);
            SerenityRest.and()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(json));
        }
//  Scenario 3

    @Given("Put update user with id {int} without name {string} or job {string}")
    public void putUpdateUserWithIdWithoutNameOrJob(int id,String name, String job) {
        putUpdateAPI.putUpdateUser(name, job, id);
    }
//  Scenario 4
    @Given("Put update user with query parameter {string}")
    public void putUpdateUserWithQueryParameter(String id) {
        putUpdateAPI.putUpdateUserQueryParam(id);
    }
}



