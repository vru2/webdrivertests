package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_CTWallet_Refresh extends API_PaymentCommon1{

    @Test
    public void CtWallet_refresh() {
        Response resp ;
        resp = payPut("CtWallet_refresh","");
        validation("CtWallet_refresh", resp);
    }
}
