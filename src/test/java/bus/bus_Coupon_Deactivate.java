// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Coupon_Deactivate extends bus_Common_API {
	
	@Test
	public void Bus_deactivateCoupon() throws Exception {
		Response resp ;		
		resp = busGet("couponDeactivate","");
		validation("couponDeactivate", resp);
	}
}
