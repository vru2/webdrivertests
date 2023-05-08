// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_EMI_Plans_Reg_Full extends API_PaymentCommon1 {
	
	@Test
	public void Eligi_Reg_full() throws Exception {
		Response resp ;		
		resp = payPost("Affor_Plans_Reg_Full","");
		validation("Affor_Plans_Reg_Full", resp);
	}
}