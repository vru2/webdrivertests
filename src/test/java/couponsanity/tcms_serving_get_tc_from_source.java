package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class tcms_serving_get_tc_from_source extends Coupon_Common{
    @Test
    public void get_tc_from_source()
    {
        Response resp;
        resp= TCMS_Serving_POSTCall(get_criteria_ids,headersForpost(),TCMS_SERVING_ENDPOINT+tcms_serving_get_tc_from_source);
        Fetch_Criteriaid(resp,"solr");
    }
}
