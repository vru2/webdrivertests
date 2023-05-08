// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import test.java.paymentsBento_com.PaymentUI_Common;

public class API_EMI_Fetch extends PaymentUI_Common
{
	@Test
	public void EMIFetch() throws Exception {
		String tripRef = getNewDate_TripID();
		resp = payUIget("Air", "", tripRef);
		Response resp ;		
		resp = rearchPayment("EMIFetch",tripRef);	
		validation("EMIFetch", resp);	
		}
}

