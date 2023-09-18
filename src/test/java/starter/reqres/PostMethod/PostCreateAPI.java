package starter.reqres.PostMethod;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;
import io.restassured.mapper.ObjectMapperType;
import java.io.File;

public class PostCreateAPI {
    public static String POST_CREATE_USER = Constans.BASE_URL+"/api/users";
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user")
    public void postCreateNewUser(String name, String job) {
        Body body = new Body(name, job);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("Post create new user")
    public void postCreateNewUser(int id,String name,String job) {
        Body body = new Body(name,job);
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
}
