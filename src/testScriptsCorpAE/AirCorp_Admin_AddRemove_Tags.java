package testScriptsCorpAE;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import domainServices.Corporate;

public class AirCorp_Admin_AddRemove_Tags extends Corporate {
	public RemoteWebDriver driver;
	boolean flightCountFailure = true;
	String domain = "com";

	@BeforeClass
	public void setUp() throws Exception {
		driver = (RemoteWebDriver) Firefox_Config(driver);
		//driver = (RemoteWebDriver) getDriverFF(driver);		
		//driver=(RemoteWebDriver) getDriver(driver);
		baseUrl = getBaseUrl(domain);
	}
	
	 @DataProvider(name = "traveller_details")
	    public Object [ ][ ] traveller_details() {
	        return new Object [ ] [ ] { { "Autotest"+System.currentTimeMillis(),"Automation" } };
	    }
	 
	 @Test(dataProvider = "traveller_details")
	 public void Corp_Add_Tags(String tagname, String tagdesc) throws Exception {
		driver.get(Corp_AE_Url());
		corp_SignIn(driver);
		textPresent(driver, "Fly anywhere. Fly everywhere.", 5);
		safeClick(driver, getObject("AirCorpCom_HomePage_Travellers_Tab"));
		elementVisible(driver, getObject("AirCorpCom_Traveller_Add_Traveller_Button"), 30);
		
		Thread.sleep(1000);
		safeClick(driver, getObject("AirCorpCom_CompanySettings_Link"));
		textPresent(driver, "Account details & settings", 5);
			
		Thread.sleep(1000);
		safeClick(driver, getObject("AirCorpCom_CompanySettings_Tags"));
		elementVisible(driver, getObject("AirCorpCom_CompanySettings_Tags_Addtag"), 20);
		Thread.sleep(1000);
		
		
		 driver.findElement(By.cssSelector("img.button")).click();
		 Thread.sleep(3000);
		 
		 
		 //   driver.findElement(By.name("tagName")).clear();
/*		    driver.findElement(By.name("tagName")).sendKeys("Test"+System.currentTimeMillis());
		    driver.findElement(By.name("tagDescription")).clear();
		    driver.findElement(By.name("tagDescription")).sendKeys("Automation");
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		    */
		 
		 safeType(driver, By.xpath("//input[3]"), "test+System.currentTimeMillis");
		 safeType(driver, By.xpath("//input[4]"), "test");
		 safeClick(driver, By.xpath("//input[5]"));
		 elementVisible(driver, getObject("AirCorpCom_CompanySettings_Delete"), 20);
		   
		   if (elementPresent(driver, getObject("AirCorpCom_CompanySettings_Delete"))){
			  Reporter.log("Tag added successfully");
			       
		   }else{
			   Reporter.log("Tag Not added successfully");
			   
		   }
		
	}
	 
	 @Test(alwaysRun = true, dependsOnMethods = { "Corp_Add_Tags" })
	 public void Corp_Remove_Tags() throws Exception {
	    	
	    	Reporter.log("Started Corp_Remove_Tags");
	    	
		 	Thread.sleep(2000);
		    safeClick(driver, getObject("AirCorpCom_CompanySettings_Delete"));
		    Thread.sleep(1000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(2000);
		    elementNotVisible(driver, getObject("AirCorpCom_CompanySettings_Delete"), 10);
		  
		    Reporter.log("Tag Deleted successfully");
		  
	    	
	    	
	    }
	 
	@AfterMethod(alwaysRun = true)	
	public void takeScreenshot(ITestResult _result) throws Exception {
		screenshot(_result, driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		browserClose(driver);
	}
}
 


