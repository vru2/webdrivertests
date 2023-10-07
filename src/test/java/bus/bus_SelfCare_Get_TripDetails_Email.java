// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_SelfCare_Get_TripDetails_Email extends bus_Common_API {
	
	@Test
	public void Bus_SelfCare_Tripinfo() throws Exception {
		Response resp ;		
		resp = busGet("GetTripDetails_Email","");
		validation("GetTripDetails_Email", resp);
	}
}
