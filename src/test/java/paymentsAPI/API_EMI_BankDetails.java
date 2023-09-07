// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_EMI_BankDetails extends API_PaymentCommon1
{
	@Test
	public void EMIBank_Details() {
		Response resp ;		
		resp = payGet("EMIBankDetails","");
		validation("EMIBankDetails", resp);
		}
}

