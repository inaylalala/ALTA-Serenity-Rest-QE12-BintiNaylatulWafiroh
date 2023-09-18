package starter.stepdef.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.PostCreateAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constans;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostCreateStepDef {
    @Steps
    PostCreateAPI postCreateAPI;
    @Given("Create new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        postCreateAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(PostCreateAPI.POST_CREATE_USER);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate create a new user JSON schema {string}")
    public void validateCreateANewUserJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Create new user without name {string} or job {string}")
    public void createNewUserWithoutNameOrJob(String name, String job) {
        postCreateAPI.postCreateNewUser(name, job);
    }

// Scenario
    @Given("Post create user with name {string} and job {string}")
    public void postCreateUserWithIdNameAndJob(String name, String job) {
        postCreateAPI.postCreateNewUser(name,job);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(PostCreateAPI.POST_CREATE_USER);
    }
}
