package test.java.  accountsAPI;
import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.IOException;

public class FKVIP_GetBenefitDetails_API extends AccountsCommon_API {

    @Test
    public void FKVIP_GetBenefitDetails_API()  throws IOException, JSONException {

        Response resp ;
        resp =getCall("FKVIP_GetBenefitDetails_API", "");
        validation( resp, "FKVIP_GetBenefitDetails_API", "");
    }
}
