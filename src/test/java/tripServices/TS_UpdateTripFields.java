package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_UpdateTripFields extends TripserviceCommon{
	

	@Test(groups={"Regression"})
	public void UpdateTripFields() throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(params,headersForTripservicepostcall(),url);
		validationforputcall(resp);		
		Response resp1;
		String url1 = ("http://trip-service-api.cltp.com:9001/trips/"+tripref+"/air-bookings/update-booking");
		Reporter.log(url1);
		resp1=TripserviceHotelsPutcall(params3,headersForTripserviceputcall(),url1);
		validationforput(resp1);
		Thread.sleep(8000);		
		DBValidation_Txn(resp, "C");
		Response resp2;
		String url2="http://trip-service-api.cltp.com:9001/trips/trip-fields";
		Reporter.log(url2);
		String tripfield="{\"trip_ref\":\""+tripref+"\",\"ct_gstin\":\"27AACCC6016B1Z8\",\"taxation_model\":\"agency\",\"has_revenue\":\"1\"}";
		resp2=TripserviceHotelsPutcall(tripfield,headersForTripservicepostgraphql(),url2);
		Reporter.log(resp2.asString());
		System.out.println(resp2.asString());
		 if(resp2.statusCode()==200){
				
				Reporter.log(resp2.asString());
	            Reporter.log("Status code " + resp2.statusCode());
	            ResponseBody body= resp2.getBody();
				String bodyAsString = body.asString();
				JsonPath jsonPath = new JsonPath(bodyAsString);
				tripref = jsonPath.getJsonObject("trip_ref");
			    Reporter.log("TripId is: " +tripref);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  tripRef");
				Assert.assertNotNull("ct_gstin");
				Assert.assertNotNull("taxation_model");
				Assert.assertNotNull("has_revenue");
				 Thread.sleep(4000);
				 String TripID=tripref;
					ArrayList<String> tripfields=db_UpdateTripFields(TripID);
					String taxation_model=tripfields.get(0);
					String ct_gstin=tripfields.get(1);
					String has_revenue=tripfields.get(2);
					Reporter.log("taxation_model value: " +taxation_model);
					System.out.println("taxation_model value: " +taxation_model);
					Reporter.log("ct_gstin value: " +ct_gstin);
					System.out.println("ct_gstin value: " +ct_gstin);
					Reporter.log("has_revenue value: " +has_revenue);
					System.out.println("has_revenue value: " +has_revenue);
					Assert.assertNotNull("ct_gstin");
					Assert.assertNotNull("taxation_model");
					Assert.assertNotNull("has_revenue");		

	            
			}else{
				Reporter.log("Status code " + resp.statusCode());
				assertTrue(false);
			}
		
 }

}
