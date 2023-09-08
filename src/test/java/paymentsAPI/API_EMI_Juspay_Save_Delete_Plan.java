// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class API_EMI_Juspay_Save_Delete_Plan extends API_PaymentCommon1
{

	String id = null;
	@Test (priority = 1)
	public void EMIJuspay_saveplan() throws Exception {
		Response resp ;
		resp = payPost("EMI_Juspay_Save_Plan","");
		JsonPath j = new JsonPath(resp.asString());
		id = j.getString("id");
		id = id.substring(1, id.length() - 1);
		Reporter.log("Created Plan ID "+id);
		validation("EMI_Juspay_Save_Plan", resp);
		}

	@Test (priority = 2)
	public void EMIJuspay_DeletePlan() throws Exception {
		Response resp ;
		String url="/paymentservice/emi/emi-entity?id="+id+"&entityType=emi_plans";
		resp= RestAssured.given().
				when().
				log().all().
				delete(url);
		validation("EMI_Juspay_Delete_Plan", resp);
	}


}



