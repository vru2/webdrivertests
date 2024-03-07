package test.java.paymentsAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_Update_CtConfig extends API_PaymentCommon1{

    @Test
    public void BannerUpdateCtConfig() {
        Response resp ;
        resp = payPut("BannerUpdateCtConfig","");
        validation("BannerUpdateCtConfig", resp);
    }
}
