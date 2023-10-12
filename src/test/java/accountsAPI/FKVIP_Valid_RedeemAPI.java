package test.java.  accountsAPI;
import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
        import io.restassured.response.ResponseBody;



public class FKVIP_Valid_RedeemAPI extends AccountsCommon_API {

    @Test
    public void FKVIP_Valid_RedeemAPI()  throws IOException, JSONException {

        Response resp ;
        resp =postCall("FKVIP_Valid_RedeemAPI", "");
        validation( resp, "FKVIP_Valid_RedeemAPI", "");

		/*ResponseBody body = resp.getBody();
		System.out.println("Response of API is:" + body.asString());*/


    }
}
