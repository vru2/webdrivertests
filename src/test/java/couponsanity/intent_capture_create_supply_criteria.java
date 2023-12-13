package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_capture_create_supply_criteria extends Coupon_Common{
    @Test
    public void create_supply_criteria()
    {
        Response resp;
        resp=TCMS_Serving_POSTCall(create_supply_criteria,headersForPatchcall(),GODFATHER+tcms_create_supply_criteria);
        validate_Supply_Criteria(resp);
    }
}
