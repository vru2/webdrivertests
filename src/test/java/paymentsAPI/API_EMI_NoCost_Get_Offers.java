// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_NoCost_Get_Offers extends API_PaymentCommon1
{
	@Test
	public void EMI_Offers_Fetch() throws Exception {
		Response resp ;
		resp = payGet("NoCostEMI_Offers","");
		validation("NoCostEMI_Offers", resp);
	}
}

