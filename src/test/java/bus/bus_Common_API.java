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

    public HashMap<String, Object> SelfCare_GetTripInfo() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("app-agent", "PWA");
        headers.put("x-ct-source", "MOBILE");
        headers.put("user-agent", "Chrome");
        headers.put("Cookie", "ct-auth = ncQX8HBir/yltoTHe7qrgbUJ1T9jAOy1EvcBd6FaFuLInX5RLPqffpexfkF3rZyZvdb22kmKGrhj2VAI20AltmsyCOKbufFIzgps5dmd9XM/dyo3uhimugoUQdKxicgjrYLG5r0EF4a6dKt8TrXMc5vXfXLYcJDnhUuM80Ho91Mn8LwEM2zpT8wjlKDpAUL+v4vpnustaZV7GqGZKryR3g==");
        return headers;
    }

    public HashMap<String, Object> headersForms_UpdateTrip() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-CT-CLOSE-TRANSACTION", "true");
        headers.put("trip-version", "V2");
        return headers;
    }

    public HashMap<String, Object> headersForms_Cancel_Trip_Status() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-ct-source", "PULSE");
        return headers;
    }

    public HashMap<String, Object> headersForms_Bus_Booking() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-ct-source", "MOBILE");
        headers.put("app-agent", "MOBILE");
        return headers;
    }
    String url_Bus = "http://bus-api.cltp.com:9001";

    String url_Coupon = "http://172.29.9.7:9001";

    String url_Bus_Trip = "http://172.29.8.215:9001";

    String url_Bus_PostBook = "http://bus-post-book.cltp.com:9001";

    String url_QA2 = "https://qa2new.cleartrip.com";

    String url_EndPoint_Update_Trip = "/trips/Q221215615418/bus-bookings/update-booking";
    String url_EndPoint_Search = "/api/bus/v1/search?fromCity=4292&toCity=4562&journeyDate=2023-10-29";
    String url_SelfCare_GetTripInfo = "/api/bus/v1/self-care/get-trip-info?tripId=Q231007798824";
    String url_SelfCare_CancelationInfo = "/api/bus/v1/self-care/cancel-info?tripId=Q231007798824";

    String url_SelfCare_CancelBooking = "/api/bus/v1/self/cancel/Q231007798824";
    String url_SelfCare_Download_eTicket = "/api/bus/v1/download-eTicket/Q231007798824";

    String url_SelfCare_TripDetails_Email = "/api/bus/v1/trip-details-email/Q231007798824?emailld=kiran.kumar@cleartrip.com";

    String url_Endpoint_Cancelation_Eligibility = "/bus/hq/v2/refund-info/Q230911782400?reason=CR01";

    String url_Endpoint_Cancel_Trip_Status = "/bus/hq/v2/cancel/Q230911782400?reason=CR04";
    String url_Endpoint_Cancel_Booking = "/api/bus/v1/self/cancel/Q231007798824";
    String url_Endpoint_Update_Traveller = "/api/bus/v1/itin/travellers";

    String url_EndPoint_AutoSuggest = "/api/bus/v1/auto-suggest/?value=ban";
    String url_EndPoint_Coupon_Active = "/offer/search?active=true";

    String url_EndPoint_Coupon_Activate = "/offer/activate/237";
    String url_EndPoint_Coupon_Deactivate = "/offer/deactivate/237";

    String payload_Update_Trip = "{\"bus_booking_infos\":[{\"seq_no\":1,\"pax_info_seq_no\":1}],\"bus_pricing_infos\":[{\"seq_no\":1,\"bus_cost_pricing_info\":{\"seq_no\":1,\"pricing_elements\":[]},\"pricing_elements\":[{\"amount\":20,\"category\":\"COUPON\",\"code\":\"TEST10\",\"label\":\"Coupon\"}]}]}";
    String payload_Canceled_Trip_Status = "{\"note\":\"string\",\"subject\":\"string\",\"trip_id\":0,\"user_id\":0}";
    String payload_Cancel_Booking =  "{\"reason\":\"CR01\"}";


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
        if (useCase.equalsIgnoreCase("CancellationInfo")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_SelfCare_CancelationInfo;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("Download_eTicket")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_Download_eTicket;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("GetTripDetails_Email")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_TripDetails_Email;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }

        if (useCase.equalsIgnoreCase("GetTripInfo")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_GetTripInfo;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponActive")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Active;
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponActivate")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Activate;
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponDeactivate")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Deactivate;
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
        if (useCase.equalsIgnoreCase("Trip_Status")) {
            endpoint = url_Bus_PostBook+url_Endpoint_Cancel_Trip_Status;
            params = payload_Canceled_Trip_Status;
            headers = headersForms_Cancel_Trip_Status();
        }
        if (useCase.equalsIgnoreCase("Cancel_booking")) {
            endpoint = url_Bus+url_Endpoint_Cancel_Booking;
            params = payload_Cancel_Booking;
            headers = SelfCare_GetTripInfo();
        }
        if (useCase.equalsIgnoreCase("UpdateTraveller")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_QA2+url_Endpoint_Update_Traveller;
            params = busType1;
            headers = headersForms_Bus_Booking();
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
        if (busType.equalsIgnoreCase("Cancellation_Eligibility")) {
            endpoint = url_Bus_PostBook+url_Endpoint_Cancelation_Eligibility;
            params = payload_Canceled_Trip_Status;
            headers = headersForms_Cancel_Trip_Status();
        }
        if (busType.equalsIgnoreCase("Chart")) {
            endpoint = "https://qa2new.cleartrip.com/api/bus/v1/chart";
            params = busType1;
            headers = headersForms_Bus_Booking();
        }
        if (busType.equalsIgnoreCase("Itinerary")) {
            endpoint = "https://qa2new.cleartrip.com/api/bus/v1/itin";
            params = busType1;
            headers = headersForms_Bus_Booking();
        }
        if (busType.equalsIgnoreCase("PreBook")) {
            endpoint = "http://bus-book.cltp.com:9001/bus/v1/preBook?itineraryId="+busType1;
            params = "";
            headers = headersForms_Bus_Booking();
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
        if(!(useCase.equals("Cancel_booking"))) {
            if (statusCode != 200) {
                Assert.assertTrue(false);
            }
        }
        if (useCase.equals("Update_Trip")) {
            String trip_ref= jsonPathEvaluator.getString("trip_ref");
            Reporter.log("trip_ref " +trip_ref);
            if(!trip_ref.equals("Q221215615418")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("GetTripInfo")) {
            String bookingConfirmed= jsonPathEvaluator.getString("bookingConfirmed");
            Reporter.log("bookingConfirmed " +bookingConfirmed);
            if(!bookingConfirmed.equals("false")) {
                Assert.assertTrue(false);
            }

        }
        else  if (useCase.equals("CancellationInfo")) {
            String cancellationApplicable= jsonPathEvaluator.getString("cancellationApplicable");
            Reporter.log("cancellationApplicable " +cancellationApplicable);
            if(!cancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("GetTripDetails_Email")) {
          /*  String cancellationApplicable= jsonPathEvaluator.getString("cancellationApplicable");
            Reporter.log("cancellationApplicable " +cancellationApplicable);
            if(!cancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }*/
        }
        else  if (useCase.equals("Cancel_booking")) {
            String success= jsonPathEvaluator.getString("success");
            String message= jsonPathEvaluator.getString("error.message");
            Reporter.log("message " +message);
            if(!success.equals("false")) {
                Assert.assertTrue(false);
            }
            if(!message.equals("Something went wrong")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("Cancellation_Eligibility")) {
            String isCancellationApplicable= jsonPathEvaluator.getString("isCancellationApplicable");
            Reporter.log("isCancellationApplicable " +isCancellationApplicable);
            if(!isCancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("Trip_Status")) {
            String cancellationProcessed= jsonPathEvaluator.getString("cancellationProcessed");
            String refundAmount= jsonPathEvaluator.getString("refundAmount");
            Reporter.log("cancellationProcessed " +cancellationProcessed);
            if(!cancellationProcessed.equals("true")) {
                Assert.assertTrue(false);
            }
            if(!refundAmount.equals("12")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponActive")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String validationFieldExtractor= jsonPathEvaluator.getString("offerValidationRuleGroups.offerValidationRules[0].validationFieldExtractor");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("UTMMONTUE20")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!validationFieldExtractor.contains("BookingDateExtractor")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponActivate")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String type= jsonPathEvaluator.getString("type");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("CTCHANNEL")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!type.contains("PERCENTAGE_DISCOUNT")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponDeactivate")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String type= jsonPathEvaluator.getString("type");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("CTCHANNEL")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("false")) {
                Assert.assertTrue(false);
            }
            if(!type.contains("PERCENTAGE_DISCOUNT")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("Search")) {
            String totalAvailBuses= jsonPathEvaluator.getString("data.totalAvailBuses");
            Reporter.log("totalAvailBuses " +totalAvailBuses);
            if(!totalAvailBuses.contains("5")) {
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