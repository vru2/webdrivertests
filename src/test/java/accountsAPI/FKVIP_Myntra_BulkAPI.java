package test.java.accountsAPI;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FKVIP_Myntra_BulkAPI extends AccountsCommon_API {

    @Test
    public void FKVIP_Myntra_BulkAPI()  throws IOException, JSONException {

        Response resp;
        resp = postCall("FKVIP_Myntra_BulkAPI", "");
        validation(resp, "FKVIP_Myntra_BulkAPI", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
