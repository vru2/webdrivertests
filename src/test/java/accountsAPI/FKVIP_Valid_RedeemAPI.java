package test.java.  accountsAPI;
import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;



public class FKVIP_Valid_RedeemAPI extends AccountsCommon_API {

    @Test(priority = 0)
    public void FKVIP_Valid_RedeemAPI()  throws IOException, JSONException {
        Response resp ;
        resp =postCall("FKVIP_Valid_RedeemAPI", "");
        validation( resp, "FKVIP_Valid_RedeemAPI", "");
    }

    @Test(priority = 1)
    public void FKVIP_Valid_RollBackAPI()  throws IOException, JSONException {
        Response resp ;
        resp = postCall("FKVIP_Valid_RollBackAPI", "");
        validation(resp, "FKVIP_Valid_RollBackAPI", "");
    }
}
