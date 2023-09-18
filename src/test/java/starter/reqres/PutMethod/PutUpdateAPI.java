package starter.reqres.PutMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.Body;
import starter.utils.Constans;

import java.io.File;

public class PutUpdateAPI {
    public static String PUT_UPDATE_USER = Constans.BASE_URL+"/api/users/{id}";
    @Step("Put update user")
    public void putUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(String name, String job, int id) {
        Body body = new Body(name, job);
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("Put update user query param")
    public void putUpdateUserQueryParam(String id) {
        Body body = new Body("","");
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }

}
