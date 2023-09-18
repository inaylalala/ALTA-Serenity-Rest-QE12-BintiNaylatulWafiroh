package starter.reqres.PostMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

import java.io.File;

public class PostRegisterUnsuccessfulAPI {
    public static String POST_REGISTER_UNSUCCESSFUL = Constans.BASE_URL+"/api/register";
    @Step("Post register unsuccessful")
    public void postRegisterUnsuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register unsuccessful")
    public void postRegisterUnsuccessful(String email) {
        Body body = new Body(email,"");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
}
