package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Floater_Add_Template_InvalidAPI extends AccountsCommon_API {

    @Test
    public void Floater_Add_Template_InvalidAPI(){
        Response resp ;
        resp =postCall("Floater_Add_Template_InvalidAPI", "");
        validation( resp, "Floater_Add_Template_InvalidAPI", "");

    }
}
