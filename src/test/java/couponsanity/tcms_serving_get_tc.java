package test.java.couponsanity;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class tcms_serving_get_tc extends Coupon_Common{
    @Test
    public void get_tc()
    {
        Response resp;
        resp= TCMS_Serving_POSTCall(get_criteria_ids,headersForpost(),TCMS_SERVING_ENDPOINT+tcms_serving_get_tc);
        Fetch_Criteriaid(resp,"redis");
    }
}
