package starter.reqres.PostMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

import java.io.File;

public class PostRegisterSuccessfulAPI {
    public static String POST_REGISTER_SUCCESSFUL = Constans.BASE_URL+"/api/register";
    @Step("Post register successful")
    public void postRegisterSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register successful")
    public void postRegisterSuccessful(String email, String password) {
        Body body = new Body(email, password);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
}
