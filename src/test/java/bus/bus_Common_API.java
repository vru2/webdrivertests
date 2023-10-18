// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.bus;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.*;

public class bus_Common_API {

    public RemoteWebDriver driver;

    public HashMap<String, Object> headersForms() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public HashMap<String, Object> headersForms_Search() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("app-agent", "123");
        headers.put("x-ct-source", "123");
        return headers;
    }

    public HashMap<String, Object> SelfCare_GetTripInfo() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("app-agent", "PWA");
        headers.put("x-ct-source", "MOBILE");
        headers.put("user-agent", "Chrome");
        headers.put("Cookie", "ct-auth = 8%2FoAirXyddvCUQYarT7xxGkltofgCmEXQLXo%2FGD32%2FQndzR%2BiHxcEe64De4yJyydEUrgVSM3cgM9x6wexLhWoQAvoCkHaCucwBqS439OaRj2Esu5jALbJD%2BpN5fLK%2BI3ajjlnxi9AmOXalhgAkk0fngZpCcVNGVWyWxx%2BiSK22%2F7T9cUvNn3kqvJXHxV%2FT%2BrbCcKl6B4fBA%2BlNr6eWTadxedDVNvZVzKna5dKidUAJE1l8vfB3iRW1SXF48TfCUTS86rLddtn5Ezp1sQr%2FUUltCf1u2X6Qbv9VdFB1bQ0guGs%2BqtBLn4Wj5zB1G2lB%2F9eBipeSDhnAMp%2B5sk8JbmuJsofFNO27tV00nkDyiX5uGqQJA%2FKe6R0QbpNFydUJJHHN%2BMynqWQfeY3pDCWhpUVB%2BuC4N9Yclsc19rIgExeF1cjoyYvIqWlfRSCuBHDDRZOJGQFQNhEcb%2Bohy0v%2FLE7uIN%2FfEz6qk38F88X9l5qu9Y%2FSZkri97CR5hIkTwC5h9AFxEgk1nmhSvj%2Bc0AlPDOUqho84pYsQDNtPlcn0e8I00RmtnUxxeEwmvtgdS4JEfK6iQv3uJwxmNErKS%2BgHAlpyRsJpKrNRNb5Q%2FaT8TL8euFvf%2BgBYNhNLXLn44QE2nXmxV%2FhsJQiW59DxLdnMALJD2hLVKIQ6Bbz0GpBD%2F5182nMuZk7sPtnjwlY%2BlxuM%2F3zAOOvYF3MbTEC%2FseSyM2o1fubtb3p7elN606%2B4H%2BzMtkIWgfs%2FvSZoxB%2FHntlpnRoRruZC6bk9DJkpPGgLc71EsC7NPVvZHeXDl%2B0HZHnTHLcwVJbqcoihMOmU8h3bKYIK55ppNwCq31G3DI%2Fm%2B0sSMYa7JvaWb7tBZkRcNWwlHfgHy9w0XRAJqNrvZNG%2FtcCsUviGKMSNy2mhCBCnh%2BgAgjf6oS6NSbuXMylPZ6oWZdLAWaz9bYT0hph3tcgDR9t2BS51jx0Gt8MBGdImHPKcQ%2BRE%2Fi7OpNhzHulCPJvq0YiIxJAiTs6hBqAqN2yWFWNKy7fd%2FRXv2Xz4fDIFAWdkwz21EyElfSU%2F7UswxzJOpv87xjAaa9KtBV7s5FGFenKxZBLgKjE8bBREGgTxCcf82MwgbGlVbFg2yOewvazWyVlKM8qlGFfPoCZdArrNIPm3473cM6%2FpV54ffNOjwb3d9E4sKahWgzrgwIcLCCZCmy%2FoZYEJyDRsucVySX3A2h3N3Fw7miIdvh6ov5GfWF2YxwQz88G4Ayb8q%2FPm9ufItL%2BS7A0zniugo%2FDggkXMkfdM4QACfve5Zg3OXves%2BFSgTF40dmGwALzNh3AlHtWvy8vFQLVRot6alUo4fIX%2B7FmzzzXTJygYREiFTJarOfbcFcN0yD56%2BRV2ZtPOrgNX8%2F36ErOh8%2F64Iwf3Ghb%2Bg1vPKVk7Aa1XKm8AJJiLmNGKnkuH6VyxlFhxSpmNZxksrkue%2F8ST3oVl4Ku7V8FEs0UNWcZ3IOoqlmjeJzKMTOWBQUI%2B4Fe17PCAxL2VADoDjnHUESTaPTdDMrzpQhjJkQwRp1iMgVekpSXdyIUtXOWEwEzdh2oek7XchwEPUM8sSkWIaO7Gy3l0g%2FfiZsdEviw0KuRYrfHRyow%2BSUv3X9Pcvqqff2Ix0VIcmRgbCB3BT8DCv661JyLJngDDBOYNJCEkBZIBwUUnsuiH5cQKGwR23YuHpGrK4xPkdj65xH2elncH72VAbybQf2DCfl8ViWMa8pBxqjxR%2BQmajPb01DT%2FjbBcVGxtgieF9uZWQRtDtZDsZybs%2BKKHB%2F8NxnknI2MCEVzbpoHO9SYuQPF3%2BWMWkfqxa7IxDp6W9J2umVuWwC1R5vgEBpEWO1O0tNnKnKID3vO8VBpqMNuRmYRr%2BeDPElY1RmF83%2B5eiGXr8B2GhR01b%2BYzCNcBjFaoSJ4enJcMGGMJZFem3q13K00%2ByLzuIy5VuaF%2BulE8SB5sIH0QZ40Q96P%2FCpOaViL6XVl7Cx%2FGSu9rXa5nx1h3K9qJaZayxSRHCXGifRCi0DMJR4GQmLjAFIP1lTFsSO567tJGS8zI%2BAq34LXHtFVkvkWheaujQ%2BInjFMuEM5V1snIXM1UcrLCQYQplOyiSo%2FnCFhUBZ6MjzlaQR%2BZRUlqYwgJLmFC2RGkSc%2B8ivXwiA86zNUGolF1iTYFXI0eOAgqZ79SNuxfzVgrEjtOKhN7ActQPEJuEN0up3zSbKgL%2F0AGsRYy9f8yk9wrILSRG4%2BKhAJcXSyUREoZtLNxkBn%2FHcDguh7PYIrvVZKrGXZfAz9h7fM9FrU4le%2BrnKDn6%2Be4M4lEtKY70U5%2FZUjxpi%2FGCM%2Fb%2FC1KGTuJ7ulLQ1UQAzd6%2FarTJYDUOFkptX8BCjS1OWtQRvcsVH%2BZoUN5rBq3ifYBsdaHaEWiiSKZ1Hz8OIRQsoa4voWH8y0S8L%2BqO%2Fn%2BWGLSp");
        return headers;
    }

    public HashMap<String, Object> headersForms_UpdateTrip() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-CT-CLOSE-TRANSACTION", "true");
        headers.put("trip-version", "V2");
        return headers;
    }

    public HashMap<String, Object> headersForms_Cancel_Trip_Status() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-ct-source", "PULSE");
        return headers;
    }

    public HashMap<String, Object> headersForms_Bus_Booking() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-ct-source", "MOBILE");
        headers.put("app-agent", "MOBILE");
        return headers;
    }

    public HashMap<String, Object> headersForms_Bus_Cancel() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("app-agent", "MOBILE");
        headers.put("X-CT-SOURCE", "MOBILE");
        headers.put("user-agent", "Chrome");
        headers.put("charset", "UTF-8");
        headers.put("Cookie", "ct-auth = 8%2FoAirXyddvCUQYarT7xxGkltofgCmEXQLXo%2FGD32%2FQndzR%2BiHxcEe64De4yJyydEUrgVSM3cgM9x6wexLhWoQAvoCkHaCucwBqS439OaRj2Esu5jALbJD%2BpN5fLK%2BI3ajjlnxi9AmOXalhgAkk0fngZpCcVNGVWyWxx%2BiSK22%2F7T9cUvNn3kqvJXHxV%2FT%2BrbCcKl6B4fBA%2BlNr6eWTadxedDVNvZVzKna5dKidUAJE1l8vfB3iRW1SXF48TfCUTS86rLddtn5Ezp1sQr%2FUUltCf1u2X6Qbv9VdFB1bQ0guGs%2BqtBLn4Wj5zB1G2lB%2F9eBipeSDhnAMp%2B5sk8JbmuJsofFNO27tV00nkDyiX5uGqQJA%2FKe6R0QbpNFydUJJHHN%2BMynqWQfeY3pDCWhpUVB%2BuC4N9Yclsc19rIgExeF1cjoyYvIqWlfRSCuBHDDRZOJGQFQNhEcb%2Bohy0v%2FLE7uIN%2FfEz6qk38F88X9l5qu9Y%2FSZkri97CR5hIkTwC5h9AFxEgk1nmhSvj%2Bc0AlPDOUqho84pYsQDNtPlcn0e8I00RmtnUxxeEwmvtgdS4JEfK6iQv3uJwxmNErKS%2BgHAlpyRsJpKrNRNb5Q%2FaT8TL8euFvf%2BgBYNhNLXLn44QE2nXmxV%2FhsJQiW59DxLdnMALJD2hLVKIQ6Bbz0GpBD%2F5182nMuZk7sPtnjwlY%2BlxuM%2F3zAOOvYF3MbTEC%2FseSyM2o1fubtb3p7elN606%2B4H%2BzMtkIWgfs%2FvSZoxB%2FHntlpnRoRruZC6bk9DJkpPGgLc71EsC7NPVvZHeXDl%2B0HZHnTHLcwVJbqcoihMOmU8h3bKYIK55ppNwCq31G3DI%2Fm%2B0sSMYa7JvaWb7tBZkRcNWwlHfgHy9w0XRAJqNrvZNG%2FtcCsUviGKMSNy2mhCBCnh%2BgAgjf6oS6NSbuXMylPZ6oWZdLAWaz9bYT0hph3tcgDR9t2BS51jx0Gt8MBGdImHPKcQ%2BRE%2Fi7OpNhzHulCPJvq0YiIxJAiTs6hBqAqN2yWFWNKy7fd%2FRXv2Xz4fDIFAWdkwz21EyElfSU%2F7UswxzJOpv87xjAaa9KtBV7s5FGFenKxZBLgKjE8bBREGgTxCcf82MwgbGlVbFg2yOewvazWyVlKM8qlGFfPoCZdArrNIPm3473cM6%2FpV54ffNOjwb3d9E4sKahWgzrgwIcLCCZCmy%2FoZYEJyDRsucVySX3A2h3N3Fw7miIdvh6ov5GfWF2YxwQz88G4Ayb8q%2FPm9ufItL%2BS7A0zniugo%2FDggkXMkfdM4QACfve5Zg3OXves%2BFSgTF40dmGwALzNh3AlHtWvy8vFQLVRot6alUo4fIX%2B7FmzzzXTJygYREiFTJarOfbcFcN0yD56%2BRV2ZtPOrgNX8%2F36ErOh8%2F64Iwf3Ghb%2Bg1vPKVk7Aa1XKm8AJJiLmNGKnkuH6VyxlFhxSpmNZxksrkue%2F8ST3oVl4Ku7V8FEs0UNWcZ3IOoqlmjeJzKMTOWBQUI%2B4Fe17PCAxL2VADoDjnHUESTaPTdDMrzpQhjJkQwRp1iMgVekpSXdyIUtXOWEwEzdh2oek7XchwEPUM8sSkWIaO7Gy3l0g%2FfiZsdEviw0KuRYrfHRyow%2BSUv3X9Pcvqqff2Ix0VIcmRgbCB3BT8DCv661JyLJngDDBOYNJCEkBZIBwUUnsuiH5cQKGwR23YuHpGrK4xPkdj65xH2elncH72VAbybQf2DCfl8ViWMa8pBxqjxR%2BQmajPb01DT%2FjbBcVGxtgieF9uZWQRtDtZDsZybs%2BKKHB%2F8NxnknI2MCEVzbpoHO9SYuQPF3%2BWMWkfqxa7IxDp6W9J2umVuWwC1R5vgEBpEWO1O0tNnKnKID3vO8VBpqMNuRmYRr%2BeDPElY1RmF83%2B5eiGXr8B2GhR01b%2BYzCNcBjFaoSJ4enJcMGGMJZFem3q13K00%2ByLzuIy5VuaF%2BulE8SB5sIH0QZ40Q96P%2FCpOaViL6XVl7Cx%2FGSu9rXa5nx1h3K9qJaZayxSRHCXGifRCi0DMJR4GQmLjAFIP1lTFsSO567tJGS8zI%2BAq34LXHtFVkvkWheaujQ%2BInjFMuEM5V1snIXM1UcrLCQYQplOyiSo%2FnCFhUBZ6MjzlaQR%2BZRUlqYwgJLmFC2RGkSc%2B8ivXwiA86zNUGolF1iTYFXI0eOAgqZ79SNuxfzVgrEjtOKhN7ActQPEJuEN0up3zSbKgL%2F0AGsRYy9f8yk9wrILSRG4%2BKhAJcXSyUREoZtLNxkBn%2FHcDguh7PYIrvVZKrGXZfAz9h7fM9FrU4le%2BrnKDn6%2Be4M4lEtKY70U5%2FZUjxpi%2FGCM%2Fb%2FC1KGTuJ7ulLQ1UQAzd6%2FarTJYDUOFkptX8BCjS1OWtQRvcsVH%2BZoUN5rBq3ifYBsdaHaEWiiSKZ1Hz8OIRQsoa4voWH8y0S8L%2BqO%2Fn%2BWGLSp");
        return headers;
    }

    String url_Bus = "http://bus-api.cltp.com:9001";

    String url_Pay = "http://paymentservice.cltp.com:9001";

    String url_Coupon = "http://172.29.9.7:9001";

    String url_Bus_Trip = "http://172.29.8.215:9001";

    String url_Bus_PostBook = "http://bus-post-book.cltp.com:9001";

    String url_QA2 = "https://qa2new.cleartrip.com";

    String url_EndPoint_Update_Trip = "/trips/Q221215615418/bus-bookings/update-booking";
    String url_EndPoint_Search = "/api/bus/v1/search?fromCity=4292&toCity=4562&journeyDate=";
    String url_Pay_Inititate = "/paymentservice/api/initiatePayment/";
    String url_SelfCare_GetTripInfo = "/api/bus/v1/self-care/get-trip-info?tripId=Q231018802670";
    String url_SelfCare_CancelationInfo = "/api/bus/v1/self-care/cancel-info?tripId=Q231018802670";

    String url_SelfCare_CancelBooking = "/api/bus/v1/self/cancel/Q231018802670";
    String url_SelfCare_Download_eTicket = "/api/bus/v1/download-eTicket/Q231018802670";

    String url_SelfCare_TripDetails_Email = "/api/bus/v1/trip-details-email?emailId=kiran.kumar@cleartrip.com&tripId=Q231018802670";

    String url_Endpoint_Cancelation_Eligibility = "/bus/hq/v2/refund-info/Q230911782400?reason=CR01";

    String url_Endpoint_Cancel_Trip_Status = "/bus/hq/v2/cancel/Q230911782400?reason=CR04";
    String url_Endpoint_Cancel_Booking = "/api/bus/v1/self/cancel/Q231007798824";
    String url_Endpoint_Update_Traveller = "/api/bus/v1/itin/travellers";

    String url_Endpoint_Cancellation = "/api/bus/v1/self/cancel/";

    String url_EndPoint_AutoSuggest = "/api/bus/v1/auto-suggest/?value=ban";
    String url_EndPoint_Coupon_Active = "/offer/search?active=true";

    String url_EndPoint_Coupon_Activate = "/offer/activate/237";
    String url_EndPoint_Coupon_Deactivate = "/offer/deactivate/237";

    String payload_Update_Trip = "{\"bus_booking_infos\":[{\"seq_no\":1,\"pax_info_seq_no\":1}],\"bus_pricing_infos\":[{\"seq_no\":1,\"bus_cost_pricing_info\":{\"seq_no\":1,\"pricing_elements\":[]},\"pricing_elements\":[{\"amount\":20,\"category\":\"COUPON\",\"code\":\"TEST10\",\"label\":\"Coupon\"}]}]}";
    String payload_Canceled_Trip_Status = "{\"note\":\"string\",\"subject\":\"string\",\"trip_id\":0,\"user_id\":0}";
    String payload_Cancel_Booking =  "{\"reason\":\"CR01\"}";


    public String SRP_Date(int toDate) throws Exception {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DATE, +toDate);
        Date s = c.getTime();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(s);
        return dateString;
    }

    public Response busGet(String useCase, String busType) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response resp;
        if (useCase.equalsIgnoreCase("Search")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_EndPoint_Search+busType;
            headers = headersForms_Search();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("PayInti")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_Pay_Inititate+busType;
            headers = headersForms_Search();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("CancellationInfo")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_SelfCare_CancelationInfo;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("Download_eTicket")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_Download_eTicket;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("GetTripDetails_Email")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_TripDetails_Email;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }

        if (useCase.equalsIgnoreCase("GetTripInfo")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_SelfCare_GetTripInfo;
            headers = SelfCare_GetTripInfo();
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponActive")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Active;
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponActivate")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Activate;
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("couponDeactivate")){
            RestAssured.baseURI = url_Coupon;
            endpoint = url_EndPoint_Coupon_Deactivate;
            Reporter.log(url_Bus + endpoint);
        }
        if (useCase.equalsIgnoreCase("autoSuggest")){
            RestAssured.baseURI = url_QA2;
            endpoint = url_EndPoint_AutoSuggest;
            headers = headersForms_Search();
            Reporter.log(url_QA2 + endpoint);
        }

        Reporter.log(url_Bus+endpoint);
        resp = RestAssured.given().
                when().
                log().all().
                headers(headers).
                get(endpoint);
        return resp;
    }

    public Response busPut(String useCase, String busType) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms_UpdateTrip();
        Response request;
        if (useCase.equalsIgnoreCase("Update_Trip")) {
            endpoint = url_Bus_Trip+url_EndPoint_Update_Trip;
            params = payload_Update_Trip;
        }
        if (useCase.equalsIgnoreCase("Trip_Status")) {
            endpoint = url_Bus_PostBook+url_Endpoint_Cancel_Trip_Status;
            params = payload_Canceled_Trip_Status;
            headers = headersForms_Cancel_Trip_Status();
        }
        if (useCase.equalsIgnoreCase("Cancel_booking")) {
            endpoint = url_Bus+url_Endpoint_Cancel_Booking;
            params = payload_Cancel_Booking;
            headers = SelfCare_GetTripInfo();
        }
        if (useCase.equalsIgnoreCase("UpdateTraveller")) {
            RestAssured.baseURI = url_QA2;
            endpoint = url_QA2+url_Endpoint_Update_Traveller;
            params = busType;
            headers = headersForms_Bus_Booking();
        }
        if (useCase.equalsIgnoreCase("Cancellation")) {
            RestAssured.baseURI = url_Bus;
            endpoint = url_Endpoint_Cancellation+busType;
            params = payload_Cancel_Booking;
            headers = SelfCare_GetTripInfo();
           // headers.put("charset", "UTF-8");
        }
        RestAssured.config = RestAssuredConfig.newConfig().encoderConfig(
                EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
        Reporter.log(endpoint);
        Reporter.log("Params :" + params);
        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                put(endpoint);
        return request;
    }

    public Response busPostNew(String useCase, String busType, String param) {
        RestAssured.baseURI = "http://bus-book.cltp.com:9001";
        String endpoint = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (useCase.equalsIgnoreCase("Param_BookInternal")) {
            endpoint = "/bus/v1/bookInternal/"+busType;
            params = param;
            headers = headersForms_Bus_Booking();
        }


        Reporter.log(url_Bus);
        Reporter.log("Params :" + params);

        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                post(endpoint);
        return request;
    }

    public Response busPost(String useCase, String busType) {
        RestAssured.baseURI = url_Bus;
        String endpoint = null;
        String params = null;
        HashMap<String, Object> headers = new HashMap<>();
        headers = headersForms();
        Response request;
        if (useCase.equalsIgnoreCase("Cancellation_Eligibility")) {
            endpoint = url_Bus_PostBook+url_Endpoint_Cancelation_Eligibility;
            params = payload_Canceled_Trip_Status;
            headers = headersForms_Cancel_Trip_Status();
        }
        if (useCase.equalsIgnoreCase("Chart")) {
            endpoint = "https://qa2new.cleartrip.com/api/bus/v1/chart";
            params = busType;
            headers = headersForms_Bus_Booking();
        }
        if (useCase.equalsIgnoreCase("Itinerary")) {
            endpoint = "https://qa2new.cleartrip.com/api/bus/v1/itin";
            params = busType;
            headers = headersForms_Bus_Booking();
        }
        if (useCase.equalsIgnoreCase("PreBook")) {
            endpoint = "http://bus-book.cltp.com:9001/bus/v1/preBook?itineraryId="+busType;
            params = "";
            headers = headersForms_Bus_Booking();
        }
        if (useCase.equalsIgnoreCase("Param_BookInternal")) {
            endpoint = "/bus/v1/bookInternal/"+busType;
            params = "";
            headers = headersForms_Bus_Booking();
        }

        if (useCase.equalsIgnoreCase("PayWall")) {
            RestAssured.baseURI = url_Pay;
            endpoint = "/paymentservice/service/pay/v3";
            params = busType;
            headers = headersForms_Bus_Booking();
        }
        Reporter.log(url_Bus);
        Reporter.log("Params :" + params);

        request = RestAssured.given().
                when().
                log().all().
                headers(headers).
                body(params).
                post(endpoint);
        return request;
    }

    public Response validation(String useCase, Response resp) {
        Reporter.log("Response body " + useCase + " : " + resp.body().asString());
        System.out.println("Response body " + useCase + " : " + resp.body().asString());
        int statusCode = resp.getStatusCode();
        Reporter.log("statusCode: " + statusCode);
        JsonPath jsonPathEvaluator = resp.jsonPath();
        if(!(useCase.equals("Cancel_booking"))) {
            if (statusCode != 200) {
                Assert.assertTrue(false);
            }
        }
        if (useCase.equals("Update_Trip")) {
            String trip_ref= jsonPathEvaluator.getString("trip_ref");
            Reporter.log("trip_ref " +trip_ref);
            if(!trip_ref.equals("Q221215615418")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("GetTripInfo")) {
            String bookingConfirmed= jsonPathEvaluator.getString("bookingConfirmed");
            Reporter.log("bookingConfirmed " +bookingConfirmed);
            if(!bookingConfirmed.equals("true")) {
                Assert.assertTrue(false);
            }

        }
        else  if (useCase.equals("CancellationInfo")) {
            String cancellationApplicable= jsonPathEvaluator.getString("cancellationApplicable");
            Reporter.log("cancellationApplicable " +cancellationApplicable);
            if(!cancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("GetTripDetails_Email")) {
          /*  String cancellationApplicable= jsonPathEvaluator.getString("cancellationApplicable");
            Reporter.log("cancellationApplicable " +cancellationApplicable);
            if(!cancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }*/
        }
        else  if (useCase.equals("Cancel_booking")) {
            String success= jsonPathEvaluator.getString("success");
            String message= jsonPathEvaluator.getString("error.message");
            Reporter.log("message " +message);
            if(!success.equals("false")) {
                Assert.assertTrue(false);
            }
            if(!message.equals("Something went wrong")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("Cancellation_Eligibility")) {
            String isCancellationApplicable= jsonPathEvaluator.getString("isCancellationApplicable");
            Reporter.log("isCancellationApplicable " +isCancellationApplicable);
            if(!isCancellationApplicable.equals("false")) {
                Assert.assertTrue(false);
            }
        }
        else  if (useCase.equals("Trip_Status")) {
            String cancellationProcessed= jsonPathEvaluator.getString("cancellationProcessed");
            String refundAmount= jsonPathEvaluator.getString("refundAmount");
            Reporter.log("cancellationProcessed " +cancellationProcessed);
            if(!cancellationProcessed.equals("true")) {
                Assert.assertTrue(false);
            }
            if(!refundAmount.equals("12")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponActive")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String validationFieldExtractor= jsonPathEvaluator.getString("offerValidationRuleGroups.offerValidationRules[0].validationFieldExtractor");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("UTMMONTUE20")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!validationFieldExtractor.contains("BookingDateExtractor")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponActivate")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String type= jsonPathEvaluator.getString("type");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("CTCHANNEL")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!type.contains("PERCENTAGE_DISCOUNT")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("couponDeactivate")) {
            String code= jsonPathEvaluator.getString("code");
            String active= jsonPathEvaluator.getString("active");
            String type= jsonPathEvaluator.getString("type");
            Reporter.log("code " +code);
            Reporter.log("active " +active);
            if(!code.contains("CTCHANNEL")) {
                Assert.assertTrue(false);
            }
            if(!active.contains("false")) {
                Assert.assertTrue(false);
            }
            if(!type.contains("PERCENTAGE_DISCOUNT")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("Search")) {
            String toCityName= jsonPathEvaluator.getString("data.sc.toCityName");
            Reporter.log("toCityName " +toCityName);
            if(!toCityName.contains("Chennai")) {
                Assert.assertTrue(false);
            }
        }
        else if (useCase.equals("autoSuggest")) {
            String success= jsonPathEvaluator.getString("success");
            String suggestions= jsonPathEvaluator.getString("data.suggestions.cityName");
            Reporter.log("success " +success);
            if(!success.contains("true")) {
                Assert.assertTrue(false);
            }
            if(!suggestions.contains("Bangalore")) {
                Assert.assertTrue(false);
            }
        }

        return resp;
    }
}