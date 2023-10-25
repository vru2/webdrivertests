package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FKSSO_Callback_API extends AccountsCommon_API {

    @Test
    public void FKSSO_Callback_API(){
        Response resp ;
        resp =getCall("FKSSO_Callback_API", "");
        validation( resp, "FKSSO_Callback_API", "");

    }
}
