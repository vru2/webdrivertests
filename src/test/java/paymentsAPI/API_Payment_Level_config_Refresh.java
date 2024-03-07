package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;


public class API_Payment_Level_config_Refresh extends API_PaymentCommon1{

    @Test
    public void PaymentLevel_Config_refresh() {
        Response resp ;
        resp = payPut("PaymentLevel_Config_refresh","");
        validation("PaymentLevel_Config_refresh", resp);
    }
}
