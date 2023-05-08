package test.java.coupons;

import io.restassured.response.Response;
import org.junit.Test;

import java.sql.SQLException;

public class TCMS_CLONE_CRITERIA extends Coupon_Common{

    Response resp;
    String url=TCMS_CRITERIA_ENDPOINT+tcms_create_criteria;

    @Test
    public void clone_criteria() throws SQLException, ClassNotFoundException {
        resp=TCMS_Clone_PostCall("",headersForpostcall(),url);
        Clonecriteriabyid(resp);
    }

}
