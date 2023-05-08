// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  common;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WrapperMethod extends CommonUtil {
	// WebElement we=null;
	//	/public static Logger logger = Logger.getLogger(WrapperMethod.class);


	public static boolean isElementPresent(RemoteWebDriver driver, By by) throws Exception {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public boolean textPresent(RemoteWebDriver driver, String text, int Time) throws InterruptedException {
		boolean textprest = false;
		int second = 0;
		for (second = 0; second < Time; second++) {
			try {
				if ((driver.getPageSource().contains(text))) {
					textprest = true;
					break;
				}
			} catch (Exception ignore) {
			}
			Thread.sleep(1000);
		}
		return textprest;
	}

	public boolean textPresent_Log(RemoteWebDriver driver, String text, int Time) throws InterruptedException {
		boolean textprest = false;
		int second = 0;
		for (second = 0; second < Time; second++) {
			try {
				if ((driver.getPageSource().contains(text))) {
					textprest = true;
					break;
				}
			} catch (Exception ignore) {
			}
			Thread.sleep(1000);
		}
		if (!textprest) {
			addLog(text + ": text is not Present");
			Assert.assertTrue(false);
		}
		return textprest;
	}

	public boolean elementVisible(RemoteWebDriver driver, By by, int Time) throws Exception {
		boolean visible = false;
		boolean elementPresent;
		int second = 0;
		try {
			for (second = 0; second <= Time; second++) {
				elementPresent = isElementPresent(driver, by);
				if (elementPresent) {
					if (driver.findElement(by).isDisplayed()) {
						visible = true;
						break;
					}
				}
				Thread.sleep(1000);
			}
			if (!visible) {
				// addLog(by + " is not displayed in the page", true);
			}
			return visible;
		} catch (StaleElementReferenceException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public boolean elementPresent(RemoteWebDriver driver, By by) throws Exception {
		int Time = 30;
		boolean visible = false;
		for (int second = 0; second < Time; second++) {
			try {
				driver.findElement(by);
				visible = true;
				// return visible;
				break;
			} catch (NoSuchElementException e) {
			}
			Thread.sleep(1000);
		}
		if (!visible) {
			// addLog(by + " is not displayed in the page");
			assertTrue("Failure! Element not Visible!", false);
		}
		return visible;
	}

	public boolean elementPresent_log(RemoteWebDriver driver, By by, String Text, int Time) throws Exception {
		boolean visible = false;
		for (int second = 0; second < Time; second++) {
			try {
				driver.findElement(by).isDisplayed();
				visible = true;
				// return visible;
				break;
			} catch (NoSuchElementException e) {
			}
			Thread.sleep(1000);
		}
		if (!visible) {
			addLog(Text + " is not displayed in the page");
			assertTrue("Failure!", false);
		}
		addLog(Text + " is displayed in page");
		return visible;
	}


	public boolean elementPresent_Time(RemoteWebDriver driver, By by, int Time) throws Exception {
		boolean visible = false;
		for (int second = 0; second < Time; second++) {
			try {
				driver.findElement(by);
				visible = true;
				// return visible;
				break;

			} catch (Exception e) {

				Thread.sleep(1000);
			}
		}
		return visible;
	}


	public boolean elementNotVisible(RemoteWebDriver driver, By by, int Time) throws Exception {
		// return (!elementVisible(driver, by, Time));

		boolean NotVisible = true;
		boolean elementPresent;
		int second = 0;
		for (second = 0; second < Time; second++) {
			elementPresent = isElementPresent(driver, by);
			if (elementPresent) {
				if (driver.findElement(by).isDisplayed()) {
					NotVisible = false;
				} else {
					NotVisible = true;
					break;
				}
			}
			Thread.sleep(1000);
		}
		return NotVisible;
	}
	public void safeClick(RemoteWebDriver driver, By by) throws Exception {

		elementVisible(driver, by, 20);
		elementPresent(driver, by);
		WebElement we = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		we = wait.until(ExpectedConditions.elementToBeClickable(by));
		we = wait.until(ExpectedConditions.visibilityOf(we));
		if (isElementPresent(driver, by)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(we).click().build().perform();
		} /*else {
			 addLog("Element " + by + "is not displayed in " +
			 driver.getCurrentUrl());
		}*/
	}



	public void smartClick(RemoteWebDriver driver, By by) throws Exception {
		if (elementVisible(driver, by, 2)) {
			elementPresent(driver, by);
			WebElement we = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 2);

			we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			we = wait.until(ExpectedConditions.elementToBeClickable(by));
			we = wait.until(ExpectedConditions.visibilityOf(we));
			if (isElementPresent(driver, by)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(we).click().perform();
			}
		}
	}



	public void safeClickList(RemoteWebDriver driver, By by, String Text) throws Exception {
		elementVisible(driver, by, 5);
		boolean elementAvailable = false;
		List<WebElement> we = driver.findElements(by);
		for (WebElement WebEle : we) {
			String elementText = WebEle.getText();
			if (elementText.contains(Text)) {
				if (!WebEle.isDisplayed()) {
					Thread.sleep(1000);
				}

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0, 150)", "");
				elementAvailable = true;
				Thread.sleep(1000);
				WebEle.click();
				break;
			}
		}
		if (!elementAvailable) {
			System.out.println(Text + " : is not displayed in the List");
			addLog(Text + " : is not displayed in the List");
			Assert.assertTrue(false);
		}

	}



	public void safeType(RemoteWebDriver driver, By by, String text) throws Exception {
		elementPresent(driver, by);
		boolean element = isElementPresent(driver, by);
		WebElement we = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		we.clear();
		we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		if (element) {
			if (isElementPresent(driver, by)) {
				we.isDisplayed();
				Actions actions = new Actions(driver);
				actions.moveToElement(we).click().perform();
				we.clear();
				we.sendKeys(text);
			}
		} else {
			addLog("Element " + by + " is not displayed in " + driver.getCurrentUrl());
		}
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void smartType(RemoteWebDriver driver, By by, String text) throws Exception {
		if (elementPresent_Time(driver, by, 1)) {
			boolean element = isElementPresent(driver, by);
			WebElement we = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 1);
			we.clear();
			we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (element) {
				if (isElementPresent(driver, by)) {
					we.isDisplayed();
					Actions actions = new Actions(driver);
					actions.moveToElement(we).click().perform();
					we.clear();
					we.sendKeys(text);
				}
			} else {
				addLog("Element " + by + " is not displayed in " + driver.getCurrentUrl());
			}
			// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
	}

	public void safeSelect(RemoteWebDriver driver, By by, String text) throws Exception {
		elementPresent(driver, by);
		boolean element = isElementPresent(driver, by);
		WebElement we = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		if (element) {
			new Select(we).selectByVisibleText(text);
		} else {
			addLog("Element " + by + " or Text " + text + " is not displayed in " + driver.getCurrentUrl());
		}
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public String getURL(RemoteWebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getText(RemoteWebDriver driver, By by) throws Exception {
		elementVisible(driver, by, 5);
		elementPresent(driver, by);
		boolean element = isElementPresent(driver, by);
		if (element) {

			if(isAlertPresent(driver)) {
				driver.switchTo().alert().accept();
			}
			WebElement we = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 10);

			we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			String text = null;
			text = we.getText();
			return text;
		} else {
			addLog("Element " + by + " is not displayed in " + driver.getCurrentUrl());
			return null;
		}

	}

	public String getValue(RemoteWebDriver driver, By by) throws Exception {
		elementVisible(driver, by, 5);
		elementPresent(driver, by);
		boolean element = isElementPresent(driver, by);
		if (element) {

			if(isAlertPresent(driver)) {
				driver.switchTo().alert().accept();
			}
			WebElement we = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 10);

			we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			String text = null;
			text = we.getAttribute("value");
			return text;
		} else {
			addLog("Element " + by + " is not displayed in " + driver.getCurrentUrl());
			return null;
		}

	}

	public String getText1(RemoteWebDriver driver, By by) throws Exception {
		elementVisible(driver, by, 1);
		boolean element = isElementPresent(driver, by);
		if (element) {

			if(isAlertPresent(driver)) {
				driver.switchTo().alert().accept();
			}
			WebElement we = driver.findElement(by);
			WebDriverWait wait = new WebDriverWait(driver, 10);

			we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			String text = null;
			text = we.getText();
			return text;
		} else {
			addLog("Element " + by + " is not displayed in " + driver.getCurrentUrl());
			return null;
		}

	}


	public boolean isAlertPresent(RemoteWebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}




	public void scrollSmooth(RemoteWebDriver driver,final int y) {
		for (int i = 0; i < y; i++) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4)", "");
		}
	}


	@SuppressWarnings("unused")
	public void openNewTabAddCtWalletMoneyAndSwitchBackToMainPage(RemoteWebDriver driver, String email) throws InterruptedException {
		addLog("Opening new chrome tab...",true);
		Thread.sleep(2000);

		Object ob=(JavascriptExecutor) driver.executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		addLog("Switched to new chrome tab...",true);
		driver.switchTo().window(tabs.get(1)); //switches to new tab

		//  String urlToAddCTWallentMoney=dataFile.value("UrlToAddWalletMoney").replace("cleartripautomationsff@gmail.com", email);
		String urlToAddCTWallentMoney=dataFile.value("UrlToAddWalletMoney");
		//  addLog("Adding money into ctwallet for user : "+email,true);
		driver.get(urlToAddCTWallentMoney);
		addLog("Switching back to main chrome window...",true);
		driver.switchTo().window(tabs.get(0)); // switch back to main screen
		Thread.sleep(3000);
	}

}

