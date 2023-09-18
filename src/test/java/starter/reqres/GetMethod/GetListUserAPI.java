package starter.reqres.GetMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

public class GetListUserAPI {
    public static String GET_LIST_USERS = Constans.BASE_URL+"/api/users?page={page}";
    @Step("Get list users")
    public void getListUsers(Object page){
        SerenityRest.given()
                .pathParam("page",page);
    }

}
