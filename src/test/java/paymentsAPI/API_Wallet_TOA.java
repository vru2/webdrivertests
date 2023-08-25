// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_Wallet_TOA extends API_PaymentCommon1
{
	@Test
	public void Wallet_GETWALLET_Details_UI()  {
		Response resp ;		
		resp = walletPost("WALLET_TOA","");
		validation("WALLET_TOA", resp);
	}

}