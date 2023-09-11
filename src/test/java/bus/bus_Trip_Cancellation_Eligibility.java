// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Trip_Cancellation_Eligibility extends bus_Common_API {
	
	@Test
	public void Bus_Cancellation_eligibility() throws Exception {
		Response resp ;		
		resp = busPost("Cancellation_Eligibility","");
		validation("Cancellation_Eligibility", resp);
	}
}
