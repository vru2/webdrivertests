// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_Juspay_GetPlans extends API_PaymentCommon1
{
	@Test
	public void EMIJuspay_getPlans() {
		Response resp ;		
		resp = payGet("EMI_Juspay_GetPlans","");
		validation("EMI_Juspay_GetPlans", resp);
		}
}