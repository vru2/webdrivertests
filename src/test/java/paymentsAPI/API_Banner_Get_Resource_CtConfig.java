package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_Get_Resource_CtConfig extends API_PaymentCommon1{

    @Test
    public void BannerResource_CtConfig() {
        Response resp ;
        resp = payGet("BannerResource_CtConfig","");
        validation("BannerResource_CtConfig", resp);
    }
}
