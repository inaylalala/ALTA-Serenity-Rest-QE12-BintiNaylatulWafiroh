package starter.reqres.GetMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostMethod.Body;
import starter.utils.Constans;

public class GetDelayedResponseAPI {
    public static String GET_DELAYED_RESPONSE =Constans.BASE_URL+"/api/users?delay={delayed}";
    @Step("Get delayed response")
    public void getDelayedResponse(int delayed){
        SerenityRest.given()
                .pathParam("delayed",delayed);
    }
    @Step("Get delayed response")
    public void getDelayedResponse(String delayed){
        SerenityRest.given()
                .pathParam("delayed",delayed);
    }
}
