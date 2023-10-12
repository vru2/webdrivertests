


package test.java.  accountsAPI;
import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.*;
import io.restassured.response.Response;
        import io.restassured.response.ResponseBody;



public class FKVIP_ActiveEntity_API extends AccountsCommon_API {

    @Test
    public void FKVIP_ActiveEntity_API()  throws IOException, JSONException {

        Response resp ;
        resp =postCall("FKVIP_ActiveEntity_API", "");
        validation( resp, "FKVIP_ActiveEntity_API", "");
    }
}
