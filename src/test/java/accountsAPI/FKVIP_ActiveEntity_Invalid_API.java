package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;
import java.io.IOException;


public class FKVIP_ActiveEntity_Invalid_API extends AccountsCommon_API {

    @Test
    public void FKVIP_ActiveEntity_Invalid_API()  throws IOException, JSONException {

        Response resp ;
        resp =postCall("FKVIP_ActiveEntity_Invalid_API", "");
        validation( resp, "FKVIP_ActiveEntity_Invalid_API", "");
    }
}

