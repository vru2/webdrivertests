package test.java.  accountsAPI;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;

public class FKVIP_Injest_ProfileExpiry extends AccountsCommon_API {

    @Test
    public void FK_Injest_ProfileExpiry()  throws IOException, JSONException {
        Response resp ;
        resp =postCall("FK_Injest_ProfileExpiry", "");
        validation( resp, "FK_Injest_ProfileExpiry", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
