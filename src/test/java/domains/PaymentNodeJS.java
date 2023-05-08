// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  domains;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import test.java.paymentsAPI.API_PaymentCommon1;

public class PaymentNodeJS extends API_PaymentCommon1{

	public Response resp;

	public String fetchPaymentURL(Response resp){
		String payurl="";
		JsonPath jsonPathEvaluator = resp.jsonPath();
		payurl = jsonPathEvaluator.getString("payment_url");
		Reporter.log("http://qa2.cleartrip.com"+payurl);
		return payurl;

	}

	public void click(RemoteWebDriver driver,String xpath) throws InterruptedException{
		driver.findElement(By.xpath(xpath)).click();
	}
}