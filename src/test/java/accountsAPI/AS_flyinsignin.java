package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_flyinsignin extends AccountsCommon_API {

    @Test
    public void AS_flyinsignin() throws IOException, JSONException {
        Response resp ;
        resp =postCall("flyinsigninV2", "");
        validation( resp, "flyinsigninV2", "");

    }
}
