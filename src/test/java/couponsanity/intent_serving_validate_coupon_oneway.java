package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_serving_validate_coupon_oneway extends Coupon_Common{

    @Test(priority = 0)
    public void validate_coupon_oneway_srp()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_oneway,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_srp);
        validate_coupon_validation(resp,"one_way","one_way_srp");
    }
    @Test(priority = 1)
    public void validate_coupon_oneway_itinerary()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_oneway,headersForpostISvalidate(),INTENT_SERVING+intent_serving_validate_coupon_itinerary);
        validate_coupon_validation(resp,"one_way","one_way_itinerary");
    }
    @Test (priority = 2)
    public void validate_coupon_oneway_payment()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_oneway,headersForpostISvalidate(),INTENT_SERVING+intent_serving_validate_coupon_payment);
        validate_coupon_validation(resp,"one_way","one_way_payment");
    }
}
