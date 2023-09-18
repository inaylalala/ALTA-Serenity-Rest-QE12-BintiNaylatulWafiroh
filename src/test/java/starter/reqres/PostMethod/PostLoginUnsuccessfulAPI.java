package starter.reqres.PostMethod;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

import java.io.File;

public class PostLoginUnsuccessfulAPI {
    public static String POST_LOGIN_UNSUCCESSFUL = Constans.BASE_URL+"/api/login";
    @Step("Post login unsuccessful")
    public void postLoginUnsuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
