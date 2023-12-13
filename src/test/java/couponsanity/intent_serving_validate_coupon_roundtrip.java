package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class intent_serving_validate_coupon_roundtrip extends Coupon_Common{

    @Test(priority = 0)
    public void validate_coupon_oneway_srp()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_roundtrip,headersForpostIS(),INTENT_SERVING+intent_serving_validate_coupon_srp);
        validate_coupon_validation(resp,"round_trip","round_trip_srp");
    }
    @Test(priority = 1)
    public void validate_coupon_roundtrip_itinerary()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_roundtrip,headersForpostISvalidate(),INTENT_SERVING+intent_serving_validate_coupon_itinerary);
        validate_coupon_validation(resp,"round_trip","round_trip_itinerary");
    }
    @Test (priority = 2)
    public void validate_coupon_roundtrip_payment()
    {
        Response resp;
        resp=INTENT_Serving_POSTCall(validate_coupon_roundtrip,headersForpostISvalidate(),INTENT_SERVING+intent_serving_validate_coupon_payment);
        validate_coupon_validation(resp,"round_trip","round_trip_payment");
    }
}
