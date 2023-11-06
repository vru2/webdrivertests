package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Floater_Get_FloaterBy_SlotID_Invalid extends AccountsCommon_API {

    @Test
    public void Floater_Get_FloaterBy_SlotID_Invalid(){

        Response resp ;
        resp =postCall("Floater_Get_FloaterBy_SlotID_Invalid", "");
        validation( resp, "Floater_Get_FloaterBy_SlotID_Invalid", "");

    }

}
