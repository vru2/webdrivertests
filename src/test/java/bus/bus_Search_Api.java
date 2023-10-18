// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Search_Api extends bus_Common_API {

	String search_id = null;
	@Test
	public void Bus__Search() throws Exception {
		Response resp ;		
		resp = busGet("Search",SRP_Date(10));
		validation("Search", resp);
	}

	@Test
	public void Bus_Chart() throws Exception {
		Response resp ;
		resp = busGet("Search","");
		validation("Search", resp);
	}
}
