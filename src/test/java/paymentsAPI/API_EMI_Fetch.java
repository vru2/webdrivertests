// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import test.java.paymentsUI_Air.PaymentUI_Common;

public class API_EMI_Fetch extends PaymentUI_Common
{
	@Test
	public void EMFetch() throws Exception {
		String tripRef = getNewDate_TripID();
		resp = payUIget("Air", "", tripRef);
		
		System.out.println(tripRef);
		Response resp ;		
		resp = rearchPayment("EMIFetch",tripRef);	
		validation("EMIFetch", resp);	
		}
}

