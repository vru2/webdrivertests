// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Random;

public class bus_Common_API {

    public RemoteWebDriver driver;

    public HashMap<String, Object> headersForms() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public HashMap<String, Object> headersForms_Search() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("app-agent", "123");
        headers.put("x-ct-source", "123");
        return headers;
    }

    public HashMap<String, Object> headersForms_UpdateTrip() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-CT-CLOSE-TRANSACTION", "true");
        headers.put("trip-version", "V2");
        return headers;
    }

    String url_Bus = "";

    String url_Coupon = "http://172.29.9.7:9001";

    String url_Bus_Trip = "http://172.29.8.215:9001";

    String url_QA2 = "http://qa2new.cleartrip.com";

    String url_EndPoint_Update_Trip = "/trips/Q221215615418/bus-bookings/update-booking";
    String url_EndPoint_Search = "/api/bus/v1/search?fromCity=6772&toCity=4292&journeyDate=2023-11-28";


    String url_EndPoint_AutoSuggest = "/api/bus/v1/auto-suggest/?value=ban";
    String url_EndPoint_Coupon_Active = "/offer/search?active=true";

    String payload_Update_Trip = "{\"bus_booking_infos\":[{\"seq_no\":1,\"pax_info_seq_no\":1}],\"bus_pricing_infos\":[{\"seq_no\":1,\"bus_cost_pricing_info\":{\"seq_no\":1,\"pricing_elements\":[]},\"pricing_elements\":[{\"amount\":20,\"category\":\"COUPON\",\"code\":\"TEST10\",\"label\":\"Coupon\"}]}]}";

    public Response busGet(String useCase, String busType1) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response resp;
        if (useCase.equalsIgnoreCase("Search")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_EndPoint_Search;
            headers = headersForms_Search();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponActive")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Active;
            //headers = headersForms_Search();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("autoSuggest")){
            RestAssured.baseURI = url_QA2;
            endpoint = url_EndPoint_AutoSuggest;
            headers = headersForms_Search();
            Reporter.log(url_QA2 + endpoint);
        }

        Reporter.log(url_Bus+endpoint);
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                get(endpoint);
        return resp;
    }

    public Response busPut(String useCase, String busType1) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms_UpdateTrip();
        Response request;
        if (useCase.equalsIgnoreCase("Update_Trip")) {
            endpoint = url_Bus_Trip+url_EndPoint_Update_Trip;
            params = payload_Update_Trip;
        }
        Reporter.log(endpoint);
        Reporter.log("Params :" + params);
        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                put(endpoint);
        return request;
    }


    public Response busPost(String busType, String busType1) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (busType.equalsIgnoreCase("")) {
            Random rand = new Random();
            endpoint = url_Bus;
            params = params;

        }

        Reporter.log(url_Bus);
        Reporter.log("Params :" + params);

        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                post(endpoint);
        return request;
    }

    public Response validation(String useCase, Response resp) {
        Reporter.log("Response body " + useCase + " : " + resp.body().asString());
        System.out.println("Response body " + useCase + " : " + resp.body().asString());
        int statusCode = resp.getStatusCode();
        Reporter.log("statusCode: " + statusCode);
        JsonPath jsonPathEvaluator = resp.jsonPath();
        if (useCase.equals("Update_Trip")) {
            String trip_ref= jsonPathEvaluator.getString("trip_ref");
            Reporter.log("trip_ref " +trip_ref);
            if(!trip_ref.equals("Q221215615418")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponActive")) {
            String code= jsonPathEvaluator.getString("code");
            Reporter.log("code " +code);
            if(!code.contains("UTMMONTUE20")) {
                Assert.assertTrue(false);
            }
            String validationFieldExtractor= jsonPathEvaluator.getString("offerValidationRuleGroups.offerValidationRules[0].validationFieldExtractor");
            Reporter.log("validationFieldExtractor " +validationFieldExtractor);
            if(!validationFieldExtractor.contains("BookingDateExtractor")) {
                Assert.assertTrue(false);
            }

        }
        else if (useCase.equals("Search")) {
            String totalAvailBuses= jsonPathEvaluator.getString("data.totalAvailBuses");
            Reporter.log("totalAvailBuses " +totalAvailBuses);
            if(!totalAvailBuses.contains("1")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("autoSuggest")) {
            String success= jsonPathEvaluator.getString("success");
            String suggestions= jsonPathEvaluator.getString("data.suggestions.cityName");
            Reporter.log("success " +success);
            if(!success.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!suggestions.contains("Bangalore")) {
                Assert.assertTrue(false);
            }
        }



        return resp;
    }
}
