// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_SelfCare_Trip_Cancel_Booking extends bus_Common_API {
	
	@Test
	public void Bus_Cancel_Booking() throws Exception {
		Response resp ;		
		resp = busPut("Cancel_booking","");
		validation("Cancel_booking", resp);
	}
}
