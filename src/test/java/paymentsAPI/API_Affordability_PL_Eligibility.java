// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Affordability_PL_Eligibility extends API_PaymentCommon1 {

	@Test
	public void Eligibility_PL() throws Exception {
		Response resp ;
		resp = payPost("Affor_Eligibility_PL","65254480");
		validation("Affor_Eligibility_PL", resp);
	}

	@Test
	public void Eligibility_CLEMI() throws Exception {
		Response resp ;
		resp = payPost("Affor_Eligibility_PL","65254480");
		validation("Affor_Eligibility_CLEMI", resp);
	}

	@Test
	public void Eligibility_FKPL() throws Exception { // PL & CL_EMI validation
		Response resp ;
		resp = payPost("Affor_Eligibility_PL","13957750");
		validation("Affor_Eligibility_FKPL", resp);
	}

	@Test
	public void Eligibility_FKPL_Only() throws Exception {// PL validation only
		Response resp ;
		resp = payPost("Affor_Eligibility_FKPL_Only","13957750");
		validation("Affor_Eligibility_FKPL_Only", resp);
	}

	@Test
	public void Eligibility_PayTMPostpaid() throws Exception {
		Response resp ;
		resp = payPost("Affor_Eligibility_PL","65222355");
		validation("Affor_Eligibility_PayTMPostpaid", resp);
	}
}