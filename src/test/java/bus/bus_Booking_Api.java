// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class bus_Booking_Api extends bus_Common_API {
	@Test
	public void bus_Book() throws Exception {

		//-------------------------------------- Search ---------------------------------------------------//

		String Operator_Name = "GDS Demo Testnaveen";
		Response respSearch = busGet("Search", SRP_Date(11));
		JsonPath jsonPathEvaluatorSearch = respSearch.jsonPath();
		Reporter.log("Search response : " + respSearch.body().asString());
		//System.out.println("Search response : " + respSearch.body().asString());
		String searchId = jsonPathEvaluatorSearch.getString("data.sc.searchId");
		String Operators = jsonPathEvaluatorSearch.getString("data.buses.meta.operatorName");
		String[] OperatorList = Operators.split(", ");
		int i = 0;
		for (i = 0; i < OperatorList.length; i++) {
			if (OperatorList[i].contains(Operator_Name)) {
				break;
			}
		}
		String Soln_Id = jsonPathEvaluatorSearch.getString("data.buses[" + i + "].solutionId");
		Reporter.log("Soln_Id " + Soln_Id);
		Reporter.log("search_id " + searchId);
		System.out.println("Soln_Id " + Soln_Id);
		System.out.println("search_id " + searchId);

		//---------------------------------------- Chart ------------------------------------------------//

		String payload_Chart = "{\"solutionId\":\""+Soln_Id+"\",\"searchId\":\""+searchId+"\"}";
		Response respChart = busPost("Chart", payload_Chart);
		JsonPath jsonPathEvaluatorChart = respChart.jsonPath();
		Reporter.log("Chart response : " + respChart.body().asString());
		//System.out.println("Chart response : " + respChart.body().asString());
		String chartInstanceID = jsonPathEvaluatorChart.getString("data.chart.chartInstanceId");
		System.out.println("ChartInstanceID "+chartInstanceID);
		String Chartdata = jsonPathEvaluatorChart.getString("data.chart.lowerDeck");
		String Seats = jsonPathEvaluatorChart.getString("data.chart.totalSeats");
		int totalSeats = Integer.parseInt(Seats);
		String SeatDetails =null;
		for ( i = 0; i < totalSeats; i++) {
			if (jsonPathEvaluatorChart.getString("data.chart.lowerDeck["+i+"]").contains("AVAILABLE_FOR_ALL")) {
				SeatDetails = jsonPathEvaluatorChart.getString("data.chart.lowerDeck["+i+"]");
			//	System.out.println("SeatDetails "+SeatDetails);
				break;
			}
		}
		String[] SeatDetailsList = SeatDetails.split(", ");
		String AvailableSeatNo = null;
		for ( i = 0; i < SeatDetailsList.length; i++) {
			if(SeatDetailsList[i].contains("seatNum")){
				AvailableSeatNo = SeatDetailsList[i];
			}
		}
		AvailableSeatNo = AvailableSeatNo.replace("seatNum:","");
		String pickUp = jsonPathEvaluatorChart.getString("data.chart.pickups[0].pickupCode");
		String dropOff = jsonPathEvaluatorChart.getString("data.chart.dropOffs[0].dropOffCode");
		System.out.println("pickups "+pickUp);
		System.out.println("dropOffs "+dropOff);
		System.out.println("AvailableSeatNo "+AvailableSeatNo);

		//---------------------------------------- Itinerary ------------------------------------------------//

		Thread.sleep(5000);
		String payLoad_Bus_itinerary = "{\"itineraryId\":\"\",\"journey\":[{\"solutionId\":\""+Soln_Id+"\",\"searchId\":\""+searchId+"\",\"chartInstanceId\":\""+chartInstanceID+"\",\"pickupCode\":\""+pickUp+"\",\"dropOffCode\":\""+dropOff+"\",\"seats\":[{\"seatNumber\":\""+AvailableSeatNo+"\"}]}]}";
		Response respItinerary = busPost("Itinerary", payLoad_Bus_itinerary);
		JsonPath jsonPathEvaluatorItinerary = respItinerary.jsonPath();
		Reporter.log("Itinerary response : " + respItinerary.body().asString());
		//System.out.println("Itinerary response : " + respItinerary.body().asString());
		String Itinerary_ID = jsonPathEvaluatorItinerary.getString("data.itineraryId");
		Reporter.log("Chart response : " + respItinerary.body().asString());

		//---------------------------------------- Traveller ------------------------------------------------//

		Thread.sleep(5000);
		String payLoad_Update_Traveller = "{\"itineraryId\":\""+Itinerary_ID+"\",\"journey\":[{\"seats\":[{\"seatNumber\":\""+AvailableSeatNo+"\",\"traveller\":{\"firstName\":\"Kiran\",\"lastName\":\"Kumar\",\"age\":80,\"gender\":\"M\"}}]}],\"contactDetail\":{\"email\":\"kiran.kumar@cleartrip.com\",\"mobile\":\"9986696785\",\"countryCode\":\"+91\"}}";
		Response respUpdateTraveller = busPut("UpdateTraveller", payLoad_Update_Traveller);
		//System.out.println("Update traveller response : " + respUpdateTraveller.body().asString());
		String success = jsonPathEvaluatorItinerary.getString("success");
		if(!success.equalsIgnoreCase("true")){
			Assert.assertTrue(false);
		}

		//---------------------------------------- PreBook  ------------------------------------------------//

		Thread.sleep(5000);
		Response respPreBook = busPost("PreBook", Itinerary_ID );
		JsonPath jsonPathEvaluatorPreBook = respPreBook.jsonPath();
		//System.out.println("PreBook response : " + respPreBook.body().asString());
		String paymentUrl = jsonPathEvaluatorPreBook.getString("data.paymentUrl");
		paymentUrl = paymentUrl.replace("/pay/bus/", "").replace("?lang=en", "");
		Reporter.log("paymentUrl : "+paymentUrl);

		//---------------------------------------- Initiate pay --------------------------------------------//


		Thread.sleep(5000);
		Response respPayInitiate = busGet("PayInti", paymentUrl );
		JsonPath jsonPathrespPayInitiate = respPayInitiate.jsonPath();
		System.out.println("respPayInitiate response : " + respPayInitiate.body().asString());
		String tripId = jsonPathrespPayInitiate.getString("trip_info.tripId");

		String total_fare = jsonPathrespPayInitiate.getString("bus_booking.total_fare");

		Response respTS= RestAssured.get("http://trip-service-api.cltp.com:9001/trips?tripID="+tripId);
		//System.out.println(respTS.asString());

		JsonPath jsonPathrespTS = respTS.jsonPath();
		System.out.println("respPayInitiate response : " + respTS.body().asString());
		String trip_id_TS = jsonPathrespTS.getString("id");
		//System.out.println("ID : " + trip_id_TS);

		//---------------------------------------- Wallet Pay ------------------------------------------------//

		String payLoad_Pay_Wall = "[{\"payment\":{\"seq_no\":2,\"trip_id\":"+trip_id_TS+",\"app_userid\":65254983,\"product_type\":\"BUS\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\""+tripId+"\",\"app_ref2\":\"74049672\",\"itinerary_id\":\""+Itinerary_ID+"\",\"payment_type\":\"WT\",\"amount\":"+total_fare+",\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E\\/233\\/BLR\\/MAA\\/20181125062500\",\"order_info2\":\"Test Booking\",\"source_type\":\"ACCOUNT\",\"user_id\":13957750,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/532f7e3ecdbf55e83eef38c70f185da3/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/532f7e3ecdbf55e83eef38c70f185da3/book-internal?ll=INFO\"},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrom/69.0.3497.100 Safari/537.36\"}}]";
		Response respPayWallet = busPost("PayWall", payLoad_Pay_Wall );
		JsonPath jsonPathrespPayWallet = respPayWallet.jsonPath();
		Reporter.log("jsonPathrespPayWallet response : " + respPayWallet.body().asString());
		System.out.println("jsonPathrespPayWallet response : " + respPayWallet.body().asString());
		String status = jsonPathrespPayWallet.getString("status");
		System.out.println("Wallet Pay status : " + jsonPathrespPayWallet.getString("status"));
		String PayStatus = "FAILED";
		if(status.equalsIgnoreCase("[S]")){
			PayStatus = "SUCCESS";
		} else
		{
			Reporter.log("Payment failed "+status);
			Assert.assertTrue(false);
		}
		//---------------------------------------- Book Internal ------------------------------------------------//

		Thread.sleep(2000);
		String payLoad_BookInternal = "{\"payments\":[{\"convenience_fee\":0.0,\"trip_ref\":\"" + tripId + "\",\"txn_id\":\"77148770\",\"amount\":" + total_fare + ",\"payment_category\":\"B\",\"payment_type\":\"WT\",\"status\":\""+PayStatus+"\",\"description\":\"Wallet payment success\",\"customer_detail\":{\"user_id\":65254983,\"ip_address\":\"35.190.36.127\",\"mobile\":\"9986696785\",\"email\":\"kiran@cleartrip.com\",\"first_name\":\"Kiran\",\"last_name\":\"Kumar\"},\"payment_additional_params\":{}}],\"super_coin_earn_eligible\":false,\"additional_params\":{\"saved_cards_available\":\"yes\",\"offer_banner_available\":\"no\",\"payment_mode\":\"WT\",\"token_selected\":\"no\",\"saved_vpa_abcookie\":\"n/a\",\"sub_payment_mode\":\"N/A\",\"supercoin_burnt\":0,\"ct_wallet_balance\":1147851.77,\"wallet_balance_used\":4,\"primary_payment_method\":\"WT\",\"primary_payment_subtype\":\"N/A\",\"primary_payment_value\":4,\"payment_ab_cookie\":\"coupon_tray:a;\"}}";
		Response respBookInternal = busPostNew("Param_BookInternal", Itinerary_ID,  payLoad_BookInternal);
		JsonPath jsonPathrespBookInternal = respBookInternal.jsonPath();
		//System.out.println("respBookInternal response : " + respBookInternal.body().asString());
		String return_url = jsonPathrespBookInternal.getString("return_url");
		System.out.println("tripId : " + tripId);
		System.out.println("total_fare : " + total_fare);
		if(!return_url.contains("/bus/confirmation")){
			Assert.assertTrue(false);
		}
		String statusBook = jsonPathrespBookInternal.getString("status");
		if(!statusBook.equalsIgnoreCase("SUCCESS")){
			Assert.assertTrue(false);
		}

		//---------------------------------------- Cancellation ------------------------------------------------//

		Thread.sleep(10000);
		Response respCancellation = busPut("Cancellation", tripId);
		JsonPath jsonPathrespCancellation = respCancellation.jsonPath();
		System.out.println("respCancellation response : " + respCancellation.body().asString());
	}

}