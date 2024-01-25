package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

public class AS_Register_API_Failure extends AccountsCommon_API{

    @Test
    public void Register_Failure() throws JSONException {

        Response resp ;
        resp =postCall("Register_Failure", "");
        validation_Flipkart_existuser( resp, "Register_Failure", "");

    }
}
