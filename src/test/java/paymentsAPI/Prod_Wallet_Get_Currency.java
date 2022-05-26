// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Prod_Wallet_Get_Currency extends API_PaymentCommon1
{
	@Test
	public void Wallet_GetCurrency()  {
		Response resp ;		
		resp = prodAPIs("Wallet_Get_Currency","");	
		validation_Prod("Wallet_Get_Currency", resp);
		}
	
}