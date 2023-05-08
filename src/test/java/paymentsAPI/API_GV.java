// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_GV extends API_PaymentCommon1
{
	@Test
	public void paymentGV_API() throws IOException, JSONException{
		Response resp ;		
		resp = rearchPayment("GV","");	
		validation("GV", resp);
		}

	@Test
	public void paymentGV_API_SCLP() throws IOException, JSONException{
		Response resp ;
		resp = rearchPayment("GVSCLP","");
		validation("GV", resp);
	}
}