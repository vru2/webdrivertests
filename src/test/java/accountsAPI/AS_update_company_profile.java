package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_update_company_profile extends AccountsCommon_API {

    @Test
    public void AS_update_company_profile() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_update_company_profile", "");
        validation( resp, "AS_update_company_profile", "");

    }
}
