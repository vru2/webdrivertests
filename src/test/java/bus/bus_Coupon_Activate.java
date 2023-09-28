// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class bus_Coupon_Activate extends bus_Common_API {
	
	@Test
	public void Bus_activateCoupon() throws Exception {
		Response resp ;		
		resp = busGet("couponActivate","");
		validation("couponActivate", resp);
	}
}
