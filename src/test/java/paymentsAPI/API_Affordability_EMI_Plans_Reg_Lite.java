// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_EMI_Plans_Reg_Lite extends API_PaymentCommon1 {
	
	@Test
	public void Eligi_Reg_lite() throws Exception {
		Response resp ;		
		resp = payPost("Affor_Plans_Reg_Lite","");
		validation("Affor_Plans_Reg_Lite", resp);
	}
}