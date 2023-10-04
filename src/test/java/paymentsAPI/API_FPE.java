package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_FPE extends API_PaymentCommon1{

    @Test
    public void FPE() throws Exception {
        Response resp ;
        resp = payGet1("FPE","");
        validation("FPE", resp);
    }
}
