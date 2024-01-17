package test.java.accountsAPI;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

public class AS_FK_Redirection extends AccountsCommon_API{

    @Test
    public void FK_Redirection() throws JSONException {

        Response resp ;
        resp =postCall("FK_Redirection", "");
        validation( resp, "FK_Redirection", "");

    }
}
