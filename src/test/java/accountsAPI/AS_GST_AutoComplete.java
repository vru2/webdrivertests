package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_GST_AutoComplete extends AccountsCommon_API
{
    @Test
    public void AS_GST_AutoComplete() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_GST_AutoComplete", "");
        validation( resp, "AS_GST_AutoComplete", "");
    }

}
