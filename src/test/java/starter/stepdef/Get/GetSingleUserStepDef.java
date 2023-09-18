package starter.stepdef.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetListUserAPI;
import starter.reqres.GetMethod.GetSingleUserAPI;
import starter.utils.Constans;

import java.io.File;

public class GetSingleUserStepDef {
    @Steps
    GetSingleUserAPI getSingleUserAPI;
    @Given("Get single user with valid parameter page {int}")
    public void getSingleUserWithValidParameterPage(int page) {
        getSingleUserAPI.getSingleUser(page);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleUserAPI.GET_SINGLE_USER);
    }

    @And("Validate get single user json schema {string}")
    public void validateGetSingleUserJsonSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single user with alphabet {string}")
    public void getSingleUserWithAlphabet(String id) {
        getSingleUserAPI.getSingleUser(id);
    }

    @Given("Get single user with special char {string}")
    public void getSingleUserWithSpecialChar(String id) {
        getSingleUserAPI.getSingleUser(id);
    }
}
