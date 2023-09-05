package test.java.bus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Random;

public class API_Bus_Common {

    // need to add bus api details

    public RemoteWebDriver driver;

    public HashMap<String, Object> headersForms() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    String url_Bus = "";

    String url_Search = "";

    String params = "";

    public Response busGet(String busType, String busType1) {
        RestAssured.baseURI = url_Bus;
        String url = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (busType.equalsIgnoreCase("")) {
            RestAssured.baseURI = url_Bus;
            url = url_Search;
            Reporter.log(url_Bus + url);
        }
        Reporter.log(url);
        request = RestAssured.get(url);
        return request;
    }

    public Response busPut(String busType, String busType1) {
        RestAssured.baseURI = url_Bus;
        String url = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (busType.equalsIgnoreCase("")) {
            url = url_Bus;
            params = params;
        }

        Reporter.log(url_Bus);
        Reporter.log("Params :" + params);

        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                put(url);
        return request;

    }


    public Response busPost(String busType, String busType1) {
        RestAssured.baseURI = url_Bus;
        String url = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (busType.equalsIgnoreCase("")) {
            Random rand = new Random();

            url = url_Bus;
            params = params ;

        }

        Reporter.log(url_Bus);
        Reporter.log("Params :" + params);

        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                post(url);
        return request;

    }
}