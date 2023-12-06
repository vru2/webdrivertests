package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AS_FlyinUserDetails_Update extends AccountsCommon_API {

    @Test
    public void AS_FylinUserDetails_Update() throws IOException, JSONException {
        Response resp ;
        resp =postCall("AS_FlyinUserDetails_Update", "");
        Verification( resp, "AS_FlyinUserDetails_Update", "");

    }
}
