package test.java.couponsanity;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.Reporter;
import test.java.domains.PlatformCommonUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class Coupon_Common extends PlatformCommonUtil {

    public Response resp;
    public String criteria_id;

    public int criteriaid1;

    public int draft_ruleid;

    String criteriaid = "1222";
    public String TCMS_CATALOG_ENDPOINT = "http://sniper-catalog-api.cltp.com:9001";
    public String TCMS_CRITERIA_ENDPOINT = "http://sniper-manager-service-api.cltp.com:9001";
    public String TCMS_VIEW_CATALOG_MODULE_ENDPOINT = "http://sniper-view-module.cltp.com:9001";

    public String TCMS_SERVING_ENDPOINT = "http://sniper-serving.cltp.com:9001";
    public String INTENT_SERVING = "http://intent-serving-api.cltp.com:9001";

    public String INTENT_CAPTURE="http://intent-capture-service.cltp.com:9001";

    public String GODFATHER="https://godfather-qa.cleartripcorp.com";

    String tcms_get_catalog = "/catalogs/SUPPLY-CRITERIA-AIR";
    String tcms_create_criteria = "/criteria";
    String tcms_update_criteria = "/criteria/" + criteriaid;
    String tcms_fetch_criteria_id = "/criteria/" + criteriaid;
    String tcms_fetch_view_catalog_criteria_byid = "/tcms/manager/api/catalogs/criteria/" + criteriaid;
    String tcms_activate_api = "/criteria/activate/" + criteriaid;
    String tcms_deactivate_api = "/criteria/deactivate/" + criteriaid;

    String tcms_serving_get_tc = "/sniperServing/targetCriteria";
    String tcms_serving_get_tc_from_source = "/sniperServing/targetCriteria/source";
    String intent_serving_get_coupon_srp = "/intent/v2/get-coupons?label=CT_AIR_OFFER&step=SRP";
    String intent_serving_get_coupon_itinerary = "/intent/v2/get-coupons?label=CT_AIR_OFFER&step=ITINERARY";
    String intent_serving_get_coupon_payment = "/intent/v2/get-coupons?label=CT_AIR_OFFER&step=PAYMENT";

    String intent_serving_validate_coupon_srp = "/intent/v2/validate-coupon?label=CT_AIR_OFFER&step=SRP";
    String intent_serving_validate_coupon_itinerary = "/intent/v2/validate-coupon?label=CT_AIR_OFFER&step=ITINERARY";
    String intent_serving_validate_coupon_payment = "/intent/v2/validate-coupon?label=CT_AIR_OFFER&step=PAYMENT";

    String intent_serving_get_coupontray_coupons="/intent/get-coupons-tray?label=CT_AIR_OFFER&step=COUPON_TRAY";

    String intent_capture_create_draftrule="/intent-capture/rule/draft";


    String tcms_create_supply_criteria="/tcms/manager/api/criteria";
    public HashMap<String, Object> headersForpostcall() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIwZTZlODJlYS0wNjljLTRiZDUtOTE4NC1jYjRmMTM2YzkyZjIiLCJ1c2VyQ2xhaW0iOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6InNoYXNoaWthbnRoLmdAY2xlYXJ0cmlwLmNvbSIsInRlYW1JZHMiOlsyLDFdLCJhdXRob3JpdGllcyI6W119LCJpc3MiOiJDVCIsImlhdCI6MTY3NDQ1NTQwOX0.WgDH1A163eopxh7LKbj3v7-2MyEg8S6uw-OAIcXEZhALDSPbQ39g0qQ_YpA_okypJryVs7L999BHZ05PV7hcZkjtWYn9SF1E9oOtmAdZwU-FC4ptA_GOW8Dt2ud-P8lHlZpOn9TOYz8l4_ZwubH912Bu47GZyYVOTkfNRYJPEZMpXDqAQeNDId_S2Po1TEFMIb7miHQ9o6dWM5dZ0YIbLgBR_Q7SpCKtTchCkXrp3liOhqXQp_F3BtmnXJsynSEnHDi0oeLEXJCtKRmmA_fitYizXNEtGmzrIEE0Fbn_Gtkrr5_h0BZIs_lLR-YnAhKnMjnz8IH4oZIy36f-wtVLeA");
        return headers;

    }

    public HashMap<String, Object> headersForPatchcall() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIwZTZlODJlYS0wNjljLTRiZDUtOTE4NC1jYjRmMTM2YzkyZjIiLCJ1c2VyQ2xhaW0iOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6InNoYXNoaWthbnRoLmdAY2xlYXJ0cmlwLmNvbSIsInRlYW1JZHMiOlsyLDFdLCJhdXRob3JpdGllcyI6W119LCJpc3MiOiJDVCIsImlhdCI6MTY3NDQ1NTQwOX0.WgDH1A163eopxh7LKbj3v7-2MyEg8S6uw-OAIcXEZhALDSPbQ39g0qQ_YpA_okypJryVs7L999BHZ05PV7hcZkjtWYn9SF1E9oOtmAdZwU-FC4ptA_GOW8Dt2ud-P8lHlZpOn9TOYz8l4_ZwubH912Bu47GZyYVOTkfNRYJPEZMpXDqAQeNDId_S2Po1TEFMIb7miHQ9o6dWM5dZ0YIbLgBR_Q7SpCKtTchCkXrp3liOhqXQp_F3BtmnXJsynSEnHDi0oeLEXJCtKRmmA_fitYizXNEtGmzrIEE0Fbn_Gtkrr5_h0BZIs_lLR-YnAhKnMjnz8IH4oZIy36f-wtVLeA");
        return headers;
    }

    public HashMap<String, Object> headersForpost() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;

    }

    public HashMap<String, Object> headersForpostIS() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("clientId", "df5e5756e");
        return headers;

    }

    public HashMap<String, Object> headersForpostISvalidate() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("clientId", "r546743");
        return headers;

    }

    public Response TCMS_Create_PostCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                post(url);
        return resp;
    }

    public Response TCMS_Update_PutCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                put(url);
        return resp;
    }

    public Response TCMS_Clone_PostCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                queryParam("sourceId", criteriaid).
                headers(headers).
                post(url);
        return resp;
    }

    public Response TCMS_Activate_PutCall(HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                put(url);
        return resp;
    }

    public Response TCMS_Deactivate_PatchCall(HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                patch(url);
        return resp;
    }

    public Response TCMS_Serving_POSTCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                post(url);
        return resp;
    }

    public Response INTENT_Serving_POSTCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                post(url);
        return resp;
    }

    public Response INTENT_Capture_POSTCall(String params, HashMap<String, Object> headers, String url) {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                post(url);
        return resp;
    }

    public Response validatefecth_catalogue(Response resp) {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "successfully fetched catalog for catalogId : SUPPLY-CRITERIA-AIR", "String matches");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Validate_Create_Criteria(Response resp) throws SQLException, ClassNotFoundException {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            criteria_id = jsonPath.getString("response.id");
            String status = jsonPath.getString("response.status");
            System.out.println("Supply Criteria with ID: " + criteria_id + " and Status: " + status);
            Reporter.log("Supply Criteria with ID: " + criteria_id + " and Status: " + status);
            Assert.assertEquals(message, "Criteria creation successful for Id: " + criteria_id, "String matches");
            //DB Validation
            ArrayList<String> supplycriteria = db_criteria(criteria_id);
            String supply_criteria_id = supplycriteria.get(0);
            String supply_criteria_status = supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id, criteria_id, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, status, "Database record exists for the created id");
            System.out.println("Database record exists for the created id");
            Reporter.log("Database record exists for the created id");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Validate_Update_Criteria(Response resp) throws SQLException, ClassNotFoundException {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            criteria_id = jsonPath.getString("response.id");
            String status = jsonPath.getString("response.status");
            System.out.println("Supply Criteria with ID: " + criteria_id + " and Status: " + status);
            Reporter.log("Supply Criteria with ID: " + criteria_id + " and Status: " + status);
            Assert.assertEquals(message, "Criteria Updated Successfully for Id: " + criteria_id + " ", "String matches");
            //DB Validation
            ArrayList<String> supplycriteria = db_criteria(criteria_id);
            String supply_criteria_id = supplycriteria.get(0);
            String supply_criteria_status = supplycriteria.get(6);

            Assert.assertEquals(supply_criteria_id, criteria_id, "Database record updated for the id");
            Assert.assertEquals(supply_criteria_status, status, "Database record updated for the id");
            System.out.println("Database record updated for the id");
            Reporter.log("Database record updated for the  id");
            db_update_criteria(criteria_id);
            ArrayList criteria_details = db_criteria(criteria_id);
            String criteria_json = (String) criteria_details.get(9);
            System.out.println(criteria_json);
            Reporter.log(criteria_json);
            System.out.println("Updated value resetted in DB");
            Reporter.log("Updated value resetted in DB");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Fetch_Selectioncriteriaid(Response resp) {
        if (resp.statusCode() == 200) {
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            Reporter.log("Status code " + resp.statusCode());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String response = jsonPath.getString("response");
            String rulesid = jsonPath.getString("response.id");
            System.out.println(response);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(rulesid, criteriaid, "ruleid fetched matches with the given ruleid");
            System.out.println("Ruleid:" + rulesid + " fetched matches with the given Ruleid:" + criteriaid);
            Reporter.log("Ruleid:" + rulesid + " fetched matches with the given Ruleid:" + criteriaid);
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Fetch_Viewcatalogcriteriabyid(Response resp) {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String response = jsonPath.getString("response");
            String rulesid = jsonPath.getString("response.displayAttributes");
            String children = jsonPath.getString("response.children");
            System.out.println("Response of response object: " + response);
            Reporter.log("Response of response object: " + response);
            System.out.println("Response of children object in response: " + children);
            Reporter.log("Response of children object in response: " + children);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertNotNull("response.children");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Clonecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            String id = jsonPath.getString("response.id");
            String status = jsonPath.getString("response.status");
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "Criteria cloned successfully for Id: " + criteriaid, "String matches");
            System.out.println("Successfully cloned RuleID: " + criteriaid + " to RuleID: " + id + " with Status: " + status);
            Reporter.log("Successfully cloned RuleID: " + criteriaid + " to RuleID: " + id + " with Status: " + status);
            //db validation
            ArrayList<String> supplycriteria = db_criteria(id);
            String supply_criteria_id = supplycriteria.get(0);
            String supply_criteria_status = supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id, id, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, status, "Database record exists for the created id");
            System.out.println("Database record exists for the created id");
            Reporter.log("Database record exists for the created id");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    //Activate CRITERIA

    public Response activatecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            String id = jsonPath.getString("response.id");
            String status = jsonPath.getString("response.status");
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "criteria status changed to active successfully for Id: " + criteriaid, "String matches");
            System.out.println("Successfully activated RuleID: " + criteriaid + " with Status: " + status);
            Reporter.log("Successfully activated RuleID: " + criteriaid + " with Status: " + status);
            //db validation
            ArrayList<String> supplycriteria = db_criteria(id);
            String supply_criteria_id = supplycriteria.get(0);
            String supply_criteria_status = supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id, id, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, status, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, "ACTIVE", "DB Status is ACTIVE");
            System.out.println("Status of the criteria is changed to ACTIVE");
            Reporter.log("Status of the criteria is changed to ACTIVE");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    //DEACTIVATE CRITERIA
    public Response deactivatecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if (resp.statusCode() == 200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            String id = jsonPath.getString("response.id");
            String status = jsonPath.getString("response.status");
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "criteria status changed to inactive successfully for Id: " + criteriaid + " ", "String matches");
            System.out.println("Successfully inactivated RuleID: " + criteriaid + " with Status: " + status);
            Reporter.log("Successfully inactivated RuleID: " + criteriaid + " with Status: " + status);
            //db validation
            ArrayList<String> supplycriteria = db_criteria(id);
            String supply_criteria_id = supplycriteria.get(0);
            String supply_criteria_status = supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id, id, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, status, "Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status, "INACTIVE", "DB Status is ACTIVE");
            System.out.println("Status of the criteria is changed to INACTIVE");
            Reporter.log("Status of the criteria is changed to INACTIVE");
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Fetch_Criteriaid(Response resp, String value) {
        if (resp.statusCode() == 200) {
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            Reporter.log("Status code " + resp.statusCode());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("response");
            System.out.println(message);
            if ((value == "redis") || (value == "solr")) {
                Assert.assertEquals(message.contains("1904"), true, "Response contains solution with target criteria id 1904");
                System.out.println("Response contains solution with target critreia id 1904");
                Reporter.log("Response contains solution with target critreia id 1904");
                Assert.assertEquals(bodyAsString.contains("solutions"), true, "Response body contains solutions");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response body contains id");
                Assert.assertEquals(bodyAsString.contains("targetCriteria"), true, "Response body contains targetCriteria");
            }
            if ((value == "without_tag_with_qosTier_Primary")) {
                Assert.assertEquals(message.contains("2021"), true, "Response contains solution with target criteria id 2021");
                System.out.println("Response contains solution with target critreia id 2021");
                Reporter.log("Response contains solution with target critreia id 2021");
                Assert.assertEquals(bodyAsString.contains("solutions"), true, "Response body contains solutions");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response body contains id");
                Assert.assertEquals(bodyAsString.contains("targetCriteria"), true, "Response body contains targetCriteria");

            }
            if ((value == "with_tag_with_qosTier_Secondary")) {
                Assert.assertEquals(message.contains("1643"), true, "Response contains solution with target criteria id 1643");
                System.out.println("Response contains solution with target critreia id 1643");
                Reporter.log("Response contains solution with target critreia id 1643");
                Assert.assertEquals(message.contains("DEL_BOM_G8-336|BOM_BLR_G8-338"), true, "Response contains solution id DEL_BOM_G8-336|BOM_BLR_G8-338");
                System.out.println("Response contains solution id DEL_BOM_G8-336|BOM_BLR_G8-338");
                Reporter.log("Response contains solution id DEL_BOM_G8-336|BOM_BLR_G8-338");
                Assert.assertEquals(bodyAsString.contains("solutions"), true, "Response body contains solutions");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response body contains id");
                Assert.assertEquals(bodyAsString.contains("targetCriteria"), true, "Response body contains targetCriteria");

            }
        } else {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: " + resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response get_coupon_validation(Response resp, String type, String value) {
        if (resp.statusCode() == 200) {
            if (Objects.equals(type, "one_way")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
                Assert.assertEquals(bodyAsString.contains("BLR_DEL_I5-741"), true, "Response contains solution id BLR_DEL_I5-741");
                System.out.println("Response contains solution id BLR_DEL_I5-741");
                Reporter.log("Response contains solution id BLR_DEL_I5-741");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193");
                Assert.assertEquals(message.contains("CTRBD"), true, "Response contains CouponCode CTRBD");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹440 off with CTRBD"), true, "Response contains Couponmessage Save ₹440 off with CTRBD");
                    System.out.println("Response contains Couponmessage Save ₹440 off with CTRBD");
                    Reporter.log("Response contains Couponmessage Save ₹440 off with CTRBD");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹440 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹440 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹440 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹440 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("id"), true, "Response contains rule id");
                System.out.println("Response contains rule id");
                Reporter.log("Response contains rule id");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("440.4"), true, "Response contains discountAmount 440.4");
                System.out.println("Response contains discountAmount 440.4");
                Reporter.log("Response contains discountAmount 440.4");
                Assert.assertEquals(message.contains("5123.6"), true, "Response contains discountedTotalFare 5123.6");
                System.out.println("Response contains discountedTotalFare 5123.6");
                Reporter.log("Response contains discountedTotalFare 5123.6");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("440.4"), true, "Response contains discountAmount 440.4");
                System.out.println("Response contains discountAmount 440.4");
                Reporter.log("Response contains discountAmount 440.4");
                Assert.assertEquals(message.contains("5123.6"), true, "Response contains discountedTotalFare 5123.6");
                System.out.println("Response contains discountedTotalFare 5123.6");
                Reporter.log("Response contains discountedTotalFare 5123.6");
            }
            if (Objects.equals(type, "round_trip")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
                //Solution1
                Assert.assertEquals(bodyAsString.contains("BOM_GAU_SG-756|GAU_DEL_SG-756|DEL_BOM_SG-776"), true, "Response contains solution id BOM_GAU_SG-756|GAU_DEL_SG-756|DEL_BOM_SG-776");
                System.out.println("Response contains solution id BOM_GAU_SG-756|GAU_DEL_SG-756|DEL_BOM_SG-776");
                Reporter.log("Response contains solution id BOM_GAU_SG-756|GAU_DEL_SG-756|DEL_BOM_SG-776");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193");
                Assert.assertEquals(message.contains("CTRBD"), true, "Response contains CouponCode CTRBD");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹7000 off with CTRBD"), true, "Response contains Couponmessage Save ₹7000 off with CTRBD");
                    System.out.println("Response contains Couponmessage Save ₹7000 off with CTRBD");
                    Reporter.log("Response contains Couponmessage Save ₹7000 off with CTRBD");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹7000 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹7000 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹7000 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹7000 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("id"), true, "Response contains rule id ");
                System.out.println("Response contains rule id ");
                Reporter.log("Response contains rule id ");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("7000.0"), true, "Response contains discountAmount 7000.0");
                System.out.println("Response contains discountAmount 7000.0");
                Reporter.log("Response contains discountAmount 7000.0");
                Assert.assertEquals(message.contains("70000.0"), true, "Response contains discountedTotalFare 70000.0");
                System.out.println("Response contains discountedTotalFare 70000.0");
                Reporter.log("Response contains discountedTotalFare 70000.0");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("CHD"), true, "Response body contains CHD");
                System.out.println("Response body contains CHD");
                Reporter.log("Response body contains CHD");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("20000.0"), true, "Response contains discountedTotalFare 20000.0");
                System.out.println("Response contains discountedTotalFare 20000.0");
                Reporter.log("Response contains discountedTotalFare 20000.0");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4000.0"), true, "Response contains discountAmount 4000.0");
                System.out.println("Response contains discountAmount 4000.0");
                Reporter.log("Response contains discountAmount 4000.0");
                Assert.assertEquals(message.contains("40000.0"), true, "Response contains discountedTotalFare 40000.0");
                System.out.println("Response contains discountedTotalFare 40000.0");
                Reporter.log("Response contains discountedTotalFare 40000.0");
                Assert.assertEquals(bodyAsString.contains("INF"), true, "Response body contains INF");
                System.out.println("Response body contains INF");
                Reporter.log("Response body contains INF");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("1000.0"), true, "Response contains discountAmount 1000.0");
                System.out.println("Response contains discountAmount 1000.0");
                Reporter.log("Response contains discountAmount 1000.0");
                Assert.assertEquals(message.contains("10000.0"), true, "Response contains discountedTotalFare 10000.0");
                System.out.println("Response contains discountedTotalFare 10000.0");
                Reporter.log("Response contains discountedTotalFare 10000.0");

                //Solution2
                Assert.assertEquals(bodyAsString.contains("BOM_CCU_6E-256|CCU_GAU_6E-666|GAU_DEL_SG-756|DEL_BOM_SG-776"), true, "Response contains solution id BOM_CCU_6E-256|CCU_GAU_6E-666|GAU_DEL_SG-756|DEL_BOM_SG-776");
                System.out.println("Response contains solution id BOM_CCU_6E-256|CCU_GAU_6E-666|GAU_DEL_SG-756|DEL_BOM_SG-776");
                Reporter.log("Response contains solution id BOM_CCU_6E-256|CCU_GAU_6E-666|GAU_DEL_SG-756|DEL_BOM_SG-776");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193");
                Assert.assertEquals(message.contains("CTRBD"), true, "Response contains CouponCode CTRBD");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹6700 off with CTRBD"), true, "Response contains Couponmessage Save ₹6700 off with CTRBD");
                    System.out.println("Response contains Couponmessage Save ₹6700 off with CTRBD");
                    Reporter.log("Response contains Couponmessage Save ₹6700 off with CTRBD");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹6700 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹6700 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹6700 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹6700 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("id"), true, "Response contains rule id ");
                System.out.println("Response contains rule id ");
                Reporter.log("Response contains rule id ");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("6700.0"), true, "Response contains discountAmount 6700.0");
                System.out.println("Response contains discountAmount 6700.0");
                Reporter.log("Response contains discountAmount 6700.0");
                Assert.assertEquals(message.contains("67300.0"), true, "Response contains discountedTotalFare 67300.0");
                System.out.println("Response contains discountedTotalFare 67300.0");
                Reporter.log("Response contains discountedTotalFare 67300.0");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("CHD"), true, "Response body contains CHD");
                System.out.println("Response body contains CHD");
                Reporter.log("Response body contains CHD");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("1900.0"), true, "Response contains discountAmount 1900.0");
                System.out.println("Response contains discountAmount 1900.0");
                Reporter.log("Response contains discountAmount 1900.0");
                Assert.assertEquals(message.contains("19100.0"), true, "Response contains discountedTotalFare 19100.0");
                System.out.println("Response contains discountedTotalFare 19100.0");
                Reporter.log("Response contains discountedTotalFare 19100.0");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("3800.0"), true, "Response contains discountAmount 3800.0");
                System.out.println("Response contains discountAmount 3800.0");
                Reporter.log("Response contains discountAmount 3800.0");
                Assert.assertEquals(message.contains("38200.0"), true, "Response contains discountedTotalFare 38200.0");
                System.out.println("Response contains discountedTotalFare 38200.0");
                Reporter.log("Response contains discountedTotalFare 38200.0");
                Assert.assertEquals(bodyAsString.contains("INF"), true, "Response body contains INF");
                System.out.println("Response body contains INF");
                Reporter.log("Response body contains INF");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("1000.0"), true, "Response contains discountAmount 1000.0");
                System.out.println("Response contains discountAmount 1000.0");
                Reporter.log("Response contains discountAmount 1000.0");
                Assert.assertEquals(message.contains("10000.0"), true, "Response contains discountedTotalFare 10000.0");
                System.out.println("Response contains discountedTotalFare 10000.0");
                Reporter.log("Response contains discountedTotalFare 10000.0");
            }
        }
        return resp;
    }

    public Response validate_coupon_validation(Response resp, String type, String value) {
        if (resp.statusCode() == 200) {
            if (Objects.equals(type, "one_way")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
                Assert.assertEquals(bodyAsString.contains("BLR_HYD_I5-1576"), true, "Response contains solution id BLR_HYD_I5-1576");
                System.out.println("Response contains solution id BLR_HYD_I5-1576");
                Reporter.log("Response contains solution id BLR_HYD_I5-1576");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹251 off with APITEST"), true, "Response contains Couponmessage Save ₹251 off with APITEST");
                    System.out.println("Response contains Couponmessage Save ₹251 off with APITEST");
                    Reporter.log("Response contains Couponmessage Save ₹251 off with APITEST");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹251 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹251 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹251 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹251 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("251.1"), true, "Response contains discountAmount 251.1");
                System.out.println("Response contains discountAmount 251.1");
                Reporter.log("Response contains discountAmount 251.1");
                Assert.assertEquals(message.contains("2259.9"), true, "Response contains discountedTotalFare 2259.9");
                System.out.println("Response contains discountedTotalFare 2259.9");
                Reporter.log("Response contains discountedTotalFare 2259.9");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("251.1"), true, "Response contains discountAmount 251.1");
                System.out.println("Response contains discountAmount 251.1");
                Reporter.log("Response contains discountAmount 251.1");
                Assert.assertEquals(message.contains("2259.9"), true, "Response contains discountedTotalFare 2259.9");
                System.out.println("Response contains discountedTotalFare 2259.9");
                Reporter.log("Response contains discountedTotalFare 2259.9");
            }
            if (Objects.equals(type, "round_trip")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
                //Solution1
                Assert.assertEquals(bodyAsString.contains("BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563"), true, "Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                System.out.println("Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                Reporter.log("Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹4000 off with APITEST"), true, "Response contains Couponmessage Save ₹4000 off with APITEST");
                    System.out.println("Response contains Couponmessage Save ₹4000 off with APITEST");
                    Reporter.log("Response contains Couponmessage Save ₹4000 off with APITEST");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹4000 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4000.0"), true, "Response contains discountAmount 4000.0");
                System.out.println("Response contains discountAmount 4000.0");
                Reporter.log("Response contains discountAmount 4000.0");
                Assert.assertEquals(message.contains("94788.0"), true, "Response contains discountedTotalFare 94788.0");
                System.out.println("Response contains discountedTotalFare 94788.0");
                Reporter.log("Response contains discountedTotalFare 94788.0");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("CHD"), true, "Response body contains CHD");
                System.out.println("Response body contains CHD");
                Reporter.log("Response body contains CHD");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("939.52"), true, "Response contains discountAmount 939.52");
                System.out.println("Response contains discountAmount 939.52");
                Reporter.log("Response contains discountAmount 939.52");
                Assert.assertEquals(message.contains("22266.48"), true, "Response contains discountedTotalFare 22266.48");
                System.out.println("Response contains discountedTotalFare 22266.48");
                Reporter.log("Response contains discountedTotalFare 22266.48");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2818.54"), true, "Response contains discountAmount 2818.54");
                System.out.println("Response contains discountAmount 2818.54");
                Reporter.log("Response contains discountAmount 2818.54");
                Assert.assertEquals(message.contains("66799.46"), true, "Response contains discountedTotalFare 66799.46");
                System.out.println("Response contains discountedTotalFare 66799.46");
                Reporter.log("Response contains discountedTotalFare 66799.46");
                Assert.assertEquals(bodyAsString.contains("INF"), true, "Response body contains INF");
                System.out.println("Response body contains INF");
                Reporter.log("Response body contains INF");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("241.92"), true, "Response contains discountAmount 241.92");
                System.out.println("Response contains discountAmount 241.92");
                Reporter.log("Response contains discountAmount 241.92");
                Assert.assertEquals(message.contains("5722.08"), true, "Response contains discountedTotalFare 5722.08");
                System.out.println("Response contains discountedTotalFare 5722.08");
                Reporter.log("Response contains discountedTotalFare 5722.08");

                //Solution2
                Assert.assertEquals(bodyAsString.contains("BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567"), true, "Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                System.out.println("Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                Reporter.log("Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                if (value == "one_way_srp") {
                    Assert.assertEquals(message.contains("Save ₹4000 off with APITEST"), true, "Response contains Couponmessage Save ₹4000 off with APITEST");
                    System.out.println("Response contains Couponmessage Save ₹4000 off with APITEST");
                    Reporter.log("Response contains Couponmessage Save ₹4000 off with APITEST");
                }
                if (value == "one_way_itinerary" || value == "one_way_payment") {
                    Assert.assertEquals(message.contains("Congrats! You have saved ₹4000 on this booking"), true, "Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");
                    System.out.println("Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");
                    Reporter.log("Response contains Couponmessage Congrats! You have saved ₹4000 on this booking");

                }
                Assert.assertEquals(bodyAsString.contains("version"), true, "Response body contains version");
                System.out.println("Response body contains version");
                Reporter.log("Response body contains version");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4000.0"), true, "Response contains discountAmount 4000.0");
                System.out.println("Response contains discountAmount 4000.0");
                Reporter.log("Response contains discountAmount 4000.0");
                Assert.assertEquals(message.contains("57784.0"), true, "Response contains discountedTotalFare 57784.0");
                System.out.println("Response contains discountedTotalFare 57784.0");
                Reporter.log("Response contains discountedTotalFare 57784.0");
                Assert.assertEquals(bodyAsString.contains("paxPricingDetails"), true, "Response body contains paxPricingDetails");
                System.out.println("Response body contains paxPricingDetails");
                Reporter.log("Response body contains paxPricingDetails");
                Assert.assertEquals(bodyAsString.contains("CHD"), true, "Response body contains CHD");
                System.out.println("Response body contains CHD");
                Reporter.log("Response body contains CHD");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("951.16"), true, "Response contains discountAmount 951.16");
                System.out.println("Response contains discountAmount 951.16");
                Reporter.log("Response contains discountAmount 951.16");
                Assert.assertEquals(message.contains("13744.84"), true, "Response contains discountedTotalFare 13744.84");
                System.out.println("Response contains discountedTotalFare 13744.84");
                Reporter.log("Response contains discountedTotalFare 13744.84");
                Assert.assertEquals(bodyAsString.contains("ADT"), true, "Response body contains ADT");
                System.out.println("Response body contains ADT");
                Reporter.log("Response body contains ADT");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2853.48"), true, "Response contains discountAmount 2853.48");
                System.out.println("Response contains discountAmount 2853.48");
                Reporter.log("Response contains discountAmount 2853.48");
                Assert.assertEquals(message.contains("41234.52"), true, "Response contains discountedTotalFare 41234.52");
                System.out.println("Response contains discountedTotalFare 41234.52");
                Reporter.log("Response contains discountedTotalFare 41234.52");
                Assert.assertEquals(bodyAsString.contains("INF"), true, "Response body contains INF");
                System.out.println("Response body contains INF");
                Reporter.log("Response body contains INF");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("195.38"), true, "Response contains discountAmount 195.38");
                System.out.println("Response contains discountAmount 195.38");
                Reporter.log("Response contains discountAmount 195.38");
                Assert.assertEquals(message.contains("2804.62"), true, "Response contains discountedTotalFare 2804.62");
                System.out.println("Response contains discountedTotalFare 2804.62");
                Reporter.log("Response contains discountedTotalFare 2804.62");
            }
        }
        return resp;
    }

    public Response validate_coupontray_coupons(Response resp, String type) {
        if (resp.statusCode() == 200) {
            if (Objects.equals(type, "one_way")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
                Assert.assertEquals(bodyAsString.contains("BLR_GOI_SG-756|HYD_DEL_SG-756|DEL_BLR_SG-776"), true, "Response contains solution id BLR_GOI_SG-756|HYD_DEL_SG-756|DEL_BLR_SG-776");
                System.out.println("Response contains solution id BLR_GOI_SG-756|HYD_DEL_SG-756|DEL_BLR_SG-776");
                Reporter.log("Response contains solution id BLR_GOI_SG-756|HYD_DEL_SG-756|DEL_BLR_SG-776");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(bodyAsString.contains("couponDetails"), true, "Response body contains couponDetails");
                System.out.println("Response body contains couponDetails json");
                Reporter.log("Response body contains couponDetails json");
               // Coupon CTRBD
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRBD: ");
                Reporter.log("Coupon discounting details for coupon CTRBD: ");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193"); Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                Assert.assertEquals(message.contains("Flat ₹7000 off"), true, "Response contains Couponmessage Flat ₹7000 off");
                System.out.println("Response contains Couponmessage Flat ₹7000 off");
                Reporter.log("Response contains Couponmessage Flat ₹7000 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("495"), true, "Response contains rule id 495");
                System.out.println("Response contains rule id 495");
                Reporter.log("Response contains rule id 495");
                Assert.assertEquals(message.contains("4"), true, "Response contains rule version 4");
                System.out.println("Response contains rule version 4");
                Reporter.log("Response contains rule version 4");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("7000.0"), true, "Response contains discountAmount 7000.0");
                System.out.println("Response contains discountAmount 7000.0");
                Reporter.log("Response contains discountAmount 7000.0");
                Assert.assertEquals(message.contains("70000.0"), true, "Response contains discountedTotalFare 70000.0");
                System.out.println("Response contains discountedTotalFare 70000.0");
                Reporter.log("Response contains discountedTotalFare 70000.0");

                // Coupon REDEEMTEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon REDEEMTEST: ");
                Reporter.log("Coupon discounting details for coupon REDEEMTEST: ");
                Assert.assertEquals(message.contains("313"), true, "Response contains CouponId 313");
                System.out.println("Response contains CouponId 313");
                Reporter.log("Response contains CouponId 313");
                Assert.assertEquals(message.contains("REDEEMTEST"), true, "Response contains CouponCode REDEEMTEST");
                System.out.println("Response contains CouponCode REDEEMTEST");
                Reporter.log("Response contains CouponCode REDEEMTEST");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("496"), true, "Response contains rule id 496");
                System.out.println("Response contains rule id 496");
                Reporter.log("Response contains rule id 496");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("75000.0"), true, "Response contains discountedTotalFare 75000.0");
                System.out.println("Response contains discountedTotalFare 75000.0");
                Reporter.log("Response contains discountedTotalFare 75000.0");


                // Coupon APITEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon APITEST: ");
                Reporter.log("Coupon discounting details for coupon APITEST: ");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                Assert.assertEquals(message.contains("Flat ₹3000 off"), true, "Response contains Couponmessage Flat ₹3000 off");
                System.out.println("Response contains Couponmessage Flat ₹3000 off");
                Reporter.log("Response contains Couponmessage Flat ₹3000 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("3000.0"), true, "Response contains discountAmount 3000.0");
                System.out.println("Response contains discountAmount 3000.0");
                Reporter.log("Response contains discountAmount 3000.0");
                Assert.assertEquals(message.contains("74000.0"), true, "Response contains discountedTotalFare 74000.0");
                System.out.println("Response contains discountedTotalFare 74000.0");
                Reporter.log("Response contains discountedTotalFare 74000.0");

                // Coupon CTRPS
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRPS: ");
                Reporter.log("Coupon discounting details for coupon CTRPS: ");
                Assert.assertEquals(message.contains("334"), true, "Response contains CouponId 334");
                System.out.println("Response contains CouponId 334");
                Reporter.log("Response contains CouponId 334");
                Assert.assertEquals(message.contains("CTRPS"), true, "Response contains CouponCode CTRPS");
                System.out.println("Response contains CouponCode CTRPS");
                Reporter.log("Response contains CouponCode CTRPS");
                Assert.assertEquals(message.contains("Flat ₹7200 off"), true, "Response contains Couponmessage Flat ₹7200 off");
                System.out.println("Response contains Couponmessage Flat ₹7200 off");
                Reporter.log("Response contains Couponmessage Flat ₹7200 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("552"), true, "Response contains rule id 552");
                System.out.println("Response contains rule id 552");
                Reporter.log("Response contains rule id 552");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("7200.0"), true, "Response contains discountAmount 7200.0");
                System.out.println("Response contains discountAmount 7200.0");
                Reporter.log("Response contains discountAmount 7200.0");
                Assert.assertEquals(message.contains("69800.0"), true, "Response contains discountedTotalFare 69800.0");
                System.out.println("Response contains discountedTotalFare 69800.0");
                Reporter.log("Response contains discountedTotalFare 69800.0");


                // Coupon CTTRAY
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTTRAY: ");
                Reporter.log("Coupon discounting details for coupon CTTRAY: ");
                Assert.assertEquals(message.contains("303"), true, "Response contains CouponId 303");
                System.out.println("Response contains CouponId 303");
                Reporter.log("Response contains CouponId 303");
                Assert.assertEquals(message.contains("CTTRAY"), true, "Response contains CouponCode CTTRAY");
                System.out.println("Response contains CouponCode CTTRAY");
                Reporter.log("Response contains CouponCode CTTRAY");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("473"), true, "Response contains rule id 473");
                System.out.println("Response contains rule id 473");
                Reporter.log("Response contains rule id 473");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("75000.0"), true, "Response contains discountedTotalFare 75000.0");
                System.out.println("Response contains discountedTotalFare 75000.0");
                Reporter.log("Response contains discountedTotalFare 75000.0");

            }
            if(type=="round_trip")
            {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("Completed the request successfully"), true, "Response contains message Completed the request successfully");
                System.out.println("Response contains message Completed the request successfully");
                Reporter.log("Response contains message Completed the request successfully");
                Assert.assertEquals(bodyAsString.contains("trackingId"), true, "Response body contains trackingId");
               // Solution 1
                System.out.println(" ");
                Reporter.log(" ");
                System.out.println("Solution1: ");
                Reporter.log("Solution1: ");
                Assert.assertEquals(bodyAsString.contains("BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563"), true, "Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                System.out.println("Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                Reporter.log("Response contains solution id BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(bodyAsString.contains("couponDetails"), true, "Response body contains couponDetails");
                System.out.println("Response body contains couponDetails json");
                Reporter.log("Response body contains couponDetails json");
                // Coupon CTRBD
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRBD: ");
                Reporter.log("Coupon discounting details for coupon CTRBD: ");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193"); Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                Assert.assertEquals(message.contains("Flat ₹8584 off"), true, "Response contains Couponmessage Flat ₹8584 off");
                System.out.println("Response contains Couponmessage Flat ₹8584 off");
                Reporter.log("Response contains Couponmessage Flat ₹8584 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("495"), true, "Response contains rule id 495");
                System.out.println("Response contains rule id 495");
                Reporter.log("Response contains rule id 495");
                Assert.assertEquals(message.contains("4"), true, "Response contains rule version 4");
                System.out.println("Response contains rule version 4");
                Reporter.log("Response contains rule version 4");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("8584.0"), true, "Response contains discountAmount 8584.0");
                System.out.println("Response contains discountAmount 8584.0");
                Reporter.log("Response contains discountAmount 8584.0");
                Assert.assertEquals(message.contains("90204.0"), true, "Response contains discountedTotalFare 90204.0");
                System.out.println("Response contains discountedTotalFare 90204.0");
                Reporter.log("Response contains discountedTotalFare 90204.0");

                // Coupon REDEEMTEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon REDEEMTEST: ");
                Reporter.log("Coupon discounting details for coupon REDEEMTEST: ");
                Assert.assertEquals(message.contains("313"), true, "Response contains CouponId 313");
                System.out.println("Response contains CouponId 313");
                Reporter.log("Response contains CouponId 313");
                Assert.assertEquals(message.contains("REDEEMTEST"), true, "Response contains CouponCode REDEEMTEST");
                System.out.println("Response contains CouponCode REDEEMTEST");
                Reporter.log("Response contains CouponCode REDEEMTEST");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("496"), true, "Response contains rule id 496");
                System.out.println("Response contains rule id 496");
                Reporter.log("Response contains rule id 496");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("96788.0"), true, "Response contains discountedTotalFare 96788.0");
                System.out.println("Response contains discountedTotalFare 96788.0");
                Reporter.log("Response contains discountedTotalFare 96788.0");


                // Coupon APITEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon APITEST: ");
                Reporter.log("Coupon discounting details for coupon APITEST: ");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                Assert.assertEquals(message.contains("Flat ₹4000 off"), true, "Response contains Couponmessage Flat ₹4000 off");
                System.out.println("Response contains Couponmessage Flat ₹4000 off");
                Reporter.log("Response contains Couponmessage Flat ₹4000 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4000.0"), true, "Response contains discountAmount 4000.0");
                System.out.println("Response contains discountAmount 4000.0");
                Reporter.log("Response contains discountAmount 4000.0");
                Assert.assertEquals(message.contains("94788.0"), true, "Response contains discountedTotalFare 94788.0");
                System.out.println("Response contains discountedTotalFare 94788.0");
                Reporter.log("Response contains discountedTotalFare 94788.0");

                // Coupon CTRPS
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRPS: ");
                Reporter.log("Coupon discounting details for coupon CTRPS: ");
                Assert.assertEquals(message.contains("334"), true, "Response contains CouponId 334");
                System.out.println("Response contains CouponId 334");
                Reporter.log("Response contains CouponId 334");
                Assert.assertEquals(message.contains("CTRPS"), true, "Response contains CouponCode CTRPS");
                System.out.println("Response contains CouponCode CTRPS");
                Reporter.log("Response contains CouponCode CTRPS");
                Assert.assertEquals(message.contains("Flat ₹8784 off"), true, "Response contains Couponmessage Flat ₹8784 off");
                System.out.println("Response contains Couponmessage Flat ₹8784 off");
                Reporter.log("Response contains Couponmessage Flat ₹8784 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("552"), true, "Response contains rule id 552");
                System.out.println("Response contains rule id 552");
                Reporter.log("Response contains rule id 552");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("8784.0"), true, "Response contains discountAmount 8784.0");
                System.out.println("Response contains discountAmount 8784.0");
                Reporter.log("Response contains discountAmount 8784.0");
                Assert.assertEquals(message.contains("90004.0"), true, "Response contains discountedTotalFare 90004.0");
                System.out.println("Response contains discountedTotalFare 90004.0");
                Reporter.log("Response contains discountedTotalFare 90004.0");


                // Coupon CTTRAY
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTTRAY: ");
                Reporter.log("Coupon discounting details for coupon CTTRAY: ");
                Assert.assertEquals(message.contains("303"), true, "Response contains CouponId 303");
                System.out.println("Response contains CouponId 303");
                Reporter.log("Response contains CouponId 303");
                Assert.assertEquals(message.contains("CTTRAY"), true, "Response contains CouponCode CTTRAY");
                System.out.println("Response contains CouponCode CTTRAY");
                Reporter.log("Response contains CouponCode CTTRAY");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("473"), true, "Response contains rule id 473");
                System.out.println("Response contains rule id 473");
                Reporter.log("Response contains rule id 473");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("96788.0"), true, "Response contains discountedTotalFare 96788.0");
                System.out.println("Response contains discountedTotalFare 96788.0");
                Reporter.log("Response contains discountedTotalFare 96788.0");

                // Solution 2
                System.out.println(" ");
                Reporter.log(" ");
                System.out.println("Solution2: ");
                Reporter.log("Solution2: ");
                Assert.assertEquals(bodyAsString.contains("BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567"), true, "Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                System.out.println("Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                Reporter.log("Response contains solution id BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567");
                Assert.assertEquals(bodyAsString.contains("coupons"), true, "Response body contains coupons");
                System.out.println("Response body contains coupons json");
                Reporter.log("Response body contains coupons json");
                Assert.assertEquals(bodyAsString.contains("couponDetails"), true, "Response body contains couponDetails");
                System.out.println("Response body contains couponDetails json");
                Reporter.log("Response body contains couponDetails json");
                // Coupon CTRBD
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRBD: ");
                Reporter.log("Coupon discounting details for coupon CTRBD: ");
                Assert.assertEquals(message.contains("193"), true, "Response contains CouponId 193");
                System.out.println("Response contains CouponId 193");
                Reporter.log("Response contains CouponId 193"); Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode CTRBD");
                Reporter.log("Response contains CouponCode CTRBD");
                Assert.assertEquals(message.contains("Flat ₹4650 off"), true, "Response contains Couponmessage Flat ₹4650 off");
                System.out.println("Response contains Couponmessage Flat ₹4650 off");
                Reporter.log("Response contains Couponmessage Flat ₹4650 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("495"), true, "Response contains rule id 495");
                System.out.println("Response contains rule id 495");
                Reporter.log("Response contains rule id 495");
                Assert.assertEquals(message.contains("4"), true, "Response contains rule version 4");
                System.out.println("Response contains rule version 4");
                Reporter.log("Response contains rule version 4");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4650.01"), true, "Response contains discountAmount 4650.01");
                System.out.println("Response contains discountAmount 4650.01");
                Reporter.log("Response contains discountAmount 4650.01");
                Assert.assertEquals(message.contains("57133.99"), true, "Response contains discountedTotalFare 57133.99");
                System.out.println("Response contains discountedTotalFare 57133.99");
                Reporter.log("Response contains discountedTotalFare 57133.99");

                // Coupon REDEEMTEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon REDEEMTEST: ");
                Reporter.log("Coupon discounting details for coupon REDEEMTEST: ");
                Assert.assertEquals(message.contains("313"), true, "Response contains CouponId 313");
                System.out.println("Response contains CouponId 313");
                Reporter.log("Response contains CouponId 313");
                Assert.assertEquals(message.contains("REDEEMTEST"), true, "Response contains CouponCode REDEEMTEST");
                System.out.println("Response contains CouponCode REDEEMTEST");
                Reporter.log("Response contains CouponCode REDEEMTEST");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("12"), true, "Response contains rule version 12");
                System.out.println("Response contains rule version 12");
                Reporter.log("Response contains rule version 12");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("496"), true, "Response contains rule id 496");
                System.out.println("Response contains rule id 496");
                Reporter.log("Response contains rule id 496");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("59784.0"), true, "Response contains discountedTotalFare 59784.0");
                System.out.println("Response contains discountedTotalFare 59784.0");
                Reporter.log("Response contains discountedTotalFare 59784.0");


                // Coupon APITEST
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon APITEST: ");
                Reporter.log("Coupon discounting details for coupon APITEST: ");
                Assert.assertEquals(message.contains("333"), true, "Response contains CouponId 333");
                System.out.println("Response contains CouponId 333");
                Reporter.log("Response contains CouponId 333");
                Assert.assertEquals(message.contains("APITEST"), true, "Response contains CouponCode APITEST");
                System.out.println("Response contains CouponCode APITEST");
                Reporter.log("Response contains CouponCode APITEST");
                Assert.assertEquals(message.contains("Flat ₹4000 off"), true, "Response contains Couponmessage Flat ₹4000 off");
                System.out.println("Response contains Couponmessage Flat ₹4000 off");
                Reporter.log("Response contains Couponmessage Flat ₹4000 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("529"), true, "Response contains rule id 529");
                System.out.println("Response contains rule id 529");
                Reporter.log("Response contains rule id 529");
                Assert.assertEquals(message.contains("5"), true, "Response contains rule version 5");
                System.out.println("Response contains rule version 5");
                Reporter.log("Response contains rule version 5");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4000.0"), true, "Response contains discountAmount 4000.0");
                System.out.println("Response contains discountAmount 4000.0");
                Reporter.log("Response contains discountAmount 4000.0");
                Assert.assertEquals(message.contains("57784.0"), true, "Response contains discountedTotalFare 57784.0");
                System.out.println("Response contains discountedTotalFare 57784.0");
                Reporter.log("Response contains discountedTotalFare 57784.0");

                // Coupon CTRPS
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTRPS: ");
                Reporter.log("Coupon discounting details for coupon CTRPS: ");
                Assert.assertEquals(message.contains("334"), true, "Response contains CouponId 334");
                System.out.println("Response contains CouponId 334");
                Reporter.log("Response contains CouponId 334");
                Assert.assertEquals(message.contains("CTRPS"), true, "Response contains CouponCode CTRPS");
                System.out.println("Response contains CouponCode CTRPS");
                Reporter.log("Response contains CouponCode CTRPS");
                Assert.assertEquals(message.contains("Flat ₹4850 off"), true, "Response contains Couponmessage Flat ₹4850 off");
                System.out.println("Response contains Couponmessage Flat ₹4850 off");
                Reporter.log("Response contains Couponmessage Flat ₹4850 off");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("552"), true, "Response contains rule id 552");
                System.out.println("Response contains rule id 552");
                Reporter.log("Response contains rule id 552");
                Assert.assertEquals(message.contains("6"), true, "Response contains rule version 6");
                System.out.println("Response contains rule version 6");
                Reporter.log("Response contains rule version 6");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("4850.0"), true, "Response contains discountAmount 4850.0");
                System.out.println("Response contains discountAmount 4850.0");
                Reporter.log("Response contains discountAmount 4850.0");
                Assert.assertEquals(message.contains("56934.0"), true, "Response contains discountedTotalFare 56934.0");
                System.out.println("Response contains discountedTotalFare 56934.0");
                Reporter.log("Response contains discountedTotalFare 56934.0");


                // Coupon CTTRAY
                System.out.println("");
                Reporter.log("");
                System.out.println("Coupon discounting details for coupon CTTRAY: ");
                Reporter.log("Coupon discounting details for coupon CTTRAY: ");
                Assert.assertEquals(message.contains("303"), true, "Response contains CouponId 303");
                System.out.println("Response contains CouponId 303");
                Reporter.log("Response contains CouponId 303");
                Assert.assertEquals(message.contains("CTTRAY"), true, "Response contains CouponCode CTTRAY");
                System.out.println("Response contains CouponCode CTTRAY");
                Reporter.log("Response contains CouponCode CTTRAY");
                Assert.assertEquals(message.contains("Flat ₹2000 off"), true, "Response contains Couponmessage Flat ₹2000 off");
                System.out.println("Response contains Couponmessage Flat ₹2000 off");
                Reporter.log("Response contains Couponmessage Flat ₹2000 off");
                Assert.assertEquals(message.contains("3"), true, "Response contains rule version 3");
                System.out.println("Response contains rule version 3");
                Reporter.log("Response contains rule version 3");
                Assert.assertEquals(bodyAsString.contains("rulesApplied"), true, "Response body contains rulesApplied");
                System.out.println("Response body contains rulesApplied array");
                Reporter.log("Response body contains rulesApplied array");
                Assert.assertEquals(message.contains("473"), true, "Response contains rule id 473");
                System.out.println("Response contains rule id 473");
                Reporter.log("Response contains rule id 473");
                Assert.assertEquals(message.contains("2"), true, "Response contains rule version 2");
                System.out.println("Response contains rule version 2");
                Reporter.log("Response contains rule version 2");
                Assert.assertEquals(bodyAsString.contains("pricingDetails"), true, "Response body contains pricingDetails");
                System.out.println("Response body contains pricingDetails");
                Reporter.log("Response body contains pricingDetails");
                Assert.assertEquals(bodyAsString.contains("bookingPricingDetail"), true, "Response body contains bookingPricingDetail");
                System.out.println("Response body contains bookingPricingDetail");
                Reporter.log("Response body contains bookingPricingDetail");
                Assert.assertEquals(bodyAsString.contains("discountAmount"), true, "Response body contains discountAmount");
                System.out.println("Response body contains discountAmount");
                Reporter.log("Response body contains discountAmount");
                Assert.assertEquals(bodyAsString.contains("discountedTotalFare"), true, "Response body contains discountedTotalFare");
                System.out.println("Response body contains discountedTotalFare");
                Reporter.log("Response body contains discountedTotalFare");
                Assert.assertEquals(message.contains("2000.0"), true, "Response contains discountAmount 2000.0");
                System.out.println("Response contains discountAmount 2000.0");
                Reporter.log("Response contains discountAmount 2000.0");
                Assert.assertEquals(message.contains("59784.0"), true, "Response contains discountedTotalFare 59784.0");
                System.out.println("Response contains discountedTotalFare 59784.0");
                Reporter.log("Response contains discountedTotalFare 59784.0");

            }
            }
        return resp;
        }

    public Response create_draftrule_validation(Response resp, String type) {
        if (resp.statusCode() == 200) {
            if (Objects.equals(type, "pricing")) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                Assert.assertEquals(bodyAsString.contains("201"), true, "Response contains status 201");
                System.out.println("Response contains status 201");
                Reporter.log("Response contains status 201");
                Assert.assertEquals(bodyAsString.contains("Draft Rule Created Successfully"), true, "Response contains message Draft Rule Created Successfully");
                System.out.println("Response contains message Draft Rule Created Successfully");
                Reporter.log("Response contains message Draft Rule Created Successfully");
                Assert.assertEquals(bodyAsString.contains("response"), true, "Response body contains response");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response contains id");
                System.out.println("Response contains id");
                Reporter.log("Response contains id");
                draft_ruleid=jsonPath.getJsonObject("response.id");
                System.out.println(draft_ruleid);
                Assert.assertEquals(bodyAsString.contains("ruleType"), true, "Response body contains ruleType");
                System.out.println("Response body contains ruleType");
                Reporter.log("Response body contains ruleType ");
                Assert.assertEquals(bodyAsString.contains("PRICING"), true, "Response body contains PRICING");
                System.out.println("Response body contains PRICING");
                Reporter.log("Response body contains PRICING ");
                Assert.assertEquals(bodyAsString.contains("uiRuleType"), true, "Response body contains uiRuleType");
                System.out.println("Response body contains uiRuleType");
                Reporter.log("Response body contains uiRuleType ");
                Assert.assertEquals(bodyAsString.contains("ruleDescription"), true, "Response body contains ruleDescription");
                System.out.println("Response body contains ruleDescription");
                Reporter.log("Response body contains ruleDescription ");
                Assert.assertEquals(bodyAsString.contains("test api automation pricing rules"), true, "Response body contains test api automation pricing rules");
                System.out.println("Response body contains test api automation pricing rules");
                Reporter.log("Response body contains test api automation pricing rules ");
                Assert.assertEquals(bodyAsString.contains("startDate"), true, "Response body contains startDate");
                System.out.println("Response body contains startDate");
                Reporter.log("Response body contains startDate ");
                Assert.assertEquals(bodyAsString.contains("1701973800000"), true, "Response body contains 1701973800000");
                System.out.println("Response body contains 1701973800000");
                Reporter.log("Response body contains 1701973800000 ");
                Assert.assertEquals(bodyAsString.contains("endDate"), true, "Response body contains endDate");
                System.out.println("Response body contains endDate");
                Reporter.log("Response body contains endDate ");
                Assert.assertEquals(bodyAsString.contains("1727720940000"), true, "Response body contains 1727720940000");
                System.out.println("Response body contains 1727720940000");
                Reporter.log("Response body contains 1727720940000 ");
                Assert.assertEquals(bodyAsString.contains("timeSlots"), true, "Response body contains timeSlots");
                System.out.println("Response body contains timeSlots");
                Reporter.log("Response body contains timeSlots ");
                Assert.assertEquals(bodyAsString.contains("startTime"), true, "Response body contains startTime");
                System.out.println("Response body contains startTime");
                Reporter.log("Response body contains startTime ");
                Assert.assertEquals(bodyAsString.contains("00:00"), true, "Response body contains startTime 00:00");
                System.out.println("Response body contains startTime 00:00");
                Reporter.log("Response body contains startTime 00:00");
                Assert.assertEquals(bodyAsString.contains("endTime"), true, "Response body contains endTime");
                System.out.println("Response body contains endTime");
                Reporter.log("Response body contains endTime ");
                Assert.assertEquals(bodyAsString.contains("23:59"), true, "Response body contains endTime 23:59");
                System.out.println("Response body contains endTime 23:59");
                Reporter.log("Response body contains endTime 23:59");
                Assert.assertEquals(bodyAsString.contains("team"), true, "Response body contains team");
                System.out.println("Response body contains team");
                Reporter.log("Response body contains team ");
                Assert.assertEquals(bodyAsString.contains("1"), true, "Response body contains team 1");
                System.out.println("Response body contains team 1");
                Reporter.log("Response body contains team 1 ");
            }
            if(type=="bcf")
            {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
                String message = jsonPath.getString("response");
                System.out.println(message);
                draft_ruleid=jsonPath.getJsonObject("response.id");
                System.out.println(draft_ruleid);
                Assert.assertEquals(bodyAsString.contains("201"), true, "Response contains status 201");
                System.out.println("Response contains status 201");
                Reporter.log("Response contains status 201");
                Assert.assertEquals(bodyAsString.contains("Draft Rule Created Successfully"), true, "Response contains message Draft Rule Created Successfully");
                System.out.println("Response contains message Draft Rule Created Successfully");
                Reporter.log("Response contains message Draft Rule Created Successfully");
                Assert.assertEquals(bodyAsString.contains("response"), true, "Response body contains response");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response contains id");
                System.out.println("Response contains id");
                Reporter.log("Response contains id");

                Assert.assertEquals(bodyAsString.contains("ruleType"), true, "Response body contains ruleType");
                System.out.println("Response body contains ruleType");
                Reporter.log("Response body contains ruleType ");
                Assert.assertEquals(bodyAsString.contains("BASE_CONVENIENCE_FEE"), true, "Response body contains BASE_CONVENIENCE_FEE");
                System.out.println("Response body contains BASE_CONVENIENCE_FEE");
                Reporter.log("Response body contains BASE_CONVENIENCE_FEE ");
                Assert.assertEquals(bodyAsString.contains("uiRuleType"), true, "Response body contains uiRuleType");
                System.out.println("Response body contains uiRuleType");
                Reporter.log("Response body contains uiRuleType ");
                Assert.assertEquals(bodyAsString.contains("ruleDescription"), true, "Response body contains ruleDescription");
                System.out.println("Response body contains ruleDescription");
                Reporter.log("Response body contains ruleDescription ");
                Assert.assertEquals(bodyAsString.contains("test automation bcf rule"), true, "Response body contains test automation bcf rule");
                System.out.println("Response body contains test automation bcf rule");
                Reporter.log("Response body contains test automation bcf rule");
                Assert.assertEquals(bodyAsString.contains("startDate"), true, "Response body contains startDate");
                System.out.println("Response body contains startDate");
                Reporter.log("Response body contains startDate ");
                Assert.assertEquals(bodyAsString.contains("1697653800000"), true, "Response body contains 1697653800000");
                System.out.println("Response body contains startDate 1697653800000");
                Reporter.log("Response body contains startDate 1697653800000 ");
                Assert.assertEquals(bodyAsString.contains("endDate"), true, "Response body contains endDate");
                System.out.println("Response body contains endDate");
                Reporter.log("Response body contains endDate ");
                Assert.assertEquals(bodyAsString.contains("1725088651000"), true, "Response body contains 1725088651000");
                System.out.println("Response body contains endDate 1725088651000");
                Reporter.log("Response body contains endDate 1725088651000 ");
                Assert.assertEquals(bodyAsString.contains("subTypeMetaInfo"), true, "Response body contains subTypeMetaInfo");
                System.out.println("Response body contains subTypeMetaInfo");
                Reporter.log("Response body contains subTypeMetaInfo ");
                Assert.assertEquals(bodyAsString.contains("type"), true, "Response body contains type");
                System.out.println("Response body contains type");
                Reporter.log("Response body contains type ");
                Assert.assertEquals(bodyAsString.contains("BCF_INFO"), true, "Response body contains startTime BCF_INFO");
                System.out.println("Response body contains type is BCF_INFO");
                Reporter.log("Response body contains type is BCF_INFO");
                Assert.assertEquals(bodyAsString.contains("demandChannel"), true, "Response body contains demandChannel");
                System.out.println("Response body contains demandChannel");
                Reporter.log("Response body contains demandChannel ");
                Assert.assertEquals(bodyAsString.contains("META"), true, "Response body contains demandChannel META");
                System.out.println("Response body contains demandChannel META");
                Reporter.log("Response body contains demandChannel META");
                Assert.assertEquals(bodyAsString.contains("DIRECT"), true, "Response body contains demandChannel DIRECT");
                System.out.println("Response body contains demandChannel DIRECT");
                Reporter.log("Response body contains demandChannel DIRECT");
                Assert.assertEquals(bodyAsString.contains("team"), true, "Response body contains team");
                System.out.println("Response body contains team");
                Reporter.log("Response body contains team ");
                Assert.assertEquals(bodyAsString.contains("1"), true, "Response body contains team 1");
                System.out.println("Response body contains team 1");
                Reporter.log("Response body contains team 1 ");
            }
        }
        return resp;
    }

    public Response validate_Supply_Criteria(Response resp) {
        if (resp.statusCode() == 200) {
                Reporter.log(resp.asString());
                System.out.println(resp.asString());
                Reporter.log("Status code " + resp.statusCode());
                ResponseBody body = resp.getBody();
                String bodyAsString = body.asString();
                JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("response");
            System.out.println(message);
            criteriaid1= jsonPath.getJsonObject("response.id");
                    System.out.println(criteriaid1);

                Assert.assertEquals(bodyAsString.contains("200"), true, "Response contains status 200");
                System.out.println("Response contains status 200");
                Reporter.log("Response contains status 200");
                Assert.assertEquals(bodyAsString.contains("Criteria creation successful for Id:"), true, "Response contains message Criteria creation successful for Id: ");
                System.out.println("Response contains message Criteria creation successful for Id:");
                Reporter.log("Response contains message Criteria creation successful for Id:");
                Assert.assertEquals(bodyAsString.contains("response"), true, "Response body contains response");
                Assert.assertEquals(bodyAsString.contains("id"), true, "Response contains id");
                System.out.println("Response contains id");
                Reporter.log("Response contains id");
                Assert.assertEquals(bodyAsString.contains("status"), true, "Response body contains status");
                System.out.println("Response body contains status");
                Reporter.log("Response body contains status ");
                Assert.assertEquals(bodyAsString.contains("DRAFT"), true, "Response body contains DRAFT");
                System.out.println("Response body contains DRAFT");
                Reporter.log("Response body contains DRAFT ");
            }
            return resp;
        }




    public ArrayList<String> db_criteria(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> Name = new ArrayList<String>();
        {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "tcms_user";
            String password = "DJ3oVLvc2q$";
            String url = "jdbc:mysql://qa2-mysql8.cltp.com:3306/sniper_store";
            String query = "SELECT * FROM CRITERIA WHERE ID= '" + id + "'";
            Connection myCon = DriverManager.getConnection(url, user, password);
            if (myCon != null) {
                ResultSet myRes = myCon.createStatement().executeQuery(query);
                while (myRes.next() == true) {
                    ResultSetMetaData result = myRes.getMetaData();
                    int noOfColumns = result.getColumnCount();
                    int noOfRows = myRes.getRow();
                    for (int x = 1; x <= noOfColumns; x++) {

                        String colValue = myRes.getString(x);
                        data.add(colValue);

                    }
                }
                myCon.close();
            } else
                Reporter.log("DB Connection not established");
        }
        return data;
    }

    public ArrayList<String> db_update_criteria(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> Name = new ArrayList<String>();
        {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "tcms_user";
            String password = "DJ3oVLvc2q$";
            String url = "jdbc:mysql://qa2-mysql8.cltp.com:3306/sniper_store";
            String query = "UPDATE CRITERIA SET CRITERIA_JSON='" + DB_CRITERIA_JSON + "'WHERE ID= '" + id + "'";
            Connection myCon = DriverManager.getConnection(url, user, password);
            if (myCon != null) {
                ResultSet myRes = myCon.createStatement().executeQuery(query);
                while (myRes.next() == true) {
                    ResultSetMetaData result = myRes.getMetaData();
                    int noOfColumns = result.getColumnCount();
                    int noOfRows = myRes.getRow();
                    for (int x = 1; x <= noOfColumns; x++) {

                        String colValue = myRes.getString(x);
                        data.add(colValue);

                    }
                }
                myCon.close();
            } else
                Reporter.log("DB Connection not established");
        }
        return data;
    }

    String create_criteria = "{\"teamId\":\"1\",\"catalogId\":\"SUPPLY-CRITERIA-AIR\",\"criteriaType\":\"SUPPLY\",\"description\":\"this includes certain supply criteria\",\"fields\":[{\"fieldName\":\"Airline\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-AIRLINE\",\"values\":[\"6E\",\"B3\"]},{\"fieldName\":\"flight_type\",\"operator\":\"EXCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-TYPE\",\"values\":[\"international\"]},{\"fieldName\":\"sector\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-SECTOR\",\"values\":[\"BOM-DEL\",\"DEL-ALL\",\"ALL-DEL\"]},{\"fieldName\":\"flight no\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-CODE\",\"values\":[\"6E-145\",\"6E-567\"]}]}";
    String put_criteria = "{\"fields\":[{\"fieldName\":\"Airline\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-AIRLINE\",\"values\":[\"6E\",\"B3\"]},{\"fieldName\":\"flight_type\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-TYPE\",\"values\":[\"domestic\",\"international\"]},{\"fieldName\":\"sector\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-SECTOR\",\"values\":[\"BOM-DEL\",\"DEL-ALL\",\"ALL-DEL\"]},{\"fieldName\":\"flight no\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-CODE\",\"values\":[\"6E-145\",\"6E-567\"]}]}";
    String DB_CRITERIA_JSON = "[{\"values\": [\"6E\", \"B3\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-AIRLINE\"}, {\"values\": [\"international\"], \"operator\": \"EXCULDES\", \"elementId\": \"SC-ELEMENT-FLIGHT-TYPE\"}, {\"values\": [\"BOM-DEL\", \"DEL-ALL\", \"ALL-DEL\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-SECTOR\"}, {\"values\": [\"6E-145\", \"6E-567\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-FLIGHT-CODE\"}]";

    String get_criteria_ids = "{\"label\":\"CT_AIR_OFFER_SUPPLY_CRITERIA\",\"solutions\":[{\"id\":\"BOM_DEL_G8-336|DEL_BLR_G8-338\",\"attributeMap\":{\"airlines\":[\"6E\"],\"sectorType\":\"DOMESTIC\",\"sectors\":[\"BOM-_ALL,_ALL-BLR,BOM-BLR\"],\"flightCodes\":[\"G8-336,G8-338\"]}},{\"id\":\"BLR_DEL_G8-336|DEL_BLR_G8-338\",\"attributeMap\":{\"airlines\":[\"6E\"],\"sectorType\":\"DOMESTIC\",\"sectors\":[\"BLR-_ALL,_ALL-BLR,DEL-BLR\"],\"flightCodes\":[\"G8-336,G8-338\"]}}]}";
    String get_criteria_ids_without_tag_with_field_qosTier_Primary = "{\"label\":\"CT_AIR_OFFER_SUPPLY_CRITERIA\",\"qosTier\":\"PRIMARY\",\"solutions\":[{\"id\":\"BLR_GOI_6E-2174\",\"attributeMap\":{\"airlines\":[\"6E\"],\"sectorType\":\"DOMESTIC\"}}]}";
    String get_criteria_ids_with_tag_with_field_qosTier_Secondary = "{\"label\":\"CT_AIR_OFFER_SUPPLY_CRITERIA\",\"qosTier\":\"SECONDARY\",\"tags\":[{\"key\":\"c\",\"values\":[300]},{\"key\":\"rt\",\"values\":[\"PRICING\"]}],\"solutions\":[{\"id\":\"BLR_GOI_6E-2174\",\"attributeMap\":{\"airlines\":[\"6E\"],\"sectors\":[\"BLR-GOI\"],\"flightCodes\":[\"6E-2174\"],\"sectorType\":\"DOMESTIC\"}},{\"id\":\"DEL_BOM_G8-336|BOM_BLR_G8-338\",\"attributeMap\":{\"airlines\":[\"6E\"],\"sectorType\":\"DOMESTIC\",\"sectors\":[\"BOM-BLR,BOM-BLR\"],\"flightCodes\":[\"G8-336,G8-338\"]}}]}";
    String get_coupon_oneway = "{\"trackingId\":\"NIFW7f11ae15-4502-40d6-8952-230929115049\",\"demandContext\":{\"deviceContext\":{\"deviceId\":\"fe79f566-3ecd-470c-8245-4c3338d5d4c6\"},\"userContext\":{\"loginStatus\":\"NON_LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"PWA\"}},\"queryContext\":{\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":1,\"paxChild\":0,\"paxInfant\":0,\"total\":1},\"travelClass\":\"ECONOMY\",\"fareType\":\"REGULAR_FARE\",\"journeyType\":\"ONE_WAY\",\"departureDate\":{\"timestamp\":1724309978000,\"timeZone\":\"UTC\"},\"bookingDate\":{\"timestamp\":1732258778000,\"timeZone\":\"UTC\"},\"parentFareType\":\"RETAIL\"},\"couponContext\":{\"couponCodes\":[\"CTRBD\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BLR_DEL_I5-741\",\"journeys\":[{\"supplyId\":\"BLR_DEL_I5-741|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_DEL_I5-741|DOM|SEGMENT\",\"airline\":\"I5\",\"flightId\":\"I5-741\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":5564,\"baseFare\":4404,\"baseFareYQ\":4404,\"revenue\":0,\"revenuePercent\":0},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":5564,\"baseFare\":4404,\"baseFareYQ\":4404,\"revenue\":0,\"revenuePercent\":0,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":5564,\"baseFare\":4404,\"baseFareYQ\":4404,\"revenue\":0,\"revenuePercent\":0},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":5564,\"baseFare\":4404,\"baseFareYQ\":4404,\"revenue\":0,\"revenuePercent\":0,\"paxCount\":1}}}}]}]}}";
    String get_coupon_roundtrip = "{\"trackingId\":\"23456\",\"demandContext\":{\"userContext\":{\"userId\":1234,\"loginStatus\":\"LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"PWA\"},\"deviceContext\":{\"deviceId\":\"fduefguebf\"}},\"queryContext\":{\"sector\":{\"source\":\"BOM\",\"destination\":\"GAU\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":2,\"paxChild\":1,\"paxInfant\":1,\"total\":6},\"travelClass\":\"ECONOMY\",\"journeyType\":\"ROUND_TRIP\",\"fareType\":\"REGULAR_FARE\",\"parentFareType\":\"RETAIL\",\"fareFamily\":\"FF1\",\"departureDate\":{\"timestamp\":1724741978000,\"timeZone\":\"Asia/Kolkata\"},\"returnDate\":{\"timestamp\":1725087578000,\"timeZone\":\"Asia/Kolkata\"},\"bookingDate\":{\"timestamp\":1671605238000,\"timeZone\":\"Asia/Kolkata\"}},\"couponContext\":{\"couponCodes\":[\"CTRBD\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BOM_GAU_SG-756|GAU_DEL_SG-756|DEL_BOM_SG-776\",\"journeys\":[{\"supplyId\":\"BOM_GAU_SG-756|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":false,\"stopCount\":0,\"rbd\":\"P\",\"sector\":{\"source\":\"BOM\",\"destination\":\"GAU\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BOM_GAU_SG-756|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-756\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"GAU\",\"sectorType\":\"DOM\"}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":35000.00,\"totalFare\":38500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":20000.00,\"totalFare\":22000.00,\"baseFareYq\":20000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}},{\"supplyId\":\"GAU_DEL_SG-757|DEL_BOM_SG-776|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"rbd\":\"P\",\"sector\":{\"source\":\"GAU\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"GAU_DEL_SG-757|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-757\",\"stopCount\":0,\"sector\":{\"source\":\"GAU\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}},{\"supplyId\":\"DEL_BOM_SG-776|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-776\",\"stopCount\":0,\"sector\":{\"source\":\"DEL\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":35000.00,\"totalFare\":38500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":20000.00,\"totalFare\":22000.00,\"baseFareYq\":20000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}}]},{\"solutionId\":\"BOM_CCU_6E-256|CCU_GAU_6E-666|GAU_DEL_SG-756|DEL_BOM_SG-776\",\"journeys\":[{\"supplyId\":\"BOM_CCU_6E-256|CCU_GAU_6E-666|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":false,\"stopCount\":0,\"rbd\":\"P\",\"sector\":{\"source\":\"BOM\",\"destination\":\"GAU\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BOM_CCU_6E-256|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-256\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"CCU\",\"sectorType\":\"DOM\"}},{\"supplyId\":\"CCU_GAU_6E-666|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-666\",\"stopCount\":0,\"sector\":{\"source\":\"CCU\",\"destination\":\"GAU\",\"sectorType\":\"DOM\"}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":32000.00,\"totalFare\":35500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":18000.00,\"totalFare\":20000.00,\"baseFareYq\":18000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":9000.00,\"totalFare\":10000.00,\"baseFareYq\":9000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}},{\"supplyId\":\"GAU_DEL_SG-757|DEL_BOM_SG-776|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"rbd\":\"P\",\"sector\":{\"source\":\"GAU\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"GAU_DEL_SG-757|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-757\",\"stopCount\":0,\"sector\":{\"source\":\"GAU\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}},{\"supplyId\":\"DEL_BOM_SG-776|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-776\",\"stopCount\":0,\"sector\":{\"source\":\"DEL\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":35000.00,\"totalFare\":38500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":20000.00,\"totalFare\":22000.00,\"baseFareYq\":20000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}}]}]}}";

    String validate_coupon_oneway = "{\"trackingId\":\"NI68d9c377be-4c4a-49e0-b917-230912163126\",\"demandContext\":{\"deviceContext\":{\"deviceId\":\"e0db0ba1-7c7f-4b1f-95b9-f2800fbb0410\"},\"userContext\":{\"userId\":65255813,\"loginStatus\":\"LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"DESKTOP\"}},\"queryContext\":{\"sector\":{\"source\":\"BLR\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":1,\"paxChild\":0,\"paxInfant\":0,\"total\":1},\"travelClass\":\"ECONOMY\",\"fareType\":\"REGULAR_FARE\",\"journeyType\":\"ONE_WAY\",\"departureDate\":{\"timestamp\":1725088651000,\"timeZone\":\"UTC\"},\"bookingDate\":{\"timestamp\":1694517069064,\"timeZone\":\"UTC\"},\"parentFareType\":\"RETAIL\"},\"couponContext\":{\"couponCodes\":[\"APITEST\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BLR_HYD_I5-1576\",\"journeys\":[{\"supplyId\":\"BLR_HYD_I5-1576|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_HYD_I5-1576|DOM|SEGMENT\",\"airline\":\"I5\",\"flightId\":\"I5-1576\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":2511,\"baseFare\":1485,\"baseFareYQ\":1485},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":2511,\"baseFare\":1485,\"baseFareYQ\":1485,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":2511,\"baseFare\":1485,\"baseFareYQ\":1485},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":2511,\"baseFare\":1485,\"baseFareYQ\":1485,\"paxCount\":1}}}}]}]}}";

    String validate_coupon_roundtrip = "{\"trackingId\":\"NI68360adc2f-94a7-4cee-9d6b-231207183434\",\"demandContext\":{\"deviceContext\":{\"deviceId\":\"f46e2a69-5c3d-4474-85d4-f32033908940\"},\"userContext\":{\"loginStatus\":\"NON_LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"DESKTOP\"}},\"queryContext\":{\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":3,\"paxChild\":1,\"paxInfant\":1,\"total\":5},\"travelClass\":\"ECONOMY\",\"fareType\":\"REGULAR_FARE\",\"journeyType\":\"ROUND_TRIP\",\"departureDate\":{\"timestamp\":1723876500000,\"timeZone\":\"UTC\"},\"returnDate\":{\"timestamp\":1725117000000,\"timeZone\":\"UTC\"},\"bookingDate\":{\"timestamp\":1701954283921,\"timeZone\":\"UTC\"},\"parentFareType\":\"RETAIL\"},\"couponContext\":{\"couponCodes\":[\"APITEST\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563\",\"journeys\":[{\"supplyId\":\"BLR_BOM_AI-622|BOM_DEL_AI-660|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_BOM_AI-622|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-622\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":21747.88,\"baseFare\":18381.600000000002,\"baseFareYQ\":18381.600000000002,\"revenue\":12150.722808000002,\"revenuePercent\":55.87083802191294},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":15282.12,\"baseFare\":12923.7,\"baseFareYQ\":12923.7,\"revenue\":8538.248511514363,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":5094.04,\"baseFare\":4307.900000000001,\"baseFareYQ\":4307.900000000001,\"revenue\":2846.0828371714547,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":1371.72,\"baseFare\":1150,\"baseFareYQ\":1150,\"revenue\":766.3914593141843,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}},{\"supplyId\":\"BOM_DEL_AI-660|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-660\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":25530.120000000003,\"baseFare\":21578.4,\"baseFareYQ\":21578.4,\"revenue\":14263.891992000003,\"revenuePercent\":55.87083802191294},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":17939.88,\"baseFare\":15171.300000000001,\"baseFareYQ\":15171.300000000001,\"revenue\":10023.161296125556,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":5979.96,\"baseFare\":5057.1,\"baseFareYQ\":5057.1,\"revenue\":3341.0537653751862,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":1610.2800000000002,\"baseFare\":1350,\"baseFareYQ\":1350,\"revenue\":899.6769304992599,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":47278,\"baseFare\":39960,\"baseFareYQ\":39960,\"revenue\":26414.614800000003,\"revenuePercent\":55.87083802191295},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":33222,\"baseFare\":28095,\"baseFareYQ\":28095,\"revenue\":18561.409807639917,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":11074,\"baseFare\":9365,\"baseFareYQ\":9365,\"revenue\":6187.1366025466405,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":2982,\"baseFare\":2500,\"baseFareYQ\":2500,\"revenue\":1666.0683898134441,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}},{\"supplyId\":\"DEL_MAA_AI-540|MAA_BLR_AI-563|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"DEL\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"DEL_MAA_AI-540|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-540\",\"stopCount\":0,\"sector\":{\"source\":\"DEL\",\"destination\":\"MAA\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":36792.857142857145,\"baseFare\":32771.42857142857,\"baseFareYQ\":32771.42857142857,\"revenue\":21845.257428571425,\"revenuePercent\":59.373636963696356},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":25997.14285714286,\"baseFare\":23239.285714285714,\"baseFareYQ\":23239.285714285714,\"revenue\":15435.44922093352,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":8665.714285714286,\"baseFare\":7746.428571428572,\"baseFareYQ\":7746.428571428572,\"revenue\":5145.149740311173,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":2130,\"baseFare\":1785.7142857142858,\"baseFareYQ\":1785.7142857142858,\"revenue\":1264.6584673267325,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}},{\"supplyId\":\"MAA_BLR_AI-563|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-563\",\"stopCount\":0,\"sector\":{\"source\":\"MAA\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":14717.142857142857,\"baseFare\":13108.571428571428,\"baseFareYQ\":13108.571428571428,\"revenue\":8738.10297142857,\"revenuePercent\":59.373636963696356},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":10398.857142857143,\"baseFare\":9295.714285714284,\"baseFareYQ\":9295.714285714284,\"revenue\":6174.179688373408,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":3466.285714285714,\"baseFare\":3098.5714285714284,\"baseFareYQ\":3098.5714285714284,\"revenue\":2058.059896124469,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":852,\"baseFare\":714.2857142857142,\"baseFareYQ\":714.2857142857142,\"revenue\":505.86338693069297,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":51510,\"baseFare\":45880,\"baseFareYQ\":45880,\"revenue\":30583.360399999998,\"revenuePercent\":59.37363696369636},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":36396,\"baseFare\":32535,\"baseFareYQ\":32535,\"revenue\":21609.628909306928,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":12132,\"baseFare\":10845,\"baseFareYQ\":10845,\"revenue\":7203.209636435643,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":2982,\"baseFare\":2500,\"baseFareYQ\":2500,\"revenue\":1770.5218542574255,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}}]},{\"solutionId\":\"BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567\",\"journeys\":[{\"supplyId\":\"BLR_HYD_6E-855|HYD_BOM_6E-267|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BLR\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_HYD_6E-855|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-855\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":13507,\"baseFare\":9928.75,\"baseFareYQ\":11098.75,\"revenue\":6508.394749999999,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":9673.21875,\"baseFare\":6989.53125,\"baseFareYQ\":7867.03125,\"revenue\":4661.073971133601,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":3224.40625,\"baseFare\":2329.84375,\"baseFareYQ\":2622.34375,\"revenue\":1553.6913237112003,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":609.375,\"baseFare\":609.375,\"baseFareYQ\":609.375,\"revenue\":293.62945515519726,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}},{\"supplyId\":\"HYD_BOM_6E-267|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-267\",\"stopCount\":0,\"sector\":{\"source\":\"HYD\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":19741,\"baseFare\":14511.25,\"baseFareYQ\":16221.25,\"revenue\":9512.26925,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":14137.78125,\"baseFare\":10215.46875,\"baseFareYQ\":11497.96875,\"revenue\":6812.338880887572,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":4712.59375,\"baseFare\":3405.15625,\"baseFareYQ\":3832.65625,\"revenue\":2270.7796269625237,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":890.625,\"baseFare\":890.625,\"baseFareYQ\":890.625,\"revenue\":429.1507421499037,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":33248,\"baseFare\":24440,\"baseFareYQ\":27320,\"revenue\":16020.663999999997,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":23811,\"baseFare\":17205,\"baseFareYQ\":19365,\"revenue\":11473.412852021173,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":7937,\"baseFare\":5735,\"baseFareYQ\":6455,\"revenue\":3824.470950673724,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":1500,\"baseFare\":1500,\"baseFareYQ\":1500,\"revenue\":722.780197305101,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}},{\"supplyId\":\"BOM_HYD_6E-5246|HYD_BLR_6E-6567|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BOM\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BOM_HYD_6E-5246|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-5246\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":15565.090909090908,\"baseFare\":12032.727272727272,\"baseFareYQ\":13603.636363636362,\"revenue\":7828.25890909091,\"revenuePercent\":50.2936921783011},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":11060.181818181818,\"baseFare\":8410.90909090909,\"baseFareYQ\":9589.090909090908,\"revenue\":5562.573797996789,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":3686.7272727272725,\"baseFare\":2803.6363636363635,\"baseFareYQ\":3196.363636363636,\"revenue\":1854.1912659989296,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":818.1818181818181,\"baseFare\":818.1818181818181,\"baseFareYQ\":818.1818181818181,\"revenue\":411.49384509519075,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}},{\"supplyId\":\"HYD_BLR_6E-6567|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-6567\",\"stopCount\":0,\"sector\":{\"source\":\"HYD\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":12970.90909090909,\"baseFare\":10027.272727272728,\"baseFareYQ\":11336.363636363636,\"revenue\":6523.54909090909,\"revenuePercent\":50.2936921783011},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":9216.818181818182,\"baseFare\":7009.090909090909,\"baseFareYQ\":7990.909090909091,\"revenue\":4635.478164997324,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":3072.272727272727,\"baseFare\":2336.3636363636365,\"baseFareYQ\":2663.6363636363635,\"revenue\":1545.1593883324413,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":681.8181818181818,\"baseFare\":681.8181818181818,\"baseFareYQ\":681.8181818181818,\"revenue\":342.9115375793256,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":28536,\"baseFare\":22060,\"baseFareYQ\":24940,\"revenue\":14351.808,\"revenuePercent\":50.29369217830109},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":20277,\"baseFare\":15420,\"baseFareYQ\":17580,\"revenue\":10198.051962994114,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":6759,\"baseFare\":5140,\"baseFareYQ\":5860,\"revenue\":3399.350654331371,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":1500,\"baseFare\":1500,\"baseFareYQ\":1500,\"revenue\":754.4053826745164,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}}]}]}}";

    String get_coupontray_coupons_oneway="{\"trackingId\":\"23456\",\"demandContext\":{\"userContext\":{\"userId\":1234,\"loginStatus\":\"LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"PWA\"},\"deviceContext\":{\"deviceId\":\"1234\",\"demandPartner\":\"DIRECT\"}},\"queryContext\":{\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":2,\"paxChild\":1,\"paxInfant\":1,\"total\":4},\"travelClass\":\"ECONOMY\",\"journeyType\":\"ROUND_TRIP\",\"fareType\":\"REGULAR_FARE\",\"departureDate\":{\"timestamp\":1725088651000,\"timeZone\":\"Asia/Kolkata\"},\"returnDate\":{\"timestamp\":1725001178000,\"timeZone\":\"Asia/Kolkata\"},\"bookingDate\":{\"timestamp\":1699261531000,\"timeZone\":\"Asia/Kolkata\"}},\"couponContext\":{\"couponCodes\":[\"CTRBD\",\"CTTRAY\",\"REDEEMTEST\",\"APITEST\",\"CTTESTING\",\"CTRPS\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BLR_GOI_SG-756|HYD_DEL_SG-756|DEL_BLR_SG-776\",\"journeys\":[{\"supplyId\":\"BOM_DEL_SG-756|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":false,\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_DEL_SG-756|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-756\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":35000.00,\"totalFare\":38500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":20000.00,\"totalFare\":22000.00,\"baseFareYq\":20000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}},{\"supplyId\":\"DEL_HYD_SG-757|HYD_BOM_SG-776|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":2,\"sector\":{\"source\":\"DEL\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"DEL_HYD_SG-757|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-757\",\"stopCount\":0,\"sector\":{\"source\":\"DEL\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}},{\"supplyId\":\"HYD_BOM_SG-776|DOM|SEGMENT\",\"airline\":\"SG\",\"flightId\":\"SG-776\",\"stopCount\":0,\"sector\":{\"source\":\"HYD\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":17500.00,\"totalFare\":19250.00,\"baseFareYq\":17500.00,\"revenue\":3500.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":2500.00,\"totalFare\":2750.00,\"baseFareYq\":2500.00,\"revenue\":500.00,\"revenuePercent\":20.0}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"baseFare\":35000.00,\"totalFare\":38500.00,\"baseFareYq\":35000.00,\"revenue\":7000.00,\"revenuePercent\":20.0},\"paxPricingInfos\":{\"ADT\":{\"paxCount\":2,\"baseFare\":20000.00,\"totalFare\":22000.00,\"baseFareYq\":20000.00,\"revenue\":4000.00,\"revenuePercent\":20.0},\"CHD\":{\"paxCount\":1,\"baseFare\":10000.00,\"totalFare\":11000.00,\"baseFareYq\":10000.00,\"revenue\":2000.00,\"revenuePercent\":20.0},\"INF\":{\"paxCount\":1,\"baseFare\":5000.00,\"totalFare\":5500.00,\"baseFareYq\":5000.00,\"revenue\":1000.00,\"revenuePercent\":20}}}}]}]}}";

    String get_coupontray_coupons_rountrip="{\"trackingId\":\"NI68360adc2f-94a7-4cee-9d6b-231207183434\",\"demandContext\":{\"deviceContext\":{\"deviceId\":\"f46e2a69-5c3d-4474-85d4-f32033908940\"},\"userContext\":{\"loginStatus\":\"NON_LOGGED_IN\",\"trafficOrigin\":\"CT\"},\"appContext\":{\"channel\":\"DESKTOP\"}},\"queryContext\":{\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"paxInfo\":{\"paxAdult\":3,\"paxChild\":1,\"paxInfant\":1,\"total\":5},\"travelClass\":\"ECONOMY\",\"fareType\":\"REGULAR_FARE\",\"journeyType\":\"ROUND_TRIP\",\"departureDate\":{\"timestamp\":1723876500000,\"timeZone\":\"UTC\"},\"returnDate\":{\"timestamp\":1725117000000,\"timeZone\":\"UTC\"},\"bookingDate\":{\"timestamp\":1701954283921,\"timeZone\":\"UTC\"},\"parentFareType\":\"RETAIL\"},\"couponContext\":{\"couponCodes\":[\"APITEST\",\"CTTRAY\",\"REDEEMTEST\",\"CTRBD\",\"CTRPS\"]},\"supplyContext\":{\"solutions\":[{\"solutionId\":\"BLR_BOM_AI-622|BOM_DEL_AI-660|DEL_MAA_AI-540|MAA_BLR_AI-563\",\"journeys\":[{\"supplyId\":\"BLR_BOM_AI-622|BOM_DEL_AI-660|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BLR\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_BOM_AI-622|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-622\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":21747.88,\"baseFare\":18381.600000000002,\"baseFareYQ\":18381.600000000002,\"revenue\":12150.722808000002,\"revenuePercent\":55.87083802191294},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":15282.12,\"baseFare\":12923.7,\"baseFareYQ\":12923.7,\"revenue\":8538.248511514363,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":5094.04,\"baseFare\":4307.900000000001,\"baseFareYQ\":4307.900000000001,\"revenue\":2846.0828371714547,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":1371.72,\"baseFare\":1150,\"baseFareYQ\":1150,\"revenue\":766.3914593141843,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}},{\"supplyId\":\"BOM_DEL_AI-660|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-660\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"DEL\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":25530.120000000003,\"baseFare\":21578.4,\"baseFareYQ\":21578.4,\"revenue\":14263.891992000003,\"revenuePercent\":55.87083802191294},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":17939.88,\"baseFare\":15171.300000000001,\"baseFareYQ\":15171.300000000001,\"revenue\":10023.161296125556,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":5979.96,\"baseFare\":5057.1,\"baseFareYQ\":5057.1,\"revenue\":3341.0537653751862,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":1610.2800000000002,\"baseFare\":1350,\"baseFareYQ\":1350,\"revenue\":899.6769304992599,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":47278,\"baseFare\":39960,\"baseFareYQ\":39960,\"revenue\":26414.614800000003,\"revenuePercent\":55.87083802191295},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":33222,\"baseFare\":28095,\"baseFareYQ\":28095,\"revenue\":18561.409807639917,\"revenuePercent\":55.87083802191294,\"paxCount\":3},\"CHD\":{\"totalFare\":11074,\"baseFare\":9365,\"baseFareYQ\":9365,\"revenue\":6187.1366025466405,\"revenuePercent\":55.87083802191295,\"paxCount\":1},\"INF\":{\"totalFare\":2982,\"baseFare\":2500,\"baseFareYQ\":2500,\"revenue\":1666.0683898134441,\"revenuePercent\":55.87083802191295,\"paxCount\":1}}}},{\"supplyId\":\"DEL_MAA_AI-540|MAA_BLR_AI-563|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"DEL\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"DEL_MAA_AI-540|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-540\",\"stopCount\":0,\"sector\":{\"source\":\"DEL\",\"destination\":\"MAA\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":36792.857142857145,\"baseFare\":32771.42857142857,\"baseFareYQ\":32771.42857142857,\"revenue\":21845.257428571425,\"revenuePercent\":59.373636963696356},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":25997.14285714286,\"baseFare\":23239.285714285714,\"baseFareYQ\":23239.285714285714,\"revenue\":15435.44922093352,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":8665.714285714286,\"baseFare\":7746.428571428572,\"baseFareYQ\":7746.428571428572,\"revenue\":5145.149740311173,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":2130,\"baseFare\":1785.7142857142858,\"baseFareYQ\":1785.7142857142858,\"revenue\":1264.6584673267325,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}},{\"supplyId\":\"MAA_BLR_AI-563|DOM|SEGMENT\",\"airline\":\"AI\",\"flightId\":\"AI-563\",\"stopCount\":0,\"sector\":{\"source\":\"MAA\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":14717.142857142857,\"baseFare\":13108.571428571428,\"baseFareYQ\":13108.571428571428,\"revenue\":8738.10297142857,\"revenuePercent\":59.373636963696356},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":10398.857142857143,\"baseFare\":9295.714285714284,\"baseFareYQ\":9295.714285714284,\"revenue\":6174.179688373408,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":3466.285714285714,\"baseFare\":3098.5714285714284,\"baseFareYQ\":3098.5714285714284,\"revenue\":2058.059896124469,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":852,\"baseFare\":714.2857142857142,\"baseFareYQ\":714.2857142857142,\"revenue\":505.86338693069297,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":51510,\"baseFare\":45880,\"baseFareYQ\":45880,\"revenue\":30583.360399999998,\"revenuePercent\":59.37363696369636},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":36396,\"baseFare\":32535,\"baseFareYQ\":32535,\"revenue\":21609.628909306928,\"revenuePercent\":59.373636963696356,\"paxCount\":3},\"CHD\":{\"totalFare\":12132,\"baseFare\":10845,\"baseFareYQ\":10845,\"revenue\":7203.209636435643,\"revenuePercent\":59.37363696369636,\"paxCount\":1},\"INF\":{\"totalFare\":2982,\"baseFare\":2500,\"baseFareYQ\":2500,\"revenue\":1770.5218542574255,\"revenuePercent\":59.37363696369636,\"paxCount\":1}}}}]},{\"solutionId\":\"BLR_HYD_6E-855|HYD_BOM_6E-267|BOM_HYD_6E-5246|HYD_BLR_6E-6567\",\"journeys\":[{\"supplyId\":\"BLR_HYD_6E-855|HYD_BOM_6E-267|DOM|JOURNEY\",\"tripType\":\"ONWARD\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BLR\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BLR_HYD_6E-855|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-855\",\"stopCount\":0,\"sector\":{\"source\":\"BLR\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":13507,\"baseFare\":9928.75,\"baseFareYQ\":11098.75,\"revenue\":6508.394749999999,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":9673.21875,\"baseFare\":6989.53125,\"baseFareYQ\":7867.03125,\"revenue\":4661.073971133601,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":3224.40625,\"baseFare\":2329.84375,\"baseFareYQ\":2622.34375,\"revenue\":1553.6913237112003,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":609.375,\"baseFare\":609.375,\"baseFareYQ\":609.375,\"revenue\":293.62945515519726,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}},{\"supplyId\":\"HYD_BOM_6E-267|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-267\",\"stopCount\":0,\"sector\":{\"source\":\"HYD\",\"destination\":\"BOM\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":19741,\"baseFare\":14511.25,\"baseFareYQ\":16221.25,\"revenue\":9512.26925,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":14137.78125,\"baseFare\":10215.46875,\"baseFareYQ\":11497.96875,\"revenue\":6812.338880887572,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":4712.59375,\"baseFare\":3405.15625,\"baseFareYQ\":3832.65625,\"revenue\":2270.7796269625237,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":890.625,\"baseFare\":890.625,\"baseFareYQ\":890.625,\"revenue\":429.1507421499037,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":33248,\"baseFare\":24440,\"baseFareYQ\":27320,\"revenue\":16020.663999999997,\"revenuePercent\":48.185346487006726},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":23811,\"baseFare\":17205,\"baseFareYQ\":19365,\"revenue\":11473.412852021173,\"revenuePercent\":48.185346487006726,\"paxCount\":3},\"CHD\":{\"totalFare\":7937,\"baseFare\":5735,\"baseFareYQ\":6455,\"revenue\":3824.470950673724,\"revenuePercent\":48.18534648700673,\"paxCount\":1},\"INF\":{\"totalFare\":1500,\"baseFare\":1500,\"baseFareYQ\":1500,\"revenue\":722.780197305101,\"revenuePercent\":48.18534648700673,\"paxCount\":1}}}},{\"supplyId\":\"BOM_HYD_6E-5246|HYD_BLR_6E-6567|DOM|JOURNEY\",\"tripType\":\"RETURN\",\"fareBreakup\":true,\"stopCount\":1,\"sector\":{\"source\":\"BOM\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"flights\":[{\"supplyId\":\"BOM_HYD_6E-5246|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-5246\",\"stopCount\":0,\"sector\":{\"source\":\"BOM\",\"destination\":\"HYD\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":15565.090909090908,\"baseFare\":12032.727272727272,\"baseFareYQ\":13603.636363636362,\"revenue\":7828.25890909091,\"revenuePercent\":50.2936921783011},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":11060.181818181818,\"baseFare\":8410.90909090909,\"baseFareYQ\":9589.090909090908,\"revenue\":5562.573797996789,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":3686.7272727272725,\"baseFare\":2803.6363636363635,\"baseFareYQ\":3196.363636363636,\"revenue\":1854.1912659989296,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":818.1818181818181,\"baseFare\":818.1818181818181,\"baseFareYQ\":818.1818181818181,\"revenue\":411.49384509519075,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}},{\"supplyId\":\"HYD_BLR_6E-6567|DOM|SEGMENT\",\"airline\":\"6E\",\"flightId\":\"6E-6567\",\"stopCount\":0,\"sector\":{\"source\":\"HYD\",\"destination\":\"BLR\",\"sectorType\":\"DOM\"},\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":12970.90909090909,\"baseFare\":10027.272727272728,\"baseFareYQ\":11336.363636363636,\"revenue\":6523.54909090909,\"revenuePercent\":50.2936921783011},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":9216.818181818182,\"baseFare\":7009.090909090909,\"baseFareYQ\":7990.909090909091,\"revenue\":4635.478164997324,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":3072.272727272727,\"baseFare\":2336.3636363636365,\"baseFareYQ\":2663.6363636363635,\"revenue\":1545.1593883324413,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":681.8181818181818,\"baseFare\":681.8181818181818,\"baseFareYQ\":681.8181818181818,\"revenue\":342.9115375793256,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}}],\"pricingContext\":{\"bookingPricingInfo\":{\"totalFare\":28536,\"baseFare\":22060,\"baseFareYQ\":24940,\"revenue\":14351.808,\"revenuePercent\":50.29369217830109},\"paxPricingInfos\":{\"ADT\":{\"totalFare\":20277,\"baseFare\":15420,\"baseFareYQ\":17580,\"revenue\":10198.051962994114,\"revenuePercent\":50.2936921783011,\"paxCount\":3},\"CHD\":{\"totalFare\":6759,\"baseFare\":5140,\"baseFareYQ\":5860,\"revenue\":3399.350654331371,\"revenuePercent\":50.2936921783011,\"paxCount\":1},\"INF\":{\"totalFare\":1500,\"baseFare\":1500,\"baseFareYQ\":1500,\"revenue\":754.4053826745164,\"revenuePercent\":50.29369217830109,\"paxCount\":1}}}}]}]}}";

    String create_draftrule_pricing="{\"ruleDescription\":\"test api automation pricing rules\",\"team\":1,\"ruleType\":\"PRICING\",\"startDate\":\"1701973800000\",\"endDate\":\"1727720940000\",\"timeSlots\":[{\"startTime\":\"00:00\",\"endTime\":\"23:59\"}]}";

    String create_draftrule_bcf="{\"ruleDescription\":\"test automation bcf rule\",\"team\":1,\"ruleType\":\"BASE_CONVENIENCE_FEE\",\"startDate\":\"1697653800000\",\"endDate\":\"1725088651000\",\"subTypeMetaInfo\":{\"type\":\"BCF_INFO\",\"demandChannel\":[\"META\",\"DIRECT\"]}}";

    String create_supply_criteria="{\"teamId\":1,\"catalogId\":\"SUPPLY-CRITERIA-AIR\",\"criteriaType\":\"SUPPLY\",\"fields\":[{\"elementId\":\"SC-ELEMENT-SECTOR-TYPE\",\"values\":[\"DOMESTIC\",\"INTL_DOM\",\"INTL_INBOUND\",\"INTL_OUTBOUND\",\"INTL_SOTO\"]},{\"elementId\":\"SC-ELEMENT-SUPPLY-TARGETING-LEVEL\",\"values\":[\"JOURNEY\",\"SEGMENT\"]}]}";
}
