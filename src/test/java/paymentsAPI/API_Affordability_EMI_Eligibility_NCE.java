// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_EMI_Eligibility_NCE extends API_PaymentCommon1 {
	
	@Test
	public void Eligi_NCE() throws Exception {
		Response resp ;		
		resp = payPost("Affor_Eligibility_NCE","");
		validation("Affor_Eligibility_NCE", resp);
	}
}
