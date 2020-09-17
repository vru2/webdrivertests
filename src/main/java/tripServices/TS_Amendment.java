package tripServices;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_Amendment extends TripserviceCommon {

	@Test(groups={"Regression"})
	public void Tripserviceairputcall() throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_CALL");
		Reporter.log(url);
		resp=TripservicePostcall(params,headersForTripservicepostcall(),url);
		System.err.println(resp.asString());
		validationforputcall(resp);		
		Response resp1;
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
		String url1 = ("http://172.17.51.86:9031/trips/"+tripref+"/air-bookings/update-booking");
		Reporter.log(url1);
		resp1=TripserviceHotelsPutcall(params3,headersForTripserviceputcall(),url1);
		validationforput(resp1);	
	} else if(Host.equalsIgnoreCase("dev")) {
		String url1 = ("http://172.17.32.12:9031/trips/"+tripref+"/air-bookings/update-booking");
		resp1=TripserviceHotelsPutcall(params3,headersForTripserviceputcall(),url1);
		validationforput(resp1);	
		} /*
			 * else if (Host.equalsIgnoreCase("www")) { String url1 =
			 * ("http://172.21.48.21:9031/trips/"+tripref+"/air-bookings/update-booking");
			 * resp1=TripserviceHotelsPutcall(params3,headersForTripserviceputcall(),url1);
			 * validationforput(resp1); }
			 */
		Thread.sleep(4000);		
		DBValidation_Txn(resp, "C");	
		Thread.sleep(8000);
		Response resp2;
		Response resp3;
		String TripID=tripref;
		ArrayList<String> amendairbooking=db_AmendAirBooking(TripID);
		String flightid=amendairbooking.get(0);
		String segmentid=amendairbooking.get(1);
		String airbookingid=amendairbooking.get(2);
		String pricingobjectid=amendairbooking.get(3);
		String tripid=amendairbooking.get(4);
		String tripref=amendairbooking.get(5);
		String userid=amendairbooking.get(6);
		String param1="{\"air_bookings\":[{\"air_booking_type\":\"D\",\"amend_itinerary_id\":\"686d08d63e-93b9-4f64-862b-191128162634\",\"seq_no\":1,\"external_references\":[{\"name\":\"DESIGN_VERSION\",\"value\":\"v2\"},{\"name\":\"NEW_GST_FLOW\",\"value\":\"N\"},{\"name\":\"deal\",\"value\":\"Get Instant cashback upto Rs 3000 on this flight. Use coupon code FLYVA_https://www.cleartrip.com/offers/india/virginatlantic\"},{\"name\":\"out_deal\",\"value\":\"Get Instant cashback upto Rs 3000 on this flight. Use coupon code FLYVA_https://www.cleartrip.com/offers/india/virginatlantic\"},{\"name\":\"ret_deal\",\"value\":\"Get Instant cashback upto Rs 3000 on this flight. Use coupon code FLYVA_https://www.cleartrip.com/offers/india/virginatlantic\"},{\"name\":\"AMENDMENT_INFO_1575352564224_PAX_1\",\"value\":\"1\"},{\"name\":\"AMENDMENT_ID\",\"value\":\"1575352564224\"},{\"name\":\"AMEND_PAX_IDX\",\"value\":\"[1]\"},{\"name\":\"SINGLE_PAGEBOOKING_FLAG\",\"value\":\"Y\"},{\"name\":\"journeyId_DEL_HYD\",\"value\":\"AIR_ASIA__OWDELHYD100I55041bfce438f5ec6474ea9d15cb48e7e5670exp1575359795510\"}],\"flights\":[{\"id\":";
		String param2=",\"flight_index\":1,\"routed\":\"N\",\"segments\":[{\"id\":";
		String param3=",\"amd_status\":\"X\",\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2019-12-28T07:40:00.000+0530\",\"arrival_terminal\":\"\",\"book_pcc\":\"OTAINCLEAN\",\"departure_airport\":\"DEL\",\"departure_date_time\":\"2019-12-28T05:30:00.000+0530\",\"departure_terminal\":\"Terminal 3\",\"duration\":7800,\"flight_number\":\"5041\",\"marketing_airline\":\"I5\",\"operating_airline\":\"I5\",\"seat_available\":80,\"seq_no\":1,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"AIR_ASIA\"},{\"amd_status\":\"N\",\"arrival_airport\":\"HYD\",\"arrival_date_time\":\"2019-12-31T07:40:00.000+0530\",\"arrival_terminal\":\"\",\"book_pcc\":\"OTAINCLEAN\",\"departure_airport\":\"DEL\",\"departure_date_time\":\"2019-12-31T05:30:00.000+0530\",\"departure_terminal\":\"Terminal 3\",\"duration\":7800,\"flight_number\":\"5041\",\"marketing_airline\":\"I5\",\"operating_airline\":\"I5\",\"seat_available\":72,\"seq_no\":2,\"stopover_count\":0,\"sup_currency\":\"INR\",\"sup_total_currency_rate\":1,\"supplier\":\"AIR_ASIA\"}]}],\"air_booking_infos\":[{\"id\":";
		String param4=",\"amd_status\":\"X\",\"amd_type\":\"1\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":1,\"segment_seq_no\":1,\"seq_no\":1},{\"agent_pcc\":\"OTAINCLEAN\",\"amd_status\":\"N\",\"amd_type\":\"1\",\"auto_refund\":\"Y\",\"booking_class\":\"K\",\"booking_status\":\"M\",\"cabin_type\":\"E\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":2,\"seat_number\":\"\",\"segment_seq_no\":2,\"seq_no\":2,\"status_history\":16,\"status_reason\":\"M\",\"ticket_type\":\"E\",\"multipcc_rev\":0,\"external_references\":[{\"name\":\"journeyId_DEL_HYD\",\"value\":\"AIR_ASIA__OWDELHYD100I55041e1c5661e9fe140caa97c5834724dca66exp1574945823153\"},{\"name\":\"connectorReturnedCurrency_DEL_HYD\",\"value\":\"INR\"},{\"name\":\"total_fare_DEL_HYD\",\"value\":\"2997.0\"},{\"name\":\"promiseId_DEL_HYD\",\"value\":\"AIR_ASIA__b914c2b16027948c5d7a909e90fbf7890db1209800a1af962612f1252d3f957eV2__100D1577511000I55041DELHYDOW__DC_dc1\"},{\"name\":\"fareId_DEL_HYD\",\"value\":\"K01H00EP_BA157_MNINR\"}]}],\"air_booking_detail\":{},\"pricing_objects\":[{\"id\":";
		String param5=",\"amd_status\":\"X\",\"seq_no\":1},{\"amd_status\":\"N\",\"cleartrip_sbc\":0,\"congestion_charge\":635,\"fare_basis_code\":\"K01H00\",\"fare_category\":\"retail\",\"fare_key\":\"DC_dc1|sms_y|fn_5041|supp_AIR_ASIA|si-oa-5fdf8445-6439-4451-a511-5b23d45333c2|fk_retail_I5_5041_1577750400000_K01H00_true_\",\"fare_sub_type\":\"\",\"net_agency_commission\":0,\"segment_amount\":8562,\"seq_no\":2,\"service_tax\":0,\"tax_base_st\":0,\"tax_ecess\":0,\"tax_shecess\":0,\"cost_pricing_object\":{\"congestion_charge\":635,\"fare_basis_code\":\"K01H00\",\"fare_category\":\"retail\",\"fare_key\":\"DC_dc1|sms_y|fn_5041|supp_AIR_ASIA|si-oa-5fdf8445-6439-4451-a511-5b23d45333c2|fk_retail_I5_5041_1577750400000_K01H00_true_\",\"fare_sub_type\":\"\",\"seq_no\":2,\"pricing_elements\":[{\"amount\":2424,\"category\":\"BF\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":91,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":65,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":65,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":75,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":277,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"false\",\"chnl_display\":\"false\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"false\",\"usr_display\":\"false\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":153,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AMD_OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]},\"pricing_elements\":[{\"amount\":2424,\"category\":\"BF\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"true\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"true\",\"wp_check\":\"true\"},{\"amount\":91,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"PSF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":65,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"SGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":65,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CGST\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":75,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CUTE\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":277,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AIRLINE-MSC\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YQ\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"YR\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"UDF\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"true\"},{\"amount\":0,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"CNCL\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":3100,\"category\":\"FEE\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AMD\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":153,\"category\":\"TAX\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"AMD_OCT\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":12,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":50,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":1000,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"},{\"amount\":1000,\"category\":\"MKP\",\"chnl_charge\":\"true\",\"chnl_display\":\"true\",\"chnl_refund\":\"false\",\"code\":\"\",\"usr_charge\":\"true\",\"usr_display\":\"true\",\"usr_refund\":\"false\",\"wp_check\":\"false\"}]}]}],\"express_checkout\":\"false\",\"id\":";
		String param6=",\"insurances\":[],\"itinerary_id\":\"68aa44f0c9-7ba7-403c-86c6-191203112559\",\"notes\":[{\"note\":\"Total:3553.0{ TAXCUTE:75.0 TAXOCT:0.0 BF:2424.0 FEECNCL:0.0 TAXAIRLINE-MSC:277.0 TAXAMD_OCT:153.0 TAXPSF:91.0 FEEAMD:3100.0 MKP:2312.0 TAXSGST:65.0 FEEOFR:-5009.0 TAXUDF:0.0 TAXYR:0.0 TAXYQ:0.0 TAXCGST:65.0}\",\"subject\":\"Amendment Fare Info\",\"user_id\":0}],\"trip_ref\":\"";
		String param7="\",\"trip_type\":1,\"txns\":[{\"external_references\":[{\"name\":\"CNCL_CT\",\"value\":\"0\"}],\"source_id\":\"115.114.17.142\",\"source_type\":\"ACCOUNT\",\"status\":\"O\",\"txn_type\":2,\"user_id\":";
		String param8="}]}";
		String amendlogbooking=param1+flightid+param2+segmentid+param3+airbookingid+param4+pricingobjectid+param5+tripid+param6+tripref+param7+userid+param8;
		String amendupdatebooking="{\"air_booking_infos\":[{\"agent_pcc\":\"OTAINCLEAN\",\"auto_refund\":\"N\",\"booking_class\":\"K\",\"booking_status\":\"P\",\"cabin_type\":\"E\",\"pax_info_seq_no\":1,\"pricing_object_seq_no\":2,\"segment_seq_no\":2,\"seq_no\":2,\"status_history\":16,\"ticket_type\":\"E\",\"external_references\":[{\"name\":\"journeyId_DEL_HYD\",\"value\":\"AIR_ASIA__OWDELHYD100I55041e1c5661e9fe140caa97c5834724dca66exp1574945823153\"},{\"name\":\"connectorReturnedCurrency_DEL_HYD\",\"value\":\"INR\"},{\"name\":\"total_fare_DEL_HYD\",\"value\":\"2997.0\"},{\"name\":\"promiseId_DEL_HYD\",\"value\":\"AIR_ASIA__b914c2b16027948c5d7a909e90fbf7890db1209800a1af962612f1252d3f957eV2__100D1577511000I55041DELHYDOW__DC_dc1\"},{\"name\":\"fareId_DEL_HYD\",\"value\":\"K01H00EP_BA157_MNINR\"}]}]}";
		Reporter.log(amendlogbooking);
		if(Host.equalsIgnoreCase("qa2")) {
			String url1 = ("http://172.17.51.86:9031/trips/amend");
			Reporter.log(url1);
			resp2=TripservicePostcall(amendlogbooking,headersForTripserviceputcall(),url1);
			System.out.println(resp2.asString());
			validationforput(resp2);
			Thread.sleep(2000);
			String url2 = ("http://172.17.51.86:9031/trips/amend/"+tripref+"/air-bookings/update-booking");
			Reporter.log(url2);
			resp3=TripserviceHotelsPutcall(amendupdatebooking,headersForTripserviceputcall(),url2);
			System.out.println(resp3.asString());
			validationforput(resp3);	
			Thread.sleep(2000);
		}
		Thread.sleep(16000);		
		DBValidation_Txn(resp, "C");	
 }
}
