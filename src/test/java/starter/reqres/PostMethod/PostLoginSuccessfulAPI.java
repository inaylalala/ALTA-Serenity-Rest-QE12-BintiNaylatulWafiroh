package starter.reqres.PostMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

import java.io.File;

public class PostLoginSuccessfulAPI {
    public static String POST_LOGIN_SUCCESSFUL = Constans.BASE_URL+"/api/login";
    @Step("Post login successful")
    public void postLoginSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login successful")
    public void postLoginSuccessful(String email, String password) {
        Body body = new Body(email, password);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
}
