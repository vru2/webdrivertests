// Framework - Cleartrip Automation
// Author - Saloni Gothi

package test.java.  paymentsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Binmanager extends API_PaymentCommon1
{
	
	@Test
	public void binmanager_qaurl () throws Exception{
		Response resp ;		
		resp = bin_manager ("Binmanager","");	
		validation("Binmanager", resp);
								
	}
	
	}
