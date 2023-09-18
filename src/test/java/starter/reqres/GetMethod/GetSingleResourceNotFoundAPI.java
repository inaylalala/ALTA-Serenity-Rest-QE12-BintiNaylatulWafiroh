package starter.reqres.GetMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

public class GetSingleResourceNotFoundAPI {
    public static String GET_SINGLE_RESOURCE_NOT_FOUND = Constans.BASE_URL+"/api/unknown/{page}";
    @Step("Get single resource not found")
    public void getSingleResourceNotFound(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

}
