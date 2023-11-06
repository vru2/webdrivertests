package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Floater_SaveImpression_API extends AccountsCommon_API {

    @Test
    public void Floater_SaveImpression_API(){
        Response resp ;
        resp =postCall("Floater_SaveImpression_API", "");
        validation( resp, "Floater_SaveImpression_API", "");

    }
}
