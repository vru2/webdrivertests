package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Promotional_Service_GetStageConfig extends AccountsCommon_API{

    @Test
    public void Promotional_Service_GetStageConfig() throws IOException, JSONException {
        Response resp ;
        resp =getCall("Promotional_Service_GetStageConfig", "");
        validation( resp, "Promotional_Service_GetStageConfig", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
