package starter.reqres.GetMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

public class GetSingleUserAPI {
    public static String GET_SINGLE_USER = Constans.BASE_URL+"/api/users/{id}";
    @Step("Get single user")
    public void getSingleUser(Object id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
