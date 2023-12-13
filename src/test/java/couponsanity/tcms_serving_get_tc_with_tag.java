package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class tcms_serving_get_tc_with_tag extends Coupon_Common{
    @Test
    public void get_tc_without_tag_with_qosTier_Secondary()
    {
        Response resp;
        resp= TCMS_Serving_POSTCall(get_criteria_ids_with_tag_with_field_qosTier_Secondary,headersForpost(),TCMS_SERVING_ENDPOINT+tcms_serving_get_tc);
        Fetch_Criteriaid(resp,"without_tag_with_qosTier_Secondary");
    }
}