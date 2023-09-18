package starter.reqres.DeleteMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constans;

public class DeleteAPI {
    public static String DELETE_USER = Constans.BASE_URL+"/api/users/{id}";
    @Step("Delete a user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Delete a user with exit user id ")
    public void deleteUserWithExitUserId(String id){
        SerenityRest.given().pathParam("id",id);
    }
}
