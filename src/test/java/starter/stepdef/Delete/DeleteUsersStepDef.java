package starter.stepdef.Delete;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DeleteMethod.DeleteAPI;

public class DeleteUsersStepDef {
    @Steps
    DeleteAPI deleteAPI;


    //    Scenario 1 = Delete a user with valid user id
    @Given("Delete a user with valid user id {int}")
    public void deleteAUserWithValidUserId(int id) {
        deleteAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER);
    }


    //  Scenario 2 =Delete a user with exit user id
    @Given("Delete a user with exit user id {string}")
    public void deleteAUserWithExitUserId(String id) {
        deleteAPI.deleteUserWithExitUserId(id);
    }

    @When("Send request delete exit user id")
    public void sendRequestDeleteExitUserId() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}


