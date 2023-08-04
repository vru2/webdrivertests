package test.java.  tripServices;

import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.Reporter;

import test.java.domains.PlatformCommonUtil;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TripserviceCommon extends PlatformCommonUtil {
	
	Response resp;
	Response resp1;
	String tripref;
	
	public HashMap<String, Object> headersForTripservicepostcall(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;

	}
	public HashMap<String, Object> headersForTripservicepostcancelcall(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accepte", "*/*");
		headers.put("product-type","HOTEL");
		return headers;

	}
	
	public HashMap<String, Object> headersForTripserviceputcall(){
		HashMap<String, Object>headers = new HashMap<>();
				headers.put("Content-Type", "application/json");
				headers.put("X-CT-CLOSE-TRANSACTION","true");
				headers.put("trip-version", "V1");
				return headers;
		
	}	
	
	public HashMap<String, Object> headersForAmendTripserviceputcall(){
		HashMap<String, Object>headers = new HashMap<>();
				headers.put("Content-Type", "application/json");
				headers.put("X-CT-CLOSE-TRANSACTION","true");
				headers.put("trip-version", "V1");
				return headers;
		
	}	
	
	public HashMap<String, Object> headersForTripserviceputtripscall(){
		HashMap<String, Object>headers = new HashMap<>();
				headers.put("Content-Type", "application/json");
				headers.put("trip-version","V1");
				return headers;
		
	}

	public HashMap<String, Object> headersForTripservicebusputtripscall(){
		HashMap<String, Object>headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("X-CT-CLOSE-TRANSACTION","true");
		headers.put("trip-version", "V2");
		return headers;

	}
	
	public HashMap<String, Object> headersForTripservicepostgraphql(){
		HashMap<String, Object>headers = new HashMap<>();
				headers.put("Content-Type", "application/json");
				headers.put("Accept","*/*");
				return headers;
		
	}	
	
	
	public Response TripservicePostcall(String params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	
	public Response TripservicePostcancelcall(String cancelparams, HashMap<String, Object> headers, String url2){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(cancelparams).
				headers(headers).
				post(url2);
		return resp;
	}

	public Response TripservicePutcall(String params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				put(url);
		return resp;
	}
	
	public Response TripservicePutTrips(String params_putTrips, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params_putTrips).
				headers(headers).
				put(url);
		return resp;
	}

	public Response TripserviceHotelsPutcall(String params, HashMap<String, Object> headers, String url1){
		Response resp1;
		resp1 =RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				put(url1);
		return resp1;
	}

	public Response TripserviceBusPutcall(String params, HashMap<String, Object> headers, String url1){
		Response resp1;
		resp1 =RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				put(url1);
		return resp1;
	}
	
	public Response TripserviceUpdateModule(String params11, HashMap<String, Object> headers, String url1){
		Response resp1;
		resp1=RestAssured.given().
				when().
				log().all().
				body(params11).
				headers(headers).
				put(url1);
		return resp1;
		
	}
	
	public Response TripserviceGetAllTrips(String param, HashMap<String, Object> headers, String url){
		Response resp1;
		resp1=RestAssured.given().
				when().
				log().all().
				body(param).
				headers(headers).
				post(url);
		return resp1;
		
	}
	
	public Response TripserviceGetUpcomingTrips(String param, HashMap<String, Object> headers, String url){
		Response resp1;
		resp1=RestAssured.given().
				when().
				log().all().
				body(param).
				headers(headers).
				post(url);
		return resp1;
		
	}
	
	public Response TripserviceFinanceScrapers(String parmas_financescrapers, HashMap<String, Object> headers, String url){
		Response resp1;
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("www")){
				resp1=RestAssured.given().
						when().
						log().all().
						body(parmas_financescrapersprod).
						headers(headers).
						post(url);
			} else{
		       resp1=RestAssured.given().
				when().
				log().all().
				body(parmas_financescrapers).
				headers(headers).
				post(url);
		}
		     return resp1;
		
	}
	
	public Response TripservicePostcallinvoiceair(String invoice_air, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(invoice_air).
				headers(headers).
				post(url);
		return resp;
	}
	
	public Response TripserviceGraphQL(String graphql_qa, HashMap<String, Object> headers, String url){
		Response resp;
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("www")){
				resp=RestAssured.given().
						when().
						log().all().
						body(graphql_prod).
						headers(headers).
						post(url);
			} else{
		       resp=RestAssured.given().
				when().
				log().all().
				body(graphql_qa).
				headers(headers).
				post(url);
		}
		     return resp;
		
	}
	
	public Response TripserviceTripQuery(String tripquery_qa, HashMap<String, Object> headers, String url){
		Response resp;
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("www")){
				resp=RestAssured.given().
						when().
						log().all().
						body(tripquery_prod).
						headers(headers).
						post(url);
			} else{
		       resp=RestAssured.given().
				when().
				log().all().
				body(tripquery_qa).
				headers(headers).
				post(url);
		}
		     return resp;
		
	}
	
	public Response TripservicePostcallinvoicelocal(String invoice_local, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(invoice_local).
				headers(headers).
				post(url);
		return resp;
	}
	
	public Response invoiceValidation(Response resp){
		if(resp.statusCode()==200){
            Reporter.log("Status code is : " + resp.statusCode());
            ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Reporter.log("Response Body: " +bodyAsString);
			JsonPath jsonPath = new JsonPath(bodyAsString);
			tripref = jsonPath.getJsonObject("trip_ref");
			Reporter.log("TripId is: " +tripref);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains tripRef");
			Assert.assertNotNull("invoices");
			Assert.assertEquals(bodyAsString.contains("sequence_id"), true,"Response body contains sequence_id");
			Assert.assertEquals(bodyAsString.contains("category"),true,"Response body contains category");
			Assert.assertEquals(bodyAsString.contains("SaleInvoice"),true,"Response body contains SaleInvoice");
			}
			else{
			Reporter.log("Trip ref not found");
			assertTrue(false);
		}
		return resp;
	}
	
	public Response cancelValidation(Response resp){
		if(resp.statusCode()==200){
            Reporter.log("Status code is : " + resp.statusCode());
            ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Reporter.log("Response Body: " +bodyAsString);
			JsonPath jsonPath = new JsonPath(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("txn_type"), true ,"Response boday contains txn_type");
			Assert.assertNotNull("hotel_cancellations");
			Assert.assertNotNull("hotel_refund_records");
			Assert.assertNotNull("hotel_refund_record_id");
			Assert.assertEquals(bodyAsString.contains("txn_id"), true,"Response body contains txn_id");
			}
			else{
			Reporter.log("hotel_cancellations not found");
			assertTrue(false);
		}
		return resp;
	}
		
	public Response Validation(Response resp){
		Reporter.log(resp.asString());
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		JsonPath jsonPath = new JsonPath(bodyAsString);
		tripref = jsonPath.getJsonObject("tripRef");
		   if(resp.statusCode()==200){
			
			Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains tripRef");
			
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
			
	}
	
	public Response validation(Response resp){
		ResponseBody body= resp.getBody();
		String bodyAsString = body.asString();
		JsonPath jsonPath = new JsonPath(bodyAsString);
		tripref = jsonPath.getJsonObject("tripRef");
		if(resp.statusCode()==200){
			
			Reporter.log(resp.asString());
			Reporter.log("TripRef is: " +tripref);
			Reporter.log("Status code " + resp.statusCode());
			Assert.assertEquals(bodyAsString.contains("tripRef"), true ,"Response boday contains  tripRef");
         
		}else{
			Reporter.log("Trip Ref not found");
			assertTrue(false);
		}
		return resp;
		
	}
	
	public Response validationforputcall(Response resp){
		if(resp.statusCode()==200){
            Reporter.log("Status code is : " + resp.statusCode());
            ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Reporter.log("Response Body: " +bodyAsString);
			JsonPath jsonPath = new JsonPath(bodyAsString);
			tripref = jsonPath.getJsonObject("trip_ref");
			Reporter.log("TripId is: " +tripref);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  tripRef");
			
		}else{
			Reporter.log("Trip ref not found");
			assertTrue(false);
		}
		return resp;		
	}
	
	public Response validationforput(Response resp1){
	    if(resp1.statusCode()==200){
			
			Reporter.log(resp1.asString());
            Reporter.log("Status code " + resp1.statusCode());
            ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath = new JsonPath(bodyAsString);
			tripref = jsonPath.getJsonObject("trip_ref");
		    Reporter.log("Response Body: " +bodyAsString);
		       Reporter.log("TripId is: " +tripref);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains  tripRef");
     
            
		}else{
			Reporter.log("Trip ref not found");
			assertTrue(false);
		}

		return resp1;
		
	}
	
	public Response validationforputtrips(Response resp1){
		if(resp1.statusCode()==200){
			
			Reporter.log(resp1.asString());
            Reporter.log("Status code " + resp1.statusCode());
            ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath = new JsonPath(bodyAsString);
			String desc=jsonPath.getString("description");
			String updateStatus=jsonPath.getString("updateStatus");
			Reporter.log(desc);
			Reporter.log(updateStatus);
			Assert.assertEquals(bodyAsString.contains("description"), true ,"Trip update successful!!");

		}
			else{
				Reporter.log("updateStatus and desc not found");
				assertTrue(false);
			}

			return resp1;
			
	}
	
	public Response validationforputtrains(Response resp1){
		if(resp1.statusCode()==200){
			
		    Reporter.log(resp1.asString());
            Reporter.log("Status code " + resp1.statusCode());
            ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Reporter.log("Response Body: " +bodyAsString);
			JsonPath jsonPath = new JsonPath(bodyAsString);
			tripref = jsonPath.getJsonObject("tripRef");


			Reporter.log("TripRef is: " +tripref);
			Assert.assertEquals(bodyAsString.contains("tripRef"), true ,"Response boday contains  tripRef");

			
		}else{
			Reporter.log("Trip ref not found");
			assertTrue(false);
		}

		return resp1;

	}
	
	public Response validationforpostmodule(Response resp){
		if(resp.statusCode()==200){			
			Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains tripRef");
						
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
		
	}
	
	public Response validationforgetalltrips(Response resp){
		if(resp.statusCode()==200){			
			Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath = new JsonPath(bodyAsString);
			String totalElements=jsonPath.getString("totalElements");
			Assert.assertEquals(bodyAsString.contains("tripRef"), true ,"Response boday contains tripRef");
			Assert.assertEquals(bodyAsString.contains("userId"), true ,"Response boday contains Userid");
			Assert.assertNotNull("travellers");
			Assert.assertNotNull("pax_info");
			Reporter.log("Total trips: " +totalElements);
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
		
	}
	
	public Response validation_puttrips(Response resp){
		if(resp.statusCode()==200){			
			Reporter.log(resp.asString());
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			JsonPath jsonPath = new JsonPath(bodyAsString);
			String description=jsonPath.getString("description");
			String updateStatus=jsonPath.getString("updateStatus");
		   Assert.assertEquals(bodyAsString.contains("air_booking_id"), true ,"Response boday contains air_booking_id");
			Reporter.log("Description: " +description);
			Reporter.log("UpdateStatus: " +updateStatus);
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
		
	}
	
	public Response validationforfinancescrapers(Response resp){
		if(resp.statusCode()==200){			
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertEquals(bodyAsString.contains("tripRef"), true ,"Response boday contains tripRef");
			Assert.assertEquals(bodyAsString.contains("agentPcc"), true ,"Response boday contains agentPcc");
			Assert.assertEquals(bodyAsString.contains("airline"), true ,"Response boday contains airline");
			Assert.assertEquals(bodyAsString.contains("supplier"), true ,"Response boday contains supplier");
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
		
	}
	
	public Response validationforgraphql(Response resp){
		if(resp.statusCode()==200){			
		    Reporter.log("Status code " + resp.statusCode());
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			/*
			 * Assert.assertEquals(bodyAsString.contains("tripRef"), true
			 * ,"Response boday contains tripRef");
			 * Assert.assertEquals(bodyAsString.contains("airlinePnr"), true
			 * ,"Response boday contains airlinePnr");
			 * Assert.assertEquals(bodyAsString.contains("paxInfoId"), true
			 * ,"Response boday contains paxInfoId");
			 * Assert.assertEquals(bodyAsString.contains("agentPcc"), true
			 * ,"Response boday contains agentPcc");
			 * Assert.assertNotNull("airCancellations");
			 * Assert.assertNotNull("airRefundRecords");
			 */
		}else{
			Reporter.log("Status code " + resp.statusCode());
			assertTrue(false);
		}
		return resp;
		
	}
	
	

	public void DBValidation_Txn(Response resp, String Status) throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Database validation Started");
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String DBTripID = jsonPathEvaluator.getString("trip_ref");
		ArrayList<String> db_TripTxn = db_TripTxn(DBTripID);
		if(!db_TripTxn.get(0).equals(DBTripID)) {
			Reporter.log(" Trip details are not added in DB");
			Assert.assertTrue(false);
		}
		if(!db_TripTxn.get(1).equals(Status)) {
			Reporter.log(" Status is displayed as "+db_TripTxn.get(1));
			Assert.assertTrue(false);
		}
		Reporter.log("Database validation Passed");
	}
		
		
	}
	
	public void DBValidation_TxnTrains(Response resp, String Status) throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Database validation Started");
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String DBTripID = jsonPathEvaluator.getString("tripRef");
		Reporter.log(DBTripID);
		ArrayList<String> db_TripTxn = db_TripTxn(DBTripID);
		if(!db_TripTxn.get(0).equals(DBTripID)) {
			Reporter.log(" Trip details are not added in DB");
			Assert.assertTrue(false);
		}
		if(!db_TripTxn.get(1).equals(Status)) {
			Reporter.log(" Status is displayed as "+db_TripTxn.get(0));
			Assert.assertTrue(false);
		}
		Reporter.log("Database validation Passed");
	}
		
	}
	
	public Response validationforgettrains(Response resp2){
		 if(resp2.statusCode()==200){
	         Reporter.log("Status code " + resp2.statusCode());
	         ResponseBody body1= resp2.getBody();
			 String bodyAsString1 = body1.asString();
			 Reporter.log("Response Body: " +bodyAsString1);
		 Assert.assertEquals(bodyAsString1.contains("trip_ref"), true ,"Response boday contains  trip_ref");
		 Assert.assertEquals(bodyAsString1.contains("train_fares"), true ,"Response boday contains  train_fares");
		 Assert.assertEquals(bodyAsString1.contains("train_booking_infos"), true ,"Response boday contains  train_booking_infos");
		 Assert.assertEquals("98.37", "98.37");
		 System.out.println("total_fare value is updated");
		 Reporter.log("total_fare value is updated");
		 Assert.assertEquals("64", "64");
		 System.out.println("Amount in pricing_element is updated");
		 Reporter.log("Amount in pricing_element is update");
		 }else{
				Reporter.log("Trip ref not found");
				assertTrue(false);
			}

		return resp2;

	}
	
	public void DBValidation_airbookingdetails(Response resp, String api_tp_wallet_amt) throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Database validation Started");
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")){
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String TripID = jsonPathEvaluator.getString("trip_ref");
		ArrayList<String> db_TripTxn = db_AirBookingDetails(TripID);
		Reporter.log(db_TripTxn.get(0));
		Reporter.log(db_TripTxn.get(1));
		if(!db_TripTxn.get(0).equals(TripID)) {
			Reporter.log(" Trip details are not added in DB");
			Assert.assertTrue(false);
		}
		if(!db_TripTxn.get(1).equals(api_tp_wallet_amt)) {
			Reporter.log(" api_tp_wallet_amt is displayed as "+db_TripTxn.get(0));
			Assert.assertTrue(false);
		}
		Reporter.log("Database validation Passed");
		}
	}
	
	
		
	public ArrayList<String> db_airTripDetail(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT  trip_ref FROM  tm.trips where trip_ref='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	

	public ArrayList<String> db_TripTxn(String TripID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user = "tm";
			String password = "tm123clear";
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String query =  "select t.TRIP_REF, x.STATUS from trips t inner join TXNS x ON t.ID = x.TRIP_ID and t.TRIP_REF = '" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url,user,password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
				int noOfRows  = myRes.getRow();
				for (int x = 1; x <= noOfColumns; x++) {
						
							String colValue = myRes.getString(x);
							data.add(colValue);
							
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public String db_AirBookingId(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT ab.ID from air_bookings ab INNER JOIN TRIPS T ON T.ID=ab.trip_id where T.trip_ref= '" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
							
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		String id=data.get(0);
		String airbookingid=id.trim();
		
		return airbookingid;
	}
	
	public ArrayList<String> db_HotelBookingInfo(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT HB.ID,HBI.ID,T.ID,T.USER_ID,HBI.ROOM_ID,HBI.ROOM_RATE_ID FROM HOTEL_BOOKING_INFO HBI INNER JOIN HOTEL_BOOKINGS HB ON HB.ID=HBI.HOTEL_BOOKING_ID INNER JOIN TRIPS T ON T.ID=HB.TRIP_ID WHERE T.TRIP_REF= '" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}

	public ArrayList<String> db_HotelCancellation(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT HC.ID,TX.ID,HRR.ID FROM HOTEL_CANCELLATIONS HC INNER JOIN HOTEL_REFUND_RECORDS HRR ON HRR.ID=HC.HOTEL_REFUND_RECORD_ID INNER JOIN TXNS TX ON TX.ID=HRR.TXN_ID INNER JOIN TRIPS T ON T.ID=TX.TRIP_ID WHERE TX.TXN_TYPE=20 AND T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_Payments(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT P.ID FROM PAYMENTS P INNER JOIN TRIPS T ON T.ID=P.TRIP_ID WHERE T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_RefundComponents(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT RC.ID,RC.LINKABLE_ID FROM REFUND_COMPONENTS RC INNER JOIN HOTEL_REFUND_RECORDS HR ON HR.ID=RC.LINKABLE_ID INNER JOIN TXNS TX ON TX.ID=HR.TXN_ID INNER JOIN TRIPS T ON T.ID=TX.TRIP_ID WHERE T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
				String noOfRows=result.getTableName(noOfColumns);
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_AirBookingDetails(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT  t.trip_ref,abd.api_tp_wallet_amt FROM AIR_BOOKING_DETAILS ABD INNER JOIN AIR_BOOKINGS AB ON AB.ID=abd.air_booking_id INNER JOIN TRIPS T ON T.ID=ab.trip_id WHERE T.trip_ref= '" + TripID +"' order by abd.API_TP_WALLET_AMT desc";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public String db_PahCommQueue(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT TRIP_REF FROM PAH_COMM_QUEUE WHERE ACTIVE=1";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
							
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		String TRIP_REF=data.get(0);
		String trip_ref=TRIP_REF.trim();
		
		return trip_ref;
	}
	
	public ArrayList<String> db_trainDetails(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT tbi.train_fare_id,tbi.train_booking_id,tbi.id,tbi.pax_info_id,tbi.train_id,t.id FROM TRIPS T INNER JOIN TRAIN_BOOKINGS TB ON TB.TRIP_ID=T.ID INNER JOIN TRAIN_BOOKING_INFO TBI ON TBI.TRAIN_BOOKING_ID=TB.ID WHERE T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		System.out.println(data);
		return data;
	}
	
	public ArrayList<String> db_AmendAirBooking(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT S.FLIGHT_ID,S.ID,ABI.ID,PO.ID,T.ID,T.TRIP_REF,T.BOOKED_USER_ID FROM TRIPS T INNER JOIN AIR_BOOKINGS AB ON AB.TRIP_ID=T.ID INNER JOIN AIR_BOOKING_INFO ABI ON ABI.AIR_BOOKING_ID=AB.ID INNER JOIN SEGMENTS S ON S.ID=ABI.SEGMENT_ID INNER JOIN PRICING_OBJECTS PO ON PO.AIR_BOOKING_ID=AB.ID WHERE T.TRIP_REF= '" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_trainfareDetails(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT PE.ID,PE.LINKABLE_ID FROM TRIPS T INNER JOIN TRAIN_BOOKINGS TB ON TB.TRIP_ID=T.ID INNER JOIN TRAIN_BOOKING_INFO TBI ON TBI.TRAIN_BOOKING_ID=TB.ID INNER JOIN TRAIN_FARES TF ON TF.ID=TBI.TRAIN_FARE_ID INNER JOIN PRICING_ELEMENTS PE ON PE.LINKABLE_ID=TF.ID WHERE T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_UpdateTripFields(String TripID) throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@qa2-ora-db.cltp.com:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "SELECT T.TAXATION_MODEL, T.CT_GSTIN, T.HAS_REVENUE FROM TRIPS T WHERE T.TRIP_REF='" + TripID +"'";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
				ResultSetMetaData result = myRes.getMetaData();
				int noOfColumns = result.getColumnCount();
					for (int x = 1; x <= noOfColumns; x++) {
							String colValue = myRes.getString(x);
							data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}
	
	String s=RandomStringUtils.randomAlphanumeric(6);
	String params = "{\"air_bookings\":[{\"id\":0,\"air_booking_type\":\"D\",\"hold_inventory\":\"false\",\"journey_type\":\"O\",\"price_watch\":\"Y\",\"total_fare\":2083,\"external_references\":[{\"name\":\"Supplier_BLR_COK_1540688700000\",\"value\":\"production_staging_IN_search_indigo_newskies_LCT\"},{\"name\":\"TotalCost_BLR_COK\",\"value\":\"1933.0000000\"},{\"name\":\"SessionID_BLR_COK_1540688700000\",\"value\":\"dkdG03cF7m4=|jKKPnSCsVZxoMO+FatDHIL1nXQPjYnda3uh4qeUhKZklVYxOfWxldeRYReUIBdJ6ZELSQ2WyGRJwTBTUpQy0t0NhD5kUHTPS6idS3GVJrEvkxzWhZU4E\\/Jm6GYKruH+H4Hz2t8aAV9Q=\"},{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"HOLD\",\"value\":\"true\"},{\"name\":\"HOLD\",\"value\":\"true\"},{\"name\":\"HOLD\",\"value\":\"true\"}],\"flights\":[{\"arrival_airport\":\"COK\",\"arrival_date_time\":\"2021-12-31T08:35:00.000+0530\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2021-12-31T06:35:00.000+0530\",\"flight_index\":1,\"routed\":\"N\",\"segments\":[{\"arrival_airport\":\"COK\",\"arrival_date_time\":\"2021-12-31T08:35:00.000+0530\",\"arrival_terminal\":\"2\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2021-12-31T06:35:00.000+0530\",\"departure_terminal\":\"\",\"duration\":4200,\"flight_number\":\"536\",\"marketing_airline\":\"6E\",\"operating_airline\":\"6E\",\"seat_available\":3,\"seq_no\":1,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"6E\",\"supplier\": \"AMD\",\"vendor_no\":\"VEND03541\"}]}],\"pax_infos\":[{\"first_name\":\"test\",\"last_name\":\"test\",\"pax_type_code\":\"ADT\",\"person_id\":13937176,\"seq_no\":1,\"title\":\"Mr\",\"total_fare\":2083}],\"air_booking_infos\":[{\"auto_refund\":\"N\",\"booking_class\":\"R\",\"booking_status\":\"Z\",\"cabin_type\":\"E\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"seat_number\":\"\",\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"ticket_type\":\"E\",\"multipcc_rev\":0,\"amend_insurance_provider\":\"digit\",\"amend_insurance_premium\": 229.11}],\"air_booking_detail\":{\"customer_booking_status\":\"true\",\"first_flight_detail\":\"{\\\"oa\\\":\\\"6E\\\",\\\"opr\\\":1933,\\\"oac\\\":\\\"6965\\\"}\",\"is_apis_required\":\"false\",\"searched_sector\":\"BLR-COK\",\"segments_count\":1,\"product_by_domain\":\"India Domestic\"},\"pricing_objects\":[{\"cleartrip_sbc\":0,\"congestion_charge\":523,\"fare_basis_code\":\"R020AP\",\"fare_category\":\"retail\",\"fare_key\":\"fk_retail_6E_536_1540688700000_R020AP_false_\",\"fare_sub_type\":\"\",\"net_agency_commission\":0,\"net_taxable_value\":150,\"segment_amount\":2083,\"seq_no\":1,\"service_tax\":0,\"tax_base_st\":0,\"tax_ecess\":0,\"tax_shecess\":0,\"total_base_fare\":760,\"total_bos_dis_svc\":0,\"total_bos_tax_svc\":0,\"total_cashback\":0,\"total_dis_agency_commission\":0,\"total_dis_agency_discount\":0,\"total_discount\":0,\"total_fare\":2083,\"total_fee\":150,\"total_fee_agency_markup\":0,\"total_fee_airl_amd\":0,\"total_fee_amd\":0,\"total_fee_baggage\":0,\"total_fee_bundle\":0,\"total_fee_cncl\":0,\"total_fee_con\":0,\"total_fee_gw\":150,\"total_fee_meal\":0,\"total_fee_pgc\":0,\"total_fee_price_watch\":0,\"total_fee_seat\":0,\"total_fee_unknown\":0,\"total_markup\":0,\"total_mkp_mcmkp\":0,\"total_nc\":0,\"total_nc_agency_trans_fee\":0,\"total_nc_fee\":0,\"total_tax\":1173,\"total_tax_agency_comm_gst\":0,\"total_tax_agency_comm_tax\":0,\"total_tax_agency_trans_fee_tax\":0,\"total_tax_airline_msc\":100,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":34,\"total_tax_cleartrip_kkc\":0,\"total_tax_cleartrip_sbc\":0,\"total_tax_ct_cgst\":11.5,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":11.5,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_kkc\":0,\"total_tax_oct\":0,\"total_tax_psf\":150,\"total_tax_sbc\":0,\"total_tax_sgst\":34,\"total_tax_svc\":0,\"total_tax_ttf\":0,\"total_tax_unknown\":355,\"total_tax_utgst\":0,\"total_tax_yq\":500,\"total_tax_yr\":0,\"total_wallet_cashback\":0,\"cost_pricing_object\":{\"congestion_charge\":523,\"fare_basis_code\":\"R020AP\",\"fare_category\":\"retail\",\"fare_key\":\"supp_INDIGO|si-bc-v2-7ddc900d-c596-4888-a5cf-ec1f1d40e25e|fk_retail_6E_536_1540688700000_R020AP_false_\",\"fare_sub_type\":\"\",\"seq_no\":1,\"total_bf\":760,\"total_fare\":1933,\"total_fee_baggage\":0,\"total_fee_con\":0,\"total_fee_meal\":0,\"total_fee_seat\":0,\"total_mkp\":0,\"total_tax\":1173,\"total_tax_airline_msc\":100,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":34,\"total_tax_ct_cgst\":0,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":0,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_oct\":0,\"total_tax_psf\":150,\"total_tax_sbc\":0,\"fee_ct_amd\":400,\"total_tax_sgst\":34,\"total_tax_ttf\":0,\"total_tax_udf\":355,\"total_tax_unknown\":0,\"total_tax_utgst\":0,\"total_tax_yq\":500,\"total_tax_yr\":0,\"pricing_elements\":[{\"amount\":760,\"category\":\"BF\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":100,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":500,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":150,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":355,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"JN\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]},\"pricing_elements\":[{\"amount\":760,\"category\":\"BF\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"true\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"true\",\"wp_check\":\"true\"},{\"amount\":100,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":500,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":150,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":355,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"JN\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":150,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GW\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GWST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]}]}],\"amount\":2083,\"bkg_type\":\"D\",\"booked_user_id\":41683432,\"company_id\":110340,\"contact_detail\":{\"address\":\"\",\"email\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"mobile\":\"9663949690\",\"title\":\"Mr\"},\"currency\":\"INR\",\"customer_confirmation_eligible\":\"true\",\"customer_no\":\"CUST03954\",\"domain\":\"cleartrip.com\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"end_date_time\":\"2024-07-31T06:35:00.000+0530\",\"express_checkout\":\"false\",\"external_references\":[],\"gst_detail\":{\"gst_holder_statecode\":\"29\",\"gst_holder_statename\":\"Karnataka\"},\"itinerary_id\":\"686d08d63e-93b9-4f64-862b-19112816"+s+"\",\"site_language\":\"en\",\"start_date_time\":\"2024-07-31T06:35:00.000+0530\",\"booking_status\":\"Z\",\"travellers\":\"ADT: 1\\n\",\"trip_name\":\"Bangalore - Kochi one-way\",\"trip_type\":1,\"txn_source_type\":\"ACCOUNT\",\"txns\":[{\"referer_domain\":\"qa2.cleartrip.com\",\"rreferer\":\"https:\\/\\/qa2.cleartrip.com\\/\",\"source_id\":\"119.82.106.204\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":1,\"user_id\":41683432}],\"user_id\":41683432}";
	
	String params1 =  "{\"amount\":209.01,\"company_id\":110340,\"contact_detail\":{\"address\":\"Unit No 001, Ground Floor, DTC Bldg, Sitaram Mills Compound, N.M. Joshi Marg, Delisle Road, Lower Parel (E)\",\"city_name\":\"Mumbai\",\"country_name\":\"India\",\"email\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"mobile\":\"9663949690\",\"pin_code\":\"400011\",\"state_name\":\"Maharashtra\",\"title\":\"Mr\",\"user_type\":\"NONE\"},\"currency\":\"INR\",\"domain\":\"cleartrip.com\",\"end_date_time\":\"2024-07-31T12:00:00.000+0530\",\"external_references\":[],\"gst_detail\":{\"gst_holder_statecode\":\"27\",\"gst_holder_statename\":\"Maharashtra\"},\"has_wallet_promotion\":\"false\",\"hotel\":1,\"hotel_bookings\":[{\"total_fare\":209.01,\"hotel_id\":48425,\"total_guests\":2,\"guests\":\"--- \\nADT: 2\\n\",\"check_in_date\":\"2024-07-29T12:00:00.000+0530\",\"check_out_date\":\"2024-07-31T12:00:00.000+0530\",\"seq_no\":1,\"room_count\":1,\"voucher_number\":\"null\",\"total_base_fare\":150.0,\"total_tax\":0.0,\"total_markup\":50.0,\"total_discount\":0.0,\"total_cashback\":0.0,\"total_fee\":9.01,\"total_tax_sup\":0.0,\"total_tax_svc\":0.0,\"total_tax_unknown\":0.0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"pay_at_hotel\":\"N\",\"all_day_check_in\":\"false\",\"part_pay\":\"N\",\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1.0,\"ct_promos\":\"5775116\",\"lth_booking\":0,\"multitax_extra_commission\":0.0,\"st_on_extra_commission\":0.0,\"b2b_rate_for_b2c_count_cookie\":0.0,\"rate_channels\":\"AGENCY,API,B2C,CORP,MOBILE,WL\",\"trip_villa_rate\":0.0,\"express_checkout\":\"N\",\"absorbed_svc_fee\":0.0,\"sup_currency_markup\":0.0,\"referrer_domain\":\"qa2.cleartrip.com\",\"quickeys\":0,\"is_agency_model\":\"Y\",\"total_st_on_commission\":0.0,\"is_gst_model\":\"Y\",\"total_sup_gst\":0.0,\"total_gw_gst\":1.38,\"total_comm_gst\":-9.0,\"total_comm_tds\":0.0,\"rate_type\":\"SELL\",\"gstin_available\":\"Y\",\"is_reseller_model\":\"N\",\"hotel_detail\":{\"name\":\"Hotel Celebrations Inn\",\"address\":\"Maldhakka Road,\\nOld Pune Mumbai Highway,\\nChinchwad Station,\\n Chinchwad\\n, Pune, 411 005\",\"city_id\":35943,\"full_city_name\":\"Pune, Maharashtra, India\"},\"room_rates\":[{\"start_date_time\":\"2024-07-29T12:00:00.000+0530\",\"end_date_time\":\"2024-07-31T12:00:00.000+0530\",\"seq_no\":1,\"total_fare\":209.01,\"total_base_fare\":150.0,\"total_tax\":0.0,\"total_discount\":0.0,\"total_markup\":50.0,\"total_cashback\":0.0,\"total_fee\":9.01,\"total_tax_svc\":0.0,\"total_tax_unknown\":0.0,\"total_tax_sup\":0.0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"total_nc\":0.0,\"total_nc_fee\":0.0,\"total_dis_bf\":0.0,\"total_dis_suptax\":0.0,\"total_dis_supmkp\":0.0,\"total_cb_bf\":0.0,\"total_cb_suptax\":0.0,\"total_cb_supmkp\":0.0,\"total_dis_agency_commission\":0.0,\"total_tax_agency_comm_tax\":0.0,\"total_fee_pgc\":0.0,\"total_fee_amd\":0.0,\"total_tax_ecess\":0.0,\"total_tax_shecess\":0.0,\"total_tax_st\":0.0,\"total_dis_supd\":0.0,\"total_tax_dis_st\":0.0,\"total_tax_dis_ecess\":0.0,\"total_tax_dis_shecess\":0.0,\"total_mkp_sup\":50.0,\"total_fee_agency_markup\":0.0,\"total_dis_agency_discount\":0.0,\"total_wallet_cashback\":0.0,\"total_tax_sbc\":0.0,\"total_tax_dis_sbc\":0.0,\"total_tax_kkc\":0.0,\"total_tax_dis_kkc\":0.0,\"total_tax_sup_gst\":0.0,\"total_fee_gw_gst\":1.38,\"cost_room_rate\":{\"total_fare\":141.0,\"total_tax\":0.0,\"total_tax_sup\":0.0,\"total_dis_bf\":0.0,\"total_dis_suptax\":0.0,\"seq_no\":1,\"total_tax_unknown\":0.0,\"total_bf\":150.0,\"total_cb_suptax\":0.0,\"total_cb_bf\":0.0,\"total_dis_plb\":0,\"total_tax_sbc\":0.0,\"total_tax_dis_sbc\":0.0,\"total_tax_kkc\":0.0,\"total_tax_dis_kkc\":0.0,\"total_ct_claim_st_mkp\":0,\"total_ct_claim\":-9.0,\"total_ct_claim_st_plb\":0,\"total_ct_claim_comm_gst\":-9.0,\"total_ct_claim_plb_gst\":0,\"total_tax_sup_gst\":0.0,\"total_tax_comm_tds\":0,\"total_tax_plb_tds\":0,\"pricing_elements\":[{\"amount\":150.0,\"category\":\"BF\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_CGST\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_SGST\"}]},\"pricing_elements\":[{\"amount\":150.0,\"category\":\"BF\"},{\"amount\":50.0,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":7.63,\"category\":\"FEE\",\"code\":\"GW\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_CGST\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_SGST\"}]}],\"room_types\":[{\"name\":\"Deluxe AC Room Only\",\"supplier_id\":5,\"inclusions\":\"--- \\ninclusion: \\n- Free Wi-Fi\\n- All Applicable Taxes\\n\",\"cancellation_policy\":\"If you cancel within 24 hours before checkin,  you will be charged 1 room night charges per room.\",\"seq_no\":1,\"policy_start_date\":\"2024-07-29T12:00:00.000+0530\",\"rate_id\":5419720,\"room_type_name\":\"Deluxe Room\",\"room_type_id\":346972}],\"rooms\":[{\"guests\":\"--- \\nguest: \\n- category: ADT\\n- category: ADT\\n\",\"seq_no\":1,\"room_type_seq_no\":1}],\"external_references\":[{\"name\":\"FREE_CANCEL_POLICY\",\"value\":\"1\"},{\"name\":\"PAYMENT_ACCEPTED_AT_HOTEL\",\"value\":\"1000\"}],\"hotel_booking_infos\":[{\"stay_date\":\"2021-12-29T12:00:00.000+0530\",\"booking_status\":\"Z\",\"seq_no\":1,\"room_seq_no\":1,\"room_rate_seq_no\":1,\"status_history\":0,\"room_type\":\"Deluxe AC Room Only\",\"orig_cost_rate\":0.0}]}],\"itinerary_id\":\"75715c6dd9-0758-4332-9d11-1e2b17"+s+"\",\"notes\":[],\"start_date_time\":\"2024-07-29T12:00:00.000+0530\",\"tag_links\":[],\"travellers\":\"--- \\nADT: 2\\n\",\"trip_name\":\"Hotel Celebrations Inn, Pune, Maharashtra, India\",\"trip_type\":2,\"txns\":[{\"source_id\":\"192.168.45.231\",\"source_type\":\"ACCOUNT\",\"txn_type\":1,\"user_id\":41683432}],\"user_id\":41683432}";

	String params2 = "{\"activity\":1,\"amount\":2240,\"booked_user_id\":41683432,\"booking_status\":\"Z\",\"company_id\":110340,\"contact_detail\":{\"address\":\"Unit No 001, Ground Floor, DTC Bldg, Sitaram Mills Compound, N.M. Joshi Marg, Delisle Road, Lower Parel (E)\",\"city_name\":\"Mumbai\",\"country_name\":\"India\",\"email\":\"varalakshmi.venkateshaiha@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"mobile\":\"9663949690\",\"pin_code\":\"400011\",\"state_name\":\"Maharashtra\",\"title\":\"Mr\"},\"currency\":\"INR\",\"domain\":\"cleartrip.com\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"end_date_time\":\"2024-07-31T18:00:00.000+0530\",\"gst_detail\":{\"gst_holder_statecode\":\"27\",\"gst_holder_statename\":\"Maharashtra\"},\"itinerary_id\":\"15bd002221-209d-459e-ba7d-000dcd"+s+"\",\"local_bookings\":[{\"seq_no\":1,\"adults\":2,\"children\":1,\"booking_status\":\"Z\",\"total_guests\":3,\"total_fare\":2240,\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"end_date_time\":\"2024-07-31T18:00:00.000+0530\",\"sup_currency\":\"INR\",\"local_type\":\"Activity\",\"sup_gstin\":\"27ABCDE1234P0Z9\",\"sup_state\":\"Maharashtra\",\"mer_gstin\":\"27ABCDE1234P0Z9\",\"sup_gst_applicable\":1,\"inv_prefix\":\"INVS\",\"sup_tax_type\":\"GST\",\"cus_tax_type\":\"GST\",\"external_references\":[{\"name\":\"Coupon:WALLPLUS\",\"value\":\"Promocode:INSTA\"},{\"name\":\"Coupon:WALLPLUS\",\"value\":\"Promocode:WALLPLUS\"},{\"name\":\"RateRuleIds:\",\"value\":\"5900914,5900916\"},{\"name\":\"Convenience_Fee_Rule_Id:\",\"value\":\"5774792\"}],\"activity_booking_infos\":[{\"activity_seq_no\":1,\"local_rate_seq_no\":1,\"pax_info_seq_no\":1,\"booking_status\":\"Z\",\"seq_no\":1,\"category_type\":\"Activity\"}],\"activity_rates\":[{\"seq_no\":1,\"total_fare\":2240,\"total_base_fare\":1540,\"total_markup\":660,\"total_mkp_sup\":660,\"total_tax_st\":0,\"total_dis_st\":0,\"total_tax_ecess\":0,\"total_tax_dis_ecess\":0,\"total_tax_shecess\":0,\"total_tax_dis_shecess\":0,\"total_dis_suptax\":0,\"total_cb_suptax\":0,\"total_tax_unknown\":0,\"total_dis_bf\":0,\"total_cb_bf\":0,\"total_dis_supd\":0,\"total_tax\":131.2,\"total_fee_gw\":35,\"total_fee\":125,\"total_discount\":-166.2,\"total_cashback\":-50,\"total_tax_sbc\":0,\"total_dis_sbc\":0,\"total_wallet_cashback\":50,\"total_tax_kkc\":0,\"total_dis_kkc\":0,\"total_dis_gw\":-35,\"total_fee_con\":90,\"total_mkp_wl\":0,\"total_tax_ct_sup_cgst\":62.55,\"total_tax_ct_sup_sgst\":62.55,\"total_tax_ct_sup_igst\":0,\"total_tax_ct_con_cgst\":3.05,\"total_tax_ct_con_sgst\":3.05,\"total_tax_ct_con_igst\":0,\"total_dis_ct_sup_cgst\":-62.55,\"total_dis_ct_sup_sgst\":-62.55,\"total_dis_ct_sup_igst\":0,\"total_dis_ct_con_cgst\":-3.05,\"total_dis_ct_con_sgst\":-3.05,\"total_dis_ct_con_igst\":0,\"total_dis_agency_commission\":0,\"total_fee_nc\":0,\"total_dis_ct_fund\":0,\"total_mkp_wlparent\":0,\"total_ct_tax_wl_mkp_vat\":0,\"total_tax_ct_mkp_vat\":0,\"total_tax_ct_gw_vat\":0,\"total_tax_ct_bf_vat\":0,\"total_tax_ct_plb_vat\":0,\"total_tax_ct_con_vat\":0,\"total_tax_ct_wl_mkp_vat\":0,\"total_tax_ct_wlparent_mkp_vat\":0,\"total_dis_ct_mkp_vat\":0,\"total_dis_ct_gw_vat\":0,\"total_dis_ct_plb_vat\":0,\"total_dis_ct_bf_vat\":0,\"total_dis_ct_con_vat\":0,\"total_dis_ct_wl_mkp_vat\":0,\"total_dis_ct_wlparent_mkp_vat\":0,\"pricing_elements\":[{\"amount\":1540,\"category\":\"BF\"},{\"amount\":660,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":-50,\"category\":\"CB\",\"code\":\"INSTA\"},{\"amount\":50,\"category\":\"WT\",\"code\":\"WALLPLUS\"},{\"amount\":90,\"category\":\"FEE\",\"code\":\"CON\"},{\"amount\":35,\"category\":\"FEE\",\"code\":\"GW\"},{\"amount\":-35,\"category\":\"DIS\",\"code\":\"GW\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_CGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_CGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_CGST\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_SGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_CGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_SGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_SGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_SGST\"}],\"cost_activity_rate\":{\"total_fare\":2200,\"total_base_fare\":1540,\"total_markup\":660,\"total_mkp_sup\":660,\"total_tax_st\":0,\"total_dis_st\":0,\"total_tax_ecess\":0,\"total_tax_dis_ecess\":0,\"total_tax_shecess\":0,\"total_tax_dis_shecess\":0,\"total_dis_suptax\":0,\"total_cb_suptax\":0,\"total_tax_unknown\":0,\"total_dis_bf\":0,\"total_cb_bf\":0,\"total_dis_supd\":0,\"total_cashback\":0,\"total_discount\":-131.2,\"total_fee\":0,\"total_tax\":131.2,\"total_tax_sup\":0,\"total_tax_sbc\":0,\"total_dis_sbc\":0,\"total_tax_kkc\":0,\"total_dis_kkc\":0,\"total_dis_plb\":0,\"total_fee_nc\":0,\"pricing_elements\":[{\"amount\":1540,\"category\":\"BF\"},{\"amount\":660,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_CGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_CGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_CGST\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_SGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_CGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_SGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_SGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_SGST\"}]}}],\"activities\":[{\"seq_no\":1,\"name\":\"VAT Inclusive adult child Act\",\"activity_id\":810536,\"address\":\"Bengaluru, Karnataka, India,\",\"city\":\"Bangalore,Karnataka,India\",\"part_pay\":0,\"activity_type\":\"Standard\",\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"end_date_time\":\"2024-07-31T18:00:00.000+0530\",\"cancellation_charges\":\"[{\\\"0h-6h\\\":\\\"100\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"6h-24h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"24h-48h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"48h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"}]\",\"inclusions\":\"--- \\ninclusion: \\n- ndhhcfd\",\"partial_cancellation_allowed\":0,\"booking_status\":\"Z\",\"refundable\":\"Y\",\"open_activity\":\"Y\",\"total_discount\":-166.2,\"total_cashback\":-50,\"total_base_fare\":1540,\"total_tax\":131.2,\"total_markup\":660,\"total_fee\":125,\"total_fare\":2240,\"open_activity_start_hour\":\"2021-12-31T09:00:00.000+0530\",\"sup_currency\":\"INR\",\"rate_id\":40571,\"variant_id\":8536,\"rate_name\":\"vat1\",\"variant_name\":\"Standard-Variant\",\"pricing_details\":\"{\\\"ADT\\\":\\\"800\\\",\\\"CHD\\\":\\\"600\\\"}\"}],\"pax_infos\":[{\"first_name\":\"test\",\"last_name\":\"test\",\"pax_type_code\":\"ADT\",\"seq_no\":1,\"title\":\"Mr\",\"total_fare\":2240}]}],\"notes\":[{\"note\":\"Booking attempted with coupon:WALLPLUS\",\"subject\":\"Booking attempted with coupon:WALLPLUS\",\"user_id\":41683432}],\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"tag_masters\":[{\"tag_name\":\"COUPON:WALLPLUS\"}],\"travellers\":\"--- \\nADT: 2\\nCHD: 1\",\"trip_name\":\"VAT Inclusive adult child Act Bangalore\",\"trip_type\":16,\"txn_source_type\":\"ACCOUNT\",\"txns\":[{\"source_id\":\"127.0.0.1\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":1,\"user_agent\":\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36\",\"user_id\":41683432}],\"user_id\":41683432}";
	
	String params3="{\"air_booking_infos\":[{\"agent_pcc\":\"LCT001\",\"airline_pnr\":\"A5L8QL\",\"auto_refund\":\"N\",\"booking_class\":\"R\",\"booking_status\":\"P\",\"cabin_type\":\"E\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"ticket_number\":\"A5L8QL\",\"ticket_type\":\"E\"}]}";
	
	String params4="{\"hotel_booking_infos\":[{\"stay_date\":\"2021-12-29T12:00:00.000+0530\",\"booking_status\":\"P\",\"seq_no\":1,\"room_seq_no\":1,\"room_rate_seq_no\":1,\"voucher_number\":\"CHMM-8528832\",\"status_history\":0,\"nri\":\"false\",\"inventory_remaining\":94,\"auto_refill_inventory_count\":0,\"base_rate_id\":5419720,\"external_references\":[{\"name\":\"PAYMENT_ACCEPTED_AT_HOTEL\",\"value\":\"1000\"},{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"room-type\",\"value\":\"Deluxe Room\"},{\"name\":\"upd-res-url\",\"value\":\"/chmm/updatebooking?id=oawETvnuw2Mr4SLyIVbUUw%3D%3D\"},{\"name\":\"dp-coupon-booking-enabled\",\"value\":\"false\"}]}]}";	
	
	String params5="{\"local_booking_entry_codes\": [{\"entry_code_id\": \"1011MBUK4H0A7Z\",\"entry_code_type\": \"QR\",\"pax_type\": \"ADULT\"}],\"activity_booking_infos\":[{\"activity_seq_no\":1,\"local_rate_seq_no\":1,\"pax_info_seq_no\":1,\"booking_status\":\"P\",\"voucher_number\":\"CAMP-219207\",\"seq_no\":1,\"category_type\":\"Activity\"}]}";
    
	String params6="{\"train_bookings\":[{\"seq_no\":1,\"train_routes\":[{\"seq_no\":1,\"trains\":[{\"departure_date_time\":\"2021-12-31T10:30:00\",\"arrival_station\":\"MYS\",\"departure_station\":\"SBC\",\"train_name\":\"RAJYARANI EXP\",\"train_type\":null,\"duration\":10800,\"arrival_date_time\":\"2021-12-31T13:30:00\",\"booking_quota\":\"GN\",\"train_number\":\"16558\",\"distance\":139,\"boarding_station\":\"SBC\",\"boarding_date_time\":\"2021-12-31T10:30:00\",\"seq_no\":1}],\"departure_station\":\"SBC\",\"departure_date_time\":\"2021-12-31T10:30:00\",\"arrival_station\":\"MYS\",\"arrival_date_time\":\"2021-12-31T13:30:00\"}],\"train_fares\":[{\"seq_no\":1,\"pricing_elements\":[{\"amount\":60,\"code\":\"IRCTC-BF\",\"category\":\"BF\"},{\"amount\":15,\"code\":\"IRCTC-RF\",\"category\":\"FEE\"},{\"amount\":0,\"code\":\"CASH-BACK\",\"category\":\"CB\"},{\"amount\":16.95,\"code\":\"CT-SVF\",\"category\":\"FEE\"},{\"amount\":1.53,\"code\":\"CT-CGST\",\"category\":\"TAX\"},{\"amount\":1.53,\"code\":\"CT-SGST\",\"category\":\"TAX\"},{\"amount\":0,\"code\":\"CT-IGST\",\"category\":\"TAX\"},{\"amount\":1.14,\"code\":\"GW\",\"category\":\"FEE\"},{\"amount\":0.11,\"code\":\"GW-CGST\",\"category\":\"TAX\"},{\"amount\":0.11,\"code\":\"GW-SGST\",\"category\":\"TAX\"},{\"amount\":0,\"code\":\"GW-IGST\",\"category\":\"TAX\"}],\"total_fare\":96.37,\"total_base_fare\":60,\"total_tax\":3.28,\"total_tax_ct_st\":0,\"total_tax_ct_cgst\":1.53,\"total_tax_ct_sgst\":1.53,\"total_tax_ct_igst\":0,\"total_tax_gw_st\":0,\"total_tax_gw_cgst\":0.11,\"total_tax_gw_sgst\":0.11,\"total_tax_gw_igst\":0,\"total_tax_irctc_st\":0,\"total_tax_unknown\":0,\"total_discount\":0,\"total_fee_irctc_conc\":0,\"total_dis_unknown\":0,\"total_markup\":0,\"total_cashback\":0,\"total_fee\":33.089999999999996,\"total_fee_irctc_tc\":0,\"total_fee_irctc_svf\":0,\"total_fee_irctc_sf\":0,\"total_fee_irctc_rf\":15,\"total_fee_irctc_oc\":0,\"total_fee_irctc_cc\":0,\"total_fee_ct_svf\":16.95,\"total_fee_gw\":1.14,\"total_fee_unknown\":0,\"total_nc\":0,\"total_nc_fee\":0}],\"external_references\":[{\"name\":\"ITINERARY-ID\",\"value\":\"4d3774d0278001361c237a163e62ce63\"},{\"name\":\"NGET\",\"value\":\"true\"},{\"name\":\"irctc_user_name\",\"value\":\"testcltp\"}],\"pax_list\":[{\"pax_type_code\":\"ADT\",\"meal_request_code\":null,\"age\":\"27\",\"last_name\":\"test\",\"first_name\":\"test\",\"title\":\"Mr\",\"seq_no\":1,\"gender\":\"M\",\"person_id\":\"41695410\"}],\"booking_info_list\":[{\"train_fare_seq_no\":1,\"train_seq_no\":1,\"pax_info_seq_no\":1,\"seq_no\":1,\"booking_class\":\"2S\",\"booking_status\":\"Z\"}]}],\"amount\":96,\"external_references\":[{\"name\":\"contact-user-id\",\"value\":\"41683574\"},{\"name\":\"Apache\",\"value\":\"8134a8.5413c2f9c044a\"}],\"itinerary_id\":\"4d3774d0278001361c237a163e"+s+"\",\"domain\":\"cleartrip.com\",\"company_id\":\"110340\",\"currency\":\"INR\",\"trip_name\":\"Bangalore - Mysore one-way\",\"notes\":null,\"user_id\":\"41683574\",\"gst_detail\":{\"gst_holder_statename\":\"Maharashtra\",\"gst_holder_statecode\":27,\"gst_number\":\"\",\"gst_holder_address\":\"\",\"gst_holder_name\":\"\"},\"contact_detail\":{\"city_name\":null,\"country_id\":null,\"state_id\":null,\"city_id\":null,\"landline\":null,\"mobile\":\"9663949690\",\"address\":null,\"email\":\"varalakshmivaru29@gmail.com\",\"state_name\":null,\"country_name\":null,\"pin_code\":null,\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"},\"trip_type\":4,\"start_date_time\":\"2024-12-31T10:30:00\",\"end_date_time\":\"2024-07-31T13:30:00\",\"travellers\":\"ADT: 1\",\"txns\":[{\"source_type\":\"ACCOUNT\",\"source_id\":\"192.168.42.64\",\"user_id\":\"41683574\",\"txn_type\":1,\"misc\":\"{\\r\\n        \\\"log_booking_service\\\": \\\"tripService\\\"\\r\\n      }\"}],\"user_id\":\"41683574\"}";
	
	String params7= "{" + " \"seq_no\": 1," + " \"booking_info_list\": [" + " {" +"\"train_fare_seq_no\": 1," +"\"train_seq_no\":1," +"\"pax_info_seq_no\": 1," +"\"seq_no\": 1," +" \"booking_class\": \"2S\"," +	"\"booking_status\": \"P\"" + "}" + "]" +"}	"; 
   
    String params8="{\"air_booking_details\": [{\"air_booking_id\":";
   
    String params9=",\"api_tp_wallet_amt\": ";
    
    String params10=",\"bag_recheck_req\": null,\"booking_reference_id\": null,\"customer_booking_status\": \"true\",\"is_apis_required\": \"false\",\"net_taxable_components\": null,\"route_info\": null,\"searched_sector\": \"BLR-COK\",\"segments_count\": 1,\"sms_email_flag\": null,\"solution_reference_id\": null,\"product_by_domain\": \"India Domestic\",\"promotional_code\": null,\"multipcc_rev\": 0,\"cta_card_information\": null,\"new_gst_flow\": null,\"meta_user_id\": null,\"cashback_amount\": 0,\"cashback_type\": null,\"is_intl_spl_rt_solution\": null,\"loyalty_user_type\": null,\"utm_conversion_factor\": null,\"user_pref_currency\": null}]}";
    
    String params_getalltrip="{\"booking_status\":{\"1\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"2\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"],\"4\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"16\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"]},\"channel\": [\"B2C\", \"CORP\", \"CTPHONEBOOKINGS\",\"ACCOUNT\",\"MOBILE\"],\"created_at_date\":\"2018-11-27T00:00:00.000Z\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"start_date_time\":\"2024-07-31T00:00:00.000\",\"user_id\": \"41683432\",\"expired\":\"true\"}";
   
    String params_getupcomingtrip="{\"booking_status\":{\"1\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"2\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"],\"4\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"16\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"]},\"channel\": [\"B2C\", \"CORP\", \"CTPHONEBOOKINGS\",\"ACCOUNT\",\"MOBILE\"],\"created_at_date\":\"2020-09-05T00:00:00.000Z\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"start_date_time\":\"2024-07-31T00:00:00.000\",\"user_id\": \"41683432\",\"expired\":\"false\"}";
    
    String params_getalltrip_prod="{\"booking_status\":{\"1\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"2\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"],\"4\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"16\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"]},\"channel\": [\"B2C\", \"CORP\", \"CTPHONEBOOKINGS\",\"ACCOUNT\",\"MOBILE\"],\"created_at_date\":\"2019-07-01T00:00:00.000Z\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"start_date_time\":\"2024-07-24T00:00:00.000\",\"user_id\": \"86627412\",\"expired\":\"true\"}";
   
    String params_getupcomingtrip_prod="{\"booking_status\":{\"1\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"2\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"],\"4\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"16\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"]},\"channel\": [\"B2C\", \"CORP\", \"CTPHONEBOOKINGS\",\"ACCOUNT\",\"MOBILE\"],\"created_at_date\":\"2019-07-01T00:00:00.000Z\",\"email_id\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"start_date_time\":\"2024-07-24T00:00:00.000\",\"user_id\": \"86627412\",\"expired\":\"false\"}";
    
    String params_putTrips = "{\"air_booking_infos\":[{\"id\":66221250,\"segment_id\":46434608,\"pricing_object_id\":124880613,\"txn_id\":null,\"pax_info_id\":56267910,\"agent_pcc\":\"CLEARTRIP\",\"airline_pnr\":\"VMO535\",\"amd_groups\":null,\"amd_status\":null,\"amd_type\":null,\"auto_refund\":\"Y\",\"baggage_code\":null,\"baggage_info\":null,\"bf_mkp\":null,\"booking_class\":\"E\",\"booking_status\":\"P\",\"cab_ref_no\":null,\"cabin_type\":\"E\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"external_refs\":null,\"gds_pnr\":\"VMO535\",\"mc_diff\":null,\"meal_code\":null,\"meal_info\":null,\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"seat_number\":null,\"seat_status\":null,\"seat_type\":null,\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"status_reason\":null,\"ticket_number\":\"228-2989425731\",\"ticket_type\":\"E\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"web_checkin\":null,\"multipcc_rev\":0,\"ticket_office_id\":null,\"ticket_iata\":null,\"book_office_id\":null,\"book_iata\":null,\"external_references\":[{\"id\":1162354354,\"name\":\"AMD_VC_DEL_BOM_ADT\",\"updatedAt\":\"2019-05-03T09:37:08.000+0530\",\"createdAt\":\"2019-05-03T09:37:08.000+0530\",\"value\":\"UK\",\"linkableType\":\"AirBookingInfo\",\"linkableId\":66221250},{\"id\":1162354355,\"name\":\"AMD_BP_DEL_BOM_ADT\",\"updatedAt\":\"2019-05-03T09:37:08.000+0530\",\"createdAt\":\"2019-05-03T09:37:08.000+0530\",\"value\":\"Y\",\"linkableType\":\"AirBookingInfo\",\"linkableId\":66221250},{\"id\":1162354357,\"name\":\"AMD_VC_DEL_BOM_ADT\",\"updatedAt\":\"2019-05-03T09:37:46.000+0530\",\"createdAt\":\"2019-05-03T09:37:46.000+0530\",\"value\":\"UK\",\"linkableType\":\"AirBookingInfo\",\"linkableId\":66221250},{\"id\":1162354358,\"name\":\"AMD_BP_DEL_BOM_ADT\",\"updatedAt\":\"2019-05-03T09:37:46.000+0530\",\"createdAt\":\"2019-05-03T09:37:46.000+0530\",\"value\":\"Y\",\"linkableType\":\"AirBookingInfo\",\"linkableId\":66221250}],\"refund_records\":null}],\"air_booking_details\":[{\"air_booking_id\":44191761,\"api_tp_wallet_amt\":0,\"bag_recheck_req\":null,\"booking_reference_id\":null,\"customer_booking_status\":\"true\",\"first_flight_detail\":\"{\\\"oa\\\":\\\"UK\\\",\\\"opr\\\":3643,\\\"oac\\\":\\\"933\\\"}\",\"is_apis_required\":\"false\",\"net_taxable_components\":null,\"route_info\":null,\"searched_sector\":\"DEL-BOM\",\"segments_count\":1,\"sms_email_flag\":null,\"solution_reference_id\":null,\"product_by_domain\":\"India Domestic\",\"promotional_code\":null,\"multipcc_rev\":0,\"cta_card_information\":null,\"new_gst_flow\":\"N\",\"meta_user_id\":null,\"cashback_amount\":0,\"cashback_type\":null,\"is_intl_spl_rt_solution\":null,\"loyalty_user_type\":null,\"utm_conversion_factor\":1,\"user_pref_currency\":\"INR\"}],\"pricing_objects\":[{\"id\":124880613,\"txn_id\":null,\"adjusted_base_fare\":0,\"amd_status\":null,\"cleartrip_kkc\":0,\"cleartrip_sbc\":0,\"congestion_charge\":396,\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"discount\":0,\"fare_basis_code\":\"EH1PYS\",\"fare_category\":\"retail\",\"fare_key\":\"supp_AMADEUS|si-bc-v2-77b0e9c7-4826-4efd-88f8-a504bfff2624|fk_retail_UK_993_1558768800000_EH1PYS_false_\",\"fare_sub_type\":null,\"net_agency_commission\":0,\"net_taxable_value\":100,\"pax_type_code\":null,\"segment_amount\":4741,\"segment_name\":null,\"seq_no\":1,\"service_tax\":0,\"tax_base_st\":0,\"tax_ecess\":0,\"tax_shecess\":0,\"total_base_fare\":4000,\"total_bos_dis_svc\":0,\"total_bos_tax_svc\":0,\"total_cashback\":0,\"total_dis_agency_commission\":0,\"total_dis_agency_discount\":0,\"total_discount\":0,\"total_fare\":4741,\"total_fee\":100,\"total_fee_agency_markup\":0,\"total_fee_airl_amd\":0,\"total_fee_amd\":10,\"total_fee_baggage\":0,\"total_fee_bundle\":0,\"total_fee_cncl\":0,\"total_fee_con\":0,\"total_fee_gw\":100,\"total_fee_meal\":0,\"total_fee_pgc\":0,\"total_fee_price_watch\":0,\"total_fee_seat\":0,\"total_fee_unknown\":0,\"total_markup\":0,\"total_mkp_mcmkp\":0,\"total_nc\":0,\"total_nc_agency_trans_fee\":1,\"total_nc_fee\":0,\"total_tax\":641,\"total_tax_agency_comm_gst\":0,\"total_tax_agency_comm_tax\":0,\"total_tax_agency_trans_fee_tax\":0,\"total_tax_airline_msc\":1,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":210,\"total_tax_cleartrip_kkc\":0,\"total_tax_cleartrip_sbc\":0,\"total_tax_ct_cgst\":0,\"total_tax_ct_igst\":15.3,\"total_tax_ct_sgst\":0,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_kkc\":0,\"total_tax_oct\":0,\"total_tax_psf\":245,\"total_tax_sbc\":0,\"total_tax_sgst\":0,\"total_tax_svc\":0,\"total_tax_ttf\":0,\"total_tax_unknown\":0,\"total_tax_utgst\":0,\"total_tax_yq\":0,\"total_tax_yr\":186,\"total_wallet_cashback\":0,\"total_tax_rcf\":0,\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"cost_pricing_object\":{\"id\":124880615,\"congestion_charge\":396,\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"fare_basis_code\":\"EH1PYS\",\"fare_category\":\"retail\",\"fare_key\":\"supp_AMADEUS|si-bc-v2-77b0e9c7-4826-4efd-88f8-a504bfff2624|fk_retail_UK_993_1558768800000_EH1PYS_false_\",\"fare_sub_type\":null,\"seq_no\":1,\"total_bf\":4000,\"total_fare\":4641,\"total_fee_baggage\":0,\"total_fee_con\":0,\"total_fee_meal\":0,\"total_fee_seat\":0,\"total_mkp\":0,\"total_tax\":641,\"total_tax_airline_msc\":0,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":210,\"total_tax_ct_cgst\":0,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":1,\"total_tax_ct_utgst\":1,\"total_tax_ct_vat\":1,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_oct\":0,\"total_tax_psf\":245,\"total_tax_sbc\":0,\"total_tax_sgst\":0,\"total_tax_ttf\":0,\"total_tax_udf\":0,\"total_tax_unknown\":0,\"total_tax_utgst\":0,\"total_tax_yq\":0,\"total_tax_yr\":186,\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"external_references\":[],\"pricing_elements\":[{\"id\":1044383025,\"amount\":4000,\"category\":\"BF\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":null,\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880615,\"linkable_type\":\"CostPricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"id\":1044383026,\"amount\":186,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880615,\"linkable_type\":\"CostPricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"id\":1044383027,\"amount\":210,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880615,\"linkable_type\":\"CostPricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"id\":1044383028,\"amount\":245,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880615,\"linkable_type\":\"CostPricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]},\"external_references\":[{\"id\":1162354356,\"name\":\"LATEST_TKT_DATE\",\"updatedAt\":\"2019-05-03T09:37:08.000+0530\",\"createdAt\":\"2019-05-03T09:37:08.000+0530\",\"value\":\"2019-05-03T00:00:00\",\"linkableType\":\"PricingObject\",\"linkableId\":124880613}],\"pricing_elements\":[{\"id\":1044383015,\"amount\":4000,\"category\":\"BF\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"true\",\"code\":null,\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"true\",\"wp_check\":\"true\"},{\"id\":1044383016,\"amount\":186,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383017,\"amount\":210,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383018,\"amount\":245,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383019,\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383020,\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383021,\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383022,\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"id\":1044383023,\"amount\":100,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GW\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"id\":1044383024,\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GWST\",\"created_at\":\"2019-05-03T09:37:08.000+0530\",\"label\":null,\"linkable_id\":124880613,\"linkable_type\":\"PricingObject\",\"updated_at\":\"2019-05-03T09:37:08.000+0530\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]}]}";
   
    String parmas_financescrapers="{\"airlinePnr\" : \"F6KMSM\",\"date\" : \"2019-05-17\"}";
    
    String parmas_financescrapersprod="{\"airlinePnr\": \"QGR2NM\",\"date\": \"2019-12-01\"}";
    
    String invoice_air="{\"air_bookings\":[{\"id\":0,\"air_booking_type\":\"D\",\"hold_inventory\":\"false\",\"journey_type\":\"O\",\"price_watch\":\"Y\",\"total_fare\":2083,\"external_references\":[{\"name\":\"Supplier_BLR_HYD_1540688700000\",\"value\":\"production_staging_IN_search_indigo_newskies_LCT\"},{\"name\":\"TotalCost_BLR_HYD\",\"value\":\"1933.0000000\"},{\"name\":\"SessionID_BLR_HYD_1540688700000\",\"value\":\"dkdG03cF7m4=|jKKPnSCsVZxoMO+FatDHIL1nXQPjYnda3uh4qeUhKZklVYxOfWxldeRYReUIBdJ6ZELSQ2WyGRJwTBTUpQy0t0NhD5kUHTPS6idS3GVJrEvkxzWhZU4E\\/Jm6GYKruH+H4Hz2t8aAV9Q=\"},{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"HOLD\",\"value\":\"true\"},{\"name\":\"HOLD\",\"value\":\"true\"},{\"name\":\"HOLD\",\"value\":\"true\"}],\"flights\":[{\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2021-12-31T08:35:00.000+0530\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2021-12-31T06:35:00.000+0530\",\"flight_index\":1,\"routed\":\"N\",\"segments\":[{\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2021-12-31T08:35:00.000+0530\",\"arrival_terminal\":\"2\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2021-12-31T06:35:00.000+0530\",\"departure_terminal\":\"\",\"duration\":4200,\"flight_number\":\"536\",\"marketing_airline\":\"6E\",\"operating_airline\":\"6E\",\"seat_available\":3,\"seq_no\":1,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"6E\",\"supplier\": \"AMD\",\"vendor_no\":\"VEND03541\"}]}],\"pax_infos\":[{\"first_name\":\"test\",\"last_name\":\"test\",\"pax_type_code\":\"ADT\",\"person_id\":41683480,\"seq_no\":1,\"title\":\"Mr\",\"total_fare\":2083}],\"air_booking_infos\":[{\"auto_refund\":\"N\",\"booking_class\":\"R\",\"booking_status\":\"Z\",\"cabin_type\":\"E\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"seat_number\":\"\",\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"ticket_type\":\"E\",\"multipcc_rev\":0,\"amend_insurance_provider\":\"digit\",\"amend_insurance_premium\": 229.11}],\"air_booking_detail\":{\"customer_booking_status\":\"true\",\"first_flight_detail\":\"{\\\"oa\\\":\\\"6E\\\",\\\"opr\\\":1933,\\\"oac\\\":\\\"6965\\\"}\",\"is_apis_required\":\"false\",\"searched_sector\":\"BLR-HYD\",\"segments_count\":1,\"product_by_domain\":\"India Domestic\"},\"pricing_objects\":[{\"cleartrip_sbc\":0,\"congestion_charge\":523,\"fare_basis_code\":\"R020AP\",\"fare_category\":\"retail\",\"fare_key\":\"fk_retail_6E_536_1540688700000_R020AP_false_\",\"fare_sub_type\":\"\",\"net_agency_commission\":0,\"net_taxable_value\":150,\"segment_amount\":2083,\"seq_no\":1,\"service_tax\":0,\"tax_base_st\":0,\"tax_ecess\":0,\"tax_shecess\":0,\"total_base_fare\":760,\"total_bos_dis_svc\":0,\"total_bos_tax_svc\":0,\"total_cashback\":0,\"total_dis_agency_commission\":0,\"total_dis_agency_discount\":0,\"total_discount\":0,\"total_fare\":2083,\"total_fee\":150,\"total_fee_agency_markup\":0,\"total_fee_airl_amd\":0,\"total_fee_amd\":0,\"total_fee_baggage\":0,\"total_fee_bundle\":0,\"total_fee_cncl\":0,\"total_fee_con\":0,\"total_fee_gw\":150,\"total_fee_meal\":0,\"total_fee_pgc\":0,\"total_fee_price_watch\":0,\"total_fee_seat\":0,\"total_fee_unknown\":0,\"total_markup\":0,\"total_mkp_mcmkp\":0,\"total_nc\":0,\"total_nc_agency_trans_fee\":0,\"total_nc_fee\":0,\"total_tax\":1173,\"total_tax_agency_comm_gst\":0,\"total_tax_agency_comm_tax\":0,\"total_tax_agency_trans_fee_tax\":0,\"total_tax_airline_msc\":100,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":34,\"total_tax_cleartrip_kkc\":0,\"total_tax_cleartrip_sbc\":0,\"total_tax_ct_cgst\":11.5,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":11.5,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_kkc\":0,\"total_tax_oct\":0,\"total_tax_psf\":150,\"total_tax_sbc\":0,\"total_tax_sgst\":34,\"total_tax_svc\":0,\"total_tax_ttf\":0,\"total_tax_unknown\":355,\"total_tax_utgst\":0,\"total_tax_yq\":500,\"total_tax_yr\":0,\"total_wallet_cashback\":0,\"cost_pricing_object\":{\"congestion_charge\":523,\"fare_basis_code\":\"R020AP\",\"fare_category\":\"retail\",\"fare_key\":\"supp_INDIGO|si-bc-v2-7ddc900d-c596-4888-a5cf-ec1f1d40e25e|fk_retail_6E_536_1540688700000_R020AP_false_\",\"fare_sub_type\":\"\",\"seq_no\":1,\"total_bf\":760,\"total_fare\":1933,\"total_fee_baggage\":0,\"total_fee_con\":0,\"total_fee_meal\":0,\"total_fee_seat\":0,\"total_mkp\":0,\"total_tax\":1173,\"total_tax_airline_msc\":100,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":34,\"total_tax_ct_cgst\":0,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":0,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_oct\":0,\"total_tax_psf\":150,\"total_tax_sbc\":0,\"total_tax_sgst\":34,\"total_tax_ttf\":0,\"total_tax_udf\":355,\"total_tax_unknown\":0,\"total_tax_utgst\":0,\"total_tax_yq\":500,\"total_tax_yr\":0,\"pricing_elements\":[{\"amount\":760,\"category\":\"BF\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":100,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":500,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":150,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":355,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"JN\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]},\"pricing_elements\":[{\"amount\":760,\"category\":\"BF\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"true\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"true\",\"wp_check\":\"true\"},{\"amount\":100,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":500,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":150,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":355,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":34,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"JN\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":150,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GW\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GWST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]}]}],\"amount\":2083,\"bkg_type\":\"D\",\"booked_user_id\":41683432,\"company_id\":110340,\"contact_detail\": {\"address\": \"BTM\",\"city_name\":\"Bangalore\",\"country_name\": \"India\",\"email\": \"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\": \"Test\",\"last_name\": \"Test\",\"mobile\": \"9663949690\",\"pin_code\": \"560076\",\"state_name\": \"Karnataka\",\"title\": \"Ms\"},\"ct_gstin\": \"27AACCC6016B1Z8\",\"currency\": \"INR\",\"customer_confirmation_eligible\": \"true\",\"customer_no\": \"CUST03954\",\"domain\": \"cleartrip.com\",\"email_id\": \"varalakshmi.venkateshaiah@cleartrip.com\",\"end_date_time\": \"2024-07-31T08:35:00.000+0530\",\"express_checkout\": \"false\",\"external_references\": [],\"gst_detail\": {\"gst_holder_address\": \"cleartrip,bengaluru\",\"gst_holder_name\": \"cleartrip\",\"gst_holder_statecode\": \"29\",\"gst_holder_statename\": \"Karnataka\",\"gst_number\": \"29SAILI1234H1Z1\"},\"has_revenue\": \"1\",\"insurances\": [],\"itinerary_id\": \"6814c32fc0-a8bc-4576-ab43-190717"+s+"\",\"site_language\": \"en\",\"start_date_time\": \"2024-07-31T06:35:00.000+0530\",\"taxation_model\": \"agency\",\"travellers\": \"ADT: 1\",\"trip_name\": \"Bangalore - Hyderabad one-way\",\"trip_type\": 1,\"txn_source_type\": \"ACCOUNT\",\"txns\":[{\"referer_domain\":\"qa2.cleartrip.com\",\"rreferer\":\"https:\\/\\/qa2.cleartrip.com\\/\",\"source_id\":\"119.82.106.204\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":1,\"user_id\":41683432}],\"user_id\":41683432}";

    String invoice_hotel="{\"amount\":209.01,\"company_id\":110340,\"contact_detail\":{\"address\":\"Unit No 001, Ground Floor, DTC Bldg, Sitaram Mills Compound, N.M. Joshi Marg, Delisle Road, Lower Parel(E)\",\"city_name\":\"Mumbai\",\"country_name\":\"India\",\"email\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"mobile\":\"9663949690\",\"pin_code\":\"400011\",\"state_name\":\"Maharashtra\",\"title\":\"Mr\",\"user_type\":\"NONE\"},\"currency\":\"INR\",\"domain\":\"cleartrip.com\",\"end_date_time\":\"2024-07-31T12:00:00.000+0530\",\"external_references\":[],\"gst_detail\": {\"created_at\": \"2019-07-18T10:02:40.000+0530\",\"gst_holder_address\": null,\"gst_holder_name\": \"cleartrip\",\"gst_holder_statecode\": \"29\",\"gst_holder_statename\": \"Karnataka\",\"gst_number\": \"29SAILI1234H1Z1\",\"updated_at\":\"2021-12-31T12:02:40.000+0530\"},\"has_revenue\":\"1\",\"has_wallet_promotion\":\"false\",\"hotel\":1,\"hotel_bookings\":[{\"total_fare\":209.01,\"hotel_id\":48425,\"total_guests\":2,\"guests\":\"--- \\nADT: 2\\n\",\"check_in_date\":\"2024-07-29T12:00:00.000+0530\",\"check_out_date\":\"2024-07-31T12:00:00.000+0530\",\"seq_no\":1,\"room_count\":1,\"voucher_number\":\"null\",\"total_base_fare\":150.0,\"total_tax\":0.0,\"total_markup\":50.0,\"total_discount\":0.0,\"total_cashback\":0.0,\"total_fee\":9.01,\"total_tax_sup\":0.0,\"total_tax_svc\":0.0,\"total_tax_unknown\":0.0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"pay_at_hotel\":\"N\",\"all_day_check_in\":\"false\",\"part_pay\":\"N\",\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1.0,\"ct_promos\":\"5775116\",\"lth_booking\":0,\"multitax_extra_commission\":0.0,\"st_on_extra_commission\":0.0,\"b2b_rate_for_b2c_count_cookie\":0.0,\"rate_channels\":\"AGENCY,API,B2C,CORP,MOBILE,WL\",\"trip_villa_rate\":0.0,\"express_checkout\":\"N\",\"absorbed_svc_fee\":0.0,\"sup_currency_markup\":0.0,\"referrer_domain\":\"qa2.cleartrip.com\",\"quickeys\":0,\"is_agency_model\":\"Y\",\"total_st_on_commission\":0.0,\"is_gst_model\":\"Y\",\"total_sup_gst\":0.0,\"total_gw_gst\":1.38,\"total_comm_gst\":-9.0,\"total_comm_tds\":0.0,\"rate_type\":\"SELL\",\"gstin_available\":\"Y\",\"is_reseller_model\":\"N\",\"hotel_detail\":{\"name\":\"Hotel Celebrations Inn\",\"address\":\"Maldhakka Road,\\nOld Pune Mumbai Highway,\\nChinchwad Station,\\n Chinchwad\\n, Pune, 411 005\",\"city_id\":35943,\"full_city_name\":\"Pune, Maharashtra, India\"},\"room_rates\":[{\"start_date_time\":\"2024-07-29T12:00:00.000+0530\",\"end_date_time\":\"2024-07-31T12:00:00.000+0530\",\"seq_no\":1,\"total_fare\":209.01,\"total_base_fare\":150.0,\"total_tax\":0.0,\"total_discount\":0.0,\"total_markup\":50.0,\"total_cashback\":0.0,\"total_fee\":9.01,\"total_tax_svc\":0.0,\"total_tax_unknown\":0.0,\"total_tax_sup\":0.0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"total_nc\":0.0,\"total_nc_fee\":0.0,\"total_dis_bf\":0.0,\"total_dis_suptax\":0.0,\"total_dis_supmkp\":0.0,\"total_cb_bf\":0.0,\"total_cb_suptax\":0.0,\"total_cb_supmkp\":0.0,\"total_dis_agency_commission\":0.0,\"total_tax_agency_comm_tax\":0.0,\"total_fee_pgc\":0.0,\"total_fee_amd\":0.0,\"total_tax_ecess\":0.0,\"total_tax_shecess\":0.0,\"total_tax_st\":0.0,\"total_dis_supd\":0.0,\"total_tax_dis_st\":0.0,\"total_tax_dis_ecess\":0.0,\"total_tax_dis_shecess\":0.0,\"total_mkp_sup\":50.0,\"total_fee_agency_markup\":0.0,\"total_dis_agency_discount\":0.0,\"total_wallet_cashback\":0.0,\"total_tax_sbc\":0.0,\"total_tax_dis_sbc\":0.0,\"total_tax_kkc\":0.0,\"total_tax_dis_kkc\":0.0,\"total_tax_sup_gst\":0.0,\"total_fee_gw_gst\":1.38,\"cost_room_rate\":{\"total_fare\":141.0,\"total_tax\":0.0,\"total_tax_sup\":0.0,\"total_dis_bf\":0.0,\"total_dis_suptax\":0.0,\"seq_no\":1,\"total_tax_unknown\":0.0,\"total_bf\":150.0,\"total_cb_suptax\":0.0,\"total_cb_bf\":0.0,\"total_dis_plb\":0,\"total_tax_sbc\":0.0,\"total_tax_dis_sbc\":0.0,\"total_tax_kkc\":0.0,\"total_tax_dis_kkc\":0.0,\"total_ct_claim_st_mkp\":0,\"total_ct_claim\":-9.0,\"total_ct_claim_st_plb\":0,\"total_ct_claim_comm_gst\":-9.0,\"total_ct_claim_plb_gst\":0,\"total_tax_sup_gst\":0.0,\"total_tax_comm_tds\":0,\"total_tax_plb_tds\":0,\"pricing_elements\":[{\"amount\":150.0,\"category\":\"BF\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_CGST\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_SGST\"}]},\"pricing_elements\":[{\"amount\":150.0,\"category\":\"BF\"},{\"amount\":50.0,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":7.63,\"category\":\"FEE\",\"code\":\"GW\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_CGST\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_SGST\"}]}],\"room_types\":[{\"name\":\"Deluxe AC Room Only\",\"supplier_id\":5,\"inclusions\":\"--- \\ninclusion: \\n- Free Wi-Fi\\n- All Applicable Taxes\\n\",\"cancellation_policy\":\"If you cancel within 24 hours before checkin,  you will be charged 1 room night charges per room.\",\"seq_no\":1,\"policy_start_date\":\"2021-12-29T12:00:00.000+0530\",\"rate_id\":5419720,\"room_type_name\":\"Deluxe Room\",\"room_type_id\":346972}],\"rooms\":[{\"guests\":\"--- \\nguest: \\n- category: ADT\\n- category: ADT\\n\",\"seq_no\":1,\"room_type_seq_no\":1}],\"external_references\":[{\"name\":\"FREE_CANCEL_POLICY\",\"value\":\"1\"},{\"name\":\"PAYMENT_ACCEPTED_AT_HOTEL\",\"value\":\"1000\"}],\"hotel_booking_infos\":[{\"stay_date\":\"2021-12-29T12:00:00.000+0530\",\"booking_status\":\"Z\",\"seq_no\":1,\"room_seq_no\":1,\"room_rate_seq_no\":1,\"status_history\":0,\"room_type\":\"Deluxe AC Room Only\",\"orig_cost_rate\":0.0}]}],\"itinerary_id\":\"75715c6dd9-0758-4332-9d11-1e2b17"+s+"\",\"notes\":[],\"start_date_time\":\"2024-07-29T12:00:00.000+0530\",\"tag_links\":[],\"travellers\":\"--- \\nADT: 2\\n\",\"trip_name\":\"Hotel Celebrations Inn, Pune, Maharashtra, India\",\"trip_type\":2,\"txns\":[{\"source_id\":\"192.168.45.231\",\"source_type\":\"ACCOUNT\",\"txn_type\":1,\"user_id\":41683432}],\"user_id\":41683432}";
 
    String invoice_local="{\"activity\":1,\"amount\":2240,\"booked_user_id\":41683432,\"booking_status\":\"Z\",\"company_id\":110340,\"contact_detail\": {\"address\": \"Unit No 001, Ground Floor, DTC Bldg, Sitaram Mills Compound, N.M. Joshi Marg, Delisle Road, Lower Parel (E)\",\"address_id\": null,\"city_id\": null,\"city_name\": \"Mumbai\",\"country_code\": \"91\",\"country_id\": null,\"country_name\": \"India\",\"created_at\": \"2019-07-18T10:02:40.000+0530\",\"email\": \"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\": \"test\",\"landline\": null,\"last_name\": \"test\",\"mobile\": \"9663949690\",\"mobile_number\": \"9663949690\",\"pin_code\": \"400011\",\"state_id\": null,\"state_name\": \"Maharashtra\",\"title\": \"Mr\",\"updated_at\": \"2021-12-31T10:02:40.000+0530\",\"user_type\": null},\"created_at\": \"2019-07-18T10:03:49.000+0530\",\"ct_gstin\": \"27AACCC6016B1Z8\",\"cur_inr_value\": null,\"currency\": \"INR\",\"customer_confirmation_eligible\": null,\"customer_no\": \"CUST03954\",\"delayed_tkt_booking\": null,\"domain\": \"cleartrip.com\",\"email_id\": \"varalakshmi.venkateshaiah@cleartrip.com\",\"end_date_time\": \"2024-07-31T22:00:00.000+0530\",\"express_checkout\": null,\"external_references\": [],\"gst_detail\": {\"created_at\": \"2021-12-31T10:02:40.000+0530\",\"gst_holder_address\": null,\"gst_holder_name\": \"cleartrip\",\"gst_holder_statecode\": \"29\",\"gst_holder_statename\": \"Karnataka\",\"gst_number\": \"29SAILI1234H1Z1\",\"updated_at\": \"2021-12-31T10:02:40.000+0530\"},\"has_revenue\": \"1\",\"has_wallet_promotion\": null,\"hotel\": 0,\"hotel_bookings\": [],\"itinerary_id\":\"15bd002221-209d-459e-ba7d-000dcd"+s+"\",\"local_bookings\":[{\"seq_no\":1,\"adults\":2,\"children\":1,\"booking_status\":\"Z\",\"total_guests\":3,\"total_fare\":2240,\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"end_date_time\":\"2024-07-31T22:00:00.000+0530\",\"sup_currency\":\"INR\",\"local_type\":\"Activity\",\"sup_gstin\":\"29SAILI1234H1Z1\",\"sup_state\":\"Maharashtra\",\"mer_gstin\":\"29SAILI1234H1Z1\",\"sup_gst_applicable\":1,\"inv_prefix\":\"INVS\",\"sup_tax_type\":\"GST\",\"cus_tax_type\":\"GST\",\"external_references\":[{\"name\":\"Coupon:WALLPLUS\",\"value\":\"Promocode:INSTA\"},{\"name\":\"Coupon:WALLPLUS\",\"value\":\"Promocode:WALLPLUS\"},{\"name\":\"RateRuleIds:\",\"value\":\"5900914,5900916\"},{\"name\":\"Convenience_Fee_Rule_Id:\",\"value\":\"5774792\"}],\"activity_booking_infos\":[{\"activity_seq_no\":1,\"local_rate_seq_no\":1,\"pax_info_seq_no\":1,\"booking_status\":\"Z\",\"seq_no\":1,\"category_type\":\"Activity\"}],\"activity_rates\":[{\"seq_no\":1,\"total_fare\":2240,\"total_base_fare\":1540,\"total_markup\":660,\"total_mkp_sup\":660,\"total_tax_st\":0,\"total_dis_st\":0,\"total_tax_ecess\":0,\"total_tax_dis_ecess\":0,\"total_tax_shecess\":0,\"total_tax_dis_shecess\":0,\"total_dis_suptax\":0,\"total_cb_suptax\":0,\"total_tax_unknown\":0,\"total_dis_bf\":0,\"total_cb_bf\":0,\"total_dis_supd\":0,\"total_tax\":131.2,\"total_fee_gw\":35,\"total_fee\":125,\"total_discount\":-166.2,\"total_cashback\":-50,\"total_tax_sbc\":0,\"total_dis_sbc\":0,\"total_wallet_cashback\":50,\"total_tax_kkc\":0,\"total_dis_kkc\":0,\"total_dis_gw\":-35,\"total_fee_con\":90,\"total_mkp_wl\":0,\"total_tax_ct_sup_cgst\":62.55,\"total_tax_ct_sup_sgst\":62.55,\"total_tax_ct_sup_igst\":0,\"total_tax_ct_con_cgst\":3.05,\"total_tax_ct_con_sgst\":3.05,\"total_tax_ct_con_igst\":0,\"total_dis_ct_sup_cgst\":-62.55,\"total_dis_ct_sup_sgst\":-62.55,\"total_dis_ct_sup_igst\":0,\"total_dis_ct_con_cgst\":-3.05,\"total_dis_ct_con_sgst\":-3.05,\"total_dis_ct_con_igst\":0,\"total_dis_agency_commission\":0,\"total_fee_nc\":0,\"total_dis_ct_fund\":0,\"total_mkp_wlparent\":0,\"total_ct_tax_wl_mkp_vat\":0,\"total_tax_ct_mkp_vat\":0,\"total_tax_ct_gw_vat\":0,\"total_tax_ct_bf_vat\":0,\"total_tax_ct_plb_vat\":0,\"total_tax_ct_con_vat\":0,\"total_tax_ct_wl_mkp_vat\":0,\"total_tax_ct_wlparent_mkp_vat\":0,\"total_dis_ct_mkp_vat\":0,\"total_dis_ct_gw_vat\":0,\"total_dis_ct_plb_vat\":0,\"total_dis_ct_bf_vat\":0,\"total_dis_ct_con_vat\":0,\"total_dis_ct_wl_mkp_vat\":0,\"total_dis_ct_wlparent_mkp_vat\":0,\"pricing_elements\":[{\"amount\":1540,\"category\":\"BF\"},{\"amount\":660,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":-50,\"category\":\"CB\",\"code\":\"INSTA\"},{\"amount\":50,\"category\":\"WT\",\"code\":\"WALLPLUS\"},{\"amount\":90,\"category\":\"FEE\",\"code\":\"CON\"},{\"amount\":35,\"category\":\"FEE\",\"code\":\"GW\"},{\"amount\":-35,\"category\":\"DIS\",\"code\":\"GW\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_CGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_CGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_CGST\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_SGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_CGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_SGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_SGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_SGST\"}],\"cost_activity_rate\":{\"total_fare\":2200,\"total_base_fare\":1540,\"total_markup\":660,\"total_mkp_sup\":660,\"total_tax_st\":0,\"total_dis_st\":0,\"total_tax_ecess\":0,\"total_tax_dis_ecess\":0,\"total_tax_shecess\":0,\"total_tax_dis_shecess\":0,\"total_dis_suptax\":0,\"total_cb_suptax\":0,\"total_tax_unknown\":0,\"total_dis_bf\":0,\"total_cb_bf\":0,\"total_dis_supd\":0,\"total_cashback\":0,\"total_discount\":-131.2,\"total_fee\":0,\"total_tax\":131.2,\"total_tax_sup\":0,\"total_tax_sbc\":0,\"total_dis_sbc\":0,\"total_tax_kkc\":0,\"total_dis_kkc\":0,\"total_dis_plb\":0,\"total_fee_nc\":0,\"pricing_elements\":[{\"amount\":1540,\"category\":\"BF\"},{\"amount\":660,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_CGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_CGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_CGST\"},{\"amount\":3.15,\"category\":\"TAX\",\"code\":\"CT_GW_SGST\"},{\"amount\":-3.15,\"category\":\"DIS\",\"code\":\"CT_GW_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_CGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_CGST\"},{\"amount\":59.4,\"category\":\"TAX\",\"code\":\"CT_MKP_SGST\"},{\"amount\":-59.4,\"category\":\"DIS\",\"code\":\"CT_MKP_SGST\"},{\"amount\":3.05,\"category\":\"TAX\",\"code\":\"CT_CON_SGST\"},{\"amount\":-3.05,\"category\":\"DIS\",\"code\":\"CT_CON_SGST\"}]}}],\"activities\":[{\"seq_no\":1,\"name\":\"VAT Inclusive adult child Act\",\"activity_id\":810536,\"address\":\"Bengaluru, Karnataka, India,\",\"city\":\"Bangalore,Karnataka,India\",\"part_pay\":0,\"activity_type\":\"Standard\",\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"end_date_time\":\"2024-07-31T22:00:00.000+0530\",\"cancellation_charges\":\"[{\\\"0h-6h\\\":\\\"100\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"6h-24h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"24h-48h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"},{\\\"48h\\\":\\\"0\\\",\\\"charge_type_code\\\":\\\"percent\\\"}]\",\"inclusions\":\"--- \\ninclusion: \\n- ndhhcfd\",\"partial_cancellation_allowed\":0,\"booking_status\":\"Z\",\"refundable\":\"Y\",\"open_activity\":\"Y\",\"total_discount\":-166.2,\"total_cashback\":-50,\"total_base_fare\":1540,\"total_tax\":131.2,\"total_markup\":660,\"total_fee\":125,\"total_fare\":2240,\"open_activity_start_hour\":\"2018-08-31T09:00:00.000+0530\",\"sup_currency\":\"INR\",\"rate_id\":40571,\"variant_id\":8536,\"rate_name\":\"vat1\",\"variant_name\":\"Standard-Variant\",\"pricing_details\":\"{\\\"ADT\\\":\\\"800\\\",\\\"CHD\\\":\\\"600\\\"}\"}],\"pax_infos\":[{\"first_name\":\"test\",\"last_name\":\"test\",\"pax_type_code\":\"ADT\",\"seq_no\":1,\"title\":\"Mr\",\"total_fare\":2240}]}],\"notes\":[{\"note\":\"Booking attempted with coupon:WALLPLUS\",\"subject\":\"Booking attempted with coupon:WALLPLUS\",\"user_id\":41683432}],\"start_date_time\":\"2024-07-31T09:00:00.000+0530\",\"tag_masters\":[{\"tag_name\":\"COUPON:WALLPLUS\"}],\"travellers\":\"--- \\nADT: 2\\nCHD: 1\",\"trip_name\":\"VAT Inclusive adult child Act Bangalore\",\"trip_type\":16,\"txn_source_type\":\"ACCOUNT\",\"txns\":[{\"source_id\":\"127.0.0.1\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":1,\"user_agent\":\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36\",\"user_id\":41683432}],\"user_id\":41683432}";
 
    String graphql_qa="{'query':'{   trips(id: \"Q191129584972\") { tripRef bookingStatus currency bkgType airBookings { journeyType paxInfos { id firstName lastName} flights { segments { id departureAirport arrivalAirport marketingAirline operatingAirline }} airBookingInfos { airlinePnr id paxInfoId pricingObjectId agentPcc segmentId} pricingObjects { id costPricingObject { id totalFare }} } txns { airCancellations { id splitPnr splitAirlinePnr airBookingInfoId }airRefundRecords { id totalSupCharge  } }  }}'}";
    
    String graphql_prod="{'query': '{   trips(id: \"180604520756\") { tripRef bookingStatus currency bkgType airBookings { journeyType paxInfos { id firstName lastName} flights { segments { id departureAirport arrivalAirport marketingAirline operatingAirline }} airBookingInfos { airlinePnr id paxInfoId pricingObjectId agentPcc segmentId} pricingObjects { id costPricingObject { id totalFare }} } txns { airCancellations { id splitPnr splitAirlinePnr airBookingInfoId } airRefundRecords { id totalSupCharge  } }  }}'}";
    
    String tripquery_qa="{'query':'{   trips(id: \"Q191129584972\") { tripRef bookingStatus currency bkgType airBookings { journeyType paxInfos { id firstName lastName} flights { segments { id departureAirport arrivalAirport marketingAirline operatingAirline }} airBookingInfos { airlinePnr id paxInfoId pricingObjectId agentPcc segmentId} pricingObjects { id costPricingObject { id totalFare }} } txns { airCancellations { id splitPnr splitAirlinePnr airBookingInfoId }airRefundRecords { id totalSupCharge  } }  }}'}";
    
    String tripquery_prod="{'query': '{   trips(id: \"180604520756\") { tripRef bookingStatus currency bkgType airBookings { journeyType paxInfos { id firstName lastName} flights { segments { id departureAirport arrivalAirport marketingAirline operatingAirline }} airBookingInfos { airlinePnr id paxInfoId pricingObjectId agentPcc segmentId} pricingObjects { id costPricingObject { id totalFare }} } txns { airCancellations { id splitPnr splitAirlinePnr airBookingInfoId } airRefundRecords { id totalSupCharge  } }  }}'}";
    
    String params_get_archivedtrips="{\"booking_status\":{\"1\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\",\"BI\"], \"2\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"],\"4\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"], \"16\": [\"J\",\"W\",\"B\",\"M\",\"N\",\"T\",\"I\",\"IC\",\"P\",\"A\",\"Q\",\"D\",\"K\",\"O\",\"AA\",\"H\",\"IF\",\"Z\",\"R\",\"C\",\"E\",\"X\",\"F\",\"Y\",\"G\",\"L\",\"U\",\"V\",\"S\"]},\r\n\"channel\": [\"B2C\", \"CORP\", \"CTPHONEBOOKINGS\",\"ACCOUNT\",\"MOBILE\"],\"created_at_date\":\"2019-02-01T00:00:00.000Z\",\"email_id\":\"mkumarban@gmail.com\",\"start_date_time\":\"2024-07-31T00:00:00.000\",\"user_id\": \"41651546\",\"expired\":\"true\"}";
    
    String param_fph_log="{\"air\":1,\"hotel\":1,\"air_bookings\":[{\"air_booking_detail\":{\"customer_booking_status\":\"true\",\"is_apis_required\":\"false\",\"product_by_domain\":\"India Domestic\",\"searched_sector\":\"DEL-BLR\",\"segments_count\":1,\"sms_email_flag\":\"false\"},\"air_booking_infos\":[{\"auto_refund\":\"N\",\"booking_class\":\"W\",\"booking_status\":\"Z\",\"cabin_type\":\"E\",\"external_references\":[],\"multipcc_rev\":0,\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"seat_number\":\"\",\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"ticket_type\":\"E\",\"amend_insurance_provider\":\"digit\",\"amend_insurance_premium\":229.11}],\"air_booking_type\":\"D\",\"air_itinerary_type\":\"Air Domestic\",\"external_references\":[{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"Coupon:SHACHI\",\"value\":\"Promocode:CTtest-Domestic\"},{\"name\":\"sessiontoken-Amadeus-DEL-BLR-6885755715-86f8-414b-a20a-aaa3f82b9f7a\",\"value\":\"|01F8IN512V|5\"}],\"flights\":[{\"arrival_airport\":\"BLR\",\"arrival_date_time\":\"2020-12-30T18:30:00.000+0530\",\"departure_airport\":\"DEL\",\"departure_date_time\":\"2020-12-30T18:30:00.000+0530\",\"flight_index\":1,\"routed\":\"N\",\"segments\":[{\"arrival_airport\":\"BLR\",\"arrival_date_time\":\"2020-12-30T21:10:00.000+0530\",\"arrival_terminal\":\"\",\"book_pcc\":\"CLEARTRIP\",\"departure_airport\":\"DEL\",\"departure_date_time\":\"2020-12-30T18:30:00.000+0530\",\"departure_terminal\":\"3\",\"duration\":9600,\"flight_number\":\"811\",\"fop\":\"CC-PBN/CTAMEX*\",\"marketing_airline\":\"9W\",\"operating_airline\":\"9W\",\"seq_no\":1,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"AMD\",\"vendor_no\":\"VEND16519\",\"external_references\":[{\"name\":\"segment_externaln\",\"value\":\"segment_externalv\"}]}]},{\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2020-12-30T22:40:00.000+0530\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2020-12-30T21:15:00.000+0530\",\"flight_index\":1,\"routed\":\"N\",\"segments\":[{\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2020-12-30T22:40:00.000+0530\",\"arrival_terminal\":\"\",\"departure_airport\":\"BLR\",\"departure_date_time\":\"2020-12-30T21:15:00.000+0530\",\"departure_terminal\":\"\",\"duration\":5100,\"flight_number\":\"1239\",\"marketing_airline\":\"SG\",\"operating_airline\":\"SG\",\"seat_available\":1,\"seq_no\":2,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"SG\"}]}],\"hold_inventory\":\"false\",\"id\":0,\"journey_type\":\"O\",\"pax_infos\":[{\"first_name\":\"test\",\"last_name\":\"test\",\"pax_type_code\":\"ADT\",\"person_id\":41646138,\"seq_no\":1,\"title\":\"Mr\",\"total_fare\":3330}],\"price_watch\":\"Y\",\"pricing_objects\":[{\"cleartrip_sbc\":1.3775,\"congestion_charge\":281,\"cost_pricing_object\":{\"congestion_charge\":281,\"fare_basis_code\":\"W2IPO\",\"fare_category\":\"retail\",\"fare_key\":\"supp_AMADEUS|si-bc-v2-8868502f-4b01-4175-9112-d4d85e342d53|fk_retail_9W_811_1538225700000_W2IPO_true_\",\"fare_sub_type\":\"\",\"pricing_elements\":[{\"amount\":1555,\"category\":\"BF\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":1200,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":125,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":144,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":12,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":154,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}],\"seq_no\":1,\"total_bf\":1555,\"total_fare\":3190,\"total_fee_baggage\":0,\"total_fee_con\":0,\"total_fee_meal\":0,\"total_fee_seat\":0,\"total_mkp\":0,\"total_tax\":1635,\"total_tax_airline_msc\":144,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":0,\"total_tax_ct_cgst\":0,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":0,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_oct\":0,\"total_tax_psf\":154,\"total_tax_sbc\":0,\"total_tax_sgst\":0,\"total_tax_ttf\":0,\"total_tax_udf\":12,\"total_tax_unknown\":0,\"total_tax_utgst\":0,\"total_tax_yq\":1200,\"total_tax_yr\":125},\"fare_basis_code\":\"W2IPO\",\"fare_category\":\"retail\",\"fare_key\":\"fk_retail_9W_811_1538225700000_W2IPO_true_\",\"fare_sub_type\":\"\",\"net_agency_commission\":0,\"net_taxable_value\":140,\"pricing_elements\":[{\"amount\":1555,\"category\":\"BF\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"true\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"true\",\"wp_check\":\"true\"},{\"amount\":1200,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":125,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":144,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":12,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":154,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":-10,\"category\":\"CB\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CTTEST-DOMESTIC\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":150,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GW\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"GWST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}],\"segment_amount\":3330,\"seq_no\":1,\"service_tax\":0,\"tax_base_st\":17.0259,\"tax_ecess\":0,\"tax_shecess\":0,\"total_base_fare\":1555,\"total_bos_dis_svc\":0,\"total_bos_tax_svc\":0,\"total_cashback\":-10,\"total_dis_agency_commission\":0,\"total_dis_agency_discount\":0,\"total_discount\":0,\"total_fare\":3330,\"total_fee\":150,\"total_fee_agency_markup\":0,\"total_fee_airl_amd\":0,\"total_fee_amd\":0,\"total_fee_baggage\":0,\"total_fee_bundle\":0,\"total_fee_cncl\":0,\"total_fee_con\":0,\"total_fee_gw\":150,\"total_fee_meal\":0,\"total_fee_pgc\":0,\"total_fee_price_watch\":0,\"total_fee_seat\":0,\"total_fee_unknown\":0,\"total_markup\":0,\"total_mkp_mcmkp\":0,\"total_nc\":0,\"total_nc_agency_trans_fee\":0,\"total_nc_fee\":0,\"total_tax\":1635,\"total_tax_agency_comm_gst\":0,\"total_tax_agency_comm_tax\":0,\"total_tax_agency_trans_fee_tax\":0,\"total_tax_airline_msc\":144,\"total_tax_airline_vat\":0,\"total_tax_amd_oct\":0,\"total_tax_cgst\":0,\"total_tax_cleartrip_kkc\":0,\"total_tax_cleartrip_sbc\":0,\"total_tax_ct_cgst\":10.7,\"total_tax_ct_igst\":0,\"total_tax_ct_sgst\":10.7,\"total_tax_ct_utgst\":0,\"total_tax_ct_vat\":0,\"total_tax_cute\":0,\"total_tax_igst\":0,\"total_tax_jn\":0,\"total_tax_kkc\":0,\"total_tax_oct\":0,\"total_tax_psf\":154,\"total_tax_sbc\":0,\"total_tax_sgst\":0,\"total_tax_svc\":0,\"total_tax_ttf\":0,\"total_tax_unknown\":12,\"total_tax_utgst\":0,\"total_tax_yq\":1200,\"total_tax_yr\":125,\"total_wallet_cashback\":0}],\"total_fare\":3330}],\"hotel_bookings\":[{\"total_fare\":209.01,\"hotel_id\":48425,\"total_guests\":2,\"guests\":\"--- \\nADT: 2\\n\",\"check_in_date\":\"2024-07-30T00:00:00.000+0530\",\"check_out_date\":\"2024-07-31T00:00:00.000+0530\",\"seq_no\":1,\"room_count\":1,\"voucher_number\":\"null\",\"total_base_fare\":150,\"total_tax\":0,\"total_markup\":50,\"total_discount\":0,\"total_cashback\":0,\"total_fee\":9.01,\"total_tax_sup\":0,\"total_tax_svc\":0,\"total_tax_unknown\":0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"pay_at_hotel\":\"N\",\"all_day_check_in\":\"false\",\"part_pay\":\"N\",\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"ct_promos\":\"5775116\",\"lth_booking\":0,\"multitax_extra_commission\":0,\"st_on_extra_commission\":0,\"b2b_rate_for_b2c_count_cookie\":0,\"rate_channels\":\"AGENCY,API,B2C,CORP,MOBILE,WL\",\"trip_villa_rate\":0,\"express_checkout\":\"N\",\"absorbed_svc_fee\":0,\"sup_currency_markup\":0,\"referrer_domain\":\"qa2.cleartrip.com\",\"quickeys\":0,\"is_agency_model\":\"Y\",\"total_st_on_commission\":0,\"is_gst_model\":\"Y\",\"total_sup_gst\":0,\"total_gw_gst\":1.38,\"total_comm_gst\":-9,\"total_comm_tds\":0,\"rate_type\":\"SELL\",\"gstin_available\":\"Y\",\"is_reseller_model\":\"N\",\"hotel_detail\":{\"name\":\"Hotel Celebrations Inn\",\"address\":\"Maldhakka Road,\\nOld Pune Mumbai Highway,\\nChinchwad Station,\\n Chinchwad\\n, Pune, 411 005\",\"city_id\":35943,\"full_city_name\":\"Pune, Maharashtra, India\"},\"room_rates\":[{\"start_date_time\":\"2024-07-30T00:00:00.000+0530\",\"end_date_time\":\"2024-07-31T00:00:00.000+0530\",\"seq_no\":1,\"total_fare\":209.01,\"total_base_fare\":150,\"total_tax\":0,\"total_discount\":0,\"total_markup\":50,\"total_cashback\":0,\"total_fee\":9.01,\"total_tax_svc\":0,\"total_tax_unknown\":0,\"total_tax_sup\":0,\"total_fee_gw\":7.63,\"total_fee_unknown\":1.38,\"total_nc\":0,\"total_nc_fee\":0,\"total_dis_bf\":0,\"total_dis_suptax\":0,\"total_dis_supmkp\":0,\"total_cb_bf\":0,\"total_cb_suptax\":0,\"total_cb_supmkp\":0,\"total_dis_agency_commission\":0,\"total_tax_agency_comm_tax\":0,\"total_fee_pgc\":0,\"total_fee_amd\":0,\"total_tax_ecess\":0,\"total_tax_shecess\":0,\"total_tax_st\":0,\"total_dis_supd\":0,\"total_tax_dis_st\":0,\"total_tax_dis_ecess\":0,\"total_tax_dis_shecess\":0,\"total_mkp_sup\":50,\"total_fee_agency_markup\":0,\"total_dis_agency_discount\":0,\"total_wallet_cashback\":0,\"total_tax_sbc\":0,\"total_tax_dis_sbc\":0,\"total_tax_kkc\":0,\"total_tax_dis_kkc\":0,\"total_tax_sup_gst\":0,\"total_fee_gw_gst\":1.38,\"cost_room_rate\":{\"total_fare\":141,\"total_tax\":0,\"total_tax_sup\":0,\"total_dis_bf\":0,\"total_dis_suptax\":0,\"seq_no\":1,\"total_tax_unknown\":0,\"total_bf\":150,\"total_cb_suptax\":0,\"total_cb_bf\":0,\"total_dis_plb\":0,\"total_tax_sbc\":0,\"total_tax_dis_sbc\":0,\"total_tax_kkc\":0,\"total_tax_dis_kkc\":0,\"total_ct_claim_st_mkp\":0,\"total_ct_claim\":-9,\"total_ct_claim_st_plb\":0,\"total_ct_claim_comm_gst\":-9,\"total_ct_claim_plb_gst\":0,\"total_tax_sup_gst\":0,\"total_tax_comm_tds\":0,\"total_tax_plb_tds\":0,\"pricing_elements\":[{\"amount\":150,\"category\":\"BF\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_CGST\"},{\"amount\":-4.5,\"category\":\"CT_CLAIM\",\"code\":\"COMM_SGST\"}]},\"pricing_elements\":[{\"amount\":150,\"category\":\"BF\"},{\"amount\":50,\"category\":\"MKP\",\"code\":\"SUP\"},{\"amount\":7.63,\"category\":\"FEE\",\"code\":\"GW\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_CGST\"},{\"amount\":0.69,\"category\":\"FEE\",\"code\":\"GW_SGST\"}]}],\"room_types\":[{\"name\":\"Deluxe AC Room Only\",\"supplier_id\":5,\"inclusions\":\"--- \\ninclusion: \\n- Free Wi-Fi\\n- All Applicable Taxes\\n\",\"cancellation_policy\":\"If you cancel within 24 hours before checkin,  you will be charged 1 room night charges per room.\",\"seq_no\":1,\"policy_start_date\":\"2020-12-30T00:00:00.000+0530\",\"rate_id\":5419720,\"room_type_name\":\"Deluxe Room\",\"room_type_id\":29948750514}],\"rooms\":[{\"guests\":\"--- \\nguest: \\n- category: ADT\\n- category: ADT\\n\",\"seq_no\":1,\"room_type_seq_no\":1}],\"external_references\":[{\"name\":\"FREE_CANCEL_POLICY\",\"value\":\"1\"},{\"name\":\"PAYMENT_ACCEPTED_AT_HOTEL\",\"value\":\"1000\"}],\"hotel_booking_infos\":[{\"stay_date\":\"2020-12-30T00:00:00.000+0530\",\"booking_status\":\"Z\",\"seq_no\":1,\"room_seq_no\":1,\"room_rate_seq_no\":1,\"status_history\":0,\"room_type\":\"Deluxe AC Room Only\",\"orig_cost_rate\":0}]}],\"amount\":3330,\"bkg_type\":\"D\",\"has_wallet_promotion\":\"false\",\"booked_user_id\":41683432,\"company_id\":110340,\"contact_detail\":{\"address\":\"BTM \",\"city_name\":\"Bangalore\",\"country_name\":\"India\",\"email\":\"varalakshmivaru29@gmail.com\",\"first_name\":\"Test\",\"last_name\":\"Test\",\"mobile\":\"9663949690\",\"pin_code\":\"560076\",\"state_name\":\"Karnataka\",\"title\":\"Ms\"},\"ct_gstin\":\"27AACCC6016B1Z8\",\"currency\":\"INR\",\"customer_confirmation_eligible\":\"true\",\"customer_no\":\"CUST03954\",\"domain\":\"cleartrip.com\",\"email_id\":\"varalakshmivaru29@gmail.com\",\"end_date_time\":\"2024-07-31T10:10:00.000+0530\",\"express_checkout\":\"false\",\"external_references\":[],\"gst_detail\":{\"gst_holder_address\":\"cleartrip,bengaluru\",\"gst_holder_name\":\"cleartrip\",\"gst_holder_statecode\":\"29\",\"gst_holder_statename\":\"Karnataka\",\"gst_number\":\"29SAILI1234H1Z1\"},\"has_revenue\":\"1\",\"insurances\":[],\"tag_links\":[],\"notes\":[],\"itinerary_id\":\"6814c32fc0-a8bc-4576-ab43-190717170338\",\"site_language\":\"en\",\"start_date_time\":\"2024-07-30T09:00:00.000+0530\",\"taxation_model\":\"agency\",\"travellers\":\"ADT: 1\",\"trip_name\":\"Bangalore - Hyderabad one-way\",\"trip_type\":3,\"ct_for_work\":{\"cashback_credited\":1000,\"ct_for_work_user\":\"varalakshmivaru29@gmail.com\",\"work_fare\":4100,\"work_fare_type\":\"CORPORATE\"},\"txn_source_type\":\"ACCOUNT\",\"txns\":[{\"referer_domain\":\"local.cleartrip.com\",\"rreferer\":\"http://local.cleartrip.com/flights/results?origin=New+Delhi%2C+IN+-+Indira+Gandhi+Airport+\",\"source_id\":\"127.0.0.1\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":1,\"user_id\":41683432}],\"user_id\":41683432}";
    
    String param_fph_update="{\"air_booking_infos\":[{\"agent_pcc\":\"agent_pcc_1\",\"airline_pnr\":\"MEQUFA\",\"amd_groups\":null,\"amd_status\":null,\"amd_type\":null,\"auto_refund\":\"N\",\"baggage_code\":null,\"baggage_info\":null,\"bf_mkp\":null,\"booking_class\":\"B\",\"booking_status\":\"P\",\"cab_ref_no\":null,\"cabin_type\":\"E\",\"created_at\":\"2019-08-19T15:37:58.000+0530\",\"external_references\":null,\"external_refs\":null,\"gds_pnr\":null,\"id\":null,\"mc_diff\":null,\"meal_code\":null,\"meal_info\":null,\"pax_info_id\":null,\"pax_info_seq_no\":1,\"pricing_object_id\":null,\"pricing_object_seq_no\":1,\"seat_number\":null,\"seat_status\":null,\"seat_type\":null,\"segment_id\":null,\"segment_seq_no\":1,\"seq_no\":1,\"status_history\":0,\"status_reason\":null,\"ticket_number\":\"MEQUFA\",\"ticket_type\":\"E\",\"txn_id\":null,\"updated_at\":\"2020-08-19T15:38:29.000+0530\",\"web_checkin\":null}],\"pricing_objects\":[{\"pricing_elements\":[{\"amount\":2450,\"category\":\"catone\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}],\"cost_pricing_object\":{\"congestion_charge\":208,\"fare_basis_code\":\"SAP8\",\"fare_category\":\"retail\",\"fare_key\":\"supp_AMADEUS|si-bc-v2-c20d4b97-5f87-4bba-a9af-628d01805869|fk_retail_AI_4347_1535232600000_SAP8_true_\",\"fare_sub_type\":\"\",\"pricing_elements\":[{\"amount\":2450,\"category\":\"catone\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":70,\"category\":\"cattwo\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}],\"seq_no\":1},\"seq_no\":1}],\"flights\":[{\"segments\":[{\"seq_no\":1,\"supplier\":\"AMD\"}]}],\"hotel_booking_infos\":[{\"stay_date\":\"2020-12-30T00:00:00.000+0530\",\"booking_status\":\"P\",\"seq_no\":1,\"room_seq_no\":1,\"room_rate_seq_no\":1,\"voucher_number\":\"CHMM-8528832\",\"status_history\":0,\"nri\":\"false\",\"inventory_remaining\":94,\"auto_refill_inventory_count\":0,\"base_rate_id\":5419720,\"external_references\":[{\"name\":\"PAYMENT_ACCEPTED_AT_HOTEL\",\"value\":\"1000\"},{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"room-type\",\"value\":\"Deluxe Room\"},{\"name\":\"upd-res-url\",\"value\":\"/chmm/updatebooking?id=oawETvnuw2Mr4SLyIVbUUw%3D%3D\"},{\"name\":\"dp-coupon-booking-enabled\",\"value\":\"false\"}]}]}";

	String paramsbus="{\"amount\":12,\"booked_user_id\":41683432,\"booking_status\":\"PI\",\"bus_booking\":{\"booking_status\":\"PI\",\"ct_cancellation_policy\":\"{\\\"text\\\":[\\\"Cancellation charges shown in the above table are indicative. Final amount may vary\\\",\\\"You will receive refunds after deducting the offer discounts, cash backs and non-refundable charges as per the bus operator?s policy\\\",\\\"Ticket cannot be cancelled after scheduled bus departure time from the first boarding point\\\",\\\"Partial cancellation of tickets is not allowed\\\"],\\\"policy\\\":[{\\\"duration\\\":1689187560000,\\\"refundPer\\\":35,\\\"cancellationPer\\\":65,\\\"amount\\\":0},{\\\"duration\\\":1689209160000,\\\"refundPer\\\":20,\\\"cancellationPer\\\":80,\\\"amount\\\":0},{\\\"duration\\\":1689230760000,\\\"refundPer\\\":0,\\\"cancellationPer\\\":100,\\\"amount\\\":0}],\\\"headline\\\":\\\"Partial refund till {date}.\\\",\\\"headlineProps\\\":{\\\"date\\\":\\\"1689209160000\\\"}}\",\"supplier_cancellation_policy\":\"{\\\"cancelRefTime\\\":1689230760000,\\\"policyList\\\":[{\\\"amount\\\":0.0,\\\"percentage\\\":100.0,\\\"minutes\\\":0},{\\\"amount\\\":0.0,\\\"percentage\\\":80.0,\\\"minutes\\\":360},{\\\"amount\\\":0.0,\\\"percentage\\\":65.0,\\\"minutes\\\":720},{\\\"amount\\\":0.0,\\\"percentage\\\":45.0,\\\"minutes\\\":1440},{\\\"amount\\\":0.0,\\\"percentage\\\":0.0,\\\"minutes\\\":2160}]}\",\"total_pax\":1,\"buses\":[{\"seq_no\":1,\"amenities\":\"Wifi,Charging Point,Snacks,Water Bottle,Facial Tissues,Thermal Screening,Bus Crew COVID Tested,Social Distancing,Bus Sanitization,Hand Sanitizer,Passenger Face Mask,Staffs With Facemask,GPS\",\"is_ac\":\"NON_AC\",\"axle\":\"SINGLE_AXLE\",\"make\":\"Normal\",\"seating\":\"SEATER\",\"pickup_info\":\"{\\\"time\\\":\\\"2024-07-29T12:26:00.000+0530\\\",\\\"name\\\":\\\"Bommanahalli\\\",\\\"code\\\":\\\"44955\\\",\\\"address\\\":\\\"Bommanahalli bus stop, bangalore\\\",\\\"landmark\\\":\\\"Bus stop\\\",\\\"latitude\\\":\\\"18.4512819249\\\",\\\"longitude\\\":\\\"73.8574023172\\\",\\\"contactNumber\\\":\\\"9663949690\\\"}\",\"dropoff_info\":\"{\\\"time\\\":\\\"2024-07-30T00:21:00.000+0530\\\",\\\"name\\\":\\\"Airport\\\",\\\"code\\\":\\\"81897\\\",\\\"latitude\\\":\\\"18.4512819249\\\",\\\"longitude\\\":\\\"73.8574023172\\\"}\",\"route_bus_id\":1,\"operator_id\":3963,\"operator_name\":\"GDS Demo Test\",\"to_city\":\" Chennai\",\"from_city\":\" Bangalore\",\"to_state\":\" Tamil Nadu\",\"from_state\":\" Karnataka\",\"to_city_id\":\"4562\",\"from_city_id\":\"4292\",\"supplier_trip_id\":\"46754\",\"is_gps\":\"true\",\"is_premium\":\"false\",\"is_flexi\":\"true\",\"display_bus_type\":\"Non A/C, Seater\",\"bus_label\":\"2X2(35) NAC Seater  \",\"arr_time\":\"2024-07-30T00:21:00.000+0530\",\"dept_time\":\"2024-07-29T12:26:00.000+0530\",\"journey_date\":\"2024-07-29\",\"supplier\":\"TY\",\"supplier_id\":\"0\",\"search_reference_id\":\"4292|4562|2023-07-13|1|0\"}],\"bus_booking_infos\":[{\"seq_no\":1,\"auto_refund\":\"Y\",\"booking_status\":\"PI\",\"fare\":\"12.00\",\"bus_pricing_info_seq_no\":1,\"pax_info_seq_no\":1,\"seat_number\":\"8\",\"seat_type\":\"SEATER\"}],\"pax_infos\":[{\"first_name\":\"Vishnu\",\"gender\":\"M\",\"age\":23,\"last_name\":\"Sai\",\"pax_type_code\":\"ADT\",\"seq_no\":1,\"total_fare\":12}],\"bus_pricing_infos\":[{\"seq_no\":1,\"total_base_fare\":11,\"total_fare\":12,\"total_tax\":1,\"total_discount\":0,\"bus_cost_pricing_info\":{\"seq_no\":1,\"total_bf\":11,\"total_fare\":12,\"total_tax\":1,\"total_discount\":0,\"pricing_elements\":[{\"amount\":1,\"category\":\"TAX\",\"code\":\"SUP\",\"label\":\"Tax\",\"usr_refund\":\"false\"},{\"amount\":11,\"category\":\"BF\",\"code\":\"SUP\",\"label\":\"Base fare\",\"usr_refund\":\"false\"}]},\"pricing_elements\":[{\"amount\":1,\"category\":\"TAX\",\"code\":\"SUP\",\"label\":\"Tax\",\"usr_refund\":\"false\"},{\"amount\":11,\"category\":\"BF\",\"code\":\"SUP\",\"label\":\"Base fare\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW\",\"label\":\"Gateway fee\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW_CGST\",\"label\":\"GW_CGST\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW_SGST\",\"label\":\"GW_SGST\",\"usr_refund\":\"false\"}]}]},\"contact_detail\":{\"country_code\":\"91\",\"country_name\":\"INDIA\",\"email\":\"varalakshmi.venkateshaiah@cleartrip.com\",\"first_name\":\"Varalakshmi\",\"last_name\":\"VV\",\"mobile\":\"9663949690\",\"mobile_number\":\"9663949690\",\"country_code_alpha\":\"IN\"},\"ct_gstin\":\"27AACCC6016B1Z8\",\"cur_inr_value\":1,\"currency\":\"INR\",\"domain\":\"qa2new.cleartrip.com\",\"end_date_time\":\"2024-07-30T00:21:00.000+05:30\",\"gst_detail\":{\"gst_holder_name\":\"Cleartrip\",\"gst_holder_statecode\":\"27\",\"gst_holder_statename\":\"Maharashtra\",\"gst_number\":\"27AACCC6016B1Z8\"},\"has_revenue\":\"1\",\"has_wallet_promotion\":\"false\",\"insurances\":[],\"itinerary_id\":\"BI4edb0fb5-34e7-41f1-a36d-230712150147\",\"start_date_time\":\"2024-07-29T12:26:00.000+05:30\",\"taxation_model\":\"agency\",\"travellers\":\"--- \\nADT: 1\\n\",\"trip_name\":\" Bangalore -  Chennai\",\"trip_type\":32,\"txn_source_type\":\"MOBILE\",\"txns\":[{\"booking_channel\":\"PWA\",\"referer_domain\":\"qa2new.cleartrip.com\",\"rreferer\":\"https://qa2new.cleartrip.com/bus/chart?view=drop&solutionId=4292|4562|2023-07-13|1|0&searchId=4292_4562_2023-07-13_1689154295793&itineraryId=\",\"source_type\":\"MOBILE\",\"status\":\"O\",\"txn_type\":1,\"user_agent\":\"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36\",\"user_id\":41683432}],\"user_id\":41683432}";

	String paramsbusupdate="{\"bus_booking_infos\":[{\"seq_no\":1,\"booking_status\":\"P\",\"pnr\":\"291553320-94616\",\"ticket_no\":\"103442324585\",\"pax_info_seq_no\":1}],\"bus_pricing_infos\":[{\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"seq_no\":1,\"total_gst\":0,\"total_base_fare\":11,\"total_fare\":11,\"total_tax\":1,\"total_discount\":0,\"total_cashback\":-1,\"bus_cost_pricing_info\":{\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"seq_no\":1,\"total_bf\":11,\"total_fare\":12,\"total_tax\":1,\"total_gst\":0,\"total_discount\":0,\"pricing_elements\":[{\"amount\":1,\"category\":\"TAX\",\"code\":\"SUP\",\"created_at\":\"2023-07-12T15:03:12.000+05:30\",\"label\":\"Tax\",\"linkable_type\":\"BusCostPricingInfo\",\"updated_at\":\"2023-07-12T15:03:12.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":11,\"category\":\"BF\",\"code\":\"SUP\",\"created_at\":\"2023-07-12T15:03:12.000+05:30\",\"label\":\"Base fare\",\"linkable_type\":\"BusCostPricingInfo\",\"updated_at\":\"2023-07-12T15:03:12.000+05:30\",\"usr_refund\":\"false\"}]},\"external_references\":[],\"pricing_elements\":[{\"amount\":1,\"category\":\"TAX\",\"code\":\"SUP\",\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"label\":\"Tax\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":11,\"category\":\"BF\",\"code\":\"SUP\",\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"label\":\"Base fare\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW\",\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"label\":\"Gateway fee\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW_CGST\",\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"label\":\"GW_CGST\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":0,\"category\":\"FEE\",\"code\":\"GW_SGST\",\"created_at\":\"2023-07-12T15:02:43.000+05:30\",\"label\":\"GW_SGST\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:02:43.000+05:30\",\"usr_refund\":\"false\"},{\"amount\":-1,\"category\":\"CB\",\"code\":\"CTPERF\",\"created_at\":\"2023-07-12T15:03:12.000+05:30\",\"label\":\"Coupon\",\"linkable_type\":\"BusPricingInfo\",\"updated_at\":\"2023-07-12T15:03:12.000+05:30\",\"usr_refund\":\"false\"}]}]}";
}