package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_Juspay_Fetch_Gateway extends API_PaymentCommon1{

    @Test
    public void EMIJuspay_Fetch_Gateway() {
        Response resp ;
        resp = payGet("EMIJuspay_Fetch_Gateway","");
        validation("EMIJuspay_Fetch_Gateway", resp);
    }
}
