// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_COD_Pincode extends API_PaymentCommon1
{
	@Test
	public void CODVerify_Pin_Valid() {
		Response resp ;
		resp = payGet("CODPincode_Verify_Valid","560085");
		validation("CODPincode_Verify_Valid", resp);
	}

	@Test
	public void CODVerify_Pin_Invalid() {
		Response resp ;
		resp = payGet("CODPincode_Verify_Valid","560002");
		validation("CODPincode_Verify_Invalid", resp);
	}

	@Test
	public void CODFetch_Pin() {
		Response resp ;
		resp = payGet("CODPincode_Fetch","560085");
		validation("CODPincode_Fetch", resp);
	}

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