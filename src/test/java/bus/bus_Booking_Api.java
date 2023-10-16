// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class bus_Booking_Api extends bus_Common_API {
	@Test
	public void Bus_Book() throws Exception {

		//--------------------------------------Search---------------------------------------------------//
		Response resp;
		resp = busGet("Search", "");
		JsonPath jsonPathEvaluator = resp.jsonPath();

		Reporter.log("Search response : " + resp.body().asString());
		// System.out.println("Search response : " + resp.body().asString());

		String searchId = null;
		searchId = jsonPathEvaluator.getString("data.sc.searchId");
		System.out.println("search_id " + searchId);

		String Operators = jsonPathEvaluator.getString("data.buses.meta.operatorName");
		String[] OperatorList = Operators.split(", ");

		String GDSDemo = null;
		int j = 0;
		for ( int i = 0; i < OperatorList.length; i++) {
			if (OperatorList[i].contains("GDS Demo Testnaveen")) {
				j=i;
				System.out.println(i);
				GDSDemo = jsonPathEvaluator.getString("data.buses[" + i + "]");
				System.out.println(jsonPathEvaluator.getString("data.buses[" + i + "]"));
			}
		}
		String Soln_Id = jsonPathEvaluator.getString("data.buses[" + j + "].solutionId");
		System.out.println("Soln_Id " + Soln_Id);

		//----------------------------------------Chart ------------------------------------------------//

		Response respChart;
		String payload_Chart = "{\"solutionId\":\""+Soln_Id+"\",\"searchId\":\""+searchId+"\"}";

		respChart = busPost("Chart", payload_Chart);
		JsonPath jsonPathEvaluatorChart = respChart.jsonPath();

		Reporter.log("Chart response : " + resp.body().asString());
		System.out.println("Chart response : " + resp.body().asString());
		String chartInstanceID = jsonPathEvaluatorChart.getString("data.chart.chartInstanceId");
		System.out.println("//----------------------------------------Chart ------------------------------------------------//");
		System.out.println("ChartInstanceID "+chartInstanceID);
		String Chartdata = jsonPathEvaluatorChart.getString("data.chart.lowerDeck");
		String Seats = jsonPathEvaluatorChart.getString("data.chart.totalSeats");
		int totalSeats = Integer.parseInt(Seats);
		String SeatDetails =null;
		for (int i = 0; i < totalSeats; i++) {
			if (jsonPathEvaluatorChart.getString("data.chart.lowerDeck["+i+"]").contains("AVAILABLE_FOR_ALL")) {
				SeatDetails = jsonPathEvaluatorChart.getString("data.chart.lowerDeck["+i+"]");
				System.out.println("//----------------------------------------Seat details ------------------------------------------------//");
				System.out.println("SeatDetails "+SeatDetails);
				break;
			}
		}

		String[] SeatDetailsList = SeatDetails.split(", ");
		String AvailableSeatNo = null;
		for (int i = 0; i < SeatDetailsList.length; i++) {
			if(SeatDetailsList[i].contains("seatNum")){
				AvailableSeatNo = SeatDetailsList[i];
			}
		}
		AvailableSeatNo = AvailableSeatNo.replace("seatNum:","");
		String pickUp = jsonPathEvaluatorChart.getString("data.chart.pickups[1].pickupCode");
		String dropOff = jsonPathEvaluatorChart.getString("data.chart.dropOffs[1].dropOffCode");

		System.out.println("----------------------------------------------------------------------------------");

		System.out.println("pickups "+pickUp);
		System.out.println("dropOffs "+dropOff);
		System.out.println("AvailableSeatNo "+AvailableSeatNo);

		//----------------------------------------Itinerary ------------------------------------------------//

		Response respItinerary;
		String param_Bus_itinerary = "{\"itineraryId\":\"\",\"journey\":[{\"solutionId\":\""+Soln_Id+"\",\"searchId\":\""+searchId+"\",\"chartInstanceId\":\""+chartInstanceID+"\",\"pickupCode\":\""+pickUp+"\",\"dropOffCode\":\""+dropOff+"\",\"seats\":[{\"seatNumber\":\""+AvailableSeatNo+"\"}]}]}";

		respItinerary = busPost("Itinerary", param_Bus_itinerary);
		JsonPath jsonPathEvaluatorItnearary = respItinerary.jsonPath();

		Reporter.log("Itinerary response : " + respItinerary.body().asString());
		System.out.println("Itinerary response : " + respItinerary.body().asString());

		System.out.println("----------------------------------Traveller------------------------------------------------");


		String Itinerary_ID = jsonPathEvaluatorItnearary.getString("data.itineraryId");
		Reporter.log("Chart response : " + respItinerary.body().asString());
		//System.out.println("Chart response : " + resp.body().asString());

		String Param_Update_Traveller = "{\"itineraryId\":\""+Itinerary_ID+"\",\"journey\":[{\"seats\":[{\"seatNumber\":\""+AvailableSeatNo+"\",\"traveller\":{\"firstName\":\"test\",\"lastName\":\"test\",\"age\":20,\"gender\":\"M\"}}]}],\"contactDetail\":{\"email\":\"kiran.kumar@cleartrip.com\",\"mobile\":\"9986696785\",\"countryCode\":\"+91\"}}";
		Response respUpdateTraveller;
		respUpdateTraveller = busPut("UpdateTraveller", Param_Update_Traveller);

		System.out.println("Update traveller response : " + respUpdateTraveller.body().asString());
		String success = jsonPathEvaluatorItnearary.getString("success");
		if(!success.equalsIgnoreCase("true")){
			Assert.assertTrue(false);
		}

		//=============================PreBook================================================//


		Response respPreBook;

		respPreBook = busPost("PreBook", Itinerary_ID );
		JsonPath jsonPathEvaluatorPreBook = respPreBook.jsonPath();

		System.out.println("PreBook response : " + respPreBook.body().asString());


		String Pay_Url = jsonPathEvaluatorPreBook.getString("data.paymentUrl");

		Pay_Url = Pay_Url.replace("/pay/bus/", "").replace("?lang=en", "");

		System.out.println("Pay_Url : "+Pay_Url);


		//=============================Pay Initiate ================================================//



		Response respPayInitiate;

		respPayInitiate = busGet("PayInti", Pay_Url );
		JsonPath jsonPathrespPayInitiate = respPayInitiate.jsonPath();
		System.out.println("respPayInitiate response : " + respPayInitiate.body().asString());


		String tripId = jsonPathrespPayInitiate.getString("trip_info.tripId");
		String total_fare = jsonPathrespPayInitiate.getString("bus_booking.total_fare");
		System.out.println("tripId : " + tripId);
		System.out.println("total_fare : " + total_fare);


		//=============================Pay Wallet ================================================//

		Response respPayWallet;

		String Param_Pay_Wall = "[{\"payment\":{\"seq_no\":2,\"trip_id\":54808092,\"app_userid\":65254983,\"product_type\":\"BUS\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\""+tripId+"\",\"app_ref2\":\"74049672\",\"itinerary_id\":\""+Itinerary_ID+"\",\"payment_type\":\"WT\",\"amount\":"+total_fare+",\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E\\/233\\/BLR\\/MAA\\/20181125062500\",\"order_info2\":\"Test Booking\",\"source_type\":\"ACCOUNT\",\"user_id\":13957750,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/532f7e3ecdbf55e83eef38c70f185da3/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/532f7e3ecdbf55e83eef38c70f185da3/book-internal?ll=INFO\"},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrom/69.0.3497.100 Safari/537.36\"}}]";

		respPayWallet = busPost("PayWall", Param_Pay_Wall );
		JsonPath jsonPathrespPayWallet = respPayWallet.jsonPath();
		System.out.println("jsonPathrespPayWallet response : " + respPayWallet.body().asString());


		//=============================Book internal ================================================//


		String Param_BookInternal = "{\"payments\":[{\"convenience_fee\":0.0,\"trip_ref\":\"" + tripId + "\",\"txn_id\":\"77148770\",\"amount\":" + total_fare + ",\"payment_category\":\"B\",\"payment_type\":\"WT\",\"status\":\"SUCCESS\",\"description\":\"Wallet payment success\",\"customer_detail\":{\"user_id\":65254983,\"ip_address\":\"35.190.36.127\",\"mobile\":\"2222222226\",\"email\":\"kiran@cleartrip.com\",\"first_name\":\"Kiran\",\"last_name\":\"Kumar\"},\"payment_additional_params\":{}}],\"super_coin_earn_eligible\":false,\"additional_params\":{\"saved_cards_available\":\"yes\",\"offer_banner_available\":\"no\",\"payment_mode\":\"WT\",\"token_selected\":\"no\",\"saved_vpa_abcookie\":\"n/a\",\"sub_payment_mode\":\"N/A\",\"supercoin_burnt\":0,\"ct_wallet_balance\":1147851.77,\"wallet_balance_used\":4,\"primary_payment_method\":\"WT\",\"primary_payment_subtype\":\"N/A\",\"primary_payment_value\":4,\"payment_ab_cookie\":\"coupon_tray:a;\"}}";


		Response respBookInternal;

		respBookInternal = busPostNew("Param_BookInternal", Itinerary_ID,  Param_BookInternal);
		JsonPath jsonPathrespBookInternal = respBookInternal.jsonPath();
		System.out.println("respBookInternal response : " + respBookInternal.body().asString());


	}
}