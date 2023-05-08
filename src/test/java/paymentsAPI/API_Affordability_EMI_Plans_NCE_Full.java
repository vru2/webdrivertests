// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_EMI_Plans_NCE_Full extends API_PaymentCommon1 {
	
	@Test
	public void Eligi_NCE_Full() throws Exception {
		Response resp ;		
		resp = payPost("Affor_Plans_NCE_Full","");
		validation("Affor_Plans_NCE_Full", resp);
	}
}