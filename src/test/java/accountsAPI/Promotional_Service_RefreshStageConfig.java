package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Promotional_Service_RefreshStageConfig extends AccountsCommon_API{

    @Test
    public void Promotional_Service_RefreshStageConfig() throws IOException, JSONException {
        Response resp ;
        resp =putCall("Promotional_Service_RefreshStageConfig", "");
        validation( resp, "Promotional_Service_RefreshStageConfig", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
