package test.java.coupons;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TCMS_UPDATE_CRITERIA extends Coupon_Common {
    Response resp;
    String url=TCMS_CRITERIA_ENDPOINT+tcms_update_criteria;
    @Test
    public void update_criteria() throws SQLException, ClassNotFoundException {
      resp=TCMS_Update_PutCall(put_criteria,headersForpostcall(),url);
      Validate_Update_Criteria(resp);
    }

}
