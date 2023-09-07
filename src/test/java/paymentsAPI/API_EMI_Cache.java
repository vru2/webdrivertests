// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_EMI_Cache extends API_PaymentCommon1
{
	@Test
	public void EMICache_OLD() {
		Response resp ;		
		resp = payPut("EMICache","");	
		validation("EMICache", resp);	
		}

	@Test
	public void EMICache_New() {
		Response resp ;
		resp = payPut("EMICache_New","");
		validation("EMICache_New", resp);
	}
}


