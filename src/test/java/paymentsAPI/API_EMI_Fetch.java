// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_EMI_Fetch extends API_PaymentCommon1
{
	@Test
	public void EMIFetch() throws Exception {
		//
		// resp = payUIget("Air", "", tripRef);
		String tripRef = getNewDate_TripID();
		Response resp ;		
		resp = rearchPayment("EMIFetch",tripRef);	
		validation("EMIFetch", resp);	
		}
}

