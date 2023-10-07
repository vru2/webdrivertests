package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.*;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FkVIP_Injest_Profile  extends AccountsCommon_API {

    @Test
    public void FkVIP_Injest(){
        Response resp ;
        resp =postCall("FkVIP_Injest_Profile", "");
        validation( resp, "FkVIP_Injest_Profile", "");

    }
}
