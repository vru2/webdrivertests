package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_Gateway_Refresh extends API_PaymentCommon1{

    @Test
    public void EMI_Gateway_refresh() throws Exception {
        Response resp ;
        resp = payPut("EMI_Gateway_refresh","");
        validation("EMI_Gateway_refresh", resp);
    }
}
