package test.java.coupons;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TCMS_DEACTIVATE_CRITERIA extends Coupon_Common{
    Response resp;
    String url=TCMS_CRITERIA_ENDPOINT+tcms_deactivate_api;
    @Test
    public void deactivate_criteria() throws SQLException, ClassNotFoundException {
        resp = TCMS_Deactivate_PatchCall(headersForPatchcall(),url);
        System.out.println(criteria_id);
        deactivatecriteriabyid(resp);
    }
}
