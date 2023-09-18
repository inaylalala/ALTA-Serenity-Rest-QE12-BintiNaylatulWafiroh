//package starter.stepdef;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Steps;
//import org.apache.bcel.Constants;
//import starter.reqres.ReqresAPI;
//import starter.reqres.ReqresResponses;
//import starter.utils.Constans;
//
//import java.io.File;
//import static org.hamcrest.Matchers.equalTo;
//
//public class ReqresStepDef {
//    @Steps
//    ReqresAPI reqresAPI;
//
//    //Scenario 1 : get list users
//    @Given("Get list users with valid parameter page {int}")
//    public void getListUserWithValidParameter(int page) {
//        reqresAPI.getListUsers(page);
//    }
//    @When("Send request get list users")
//    public void sendRequestGetListUsers(){
//        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
//    }
//    @Then("Status code should be {int} OK")
//    public void statusCodeShouldBeOK(int ok){
//        SerenityRest.then().statusCode(ok);
//    }
//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int page) {
//        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
//    }
//
//    //Scenario 2Post create new user
//    @Given("Create new user with valid json {string}")
//    public void createNewUserWithValidJson(String jsonFile) {
//        File json = new File(Constans.REQ_BODY+jsonFile);
//        reqresAPI.postCreateUser(json);
//    }
//
//    @When("Send request post create new user")
//    public void sendRequestPostCreateNewUser() {
//        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
//    }
//    //Scenario 3
//    @Then("Status code should be {int} Created")
//    public void statusCodeShouldBeCreated(int created) {
//        SerenityRest.then().statusCode(created);
//    }
//
//    @Given("Update user with json {string} and user id {int}")
//    public void updateUserWithJsonAndUserId(String jsonFile, int id ) {
//        File json = new File(Constans.REQ_BODY+jsonFile);
//        reqresAPI.putUpdateUser(json,id);
//    }
//
//    @When("Send request put update user")
//    public void sendRequestPutUpdateUser() {
//        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
//    }
//    //Scenario 4 : Delete a user
//    @Given("Delete a user with valid user id {int}")
//    public void deleteAUserWithValidUserIs(int id) {
//        reqresAPI.deleteUser(id);
//    }
//
//    @When("Send request delete user")
//    public void sendRequestDeleteUser() {
//        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
//    }
//
//    @Then("Status code should be {int} No Content")
//    public void statusCodeShouldBeNoContent(int noContent) {
//        SerenityRest.then().statusCode(noContent);
//    }
//
//
//}
