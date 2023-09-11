// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Wallet_Get_Wallet_INR extends API_PaymentCommon1
{
	@Test
	public void Wallet_GETWALLET()  {
		Response resp ;		
		resp = rearchWallet("GETWALLET_INR","");	
		validation("wallet_GETWALLET_INR", resp);
		}

	@Test
	public void Wallet_GETWALLET_New()  {
		Response resp ;
		resp = rearchWallet("GETWALLET_INR2","");
		validation("wallet_GETWALLET_INR2", resp);
	}

}