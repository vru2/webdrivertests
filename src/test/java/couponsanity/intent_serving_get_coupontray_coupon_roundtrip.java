package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_serving_get_coupontray_coupon_roundtrip extends Coupon_Common{
    @Test(priority = 0)
    public void get_coupontray_coupon_roundtrip()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupontray_coupons_rountrip,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupontray_coupons);
        validate_coupontray_coupons(resp,"round_trip");
    }
}
