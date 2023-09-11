// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Trip_Cancellation_Status extends bus_Common_API {
	
	@Test
	public void Bus_Cancellation_status() throws Exception {
		Response resp ;		
		resp = busPut("Trip_Status","");
		validation("Trip_Status", resp);
	}
}
