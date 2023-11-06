package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Floater_Add_Template_DuplicateAPI extends AccountsCommon_API {

    @Test
    public void Floater_Add_Template_DuplicateAPI(){
        Response resp ;
        resp =postCall("Floater_Add_Template_DuplicateAPI", "");
        validation( resp, "Floater_Add_Template_DuplicateAPI", "");

    }
}
