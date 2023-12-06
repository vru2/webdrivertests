package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_Get_Traveller_Details extends AccountsCommon_API
{
    @Test
    public void AS_Get_Traveller_Details() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_Get_Traveller_Details", "");
        validation( resp, "AS_Get_Traveller_Details", "");
    }

}
