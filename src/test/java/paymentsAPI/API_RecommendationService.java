// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_RecommendationService extends API_PaymentCommon1 {
	
	@Test
	public void PrefferedMode_getuser() throws Exception{
		Response resp ;		
		resp = payGet1("get_prefferred_modes","");
		System.out.println("Response body "+ resp.body().asString());
		validation("get_prefferred_modes", resp);
	}

}
