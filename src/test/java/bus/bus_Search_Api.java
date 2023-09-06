// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Search_Api extends bus_Common_API {
	
	@Test
	public void Bus__Search() throws Exception {
		Response resp ;		
		resp = busGet("Search","");
		validation("Search", resp);
	}
}
