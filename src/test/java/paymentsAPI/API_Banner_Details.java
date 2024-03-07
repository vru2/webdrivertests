package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_Details extends API_PaymentCommon1{
    @Test
    public void BannerDetails() {
        Response resp ;
        resp = payGet("BannerDetails","");
        validation("BannerDetails", resp);
    }
}

