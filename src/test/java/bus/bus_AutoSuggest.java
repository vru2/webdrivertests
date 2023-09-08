// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_AutoSuggest extends bus_Common_API {
	
	@Test
	public void Bus_Autosug() throws Exception {
		Response resp ;		
		resp = busGet("autoSuggest","");
		validation("autoSuggest", resp);
	}
}
