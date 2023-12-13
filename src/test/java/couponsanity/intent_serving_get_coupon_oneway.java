package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_serving_get_coupon_oneway extends Coupon_Common{
    @Test(priority = 0)
    public void get_coupon_oneway_srp()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_oneway,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_srp);
        get_coupon_validation(resp,"one_way","one_way_srp");
    }
    @Test (priority = 1)
    public void get_coupon_oneway_itinerary()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_oneway,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_itinerary);
        System.out.println(resp.asString());
        get_coupon_validation(resp,"one_way","one_way_itinerary");
    }
    @Test (priority = 2)
    public void get_coupon_oneway_payment()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_oneway,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_payment);
        System.out.println(resp.asString());
        get_coupon_validation(resp,"one_way","one_way_payment");
    }
}
