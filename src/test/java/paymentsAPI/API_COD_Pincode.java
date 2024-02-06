// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_COD_Pincode extends API_PaymentCommon1
{
	@Test
	public void CODUpdate_Pin() {
		Response resp ;		
		resp = payPut("CODPincode_Update","");
		validation("CODPincode_Update", resp);
	}

	@Test
	public void CODCreate_Pin() throws Exception {
		Response resp ;
		resp = payPost("CODPincode_Create","");
		validation("CODPincode_Create", resp);
	}


}