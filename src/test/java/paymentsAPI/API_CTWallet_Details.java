package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_CTWallet_Details extends API_PaymentCommon1{

    @Test
    public void CTWallet_Details() {
        Response resp ;
        resp = payGet("CTWallet_Details","");
        validation("CTWallet_Details", resp);
    }
}
