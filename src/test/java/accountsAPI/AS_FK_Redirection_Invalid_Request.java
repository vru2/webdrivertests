package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

public class AS_FK_Redirection_Invalid_Request extends AccountsCommon_API{

    @Test
    public void FK_Redirection_Invalid_request() throws JSONException {

        Response resp ;
        resp =postCall("FK_Redirection_Invalid_request", "");
        validationjwt( resp, "FK_Redirection_Invalid_request", "");

    }
}
