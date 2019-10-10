package testScriptsJsonExternalAPI;

import java.util.HashMap;
import java.util.List;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testScriptsExternalAPICommon.CommonUtils;

import com.google.common.collect.ArrayListMultimap;

public class JSONB2C_API_Book_RT_SPICEJETMultiPAX extends CommonUtils{




	
	DefaultHttpClient clientSearch = null;
	ArrayListMultimap<String, String> fareKeys=ArrayListMultimap.create();
	HashMap<String, String> hp=new HashMap<String,String>();
	HashMap<String, String> hp1=new HashMap<String,String>();
	HashMap<String, String> fareKey=new HashMap<String,String>();
	String payLoadFileName = "Payloadroundtrip.txt";
    boolean bookingSuccess = false;
    String tripId = null;
    String airlinepnr=null;
	String ticketNumber=null;
	public RemoteWebDriver driver = null;
	String bookingstatus=null;
	String basefare=null;
	String discount=null;
	String taxes=null;
	String cashback=null;
	//
	@Test(dataProvider="dp")
	public void jSONAPI_Book_RT_SPICEJETMultiPAX_344(String from,String to,String carrier,String aCount,String cCount) throws Exception{
		//String common.value("Environment") = getcommon.value("Environment")("common.value("Environment")");
		String onwarddate=getModifiedDate(common.value("Days_to_add_for_CurrentDate"));
		String returndate=getModifiedDate(common.value("Days_to_add_for_CurrentDate_to_return"));
		
		
		List l=getRoundtripFlightDetails(hp,hp1,clientSearch,fareKey,from,to,carrier,aCount,cCount,onwarddate,returndate,"B2C");
		//System.out.println(l.get(0));
		hp=(HashMap<String, String>) l.get(0);
		hp1=(HashMap<String, String>) l.get(1);
		fareKey=(HashMap<String, String>) l.get(2);
	int i=0;
	boolean flightUnavailable=false;
	Test:do{
		JSONObject itinenaryId=getRoundTripMultiPAXItineraryID(clientSearch,hp,hp1,fareKey,from,to,carrier,aCount,cCount,onwarddate,returndate,i,"B2C");
	
//System.out.println("itinerary id="+itinenaryId);
	//System.out.println(itinenaryId.getString("itinerary_id"));
	JSONObject jsonObject1=jsonBooking(itinenaryId,clientSearch,"B2C");
	try{
		String tripId = jsonObject1.getString("trip_id");
		JSONArray pxPrcngInfo = jsonObject1.getJSONArray("pax_pricing_info_list");
		for (int loop1 = 0; loop1 <= (pxPrcngInfo.length()-1); loop1++){
			JSONObject paxObject = pxPrcngInfo.getJSONObject(loop1);
			JSONArray bookingInfoArray = paxObject.getJSONArray("booking_info_list");
			for (int loop2 = 0; loop2 <= (bookingInfoArray.length()-1); loop2++){
				JSONObject bookingInfoObject = bookingInfoArray.getJSONObject(loop2);
				airlinepnr = bookingInfoObject.getString("airline_pnr");
				ticketNumber=bookingInfoObject.getString("ticket_number");
				bookingstatus=bookingInfoObject.getString("booking_status");
				
			}
		}
	
	
	
	System.out.println("trip-id="+jsonObject1.getString("trip_id"));
	Reporter.log("trip-id="+jsonObject1.getString("trip_id"));
	tripId = jsonObject1.getString("trip_id");
	Reporter.log("airline-pnr="+airlinepnr);
	System.out.println("airline-pnr="+airlinepnr);
	Reporter.log("TicketNumber="+ticketNumber);
	System.out.println("TicketNumber="+ticketNumber);
	
	Reporter.log("booking status="+bookingstatus);
	System.out.println("booking status="+bookingstatus);
	
	
				 
	bookingSuccess=true;
	flightUnavailable=false;
}
	catch(Exception e){
		System.out.println(jsonObject1.getString("error_message"));
		Reporter.log(jsonObject1.getString("error_message"));
		bookingSuccess=false;
	}
	i++;	
}while(i<1 && flightUnavailable);
Assert.assertTrue(bookingSuccess,"Booking Failed");
  }
	

	
	@DataProvider(name="dp")
	public static Object[][] oneAdultDp(){
		return new Object[][]{
				{"BLR","BOM","SG","1","1"}
				              
		 
		 };
		}


	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethod(driver, _result);
	}


}
