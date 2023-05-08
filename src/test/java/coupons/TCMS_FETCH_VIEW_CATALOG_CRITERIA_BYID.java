package test.java.coupons;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class TCMS_FETCH_VIEW_CATALOG_CRITERIA_BYID extends Coupon_Common{
    Response resp;
    String url=TCMS_VIEW_CATALOG_MODULE_ENDPOINT+tcms_fetch_view_catalog_criteria_byid;

    @Test
    public void fetch_view_catalog_criteria_byid()
    {
        resp= RestAssured.given().
                when().
                log().all().
                headers("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiIwZTZlODJlYS0wNjljLTRiZDUtOTE4NC1jYjRmMTM2YzkyZjIiLCJ1c2VyQ2xhaW0iOnsidXNlcklkIjoxLCJ1c2VybmFtZSI6InNoYXNoaWthbnRoLmdAY2xlYXJ0cmlwLmNvbSIsInRlYW1JZHMiOlsyLDFdLCJhdXRob3JpdGllcyI6W119LCJpc3MiOiJDVCIsImlhdCI6MTY3NDQ1NTQwOX0.WgDH1A163eopxh7LKbj3v7-2MyEg8S6uw-OAIcXEZhALDSPbQ39g0qQ_YpA_okypJryVs7L999BHZ05PV7hcZkjtWYn9SF1E9oOtmAdZwU-FC4ptA_GOW8Dt2ud-P8lHlZpOn9TOYz8l4_ZwubH912Bu47GZyYVOTkfNRYJPEZMpXDqAQeNDId_S2Po1TEFMIb7miHQ9o6dWM5dZ0YIbLgBR_Q7SpCKtTchCkXrp3liOhqXQp_F3BtmnXJsynSEnHDi0oeLEXJCtKRmmA_fitYizXNEtGmzrIEE0Fbn_Gtkrr5_h0BZIs_lLR-YnAhKnMjnz8IH4oZIy36f-wtVLeA").
                get(url);
        Fetch_Viewcatalogcriteriabyid(resp);
    }
}
