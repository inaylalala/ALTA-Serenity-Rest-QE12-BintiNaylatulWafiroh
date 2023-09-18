package starter.stepdef.Post;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.PostLoginUnsuccessfulAPI;
import starter.utils.Constans;

import java.io.File;

public class PostLoginUnsuccessfulStepDef {
    @Steps
    PostLoginUnsuccessfulAPI postLoginUnsuccessfulAPI;
    @Given("Post login unsuccessful with json {string}")
    public void postLoginUnsuccessfulWithJson(String jsonFile) {
        File json = new File(Constans.REQ_BODY+jsonFile);
        postLoginUnsuccessfulAPI.postLoginUnsuccessful(json);
    }

    @When("Send request post login unsuccessful")
    public void sendRequestPostLoginUnsuccessful() {
        SerenityRest.when().post(PostLoginUnsuccessfulAPI.POST_LOGIN_UNSUCCESSFUL);
    }
}
