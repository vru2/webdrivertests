package test.java.  accountsAPI;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class FKVIP_Discovery_API_WithOutFilter extends AccountsCommon_API {

    @Test
    public void FKVIP_Discovery_API_WithOutFilter()  throws IOException, JSONException {

        Response resp ;
        resp =postCall("FKVIP_Discovery_API_WithOutFilter", "");
        validation( resp, "FKVIP_Discovery_API_WithOutFilter", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
