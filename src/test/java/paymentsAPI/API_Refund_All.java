// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Refund_All extends API_PaymentCommon1
{
	@Test
	public void paymentCC_API() throws IOException, JSONException, ClassNotFoundException, SQLException, InterruptedException{
			Response resp ;		
			ArrayList<String> db_CC = db_get_Value();
			String RefundID = db_CC.get(1);
			String RefundID1 = db_CC.get(2);
		}
	 
}