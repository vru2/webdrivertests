
	package testScriptsMobileAirforMEPWA;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	import dataServices.MobileDataProvider;
import domainServices.Mobile;
	public class PWA_MobileWeb_MEAir_Intl_Coupon_Booking_SA extends Mobile {
			public RemoteWebDriver driver;
			private String baseUrl;
			String srpprice="";
			String paymentpage;
			boolean pgcheck=false;
		String pgfees;
		  @Test ( dataProviderClass = MobileDataProvider.class,dataProvider="MobileKW_INTL_RT_CP", groups={ "Smoke Test"})
		  public void pwa_MobileWeb_Air_Intl_Coupon(String FromCity, String ToCity, String From_Date, String To_Date, String Adults, String Childrens, String Infants, String Trip_Logger_Msg, String Carrier1, String Carrier2, String Carrier3,String couponcode) throws Exception {
			 System.out.println(baseUrl);
			 driver.get(common.value("pwaairurlSA"));
			// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			 if(elementVisible(driver,By.xpath("//div/h1[1][@class='Modal__heading']"),1)){
				
				 System.out.println("popup found");
				  driver.findElement(By.xpath("//div/a[@class='Modal__action']")).click();
				  System.out.println("slected english lang");
				  
			  }
			 
			 Reporter.log("PWA_MobileWeb_MEAir_Intl_Coupon_Booking_SA",true);
			 
		//	 mobileCom_SignIn(driver);
			 driver.get(baseUrl);
			 pwa_Air_Homepage(driver, FromCity, ToCity, From_Date, To_Date, Adults, Childrens,Infants,"");
			 pwa_MEAir_SRP(driver,"","all");
			 pwa_MEAir_ReviewItineraryCoupon(driver,couponcode);
			 pwa_MEAir_Unsigned_Bookstep2(driver,Adults,Childrens,Infants,"");
			
			pwa_MEAir_MakePayment(driver,"CREDITCARD","","");
			  }

		  @BeforeClass
		  public void setUp() throws Exception {
			driver=getMobileDriver(driver);
			baseUrl = common.value("pwaairurlSA");
		  }

		  @AfterMethod(alwaysRun = true)
		  public void afterMethod(ITestResult _result) throws Exception {
		  	afterMethod(driver, _result);
		  }
		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
			 // driver.quit();    
		  }






		}













