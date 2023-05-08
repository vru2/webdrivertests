package test.java.coupons;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TCMS_ACTIVATE_CRITERIA extends Coupon_Common{
    Response resp;
    String url=TCMS_CRITERIA_ENDPOINT+tcms_activate_api;
    @Test
    public void activate_criteria() throws SQLException, ClassNotFoundException {
        resp = TCMS_Activate_PutCall(headersForPatchcall(),url);
        System.out.println(criteria_id);
        activatecriteriabyid(resp);
    }
}
