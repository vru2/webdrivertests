package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_Save_TripPDF extends TripserviceCommon {
	@Test(groups={"Regression"})
	public void trippdf() throws IOException, InterruptedException{
		String url="http://trip-service-api.cltp.com:9001/trips/Q210819130428/pdf";
		String s=RandomStringUtils.randomNumeric(4);
		String params="{\"pdfPath\":\"test-eticket"+s+"\",\"pdfType\":\"e-ticket\",\"requestId\":\"12345\"}";
		System.out.println(url);
		Reporter.log(url);
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers("Content-Type","application/json").
				post(url);
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(resp);
			 Assert.assertEquals("Response consists of created_at field",bodyAsString.contentEquals("created_at"), bodyAsString.contentEquals("created_at"));	
			 Assert.assertEquals("Response consists of updated_at field",bodyAsString.contentEquals("updated_at"), bodyAsString.contentEquals("updated_at"));	
			 Assert.assertEquals("Response consists of id field",bodyAsString.contentEquals("id"), bodyAsString.contentEquals("id"));	
			 Assert.assertEquals("Response consists of pdf_path field",bodyAsString.contentEquals("pdf_path"), bodyAsString.contentEquals("pdf_path"));	
			 Assert.assertEquals("Response consists of pdf_type field",bodyAsString.contentEquals("pdf_type"), bodyAsString.contentEquals("pdf_type"));	
			 Assert.assertEquals("Response consists of request_id field",bodyAsString.contentEquals("request_id"), bodyAsString.contentEquals("request_id"));	
			 Assert.assertEquals("Response consists of trip_id field",bodyAsString.contentEquals("trip_id"), bodyAsString.contentEquals("trip_id"));	
			 Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
		
	}

}
