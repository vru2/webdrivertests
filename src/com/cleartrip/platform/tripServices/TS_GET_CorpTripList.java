package com.cleartrip.platform.tripServices;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TS_GET_CorpTripList extends TripserviceCommon {
	
	@Test(groups={"Regression"})
	public void getCorpTripCount() throws IOException, InterruptedException{
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
		Reporter.log("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com");
		Response resp=RestAssured.get("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com");
		System.out.println(resp.asString());
		if(resp.statusCode()==200){
			ResponseBody body= resp.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
			Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
			Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
			Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
			Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
			Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
			Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
			Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
			Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
			Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
			Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
			Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
			Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
			Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
			Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booking-status=P");
		Response resp1=RestAssured.get("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booking-status=P");
		System.out.println(resp1.asString());
		if(resp1.statusCode()==200){
			ResponseBody body= resp1.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
			Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
			Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
			Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
			Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
			Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
			Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
			Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
			Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
			Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
			Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
			Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
			Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
			Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
			Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
			Reporter.log(bodyAsString);
			
		}else{
			Reporter.log("Status code : " + resp1.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970");
		Response resp2=RestAssured.get("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970");
		System.out.println(resp2.asString());
		if(resp2.statusCode()==200){
			ResponseBody body= resp2.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
			Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
			Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
			Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
			Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
			Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
			Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
			Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
			Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
			Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
			Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
			Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
			Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
			Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
			Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp2.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&trip-ref=Q190822470014&booker-id=1876970&travel-start-date=2019-09-05&travel-end-date=2019-09-07&booking-date-from=2019-08-21&booking-date-to=2019-08-23&status-history=4096&booking-status=B&pax-id=1876970&initiator-id=1876970&txn-status=C&page-size=10");
		Response resp3=RestAssured.get("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&trip-ref=Q190822470014&booker-id=1876970&travel-start-date=2019-09-05&travel-end-date=2019-09-07&booking-date-from=2019-08-21&booking-date-to=2019-08-23&status-history=4096&booking-status=B&pax-id=1876970&initiator-id=1876970&txn-status=C&page-size=10");
		System.out.println(resp3.asString());
		if(resp3.statusCode()==200){
			ResponseBody body= resp3.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
			Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
			Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
			Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
			Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
			Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
			Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
			Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
			Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
			Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
			Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
			Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
			Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
			Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
			Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp3.statusCode());
			assertTrue(false);
		}
		Reporter.log("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970&status-history=4096&booking-status=B&txn-status=C");
		Response resp4=RestAssured.get("http://172.17.26.11:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970&status-history=4096&booking-status=B&txn-status=C");
		System.out.println(resp4.asString());
		if(resp4.statusCode()==200){
			ResponseBody body= resp4.getBody();
			String bodyAsString = body.asString();
			Assert.assertNotNull(bodyAsString);
			Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
			Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
			Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
			Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
			Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
			Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
			Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
			Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
			Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
			Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
			Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
			Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
			Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
			Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
			Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
			Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
			Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
			Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
			Reporter.log(bodyAsString);
		}else{
			Reporter.log("Status code : " + resp4.statusCode());
			assertTrue(false);
		}
		}else if(Host.equalsIgnoreCase("www")) {
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com");
			Response resp=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com");
			if(resp.statusCode()==200){
				ResponseBody body= resp.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booking-status=Z");
			Response resp1=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booking-status=Z");
			if(resp1.statusCode()==200){
				ResponseBody body= resp1.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp1.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booker-id=74797002");
			Response resp2=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booker-id=74797002");
			if(resp2.statusCode()==200){
				ResponseBody body= resp2.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp2.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&trip-ref=190910410608&booker-id=74797002&travel-start-date=2019-11-11&travel-end-date=2019-11-13&booking-date-from=2019-09-09&booking-date-to=2019-09-11&status-history=4128&booking-status=Z&pax-id=101585082&initiator-id=74797002&txn-status=C&page-size=10");
			Response resp3=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&trip-ref=190910410608&booker-id=74797002&travel-start-date=2019-11-11&travel-end-date=2019-11-13&booking-date-from=2019-09-09&booking-date-to=2019-09-11&status-history=4128&booking-status=Z&pax-id=101585082&initiator-id=74797002&txn-status=C&page-size=10");
			if(resp3.statusCode()==200){
				ResponseBody body= resp3.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp3.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booker-id=74797002&status-history=4128&booking-status=Z&txn-status=C");
			Response resp4=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&booker-id=74797002&status-history=4128&booking-status=Z&txn-status=C");
			if(resp4.statusCode()==200){
				ResponseBody body= resp4.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp4.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&trip-ref=190830769704&booker-id=74797002&travel-start-date=2019-09-04&travel-end-date=2019-09-07&booking-date-from=2019-08-28&booking-date-to=2019-09-01&status-history=0&booking-status=K&txn-status=C&page-size=10");
			Response resp5=RestAssured.get("http://trip-service.cltp.com:9001/trips/corp?domain=corpprod.cleartripforbusiness.com&trip-ref=190830769704&booker-id=74797002&travel-start-date=2019-09-04&travel-end-date=2019-09-07&booking-date-from=2019-08-28&booking-date-to=2019-09-01&status-history=0&booking-status=K&txn-status=C&page-size=10");
			if(resp5.statusCode()==200){
				ResponseBody body= resp5.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("hotels"), true ,"Response boday contains hotels");
				Assert.assertEquals(bodyAsString.contains("hotel_name"), true ,"Response boday contains hotel_name");
				Assert.assertEquals(bodyAsString.contains("room_type"), true ,"Response boday contains room_type");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("hotel_id"), true ,"Response boday contains hotel_id");
				Assert.assertEquals(bodyAsString.contains("room_count"), true ,"Response boday contains room_count");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp5.statusCode());
				assertTrue(false);
			}
		}else if(Host.equalsIgnoreCase("dev")) {
			Reporter.log("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com");
			Response resp=RestAssured.get("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com");
			if(resp.statusCode()==200){
				ResponseBody body= resp.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booking-status=P");
			Response resp1=RestAssured.get("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booking-status=P");
			if(resp1.statusCode()==200){
				ResponseBody body= resp1.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp1.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970");
			Response resp2=RestAssured.get("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970");
			if(resp2.statusCode()==200){
				ResponseBody body= resp2.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp2.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&trip-ref=Q190822470014&booker-id=1876970&travel-start-date=2019-09-05&travel-end-date=2019-09-07&booking-date-from=2019-08-21&booking-date-to=2019-08-23&status-history=4096&booking-status=B&pax-id=1876970&initiator-id=1876970&txn-status=C&page-size=10");
			Response resp3=RestAssured.get("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&trip-ref=Q190822470014&booker-id=1876970&travel-start-date=2019-09-05&travel-end-date=2019-09-07&booking-date-from=2019-08-21&booking-date-to=2019-08-23&status-history=4096&booking-status=B&pax-id=1876970&initiator-id=1876970&txn-status=C&page-size=10");
			if(resp3.statusCode()==200){
				ResponseBody body= resp3.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp3.statusCode());
				assertTrue(false);
			}
			Reporter.log("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970&status-history=4096&booking-status=B&txn-status=C");
			Response resp4=RestAssured.get("http://172.17.32.12:9031/trips/corp?domain=demo.cleartripforbusiness.com&booker-id=1876970&status-history=4096&booking-status=B&txn-status=C");
			if(resp4.statusCode()==200){
				ResponseBody body= resp4.getBody();
				String bodyAsString = body.asString();
				Assert.assertNotNull(bodyAsString);
				Assert.assertEquals(bodyAsString.contains("trip_ref"), true ,"Response boday contains trip_ref");
				Assert.assertEquals(bodyAsString.contains("trip_name"), true ,"Response boday contains trip_name");
				Assert.assertEquals(bodyAsString.contains("booker_id"), true ,"Response boday contains booker_id");
				Assert.assertEquals(bodyAsString.contains("status_reason"), true ,"Response boday contains status_reason");
				Assert.assertEquals(bodyAsString.contains("user_id"), true ,"Response boday contains user_id");
				Assert.assertEquals(bodyAsString.contains("booking_status"), true ,"Response boday contains booking_status");
				Assert.assertEquals(bodyAsString.contains("initiator_id"), true ,"Response boday contains initiator_id");
				Assert.assertEquals(bodyAsString.contains("approved_by_id"), true ,"Response boday contains approved_by_id");
				Assert.assertEquals(bodyAsString.contains("approver_id"), true ,"Response boday contains approver_id");
				Assert.assertEquals(bodyAsString.contains("pax_id"), true ,"Response boday contains pax_id");
				Assert.assertEquals(bodyAsString.contains("domain"), true ,"Response boday contains domain");
				Assert.assertEquals(bodyAsString.contains("pahcc_booking_check"), true ,"Response boday contains pahcc_booking_check");
				Assert.assertEquals(bodyAsString.contains("user_trip_name"), true ,"Response boday contains user_trip_name");
				Assert.assertEquals(bodyAsString.contains("amount"), true ,"Response boday contains amount");
				Assert.assertEquals(bodyAsString.contains("status_history"), true ,"Response boday contains status_history");
				Assert.assertEquals(bodyAsString.contains("flight_type"), true ,"Response boday contains flight_type");
				Assert.assertEquals(bodyAsString.contains("airline_code"), true ,"Response boday contains airline_code");
				Assert.assertEquals(bodyAsString.contains("external_references"), true ,"Response boday contains external_references");
				Reporter.log(bodyAsString);
			}else{
				Reporter.log("Status code : " + resp4.statusCode());
				assertTrue(false);
			}
		}
	}

}
