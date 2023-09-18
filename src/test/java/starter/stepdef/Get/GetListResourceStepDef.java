package starter.stepdef.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetMethod.GetListResourceAPI;
import starter.utils.Constans;

import java.io.File;

public class GetListResourceStepDef {
    @Steps
    GetListResourceAPI getListResourceAPI;
    @Given("Get list resource with unknown page")
    public void getListUserWithUnknownPage() {
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(GetListResourceAPI.GET_LIST_UNKNOWN);
    }

    @And("Validate get list resource json schema {string}")
    public void validateGetListResourceJsonSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
