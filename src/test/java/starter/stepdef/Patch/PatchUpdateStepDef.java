package starter.stepdef.Patch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PatchMethod.PatchUpdateAPI;
import starter.utils.Constans;

import java.io.File;

public class PatchUpdateStepDef {
    @Steps
    PatchUpdateAPI patchUpdateAPI;
    @Given("Update user with id {int} username {} and  job {}")
    public void updateUserWithIdUsernameAndJob(int id, String name, String job) {
        patchUpdateAPI.patchUpdate(job,name,id);
    }

    @When("Send request patch update")
    public void sendRequestPatchUpdate() {
        SerenityRest.when().patch(PatchUpdateAPI.PATCH_UPDATE);
    }

    @And("Validate patch update user JSON schema {string}")
    public void validatePatchUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constans.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Update user id {int} without input username {} and  job {}")
    public void updateUserIdWithoutInputUsernameAndJob(int id, String name, String job) {
        patchUpdateAPI.patchUpdate(job,name,id);
    }
}
