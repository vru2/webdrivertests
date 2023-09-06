// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Update_Trip extends bus_Common_API {
	
	@Test
	public void Bus_UpdateTrip() throws Exception {
		Response resp ;		
		resp = busPut("Update_Trip","");
		validation("Update_Trip", resp);
	}
}
