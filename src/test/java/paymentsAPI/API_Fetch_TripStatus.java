// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Fetch_TripStatus extends API_PaymentCommon1
{
	@Test
	public void APIFetch_Status() throws InterruptedException {
		Response resp ;
		Thread.sleep(1000);
		resp = payGet("FetchTripStatus","");	
		validation("FetchTripStatus", resp);	
		}
}

