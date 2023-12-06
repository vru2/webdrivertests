package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_GST_AutoCompleteInvalid extends AccountsCommon_API
{
    @Test
    public void AS_GST_AutoCompleteInvalid() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_GST_AutoCompleteInvalid", "");
        validation( resp, "AS_GST_AutoCompleteInvalid", "");
    }

}
