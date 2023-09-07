// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_NoCost_Get_Offers extends API_PaymentCommon1
{
	@Test
	public void EMI_Offers_Fetch_OLD() throws Exception {
		Response resp ;
		resp = payGet("NoCostEMI_Offers","");
		validation("NoCostEMI_Offers", resp);
	}

	@Test // Juspay api
	public void EMI_Offers_Fetch_New() throws Exception {
		Response resp ;
		resp = payGet("EMI_Offer_eligibility_New","");
		validation("EMI_Offer_eligibility_New", resp);
	}

}

