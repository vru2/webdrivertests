// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_FlyinPay extends API_PaymentCommon1
{
	@Test
	public void PaymentCtPayCreate() {
		Response resp ;		
		resp = rearchPayment("FLYIN","");	
		validation("FLYIN", resp);	
		}
} 