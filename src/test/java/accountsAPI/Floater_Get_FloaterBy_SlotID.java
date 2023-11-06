package test.java.accountsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import io.restassured.response.Response;

public class Floater_Get_FloaterBy_SlotID extends AccountsCommon_API {

    @Test
    public void Floater_Get_FloaterBy_SlotID(){
        Response resp ;
        resp =postCall("Floater_Get_FloaterBy_SlotID", "");
        validation( resp, "Floater_Get_FloaterBy_SlotID", "");

    }

}
