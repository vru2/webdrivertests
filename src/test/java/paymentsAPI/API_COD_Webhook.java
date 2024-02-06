// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_COD_Webhook extends API_PaymentCommon1
{

	@Test
	public void COD_Webhook_Success() throws Exception {
		Response resp ;
		resp = payPost("COD_Webhook_Success","");
		validation("COD_Webhook_Success", resp);
	}

	@Test
	public void COD_Webhook_Failure() throws Exception {
		Response resp ;
		resp = payPost("COD_Webhook_Failure","");
		validation("COD_Webhook_Success", resp);
	}

}