package test.java.paymentsAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_new_Ct_Config extends API_PaymentCommon1{

    @Test
    public void Banner_Ct_config() {
        Response resp ;
        resp = payGet("Banner_Ct_config","");
        validation("Banner_Ct_config", resp);
    }
}
