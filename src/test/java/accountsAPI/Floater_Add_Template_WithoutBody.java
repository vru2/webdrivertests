package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Floater_Add_Template_WithoutBody extends AccountsCommon_API {

    @Test
    public void Floater_Add_Template_WithoutBody(){
        Response resp ;
        resp =postCall("Floater_Add_Template_WithoutBody", "");
        validation( resp, "Floater_Add_Template_WithoutBody", "");

    }
}
