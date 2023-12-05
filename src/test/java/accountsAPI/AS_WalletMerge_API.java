package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_WalletMerge_API extends AccountsCommon_API {

    @Test
    public void AS_WalletMerge_API() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_WalletMerge_API", "");
        validation( resp, "AS_WalletMerge_API", "");

    }
}

