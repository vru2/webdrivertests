package test.java.coupons;

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
import static org.testng.Assert.assertTrue;

public class Coupon_Common extends PlatformCommonUtil {

    public Response resp;
    public String criteria_id;

    String criteriaid="1222";
    public String TCMS_CATALOG_ENDPOINT="http://sniper-catalog-api.cltp.com:9001";
    public String TCMS_CRITERIA_ENDPOINT="http://sniper-manager-service-api.cltp.com:9001";
    public String TCMS_VIEW_CATALOG_MODULE_ENDPOINT="http://sniper-view-module.cltp.com:9001";

    String tcms_get_catalog="/catalogs/SUPPLY-CRITERIA-AIR";
    String tcms_create_criteria="/criteria";
    String tcms_update_criteria="/criteria/"+criteriaid;
    String tcms_fetch_criteria_id="/criteria/"+criteriaid;
    String tcms_fetch_view_catalog_criteria_byid="/tcms/manager/api/catalogs/criteria/"+criteriaid;
    String tcms_activate_api="/criteria/activate/"+criteriaid;
    String tcms_deactivate_api="/criteria/deactivate/"+criteriaid;


    public HashMap<String, Object> headersForpostcall(){
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIwZTZlODJlYS0wNjljLTRiZDUtOTE4NC1jYjRmMTM2YzkyZjIiLCJ1c2VyQ2xhaW0iOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6InNoYXNoaWthbnRoLmdAY2xlYXJ0cmlwLmNvbSIsInRlYW1JZHMiOlsyLDFdLCJhdXRob3JpdGllcyI6W119LCJpc3MiOiJDVCIsImlhdCI6MTY3NDQ1NTQwOX0.WgDH1A163eopxh7LKbj3v7-2MyEg8S6uw-OAIcXEZhALDSPbQ39g0qQ_YpA_okypJryVs7L999BHZ05PV7hcZkjtWYn9SF1E9oOtmAdZwU-FC4ptA_GOW8Dt2ud-P8lHlZpOn9TOYz8l4_ZwubH912Bu47GZyYVOTkfNRYJPEZMpXDqAQeNDId_S2Po1TEFMIb7miHQ9o6dWM5dZ0YIbLgBR_Q7SpCKtTchCkXrp3liOhqXQp_F3BtmnXJsynSEnHDi0oeLEXJCtKRmmA_fitYizXNEtGmzrIEE0Fbn_Gtkrr5_h0BZIs_lLR-YnAhKnMjnz8IH4oZIy36f-wtVLeA");
        return headers;

    }

    public HashMap<String, Object> headersForPatchcall(){
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIwZTZlODJlYS0wNjljLTRiZDUtOTE4NC1jYjRmMTM2YzkyZjIiLCJ1c2VyQ2xhaW0iOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6InNoYXNoaWthbnRoLmdAY2xlYXJ0cmlwLmNvbSIsInRlYW1JZHMiOlsyLDFdLCJhdXRob3JpdGllcyI6W119LCJpc3MiOiJDVCIsImlhdCI6MTY3NDQ1NTQwOX0.WgDH1A163eopxh7LKbj3v7-2MyEg8S6uw-OAIcXEZhALDSPbQ39g0qQ_YpA_okypJryVs7L999BHZ05PV7hcZkjtWYn9SF1E9oOtmAdZwU-FC4ptA_GOW8Dt2ud-P8lHlZpOn9TOYz8l4_ZwubH912Bu47GZyYVOTkfNRYJPEZMpXDqAQeNDId_S2Po1TEFMIb7miHQ9o6dWM5dZ0YIbLgBR_Q7SpCKtTchCkXrp3liOhqXQp_F3BtmnXJsynSEnHDi0oeLEXJCtKRmmA_fitYizXNEtGmzrIEE0Fbn_Gtkrr5_h0BZIs_lLR-YnAhKnMjnz8IH4oZIy36f-wtVLeA");
        return headers;
    }

    public Response TCMS_Create_PostCall(String params, HashMap<String, Object> headers, String url){
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                post(url);
        return resp;
    }

    public Response TCMS_Update_PutCall(String params, HashMap<String,Object> headers,String url)
    {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                headers(headers).
                put(url);
        return resp;
    }

    public Response TCMS_Clone_PostCall(String params, HashMap<String,Object> headers,String url)
    {
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                body(params).
                queryParam("sourceId",criteriaid).
                headers(headers).
                post(url);
        return resp;
    }

    public Response TCMS_Activate_PutCall(HashMap<String,Object> headers, String url){
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                put(url);
        return resp;
    }

    public Response TCMS_Deactivate_PatchCall(HashMap<String,Object> headers, String url){
        Response resp;
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                patch(url);
        return resp;
    }

    public Response validatefecth_catalogue(Response resp)
    {
        if(resp.statusCode()==200)
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body= resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message=jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true ,"Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message,"successfully fetched catalog for catalogId : SUPPLY-CRITERIA-AIR","String matches");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Validate_Create_Criteria(Response resp) throws SQLException, ClassNotFoundException {
        if(resp.statusCode()==200)
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body= resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message=jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true ,"Response boday contains response");
            Assert.assertNotNull("response");
            criteria_id = jsonPath.getString("response.id");
            String status=jsonPath.getString("response.status");
            System.out.println("Supply Criteria with ID: "+criteria_id+" and Status: "+status);
            Reporter.log("Supply Criteria with ID: "+criteria_id+" and Status: "+status);
            Assert.assertEquals(message,"Criteria creation successful for Id: "+criteria_id,"String matches");
            //DB Validation
            ArrayList<String> supplycriteria=db_criteria(criteria_id);
            String supply_criteria_id=supplycriteria.get(0);
            String supply_criteria_status=supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id,criteria_id,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,status,"Database record exists for the created id");
            System.out.println("Database record exists for the created id");
            Reporter.log("Database record exists for the created id");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Validate_Update_Criteria(Response resp) throws SQLException, ClassNotFoundException {
        if(resp.statusCode()==200)
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body= resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message=jsonPath.getString("message");
            System.out.println(message);
            Assert.assertEquals(bodyAsString.contains("response"), true ,"Response boday contains response");
            Assert.assertNotNull("response");
            criteria_id = jsonPath.getString("response.id");
            String status=jsonPath.getString("response.status");
            System.out.println("Supply Criteria with ID: "+criteria_id+" and Status: "+status);
            Reporter.log("Supply Criteria with ID: "+criteria_id+" and Status: "+status);
            Assert.assertEquals(message,"Criteria Updated Successfully for Id: "+criteria_id+" ","String matches");
            //DB Validation
            ArrayList<String> supplycriteria=db_criteria(criteria_id);
            String supply_criteria_id=supplycriteria.get(0);
            String supply_criteria_status=supplycriteria.get(6);

            Assert.assertEquals(supply_criteria_id,criteria_id,"Database record updated for the id");
            Assert.assertEquals(supply_criteria_status,status,"Database record updated for the id");
            System.out.println("Database record updated for the id");
            Reporter.log("Database record updated for the  id");
            db_update_criteria(criteria_id);
            ArrayList criteria_details= db_criteria(criteria_id);
            String criteria_json= (String) criteria_details.get(9);
            System.out.println(criteria_json);
            Reporter.log(criteria_json);
            System.out.println("Updated value resetted in DB");
            Reporter.log("Updated value resetted in DB");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Fetch_Selectioncriteriaid(Response resp)
    {
        if(resp.statusCode()==200) {
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
            Assert.assertEquals(rulesid,criteriaid,"ruleid fetched matches with the given ruleid");
            System.out.println("Ruleid:"+rulesid+" fetched matches with the given Ruleid:" +criteriaid);
            Reporter.log("Ruleid:"+rulesid+" fetched matches with the given Ruleid:" +criteriaid);
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Fetch_Viewcatalogcriteriabyid(Response resp)
    {
        if(resp.statusCode()==200) {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String response = jsonPath.getString("response");
            String rulesid = jsonPath.getString("response.displayAttributes");
            String children=jsonPath.getString("response.children");
            System.out.println("Response of response object: "+response);
            Reporter.log("Response of response object: "+response);
            System.out.println("Response of children object in response: "+children);
            Reporter.log("Response of children object in response: "+children);
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertNotNull("response.children");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    public Response Clonecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if(resp.statusCode()==200)
        {
        Reporter.log("Status code " + resp.statusCode());
        System.out.println("Status code " + resp.statusCode());
        Reporter.log(resp.asString());
        System.out.println(resp.asString());
        ResponseBody body = resp.getBody();
        String bodyAsString = body.asString();
        JsonPath jsonPath = new JsonPath(bodyAsString);
        String message = jsonPath.getString("message");
        System.out.println(message);
        String id=jsonPath.getString("response.id");
        String status=jsonPath.getString("response.status");
        Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
        Assert.assertNotNull("response");
        Assert.assertEquals(message, "Criteria cloned successfully for Id: "+criteriaid, "String matches");
        System.out.println("Successfully cloned RuleID: "+criteriaid+" to RuleID: "+id+" with Status: "+status);
        Reporter.log("Successfully cloned RuleID: "+criteriaid+" to RuleID: "+id+" with Status: "+status);
        //db validation
            ArrayList<String> supplycriteria=db_criteria(id);
            String supply_criteria_id=supplycriteria.get(0);
            String supply_criteria_status=supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id,id,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,status,"Database record exists for the created id");
            System.out.println("Database record exists for the created id");
            Reporter.log("Database record exists for the created id");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    //Activate CRITERIA

    public Response activatecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if(resp.statusCode()==200)
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            String id=jsonPath.getString("response.id");
            String status=jsonPath.getString("response.status");
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "criteria status changed to active successfully for Id: " +criteriaid, "String matches");
            System.out.println("Successfully activated RuleID: "+criteriaid+" with Status: "+status);
            Reporter.log("Successfully activated RuleID: "+criteriaid+" with Status: "+status);
            //db validation
            ArrayList<String> supplycriteria=db_criteria(id);
            String supply_criteria_id=supplycriteria.get(0);
            String supply_criteria_status=supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id,id,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,status,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,"ACTIVE","DB Status is ACTIVE");
            System.out.println("Status of the criteria is changed to ACTIVE");
            Reporter.log("Status of the criteria is changed to ACTIVE");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
        }
        return resp;
    }

    //DEACTIVATE CRITERIA
    public Response deactivatecriteriabyid(Response resp) throws SQLException, ClassNotFoundException {
        if(resp.statusCode()==200)
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code " + resp.statusCode());
            Reporter.log(resp.asString());
            System.out.println(resp.asString());
            ResponseBody body = resp.getBody();
            String bodyAsString = body.asString();
            JsonPath jsonPath = new JsonPath(bodyAsString);
            String message = jsonPath.getString("message");
            System.out.println(message);
            String id=jsonPath.getString("response.id");
            String status=jsonPath.getString("response.status");
            Assert.assertEquals(bodyAsString.contains("response"), true, "Response boday contains response");
            Assert.assertNotNull("response");
            Assert.assertEquals(message, "criteria status changed to inactive successfully for Id: " +criteriaid+" ", "String matches");
            System.out.println("Successfully inactivated RuleID: "+criteriaid+" with Status: "+status);
            Reporter.log("Successfully inactivated RuleID: "+criteriaid+" with Status: "+status);
            //db validation
            ArrayList<String> supplycriteria=db_criteria(id);
            String supply_criteria_id=supplycriteria.get(0);
            String supply_criteria_status=supplycriteria.get(6);
            Assert.assertEquals(supply_criteria_id,id,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,status,"Database record exists for the created id");
            Assert.assertEquals(supply_criteria_status,"INACTIVE","DB Status is ACTIVE");
            System.out.println("Status of the criteria is changed to INACTIVE");
            Reporter.log("Status of the criteria is changed to INACTIVE");
        }
        else
        {
            Reporter.log("Status code " + resp.statusCode());
            System.out.println("Status code: "+resp.statusCode());
            assertTrue(false);
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
            String query =  "SELECT * FROM CRITERIA WHERE ID= '" + id +"'";
            Connection myCon = DriverManager.getConnection(url,user,password);
            if (myCon != null) {
                ResultSet myRes = myCon.createStatement().executeQuery(query);
                while (myRes.next() == true) {
                    ResultSetMetaData result = myRes.getMetaData();
                    int noOfColumns = result.getColumnCount();
                    int noOfRows  = myRes.getRow();
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
            String query =  "UPDATE CRITERIA SET CRITERIA_JSON='"+DB_CRITERIA_JSON+"'WHERE ID= '" + id +"'";
            Connection myCon = DriverManager.getConnection(url,user,password);
            if (myCon != null) {
                ResultSet myRes = myCon.createStatement().executeQuery(query);
                while (myRes.next() == true) {
                    ResultSetMetaData result = myRes.getMetaData();
                    int noOfColumns = result.getColumnCount();
                    int noOfRows  = myRes.getRow();
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

    String create_criteria="{\"teamId\":\"1\",\"catalogId\":\"SUPPLY-CRITERIA-AIR\",\"criteriaType\":\"SUPPLY\",\"description\":\"this includes certain supply criteria\",\"fields\":[{\"fieldName\":\"Airline\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-AIRLINE\",\"values\":[\"6E\",\"B3\"]},{\"fieldName\":\"flight_type\",\"operator\":\"EXCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-TYPE\",\"values\":[\"international\"]},{\"fieldName\":\"sector\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-SECTOR\",\"values\":[\"BOM-DEL\",\"DEL-ALL\",\"ALL-DEL\"]},{\"fieldName\":\"flight no\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-CODE\",\"values\":[\"6E-145\",\"6E-567\"]}]}";
    String put_criteria="{\"fields\":[{\"fieldName\":\"Airline\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-AIRLINE\",\"values\":[\"6E\",\"B3\"]},{\"fieldName\":\"flight_type\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-TYPE\",\"values\":[\"domestic\",\"international\"]},{\"fieldName\":\"sector\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-SECTOR\",\"values\":[\"BOM-DEL\",\"DEL-ALL\",\"ALL-DEL\"]},{\"fieldName\":\"flight no\",\"operator\":\"INCLUDES\",\"elementId\":\"SC-ELEMENT-FLIGHT-CODE\",\"values\":[\"6E-145\",\"6E-567\"]}]}";
    String DB_CRITERIA_JSON="[{\"values\": [\"6E\", \"B3\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-AIRLINE\"}, {\"values\": [\"international\"], \"operator\": \"EXCULDES\", \"elementId\": \"SC-ELEMENT-FLIGHT-TYPE\"}, {\"values\": [\"BOM-DEL\", \"DEL-ALL\", \"ALL-DEL\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-SECTOR\"}, {\"values\": [\"6E-145\", \"6E-567\"], \"operator\": \"INCLUDES\", \"elementId\": \"SC-ELEMENT-FLIGHT-CODE\"}]";
}
