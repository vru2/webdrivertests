package testScriptsRewardProgSanity;

import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

//import javax.json.Json;
//import javax.json.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import domainServices.HQ;

public class RewardSanityTravellerCheckPlusMinBookingsForProducts extends HQ {
	
	/*
	public RemoteWebDriver driver = null;
	String tripId = null;
	String domain = "com";
	String Username_HQ_Reward_qa2 = "cleartripautomation+500@gmail.com";
	int userID_HQ_Reward_qa2 = 14037312;

	@BeforeClass
	public void startSelenium() throws Exception {
		this.driver = getDriver(driver);
		if (driver == null) {
			Reporter.log("Error in initial setup. Exiting without screenshot");
			throw new SkipException("Skipping Test: ");
		}
		baseUrl = getBaseUrl(domain);
	}

	@Test()
	public void rewardSanityTravellerCheckPlusMinBookingsForProducts() throws Exception {

		Reporter.log("Test case " + this.getClass() + " started");
		//System.out.println("Test case " + this.getClass() + " started");

		String travellerA = "testone";
		String travellerB = "testtwo";
		String travellerC = "testthree";
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppostBook = new HttpPost("http://172.16.53.222:4567/reward_program_bookings");

		driver.get(getBaseUrl(domain) + "/hq");
		signInHQ(driver);
		Thread.sleep(5000);
		driver.get(getBaseUrl(domain) + "/hq/reports/reward_program/user_dashboard");
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_EmailSearchButton"), 5)) {
			Reporter.log("User reward dashboard not loading. ERROR!");
			//System.out.println("User reward dashboard not loading. ERROR!");
			assertTrue("Failure!", false);
		}

		safeType(driver, getObject("Reward_Program_EmailSearchBox"), Username_HQ_Reward_qa2);
		safeClick(driver, getObject("Reward_Program_EmailSearchButton"));
		Thread.sleep(2000);

		assertTrue("Rounds present without any bookings. Failure!",
				!waitElement(driver, getObject("Reward_Program_RoundSelectDropdown"), 3));

		JsonObject jsonObject = createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 2, -1, 5000, -1,
				travellerB, "", "");
		String jsonString = jsonObject.toString();
		StringEntity se = new StringEntity(jsonString);
		httppostBook.setEntity(se);

		HttpResponse response = httpclient.execute(httppostBook);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		// ["Q1603300725","Q1603300726","Q1603300727","Q1603300728"]
		List<String> trips = tripsFromResponse(responseString);

		jsonObject = createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 1, -1, 5000, -1, travellerA, "",
				"");
		jsonString = jsonObject.toString();
		se = new StringEntity(jsonString);
		httppostBook.setEntity(se);

		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");

		List<String> temp = tripsFromResponse(responseString);
		trips.add(trips.size(), temp.get(0));

		Thread.sleep(120000);
		driver.navigate().refresh();
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 5)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		List<WebElement> tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(0).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(1).equals(
				tripsDetailsFromDashboard.get(1).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(2).equals(
				tripsDetailsFromDashboard.get(2).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(0).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(1).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(2).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Resend".equals(driver.findElements(getObject("Reward_Program_Trips_CouponResendButton")).get(0).getText()));
		//System.out.println("Level 1 completed. Coupon sent.");
		Reporter.log("Level 1 completed. Coupon sent.");

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 2, -1, 5000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 1, -1, 5000, -1,
				travellerA, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		temp = tripsFromResponse(responseString);
		trips.add(trips.size(), temp.get(0));

		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(3).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(1).equals(
				tripsDetailsFromDashboard.get(4).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(2).equals(
				tripsDetailsFromDashboard.get(5).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(3).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(4).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(5).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 1, -1, 5000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		Thread.sleep(40000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(6).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(3).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(4).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(5).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(6).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Resend".equals(driver.findElements(getObject("Reward_Program_Trips_CouponResendButton")).get(1).getText()));
		//System.out.println("Level 2 completed. Coupon sent.");
		Reporter.log("Level 2 completed. Coupon sent.");

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "hotel", "", 2, -1, 5000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 1, -1, 5000, -1,
				travellerA, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		temp = tripsFromResponse(responseString);
		trips.add(trips.size(), temp.get(0));

		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(7).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(1).equals(
				tripsDetailsFromDashboard.get(8).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(2).equals(
				tripsDetailsFromDashboard.get(9).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(7).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(8).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(9).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 3, -1, 7000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(10).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(1).equals(
				tripsDetailsFromDashboard.get(11).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue(trips.get(2).equals(
				tripsDetailsFromDashboard.get(12).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(10)
				.findElement(getObject("Reward_Program_Trips_CouponStatus")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(11)
				.findElement(getObject("Reward_Program_Trips_CouponStatus")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(12)
				.findElement(getObject("Reward_Program_Trips_CouponStatus")).getText()));

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "hotel", "", 1, -1, 5000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		Thread.sleep(40000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(13).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(7).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(8).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(9).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(10).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(11).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(12).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Sent".equals(tripsDetailsFromDashboard.get(13).findElement(getObject("Reward_Program_Trips_CouponStatus"))
				.getText()));
		assertTrue("Resend".equals(driver.findElements(getObject("Reward_Program_Trips_CouponResendButton")).get(2).getText()));
		//System.out.println("Level 3 completed. Coupon sent.");
		Reporter.log("Level 3 completed. Coupon sent.");

		se = new StringEntity(createJsonReward(Username_HQ_Reward_qa2, userID_HQ_Reward_qa2, "air", "", 1, -1, 5000, -1,
				travellerC, "", "").toString());
		httppostBook.setEntity(se);
		response = httpclient.execute(httppostBook);
		entity = response.getEntity();
		responseString = EntityUtils.toString(entity, "UTF-8");
		trips = tripsFromResponse(responseString);

		Thread.sleep(40000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (!waitElement(driver, getObject("Reward_Program_ViewHistory"), 2)) {
			Reporter.log("Trips were not created. ERROR!");
			//System.out.println("Trips were not created. ERROR!");
			assertTrue("Failure!", false);
		}
		safeClick(driver, getObject("Reward_Program_ViewHistory"));
		Thread.sleep(1000);

		tripsDetailsFromDashboard = driver.findElementsByXPath("//*[@id='view_history']/table/tbody/tr");

		assertTrue(trips.get(0).equals(
				tripsDetailsFromDashboard.get(14).findElement(getObject("Reward_Program_Trips_TripId")).getText()));
		assertTrue("Not sent".equals(tripsDetailsFromDashboard.get(14)
				.findElement(getObject("Reward_Program_Trips_CouponStatus")).getText()));
		assertTrue("2nd round".equals(tripsDetailsFromDashboard.get(14)
				.findElement(getObject("Reward_Program_Trips_RoundStatus")).getText()));
		//System.out.println("Round 2 started.");
		Reporter.log("Round 2 started.");

		// '{"user":{"email":"cleartripautomation+500@gmail.com","user_id":14037312},"bookings":[{"product_type":"air","count":2,"amount":5000},{"product_type":"air","count":2,"amount":5000}]}'
		// coupon redemption hotel
		// {"user":{"email":"cleartripautomation+500@gmail.com","user_id":14037312},"bookings":[{"product_type":"hotel","count":1,"amount":5000}],"coupon":169272}
		// delete
		// {"user_id":14037312}
		// coupon redemption activity 169270
		// {"user":{"email":"cleartripautomation+500@gmail.com","user_id":14037312},"bookings":[{"product_type":"activity","count":1,"amount":5000}],"coupon":169270}

		httppostBook = new HttpPost("http://172.16.53.222:4567/delete_bookings");
		se = new StringEntity(Json.createObjectBuilder().add("user_id", "14037312").build().toString());
		httppostBook.setEntity(se);

		response = httpclient.execute(httppostBook);
		assertTrue("Deletion not happening. Error!", EntityUtils.toString(response.getEntity(), "UTF-8").equals("true"));

		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		assertTrue("Rounds present without any bookings. Failure!",
				!waitElement(driver, getObject("Reward_Program_RoundSelectDropdown"), 3));

		signOut(driver);
		Reporter.log("Test case " + this.getClass() + " passed successfully");
		//System.out.println("Test case " + this.getClass() + " passed successfully");

	}

	@AfterClass
	public void closeSelenium() throws Exception {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppostBook = new HttpPost("http://172.16.53.222:4567/delete_bookings");
		StringEntity se = new StringEntity(Json.createObjectBuilder().add("user_id", "14037312").build().toString());
		httppostBook.setEntity(se);
		httpclient.execute(httppostBook);
		
		// writeTripToFile(tripID);
		driver.close();
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void takeScreenshot(ITestResult _result) throws Exception {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppostBook = new HttpPost("http://172.16.53.222:4567/delete_bookings");
		StringEntity se = new StringEntity(Json.createObjectBuilder().add("user_id", "14037312").build().toString());
		httppostBook.setEntity(se);
		httpclient.execute(httppostBook);
		
		screenshot(_result, driver);
		driver.manage().deleteAllCookies();
	}
*/}
