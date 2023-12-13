package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_serving_get_coupon_roundtrip extends Coupon_Common{
    @Test(priority = 0)
    public void get_coupon_roundtrip_srp()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_roundtrip,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_srp);
        System.out.println(resp.asString());
        get_coupon_validation(resp,"round_trip","round_trip_srp");
    }
    @Test (priority = 1)
    public void get_coupon_roundtrip_itinerary()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_roundtrip,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_itinerary);
        System.out.println(resp.asString());
        get_coupon_validation(resp,"round_trip","round_trip_itinerary");
    }
    @Test (priority = 2)
    public void get_coupon_roundtrip_payment()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(get_coupon_roundtrip,headersForpostIS(),INTENT_SERVING+intent_serving_get_coupon_payment);
        System.out.println(resp.asString());
        get_coupon_validation(resp,"round_trip","round_trip_payment");

    }
}
