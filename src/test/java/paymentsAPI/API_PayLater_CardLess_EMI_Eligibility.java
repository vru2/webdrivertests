// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_PayLater_CardLess_EMI_Eligibility extends API_PaymentCommon1
{
	@Test
	public void PayLater_Raterule_CLEMI()  {
		Response resp ;
		resp = payGet("GET_Raterule_CLEMI","");
		validation("GET_Raterule_CLEMI", resp);
		Assert.assertTrue(false);
	}
	@Test
	public void PayLater_Raterule_PL()  {
		Response resp ;
		resp = payGet("GET_Raterule_PL","");
		validation("GET_Raterule_PL", resp);
		Assert.assertTrue(false);
	}


	
}