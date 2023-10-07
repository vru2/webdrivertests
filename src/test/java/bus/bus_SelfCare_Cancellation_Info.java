// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_SelfCare_Cancellation_Info extends bus_Common_API {
	
	@Test
	public void Bus_SelfCare_cancelinfo() throws Exception {
		Response resp ;		
		resp = busGet("CancellationInfo","");
		validation("CancellationInfo", resp);
	}
}
