package test.java.  accountsAPI;
import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class FKVIP_InValid_RollBackAPI extends AccountsCommon_API {

    @Test
    public void FKVIP_InValid_RollBackAPI()  throws IOException, JSONException {

        Response resp ;
        resp =postCall("FKVIP_InValid_RollBackAPI", "");
        validation( resp, "FKVIP_InValid_RollBackAPI", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
