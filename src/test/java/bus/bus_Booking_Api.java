// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
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
			if (OperatorList[i].contains("naveen")) {
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
		//System.out.println("Chart response : " + resp.body().asString());
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

	}
}