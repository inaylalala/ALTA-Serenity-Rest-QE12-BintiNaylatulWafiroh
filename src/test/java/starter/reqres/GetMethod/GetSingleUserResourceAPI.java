package starter.reqres.GetMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;



public class GetSingleUserResourceAPI {
    public static String GET_SINGLE_USERS_RESOURCE = Constans.BASE_URL + "/api/unknown/{page}";

    @Step("Get single users resource")
    public void getSingleUsersResource(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get single resource with exit id on parameter page")
    public void getSingleUsersResourceWithExitIdOnParameterPage(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }


}

