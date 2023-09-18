package starter.reqres.GetMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

public class GetSingleUserNotFoundAPI {
    public static String GET_SINGLE_USER_NOT_FOUND = Constans.BASE_URL+"/api/users/{page}";
    @Step("Get single user not found")
    public void getSingleUserNotFound(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
}
