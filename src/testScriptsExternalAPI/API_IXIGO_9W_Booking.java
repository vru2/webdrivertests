package testScriptsExternalAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import testScriptsExternalAPICommon.CommonUtils;

import com.google.common.collect.ArrayListMultimap;

public class API_IXIGO_9W_Booking extends CommonUtils{


	public RemoteWebDriver driver = null;
	DefaultHttpClient clientSearch = null;
	ArrayListMultimap<String, String> fareKeys=ArrayListMultimap.create();
	String payLoadFileName = "Ixigo.txt";
	boolean bookingSuccess = false;
	String TotalFare;
	HttpPost bookCall;
	//public RemoteWebDriver driver = null;
	HttpResponse itinenaryResponse=null;
	boolean paymentDone = false;
	HttpResponse itinenaryResponse1;
	JSONObject itinenaryId1;
	String tripId= null;
	String airlinepnr=null;
	String ticketnumber=null;
	String bookingstatus=null;
	String totalfare=null;
	String basefare=null;
	String discount=null;
	JSONObject itinenaryId;
	String taxes=null;
	 boolean priceChange1=false;
	String cashback=null;
	String[] res;
	String finalfare;
	String paymentlink;
	String responseString;
	String domain = "com";
	JSONArray onwardSolutions;
	
	@BeforeClass
	public void startSelenium() throws Exception {
		this.driver = getDriver(driver);
		if (driver == null) {
			Reporter.log("Error in initial setup. Exiting without screenshot");
			throw new SkipException("Skipping Test: ");
		}
		baseUrl = getBaseUrl(domain);
	}
	
	
	@Test(dataProvider="dp")
	public void retailOneAdult_360(String from,String to,String carrier,String aCount,String cCount) throws Exception{
		//String common.value("Environment") = getcommon.value("Environment")("common.value("Environment")");
		String onwarddate=getModifiedDate(common.value("Days_to_add_for_CurrentDate"));
		String returndate1=getModifiedDate(common.value("Days_to_add_for_CurrentDate_to_return"));
		//System.out.println("onward date="+onwarddate+"   returndate="+returndate1);
		clientSearch = new DefaultHttpClient();
	System.out.println(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/search?from="+from+"&to="+to+"&depart-date="+onwarddate+"&adults="+aCount+"&children="+cCount+"&infants=0&carrier="+carrier+"&cabin-type=Economy");
		HttpGet get = new HttpGet(new URI(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/search?from="+from+"&to="+to+"&depart-date="+onwarddate+"&adults="+aCount+"&children="+cCount+"&infants=0&carrier="+carrier+"&cabin-type=Economy"));
		//System.out.println();
		// getdepositaccountid(common.value("AccountID"),"Book.txt");
		//getdepositaccountid(common.value("AccountID"),"PayloadIntlSinglePAX.txt");

		get.setHeader("X-CT-API-KEY",common.value("APIKey"));
		get.setHeader("X-CT-SOURCETYPE","B2C");
		//get.setHeader("X-CT-API-KEY","707ef05933ce418c028a65419dadaf8d");
		HttpResponse response = clientSearch.execute(get);
		//System.out.println(response);
		HttpEntity entity = response.getEntity();
		Document doc =null;
		StringBuffer sb1 = new StringBuffer();
		String str1="";
		BufferedReader br1 = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while((str1=br1.readLine())!=null){
			sb1.append(str1);
		}

		JSONObject jsonObject = XML.toJSONObject(sb1.toString());

		//System.out.println(jsonObject);
		JSONObject airSearchResult = jsonObject.getJSONObject("air-search-result");
		try{
		JSONObject onward = airSearchResult.getJSONObject("onward-solutions");
		//System.out.println("onward="+onward);
		 onwardSolutions = onward.getJSONArray("solution");
		}
		catch(Exception e){
			JSONObject onward = airSearchResult.getJSONObject("solutions");
			//System.out.println("onward="+onward);
			 onwardSolutions = onward.getJSONArray("solution");
		}
		//System.out.println("onwardSolutions=="+onwardSolutions);
		for(int a=0;a<onwardSolutions.length();a++){
			TotalFare=onwardSolutions.getJSONObject(a).getJSONObject("pricing-summary").toString();
			//System.out.println(TotalFare);
			 res=TotalFare.split("\\,");
			 finalfare="_fpr_"+res[2].split(":")[1];
			// //System.out.println("finalfare==="+finalfare);
			////System.out.println("check=="+"fpr_"+res[2].split(":")[1]);
			//System.out.println(onwardSolutions.getJSONObject(a).getJSONObject("pax-pricing-info-list").getJSONObject("pax-pricing-info").getJSONObject("pricing-info-list").getJSONObject("pricing-info").get("fare-key").toString());
			fareKeys.put(String.valueOf(a),onwardSolutions.getJSONObject(a).getJSONObject("pax-pricing-info-list").getJSONObject("pax-pricing-info").getJSONObject("pricing-info-list").getJSONObject("pricing-info").get("fare-key").toString());
			////System.out.println("fare key value="+fareKeys.get("a"));
		}
		int i=0;
		boolean flightUnavailable;
		//Test:do{

			flightUnavailable= false;
			//if(fareKeys.get(String.valueOf(i)).toArray().length==2){
			// String key = fareKeys.get(String.valueOf(i)).toString();
		
			String key1=fareKeys.get(String.valueOf(i)).toString().replace("[","").replace("]","");
			//System.out.println(key1);
			String flightno = fareKeys.get(String.valueOf(i)).toString().split(carrier.trim())[1].split("_")[1].trim();
			//System.out.println(flightno);
			// String flightno1=flightno.replace("[","").replace("]","");
			////System.out.println("flight no 1=================="+flightno1);
			/* String key = fareKeys.get("fare-key").get(i);
			    	   String flightno = fareKeys.get("fare-key").get(i).split(carrier.trim())[1].split("_")[1].trim();*/
			String postString="<?xml version=\"1.0\" encoding=\"UTF-8\"?><itinerary>  <cabin-type>E</cabin-type>  <flights>    <flight-spec>      <fare-key>"+key1+"</fare-key>      <segments>        <segment-spec>          <departure-airport>"+from+"</departure-airport>          <arrival-airport>"+to+"</arrival-airport>          <flight-number>"+flightno+"</flight-number>          <airline>"+carrier+"</airline>          <departure-date>"+onwarddate+"</departure-date>        </segment-spec>      </segments>    </flight-spec>  </flights>  <pax-info-list>    <pax-info>      <title>Mr</title>      <first-name>Jivan</first-name>      <last-name>Kottian</last-name>      <type>ADT</type>      <id-number>Grant</id-number>      <date-of-birth>1990-05-05</date-of-birth>    </pax-info>  </pax-info-list>  <contact-detail>    <title>Mr</title>    <first-name>Test</first-name>    <last-name>Booking</last-name>    <email>nfsfrank@hotmail.com</email>    <address>Unit No 001, Ground Floor, DTC Bldg, Sitaram mills compound, N.M.joshi Marg, Lower parel (E)</address>    <mobile>919844000000</mobile>    <landline>02240554000</landline>    <city-name>Mumbai</city-name>    <state-name>Maharashtra</state-name>    <country-name>India</country-name>    <pin-code>400011</pin-code>  </contact-detail></itinerary>";
			//System.out.println("fare key="+key1);
			//System.out.println(postString);
			//System.out.println(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/create");
			HttpPost itinenaryCall = new HttpPost(new URI(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/create"));
			itinenaryCall.setHeader("X-CT-API-KEY",common.value("APIKey"));
			itinenaryCall.setHeader("X-CT-SOURCETYPE","B2C");
			StringEntity params = new StringEntity(postString);
			itinenaryCall.setEntity(params);

			
			
			 itinenaryResponse = clientSearch.execute(itinenaryCall);
			HttpEntity entityIti = itinenaryResponse.getEntity();
			Document docIti =null;
			BufferedReader br12 = new BufferedReader(new InputStreamReader(entityIti.getContent()));
			String str12 ="";
			StringBuffer sb12 =new StringBuffer();
			while((str12=br12.readLine())!=null){
				sb12.append(str12);
			}


		 itinenaryId= XML.toJSONObject(sb12.toString());
//System.out.println(itinenaryId);
		    Reporter.log(itinenaryId.getJSONObject("itinerary").get("itinerary-id").toString(),true);
			
			String postStringBook1="<price-check><payment-detail><payment-type>CP</payment-type></payment-detail></price-check>";
			String postStringBook="<booking><payment-detail><payment-type>CP</payment-type></payment-detail></booking>";
			
	  	   
			
			Document docBook = null;
			Document docBook1 = null;
			//try{
				   	    	System.out.println(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/priceCheck/"+itinenaryId.getJSONObject("itinerary").get("itinerary-id"));
			        HttpPost bookCall1 = new HttpPost(new URI(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/priceCheck/"+itinenaryId.getJSONObject("itinerary").get("itinerary-id")));
			        StringEntity paramsBook1 = new StringEntity(postStringBook1);
			        bookCall1.setEntity(paramsBook1);
			        bookCall1.setHeader("X-CT-API-KEY",common.value("APIKey"));
			        bookCall1.setHeader("X-CT-SOURCETYPE","B2C");
			        HttpResponse bookResponse1 = clientSearch.execute(bookCall1);
			       // //System.out.println("book response="+bookResponse1.getEntity());
			       HttpEntity entityBook1 = bookResponse1.getEntity();
			   /* responseString = EntityUtils.toString(entityBook1, "UTF-8");
			  	   System.out.println("Response string="+responseString);*/
			  	     if(itinenaryResponse!=null){
			  	    	 DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
			               DocumentBuilder db1 = dbf1.newDocumentBuilder();
			                docBook1 = db1.parse(entityBook1.getContent());
			    	  }
			  	   
  paymentlink=docBook1.getElementsByTagName("payment-link").item(0).getTextContent();
 	 System.out.println("payment link="+docBook1.getElementsByTagName("payment-link").item(0).getTextContent());
 	 
 	// Document docBook = null;
//	String common.value("Environment") = getcommon.value("Environment")("common.value("Environment")");
DesiredCapabilities capabilities = new DesiredCapabilities();
	
	//capabilities.setCapability(CapabilityType.PROXY, proxy);
	//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
baseUrl = paymentlink;
//RemoteWebDriver driver = new ChromeDriver();

driver.get(baseUrl);
paymentDone = b2cPayment(driver,"credit card", 1);
			 String url=driver.getCurrentUrl().replace("www","qa2");
			 driver.get(url);
			 //System.out.println("tripId="+driver.findElement(By.xpath("//p[2]")).getText());
			 Reporter.log("tripId="+driver.findElement(By.xpath("//p[2]")).getText());
			 driver.quit();
			
			System.out.println(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/book/"+itinenaryId.getJSONObject("itinerary").get("itinerary-id"));
			 HttpPost bookCall = new HttpPost(new URI(common.value("protocol")+"://"+common.value("Environment")+".cleartrip.com/air/1.0/itinerary/book/"+itinenaryId.getJSONObject("itinerary").get("itinerary-id")));
			 StringEntity paramsBook = new StringEntity(postStringBook);
			 bookCall.setEntity(paramsBook);
			 bookCall.setHeader("X-CT-API-KEY",common.value("APIKey"));
			 bookCall.setHeader("X-CT-SOURCETYPE","B2C");
			 HttpResponse bookResponse = clientSearch.execute(bookCall);
			 ////System.out.println("book response="+bookResponse.getEntity());
			 HttpEntity entityBook = bookResponse.getEntity();
			/* responseString = EntityUtils.toString(entityBook, "UTF-8");
		  	   System.out.println("Response string="+responseString);*/
			if(itinenaryResponse!=null){
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				//  docBook = db.parse(responseString);
				docBook = db.parse(entityBook.getContent());
			}
			 Reporter.log(responseString);
			 Reporter.log("Tickrt number="+docBook.getElementsByTagName("ticket-number").item(0).getTextContent());
			 System.out.println("Tickrt number="+docBook.getElementsByTagName("ticket-number").item(0).getTextContent());
			 Reporter.log("gds-pnr="+docBook.getElementsByTagName("gds-pnr").item(0).getTextContent());
			 System.out.println("gds-pnr="+docBook.getElementsByTagName("gds-pnr").item(0).getTextContent());
			 Reporter.log("base-fare="+docBook.getElementsByTagName("base-fare").item(0).getTextContent());
			 //System.out.println("base-fare="+docBook.getElementsByTagName("base-fare").item(0).getTextContent());
			 basefare = docBook.getElementsByTagName("base-fare").item(0).getTextContent();
			 Reporter.log("discount="+docBook.getElementsByTagName("discount").item(0).getTextContent());
			 //System.out.println("discount="+docBook.getElementsByTagName("discount").item(0).getTextContent());
			 discount = docBook.getElementsByTagName("discount").item(0).getTextContent();
			 //System.out.println("taxes="+docBook.getElementsByTagName("taxes").item(0).getTextContent());
			 Reporter.log("taxes="+docBook.getElementsByTagName("taxes").item(0).getTextContent());
			 taxes = docBook.getElementsByTagName("taxes").item(0).getTextContent();
			 Reporter.log("cashback="+docBook.getElementsByTagName("cashback").item(0).getTextContent());
			 //System.out.println("cashback="+docBook.getElementsByTagName("cashback").item(0).getTextContent());
			 cashback = docBook.getElementsByTagName("cashback").item(0).getTextContent();
			 System.out.println("trip-id="+docBook.getElementsByTagName("trip-id").item(0).getTextContent());
			 Reporter.log("trip-id="+docBook.getElementsByTagName("trip-id").item(0).getTextContent());
			 tripId = docBook.getElementsByTagName("trip-id").item(0).getTextContent();
			 Reporter.log("airline-pnr="+docBook.getElementsByTagName("airline-pnr").item(0).getTextContent());
			 System.out.println("airline-pnr="+docBook.getElementsByTagName("airline-pnr").item(0).getTextContent());
			 airlinepnr=docBook.getElementsByTagName("airline-pnr").item(0).getTextContent();
			 Reporter.log("ticket-number="+docBook.getElementsByTagName("ticket-number").item(0).getTextContent());
			 System.out.println("ticket-number="+docBook.getElementsByTagName("ticket-number").item(0).getTextContent());
			 ticketnumber=docBook.getElementsByTagName("ticket-number").item(0).getTextContent();
			 Reporter.log("booking-status="+docBook.getElementsByTagName("booking-status").item(0).getTextContent());
			 //System.out.println("booking-status="+docBook.getElementsByTagName("booking-status").item(0).getTextContent());
			 bookingstatus=docBook.getElementsByTagName("booking-status").item(0).getTextContent();
				bookingSuccess=true;
				flightUnavailable=false;
			/*}
			catch(Exception e){
				////System.out.println("response string=="+responseString);
				//Reporter.log("response string=="+responseString);
				flightUnavailable=true;
			} 

			i++;
//break Test;
		}while(i<5 && flightUnavailable);
		Assert.assertTrue(bookingSuccess,"Booking Failed");*/
	}



	


	@DataProvider(name="dp")
	public static Object[][] oneAdultDp(){
		return new Object[][]{
				{"DEL","BOM","9W","1","0"}


		};
	}
	//PayloadIntlSinglePAX.txt
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult _result) throws Exception {
		afterMethodNoScreenshot(_result);
	}


}
