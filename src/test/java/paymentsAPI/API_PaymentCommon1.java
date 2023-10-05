// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import test.java.domains.PlatformCommonUtil;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import test.java.domains.PlatformCommonUtil;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.CoreMatchers.equalTo;

public class API_PaymentCommon1 extends PlatformCommonUtil

{	
	public RemoteWebDriver driver;

	String urlPay = "http://172.29.20.90:9001"; //"http://paymentservice.cltp.com:9001"; //http://172.17.51.86:8070"
	String urlRefundNew1 = "http://172.29.20.90:9001";//"http://paymentservice.cltp.com:9001";"http://172.17.51.86:8070";
	String urlrewards_payURI ="http://paymentservice.cltp.com:9001";//"http://172.17.51.86:8070";
	String urladcb_validat = "http://172.29.20.90:9001";//"http://paymentservice.cltp.com:9001";"http://172.17.51.86:8070";
	String urlFetchRefunds="http://172.29.20.90:9001";//"http://paymentservice.cltp.com:9001";"http://172.17.51.86:8070";
	String urlFlyin = "http://172.17.51.86:8406"; // ORACLE
	String urlDA = "http://172.17.28.21:8403";
	String promoURL = "http://172.29.20.76:9001";//http://promoservice.cltp.com:9001";http://172.17.51.86:7999";
	String urlRewards = "http://rewardsservice.cltp.com:9080";//http://172.17.56.51:9080";
	String urlAffordability = "http://payments-affordability.cltp.com:9001";//http://172.17.56.51:9080";
	String urlWallet = "http://172.29.20.92:9001";//"http://wallet-service-qa.cltp.com:9001";
	String urlCardInfo_Service="http://172.29.20.21:9001";// http://172.29.8.152:8331";//http://172.17.51.86:8331";
	String urlrewards_validate = "http://172.29.20.90:9001";//"http://paymentservice.cltp.com:9001";"http://172.17.51.86:8070";
	String urlrewards_URI = "http://rewardsservice.cltp.com:9001";//http://172.17.56.51:9080";
	String urlPromo_Used = "http://172.29.20.92:9001";//"http://wallet-service-qa.cltp.com:9001";//http://172.17.51.86:8071";

	String urlReporting_TS = "http://172.17.51.86:8282";
	String urlReporting = "http://172.29.20.73:9001";//http://paymentservicereporting.cltp.com:9001";
	String urlRecommendationService = "http://172.29.20.25:9001";//http://recommendation-service.cltp.com:9001";
	String urlReportingTS ="http://172.29.8.215:9001";
	String url_Binmanager = "https://qa2new.cleartrip.com/binmanager/v1/payment/cards?bin=534977";
	String url_QA2 = "https://qa2new.cleartrip.com/";
	public String url_TestApp = "";

	String banner_New = "paymentservice/bannerDetails";

	String paramsCC ="[{\"payment\":{\"seq_no\":1,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":276,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.73.123\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"firstName\":\"test\"},\"app_ref1\":\"Q18110926800\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"683a3a6bec-4e58-422a-a2c9-90707b1e5a12\",\"payment_type\":\"CC\",\"amount\":100,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"9W/362/DEL/BOM/201811XXXXXX00\",\"order_info2\":\"Kiran Kumar\",\"source_type\":\"ACCOUNT\",\"user_id\":85721640,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://www.cleartrip.com/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"340000000000009\",\"card_type_id\":1,\"expiry_month\":\"12\",\"expiry_year\":\"2025\",\"cvv\":\"123\",\"name\":\"CleartripCard\",\"billto_detail\":{\"firstname\":\"test\",\"lastname\":\"test\",\"address1\":\"Cleartrip JP Nagar\",\"city_name\":\"Bangalore\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"postal_code\":\"560076\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\"}}]";
	String paramsCCVISA ="[{\"payment\":{\"seq_no\":1,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"VISA\",\"high_risk\":false,\"d_plus_x_in_hours\":276,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.73.123\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"firstName\":\"test\"},\"app_ref1\":\"Q18110926800\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"683a3a6bec-4e58-422a-a2c9-90707b1e5a12\",\"payment_type\":\"CC\",\"amount\":100.99,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"9W/362/DEL/BOM/201811XXXXXX00\",\"order_info2\":\"Kiran Kumar\",\"source_type\":\"ACCOUNT\",\"user_id\":85721640,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://www.cleartrip.com/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"5123456789012346\",\"card_type_id\":1,\"expiry_month\":\"05\",\"expiry_year\":\"2025\",\"cvv\":\"123\",\"name\":\"CleartripCard\",\"billto_detail\":{\"firstname\":\"test\",\"lastname\":\"test\",\"address1\":\"Cleartrip JP Nagar\",\"city_name\":\"Bangalore\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"postal_code\":\"560076\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\"}}]";

	String ParamsGV_Refund = "{\"paymentId\":43178534,\"amount\":400,\"refundId\":9283288,\"giftVoucherRecipientEmail\":\"cleartriptest@gmail.com\",\"originalGiftVoucherNumber\":\"3000331134027267\",\"originalInvoiceNumber\":\"43178534_Q190808460482\",\"originalGvTxnId\":\"1908081707\",\"originalBatchNumber\":\"10573009\",\"originalApprovalCode\":\"7015313\",\"currency\":\"INR\",\"tripRef\":\"Q190808460482\"}";
	String ParamsGV_CAPTURE = "{\"cardNumber\":\"3000331032058605\",\"cardPin\":\"299574\",\"cardCategory\":\"\",\"amount\":10.0,\"currency\":\"INR\",\"paymentId\":";

	String ParamsGV_CAPTURE1	= ",\"tripRef\":\"T5017864736\",\"productType\":\"DOMESTIC-AIR\"}";
	String paramsDA = "{\"payment\":[{\"tripId\":46393238,\"seqNo\":1,\"highRisk\":false,\"d_plus_x_in_hours\":1138,\"fraudSystemInvocation\":\"N\",\"uiVersion\":\"v1\",\"customerDetail\":{\"address1\":\"One way\",\"city_name\":\"jp nagar\",\"postal_code\":\"111111\",\"state_name\":\"KA\",\"country_name\":\"India\",\"landline\":\"08012121212\",\"email\":\"123@123.com\"},\"appRef1\":\"Q1221212112\",\"appRef2\":\"75604242\",\"paymentType\":\"DA\",\"amount\":1.1,\"currency\":\"INR\",\"orderInfo1\":\"SG/8905/DEL/BLR/202004XXXXXX00\",\"orderInfo2\":\"Kiran Kumar\",\"sourceType\":\"API\",\"userId\":41651546,\"companyId\":110340,\"appReturnInfo\":{\"method\":\"POST\"},\"paymentCategory\":\"B\",\"deposit_account_detail\":{\"id\":44980178,\"transaction_password\":\"test123\"},\"isPWA\":false,\"pwa\":false,\"dplusXInHours\":1138}]}";
	String paramsDAValidateV3 = "[{\"payment\":{\"seq_no\":1,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"testcthotel@gmail.com\"},\"payment_type\":\"DA\",\"amount\":10.0,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"CORP\",\"user_id\":13939735,\"company_id\":101,\"app_return_info\":{\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://corporate.cltp.com:9001/r3/corp/air-book-internal?itineraryId\\u003d689a209bce-a21e-49ac-a0f9-200330145310\\u0026corpPageId\\u003d\"},\"deposit_account_detail\":{\"id\":46207144,\"transaction_password\":\"test123\"}}}]";
	String paramsDAPayV3 = "[{\"payment\":{\"seq_no\":1,\"trip_id\":43453224,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"testcthotel@gmail.com\"},\"app_ref1\":\"Q200330788702\",\"app_ref2\":\"75629492\",\"payment_type\":\"DA\",\"amount\":1.0,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"CORP\",\"user_id\":790982,\"company_id\":101,\"app_return_info\":{\"url\":\"https://demo.cleartripforbusiness.com/airConfirmNetBanking?itineraryId\\u003d689a209bce-a21e-49ac-a0f9-200330145310\\u0026corpPageId\\u003db8d196f8-af63-45cd-9516-d4c91f7821f2\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://corporate.cltp.com:9001/r3/corp/air-book-internal?itineraryId\\u003d689a209bce-a21e-49ac-a0f9-200330145310\\u0026corpPageId\\u003db8d196f8-af63-45cd-9516-d4c91f7821f2\"},\"deposit_account_detail\":{\"id\":46207144,\"transaction_password\":\"test123\"}}}]";
	String paramsDAPayV3Async = "[{\"payment\":{\"seq_no\":1,\"trip_id\":43453224,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"testcthotel@gmail.com\"},\"app_ref1\":\"Q200330788702\",\"app_ref2\":\"75629492\",\"payment_type\":\"DA\",\"amount\":1.0,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"CORP\",\"user_id\":1876970,\"company_id\":101,\"app_return_info\":{\"url\":\"https://demo.cleartripforbusiness.com/airConfirmNetBanking?itineraryId\\u003d689a209bce-a21e-49ac-a0f9-200330145310\\u0026corpPageId\\u003db8d196f8-af63-45cd-9516-d4c91f7821f2\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://corporate.cltp.com:9001/r3/corp/air-book-internal?itineraryId\\u003d689a209bce-a21e-49ac-a0f9-200330145310\\u0026corpPageId\\u003db8d196f8-af63-45cd-9516-d4c91f7821f2\"},\"deposit_account_detail\":{\"id\":46207144,\"transaction_password\":\"test123\"}}}]";
	
	String paramsDAPayV3FK = "[{\"payment\":{\"seq_no\":1,\"trip_id\":43453224,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"test987@gmail.com\"},\"app_ref1\":\"Q211112349\",\"app_ref2\":\"75629492\",\"payment_type\":\"DA\",\"amount\":0.9,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"API\",\"user_id\":1876970,\"company_id\":101,\"app_return_info\":{\"url\":\"\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"\"},\"deposit_account_detail\":{\"id\":44980178,\"transaction_password\":\"test\"},\"partner_reference_data\":{\"reference_id\":\"Q211112345\",\"reference_data\":{\"adjustments\":[{\"adjustments\":[{\"type\":\"SUPER_COINS\",\"adjustment_id\":\"Q211112349\",\"amount\":12821.0,\"units\":12821}],\"payment_instrument_breakup\":[{\"payment_instrument_name\":\"Net Banking\",\"amount\":592.0,\"bank_name\":\"HDFC\"}],\"amount\":13413.0,\"final_pg_amount\":592.0}]}}}}]";
	String paramsDAPayV3FK6000 = "[{\"payment\":{\"tripId\":4580505011,\"seqNo\":8,\"appRef1\":\"Q21091012345\",\"appRef2\":\"7629376500\",\"paymentType\":\"DA\",\"amount\":1.0,\"currency\":\"INR\",\"sourceType\":\"API\",\"userId\":1876970,\"companyId\":110340,\"paymentCategory\":\"B\",\"newBento\":false,\"deposit_account_detail\":{\"id\":44980178,\"transaction_password\":\"test\"},\"partner_reference_data\":{\"reference_id\":\"212223445\",\"reference_data\":{\"adjustments\":[{\"type\":\"SUPER_COINS\",\"adjustment_id\":\"34563278132\",\"amount\":2.34,\"units\":1}],\"payment_instrument_breakup\":[{\"payment_instrument_name\":\"CC / DC. String\",\"amount\":234.56,\"bank_name\":\"hdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_namepayment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"},{\"payment_instrument_name\":\"CC / DC. String stri\",\"amount\":234000000000.56,\"bank_name\":\"hdfc/sbi. Free flowing stringhdfc/sbi. Free flowing string\"}]}},\"isPWA\":false}}]";
	String paramsDAPayV3Amend = "[{\"payment\":{\"seq_no\":1,\"trip_id\":43453224,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"A\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"test987@gmail.com\"},\"app_ref1\":\"Q2111009812\",\"app_ref2\":\"75629492\",\"payment_type\":\"DA\",\"amount\":1.0,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"API\",\"user_id\":1876970,\"company_id\":101,\"app_return_info\":{\"url\":\"\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"\"},\"deposit_account_detail\":{\"id\":44980178,\"transaction_password\":\"test\"},\"partner_reference_data\":{\"reference_id\":\"123\",\"reference_data\":{\"adjustments\":[{\"adjustmentId\":\"Id for the adjustment\",\"amount\":\"discount amount\",\"offerId\":\"will be couponId for instant discount\",\"type\":\"INSTANT / BANK / FK_COIN\",\"units\":\"no. of coin units. For other cases, it will be null\"}]}}}}]";
	String paramsDAPayV3ZeroAmt = "[{\"payment\":{\"seq_no\":1,\"trip_id\":43453224,\"high_risk\":false,\"d_plus_x_in_hours\":633,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v1\",\"customer_detail\":{\"address1\":\"test\",\"city_name\":\"test\",\"postal_code\":\"121212\",\"state_name\":\"test\",\"country_name\":\"india\",\"mobile\":\"121221211\",\"landline\":\"\",\"email\":\"test987@gmail.com\"},\"app_ref1\":\"Q211112349\",\"app_ref2\":\"75629492\",\"payment_type\":\"DA\",\"amount\":0.0,\"currency\":\"INR\",\"order_info1\":\"SG/8161/DEL/BOM/20200426155000\",\"order_info2\":\"test booking\",\"source_type\":\"API\",\"user_id\":1876970,\"company_id\":101,\"app_return_info\":{\"url\":\"\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"\"},\"deposit_account_detail\":{\"id\":44980178,\"transaction_password\":\"test\"},\"partner_reference_data\":{\"reference_id\":\"Q211112345\",\"reference_data\":{\"adjustments\":[{\"adjustments\":[{\"type\":\"SUPER_COINS\",\"adjustment_id\":\"Q211112349\",\"amount\":12821.0,\"units\":12821}],\"payment_instrument_breakup\":[{\"payment_instrument_name\":\"Net Banking\",\"amount\":592.0,\"bank_name\":\"HDFC\"}],\"amount\":13413.0,\"final_pg_amount\":592.0}]}}}}]";

	String paramsGV  = "[{\"payment\":{\"seq_no\":2,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q18110930000\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"684fe048c7-cde3-4c20-9b73-a70e3c43bc9d\",\"payment_type\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331039058522\",\"card_pin\":\"147593\",\"amount\":1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip Tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331039058522\",\"card_pin\":\"147593\",\"card_category\":\"\"}}}}]";

	String paramsGVSCLP  = "[{\"payment\":{\"seq_no\":2,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q18110930000\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"684fe048c7-cde3-4c20-9b73-a70e3c43bc9d\",\"payment_type\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"5004000014042540\",\"card_pin\":\"136652\",\"amount\":1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip Tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"5004000014042540\",\"card_pin\":\"136652\",\"card_category\":\"\"}}}}]";
	String paramsWallet ="[{\"payment\":{\"seq_no\":1,\"trip_id\":54808092,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q1809140000\",\"app_ref2\":\"74049672\",\"itinerary_id\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"payment_type\":\"WT\",\"amount\":0.1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E\\/233\\/BLR\\/MAA\\/20181125062500\",\"order_info2\":\"Test Booking\",\"source_type\":\"ACCOUNT\",\"user_id\":41654864,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book-internal?ll=INFO\"},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrom/69.0.3497.100 Safari/537.36\"}}]";
	String paramsCCGVWL ="[{\"payment\":{\"seq_no\":1,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":276,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.73.123\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"firstName\":\"test\"},\"app_ref1\":\"Q18110926800\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"683a3a6bec-4e58-422a-a2c9-90707b1e5a12\",\"payment_type\":\"CC\",\"amount\":10.99,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"9W/362/DEL/BOM/201811XXXXXX00\",\"order_info2\":\"Kiran Kumar\",\"source_type\":\"ACCOUNT\",\"user_id\":85721640,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://www.cleartrip.com/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"5123456789012346\",\"card_type_id\":1,\"expiry_month\":\"05\",\"expiry_year\":\"2025\",\"cvv\":\"123\",\"name\":\"CleartripCard\",\"billto_detail\":{\"firstname\":\"test\",\"lastname\":\"test\",\"address1\":\"Cleartrip JP Nagar\",\"city_name\":\"Bangalore\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"postal_code\":\"560076\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\"}},{\"payment\":{\"seq_no\":2,\"trip_id\":54808092,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q1809140000\",\"app_ref2\":\"74049672\",\"itinerary_id\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"payment_type\":\"WT\",\"amount\":10,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E\\/233\\/BLR\\/MAA\\/20181125062500\",\"order_info2\":\"Test Booking\",\"source_type\":\"ACCOUNT\",\"user_id\":41654864,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book-internal?ll=INFO\"},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrom/69.0.3497.100 Safari/537.36\"}},{\"payment\":{\"seq_no\":2,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q18110930000\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"684fe048c7-cde3-4c20-9b73-a70e3c43bc9d\",\"payment_type\":\"GV\",\"amount\":10.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331031424400\",\"card_pin\":\"198024\",\"amount\":1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip Tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331036850568\",\"card_pin\":\"257659\",\"card_category\":\"\"}}}}]";
	String paramsInit  = "[{\"payment\":{\"seq_no\":1,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":276,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.73.123\",\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"firstName\":\"test\"},\"app_ref1\":\"Q18110920000\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"683a3a6bec-4e58-422a-a2c9-90707b1e5a12\",\"payment_type\":\"CC\",\"amount\":10.99,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"\",\"order_info2\":\"\",\"source_type\":\"ACCOUNT\",\"user_id\":85721640,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://www.cleartrip.com/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"5497774415170603\",\"card_type_id\":1,\"expiry_month\":\"02\",\"expiry_year\":\"2025\",\"cvv\":\"412\",\"name\":\"test\",\"billto_detail\":{\"firstname\":\"Cleartrip\",\"lastname\":\"Tester\",\"address1\":\"JP Nagar\",\"city_name\":\"Bangalore\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"postal_code\":\"560076\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\"}}]";
	String paramsctPay_UpdateClient ="{\"client_id\":1125,\"active\":true}";
	String paramsctPay_GetURL = "{\"order_id\":\"T2333454445\",\"client_id\":1111,\"amount\":700.10,\"currency\":\"INR\",\"country\":\"IN\",\"udf\":{\"udf1\":\"1\",\"udf2\":\"2\",\"udf3\":\"3\",\"udf4\":\"4\",\"udf5\":\"5\"},\"customer_detail\":{\"ip_address\":\"217.164.159.242\",\"address1\":\"Unit No 001, Ground Floor, DTC Bldg, Sitaram mills compound, N.M.joshi Marg, Lower parel (E)\",\"address2\":\"null\",\"address3\":null,\"city_name\":\"Mumbai\",\"postal_code\":\"400011\",\"state_name\":\"Maharashtra\",\"country_name\":\"India\",\"mobile\":\"121222112\",\"landline\":\"1212121212\",\"other_phone\":null,\"email\":\"cltppayment@gmail.com\"}}";
	String paramsctPay_ADD = "{\"client_id\":";
	String paramsctPay_ADD1 = ",\"s2s_url\":\"wwww.123.com\",\"payment_types\":\"CC,DC,TW\"}";


	String paramsEMI1 = "{\"tripRef\":\"";
	String paramsEMI2 = "\",\"amount\":30000}";
	String paramsctPay_CreateURL = "{\"order_id\":\"T2021069300\",\"client_id\":1125,\"amount\":1234.52,\"currency\":\"INR\",\"country\":\"IN\",\"return_url\":\"http://qa2.cleartrip.com\",\"udf\":{\"udf1\":\"Air ()\",\"udf2\":\"Air - ()\",\"udf3\":\"Hotel ()\",\"udf4\":\"Local & ()\",\"udf5\":\"Trains ()\"},\"customer_detail\":{\"ip_address\":\"217.164.159.242\",\"address1\":\"Unit No 001, Ground Floor, DTC Bldg, Sitaram mills compound, N.M.joshi Marg, Lower parel (E)\",\"address2\":\"Cleartrip JP Nagar\",\"address3\":null,\"city_name\":\"Bangalore\",\"postal_code\":\"560085\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"1212121112\",\"landline\":\"121212121221\",\"other_phone\":null,\"email\":\"cltppayment@gmail.com\"}}";
	String paramsFlyIN = "{\"amount\":10.10,\"currency\":\"SAR\",\"country\":\"SA\",\"txnid\":\"110119042057CTK3ZG2\",\"payment_type\":\"CC\",\"product_info\":\"Flight_Flyin\",\"source_type\":\"ACCOUNT\",\"host_name\":\"preproduction.flyin.com\",\"udf\":{\"udf1\":\"vkY25EH\",\"udf2\":\"F booking txn amount 10.10\"},\"company_id\":205,\"customer_detail\":{\"ip_address\":\"119.82.106.204\",\"mobile\":\"12121121212\",\"email\":\"123@flyin.com\"},\"card_detail\":{\"card_number\":\"4242424242424242\",\"card_type_id\":1,\"expiry_month\":\"05\",\"expiry_year\":\"2025\",\"cvv\":\"100\",\"name\":\"test test\"},\"return_url\":\"http://payments.fly.in/payment/finalresponse/ct?pid=vkY25EH\"}";
	String paramWalletCreate = "{\"currency\":\"AED\",\"createdBy\":\"13957750\",\"amount\":\"100\",\"paymentId\":\"43188350\",\"tripRef\":\"Q190822469836\",\"eventType\":\"CREATION\",\"expiryDate\":\"2020-12-21\"}";
	String paramsGV_Create_10 = "{\"currency\":\"INR\",\"amount\":\"10\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"43222146\"}";
	String paramsGV_Create_5000 = "{\"currency\":\"INR\",\"amount\":\"5000\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"43222232\"}";
	String paramsGV_Create_100000 = "{\"currency\":\"INR\",\"amount\":\"100000\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"43222232\"}";

	String paramsGV_Create_10_SCLP = "{\"currency\":\"INR\",\"amount\":\"1000\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"44582482\",\"giftVoucherType\":\"SCLP\",\"cardProgramName\":\"Cleartrip-India SCLP eGift Card\"}";
	String paramsGV_Create_10000_SCLP = "{\"currency\":\"INR\",\"amount\":\"10000\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"44582482\",\"giftVoucherType\":\"SCLP\",\"cardProgramName\":\"Cleartrip-India SCLP eGift Card\"}";
	String paramsGV_Create_10000_CLP = "{\"currency\":\"INR\",\"amount\":\"10000\",\"userEmail\":\"kiran.kumar@cleartrip.com\",\"paymentId\":\"44582482\",\"giftVoucherType\":\"CLP\",\"cardProgramName\":\"Cleartrip-India SCLP eGift Card\"}";


	String paramsGV_GET_SCLP_CAPTURE = "{\"cardNumber\":\"5004000018831128\",\"cardPin\":\"184640\",\"amount\":0.1,\"currency\":\"INR\",\"paymentId\":45246590}";
	String paramsGV_GET_SCLP_VALIDATE = "{\"amount\":1.1,\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"5004000019142061\",\"cardPin\":\"111755\"},\"customerDetail\":{\"firstName\":\"Test\",\"lastName\":\"Test\",\"mobile\":\"1121212122\"}}";
	String paramsGV_GET_SCLP_VALIDATE_LIST = "[{\"amount\":1.0,\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"5004000017915661\",\"cardPin\":\"256134\"},\"customerDetail\":{\"firstName\":\"Test\",\"lastName\":\"Test\",\"mobile\":\"1121212122\"}},{\"amount\":100.0,\"currency\":\"INR\",\"productType\":\"INTL-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"5004000013522541\",\"cardPin\":\"184630\"},\"customerDetail\":{\"firstName\":\"Test\",\"lastName\":\"Test\",\"mobile\":\"1121212122\"}}]";
	String paramsGV_GET_SCLP_VALIDATE_INSUFFICENT = "{\"amount\":200120.1,\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"5004000019142061\",\"cardPin\":\"111755\"},\"customerDetail\":{\"firstName\":\"Test\",\"lastName\":\"Test\",\"mobile\":\"1121212122\"}}";


	String paramsGV_GET_SCLP_EXPIRY ="[45241778,45241780]";


	String paramsGV_GET_SCLP_GENDOM = "{\"cardNumber\":\"5004000013382809\",\"cardPin\":\"147036\",\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\"}";
	String paramsGV_GET_SCLP_GENINTL = "{\"cardNumber\":\"5004000013382809\",\"cardPin\":\"147036\",\"currency\":\"INR\",\"productType\":\"INTL-AIR\"}";
	String paramsGV_GET_SCLP_GENHOTEL = "{\"cardNumber\":\"5004000013382809\",\"cardPin\":\"147036\",\"currency\":\"INR\",\"productType\":\"HOTEL\"}";
	String paramsGV_GET_SCLP = "{\"cardNumber\":\"1001471016335397\",\"cardPin\":\"215288\",\"currency\":\"INR\",\"productType\":\"HOTEL\"}";
	String paramsGV_GET_SCLP_DOMAIR = "{\"cardNumber\":\"1001371063548292\",\"cardPin\":\"142587\",\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\"}";
	String paramsGV_GET_SCLP_INTLAIR = "{\"cardNumber\":\"1001371063548292\",\"cardPin\":\"142587\",\"currency\":\"INR\",\"productType\":\"INTL-AIR\"}";
	String paramsGV_GET_SCLP_HOTEL = "{\"cardNumber\":\"1001471017637077\",\"cardPin\":\"187924\",\"currency\":\"INR\",\"productType\":\"HOTEL\"}";
	String paramsGV_GET_SCLP_DOMAIR_ERR = "{\"cardNumber\":\"1001471014504415\",\"cardPin\":\"238436\",\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\"}";
	String paramsGV_GET_SCLP_INTLAIR_ERR = "{\"cardNumber\":\"1001471014504415\",\"cardPin\":\"238436\",\"currency\":\"INR\",\"productType\":\"INTL-AIR\"}";
	String paramsGV_GET_SCLP_HOTEL_ERR = "{\"cardNumber\":\"1001371063548292\",\"cardPin\":\"142587\",\"currency\":\"INR\",\"productType\":\"HOTEL\"}";
	String paramsGV_GET_SCLP_BUS_ERR = "{\"cardNumber\":\"1001371063548292\",\"cardPin\":\"142587\",\"currency\":\"INR\",\"productType\":\"BUS\"}";


	String paramsEW_Pay = "{\"payment\":[{\"seq_no\":1,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"anas.ansari@cleartrip.com\"},\"app_ref1\":\"Q1903221094\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"EP\",\"amount\":5,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Mitali Biswas\",\"source_type\":\"ACCOUNT\",\"user_id\":41649008,\"company_id\":41649008,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"}]}";
	String paramsEW_PayV3 = "[{\"payment\":{\"seq_no\":1,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"varalakshmi.venkateshaiah@cleartrip.com\"},\"app_ref1\":\"Q19051212126\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"EP\",\"amount\":10,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Kiran Kumar\",\"source_type\":\"ACCOUNT\",\"user_id\":41683432,\"company_id\":41654864,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"}}]";
	String paramsEW_PayMultiV3 = "[{\"payment\":{\"seq_no\":4,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"anas.ansari@cleartrip.com\"},\"app_ref1\":\"Q1903221094\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"EP\",\"amount\":5,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Mitali Biswas\",\"source_type\":\"ACCOUNT\",\"user_id\":41649008,\"company_id\":41649008,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"}},{\"payment\":{\"seq_no\":1,\"trip_id\":116912714,\"appUserid\":10001,\"productType\":\"DOMESTIC-AIR\",\"highRisk\":false,\"d_plus_x_in_hours\":1618,\"fraudSystemInvocation\":\"N\",\"uiVersion\":\"v2\",\"customerDetail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"anas.ansari@cleartrip.com\"},\"appRef1\":\"Q6876405349\",\"appRef2\":\"74049672\",\"itineraryId\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"paymentType\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"orderInfo1\":\"6E/233/BLR/MAA/20181125062500\",\"orderInfo2\":\"Test Booking\",\"sourceType\":\"ACCOUNT\",\"userId\":13957750,\"companyId\":110340,\"appReturnInfo\":{\"url\":\"http://172.17.15.176:9080/return\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://172.17.15.176:9080/bookInternalURL\"},\"giftVoucherDetail\":{\"card_number\":\"3000331035614653\",\"card_pin\":\"105525\"},\"userAgent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\",\"paymentCategory\":\"B\",\"isPWA\":false,\"dplusXInHours\":1618,\"pwa\":false}},{\"payment\":{\"seq_no\":2,\"trip_id\":116912714,\"appUserid\":10001,\"productType\":\"DOMESTIC-AIR\",\"highRisk\":false,\"d_plus_x_in_hours\":1618,\"fraudSystemInvocation\":\"N\",\"uiVersion\":\"v2\",\"customerDetail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"anas.ansari@cleartrip.com\"},\"appRef1\":\"Q6876405349\",\"appRef2\":\"74049672\",\"itineraryId\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"paymentType\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"orderInfo1\":\"6E/233/BLR/MAA/20181125062500\",\"orderInfo2\":\"Test Booking\",\"sourceType\":\"ACCOUNT\",\"userId\":13957750,\"companyId\":110340,\"appReturnInfo\":{\"url\":\"http://172.17.15.176:9080/return\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://172.17.15.176:9080/bookInternalURL\"},\"giftVoucherDetail\":{\"card_number\":\"3000331031424400\",\"card_pin\":\"198024\"},\"userAgent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\",\"paymentCategory\":\"B\",\"isPWA\":false,\"dplusXInHours\":1618,\"pwa\":false}},{\"payment\":{\"seq_no\":1,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"customer_detail\":{\"address1\":\"Flat 403 Tower 1, Mallika Malancha HIG Complex Action area 2B, Newtown\",\"city_name\":\"kolkata\",\"postal_code\":\"560066\",\"state_name\":\"West Bengal\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"anas.ansari@cleartrip.com\"},\"app_ref1\":\"Q1904190001\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"WT\",\"amount\":50,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Test test\",\"source_type\":\"ACCOUNT\",\"user_id\":41654864,\"company_id\":41649008,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"}}]";
	String paramsEW_PayMulti= "{\"payment\":[{\"seq_no\":4,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"anas.ansari@cleartrip.com\"},\"app_ref1\":\"Q1904190001\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"EP\",\"amount\":100.5,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"test test\",\"source_type\":\"ACCOUNT\",\"user_id\":41649008,\"company_id\":41649008,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"},{\"seq_no\":1,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"anas.ansari@cleartrip.com\"},\"app_ref1\":\"Q1904190001\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"WT\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Test test\",\"source_type\":\"ACCOUNT\",\"user_id\":41649008,\"company_id\":41649008,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"},{\"seq_no\":2,\"trip_id\":116912714,\"appUserid\":10001,\"productType\":\"DOMESTIC-AIR\",\"highRisk\":false,\"d_plus_x_in_hours\":1618,\"fraudSystemInvocation\":\"N\",\"uiVersion\":\"v2\",\"customerDetail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"anas.ansari@cleartrip.com\"},\"appRef1\":\"Q6876405349\",\"appRef2\":\"74049672\",\"itineraryId\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"paymentType\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"orderInfo1\":\"6E/233/BLR/MAA/20181125062500\",\"orderInfo2\":\"Test Booking\",\"sourceType\":\"ACCOUNT\",\"userId\":13957750,\"companyId\":110340,\"appReturnInfo\":{\"url\":\"http://172.17.15.176:9080/return\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://172.17.15.176:9080/bookInternalURL\"},\"giftVoucherDetail\":{\"card_number\":\"3000331031424400\",\"card_pin\":\"198024\"},\"userAgent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\",\"paymentCategory\":\"B\",\"dplusXInHours\":1618,\"pwa\":false},{\"seq_no\":3,\"trip_id\":116912714,\"appUserid\":10001,\"productType\":\"DOMESTIC-AIR\",\"highRisk\":false,\"d_plus_x_in_hours\":1618,\"fraudSystemInvocation\":\"N\",\"uiVersion\":\"v2\",\"customerDetail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"anas.ansari@cleartrip.com\"},\"appRef1\":\"Q6876405349\",\"appRef2\":\"74049672\",\"itineraryId\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"paymentType\":\"GV\",\"amount\":1.0,\"currency\":\"INR\",\"country\":\"IN\",\"orderInfo1\":\"6E/233/BLR/MAA/20181125062500\",\"orderInfo2\":\"Test Booking\",\"sourceType\":\"ACCOUNT\",\"userId\":13957750,\"companyId\":110340,\"appReturnInfo\":{\"url\":\"http://172.17.15.176:9080/return\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://172.17.15.176:9080/bookInternalURL\"},\"giftVoucherDetail\":{\"card_number\":\"3000331031424400\",\"card_pin\":\"198024\"},\"userAgent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\",\"paymentCategory\":\"B\",\"isPWA\":false,\"dplusXInHours\":1618,\"pwa\":false}]}";
	String paramsGVWL = "[{\"payment\":{\"seq_no\":2,\"trip_id\":54808092,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"kiran.kumar@cleartrip.com\"},\"app_ref1\":\"T8162456096\",\"app_ref2\":\"74049672\",\"itinerary_id\":\"681f6b756d-67de-4efc-b663-5a7ac1bd9fa1\",\"payment_type\":\"WT\",\"amount\":1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E\\/233\\/BLR\\/MAA\\/20181125062500\",\"order_info2\":\"Test Booking\",\"source_type\":\"ACCOUNT\",\"user_id\":41654864,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/681f6b756d-67de-4efc-b663-5a7ac1bd9fa1/book-internal?ll=INFO\"},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrom/69.0.3497.100 Safari/537.36\"}},{\"payment\":{\"seq_no\":2,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":1618,\"payment_category\":\"B\",\"fraud_system_invocation\":\"N\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":\"12121221212\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"T8162456096\",\"app_ref2\":\"167823462\",\"itinerary_id\":\"684fe048c7-cde3-4c20-9b73-a70e3c43bc9d\",\"payment_type\":\"GV\",\"amount\":10.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331036684396\",\"card_pin\":\"212124\",\"amount\":10,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/8481/PAT/DEL/201812XXXXXX00\",\"order_info2\":\"Cleartrip Tester\",\"source_type\":\"WL\",\"user_id\":51351954,\"company_id\":5291262,\"app_return_info\":{\"url\":\"dummy\",\"method\":\"POST\"},\"gift_voucher_detail\":{\"card_number\":\"3000331036850568\",\"card_pin\":\"257659\",\"card_category\":\"\"}}}}]";
	
	
	String paramsEW_Validate = "{\"payment\":[{\"seq_no\":1,\"trip_id\":116912714,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":217,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"customer_detail\":{\"address1\":\"Cleartrip JP Nagar Bangalore\",\"city_name\":\"Bangalore\",\"postal_code\":\"560076\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"mobile\":\"91 1212121212\",\"email\":\"cltppayment@gmail.com\"},\"app_ref1\":\"Q1903221094\",\"app_ref2\":\"185110142\",\"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",\"payment_type\":\"EP\",\"amount\":5,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/676/BLR/CCU/201904XXXXXX00\",\"order_info2\":\"Mitali Biswas\",\"source_type\":\"ACCOUNT\",\"user_id\":41654864,\"company_id\":41654864,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/68b08214fd-e940-42d5-9f0d-190322223806/book\",\"method\":\"POST\"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Apache-HttpClient/4.4 (Java 1.5 minimum; Java/1.8.0_51)\"}]}";
	String paramsEW_AddAmt = "";
	String paramsDA_Refund = "{\"txn_id\":75413816,\"payment_id\":43422440,\"refund_txn_id\":75413816,\"amount\":1352.0}";

	String ParamsValidate = "[{\"payment\":{\"seq_no\":1,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":755,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.106.204\",\"mobile\":\" 919986696785\",\"email\":\"cltppayment@gmail.com\"},\"itinerary_id\":\"68730b1763-f9d8-4059-88ff-62ce5f4a1ef8\",\"payment_type\":\"CC\",\"amount\":4118.0,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/812/BLR/CCU/20181113055500\",\"order_info2\":\"Test Pay\",\"source_type\":\"ACCOUNT\",\"user_id\":41644016,\"company_id\":110340,\"app_return_info\":{\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/68730b1763-f9d8-4059-88ff-62ce5f4a1ef8/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"5123456789012346\",\"card_type_id\":2,\"expiry_month\":\"5\",\"expiry_year\":\"2020\",\"cvv\":\"123\",\"name\":\"Test\",\"billto_detail\":{\"firstname\":\"Test\",\"address1\":\" \",\"city_name\":\"\",\"state_name\":\"\",\"country_name\":\"\",\"postal_code\":\"\"}}}}]";
	String ParamsOLAValidate1 = "{\"promoId\":\"PS";
	String ParamsOLAValidate2 = "\",\"amount\":200,\"tripId\":\"Q898989879\",\"recipientId\":\"9986696785\",\"currency\":\"INR\",\"comments\":\"test comment\",\"returnUrl\":\"NA\",\"notificationUrl\":\"NA\",\"balanceType\":\"cash\",\"balanceName\":\"cash\",\"agentId\":\"NA\"}";
	String ParamsOLAPromoGroup1 = "{\"user_id\":41651522,\"trip_ref\":\"Q";
	String ParamsOLAPromoGroup2 = "\",\"type\":\"HOTEL_BOOKING\",\"promotions\":[{\"amount\":500.55,\"currency\":\"INR\",\"expiry_date\":\"11-11-2021\",\"trigger_date\":\"12-11-2019\",\"wallet\":\"OLA\",\"mobile\":\"9986696785\",\"email\":\"test@test.com\"}]}";

	String paramsOLAPay="\",\"amount\":50.55,\"tripId\":\"Q898989879\",\"recipientId\":\"9986696785\",\"currency\":\"INR\",\"comments\":\"test\",\"returnUrl\":\"NA\",\"notificationUrl\":\"NA\",\"balanceType\":\"cash\",\"balanceName\":\"cash\",\"agentId\":\"NA\"}"; 

	String Paramsadcb_checkbalance1 = "{  \"rewardsType\": \"ADCB\",  \"rewardsRequestType\": \"BALANCE_CHECK\",  \"trackId\": \"";
	String Paramsadcb_checkbalance2 = "\",  \"cardNumber\": \"5264083966400083\",  \"amount\": 0.01,  \"currency\": \"AED\",   \"params\": {     \"customerName\": \"test\",     \"expiryDate\": \"2506\"  }}";
	String Paramsadcb_sendOTP1 = "{  \"rewardsType\": \"ADCB\",  \"rewardsRequestType\": \"OTP\",  \"trackId\": \"";
	String Paramsadcb_sendOTP2 = "\",  \"cardNumber\": \"5264083966400083\",  \"amount\": 0.01,  \"currency\": \"AED\",  \"params\": {  \t \"customerName\": \"test\",     \"expiryDate\": \"2506\"  }}";
	
	String Paramsadcb_validate1="[   {      \"payment\":{         \"seq_no\":1,         \"payment_subtype\":\"ADCB\",         \"trip_id\":45025226,         \"app_userid\":10001,         \"product_type\":\"INTL-AIR\",         \"high_risk\":false,         \"d_plus_x_in_hours\":0,         \"payment_category\":\"B\",         \"fraud_system_invocation\":\"Y\",         \"ui_version\":\"v2\",         \"customer_detail\":{            \"ip_address\":\"192.168.50.230\",            \"mobile\":\"9999999999\",            \"email\":\"123@cleartrip.com\"         },         \"itinerary_id\":\"68730b1763-f9d8-4059-88ff-62ce5f4a1ef8\",         \"payment_type\":\"RP\",         \"amount\":10,         \"currency\":\"AED\",         \"country\":\"AE\",         \"order_info1\":\"SG/812/BLR/CCU/20181113055500\",         \"order_info2\":\"Test\",         \"source_type\":\"ACCOUNT\",         \"user_id\":41644016,         \"company_id\":110340,         \"app_return_info\":{            \"method\":\"POST\",            \"book_internal\":true,            \"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/68730b1763-f9d8-4059-88ff-62ce5f4a1ef8/book-internal?ll=INFO\"         },         \"host_name\":\"qa2.cleartrip.com\",         \"reward_points_detail\":{            \"trackId\":\"";
	
	String Paramsadcb_validate2=  "\",            \"otp\":\"11111111\",            \"bankName\": \"ADCB\",            \"card_detail\":{               \"card_number\":\"5264083966400083\",               \"card_type_id\":2,               \"expiry_month\":\"06\",               \"expiry_year\":\"2025\",               \"cvv\":\"123\",               \"name\":\"Test\",               \"billto_detail\":{                  \"firstname\":\"Test\",                  \"address1\":\" \",                  \"city_name\":\"\",                  \"state_name\":\"\",                  \"country_name\":\"\",                  \"postal_code\":\"\"               }            }         }      }   }]";
	String Paramsadcb_pay1 = "[ {\n  \"payment\" : { \"seq_no\" : 1, \"payment_subtype\":\"ADCB\", \"trip_id\" : 45025226, \"app_userid\" : 10001, \"product_type\" : \"INTL-AIR\", \"high_risk\" : false, \"d_plus_x_in_hours\" : 0, \"payment_category\" : \"B\", \"fraud_system_invocation\" : \"Y\", \"ui_version\" : \"v2\", \"customer_detail\" : {   \"ip_address\" : \"192.168.50.230\",   \"mobile\" : \"9999999999\",   \"email\" : \"123@cleartrip.com\" }, \"app_ref1\" : \"Q1810120439\", \"app_ref2\" : \"74093112\", \"itinerary_id\" : \"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\", \"payment_type\" : \"RP\", \"amount\" : 0.01, \"currency\" : \"AED\", \"country\" : \"AE\", \"order_info1\" : \"6E/21/DEL/DXB/201810XXXXXX00\", \"order_info2\" : \"test testing\", \"source_type\" : \"ACCOUNT\", \"user_id\" : 41629512, \"company_id\" : 110340, \"app_return_info\" : {   \"url\" : \"https://qa2.cleartrip.ae/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book\",   \"method\" : \"POST\",   \"book_internal\" : true,   \"book_internal_url\" : \"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book-internal?ll=INFO\" }, \"host_name\" : \"qa2.cleartrip.ae\", \"reward_points_detail\":{         \"trackId\":\"";
	String Paramsadcb_pay2 = "\",         \"otp\":\"11111111\",          \"bankName\": \"ADCB\",         \"card_detail\":{            \"card_number\":\"5264083966400083\",            \"card_type_id\":2,            \"expiry_month\":\"06\",            \"expiry_year\":\"2025\",            \"cvv\":\"123\",            \"name\":\"Test\",            \"billto_detail\":{               \"firstname\":\"Test\",               \"address1\":\" \",               \"city_name\":\"\",               \"state_name\":\"\",               \"country_name\":\"\",               \"postal_code\":\"\"            }         } }, \"user_agent\" : \"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\"\n  }\n} ]\n";
	
	String ParamsPayBackCheckBalance = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"BALANCE_CHECK\",\"trackId\":\"SAL1011122\",\"currency\":\"INR\",\"params\":{\"customerName\":\"cleartrip\",\"mobile\":\"9632699584\",\"pin\":\"3642\"}}";
	String ParamsPayBackCheckBalance_card = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"BALANCE_CHECK\",\"trackId\":\"CLRP1000018\",\"cardNumber\":\"9401120000319303\",\"params\":{\"customerName\":\"test\",\"pin\":\"3642\"}}";
	String ParamsPayBack_Vaidate1 = "[{\"payment\":{\"seq_no\":1,\"payment_subtype\":\"PAYBACK\",\"trip_id\":45025226,\"app_userid\":10001,\"product_type\":\"INTL-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":0,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"192.168.50.230\",\"mobile\":\"9620351338\",\"email\":\"123@cleartrip.com\"},\"itinerary_id\":\"68730b1763-f9d8-4059-88ff-62ce5f4a1ef8\",\"payment_type\":\"RP\",\"amount\":1,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"SG/812/BLR/CCU/20181113055500\",\"order_info2\":\"Test\",\"source_type\":\"ACCOUNT\",\"user_id\":41644016,\"company_id\":110340,\"app_return_info\":{\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/68730b1763-f9d8-4059-88ff-62ce5f4a1ef8/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"reward_points_detail\":{\"trackId\":\"CLRP1000014\",\"params\":{\"mobile\":\"9620351338\",\"pin\":\"6486\"}}}}]";
	String ParamsPayBack_CheckEarnPoints = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"EARN_CHECK\",\"trackId\":\"SAL1011122ghfjkf\",\"amount\":7050,\"currency\":\"INR\",\"params\":{\"source\":\"MOBILE\",\"isPwa\":true}}";
	String ParamsPayBack_ForgotPassword = "{\"mobileNumber\":\"1111111111\",\"cardNumber\":null}";
	String ParamsPayBack_Pay = "[{\"payment\":{\"seq_no\":1,\"payment_subtype\":\"PAYBACK\",\"trip_id\":45025226,\"app_userid\":10001,\"product_type\":\"INTL-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":0,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"192.168.50.230\",\"mobile\":\"9999999999\",\"email\":\"123@cleartrip.com\"},\"app_ref1\":\"Q18101204391\",\"app_ref2\":\"74093112\",\"itinerary_id\":\"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\",\"payment_type\":\"RP\",\"amount\":10,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/21/DEL/DXB/201810XXXXXX00\",\"order_info2\":\"test testing\",\"source_type\":\"ACCOUNT\",\"user_id\":41629512,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.ae/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"reward_points_detail\":{\"trackId\":\"";
	String ParamsPayBack_Pay1 = "\",\"params\":{\"customerName\":\"test\",\"mobile\":\"9986696785\",\"pin\":\"6756\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36\"}}]";
	String ParamsPayBack_Earn = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"EARN\",\"trackId\":\"";
	String ParamsPayBack_Earn1 = "\",\"cardNumber\":null,\"amount\":1,\"currency\":\"INR\",\"params\":{\"mobile\":\"9986696785\",\"tripRef\":\"Q191014530822\"}}";

	String ParamsPayBack_reverseearn = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"REVERSE_EARN\",\"trackId\":\"";
	String ParamsPayBack_reverseearn1 = "\",\"amount\":1,\"cardNumber\":null,\"currency\":\"INR\",\"params\":{\"mobile\":\"9986696785\",\"tripRef\":\"Q191014530822\"}}";
	String ParamsPaymentUIGetPay = "{\"train_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Ms\",\"first_name\":\"Test\",\"last_name\":\"Test\"}],\"itinerary_details\":[{\"from_station_code\":\"SBC\",\"to_station_code\":\"MYS\",\"from_station_name\":\"KSR BENGALURU\",\"to_station_name\":\"MYSURU JN\",\"train_name\":\"BSB MYS EXP\",\"train_number\":\"16230\",\"departure_time\":\"2019-11-12T00:15:00\",\"arrival_time\":\"2019-11-12T02:45:00\",\"booking_class\":\"AC 2 Tier(2A)\",\"updated_availability\":\"AVAILABLE-0119\",\"quota\":\"General\",\"seatStatus\":true}],\"pricing_details\":[{\"other_railway_charges\":119.4,\"agent_service_charge\":40,\"total\":775.4,\"insuranceCharge\":0,\"currency\":\"INR\",\"pax_pay_info\":[{\"base_fare\":616,\"pax_count\":1,\"pax_type\":\"ADULT\"}]}],\"transaction_fee_details\":{\"CC\":{\"DEFAULT\":1.8},\"DC\":{\"DEFAULT\":1},\"NB\":{\"1\":1.1,\"2\":1.2,\"3\":1.1,\"23\":1.1,\"DEFAULT\":1.35},\"KC\":{\"DEFAULT\":0},\"DA\":{\"DEFAULT\":0},\"TW\":{\"DEFAULT\":1},\"UP\":{\"DEFAULT\":1}}},\"itinerary_id\":\"f25db800de1e0137664316217d236675\",\"ttl\":3600,\"trip_id\":45134538,\"app_ref1\":\"Q1902210388\",\"app_ref2\":74282510,\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":1212121212,\"landline\":1212121212,\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"payment\",\"username\":\"cltppayment@gmail.com\"},\"product_type\":\"TRAIN\",\"currency\":\"INR\",\"order_info1\":\"16230/SBC/MYS/2019111200:15:00\",\"order_info2\":\"Test Test\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"64891349\",\"email_id\":\"cltppayment@gmail.com\",\"d_plus_x_in_hours\":273,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/trains/itinerary/f25db800de1e0137664316217d236675/process_payment\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://trains-book-nget.cltp.com:9001/r3/trains/itinerary/f25db800de1e0137664316217d236675/book_internal\",\"params\":null},\"payment_category\":\"B\"}";
	String ParamsPayBack_PayWT = "\",   \"params\": {\"customerName\": \"test\", \"mobile\": \"9620351338\", \"pin\":\"6486\"   }     },     \"user_agent\" : \"Mozilla/5.0(WindowsNT6.1;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/69.0.3497.100Safari/537.36\"   }  },  {    \"payment\":{ \"seq_no\":2, \"trip_id\":45025226, \"app_userid\":10001, \"product_type\":\"DOMESTIC-AIR\", \"high_risk\":false, \"d_plus_x_in_hours\":0, \"payment_category\":\"B\", \"customer_detail\":{    \"address1\":\"Flat403Tower1,MallikaMalanchaHIGComplexActionarea2B,Newtown\",    \"city_name\":\"kolkata\",    \"postal_code\":\"560066\",    \"state_name\":\"WestBengal\",    \"country_name\":\"India\",    \"mobile\":\"9620351338\",    \"email\":\"cltppayment@gmail.com\" }, \"app_ref1\":\"Q18101204300\", \"app_ref2\":\"74093112\", \"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\", \"payment_type\":\"WT\", \"amount\":5, \"currency\":\"INR\", \"country\":\"IN\", \"order_info1\":\"6E/21/DEL/BOM/201810XXXXXX00\", \"order_info2\":\"Testtesting\", \"source_type\":\"ACCOUNT\", \"user_id\":41649008, \"company_id\":41649008, \"host_name\":\"qa2.cleartrip.com\", \"user_agent\":\"Apache-HttpClient/4.4(Java1.5minimum;Java/1.8.0_51)\"       }  } ] ";
	String ParamsPayBack_PayWTMulti = "\",\"params\": { \"customerName\": \"test\", \"mobile\": \"9620351338\", \"pin\":\"6486\"}     },     \"user_agent\" : \"Mozilla/5.0(WindowsNT6.1;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/69.0.3497.100Safari/537.36\"   }  },  {    \"payment\":{          \"seq_no\":2,          \"trip_id\":45025226,          \"app_userid\":10001,          \"product_type\":\"DOMESTIC-AIR\",          \"high_risk\":false,          \"d_plus_x_in_hours\":0,          \"payment_category\":\"B\",          \"customer_detail\":{ \"address1\":\"Flat403Tower1,MallikaMalanchaHIGComplexActionarea2B,Newtown\", \"city_name\":\"kolkata\", \"postal_code\":\"560066\", \"state_name\":\"WestBengal\", \"country_name\":\"India\", \"mobile\":\"9620351338\", \"email\":\"cltppayment@gmail.com\"          },          \"app_ref1\":\"Q18101204300\",          \"app_ref2\":\"74093112\",          \"itinerary_id\":\"68b08214fd-e940-42d5-9f0d-190322223806\",          \"payment_type\":\"WT\",          \"amount\":5.25,          \"currency\":\"INR\",          \"country\":\"IN\",          \"order_info1\":\"6E/21/DEL/BOM/201810XXXXXX00\",          \"order_info2\":\"Testtesting\",          \"source_type\":\"ACCOUNT\",          \"user_id\":41654864,          \"company_id\":110340,          \"host_name\":\"qa2.cleartrip.com\",          \"user_agent\":\"Apache-HttpClient/4.4(Java1.5minimum;Java/1.8.0_51)\"       }  },  {    \"payment\":{          \"seq_no\":3,          \"trip_id\":45025226,       \"appUserid\" : 10001,     \"productType\" : \"DOMESTIC-AIR\",     \"highRisk\" : false,     \"d_plus_x_in_hours\" : 0,     \"fraudSystemInvocation\" : \"N\",     \"uiVersion\" : \"v2\",    \"customer_detail\" : {       \"ip_address\" : \"192.168.50.230\",       \"mobile\" : \"9620351338\",       \"email\" : \"123@cleartrip.com\"     },     \"appRef1\" : \"Q18101204300\",     \"appRef2\" : \"74093112\",     \"itineraryId\" : \"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\",     \"paymentType\" : \"GV\",     \"amount\" : 10.0,     \"currency\" : \"INR\",     \"country\" : \"IN\",     \"orderInfo1\" : \"6E/21/DEL/BOM/201810XXXXXX00\",     \"orderInfo2\" : \"TestTesting\",     \"sourceType\" : \"ACCOUNT\",     \"userId\" : 41701828,     \"companyId\" : 110340,     \"appReturnInfo\" : {       \"url\" : \"http://172.17.15.176:9080/return\",       \"method\" : \"POST\",       \"book_internal\" : true,       \"book_internal_url\" : \"http://172.17.15.176:9080/bookInternalURL\"     },     \"giftVoucherDetail\" : {       \"card_number\" : \"3000331033112563\",       \"card_pin\" : \"714375\"     },     \"userAgent\" : \"Mozilla/5.0(WindowsNT6.1;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/69.0.3497.100Safari/537.36\",     \"paymentCategory\" : \"B\",     \"isPWA\" : false,     \"dplusXInHours\" : 1618,     \"pwa\" : false       }     },  {    \"payment\":{          \"seq_no\":4,          \"trip_id\":45025226,       \"appUserid\" : 10001,     \"productType\" : \"DOMESTIC-AIR\",     \"highRisk\" : false,     \"d_plus_x_in_hours\" : 0,     \"fraudSystemInvocation\" : \"N\",     \"uiVersion\" : \"v2\",    \"customer_detail\" : {       \"ip_address\" : \"192.168.50.230\",       \"mobile\" : \"9620351338\",       \"email\" : \"123@cleartrip.com\"     },     \"appRef1\" : \"Q18101204300\",     \"appRef2\" : \"74093112\",     \"itineraryId\" : \"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\",     \"paymentType\" : \"GV\",     \"amount\" : 10.5,     \"currency\" : \"INR\",     \"country\" : \"IN\",     \"orderInfo1\" : \"6E/21/DEL/BOM/201810XXXXXX00\",     \"orderInfo2\" : \"TestTesting\",     \"sourceType\" : \"ACCOUNT\",     \"userId\" : 41701828,     \"companyId\" : 110340,     \"appReturnInfo\" : {       \"url\" : \"http://172.17.15.176:9080/return\",       \"method\" : \"POST\",       \"book_internal\" : true,       \"book_internal_url\" : \"http://172.17.15.176:9080/bookInternalURL\"     },     \"giftVoucherDetail\" : {       \"card_number\" : \"3000331033112563\",       \"card_pin\" : \"714375\"     },     \"userAgent\" : \"Mozilla/5.0(WindowsNT6.1;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/69.0.3497.100Safari/537.36\",     \"paymentCategory\" : \"B\",     \"isPWA\" : false,     \"dplusXInHours\" : 1618,     \"pwa\" : false       }     }      ";
	String ParamsPayBack_PayWTMulti1 = 	"] ";
	String ParamsPayBack_PayWTMultiCC = ",{\"payment\":{\"seq_no\":5,\"trip_id\":45025226,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":0,\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"192.168.50.230\",\"mobile\":\"9620351338\",\"email\":\"123@cleartrip.com\"},\"app_ref1\":\"Q18101204300\",\"app_ref2\":\"74093112\",\"itinerary_id\":\"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\",\"payment_type\":\"CC\",\"amount\":100.99,\"currency\":\"INR\",\"country\":\"IN\",\"order_info1\":\"6E/21/DEL/BOM/201810XXXXXX00\",\"order_info2\":\"test testing\",\"source_type\":\"ACCOUNT\",\"user_id\":41701828,\"company_id\":110340,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book-internal?ll=INFO\"},\"host_name\":\"qa2.cleartrip.com\",\"card_detail\":{\"card_number\":\"5123456789012346\",\"card_type_id\":1,\"expiry_month\":\"05\",\"expiry_year\":\"2020\",\"cvv\":\"123\",\"name\":\"CleartripCard\",\"billto_detail\":{\"firstname\":\"test\",\"lastname\":\"test\",\"address1\":\"Cleartrip JP Nagar\",\"city_name\":\"Bangalore\",\"state_name\":\"Karnataka\",\"country_name\":\"India\",\"postal_code\":\"560076\"}},\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\",\"isPWA\":false,\"pwa\":false}}";

	String ParamsPayBack_PayCC ="\",   \"params\": {  \"customerName\": \"test\",  \"mobile\": \"9620351338\",  \"pin\": \"6486\"   }   },   \"user_agent\": \"Mozilla/5.0(WindowsNT6.1;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/69.0.3497.100Safari/537.36\"    }},{    \"payment\": {   \"seq_no\": 2,   \"trip_id\": 45025226,   \"app_userid\": 10001,   \"product_type\": \"DOMESTIC-AIR\",   \"high_risk\": false,   \"d_plus_x_in_hours\": 0,   \"payment_category\": \"B\",   \"fraud_system_invocation\": \"Y\",   \"ui_version\": \"v2\",   \"customer_detail\": {   \"ip_address\": \"192.168.50.230\",   \"mobile\": \"9620351338\",   \"email\": \"123@cleartrip.com\"   },   \"app_ref1\": \"Q18101204300\",   \"app_ref2\": \"74093112\",   \"itinerary_id\": \"7325a60909-c8c7-4383-a584-4dc94dd8b5f5\",   \"payment_type\": \"CC\",   \"amount\": 100.99,   \"currency\": \"INR\",   \"country\": \"IN\",   \"order_info1\": \"6E/21/DEL/BOM/201810XXXXXX00\",   \"order_info2\": \"testtesting\",   \"source_type\": \"ACCOUNT\",   \"user_id\": 41701828,   \"company_id\": 110340,   \"app_return_info\": {   \"url\": \"https://qa2.cleartrip.com/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book\",   \"method\": \"POST\",   \"book_internal\": true,   \"book_internal_url\": \"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/7325a60909-c8c7-4383-a584-4dc94dd8b5f5/book-internal?ll=INFO\"   },   \"host_name\": \"qa2.cleartrip.com\",   \"card_detail\": {   \"card_number\": \"5123456789012346\",   \"card_type_id\": 1,   \"expiry_month\": \"05\",   \"expiry_year\": \"2020\",   \"cvv\": \"123\",   \"name\": \"CleartripCard\",   \"billto_detail\": {  \"firstname\": \"test\",  \"lastname\": \"test\",  \"address1\": \"CleartripJPNagar\",  \"city_name\": \"Bangalore\",  \"state_name\": \"Karnataka\",  \"country_name\": \"India\",  \"postal_code\": \"560076\"   }   },   \"user_agent\": \"Mozilla/5.0(WindowsNT10.0;WOW64;Trident/7.0;rv:11.0)likeGecko\",   \"isPWA\": false,   \"pwa\": false    }} ]";

	String Params_Createrefund = "{\"isFullWalletRefund\":%s,\"tripRef\":\"%s\",\"description\":\"some test description\",\"amount\":%s,\"txnid\": %s }";
	String Params_Createrefund1 = "{\"isFullWalletRefund\":false,\"tripRef\":\"%s\",\"status\":null,\"description\":\"some test description\",\"amount\":%s,\"txnid\": %s }";

	String Params_Updatestatus ="{\"refundId\": %s ,\"currentStatus\":\"S\",\"finalStatus\":\"P\"}";
	String Params_Updatepgtxnid = "{\"refundId\": %s ,\"pgGenerationTxnId\": %s }";

	String Params_ROR_UpdateProfile_List= "{\"id\":5073286,\"card_number_prefix\":\"340000\",\"ip_address\":\"12.34.56.80\",\"phone_number\":\"";
	String Params_ROR_UpdateProfile_List1 = "\",\"booked_by_email_id\":\"\",\"card_holder_email_id\":\"\",\"effective_upto\":\"2019-12-26 05:30:00\",\"status\":\"T\",\"list_type\":0,\"temporary\":1,\"remarks\":\"Api tests\",\"user_id\":\"123456543\"}";

	String Params_ROR_Cash_Update= "{\"id\":5116412,\"payment_id\":43336324,\"company_id\":198348,\"description\":\"test\",\"transaction_ref_no\":1,\"status\":\"I\",\"first_name\":\"test\"}";


	String Params_ROR_UpdateRefund_List = "[{\"id\":9371271,\"paymentId\":43350738,\"refundAmount\":3221,\"refundFileId\":null,\"status\":\"D\",\"description\":\"test\",\"seqNo\":123,\"bosFileId\":null,\"pgGenerationTxnId\":75298206,\"paymentReconciliationFileId\":null,\"txnId\":75298206,\"taken\":null,\"pbosFileId\":1223,\"rollbacked\":null,\"rollbackSupported\":\"Y\",\"arnNo\":\"";

	String Params_ROR_UpdateRefund_List1 = "\",\"attempted\":\"N\",\"refundType\":\"DC\"}]";

	String Params_ROR_Create_Profile_List = "{\"card_number_prefix\":\"12345679\",\"ip_address\":\"12.34.56.81\",\"phone_number\":\"121212121221\",\"booked_by_email_id\":\"123@1223.com\",\"card_holder_email_id\":\"123@1223.com\",\"status\":\"T\",\"list_type\":0,\"temporary\":1,\"user_id\":\"123456543\"}";
	String Params_ROR_Update_Payments = "{\"id\":43327334,\"trip_id\":106562333,\"txn_id\":167823463,\"payment_type\":\"DC\",\"amount\":3.955111,\"created_at\":1571291019000,\"updated_at\":1578889867935,\"seq_no\":1,\"status\":\"S\",\"description\":\"Initializing the payment\",\"currency\":\"INR\",\"order_info1\":null,\"order_info2\":null,\"app_ref1\":\"167823462\",\"app_ref2\":167823462,\"neglist_id\":null,\"pos_list_id\":null,\"linkable_id\":null,\"linkable_type\":null,\"user_message\":null,\"pan_number\":null,\"payment_category\":\"B\",\"merchant_txn_ref\":\"43327334\",\"payment_subtype\":null,\"express_checkout\":null,\"emi_count\":null,\"emi_fee\":null,\"ref_payment_id\":null,\"payment_cards_gateway_accesses\":[{\"id\":389967720,\"payment_id\":43327334,\"trip_ref\":\"TPOtpK34\",\"txn_id\":167823462,\"payment_mode\":\"D\",\"gateway_id\":52,\"card_number\":\"458546XXXXXX5964\",\"name_on_card\":\"test\",\"amount\":1.0,\"status\":\"S\",\"description\":\"Initializing\",\"tran_type\":\"INIT\",\"seq_no\":1,\"created_at\":1571291061000,\"updated_at\":1571291061000,\"credential_name\":\"IN_TECH_PROCESS_OTP_QA\",\"retry_count\":0,\"card_number_hash\":\"d1e0bef8e70b9968ac037aa1d0b0b0242d4a3203836f0822d75a0c3267c37bf1\"},{\"id\":389967722,\"payment_id\":43327334,\"trip_ref\":\"TPOtpK34\",\"txn_id\":167823462,\"payment_mode\":\"D\",\"gateway_id\":52,\"card_number\":\"458546XXXXXX5964\",\"name_on_card\":\"test\",\"amount\":1.0,\"status\":\"F\",\"description\":\"OTP Flag is not present in TP response : Error Code :ERROR082\",\"gateway_response1\":\"0399\",\"gateway_response2\":\"failed\",\"gateway_response4\":\"1180\",\"gateway_response5\":\"43327334\",\"gateway_response8\":\"ERROR082\",\"gateway_response9\":\"NA\",\"gateway_response11\":\"b1029d24a0b8a9fe2ae7b00a815bb453d5c4d55f\",\"tran_type\":\"PAUT\",\"seq_no\":1,\"created_at\":1571291065000,\"updated_at\":1571291303000,\"credential_name\":\"IN_TECH_PROCESS_OTP_QA\",\"retry_count\":0,\"card_number_hash\":\"d1e0bef8e70b9968ac037aa1d0b0b0242d4a3203836f0822d75a0c3267c37bf1\"},{\"id\":389967724,\"payment_id\":43327334,\"trip_ref\":\"TPOtpK34\",\"txn_id\":167823462,\"payment_mode\":\"D\",\"gateway_id\":14,\"card_number\":\"458546XXXXXX5964\",\"name_on_card\":\"test\",\"amount\":1.0,\"status\":\"S\",\"description\":\"Initializing\",\"tran_type\":\"INIT\",\"seq_no\":1,\"created_at\":1571291303000,\"updated_at\":1571291303000,\"credential_name\":\"IN_TECH_PROCESS\",\"retry_count\":0,\"card_number_hash\":\"d1e0bef8e70b9968ac037aa1d0b0b0242d4a3203836f0822d75a0c3267c37bf1\"}],\"payment_cash_details\":null,\"payment_gift_voucher_txns\":[],\"payment_tp_wallet_txns\":[],\"payment_upi_txns\":[],\"payment_redirect_timings\":[{\"payment_id\":43327334,\"redirection_out\":1571291305948,\"created_at\":1571291305951,\"updated_at\":1571291305951,\"retry_count\":0,\"id\":34678514}],\"payment_card_details\":[{\"id\":30780182,\"payment_id\":43327334,\"card_number\":\"458546XXXX445964\",\"card_type_id\":1,\"payment_mode\":\"D\",\"bank_id\":6,\"created_at\":1571291061000,\"updated_at\":1571291061000,\"bin_id\":0,\"country\":\"INDIA\"}],\"payment_cash_card_detail\":null,\"payment_net_banking_details\":null,\"payment_ivr_detail\":null,\"payment_techpro_detail\":null,\"payment_third_party_da_details\":[],\"payment_third_party_details\":[],\"payment_ap_txns\":[],\"payment_da_transactions\":[],\"payment_da_details\":[],\"payment_wallet_transactions\":[],\"reward_points_txns\":null}";

	String Params_IR_Valid_VPA= "{\"accountType\":\"VPA\",\"vpa\":\"kirank@okhdfcbank\",\"bankAccountNumber\":\"51248779\",\"ifsc\":\"HDFC0000531\"}";
	String Params_IR_InValid_VPA= "{\"accountType\":\"VPA\",\"vpa\":\"kirankokhdfcbank\",\"bankAccountNumber\":\"51248779\",\"ifsc\":\"HDFC0000531\"}";
	
	String Params_IR_Save_VPA_Details= "{\"accountType\":\"VPA\",\"vpa\":\"3212467@okhdfcbank\",\"accountHolderName\":\"kiran Kumar\",\"cancellationTxnId\":\"2022020947\",\"isConsentAvailable\":true,\"savedDetailsId\":0,\"tripRef\":\"Q211223200042\",\"userDetails\":{\"userId\":\"65237343\"}}";
	String Params_IR_Create_Refund1= "{\"isFullWalletRefund\":false,\"accountType\":\"VPA\",\"refundVersion\":\"INSTANT\",\"tripRef\":\"Q221102593002\",\"description\":\"Refund cron\",\"amount\":1.0,\"txnid\":";
	String Params_IR_Create_Refund2= "{\"isFullWalletRefund\":false,\"refundVersion\":\"NORMAL\",\"tripRef\":\"Q220223384658\",\"description\":\"Refund cron\",\"amount\":1.0,\"txnid\":";
	String Params_IR_Create_Refund3= ",\"cancellationTxnId\":1234567,\"disableAutoRefundProcessing\":false}";
	String Params_IR_Create_Refund4= "{\"isFullWalletRefund\":false,\"accountType\":\"WALLET\",\"refundVersion\":\"INSTANT\",\"tripRef\":\"Q221102593002\",\"description\":\"Refund cron\",\"amount\":1.0,\"txnid\":";
	String Params_IR_Create_Refund5= "{\"isFullWalletRefund\":false,\"refundVersion\":\"NORMAL\",\"tripRef\":\"Q220223384658\",\"description\":\"Refund cron\",\"amount\":1.0,\"txnid\":";
	String Params_IR_Create_Refund6= "{\"isFullWalletRefund\":false,\"accountType\":\"WALLET\",\"refundVersion\":\"INSTANT\",\"tripRef\":\"Q221208608736\",\"description\":\"Refund cron\",\"amount\":1.0,\"txnid\":";



	String Params_RORUpdate_GW_Status = "{\"currentStatus\":\"P\",\"status\":\"I\",\"gatewayId\":14}";
	String Params_Enque_refunds = "[\"Q210203887410\",\"Q210225908308\"]";
	String Params_RORCreate_Payment = "[{\"payment\":{\"id\":null,\"trip_id\":46198930,\"txn_id\":75300328,\"payment_type\":\"IV\",\"amount\":\"1000.0\",\"created_at\":\"2019-11-20T18:40:29+05:30\",\"updated_at\":\"2019-11-20T18:40:29+05:30\",\"seq_no\":3,\"status\":\"S\",\"description\":\"created by API\",\"currency\":\"INR\",\"order_info1\":123,\"order_info2\":345,\"app_ref1\":\"Q191109570525\",\"app_ref2\":75300328,\"neglist_id\":\"y\",\"poslist_id\":109,\"linkable_id\":null,\"linkable_type\":null,\"user_message\":null,\"pan_number\":null,\"payment_category\":\"B\",\"merchant_txn_ref\":\"12312\",\"payment_subtype\":\"ADCB\",\"express_checkout\":null,\"emi_count\":null,\"emi_fee\":null,\"ref_payment_id\":null,\"ivr_detail\":{\"id\":null,\"description\":null,\"created_at\":null,\"updated_at\":null,\"seq_no\":null,\"payment_id\":null,\"transaction_ref_no\":\"Q234334\",\"card_number\":\"1234 2344 3434\",\"response_message\":\"testmsg\",\"gateway_txn_id\":12345,\"gateway\":\"ivr_gateway\",\"status\":null,\"credential_name\":\"test\"}}}]";
	String Params_RORCreate_Profile_List = "{\"card_number_prefix\":\"12345679\",\"ip_address\":\"12.34.56.81\",\"phone_number\":\"121212121221\",\"booked_by_email_id\":\"123@1223.com\",\"card_holder_email_id\":\"123@1223.com\",\"status\":\"T\",\"list_type\":0,\"temporary\":1,\"user_id\":\"123456543\"}";
	String Params_RORSearch_Profile_List = "{\"list_type\":0,\"page_number\":1}";
	String Params_RORCreate_Refund = "{\"isFullWalletRefund\":false,\"tripRef\":\"Q210331930780\",\"amount\":1,\"description\":\"Autaomtion REFUND\",\"txnid\":";
	String ParamsROR_Recon = "{\"tripRef\":\"Q191203587976\",\"txnId\":";

	String ParamsQitaf_SendOTP = "{\"rewardsType\":\"QITAF\",\"rewardsRequestType\":\"OTP\",\"params\":{\"mobile\":\"555021516\"},\"trackId\":\"1280431506701\"}";
	String ParamsQitaf_Redeem = "{\"rewardsType\":\"QITAF\",\"rewardsRequestType\":\"REDEEM\",\"params\":{\"mobile\":\"555021515\",\"pin\":\"2118\"},\"trackId\":\"1280431506700\",\"paymentId\":\"123456106700\",\"amount\":300,\"currency\":\"SAR\",\"otp\":\"1235\"}";
	String ParamsROR_Reverse= "{\"rewardsType\":\"QITAF\",\"rewardsRequestType\":\"REVERSE\",\"trackId\":\"1222234\",\"amount\":10,\"paymentId\":44695226,\"currency\":\"SAR\",\"params\":{\"tripRef\":\"Q210218897302\"}}";

	String ParamsSuperCoins_SendOTP = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"OTP\",\"trackId\":\"CTS01021\",\"amount\":10,\"params\":{\"mobile\":\"+918884094547\",\"itineraryId\":\"681f6b756d-67de-4efc-b3-5a7ac1bd9fa1\"}}";
	String ParamsSuperCoins_ValidateOTP = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"VALIDATE_OTP\",\"trackId\":\"CTS01021\",\"otp\":\"";
	String ParamsSuperCoins_ValidateOTP1 = "\",\"params\":{\"mobile\":\"+918884094547\",\"itineraryId\":\"681f6b756d-67de-4efc-b3-5a7ac1bd9fa1\"}}";
	String ParamsSuperCoins_Earn1= "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"EARN_CHECK\",\"trackId\":\"SAL1011122ghfjkf\",\"productType\":\"HOTEL\",\"amount\":1801,\"currency\":\"INR\"}";
	String ParamsSuperCoins_CheckMobileLinked1="{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"ACCOUNT_LINKED_AND_BALANCE\",\"productType\":\"HOTEL\",\"params\":{\"itineraryId\":\"756177b6c1-fab4-4643-ab7c-220704151433\",\"mobile\":\"+919986696785\"},\"amount\":1000.0,\"uid\":\"756177b6c1-fab4-4643-ab7c-220704151433\"}";
	String ParamsSuperCoins_TrnxInfo="{\"tripRef\":\"Q210922154594\",\"paymentId\":\"\",\"txnType\":[\"INIT_EARN\"]}";


	String ParamsAffordability_Eligi_NCE_PL_V2="{\"product_type\":\"DOMESTIC_AIR\",\"payment_mode_list\":[{\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"NOCOST\"},{\"payment_mode\":\"PL\"}],\"customer_info\":{\"user_id\":\"";
	String ParamsAffordability_Eligi_NCE_PL_V2_2="\"},\"pricing_list\":[{\"amount\":4000,\"uuid\":\"122\"},{\"amount\":6000,\"uuid\":\"133\"}]}";


	String ParamsAffordability_Eligi_NCE_PL_V2_Plans="{\"uuid\":\"NI68503666e0-2ace-4be1-be9a-230123150313\",\"product_type\":\"DOMESTIC_AIR\",\"payment_mode_list\":[{\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"NOCOST\"},{\"payment_mode\":\"PL\"}],\"customer_info\":{\"user_id\":\"";
	String ParamsAffordability_Eligi_NCE_PL_V2_2_Plans="\"},\"amount\":9100,\"request_mode\":\"FULL\"}";

	String ParamsAffordability_Eligi_NCE="{\"product_type\":\"INTL_AIR\",\"payment_mode_list\":[{\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"NOCOST\"}],\"pricing_list\":[{\"amount\":100,\"uuid\":\"12\"},{\"amount\":20000,\"uuid\":\"122\"}]}";
	String ParamsAffordability_Eligi_Reg="{\"product_type\":\"INTL_AIR\",\"payment_mode_list\":[{\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"REGULAR\"}],\"pricing_list\":[{\"amount\":100,\"uuid\":\"12\"},{\"amount\":20000,\"uuid\":\"122\"}]}";
	String ParamsAffordability_Plans_NCE_Full="{\"product_type\":\"DOMESTIC_AIR\",\"uuid\":\"NI68503666e0-2ace-4be1-be9a-230123150313\",\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"NOCOST\",\"amount\":123853,\"request_mode\":\"FULL\"}";
	String ParamsAffordability_Plans_NCE_Lite="{\"product_type\":\"DOMESTIC_AIR\",\"uuid\":\"NI68503666e0-2ace-4be1-be9a-230123150313\",\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"NOCOST\",\"request_mode\":\"LITE\"}";
	String ParamsAffordability_Plans_Reg_Full="{\"product_type\":\"DOMESTIC_AIR\",\"uuid\":\"NI68503666e0-2ace-4be1-be9a-230123150313\",\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"REGULAR\",\"amount\":123853,\"request_mode\":\"FULL\"}";
	String ParamsAffordability_Plans_Reg_Lite="{\"product_type\":\"INTL_AIR\",\"uuid\":\"NI68503666e0-2ace-4be1-be9a-230123150313\",\"payment_mode\":\"EMI\",\"payment_sub_mode\":\"REGULAR\",\"amount\":123853,\"request_mode\":\"LITE\"}";

	String ParamsAffordability_PL_Eligibility="\",   \"productType\": \"DOMESTIC_AIR\",   \"affordabilityType\": \"PL\",   \"amount\": 8000,   \"uuid\": \"Q12345\" }";

	String ParamsAffordability_PL_Eligibility_2000="\",   \"productType\": \"DOMESTIC_AIR\",   \"affordabilityType\": \"PL\",   \"amount\": 2000,   \"uuid\": \"Q12345\" }";

	String ParamsEMI_Juspay_SaveAPI="[{\"tenure\":50,\"interest\":12,\"minAmount\":3000.0,\"maxAmount\":null,\"bankFee\":199.0,\"paymentType\":\"EMI\",\"paymentSubtype\":\"CC\",\"providerValue\":\"192\",\"provider\":\"bank\",\"displayPlan\":true,\"emiPlanGatewayMapping\":[{\"gatewayId\":25,\"credentialName\":\"RAZORPAY_V2_TEST\",\"gatewayPlanId\":null},{\"gatewayId\":27,\"credentialName\":\"Tests_HDFC\",\"gatewayPlanId\":null}]}]";

	String ParamsSuperCoins_Hold = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"HOLD\",\"trackId\":\"681f76-6de-4ec-b359adhks1s6\",\"productType\":\"AIR\",\"amount\":1.6,\"params\":{\"mobile\":\"+919986696785\",\"itineraryId\":\"681f76-6de-4ec-16559048910479\"}}";
	String ParamsSuperCoins_Unhold = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"UNHOLD\",\"trackId\":\"681f76-6de-4ec-b359adhks1s6\",\"params\":{\"mobile\":\"+919986696785\",\"itineraryId\":\"NI68ff2771a0-361c-4a65-bb92-220721200825\"}}";
	String ParamsSuperCoins_CheckBalance = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"BALANCE_CHECK\",\"trackId\":\"CLRP1000232\",\"currency\":\"INR\",\"params\":{\"mobile\":\"+919986696785\"}}";
	
	
	String ParamsSuperCoins_CheckEarnPoints = "{\"rewardsType\":\"SUPERCOINS\",\"rewardsRequestType\":\"EARN_CHECK\",\"trackId\":\"SAL1011122ghfj1\",\"amount\":2449,\"currency\":\"INR\",\"params\":{\"source\":\"MOBILE\",\"isPwa\":true,\"tripRef\":\"Q191014530821\"}}";

	String ParamsSuperCoins_CreatePromo = "{\"user_id\":41649009,\"trip_ref\":\"";
	String ParamsSuperCoins_CreatePromo1 = "\",\"type\":\"AIR_BOOKING\",\"promotions\":[{\"amount\":10,\"currency\":\"INR\",\"expiry_date\":\"11-12-2023\",\"trigger_date\":\"14-01-2022\",\"wallet\":\"SUPERCOINS\",\"mobile\":\"+917483912960\",\"email\":\"test@test.com\"}]}";

	String ParamsSuperCoins_UpdatePromo = "{\"amount\":20,\"currency\":\"INR\",\"expiry_date\":\"24-12-2021\",\"trigger_date\":\"";
	String ParamsSuperCoins_UpdatePromo1 = "\",\"status\":\"ACTIVE\"}";
	
	String ParamsFetchRefund="{\"refundIds\":[9387165,9387150,9387149,9387190,9387357"
			+ ",9387405],\"txnIds\": null,"+"\"status\": [\"D\",\"P\",\"S\",\"T\",\"F\"]}";
	
	String ParamsFetchRefundByTripRef="{\"tripRef\":[\"Q200422824400\",\"Q200421824282\",\"Q200421824270\",\"Q200414822686\",\"Q200414822642\", \"Q200413822486\",\"Q200413822480\"],\"status\": \"D\"}";
	
	String s=RandomStringUtils.randomAlphabetic(5);
	String r=RandomStringUtils.randomNumeric(2);
	String t=RandomStringUtils.randomNumeric(6);
	String Param1="{\"bank\":\" "+s;
	String Param2=" \",\"bank_id\": "+r;
	String Param3=", \"bin\":\""+t;
	String Param4="\", \"card_type\": \"CREDIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"MASTERCARD\",\"sub_type\": \"NA\"}";

	String Param5="\", \"card_type\": \"DEBIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"MASTERCARD\",\"sub_type\": \"NA\"}";

	String Params_Singlebincard_Credit=Param1+Param2+Param3+Param4;
	String Params_Singlebincard_Debit=Param1+Param2+Param3+Param5;
	String Param6="\", \"card_type\": \"CREDIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"VISA\",\"sub_type\": \"NA\"}";
	String Param7="\", \"card_type\": \"DEBIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"VISA\",\"sub_type\": \"NA\"}";
	String Params_Singlebincard_Visa_Credit=Param1+Param2+Param3+Param6;
	String Params_Singlebincard_Visa_Debit=Param1+Param2+Param3+Param7;

	String Params_Reporting_UpdloadQ_FetchBy_RefundID="{\"refundIds\":[9387291,9387289],\"txnIds\":null,\"status\":null}";
	String Params_Reporting_UpdloadQ_FetchBy_TripID="{\"tripRef\":[\"Q190722430506\",\"Q200417823668\"],\"status\":\"D\"}";

	
	
	
	String Params_Reporting_Refund_Status_Post="{\"refundStatus\":\"D\",\"paymentType\":[\"GV\",\"CC\"],\"tripRef\":[\"Q190722430506\",\"Q200417823774\"]}";
	
	String paramsCSPayvalidate="[{\"payment\":{\"seq_no\":1,\"trip_id\":106562332,\"app_userid\":10001,\"product_type\":\"DOMESTIC-AIR\",\"high_risk\":false,\"d_plus_x_in_hours\":276,\r\n" + 
			"\"payment_category\":\"B\",\"fraud_system_invocation\":\"Y\",\"ui_version\":\"v2\",\"customer_detail\":{\"ip_address\":\"119.82.73.123\",\r\n" + 
			"\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"firstName\" : \"test\"},\"app_ref1\":\"Q18110926806\",\"creditshell_account_detail\":{\"id\":1},\r\n" + 
			"\"app_ref2\":\"167823462\",\"itinerary_id\":\"683a3a6bec-4e58-422a-a2c9-90707b1e5a12\",\"payment_type\":\"CS\",\"amount\":1,\"currency\":\"USD\",\"country\":\"IN\",\r\n" + 
			"\"order_info1\":\"9W/362/DEL/BOM/201811XXXXXX00\",\"order_info2\":\"Kiran Kumar\",\"source_type\":\"ACCOUNT\",\"user_id\":85721640,\"company_id\":110340,\r\n" + 
			"\"app_return_info\":{\"url\":\"https://www.cleartrip.com/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book\",\"method\":\"POST\",\"book_internal\":true,\r\n" + 
			"\"book_internal_url\":\"http://book-flights.cltp.com:9001/r3/book/flights/itinerary/683a3a6bec-4e58-422a-a2c9-90707b1e5a12/book-internal?ll=INFO\"\r\n" + 
			"},\"host_name\":\"qa2.cleartrip.com\",\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko\"}}]";
	
	
	String params_FK_Refund1="{\"amount\":0.1,\"description\":\"1 Segment\",\"isFullWalletRefund\":false,\"disableAutoRefundProcessing\":true,\"source\":\"FK_Refund_Automation\",\"tripRef\":\"Q211130188952\",\"txnid\":";

	String params_FK_Refund_Update_PartnerInfo ="[{\"refund_id\":\"10042072\",\"trip_ref\":\"Q210323926516\",\"partner_reference_data\":{\"reference_id\":\"123456\",\"reference_data\":{\"adjustments\":[{\"adjustmentId\":\"Id for the adjustmentssssfff\",\"amount\":\"discount amountssss\",\"offerId\":\"will be couponId for instant discountttt\",\"type\":\"INSTANT / BANK / FK_COINNN\",\"units\":\"no. of coin units. For other cases, it will be null\"}]}},\"override_partner_ref_data\":true},{\"refund_id\":\"9876543\",\"trip_ref\":\"208765432\",\"partner_reference_data\":{\"reference_id\":\"123456\",\"reference_data\":{\"adjustments\":[{\"adjustmentId\":\"Id for the adjustmentssssdd\",\"amount\":\"discount amountssss\",\"offerId\":\"will be couponId for instant discountttt\",\"type\":\"INSTANT / BANK / FK_COINNN\",\"units\":\"no. of coin units. For other cases, it will be nulllllll\"}]}},\"override_partner_ref_data\":true}]";
			
	
	String params_FK_Refund_Status_Update = "{\"refundIds\":[10148042],\"toStatus\":\"F\"}";
	
	String paramsCSPay="";
	
	String paramsWalletrevertPromo = "{\"tripRef\":\"Q201124864780\",\"amount\":100.1}";


	String ParamsGetPayURL_Air = "{\"itinerary_id\":\"6899c725d1-a698-4978-8fa7-2001081509423\",\"ttl\":0,\"trip_id\":46314335,\"trip_ref\":\"Q10041538791\",\"txn_id\":\"75509223\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"A\",\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"INR\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10}}}";

	String ParamsGetPayURL_Air_Coupon= "";
	

	String ParamsGetPayURL_Air_GV= "";

	String ParamsGetPayURL_Air_RP= "";

	
	
	
	public String AirUrl ="https://qa2new.cleartrip.com/flights/results?from=BLR&to=BOM&depart_date=24/12/2020&adults=1&childs=0&infants=0&class=Economy&airline=&carrier=&intl=n";
	
	String urlInit = "/paymentservice/service/otp/init";
	String urlProcess = "/paymentservice/service/otp/process";
	String urlResend = "/paymentservice/service/otp/resend";
	String urlPayValidateV3 = "/paymentservice/service/validate/v3";
	String urlPayV3 = "/paymentservice/service/pay/v3";
	String urlPayV2 = "/paymentservice/service/pay";
	String url1_FetchPayDetails = "/trips?tripID=Q1904233450";
	String urlpromoActivate = "/promoservice/v1/promogroups/Q210428976934";
	String urlpromoUsed = "/payments/wallet/promo/used?tripRef=Q190702311622";
	String urlFetchTripStatus = "/paymentservice/service/status/xml/Q210302910382.ref";
	String urlFetchGWFailure = "/paymentservice/bannerDetails";
	String urlHi5_Fetch_Wallet = "/pay/wallet?userId=65218660&currency=INR";
	String urlHi5_Fetch_WalletTnx = "/pay/wallet/5758972/transactions?offset=1&size=10";

	String urlMIS_Report_PL = "/paymentservice/service/air/mis/detail?paymentType=PL&tripRef=Q221208608790";

	String urlMIS_Report_CC = "/paymentservice/service/air/mis/detail?paymentType=CC&tripRef=Q221213613184";

	String urlMIS_Report_DC = "/paymentservice/service/air/mis/detail?paymentType=DC&tripRef=Q221208609206";
	String urlMIS_Report_NB = "/paymentservice/service/air/mis/detail?paymentType=NB&tripRef=Q221213613594";
	String urlMIS_Report_RP_SC = "/paymentservice/service/air/mis/detail?paymentType=RP&tripRef=Q221213612630";
	String urlMIS_Report_RP_ADCB = "/paymentservice/service/air/mis/detail?paymentType=RP&tripRef=Q220226385630";

	String urlMIS_Report_WT_Rewards = "/paymentservice/service/air/mis/detail?paymentType=WT&tripRef=Q221213613306";
	String urlMIS_Report_WT_Credit = "/paymentservice/service/air/mis/detail?paymentType=WT&tripRef=Q221212612090";

	String urlMIS_Report_GV = "/paymentservice/service/air/mis/detail?paymentType=GV&tripRef=Q221209610250";

	String urlMIS_Report_CLEMI = "/paymentservice/service/air/mis/detail?paymentType=CL_EMI&tripRef=Q221212612160";
	String urlMIS_Report_EMI = "/paymentservice/service/air/mis/detail?paymentType=EMI&tripRef=Q221209609956";
	String urlMIS_Report_UP = "/paymentservice/service/air/mis/detail?paymentType=UP&tripRef=Q221213613660";
	String urlMIS_Report_TW = "/paymentservice/service/air/mis/detail?paymentType=TW&tripRef=Q221123601794";
	String urlMIS_Report_DA = "/paymentservice/service/air/mis/detail?paymentType=DA&tripRef=Q221213613752";
	String urlMIS_Report_PL_Refund ="/paymentservice/service/air/mis/detail?paymentType=PL&tripRef=Q221117600854&reqFor=REFUND";

	String urlSuperCoins_MobileLinked= "/payments/rewards/supercoins/checkAccountLinked?mobileNumber=+919986696785";

	String urlSuperCoins_Info= "payments/rewards/supercoins/rewardTxnDetails";

	String urlHi5_GetTrnx= "/pay/wallet/5758972/transactions?offset=1&size=10";

	//String urlSuperCoins_Info = "/api/supercoinsInfo/Q221028592282";
	//String urlSuperCoins_TrnxInfo = "/api/supercoinsInfo/Q221028592282";
	
	String urlSuperCoins_SendOTP="/payments/rewards/sendOtp";

	String urlSuperCoins_ValidateOTP = "/payments/rewards/supercoins/validateOtp";
	String urlSuperCoins_Unhold = "/payments/rewards/supercoins/unhold";
	String urlSuperCoins_Hold = "/payments/rewards/supercoins/hold";
	String urlSuperCoins_CheckBalance = "/payments/rewards/checkBalance";

	String urlSuperCoins_CheckEarnPoints = "/payments/rewards/supercoins/v1/earnConfig?productType=AIR";
	String urlSuperCoins_CheckEarnPoints1 = "/payments/rewards/checkEarnPoints";
	String urlSuperCoins_CheckMobileLinked1 = "/payments/rewards/supercoins/checkAccountLinkedAndBurnDetails";
	String urlSuperCoins_CreatePromo = "/promoservice/v1/promogroups";
	String urlAffordability_EMI_Eligibility_Plans = "/payments/affordability/plans?tripId=21234";
	String urlAffordability_EMI_Eligibility = "/payments/affordability/eligibility";
	String urlAffordability_EMI_V2_Plans = "/payments/affordability/plans";
	String urlAffordability_PL_Eligibility = "/paymentservice/api/getAllPayLaterMerchants";


	String urlSuperCoins_UpdatePromo = "/promoservice/v1/promogroups/Q2109156655/promotions/64905";
	String urlSuperCoins_ActivatePromo = "/promoservice/v1/promogroups/Q210921153722/promotions/65253";
	
	String urlPayFlyin = "/paymentservice/gw/v1/pay";
	String urlSavedCards ="/paymentservice/saved/payments/get/65218452";

	String urlEMI_NoCost_Offers = "/paymentservice/emi/offers";
	String urlEMI_NoCost_Offers_Eligibility_New = "/paymentservice/emiOfferEligibility"; // Juspay EMI Api
	String urlEMI_Banks = "/paymentservice/service/emibanks";
	String urlEMI_Interest = "/paymentservice/service/emiinterests";
	String urlpayReporting= "/paymentservice/service/air/mis/detail?tripRef=Q190530193406&paymentType=CC&reqFor=refund";

	String urlEndPoint_Wallet_PromoUsed="/payments/wallet/promo/used?tripRef=Q19050680568"; 	

	String urlROR_Cash_Update="/paymentservice/payments/cashdetail/update";

	String urlEndPoint_GV_GetSCLP="/payments/gv/get";

	String urlEndPoint_GV_SCLP_CAPTURE="/payments/gv/capture";
	String urlEndPoint_GV_SCLP_VALIDATE="/payments/gv/validate";
	String urlEndPoint_GV_SCLP_VALIDATE_LIST="/payments/gv/validatePaymentList";

	String urlEndPoint_GV_SCLP_EXPIRY="/payments/gv/getExpiry";



	String urlEndPoint_GV_GetSCLP_DOMAIR="";

	String urlEndPoint_GV_GetSCLP_INTLAIR="";
	String urlEndPoint_GV_GetSCLP_HOTEL="";
	String urlEndPoint_GV_GetSCLP_HOTEL_ERR="";
	String urlEndPoint_GV_GetSCLP_DOMAIR_ERR="";

	String urlRecommendation_getDetails= "/recommendation/preferredpaymentmodes?userId=65234404";

	String urlEndPoint_GV_Get="/payments/gv/get?cardnumber=3000331033588753&cardpin=247648&currency=INR&productType=DOMESTIC-AIR&itineraryId=681f6b756d-67de-4efc-b663-5a7ac1bd9fa1&cardCategory=DF";
	String urlEndPoint_GV_Refund="/payments/gv/refund";
	String urlEndPoint_GV_CAPTURE = "/payments/gv/capture";
	String urlPay_CreateRecord = "/paymentservice/service/createrecord?company-name=Fwd+Tourism+Pvt+Ltd&payment-type=cre&deposit-acct-id=124652522&amount=4819.5";
	String urlROR_Fetch_PayByID= "/paymentservice/payments/fetchById?id=43363994&field=paymentId";
	String urlROR_Fetch_RefundByID ="/paymentservice/service/refund/info/9373548";
	String urlReporting_Disabled_Refunds = "/paymentservice/disabledRefundRecords?toDate=03-05-2021&fromDate=02-05-2021";
	String urlROR_TripID_Status ="/paymentservice/service/status/xml/Q210322925952.ref";
	String urlROR_Fetch_ProfileList= "paymentservice/service/profileList/info/5073286";
	String urlROR_MultiSearch_Pay= "/paymentservice/search/payments/v1?query=id:43621536,paymentType:CC";

	String urlROR_Mis_ExpReports= "/paymentservice/service/air/mis/expreports?startDate=01/01/2021&endDate=02/01/2021";
	String endPointCardMulti = "/v1/payment/common/json?country=Palau&issuerType=MASTER";
	String endPointPromotriprefandid = "/promoservice/v1/promogroups/Q0806201815/promotions/22899";
	String endPointPromoGroupPromoRef = "/promoservice/v1/promogroups/Q1901160033";
	String endPointPromo_Cron = "/promoservice/v1/promotions?status=ACTIVE&triggerDate=04-11-2019";
	String endPointPromoGroupTripRef = "/promoservice/v1/promogroups/Q191115575604/promotions";
	String endPointPromoFromPromoId = "/promoservice/v1/promogroups/Q191115575604/";
	String endPointPromoGroupsFromCreatedDate= "/promoservice/v1/promogroups?createdDate=15-11-2019";
	String endPointPromoGroupsForAUpdatedDate= "/promoservice/v1/promogroups?updatedDate=15-11-2019";
	String endPointPromoGroupsForACreatedAndUpdatedDate= "/promoservice/v1/promogroups?createdDate=15-11-2019&updatedDate=15-11-2019";
	String urlFlyin_Wallet = "/paymentservice/api/wallet?product=DOMESTIC-AIR&currency=SAR&tripRef=Q210219897402";
	
	String urlIR_Eligibility_NB = "/paymentservice/service/refund/eligibility?tripRef=Q220222384004";
	String urlIR_Eligibility_CC = "/paymentservice/service/refund/eligibility?tripRef=Q211227200550";
	String urlIR_Eligibility_DC = "/paymentservice/service/refund/eligibility?tripRef=Q220131331240";
	String urlIR_Non_Eligibility_CC = "/paymentservice/service/refund/eligibility?tripRef=Q230504725042";
	String urlIR_Non_Eligibility_GV = "/paymentservice/service/refund/eligibility?tripRef=Q220304387832";
	String urlIR_Non_Eligibility_WALLET = "/paymentservice/service/refund/eligibility?tripRef=Q221103593354";

	String urlIR_Non_Eligibility_EMI = "/paymentservice/service/refund/eligibility?tripRef=Q221104594084";
	String urlIR_Non_Eligibility_TW = "/paymentservice/service/refund/eligibility?tripRef=Q221103593350";
	String urlIR_Non_Eligibility_UPI = "/paymentservice/service/refund/eligibility?tripRef=Q221104594080";
	String urlIR_Non_Eligibility_RP = "/paymentservice/service/refund/eligibility?tripRef=Q221028592234";
	String urlIR_Eligibility_Cardless_EMI = "/paymentservice/service/refund/eligibility?tripRef=Q221201604628";
	String urlIR_Eligibility_PayLater = "/paymentservice/service/refund/eligibility?tripRef=Q221208608792";


	String urlIR_Validate_VPA = "/paymentservice/ba/verify/Q211223200042";
	String urlIR_Save_VPA = "/paymentservice/ba/save";
	String urlIR_Get_VPA_Cancel_Details =	"/paymentservice/ba/details?cancellationTxnId=2022020947";
	String urlIR_Get_VPA_Cancel_Details_UserID = "/paymentservice/ba/details?userId=65237343";
	String urlIR_Create_Refund = "/paymentservice/service/refund";
	
	String url_NavisonCC = "/paymentservice/service/mis/detail?tripRef=Q200117692102&paymentType=CC";
	String url_NavisonAir = "/paymentservice/service/air/mis/detail?tripRef=Q191226667766&paymentType=UP";

	String urlROR_Update_ProfileList= "/paymentservice/service/profileList";

	String urlROR_Update_RefundList= "/paymentservice/service/refund/update";
	String urlROR_Create_ProfileList= "/paymentservice/service/profileList";
	String urlROR_Update_Payment= "/paymentservice/payments/update";

	String urlRORUpdate_GW_Status = "/paymentservice/service/refund/updateStatusForGateway";
	String urlrefund_Enque= "/paymentservice/service/refund/redis/enqueue";


	String urlRORCreate_Payments ="/paymentservice/service/insert/paymentdetails";
	String urlRORCreate_Profile_List ="/paymentservice/service/profileList";
	String urlRORSearch_Profile_List ="/paymentservice/service/profileList/search";
	String urlRORCreate_Refunds="/paymentservice/service/refund";
	

	String urlQitaf_Reverse = "/payments/rewards/reverse";
	String urlQitaf_Redeem = "/payments/rewards/redeem";
	String urlQitaf_SendOTP = "/payments/rewards/sendOtp";
	
	
	String urlRORRecon="/paymentservice/service/refund/recon";

	String urlROR_WalletFetch_Reads="/payments/wallet/fetch/v2?userId=13957750&currency=AED";
	String urlROR_MultiSearch_Reads ="/paymentservice/search/payments/v1?query=id:43622220,paymentType:WT";
	String urlROR_MultiSearch_TripRef_Reads= "/paymentservice/search/payments/v1?query=appRef1:Q190809461122";
	
	String urlROR_Wallet_Trnx_Reads = "/paymentservice/search/walletTransactions/v1?query=walletDetailId:5154746";
	
	String urlROR_Wallet_GetWallet_Reads = "/payments/wallet/5789285/v2/getWallet";
	String urlROR_GV_Details_Reads = "/paymentservice/search/gvDetails/v1?query=refundId:9367489";
	
	String urlROR_Refund_Reads = "/paymentservice/search/refunds/v1?query=paymentId:43410410,status:D";
	String url_UI_Get_ConvFee = "/paymentservice/ui/fetch/convFeePriority";
	String url_UI_Get_PayTypes = "/paymentservice/ui/fetch/paymentTypes";

	String url_SCLP_Raterule_CLEMI = "/paymentservice/rateRule/paymentInfo?paymentType=CL_EMI";
	String url_SCLP_Raterule_PL = "/paymentservice/rateRule/paymentInfo?paymentType=PL";


	String endPointgetPay = "/paymentservice/api/getPaymentURL";

	String urlEndPoint_Wallet_RevertPromo ="/payments/wallet/promo/revert?tripRef=Q19050680568";
	String urlEndPoint_Wallet_Refund_Stop_Trnx ="/paymentservice/walletStoppedTxns?fromDate=20-04-2021&toDate=21-04-2021";
	String urlEndPoint_Wallet_RevertPromoNew ="/payments/wallet/promo/revert/amount";
	
	
	String urlEndPoint_Wallet_RevertedPromo ="/payments/wallet/promo/reverted/amount/Q201124864780";
	String urlEndPoint_Wallet_GetDeduction = "/payments/wallet/promo/deductions?tripRef=Q190702311622";
	String urlEndPoint_Wallet_GetWallet_Trnx = "/payments/wallet/65237343/transactions?currency=INR";
	String urlEndPoint_Wallet_GetWallet_Details_UI = "/pay/wallet?userId=65243646&currency=INR";
	String urlEndPoint_Wallet_GetWallet_Trnx_UI = "/pay/wallet/65243646/transactions?offset=1&size=10&currency=INR";
	String urlEndPoint_Wallet_CASHBACK_DETAILS = "/payments/wallet/promo/13957750/promotions/5732312";
	String urlEndPoint_Wallet_GETWALLET_ALL = "/payments/wallet/65179937/getWallet";
	String urlEndPoint_Wallet_GETWALLET_INR = "/payments/wallet/fetch?userId=13957750&currency=INR";
	String urlEndPoint_Wallet_GETWALLET_INR2 = "payments/wallet/65215483/transactions?currency=INR";
	String urlEndPoint_Wallet_GETWALLET_V2_INR = "/payments/wallet/fetch/v2?userId=13957750&currency=INR";
	String urlEndPoint_Wallet_CASHBACK_DETAILS14 = "";
	String urlEndpoint_GVCreate= "/payments/gv/create";
	String urlEndPoint_Wallet_CASHBACK_Wallet = "/payments/wallet/cashback?emailId=test@test123.com&currency=INR&amount=1&tripRef=Q190812462222&expiryDate =20-09-19";
	String urlEndPoint_Wallet_Create = "/payments/wallet/65201137/createWallet";
	String urlEndPoint_Wallet_FetchQA = "/paymentservice/api/wallet?product=DOMESTIC-AIR&currency=INR";

	String urlDA_Balance = "/account/61/balance";
	String urlDA_Refund= "/account/46207144/trips/Q191210603834/refund";
	String urlDA_Status = "/account/387212870";
	
	String urlDA_FK_FetchBy_TripID = "/paymentservice/payments/44951548";
	String urlDA_FK_FetchBy_PaymentID = "/paymentservice/payments/fetchById?id=44948256";
	
	
	String urlCTPay = "https://qa2new.cleartrip.com";

	String urlSavedPaymentModes_UI= "payment/saved/payments/mode/get/65237343"; //5656565657 //65236280


	String urlCTPay_Get ="/paymentservice/ct/v2/getCtPaymentUrl";
	String urlCTPay_ADD ="/paymentservice/ct/v2/addClient";
	String urlCTPay_Status ="/paymentservice/ct/v2/T2021069300/status";
	String urlCTPay_UpdateClient= "/paymentservice/ct/v2/updateClient";
	String urlCTPay_CreateURL= "paymentservice/ct/v2/getCtPaymentUrl";


	String urlEW_UserDetails= "/paymentservice/expresswayplus/details/41649008/INR";	
	String urlEW_OptIn= "/paymentservice/expresswayplus/user/opt/in/41697596/INR";	
	String urlEW_GetOutstandingAmt= "/paymentservice/expresswayplus/outstandingbalance?userId=41697596&currency=INR";
	String urlEW_Validate= "/paymentservice/service/validate";
	String urlEW_Pay= "/paymentservice/service/pay";
	String urlEW_AutoDebit= "/paymentservice/expresswayplus/autodebit?expIdList=1029";
	String urlEW_AddAmt = "/paymentservice/expresswayplus/41697596/INR/addcredit?creditAmount=10";

	String urlEW_PayV3= "/paymentservice/service/pay/v3";
	String urlEW_Refund= "/paymentservice/expressway/v2/refund?refundIds=";

	String 	urlEW_Summary = "/paymentservice/expresswayplus/paymentSummary?trip_ref=Q190521160824";
	String url_RefundNEW_EndPoint= "/paymentservice/service/refund?refundids=";

	String urlOLA_Validate = "/paymentservice/service/cashback/ola/validate";
	String urlOLA_Pay = "/paymentservice/service/cashback/ola/process";
	String urlOLA_CheckStat = "/paymentservice/service/cashback/ola/stat/";
	String urlOLA_PromoGroup = "/promoservice/v1/promogroups";

	String urlOLA_PromoStatus = "/promoservice/v1/promogroups/Q12345690012";

	String urladcb_checkbalance = "/payments/rewards/checkBalance";

	String urlreward_checkbalance = "/payments/rewards/checkBalance";

	String urlreward_Validate = "/paymentservice/service/validate/v3";

	String urlreward_PayCheckEarnPoints = "/payments/rewards/checkEarnPoints";

	String urlreward_RewardRedeem = "/payments/rewards/redeem";

	String url_reward_RewardRefund= "/payments/rewards/refund";

	String urlreward_payback_CheckMobile_Linked  = "/payments/rewards/payback/checkAccountLinked?mobileNumber=9620351338";
	String urlreward_payback_CheckCard_Linked  = "/payments/rewards/payback/checkAccountLinked?cardNumber=9401120000319303";

	String endPointCreatePromo = "/promoservice/v1/promogroups";
	String endPointUpdatePromo = "/promoservice/v1/promogroups";

	String urlreward_payback_ForgotPassword = "/payments/rewards/payback/forgotPassword";
	String urlreward_payback_pay ="/paymentservice/service/pay/v3";
	String urlreward_payback_earn ="/payments/rewards/earn";
	String urlreward_payback_reverseearn ="/payments/rewards/reverseEarn";



	String urladcb_sendOTP = "/payments/rewards/sendOtp";
	String urladcb_validate = "/paymentservice/service/validate/v3";
	String urladcb_pay = "/paymentservice/service/pay/v3";
	String url_createrefundentry = "/paymentservice/service/refund";
	String url_refundupdatestatus = "/paymentservice/service/refund/update/status";
	String url_refundpgtxnid = "/paymentservice/service/refund/update/pgTxnId";
	String url_refundgetrecord = "/paymentservice/service/refund/info/";
	String urlEndpoint_GV_GET = "http://172.17.26.11:8071/payments/gv/create";

	String url_walletTOA ="/payments/wallet/v2/addcash"; //  65222417

	String url_walletGetCards ="/paymentservice/card/get/65206610"; //  41654864, 41654864 41701828
	String url_walletValidateCards ="/paymentservice/card/validate?cardNumber=340000000000009&name=test&cardTypeId=2&expiryMonth=9&expiryYear=2021&userId=65206610";
	String url_walletDeleteCards ="/paymentservice/card/delete/%s";
	String url_walletStoreCards ="/paymentservice/card/store?cardNumber=340000000000009&name=test&cardTypeId=2&expiryMonth=09&expiryYear=2021&userId=65237343";

	//String url_Binmanager = "https://qa2.cleartrip.com/binmanager/v1/payment/cards?bin=534977";

	String url_Reportingendpoint ="/paymentservice/service/air/mis/detail?tripRef=Q200109687244&paymentType=CC&reqFor=refund";
	String url_ReportingPaymentID ="/paymentservice/payments/43911126";
	String url_Reporting_Refund_Pending_Download ="/paymentservice/script/refund/details/download?startDate=07/05/2023&endDate=09/09/2023";
	String url_ReportingRefund_StatusReport ="/paymentservice/script/refund/details?status=D&startDate=05/01/2021&endDate=06/01/2021";
	
	String url_ReportingTS_V3 ="/trips?tripID=Q191014530470&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V3";
	String url_ReportingTS_Archived_V3_False ="/paymentservice/payments/42752096?isArchived=false";
	String url_ReportingTS_Archived_V3_True ="/paymentservice/payments/42752096?isArchived=true";
	String url_ReportingTS_Archived_V_New ="/trips?tripID=Q190620284526&refundRequired=true&historyRequired=true&paymentsRequired=true&apiVersion=V3";

	String urlRefundsTrip="/paymentservice/refund/data/fetch";
	String urlRefundsTripRef="/paymentservice/refund/data/fetchByTripRef";
	
	String url_ReportingPaginate = "/paymentservice/paginate/refunds?pageNo=1385&status=P&sort=desc";
	String url_ReportingPaginate_PayType = "/paymentservice/paginate/refunds?pageNo=1&status=D&sort=desc&paymentType=NB";
	
	String url_ReportingRefundQ_Count_D = "/paymentservice/service/refund/count/refunds?refundStatus=D";
	String url_ReportingRefundQ_Count_D_DA = "/paymentservice/service/refund/count/refunds?refundStatus=D&daStatus=S";
	String url_ReportingRefundQ_Count_S_Txns = "/paymentservice/service/refund/count/refunds?refundStatus=S&txnType=CAPT,QURY";
	String url_ReportingRefundQ_Count_S_Txns_Gw = "/paymentservice/service/refund/count/refunds?refundStatus=S&txnType=CAPT,QURY&gatewayId=10";
	String url_ReportingRefundQ_Count_S_PayType = "/paymentservice/service/refund/count/refunds?refundStatus=s&paymentType=CC,DC";
	String url_ReportingRefundQ_Count_S_PayType_GW = "/paymentservice/service/refund/count/refunds?refundStatus=D&paymentType=CC,DC&gatewayId=10";
	String url_ReportingRefundQ_Count_D_CashCard = "/paymentservice/service/refund/count/refunds?refundStatus=d&cashCardStatus=s&cashCardId=1&paymentType=KC";
	String url_ReportingRefundQ_Count_P_PayType = "/paymentservice/service/refund/count/refunds?refundStatus=p&paymentType=NB,DC,CC&paymentStatus=s";	
	String url_ReportingRefundUploadQ_fetch_RefundID = "/paymentservice/refund/data/fetch";	
	String url_ReportingRefundUploadQ_fetch_TripID = "/paymentservice/refund/data/fetchByTripRef";	
	String url_ReportingRefund_Count_ID = "/paymentservice/service/refund/count/refunds";	
	
	

	String url_Singlebincard="/v1/payment/card";

	String url_EMI_Cache_Refresh ="/paymentservice/ui/refresh/emiCache?domain=IN";

	String url_EMI_Bank_Details ="/paymentservice/emiBankDetails";
	String url_EMI_Routing ="/paymentservice/emiQuotaConfig";


	String url_EMI_GetPlans ="/paymentservice/emi/emi-plan?provider=bank&providerValue=5&paymentType=EMI&paymentSubtype=CC";

	String url_EMI_Juspay_SavePlan ="/paymentservice/emi/emi-plan";

	String EMI_Juspay_GetOffer = "/paymentservice/emi/emi-offer?id=6&ctOfferId=CT_EMI_OFFER_V2_NO_COST_67_4000.0";
	String url_EMI_Cache_Refresh_New ="/paymentservice/emi/cache";
	String url_EMI_Cache_ResourcesRefresh ="/paymentservice/ui/refresh/cachedEmiResources"; 
	String url_EMI_GW_Razorpay = "/paymentservice/ui/fetch/emiCache?domain=IN&gateway=RAZORPAYV2";
	String url_EMI_GW_Noon = "/paymentservice/ui/fetch/emiCache?domain=AE&gateway=NOON";
	String url_EMI_Fetch = "/paymentservice/api/fetchEmi";
	
	
	/*String Prod_Url_PaymentService="http://172.21.65.21:8070";
	//String Prod_Url_Rewards1="http://rewardsservice.cltp.com:9001";
	String Prod_Url_Rewards="http://172.21.3.122:9080";
	String Prod_Url_Wallet="http://172.21.65.21:8071";
	String Prod_Url_Promo="http://172.21.48.21:7999";*/
	
	String Prod_Url_PaymentService="http://paymentservice.cltp.com:9001";
	//String Prod_Url_Rewards1="http://rewardsservice.cltp.com:9001";
	//String Prod_Url_Rewards="http://10.163.15.235:9001";
	String Prod_Url_Rewards="http://rewardsservice.cltp.com:9001";
	String Prod_Url_Wallet="http://wallet-service.cltp.com:9001";
	String Prod_Url_Promo="http://promoservice.cltp.com:9001";
	

	String Prod_Url_EndPoint_Get_TP_Wallets="/paymentservice/service/thirdpartywallets";

	String Prod_Url_EndPoint_Rewards_PayBack_Mobile="/payments/rewards/payback/checkAccountLinked?mobileNumber=9620351338";
	String Prod_Url_ActiveNB= "/paymentservice/service/netbankingbanks?status=active";
	String Prod_Url_PaymentStatus= "/paymentservice/service/status?paymentIds=140145386";
	String Prod_Url_ActiveCardType= "/paymentservice/service/cardtypes?status=active";
	String Prod_Url_EndPoint_Rewards_ADCB_Balance="/payments/rewards/checkBalance";
	String Prod_Url_EndPoint_Wallet_getWallet="/payments/wallet/74728676/getWallet";
	String Prod_Url_EndPoint_Promo_Group = "/promoservice/v1/promogroups/190313426926";

	String Prod_Params_Rewards_ADCB_Balance="{\"rewardsType\":\"ADCB\",\"rewardsRequestType\":\"BALANCE_CHECK\",\"trackId\":\"CL1212S00323\",\"cardNumber\":\"5420187505091559\",\"amount\":1,\"currency\":\"AED\",\"params\":{\"customerName\":\"test\",\"expiryDate\":\"0224\"}}";



	String URL_SmilesDev= "https://test-developerhub.etisalat.ae:9443";
	String URL_SmilesDev_Parm = "/test-organization/smiles/confidential/oauth2/token";
	String Param_Smiles_Auth = "grant_type=client_credentials&scope=apioauth";

	String urlCS_Pay="/paymentservice/service/pay/v3";
	String urlCS_Validate="/paymentservice/service/validate/v3";

	String urlFKRefundCreate= "/paymentservice/service/refund";
	String urlFKRefundUpdatePartnerInfo= "/paymentservice/service/refund/updatePartnerInfo";
	String urlFKRefundStatusUpdate= "/paymentservice/service/refund/updateStatus";
	
	String MySQL_URL = "jdbc:mysql://172.17.4.15:3306/payment";
	String MySQL_User = "payment";
	String MySQL_Password = "P@yment@123";
	
	//-------------------------------------------------------------------PayUI payload-------------------------------------------------------------------------//

	String PaymentUI_Trains = "{\"train_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Ms\",\"first_name\":\"Test\",\"last_name\":\"Test\"}],\"itinerary_details\":[{\"from_station_code\":\"SBC\",\"to_station_code\":\"MYS\",\"from_station_name\":\"KSR BENGALURU\",\"to_station_name\":\"MYSURU JN\",\"train_name\":\"BSB MYS EXP\",\"train_number\":\"16230\",\"departure_time\":\"2019-11-12T00:15:00\",\"arrival_time\":\"2019-11-12T02:45:00\",\"booking_class\":\"AC 2 Tier(2A)\",\"updated_availability\":\"AVAILABLE-0119\",\"quota\":\"General\",\"seatStatus\":true}],\"pricing_details\":[{\"other_railway_charges\":119.4,\"agent_service_charge\":40,\"total\":7775.4,\"insuranceCharge\":0,\"currency\":\"INR\",\"pax_pay_info\":[{\"base_fare\":6616.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}]}],\"transaction_fee_details\":{\"CC\":{\"DEFAULT\":1.8},\"DC\":{\"DEFAULT\":1.0},\"NB\":{\"DEFAULT\":1.35,\"1\":1.1,\"2\":1.2,\"23\":1.1,\"3\":1.1},\"KC\":{\"DEFAULT\":0.0},\"DA\":{\"DEFAULT\":0.0},\"TW\":{\"DEFAULT\":1.0},\"UP\":{\"DEFAULT\":1.0}}},\"itinerary_id\":\"f25db800de1e0137664316217d236675\",\"ttl\":3600,\"trip_id\":45134538,\"app_ref1\":\"";

	String PaymentUI_Trains1 = "\",\"app_ref2\":74282510,\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":1212121212,\"landline\":1212121212,\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"payment\",\"username\":\"cltppayment@gmail.com\"},\"product_type\":\"TRAIN\",\"currency\":\"INR\",\"order_info1\":\"16230/SBC/MYS/2019111200:15:00\",\"order_info2\":\"Test Test\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"64891349\",\"email_id\":\"cltppayment@gmail.com\",\"d_plus_x_in_hours\":273,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/trains/itinerary/f25db800de1e0137664316217d236675/process_payment\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://trains-book-nget.cltp.com:9001/r3/trains/itinerary/f25db800de1e0137664316217d236675/book_internal\",\"params\":null},\"payment_category\":\"B\"}";

	String params_PayUI_Air1="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":0,\"trip_id\":46314335,\"trip_ref\":\"";
	String params_PayUI_Air1_new="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":3600,\"trip_id\":46604130,\"ui_language\":\"EN\",\"client\":\"Cleartrip\",\"trip_ref\":\"";
	String params_PayUI_Air1_new_ar="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":3600,\"trip_id\":46604130,\"ui_language\":\"AR\",\"client\":\"Flyin\",\"trip_ref\":\"";
	String params_PayUI_Air2="\",\"txn_id\":\"75719816\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1211212122\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":3,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":4,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":5,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":734,\"departure_date\":\"2020-10-24T09:20:00\",\"arrival_date\":\"2020-10-24T11:05:00\",\"departure_time\":\"09:20\",\"arrival_time\":\"11:05\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":723.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[{\"amount\":229.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"},{\"amount\":279.0,\"provider\":\"DIGIT\",\"title\":\"TRAVEL_INSURANCE\",\"vas_type\":\"TRAVEL_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":3100.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"new_bento\":false}";
	String params_PayUI_Air2_New="\",\"txn_id\":\"75872776\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":110340,\"payment_category\":\"B\",\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"kiran.kumar@cleartrip.com\",\"first_name\":\"kiran\",\"last_name\":\"kumar\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6847f117db-6f00-4624-a0a0-210405140001/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6847f117db-6f00-4624-a0a0-210405140001/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":258,\"departure_date\":\"2021-06-03T13:35:00\",\"arrival_date\":\"2021-06-03T14:40:00\",\"departure_time\":\"13:35\",\"arrival_time\":\"14:40\",\"duration\":\"3900\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"MAA\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chennai Airport\",\"total_time\":\"3900\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Chennai\"},{\"serial_number\":2,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":302,\"departure_date\":\"2021-06-03T16:25:00\",\"arrival_date\":\"2021-06-03T17:45:00\",\"departure_time\":\"16:25\",\"arrival_time\":\"17:45\",\"duration\":\"4800\",\"stops\":0,\"departure_code\":\"MAA\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Chennai Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4800\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Chennai\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":793.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[{\"amount\":149.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":2102.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0,\"baggage_charges\":0.0,\"meal_charges\":0.0,\"seat_charges\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":100.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"emi\":0.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"dx_value\":58,\"new_bento\":false}";
	String params_PayUI_Air2_EMI="\",\"txn_id\":\"75872776\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":110340,\"payment_category\":\"B\",\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"kiran.kumar@cleartrip.com\",\"first_name\":\"kiran\",\"last_name\":\"kumar\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6847f117db-6f00-4624-a0a0-210405140001/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6847f117db-6f00-4624-a0a0-210405140001/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":258,\"departure_date\":\"2021-06-03T13:35:00\",\"arrival_date\":\"2021-06-03T14:40:00\",\"departure_time\":\"13:35\",\"arrival_time\":\"14:40\",\"duration\":\"3900\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"MAA\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chennai Airport\",\"total_time\":\"3900\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Chennai\"},{\"serial_number\":2,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":302,\"departure_date\":\"2021-06-03T16:25:00\",\"arrival_date\":\"2021-06-03T17:45:00\",\"departure_time\":\"16:25\",\"arrival_time\":\"17:45\",\"duration\":\"4800\",\"stops\":0,\"departure_code\":\"MAA\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Chennai Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4800\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Chennai\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":793.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[{\"amount\":149.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":2102.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":5000.0,\"baggage_charges\":0.0,\"meal_charges\":0.0,\"seat_charges\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":100.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"emi\":0.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"dx_value\":58,\"new_bento\":false}";
	String params_PayUI_SUPERCOINS="\",\"txn_id\":\"76266182\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"41695136\",\"company_id\":110340,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"NI68d2b19783-ebf0-47bb-8e00-210915092614\",\"otp\":\"249971\",\"params\":{\"mobile\":\"+917483912960\"}},\"rewards_type\":\"SUPERCOINS\",\"amount\":1000.0,\"total_balance\":1000.0,\"earned_amount\":0.0}],\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":41695136,\"mobile\":\"9985123464\",\"landline\":\"9985123464\",\"email\":\"sindhu.gummadi@cleartrip.com\",\"first_name\":\"Sindhu\",\"last_name\":\"Gummadi\",\"title\":\"Ms\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d2b19783-ebf0-47bb-8e00-210915092614/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d2b19783-ebf0-47bb-8e00-210915092614/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Ms\",\"first_name\":\"Sindhu\",\"last_name\":\"Gummadi\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"SpiceJet\",\"airline_code\":\"SG\",\"flight_number\":456,\"departure_date\":\"2021-11-10T20:35:00\",\"arrival_date\":\"2021-11-10T22:45:00\",\"departure_time\":\"20:35\",\"arrival_time\":\"22:45\",\"duration\":\"7800\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"7800\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":670.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2880.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":2550.0,\"baggage_charges\":0.0,\"meal_charges\":0.0,\"seat_charges\":0.0},\"convenience_fee_details\":{\"cc\":110.0,\"dc\":100.0,\"nb\":110.0,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":110.0,\"rp\":110.0,\"ap\":0.0,\"wt\":110.0,\"gv\":110.0,\"emi\":0.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"dx_value\":56,\"new_bento\":false}";

	String params_PayUI_SUPERCOINS1 ="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":0,\"trip_id\":46314335,\"trip_ref\":\"";

	String params_PayUI_Air224="\",\"txn_id\":\"75719816\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1211212122\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":734,\"departure_date\":\"2020-10-24T09:20:00\",\"arrival_date\":\"2020-10-24T11:05:00\",\"departure_time\":\"09:20\",\"arrival_time\":\"11:05\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":723.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[{\"amount\":229.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"},{\"amount\":279.0,\"provider\":\"DIGIT\",\"title\":\"TRAVEL_INSURANCE\",\"vas_type\":\"TRAVEL_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":3100.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";

	String params_PayUI_Air25="\",\"txn_id\":\"75798294\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":110340,\"payment_category\":\"B\",\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"kiran.kumar@cleartrip.com\",\"first_name\":\"John\",\"last_name\":\"Miller\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68acfbf6c2-99c1-4dbd-b865-210209103810/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68acfbf6c2-99c1-4dbd-b865-210209103810/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":3,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":4,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":5,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":266,\"departure_date\":\"2021-03-05T06:10:00\",\"arrival_date\":\"2021-03-05T07:20:00\",\"departure_time\":\"06:10\",\"arrival_time\":\"07:20\",\"duration\":\"4200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4200\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":3135.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[{\"amount\":745.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"},{\"amount\":1395.0,\"provider\":\"DIGIT\",\"title\":\"Travel insurance\",\"vas_type\":\"TRAVEL_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":1338.0,\"pax_count\":5,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":11965.0},\"convenience_fee_details\":{\"cc\":750.0,\"dc\":750.0,\"nb\":750.0,\"kc\":0.0,\"up\":750.0,\"da\":0.0,\"tw\":750.0,\"rp\":750.0,\"ap\":0.0,\"wt\":750.0,\"gv\":750.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"new_bento\":false}";

	String params_PayUI_Air_AE="\",\"txn_id\":\"75719878\",\"currency\":\"AED\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"AE\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"AED\",\"conversionFactor\":379.04947607124905},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"AED\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"AE\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_AE_AR="\",\"txn_id\":\"75719878\",\"currency\":\"AED\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"AE\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"ui_language\":\"AR\",\"currency_conversion_details\":{\"displayCurrency\":\"AED\",\"conversionFactor\":379.04947607124905},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"AED\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"AE\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_SA_AR="\",\"txn_id\":\"75719878\",\"currency\":\"SAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"SA\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"ui_language\":\"AR\",\"currency_conversion_details\":{\"displayCurrency\":\"SAR\",\"conversionFactor\":20.04947607124905},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"SAR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"SA\",\"initial_total\":0.0,\"retry_num\":0}";
	
	String params_PayUI_Air_BH="\",\"txn_id\":\"75719878\",\"currency\":\"BHD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"BH\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"BHD\",\"conversionFactor\":500.04947607124905},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"BHD\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"BH\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_KW="\",\"txn_id\":\"75719878\",\"currency\":\"KWD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"KW\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"KWD\",\"conversionFactor\":500.04947607124905},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"KWD\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"KW\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_OM="\",\"txn_id\":\"75719878\",\"currency\":\"OMR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"OM\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"OMR\",\"conversionFactor\":5.04},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"OMR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"OM\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_QA="\",\"txn_id\":\"75719878\",\"currency\":\"QAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"QA\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"QAR\",\"conversionFactor\":67.04},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"QAR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"QA\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_SA="\",\"txn_id\":\"75719878\",\"currency\":\"SAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"SA\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"SAR\",\"conversionFactor\":77.06},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0, \"total_vat\":40.13999938964844,\"vat_percentage\":15.0, \"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"SAR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"SA\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_Flyin="\",\"txn_id\":\"75848156\",\"currency\":\"SAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"FSA\",\"user_id\":\"65212457\",\"company_id\":110340,\"payment_category\":\"B\",\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"SAR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":65212457,\"mobile\":\"9986696785\",\"landline\":\"9986696785\",\"email\":\"ct_wallet_partial@cleartrip.com\",\"first_name\":\"Kiran\",\"last_name\":\"kumar\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI682452bf22-6aca-43ab-9895-210318104851/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI682452bf22-6aca-43ab-9895-210318104851/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"SpiceJet\",\"airline_code\":\"SG\",\"flight_number\":311,\"departure_date\":\"2021-03-24T05:50:00\",\"arrival_date\":\"2021-03-24T07:45:00\",\"departure_time\":\"05:50\",\"arrival_time\":\"07:45\",\"duration\":\"6900\",\"stops\":0,\"departure_code\":\"BOM\",\"arrival_code\":\"BLR\",\"departure_airport_name\":\"Chatrapati Shivaji Airport\",\"arrival_airport_name\":\"Bengaluru International Airport\",\"total_time\":\"6900\",\"departure_terminal\":\"2\",\"arrival_terminal\":\"1\",\"departure_name\":\"Mumbai\",\"arrival_name\":\"Bangalore\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":32.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":151.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"SAR\",\"total\":500.0,\"baggage_charges\":0.0,\"meal_charges\":0.0,\"seat_charges\":0.0},\"convenience_fee_details\":{\"cc\":11.0,\"dc\":11.0,\"nb\":11.0,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":11.0,\"rp\":11.0,\"ap\":0.0,\"wt\":11.0,\"gv\":11.0,\"emi\":0.0,\"flat_fee\":true}},\"domain\":\"FSA\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"new_bento\":false}";
	String params_PayUI_Air_US="\",\"txn_id\":\"75719878\",\"currency\":\"USD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"US\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"USD\",\"conversionFactor\":1239.04},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"121221212\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI681fdd54f8-2d6c-44d1-9dd6-200903182914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":5354,\"departure_date\":\"2020-10-24T13:50:00\",\"arrival_date\":\"2020-10-24T15:35:00\",\"departure_time\":\"13:50\",\"arrival_time\":\"15:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"2\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":37.150001525878906,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":159.23,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"USD\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":10.0,\"dc\":10.0,\"nb\":6.37,\"kc\":0.0,\"up\":0.0,\"da\":0.0,\"tw\":0.0,\"rp\":10.0,\"ap\":0.0,\"wt\":10.0,\"gv\":0.0,\"flat_fee\":true}},\"domain\":\"ME\",\"initial_total\":0.0,\"retry_num\":0}";

	String params_PayUI_AirRT="\",\"txn_id\":\"75740574\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"kiran.kumar@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68a7ab14ed-8a4c-4450-b602-200924142642/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68a7ab14ed-8a4c-4450-b602-200924142642/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"SpiceJet\",\"airline_code\":\"SG\",\"flight_number\":3302,\"departure_date\":\"2020-11-15T07:40:00\",\"arrival_date\":\"2020-11-15T08:40:00\",\"departure_time\":\"07:40\",\"arrival_time\":\"08:40\",\"duration\":\"3600\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"MAA\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chennai Airport\",\"total_time\":\"3600\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Chennai\"}]},{\"segment_details\":[{\"serial_number\":2,\"airline_name\":\"SpiceJet\",\"airline_code\":\"SG\",\"flight_number\":3309,\"departure_date\":\"2020-11-16T17:00:00\",\"arrival_date\":\"2020-11-16T17:55:00\",\"departure_time\":\"17:00\",\"arrival_time\":\"17:55\",\"duration\":\"3300\",\"stops\":0,\"departure_code\":\"MAA\",\"arrival_code\":\"BLR\",\"departure_airport_name\":\"Chennai Airport\",\"arrival_airport_name\":\"Bengaluru International Airport\",\"total_time\":\"3300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Chennai\",\"arrival_name\":\"Bangalore\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":1831.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":1766.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":250.0,\"dc\":250.0,\"nb\":250.0,\"kc\":0.0,\"up\":250.0,\"da\":0.0,\"tw\":250.0,\"rp\":0.0,\"ap\":0.0,\"wt\":250.0,\"gv\":250.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_AirMC="";
	
	/*
	String params_PayUI_Air_BH1="\",\"txn_id\":\"75509223\",\"currency\":\"BHD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"BH\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"BHD.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"BHD\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	String params_PayUI_Air_KW1="\",\"txn_id\":\"75509223\",\"currency\":\"KWD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"KW\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"KWD.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"KWD\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	String params_PayUI_Air_OM1="\",\"txn_id\":\"75509223\",\"currency\":\"OMR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"OM\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"OMR.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"OMR\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	String params_PayUI_Air_QA1="\",\"txn_id\":\"75509223\",\"currency\":\"QAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"QA\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"QAR.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"QAR\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	String params_PayUI_Air_SA1="\",\"txn_id\":\"75509223\",\"currency\":\"SAR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"SA\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"SAR.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"SAR\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	String params_PayUI_Air_US1="\",\"txn_id\":\"75509223\",\"currency\":\"USD\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"US\",\"user_id\":\"1876970\",\"company_id\":110340,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"USD.\",\"conversionFactor\":1.0},\"ui_language\":\"EN\",\"trip_title\":\"AMD -> BLR\",\"back_button_url\":\"/accounts\",\"customer_detail\":{\"user_id\":1876970,\"mobile\":\"911212121212\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\",\"method\":\"POST\",\"params\":null,\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6826d4897a-b5af-47a5-a72e-200511165846/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"John\",\"last_name\":\"Miller\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Ashish\",\"last_name\":\"Jain\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Rohit\",\"last_name\":\"Kumar\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Mohit\",\"last_name\":\"Verma\"},{\"seq_no\":2,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Sachin\",\"last_name\":\"Reddy\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-15T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"DEL\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"},{\"serial_number\":0,\"airline_name\":\"SG\",\"airline_code\":\"SG\",\"flight_number\":8169,\"departure_date\":\"2020-02-15T19:45:00\",\"arrival_date\":\"2020-02-16T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":1,\"departure_code\":\"BOM\",\"arrival_code\":\"AMD\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]},{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"AI\",\"airline_code\":\"AI\",\"flight_number\":8169,\"departure_date\":\"2020-02-20T19:45:00\",\"arrival_date\":\"2020-02-20T22:05:00\",\"departure_time\":\"07:45\",\"arrival_time\":\"10:05\",\"duration\":\"8400\",\"stops\":0,\"departure_code\":\"AMD\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Indira Gandhi Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"departure_name\":\"New Delhi\",\"arrival_name\":\"Mumbai\",\"date\":\"2020-02-15T19:45:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":3000.1,\"pax_count\":1,\"pax_type\":\"ADULT\"},{\"base_fare\":3000.02,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":100,\"psgr_service_fee\":91,\"air_dev_fee\":0,\"airline_misc\":177,\"cute_fee\":65,\"airline_gst\":20.5,\"paid_before\":\"100.0\",\"amend_charges\":200.5,\"ct_charges\":10,\"currency\":\"USD\",\"other_charges\":1016,\"service_fee\":1012,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":10},\"dc\":{\"DEFAULT\":0},\"nb\":{\"DEFAULT\":0},\"kc\":{\"DEFAULT\":0},\"da\":{\"DEFAULT\":0},\"tw\":{\"DEFAULT\":0},\"up\":{\"DEFAULT\":0},\"wt\":{\"DEFAULT\":0}},\"convenience_fee_details\":{\"cc\":200,\"dc\":500,\"nb\":50,\"tw\":25,\"up\":10,\"wt\":100}}}";
	
	*/
	String params_PayUI_Air_Coupon1 ="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":0,\"trip_id\":46314335,\"trip_ref\":\"";
	String params_PayUI_Air_Coupon2 ="\",\"txn_id\":\"75719850\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"41654864\",\"company_id\":101,\"payment_category\":\"B\",\"coupon_details\":{\"coupon_code\":\"DOMOW\",\"amount\":150.0,\"callback_required\":false,\"message\":\"Great! You just saved \\u003camount\\u003e on your booking.\"},\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":41654864,\"mobile\":\"1212112211\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":414,\"departure_date\":\"2020-10-24T12:50:00\",\"arrival_date\":\"2020-10-24T14:35:00\",\"departure_time\":\"12:50\",\"arrival_time\":\"14:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_CouponWT ="\",\"txn_id\":\"75719850\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"41654864\",\"company_id\":101,\"payment_category\":\"B\",\"coupon_details\":{\"coupon_code\":\"DOMOW\",\"coupon_type\":\"Wallet\",\"amount\":150.0,\"callback_required\":false,\"message\":\"Great! You just saved \\u003camount\\u003e on your booking.\"},\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":41654864,\"mobile\":\"1212112211\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":414,\"departure_date\":\"2020-10-24T12:50:00\",\"arrival_date\":\"2020-10-24T14:35:00\",\"departure_time\":\"12:50\",\"arrival_time\":\"14:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_CouponCashback ="\",\"txn_id\":\"75719850\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"41654864\",\"company_id\":101,\"payment_category\":\"B\",\"coupon_details\":{\"coupon_code\":\"FLEXICASH\",\"coupon_type\":\"Wallet\",\"amount\":100.0,\"callback_required\":false,\"message\":\"Great! We\\u0027ll add \\u003camount\\u003e in your Cleartrip Wallet\"},\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":41654864,\"mobile\":\"1212112211\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6852a2523e-4c1e-4ef6-b6f2-200903173122/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"kiran\",\"last_name\":\"kumar\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":414,\"departure_date\":\"2020-10-24T12:50:00\",\"arrival_date\":\"2020-10-24T14:35:00\",\"departure_time\":\"12:50\",\"arrival_time\":\"14:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_GV1 ="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":3600,\"trip_id\":46471954,\"ui_language\":\"EN\",\"client\":\"Cleartrip\",\"trip_ref\":\"";
	String params_PayUI_Air_GV2 ="\",\"txn_id\":\"75719872\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"gift_voucher_details\":[{\"applicable_amount\":1.0,\"card_number\":\"3000331035955930\",\"card_pin\":\"288113\",\"card_category\":\"Cleartrip Test e-GV\",\"total_balance\":1.0}],\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1212121121\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68ec9fa779-e240-41c6-9588-200903175504/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68ec9fa779-e240-41c6-9588-200903175504/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":361,\"departure_date\":\"2020-10-24T15:30:00\",\"arrival_date\":\"2020-10-24T17:20:00\",\"departure_time\":\"15:30\",\"arrival_time\":\"17:20\",\"duration\":\"6600\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6600\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_GV2_Full ="\",\"txn_id\":\"75719862\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"gift_voucher_details\":[{\"applicable_amount\":1.0,\"card_number\":\"3000331035955930\",\"card_pin\":\"288113\",\"card_category\":\"Cleartrip Test e-GV\",\"total_balance\":90454.0}],\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1221121211\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI689f5d93b4-2a9e-4872-a8d2-200903175506/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI689f5d93b4-2a9e-4872-a8d2-200903175506/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":849,\"departure_date\":\"2020-10-24T23:00:00\",\"arrival_date\":\"2020-10-25T00:50:00\",\"departure_time\":\"23:00\",\"arrival_time\":\"00:50\",\"duration\":\"6600\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6600\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	String params_PayUI_Air_RP1 ="{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":0,\"trip_id\":46314335,\"trip_ref\":\"";
	String params_PayUI_Air_RP2 ="\",\"txn_id\":\"75797748\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":110340,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"CLRRLOW4QNEJH8AVEB52\",\"card_detail\":{\"card_number\":\"9401120000263501\"},\"params\":{\"pin\":\"1787\",\"mobile\":\"9986696785\"}},\"rewards_type\":\"PAYBACK\",\"amount\":1.0,\"total_balance\":953520.25,\"earned_amount\":19.0}],\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"kiran.kumar@cleartrip.com\",\"first_name\":\"test\",\"last_name\":\"test\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68f1fb295d-b7a2-4a24-9084-210208123603/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68f1fb295d-b7a2-4a24-9084-210208123603/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":266,\"departure_date\":\"2021-03-05T06:10:00\",\"arrival_date\":\"2021-03-05T07:20:00\",\"departure_time\":\"06:10\",\"arrival_time\":\"07:20\",\"duration\":\"4200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4200\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":627.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":1338.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":1964.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"new_bento\":false}";
	String params_PayUI_Air_RP3 ="\",\"txn_id\":\"75719466\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"65201137\",\"company_id\":101,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"CLRVCKDMMKS16PA6OC3S\",\"card_detail\":{\"card_number\":\"9401120000385007\"},\"params\":{\"pin\":\"8476\",\"mobile\":\"9855520269\"}},\"rewards_type\":\"PAYBACK\",\"amount\":3172.0,\"total_balance\":27499.0}],\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":65201137,\"mobile\":\"1212121212\",\"landline\":\"\",\"email\":\"ct_wallet_partial@cleartrip.com\",\"first_name\":\"Wallet\",\"last_name\":\"Partial\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68f4a063ad-5f31-47c7-a623-200902182149/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68f4a063ad-5f31-47c7-a623-200902182149/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":414,\"departure_date\":\"2020-10-24T12:50:00\",\"arrival_date\":\"2020-10-24T14:35:00\",\"departure_time\":\"12:50\",\"arrival_time\":\"14:35\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":672.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":2500.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";


	String params_PayUI_Air_RP4 = "\",\"txn_id\":\"75797398\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"65211597\",\"company_id\":110340,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"CLRL0S20AJ4E6REGOGL6\",\"card_detail\":{\"card_number\":\"9401120000263501\"},\"params\":{\"pin\":\"1787\",\"mobile\":\"9986696785\"}},\"rewards_type\":\"PAYBACK\",\"amount\":1965.0,\"total_balance\":953521.25,\"earned_amount\":19.0}],\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":65211597,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"ct_storedcard@cleartrip.com\",\"first_name\":\"Stored\",\"last_name\":\"card\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6838c425b6-cf5e-43a9-a5ad-210205113311/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6838c425b6-cf5e-43a9-a5ad-210205113311/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Stored\",\"last_name\":\"card\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":266,\"departure_date\":\"2021-03-05T06:10:00\",\"arrival_date\":\"2021-03-05T07:20:00\",\"departure_time\":\"06:10\",\"arrival_time\":\"07:20\",\"duration\":\"4200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4200\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":627.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":1338.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"new_bento\":false}";

	String params_PayUI_Air_RP6= "\",\"txn_id\":\"75797398\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"65211597\",\"company_id\":110340,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"CLRL0S20AJ4E6REGOGL6\",\"card_detail\":{\"card_number\":\"9401120000263501\"},\"params\":{\"pin\":\"1787\",\"mobile\":\"9986696785\"}},\"rewards_type\":\"PAYBACK\",\"amount\":1.0,\"total_balance\":953521.25,\"earned_amount\":19.0}],\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":65211597,\"mobile\":\"1111111111\",\"landline\":\"1111111111\",\"email\":\"ct_storedcard@cleartrip.com\",\"first_name\":\"Stored\",\"last_name\":\"card\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6838c425b6-cf5e-43a9-a5ad-210205113311/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI6838c425b6-cf5e-43a9-a5ad-210205113311/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Stored\",\"last_name\":\"card\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":266,\"departure_date\":\"2021-03-05T06:10:00\",\"arrival_date\":\"2021-03-05T07:20:00\",\"departure_time\":\"06:10\",\"arrival_time\":\"07:20\",\"duration\":\"4200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4200\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":627.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":1000.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":0.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":500.0,\"retry_num\":0,\"cfw_amount\":0.0,\"new_bento\":false}";

	
	//String params_PayUI_Air_RP5 = "\",\"txn_id\":\"75795858\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"65201137\",\"company_id\":110340,\"payment_category\":\"B\",\"reward_point_details\":[{\"reward_points_detail\":{\"uid\":\"CLRYHEPACDY3FKPHDQOU\",\"card_detail\":{\"card_number\":\"9401120000263501\"},\"params\":{\"pin\":\"1787\",\"mobile\":\"9986696785\"}},\"rewards_type\":\"PAYBACK\",\"amount\":1.0,\"total_balance\":953517.0,\"earned_amount\":18.0}],\"coupon_details\":{\"coupon_code\":\"DOMOW\",\"amount\":150.0,\"callback_required\":false,\"message\":\"Great! You just saved \\u003camount\\u003e on your booking.\"},\"gift_voucher_details\":[],\"currency_conversion_details\":{\"displayCurrency\":\"INR\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":65201137,\"mobile\":\"1212121212\",\"landline\":\"1212121212\",\"email\":\"ct_wallet_partial@cleartrip.com\",\"first_name\":\"Wallets\",\"last_name\":\"Partial\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68cb76010f-de09-48b9-9be6-210201190914/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68cb76010f-de09-48b9-9be6-210201190914/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Wallets\",\"last_name\":\"Partial\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":266,\"departure_date\":\"2021-03-05T06:10:00\",\"arrival_date\":\"2021-03-05T07:20:00\",\"departure_time\":\"06:10\",\"arrival_time\":\"07:20\",\"duration\":\"4200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"HYD\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Rajiv Gandhi International\",\"total_time\":\"4200\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Hyderabad\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":627.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"total_vat\":0.0,\"vat_percentage\":0.0,\"vas_details\":[],\"pax_pay_info\":[{\"base_fare\":1338.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":1814.0},\"convenience_fee_details\":{\"cc\":150.0,\"dc\":150.0,\"nb\":150.0,\"kc\":0.0,\"up\":150.0,\"da\":0.0,\"tw\":150.0,\"rp\":150.0,\"ap\":0.0,\"wt\":150.0,\"gv\":150.0,\"flat_fee\":true}},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0,\"cfw_amount\":0.0,\"supplier_currency\":\"INR\",\"new_bento\":true}";
	// //Dont use// String param_Air_Amendment_API  = "http://bqapi.cleartripcorp.com/bqAPI/file?name=PAYMENT_STATUS-Amend-10.56.54.69-1592076267056-36-req.gz&iId=680e1794b8-87a7-40b9-a8d6-200614005232&date=2020-06-14&tripId=Q200531806440";
	
	String param_Air_Amendment_API1  = "{\"itinerary_id\":\"NI685a33347e-464c-4a27-86c9-200710101330\",\"ttl\":0,\"trip_id\":140471948,\"ui_language\":\"EN\",\"client\":\"Cleartrip\",\"trip_ref\":\"";
	String param_Air_Amendment_API2 = "\",\"txn_id\":\"227577296\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"MOBILE\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"77925412\",\"company_id\":110340,\"back_button_url\":\"/amendments/itinerary\",\"trip_title\":\"Bangalore ? New Delhi\",\"payment_category\":\"A\",\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":7792512,\"mobile\":\"9986696785\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"CLTP\",\"last_name\":\"Payment\"},\"app_return_info\":{\"url\":\"http://amendtool.gcp-cltp.com/amend/book/68edc4657c-90e5-44bc-8eaf-200612123123\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://amendtool.gcp-cltp.com/amend/book/68edc4657c-90e5-44bc-8eaf-200612123123\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Cltp\",\"last_name\":\"Payment\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"UK\",\"airline_code\":\"UK\",\"flight_number\":816,\"departure_date\":\"2020-06-22T12:15:00\",\"arrival_date\":\"2020-06-22T15:05:00\",\"departure_time\":\"12:15\",\"arrival_time\":\"15:05\",\"duration\":\"10200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Kempegowda International Airport\",\"arrival_airport_name\":\"Indira Gandhi Airport\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"New Delhi\",\"date\":\"2020-06-22T12:15:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":4970.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"air_dev_fee\":0.0,\"airline_misc\":177.0,\"cute_fee\":0.0,\"airline_gst\":255.0,\"paid_before\":\"5223.0\",\"amend_charges\":1350.0,\"ct_charges\":0.0,\"currency\":\"INR\",\"other_charges\":348.0,\"service_fee\":0.0,\"total\":500},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":0.0},\"dc\":{\"DEFAULT\":0.0},\"nb\":{\"DEFAULT\":0.0},\"kc\":{\"DEFAULT\":0.0},\"da\":{\"DEFAULT\":0.0},\"tw\":{\"DEFAULT\":0.0},\"up\":{\"DEFAULT\":0.0}}}}";
	String param_Air_Amendment_API212="\",\"txn_id\":\"75719816\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"13957750\",\"company_id\":101,\"payment_category\":\"B\",\"currency_conversion_details\":{\"displayCurrency\":\"Rs.\",\"conversionFactor\":1.0},\"customer_detail\":{\"user_id\":13957750,\"mobile\":\"1211212122\",\"landline\":\"02240554000\",\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cleartrip\",\"last_name\":\"Booker\",\"title\":\"Mr\"},\"app_return_info\":{\"url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://onetin.cltp.com:9001/itin/internal/itinerary/NI68d317ae5b-ef5e-49e5-a2cc-200903170504/book/internal\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"test\",\"last_name\":\"test\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":1,\"airline_name\":\"IndiGo\",\"airline_code\":\"6E\",\"flight_number\":734,\"departure_date\":\"2020-10-24T09:20:00\",\"arrival_date\":\"2020-10-24T11:05:00\",\"departure_time\":\"09:20\",\"arrival_time\":\"11:05\",\"duration\":\"6300\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"BOM\",\"departure_airport_name\":\"Bengaluru International Airport\",\"arrival_airport_name\":\"Chatrapati Shivaji Airport\",\"total_time\":\"6300\",\"departure_terminal\":\"1\",\"arrival_terminal\":\"1\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"Mumbai\"}]}],\"flights_pricing_details\":{\"air_dev_fee\":0.0,\"airline_misc\":0.0,\"cute_fee\":0.0,\"airline_gst\":723.0,\"amend_charges\":0.0,\"ct_charges\":0.0,\"other_charges\":0.0,\"service_fee\":0.0,\"vas_details\":[{\"amount\":229.0,\"provider\":\"DIGIT\",\"title\":\"Flexifly\",\"vas_type\":\"AMEND_INSURANCE\"},{\"amount\":279.0,\"provider\":\"DIGIT\",\"title\":\"TRAVEL_INSURANCE\",\"vas_type\":\"TRAVEL_INSURANCE\"}],\"pax_pay_info\":[{\"base_fare\":3100.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"currency\":\"INR\",\"total\":500.0},\"domain\":\"IN\",\"initial_total\":0.0,\"retry_num\":0}";
	
	
	//"140471948,\"ui_language\":\"EN\",\"client\":\"Cleartrip\",\"trip_ref\":\"200531806440\",\"txn_id\":\"227577296\",\"currency\":\"INR\",\"product_type\":\"DOMESTIC-AIR\",\"source_type\":\"MOBILE\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"77925412\",\"company_id\":110340,\"back_button_url\":\"/amendments/itinerary\",\"trip_title\":\"Bangalore ? New Delhi\",\"payment_category\":\"A\",\"customer_detail\":{\"user_id\":77925412,\"mobile\":\"9971867476\",\"email\":\"shubham.bansal@cleartrip.com\",\"first_name\":\"Shubham\",\"last_name\":\"Bansal\"},\"app_return_info\":{\"url\":\"http://amendtool.gcp-cltp.com/amend/book/680e1794b8-87a7-40b9-a8d6-200614005232\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://amendtool.gcp-cltp.com/amend/book/680e1794b8-87a7-40b9-a8d6-200614005232\"},\"air_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Mr\",\"first_name\":\"Shubham\",\"last_name\":\"Bansal\"}],\"itinerary_details\":[{\"segment_details\":[{\"serial_number\":0,\"airline_name\":\"UK\",\"airline_code\":\"UK\",\"flight_number\":816,\"departure_date\":\"2020-06-22T12:15:00\",\"arrival_date\":\"2020-06-22T15:05:00\",\"departure_time\":\"12:15\",\"arrival_time\":\"15:05\",\"duration\":\"10200\",\"stops\":0,\"departure_code\":\"BLR\",\"arrival_code\":\"DEL\",\"departure_airport_name\":\"Kempegowda International Airport\",\"arrival_airport_name\":\"Indira Gandhi Airport\",\"departure_name\":\"Bangalore\",\"arrival_name\":\"New Delhi\",\"date\":\"2020-06-22T12:15:00\"}]}],\"flights_pricing_details\":{\"pax_pay_info\":[{\"base_fare\":4970.0,\"pax_count\":1,\"pax_type\":\"ADULT\"}],\"discount\":0.0,\"psgr_service_fee\":0.0,\"air_dev_fee\":0.0,\"airline_misc\":177.0,\"cute_fee\":0.0,\"airline_gst\":255.0,\"paid_before\":\"5223.0\",\"amend_charges\":1350.0,\"ct_charges\":0.0,\"currency\":\"INR\",\"other_charges\":348.0,\"service_fee\":0.0,\"total\":1877},\"transaction_fee_details\":{\"cc\":{\"DEFAULT\":0.0},\"dc\":{\"DEFAULT\":0.0},\"nb\":{\"DEFAULT\":0.0},\"kc\":{\"DEFAULT\":0.0},\"da\":{\"DEFAULT\":0.0},\"tw\":{\"DEFAULT\":0.0},\"up\":{\"DEFAULT\":0.0}}}}"
	
	
	String param_EMI_Fetch = "{\"tripRef\":\"Q2020990339303\",\"amount\":1000}";
	

	public String tripRef = null;

	protected String Url;
	protected String paymentUrl;
	protected String qaUrl;
	public Response resp;


	protected String qaurl = "https://qa2new.cleartrip.com";
	protected String qaurlFlyin = "https://qa2.flyin.com";
	protected String qaurlae = "https://qa2.cleartrip.ae";
	protected String qaurlbh = "https://qa2bh.cleartrip.com";
	protected String qaurlkw = "https://qa2kw.cleartrip.com";
	protected String qaurlom = "https://qa2om.cleartrip.com";
	protected String qaurlsa = "https://qa2.cleartrip.sa";
	protected String qaurlus = "https://qa2me.cleartrip.com";
	protected String qaurlqa = "https://qa2qa.cleartrip.com";
	protected String URL_Android = "&isMobileApp=true&deviceType=android";
	protected String URL_iOS = "&isMobileApp=true&deviceType=ios";
	
	List<Integer> payment_id = new ArrayList<Integer>();
	List<String> trk_id = new ArrayList<String>();
	List<String> trip_refPromo = new ArrayList<String>();

	public HashMap<String, Object> headersForms(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");		
		return headers;
	}

	public HashMap<String, Object> headersForms_Recommendation(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("request-id", "123");
		return headers;
	}

	public HashMap<String, Object> headersForms_IR1(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Cookie", "ct-auth=kHJ9m9EZ5FnYbC9M%2BUy3p2Op7Lwt%2F2TACwQ7J1Zh5vTvKMlBDLe8dGg0f5k%2FKxm5uQmW3NiUZma8q2lELnUuyC3uAF5DaTQONdJlLn%2FO2md2nbUa45ssUlijxS%2BlNzPHs1E8yeZEP1o8qe0ANvv609qkekjA1i1%2Boi%2Bn9cegRH96COXmEO6znXR7hdWPSF2Je64UQLp1AMFGUq5JNjib0Q%3D%3D");
		return headers;
	}
	public HashMap<String, Object> headersForms_IR(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Cookie", "ct-auth=hw%2Fzn67oakJZkXnJoxIeIjfl2qOnHQRRNnqN7AQQ%2FxQ26Kin9hQIigot%2F0Xrgh84j9O3UYZZi4zJRwF%2Bio21NJjJfVdGhDt6EBXP56tMKTFEH0OuwGlEszc72Fq4WLhXmtL9BcVMk55ioGmyMvRjeRfO1jD%2FuIPrjNiVlyI87b4%3D");
		return headers;
	}

	public HashMap<String, Object> headersForms_Supercoins(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");/*
		headers.put("Content-Length", "<calculated when request is sent>");
		headers.put("Host", "<calculated when request is sent>");*/
		headers.put("Cookie", "ct-auth=cvlYMINwAZRln63Yy%2FxTL568HM%2FlJBdzmm2h%2BU3Y05v2zwkQAPQe5Vd9D3VsgwyxL5w%2BfbtxsaW%2BbtdHrc%2BWsScG24OcK1SPJLWfpxAcYSUZ%2BDPJWIpT6PozXecbENnMvrpx3EcElSt8IxAixuU3Wx1urIG%2BJIXXp1dllo9UaxruwmmL4%2Fl%2BZmNgLOEFFQEHIBmo7ujFj4IR251LE1REPIl0hD%2BOGrq3TzykZUx%2BW0wEWrlcwiuBMyRp%2FjW2ZkBtsCH0dQMu8eNGLFfYURLEzxWteZk4kgVCTdhW8xwshOSRXS16FEAEuu%2F0%2BY4jXzpsD%2BBMWmzm2HjhJN3LrqPmJl%2BPb%2BtRIDeSJJ8B3pwqUtovU9euu0zuyj4pUK7H7Exfn3xsb72VU1fgZGUiAqGNjlr4i1%2BstEIodrXyWaIerOwsliKRdHKdB04q2m8OnZXTH2Z4tsAXBZj47Mu0vEuTRiAH0Rp2vtFkuXiol%2Fc%2BBJD4qswYyk0D6GkqDc%2FryiGzrriKvMSxzl8ZjdP0xHKTJjDfE5MjfU2lez8Mc21eeVj4yG9Y5gNNb6MvOPOrwEDI%2FRkVukgyqFl7OJk6DNu3G%2FLNPaqxgHPoG%2Fb4MQRnyZVI9iJH8UXIBBVrkHxP0uq0KBIFqMINY881df17xzwxrP0wDfAjdIJWLC650cfnf3%2BZ8zInGGcv79tFePFr5UA0tMv7Ci9nlUUKOJuJ4P3asT%2F%2Fu6AA%2BWLog2uJ%2FY2YYqgP%2FV7P4M74%2FvZ8fgql9D8g8%2F%2F1HM9Q%2BhZwENf6sKaAU%2FkxX%2BEKCRjKf8O%2BTNUSfsuE8coUcku3YuzCaIBgM2P8Rb8sKLbSBDeyofU70uSSaPMHgCym1TRbOwe4kMI3sC%2BxNY2SNpWEXNL%2B8qnJRC3izkqTBVx8eUSmCMEROlIxUX3V3khzmrd4HsCxqs0QPfyV377s8BRI51ht8oyW%2FzMrKpsxMHx8GV2Wrz8SXH%2BJ4L7k2DAeId6CWMfLGEE76GmqZ7oItSHv5%2F5UO3DEKBLdNgJ6hCK8jDxka%2F19EfaquJ%2FSxkyRZqMldWabWMA8RFSkXBqexHhTLDzmgQVTrTtMzlNFPfPmCegfz2VJg5y%2Bh8C6ZuqGprbV9JxNvdZWfas1vK%2BlbxoIkTOxeVMYoTzx%2BRDEyo9MjCQlcI5K%2BXqy75cBiovhF%2FKcf00zq%2B4kHLbNgQWHsPxU03SG2PnNTTKvShsNtANjRoE31K8EhQCUxAy0RKUSZCsC9rC3NzCyiZQ8OMPyxuJe8aT3kw6b6Vr5W6ItDyb4p912T8y4Fmb%2BkWvTbYc3Gs6r0RfKxtBdJ7XZo8xSwXirQmVaFYJIN9SOYihXgvoe0tBEocfUYUUWT%2B21WjlsPFl3GqgqbnhOpQnwu4MuBFLJXP%2FGwt5epuyxkim5u3c1uLqpdlcKqTiJklaTM5EIWuxV%2BaxHXwh%2BX0x6JaS%2BJVI%2FViRLDjDvQxUjikuijAL%2BCIze%2BR0CONXQZwkQogOIBXtmmoU7CXBduaNzsLsrm0xPzTZjAvB1t1bEN8iIA9Fm3g2V6y48Pcv105pi%2F0nOxsa88OJMSX3bnJI%2F3pgvKn2lnUXPLJ7y2Eu5XYFyvRuvn8a18e%2B8QW%2BDTpp4h6bdpj%2FZ9V%2FRA%2BDYvT8d%2B0SoNyAooj0VtvXSMlfWLLScXRLU%2BZaNO4FeNzu9omIl8wyeWqwu8rZig4caleCF1rb7B0cXdHlu22SFZBRDdm61ES55aWujhpwye7ll1z5%2BCvKfEGNj16XgE8nl%2BknQOMmlSXdgI%2BJFHEAfZDmnjfzC2WV5xvuKqSmWWXeio0nh2R21fe8daY7Ojjo6NrqXDwQ6jZAjW349e5ztY0ocyXbt3mUSAALPlSZH315et1tPeY6CAhN3g8jTi%2B5T067h1hS925YjG5GVWQEGPrqiotCIMZf53SSRFJifXJIaxURXAN73vVKQpNfYJD6mKYvS77BJ1HSahQWO8rzmGvOJz6lU2vmvg5v2yYWzQbPfgX5sziMP%2Fp6at%2Fg5EUSUNbxqsajCjtC4Sy4Z%2FcEq0OVtCOVMb5LGLl%2B%2FaRcmVwIivbXgF6WJgGUyqQ%2FXYwgA%2Fd9fga3Wk9c01HYm8wnioO4gmHaHVqQNmgGYeBrRXYvmI7n0EifouUynX87T2pv9AtznT%2BGRE6YbjHJMx5nzalaKkdHPfrRRUzMejSVax39JguN5OkUi2cnUbya%2FFSiCtp%2By8Ubg5ROodIVxVaYSNtFg8%2FGBOW6RnvXjvo2J6aYJW4Dwa4%2Bqo2J56VlK7p5gikInWq5kpbwMOT5ewyDoK4sB7QCaCOGKCAw9mQlGqrQU5MUNpJgjO%2Bvcj2nSPdpoA%2BndoEUb2M%2F1KyL5QnnmD2uv");
		return headers;
	}

	public HashMap<String, Object> headersForms_Eligibility_V2(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("api-version","2");
		return headers;
	}
	
	public HashMap<String, Object> headersForms_Json(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json");		
		return headers;
	}	

	public HashMap<String, Object> headersForms_Promo_Update(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		headers.put("x-action", "UPDATE");	
		return headers;
	}

	public HashMap<String, Object> headersForms_Wallet_UI(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json"); //5656565656
		headers.put("Cookie", "ct-auth=mtZsACRA1n9P2aEwIiDHAS%2FXfzh%2Bul9C4d7wxOu%2FKukL%2FjYrSv%2Fkq3vusOayrMK7vdb22kmKGrhj2VAI20AltuKMN8g0MGLQHH84RxKf3tJ4YopeEIURg7FDSj5odZZP%2FpU0eWHnRrV%2FQr%2FWJfgJFRMNMpDSxn28XwRgiET54H8%3D");
		return headers;
	}

	public HashMap<String, Object> headersForms_Wallet_TOA(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "3d3c2e128f58d62fb90cd9d7e9bd325031f181f3455f560ff1183d69f1c619de");
		return headers;
	}

	public HashMap<String, Object> headersForms_UI_Wallet_Cookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		headers.put("Cookie", "ct-auth=cvlYMINwAZRln63Yy%2FxTL568HM%2FlJBdzmm2h%2BU3Y05v2zwkQAPQe5Vd9D3VsgwyxL5w%2BfbtxsaW%2BbtdHrc%2BWsScG24OcK1SPJLWfpxAcYSUZ%2BDPJWIpT6PozXecbENnMvrpx3EcElSt8IxAixuU3Wx1urIG%2BJIXXp1dllo9UaxruwmmL4%2Fl%2BZmNgLOEFFQEHIBmo7ujFj4IR251LE1REPIl0hD%2BOGrq3TzykZUx%2BW0wEWrlcwiuBMyRp%2FjW2ZkBtsCH0dQMu8eNGLFfYURLEzxWteZk4kgVCTdhW8xwshOSRXS16FEAEuu%2F0%2BY4jXzpsD%2BBMWmzm2HjhJN3LrqPmJl%2BPb%2BtRIDeSJJ8B3pwqUtovU9euu0zuyj4pUK7H7Exfn3xsb72VU1fgZGUiAqGNjlr4i1%2BstEIodrXyWaIerOwsliKRdHKdB04q2m8OnZXTH2Z4tsAXBZj47Mu0vEuTRiAH0Rp2vtFkuXiol%2Fc%2BBJD4qswYyk0D6GkqDc%2FryiGzrriKvMSxzl8ZjdP0xHKTJjDfE5MjfU2lez8Mc21eeVj4yG9Y5gNNb6MvOPOrwEDI%2FRkVukgyqFl7OJk6DNu3G%2FLNPaqxgHPoG%2Fb4MQRnyZVI9iJH8UXIBBVrkHxP0uq0KBIFqMINY881df17xzwxrP0wDfAjdIJWLC650cfnf3%2BZ8zInGGcv79tFePFr5UA0tMv7Ci9nlUUKOJuJ4P3asT%2F%2Fu6AA%2BWLog2uJ%2FY2YYqgP%2FV7P4M74%2FvZ8fgql9D8g8%2F%2F1HM9Q%2BhZwENf6sKaAU%2FkxX%2BEKCRjKf8O%2BTNUSfsuE8coUcku3YuzCaIBgM2P8Rb8sKLbSBDeyofU70uSSaPMHgCym1TRbOwe4kMI3sC%2BxNY2SNpWEXNL%2B8qnJRC3izkqTBVx8eUSmCMEROlIxUX3V3khzmrd4HsCxqs0QPfyV377s8BRI51ht8oyW%2FzMrKpsxMHx8GV2Wrz8SXH%2BJ4L7k2DAeId6CWMfLGEE76GmqZ7oItSHv5%2F5UO3DEKBLdNgJ6hCK8jDxka%2F19EfaquJ%2FSxkyRZqMldWabWMA8RFSkXBqexHhTLDzmgQVTrTtMzlNFPfPmCegfz2VJg5y%2Bh8C6ZuqGprbV9JxNvdZWfas1vK%2BlbxoIkTOxeVMYoTzx%2BRDEyo9MjCQlcI5K%2BXqy75cBiovhF%2FKcf00zq%2B4kHLbNgQWHsPxU03SG2PnNTTKvShsNtANjRoE31K8EhQCUxAy0RKUSZCsC9rC3NzCyiZQ8OMPyxuJe8aT3kw6b6Vr5W6ItDyb4p912T8y4Fmb%2BkWvTbYc3Gs6r0RfKxtBdJ7XZo8xSwXirQmVaFYJIN9SOYihXgvoe0tBEocfUYUUWT%2B21WjlsPFl3GqgqbnhOpQnwu4MuBFLJXP%2FGwt5epuyxkim5u3c1uLqpdlcKqTiJklaTM5EIWuxV%2BaxHXwh%2BX0x6JaS%2BJVI%2FViRLDjDvQxUjikuijAL%2BCIze%2BR0CONXQZwkQogOIBXtmmoU7CXBduaNzsLsrm0xPzTZjAvB1t1bEN8iIA9Fm3g2V6y48Pcv105pi%2F0nOxsa88OJMSX3bnJI%2F3pgvKn2lnUXPLJ7y2Eu5XYFyvRuvn8a18e%2B8QW%2BDTpp4h6bdpj%2FZ9V%2FRA%2BDYvT8d%2B0SoNyAooj0VtvXSMlfWLLScXRLU%2BZaNO4FeNzu9omIl8wyeWqwu8rZig4caleCF1rb7B0cXdHlu22SFZBRDdm61ES55aWujhpwye7ll1z5%2BCvKfEGNj16XgE8nl%2BknQOMmlSXdgI%2BJFHEAfZDmnjfzC2WV5xvuKqSmWWXeio0nh2R21fe8daY7Ojjo6NrqXDwQ6jZAjW349e5ztY0ocyXbt3mUSAALPlSZH315et1tPeY6CAhN3g8jTi%2B5T067h1hS925YjG5GVWQEGPrqiotCIMZf53SSRFJifXJIaxURXAN73vVKQpNfYJD6mKYvS77BJ1HSahQWO8rzmGvOJz6lU2vmvg5v2yYWzQbPfgX5sziMP%2Fp6at%2Fg5EUSUNbxqsajCjtC4Sy4Z%2FcEq0OVtCOVMb5LGLl%2B%2FaRcmVwIivbXgF6WJgGUyqQ%2FXYwgA%2Fd9fga3Wk9c01HYm8wnioO4gmHaHVqQNmgGYeBrRXYvmI7n0EifouUynX87T2pv9AtznT%2BGRE6YbjHJMx5nzalaKkdHPfrRRUzMejSVax39JguN5OkUi2cnUbya%2FFSiCtp%2By8Ubg5ROodIVxVaYSNtFg8%2FGBOW6RnvXjvo2J6aYJW4Dwa4%2Bqo2J56VlK7p5gikInWq5kpbwMOT5ewyDoK4sB7QCaCOGKCAw9mQlGqrQU5MUNpJgjO%2Bvcj2nSPdpoA%2BndoEUb2M%2F1KyL5QnnmD2uv");

		return headers;
	}
	
	public HashMap<String, Object> headersForms_Promo_Activate(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		headers.put("x-action", "ACTIVATE");	
		return headers;
	}
	
	public HashMap<String, Object> headersFormsWallet(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");		
		headers.put("ct-auth", "5zoM9zvEgPvd1fO%2BsJylFp4hvaybBzUzp2ilDBfOdXvOg%2BIVENg%2BHdsz3cA98%2B5BD3habrO078UoXdzWM34lXZaLbE1jIpkEaANLn%2BHJadeW7kll2UfWWUfOoZLsVWTER2KXP0MBz2Ucg2wdtjfomKwrrYOshnOlUWyYWat6SeV2Tt6lvwTzivgXCSht22Dws");
		return headers;
	}
	
	public HashMap<String, Object> headersFormsNew(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		return headers;
	}
	
	public HashMap<String, Object> headersFormsNew1(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");		
		return headers;
	}
	
	public HashMap<String, Object> headersFormspay() throws Exception{		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		headers.put("pay-auth", paygetAuth());
		return headers;
	}

	public HashMap<String, Object> headersFormspay_FullGV() throws Exception{		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		headers.put("pay-auth", paygetAuth_FullGV());
		return headers;
	}
	
	public HashMap<String, Object> headersFormspay_Supercoins() throws Exception{		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		headers.put("pay-auth", paygetAuth_SuperCoins());
		return headers;
	}
	
	public HashMap<String, Object> headersFormspay_EMI() throws Exception{		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		headers.put("pay-auth", paygetAuth_EMI());
		return headers;
	}


	public HashMap<String, Object> headersPayAuth(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}
	public HashMap<String,Object> headerFormsPromoService(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("x-action", "ACTIVATE");
		return headers;
	}
	
	public HashMap<String,Object> headerFormsPromoService_Supercoins_Update(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("x-action", "UPDATE");
		return headers;
	}

	public HashMap<String, Object> headersFormsSmiles(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Authorization", "Basic OGI3YTJmN2NkNDQwOTg5NTk0Yzk1Y2JkZjczOThiZWM6MDNjYzJjNzYwNTg5OTM5NDkwN2FkMWUyODJmMmFhNzU=");

		headers.put("Content-Type", "application/x-www-form-urlencoded");
		return headers;
	}


	public HashMap<String, Object> headersForms_wallet(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		//headers.put("Cookie", "ct-auth = JHuf%2BCHAT9dJA6iy3yljOA%2BJEhxSeSS6bMSVjXXjBRMEKMkFZO7FDVmoCxuK2ro9JWNRt682KuqiFuXV2whf5HObWzaif65XOuM37YyrPLX%2BaiBNwnkmSmMem2WbpgBvzIOK8AA0ICwzYBAszCVlK7Wt4vbavb4Rc9plZba2GjgZcQBlPkvWs0YEAP%2B2OXYcwxeut2x6p5X1i%2BvPjnOjN5c7bmkG62x2TeRUPL%2BcTfQ7ZtPZvYpaAQ3oRcyhXrPhCUmcbRdKxTvjY08FAtXwySBwZnpRB%2Fr6Tdc4tErNeglqJTknezoRpPhKBzjfu1gtd8ro1XIKetU3yLt3kXt9RMitRVpAKIqLA%2Bkwfued9ARpSFWPHNzcb5k%2BZjusDdQuULECGHAP00B8LK7MltV20wodXXSeczhpDpmjAwJJBWF2kulqJ%2FaQ5Oi%2BUMmQ92BEqwQ0%2FZ1GGS%2FCsh4%2Flet6bIQmTJelK7OdeSLJlOhcpan1uHwoj5PmK6CrwQl4iGe6N0IBzS8MCjon9SGgFW8uc%2B97NUe06yWRwDtxLHRrqe%2B8UfmNCT%2B9HIFFr7urccGIf09n7B1MBN2D%2F3uBsb4bR8YYXRDmXYUVm%2FXms5YZHzl1u0HRpkoj3SJCZNksleaf4%2FRMFvDNJjcW0zkxFMlzew2BiwCGms1A%2Bpuib7AbTmi3KrivJofipyqlrlOmpIFB86BH3WBORcuhJKlOSbZ88Sjk7Axf%2Bj5hS4tsbVfQlBNW%2Fn1gi1O6phXNn%2BoD%2B1RUQ2HxBmGgursB0XalVJfK1g%3D%3D");
		headers.put("Cookie", "ct-auth = hw%2Fzn67oakJZkXnJoxIeIjfl2qOnHQRRNnqN7AQQ%2FxQ26Kin9hQIigot%2F0Xrgh84j9O3UYZZi4zJRwF%2Bio21NJjJfVdGhDt6EBXP56tMKTFEH0OuwGlEszc72Fq4WLhXmtL9BcVMk55ioGmyMvRjeRfO1jD%2FuIPrjNiVlyI87b4%3D");

		return headers;
	}


	public HashMap<String, Object> headersForms_GVCreate_10(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "5251ffd74806413354865c7b718d3d5cfed9b2d41ef3035ae0da51f052f4d1b2");
		return headers;
	}

	public HashMap<String, Object> headersForms_GVCreate_5000(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "68b14cc68ab1b618f219c13c63618f685fa50f31cc8072dc294bdc02acf94c36");
		return headers;
	}

	public HashMap<String, Object> headersForms_GVCreate_100000(){		
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "53a8a87f3707c1da57f5c1bf9d5e3ceb25ae5f5866fea66703173e530fcb9bce");
		return headers;
	}

	public HashMap<String, Object> headersForms_GVCreate_1000(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "a275636f9706600bee55f0495101fdf651a24085bd78b35c49dae79d9b5f3450");
		return headers;
	}

	public HashMap<String, Object> headersForms_GVCreate_10000(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("checksum", "b4207cd988b53b3a1bd70a2154d73f96186c084a14b081ff183ce90e4a114d6b");
		return headers;
	}

	public HashMap<String, Object> headerFormss_Hi5_GetTrnx(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("x-ct-api-key", "8eba7730aab83acbe07d7643d1c0d146");
		headers.put("Cookie", "ct-auth=3xcxwwe9ygZiz9iN8PQijGtShnZ6wgaan3KzDIvhyX%2FgtvKRgKn%2FcWX1FJfzonaXt3THK21PZyGXoShVpB1iXMqmWm%2FDev2x5gdkBTtDCsr%2Bu0DSP3zgAJqBuEcpX5lNKg%2F%2FPf1RAYqRIMSQp1BvYlcH8%2FyUvKb1jb%2B9ynKvCSw%3D");
		return headers;
	}

	public HashMap<String, Object> SavedCards(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");
		//headers.put("ct-auth", "0dLJv9ljuebC7zmtbuIUMnoNEawA%2BTkywGgYinYAgAjN3R7SkF4o6%2FSUnv5DuNa7t3THK21PZyGXoShVpB1iXOhQR5gUiv5XCwmTDvwPqehabhTrwJ%2FMVeB9HRZETygtTMhGff980MrbPTJfxNwnsdfycQDMejsyL7IyXjf6h8k%3D");
		//headers.put("Cookie: ct-auth=0dLJv9ljuebC7zmtbuIUMnoNEawA%2BTkywGgYinYAgAjN3R7SkF4o6%2FSUnv5DuNa7t3THK21PZyGXoShVpB1iXOhQR5gUiv5XCwmTDvwPqehabhTrwJ%2FMVeB9HRZETygtTMhGff980MrbPTJfxNwnsdfycQDMejsyL7IyXjf6h8k%3D");
		//headers.put("ct-auth", "0dLJv9ljuebC7zmtbuIUMnoNEawA%2BTkywGgYinYAgAjN3R7SkF4o6%2FSUnv5DuNa7t3THK21PZyGXoShVpB1iXOhQR5gUiv5XCwmTDvwPqehabhTrwJ%2FMVeB9HRZETygtTMhGff980MrbPTJfxNwnsdfycQDMejsyL7IyXjf6h8k%3D");
		return headers;
	}

	public HashMap<String, Object> addCookies(){
		HashMap<String, Object> setCookies = new HashMap<>();
		setCookies.put("userid", "prakhar.chatterjee%40cleartrip.com%7C%7C%7C%7C65176819");
		setCookies.put("usermisc", "SIGNED_IN%7C");
		return setCookies;
	}
	
	public String returnParamForBin_CC(){
		String t=RandomStringUtils.randomNumeric(6);
		String Param1="{\"bank\":\" "+s;
		String Param2=" \",\"bank_id\": "+r;
		String Param3=", \"bin\":\""+t;
		String Param4="\", \"card_type\": \"CREDIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"MASTERCARD\",\"sub_type\": \"NA\"}";

		String Param5="\", \"card_type\": \"DEBIT\", \"country\": \"INDIA\",\"is_otp_eligible\": true,\"issuer_type\": \"MASTERCARD\",\"sub_type\": \"NA\"}";

		String Params_Singlebincard_Credit=Param1+Param2+Param3+Param4;

		return Params_Singlebincard_Credit;
	}
	
	public Response payGet(String payType, String payType1) {
		RestAssured.baseURI =promoURL;
		String url = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;	
		if(payType.equalsIgnoreCase("PromoActive")) {
			url= urlpromoActivate;
		}
		else if(payType.equalsIgnoreCase("BannerNew")) {
			url=url_QA2+banner_New;
		}

		else if(payType.equalsIgnoreCase("Hi_5_get_walletTnx")) {
			RestAssured.baseURI =url_QA2;
			Reporter.log(url_QA2);
			url= urlHi5_Fetch_WalletTnx;
		}else if(payType.equalsIgnoreCase("GET_Raterule_CLEMI")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_SCLP_Raterule_CLEMI;
		}
		else if(payType.equalsIgnoreCase("GET_Raterule_PL")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_SCLP_Raterule_PL;
		}
		else if(payType.equalsIgnoreCase("EMIBankDetails")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_EMI_Bank_Details;
		}
		else if(payType.equalsIgnoreCase("EMIRouting")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_EMI_Routing;
		}
		else if(payType.equalsIgnoreCase("EMI_Juspay_GetPlans")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_EMI_GetPlans;
		}
		else if(payType.equalsIgnoreCase("EMI_Juspay_GetOffer")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= EMI_Juspay_GetOffer;
		}
		else if(payType.equalsIgnoreCase("EMICache_Refresh_New")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= url_EMI_Cache_Refresh_New;
		}





		else if(payType.equalsIgnoreCase("MIS_Report")) {
			RestAssured.baseURI =urlReporting;
			Reporter.log(urlReporting);
			if(payType1.equalsIgnoreCase("CC")) {
				url = urlMIS_Report_CC;
			}
			else if(payType1.equalsIgnoreCase("DC")) {
				url = urlMIS_Report_DC;
			}
			else if(payType1.equalsIgnoreCase("PL")) {
				url = urlMIS_Report_PL;
			}

			else if(payType1.equalsIgnoreCase("RP_SC")) {
				url = urlMIS_Report_RP_SC;
			}
			else if(payType1.equalsIgnoreCase("NB")) {
				url = urlMIS_Report_NB;
			}
			else if(payType1.equalsIgnoreCase("RP_SC")) {
				url = urlMIS_Report_RP_SC;
			}
			else if(payType1.equalsIgnoreCase("RP_ADCB")) {
				url = urlMIS_Report_RP_ADCB;
			}
			else if(payType1.equalsIgnoreCase("WT_Credit")) {
				url = urlMIS_Report_WT_Credit;
			}
			else if(payType1.equalsIgnoreCase("WT_Rewards")) {
				url = urlMIS_Report_WT_Rewards;
			}
			else if(payType1.equalsIgnoreCase("GV")) {
				url = urlMIS_Report_GV;
			}
			else if(payType1.equalsIgnoreCase("CL_EMI")) {
				url = urlMIS_Report_CLEMI;
			}
			else if(payType1.equalsIgnoreCase("EMI")) {
				url = urlMIS_Report_EMI;
			}
			else if(payType1.equalsIgnoreCase("TW")) {
				url = urlMIS_Report_TW;
			}
			else if(payType1.equalsIgnoreCase("UP")) {
				url = urlMIS_Report_UP;
			}
			else 	if(payType1.equalsIgnoreCase("DA")) {
				url = urlMIS_Report_DA;
			}else if(payType1.equalsIgnoreCase("PL_Refund")) {
				url = urlMIS_Report_PL_Refund;
			}
		}


		else if(payType.equalsIgnoreCase("NoCostEMI_Offers")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= urlEMI_NoCost_Offers;
		}

		else if(payType.equalsIgnoreCase("EMI_Offer_eligibility_New")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url= urlEMI_NoCost_Offers_Eligibility_New;
		}

		
		else if(payType.equalsIgnoreCase("Hi_5_get_wallet")) {
			RestAssured.baseURI =url_QA2;
			Reporter.log(url_QA2);	
			url= urlHi5_Fetch_Wallet;
		}
		
		else if(payType.equalsIgnoreCase("EMIBanks")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);	
			url= urlpromoUsed;
		}
		
		else if(payType.equalsIgnoreCase("IR_Fetch_Cancel_Details_CancelTnx")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);	
			url= urlIR_Get_VPA_Cancel_Details;
		}
		
		else if(payType.equalsIgnoreCase("IR_Fetch_Cancel_Details_UserID")) {

			headers = headersForms_IR();
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);	
			url= urlIR_Get_VPA_Cancel_Details_UserID;
		}
		
		
		else if(payType.equalsIgnoreCase("FetchTripStatus")) {
			RestAssured.baseURI =urlPay;			
			Reporter.log(urlPay);	
			url= urlFetchTripStatus;
		}
		else if(payType.equalsIgnoreCase("FetchGWFailure")) {
			RestAssured.baseURI =urlPay;			
			Reporter.log(urlPay);	
			url= urlFetchGWFailure;
		}

		else if(payType.equalsIgnoreCase("EMIRazorpay")) {
			RestAssured.baseURI =urlPay;			
			Reporter.log(urlPay);	
			url= url_EMI_GW_Razorpay;
		}
		else if(payType.equalsIgnoreCase("EMINoon")) {
			RestAssured.baseURI =urlPay;			
			Reporter.log(urlPay);	
			url= url_EMI_GW_Noon;
		}
		
		
		else if(payType.equalsIgnoreCase("PromoUsed")) {
			Reporter.log(urlReportingTS);	
			RestAssured.baseURI =urlPromo_Used;
			url= urlpromoUsed;
		}
		else if(payType.equalsIgnoreCase("FetchPayDetails")) {
			RestAssured.baseURI =urlReportingTS;
			url= url1_FetchPayDetails;
			Reporter.log(urlReportingTS+url);		
		}
		else if(payType.equalsIgnoreCase("CreateRecord")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);			
			url = urlPay_CreateRecord;
		}
		else if(payType.equalsIgnoreCase("FlyinWallet")) {
			RestAssured.baseURI =url_QA2;
			Reporter.log(url_QA2);			
			url = urlFlyin_Wallet;
		}

		else if(payType.equalsIgnoreCase("IR_Eligibility_NB")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);			
			url = urlIR_Eligibility_NB;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_CC")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Eligibility_CC;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_Cardless_EMI")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Eligibility_Cardless_EMI;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_PayLater")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Eligibility_PayLater;
		}



		else if(payType.equalsIgnoreCase("IR_Eligibility_DC")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);			
			url = urlIR_Eligibility_DC;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_CC_Non")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);			
			url = urlIR_Non_Eligibility_CC;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_GV")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_GV;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_WALLET")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_WALLET;
		}

		else if(payType.equalsIgnoreCase("IR_Eligibility_EMI")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_EMI;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_TW")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_TW;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_UPI")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_UPI;
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_RP")) {

			RestAssured.baseURI =urlPay;
			Reporter.log(urlPay);
			url = urlIR_Non_Eligibility_RP;
		}





		Reporter.log(url);	
		request = RestAssured.given().
				when().
				log().all().
				headers(headers).
				get(url);
		return request;			
	}

	public Response payGet1(String payType, String payType1) {
		RestAssured.baseURI =urlPay;
		String url = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;	
		if(payType.equalsIgnoreCase("RORFetch_Pay_BY_ID")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_Fetch_PayByID;
			Reporter.log(urlReporting+url);
		}

		else if(payType.equalsIgnoreCase("get_prefferred_modes")) {
			RestAssured.baseURI =urlRecommendationService;
			url= urlRecommendation_getDetails;
			HashMap<String, Object> headers1 = new HashMap<>();
			headers=headersForms_Recommendation();
			Reporter.log(urlReporting+url);

			System.out.println(urlRecommendationService+url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_CheckEarnPoints")) {

			RestAssured.baseURI =urlRewards;
			//params = ParamsSuperCoins_CheckEarnPoints;
			url= urlSuperCoins_CheckEarnPoints;
			Reporter.log(urlRewards+url);
		}
		else if(payType.equalsIgnoreCase("Saved_PaymentModes")) {

			RestAssured.baseURI =url_QA2;
			url= urlSavedPaymentModes_UI;

			headers=SavedCards();

			Reporter.log(url_QA2+url);
		}
		else if(payType.equalsIgnoreCase("SavedCards")) {

			RestAssured.baseURI =urlPay;
			HashMap<String, Object> headers1 = new HashMap<>();
			headers=SavedCards();
			url= urlSavedCards;
			Reporter.log(urlPay+url);
			System.out.println(urlPay+url);
		}

		else if(payType.equalsIgnoreCase("Hi5_GetTrnx")) {
			RestAssured.baseURI =qaurl;
			HashMap<String, Object> headers1 = new HashMap<>();
			headers1=headerFormss_Hi5_GetTrnx();
			url= urlHi5_GetTrnx;
			Reporter.log(qaurl+url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_MobileLinked")) {
			RestAssured.baseURI =urlrewards_URI;
			url= urlSuperCoins_MobileLinked;
			Reporter.log(urlrewards_URI+url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_Info")) {
			//RestAssured.baseURI ="http://172.17.51.86:8061";
			RestAssured.baseURI =urlRewards;

			url= urlSuperCoins_Info;
			Reporter.log("http://172.17.51.86:8061"+url);
		}
		else if(payType.equalsIgnoreCase("RORFetch_Refund_BY_ID")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_Fetch_RefundByID;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_TripStatus")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_TripID_Status;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("RORFetch_Profile_List")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_Fetch_ProfileList;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("NavisonCC")) {
			RestAssured.baseURI =urlReporting;
			url= url_NavisonCC;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("NavisonAir")) {
			RestAssured.baseURI =urlReporting;
			url= url_NavisonAir;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_MultiSearch")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_MultiSearch_Pay;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_WalletFetch")) {
			RestAssured.baseURI =urlWallet;
			url= urlROR_MultiSearch_TripRef_Reads;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_MultiSearch_TripRef_Reads")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_MultiSearch_TripRef_Reads;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_WalletGetV2_Reads")) {
			RestAssured.baseURI =urlPay;
			Reporter.log(urlWallet);
			url= urlROR_WalletFetch_Reads;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_MultiSearch_Reads")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_MultiSearch_Reads;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_WalletTrnx_Reads")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_Wallet_Trnx_Reads;
			Reporter.log(urlReporting+url);
		}
		else if(payType.equalsIgnoreCase("ROR_WalletGet_Reads")) {
			RestAssured.baseURI =urlWallet;
			url= urlROR_Wallet_GetWallet_Reads;
			Reporter.log(urlWallet+url);
		}
		else if(payType.equalsIgnoreCase("ROR_GV_Details")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_GV_Details_Reads;
			Reporter.log(urlPay+url);	
		}
		else if(payType.equalsIgnoreCase("ROR_Refund_Details")) {
			RestAssured.baseURI =urlReporting;			
			url= urlROR_Refund_Reads;
			Reporter.log(urlPay=url);
		}
		else if(payType.equalsIgnoreCase("GETUI_CONVFEE")) {
			RestAssured.baseURI =urlPay;			
			url= url_UI_Get_ConvFee;
			//Reporter.log(urlPay=url);
		}
		else if(payType.equalsIgnoreCase("GETUI_PAYTYPES")) {
			RestAssured.baseURI =urlPay;			
			url= url_UI_Get_PayTypes;
			//Reporter.log(urlPay=url);
		}	
		else if(payType.equalsIgnoreCase("ROR_Mis_expreports")) {
			RestAssured.baseURI =urlReporting;			
			url= urlROR_Mis_ExpReports;
			//Reporter.log(urlPay=url);
		}		
		Reporter.log(url);
		request = RestAssured.get(url);
		return request;			
	}

	public Response payGet2(String payType, String payType1) {

		HashMap<String, Object> headers = new HashMap<>();
		Response request;

		RestAssured.baseURI =qaurl;
		headers=headerFormss_Hi5_GetTrnx();
		String url= urlHi5_GetTrnx;
		Reporter.log(qaurl+url);
		System.out.println(qaurl+url);

		Reporter.log(url);
		System.out.println(url);
		request = RestAssured.get(url);
		return request;
	}

		public Response payPut(String payType, String payType1) {
		RestAssured.baseURI =urlReporting;
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;	
		if(payType.equalsIgnoreCase("RORUpdate_Profile_List")) {
			Random rand = new Random(); 
			int rand_int = rand.nextInt(999999999)+1000000000;

			url= urlROR_Update_ProfileList;
			params= Params_ROR_UpdateProfile_List+rand_int+Params_ROR_UpdateProfile_List1;

		}


		else if(payType.equalsIgnoreCase("EMICache")) {
			RestAssured.baseURI =urlPay;

			url= url_EMI_Cache_Refresh;
			params= "";
		}


		else if(payType.equalsIgnoreCase("EMICache_New")) {
			RestAssured.baseURI =urlPay;

			url= url_EMI_Cache_Refresh_New;
			params= "";
		}

		else if(payType.equalsIgnoreCase("EMIResources")) {
			RestAssured.baseURI =urlPay;

			url= url_EMI_Cache_ResourcesRefresh;
			params= "";
		} 
		
		
		
		else if(payType.equalsIgnoreCase("RORUpdate_Refund_List")) {
			RestAssured.baseURI =urlReporting;
			Random rand = new Random(); 
			int rand_int = rand.nextInt(99999);

			url= urlROR_Update_RefundList;
			params= Params_ROR_UpdateRefund_List+rand_int+Params_ROR_UpdateRefund_List1;

		} 
		else if(payType.equalsIgnoreCase("ROR_CashUpdate")) {
			RestAssured.baseURI =urlReporting;
			url= urlROR_Cash_Update;
			params= Params_ROR_Cash_Update;
		} 

		else if(payType.equalsIgnoreCase("RORFetch_Profile_List")) {
			RestAssured.baseURI =urlReporting;
			Random rand = new Random(); 
			int rand_int = rand.nextInt(99999);

			url= urlROR_Update_RefundList;
			params= Params_ROR_UpdateRefund_List+rand_int+Params_ROR_UpdateRefund_List1;

		} 	

		else if(payType.equalsIgnoreCase("RORUpdate_Payment")) {

			RestAssured.baseURI =urlReporting;
			url= urlROR_Update_Payment;
			params= Params_ROR_Update_Payments;
		} 		

		Reporter.log(urlReporting);
		Reporter.log("Params :" +params);

		request = RestAssured.given().
				when().
				log().all().
				headers(headers).
				body(params).
				put(url);
		return request;			
	}

	public Response payPost(String payType, String payType1) throws Exception {
		RestAssured.baseURI =urlPay;
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;
		if(payType.equalsIgnoreCase("ROR_Create_ProfileList")) {
			params = Params_ROR_Create_Profile_List;
			url= urlROR_Create_ProfileList;
		}
		if(payType.equalsIgnoreCase("EMI_Juspay_Save_Plan")) {
			params = urlPay;
			url= url_EMI_Juspay_SavePlan;
			params = ParamsEMI_Juspay_SaveAPI;
		}
		else if(payType.equalsIgnoreCase("Affor_Eligibility_NCE_V2")) {
			headers=headersForms_Eligibility_V2();
			url= urlAffordability+urlAffordability_EMI_Eligibility;
			params = ParamsAffordability_Eligi_NCE_PL_V2+payType1+ParamsAffordability_Eligi_NCE_PL_V2_2;
		}
		else if(payType.equalsIgnoreCase("Affor_Plans_V2")) {
			headers=headersForms_Eligibility_V2();
			url= urlAffordability+urlAffordability_EMI_V2_Plans;
			params = ParamsAffordability_Eligi_NCE_PL_V2_Plans+payType1+ParamsAffordability_Eligi_NCE_PL_V2_2_Plans;
		}
		else if(payType.equalsIgnoreCase("Affor_Eligibility_NCE")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility;
			params = ParamsAffordability_Eligi_NCE;
		}
		else if(payType.equalsIgnoreCase("Affor_Eligibility_Reg")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility;
			params = ParamsAffordability_Eligi_Reg;
		}
		else if(payType.equalsIgnoreCase("Affor_Plans_NCE_Full")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility_Plans;
			params = ParamsAffordability_Plans_NCE_Full;
		}
		else if(payType.equalsIgnoreCase("Affor_Plans_NCE_Lite")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility_Plans;
			params = ParamsAffordability_Plans_NCE_Lite;
		}
		else if(payType.equalsIgnoreCase("Affor_Plans_Reg_Full")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility_Plans;
			params = ParamsAffordability_Plans_Reg_Full;
		}
		else if(payType.equalsIgnoreCase("Affor_Plans_Reg_Lite")) {
			RestAssured.baseURI =urlAffordability;
			url= urlAffordability_EMI_Eligibility_Plans;
			params = ParamsAffordability_Plans_Reg_Lite;
		}
		else if(payType.equalsIgnoreCase("Affor_Eligibility_PL")) {
			RestAssured.baseURI =urlPay;
			url= urlAffordability_PL_Eligibility;
			params = "{\"userId\":\""+payType1+ParamsAffordability_PL_Eligibility;
		}
		else if(payType.equalsIgnoreCase("Affor_Eligibility_FKPL_Only")) {
			RestAssured.baseURI =urlPay;
			url= urlAffordability_PL_Eligibility;
			params = "{\"userId\":\""+payType1+ParamsAffordability_PL_Eligibility_2000;
		}
		else if(payType.equalsIgnoreCase("SuperCoins_MobileLinked")) {
			headers=headersForms_Supercoins();
			headers=headersForms_Supercoins();
			RestAssured.baseURI =urlRewards;
			url= urlSuperCoins_CheckMobileLinked1;
			params = ParamsSuperCoins_CheckMobileLinked1;
		}

		else if(payType.equalsIgnoreCase("SuperCoins_Info")) {
			headers=headersForms_Supercoins();
			headers=headersForms_Supercoins();
			RestAssured.baseURI =urlRewards;
			url= urlSuperCoins_Info;
			params = ParamsSuperCoins_TrnxInfo;
		}


		else if(payType.equalsIgnoreCase("SuperCoins_OTPLess_Hold")) {
			headers=headersForms_Supercoins();
			RestAssured.baseURI =urlRewards;
			url= urlSuperCoins_Hold;
			params = ParamsSuperCoins_Hold;
		}

		else if(payType.equalsIgnoreCase("SuperCoins_OTPLess_Unhold")) {
			headers=headersForms_Supercoins();
			RestAssured.baseURI =urlRewards;
			url= urlSuperCoins_Unhold;
			params = ParamsSuperCoins_Unhold;
		}
		else if(payType.equalsIgnoreCase("SuperCoins_CheckEarnPoints")) {

			headers=headersForms_IR();
			RestAssured.baseURI =urlRewards;
			//params = ParamsSuperCoins_CheckEarnPoints;
			url= urlSuperCoins_CheckEarnPoints1;
			params = ParamsSuperCoins_Earn1;
		}

		else if(payType.equalsIgnoreCase("IR_Save_VPA")) {
			headers=headersForms_IR();
			params = Params_IR_Save_VPA_Details;
			url= urlIR_Save_VPA;
		}
		else if(payType.equalsIgnoreCase("IR_Create_Refund")) {

			headers=headersForms_IR();
			params = Params_IR_Create_Refund1+getRandomNumber()+Params_IR_Create_Refund3;
			url= urlIR_Create_Refund;
		}

		else if(payType.equalsIgnoreCase("IR_Create_Refund_Wallet")) {

			headers=headersForms_IR();
			params = Params_IR_Create_Refund4+getRandomNumber()+Params_IR_Create_Refund3;
			url= urlIR_Create_Refund;
		}

		else if(payType.equalsIgnoreCase("IR_Create_Refund_Wallet_PL")) {

			headers=headersForms_IR();
			params = Params_IR_Create_Refund6+getRandomNumber()+Params_IR_Create_Refund3;
			url= urlIR_Create_Refund;
		}

		else if(payType.equalsIgnoreCase("IR_Create_Refund_Normal")) {

			headers=headersForms_IR();
			params = Params_IR_Create_Refund2+getRandomNumber()+Params_IR_Create_Refund3;
			url= urlIR_Create_Refund;
		}
		
		
		else if(payType.equalsIgnoreCase("IR_InValid_VPA")) {
			params = Params_IR_InValid_VPA;
			url= urlIR_Validate_VPA;
		}

		else if(payType.equalsIgnoreCase("IR_Valid_VPA")) {
			params = Params_IR_Valid_VPA;
			url= urlIR_Validate_VPA;
		}
		else if(payType.equalsIgnoreCase("RORUpdate_GW_Status")) {
			params = Params_RORUpdate_GW_Status;
			url= urlRORUpdate_GW_Status;
		}
		else if(payType.equalsIgnoreCase("refund_Enque")) {
			RestAssured.baseURI =urlReporting;
			params = Params_Enque_refunds;
			url= urlrefund_Enque;
		}
		else if(payType.equalsIgnoreCase("RORCreate_Payment")) {
			params = Params_RORCreate_Payment;
			url= urlRORCreate_Payments;
		}
		else if(payType.equalsIgnoreCase("Qitaf_SendOTP")) {
			RestAssured.baseURI =urlRewards;
			params = ParamsQitaf_SendOTP;
			url= urlQitaf_SendOTP;
			Reporter.log(urlPay+url);
		}
		else if(payType.equalsIgnoreCase("Qitaf_Redeem")) {
			RestAssured.baseURI =urlRewards;
			params = ParamsQitaf_Redeem;
			url= urlQitaf_Redeem;
			Reporter.log(urlPay+url);
		}
		else if(payType.equalsIgnoreCase("Qitaf_Reverse")) {
			RestAssured.baseURI =urlRewards;
			params = ParamsROR_Reverse;
			url= urlQitaf_Reverse;
			Reporter.log(urlPay+url);
			System.out.println(urlRewards+url);
		}
		
		/*
		else if(payType.equalsIgnoreCase("RORCreate_ProfileList")) {
			params = Params_RORCreate_Profile_List;
			url= urlRORCreate_Profile_List;
		}*/
		else if(payType.equalsIgnoreCase("ROR_Search_ProfileList")) {
			params = Params_RORSearch_Profile_List;
			url= urlRORSearch_Profile_List;
		}
		else if(payType.equalsIgnoreCase("ROR_Create_Refunds")) {
			String ranno = getDateTime(1, "mmddss");
			params = Params_RORCreate_Refund+"5"+ranno+"}";
			url= urlRORCreate_Refunds;
		}
	
		else if(payType.equalsIgnoreCase("ROR_Recon")) {
			String ranno = getDateTime(1, "mmddss");
			params = ParamsROR_Recon+"6"+ranno+"}";	
			url= urlRORRecon;
		}
		
		else if(payType.equalsIgnoreCase("SuperCoins_SendOTP")) {

			RestAssured.baseURI =urlRewards;
			params = ParamsSuperCoins_SendOTP;	
			url= urlSuperCoins_SendOTP;
			Reporter.log(urlRewards+url);
		}

		else if(payType.equalsIgnoreCase("SuperCoins_ValidateOTP")) {

			RestAssured.baseURI =urlRewards;
			params = ParamsSuperCoins_ValidateOTP+payType1+ParamsSuperCoins_ValidateOTP1;	
			url= urlSuperCoins_ValidateOTP;
			Reporter.log(urlRewards+url);
		}
		
		else if(payType.equalsIgnoreCase("SuperCoins_Unhold")) {

			RestAssured.baseURI =urlRewards;
			params = ParamsSuperCoins_Unhold;	
			url= urlSuperCoins_Unhold;
			Reporter.log(urlRewards+url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_CheckBalance")) {

			RestAssured.baseURI =urlRewards;
			params = ParamsSuperCoins_CheckBalance;	
			url= urlSuperCoins_CheckBalance;
			Reporter.log(urlRewards+url);
		}

		
		else if(payType.equalsIgnoreCase("SuperCoins_CreatePromo")) {

			RestAssured.baseURI =promoURL;
			params = ParamsSuperCoins_CreatePromo+payType1+ParamsSuperCoins_CreatePromo1;	
			url= urlSuperCoins_CreatePromo;
			Reporter.log(promoURL+url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_UpdatePromo")) {

			RestAssured.baseURI =promoURL;
			params = ParamsSuperCoins_UpdatePromo+payType1+ParamsSuperCoins_UpdatePromo1;	
			url= urlSuperCoins_UpdatePromo;
			Reporter.log(promoURL+url);
		}
		
		else if(payType.equalsIgnoreCase("SuperCoins_ActivatePromo")) {

			RestAssured.baseURI =promoURL;
			params = "";	
			url= urlSuperCoins_ActivatePromo;
			Reporter.log(promoURL+url);
			//headersForms_Promo_Activate
		}
		
		Reporter.log(urlPay+url);
		Reporter.log("Params :" +params);
		request = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return request;			
	}


	public Response walletPost(String payType, String payType1) {
		RestAssured.baseURI =urlWallet;
		String url = null;
		String params = null;
		//HashMap<String, Object> headers = new headersForms_Wallet_TOA<>();

		HashMap<String, Object> headersFormsWalletUI = new HashMap<>();
		headersFormsWalletUI= headersForms_Wallet_TOA();
		Response resp = null;

		if(payType.equalsIgnoreCase("WALLET_TOA")){
			url = urlWallet + url_walletTOA;
			String paramsTOA = "{\"user_id\":\"65222417\",\"currency\":\"INR\",\"amount\":100.0,\"trip_ref\":\"Q2308251236\",\"event_type\":\"TOA\",\"wallet_type\":\"REWARD\"}";
			resp = RestAssured.given().when().log().all().body(paramsTOA).headers(headersFormsWalletUI).post(url);
		}


		Reporter.log(promoURL+url);
		Reporter.log("Params :" +params);
		return resp;
	}

	public Response promoPost(String payType, String payType1) {
		RestAssured.baseURI =promoURL;
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		Response resp = null;
		trip_refPromo.add(API_PaymentCommon1.tripRefForPromo());
		if(payType.equalsIgnoreCase("")) {
			params = "";
			url= "";
		}

		else if(payType.equalsIgnoreCase("CreatePromo")){
			url = promoURL + endPointCreatePromo;
			String trip_ref =trip_refPromo.get(0);
			String paramCreatePromo = "{\"user_id\":41649008,\"trip_ref\": \"" +trip_ref+ "\",\"type\":\"AIR_BOOKING\",\"promotions\":[{\"amount\":336,\"currency\":\"INR\",\"expiry_date\":\"11-12-2020\",\"trigger_date\":\"22-10-2020\"},{\"amount\":500,\"currency\":\"INR\",\"expiry_date\":\"11-12-2021\",\"trigger_date\":\"22-10-2020\"},{\"amount\":120,\"currency\":\"INR\",\"expiry_date\":\"11-12-2021\",\"trigger_date\":\"22-10-2021\",\"wallet\":\"OLA\",\"mobile\":\"9986696785\",\"email\":\"test@test.com\"}]}";
			params = paramCreatePromo;
			headers = headersForms();
			resp=RestAssured.given().when().log().all().body(params).headers(headers).post(url);
		}

		else if(payType.equalsIgnoreCase("CreatePromoGroup")){
			url = promoURL + endPointCreatePromo;
			String trip_ref = trip_refPromo.get(1);
			String paramCreatePromoGroup = "{\"user_id\":65176819,\"trip_ref\":\""+trip_ref+"\",\"type\":\"AIR_BOOKING\",\"promotions\":[{\"amount\":10,\"currency\":\"INR\",\"expiry_date\":\"14-02-2021\",\"trigger_date\":\"16-12-2020\"},{\"amount\":150,\"currency\":\"INR\",\"expiry_date\":\"15-12-2020\",\"trigger_date\":\"17-12-2019\",\"promo_type\":\"OLA\"},{\"amount\":20,\"currency\":\"INR\",\"expiry_date\":\"16-12-2020\",\"trigger_date\":\"16-01-2020\",\"promo_type\":\"OLA\"}]}";
			params = paramCreatePromoGroup;
			headers = headersForms();
			resp = RestAssured.given().when().log().all().body(params).headers(headers).post(url);
		}

		else if(payType.equalsIgnoreCase("ActivatePromo")){
			String trip_ref = trip_refPromo.get(0);
			
			//String endPointActivatePromo = "/promoservice/v1/promogroups/" + trip_ref;
			String endPointActivatePromo = "/promoservice/v1/promogroups/Q201215869448";
			url = promoURL + endPointActivatePromo;
			headers = headerFormsPromoService();
			resp=RestAssured.given().when().log().all().headers(headers).post(url);
		}

		else if(payType.equalsIgnoreCase("UpdatePromo")){
			int listSize = trip_refPromo.size(); 
			String trip_ref = trip_refPromo.get(listSize-1);
			url = promoURL + endPointUpdatePromo;
			headers = headersForms();
			String paramUpdatePromo = "{\"user_id\":41649008,\"trip_ref\": \"" +trip_ref+ "\",\"type\":\"AIR_BOOKING\",\"promotions\":[{\"amount\":336,\"currency\":\"INR\",\"expiry_date\":\"02-11-2020\",\"trigger_date\":\"01-10-2019\"},{\"amount\":500,\"currency\":\"INR\",\"expiry_date\":\"11-11-2020\",\"trigger_date\":\"01-20-2019\"}]}";
			params = paramUpdatePromo;
			resp = RestAssured.given().when().log().all().body(params).headers(headers).post(url);
		}


		Reporter.log(promoURL+url);
		Reporter.log("Params :" +params);
		return resp;			
	}

	public Response DAGet(String Type, String Type1){
		RestAssured.baseURI = urlDA;
		String url = null;
		HashMap<String, Object> headers = new HashMap<String,Object>();
		headers = headersForms();
		Response request;
		if(Type.equalsIgnoreCase("DABalance")){
			url = urlDA_Balance;
		}else if(Type.equalsIgnoreCase("DAStatus")){
			url = urlDA_Status;
		}
		else if(Type.equalsIgnoreCase("DAFK_FetchBy_TripID")){
			RestAssured.baseURI = urlPay;
			url = urlDA_FK_FetchBy_TripID;
		}
		else if(Type.equalsIgnoreCase("DAFK_FetchBy_PaymentID")){
			RestAssured.baseURI = urlPay;
			url = urlDA_FK_FetchBy_PaymentID;
		}
		
		
		request = RestAssured.given().
				when().
				log().all().
				headers(headers).
				get(url);

		Reporter.log(urlDA+url);
		return request;
	
	}
	
	public Response fetchrefunds(String refundType, String payType1) {
		RestAssured.baseURI = urlFetchRefunds;
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<String,Object>();
		headers = headersForms();
		Response request;
		if(refundType.equalsIgnoreCase("RefundsTrip")){
			url = urlRefundsTrip;
			params=ParamsFetchRefund;
		}
		else if(refundType.equalsIgnoreCase("RefundsTripRef")){
			url = urlRefundsTripRef;
			params=ParamsFetchRefundByTripRef;
		}
		
		Reporter.log(url);
		Reporter.log("Params :" +params);
		request = RestAssured.given().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return request;
	}
		
	public Response promoGet(String payType, String payType1){
		RestAssured.baseURI = promoURL;
		String url = null;
		HashMap<String, Object> headers = new HashMap<String,Object>();
		headers = headersForms();
		Response request;
		if(payType.equalsIgnoreCase("")){
				url = "";
		}

		else if(payType.equalsIgnoreCase("PromoTripRefAndId")){
			url = promoURL + endPointPromotriprefandid;
		}

		else if(payType.equalsIgnoreCase("PromoGroupFromPromoRef")){
			url = promoURL + endPointPromoGroupPromoRef;
		}
		
		else if(payType.equalsIgnoreCase("Promo_Active_Cron")){
			url = promoURL + endPointPromo_Cron;
		}

		else if(payType.equalsIgnoreCase("PromoFromTripRef")){
			url = promoURL + endPointPromoGroupTripRef;
		}

		else if(payType.equalsIgnoreCase("PromoFromPromoId")){
			url = promoURL + endPointPromoFromPromoId;
		}

		else if(payType.equalsIgnoreCase("PromoGroupsFromCreatedDate")){
			url = promoURL + endPointPromoGroupsFromCreatedDate;
		}

		else if(payType.equalsIgnoreCase("PromoGroupsForAUpdatedDate")){
			url = promoURL + endPointPromoGroupsForAUpdatedDate;
		}

		else if(payType.equalsIgnoreCase("PromoGroupsForACreatedAndUpdatedDate")){
			url = promoURL + endPointPromoGroupsForACreatedAndUpdatedDate;
		}

		Reporter.log(promoURL+url);
		request = RestAssured.given().
				when().
				log().all().
				headers(headers).
				get(url);

		return request;
	}

	public Response rearchPayment(String payType, String payType1){
		RestAssured.baseURI =urlPay;
		String url = urlPayV3;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;	 
		if(payType.equalsIgnoreCase("VALIDATE")) {
			params = paramsCC;
			url= urlPayValidateV3;
		}
		else if(payType.equalsIgnoreCase("CC")) {
			params = paramsCC;
		}
		else if(payType.equalsIgnoreCase("CCVISA")) {
			params = paramsCCVISA;
		}
		//V2 pay DA
		else if(payType.equalsIgnoreCase("DA")) {
			url = urlPayV2;
			params = paramsDA;
		}
		else if(payType.equalsIgnoreCase("DAPay")) {
			url = urlPayV3;
			params = paramsDAPayV3;
		}
		else if(payType.equalsIgnoreCase("DAPayFK")) {
			url = urlPayV3;
			params = paramsDAPayV3FK;
		}
		else if(payType.equalsIgnoreCase("DAPayFK6000")) {
			url = urlPayV3;
			params = paramsDAPayV3FK6000;
		}
		else if(payType.equalsIgnoreCase("DAPayFKAmend")) {
			url = urlPayV3;
			params = paramsDAPayV3Amend;
		}
		else if(payType.equalsIgnoreCase("DAPayFKZeroAmt")) {
			url = urlPayV3;
			params = paramsDAPayV3ZeroAmt;
		}
		else if(payType.equalsIgnoreCase("DAPayAsync")) {
			url = urlPayV3;
			params = paramsDAPayV3Async;
		}
		else if(payType.equalsIgnoreCase("DAFKRefundCreate")) {
			Random rand = new Random();
			int rand_int = rand.nextInt(999999);
			RestAssured.baseURI =urlPay;
			url = urlFKRefundCreate;
			params = params_FK_Refund1+rand_int+"}";
		}
		else if(payType.equalsIgnoreCase("DAFKRefundUpdatePartnerinfo")) {
			RestAssured.baseURI =urlReporting;
			url = urlFKRefundUpdatePartnerInfo;
			params = params_FK_Refund_Update_PartnerInfo;
		}
		else if(payType.equalsIgnoreCase("DAFKRefundStatusUpdate")) {
			RestAssured.baseURI =urlReporting;
			url = urlFKRefundStatusUpdate;
			params = params_FK_Refund_Status_Update;
		}
		
		
		
		
		
		
		else if(payType.equalsIgnoreCase("EMIFetch")) {
			url = url_EMI_Fetch;
			params = paramsEMI1+payType1+paramsEMI2;
		}
		

		else if(payType.equalsIgnoreCase("DAVAlidate")) {
			url = urlPayValidateV3;
			params = paramsDAValidateV3;
		}
		else if(payType.equalsIgnoreCase("DARefund")) {
			Reporter.log(urlDA+url);
			RestAssured.baseURI =urlDA;
			url = urlDA_Refund;
			params = paramsDA_Refund;
		}
		
		else if(payType.equalsIgnoreCase("CSPay")) {
			//RestAssured.baseURI =urlCS;
			url = urlCS_Pay;
			params = paramsCSPayvalidate;
		}
		else if(payType.equalsIgnoreCase("CSValidate")) {
			//RestAssured.baseURI =urlCS;
			url = urlCS_Validate;
			params = paramsCSPayvalidate;
		}

		else if(payType.equalsIgnoreCase("GV")) {
			params = paramsGV;
		}else if(payType.equalsIgnoreCase("GVSCLP")) {
			params = paramsGVSCLP;
		}else if(payType.equalsIgnoreCase("WALLET")) {
			params = paramsWallet;
		}else if(payType.equalsIgnoreCase("CCGVWL")) {
			params = paramsCCGVWL;
		}else if(payType.equalsIgnoreCase("GVWL")) {
			params = paramsGVWL;
		}
		else if(payType.equalsIgnoreCase("FLYIN")) {
			RestAssured.baseURI =urlPay;
			url = urlPayFlyin;
			params = paramsFlyIN;
			Reporter.log(urlFlyin+url);
		}

		Reporter.log(urlPay+url);
		Reporter.log("Params : "+params);
		request = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return request;
	}

	public Response createGV(int Amount) {
		RestAssured.baseURI =urlWallet;
		String params = paramsGV_Create_10;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms_GVCreate_10();
		if (Amount==5000) {
			params = paramsGV_Create_5000;
			headers = new HashMap<>();
			headers = headersForms_GVCreate_5000();
		}
		else if (Amount==10000) {
			params = paramsGV_Create_10000_CLP;
			headers = new HashMap<>();
			headers = headersForms_GVCreate_10000();
		}
		Response request = null;	 

		String url= urlEndpoint_GVCreate;
		Reporter.log(urlWallet+url);
		Reporter.log("Params : "+params);
		request = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);	
		return request;

	}

	public Response createGVSCLP(int Amount) {
		RestAssured.baseURI =urlWallet;

		HashMap<String, Object> headers = new HashMap<>();
		String params = paramsGV_Create_10_SCLP;
		if(Amount==10) {
			 params = paramsGV_Create_10_SCLP;
			headers = headersForms_GVCreate_1000();
		}
		else if (Amount==10000){
			 params = paramsGV_Create_10000_SCLP;
			headers = headersForms_GVCreate_10000();
		}
		else if (Amount==1000){
			params = paramsGV_Create_10000_SCLP;
			headers = headersForms_GVCreate_10000();
		}
		Response request = null;

		String url= urlEndpoint_GVCreate;
		Reporter.log(urlWallet+url);
		Reporter.log("Params : "+params);
		request = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return request;

	}

	@SuppressWarnings("deprecation")
	public Response rearch_SmilesAuth(String payType, String payType1){
		RestAssured.baseURI =URL_SmilesDev;
		Reporter.log(URL_SmilesDev);
		String url = URL_SmilesDev_Parm;
		String params = Param_Smiles_Auth;
		//httpRequest.header("Authorization", "8b7a2f7cd440989594c95cbdf7398bec" + "03cc2c7605899394907ad1e282f2aa75")
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersFormsSmiles();

		Response request = null;	 

		request = RestAssured.given().
				when().
				log().all().
				headers(headers).
				body("data-raw grant_type=client_credentials&scope=apioauth").

				post(url);

		return request;
	}

/*	public Response rearch_Smiles(String payType, String payType1){
		RestAssured.baseURI =urlPay;
		Reporter.log(urlPay);
		String url = urlPayV3;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;	 
		if(payType.equalsIgnoreCase("GenrateAuth")) {
			params = paramsCC;
			url= urlPayValidateV3;
		}

		return request;
	}*/

	@SuppressWarnings("null")
	public String[] getGV(int Amount) {

		String GVdetails[] = {"0","0","0"} ;
		Response resp = null;
		resp = createGV(Amount);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		//System.out.println("Response body : "+ resp.body().asString());
		GVdetails[0] = jsonPathEvaluator.getString("gvNumber");
		GVdetails[1] = jsonPathEvaluator.getString("gvPin");
		GVdetails[2] = jsonPathEvaluator.getString("balance");
		return GVdetails;

	}

	@SuppressWarnings("null")
	public String[] getGVSCLP(int Amount) {

		String GVdetails[] = {"0","0","0"} ;
		Response resp = null;
		resp = createGVSCLP(Amount);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		System.out.println("Response body : "+ resp.body().asString());
		GVdetails[0] = jsonPathEvaluator.getString("gvNumber");
		GVdetails[1] = jsonPathEvaluator.getString("gvPin");
		GVdetails[2] = jsonPathEvaluator.getString("balance");
		return GVdetails;

	}

	public String[] getGVCLP(int Amount) {

		String GVdetails[] = {"0","0","0"} ;
		Response resp = null;
		resp = createGV(Amount);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		GVdetails[0] = jsonPathEvaluator.getString("gvNumber");
		GVdetails[1] = jsonPathEvaluator.getString("gvPin");
		GVdetails[2] = jsonPathEvaluator.getString("balance");
		return GVdetails;

	}

	public Response rearchWallet(String payType, String payType1){
		RestAssured.baseURI =urlWallet;
		Reporter.log(urlWallet);
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		HashMap<String, Object> headersWallet = new HashMap<>();
		headersWallet = headersFormsWallet();
		HashMap<String, Object> headersFormsNew = new HashMap<>();
		headersFormsNew= headersFormsNew();
		HashMap<String, Object> headersFormsNew1 = new HashMap<>();
		headersFormsNew1= headersFormsNew1();

		HashMap<String, Object> headersFormsPromoUpdate = new HashMap<>();
		headersFormsPromoUpdate= headersForms_Promo_Update();

		HashMap<String, Object> headersFormsWalletUI = new HashMap<>();
		headersFormsWalletUI= headersForms_Wallet_UI();

		HashMap<String, Object> headersFormsPromoActivate = new HashMap<>();
		headersFormsPromoActivate= headersForms_Promo_Activate();

		Response request = null;	 
		if(payType.equalsIgnoreCase("PROMOUSED")) {
			url= urlEndPoint_Wallet_PromoUsed;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		

		else if(payType.equalsIgnoreCase("GETWALLET_Refund_Stop_Tnx")) {
			RestAssured.baseURI =urlReporting;
			//RestAssured.baseURI =urlPay;
			url= urlEndPoint_Wallet_Refund_Stop_Trnx;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_UpdatePromo")) {
			RestAssured.baseURI =promoURL;
			params = ParamsSuperCoins_UpdatePromo+payType1+ParamsSuperCoins_UpdatePromo1;	
			url= urlSuperCoins_UpdatePromo;
			Reporter.log(promoURL+url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsPromoUpdate).
					get(url);
		}
		else if(payType.equalsIgnoreCase("SuperCoins_ActivatePromo")) {
			RestAssured.baseURI =promoURL;
			params = "";	
			url= urlSuperCoins_ActivatePromo;
			Reporter.log(promoURL+url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsPromoActivate).
					get(url);
		}
	
		
		else if(payType.equalsIgnoreCase("REVERTPROMO")) {
			url= urlEndPoint_Wallet_RevertPromo;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					post(url);
		}
		else if(payType.equalsIgnoreCase("REVERTPROMONEW")) {
			url= urlEndPoint_Wallet_RevertPromoNew;
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsNew1).
					param(paramsWalletrevertPromo).
					post(url);
		}
		else if(payType.equalsIgnoreCase("REVERTEDPROMO")) {
			url= urlEndPoint_Wallet_RevertedPromo;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		
		else if(payType.equalsIgnoreCase("GETDEDUCTION")) {
			url= urlEndPoint_Wallet_GetDeduction;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("GETWALLET_Trnx")) {
			url= urlEndPoint_Wallet_GetWallet_Trnx;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("GETWALLET_Details_UI")) {
			RestAssured.baseURI =url_QA2;
			url= urlEndPoint_Wallet_GetWallet_Details_UI; // 5123412348 / 65243646
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsWalletUI).
					get(url);
		}

		else if(payType.equalsIgnoreCase("GETWALLET_Trnx_UI")) {
			RestAssured.baseURI =url_QA2;
			url= urlEndPoint_Wallet_GetWallet_Trnx_UI;
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsWalletUI).
					get(url);
		}
		else if(payType.equalsIgnoreCase("CASHBACK_DETAILS")) {
			url= urlEndPoint_Wallet_CASHBACK_DETAILS;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("GETWALLET_Trnx_UI")) {
			RestAssured.baseURI = url_QA2;
			url = urlEndPoint_Wallet_GetWallet_Trnx_UI;
			request = RestAssured.given().
					when().
					log().all().
					headers(headersFormsWalletUI).
					get(url);
		}
		else if(payType.equalsIgnoreCase("GETWALLET_ALL")) {
			url= urlEndPoint_Wallet_GETWALLET_ALL;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("GETWALLET_INR")) {
			url= urlEndPoint_Wallet_GETWALLET_INR;
			Reporter.log(url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("GETWALLET_INR2")) {
			url= urlEndPoint_Wallet_GETWALLET_INR2;
			Reporter.log(url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}else if(payType.equalsIgnoreCase("GETWALLET_V2_INR")) {
			url= urlEndPoint_Wallet_GETWALLET_V2_INR;
			Reporter.log(url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					post(url);
		}	
		else if(payType.equalsIgnoreCase("CASHBACK_DETAILS_WALLET")) {
			url= urlEndPoint_Wallet_CASHBACK_Wallet;
			Reporter.log(url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}	
		else if(payType.equalsIgnoreCase("WALLET_CREATE")) {
			url= urlEndPoint_Wallet_Create;
			params =paramWalletCreate;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params).
					post(url);
		}else if(payType.equalsIgnoreCase("WALLET_Fetch")) {
			RestAssured.baseURI ="http://qa2new.cleartrip.com";
			url= urlEndPoint_Wallet_FetchQA;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}else if(payType.equalsIgnoreCase("WALLET_Fetch_LoggedIN")) {
			RestAssured.baseURI ="http://qa2new.cleartrip.com";
			url= urlEndPoint_Wallet_FetchQA;
			request = RestAssured.given().
					when().
					log().all().
					headers(headersWallet).
					cookie("ct-auth", "EVefRmmOWPSC8c9sPGbZGwZMgfl%2FLjP6yfQQAwhPONaOOIjRmfrMO5ubb5%2FGLWzguQmW3NiUZma8q2lELnUuyC3uAF5DaTQONdJlLn%2FO2me%2FiLCzDjUE8Mm7nMigogz0z84lf%2Bili9Xzawt1KbN%2FMNpQDroZvb3Q7ub%2BLj1YfofQs%2BDG9mD5DXvLFNSWqYz93GfvGpnfyFmIRy226HjYgQ%3D%3D").
					get(url);
		}
		else if(payType.equalsIgnoreCase("Saved_PaymentModes")) {
			RestAssured.baseURI =url_QA2;
			url= urlSavedPaymentModes_UI;
			Reporter.log(url_QA2+url);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					cookie("ct-auth", "hw%2Fzn67oakJZkXnJoxIeIjfl2qOnHQRRNnqN7AQQ%2FxQ26Kin9hQIigot%2F0Xrgh84j9O3UYZZi4zJRwF%2Bio21NJjJfVdGhDt6EBXP56tMKTFEH0OuwGlEszc72Fq4WLhXmtL9BcVMk55ioGmyMvRjeRfO1jD%2FuIPrjNiVlyI87b4%3D").
					get(url);
		}

		Reporter.log(urlWallet+url);
		Reporter.log("Params : "+params);

		return request;
	}


	public Response prodAPIs(String payType, String payType1){
		String url = null;
		String endpointurl = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;	  

		if(payType.equalsIgnoreCase("Rwd_PayBack_Mobile")) {
			endpointurl = Prod_Url_Rewards;
			RestAssured.baseURI =endpointurl;
			url= Prod_Url_EndPoint_Rewards_PayBack_Mobile;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		if(payType.equalsIgnoreCase("Rwd_ADCB_Balance")) {
			endpointurl = Prod_Url_Rewards;
			RestAssured.baseURI =endpointurl;
			url= Prod_Url_EndPoint_Rewards_ADCB_Balance;
			params=Prod_Params_Rewards_ADCB_Balance;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params).
					post(url);
		}
		else if(payType.equalsIgnoreCase("Wallet_Get_Currency")) {
			endpointurl = Prod_Url_Wallet;
			RestAssured.baseURI =endpointurl;
			url= Prod_Url_EndPoint_Wallet_getWallet;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("Pay_Get_TW_Wallets")) {
			endpointurl = Prod_Url_PaymentService;
			RestAssured.baseURI =endpointurl;
			url= Prod_Url_EndPoint_Get_TP_Wallets;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("Promo_Get_Group")) {
			endpointurl = Prod_Url_Promo;
			RestAssured.baseURI =endpointurl;
			url= Prod_Url_EndPoint_Promo_Group;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("Bin_Get_CardInfo")) {
			endpointurl = "https://www.cleartrip.com";;
			RestAssured.baseURI =endpointurl;
			url= "/binmanager/v1/payment/cards?bin=552260";
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("ActiveNB")) {
			endpointurl = Prod_Url_PaymentService;
			RestAssured.baseURI =endpointurl;
			url = Prod_Url_ActiveNB;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("GetPaymentStatus")) {
			endpointurl = Prod_Url_PaymentService;
			RestAssured.baseURI =endpointurl;
			
			url = Prod_Url_PaymentStatus;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("ActiveCardTypes")) {
			endpointurl = Prod_Url_PaymentService;
			RestAssured.baseURI =endpointurl;
			
            url = Prod_Url_ActiveCardType;
            request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		Reporter.log(endpointurl+url);
		Reporter.log("Params : "+params);
        return request;
	}

	public Response rearchGV(String payType, String payType1) throws ClassNotFoundException, SQLException{
		ArrayList<String> db_GV = db_GV();
		String GVID = db_GV.get(1);
		RestAssured.baseURI =urlWallet;
		Reporter.log(urlWallet);
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;	 
		if(payType.equalsIgnoreCase("GET")) {
			url= urlEndPoint_GV_Get;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equalsIgnoreCase("REFUND")) {
			url= urlEndPoint_GV_Refund;
			params = ParamsGV_Refund;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params).
					post(url);
		}
		else if(payType.equalsIgnoreCase("CAPTURE")) {
			url= urlEndPoint_GV_CAPTURE;
			params = ParamsGV_CAPTURE+"43852510"+ParamsGV_CAPTURE1;
			//System.out.println(params);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params).
					post(url);
		}

		else if(payType.equalsIgnoreCase("CREATE")){
			url= urlEndpoint_GV_GET;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);

		}

		Reporter.log(urlWallet+url);
		Reporter.log("Params : "+params);
		return request;


	}


	public Response rearchGV_UI(String payType, String GVNumber, String GVPin) throws ClassNotFoundException, SQLException {
		RestAssured.baseURI = urlWallet;
		Reporter.log(urlWallet);
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;
		if(payType.equalsIgnoreCase("VALIDATESCLPGV_UI")) {
			Url= urlEndPoint_GV_SCLP_VALIDATE;
			params = paramsGV_GET_SCLP_VALIDATE;
			//String params1 = "{\"amount\":1.0,\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"";
			String params1 = "{\"amount\":1.1,\"currency\":\"INR\",\"productType\":\"DOMESTIC-AIR\",\"tripRef\":\"Q243333333\",\"giftVoucherDetail\":{\"cardNumber\":\"";
			String params2 = "\",\"cardPin\":\"";
			String params3  = "\"},\"customerDetail\":{\"firstName\":\"Test\",\"lastName\":\"Test\",\"mobile\":\"1121212122\"}}";
			params = params1+GVNumber+params2+GVPin+params3;
			System.out.println(params);
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("CAPTURESCLPGV_UI")) {
			Url= urlEndPoint_GV_SCLP_CAPTURE;
			String params1 = "{\"cardNumber\":\"";
			String params2 = "\",\"cardPin\":\"";
			String params3  = "\",\"amount\":1.0,\"currency\":\"INR\",\"paymentId\":45246590}";
			params = params1+GVNumber+params2+GVPin+params3;
			System.out.println(params);

			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		return request;
	}

	public Response rearchGV1(String payType, String payType1) throws ClassNotFoundException, SQLException{
		RestAssured.baseURI =urlWallet;
		Reporter.log(urlWallet);
		String url = null;
		String params = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;	 
		if(payType.equalsIgnoreCase("GET")) {
			url= urlEndPoint_GV_Get;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(payType.equalsIgnoreCase("CAPTURESCLPGV")) {
			Url= urlEndPoint_GV_SCLP_CAPTURE;
			params = paramsGV_GET_SCLP_CAPTURE;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("GVSCLPGETEXPIRY")) {
			Url= urlEndPoint_GV_SCLP_EXPIRY;
			params = paramsGV_GET_SCLP_EXPIRY;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("VALIDATELISTGVSCLP")) {
			Url= urlEndPoint_GV_SCLP_VALIDATE_LIST;
			params = paramsGV_GET_SCLP_VALIDATE_LIST;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("VALIDATESCLPGV")) {
			Url= urlEndPoint_GV_SCLP_VALIDATE;
			params = paramsGV_GET_SCLP_VALIDATE;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}


		else if(payType.equalsIgnoreCase("VALIDATEINSUFFSCLPGV")) {
			Url= urlEndPoint_GV_SCLP_VALIDATE;
			params = paramsGV_GET_SCLP_VALIDATE_INSUFFICENT;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPGENDOM")) {
			Url= urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_GENDOM;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPGENINTL")) {
			Url= urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_GENINTL;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("GETSCLPGENHOTEL")) {
			Url= urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_GENHOTEL;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPDOMAIR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_DOMAIR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPINTLAIR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_INTLAIR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("GETSCLPHOTEL")) {
			Url= urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_HOTEL;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPHOTELERR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_HOTEL_ERR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}

		else if(payType.equalsIgnoreCase("GETSCLPDOMAIRERR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_DOMAIR_ERR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("GETSCLPINTLAIRERR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_INTLAIR_ERR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		else if(payType.equalsIgnoreCase("GETSCLPBUSERR")) {
			Url = urlEndPoint_GV_GetSCLP;
			params = paramsGV_GET_SCLP_BUS_ERR;
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}


		Reporter.log(urlWallet+url);
		Reporter.log("Params : "+params);
		return request;
	}

	public Response rearchPaymentOTP(String payType, String payType1, String paymentID){
		RestAssured.baseURI =urlPay;
		String params = null;
		String Url = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response response;

		if(payType.equalsIgnoreCase("INIT")) {
			params = paramsInit;
			Url = urlInit ;

		}else if(payType.equalsIgnoreCase("PROCESS")) {
			params  = "{\"payment_id\":"+paymentID+",\"otp_gateway_id\":51,\"otp\":\"123456\"}";
			Url = urlProcess;
		}else if(payType.equalsIgnoreCase("RESEND")) {
			params = "{\"payment_id\":"+paymentID+",\"otp_gateway_id\":51}";

			Url = urlResend;
		}
		Reporter.log(urlPay);
		Reporter.log(Url);
		response = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(Url);
		Reporter.log(urlPay+Url);
		Reporter.log("Params : "+params);
		return response;
	}

	public Response ola(String payType, String payType1, String promoID) throws Exception {
		RestAssured.baseURI = urlPay;
		String params = null;
		String Url = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response response = null;
		if(payType.equalsIgnoreCase("Validate")){
			params = ParamsOLAValidate1+promoID+ParamsOLAValidate2;
			Url = urlOLA_Validate;
		}
		else if(payType.equalsIgnoreCase("pay")){
			params = ParamsOLAValidate1+promoID+paramsOLAPay;
			Url = urlOLA_Pay;
		}
		else if(payType.equalsIgnoreCase("Stat")){
			promoID ="PS"+promoID;
			Url = urlOLA_CheckStat+promoID;
			response = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(Url);
		}
		else if(payType.equalsIgnoreCase("PromoStatus")) {				
			Url = promoURL+urlOLA_PromoGroup;
			//String trip = getRandomNo(99999999);
			Random rand = new Random();
			int n = rand.nextInt(9999999);
			String trip = Integer.toString(n);

			params = ParamsOLAPromoGroup1+trip+ParamsOLAPromoGroup2;
			Reporter.log(Url);
			Reporter.log(params);
		}			
		if(!payType.equalsIgnoreCase("Stat")){
			response = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(Url);
		}
		Reporter.log(urlPay);
		Reporter.log(Url);
		Reporter.log("Params : "+params);
		////System.out.println(response.body().asString());
		return response;

	}

	public Response BinDetail(String url, String params){
		String baseurl=urlCardInfo_Service;
		RestAssured.baseURI =baseurl;
		Reporter.log(baseurl);
		String url1 = null;
		String params1 = null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request = null;	 
		if(url.equalsIgnoreCase("ADD_MC_Credit")&&params.equalsIgnoreCase(Params_Singlebincard_Credit)) { 
			url1= baseurl+url_Singlebincard;
			params1=returnParamForBin_CC();
			request = RestAssured.given().
					when().
					log().all(). 
					headers(headers).
					body(params1).
					post(url1);
		}
		else if(url.equalsIgnoreCase(baseurl+url_Singlebincard)&&params.equalsIgnoreCase("Params_Singlebincard_Debit")) {
			url1= baseurl+url_Singlebincard;
			params1=params;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params1).
					post(url1);
		}
		else if(url.equalsIgnoreCase("CAPTURE")) {
			url= urlEndPoint_GV_CAPTURE;
			params = ParamsGV_CAPTURE;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					body(params).
					post(url);
		}
		else if(url.equalsIgnoreCase("GetCard")) {
			url= "v1/payment/cards?bin=512345";
			params = ParamsGV_CAPTURE;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}

		else if(url.equalsIgnoreCase("GetCard_Multi")) {
			url= baseurl + endPointCardMulti;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		Reporter.log(urlCardInfo_Service+url);
		Reporter.log(url);
		return request;
	}

	public Response validationforbindetail(String url,Response resp){
		Reporter.log(resp.asString());
		//System.out.println(resp.asString());
		int statusCode = resp.getStatusCode();	
		Reporter.log("statusCode: " + statusCode);
		if(statusCode!=200) {
			Reporter.log("statusCode =" +statusCode);
			Assert.assertFalse(true);
		}
		String bodyAsString=resp.asString(); 
		JsonPath jsonPath = new JsonPath(bodyAsString);
		if(url.equalsIgnoreCase("ADD_Card"))
		{
			String description = jsonPath.getString("description");
			String status=jsonPath.getString("status");
			Assert.assertNotNull(description);
			//			Assert.assertEquals("true", "false");;
			Assert.assertNotNull(bodyAsString.contains("cardInfoRequest"));
			Assert.assertNotNull(bodyAsString.contains("cardInfoFromDb"));
			/*Assert.assertEquals("Response boday contains Successfully added", true ,bodyAsString.contains("Successfully added"));
			Assert.assertEquals("Response boday contains card_type", true ,bodyAsString.contains("card_type"));
			Assert.assertEquals("Response boday contains bin", true ,bodyAsString.contains("bin"));
			Assert.assertEquals("Response boday contains bank", true ,bodyAsString.contains("bank"));
			Assert.assertEquals("Response boday contains country", true ,bodyAsString.contains("country"));
			Assert.assertEquals("Response boday contains issuer_type", true ,bodyAsString.contains("issuer_type"));
			Assert.assertEquals("Response boday contains bank_id", true ,bodyAsString.contains("bank_id"));
			Assert.assertEquals("Response boday contains status", true ,bodyAsString.contains("status"));*/
			if(status.equals("S") && description.equals("Successfully added")){
				Assert.assertTrue(true);
			}
		}
		else if(url.equalsIgnoreCase("Get_Card")) {
			String bin = jsonPath.getString("bin");
			String country = jsonPath.getString("country");
			if(!bin.equalsIgnoreCase("512345")) {
				Reporter.log("bin =" +bin);
				Assert.assertFalse(true);
			}
			if(!country.equalsIgnoreCase("INDIA")) {
				Reporter.log("country =" +country);
				Assert.assertFalse(true);
			}
		} 

		else if(url.equalsIgnoreCase("Get_Card_Multi")){
			if(!bodyAsString.isEmpty())
				Assert.assertTrue(true);
		}
		return resp; 

	}

	public Response validation_MIS(String payType, Response resp) {
		Reporter.log("Response body " + payType + " : " + resp.body().asString());
		System.out.println("Response body " + payType + " : " + resp.body().asString());
		int statusCode = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		String credential_name = jsonPathEvaluator.getString("credential_name");
		String txnID = jsonPathEvaluator.getString("gateway_transaction_id");
		String payment_id = jsonPathEvaluator.getString("payment_id");
		String wallet_number = jsonPathEvaluator.getString("wallet_number");
		String card_numbers = jsonPathEvaluator.getString("card_numbers");

		Reporter.log("credential_name " +credential_name);
		Reporter.log("txnID " +txnID);
			if (statusCode != 200) {
				Assert.assertTrue(false);
			}
			if(payType.equalsIgnoreCase("CC")) {
				if(!credential_name.equals("[RAZORPAY_V2_TEST]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[order_KrM5PYVcQJSZa1]")) {
					Assert.assertTrue(false);
				}
			}
			else if(payType.equalsIgnoreCase("DC")) {
				if(!credential_name.equals("[TEST]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[20221208111212800110168173404295906]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("NB")) {
				if(!credential_name.equals("[IN_CCAVENUEV2_hdfc]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[order_KrOsfQsyeeduGO]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("RP_SC")) {
				if (!payment_id.equals("[45240370]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.contains("RP_ADCB")) {
				if(!payment_id.equals("[45125908]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("WT_Rewards")) {
				if(!wallet_number.equals("[3000331040001266]")) {
					Assert.assertTrue(false);
				}if(!payment_id.equals("[45240612]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("WT_Credit")) {
				if(!wallet_number.equals("[7008000020000067, 3000331040001187]")) {
					Assert.assertTrue(false);
				}if(!payment_id.equals("[45240094, 45240092]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("GV")) {
				String payment_ids= jsonPathEvaluator.getString("payment_ids");

				if(!card_numbers.equals("[3000331038009135]")) {
					Assert.assertTrue(false);
				}if(!payment_ids.equals("[45239560]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("PL")) {
				if(!credential_name.equals("[RAZORPAY_PAYLATER_TEST]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[pay_KpLl9BERBOynqh]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("CL_EMI")) {
				if(!credential_name.equals("[RAZORPAY_CARDLESS_EMI_TEST]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[pay_KqyejBvDFaWUcp]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("EMI")) {
				if(!credential_name.equals("[RAZORPAY_V2_TEST]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[order_Kpix1Y9hwymS3w]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("UP")) {
				if(!credential_name.equals("[RAZORPAY]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[pay_KrPQvercdz90PV]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("TW")) {
				if(!credential_name.equals("[AMAZON_WALLET]")) {
					Assert.assertTrue(false);
				}if(!txnID.equals("[S04-6613239-9867572]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("DA")) {
				if (!payment_id.equals("[45240820]")) {
					Assert.assertTrue(false);
				}
			}else if(payType.equalsIgnoreCase("PL_Refund")) {
				if(!credential_name.equals("[null, RAZORPAY_PAYLATER_TEST]")) {
					System.out.println(credential_name);
					Assert.assertTrue(false);
				}if(!txnID.equals("[rfnd_Kh5a011yNfcyRa, rfnd_Kh5mIwZpPhr9n8]")) {
					System.out.println(txnID);
					Assert.assertTrue(false);
				}
			}
		return resp;
	}

	public Response validation(String payType, Response resp){
		Reporter.log("Response body "+payType +" : "+ resp.body().asString());
		System.out.println("Response body "+payType +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(!(payType.equals("WALLET_CREATE")||(payType.equals("IR_Save_VPA")))) {
			if (statusCode != 200) {
				//Assert.assertTrue(false);
			}
		}
		if(payType.equals("Reporting_Pending_Refunds")) {
			if(!(resp.body().asString().contains("Q230907781504"))){
				Assert.assertTrue(false);
			}
		}
		if(payType.equals("EMIRouting")) {
			if(!(resp.body().asString().contains("providerToMonthlyQuotaMap"))){
				Assert.assertTrue(false);
			}
		}
		if(payType.equals("Affor_Eligibility_PL")) {
			JsonPath j = new JsonPath(resp.asString());
			String timedOut = j.getString("timedOut");
			if(timedOut.contains("true")){
				Reporter.log("timeOut "+timedOut);
			}
			else {
				String[] paymentTypeArr = {null, null, null, null, null, null};
				for (int i = 0; i < 5; i++) {
					String paymentType = j.getString("instrument.merchants.paymentTypeType[" + i + "]");
					paymentTypeArr[i] = paymentType;
				}
				for (int i = 0; i <= 6; i++) {
					if (!paymentTypeArr[i].contains("PL")) {
						if (i == 6) {
							Assert.assertTrue(false);
						}
					} else break;
				}
			}
		}
		if(payType.equals("Affor_Eligibility_NCE_V2_PayTM")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value =null;
			type = j.getString("data.call_out_attributes.EMI.ui_attributes.type[0]");
			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			value = j.getString("data.call_out_attributes.PL.ui_attributes.value[1]");
			if(!value.contains("Paytm Postpaid")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE_V2_FKPL")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value =null;
			type = j.getString("data.call_out_attributes.EMI.ui_attributes.type[0]");
			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			value = j.getString("data.call_out_attributes.PL.ui_attributes.value[1]");
			if(!value.contains("Flipkart Pay Later EMI")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE_V2_PL")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value =null;
			type = j.getString("data.call_out_attributes.EMI.ui_attributes.type[0]");
			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			value = j.getString("data.call_out_attributes.PL.ui_attributes.value[1]");
			if(!value.contains("Axio")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE_V2_PayTM_Plans")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value , Proc_Fee=null;
			type = j.getString("call_out_attributes.EMI.ui_attributes.type[3]");
			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			Proc_Fee = j.getString("call_out_attributes.EMI.ui_attributes.value[4]");
			if(!Proc_Fee.contains("A processing fee with applicable taxes will be charged by the Bank for each EMI order")){
				Reporter.log("Proc_Fee "+Proc_Fee);
				Assert.assertTrue(false);
			}
			value = j.getString("call_out_attributes.PL.ui_attributes.value[1]");
			if(!value.contains("Paytm Postpaid")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE_V2_FKPL_Plans")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value, Proc_Fee =null;
			type = j.getString("call_out_attributes.EMI.ui_attributes.type[3]");

			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			Proc_Fee = j.getString("call_out_attributes.EMI.ui_attributes.value[4]");
			if(!Proc_Fee.contains("A processing fee with applicable taxes will be charged by the Bank for each EMI order")){
				Reporter.log("Proc_Fee "+Proc_Fee);
				Assert.assertTrue(false);
			}
			value = j.getString("call_out_attributes.PL.ui_attributes.value[2]");
			System.out.println("value "+value);
			if(!value.contains("with your Flipkart Pay Later EMI")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE_V2_PL_Plans")) {
			JsonPath j = new JsonPath(resp.asString());
			String type, value , Proc_Fee=null;
			type = j.getString("call_out_attributes.EMI.ui_attributes.type[3]");
			if(!type.contains("number")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
			Proc_Fee = j.getString("call_out_attributes.EMI.ui_attributes.value[4]");
			if(!Proc_Fee.contains("A processing fee with applicable taxes will be charged by the Bank for each EMI order")){
				Reporter.log("Proc_Fee "+Proc_Fee);
				Assert.assertTrue(false);
			}
			value = j.getString("call_out_attributes.PL.ui_attributes.value[1]");
			if(!value.contains("IDFC Bank")){
				Reporter.log("type "+type);
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_CLEMI")) {
			String[] paymentTypeArr = {null,null,null,null,null,null};
			JsonPath j = new JsonPath(resp.asString());
			for (int i = 0; i < 5; i++) {
				String paymentType = j.getString("instrument.merchants.paymentTypeType["+i+"]");
				paymentTypeArr[i] = paymentType;
			}
			for (int i = 0; i<=6; i++) {
				if(!paymentTypeArr[i].contains("CL_EMI")){
					if(i==6){
						Assert.assertTrue(false);
					}
				} else break;
			}
		}

		if(payType.equals("Affor_Eligibility_FKPL")) {
			JsonPath j = new JsonPath(resp.asString());
			String timedOut = j.getString("timedOut");
			if(timedOut.contains("true")){
				Reporter.log("timeOut "+timedOut);
			}
			else {
				String[] paymentTypeArr = {null, null, null, null, null, null};
				for (int i = 0; i < 5; i++) {
					String paymentType = j.getString("instrument.merchants.paymentTypeType[" + i + "]");
					paymentTypeArr[i] = paymentType;
				}
				String Status = j.getString("status");
				if(!Status.contains("S")){
					Reporter.log("Status "+Status);
					Assert.assertTrue(false);
				}
				/*for (int i = 0; i <= 6; i++) {
					if (!paymentTypeArr[i].contains("CL_EMI")) {
						if (i == 6) {
							Assert.assertTrue(false);
						}
					} else break;
				}*/
				/*for (int i = 0; i <= 6; i++) {
					if (!paymentTypeArr[i].contains("PL")) {
						if (i == 6) {
							Assert.assertTrue(false);
						}
					} else break;
				}*/
			}

		}
		if(payType.equals("Affor_Eligibility_FKPL_Only")) {
			JsonPath j = new JsonPath(resp.asString());
			String timedOut = j.getString("timedOut");
			if(timedOut.contains("true")){
				Reporter.log("timeOut "+timedOut);
			}
			else {
				String[] paymentTypeArr = {null, null, null, null, null, null};
				for (int i = 0; i < 5; i++) {
					String paymentType = j.getString("instrument.merchants.paymentTypeType[" + i + "]");
					paymentTypeArr[i] = paymentType;
				}
				String Status = j.getString("status");
				if(!Status.contains("S")){
					Reporter.log("Status "+Status);
					Assert.assertTrue(false);
				}
				/*for (int i = 0; i <= 6; i++) {
					if (!paymentTypeArr[i].contains("PL")) {
						if (i == 6) {
							Assert.assertTrue(false);
						}
					} else break;
				}
				for (int i = 0; i <= 6; i++) {
					if (paymentTypeArr[i].contains("CL_EMI")) {
						if (i == 5) {
							Assert.assertTrue(false);
						}
					} else break;
				}*/
			}
		}


		if(payType.equals("Affor_Eligibility_PayTMPostpaid")) {
			JsonPath j = new JsonPath(resp.asString());
			String timedOut = j.getString("timedOut");
			if(timedOut.contains("true")){
				Reporter.log("timeOut "+timedOut);
			}
			else {
				String[] paymentTypeArr = {null, null, null, null, null, null};
					String status = j.getString("instrument.merchants.status");
				if(!status.contains("ELIGIBLE")){
					Reporter.log("ELIGIBLE "+status);
				}
			}
		}

		if(payType.equals("WALLET_TOA")) {
			JsonPath j = new JsonPath(resp.asString());
			String desc = j.getString("description");
			String status = j.getString("status");
			if (!desc.contains("Wallet cashback success") ) {
				Assert.assertTrue(false);
			}if (!status.contains("S")) {
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Eligibility_NCE")) {
			if(!resp.body().asString().contains("{monthly_value}/mo")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("eligibility_list")){
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Plans_NCE_Full")) {
			if(!resp.body().asString().contains("{monthly_value}/mo")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("No Cost EMI from")){
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("EMIBankDetails")) {
			if(!resp.body().asString().contains("Kotak Mahindra Bank")){
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("EMI_Juspay_GetPlans")) {
			if(!resp.body().asString().contains("offer_MXub89rjoAnoqy")){
				Assert.assertTrue(false);
			}
			JsonPath j = new JsonPath(resp.asString());
			String credentialName = j.getString("emiSubventionList.emiSubventionGatewayMapping.credentialName");
			if (!credentialName.contains("Tests_HDFC") ) {
				Assert.assertTrue(false);
			}
		}
		if(payType.equals("EMI_Juspay_GetOffer")) {
			JsonPath j = new JsonPath(resp.asString());
			String gatewaySubventionId = j.getString("emiSubventionGatewayMapping.gatewaySubventionId");
			String subventionType = j.getString("subventionType");
			if (!subventionType.contains("NO_COST") ) {
				Assert.assertTrue(false);
			}
			if (!gatewaySubventionId.contains("offer_MXub89rjoAnoqy") ) {
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("EMI_Juspay_Save_Plan")) {
			JsonPath j = new JsonPath(resp.asString());
			String id = j.getString("id");
			if(id!=null){
			} else Assert.assertTrue(false);
		}
		if(payType.equals("EMI_Juspay_Delete_Plan")) {
			if(!resp.body().asString().contains("SUCCESS")){
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Plans_Reg_Full")) {
			if(!resp.body().asString().contains("{monthly_value}/mo")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("affordability_list")){
				Assert.assertTrue(false);
			}
		}

		if(payType.equals("Affor_Plans_Reg_Lite")) {
			if(!resp.body().asString().contains("https://fastui.cltpstatic.com/image/upload/resources/images/banklogo/")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("affordability_list")){
				Assert.assertTrue(false);
			}
		}




		if(payType.equals("Affor_Plans_NCE_Lite")) {
			if(!resp.body().asString().contains("https://fastui.cltpstatic.com/image/upload/resources/images/banklogo/hdfc.png")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("BAJAJ Finserv")){
				Assert.assertTrue(false);
			}
		}


		if(payType.equals("BannerNew")) {
			if(!(resp.body().asString().contains("Experiencing high failure rate on HDFC Debit Cards"))){
				Assert.assertTrue(false);
			}
		}
		if(payType.equals("Saved_PaymentModes")) {
			JsonPath j = new JsonPath(resp.asString());
			String Cards = j.getString("stored_cards.number");
			String VPA = j.getString("stored_vpa.vpa");
			if (!Cards.contains("XXXXXXXXXXX0009") ) {
				Assert.assertTrue(false);
			}if (!VPA.contains("3212467@okhdfcbank")) {
				Assert.assertTrue(false);
			}
		}

		if(payType.equalsIgnoreCase("Hi5_GetTrnx")) {
			if(!(resp.body().asString().contains("Q221028592282"))){
				Assert.assertTrue(false);
			}
			if(!(resp.body().asString().contains("Q221028592282"))){
				Assert.assertTrue(false);
			}
		}

		if(payType.equalsIgnoreCase("GET_Raterule_CLEMI")) {
			JsonPath j = new JsonPath(resp.asString());
			String N = j.getString("displayName");
			String V = j.getString("value");
			if (!N.contains("HDFC Bank") || !N.contains("Bank of Baroda") || !N.contains("Kotak Bank") || !N.contains("ICICI Bank") || !N.contains("IDFC Bank") || !N.contains("Fedral Bank") || !N.contains("Home Credit") || !N.contains("ZestMoney") || !N.contains("EarlySalary") || !N.contains("Axio")) {
				Assert.assertTrue(false);
			}if (!V.contains("HDFC") || !V.contains("BARB") || !V.contains("KKBK") || !V.contains("ICIC") || !V.contains("IDFB") || !V.contains("FDRL") || !V.contains("HCIN") || !V.contains("ZESTMONEY") || !V.contains("EARLYSALARY") || !V.contains("WALNUT369")) {
				Assert.assertTrue(false);
			}
		}
		if(payType.equalsIgnoreCase("GET_Raterule_PL")) {
			JsonPath j = new JsonPath(resp.asString());
			String N = j.getString("displayName");
			String V = j.getString("value");
			System.out.println("j"+j);
			if (!N.contains("ICICI Bank PayLater") || !N.contains("Simpl") || !N.contains("FlexiPay By HDFC Bank") || !N.contains("LazyPay")) {
				Assert.assertTrue(false);
			}if (!V.contains("ICIC") || !V.contains("GETSIMPL") || !V.contains("HDFC") || !V.contains("LAZYPAY") ) {
				Assert.assertTrue(false);
			}
		}

		if(payType.equalsIgnoreCase("SuperCoins_OTPLess_Hold")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("status " +status);
			Reporter.log("description " +description);
			if(!status.equals("S")) {
				Assert.assertTrue(false);
			}if(!description.equals("Coins held successfully")) {
				Assert.assertTrue(false);
			}
		}


		if(payType.equalsIgnoreCase("GETWALLET_Details_UI")) {

			JsonPath j = new JsonPath(resp.asString());
			String C = j.getString("walletList.CREDIT.balance");
			String R = j.getString("walletList.REWARD.balance");
			String CW = j.getString("walletList.CREDIT.walletNumber");
			String RW = j.getString("walletList.REWARD.walletNumber");
			String B = j.getString("balance");
			if(!CW.equals("7008000020000080")||!RW.equals("3000331040001841")||!C.equals("21437.0")||!R.equals("400.0")||!B.equals("21837.0")) {
				Assert.assertTrue(false);
			}
		}

		if(payType.equalsIgnoreCase("GETWALLET_Trnx_UI")) {
			resp.then().assertThat().body("walletType[0]", equalTo("CREDIT"))
			.assertThat().body("trip-details[0]", equalTo("Bangalore to New Delhi"))
			.assertThat().body("id[0]", equalTo(7100636))
			.assertThat().body("walletType[4]", equalTo("REWARD"))
			.assertThat().body("date[4]", equalTo("30-Jan-2023"));
		}

		else if(payType.equalsIgnoreCase("SuperCoins_OTPLess_Unhold")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("status " +status);
			Reporter.log("description " +description);
			if(!status.equals("S")) {
				Assert.assertTrue(false);
			}if(!description.equals("Unhold successful")) {
				Assert.assertTrue(false);
			}
		}

		else if(payType.equalsIgnoreCase("NoCostEMI_Offers")) {

			if(!(resp.body().asString().contains("CT_NOCOST_EMI_PLAN_2_3_2.61"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("EMI_Offer_eligibility_New")) {

			if(!(resp.body().asString().contains("CT_EMI_OFFER_V2_NO_COST_73_4000"))){
				Assert.assertTrue(false);
			}
		}


		else if(payType.equalsIgnoreCase("VALIDATE")) {
			String redirection = jsonPathEvaluator.getString("redirection_required");
			String Response = jsonPathEvaluator.getString("response_message");
			Reporter.log("redirection required " +redirection);
			Reporter.log("Response " +Response);
			if(!redirection.equals("[Y]")) {
				Assert.assertTrue(false);
			}  
			if(!Response.equals("[Payment can be processed-Redirection required]")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("Hi_5_get_walletTnx")) {
			/*String errorMessage = jsonPathEvaluator.getString("errorMessage");
			Reporter.log("errorMessage " +errorMessage);
			
			if(!errorMessage.equals("duplicate request")) {
				Assert.assertTrue(false);
			}*/
			Assert.assertTrue(false);
		}
	
		
		else if(payType.equalsIgnoreCase("Hi_5_get_wallet")) {
			/*String errorMessage = jsonPathEvaluator.getString("errorMessage");
			Reporter.log("errorMessage " +errorMessage);
			
			if(!errorMessage.equals("duplicate request")) {
				Assert.assertTrue(false);
			}*/
			Assert.assertTrue(false);
		}
	
		
		else if(payType.equalsIgnoreCase("IR_Save_VPA")) {
			String errorMessage = jsonPathEvaluator.getString("errorMessage");
			Reporter.log("errorMessage " +errorMessage);
			
			if(!errorMessage.equals("duplicate request")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("IR_Create_Refund")) {
		//	if(!(resp.body().asString().contains("Refund Partially Initiated"))){
				
			if(!(resp.body().asString().contains("Refund Partially Initiated"))){
					//Assert.assertTrue(false);
			}
			if(!(resp.body().asString().contains("Refund Partially Initiated"))){
				Assert.assertTrue(false);
			}
		}


		else if(payType.equalsIgnoreCase("IR_Create_Refund_Normal")) {
			//	if(!(resp.body().asString().contains("Refund Partially Initiated"))){

			if(!(resp.body().asString().contains("Refund Initiated"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("IR_Fetch_Cancel_Details_CancelTnx")) {
			//if(!(resp.body().asString().contains("65201137"))){
			if(!(resp.body().asString().contains("3212467@okhdfcbank"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("IR_Fetch_Cancel_Details_UserID")) {
			if(!(resp.body().asString().contains("65237343"))){
				if(!(resp.body().asString().contains("Refund Initiated"))){
				Assert.assertTrue(false);
			}
		}
		}
		else if(payType.equalsIgnoreCase("IR_Valid_VPA")) {
			String accountHolderName = jsonPathEvaluator.getString("accountHolderName");
			String valid = jsonPathEvaluator.getString("valid");
			Reporter.log("valid " +valid);
			Reporter.log("accountHolderName " +accountHolderName);
			
			if(!valid.equals("true")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("IR_InValid_VPA")) {
			String accountHolderName = jsonPathEvaluator.getString("accountHolderName");
			String valid = jsonPathEvaluator.getString("valid");
			Reporter.log("valid " +valid);
			Reporter.log("accountHolderName " +accountHolderName);
			if(!valid.equals("false")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("IR_Eligibility_NB")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!OS.equals("true")) {
				Assert.assertTrue(false);
			} 
			if(!AS.contains("VPA")) {
				Assert.assertTrue(false);
			}
			if(!AS.contains("WALLET")) {
				Assert.assertTrue(false);
			}
			
		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_DC")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!AS.contains("WALLET")) {
				Assert.assertTrue(false);
			}

		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_CC")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");

			System.out.println("AS " +AS);
			System.out.println("OS " +OS);
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!OS.equals("true")) {
				Assert.assertTrue(false);
			} 
			/*if(!AS.contains("VPA")) {

				Assert.assertTrue(false);
			}*/
			if(!AS.contains("WALLET")) {

				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("IR_Eligibility_TW")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!OS.equals("true")) {
				Assert.assertTrue(false);
			}
			if(!AS.contains("WALLET")) {

				Assert.assertTrue(false);
			}
			if(AS.contains("VPA")) {

				Assert.assertTrue(false);
			}
			if(AS.contains("BA")) {

				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("IR_Eligibility_CC_Non")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!OS.equals("true")) {
				Assert.assertTrue(false);
			}
			/*if(!AS.contains("VPA")) {
				Assert.assertTrue(false);
			}*/

		}
		else if(payType.equalsIgnoreCase("IR_Eligibility_GV")) {
			String OS = jsonPathEvaluator.getString("eligibleForOriginalSource");
			String AS = jsonPathEvaluator.getString("eligibleAlternativeSourceType");
			Reporter.log("AS " +AS);
			Reporter.log("OS " +OS);
			if(!OS.equals("true")) {
				Assert.assertTrue(false);
			}
			if(!AS.equals("[]")) {
				Assert.assertTrue(false);
			}

		}



		else if(payType.equalsIgnoreCase("ROR_CashUpdate")) {
			String id = jsonPathEvaluator.getString("id");
			String company_id = jsonPathEvaluator.getString("company_id");
			if(!id.equals("5116412")) {
				Assert.assertTrue(false);
			}  
			if(!company_id.equals("198348")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("GETWALLET_Refund_Stop_Tnx")) {
			if(!(resp.body().asString().contains("Q210419967300"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("DAFK_FetchBy_TripID")) {
			if(!(resp.body().asString().contains("no. of coin units. For other cases, it will be null"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("DAFK_FetchBy_PaymentID")) {
			if(!(resp.body().asString().contains("FK deposit account"))){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("DAFKRefundCreate")) {
			String Status = jsonPathEvaluator.getString("status");
		if(!Status.equals("S")) {
			Assert.assertTrue(false);
		}
		}
		else if(payType.equalsIgnoreCase("DAFKRefundUpdatePartnerinfo")) {
		String Status = jsonPathEvaluator.getString("10042072");
		if(!Status.equals("S")) {
			Assert.assertTrue(false);
		}
		}
		else if(payType.equalsIgnoreCase("DAFKRefundStatusUpdate")) {
			if(!(resp.body().asString().contains("1 rows updated"))){
				Assert.assertTrue(false);
			}
		}		
		
		else if(payType.equalsIgnoreCase("Reporting_Disabled_Refunds")) {
			if(!(resp.body().asString().contains("Q210502977324"))){
				Assert.assertTrue(false);
			}if(!(resp.body().asString().contains("kiran.kumar@cleartrip.com"))){
				Assert.assertTrue(false);
			}
		}		
		
		else if(payType.equalsIgnoreCase("Qitaf_Reverse")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			if(!description.equals("success")) {
				Assert.assertTrue(false);
			}  
			if(!status.equals("S")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("Qitaf_SendOTP")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			if(!description.equals("QitafNot Found Or Available")) {
				Assert.assertTrue(false);
			}  
			if(!status.equals("F")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("Qitaf_Redeem")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			if(!description.equals("Invalid Pin")) {
				Assert.assertTrue(false);
			}  
			if(!status.equals("F")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("refund_Enque")) {
			if(!(resp.body().asString().contains("SUCCESS"))){
				Assert.assertTrue(false);
			
			}
		}
		else if(payType.equalsIgnoreCase("FetchGWFailure")) {
			if(!(resp.body().asString().contains("Experiencing high failure rate on HDFC Debit Cards"))){
				Assert.assertTrue(false);
			}
		}		
		
		else if(payType.equalsIgnoreCase("ROR_Mis_expreports")) {
			if(!(resp.body().asString().contains("Q1903221094")&&resp.body().asString().contains("settlement_date"))){
				//Assert.assertTrue(false);
			}
		}

		else if(payType.equalsIgnoreCase("CC")) {
			String paymentID = jsonPathEvaluator.getString("id");
			String statusCC = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("Status is Sucess " +statusCC);
			Reporter.log("description Process " +description);
			Reporter.log(" Payment ID: " + paymentID);
			if(!statusCC.equals("[I]")) {
				if(!description.equals("[Payment successful]")) {
					Assert.assertTrue(false);
				}
				Assert.assertTrue(false);
			}
		}

		else if(payType.equalsIgnoreCase("FetchTripStatus")) {
		if(!resp.body().asString().contains("Payment Successful")){
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("44653436")){
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("ROR_TripStatus")) {
			if(!resp.body().asString().contains("kiran.kumar@cleartrip.com")){
					Assert.assertTrue(false);
				}
				if(!resp.body().asString().contains("Approved")){
					Assert.assertTrue(false);
				}
			}
		
		else if(payType.equalsIgnoreCase("DA")) {
			if(!resp.body().asString().contains("Payment successful")){
				Assert.assertTrue(false);
			}
		}	
		else if(payType.equalsIgnoreCase("DAPay")) {
			if(!resp.body().asString().contains("Payment successful")){
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("DAPayFKZeroAmt")) {
			if(!resp.body().asString().contains("Partner reference data saved successfully")){
				Assert.assertTrue(false);
			}
		}
		
		
		else if(payType.equalsIgnoreCase("DABalance")) {
			String Balance = jsonPathEvaluator.getString("balance");
			String CreditLimit = jsonPathEvaluator.getString("credit_limit");
			String balance_type = jsonPathEvaluator.getString("balance_type");
			Reporter.log("Balance " +Balance);
			Reporter.log("CreditLimit " +CreditLimit);
			if(!balance_type.equals("DR")) {
				Assert.assertTrue(false);
			}  
		}
		
		else if(payType.equalsIgnoreCase("DAStatus")) {
			String Balance = jsonPathEvaluator.getString("balance");
			String CreditLimit = jsonPathEvaluator.getString("credit_limit");
			String balance_type = jsonPathEvaluator.getString("balance_type");
			Reporter.log("Balance " +Balance);
			Reporter.log("CreditLimit " +CreditLimit);
			if(!balance_type.equals("DR")) {
				Assert.assertTrue(false);
		
			}  
			
		}
		else if(payType.equalsIgnoreCase("DARefund")) {
			if(!resp.body().asString().contains("Payment successful")){
				Assert.assertTrue(false);
			
			}
			
		}
		
		
		
		else if(payType.equalsIgnoreCase("DAValidate")) {
			if(!resp.body().asString().contains("Payment can be processed")){
				Assert.assertTrue(false);
			
			}
			
		}		
		
		else if(payType.equalsIgnoreCase("CSValidate")) {
			String paymenttype = jsonPathEvaluator.getString("payment_type");
			String responsemsg = jsonPathEvaluator.getString("response_message");
			Reporter.log("paymentType is " +paymenttype);
			Reporter.log("Response Message " +responsemsg);
		
			/*if(!paymenttype.equals("[CS]"))
			{
				Assert.assertTrue(false);
			}
			if(!responsemsg.equals("[Validation successful]")) {
				Assert.assertTrue(false);
			}*/
		}
		else if(payType.equalsIgnoreCase("CSPay")) {
			String paymenttype = jsonPathEvaluator.getString("payment_type");
			String description = jsonPathEvaluator.getString("description");
			String status=jsonPathEvaluator.getString("status");
			Reporter.log("paymentType is " +paymenttype);
			Reporter.log("Response Message " +description);
			Reporter.log("status Message " +status);
			if(!paymenttype.equals("[CS]")){
				Assert.assertTrue(false);
			}
			if(!status.equals("[S]")) {
				Assert.assertTrue(false);
			}	
			if(!description.equals("[Pay Success]")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("GV")) {
			String paymentID = jsonPathEvaluator.getString("id");
			String statusCC = jsonPathEvaluator.getString("status");					
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("Status is failing " +statusCC);
			Reporter.log("Description GV " +description);
			Reporter.log(" Payment ID: " + paymentID);			
			if(!statusCC.equals("[S]")) {
				if(!description.equals("[Gift voucher redemption success]")) {
					Assert.assertTrue(false);
				}
				Assert.assertTrue(false);
			}		
			
		}else if(payType.equalsIgnoreCase("WALLET")) {
			String paymentID = jsonPathEvaluator.getString("id");
			String statusCC = jsonPathEvaluator.getString("status");				
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("Status is failing " +statusCC);
			Reporter.log("Description Wallet " +description);
			Reporter.log(" Payment ID: " + paymentID);		
			if(!statusCC.equals("[S]")) {
				if(!description.equals("[Wallet payment success]")) {
					Assert.assertTrue(false);
				}
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("GETWALLET_V2_INR")) {
			String wallet_number = jsonPathEvaluator.getString("wallet_number");
			String id = jsonPathEvaluator.getString("id");

			//if(!wallet_number.equalsIgnoreCase("7008000020000038")) {
			if(!resp.body().asString().contains("7008000020000038")){

				Reporter.log("transactionType is : "+wallet_number);
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("5153572")) {
				Reporter.log("description is : "+id);
				Assert.assertTrue(false);
			}
		}
		
		
		
		else if(payType.equalsIgnoreCase("GVWL")) {
			if(!resp.body().asString().contains("Wallet payment success")){
				Assert.assertTrue(false);
			
			}
			if(!resp.body().asString().contains("Gift voucher redemption success")){
				Assert.assertTrue(false);
			
			}
		}else if(payType.equalsIgnoreCase("CCGVWL")) {
			String paymentID = jsonPathEvaluator.getString("id");
			String status = jsonPathEvaluator.getString("status");
			Reporter.log("ID : "+paymentID);
			Reporter.log("status : "+status);
			if(!status.equals("[I, P, P]")) {
				Reporter.log("Init Status is failing " +status);	 
				Assert.assertTrue(false);
			}				
		}else if(payType.equalsIgnoreCase("INIT")) {
			String paymentID = jsonPathEvaluator.getString("id");
			String statusInit = jsonPathEvaluator.getString("status");
			String collectOtp = jsonPathEvaluator.getString("collect_otp");				
			String redirection_required = jsonPathEvaluator.getString("redirection_required");
			Reporter.log("Init Status is Passed " +statusInit);
			Reporter.log("redirection_required " +redirection_required);
			Reporter.log(" Payment ID: " + paymentID);
			Reporter.log(" collectOtp: " + collectOtp);
			if(!statusInit.equals("[I]")) {
				Reporter.log("Init Status is failed " +statusInit);
				Assert.assertTrue(false);
			}
			if(!redirection_required.equals("[N]")) {
				Reporter.log("redirection_required " +redirection_required);
				Assert.assertTrue(false);
			}
			if(!collectOtp.equals("[true]")) {
				Reporter.log("collectOtp " +collectOtp);
				Assert.assertTrue(false);
			}
		}else if(payType.equalsIgnoreCase("PROCESS")) {
			String statusProcess = jsonPathEvaluator.getString("status");
			String descriptionOTP = jsonPathEvaluator.getString("description");
			Reporter.log("description Process " +descriptionOTP);
			Reporter.log("Status is failing " +statusProcess);
			if(!statusProcess.equals("[S]")) {
				if(!descriptionOTP.equals("[Payment successful]")) {
					Assert.assertTrue(false);
				}
				Assert.assertTrue(false);
			}	
		}else if(payType.equalsIgnoreCase("RESEND")) {
			String status = jsonPathEvaluator.getString("status");
			String descriptionOTP = jsonPathEvaluator.getString("description");
			Reporter.log("Status is failing " +status);
			Reporter.log("description " +descriptionOTP);
			if(!status.equals("[S]")) {
				Assert.assertTrue(false);
			}
			if(!descriptionOTP.equals("[otp resend successfully]")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("UPDATE")) {
			String status = jsonPathEvaluator.getString("status");
			Reporter.log(" status : " + status);
			if(!status.equals("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}	
		else if(payType.equals("RefundsTrip")) {
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equals("RefundsTripRef")) {
			String status = jsonPathEvaluator.getString("status");
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
		
		}
		else if(payType.equalsIgnoreCase("GETURL")) {
			String CTPay_URL = jsonPathEvaluator.getString("redirection_url");
			Reporter.log("CTpay  URL "+CTPay_URL);
			if(!CTPay_URL.contains("initiatePayment")) {
				Assert.assertTrue(false);
			}
		}		
		else if(payType.equalsIgnoreCase("STATUS")) {
			String Order_Status = jsonPathEvaluator.getString("order_status");
			String Description = jsonPathEvaluator.getString("description");
			Reporter.log("Order_Status "+Order_Status);
			Reporter.log("Description : "+Description);
			if(!Order_Status.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
			if(!Description.contains("Payment successful")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("CreateURL")) {
			String Order_ID = jsonPathEvaluator.getString("order_id");
			String status = jsonPathEvaluator.getString("status");
			String redirection_url = jsonPathEvaluator.getString("redirection_url");
			Reporter.log("Order_ID "+Order_ID);
			Reporter.log("redirection_url : "+redirection_url);
			Reporter.log("status : "+status);
			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
			if(!redirection_url.contains("initiatePayment")) {
				Assert.assertTrue(false);
			}
		}

		else if(payType.equalsIgnoreCase("EW_USERDETAILS")) {
			String Avl_bal = jsonPathEvaluator.getString("available_balance");
			String Crdt_lmt = jsonPathEvaluator.getString("credit_limit");
			String Opt_In = jsonPathEvaluator.getString("opted-in");
			Reporter.log("available_balance "+Avl_bal);
			Reporter.log("credit_limit : "+Crdt_lmt);
			if(!Opt_In.contains("true")) {
				Reporter.log("Opt_In : "+Opt_In);
				Assert.assertTrue(false);
			}
			if(Avl_bal.isEmpty()) {
				Reporter.log("Avl_bal : "+Avl_bal);
				Assert.assertTrue(false);
			}
			if(Crdt_lmt.isEmpty()) {
				Reporter.log("Crdt_lmt : "+Crdt_lmt);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("EW_OUTSTANDING")) {
			String dueAmount = jsonPathEvaluator.getString("dueAmount");
			String userId = jsonPathEvaluator.getString("userId");
			if (dueAmount.isEmpty()) {
				Reporter.log("dueAmount : "+dueAmount);
				Assert.assertTrue(false);
			}
			if (!userId.equals("41697596")) {
				Reporter.log("userId : "+userId);
				Assert.assertTrue(false);
			}			
		}
		else if (payType.equalsIgnoreCase("EW_OPTIN")) {
			String description = jsonPathEvaluator.getString("description");
			String status = jsonPathEvaluator.getString("status");
			if (!description.contains("Account is already activated")) {
				Reporter.log("description : "+description);
				Assert.assertTrue(false);
			}
			if (!status.equals("false")) {
				Reporter.log("status : "+status);
				Assert.assertTrue(false);
			}	
		}	


		else if (payType.equalsIgnoreCase("EW_OPTIN123")) {
			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("true")) {
				Reporter.log("status : "+status);
				Assert.assertTrue(false);
			}

		}
		else if (payType.equalsIgnoreCase("EW_PAY")) {				
			if(!resp.body().asString().contains("EP")) {
				Reporter.log("paymentType is not EP 	");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Payment will be done later")) {
				Reporter.log("Payment will be done later message not displayed ");
				Assert.assertTrue(false);
			}
			if(resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted ");
				Assert.assertTrue(false);
			}				

		}else if (payType.equalsIgnoreCase("EW_Autodebit")) {	
			if(!resp.body().asString().contains("CAPTURED")) {
				Reporter.log("status text is not displayed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("debit_amount")) {
				Reporter.log("debit_amount text is not displayed");
				Assert.assertTrue(false);
			}


		}
		else if (payType.equalsIgnoreCase("ReportingRefundStatus")) {	
			if(!resp.body().asString().contains("Q191203587976")) {
				Reporter.log("TripID is not displayed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("CREDENTIAL_NAME")) {
				Reporter.log("CREDENTIAL_NAME text is not displayed");
				Assert.assertTrue(false);
			}


		}
		else if (payType.equalsIgnoreCase("EW_PAY_Multi")) {				
			if(!resp.body().asString().contains("EP")) {
				Reporter.log("paymentType is not EP 	");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("GV")) {
				Reporter.log("paymentType is not GV 	");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("WT")) {
				Reporter.log("paymentType is not WT 	");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Gift voucher redemption success")) {
				Reporter.log("Gift voucher redemption success not displayed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Wallet payment success")) {
				Reporter.log("Wallet payment success not displayed");
				Assert.assertTrue(false);
			}




			if(!resp.body().asString().contains("Payment will be done later")) {
				Reporter.log("Payment will be done later message not displayed ");
				Assert.assertTrue(false);
			}
			if(resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted ");
				Assert.assertTrue(false);
			}	
		}
		
		else if (payType.equalsIgnoreCase("EW_Summary")) {
			if(!resp.body().asString().contains("amount")) {
				Reporter.log("amount is not displayed : ");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("S")) {
				Reporter.log("Status S is not displayed : ");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("EW_VALIDATE")) {
			if(!resp.body().asString().contains("Validation successful")) {
				Reporter.log("Validation successful is not displayed : ");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("EP")) {
				Reporter.log("EP  is not displayed ");
				Assert.assertTrue(false);
			}
			/*	if(!resp.body().asString().contains("WT")) {
					Reporter.log("WT is not displayed ");
					Assert.assertTrue(false);
				}*/

			if(resp.body().asString().contains("Internal server error")) {
				Reporter.log("Internal server error  is displayed ");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("EW_Refund")) {

		}
		else if (payType.equalsIgnoreCase("OLAVALIDATE")) {
			String status = jsonPathEvaluator.getString("status");
			String id = jsonPathEvaluator.getString("id"); 
			if(id.isEmpty()) {
				Reporter.log("ID is empty: "+id);
				Assert.assertTrue(false);
			}
			if(!status.contains("success")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("OLAPAY")) {
			String status = jsonPathEvaluator.getString("status");
			String id = jsonPathEvaluator.getString("id"); 
			String transactionId = jsonPathEvaluator.getString("transactionId"); 
			if(id.isEmpty()) {
				Reporter.log("ID is empty: "+id); //transactionId
				Assert.assertTrue(false);
			}
			if(!status.contains("success")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			else if(transactionId.isEmpty()) {
				Reporter.log("transactionId is : "+transactionId);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("OLAStat")) {
			String status = jsonPathEvaluator.getString("status");
			String uniqueBillId = jsonPathEvaluator.getString("uniqueBillId"); 
			if(!status.contains("completed")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			else if(uniqueBillId.isEmpty()) {
				Reporter.log("uniqueBillId is : "+uniqueBillId);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("OLAPromoStatus")) {
			String status = jsonPathEvaluator.getString("status");
			String uniqueBillId = jsonPathEvaluator.getString("uniqueBillId"); 
			if(!resp.body().asString().contains("DEACTIVE")) {{
				Reporter.log("DEACTIVE not displayed");
				Assert.assertTrue(false);
			}
			if(!status.contains("completed")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			else if(uniqueBillId.isEmpty()) {
				Reporter.log("uniqueBillId is : "+uniqueBillId);
				Assert.assertTrue(false);
			}
			}

		}
		else if (payType.equalsIgnoreCase("FLYIN")) {
			String status = jsonPathEvaluator.getString("status");
			String reference_id = jsonPathEvaluator.getString("reference_id"); 
			String processing_gateway = jsonPathEvaluator.getString("processing_gateway"); 

			if(!status.contains("INITIALIZING")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}

			if(reference_id.isEmpty()) {
				Reporter.log("reference_id is : "+reference_id);
				Assert.assertTrue(false);
			}
			if(!processing_gateway.equals("CHECKOUT")) {
				Reporter.log("processing_gateway is : "+processing_gateway);
				Assert.assertTrue(false);
			}
		}

		else if (payType.equalsIgnoreCase("adcb_checkBalance")) {				
			if(!resp.body().asString().contains("Successfully")) {
				Reporter.log("checkBalance Failed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Successfully fetched pay by points amount")) {
				Reporter.log("Successfully fetched pay by points amount - message is not displayed ");
				Assert.assertTrue(false);
			}
			if(resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted ");
				Assert.assertTrue(false);
			}	

			Reporter.log("Successfully fetched pay by points amount - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("adcb_sendOTP")) {				
			if(!resp.body().asString().contains("successfully")) {
				Reporter.log("OTP Failed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("OTP sent successfully")) {
				Reporter.log("OTP sent successfully - message is not displayed ");
				Assert.assertTrue(false);
			}
			if(resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted ");
				Assert.assertTrue(false);
			}	

			Reporter.log("OTP sent successfully - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("adcb_validate")) {				
			if(!resp.body().asString().contains("Reward Points")) {
				Reporter.log("Validation Failed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Reward Points validation successful")) {
				Reporter.log("Reward Points validation successful - message is not displayed ");
				Assert.assertTrue(false);
			}
			if(resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted ");
				Assert.assertTrue(false);
			}	

			Reporter.log("Reward Points validation successful - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("adcb_pay")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 

			Reporter.log("Status is : "+status);
			Reporter.log("---------------------------- Message is -----------"+description);

			if(!status.equalsIgnoreCase("[S]")) {
				Reporter.log("Status is : "+status);
				Assert.assertTrue(false);
			}

			if(!description.contains("[Successfully redeemed points]")) {
				Reporter.log("Message is : "+description);
				Assert.assertTrue(false);
			}


			Reporter.log("Successfully redeemed points - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("adcb_pay2")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 

			Reporter.log("Status is : "+status);
			Reporter.log("Message is : "+description);

			if(!status.equalsIgnoreCase("[F]")) {
				Reporter.log("Status is : "+status);
				Assert.assertTrue(false);
			}

			if(!description.contains("[External ref not found for given trackId")) {
				Reporter.log("Message is : "+description);
				Assert.assertTrue(false);
			}

			if(resp.body().asString().contains("Successfully redeemed points")) {
				Reporter.log("Validation Failed");
				Assert.assertTrue(false);
			}

			Reporter.log( description + "- message is displayed ");

		}

		else if (payType.equalsIgnoreCase("Binmanager")) {				

			String cardType = jsonPathEvaluator.getString("cardType");
			String isOtpEligible = jsonPathEvaluator.getString("isOtpEligible"); 

			Reporter.log("CardType is : "+cardType);

			if(!cardType.equalsIgnoreCase("DEBIT")) {
				Reporter.log("CardType is : "+cardType);
				Assert.assertTrue(false);
			}

			if(!isOtpEligible.equalsIgnoreCase("false")) {
				Reporter.log("isOtpEligible is : "+isOtpEligible);
				Assert.assertTrue(false);
			}

		}
		else if (payType.equalsIgnoreCase("PAYBACK_CheckBalance")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 

			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}		
			if(!description.equalsIgnoreCase("Successfully fetched payback points amount")) {
				Reporter.log("description is : "+description);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully fetched payback points amount - message is displayed ");

		}

		else if (payType.equalsIgnoreCase("PAYBACK_Validate")) {				

			String response_message = jsonPathEvaluator.getString("response_message");
			String payment_type = jsonPathEvaluator.getString("payment_type"); 
			if(!response_message.equalsIgnoreCase("[Reward Points validation successful]")) {
				Reporter.log("response_message is : "+response_message);
				Assert.assertTrue(false);
			}		
			if(!payment_type.equalsIgnoreCase("[RP]")) {
				Reporter.log("payment_type is : "+payment_type);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully fetched pay by points amount - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("PAYBACK_Pay")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 
			if(!status.equalsIgnoreCase("[S]")) {
				Reporter.log("response_message is : "+status);
				Assert.assertTrue(false);
			}		
			if(!description.equalsIgnoreCase("[Successfully redeemed points]")) {
				Reporter.log("Message is : "+description);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully redeemed points - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("PAYBACK_Pay_WT_MultiGV_CC")) {				

			if(!resp.body().asString().contains("redirection_info")) {
				Reporter.log("redirection_info is not displayed for CC ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("Not attempted")) {
				Reporter.log("Not attempted message is not displayed");
				Assert.assertTrue(false);
			}

			Reporter.log("Not attempted - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("PAYBACK_Pay_WT_MultiGV")) {				

			System.out.println(resp.body().asString());
			if(!resp.body().asString().contains("Wallet payment success")) {
				Reporter.log("Wallet payment success message is not displayed ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("Successfully redeemed points")) {
				Reporter.log("Successfully redeemed points message is not displayed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("Gift voucher redemption success")) {
				Reporter.log("Gift voucher redemption success message is not displayed");
				Assert.assertTrue(false);
			}

			Reporter.log("Successfully executed PAYBACK_Pay_WT_MultiGV ");

		}
		else if (payType.equalsIgnoreCase("PAYBACK_Earn")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("response_message is : "+status);
				Assert.assertTrue(false);
			}		
			if(!description.equalsIgnoreCase("Successful Payback earn transaction")) {
				Reporter.log("Message is : "+description);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully fetched pay by points amount - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("PAYBACK_Reverseearn")) {				

			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description"); 
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("response_message is : "+status);
				Assert.assertTrue(false);
			}		
			if(!description.equalsIgnoreCase("Successfully reversed Payback Earn transaction")) {
				Reporter.log("Message is : "+description);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully fetched pay by points amount - message is displayed ");

		}
		else if (payType.equalsIgnoreCase("PromoActive")) {		

			if(!resp.body().asString().contains("trip_ref")) {
				Reporter.log("trip_ref is not displayed ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("status")) {
				Reporter.log("status is not displayed");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("ACTIVE")) {
				Reporter.log("ACTIVE is not displayed");
				Assert.assertTrue(false);
			}
		}



		else if (payType.equalsIgnoreCase("PAYBACK_CheckEarnPoints")) {				

			String description = jsonPathEvaluator.getString("description");
			String status = jsonPathEvaluator.getString("status"); 
			if(!description.equalsIgnoreCase("Successfully calculated earn points")) {
				Reporter.log("Description is : "+description);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully checked Earn points ");
		}

		else if (payType.equalsIgnoreCase("PAYBACK_CheckMobileLinked")) {				

			String isAccountLinked = jsonPathEvaluator.getString("isAccountLinked");
			String status = jsonPathEvaluator.getString("status"); 
			if(!isAccountLinked.equalsIgnoreCase("true")) {
				Reporter.log("isAccountLinked is : "+isAccountLinked);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully checked if Mobile is linked ");
		}

		else if (payType.equalsIgnoreCase("PAYBACK_CheckCardLinked")) {	

			String isAccountLinked = jsonPathEvaluator.getString("isAccountLinked");
			String status = jsonPathEvaluator.getString("status"); 
			if(!isAccountLinked.equalsIgnoreCase("true")) {
				Reporter.log("isAccountLinked is : "+isAccountLinked);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully checked if Card is linked ");
		}
		else if (payType.equalsIgnoreCase("PAYBACK_Forgotpassword")) {				

			String description = jsonPathEvaluator.getString("isAccountLinked");
			String status = jsonPathEvaluator.getString("status"); 
			if(!description.equalsIgnoreCase("false")) {
				Reporter.log("isAccountLinked is : "+description);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("F")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			Reporter.log("Successfully fetched PIN for Mobile Number ");
		}

		else if (payType.equalsIgnoreCase("PromoUsed")) {				
			String usedPromo = jsonPathEvaluator.getString("usedPromo");
			if(!usedPromo.equalsIgnoreCase("10.0")) {
				Reporter.log("usedPromo is : "+usedPromo);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("FetchPayDetails")) {
			if(!resp.body().asString().contains("user_id")) {
				Reporter.log("user_id is not displayed ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("air_bookings")) {
				Reporter.log("air_bookings text is not displayed");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("Reporting")) {
			if(!resp.body().asString().contains("trip_ref")) {
				Reporter.log("trip_ref is not displayed ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("payment_id")) {
				Reporter.log("payment_id is not displayed");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("ReportingPAYID")) {
			if(!resp.body().asString().contains("description")) {
				Reporter.log("description is not displayed ");
				Assert.assertTrue(false);
			}/*if(!resp.body().asString().contains("Successful Transaction")) {
				Reporter.log("Successful Transaction is not displayed");
				Assert.assertTrue(false);
			}*/if(!resp.body().asString().contains("payment_type")) {
				Reporter.log("payment_type is not displayed");
				Assert.assertTrue(false);
			}
		}


		else if (payType.equalsIgnoreCase("createrefund")) {
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status"); 
			if(!message.equalsIgnoreCase("Refund entry successful with status S")) {
				Reporter.log("isAccountLinked is : "+message);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("updatestatus")) {
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status"); 
			if(!message.equalsIgnoreCase("Update Successful")) {
				Reporter.log("Message is : "+message);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("updatepgtxnid")) {
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status"); 
			if(!message.equalsIgnoreCase("Update Successful")) {
				Reporter.log("Message is : "+message);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("getrecord")) {
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status"); 
			if(!message.equalsIgnoreCase("Query successful")) {
				Reporter.log("Message is : "+message);
				Assert.assertTrue(false);
			}		
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_getcards")) {
			if(!resp.body().asString().contains("340000")) {
					Reporter.log("card number is not displayed ");
					//Assert.assertTrue(false);
				}
				if(resp.body().asString().contains("Card already exist")) {
					Reporter.log("Card already exist is not displayed ");
					//Assert.assertTrue(false);					
				}
				else if(!resp.body().asString().contains("exp_month")) {
					Reporter.log("exp_month is not displayed ");
					Assert.assertTrue(false);
				}else if(!resp.body().asString().contains("number")) {
					Reporter.log("Card Number is not displayed");
					Assert.assertTrue(false);
				}
		}
		else if (payType.equalsIgnoreCase("wallet_deleteCards")) {
			if(!resp.body().asString().contains("[")) {
				Reporter.log("Card deletion failed");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_PROMOUSED")) {
			String usedPromo = jsonPathEvaluator.getString("usedPromo");
			if(!usedPromo.equalsIgnoreCase("10.0")) {
				Reporter.log("usedPromo is : "+usedPromo);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_REVERTPROMO")) {

		}else if (payType.equalsIgnoreCase("wallet_REVERTEDPROMO")) {

			if(!resp.body().asString().contains("reverted amount fetched successfully")) {
				Reporter.log("reverted amount fetched successfully is not displayed ");
				Assert.assertTrue(false);
			}
		}else if (payType.equalsIgnoreCase("wallet_GETDEDUCTION")) {
			String usedPromo = jsonPathEvaluator.getString("promoused");
			if(!usedPromo.equalsIgnoreCase("10.0")) {
				Reporter.log("usedPromo is : "+usedPromo);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_GETWALLET_Trnx")) {

			if(!resp.body().asString().contains("Q230428722754")) {
				Reporter.log("Q230428722754 is not displayed ");
				Assert.assertTrue(false);
			}
		}

		else if (payType.equalsIgnoreCase("wallet_GETWALLET_Trnx")) {
			String transactionType = jsonPathEvaluator.getString("transactionType");
			String description = jsonPathEvaluator.getString("description");
			if(!transactionType.equalsIgnoreCase("CAPTURE")) {
				Reporter.log("transactionType is : "+transactionType);
				Assert.assertTrue(false);
			}
			if(!description.equalsIgnoreCase("Transaction successful")) {
				Reporter.log("description is : "+description);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_GETWALLET_ALL")) {
			if(!resp.body().asString().contains("3000331040000246")) {
				Reporter.log("3000331040000001 is not displayed ");
				Assert.assertTrue(false);
			}
			/*if(!resp.body().asString().contains("3000331020000001")) {
				Reporter.log("3000331020000001 is not displayed ");
				Assert.assertTrue(false);
			}*/


		}
		else if (payType.equalsIgnoreCase("wallet_GETWALLET_INR")) {

			if(!resp.body().asString().contains("3000331040000001")) {
				Reporter.log("3000331040000001 is not displayed ");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("7008000020000038")) {
				Reporter.log("7008000020000038 is not displayed ");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("CREDIT")) {
				Reporter.log("CREDIT is not displayed ");
				Assert.assertTrue(false);
			}if(!resp.body().asString().contains("REWARD")) {
				Reporter.log("REWARD is not displayed ");
				Assert.assertTrue(false);
			}
			/*
			String walletNumber = jsonPathEvaluator.getString("walletNumber");
			String id = jsonPathEvaluator.getString("id");
			if(!walletNumber.equalsIgnoreCase("3000331040000001")) {
				Reporter.log("transactionType is : "+walletNumber);
				Assert.assertTrue(false);
			}
			if(!id.equalsIgnoreCase("5153572")) {
				Reporter.log("description is : "+id);
				Assert.assertTrue(false);
			}*/
		}
		else if (payType.equalsIgnoreCase("wallet_GETWALLET_INR2")) {

			if(!(resp.asString().contains("6007000027209671"))&&(resp.asString().contains("Q221109595168"))&&(resp.asString().contains("REFUND"))) {
				Reporter.log("Credit wallet");
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("wallet_GETWALLET_INR")) {
			String walletNumber = jsonPathEvaluator.getString("walletNumber");
			String id = jsonPathEvaluator.getString("id");
			if(!walletNumber.equalsIgnoreCase("3000331040000001")) {
				Reporter.log("transactionType is : "+walletNumber);
				Assert.assertTrue(false);
			}
			if(!id.equalsIgnoreCase("5153572")) {
				Reporter.log("description is : "+id);
				Assert.assertTrue(false);
			}
		}	
		else if (payType.equalsIgnoreCase("wallet_CASHBACK_DETAILS_WALLETS")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			if(!description.equalsIgnoreCase("Wallet cashback success")) {
				Reporter.log("description is : "+description);
				Assert.assertTrue(false);
			}
		}	
		else if (payType.equalsIgnoreCase("WALLET_CREATE")) {
			String error = jsonPathEvaluator.getString("error");
			String message = jsonPathEvaluator.getString("message");
			if(!error.equalsIgnoreCase("Internal Server Error")) {
				Reporter.log("error is : "+error);
				Assert.assertTrue(false);
			}
			/*if(!message.equalsIgnoreCase("Wallet already exists for User-Id: 65176051 Currency: AED ")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}*/
		}
		else if (payType.equalsIgnoreCase("GV_GET")) {
			String status = jsonPathEvaluator.getString("status");
			String isExpired = jsonPathEvaluator.getString("isExpired");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			if(!isExpired.equalsIgnoreCase("false")) {
				Reporter.log("isExpired is : "+isExpired);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("GV_REFUND")) {
			String status = jsonPathEvaluator.getString("status");
			String isExpired = jsonPathEvaluator.getString("isExpired");
			if(!status.equalsIgnoreCase("F")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("GV_CAPTURE")) {
			String description = jsonPathEvaluator.getString("description");
			String status = jsonPathEvaluator.getString("status");
			if(!description.equalsIgnoreCase("Gift voucher redemption success")) {
				Reporter.log("description is : "+description);
				Assert.assertTrue(false);
			}if(!status.equalsIgnoreCase("SUCCESS")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("GV_REFUND2")) {
			String status = jsonPathEvaluator.getString("status");
			String isExpired = jsonPathEvaluator.getString("isExpired");
			if(!status.equalsIgnoreCase("F")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("CreateRecord")) {

			String PayID = resp.asString();
			if(PayID.isEmpty()) {
				Reporter.log("Payment ID is not created");
				Assert.assertTrue(false);
			}
		}else if (payType.equalsIgnoreCase("RORFetch_Pay_BY_ID")) {

			String description = jsonPathEvaluator.getString("description");
			String app_ref1 = jsonPathEvaluator.getString("app_ref1");
			if(!description.equalsIgnoreCase("Payment successful")) {
				Reporter.log("description is : "+description);
				Assert.assertTrue(false);
			}if(!app_ref1.equalsIgnoreCase("Q191204588534")) {
				Reporter.log("app_ref1 is : "+app_ref1);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("RORFetch_Refund_BY_ID")||payType.equalsIgnoreCase("RORFetch_Profile_List")) {

			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!message.equalsIgnoreCase("Query successful")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("RORUpdate_Profile_List")) {

			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!message.equalsIgnoreCase("Successfully updated")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("RORUpdate_Profile_List")) {

			String id = jsonPathEvaluator.getString("id");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!id.equalsIgnoreCase("9371271")) {
				Reporter.log("id is : "+id);
				Assert.assertTrue(false);
			}
		}
		else if (payType.equalsIgnoreCase("RORUpdate_Refund_List")) {

			if(!(resp.asString().contains("true"))&&(resp.asString().contains("9371271"))) {
				Reporter.log("Staus is not true");
				Assert.assertTrue(false);
			}/*

			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("true")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!message.equalsIgnoreCase("Successfully updated")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}*/
		}
		else if (payType.equalsIgnoreCase("ReportingTS_V3")) {
			if(!(resp.asString().contains("11605.02"))) {
				Reporter.log("11605.02 not displayed");
				Assert.assertTrue(false);
			}

		}

		else if (payType.equalsIgnoreCase("CTPAYADD")) {			
			String s2s_url = jsonPathEvaluator.getString("s2s_url");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("SUCCESS")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!s2s_url.equalsIgnoreCase("wwww.123.com")) {
				Reporter.log("message is : "+s2s_url);
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("ROR_Create_ProfileLists")){
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}if(!message.contains("Profile created with id")) {
				Reporter.log("message is : "+status);
				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("RORUpdate_GW_Status")){
			String currentStatus = jsonPathEvaluator.getString("currentStatus");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("I")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			if(!currentStatus.contains("P")) {
				Reporter.log("currentStatus is : "+currentStatus);
				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("RORCreate_Payment")){
			String TripID = jsonPathEvaluator.getString("Q191109570525");

			if(TripID.isEmpty()) {
				Reporter.log("TripID is : "+TripID);
				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("RORCreate_ProfileList")){
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			if(!message.contains("Profile created with id")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}

		}

		else if(payType.equalsIgnoreCase("ROR_Search_ProfileList")){
			if(!resp.body().asString().contains("user_id")) {
				Reporter.log("Card deletion failed");
				Assert.assertTrue(false);
			}



		}

		else if(payType.equalsIgnoreCase("ROR_Create_Refunds")){
			String message = jsonPathEvaluator.getString("message");
			String status = jsonPathEvaluator.getString("status");
			if(!status.equalsIgnoreCase("S")) {
				Reporter.log("status is : "+status);
				Assert.assertTrue(false);
			}
			if(!message.contains("Refund Initiated")) {
				Reporter.log("message is : "+message);
				Assert.assertTrue(false);
			}			
		}

		else if(payType.equalsIgnoreCase("ROR_Recon")){
			if(!resp.body().asString().contains("payment_id")) {
				Reporter.log("refundAmount");
				Assert.assertTrue(false);
			}
			if(!resp.body().asString().contains("status")) {
				Reporter.log("status D");
				Assert.assertTrue(false);
			}			
		}
		else if(payType.equalsIgnoreCase("NavisonCC")){
			String trip_ref = jsonPathEvaluator.getString("trip_ref");
			String credential_name = jsonPathEvaluator.getString("credential_name");
			if(!credential_name.equalsIgnoreCase("IN_PAYU_STAGING")) {
				Reporter.log("credential_name is : "+credential_name);
				Assert.assertTrue(false);
			}
			if(!trip_ref.contains("Q200117692102")) {
				Reporter.log("trip_ref is : "+trip_ref);
				Assert.assertTrue(false);
			}	
		}
		else if(payType.equalsIgnoreCase("NavisonAir")){
			String trip_ref = jsonPathEvaluator.getString("trip_ref");
			String credential_name = jsonPathEvaluator.getString("credential_name");
			if(!credential_name.equalsIgnoreCase("[RAZORPAY]")) {
				Reporter.log("credential_name is : "+credential_name);
				Assert.assertTrue(false);
			}
			if(!trip_ref.contains("Q191226667766")) {
				Reporter.log("trip_ref is : "+trip_ref);
				Assert.assertTrue(false);
			}	
		}
		else if(payType.equalsIgnoreCase("ROR_MultiSearch")){

			if(!resp.body().asString().contains("Q200123741386")) {
				Reporter.log("TripID");
				Assert.assertTrue(false);
			}	
		}
		else if(payType.equalsIgnoreCase("ROR_WalletFetch")){

			if(!resp.body().asString().contains("5153574")) {
				Reporter.log("5153574 is not displayed");
				Assert.assertTrue(false);
			}	
		}
		else if(payType.equalsIgnoreCase("ROR_MultiSearch_Reads")){

			if(!resp.body().asString().contains("43622220")) {
				Reporter.log("43622220 is not displayed");
				Assert.assertTrue(false);
			}	
		}

		else if(payType.equalsIgnoreCase("ROR_MultiSearch_TripRef_Reads")){

			if(!resp.body().asString().contains("43179370")) {
				Reporter.log("43179370 is not displayed");
				Assert.assertTrue(false);
			}	
		}

		else if(payType.equalsIgnoreCase("ROR_WalletTrnx_Reads")){

			if(!resp.body().asString().contains("5154746")) {
				Reporter.log("5154746 is not displayed");
				Assert.assertTrue(false);
			}	
		}

		else if(payType.equalsIgnoreCase("ROR_WalletGet_Reads")){

			if(!resp.body().asString().contains("5789285")) {
				Reporter.log("5789285 is not displayed");
				Assert.assertTrue(false);
			}	
		}

		else if(payType.equalsIgnoreCase("ROR_GV_Details")){

			if(!resp.body().asString().contains("3000331039771395")) {
				Reporter.log("3000331039771395 is not displayed");
				Assert.assertTrue(false);
			}	
		}
		
		else if(payType.equalsIgnoreCase("ROR_Refund_Details")){

			if(!resp.body().asString().contains("Recon Req")) {
				Reporter.log("Recon Re is not displayed");
				Assert.assertTrue(false);
			}	
		}
		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V3_False")){
					if(!resp.body().asString().contains("40294932")) {
						Reporter.log("40294932 is not displayed");
						Assert.assertTrue(false);
					}
		}
		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V3_True")){
			/*if(!resp.body().asString().contains("40294932")) {
				Reporter.log("40294932 is not displayed");
				Assert.assertTrue(false);
			}*/
		}
		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V_New")){
			if(!resp.body().asString().contains("SessionID_1569885600000BLR_DEL")) {
				Reporter.log("SessionID_1569885600000BLR_DEL is not displayed");
				Assert.assertTrue(false);
			}
		}
		
		
		else if(payType.equals("GETUI_CONVFEE")) {
			String CC = jsonPathEvaluator.getString("cc");
			Reporter.log("cc " +CC);
			if(!CC.equals("1")) {
				
					Assert.assertTrue(false);
			}
			
		}
		else if(payType.equals("GETUI_PAYTYPES")) {
			
			if(!resp.body().asString().contains("UPI")) {
				Reporter.log("UPI is not displayed");
				Assert.assertTrue(false);
			}		
		}
	else if(payType.equals("WALLET_Fetch_NotLogged")) {
			
			if(!resp.body().asString().contains("User not logged in")) {
				Reporter.log("User not logged in is not displayed");
				Assert.assertTrue(false);
			}		
		}
	else if(payType.equals("EMICache")) {
		if(!resp.body().asString().contains("success")) {
			Reporter.log("success is not displayed");
			Assert.assertTrue(false);
		}
	}
	else if(payType.equals("EMICache_New")) {
			if(!resp.body().asString().contains("SUCCESS")) {
				Reporter.log("SUCCESS is not displayed");
				Assert.assertTrue(false);
			}
		}
	else if(payType.equals("EMICache_Refresh_New")) {
		if(!resp.body().asString().contains("CT_EMI_PLAN_V2_EMI_CC_192_bank_6_3000")) {
				Reporter.log("CT_EMI_PLAN_V2_EMI_CC_192_bank_6_3000 not displayed");
				Assert.assertTrue(false);
		}
	}
	else if(payType.equals("EMICache")) {
		if(!resp.body().asString().contains("SUCCESS")) {
			Reporter.log("success is not displayed");
			Assert.assertTrue(false);
		}
	}
	else if(payType.equals("EMIResources")) {
		if(!resp.body().asString().contains("success")) {
			Reporter.log("success is not displayed");
			Assert.assertTrue(false);
		}
	}		
		
	else if(payType.equals("EMIRazorpay")) {
		if(!resp.body().asString().contains("CT_EMI_PLAN_25_9_12_14.0_10")) {
			Reporter.log("CT_EMI_PLAN_25_9_12_14.0_10");
			Assert.assertTrue(false);
		}
	}
		
	else if(payType.equals("EMINoon")) {
		/*if(!resp.body().asString().contains("CT_EMI_PLAN_24_107_3_0")) {
			Reporter.log("Plan is not displayed");
			Assert.assertTrue(false);
		}*/
	}
	else if(payType.equals("EMIFetch")) {
		if(!resp.body().asString().contains("Invalid trip")) {
			Reporter.log("Invalid trip is not displayed");
			Assert.assertTrue(false);
		}
	}
	else if(payType.equals("SuperCoins_MobileLinked")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
				Assert.assertTrue(false);
		}
		boolean isAccountLinked= jsonPathEvaluator.getBoolean("isAccountLinked");
		Reporter.log("isAccountLinked " +isAccountLinked);
		if(!isAccountLinked) {
				Assert.assertTrue(false);
		}
		
	}
	
	else if(payType.equals("SuperCoins_SendOTP")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
				Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("description " +Description);
		if(!Description.equals("OTP sent successfully")) {
				Assert.assertTrue(false);
		}
	}
		
	else if(payType.equals("SuperCoins_ValidateOTP")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
				Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("description " +Description);
		if(!Description.equals("Otp validated successfully")) {
				Assert.assertTrue(false);
		}
	}
	else if(payType.equals("SuperCoins_Unhold")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
				Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("description " +Description);
		if(!Description.equals("Unhold successful")) {
				Assert.assertTrue(false);
		}
		
	}
		
	else if(payType.equals("SuperCoins_ValidateOTP_Invalid")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("F")) {
			Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("description " +Description);
		if(!Description.equals("OTP verification failed")) {
			Assert.assertTrue(false);
		}
		String Error= jsonPathEvaluator.getString("errorCode");
		Reporter.log("Error " +Error);
		if(!Error.equals("OTP_VERIFICATION_FAILED")) {
			Assert.assertTrue(false);
		}
	}	
	else if(payType.equals("SuperCoins_Info")) {
			if(!(resp.body().asString().contains("amount") && resp.body().asString().contains(":4.0"))) {
				Reporter.log("amount :4.0 not displayed");
				Assert.assertTrue(false);
			}

	/*	String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("ACTIVE")) {
			Assert.assertTrue(false);
		}
		String coins= jsonPathEvaluator.getString("coins");
		Reporter.log("coins " +coins);
		if(!coins.equals("5")) {
			Assert.assertTrue(false);
		}*/
	}
	else if(payType.equals("SuperCoins_CheckBalance")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
			Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("Description " +Description);
		if(!Description.equals("Successfully fetched Supercoins balance")) {
			Assert.assertTrue(false);
		}		
	}
	else if(payType.equals("SuperCoins_CheckEarnPoints")) {
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("S")) {
			Assert.assertTrue(false);
		}
		String Description= jsonPathEvaluator.getString("description");
		Reporter.log("Description " +Description);
		if(!Description.equals("Successfully fetched earn config")) {
			Assert.assertTrue(false);
		}		
	
	}
		else if(payType.equals("SuperCoins_CheckEarnPoints1")) {
			String Status= jsonPathEvaluator.getString("status");
			Reporter.log("Status " +Status);
			if(!Status.equals("S")) {
				Assert.assertTrue(false);
			}
			String Description= jsonPathEvaluator.getString("description");
			Reporter.log("Description " +Description);
			if(!Description.equals("Successfully calculated earn points")) {
				Assert.assertTrue(false);
			}

		}


	else if(payType.equals("SuperCoins_CreatePromo")) {
		if(!resp.body().asString().contains("SUPERCOINS")) {
			Reporter.log("SUPERCOINS is not displayed");
			Assert.assertTrue(false);
		}	
		if(!resp.body().asString().contains("DEACTIVE")) {
			Reporter.log("DEACTIVE is not displayed");
			Assert.assertTrue(false);
		}
		if(!resp.body().asString().contains("41649009")) {
			Reporter.log("41649009 is not displayed");
			Assert.assertTrue(false);
		}
	}
	
	else if(payType.equals("SuperCoins_UpdatePromo")) {			
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("ACTIVE")) {
			Assert.assertTrue(false);
		}
	}

	else if(payType.equals("SuperCoins_ActivatePromo")) {			
		String Status= jsonPathEvaluator.getString("status");
		Reporter.log("Status " +Status);
		if(!Status.equals("ACTIVE")) {
			Assert.assertTrue(false);
		}
	}
		
		return resp;	
	}

	public Response validation_SCLP_GV(String payType, Response resp) {
		Reporter.log("Response body " + payType + " : " + resp.body().asString());
		System.out.println("Response body " + payType + " : " + resp.body().asString());
		int statusCode = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(!payType.contains("ERRORPRODUCT")) {
			if (statusCode != 200) {
				Assert.assertTrue(false);
			}
		}
		if(payType.equals("CAPTURESCLPGV")){
			JsonPath j = new JsonPath(resp.asString());
			String status = j.getString("status");
			if (!status.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equals("GVSCLPGETEXPIRY")){
			JsonPath j = new JsonPath(resp.asString());
			String status = j.getString("status");
			String description = j.getString("description");
			String expiry = j.getString("gvExpiryDetails.expiry");
			System.out.println(expiry);
			if (!description.contains("Expiry details fetched successfully") || !status.contains("S")|| !expiry.contains("2023-12-15T12:38:38.000+00:00")) {
				Assert.assertTrue(false);
			}
		}

		else if(payType.equals("VALIDATESCLPGV")){
			JsonPath j = new JsonPath(resp.asString());
			String status = j.getString("status");
			String cardNumber = j.getString("giftVoucherResponseDetails.cardNumber");
			if (!cardNumber.contains("5004000019142061") || !status.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equals("VALIDATELISTGVSCLP")){
			JsonPath j = new JsonPath(resp.asString());
			String status = j.getString("status");
			String cardNumber = j.getString("giftVoucherResponseDetails.cardNumber");
			if (!status.contains("SUCCESS")|| !cardNumber.contains("5004000017915661")||!cardNumber.contains("5004000013522541")) {
				Assert.assertTrue(false);
			}
		}


		else if(payType.equals("VALIDATEINSUFFSCLPGV")){
			JsonPath j = new JsonPath(resp.asString());
			String status = j.getString("status");
			String description = j.getString("description");

			String cardNumber = j.getString("giftVoucherResponseDetails.cardNumber");

			if (!cardNumber.contains("5004000019142061") || !status.contains("FAILURE") || !description.contains("Insufficient balance")  ) {
				Assert.assertTrue(false);
			}
		}

		else if (payType.equals("GENERIC")) {
			JsonPath j = new JsonPath(resp.asString());
			String cardType = j.getString("cardType");
			String status = j.getString("status");
			if (!cardType.contains("Cleartrip-India SCLP eGift Card") || !status.contains("S")) {
				Assert.assertTrue(false);
			}
		}
		else if (payType.equals("ONLY_DOMAIR")) {
			JsonPath j = new JsonPath(resp.asString());
			String cardType = j.getString("cardType");
			String status = j.getString("status");
			if (!cardType.contains("Cleartrip India SCLP Flight Travel") || !status.contains("S")) {
				Assert.assertTrue(false);
			}
		}
		else if (payType.equals("ONLY_INTLAIR")) {
			JsonPath j = new JsonPath(resp.asString());
			String cardType = j.getString("cardType");
			String status = j.getString("status");
			if (!cardType.contains("Cleartrip India SCLP Flight Travel") || !status.contains("S")) {
				Assert.assertTrue(false);
			}
		}
		else if (payType.equals("ONLY_HOTEL")) {
			JsonPath j = new JsonPath(resp.asString());
			String cardType = j.getString("cardType");
			String status = j.getString("status");
			if (!cardType.contains("Cleartrip India SCLP hotel EGV") || !status.contains("S")) {
				Assert.assertTrue(false);
			}
		}
		else if (payType.equals("ERROR")) {
			String j = resp.body().asString();
			if(!j.contains("")) {
				Assert.assertTrue(false);
			}
		}
		else if (payType.equals("ERRORPRODUCT")) {
			String j = resp.body().asString();
			if(!j.contains("Internal Server Error")) {
				Assert.assertTrue(false);
			}
		}
		return resp;
	}

		public Response validation_Prod(String payType, Response resp) {
		Reporter.log("Response body "+payType +" : "+ resp.body().asString());
		//System.out.println("Response body "+payType +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();	
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(statusCode!=200) {
			Assert.assertTrue(false);
			Reporter.log("Response Status code is not matching");
		}

		else {
			Reporter.log("Response status code is matching");
		}
		if(payType.equalsIgnoreCase("Rwd_PayBack_Mobile")) {
			String status = jsonPathEvaluator.getString("status");
			String isAccountLinked = jsonPathEvaluator.getString("isAccountLinked");
			Reporter.log("status " +status);
			Reporter.log("isAccountLinked " +isAccountLinked);
			if(!status.equals("S")) {
				Assert.assertTrue(false);
			}  
			if(!isAccountLinked.equals("true")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("Rwd_ADCB_Balance")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			Reporter.log("status " +status);
			Reporter.log("description " +description);
			if(!status.equals("F")) {
				Assert.assertTrue(false);
			}  
			if(!description.contains("You have provided incorrect card details")) {
				Assert.assertTrue(false);
			}
		}
		else if(payType.equalsIgnoreCase("GetPaymentStatus")) {
			boolean isMatching = false;
			List<HashMap<String,Object>> payStatusList = new ArrayList<>();
			payStatusList = jsonPathEvaluator.get("bookPaymentResponse");
			for(HashMap<String,Object> m : payStatusList) {
				if(m.get("status").equals("S") && m.get("description").equals("Payment successful")) {
					isMatching = true;
					Reporter.log("Payment Status Is Successful");
				}

				else {
					Reporter.log("Payment Status Is Not Successful");
				}
			}

			Assert.assertTrue(isMatching);
		}

		else if(payType.equals("ThirdPartyWallets")) {
			boolean isMatching = false;
			List<HashMap<String,Object>> tpStatusList = new ArrayList<>();
			tpStatusList = (List<HashMap<String, Object>>) resp;
			for(HashMap<String,Object> m : tpStatusList) {
				if(m.get("status").equals("D") || m.get("status").equals("A")) {
					isMatching = true;
					Reporter.log("Third Party Wllet Status Is Successful");
				}

				else {
					Reporter.log("Payment Status Is Not Successful");
				}
			}

			Assert.assertTrue(isMatching);

		}
		else if(payType.equalsIgnoreCase("Wallet_Get_Currency")) {
			String str_resp = resp.body().asString();
			if(!str_resp.contains("INR")) {
				Assert.assertTrue(false);
			}  
			if(!str_resp.contains("1001370018436908")) {
				Assert.assertTrue(false);
			} 
		}
		else if(payType.equalsIgnoreCase("Pay_Get_TW_Wallets")) {
			String str_resp = resp.body().asString();
			if(!str_resp.contains("AmazonPay")) {
				Assert.assertTrue(false);
			}  	

		}
		else if(payType.equalsIgnoreCase("Promo_Get_Group")) {
			String str_resp = resp.body().asString();
			if(!str_resp.contains("AIR_BOOKING")) {
				Assert.assertTrue(false);
			}			 
		}
		else if(payType.equalsIgnoreCase("Bin_Get_CardInfo")) {
			String cardType = jsonPathEvaluator.getString("cardType");
			String bank = jsonPathEvaluator.getString("bank");
			Reporter.log("bank " +bank);
			Reporter.log("cardType " +cardType);
			if(!cardType.equals("CREDIT")) {
				Assert.assertTrue(false);
			}  
			if(!bank.equals("HDFC BANK, LTD.")) {
				Assert.assertTrue(false);
			}
		}
		
		else if(payType.equalsIgnoreCase("EMICache")) {
			String str_resp = resp.body().asString();
			if(!str_resp.contains("success")) {
				Assert.assertTrue(false);
			}	
			if(!str_resp.contains("success1")) {
				Assert.assertTrue(false);
			}	
		}
		return resp;
	}


	public String generateTripRef() {
		int randomNumber= 12;
		String randNumber= Integer.toString(randomNumber);
		tripRef= "Q201" + randNumber;
		return tripRef;
	}
	
	public String getPayUI(String PayType, String Domain) throws Exception {			
		tripRef = getNewDate_TripID();
		resp = payUIget(PayType, Domain, tripRef);
		if(Domain.equalsIgnoreCase("AE")) {
			qaurl=qaurlae;
		}else if(Domain.equalsIgnoreCase("BH")) {
			qaurl=qaurlbh;
		}else if(Domain.equalsIgnoreCase("KW")) { 
			qaurl=qaurlkw;
		}else if(Domain.equalsIgnoreCase("OM")) {
			qaurl=qaurlom;
		}else if(Domain.equalsIgnoreCase("QA")) {
			qaurl=qaurlqa;
		}else if(Domain.equalsIgnoreCase("SA")) {
			qaurl=qaurlsa;
		}else if(Domain.equalsIgnoreCase("US")) {
			qaurl=qaurlus;
		}
		Url = qaurl+ fetchPaymentURL(resp);
		System.out.println(fetchPaymentURL(resp));
		if(Domain.contains("FLYIN")) {
			Url = qaurlFlyin+ fetchPaymentURL(resp);			
		}		
		Reporter.log("Payment URL : " +Url);
		//System.out.println("Payment URL : " +Url);
		String TripID = fetchPaymentTripID(resp);
		Reporter.log("TripID : "+TripID);	
		if(!Url.contains("pay")) {
			Reporter.log("Pay URL is not created - Failing the script");
			//System.out.println("Pay URL is not created - Failing the script"+Url);
			Assert.assertTrue(false);			
		}
		if(textPresent(driver, "Oops, Something went wrong", 5)) {
			Reporter.log("Oops, Something went wrong");
			Assert.assertTrue(false);
		}
		Reporter.log("URL : "+Url);
		//System.out.println("URL : "+Url);
		return Url;
	}
	

	public String fetchPaymentURL(Response resp){
		String payurl="";
		JsonPath jsonPathEvaluator = resp.jsonPath();
		payurl = jsonPathEvaluator.getString("payment_url");
		System.out.println(resp);
		if(payurl.equals(null)) {
			Reporter.log("Pay URL is not created - Failing the script");
			Assert.assertTrue(false);			
		}
		return payurl;
	}
	
	public String fetchPaymentTripID(Response resp){
		String tripID="";
		JsonPath jsonPathEvaluator = resp.jsonPath();
		tripID = jsonPathEvaluator.getString("trip_ref");
		return tripID;
	}

	public Response validation_ROR(String payType, Response resp){
		Reporter.log("Response body "+payType +" : "+ resp.body().asString());
	//	System.out.println("Response body "+payType +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();	
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();		
		if(statusCode!=200) {
				Assert.assertTrue(false);
		}
		
		
		if(payType.equalsIgnoreCase("ReportingPaginate")) {
			String str_resp = resp.body().asString();			
			if(!str_resp.contains("page_size")) {
				Assert.assertTrue(false);
			}			
		}
		
		else if(payType.equalsIgnoreCase("BasicValidaton")) {
			String status = jsonPathEvaluator.getString("status");
			String description = jsonPathEvaluator.getString("description");
			if(!status.equals("S")) {
				Assert.assertTrue(false);
			}  
			if(!description.equals("Successfully fetched")) {
				Assert.assertTrue(false);
			}
		}
		
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundUploadFetch")) {
			String str_resp = resp.body().asString();			
			if(!str_resp.contains("refund_amount")) {
				Assert.assertTrue(false);
			}		
		}
			
		else if(payType.equalsIgnoreCase("ReportingPaginate")) {
			String redirection = jsonPathEvaluator.getString("redirection_required");
			String Response = jsonPathEvaluator.getString("response_message");
			Reporter.log("redirection required " +redirection);
			Reporter.log("Response " +Response);
			if(!redirection.equals("[Y]")) {
				Assert.assertTrue(false);
			}  
			if(!Response.equals("")) {
				Assert.assertTrue(false);
			}
		}
		return resp;
	}
	
	public String paygetAuth() throws Exception {
		/*int randomNumber= PaymentUI_CommonUtilities.generateFiveDigitRandomNumber();
		String randNumber= Integer.toString(randomNumber);
		String tripRef= "Q201" + randNumber;
		*/
		String URL = "/paymentservice/test/getHash?tripRef="+tripRef+"&itineraryId=NI685a33347e-464c-4a27-86c9-200710101330&amount=500&productType=DOMESTIC_AIR";
		RestAssured.baseURI = urlPay;
		String endPoint = URL;		
		Response response = null;
		response = RestAssured.given().when().log().all().get(endPoint);
		String payAuth = response.asString();
		return payAuth;
	}
	
	public String paygetAuth_FullGV() throws Exception {
		/*int randomNumber= PaymentUI_CommonUtilities.generateFiveDigitRandomNumber();
		String randNumber= Integer.toString(randomNumber);
		String tripRef= "Q201" + randNumber;
		*/
		String URL = "/paymentservice/test/getHash?tripRef="+tripRef+"&itineraryId=NI685a33347e-464c-4a27-86c9-200710101330&amount=0&productType=DOMESTIC_AIR";
		RestAssured.baseURI = urlPay;
		String endPoint = URL;		
		Response response = null;
		response = RestAssured.given().when().log().all().get(endPoint);
		String payAuth = response.asString();
		return payAuth;
	}
	
	public String paygetAuth_SuperCoins() throws Exception {
		/*int randomNumber= PaymentUI_CommonUtilities.generateFiveDigitRandomNumber();
		String randNumber= Integer.toString(randomNumber);
		String tripRef= "Q201" + randNumber;
		*/
		String URL = "/paymentservice/test/getHash?tripRef="+tripRef+"&itineraryId=NI685a33347e-464c-4a27-86c9-200710101330&amount=110&productType=DOMESTIC_AIR";
		RestAssured.baseURI = urlPay;
		String endPoint = URL;		
		Response response = null;
		response = RestAssured.given().when().log().all().get(endPoint);
		String payAuth = response.asString();
		return payAuth;
	}
		
	public String paygetAuth_EMI() throws Exception {
		/*int randomNumber= PaymentUI_CommonUtilities.generateFiveDigitRandomNumber();
		String randNumber= Integer.toString(randomNumber);
		String tripRef= "Q201" + randNumber;
		*/
		String URL = "/paymentservice/test/getHash?tripRef="+tripRef+"&itineraryId=NI685a33347e-464c-4a27-86c9-200710101330&amount=5000&productType=DOMESTIC_AIR";
		RestAssured.baseURI = urlPay;
		String endPoint = URL;		
		Response response = null;
		response = RestAssured.given().when().log().all().get(endPoint);
		String payAuth = response.asString();
		return payAuth;
	}
	
	public Response payUIget(String payType, String PayType1, String tripRef) throws Exception {
		String endPoint = null;
		String params = null; 
		HashMap<String, Object> headers	= new HashMap<>();
		HashMap<String, Object> cookies	= new HashMap<>();
		if(common.value("payAuth").contains("false")||payType.contains("AirAmend")) {
			headers = headersForms();
			Reporter.log("Pay Auth header not added");
		} else headers = headersFormspay();			
		cookies = addCookies();
		Response response = null;
		if(payType.equalsIgnoreCase("BookApp/GetPay")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			int randomNumber= 1;
			String randNumber= Integer.toString(randomNumber);
			params = "{\"train_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Ms\",\"first_name\":\"Test\",\"last_name\":\"Test\"}],\"itinerary_details\":[{\"from_station_code\":\"SBC\",\"to_station_code\":\"MYS\",\"from_station_name\":\"KSR BENGALURU\",\"to_station_name\":\"MYSURU JN\",\"train_name\":\"BSB MYS EXP\",\"train_number\":\"16230\",\"departure_time\":\"2019-11-12T00:15:00\",\"arrival_time\":\"2019-11-12T02:45:00\",\"booking_class\":\"AC 2 Tier(2A)\",\"updated_availability\":\"AVAILABLE-0119\",\"quota\":\"General\",\"seatStatus\":true}],\"pricing_details\":[{\"other_railway_charges\":119.4,\"agent_service_charge\":40,\"total\":775.4,\"insuranceCharge\":0,\"currency\":\"INR\",\"pax_pay_info\":[{\"base_fare\":616,\"pax_count\":1,\"pax_type\":\"ADULT\"}]}],\"transaction_fee_details\":{\"CC\":{\"DEFAULT\":1.8},\"DC\":{\"DEFAULT\":1},\"NB\":{\"1\":1.1,\"2\":1.2,\"3\":1.1,\"23\":1.1,\"DEFAULT\":1.35},\"KC\":{\"DEFAULT\":0},\"DA\":{\"DEFAULT\":0},\"TW\":{\"DEFAULT\":1},\"UP\":{\"DEFAULT\":1}}},\"itinerary_id\":\"f25db800de1e0137664316217d236675\",\"ttl\":3600,\"trip_id\":45134538,\"app_ref1\":\"" + tripRef +"\",\"app_ref2\":74282510,\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":1212121212,\"landline\":1212121212,\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"payment\",\"username\":\"cltppayment@gmail.com\"},\"product_type\":\"TRAIN\",\"currency\":\"INR\",\"order_info1\":\"16230/SBC/MYS/2019111200:15:00\",\"order_info2\":\"Test Test\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"64891349\",\"email_id\":\"cltppayment@gmail.com\",\"d_plus_x_in_hours\":273,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/trains/itinerary/f25db800de1e0137664316217d236675/process_payment\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://trains-book-nget.cltp.com:9001/r3/trains/itinerary/f25db800de1e0137664316217d236675/book_internal\",\"params\":null},\"payment_category\":\"B\"}";;		
		}
		else if(payType.equalsIgnoreCase("BookApp/GetPayWithCookie")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = "{\"train_booking\":{\"traveller_details\":[{\"seq_no\":1,\"type\":\"ADT\",\"title\":\"Ms\",\"first_name\":\"Test\",\"last_name\":\"Test\"}],\"itinerary_details\":[{\"from_station_code\":\"SBC\",\"to_station_code\":\"MYS\",\"from_station_name\":\"KSR BENGALURU\",\"to_station_name\":\"MYSURU JN\",\"train_name\":\"BSB MYS EXP\",\"train_number\":\"16230\",\"departure_time\":\"2019-11-12T00:15:00\",\"arrival_time\":\"2019-11-12T02:45:00\",\"booking_class\":\"AC 2 Tier(2A)\",\"updated_availability\":\"AVAILABLE-0119\",\"quota\":\"General\",\"seatStatus\":true}],\"pricing_details\":[{\"other_railway_charges\":119.4,\"agent_service_charge\":40,\"total\":775.4,\"insuranceCharge\":0,\"currency\":\"INR\",\"pax_pay_info\":[{\"base_fare\":616,\"pax_count\":1,\"pax_type\":\"ADULT\"}]}],\"transaction_fee_details\":{\"CC\":{\"DEFAULT\":1.8},\"DC\":{\"DEFAULT\":1},\"NB\":{\"1\":1.1,\"2\":1.2,\"3\":1.1,\"23\":1.1,\"DEFAULT\":1.35},\"KC\":{\"DEFAULT\":0},\"DA\":{\"DEFAULT\":0},\"TW\":{\"DEFAULT\":1},\"UP\":{\"DEFAULT\":1}}},\"itinerary_id\":\"f25db800de1e0137664316217d236675\",\"ttl\":3600,\"trip_id\":45134538,\"app_ref1\":\"Q19020128945\",\"app_ref2\":74282510,\"customer_detail\":{\"ip_address\":\"119.82.106.202\",\"mobile\":1212121212,\"landline\":1212121212,\"email\":\"cltppayment@gmail.com\",\"first_name\":\"Cltp\",\"last_name\":\"payment\",\"username\":\"cltppayment@gmail.com\"},\"product_type\":\"TRAIN\",\"currency\":\"INR\",\"order_info1\":\"16230/SBC/MYS/2019111200:15:00\",\"order_info2\":\"Test Test\",\"source_type\":\"ACCOUNT\",\"high_risk\":false,\"country\":\"IN\",\"user_id\":\"64891349\",\"email_id\":\"cltppayment@gmail.com\",\"d_plus_x_in_hours\":273,\"app_return_info\":{\"url\":\"https://qa2.cleartrip.com/trains/itinerary/f25db800de1e0137664316217d236675/process_payment\",\"method\":\"POST\",\"book_internal\":true,\"book_internal_url\":\"http://trains-book-nget.cltp.com:9001/r3/trains/itinerary/f25db800de1e0137664316217d236675/book_internal\",\"params\":null},\"payment_category\":\"B\"}";;
			
		}
		
		else if(payType.equalsIgnoreCase("Air")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air2;
		}
		else if(payType.equalsIgnoreCase("AirNew")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1_new+tripRef+params_PayUI_Air2_New;
		}
		else if(payType.equalsIgnoreCase("AirEMI")){
			headers = headersFormspay_EMI();
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1_new+tripRef+params_PayUI_Air2_EMI;
		}
		else if(payType.equalsIgnoreCase("AirSUPERCOINS")){
			headers = headersFormspay_Supercoins();
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_SUPERCOINS1+tripRef+params_PayUI_SUPERCOINS;
		}
		else if(payType.equalsIgnoreCase("AirRT")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_AirRT;
		}
		else if(payType.equalsIgnoreCase("AirMC")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_AirMC;
		}
		else if(payType.equalsIgnoreCase("AirCoupon")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_Coupon1+tripRef+params_PayUI_Air_Coupon2;
		}
		else if(payType.equalsIgnoreCase("AirCouponCash")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_Coupon1+tripRef+params_PayUI_Air_CouponCashback;
		}
		
		
		else if(payType.equalsIgnoreCase("AirCouponWT")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_Coupon1+tripRef+params_PayUI_Air_CouponWT;
		}
		else if(payType.equalsIgnoreCase("AirGV")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_GV1+tripRef+params_PayUI_Air_GV2;
		}
		else if(payType.equalsIgnoreCase("AirGVFull")){
			headers = headersFormspay_FullGV();
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_GV1+tripRef+params_PayUI_Air_GV2_Full;
		}
		else if(payType.equalsIgnoreCase("AirRP")){
			headers = headersFormspay_FullGV();
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_RP1+tripRef+params_PayUI_Air_RP6;
		}
		else if(payType.equalsIgnoreCase("AirRPFull")){
			headers = headersFormspay_FullGV();
			endPoint = endPointgetPay;	
			params = params_PayUI_Air_RP1+tripRef+params_PayUI_Air_RP4;
		}
		else if(payType.equalsIgnoreCase("AirAmend")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = param_Air_Amendment_API1+tripRef+param_Air_Amendment_API2;
		}
		else if(payType.equalsIgnoreCase("AirAE")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_AE;
		}else if(payType.equalsIgnoreCase("AirAEAR")){ // Arabic
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_AE_AR;
		}else if(payType.equalsIgnoreCase("AirBH")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_BH;
		}else if(payType.equalsIgnoreCase("AirKW")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_KW;
		}else if(payType.equalsIgnoreCase("AirSA")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_SA;
		}else if(payType.equalsIgnoreCase("AirFlyin")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1_new+tripRef+params_PayUI_Air_Flyin;
		}
		else if(payType.equalsIgnoreCase("AirFlyinAR")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1_new_ar+tripRef+params_PayUI_Air_Flyin;
		}
		else if(payType.equalsIgnoreCase("AirSAAR")){ // Arabic
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_SA_AR;
		}
		
		else if(payType.equalsIgnoreCase("AirOM")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_OM;
		}else if(payType.equalsIgnoreCase("AirQA")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_QA;
		}else if(payType.equalsIgnoreCase("AirUS")){
			RestAssured.baseURI = urlPay;
			endPoint = endPointgetPay;	
			params = params_PayUI_Air1+tripRef+params_PayUI_Air_US;
		}
			response = RestAssured.given().
				when().log().all().body(params).headers(headers).post(endPoint);
			System.out.println("URL : "+urlPay+endPoint);
			//Reporter.log("Params : "+params);
			return response;
	}
	
	public Response rearchCtPay(String payType, String payType1) throws Exception{
		RestAssured.baseURI =urlCTPay;
		Response request = null;		
		String params = null;
		String url=null;
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();

		if(payType.equals("UPDATE")) {
			url = urlCTPay_UpdateClient;
			params = paramsctPay_UpdateClient;		
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(url);
		}
		else if(payType.equals("ADD")) {
			url =urlCTPay_ADD ; 
			String ranno = getRandomNos(4);

			String Date = getDateTime(1, "ssmm");

			params = paramsctPay_ADD+Date+paramsctPay_ADD1;		
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(url);
		}
		else if(payType.equals("GETURL")) {
			url =urlCTPay_Get ; 
			params = paramsctPay_GetURL;		
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(url);
		}
		else if(payType.equals("STATUS")) {
			url =urlCTPay_Status;
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(url);
		}
		else if(payType.equals("CreateURL")) {
			url =urlCTPay_CreateURL ; 
			params = paramsctPay_CreateURL;		
			request = RestAssured.given().
					when().
					log().all().
					body(params).
					headers(headers).
					post(url);
		}
		Reporter.log(urlCTPay);
		Reporter.log("Params : "+params);
		Reporter.log(url);
		return request;
	}	

	public Response refund(String payType, String RefundID) {
		RestAssured.baseURI = urlPay;
		String endPoint = null;
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;
		if(payType.equalsIgnoreCase("refund")) {
			endPoint = urlPay+url_RefundNEW_EndPoint+RefundID;
			if(common.value("PaymentServer").equalsIgnoreCase("old")) {
				endPoint = "http://paymentservice.cltp.com:9001/paymentservice/service/refund?refundids="+RefundID;
			}

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		Reporter.log(urlPay);
		Reporter.log(endPoint);
		return response;
	}

	public Response walletEndPoints(String payType, String cardId) {
		RestAssured.baseURI = urlrewards_validate;
		String endPoint = null;
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms_wallet();
		Response response = null;
		String params = null;
		if(payType.equalsIgnoreCase("wallet_getCards")) {
			endPoint =url_walletGetCards;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		if(payType.equalsIgnoreCase("wallet_validateCards")) {
			endPoint =url_walletValidateCards;
			response = RestAssured.given().
					when().log().all().headers(headers).post(endPoint);
		}
		if(payType.equalsIgnoreCase("wallet_storeCards")) {
			endPoint =url_walletStoreCards;
			response = RestAssured.given().
					when().log().all().headers(headers).post(endPoint);
		}
		if(payType.equalsIgnoreCase("wallet_deleteCards")) {
			endPoint =String.format(url_walletDeleteCards, cardId);
			response = RestAssured.given().
					when().log().all().headers(headers).post(endPoint);
		}
		Reporter.log(urlrewards_validate);
		Reporter.log("Params : "+params);
		Reporter.log(endPoint);
		return response;
	}

	public Response expressWay(String payType, String PayType1) {
		RestAssured.baseURI = urlPay;
		String endPoint = null;
		String params = null;
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;
		if(payType.equalsIgnoreCase("userDetails")) {
			endPoint = urlEW_UserDetails;	
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("getOutstanding")) {
			endPoint = urlEW_GetOutstandingAmt;	
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}			
		else if(payType.equalsIgnoreCase("otpIN")) {
			endPoint = urlEW_OptIn;	
			response = RestAssured.given().
					when().log().all().headers(headers).put(endPoint);
		}
		else if(payType.equalsIgnoreCase("payV3")) {
			endPoint = urlEW_PayV3;	
			params = paramsEW_PayV3;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("payMultiV3")) {
			endPoint = urlEW_PayV3;	
			params = paramsEW_PayMultiV3;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("pay")) {
			endPoint = urlEW_Pay;	
			params = paramsEW_Pay;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("Autodebit")) {
			endPoint = urlEW_AutoDebit;	
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("payMulti")) {
			endPoint = urlEW_Pay;	
			params = paramsEW_PayMulti;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("validate")) {
			endPoint = urlEW_Validate;	
			params = paramsEW_Validate;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}	

		else if(payType.equalsIgnoreCase("EW_AddAmt")) {
			endPoint = urlEW_AddAmt;	
			params = paramsEW_AddAmt;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).put(endPoint);
		}
		else if(payType.equalsIgnoreCase("refund")) {
			endPoint = urlEW_Refund;	
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("EW_Summary")) {
			endPoint = urlEW_Summary;	
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}

		Reporter.log(urlPay);
		Reporter.log("Params : "+params);
		Reporter.log(endPoint);
		return response;

	}

	public Response adcb (String payType, String PayType1) throws Exception {
		//RestAssured.baseURI = urladcb_validat;
		String endPoint = null;
		String params = null; 
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;
		String trackid = PayType1;
		//String track = "CLR"+ getRandomNo(8);

		if(payType.equalsIgnoreCase("checkBalance")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urladcb_checkbalance;	
			params = Paramsadcb_checkbalance1+trackid+Paramsadcb_checkbalance2;
			response = RestAssured.given(). 
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("sendOTP")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urladcb_sendOTP;	
			params = Paramsadcb_sendOTP1+trackid+Paramsadcb_sendOTP2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}			
		else if(payType.equalsIgnoreCase("validate")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urladcb_validate;	
			params = Paramsadcb_validate1+trackid+Paramsadcb_validate2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("pay")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urladcb_pay;	
			params = Paramsadcb_pay1+trackid+Paramsadcb_pay2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		Reporter.log(urlRewards);
		Reporter.log("Params : "+params);
		Reporter.log(endPoint);
		return response;

	}

	public Response reward(String payType, String PayType1) throws Exception {
		String endPoint = null;
		String params = null; 
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;
		String trackid = PayType1;
		payment_id.add(PlatformCommonUtil.generatePaymentID());
		trk_id.add("pay12341608"+PlatformCommonUtil.generateTrackID());
		if(payType.equalsIgnoreCase("ADCB_CheckBalance")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urladcb_checkbalance;	
			params = Paramsadcb_checkbalance1+trackid+Paramsadcb_checkbalance2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("ADCB_sendOTP")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urladcb_sendOTP;	
			params = Paramsadcb_sendOTP1+trackid+Paramsadcb_sendOTP2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}			
		else if(payType.equalsIgnoreCase("ADCB_validate")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urladcb_validate;	
			params = Paramsadcb_validate1+trackid+Paramsadcb_validate2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("ADCB_pay")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urladcb_pay;	
			params = Paramsadcb_pay1+trackid+Paramsadcb_pay2;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_CheckBalance")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_checkbalance;
			params = ParamsPayBackCheckBalance;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("PAYBACK_CheckBalance_card")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_checkbalance;
			params = ParamsPayBackCheckBalance_card;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_Validate")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urlreward_Validate;
			params = ParamsPayBack_Vaidate1;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_CheckEarnPoints")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_PayCheckEarnPoints; 
			params = ParamsPayBack_CheckEarnPoints;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_CheckMobileLinked")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_payback_CheckMobile_Linked;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_CheckCardLinked")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_payback_CheckCard_Linked;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}


		else if(payType.equalsIgnoreCase("PAYBACK_Pay")) {
			RestAssured.baseURI = urlrewards_validate;
			endPoint = urlreward_payback_pay;
			params = ParamsPayBack_Pay+trackid+ParamsPayBack_Pay1;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
				/*	else if(payType.equalsIgnoreCase("PAYBACK_Pay_WT")) {
						Random rand = new Random();
						int n = rand.nextInt(9999999);
						String trackid1 = Integer.toString(n);
						String track = "CLRTRP"+ trackid1;
						
						RestAssured.baseURI = urlrewards_payURI;
						endPoint = urlreward_payback_pay;
						params = ParamsPayBack_Pay+track+ParamsPayBack_PayWT;
						response = RestAssured.given().
								when().log().all().body(params).headers(headers).post(endPoint);
					}*/
		
		
		else if(payType.equalsIgnoreCase("PAYBACK_Pay_WT_MultiGV")) {
			Random rand = new Random();
			int n = rand.nextInt(9999999);
			String trackid1 = Integer.toString(n);
			String track = "CLRTRPG"+ trackid1;

			RestAssured.baseURI = urlrewards_validate;
			endPoint = urlreward_payback_pay;
			params = ParamsPayBack_Pay+track+ParamsPayBack_PayWTMulti+ParamsPayBack_PayWTMulti1;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_Pay_WT_MultiGV_CC")) {
			Random rand = new Random();
			int n = rand.nextInt(9999999);
			String trackid1 = Integer.toString(n);
			String track = "CLRTRPM"+ trackid1;

			RestAssured.baseURI = urlPay;
			endPoint = urlreward_payback_pay;
			params = ParamsPayBack_Pay+track+ParamsPayBack_PayCC;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_Earn")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_payback_earn;
			String track_id = trk_id.get(0);
			params = ParamsPayBack_Earn+track_id+ParamsPayBack_Earn1;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}	

		else if(payType.equalsIgnoreCase("PAYBACK_RedeemPoints")){
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_RewardRedeem;
			int rand_num= PlatformCommonUtil.getRandomNumber();
			String random_num = Integer.toString(rand_num);
			String track_id = "pay123419823" + random_num;
			int payment_id_redeem = payment_id.get(0);
			params = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"REDEEM\",\"paymentId\": " +payment_id_redeem+ ",\"trackId\": \"" + track_id + "\","+ "\"amount\":1,\"currency\":\"INR\",\"params\":{\"mobile\":\"9986696785\",\"tripRef\":\"Q191014530822\",\"pin\":\"6756\"}}";

			System.out.println("params : "+params);

			Reporter.log("params : "+params);
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}

		else if(payType.equalsIgnoreCase("PAYBACK_RefundPoints")){
			RestAssured.baseURI = urlRewards;
			endPoint = url_reward_RewardRefund;
			int rand_num= PlatformCommonUtil.getRandomNumber();
			String random_num = Integer.toString(rand_num);
			int uid_refund = 9331486;
			String str_uid = Integer.toString(uid_refund);
			String str_uid_new = str_uid + random_num;
			long uid = Long.parseLong(str_uid_new);
			int payment_id_refund = payment_id.get(0);
			//params = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"REFUND\",\"paymentId\": " +payment_id_refund+ ",\"uid\": " + uid + ","+ "\"amount\":1,\"currency\":\"INR\",\"params\":{\"customerName\":\"test\",\"tripRef\":\"Q191014530822\"}}";
			params = "{\"rewardsType\":\"PAYBACK\",\"rewardsRequestType\":\"REFUND\",\"paymentId\":43317987691,\"uid\":93314865678786346,\"amount\":1,\"currency\":\"INR\",\"params\":{\"customerName\":\"test\",\"tripRef\":\"Q191014530822\"}}";
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);

		}

		else if(payType.equalsIgnoreCase("PAYBACK_Forgotpassword")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_payback_ForgotPassword;
			params = ParamsPayBack_ForgotPassword;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		else if(payType.equalsIgnoreCase("PAYBACK_Reverseearn")) {
			RestAssured.baseURI = urlRewards;
			endPoint = urlreward_payback_reverseearn;
			String track_id = trk_id.get(0);
			params = ParamsPayBack_reverseearn+track_id+ParamsPayBack_reverseearn1;
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		Reporter.log(urlRewards);
		Reporter.log("Params : "+params);
		Reporter.log(endPoint);
		return response;			
	}

	public Response refunds (String payType, String PayType1, String tripid, String amount, Boolean isFullWalletRefund, String status) {
		RestAssured.baseURI = urlPay;
		String endPoint = null;
		String params = null; 
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;

		if(payType.equalsIgnoreCase("refunds_createrefund")) {
			String txnid = PayType1;
			endPoint = url_createrefundentry;
			params = String.format(Params_Createrefund,isFullWalletRefund,tripid,amount,txnid);			
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		if(payType.equalsIgnoreCase("refunds_updatestatus")) {
			String refundid = PayType1;
			endPoint = url_refundupdatestatus;
			params = String.format(Params_Updatestatus, refundid);
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		if(payType.equalsIgnoreCase("refunds_updatepgtxnid")) {
			Random rand = new Random();
			int n = rand.nextInt(9999999);
			String pgtxnid = Integer.toString(n);
			String refundid = PayType1;

			endPoint = url_refundpgtxnid;
			params = String.format(Params_Updatepgtxnid, refundid,pgtxnid );
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().body(params).headers(headers).post(endPoint);
		}
		if(payType.equalsIgnoreCase("refunds_getrecord")) {
			String refundid = PayType1;
			endPoint = url_refundgetrecord+refundid;
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}

		Reporter.log(urlPay);						
		Reporter.log(endPoint);			
		return response;
	}

	public Response bin_manager (String payType, String PayType1) {
		RestAssured.baseURI = url_Binmanager;
		String endPoint = null;
		HashMap<String, Object> headers	= new HashMap<>();
		headers = headersForms();
		Response response = null;
		if(payType.equalsIgnoreCase("Binmanager")) {
			endPoint = url_Binmanager;

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		Reporter.log(url_Binmanager);						
		Reporter.log(endPoint);		
		return response;
	}

	public Response Reporting (String payType, String PayType1) {
		RestAssured.baseURI = urlReporting;

		//Reporter.log(urlReporting);	 
		String endPoint = null;
		HashMap<String, Object> headers	= new HashMap<>();
		HashMap<String, Object> headers1	= new HashMap<>();
		headers = headersForms();
		headers1 = headersForms_Json();
		Response response = null;
		if(payType.equalsIgnoreCase("Reporting")) {
			endPoint = url_Reportingendpoint;
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("ReportingPAYID")) {
			endPoint = url_ReportingPaymentID;

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("Reporting_Pending_Refunds")) {
			endPoint = url_Reporting_Refund_Pending_Download;

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}


		else if(payType.equalsIgnoreCase("Reporting_Disabled_Refunds")) {
			RestAssured.baseURI =urlReporting;
			endPoint= urlReporting_Disabled_Refunds;
			Reporter.log(urlReporting+endPoint);
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		
		else if(payType.equalsIgnoreCase("Reporting_Disabled_Refunds_Json")) {
			RestAssured.baseURI =urlReporting;
			endPoint= urlReporting_Disabled_Refunds;
			Reporter.log(urlReporting+endPoint);
			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers1).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("ReportingRefundStatus")) {
			endPoint = url_ReportingRefund_StatusReport;

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("ReportingPAYID")) {
			endPoint = url_ReportingPaymentID;

			Reporter.log(endPoint);
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}
		else if(payType.equalsIgnoreCase("ReportingTS_V3")) {
			RestAssured.baseURI =urlReportingTS;

			Reporter.log(urlReportingTS);	
			endPoint = url_ReportingTS_V3;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	

		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V3_False")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReportingTS);	
			endPoint = url_ReportingTS_Archived_V3_False;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V3_True")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReportingTS);	
			endPoint = url_ReportingTS_Archived_V3_True;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
			
		else if(payType.equalsIgnoreCase("ReportingTS_Archived_V_New")) {
			RestAssured.baseURI =urlReporting_TS; //==============================//

			Reporter.log(urlReportingTS);	
			endPoint = url_ReportingTS_Archived_V_New;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		
		else if(payType.equalsIgnoreCase("ReportingPaginate")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingPaginate;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingPaginatePayType")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
	
			endPoint = url_ReportingPaginate_PayType;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountD")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_D;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountDDA")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_D_DA;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountSTnx")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_S_Txns;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountSTnxGw")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_S_Txns_Gw;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountSPayType")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_S_PayType;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountSPayTypeGw")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_S_PayType_GW;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountDCashCard")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_D_CashCard;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingRefundQCountPpayType")) {
			RestAssured.baseURI =urlReporting;

			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundQ_Count_P_PayType;
			response = RestAssured.given().
					when().log().all().headers(headers).get(endPoint);
		}	
		
		
		
		else if(payType.equalsIgnoreCase("ReportingRefundUploadFetchRefundID")) {
			RestAssured.baseURI =urlReporting;
			String Param = Params_Reporting_UpdloadQ_FetchBy_RefundID;
			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundUploadQ_fetch_RefundID;
			response = RestAssured.given().
					when().log().all().headers(headers).body(Param).post(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingRefundUploadFetchTripID")) {
			RestAssured.baseURI =urlReporting;

			String Param = Params_Reporting_UpdloadQ_FetchBy_TripID;
			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefundUploadQ_fetch_TripID;
			response = RestAssured.given().
					when().log().all().headers(headers).body(Param).post(endPoint);
		}	
		
		else if(payType.equalsIgnoreCase("ReportingStatusPost")) {
			RestAssured.baseURI =urlReporting;

			String Param = Params_Reporting_Refund_Status_Post;
			Reporter.log(urlReporting);	
			endPoint = url_ReportingRefund_Count_ID;
			response = RestAssured.given().
					when().log().all().headers(headers).body(Param).post(endPoint);
		}	
			
		Reporter.log(urlReporting+endPoint);		
		return response;
	}

	public ArrayList<String> db_Refund_Common(String RefundType) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "select ID from TM.REFUNDS where STATUS='P' AND REFUND_AMOUNT!=0 AND REFUND_TYPE ='"+RefundType+"' ORDER BY CREATED_AT desc";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}
		
	public ArrayList<String> db_Refund_Common_MySQL(String RefundType) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String MySQL_URL = "jdbc:mysql://172.17.4.15:3306/payment";
			String MySQL_User = "payment";
			String MySQL_Password = "P@yment@123";
			String query =  "select ID from payment.refunds where STATUS='P' AND REFUND_AMOUNT!=0 AND REFUND_TYPE ='"+RefundType+"' ORDER BY CREATED_AT desc";
			Connection myCon = DriverManager.getConnection(MySQL_URL, MySQL_User, MySQL_Password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}

	public ArrayList<String> MySQL_DB(String RefundType) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{

			String url = "jdbc:mysql://172.17.14.174:3306/payment";
			String user = "cleartrip";
			String password = "1nterl3av3";
			String query =  "select ctpay_id from ctpay_details where ORDER_ID ='T121212123344'";
			Connection myCon = DriverManager.getConnection(url, user, password);

			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}

	public ArrayList<String> db_get_Value() throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "select * from TM.REFUNDS where ID = 9187220";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					int colCnt = result.getColumnCount();
					for (int x = 1; x <= colCnt; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				} 
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}

	public ArrayList<String> db_Refund_Delete(String TripID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "Delete from tm.refunds where ID = "+TripID;
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);

				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_Refund_Delete_MySQL(String TripID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		{

			String MySQL_URL = "jdbc:mysql://172.17.14.174:3306/payment";
			String MySQL_User = "cleartrip";
			String MySQL_Password = "1nterl3av3";
			String query =  "Delete from payments.refunds where ID = "+TripID;
			

		    try (Connection myCon = DriverManager.getConnection(MySQL_URL, MySQL_User, MySQL_Password);
		        java.sql.PreparedStatement stmt = myCon.prepareStatement(query)) {
		      
		      stmt.setInt(1, 2);
		      stmt.executeUpdate();
		      
		      System.out.println("Record deleted successfully");
			
			
			//Connection myCon = DriverManager.getConnection(MySQL_URL, MySQL_User, MySQL_Password);
		/*	if (myCon != null) {
				ResultSet myRes = myCon.createStatement().execute

				myCon.close();
			} else
				Reporter.log("Connection not established");*/
		}catch (SQLException e) {
		      e.printStackTrace();
		}
		}
		return data;
	}
	
	public ArrayList<String> db_Refund_Delete_ID(String TripID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		if (common.value("PaymentDB").equalsIgnoreCase("ORACLE")) {
			data = db_Refund_Delete(TripID);
			
		} else {
			data = db_Refund_Delete_MySQL(TripID);
			}
			
		return data;
		
	}

	public ArrayList<String> db_Refund_Amazon(String RefundType) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "select R.ID from tm.REFUNDS R inner join tm.Payments P on R.STATUS='P' AND R.REFUND_TYPE ='TW' AND R.PAYMENT_ID= P.ID AND P.PAYMENT_SUBTYPE='AMAZON_WALLET' ORDER BY R.CREATED_AT desc";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}

	public ArrayList<String> db_Refund_StatusCC(String RefundID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "select STATUS from TM.REFUNDS where ID ="+RefundID;
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_Refund_StatusCC_MySQL(String RefundID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String MySQL_URL = "jdbc:mysql://172.17.4.15:3306/payment";
			String MySQL_User = "payment";
			String MySQL_Password = "P@yment@123";
			Connection myCon = DriverManager.getConnection(MySQL_URL, MySQL_User, MySQL_Password);
			String query =  "select STATUS from payment.REFUNDS where ID ="+RefundID;
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_Refund_Status(String RefundID) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		if (common.value("PaymentDB").equalsIgnoreCase("ORACLE")) {
			data = db_Refund_StatusCC(RefundID);
			
		} else {
			data = db_Refund_StatusCC_MySQL(RefundID);
			}
			
		return data;
		
	}
	
	public ArrayList<String> db_GV() throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		if (common.value("PaymentDB").equalsIgnoreCase("ORACLE")) {
			data = db_GV_Oracle();
			
		} else {
			data = db_GV_MySQL();
			}
			
		return data;
		
	}
		
	public ArrayList<String> db_CC() throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		if (common.value("PaymentDB").equalsIgnoreCase("ORACLE")) {
			data = db_Refund_Common("CC");
			
		} else {
			data = db_Refund_Common_MySQL("CC");
			}
			
		return data;
		
	}
	
	public ArrayList<String> db_GV_Oracle() throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			String url = "jdbc:oracle:thin:@172.17.4.101:1521/cleardb";
			String user = "tm";
			String password = "tm123clear";
			String query =  "select ID from tm.payments where Payment_Type='GV' AND status ='S' order by created_at desc";
			Connection myCon = DriverManager.getConnection(url, user, password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("Connection not established");
		}
		return data;
	}
	
	public ArrayList<String> db_GV_MySQL() throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{

			String MySQL_URL = "jdbc:mysql://172.17.4.15:3306/payment";
			String MySQL_User = "payment";
			String MySQL_Password = "P@yment@123";
			String query =  "select ID from payment.payments where Payment_Type='GV' AND status ='S' order by created_at desc";
			Connection myCon = DriverManager.getConnection(MySQL_URL, MySQL_User, MySQL_Password);

			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					for (int x = 1; x <= 1; x++) {
						String colName = result.getColumnName(x);
						String colValue = myRes.getString(x);
						Name.add(colName);
						data.add(colValue);
					}
				}
				myCon.close();
			} else
				Reporter.log("MYSQL Connection not established");
		}
		return data;
	}
	
	
	public Response validation_RewardPayback(String payType, Response resp) throws Exception{
		boolean isMatching = false;
		String status="";
		String description="";
		Reporter.log("Response body "+payType +" : "+ resp.body().asString());
		System.out.println("Response body "+payType +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();	
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if (payType.equalsIgnoreCase("PAYBACK_CheckBalance")) {				

			status = jsonPathEvaluator.getString("status");
			description = jsonPathEvaluator.getString("description"); 

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successfully fetched payback points amount")) {
				Reporter.log("status is : "+status);
				Reporter.log("Successfully fetched payback points amount - message is displayed ");
				isMatching = true;		
			}

			else{
				isMatching = false;
				Assert.assertTrue(isMatching);
			}

		}

		if(payType.equalsIgnoreCase("PAYBACK_CheckBalance_card")){
			status = jsonPathEvaluator.getString("status");
			description = jsonPathEvaluator.getString("description"); 

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successfully fetched payback points amount")) {
				Reporter.log("status is : "+status);
				Reporter.log("Successfully fetched payback points amount - message is displayed ");
				isMatching = true;
			}

			else{
				isMatching = false;
				Assert.assertTrue(isMatching);
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_CheckEarnPoints")){
			status =  jsonPathEvaluator.getString("status");
			description = jsonPathEvaluator.getString("description");

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successfully calculated earn points")){
				Reporter.log("status is : "+status);
				Reporter.log("Successfully calculated earn points");
				isMatching = true;
			}
			else{
				isMatching = false;
				Assert.assertTrue(isMatching);
			}

		}
		if(payType.equalsIgnoreCase("PAYBACK_CheckMobileLinked")){
			status = jsonPathEvaluator.getString("status");
			String isAccountLinked = jsonPathEvaluator.getString("isAccountLinked");

			if(status.equalsIgnoreCase("S") && isAccountLinked.equalsIgnoreCase("true")){
				Reporter.log("status is : "+status);
				Reporter.log("Payback Account is successfully linked to the mobile number");
				isMatching = true;
			}
			else{
				isMatching = false;
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_CheckCardLinked")){
			status = jsonPathEvaluator.getString("status");
			String isAccountLinked = jsonPathEvaluator.getString("isAccountLinked");

			if(status.equalsIgnoreCase("S") && isAccountLinked.equalsIgnoreCase("true")){
				Reporter.log("status is : "+status);
				Reporter.log("Payback Account is successfully linked to the card number");
				isMatching = true;
			}

			else{
				isMatching = false;	
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_Forgotpassword")){
			status= jsonPathEvaluator.getString("status");
			description= jsonPathEvaluator.getString("description");

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("PIN has been sent to your registered PAYBACK Mobile no:XXXXXX6785 and Email ID:kXXaXXkXXaX@cleartrip.com")){
				Reporter.log("status is : "+status);
				Reporter.log("Password pin successfully sent to the mobile number");
				isMatching=true;
			}
			else{
				isMatching=false;
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_RedeemPoints")){
			status= jsonPathEvaluator.getString("status");
			description= jsonPathEvaluator.getString("description");

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successfully redeemed points")){
				Reporter.log("status is : "+status);
				Reporter.log("Successfully redeemed points");
				isMatching=true;
			}

			else{
				isMatching=false;
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_RefundPoints")){
			status= jsonPathEvaluator.getString("status");
			description= jsonPathEvaluator.getString("description");

			if(status.equalsIgnoreCase("F") && description.contains("INSUFFICIENT POINTS for Refund")){
				Reporter.log("status is : "+status);
				Reporter.log("INSUFFICIENT POINTS for Refund");
				isMatching=true;
			}
			else{
				isMatching=false;
			}

		}

		if(payType.equalsIgnoreCase("PAYBACK_Earn")){
			status= jsonPathEvaluator.getString("status");
			description= jsonPathEvaluator.getString("description");

			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successful Payback earn transaction")){
				Reporter.log("status is : "+status);
				Reporter.log("Successful Payback earn transaction");
				isMatching=true;
			}

			else{
				isMatching=false;
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_Reverseearn")){
			status= jsonPathEvaluator.getString("status");
			description= jsonPathEvaluator.getString("description");


			if(status.equalsIgnoreCase("S") && description.equalsIgnoreCase("Successfully reversed Payback Earn transaction")){
				Reporter.log("status is : "+status);
				Reporter.log("Successful Payback reverse earn transaction");
				isMatching=true;
			}

			else{
				isMatching=false;
			}
		}

		if(payType.equalsIgnoreCase("PAYBACK_Validate")){
			String redirectionRequired = jsonPathEvaluator.getString("redirection_required");
			String responseMessage = jsonPathEvaluator.getString("response_message");
			redirectionRequired= redirectionRequired.replace("[", "");
			redirectionRequired= redirectionRequired.replace("]", "");
			
			responseMessage= responseMessage.replace("[", "");
			responseMessage= responseMessage.replace("]", "");
			
			if(redirectionRequired.equalsIgnoreCase("N") && responseMessage.equalsIgnoreCase("Reward Points validation successful")){
				Reporter.log("There is no redirection required as the card details are valid");
				Reporter.log("Reward Points validation successful");
				isMatching=true;
			}

			else{
				isMatching=false;
			}
		}
		Assert.assertTrue(isMatching);
		return resp;
	}


	public Response validation_PromoService(String payType, Response resp) throws Exception{
		boolean isMatching = false;
		String status="";
		Reporter.log("Response body "+payType +" : "+ resp.body().asString());
		//System.out.println("Response body "+payType +" : "+ resp.body().asString());
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(payType.equalsIgnoreCase("PromoTripRefAndId")){
			status = jsonPathEvaluator.getString("status");
			String currency = jsonPathEvaluator.getString("currency");
			if(status.equalsIgnoreCase("Active") && currency.equalsIgnoreCase("INR")){
				isMatching = true;
				Reporter.log("Status is showing as:" + " "+status);
				Reporter.log("Currency is showing as:" + " " +currency);
			}
		}

		if(payType.equalsIgnoreCase("PromoGroupFromPromoRef")){
			status = jsonPathEvaluator.getString("status");
			if(status.equals("ACTIVE")){
				List<HashMap<String,String>> promoListOfList = jsonPathEvaluator.get("promotions");
				for(HashMap<String,String> m : promoListOfList){
					if(m.get("status").equals("ACTIVE")){
						isMatching = true;
					}
					else if(String.valueOf(m.get("status")).equals("COMPLETE")){
						if(m.get("transactions")!=""){
							String transactions = String.valueOf(m.get("transactions"));
							if(transactions.contains("status=SUCCESS"))
								isMatching = true;
						}
					}

				}
			}

		}

		if(payType.equalsIgnoreCase("PromoFromTripRef")){
			List<String> status_list = jsonPathEvaluator.get("status");
			for(int i=0;i<status_list.size();i++){
				if(status_list.get(i).equalsIgnoreCase("COMPLETE")){
					List<List<HashMap<String,String>>> trans_Map = jsonPathEvaluator.get("transactions");
					for(List<HashMap<String,String>> m : trans_Map){
						if(m==null){
							Reporter.log("No transaction statuses are available");
						}
						else if(m.get(0).get("status").equals("SUCCESS")){
							isMatching= true;
						}
						else{
							Reporter.log("Status is a Failure");
						}
					}

				}

				else if(status_list.get(i).equals("ACTIVE")){
					isMatching= true;
				}

			}
		}

		if(payType.equalsIgnoreCase("PromoFromPromoId")){
			status = jsonPathEvaluator.get("status");
			if(status.equals("ACTIVE")){
				List<HashMap<String,String>> promoListOfList = jsonPathEvaluator.get("promotions");
				for(HashMap<String,String> m : promoListOfList){
					if(m.get("status").equals("ACTIVE")){
						isMatching = true;
					}
					else if(String.valueOf(m.get("status")).equals("COMPLETE")){
						if(m.get("transactions")!=""){
							String transactions = String.valueOf(m.get("transactions"));
							if(transactions.contains("status=SUCCESS"))
								isMatching = true;
						}
					}

				}
			}

		}

		if(payType.equalsIgnoreCase("PromoGroupsFromCreatedDate")){
			List<String> status_list = jsonPathEvaluator.get("status");
			if(status_list.get(0).equalsIgnoreCase("ACTIVE")){
				isMatching = true;
				/*List<List<HashMap<String,String>>> promo_status=  jsonPathEvaluator.get("promotions");
				isMatching = true;*/
			}
		}

		if(payType.equalsIgnoreCase("PromoGroupsForAUpdatedDate")){
			List<String> status_list = jsonPathEvaluator.get("status");
			if(status_list.get(0).equalsIgnoreCase("ACTIVE")){
				isMatching = true;
			}
		}

		if(payType.equalsIgnoreCase("PromoGroupsForACreatedAndUpdatedDate")){
			List<String> status_list = jsonPathEvaluator.get("status");
			for(int i=0;i<status_list.size();i++){
				if(status_list.get(i).equalsIgnoreCase("ACTIVE")){
					List<List<HashMap<String,Object>>> statuspromo = jsonPathEvaluator.get("promotions");
					for(List<HashMap<String,Object>> m : statuspromo){
						HashMap<String,Object> promoNewMap = m.get(0);
						if(promoNewMap.containsKey("transactions")){
							if(promoNewMap.get("transactions")!=null){
								List<HashMap<String,Object>> transStatusList = (List<HashMap<String, Object>>) promoNewMap.get("transactions");
								for(HashMap<String,Object> map : transStatusList){
									String transactionStatus="";
									if(map.containsKey("status"))
										transactionStatus = (String) map.get("status");
									if(transactionStatus.equals("SUCCESS"))
										isMatching = true;
								}
							}

						}

					}
				}
			}	
		}

		if(payType.equals("CreatePromo")){
			status = jsonPathEvaluator.getString("status");
			if(status.equalsIgnoreCase("DEACTIVE")){
				List<HashMap<String,Object>> status_promo = jsonPathEvaluator.get("promotions");
				for(HashMap<String,Object> m : status_promo){
					if(m.get("status").equals("DEACTIVE"))
						isMatching = true;
					else
						isMatching=false;
				}
			}
		}

		if(payType.equals("CreatePromoGroup")){
			status = jsonPathEvaluator.getString("status");
			if(status.equalsIgnoreCase("DEACTIVE")){
				List<HashMap<String,Object>> status_promo = jsonPathEvaluator.get("promotions");
				for(HashMap<String,Object> m : status_promo){
					if(m.get("status").equals("DEACTIVE"))
						isMatching = true;
					else
						isMatching=false;
				}
			}

		}

		if(payType.equals("ActivatePromo")){
			status = jsonPathEvaluator.getString("status");
			if(status.equalsIgnoreCase("ACTIVE")){
				List<HashMap<String,Object>> status_promo = jsonPathEvaluator.get("promotions");
				for(HashMap<String,Object> m : status_promo){
					//	if(m.get("status").equals("ACTIVE"))
					if(m.get("status").equals("PROMOTION_ALREADY_PROCESSED"))
								isMatching = true;
					else
						isMatching=false;
				}
			}
		}

		if(payType.equalsIgnoreCase("UpdatePromo")){
			status = jsonPathEvaluator.getString("status");
			if(status.equalsIgnoreCase("DEACTIVE")){
				List<HashMap<String,Object>> status_promo = jsonPathEvaluator.get("promotions");
				for(HashMap<String,Object> m : status_promo){
					if(m.get("status").equals("DEACTIVE"))
						isMatching = true;
					else
						isMatching=false;
				}
			}
		}
		
		if(payType.equalsIgnoreCase("Promo_Active_Cron")){
			if(!(resp.body().asString().contains("09986696785"))){
				Assert.assertTrue(false);
			}if(!(resp.body().asString().contains("kiran.kumar@cleartrip.com"))){
				Assert.assertTrue(false);
			}
		}


		return resp;
	}


	public static String tripRefForPromo(){
		int rand_num= PlatformCommonUtil.getRandomNumber();
		String random_num = Integer.toString(rand_num);
		String trip_ref = "Q180611" + random_num;
		return trip_ref;
	}


	public Response addWalletAmt(Response resp, String EmailID, int Amount, String Currency){
		RestAssured.baseURI =urlWallet;
		String url = "/payments/wallet/cashback?emailId="+EmailID+"&currency="+Currency+"&amount="+Amount+"&tripRef=Q190812462288";
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms();
		Response request;	

		System.out.println(url);
		request = 		
		RestAssured.given().
		when().
		log().all().
		headers(headers).
		get(url);
		System.out.println(request);
		return request;
	}
}



