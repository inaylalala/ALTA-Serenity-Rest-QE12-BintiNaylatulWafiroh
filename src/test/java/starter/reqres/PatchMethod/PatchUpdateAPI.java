package starter.reqres.PatchMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.Body;
import starter.utils.Constans;

import java.io.File;

public class PatchUpdateAPI {
    public static String PATCH_UPDATE = Constans.BASE_URL + "/api/users/{id}";

    @Step("Patch update user")
    public void patchUpdate(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Patch update user")
    public void patchUpdate(String name, String job, int id) {
        Body body = new Body(name, job);
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
}
