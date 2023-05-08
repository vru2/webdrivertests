// Framework - Cleartrip Automation
// Author - Varalakshmi

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Banner_New extends API_PaymentCommon1
{
	
	@Test
	public void Get_banner () throws Exception{
        Response resp;
		resp = payGet("BannerNew", "");
		validation("BannerNew",resp);
	
	}
}
