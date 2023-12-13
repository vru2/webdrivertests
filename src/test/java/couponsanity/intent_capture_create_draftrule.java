package test.java.couponsanity;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class intent_capture_create_draftrule extends Coupon_Common {

    @Test(priority=0)
    public void create_draftrule_pricing()
    {
        Response resp;
        resp=INTENT_Capture_POSTCall(create_draftrule_pricing,headersForPatchcall(),INTENT_CAPTURE+intent_capture_create_draftrule);
        System.out.println(resp.asString());
        create_draftrule_validation(resp,"pricing");
    }

    @Test(priority = 1)
    public void create_draftrule_bcf()
    {
        Response resp;
        resp=INTENT_Capture_POSTCall(create_draftrule_bcf,headersForPatchcall(),INTENT_CAPTURE+intent_capture_create_draftrule);
        create_draftrule_validation(resp,"bcf");

    }
}
