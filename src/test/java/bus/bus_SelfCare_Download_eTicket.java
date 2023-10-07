// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_SelfCare_Download_eTicket extends bus_Common_API {
	
	@Test
	public void Bus_SelfCareDownload_eTicket() throws Exception {
		Response resp ;		
		resp = busGet("Download_eTicket","");
		validation("Download_eTicket", resp);
	}
}
