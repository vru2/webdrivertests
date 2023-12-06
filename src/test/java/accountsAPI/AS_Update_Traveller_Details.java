package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Update_Traveller_Details  extends AccountsCommon_API
{
    @Test
    public void AS_Update_Traveller_Details() throws IOException, JSONException {
        Response resp ;
        resp =putCall("AS_Update_Traveller_Details", "");
        validation( resp, "AS_Update_Traveller_Details", "");

    }

}
