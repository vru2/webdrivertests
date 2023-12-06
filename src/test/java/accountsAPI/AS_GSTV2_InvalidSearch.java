package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_GSTV2_InvalidSearch extends AccountsCommon_API
{
    @Test
    public void AS_GSTV2_InvalidSearch() throws IOException, JSONException {
        Response resp ;
        resp =getCall("AS_GSTV2_InvalidSearch", "");
        validation( resp, "AS_GSTV2_InvalidSearch", "");
    }

}
