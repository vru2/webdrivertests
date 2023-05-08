package test.java.coupons;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TCMS_CREATE_CRITERIA extends Coupon_Common{
    Response resp;
    String url=TCMS_CRITERIA_ENDPOINT+tcms_create_criteria;
    @Test
    public void create_criteria() throws SQLException, ClassNotFoundException {
        resp = TCMS_Create_PostCall(create_criteria, headersForpostcall(), url);
        Validate_Create_Criteria(resp);
    }

}
