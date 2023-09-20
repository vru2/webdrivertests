// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_EMI_Eligibility_V2 extends API_PaymentCommon1 {
	
	@Test
	public void Eligi_NCE_V2_PayTM() throws Exception {
		Response resp ;		
		resp = payPost("Affor_Eligibility_NCE_V2","65222355");
		validation("Affor_Eligibility_NCE_V2_PayTM", resp);
	}

	@Test
	public void Eligi_NCE_V2_FKPL() throws Exception {
		Response resp ;
		resp = payPost("Affor_Eligibility_NCE_V2","13957750");
		validation("Affor_Eligibility_NCE_V2_FKPL", resp);
	}

	@Test
	public void Eligi_NCE_V2_PL() throws Exception {
		Response resp ;
		resp = payPost("Affor_Eligibility_NCE_V2","65254480");
		validation("Affor_Eligibility_NCE_V2_PL", resp);
	}
}
