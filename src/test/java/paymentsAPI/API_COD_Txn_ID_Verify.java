package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_COD_Txn_ID_Verify extends API_PaymentCommon1{

    @Test
    public void COD_TxnID_Verify() {
        Response resp ;
        resp = payGet("COD_TxnID_Verify","");
        validation("COD_TxnID_Verify", resp);
    }
}
