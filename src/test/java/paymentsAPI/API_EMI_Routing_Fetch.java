// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_Routing_Fetch extends API_PaymentCommon1
{
	@Test
	public void EMIRouting_fetch() {
		Response resp ;		
		resp = payGet("EMIRouting","");
		validation("EMIRouting", resp);
		}
}

