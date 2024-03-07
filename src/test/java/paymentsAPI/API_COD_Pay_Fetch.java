package test.java.paymentsAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_COD_Pay_Fetch extends API_PaymentCommon1{

    @Test
    public void CODFetch_Pay() {
        Response resp ;
        resp = payGet("CODFetch_Pay","");
        validation("CODFetch_Pay", resp);
    }
}
