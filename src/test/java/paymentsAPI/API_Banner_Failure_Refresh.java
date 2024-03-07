package test.java.paymentsAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_Failure_Refresh extends API_PaymentCommon1{
    @Test
    public void BannerRefresh() {
        Response resp ;
        resp = payPut("BannerRefresh","");
        validation("BannerRefresh", resp);
    }
}
