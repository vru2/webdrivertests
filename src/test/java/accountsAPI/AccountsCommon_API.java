// Framework - Cleartrip Automation
// Author - Kiran Kumar


package test.java.  accountsAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
//import org.jetbrains.annotations.NotNull;
import org.testng.Reporter;

//import com.sun.javafx.collections.MappingChange.Map;

import test.java.domains.PlatformCommonUtil;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class 	AccountsCommon_API extends PlatformCommonUtil
{	
	String url_EndPoint_Trip  = "/trips/v2?trip=Q1901080092";
	String url_EndPoint_Mobile = "/trips/v2?mobile=7022651232";
	String url_EndPoint_Date = "/trips/v2?mobile=7411873374&t_date=12/03/2019";
	String url_PersonJson = "http://accounts.cltp.com:9001/r3/people/refresh_json?caller=true&from_accounts=true&username=ns.likhitha@cleartrip.com";
	String url_PersonJsonID = "http://accounts.cltp.com:9001/r3/people/refresh_json?caller=true&from_accounts=true&id=41699808";

	String url_IVR = "https://ivrqa.cleartrip.com";

	String url_Acct = "http://accounts.cltp.com:9001";

	//String url_NewAcct= "http://accounts-service-api.cltp.com:9001";

	String url_qa2 = "https://qa2.cleartrip.com:9001";

	String qaurl = "https://qa2new.cleartrip.com/";

	String url_Acct_Service_applesgnin = "http://172.29.23.236:9001/";

	String url_identity="https://qa2.cleartrip.com";

	String url_da= "http://hq-paydeposit.cltp.com:9001";

	String url_Identitymicro_service="http://identity-microservice.cltp.com:9001";

	String url_Acct_Service="http://accounts-service-api.cltp.com:9001";

	String url_Acct_service_worker = "http://accounts-service-worker.cltp.com:9001";

	String url_prod = "https://www.cleartrip.com";
	
	String url_Promotional_Service="http://172.29.23.245:9001";
	String url_Promotional_Service_domain ="http://promotional-service-api.cltp.com:9001";

	String url_ingestion_Service_domain = "http://ingestion-service.cltp.com:9001";

	String url_monetisation_Service_domain = "https://qa2new.cleartrip.com";

	String url_monetisation_Service = "http://monetisation-service.cltp.com:9001";
	
	String 	url_Acct_Service_gateway="https://platformqa2new.cleartrip.com";

	String url_userclassification="http://172.29.20.75:9001";

	String url_flyin="http://user-accounts.cltp.com:9001";

	String url_CreateWallet = "/people/13941099/wallet?caller=postman";
	String url_acctSanity = "/accountsR3/sanity_test";
	String url_AcctSanity_Prod="/accountsR3/sanity_test";
	String url_CmpProfile_Prod="/v1/company/search?id=5312500&caller=postman";
	String url_FetchBank_Prod="/r3/companies/5334580/bank_details?caller=postman";
	String url_GstDetails_Prod="/partial/account/user/gst?email_id=ns.likhitha@cleartrip.com";
	String url_AcctHealthtestURL_Prod="/accountsR3/health_test";
	String url_Userclassification_Health_Test_Url="/actuator/health";
	String url_Account_Service_Verify_Person="/account/people/verify?id=14029546&emailId=ns.likhitha@cleartrip.com&domain=www.cleartrip.com&companyId=110340";
	String url_Account_Service_UserController_VerifyAccount="/user/v1/account/verify/14029546";

	String url_Account_Service_Update_Personal_Details = "/external-api/user";

	String url_Traveller_Details_update = "/people/traveller/v2";
	String url_Account_Service_MobileLoginUpdatePersonaldetailsApi="/external-api/user";
	String url_Promotional_Service_SavenudgeAPI="/referral/nudge?action=HI_FIVE&type=RESULT_SEEN";
	String url_Account_Service_UserController_VerifyAccount_UsernotPresent="/user/v1/account/verify/1402954698";
	String url_Account_Service_People_UpdateUserRoles="/accounts/people/roles?userId=65214457";
	String url_Accounts_service_Company_DeleteGST="/company/v2/gst?id=836674&gstNumber=123459898";
	String url_Account_Service_Mongo_CacheReset="/user/v2/cache/1234";
	String url_Accounts_service_Company_DeleteGST_CompanyID_DomainName="/company/v2/gst?id=836674&domainName=expedia.travelbox99.com&gstNumber=hihi&gstId=123";
	String url_Flipkart_Accounts_service_Updateuser="/accounts/v3/people?partner=FLIPKART&referenceId=me123testing";
	String url_Account_Service_AuthforNonLoggedinUser="http://accounts-service-api.cltp.com:9001/user/v2/auth/otp?tripRef=Q210317918852&emailId=ns.likhitha@cleartrip.com&source=www.cleartrip.com";
	String url_Account_Service_AuthforNonLoggedinUser_InvalidTripID="/user/v2/auth/otp?tripRef=Q210318852&emailId=ns.likhitha@cleartrip.com&source=www.cleartrip.com";
	String url_Account_Service_AuthforNonLoggedinUser_HotelTrip="/user/v2/auth/otp?tripRef=Q210929161450&emailId=ns.likhitha@cleartrip.com&source=www.cleartrip.com";
	String url_Account_Service_AuthforNonLoggedinUser_VerifyOTP="/user/v2/auth/otp/verify?tripRef=Q210317918852&emailId=ns.likhitha@cleartrip.com&otp=76989&source=b2c&subSource=www.cleartrip.com";
	String url_Accounts_Service_VerifynonLoggedinUser="/user/v2/auth/otp/verify?tripRef=Q200102680540&emailId=ns.likhitha@cleartrip.com&otp=123455&source=b2c&subSource=www.cleartrip.com";
	String url_IdentityService_UpdatePassword_ForChangePasswordflow="/user/updatePassword";
	String url_Userclassification_Userdetails_emailid="/users/detail?email_id=test@cleartrip.com";
	String url_Userclassification_Gettripdetails_fromtripid="/users/trip?trip_id=Q200102680486";
	String url_UserInfo_Prod="/account/api/user_info?user_id=32553048&api_product_id=1040";
	String url_People_search_API_prod="/people/search?username=ns.likhitha@cleartrip.com&caller=postman";
	String url_UserProfile_Json_Prod="/people/14029546?caller=postman&source=B2C";
	String url_CompanyProfileRefresh_Prod="/r3/companies/refresh_json?skip_login_check=true&id=5312500&caller=air";
	String url_CompanyUsers_Prod="/account/company/users?domain_name=corpprod.cleartripforbusiness.com&filter=user_ids";
	String url_Company_vendormapping_prod="/account/companies/5231474/company_vendor_mapping";
	String url_autocomplete_prod="/account/people/auto_complete?name=sai";
	String url_deposit_account_search_prod="/account/deposit_account/search?linkable_type=Company&linked=false&domain_name=corpprod.cleartripforbusiness.com";
	String url_User_activestatus_prod="/people/status?username=ns.likhitha@cleartrip.com&cfw=true&caller=cfw_landing";
	String url_healthCheck = "/accountsR3/heart_beat";
	String url_depositAccount_search="/account/deposit_account/search?linkable_type=Company&linked=false&domain_name=ct.cleartripforbusiness.com";
	//String url_link_depositaccount="/account/deposit_account/link/v2";
	String url_depositAccount_walletbalance_check="/r1/account/9934/balance";
	String url_GSTDetails = "/r3/partial/account/user/gst?email_id=ns.likhitha@cleartrip.com";
	String url_get_cfwoptinstatus="/account/cfw/opt_in?emailId=ns.likhitha@cleartrip.com";
	String url_peopleautocomplete="/account/people/auto_complete?name=vivek";
	String url_get_cfwgstdocstatus="/account/cfw/gst_doc_status?emailId=ns.likhitha@cleartrip.com";
	String url_CmpProfile = "/v1/company/search?id=5264644&caller=postman";
	String url_UserJson = "/people/13952926?caller=postman&source=B2C";
	String url_CmpConfig = "/r1/v1/company/company_configs?caller=air&id=137536";
	String url_Cmpjsonfetch="/r3/companies/121?caller=air";
	String url_b2bcmpuserdetails="/account/companies/5266142/b2b/users_info?user_profile=true";
	String url_PeopleSearch = "/r3/people/search?username=sphurti.d@cleartrip.com&caller=postman";
	String url_FetchProfile = "/r3/people/search?username=test@test1.com&caller=postman&source=B2C";
	String url_CmpRefresh = "/r3/companies/refresh_json?caller=air&domain=test.cleartripforbusiness.com&skip_login_check=true";

	String url_FetchBank = "/companies/200748/bank_details?caller=postman";
	String url_FetchPeople = "/r3/account/people/id/fetch";
	String  url_Feedbackemail="people/feedback_email";
	String url_signinpostcall="/r3/externalapi/signin";
	String url_userprofile_externalAPI_Mobileapp="/externalapi/people?caller=postman";

	String url_b2bAddtraveler="/people?caller=CORP_USER_CREATE&mode=update";

	String url_b2csignin="/externalapi/signin";
	String url_b2csignin_prod="/externalapi/signin";
	String url_flyinsignin="/partners/signin";
	String url_Account_Service_PWA_SignIn_API="/signin";
	String url_flyinsigninV2="/partners/v2/signin";
	String url_flyinsigninV2_CleartripUser="/partners/v2/signin";	
	String url_Account_Service_MobileLogin_sendOTP_SIGNIN="/external-api/otp";
	String url_Manage_trips_OTP_API="/account/auth/otp?trip_ref=Q190827475876&email_id=ns.likhitha@cleartrip.com";
	String url_cfw_active_status="/activate/vOCNSWKS2uLqsDVH";
	String url_identtiyservice_getresource="/ctauth/resource";
	String url_flyinsignup="/partners/signup";
	String url_Account_Service_Update_User="/account/people/v2?domain=qa2new.cleartrip.com";
	String url_Account_Service_Cleartrip_confirmedtravlerwithActivestatus="/account/people/v2?domain=www.cleartrip.com";
	String url_IdentityService_ChangePassword="/user/changePassword?email=ns.likhitha@cleartrip.com";
	String url_IdentityService_RecaptchaAPI="/user/verify/captcha?domain=qa2.cleartrip.com&g-recaptcha-response=test";
	String url_Account_Service_CFW_StatusUpdateCall="/user/v2/cfw/optIn?emailId=ns.likhitha@cleartrip.com&userId=14029546&status=ENABLED";
	String url_IdentityService_ResetPassword="/user/resetPassword?email=ns.likhitha@cleartrip.com";
	String url_Account_Service_RegisterFLyinUserUpdate_OTPValidation="/account/people/v2?domain=www.flyin.com";
	String url_Account_Service_FLYIN_User_Update="/account/people/v2?domain=www.flyin.com";
	String url_Account_Service_Update_User_MobileNo_OTPValidaion="/account/people/v2?domain=qa2new.cleartrip.com";
	String url_Account_Service_MobileLogin_verifyOTP_SignIn="/external-api/otp/verify-action";
	String url_Account_Service_MobileLogin_NudgePersonaldetails="/external-api/nudge?type=PERSONAL_DETAILS";
	String url_Account_Service_MobileLogin_NudgeUpdateMobile="/external-api/nudge?type=UPDATE_MOBILE";
	String url_Account_Service_AppleSignin_uniqueId="/apple/signin";
	String url_Identity_service_RecaptchaAPI="/user/verify/captcha?domain=cleartrip.ae&g-recaptcha-response=test";
	String url_Account_Service_FetchContactData="/account/people/v2/fetch/contactData";
	String url_Account_Service_LinkDepositAccount="/account/v2/depositAccount/link?email=sai@test.com&depositAccountId=10367339&partner=CLEARTRIP";
	String url_Account_Service_Company_AddGSTwith_DomainName="/company/v2/gst?domainName=test.cleartripforbusiness.com";
	String url_Account_Service_Express_Checkout="/account/people/expressCheckout/enable?userId=65214677";
	String url_Account_Service_CreateWalletAPI="/account/people/createWallet";
	String url_Account_Service_Company_AddGSTwith_CompanyID="/company/v2/gst?id=110340";
	String url_Account_Service_Company_AddGSTwith_CompanyID_DomainName="/company/v2/gst?domainName=test.cleartripforbusiness.com&id=110340";
	String url_Account_Service_FetchPersonalData="/account/people/v2/fetch/personalData";
	String url_Account_Service_AppleSignin_WrapperAPI="/partners/signin/apple";
	String url_Account_Service_SendOTP_ToUsermobileNo="/account/people/send-mobile-otp";
	String url_Userclassification_parsingcsv="/users/data";
	String url_flyinsignupV2="/partners/v2/signup";
	String url_flyinresetpassword="/partners/account/reset_password";
	String url_flyinresetpasswordV2="/partners/account/resetPassword";
	String url_flyinforgetpassword="/partners/account/forgot_password";
	String url_flyinforgetpasswordV2="/partners/account/forgotPassword";
	String url_flyinusersearch="/partners/user/search";
	String url_flyinusersearchV2="/partners/v2/user/search";
	String url_partnercontroller_updatetraveller="/account/partner/people/v1/traveller";
	String url_travellercontroller_updatetraveller="/people/traveller";
	String url_flyinsocialsignup="/partners/social/signup";
	String url_flyinsocialsignupV2="/partners/v2/social/signup";
	String url_UserInfo = "/account/api/user_info?user_id=13939044&api_product_id=1040";
	String url_FetchCompany = "/account/companies/200748/company_vendor_mapping";
	String url_CompanyUsers= "/account/company/users?domain_name=eqc.agentbox.com&filter=user_ids";
	String url_DepositAcctSearch = "/account/deposit_account/search?linkable_type=Company&linked=true&domain_name=vinay.agentbox.com";
	String url_RoleInfo = "/account/roles/info";
	String url_FetchUserV2 = "/account/v2/people/search";
	String url_CompanyProfileRefresh = "/r3/companies/refresh_json?skip_login_check=true&id=206299&caller=air";
	String url_GenerateAPIKEY = "/r3/partners/profile/generate_api_key/anit.jkkl@gmail.com";
	String url_AcctRegister="r1/register?caller=true";
	String url_B2B_user_authentication="/users/authenticate";

	String url_Register = "/user/v2/register";

	String url_FK_Redirection = "/oauth2/redirectionInfo";
	String url_Apiconfig_postcall="/account/api_config";
	String url_Companyconfig_contactdata="/companies/121";
	String url_ForgotPasswordEmail="r3/reset?redirect=no";
	String url_fetchWallet="/account/wallet_balance?country=IN";
	String url_AccntHealthtest="/accountsR3/health_test";
	String url_partnercontroller_usersearch="/account/partner/people/v1/search?emails=test@flyin.com&partner=1";
	String url_Account_Service_Caching_Userprofilejson_Email="/account/people/v2/fetch?docRequired=true&savedCards=false&travellersRequired=true&userPreference=true&emailId=ns.likhitha@cleartrip.com&domain=qa.cleartrip.com";
	String url_Account_Service_Caching_Userprofilejson_ID="/account/people/v2/fetch?docRequired=true&savedCards=false&travellersRequired=true&userPreference=true&emailId=ns.likhitha@cleartrip.com&domain=www.cleartrip.com";
	String url_peoplecontroller_getuserbyemail="/account/people?docRequired=false&email=kirti.pandey@cleartrip.com&partner=1&travellersRequired=false&userPreference=false";
	String url_peoplecontroller_getuserbyid="account/people/7707500017642?docRequired=false&partner=1&travellersRequired=false&userPreference=false";
	String url_Account_Service_PWA_GetUserbyID="/account/people/v2/14029546?docRequired=false&savedCards=true&travellersRequired=true&userPreference=true";

	String url_Account_Service_GST_AutoComplete = "/gst/v2/autocomplete?domainName=demo.cleartripforbusiness.com&gstNumberSubString=1";

	String url_Account_Service_GST_AutoCompleteInvalid = "/gst/v2/autocomplete?gstNumberSubString=1";
	String url_Account_Service_FetchcompanyBy_depositaccountID="/company/v2/deposit-account/121";
	String url_Account_Service_Depositaccountsearch_WOTlinkedparam="/account/v2/depositAccount/search?domainName=demo.cleartripforbusiness.com&linkableType=Company";
	String url_Account_Service_Depositaccountsearch_Withlinkedparam="/account/v2/depositAccount/search?linkableType=Company&linked=true&domainName=manjunathdj20-09-2017 12:49";
	String url_Account_Service_GSTV2_SearchAPIwithGstNo_ID="/gst/v2?gstNumber=29AAAAA0000A1Z5&linkableType=Person";

	String url_AS_GSTV2_InvalidSearch = "/gst/v2?linkableType=Person";
	String url_Account_Service_GstSearch_WithoutSubString="/gst/v2/autocomplete?domainName=demo.cleartripforbusiness.com";
	String url_Account_Service_CompanySearchAPI_withDomainname="/company/v2/search?domain=flyintest.cleartripforbusiness.com&usersRequired=true&travellersRequired=true";
	String url_Account_Service_CompanySearchAPI_internalDomainSearch="/company/v2/search?domain=www.cleartrip.com";
	String url_Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers="/company/v2/search?apiKey=test&usersRequired=true&travellersRequired=true";
	String url_Account_Service_CompanySearchAPIwithTagID="/company/v2/search?tagId=21004356";
	String url_Account_Service_CompanySearchAPIwithTagID_UsersandTravellers="/company/v2/search?tagId=21004356&usersRequired=true&travellersRequired=true";
	String url_Account_Service_CompanyConfig_GSTdetails="/company/v2/configs?id=836674";
	String url_Account_Service_CompanyConfig_GSTdetailswithDomainName="/company/v2/configs?domain=qa.amexindiatravel.com";
	String url_Account_Service_CompanyConfig_GetCompanybyID="/company/v2/profile/110340";

	String url_Account_Service_GetuserdetailsbyAPIKey="/account/people/v2/api-key/111test111?docRequired=true&savedCards=true&travellersRequired=true&userPreference=true";
	String url_Accounts_Service_AccountExits = "/accounts-api/people/v2/fetch?mobile=9908636704&countryCode=%2B91&domain=www.cleartrip.com";

	String url_Accounts_Service_AccountExits_Invalid = "/accounts-api/people/v2/fetch?mobile=9908636704&countryCode=%2B91&domain=www.cleartrip.com";

	//String url_Account_Service_GetuserdetailsbyAPIKey="company/v2/search?apiKey=test";
	// company/v2/search?apiKey=test
	String url_Accounts_Service_fetchuserdetails_withoutReferer="/people/v2/fetch/details?docRequired=true&savedCards=true&travellersRequired=true&userPreference=true";
	String url_Account_Service_CompanyConfig_GetCompanyConfigsbyID="/company/v2/configs?id=181";
	String url_Account_Service_CompanyVendorMapping="/company/v2/196440/vendor-mapping";
	String url_Account_Service_CompanySearchAPIwithAPIkey="/company/v2/search?apiKey=test";
	String url_Account_Service_GstSearch_WithSubString="/gst/v2/autocomplete?domainName=demo.cleartripforbusiness.com&gstNumberSubString=7";
	String url_Account_Service_MobileLogin_UserexistenceByMobileNo="/external-api/user-exists?mobile=7799964888&countryCode=+91&domain=www.cleartrip.com";
	String url_Account_Service_MobileLogin_FetchOldCTusersApi="/external-api/users";
	String url_Account_Service_FetchCustomer_number="/external-api/customer-no?domain=agencydemo3.agentbox.com";
	String url_Account_Service_CFW_GetUserStatus="/user/v2/cfw/optIn?userId=14029546";
	String url_Flipkart_Accounts_service_GetUserDetails="/accounts/v3/people?partner=FLIPKART&referenceId=me123testing8&travellersRequired=true&gstDetailsRequired=true";
	String url_Flipkart_Accounts_service_GetUserDetailsBy_UserID="/accounts/v3/people/65214414?travellersRequired=true&gstDetailsRequired=true";
	String url_Flipkart_Accounts_service_GetUserDetailsBy_UserID_withoutparams="/accounts/v3/people/65214414?travellersRequired=false&gstDetailsRequired=false";
	String url_Flipkart_Accounts_service_JWTtoken_flipkart="/auth/jwt/token?partner=FLIPKART";
	String url_Flipkart_Accounts_service_JWTtoken_Cleartrip="/auth/jwt/token?partner=CLEARTRIP";
	String url_Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams="/accounts/v3/people?partner=FLIPKART&referenceId=me123testing8&travellersRequired=false&gstDetailsRequired=false";
	String url_Account_Service_Fetchdomain_nameByID="/company/v2/110342/domain-name";
	String url_Account_Service_Company_DomainName_Autocomplete="/company/v2/domain-auto-completer?domain=test";
	String url_Account_Service_GetActivationKey="/user/v2/activation-key/65213401";
	String url_Promotional_Service_healthTestAPI="/actuator/health";
	String url_Promotional_Service_GenerateReferralLink="/referral/link?action=HI_FIVE";

	String url_Update_GST_Details = "accounts/external-api/gst";

	String url_Update_contact_data = "account/people/v2/update/contactData?userId=65214457";

	String url_Update_User_profile = "/company/v2/update/131304";

	String url_Update_UserJson =  "/account/people/v2?domain=http://www.flipkart.com";

	String url_Create_ct_auth = "/ct-auth/sessions?partner=FLIPKART&referenceId=IuTKN321C02F0A0FF4999B4CE0BA934F2E009YR1";

	String url_AccountMerge = "/retry/account-merge/date/2023-03-08T05:19:19.564Z?isWalletMerge=true&isTripsMerge=true";

	String url_WalletMerge = "/retry/account-merge/source/65247026/target/65247028?isWalletMerge=true&isTripsMerge=true";

	String url_FKVIP_Injest_Profile = "/ingest/v1/flipkart/profile";


	String url_FKVIP_Discover_API = "/cohort/v1/benefits/191121006/fetch";

	String url_Floater_Get_API = "/monetisation/v1/floater/fetch";

	String url_Floater_SaveImpression = "/monetisation/v1/floater/impression";

	String url_FLoater_AddTemplate = "/floater/template/add";

	String url_FKVIP_Redeem_API = "/cohort/v1/benefits/redeem";

	String url_FKVIP_Invalid_Rollback_API = "/cohort/v1/benefits/rollback";

	String  url_FKVIP_Active_Entity = "/cohort/v1/entity/fetch";

	String url_FKVIP_GetBenefitDetails_API = "/cohort/v1/benefits/data/Q906523733692";


	String url_Promotional_Service_ValidatereferralLink="/referral/validate?action=HI_FIVE&referralLink=https://qa2m.cltp.in/ref/Q2hQr8bl";
	String url_Promotional_Service_ValidateInvalidReferralLink="/referral/validate?action=HI_FIVE&referralLink=https://qa2m.cltp.in/ref/Q2hQr8bleeee";
	String url_Promotional_Service_GetReferradetailsHQ="/referral/history?action=HI_FIVE&peopleId=65262210";
	String url_Promotional_Service_GetReferradetailsAPI="/referral/details?action=HI_FIVE";

	String url_Promotional_Service_GetConfigAPI="resource/stageConfig";

	String url_Promotional_Service_Getreferralhistory="/referral/history?action=HI_FIVE&peopleId=65261422";

	String url_Fetch_details = "people/v2/fetch/details";

	String url_SignOut_Api = "/signout-redirect";

	String url_Session_Status = "/ct-auth/sessions/CT_b8238860-7e60-47a6-a655-d6b5b14a935e/users/65269357";

	String url_Active_session_status = "/ct-auth/sessions/CT_a2840adc-3feb-40aa-9ca1-a25f97ea69ba/users/65262258";

	String url_Promotional_Service_RefreshStageConfig="/resource/refresh/stageConfig?programType=HI_FIVE";

	String url_Account_Service_GET_UserbyCookie_CleartripUser="/external-api/v2/user";
	String url_Account_Service_AgencyLogo="/company/logo?id=100161";
	String url_Account_Service_UserExistence_withEmailIDandDomain="/external-api/user-exists?emailId=ns.likhitha@cleartrip.com&domain=www.cleartrip.com";
	String url_Account_Service_UserExistence_withID="/external-api/user-exists?id=6510909";
	String url_Account_Service_GSTV2_SearchAPIwithGstNoAndGstID="/gst/v2?id=203&gstNumber=29aaaaa0000a1Z5&linkableType=Person";
	String url_Account_Service_Peoplecontroller_FindByID="/account/people/entity/65206686";
	String url_Account_Service_AuthorizeAPI_encodingCookie="/account/people/authorize";

	String url_Account_Service_Get_Traveller_Details = "/external-api/v2/user?travellersRequired=true";
	String url_IdentityService_ctAuth_noLoginCookie="/user/ct-auth-no-login?email=testtoken@privaterelay.appleid.com.com&tripRef=Q200302760880";
	String url_Account_Service_PWA_GetUser_Byemail="/account/people?docRequired=true&email=priyankapukale259@gmail.com&partner=0&savedCards=true&travellersRequired=true&userPreference=false";
	String url_Account_Service_EmailVerification_API="/user/v2/email_verified_status?username=ns.likhitha@cleartrip.com";
	String url_IdentityService_PeopleController_gt_token_for_userBy_ID="/user/token?userId=14029546";
	String url_IdentityService_PeopleController_gt_token_for_userBy_Email="/user/token?username=testtoken@flyin.com";
	String url_IdentityService_PeopleController_gt_token_for_userBy_Private_EmailandID="/user/token?username=testtoken@privaterelay.appleid.com.com&userId=65203482";
	String url_peoplecontroller_getuserbyid_v2="/account/people/v2/41623980?docRequired=true&savedCards=true&travellersRequired=true&userPreference=true";
	String url_apiConfig_APIkey="/account/api_config?api_key=d4beada793e93d93fcd432141709400f";
	String  url_b2bgetTravelerURL="/companies/b2b/101/travellers?sourceType=corp&titleType=adult";


	String url_createUpdateGST="/partial/account/user/gst?email_id=ns.likhitha@cleartrip.com";
	String url_cleartripForWorkOptin="/account/cfw/opt_in";
	String url_screencaptureInitiate="/sc_external_api/initiate";
	String url_cfwgstdocstatusupdate="/account/cfw/gst_doc_status";
	String url_identityserviceaddclient="/ctauth/client";
	String flip=RandomStringUtils.randomAlphabetic(3);
	String url_Flipkart_Accounts_Service_CreateUser="/accounts/v3/people?partner=FLIPKART&referenceId=nakkjultestqa"+flip;
	String url_Flipkart_Accounts_service_CreateUser_ExistingUser="/accounts/v3/people?partner=FLIPKART&referenceId=nakultestqa";
	String url_identityservicesignin="/signin";
	String url_IdentityService_Signin_Userauthentication_B2C_B2B="/user/authenticate?docRequired=true&savedCards=true&travellersRequired=true&userPreference=true";
	String url_IdentityService_Signin_Userauthentication_B2C_B2B_b2cUserwithoutParams="/user/authenticate";
	String url_registerUser="/expressway-register";
	String url_externalApi_Refreshtoken="/r3/account/external_api/refresh_token";
	String url_createUpdateTraveller="/people/externalapi/41623878/create_update_travellers?caller=Android%20App%2017.11.2";
	String url_createTraveller="/people/externalapi/41623878/create_update_travellers?caller=Android&user_profile=true";
	String url_createCompanyTags="/r3/companies/121/tags";
	String url_createUpdateTraveller_bookstep2="/people/externalapi/41623878/create_update_travellers?caller=bookstep2";
	String url_AccountsInfoAPI_BasedonUserId="/v1/people/filters?caller=ct-suite";
	String url_Account_Service_AppleSignin="/apple/signin";

	String url_logout = "/external-api/v2/user?travellersRequired=false&docRequired=false&userPreference=false&savedCards=false";

	String params_CreateWallet = "{\"currency\":\"INR\", \"caller\":\"pay-refund\", \"id\":\"5682929\"}";
	String params_FetchPeople = "{\"email_ids\":[\"vinay.raj@cleartrip.com\",\"sathianarayanan.s@cleartrip.com\",\"kiran.kumar@cleartrip.com\",\"xyz1\"]}";
	String params_Feedbackemail="{\"email_id\":\"ns.likhitha@cleartrip.com\",\"msg\":\"test\",\"subject\":\"working\",\"email_type\":\"default\"}";
	String params_Signinpostcall="{\"email\":\"ns.likhitha@cleartrip.com\",\"password\":\"cleartrip123\",\"persistent_login\":\"t\",\"service\":\"\",\"caller\":\"homepage\",\"source\":\"ui\",\"action_type\":\"\",\"trip_ref\":\"\",\"_\": \"\"}";
	String params_Account_Service_AppleSignin="{\"appleId\":\"1:7676790:1100:009:jhjhdjdfjnfkmkggjuthgjfhghh\",\"emailId\":\"appleidt50chars@privaterelay.appleid.com\",\"firstName\":\"abcd\",\"lastName\":\"sai\",\"title\":\"Mr.\"}";
	String params_Account_Service_FetchContactData="[1,2,3,4]";
	String params_Account_Service_LinkDepositAccount="";
	String params_Account_Service_Company_AddGSTwith_DomainName="{\"gstHolderAddress\":\"okdomainautomation\",\"gstHolderName\":\"okdomainautomation\",\"gstHolderStateCode\":\"21\",\"gstHolderStateName\":\"okdomainautomation\",\"gstNumber\":\"1domainautomat\"}";
	String params_Account_Service_CreateWalletAPI="{\"userId\":65204276,\"currency\":\"BHD\"}";
	String params_Account_Service_Company_AddGSTwith_CompanyID="{\"gstHolderAddress\":\"okdomainautomation\",\"gstHolderName\":\"okdomainautomation\",\"gstHolderStateCode\":\"21\",\"gstHolderStateName\":\"okdomainautomation\",\"gstNumber\":\"1domainautomat\"}";
	String params_Account_Service_Company_AddGSTwith_CompanyID_DomainName="{\"gstHolderAddress\":\"okdomainautomation\",\"gstHolderName\":\"okdomainautomation\",\"gstHolderStateCode\":\"21\",\"gstHolderStateName\":\"okdomainautomation\",\"gstNumber\":\"1domainautomat\"}";

	String params_Accounts_Service_Applesignin_Unauthorized="{\"appleId\":\"saicharan@gmail.com\",\"emailId\":\"hi7@hi.appleid.com\",\"firstName\":\"abcd\",\"lastName\":\"sai\",\"title\":\"Mr.\"}";

	String params_Account_Service_AppleSignin_WrapperAPI="{\"appleId\":\"1:a:2:b:3:00\",\"emailId\":\"nakul@gmail.com\",\"firstName\":\"nakul\",\"lastName\":\"goyal\",\"title\":\"Mr.\"}";
	String params_Account_Service_SendOTP_ToUsermobileNo="{\"mobile\":\"+917799964888\",\"userId\":\"14029546\",\"countryCode\":\"91\"}";
	String params_b2csignin="{\"email\":\"ns.likhitha@cleartrip.com\",\"password\":\"cleartrip123\",\"persistent_login\":\"t\",\"service\":\"\",\"caller\":\"homepage\",\"source\":\"ui\",\"action_type\":\"\",\"trip_ref\":\"\",\"_\": \"\"}";
	String params_b2csignin_prod="{\"email\":\"ns.likhitha@cleartrip.com\",\"password\":\"Likhitha@143\",\"persistent_login\":\"t\",\"service\":\"\",\"caller\":\"homepage\",\"source\":\"ui\",\"action_type\":\"\",\"trip_ref\":\"\",\"_\": \"\"}";
	String params_IdentityService_ResetPassword="";
	String params_flyinsignin="{\"username\" : \"ok@cltp.com\",\"partner\":1,\"password\":\"cleartrip1\"}";
	String params_Account_Service_CFW_StatusUpdateCall="";
	String params_flyinsigninV2_CleartripUser="{ \"password\": \"cleartrip123\", \"partner\": 0, \"source\": \"home_page\", \"username\": \"ns.likhitha@cleartrip.com\", \"persist_login\": false}";
	String params_Promotional_Service_GenerateReferralLink="";

	String params_Update_GST_Details = "{\n" +
			"   \"id\": 21257,\n" +
			"  \"gstNumber\": \"29AAAAA1111A1A0\",\n" +
			"  \"gstHolderName\": \"okok\",\n" +
			"  \"gstHolderAddress\": \"okok\",\n" +
			"  \"gstHolderStateCode\": \"1111\",\n" +
			"  \"gstHolderStateName\": \"okok\"\n" +
			"}\n";

	String params_Update_Contact_Data = "{\n" +
			"    \"userId\": 65214024,\n" +
			"    \"contactData\": {\n" +
			"        \"phoneNumbers\": [\n" +
			"            {\n" +
			"                \"mobileNumber\": \"9899889889\",\n" +
			"                \"category\": \"mobile\"\n" +
			"            }\n" +
			"        ],\n" +
			"        \"addresses\": [\n" +
			"            {\n" +
			"               \"city\": \"vijayawada\",\n" +
			"                \"cityId\": 1111,\n" +
			"                \"country\": \"India\",\n" +
			"                \"countryId\": 1111,\n" +
			"                \"pincode\": \"123456\",\n" +
			"                \"state\": \"maharashtra\",\n" +
			"                \"stateId\": 1111,\n" +
			"                \"streetAddress\":\"street\",\n" +
			"                \"category\": \"test\",\n" +
			"                \"seqNo\": \"1\"\n" +
			"            },\n" +
			"            {\n" +
			"                \"city\": \"bangalore\",\n" +
			"                \"country\": \"India\",\n" +
			"                \"pincode\": \"505505\",\n" +
			"                \"state\": \"karnataka\",\n" +
			"                \"streetAddress\": \"jpnagar\",\n" +
			"                \"category\": \"home\"\n" +
			"            }\n" +
			"        ],\n" +
			"        \"emails\": [\n" +
			"            {\n" +
			"                \"emailId\": \"temp@test.com\",\n" +
			"                \"category\": \"work\",\n" +
			"                   \"seqNo\": 11\n" +
			"            },\n" +
			"            {\n" +
			"                \n" +
			"                \"emailId\": \"okok@test.com\",\n" +
			"                \"category\": \"work\",\n" +
			"                   \"seqNo\": 11\n" +
			"            }\n" +
			"        ],\n" +
			"        \"otherDetails\": [\n" +
			"            {\n" +
			"                \"category\": \"chat\",\n" +
			"                \"name\": \"yahoo\",\n" +
			"                \"value\": \"testChat\",\n" +
			"                \"seqNo\": 12\n" +
			"            },\n" +
			"            {\n" +
			"                  \n" +
			"                \"category\": \"test\",\n" +
			"                \"name\": \"hi\",\n" +
			"                \"value\": \"testChat\",\n" +
			"                \"seqNo\": 12\n" +
			"            }\n" +
			"        ],\n" +
			"        \"websites\": [\n" +
			"            {\n" +
			"                \"category\": \"work\",\n" +
			"                \"url\": \"www.work.com\",\n" +
			"                \"seqNo\": 11\n" +
			"            },\n" +
			"             {\n" +
			"                \"category\": \"work\",\n" +
			"                \"url\": \"http://test.work.com\",\n" +
			"                \"seqNo\": 11\n" +
			"            }\n" +
			"        ]\n" +
			"    }\n" +
			"}";

	String params_Update_Invalid_GST_Details = "{\n" +
			"   \"id\": 21257,\n" +
			"  \"gstNumber\": \"2AAAAA1111A1A0\",\n" +
			"  \"gstHolderName\": \"okok\",\n" +
			"  \"gstHolderAddress\": \"okok\",\n" +
			"  \"gstHolderStateCode\": \"1111\",\n" +
			"  \"gstHolderStateName\": \"okok\"\n" +
			"}\n";

	String params_Create_Ct_auth = "";

	String params_jsonEmpty = "{}";

	String params_json = "{\n" +
			"  \"id\": 65270513,\n" +
			"  \"travellerDetails\": [\n" +
			"    {\n" +
			"      \"personalDetails\": {\n" +
			"        \"firstName\": \"Mansur1\",\n" +
			"        \"gender\": \"Male\",\n" +
			"        \"lastName\": \"Ansari\",\n" +
			"        \"title\": \"Mr\",\n" +
			"        \"paxType\": \"ADT\",\n" +
			"        \"maritalStatus\":\"SINGLE\"\n" +
			"      },\n" +
			"      \"isRegistered\": false\n" +
			"    }\n" +
			"  ]\n" +
			"}";


	String params_Update_Profile_Data = "{\n" +
			"    \"about\": \"tree1\",\n" +
			"    \"address1\": \"treesiv\",\n" +
			"    \"address2\": \"treesiv\",\n" +
			"    \"annualTravelBudget\": \"21\",\n" +
			"    \"channelType\": \"1\",\n" +
			"    \"city\": \"treesiv\",\n" +
			"    \"companyWebsite\": \"http://treesiv.cltp.com\",\n" +
			"    \"country\": \"India\",\n" +
			"    \"custServiceEmail\": \"treesiv@gmail.com\",\n" +
			"    \"custServicePhone\": \"1234567890\",\n" +
			"    \"effectiveFrom\": \"2011-12-08\",\n" +
			"    \"effectiveTo\": \"2033-12-08\",\n" +
			"    \"groupName\": \"treesiv\",\n" +
			"    \"name\": \"treesiv\",\n" +
			"    \"panCardDetails\": \"treesiv\",\n" +
			"    \"serviceNo\": \"1\",\n" +
			"    \"siteDescription\": \"treesiv\",\n" +
			"    \"siteName\": \"treesiv\",\n" +
			"    \"state\": \"treesiv\",\n" +
			"    \"status\": \"1\",\n" +
			"    \"tinNumber\": \"ATN1234\",\n" +
			"    \"zip\": \"treesiv\",\n" +
			"    \"contactData\": {\n" +
			"        \"phoneNumbers\": [\n" +
			"            {\n" +
			"                   \"mobileNumber\": \"111111\",               \n" +
			"                \"mobileCountryCode\": \"9198\",\n" +
			"                \"category\": \"mobile\",\n" +
			"                \"phoneNumberValue\": \"1\",\n" +
			"                \"seqNo\": \"1\"\n" +
			"            },\n" +
			"            {\n" +
			"                   \"mobileNumber\": \"122222222\",               \n" +
			"                \"mobileCountryCode\": \"+481\",\n" +
			"                \"category\": \"mobile\",\n" +
			"                \"phoneNumberValue\": \"1\",\n" +
			"                \"seqNo\": \"1\"\n" +
			"            }\n" +
			"             \n" +
			"            \n" +
			"        ],\n" +
			"        \"whatsappDetails\": [\n" +
			"            {\n" +
			"               \n" +
			"                \"mobileNumber\": \"0000000\",\n" +
			"                \"status\": \"A\"\n" +
			"            },\n" +
			"             {\n" +
			"                \"mobileNumber\": \"2222\",\n" +
			"                \"status\": \"B\"\n" +
			"            }\n" +
			"        ],\n" +
			"        \"addresses\": [\n" +
			"           \n" +
			"            {\n" +
			"                \"city\": \"vijayawada\",\n" +
			"                \"cityId\": null,\n" +
			"                \"country\": \"India\",\n" +
			"                \"countryId\": null,\n" +
			"                \"pincode\": \"123456\",\n" +
			"                \"state\": \"maharashtra\",\n" +
			"                \"stateId\": null,\n" +
			"                \"streetAddress\":\"street\",\n" +
			"                \"category\": \"test\",\n" +
			"                \"seqNo\": \"1\"\n" +
			"            },\n" +
			"              {\n" +
			"                \"city\": \"vja\",\n" +
			"                \"cityId\": null,\n" +
			"                \"country\": \"India\",\n" +
			"                \"countryId\": null,\n" +
			"                \"pincode\": \"123456\",\n" +
			"                \"state\": \"maharashtra\",\n" +
			"                \"stateId\": null,\n" +
			"                \"streetAddress\":\"street\",\n" +
			"                \"category\": \"test\",\n" +
			"                \"seqNo\": \"1\"\n" +
			"            }\n" +
			"\n" +
			"        ],\n" +
			"        \"emails\": [\n" +
			"            \n" +
			"             {\n" +
			"                 \"id\":9804604,\n" +
			"                \"emailId\": \"ooooooo@aa.com\",\n" +
			"                \"category\": \"test\",\n" +
			"                \"seqNo\": null\n" +
			"            }\n" +
			"        ],\n" +
			"        \"otherDetails\": [\n" +
			"            {\n" +
			"                \"category\": \"testqa\",\n" +
			"                \"seqNo\": \"1\",\n" +
			"                \"name\": \"testqa\",\n" +
			"                \"value\": \"testqa\"\n" +
			"            }\n" +
			"        ],\n" +
			"        \"websites\": [\n" +
			"           \n" +
			"            {\n" +
			"                \"category\": \"Atest\",\n" +
			"                \"seqNo\": 4,\n" +
			"                \"url\": \"http://qa2.cleartrip.com\"\n" +
			"            }\n" +
			"        ]\n" +
			"    },\n" +
			"    \"companyConfigs\": [\n" +
			"        {\n" +
			"            \"configName\": \"test12345\",\n" +
			"            \"configValue\": \"test123456\",\n" +
			"            \"createdBy\": null,\n" +
			"            \"updatedBy\": null\n" +
			"        }\n" +
			"    ],\n" +
			"    \"depositAccounts\": [\n" +
			"        \n" +
			"        {\n" +
			"            \"id\": 11111110\n" +
			"        }\n" +
			"    ]\n" +
			"}\n";

	String params_Account_Wallet_merge = "";
	String params_FKVIP_injest_profile= "{\n" +
			"    \"eventType\": \"ACTIVATION\",\n" +
			"    \"membershipPIITierDetails\": {\n" +
			"        \"phoneNumber\": \"8692e1407354fcdc6af54b11a2b6188e950f0d2b0eccb12abb0979100c78ed9c\",\n" +
			"        \"campaignIds\": [\n" +
			"            \"CT_CAMP1\"\n" +
			"        ],\n" +
			"        \"membershipTierInfo\": {\n" +
			"            \"tier\": \"VIP\",\n" +
			"          \"start\": \"2023-09-10 23:00:00\",\n" +
			"            \"end\": \"2025-09-10 23:00:00\",\n" +
			"            \"membershipTenureDuration\": {\n" +
			"                \"duration\": 365,\n" +
			"                \"durationTimeUnit\": \"DAY\"\n" +
			"            }\n" +
			"        }\n" +
			"    }\n" +
			"}";

	String params_FKVIP_injest_profileEXPIRY= "{\n" +
			"    \"eventType\": \"EXPIRY\",\n" +
			"    \"membershipPIITierDetails\": {\n" +
			"        \"phoneNumber\": \"8692e1407354fcdc6af54b11a2b6188e950f0d2b0eccb12abb0979100c78ed9c\",\n" +
			"        \"campaignIds\": [\n" +
			"            \"CT_CAMP1\"\n" +
			"        ],\n" +
			"        \"membershipTierInfo\": {\n" +
			"            \"tier\": \"VIP\",\n" +
			"          \"start\": \"2023-09-10 23:00:00\",\n" +
			"            \"end\": \"2025-09-10 23:00:00\",\n" +
			"            \"membershipTenureDuration\": {\n" +
			"                \"duration\": 365,\n" +
			"                \"durationTimeUnit\": \"DAY\"\n" +
			"            }\n" +
			"        }\n" +
			"    }\n" +
			"}";

	String params_Floater_Get_API = "{\n" +
			"\"slotIds\" : [\"air_pwa_home_page\",\"air_pwa_home\"]\n" +
			"}";

	String params_Floater_SaveImpression = "{\n" +
			"    \"campaign\" : \"111\",\n" +
			"    \"timestamp\" : 1693546587000,\n" +
			"    \"impressionType\" : \"VIEW\"\n" +
			"}";

    String tempID = RandomStringUtils.randomNumeric(5);

	String params_Floater_AddTemplate = "{\n" +
			"    \"templateId\" : "+tempID+",\n" +
			"    \"templateBody\" : \"[{\\\"id\\\":1,\\\"attributes\\\":[{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"close\\\"},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"maximize\\\",\\\"minimisedOnly\\\":true},{\\\"type\\\":\\\"artifact\\\",\\\"properties\\\":{\\\"title\\\":\\\"${artifact_title}\\\",\\\"url\\\":\\\"${artifact_url}\\\",\\\"imageType\\\":\\\"${artifact_type}\\\"}},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"redirect\\\",\\\"properties\\\":{\\\"title\\\":\\\"${redirection_title}\\\",\\\"url\\\":\\\"${redirection_url}\\\"}}]}]\"\n" +
			"}";

	String params_Floater_AddDuplicateTemplate = "{\n" +
			"    \"templateId\" : \"08998\",\n" +
			"    \"templateBody\" : \"[{\\\"id\\\":1,\\\"attributes\\\":[{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"close\\\"},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"maximize\\\",\\\"minimisedOnly\\\":true},{\\\"type\\\":\\\"artifact\\\",\\\"properties\\\":{\\\"title\\\":\\\"${artifact_title}\\\",\\\"url\\\":\\\"${artifact_url}\\\",\\\"imageType\\\":\\\"${artifact_type}\\\"}},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"redirect\\\",\\\"properties\\\":{\\\"title\\\":\\\"${redirection_title}\\\",\\\"url\\\":\\\"${redirection_url}\\\"}}]}]\"\n" +
			"}";

	String params_Floater_InvalidBody = "{\n" +
			"    \n" +
			"    \"templateBody\" : \"[{\\\"id\\\":1,\\\"attributes\\\":[{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"close\\\"},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"maximize\\\",\\\"minimisedOnly\\\":true},{\\\"type\\\":\\\"artifact\\\",\\\"properties\\\":{\\\"title\\\":\\\"${artifact_title}\\\",\\\"url\\\":\\\"${artifact_url}\\\",\\\"imageType\\\":\\\"${artifact_type}\\\"}},{\\\"type\\\":\\\"button\\\",\\\"action\\\":\\\"redirect\\\",\\\"properties\\\":{\\\"title\\\":\\\"${redirection_title}\\\",\\\"url\\\":\\\"${redirection_url}\\\"}}]}]\"\n" +
			"}";

	String params_Floater_WithoutTemplateBody = "{\n" +
			"    \"templateId\" : \"08998\"\n" +
			"}";

	String params_Floater_Get_API_WithNewbody = "{\n" +
			"\"slotIds\" : [\"air_pwa_home_page\"]\n" +
			"}";

	String params_FKVIP_Discover_API = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000008\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    },\n" +
			"    \"requestId\": \"uuid\",\n" +
			"    \"filter\": {\n" +
			"        \"productType\": \"hotel\"\n" +
			"    }\n" +
			"}";

	String params_FKVIP_Discover_API_WIthOutFilter = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000008\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    },\n" +
			"    \"requestId\": \"uuid\"\n" +
			"}";

	String params_FKVIP_Redeem_API = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000008\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    },\n" +
			"    \"campaignId\": \"CAMPID_MYNTRA_ICON_HOTEL_001\",\n" +
			"    \"cohortName\": \"MYNTRA_ICON_V1\",\n" +
			"    \"benefitId\": \"64cdce544fbadd0e2a83962e\",\n" +
			"    \"tripRef\": \"Q019523733692\",\n" +
			"    \"benefitTxnDetails\": {\n" +
			"        \"txnAmount\": 10,\n" +
			"        \"notionalValue\": 5\n" +
			"    }\n" +
			"}";

	String params_FKVIP_InValid_Redeem_API = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000008\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    },\n" +
			"    \"campaignId\": \"CAMPID_MYNTRA_ICON_HOTEL_001\",\n" +
			"    \"cohortName\": \"MYNTRA_ICON_V1\",\n" +
			"    \"tripRef\": \"Q019523733692\",\n" +
			"    \"benefitTxnDetails\": {\n" +
			"        \"txnAmount\": 10,\n" +
			"        \"notionalValue\": 5\n" +
			"    }\n" +
			"}";

	int benefitRedemptionId;
	String params_FKVIP_Invalid_RollBack_API = "{\n" +
			"    \"benefitRedemptionId\": \"245\",\n" +
			"    \"tripRef\": \"Q909523733692\"\n" +
			"}";

	String params_FKVIP_Valid_RollBack_API = "{\n" +
			"    \"benefitRedemptionId\": "+benefitRedemptionId+",\n" +
			"    \"tripRef\": \"Q909523733692\"\n" +
			"}";

	String params_FKVIP_Active_Entity = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000007\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    },\n" +
			"    \"requestId\": \"uuid\"\n" +
			"}";

	String params_FKVIP_Active_Entity_Invalid_API = "{\n" +
			"    \"identity\": {\n" +
			"        \"identifier\": \"2500000007\",\n" +
			"        \"type\": \"MOBILE\"\n" +
			"    }\n" +
			"}";

	String params_Account_Service_MobileLogin_sendOTP_SIGNIN="{\n" +
			"  \"type\": \"MOBILE\",\n" +
			"  \"value\": \"1111022299\",\n" +
			"  \"countryCode\": \"+91\",\n" +
			"  \"action\": \"SIGNIN\"\n" +
			"}\n" +
			"\n";
	String params_Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE="{\"type\":\"MOBILE\",\"value\":\"7799964888\",\"countryCode\":\"+91\",\"action\":\"UPDATE_MOBILE\"}";
	String params_Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE="{\"type\":\"EMAIL\",\"value\":\"ns.likhitha@cleartrip.com\",\"action\":\"SIGNUP_MERGE\"}";
	String params_Identity_service_RecaptchaAPI="";
	String params_Accounts_Service_FLyinV2_Signin_Unauthorized="{ \"password\": \"cleatrip123\", \"partner\": 0, \"source\": \"home_page\", \"username\": \"ns.likhitha@cleartrip.com\", \"persist_login\": false}";
	String params_AccountsService_FlyinV2Signin_Unauthorized="{ \"password\": \"Pre@123\", \"partner\": 1, \"source\": \"home_page\", \"username\": \"flyinctuser@gmail.com\", \"persist_login\": false}";
	String params_Account_Service_FlyinV2_Signin_FlyinUser="{ \"password\": \"Preprod@123\", \"partner\": 1, \"source\": \"home_page\", \"username\": \"flyinctuser@gmail.com\", \"persist_login\": false}";
	String params_Account_Service_PWA_SignIn_API="{\"username\" : \"ns.likhitha@cleartrip.com\",\"password\":\"cleartrip123\"}";
	String params_Manage_trips_OTP_API="{\"trip_ref\":\"Q19050680460\",\"email_id\":\"ns.likhitha@cleartrip.com\"}";
	String params_cfw_active_status="{ \"cfw\":\"false\", \"user\": { \"password\": \"cleartrip1\" }, \"retype_password\": \"cleartrip1\", \"personal_data\": { \"title\": \"Mr\", \"first_name\": \"vinay\", \"last_name\": \"raj\" }, \"phone_number\": { \"phone_number_value\": \"+919743049515\", \"category\": \"mobile\" }, \"email_id\":\"ns.likhitha@cleartrip.com\" }";
	String params_identtiyservice_getresource="access_token:rUBn829a8U4nH12Zo4uiHj9CHOSu3H5k44FyRJVERLB2rjdlOy";
	String params_flyinsignup="{ \"username\" : \"ok@cltp.com\", \"password\" : \"cleartrip1\", \"partner\" : \"1\", \"source\" : \"homepage\", \"title\" : \"Mr>\", \"first_name\":\"test\", \"last_name\":\"testte\" }";
	String params_Account_Service_Update_User="{\"id\":65205484,\"username\":\"otpmobilenotest@cleartrip.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":65205510,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"44444444\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":110340,\"companyName\":\"cleartrip\",\"domain\":\"www.cleartrip.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_Account_Service_Update_User_Cleartrip_B2Buser="{\"username\":\"qaauto1584674982375@manit.agentbox.com\",\"travellerDetails\":[{\"id\":65199164,\"personalDetails\":{\"firstName\":\"oioioioi\",\"lastName\":\"tttttt\",\"title\":\"Mrs\",\"paxType\":\"ADT\"},\"isRegistered\":false},{\"personalDetails\":{\"firstName\":\"zzzzz\",\"lastName\":\"tttttt\",\"title\":\"Mrs\",\"paxType\":\"ADT\"},\"isRegistered\":false},{\"personalDetails\":{\"firstName\":\"oooo\",\"lastName\":\"ttttt\",\"title\":\"Mrs\",\"paxType\":\"ADT\"},\"isRegistered\":false}]}";
	String params_Account_Service_Cleartrip_confirmedtravlerwithActivestatus="{\"id\":65213192,\"travellerDetails\":[{\"personalDetails\":{\"firstName\":\"first35\",\"lastName\":\"last45\",\"middleName\":\"mid25\",\"title\":\"Mr.\"},\"userStatus\":\"ACTIVE_USER\"},{\"personalDetails\":{\"firstName\":\"firstq\",\"lastName\":\"lastq\",\"middleName\":\"midq\",\"title\":\"Mr.\"}}]}";
	String params_Accounts_Service_Cleartrip_MultipleTraveller_Updatecall="{\"id\":65211332,\"username\":\"cleartpdate@cleartrip.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":65211332,\"isRegistered\":true,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"111111111111\",\"mobileCountryCode\":\"91\",\"category\":\"test\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":\"ALPC\",\"countryOfResidence\":\"IN\",\"countryOfResidenceId\":null,\"countryPreference\":\"IN\",\"currency\":\"INR\",\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":\"Nillok\",\"emergencyContactNumber\":\"0000000\",\"firstName\":\"mynameiskk\",\"gender\":\"female\",\"homeAirport\":null,\"homeAirportId\":\"21\",\"language\":\"Tamil\",\"lastName\":\"testme\",\"middleName\":\"Myname\",\"nickName\":\"Tamil\",\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":\"Miss\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":22133345,\"countryIssued\":\"UAE\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"998899\",\"docType\":\"DCO_REG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"usus\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"111111111\",\"mobileCountryCode\":\"91\",\"category\":\"test\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":\"ALPC\",\"countryOfResidence\":\"IN\",\"countryOfResidenceId\":null,\"countryPreference\":\"IN\",\"currency\":\"INR\",\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":\"SITEISSUEStestinginqa\",\"gender\":\"Female\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":\"Tamil\",\"lastName\":\"testme\",\"middleName\":\"Myname\",\"nickName\":\"Tamil\",\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":\"Mr\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"111111111\",\"docType\":\"DCO_REG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"TIkkME\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":\"okok\",\"gender\":\"Male\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":\"testme\",\"middleName\":\"middlenametest\",\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":\"Miss\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"DCO_NonREG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"111111111\",\"docType\":\"DCO_NonREG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":110340,\"companyName\":\"cleartrip\",\"domain\":\"www.cleartrip.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[{\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1SY\"},{\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1SO\"}],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_Accounts_Service_DOCdetailsUpdate_cleartripuser="{\"id\":65205822,\"username\":\"otpmobilenotestfinal@cleartrip.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":65205822,\"isRegistered\":true,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"1234567890\",\"mobileCountryCode\":\"91\",\"category\":\"test\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":22128655,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"111111111\",\"docType\":\"DCO_REG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"TIkkME\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"id\":65205824,\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":22128656,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"DCO_NonREG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"111111111\",\"docType\":\"DCO_NonREG_USER\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":110340,\"companyName\":\"cleartrip\",\"domain\":\"www.cleartrip.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[{\"id\":9158,\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1SY\"},{\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1SO\"}],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_Account_Service_RegisterFLyinUserUpdate_OTPValidation="{\"id\":65206329,\"username\":\"otpmobilenotestfinal@flyin.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":179861,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"11111111111\",\"mobileCountryCode\":\"91\",\"category\":\"test\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"id\":179862,\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"88888888\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":\"HIiiiIII\",\"gender\":\"M\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":\"tamil\",\"lastName\":\"HI\",\"middleName\":\"HI\",\"nickName\":\"Hhhhhhhh\",\"primaryEmail\":\"otpmobilenotest@flyin.com\",\"title\":\"MR\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":5266152,\"companyName\":\"flyin\",\"domain\":\"www.flyin.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_IdentityService_ChangePassword="";
	String params_Account_Service_FLYIN_User_Update="{\"id\":65206329,\"username\":\"otpmobilenotestfinal@flyin.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":179862,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"11111111111\",\"mobileCountryCode\":\"91\",\"category\":\"test\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"id\":179862,\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"88888888\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":\"HIiiiIII\",\"gender\":\"M\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":\"tamil\",\"lastName\":\"HI\",\"middleName\":\"HI\",\"nickName\":\"Hhhhhhhh\",\"primaryEmail\":\"otpmobilenotest@flyin.com\",\"title\":\"MR\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":5266152,\"companyName\":\"flyin\",\"domain\":\"www.flyin.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_Accounts_Service_Flyin_DOCdetails_update="{\"id\":65206329,\"username\":\"otpmobilenotestfinal@flyin.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":179861,\"isRegistered\":true,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":\"ME\",\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":\"male\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":23916,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"AUTOMATEDOC_REG\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"222222\",\"docType\":\"TESTTEST\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"id\":180256,\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"88888888\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":\"SOMETIME\",\"concatName\":\"TEST\",\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":\"SOMETIME\",\"emergencyContactNumber\":null,\"firstName\":\"HIiiiIII\",\"gender\":\"M\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":\"tamil\",\"lastName\":\"HI\",\"middleName\":\"HI\",\"nickName\":\"Hhhhhhhh\",\"primaryEmail\":\"otpmobilenotest@flyin.com\",\"title\":\"MR\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":23895,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"AAAAAA\",\"docType\":\"AUTOMATEDOC_NONREG\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"AAAAAA\",\"docType\":\"TESTTEST\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":5266152,\"companyName\":\"flyin\",\"domain\":\"www.flyin.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";

	String params_Account_Service_FLYINUserDetails_Update = "{\"username\":\"sabori7535@pidouno.com\",\"travellerDetails\":[{\"personalDetails\":{\"dateOfBirth\":1551637800000,\"firstName\":\"jbdfdsb\",\"gender\":\"M\",\"lastName\":\"dssfsdf\",\"title\":\"Mstr\",\"paxType\":\"INF\"}},{\"personalDetails\":{\"dateOfBirth\":1236105000000,\"firstName\":\"child\",\"gender\":\"M\",\"lastName\":\"bento\",\"title\":\"Mstr\",\"paxType\":\"CHD\"}},{\"personalDetails\":{\"firstName\":\"test\",\"gender\":\"M\",\"lastName\":\"user\",\"title\":\"Mr\",\"paxType\":\"ADT\"}}]}";
	String params_Accounts_Service_FLyinUser_GSTdetailsUpdate="{\"id\":65206329,\"username\":\"otpmobilenotestfinal@flyin.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":179861,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":\"ME\",\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":\"male\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":23916,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"22222222\",\"docType\":\"TIkkME\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"222222\",\"docType\":\"TESTTEST\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},{\"id\":180256,\"isRegistered\":false,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"88888888\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":\"SOMETIME\",\"concatName\":\"TEST\",\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":\"SOMETIME\",\"emergencyContactNumber\":null,\"firstName\":\"HIiiiIII\",\"gender\":\"M\",\"homeAirport\":null,\"homeAirportId\":null,\"language\":\"tamil\",\"lastName\":\"HI\",\"middleName\":\"HI\",\"nickName\":\"Hhhhhhhh\",\"primaryEmail\":\"otpmobilenotest@flyin.com\",\"title\":\"MR\",\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":[{\"id\":23895,\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"AAAAAA\",\"docType\":\"TESTTEST\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"},{\"countryIssued\":\"india\",\"dateOfBirth\":\"1991-04-23T00:00:00\",\"docNumber\":\"AAAAAA\",\"docType\":\"TESTTEST\",\"expiryDate\":\"2028-02-29T00:00:00\",\"nationality\":\"india\"}],\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":5266152,\"companyName\":\"flyin\",\"domain\":\"www.flyin.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[{\"id\":9164,\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1SO\"},{\"gstHolderAddress\":\"test\",\"gstHolderName\":\"test\",\"gstHolderStateCode\":\"91\",\"gstHolderStateName\":\"test\",\"gstNumber\":\"28SAILI1234H1Y\"}],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";		
	String params_Account_Service_Update_User_MobileNo_OTPValidaion="{\"id\":65205484,\"username\":\"otpmobilenotest@cleartrip.com\",\"profilePercentCompleted\":null,\"travellerDetails\":[{\"id\":65205484,\"isRegistered\":true,\"profileData\":null,\"contactInfo\":{\"phoneNumbers\":[{\"mobileNumber\":\"44444444\",\"mobileCountryCode\":\"91\",\"category\":\"mobile\"}],\"whatsapp\":null,\"addresses\":[],\"otherDetails\":[],\"emails\":[]},\"ffnPreferences\":null,\"personalDetails\":{\"anniversaryDate\":null,\"companyDesignation\":null,\"concatName\":null,\"countryOfResidence\":null,\"countryOfResidenceId\":null,\"countryPreference\":null,\"currency\":null,\"dateOfBirth\":null,\"department\":null,\"emergencyContactName\":null,\"emergencyContactNumber\":null,\"firstName\":null,\"gender\":null,\"homeAirport\":null,\"homeAirportId\":null,\"language\":null,\"lastName\":null,\"middleName\":null,\"nickName\":null,\"primaryEmail\":\"otpmobilenotest@cleartrip.com\",\"title\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"},\"preferences\":null,\"docDetails\":null,\"createdAt\":\"2020-10-27T09:15:14\",\"updatedAt\":\"2020-10-27T09:15:14\"}],\"companyDetails\":[{\"id\":110340,\"companyName\":\"cleartrip\",\"domain\":\"www.cleartrip.com\",\"roles\":[{\"id\":1064,\"name\":\"USER\"}],\"status\":\"N\"}],\"depositAccounts\":[],\"gstDetails\":[],\"resources\":[],\"savedCards\":null,\"registrationDate\":\"2020-10-27T09:15:14\",\"lastUpdatedOn\":\"2020-10-27T09:15:14\"}";
	String params_Account_Service_FetchPersonalData="[14029546,65201340,65180937]";
	String params_Account_Service_MobileLogin_verifyOTP_SignIn="{\"type\":\"MOBILE\",\"value\":\"7799964888\",\"countryCode\":\"+91\",\"action\":\"SIGNIN\",\"otp\":\"404780\"}";
	String params_Account_Service_MobileLogin_verifyOTP_UPDATE_MOBILE="{\"type\":\"MOBILE\",\"value\":\"7799964888\",\"countryCode\":\"+91\",\"action\":\"UPDATE_MOBILE\",\"otp\":\"117758\"}";
    String params_Account_Service_MobileLogin_NudgePersonaldetails="";
	String params_Account_Service_MobileLogin_verifyOTP_SIGNUP_MERGE="{\"type\":\"EMAIL\",\"value\":\"sai@gmail.com\",\"action\":\"SIGNUP_MERGE\",\"otp\":\"284262\"}";
	String params_Account_Service_AppleSignin_uniqueId="{\"appleId\":\"1:a:2:b:35\",\"emailId\":\"123@privaterelay.appleid.com\",\"firstName\":\"abcd\",\"lastName\":\"sai\",\"title\":\"Mr.\"}";
	String params_Account_Service_AppleSignin_Entity="{\"appleId\":\"1:a:2:b:3\",\"emailId\":\"sai@privaterelay.appleid.com\",\"firstName\":\"abcd\",\"lastName\":\"sai\",\"title\":\"Mr.\"}";
	String params_Account_Service_AppleRegister_NullEmail="{\"appleId\":\"1:a:2:b:3:00\",\"emailId\":\"\",\"firstName\":\"abcd\",\"lastName\":\"sai\",\"title\":\"Mr.\"}";
	String params_flyinresetpassword="{ \"username\" : \"ok@cltp.com\", \"old_password\" : \"cleartrip1\", \"new_password\" : \"cleartrip1\", \"partner\" : 1, \"source\":\"homepage\" }";
	String params_flyinresetpasswordV2="{ \"username\" : \"ok@cltp.com\", \"old_password\" : \"cleartrip1\", \"new_password\" : \"cleartrip1\", \"partner\" : 1, \"source\":\"homepage\" }";
    String params_Account_Service_Cleartrip_ResetPassword="{\"partner\":0,\"source\":\"homepage\",\"key\":\"33e0ee9e7b833ece75ad55aee3269e627b95638e5dd5828f8d4e9ad81cc7ae3c\",\"username\":\"nakul@test.com\",\"new_password\":\"Cleartrip@1234\",\"old_password\":\"Cleartrip@123\"}";
	String params_flyinforgetpassword="{ \"username\" : \"samsung@gmail.com\", \"key\" : \"bb54068cfd0f08459f85ce394a53caeef2feb56efa779ea9f512c3ed33d31e31\", \"new_password\" : \"cleartrip1\", \"partner\" : 1 }";
	String params_flyinforgetpasswordV2="{ \"username\" : \"samsung@gmail.com\", \"key\" : \"bb54068cfd0f08459f85ce394a53caeef2feb56efa779ea9f512c3ed33d31e31\", \"new_password\" : \"cleartrip1\", \"partner\" : 1 }";

	String params_flyinusersearch="{\"partner\":1,\"usernames\":[\"ok@cltp.com\",\"samsung@gmail.com\"],\"user_ids\":[65173245]}";
	String params_flyinusersearchV2="{\"partner\":1,\"user_ids\":[\"65178369\", \"65178433\", \"65071986\", \"65175660\", \"65176954\", \"65178404\", \"65178384\", \"65178378\", \"65178394\", \"9077500094746\", \"1090200101187\", \"65175544\", \"65178364\", \"1003697\", \"1007777\", \"65178476\", \"65178402\", \"65072085\", \"65072566\", \"65178449\", \"1004939\", \"1007898\", \"65178352\", \"65178403\", \"65178452\", \"65178473\", \"65178405\", \"65178355\", \"65178370\"]}";
	String params_flyinusersearchV2_regression="{\"source\":\"homepage\",\"partner\":1,\"usernames\":[\"hemakanta.sethi@cleartrip.com\"]}";
	String params_partnercontroller_updatetraveller="{\"partnerId\":\"1008700094638\",\"action\":\"UPSERT\",\"partner\":1,\"data\":[{\"isReg\":true,\"profileData\":{\"personalData\":{\"title\":\"Mr\",\"firstName\":\"aaa\",\"middleName\":\"\",\"lastName\":\"bbb\",\"mobileNumber\":\"8792608054\",\"mobileAreaCode\":\"91\",\"contactEmailId\":\"hemakanta@flyin.com\",\"dateOfBirth\":\"2003-02-19T00:00:00\",\"address\":\"\",\"postalCode\":\"\",\"profilePic\":null,\"anniversaryDate\":\"\",\"emergencyContactNum\":\"_\",\"emergencyContactName\":\"Mr   \"}},\"docDetails\":[{\"docType\":3,\"docNumber\":\"LM123RTD\",\"expiryDate\":\"2026-03-03T00:00:00\",\"dateOfBirth\":\"2013-02-16T00:00:00\",\"nationality\":\"BS\",\"countryIssued\":\"\",\"issuedDate\":\"2018-03-04T00:00:00\"}]},{\"isReg\":true,\"profileData\":{\"personalData\":{\"title\":\"Mr\",\"firstName\":\"hi00\",\"middleName\":\"hi\",\"lastName\":\"hi\",\"mobileNumber\":\"1234567890\",\"mobileAreaCode\":\"91\",\"contactEmailId\":\"hemakanta@flyin.com\",\"dateOfBirth\":\"2003-02-19T00:00:00\",\"address\":\"\",\"postalCode\":\"\",\"profilePic\":null,\"anniversaryDate\":\"\",\"emergencyContactNum\":\"_\",\"emergencyContactName\":\"Mr   \"}},\"docDetails\":[{\"docType\":3,\"docNumber\":\"LM123RTD\",\"expiryDate\":\"2026-03-03T00:00:00\",\"dateOfBirth\":\"2013-02-16T00:00:00\",\"nationality\":\"BS\",\"countryIssued\":\"\",\"issuedDate\":\"2018-03-04T00:00:00\"}]}]}";
	String params_travellercontroller_updatetraveller="{\"id\":65165611,\"action\":\"UPSERT\",\"partner\":1,\"data\":[{\"isReg\":true,\"profileData\":{\"personalData\":{\"title\":\"Mr\",\"firstName\":\"hemakanta\",\"middleName\":\"\",\"lastName\":\"sethi\",\"mobileNumber\":\"8792608054\",\"mobileAreaCode\":\"91\",\"contactEmailId\":\"hemakanta@flyin.com\",\"dateOfBirth\":\"2003-02-19T00:00:00\",\"address\":\"\",\"postalCode\":\"\",\"profilePic\":null,\"anniversaryDate\":\"\",\"emergencyContactNum\":\"_\",\"emergencyContactName\":\"Mr   \"}},\"docDetails\":[{\"docType\":2,\"docNumber\":\"q2423142\",\"expiryDate\":\"2026-03-03T00:00:00\",\"dateOfBirth\":\"2003-02-16T00:00:00\",\"nationality\":\"BS\",\"countryIssued\":\"\",\"issuedDate\":\"2018-03-04T00:00:00\"},{\"docType\":3,\"docNumber\":\"afsdf\",\"nationality\":\"BH\",\"countryIssued\":\"BH\"},{\"docType\":4,\"expiryDate\":\"\",\"nationality\":\"\",\"countryIssued\":\"SA\"}]}]}";
	String params_Account_Service_Travellercontroller_UpdateTraveller_FlyRegression="{\"action\":\"UPSERT\",\"partner\":1,\"id\":\"65200972\",\"data\":[{\"id\":\"\",\"profileData\":{\"personalData\":{\"firstName\":\"test\",\"lastName\":\"user\",\"title\":\"Mr\",\"dateOfBirth\":\"2007-04-03T00:00:00\",\"mobileNumber\":\"453535353\",\"mobileAreaCode\":\"966\",\"contactEmailId\":\"yihinad483@temhuv.com\",\"address\":\"hyderabad\"}},\"docDetails\":[{\"docType\":\"3\",\"expiryDate\":\"2020-08-25T00:00:00\",\"nationality\":\"AE\",\"countryIssued\":\"AE\",\"id\":\"\",\"docNumber\":\"fgdfgdfgdf\",\"issuedDate\":\"2016-08-25T00:00:00\"}],\"isReg\":false}]}";
	String params_flyinsocialsignup="{ \"username\" : \"ok@gmail.com\", \"partner\" : 1, \"title\" : \"Mr\", \"first_name\":\"test\", \"last_name\":\"Raj\", \"social_media_id\" : \"12345678\", \"social_media_type\":\"FaceBook\", \"key\":\"669947b54a191a94a50446db72924398f122d6ac58b349d0b163b1363b59d477\" }";
	String params_flyinsocialsignupV2="{ \"username\" : \"samsung10@gmail.com\", \"partner\" : 1, \"title\" : \"Mr\", \"first_name\":\"test\", \"last_name\":\"Raj\", \"social_media_id\" : \"123456\", \"social_media_type\":\"FaceBook\", \"key\":\"b5fa7bdc919c5ccb3eec706c9c770bf3f1205e7e4ff60445369f79dd816d062e\" }";
	String params_flyinsocialsignupV2_flyinregression="{\"username\":\"anilkumar9291@gmail.com\",\"source\":\"homepage\",\"partner\":1,\"first_name\":\"Anil\",\"last_name\":\" Kumar\",\"social_media_id\":\"10204548280861143\",\"social_media_type\":\"FaceBook\",\"key\":\"01b7b6001cacb343aa4a2ba283b3f24ec05710ffc5883420991641057331785d\"}";
	String params_userprofile_externalAPI_Mobileapp="";
	String params_IdentityService_UpdatePassword_ForChangePasswordflow="{\"emailId\":\"ns.likhitha@cleartrip.com\",\"oldPassword\":\"Cleartrip@1\",\"newPassword\":\"Cleartrip@2\",\"otp\":\"035175\"}";
	String params_IdentityService_UpdatePassword_ForResetPasswordflow="{\"emailId\":\"ns.likhitha@cleartrip.com\",\"newPassword\":\"Cleartrip@8\",\"mailerKey\":\"aIWr1jRjfDPjXojg\"}";
	String params_Account_Service_UserController_VerifyAccount="";

	String params_Accounts_Service_Update_Personal_Details= "{\n" +
			"    \"personalData\": {\n" +
			"        \"firstName\": \"saitest\",\n" +
			"        \"lastName\": \"saitest\",\n" +
			"        \"gender\": \"male\",\n" +
			"        \"title\": \"Mr\",\n" +
			"        \"dateOfBirth\": \"1996-04-25T00:00:00\",\n" +
			"        \"anniversaryDate\": \"1990-04-24T00:00:00\",\n" +
			"        \"maritalStatus\": \"SINGLE\"\n" +
			"    }\n" +
			"}";

	String params_AS_Update_Traveller_details = "{\n" +
			"    \"travellerDetails\": [\n" +
			"        {\n" +
			"            \"personalDetails\": {\n" +
			"                \"firstName\": \"test\",\n" +
			"                \"gender\": \"Male\",\n" +
			"                \"lastName\": \"test\",\n" +
			"                \"title\": \"Mr\",\n" +
			"                \"paxType\": \"ADT\"\n" +
			"            },\n" +
			"            \"isRegistered\": false,\n" +
			"            \"userStatus\": \"ACTIVE_USER\"\n" +
			"        }\n" +
			"    ]\n" +
			"}";

	String params_Promotional_service_RefreshStageCinfig="";
	String params_Account_Service_MobileLoginUpdatePersonaldetailsApi="{\"marketingSubscription\":1,\"personalData\":{\"firstName\":\"cool\",\"lastName\":\"oktest\",\"gender\":\"male\"}}";
	String params_Account_Service_People_UpdateUserRoles="{\"userId\":3863174,\"companyPeopleDetails\":[{\"companyId\":87321,\"companyPeopleId\":58963,\"role\":{\"id\":1,\"accessLevel\":0}},{\"companyId\":87321,\"role\":{\"id\":1064,\"accessLevel\":0}},{\"companyId\":87321,\"role\":{\"id\":10000,\"accessLevel\":0}},{\"companyId\":21,\"role\":{\"id\":2,\"name\":\"Finance \",\"accessLevel\":0}}]}";
	String params_Accounts_service_Company_DeleteGST="";
	String params_Flipkart_Accounts_service_Updateuser="{\"travellerDetails\":[{\"id\":182197,\"isRegistered\":true,\"personalDetails\":{\"dateOfBirth\":739650600000,\"firstName\":\"automationtest\",\"lastName\":\"testing\",\"title\":\"Mr.\",\"nationality\":\"IN\"},\"docDetails\":[{\"id\":1,\"docNumber\":\"2345\",\"docType\":\"automationtest\",\"expiryDate\":\"2020-09-11T00:00:00\",\"issuedDate\":\"2009-05-11T00:00:00\"}]},{\"id\":182189,\"isRegistered\":false,\"personalDetails\":{\"dateOfBirth\":739650600000,\"firstName\":\"automationtest2\",\"lastName\":\"testing2\",\"title\":\"Mr.\",\"nationality\":\"Indian\"},\"docDetails\":[{\"id\":6,\"docNumber\":\"7878\",\"docType\":\"PASSPORT\",\"expiryDate\":\"2020-09-11T00:00:00\",\"issuedDate\":\"2009-05-11T00:00:00\"}]}],\"gstDetails\":[{\"gstNumber\":\"12automation\",\"gstHolderCompanyName\":\"flipkart\",\"gstHolderCompanyAddress\":\"address\",\"gstHolderStateName\":\"Karnataka\",\"pinCode\":\"12345\",\"city\":\"bangalore\"}]}";
	String params_b2bAddtraveler="{ \"person\": { \"contact_data\": { \"emails\": [ { \"seq_no\": 0, \"email_id\": \"ns.likhitha@cleartrip.com\", \"category\": \"work\" } ] }, \"id\": 0, \"company_details\": [ { \"company_id\": 186462, \"company_people_roles\": [ { \"role_id\": 1073 } ], \"status\": \"0\" } ], \"personal_data\": { \"title\": \"Miss\", \"first_name\": \"sai\", \"last_name\": \"test\" }, \"recentlyBooked\": false, \"travel_profile\": { } } }";
	String params_RoleInfo= "{\"role_ids\":[1069]}";
	String params_FetchUserV2 = "{\"person_ids\":[13941098,13941098],\"usernames\":[\"vinay.raj@cleartrip.com\"],\"query\":[\"personal_data\"]}";
	String params_Register="{\"user\": { \"id\": 0,\"contact_data\": { },\"personal_data\": { },\"company_details\": [{\"company_id\": \"110340\",\"company_people_roles\": [{\"role_id\": 1064}]}],\"source_of_registration\": \"API\",\"travel_profile\": { },\"recentlyBooked\": false,\"username\": \"testcltp6@gmail.com\"} }";
	String params_B2B_user_authentication="{\"company_id\":101,\"username\":\"cleartripdemo@gmail.com\",\"password\":\"cleartrip\"}";

	String params_Register_api ="{\n" +
			"  \"username\": \"sessionm"+getRandomNumber()+"@gmail.com\",\n" +
			"   \"marketingSubscription\": 1,\n" +
			"  \"travellerDetails\": [\n" +
			"    {\n" +
			"      \"profileData\": null,\n" +
			"      \"contactInfo\": {\n" +
			"        \"phoneNumbers\": [\n" +
			"          {\n" +
			"            \"mobileNumber\": \"1234567890\",\n" +
			"            \"mobileCountryCode\": \"91\",\n" +
			"            \"category\": \"mobile\"\n" +
			"          }\n" +
			"        ],\n" +
			"        \"whatsapp\": null,\n" +
			"        \"addresses\": [],\n" +
			"        \"otherDetails\": [],\n" +
			"        \"emails\": []\n" +
			"      },\n" +
			"      \"ffnPreferences\": null,\n" +
			"      \"personalDetails\": {\n" +
			"        \"anniversaryDate\": null,\n" +
			"        \"companyDesignation\": null,\n" +
			"        \"concatName\": \"jayendrasinghjayendra.singh@cleartrip.com\",\n" +
			"        \"countryOfResidence\": null,\n" +
			"        \"countryOfResidenceId\": null,\n" +
			"        \"countryPreference\": null,\n" +
			"        \"currency\": null,\n" +
			"        \"dateOfBirth\": null,\n" +
			"        \"department\": null,\n" +
			"        \"emergencyContactName\": null,\n" +
			"        \"emergencyContactNumber\": null,\n" +
			"        \"firstName\": \"Jayendra\",\n" +
			"        \"gender\": null,\n" +
			"        \"homeAirport\": null,\n" +
			"        \"homeAirportId\": null,\n" +
			"        \"language\": null,\n" +
			"        \"lastName\": \"Singh\",\n" +
			"        \"middleName\": null,\n" +
			"        \"nickName\": null,\n" +
			"        \"primaryEmail\": null,\n" +
			"        \"title\": \"Mr\"\n" +
			"      },\n" +
			"      \"preferences\": null,\n" +
			"      \"docDetails\": null\n" +
			"    }\n" +
			"  ],\n" +
			"  \"password\" : \"Cleartrip@123\"\n" +
			"}";

	String param_Register_Failure = "{\n" +
			"  \"username\": \"sessionm781@gmail.com\",\n" +
			"   \"marketingSubscription\": 1,\n" +
			"  \"travellerDetails\": [\n" +
			"    {\n" +
			"      \"profileData\": null,\n" +
			"      \"contactInfo\": {\n" +
			"        \"phoneNumbers\": [\n" +
			"          {\n" +
			"            \"mobileNumber\": \"1234567890\",\n" +
			"            \"mobileCountryCode\": \"91\",\n" +
			"            \"category\": \"mobile\"\n" +
			"          }\n" +
			"        ],\n" +
			"        \"whatsapp\": null,\n" +
			"        \"addresses\": [],\n" +
			"        \"otherDetails\": [],\n" +
			"        \"emails\": []\n" +
			"      },\n" +
			"      \"ffnPreferences\": null,\n" +
			"      \"personalDetails\": {\n" +
			"        \"anniversaryDate\": null,\n" +
			"        \"companyDesignation\": null,\n" +
			"        \"concatName\": \"jayendrasinghjayendra.singh@cleartrip.com\",\n" +
			"        \"countryOfResidence\": null,\n" +
			"        \"countryOfResidenceId\": null,\n" +
			"        \"countryPreference\": null,\n" +
			"        \"currency\": null,\n" +
			"        \"dateOfBirth\": null,\n" +
			"        \"department\": null,\n" +
			"        \"emergencyContactName\": null,\n" +
			"        \"emergencyContactNumber\": null,\n" +
			"        \"firstName\": \"Jayendra\",\n" +
			"        \"gender\": null,\n" +
			"        \"homeAirport\": null,\n" +
			"        \"homeAirportId\": null,\n" +
			"        \"language\": null,\n" +
			"        \"lastName\": \"Singh\",\n" +
			"        \"middleName\": null,\n" +
			"        \"nickName\": null,\n" +
			"        \"primaryEmail\": null,\n" +
			"        \"title\": \"Mr\"\n" +
			"      },\n" +
			"      \"preferences\": null,\n" +
			"      \"docDetails\": null\n" +
			"    }\n" +
			"  ],\n" +
			"  \"password\" : \"Cleartrip@123\"\n" +
			"}";

	String param_Register_Incomplete = "{\n" +
			"  \"username\": \"\",\n" +
			"   \"marketingSubscription\": 1,\n" +
			"  \"travellerDetails\": [\n" +
			"    {\n" +
			"      \"profileData\": null,\n" +
			"      \"contactInfo\": {\n" +
			"        \"phoneNumbers\": [\n" +
			"          {\n" +
			"            \"mobileNumber\": \"1234567890\",\n" +
			"            \"mobileCountryCode\": \"91\",\n" +
			"            \"category\": \"mobile\"\n" +
			"          }\n" +
			"        ],\n" +
			"        \"whatsapp\": null,\n" +
			"        \"addresses\": [],\n" +
			"        \"otherDetails\": [],\n" +
			"        \"emails\": []\n" +
			"      },\n" +
			"      \"ffnPreferences\": null,\n" +
			"      \"personalDetails\": {\n" +
			"        \"anniversaryDate\": null,\n" +
			"        \"companyDesignation\": null,\n" +
			"        \"concatName\": \"jayendrasinghjayendra.singh@cleartrip.com\",\n" +
			"        \"countryOfResidence\": null,\n" +
			"        \"countryOfResidenceId\": null,\n" +
			"        \"countryPreference\": null,\n" +
			"        \"currency\": null,\n" +
			"        \"dateOfBirth\": null,\n" +
			"        \"department\": null,\n" +
			"        \"emergencyContactName\": null,\n" +
			"        \"emergencyContactNumber\": null,\n" +
			"        \"firstName\": \"Jayendra\",\n" +
			"        \"gender\": null,\n" +
			"        \"homeAirport\": null,\n" +
			"        \"homeAirportId\": null,\n" +
			"        \"language\": null,\n" +
			"        \"lastName\": \"Singh\",\n" +
			"        \"middleName\": null,\n" +
			"        \"nickName\": null,\n" +
			"        \"primaryEmail\": null,\n" +
			"        \"title\": \"Mr\"\n" +
			"      },\n" +
			"      \"preferences\": null,\n" +
			"      \"docDetails\": null\n" +
			"    }\n" +
			"  ],\n" +
			"  \"password\" : \"Cleartrip@123\"\n" +
			"}";

	String params_FK_Redirection="{\n" +
			"    \"currentPageUri\": \"https://qa2new.cleartrip.com/\",\n" +
			"    \"fallbackUri\": \"https://qa2new.cleartrip.com\",\n" +
			"    \"signupPageUri\": \"https://www.cleartrip.com/signin?service=/my-account\",\n" +
			"    \"provider\": \"flipkart\"\n" +
			"}";

	String params_FK_Redirection_Incomplete="{\n" +
			"  \n" +
			"    \"fallbackUri\": \"https://qa2new.cleartrip.com\",\n" +
			"    \"signupPageUri\": \"https://www.cleartrip.com/signin?service=/my-account\",\n" +
			"    \"provider\": \"flipkart\"\n" +
			"}";

	String params_Apiconfig_postcall="{ \"active_date\": \"2016-01-28T12:56:35+05:30\", \"api_key\": \"d4beada793e93d93fcd432141709400f\", \"api_product_id\": 1042, \"book\": 1, \"create_date\": \"2016-01-28T12:56:35+05:30\", \"inactive_date\": \"2018-01-28T12:56:35+05:30\", \"look\": 2000, \"update_date\": \"2016-01-28T12:56:35+05:30\" }";
	String params_Companyconfig_contactdata="{\"company\":{\"contact_data\":{\"addresses\":[{\"category\":\"work\",\"city\":\"Kolkata\",\"city_id\":396110,\"contact_data_id\":3647911,\"country\":\"India\",\"country_id\":694,\"id\":339346437,\"pincode\":\"560078\",\"seq_no\":1,\"state\":\"Ka\",\"state_id\":null,\"street_address\":\"Hyderabad\"}],\"phone_numbers\":[{\"category\":\"mobile\",\"contact_data_id\":3647911,\"country_code\":null,\"id\":25744681,\"mobile_number\":\"1234567890\",\"phone_number_value\":\"1234567890999999\",\"seq_no\":1}],\"emails\":[{\"category\":\"other\",\"contact_data_id\":3647911,\"email_id\":\"Hyderabaddddddd@cleartrip.com\",\"id\":9801717,\"seq_no\":1}]},\"company_configs\":[{\"config_name\":\"GALILEO_CORP_DEAL_CODES_100\",\"config_value\":\"AI9WMASTERCODEE\"},{\"config_name\":\"GALILEO_CORP_FARES_ENABLED\",\"config_value\":\"Y\"},{\"config_name\":\"GALILEO_CORP_FARES_ENABLED_disables\",\"config_value\":\"Yyyyyyyy\"}]}}";
	String params_ForgotPasswordEmail="{\"email\":\"cleartriptester@gmail.com\"}";
	String params_createUpdateGST = "{\"gst_details\":[{\"gst_number\":\"28SAILI1234H1SL\",\"gst_holder_name\":\"Test holder name\",\"gst_holder_address\":\"test , test apartment, test road, test phase, test nagar, Bangalore 560078\",\"gst_holder_state_name\":\"Karnataka\",\"gst_holder_state_code\":\"22\"}]}";
	String params_cleartripForWorkOptin="{\"emailId\":\"ns.likhitha@cleartrip.com\",\"status\":\"enabled\"}";
	//	String params_screencaptureInitiate="screenshot:data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA8AAAAQ1CAYAAAB6Lqa/AAAgAElEQVR4XuzdB7htRXn/8bn03hEUUcAWBUSKCIIinRBb7N3EEqOx9xqjJjGWWKKJvcZeYheQLiqIKEWRiA0RsCBFer//5zN55v7XXex9ztmn3LvP3b95nvPcffdea9bMd2atNb9533lnydKlS48vSSEQAiEQAiEQAiEQAiEQAiEQAiGwihNYsnTp0qWreB1TvRAIgRAIgRAIgRAIgRAIgRAIgRAoEcDpBCEQAiEQAiEQAiEQAiEQAiEQAhNBIAJ4Ipo5lQyBEAiBEAiBEAiBEAiBEAiBEIgATh8IgRAIgRAIgRAIgRAIgRAIgRCYCAIRwBPRzKlkCIRACIRACIRACIRACIRACIRABHD6QAiEQAiEQAiEQAiEQAiEQAiEwEQQiACeiGZOJUMgBEIgBEIgBEIgBEIgBEIgBCKA0wdCIARCIARCIARCIARCIARCIAQmgkAE8EQ0cyoZAiEQAiEQAiEQAiEQAiEQAiEQAZw+EAIhEAIhEAIhEAIhEAIhEAIhMBEEIoAnoplTyRAIgRAIgRAIgRAIgRAIgRAIgQjg9IEQCIEQCIEQCIEQCIEQCIEQCIGJIBABPBHNnEqGQAiEQAiEQAiEQAiEQAiEQAhEAKcPhEAIhEAIhEAIhEAIhEAIhEAITASBCOCJaOZUMgRCIARCIARCIARCIARCIARCIAI4fSAEQiAEQiAEQiAEQiAEQiAEQmAiCEQAT0Qzp5IhEAIhEAIhEAIhEAIhEAIhEAIRwOkDIRACIRACIRACIRACIRACIRACE0EgAngimjmVDIEQCIEQCIEQCIEQCIEQCIEQiABOHwiBEAiBEAiBEAiBEAiBEAiBEJgIAhHAE9HMqWQIhEAIhEAIhEAIhEAIhEAIhEAEcPpACIRACIRACIRACIRACIRACITARBCIAJ6IZk4lQyAEQiAEQiAEQiAEQiAEQiAEIoDTB0IgBEIgBEIgBEIgBEIgBEIgBCaCQATwRDRzKhkCIRACIRACIRACIRACIRACIRABnD4QAiEQAiEQAiEQAiEQAiEQAiEwEQQigCeimVPJEAiBEAiBEAiBEAiBEAiBEAiBCOD0gRAIgRAIgRAIgRAIgRAIgRAIgYkgEAE8Ec2cSoZACIRACIRACIRACIRACIRACEQApw+EQAiEQAiEQAiEQAiEQAiEQAhMBIEI4Ilo5lQyBEIgBEIgBEIgBEIgBEIgBEIgAjh9IARCIARCIARCIARCIARCIARCYCIIRABPRDOnkiEQAiEQAiEQAiEQAiEQAiEQAhHA6QMhEAIhEAIhEAIhEAIhEAIhEAITQWDsBfBZZ51VvvSlL03ZGNtss03ZYYcdym677VY22WSTVa7h+gwe8IAHlP3222+Vq+dsKnT++eeXj3zkI0NP/du//dty+eWXD+1DW221VXnEIx5Rtthii9lcftk511xzTfmf//mf8stf/nLZd3/9139d7nnPe84p3/k8uc9q9913L4ceemhZc8015/MyA/Pq9+E73elO5WEPe1hZb731FvzauUAIhEAIhEAIhEAIhEAINAKLQgB/9rOfLccdd1w55ZRTarkNnh/+8IeXJUuWlB/96EdVdNz+9rcvD3rQg8qTn/zksuWWW65SLUw8/OM//mP5yle+Uuv1+te/vrzmNa9Zpeo428oQdR/60IcKRl/+8peXZfOQhzykis+nPe1pVQD3+9AGG2xQCNS99967PPKRj5wXAfzFL36xfPCDHyzf/va3azk+8YlPlMc//vGzrdq8n4eVfvSxj32s5v2MZzyjvP3tby/rrrvuvF+rn6H2ee9731sw+uMf/1iF9yc/+cmy+eabL/i1c4EQCIEQCIEQCIEQCIEQWDQCWEFvuOGG8s53vrO89KUvreVug2fWox/84Afl1a9+dTnppJMKS/Ab3/jG8tjHPrasscYaq0wrL126tPz3f/93FfcRwLduVnyOPfbYKjaJK8lkwQMf+MCy2mqr1f/3+9C97nWvynTHHXesEynzkZTjda97Xf2Txk0AKxNx3rwHVqQAdu2f/vSn9d4khlclAXzFFVfUSbhtt912zhMp89EPk0cIhEAIhEAIhEAIhMBwAmNvAW5FZy16whOesJwAZj266aabylvf+tbyile8ov7GnZWlaVWzLHXrHwvwrTv0//7v/5ZHP/rRVVxJ3/nOd8o+++yz3IHD+tB8PiDe8IY3VCvruArg7373u2Xfffet5VvRAvhnP/tZbaMzzzxzxgL4t7/97bJJDWW+4x3vOK3I/PnPf16IUslE2F/8xV+Utddeez6beVleyveLX/yiCmBcXWtlpS6rqerdPW6jjTYqd7nLXaYssmfsueeeW6699toZM73++uuLe9K50kyuM1tu/fIN6yf94wb1pT/96U/lN7/5zbKi8I64613veqsJ1W79TLLxSlLHpBAIgRAIgRAIgfEnsOgFMMQf//jHl1lH73e/+1XXStYY6c9//nMdcJ9zzjnl97//fdl4440L6x/X1+6guL+G09pQljKDW5Yrg5uDDz64DnT6FkMDwx/+8IfljDPOKJdccsmtWn3QekfWQoMtLtwG7M4j2vfaa69avr4FeyoBbGCnft///vfLhRdeWLbffvty73vfu9ztbndbZgHtFmrQmuL73//+hUA5/vjj6/kHHnhgXRuqXKyGBrPWV+N7j3vcY2C+K7O7d8WVcsxUABvg9tfuOt/a4Tvc4Q5VULc16P01s6zK2h13CfOvf/3r5d/+7d/q/4dZgK+66qryve99r5x++um1D2pzeffX4s60nfQl9dfPiRvpzne+c9l///1vJRa7Avjv/u7vqlfFaaedVtuXeNPnt95661s15aj91fHut9Z3iCxLE1784hePZAFWn4suumiZAFPG+973vkM9PAjfI488srq9EzjqstAC2POBaHIPrSwBjJM//cnz4Ne//nWNi7DLLrss95zzrPnVr35V72XPmD/84Q9VAE8lgptwdCyhT/Cpqz42LHlutqUAmGj76YT2bJ4fyqbvX3nllfX+aWW9zW1uU59T7T1AsJ599tnl4osvrveE/3tu49PW/3se47PWWmvVovg/jxJeIv7a+0If0+ZXX3115eh+xkReEcGzacWcEwIhEAIhEAIrlsCiFMCsSO9///vrYOPGG28sb37zm6sbtPT0pz+9vOUtb6lC18BZgCSDIoMcAyVriX1+/vOfX/7qr/5qmegggD/60Y+WN73pTcVaSeKHO7VB1X/+539WgUkUvexlLyubbrrpslYy+Pn85z9fRfeGG25YB0oExVFHHVXLYK0yIdIP+KMs1osSveuvv34VQ8QJa8NLXvKSak1q7rsuNkwA33LLLdX9+13velcNKKTcBm2E/z/8wz/cKh959dcUc9l9wQteUE4++eTyrGc9q+y0007Vim6QiInBnsGuQSZBLF8TCPPlOjysyxuAWqu7zjrrTHtXzEUAa4f/+I//WBbAyvph/28C+J//+Z+roHj5y19eHvzgB9c+od9985vfLO95z3sqhwMOOKAO8PWFT33qU0MFsDr5nUAn0AjFCy64oDzxiU+s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CIRACIRACIRACIRACIRACIRABHD6QAiEQAiEQAiEQAiEQAiEQAiEwEQQiACeiGZOJUMgBEIgBEIgBEIgBEIgBEIgBCKA0wdCIARCIARCIARCIARCIARCIAQmgkAE8EQ0cyoZAiEQAiEQAiEQAiEQAiEQAiEQAZw+EAIhEAIhEAIhEAIhEAIhEAIhMBEEIoAnoplTyRAIgRAIgRAIgRAIgRAIgRAIgQjg9IEQCIEQCIEQCIEQCIEQCIEQCIGJIBABPBHNnEqGQAiEQAiEQAiEQAiEQAiEQAhEAKcPhEAIhEAIhEAIhEAIhEAIhEAITASBCOCJaOZUMgRCIARCIARCIARCIARCIARCIAI4fSAEQiAEQiAEQiAEQiAEQiAEQmAiCEQAT0Qzp5IhEAIhEAIhEAIhEAIhEAIhEAIRwOkDIRACIRACIRACIRACIRACIRACE0EgAngimjmVDIEQCIEQCIEQCIEQCIEQCIEQiABOHwiBEAiBEAiBEAiBEAiBEAiBEJgIAhHAE9HMqWQIhEAIhEAIhEAIhEAIhEAIhEAEcPpACIRACIRACIRACIRACIRACITARBCIAJ6IZk4lQyAEQiAEQiAEQiAEQiAEQiAEIoDTB0IgBEIgBEIgBEIgBEIgBEIgBCaCwNgL4BtvvHEiGiKVDIEQCIEQCIEQCIEQmD8Ca6655vxllpxCIARWGQJjL4CvueaaVQZ2KhICIRACIRACIRACIbBiCKy33nor5kK5SgiEwKIiMPYCOBbgRdWfUtgQCIEQCIEQCIEQGAsCsQCPRTOkECEwdgTGXgCPHbEUKARCIARCIARCIARCIARCIARCYFESiABelM2WQodACIRACIRACIRACIRACIRACIxKIAJ4VGI5PgRCIARCIARCIARCIARCIARCYFESiABelM2WQodACIRACIRACIRACIRACIRACIxKIAJ4VGI5PgRCIARCIARCIARCIARCIARCYFESiABelM2WQodACIRACIRACIRACIRACIRACIxKIAJ4VGI5PgRCIARCIARCIARCIARCIARCYFESiABelM2WQodACIRACIRACIRACIRACIRACIxKYOwF8I033jhqnXJ8CIRACIRACIRACITAhBNYc801J5xAqh8CITCIwNgL4GuuuSYtFwIhEAIhEAIhEAIhEAIjEVhvvfVGOj4Hh0AITAaBsRfA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jCAgAc6IYVYnRUAEREAEREAEREAEREAEREAEJMCaAyIgAiIgAiIgAiIgAiIgAiIgAhlBQAKcEcOsToqACIiACIiACIiACIiACIiACEiANQdEQAREQAREQAREQAREQAREQAQygoAEOCOGWZ0UAREQAREQARFIFoHNm6usYF25bSrfnKwqVY+ZZWc1sZbNsyy/VbZ4iIAIiEBUAhJgTQ4REAEREAEREAERSBCBtRvKbe7Sjba+uMKaZTdJUKkqJhYCm6uqrLh0sw3snWd9u7WM5RKdIwIikIEEJMAZOOjqsgiIgAiIgAiIQP0Q+GrmepuztMR26N7SWrfMqp9KVGpEAmUVVbaysMyWrymzU0Z0sZzspiIlAiIgAtsQkABrUoiACIiACIiACIhAggi8+ekq65KfY4P65CWoRBUTDwHSz58bs9JOPrizdWjTLJ5Lda4IiECGEJAAZ8hAq5siIAIiIAIiIAL1T+D5j5bbHgNaWbcOzeu/MtUQkcAbn622/XfNt16dWoiQCIiACGxDQAKsSSECIiACIiACIiACCSIgAU4QyO0oRgK8HfB0qQhkAAEJcAYMsrooAiIgAiIgAiKQHAIS4ORwrqkWCXDDj4FaIAKpTEACnOTRqaiosK+++srWrVvnau7SpYv74Wjbtq19+eWXtssuu7jft+f49ttvLS8vz/r37x9zMbTpu+++sz322MOaN489dasudcXcqEZwYnl5ub377rs2efLkbVp77rnnWu/eveu1F998842tXbvWRowYsV311LWckpISe+utt2zkyJHWsWPHmNtQ1/piriBDToT/hx9+aIceeqjl5uaauGbIwKubKUtAAtzwQyMBbvgxUAtEIJUJSICTODqbNm2yTz/91ObOnVstRU2aNLEVK1bY4MGDbcOGDfbJJ5/YOeecY7169apzyyj/1Vdftd12280OO+ywmMupiwDXta6YG9UITvQCfMcdd1i7du0cd46FCxe6hxuXXXZZXGIYT5ep4/e//70NGzbM/vSnP8Vz6Vbnbk85dRHg7amvzp1s4Avh9P3339vw4cMT1hLm3ssvv2wvvfSS3XfffdahQ4eUEeDp06e7eR/PQ5GEgVFBItCABCTADQj/f1VLgBt+DNQCEUhlAhLgJI4ON7/vvPOOi5TtvvvuruaVK1c66UV4y8rKGlSA64JCAvwDtT//+c8u4n72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zIZcFRVVbr3vuKnrrV3rLbtJF2+stH13aW0PvrF8m3PPP7brVhtmSYBjmSE6RwREIF4CEuB4ien87SKAtPqvOvIRYJ+eTITIfz2Sr4QoExsXBb83OSjA0cqqj1Tn7ep4DRf7iKNPUY4n3ba+2pRq5XoB9mvHaR8p4AgxUUr/9Uj+wQGvs0NypK8vQoD9Zlo+AkxUk3W38Wx2lWqM1B4REIHUIJBoAU6NXm3dilfHr95KgNcXV9hhe+TbE++vrJbaisoqF+098YD223xdE+uMb35mUUzn1qX/igDXhZquEYHMISABzpyxTpmeBlOTaVRws6tgmndwg6xojY9WVsp0NoaGeAEOpijHcFnGnRJMjabzwVTiYEov70VLufbQgmnOvBZMD844sOqwCIhAQglkggCzYZb/aiTgERVmJ2sfLeY1H0Vm3XL4YFfrWM+ty+BIgOtCTdeIQOYQkABnzlirpyIgAiIgAiIgAvVMIBMEuJ4RbnfxEuDtRqgCRCCtCUiA03p41TkREAEREAEREIFkEnjz01XWsU22Dem3ZYMoHcklsHlzlT03ZqWdfHAX69Bm2+hzcluj2kRABFKRgAQ4FUdFbRIBERABERABEWiUBL6evd5mLCyxnXq2tNYtt+yGrCM5BPiuYb6/ePmaMjtlRFf3HcQ6REAERCBMQAKsOSECIiACIiACIiACCSJQWFRuc5ZsNDaGYh2sjuQR2FxVZcWlm21gnzzr23XLtwLoEAEREAEJsOaACIiACIiACIiACNQjAdJwC9aV26byzfVYi4oOE8jOamItm2e53ad1iIAIiEA0AooAa26IgAiIgAiIgAiIgAiIgAiIgAhkBAEJcEYMszopAiIgAiIgAiIgAiIgAiIgAiIgAdYcEAEREAEREAEREAEREAEREAERyAgCEuCMGGZ1UgREQAREQAREQAREQAREQAREQAKsOSACIiACIiACIiACIiACIiACIpARBCTAGTHM6qQIiIAIiIAIiIAIiIAIiIAIiIAEWHNABERABERABERABERABERABEQgIwhIgDNimNVJERABERABERABERABERABERABCbDmgAiIgAiIgAiIgAiIgAiIgAiIQEYQSHkBLi8vz4iBUCdFQAREQAREQAREQAQSRyAnJydxhakkERCBtCGQ8gJcUlKSNrDVEREQAREQAREQAREQgeQQyM3NTU5FqkUERKBREUh5AVYEuFHNJzVWBERABERABERABFKCgCLAKTEMaoQIpByBlBfglCOmBomACIiACIiACIiACIiACIiACDRKAhLgRjlsarQIiIAIiIAIiIAIiIAIiIAIiEC8BCTA8RLT+SIgAiIgAiIgAiIgAiIgAiIgAo2SgAS4UQ6bGi0CIiACIiACIiACIiACIiACIhAvAQlwvMR0vgiIgAiIgAiIgAiIgAiIgAiIQKMkIAFulMOmRouACIiACIiACIiACIiACIiACMRLQAIcLzGdLwIiIAIiIAIiIAIiIAIiIAIi0CgJSIAb5bCp0SIgAiIgAiIgAiIgAiIgAiIgAvESkADHS0zni4AIiIAIiIAIiIAIiIAIiIAINEoCEuBGOWxqtAiIgAiIgAiIgAiIgAiIgAiIQLwEJMDxEtP5IiACIiACIiACIiACIiACIiACjZKABLhRDpsaLQIiIAIiIAIiIAIiIAIiIAIiEC8BCXC8xHS+CIiACIiACIiACMRIYENJhS1fs8nKyqtivEKnxUKgeU5Ta52bZV3aN4/ldJ0jAiIgAtUEJMCaDCIgAiIgAiIgAiJQDwQKCsts1uISKy2rtOysJvVQQ+YWubnKbFP5ZhvYO896d2mZuSDUcxEQgbgJSIDjRqYLREAEREAEREAERKB2AqMnrbaKys22U89cy23etPYLdEbMBErLNtv8FaW2vqTSTjigc8zX6UQREAERkABrDoiACIiACIiACIhAPRB44NVFduRe7a1zfrN6KF1FFpdW2kufrLKLT+wlGCIgAiIQMwEJcMyodKIIiIAIiIAIiIAIxE7gzv8usAuO7R77BTozbgIPv7nUfndan7iv0wUiIAKZS0ACnLljr56LgAiIgAiIgAjUIwEJcD3C/V/REuD6Z6waRCDdCEiAG/mIrly50r755pvqXuy2227WuXP8a2HWrVtnX331lVVUVFinTp2srKzM+vTp48rive+++8722GMPa948+m6Lc+fOteLiYtt1111Thip8FixYYLvvvrtlZ2enTLvUEBEQAREQgfQnIAGu/zGWANc/Y9UgAulGQALcyEcUwfvkk0+qBXWvvfaKW4CR3vHjx1thYaET4MWLF1tJSYkdf/zxNmTIkJgEmHa88sor1qpVKzvrrLO2obpw4UJr27at+0nWgbi/++67tnr1avvFL35Ro7wn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02ssN+3evXvYeOONm3VoLgATnJgdZuMGX4ceemicpaNdBPMZM2as9nr2/dkl2oXaSd1shAdmAHfZZZdw0003hSuuuKKoGWnKPf/88+NyWvrPjNz//u//hs997nPxrtyLFi1qWqrKTOR9990XZ4uzfcmHk1su/WZLfaate++9d7yhGUuue/XqFWcFacOkSZNiOKJN9ItZV8YPx2y9rR2nQmORlhNTJ/tC1j19hnoZM/aHlmaAs2OVlt5n7bL7Wlrqy/XvhMJC3ttss024+eabwze/+c1okwIk7WK28o477ohLntO18S+99FL05YZy2X4nd14v1O+0b9LOHXfcMY5NMSsJeH92v84uc6a9V155ZRzTAw44YI3lz+XaD9N3PPd70pLNm2++Gc4555y4EgJvDLOmuWNMPew7qc/8m0stBg8e3DQOFftjakUKKKCAAgqUWcAAXGZgi28MgXIFYPReeOGF8Mc//jEceOCB8UCea41TMCA4cNDOLNr6668fTjjhhHDbbbcFHstEUH7vvffCRz/60bUOwNdff30McZT98ssvh69//eth+PDhgdmwyZMnh8WLF8fXTz755DBixIhw5513xjtdz58/P4YFlm7Tvtx2EiLOPffcpuBKaCSYMrvGbO66BGBmswlkWLEMNC1VffDBB8OECRPCwoULoxdhudDduHMDDfaURZ+5m/esWbPCEUccEd56661wwQUXhCOPPDKsWLEinpj461//GkPHXnvtFe3mzZsXf546depqhjfccEOrxinfWHAygqXNWB999NEx5OD97W9/O44Ny9u5jpygybhsuOGGzQZgglIaK36m/K9+9atxTLJ2hEr2tUcffTT2/+CDD87r/eyzz4YOHTrEffGBBx4Ip59+euzzz3/+89heXLIBGGeCF+Pzve99L/Yh7VPs87gT/jipU6jftJsTFYw/9gcddFBRKwkI+Wm/ZozZh/v37x+/P4xjawNwKfbDNHOfTvCk78m3vvWtGFbz2eyxxx4hG4B5LNtFF13UZIpt7hhzgof9i9/RbjYuteCE1P7779/izf0a46+8vVRAAQUUaCsCBuC2MpL2o6oC3AWamTeuzW1u48Cag+nW3AWaA3MCIeGGMEIYZeOAlVlFboTFgStB+ac//WkMwLSDMMazh1u6UVZzM8DMfBGeCEBc/0igJQCzZJXQS8hgVnXYsGFN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AQUUUEABBRRQQIHGEKj5ALxo0aLGGAl7qYACCiiggAIKKFAyge7du5esLAtSQIG2I2AAbjtjaU8UUEABBRRQQAEF/i1gAHZXUECBfAI1H4AdNgUUUEABBRRQQAEFFFBAAQVKIWAALoWiZSiggAIKKKCAAgoooIACCtS8gAG45ofIBiqggAIKKKCAAgoooIACCpRCwABcCkXLUEABBRRQQAEFFFBAAQUUqHkBA3DND5ENVEABBRRQQAEFFFBAAQUUKIWAAbgUipahgAIKKKCAAgoooIACCihQ8wIG4JofIhuogAIKKKCAAgoooIACCihQCgEDcCkULUMBBRRQQAEFFFBAAQUUUKDmBQzANT9ENlABBRRQQAEFFFBAAQUUUKAUAgbgUihahgIKKKCAAgoooIACCiigQM0LGIBrfohsoAIKKKCAAgoooIACCiigQCkEDMClULQMBRRQQAEFFFBAAQUUUECBmhcwANf8ENlABRRQQAEFFFBAAQUUUECBUggYgEuhaBkKKKCAAgoooIACCiiggAI1L2AArvkhsoEKKKCAAgoooIACCiiggAKlEDAAl0LRMhRQQAEFFFBAAQUUUEABBWpewABc80NkAxVQQAEFFFBAAQUUUEABBUohYAAuhaJlKJAReOWVV8K9994bX+nZs2c47LDD4s+33HJLWLBgQfx5n332CZtvvrluVRRYsmRJeOihh8Luu+8eunbtWsWWrFn1nDlzwsMPPxz222+/prY98sgj4Zlnnmnap/r161eRNtOWF154Iey6666hY8eOFamzmEoqMX7Lly8P9913Xxg/frzf22IGxfcooIACCihQBwIG4DoYJJtYXwIE4Msvvzy89NJL4fDDDw9HHXVU7MB1110X/vGPf8QgccwxxxiAqzisBJvbb7893HrrreGHP/xh6Nu3bxVb03IAfvvtt8PVV18dunTpEl588cVwwAEHhD333DOUOwQTMi+77LIwefLkcNpppzV7ouD5558Pm266aUVOJlRq/Aj+Tz/9dFi4cGFgDFauXBm+9rWvld29pnZGG6OAAgoooEAbEzAAt7EBtTu1IfDkk0+Ga6+9Nnzve99rCgTvvvtuOOOMM+IB9MiRI2ujoQ3aikoFqFLx3nPPPeG5554LX/7yl+PqAsL7KaecUvb9qNgAzCzxhRdeGNtUiZMJlRq/G2+8MfTu3Tvsu+++4c0334zf3zPPPLPs7qXabyxHAQUUUEABBdYUMABXeK944403Av+xsexym222CTNmzAijRo2qcEtaV93SpUvDrFmzwtChQ5s+yGvPPvts2HbbbePMFP1ipoQ+NfpWTAAmXDADyfizpZliZonTv5nh4z0chO+9997hnXfeibPIbM0to27N0s1sOwYOHBgOPfTQuG8y45XqYmYvW/92220X+I+2sfEZtrvvvjvObLN8l+Xe9GnIkCEhtz3pdermM9tvv31gie+iRYvikvFiZzZb03aW72bbwX568803h29+85sxtGX7W+wS9XxG1MMqgClTpoR58+Y1jV2+5cNpWXP6viR/AiUrCDB/4oknwpVXXhk4gbL//vuHVatWhWuuuabZlQTZfqZl+Jhml+enMeW9jEGvXr3i7DJjk/Y79s0tt9wyPPjgg/HETb6l4rSVWeI77rgjLtk+/vjjw/rrr7/a0uE03oX+LuTzev3115suJci3HxU7ftni1pfFAAAgAElEQVQ+p3J4DU/GnRMK7MubbbZZvEyBLe2DvI+NfZqx/s1vfhMd6J+bAgoooIACCtSngAG4guPGDM5TTz0VBgwYEANju3btAgfwBMljjz22gi1pfVVTp04Nc+fOjQfDbBw0E3Iee+yxcPLJJ8eD/FoJwJMmTQp9+vSJ/1VrIwD//Oc/jwEmBR/G+vHHH2+aQWJG6fzzz4+zSRxo77XXXmHs2LHhkksuCRMmTAj/8z//E4PI9ddfH/r37x922GGHwEwgIRh/lmOedNJJecMi7/n9738f1ltvvfh+gtWpp566xjWclEOZLHFdvHhxePnll+N4jhgxItx5553xs7Sfkx/0ZeONNw5nn3122GijjWJ5BB/2g5/85Cfh0UcfDRdccEE44ogjQufOneP1qjvuuGP48Ic/HMMtfeIECYGJsHXCCSc0febggw+O/aCsj3zkIzHctbS1tu177LFHDHKctOnQoUMYNGhQeOCBB8Lpp58eQ2Xqb0u2qV30ozmjZcuWxeuLsc/uB+nzBKq//OUvcT+dP39+HAdMOJlw6aWXRidWEODY2gBMP5M3oZZAx7Lpiy++OMycOTN069Ytjvl//dd/BfZVxu3II48MK1asiO/lb9XEiROjE99tympNAOZvQe54f/SjH827r+LAPpX14oQgoZzvDA4Ezo997GPxZEBrxo/P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BJIg4Jcz4GmeNhEQARFIFQEJcKpIZk45TOa1rrza+pUVZk6lVJMdCGS6APs0YVJbP/jgAzdDcqKIZmfvYj+ZF1FhxvAmWkooE1ghwDzcYKUP36+sNMEEXtnczxLgTLi6VAcRSBEB0o8YQ0FKizYREAERSBUBCXCqSGZGOcjv1spaq6s161manxmVUi1iEsgGAWZ8LanJzRkb2tm72Qswab6J0rgziRNr/zIm12/pTE1uq3ZLgNuKtM4jAm1AgDE6jOMoLCx0085rEwEREIFUENiwxaxn9yIryC9IRXEqo50JsBxydW2dlXTJtS4F2buMUztjbJPTZ7oAtwkEnUQEUkxAApxioCpOBNqbABJMWkpurm5q2rsvdH4R6CgEauryrKCgwPILCqywQBKc7f0aiUQsL9esID/H+Le2zCUgAc7cvlHNspeABDh7+041F4G4BFjegNn+tImACIhAqgmQYaJNBESgbQhIgNuGs87SuQhIgDtXf6u1IiACIiACIiACIiACWUKgLQWYsZ4lJSVuXdpMn5yJybdY5mnp0qXNqittY3mfVK0rG1zuyF9K4XG9nJPNj/UNLg0UXHrJj7Gtra01/pBtE9zija2mDuFlmILHBcfuMm6XcbwsN8SauyyP5evAskZ+jC/rGgezQhItEeXPxbhm2pYtY5qptwQ4S74AVU0REAEREAEREAEREIHORaAtBfjoo4+2CRMm2KuvvupmKM7krSkB5v3Ro0fbZ5995oaFpUOAjz32WDf5F+LHGsVDhw61Z5991mbMmOGE8KKLLnLzsdx5551Ovr0AH3DAAU4+H3nkESfvJ510ku25555ubd2ioiIbP368W6+XurONGzfOrTXMDNt+o33nnXeeW2OYJYqCSxLxHhOT7b///jZz5kx3yE477eT2Zdkl6ok/TfEsAAAgAElEQVQ8z58/31555RV3btYkXrZsmVt/mSWaFi5c6OrGQ4Y1a9bYU0895doQa2uOAIf7o72vLQlwe/eAzi8CIiACIiACIiACIiACMQi0pQD379/fSdtbb72V8QLc1MUyduxYQ+gffvjhhvVrmzom2fcvueQS69mzp918881Obi+++GJjCNpf//pXGzlypFGHQYMGOZYw9duhhx7qBBSpRDKPOeYY99ZLL71k9MGll15qH3/8sXuf7ZxzzrHBgwfbn/70p4alh1ie6Mgj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U6a4//ft29fVhxRoosPsm5OTY9u3b3f1oXz2WbFihfXp08e9N3fuXFu8eLHts88+7j02n4adrADDqqioyNasWWOVlZUNXPLy8tx6wPAjgs55wv+HLzJP20jjHjJkiPu7pKTEunTpErNdnjVtKCsrs969e9uqVatcG3xUvOVXjY5sioAEuClCel8EREAEREAEREAEREAE2oFAKgWYsbAHHXSQzZ8/30lmfn6+vfPOO06Ahw4d6l5ftGjRDgK877772tFHH23Tp093+yKpCO2kSZOcvCF+w4YNcwL36KOPxnyd/UlLrq2ttddee62RAOfm5tpxxx1n7733nnvvpJNOcqQRy3Hjxrn6IKZEjTdt2mRffvmlk0zq8eabb9r555/v3vfCec8999iRRx7Z7Agwwn7uuee6+g8cONAWLFhg27Ztc21FRg844AD75z//6V6jDkj2I488YmPGjHEPFN5//32bOHGia9szzzzj0sEjkYiLvPfs2dPKy8vt3nvvtXPOOceJLtKLcFPes88+a4cccogxPpv3+DtdUfF2uHwz9pQS4IztGlVMBERABERABERABESgMxNojQDD7ZprrrF58+bZU089ZRdddJGLqD788MNOgC+44AKbOXOmE00EbvLkyTZr1qwdcPvxrbxx+OGHOwF899137eSTT7ann37ajbG9+OKLXTnxXicyTJo0QnjzzTc3Spnu37+/XXrppfbxxx87CT/hhBOcSBPdRRqR8zvuuMPVn2gx8omIsj355JMutZuo7NixY110mHMdeOCBzRZgWJxxxhlO/pHYzz77zIqLi43IN5Fm2CD/niHnRWiJUvfr189JeLhtyCz1RKKJXtNmpAtG8Off9AXthB3yTQSdOsyYMaMzX/Jt0nYJcJtg1klEQATaisDS1dvti5Xb3emKCnNt2E5F9tmSrVZTG7WcSMRGDC6yvj0K2qo6Oo8IiIAIiIAItJhAKgU4KMNUyAsZEVWikEhdrAmjfEryoEGDDFlFgJHq4DF+DHC815srwBs2bGhULhFgosMPPvignXnmmQ0y78+HQBKhRpKJaLdEgH2KN+0kAjt79mzXX0R4SRcnuu0FmDYfdthhbmwx7yOuRHTjyT2p2F6AjzrqqIaoMhOTEdlGnokGDx482J2TsiTALf64NPtACXCzUWlHERCBbCCAAL/5ySZbtaHKDtyt1HbbpcRe/XC9LVqx3fYa1tX2GdlVApwNHak6ioAIiIAIuLGofrxsS3CEI8BENolMMs71wgsvdGNbSUFOJMBEW4kCE22dMGGCqwaSRgSYlF9Skb/zne84eYz3enMFmAgw53vjjTecHFIvoqiPP/64iwAjp0RivQATcWb/adOmuYiqb0cyEWBSoGkf6dXjx4+3qqoqxwQxJsIdFG/2JeWa1GjeJzWa1PKgAPvoLm0OCvDxxx/vHiDwwMGPbYYladSMGaadRI7vv//+Nlm6qSXXU0c5RgLcUXpS7RABEWgg8M6sTfbxgq123lH9bMPmavt4wRbrVZpvewztal2LckVKBERABERABLKCQGsEODgJFoKIZH3zm9+0hQsXOgErLS11a/IijURQkc6XX355By6kITPmligoEVk29kXYmCRqyZIlLhpKGvIrr7ziJDL8+ksvveQm5ELAH3roIVcOZTIJlh8DjBgyJpY06wEDBjg5Jyo7Z84cd04iwUyCxbhloqlsCDGTYJHKjZwyUdVbb73l2sN43hdeeMGJdKIN+UVOmYSLMhizSySZNpAODUf6ARkmLRvhpnzee/75510dGd9M21588UX3wAK+ngVSy8MDpJxJxCiDjX2WLl1qJ554ooskc76CggJXZ+pEPRQNTs/HVAKcHq4qVQREoB0JeAHee3hXW7upygb36WJ7De/aUKPPl26z1RuqbECvQluzscqY/NKnRq/eWGXzllZYXTTqUqj3HFpii1Zud/uXFudZWWmeS7HOy404of5ybaWt3VjdKLU6XD4nHr1ziS1YXmEVlbU2pH8XG9y3i6vPx/O3WPm2GvdvXu/ZLd9mLtxiOTkR91puTsTVYc7ibW4/f16JfDteYDq1CIiACLQRgdYKsJ/xmegssovMxZoFGvny+4Sbhowhq8ENWXS/W0OGOKljbC6zKJPCy8zH4deZpMrP3hw8lnP6WaD97MpEVuPNAs25SJNGVNkQR/5N/f3G5FKIJK/5WaETdRfHDx8+3D0QYPMzM/uZpXktOPs1wsv+RKuR2eCs1UirL4cHDox5Zhwx9WBZJtpLxJgNQUfco9GoWxOZ+sKGBwGkdUuA0/chkwCnj61KFgERaCcCCPC7s8vdmF9E8fyj+1lBfk5DbRDUV6attx7d8qx/zwJbsrrSCeyBo0ttyscbnRAXd8mxuUsrbM9hJVZakuf2HzKgi0ujfv+zzbZqfZWdPbGvzV1WYWs3VdsBu3VrSK0Olz9/eYUN6tPFcnLMlq+ttP5lBXbi+N5GuvY7s8ptQK8CW72x2upqo7bf6G42c+FWW7SiwoYNLLL+ZYVWmB9xAsx+SPSIgcV2yB7d24muTisCIiACItBWBFojwG1VR52naQJIMpFeUrn9OGtmiyZ9PNbEY02XqD1aQ0AC3Bp6OlYERCAjCXgBHr1zsS1eVWn7juxq+4+uf7LrtwdeWmlFhTl23IG97J8zNriXx43oZq98sN5OOaS3lZXmu38zdvhbk/rZ6x/V74O4vj+n3D74bLOdPKG3rdlYbX2659ugvoVxy3/+3XW2paLWTjy4l32yYIstX1tlFxzT3559Z611KcixSfuWGZHnJ6assbFDS6ysW75NmbHRlT+oT6E99q/VLvo7anCxIdcRi+wg9RnZEaqUCIiACIhAqwhIgFuFL2MORoDPOusst8SSjwAT9SWF2v8/YyrbCSoiAe4EnawmikBnI+BToL95RB/7bMk2Fz3db1S3RmnQCPCIQUU2fmx3e/rttQ4RM0a/O6vczprY10WOicK+8sEGO+PwPi4F+q1Py+20w/rYnMVbncgiqxY122dEtx3GFscq/+SDext1m7eswglwcB/Oj+iSYk1qdrAe7Efq8+CvJNunZgej2p2tj9VeERABEegMBCTAHaeXg+nntIp0ZyLA2tqegAS47ZnrjCIgAmkmEJwEqyAvYq9O32BfrNhuh+ze3UlwVXWd/e/Lq2zMkOJGAkwEmGjt+LGlbnzvZ4juwq126oTeLoL72OtrbJ/hXa1bca4tXFFhm7bW2s59C+3QPXs0alG88sMCTAS4orLORaGp55NT17rxvrVRayTAiHF+XsROOKh+zNP8Lyts+MCiRmndaUaq4kVABERABNqBgAS4HaDrlB2egAS4w3exGigCnYtAeBkkIr+M6/3w880uSrvvqG4u7fj1jza6MbV7Du1qb8/a5CB9Y5+eLsV45boqFx1mbC+iiQwjtZOnrHH7Tdq3p20or7bXZmy0/Ud1swN2a5xezSRWr364wZU/clCxTZ+32R138Nju9snCLW7SrKP2L7Piwhx77t11tku/LlaQl2MVVbW2/6hSe29OuUu9Pnj3Upe6TZ2mfrLJTZLFVlsXtSP27iEB7lyXtlorAiLQCQlIgDthp6vJaScgAU47Yp1ABESgLQkgwMzSzOZThf0MyrxGKjGzOa/fXO0myerZLc/WlVe7/RHMwoKcHWaB9qnGiOjmbbUuSltVE7VZX2y1XQd02WFdYT8LNOUzznjr9lpXPksxbdhc42aY7tuzwI3pjTcLdE1t1NXTz14d3s/PIt2WbHUuERABERCBtiUgAW5b3jpb5yAgAe4c/axWioAIiIAIiIAIiIAIZBkBltJh/VxtIiACqSNw5ZVX2oUXXpi6AltYUiTKIljaREAEREAEREAEREAEREAEHIFNmzbZkUceKRoiIAIpJHDdddfZ6aefnsISW1aUBLhl3HSUCIiACIiACIiACIhAByVQVVVlxx9/vG3cuLGDtlDNEoG2J3DXXXfZPvvs0/YnDp1RAtzuXaAKiIAIiIAIiIAIiIAIZBqBW265xR5++OFMq5bqIwJZSWDUqFH2l7/8xbp27dru9ZcAt3sXqAIiIAIiIAIiIAIiIAKZRmDp0qX261//2j788MNMq5rqIwJZRaCsrMx+9KMf2aRJkzKi3hLgjOgGVUIEREAEREAEREAERCDTCCC/TzzxhL3//vu2YcOGTKue6iMCGU2goKDAdtttNye+Z5xxhuXn52dEfSXAGdENqoQIiIAIiIAIiIAIiEAmEli8eLET4FWrVpnmjs3EHlKdMpUA6c5jxoyxcePGZYz8wkoCnKlXjOolAiIgAiIgAiIgAiKQMQSYGEsCnDHdoYpkAQEiwJFIJONqKgHOuC5RhURABERABERABERABERABERABNJBQAKcDqoqUwREQAREQAREQAREQAREQAREIOMISIAzrktUIREQAREQAREQAREQAREQAREQgXQQkACng6rKFAEREAEREAEREAEREAEREAERyDgCEuCM6xJVSAREQAREQAREQAREQAREQAREIB0EJMDpoKoyRUAEREAEREAEREAEREAEREAEMo6ABDjjukQVEgEREAEREAEREAEREAEREAERSAcBCXA6qKpMERABERABERABERABERABERCBjCMgAc64LlGFREAEREAEREAEREAEREAEREAE0kFAApwOqipTBERABERABERABERABERABEQg4whIgDOuS1QhERABERABERABERABERABERCBdBDIeAGurq5OR7tVpgiIgAiIgAiIgAiIQAcmkJ+f34Fbp6aJgAi0lEDGC/C2bdta2jYdJwIiIAIiIAIiIAIi0EkJFBcXd9KWq9kiIAKJCGS8ACsCrAtYBERABERABERABEQgWQKKACdLTPuLQOcgkPEC3Dm6Qa0UAREQAREQAREQAREQAREQARFINwEJcLoJq3wREAEREAEREAEREAEREAEREIGMICABzohuUCVEQAREQAREQAREQAREQAREQATSTUACnG7CKl8EREAEREAEREAEREAEREAERCAjCEiAM6IbVAkREAEREAEREAEREAEREAEREIF0E5AAp5uwyhcBERABERABERABERABERABEcgIAhLgjOgGVUIEREAEREAEREAEREAEREAERCDdBCTA6Sas8kVABERABERABERABERABERABDKCgAQ4I7pBlRABERABERABERABERABERABEUg3AQlwugmrfBEQAREQAREQAREQAREQAREQgYwgIAHOiG5QJURABERABERABERABERABERABNJNQAKcbsIqXwREQAREQAREQAREQAREQAREICMISIAzohtUCREQAREQAREQAREQAREQAREQgXQTkACnm7DKFwEREAEREAEREAEREAEREAERyAgCEuCM6AZVQgREQAREQAREQAREQAREQAREIN0EJMDpJqzyRUAEREAEREAEREAEREAEREAEMoKABDgjukGVEAEREAEREAEREAEREAEREAERSDcBCXC6Cat8ERABERABERABERABERABERCBjCAgAc6IblAlOjKBlStX2rx58+I2sU+fPjZixAjLzc1tEsP27dvtxRdftAMPPNAGDBiQcP/33nvPPv7445j7HH744TZq1Kgd3vv8889typQp7vWTTjrJnaMl5TTZEO0gAiIgAiIgAiIgAiIgAu1AQALcDtB1yqYJVFZW2rRp0wzhC29dunSx/fff3woLC5suKM4eq1evtsWLF9s+++xjeXl5LS6nOQdyniVLljTs6oV4zz33tO7du1tzBNiLL+UgwL/+9a9t3LhxcU/P/r/4xS/slVde2WGfrl272m9+8xs76KCDGt7bsGGDvfDCC/bhhx+615BjBLhnz55JldMcHtpHBERABERABERABERABNqLgAS4vcjrvAkJlJeX2+OPP26DBw+2TZs22ezZs53wIb1Lly61008/3UpLS2OWgSQilvyJtVHeSy+9ZOvWrbOLL764VSLdnG5cv369zZ8/35B6tmQFGJl98skn7YEHHjDEne3OO+9MKMArVqywZ5991qLRaKMqEs2NRCJ24403OvFmY1/KJkoN4yOPPLIhOpxMOc1hoX1EQAREQAREQAREQAREoD0JSIDbk77OHZcAsojIkhqM8P7973+3Sy65xEkvorbzzjvHFFeOe+qpp2z8+PFOnjNBgIkAI5LV1dWuOtu2bbNPP/3UtaF///5NRoB99Jf0ZKK0W7ZsaVKAiejW1NQ0SC7n9VFhzvvd737XRb557d5777VnnnnGrrjiCjv66KMbRcSbW44uZREQAREQAREQAREQARHIBgIS4GzopU5ex7AAgwO5mzFjhosOs/l04qlTp9rbb79tY8aMcenNpPt+8sknbp9g6jQC+uabb7ZJBHjNmjVWVlbWMMZ31qxZ9tZbb9lxxx0XV9JjdfmiRYvsqquucjLdVAQ43vGkRX//+9+3vfbay+3CGOHrrrvO1WPs2LGO0fDhw+2www6LmxpOPcLldPJLVM0XAREQAREQAREQARHIEgIS4CzpqM5czVgCjPwuX77cRYG9BB966KE2c+bMRgKMrK1atcoJ6Jw5c+yMM85wsteWAuwjvj4Feu3atTZo0CDbe++9LT8/v9ld21oBJo2aFOif/exnTnSJ/t5+++02efJkO++886ygoMDeeOMNVx9SwydOnBhTgsPlNLsB2lEEREAEREAEREAEREAE2pmABLidO0Cnb5pAWIARyb/97W921FFHNYwRJu2ZKPDQoUPt7rvvbhBdhLhHjx62YMECe+edd9zETrvvvnubCjDC++ijjzrBJKWb+hBtTUZ+odQaAfbpz8wefeqppzroRJKvvvpqW7hwod188802YcIEu+uuuxw/5Dw4Ttj3Uqxymu5B7SECIiACIiACIiACIiACmUFAApwZ/aBaJCAQFmAmyEKAzz333IaJsF577TVXArNDhwWYiaNImZ4+fXq7CDARYFKev/jiCxdVHTZsWIv6uzUC7NOWif7uuuuu7vxMLHb55Zc3GlP8+uuv2zXXXOOWP/rd737XsK+vcKxyWtQYHXtLOxEAAByGSURBVCQCIiACIiACIiACIiAC7UBAAtwO0HXK5AjEiwAT8d1vv/2c3D799NMu+huMAPft29fuv/9+GzhwoItuPvTQQ0aadFtHgGktadovv/yyVVRUuImmmPwq2a01AhwrbZkHApdeeqmrhh9T7F+LJ8BKf06217S/CIiACIiACIiACIhAJhGQAGdSb6guOxAgestkVX4ZJCK8iC1jgPnDjMYIMEv7sK4tMxvfc889ttNOO7mJsDi2V69ebkkk0qG9DDNZFmnRxx57rJssqy02xiw/99xzTn5Zaqi4uDip0yYSYNKZmckZNrSJMb5+i5e2THn/8R//4ZZWIgX6iCOOcFFypJgHCYwPRoSbKiepRmhnERABERABERABERABEWhHAhLgdoSvUzdNADnzszizN1FfJC/WLNDh15G4rVu3ukmwEOPc3Fyrra21kSNH2ty5c10Z/fr1sz322KPpiqRgD86NyDMWmSg0Mp/MOOB4Akw7GGN82223OTaM3fWzPFPteGnLwUmwzjzzTDce+N1333Up0P7/QZFW+nMKLgIVIQIiIAIiIAIiIAIi0K4EJMDtil8n72wEWAt42rRpbhIuJsIi+txUJJi1eFn/l1Rwvw4wk3kxoRZLKXXr1q1h8ip4Xn/99XbyySc3oE2Utszawo888oibHZrIMWsWs9by2WefbaNGjWrUPUp/7mxXq9orAiIgAiIgAiIgAh2PgAS44/WpWpThBPyySFSTSHBzBXjLli2NWsYaxwhwz549DZGdMmWK+xs5Jp3Zb8gtGzNAx9p8+rR/j+ODqc/NLSfDsat6IiACIiACIiACIiACImASYF0EItBBCCCyRGlPPPFEtzyUNhEQAREQAREQAREQAREQgcYEJMC6IkSgAxAg8jtnzhyXvnzYYYe5Mc/aREAEREAEREAEREAEREAEJMC6BkSgwxFAgDdu3Bg3zbnDNVgNEgEREAEREAEREAEREIEWEFAEuAXQdIgIiIAIiIAIiIAIiIAIiIAIiED2EZAAZ1+fqcYiIAIiIAIiIAIiIAIiIAIiIAItICABbgE0HSICIiACIiACIiACIiACIiACIpB9BCTA2ddnqrEIiIAIiIAIiIAIiIAIiIAIiEALCEiAWwBNh4iACIiACIiACIiACIiACIiACGQfAQlw9vWZaiwCIiACIiACIiACIiACIiACItACAhLgFkDTISIgAiIgAiIgAiIgAiIgAiIgAtlHQAKcfX2mGmchgbVr19rixYuttLTURowYkVQLKisr7bPPPrPi4uK4xy5dutQ4x7Bhw9w5mrt9vnSb23XU4GJbunq7fbFyu+XlRmyPoV2ta1Fuc4tJuN/qjVU2b2mF9e6R787Tko26rS+vsQG9C+KW5ffZa3jXlpxCx4iACIiACIiACIiACHQCAhLgTtDJamL7E0BOP/zwQ6utrbXjjz8+qQohwFOnTjX+jnfsokWL7L333rMJEybYoEGDbPny5da1a9eEMoz8fjx/iyGMA3sX2usfbbCiglyb9+U2O2KvHjZ6l5Kk6hlvZwT42bfXOQE++eDeMXeb/2WFlZbkWt8eBTHfDwpwvLLY551Z5U6yJcEp6ToVIgIiIAIiIAIiIAIdjoAEuMN1qRqUqQSI4i5cuDBpAaY9TR2LHL/00ks2btw469+/v7355psuWowMx9q2VNTa8++us10HdLH9R5faohUV9vpHG+3MI/ragi8rrKw0zwb37ZIylE+/vdaVFUuAq6rr7Km31tqYISU2dkjT0p2oLKR+2meb7ej9e8aV6ZQ1SgWJgAiIgAiIgAiIgAhkHQEJcNZ1mSqcrQQSSaxPc66pqXHN22WXXax37942b948Ky8vt6qqKtuwYYMdcMABLpWa9ysqKmz16tXu3926dWsQ4M2bN9uMGTNswIABtscee7hywttni7faJwu32qkTeltVTdT+OX2DLVqx3fYcVmLDBxbZsjWVVlMbdYcN7ltoazfVWG1d/f+75OfYbrsUu+MrKmuttDgvZsQVsWWfyqo6W7J6u5UU5ToB9qnWOZGIjRhcZItXbre3Py23QX0Lbe/hXW31hqqGcw/p38UKC3IapT17AT52/zJXPlu34lzbtX8XK8jPsRfeW2ddi3Pt0D16ZOulonqLgAiIgAiIgAiIgAikiYAEOE1gVawI7CCdCSLAQQFmPC9SO3jwYHv//fetX79+tmrVKlccAvzqq6/a3nvvbSUlJfbWW2+5f++6665JCfCrH6535U3at8yIBscTYCKqCHBtndm8pdts2MAiG9yni+XkmLm05eI8N26YiGs4Yjxz4RYnqDv1KrB5yyqsf68Cm7hPz4ZU6zWbqqy0JM+6l+TZB59t3kGAOTcCvOewro1SqL0AjxvRzabO3ORSp4sLc+zgsd2dAE+fu9kWrthuZxzeRxehCIiACIiACIiACIiACDQiIAHWBSECbUSgqTRmor9z5851f/r27WuRSMTVbPz48fbOO++4CDBjgJ9//nkbOnSojR49uuHfQQHu06dPgwzHS4FGIvt0z7fxY7u7c8z6Yqu9O6vczprY101+5aO3H83fbH17FtiwnYpsyoyNdvKE3jaoT6E99q/VLkrbr2eBfbJwi+0xtMTJtN84/vE31jipPXB0qU2essZFaffYtcReeG+9G6e7akOVrSuvtn+b0NtemrbBDhpb6lKgw+cmahxMew4LcH5exHqV5tkRe/dsaMsnC7baOUf2baOe1WlEQAREQAREQAREQASyhYAEOFt6SvXMegKJBJg05/nz57tU55UrVzoB3r59uxUVFTkBJqV5xYoVjQR4+PDh9txzz9moUaMaRYCbI8DBCHBYgLdV1tqcL7bZ1spaW762skGAg4L8wEsr3WzRRIfZkOTgDM9I7N9eXWXDBxW5VGSEuUthjhNpos1jdimxgvyIK2PogCJ79p11ToD79Mjf4dzxBNinQJOGvWJdlY0fW+qi0IoAZ/1HRQ0QAREQAREQAREQgbQRkACnDa0KFoGvCSC4zNK8bt0623fffXdYzmjZsmUutZnU502bNllOTo4NGTLEmN2ZKC5jfXl90qRJDeOCy8rKbMGCBYbwchzp0kSG99lnH3vllVfcuGD+HWtZpHhjgPceUb/80b+mb7BddyqyDZurjbG6iOnC5dtt4rgebomkt2ZusuXrKq1/Wf2szaQqh1Og2YcZpZHeOYu3Odk9cEypfbJgi5ugCgEuKsy10TsX2+TXV1uPrnmuPI4LnvuwvXrYGx9vdOcJ/3vV+iqri0ZdBNvPXK0xwPrkiYAIiIAIiIAIiIAIxCMgAda1IQJtQAABRlbr6upirgUcfJ/qeAEm6stkV4WFhW4ZJESXjYmw2Ic/bN27d3dyTcR45MiRTpy3bNkSd11gxv2y7BEpzLvtUmKM1yWlGUklxXnJqkonlq4ukfpIbVVNXUOkl+P9MfEEOLgPY3NraqJu0qsNm2vcRFdsCPCeQ0ucILN/v7IC81Lrz+1f4/+x/k09/drFX66t1CzQbXA96xQiIAIiIAIiIAIikK0EJMDZ2nOqtwi0kgCzMX+8YIuNGFTcKH25lcW22+FaB7jd0OvEIiACIiACIiACIpA1BCTAWdNVqqgIpJ4A0ritsq7DCPD68pqYSzKlnpxKFAEREAEREAEREAERyEYCEuBs7DXVWQREQAREQAREQAREQAREQAREIGkCEuCkkekAERABERABERABERABERABERCBbCQgAc7GXlOdRUAEREAEREAEREAEREAEREAEkiYgAU4amQ4QAREQAREQAREQAREQAREQARHIRgIS4GzsNdVZBERABERABERABERABERABEQgaQIS4KSR6QAREAEREAEREAEREAEREAEREIFsJCABzsZeU51FQAREQAREQAREQAREQAREQASSJiABThqZDhABERABERABERABERABERABEchGAhLgbOw11VkEREAEREAEREAEREAEREAERCBpAhLgpJHpABEQAREQAREQAREQAREQAREQgWwkIAHOxl5TnUVABERABERABERABERABERABJImIAFOGpkOEAEREAEREAEREAEREAEREAERyEYCEuBs7DXVWQREQAREQAREQAREQAREQAREIGkCEuCkkekAERABERABERABERABERABERCBbCQgAc7GXlOdRUAEREAEREAEREAEREAEREAEkiYgAU4amQ4QAREQAREQAREQAREQAREQARHIRgIS4GzsNdVZBERABERABERABERABERABEQgaQIS4KSR6QAREAEREAEREAEREAEREAEREIFsJCABzsZeU51FQAREQAREQAREQAREQAREQASSJiABThqZDhABERABERABERABERABERABEchGAhLgbOw11VkEREAEREAEREAEREAEREAERCBpAhLgpJHpABEQAREQAREQAREQAREQAREQgWwkIAHOxl5TnUVABERABERABERABERABERABJImIAFOGpkOEAEREAEREAEREAEREAEREAERyEYCEuBs7DXVWQREQAREQAREQAREQAREQAREIGkCEuCkkekAERABERABERABERABERABERCBbCQgAc7GXlOdRUAEREAEREAEREAEREAEREAEkiYgAU4amQ4QAREQAREQAREQAREQAREQARHIRgIS4GzsNdVZBERABERABERABERABERABEQgaQIS4KSR6QAREAEREAEREAEREAEREAEREIFsJCABzsZeU51FQAREQAREQAREQAREQAREQASSJiABThqZDhABERABERABERABERABERABEchGAhLgbOw11VkEREAEREAEREAEREAEREAERCBpAhLgpJHpABEQAREQAREQAREQAREQAREQgWwkIAHOxl5TnUVABERABERABERABERABERABJImIAFOGpkOEAEREAEREAEREAEREAEREAERyEYCEuBs7DXVWQREQAREQAREQAREQAREQAREIGkCEuCkkekAERABERABERABERABERABERCBbCQgAc7GXlOdRUAEREAEREAEREAEREAEREAEkiYgAU4amQ4QAREQAREQAREQAREQAREQARHIRgIS4GzsNdVZBERABERABERABERABERABEQgaQIS4KSR6QAREAEREAEREAEREAEREAEREIFsJCABzsZeU51FQAREQAREQAREQAREQAREQASSJiABThqZDhABERABERABERABERABERABEchGAhLgbOw11VkEREAEREAEREAEREAEREAERCBpAhLgpJHpABGIQ6C22qJb1pnVVAuRCNQTyMu3SNdeZrn5IiICIiACIiACIiACIpABBCTAGdAJqkL2E4iuW2J10x43/o7WVmV/g9SClBCI5BZYpPfOlnPAWRbpuVNKylQhIiACIiACIiACIiACLScgAW45Ox0pAg0Eal681WpfvNWscquoiEBjAoUllnv8tZZ39NUiIwIiIAIiIAIiIAIi0M4EJMDt3AE6fccgUPWrQyy6fHbHaIxakXICkZ3GWMFP30p5uSpQBERABERABERABEQgOQIS4OR4aW8RiEmg8sr+ZjWVoiMCsQnkFVrh71eKjgiIgAiIgAiIgAiIQDsTkAC3cwfo9B2DQOVlPTtGQ9SKtBEo/POGtJWtgkVABERABERABERABJpHQALcPE7aSwQSEpAA6wJpioAEuClCel8EREAEREAEREAE0k9AApx+xjpDJyAgAe4EndzKJkqAWwlQh4uACIiACIiACIhACghIgFMAUUWIgARY10BTBCTATRHS+yIgAiIgAiIgAiKQfgIS4PQz1hk6AQEJcCfo5FY2UQLcSoA6XAREQAREQAREQARSQEACnAKIKkIEJMC6BpoiIAFuipDeFwEREAEREAEREIH0E5AAp5+xztAJCEiAO0Ent7KJEuBWAtThIiACIiACIiACIpACAhLgFEBUESLQagEecYjZ0APNIjn1MNctMfvyU7M+Q80+fjZ1gPf/plnZILOF75nNeyt15TZVUq+dzfY83qywq9mWdWZT723qiKbfn3CRWddeZpVbzD55vp5ZcGuvtsapuQS46S7VHiIgAiIgAiIgAiKQbgIS4HQTVvmdgkCrBHj/b1rkoG+ZDRxj0ZkvOpGLDDvI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" + 
	//			"itinerary_id:682a669743-c483-4d70-9219-200205121647" + "step:itinerary" + 	"ddt:30/03/2020";
	String params_cfwgstdocstatusupdate="{\"emailId\":\"ns.likhitha@cleartrip.com\",\"status\":\"accepted\"}";

	String s=RandomStringUtils.randomAlphabetic(3);
	String params_identityserviceaddclient1= "{ \"clientId\":\"likhithaa" +s;
	String params_identityservicesignin="{" + " \"username\": \"automate@test.com\"," + "  \"password\": \"Cleartrip@123\"" + 	"  " + "}";
	String params_IdentityService_Signin_FlyinUser="{\"username\":\"sandeep.shivanadhula@cleartrip.com\",\"password\":\"Preprod@123\"}";
	String params_IdentityService_Signin_Unauthorized="{\"username\":\"sandeep.shivanadhula@cleartrip.com\",\"password\":\"Pre@123\"}";
	String params_identityserviceaddclient2="\", \"clientSecret\":\"secret\", \"authenticated\":\"true\", \"scope\":\"all\", \"authorizedGrantTypes\":\"read,write,trust\", \"redirectUri\":[\"http://localhost:8080/ctauth/authorize\"], \"authorities\":\"authorities\" }";
	String params_Flipkart_Accounts_Service_CreateUser="{\"travellerDetails\":[{\"isRegistered\":true,\"personalDetails\":{\"dateOfBirth\":739650600000,\"firstName\":\"name for\",\"lastName\":\"testingautomate\",\"title\":\"Mr.\",\"nationality\":\"Indian\"},\"docDetails\":[{\"docNumber\":\"2345\",\"docType\":\"PASSPORTautomate\",\"expiryDate\":\"2020-09-11T00:00:00\",\"issuedDate\":\"2009-05-11T00:00:00\"}]}],\"gstDetails\":[{\"gstNumber\":\"12345automate\",\"gstHolderCompanyName\":\"flipkart\",\"gstHolderCompanyAddress\":\"address\",\"gstHolderStateName\":\"Karnataka\",\"pinCode\":\"12345\",\"city\":\"bangalore\"}]}";
	String params_Flipkart_Accounts_service_CreateUser_ExistingUser="{\"travellerDetails\":[{\"isRegistered\":true,\"personalDetails\":{\"dateOfBirth\":739650600000,\"firstName\":\"name for\",\"lastName\":\"testingautomate\",\"title\":\"Mr.\",\"nationality\":\"Indian\"},\"docDetails\":[{\"docNumber\":\"2345\",\"docType\":\"PASSPORTautomate\",\"expiryDate\":\"2020-09-11T00:00:00\",\"issuedDate\":\"2009-05-11T00:00:00\"}]}],\"gstDetails\":[{\"gstNumber\":\"12345automate\",\"gstHolderCompanyName\":\"flipkart\",\"gstHolderCompanyAddress\":\"address\",\"gstHolderStateName\":\"Karnataka\",\"pinCode\":\"12345\",\"city\":\"bangalore\"}]}";		
	String params_identityserviceaddclient=	params_identityserviceaddclient1+params_identityserviceaddclient2;
	String i = generateRandomWord(4);
	//expressway-register API POST body
	String params_registerUser="{\"username\":\"htedtalksatct"+i+"@gmail.com\", \"password\":\"Hello@123\",\"title\":\"Mr\",\"first_name\":\"Sujeett\", \"last_name\":\"Giger\", \"country_code\":\"91\", \"phone_number_value\":\"8765432161\", \"mkt_sbpt\":\"1\",\"service\":\"\", \"caller\":\"REG_FORM\", \"mail_token\":\"27A5E09E7260EAFB9815A27AEC554AF6\", \"_\":\"\"}";

	String params_externalApi_Refreshtoken="{\"refresh_token\":\"a0646154-7d20-4808-b73a-f1e100be1387\",\"company_id\":\"5363218\",\"expiry_date\":\"Tue Jun 02 14:57:37 IST 2020\",\"geolocation\":\"https://lik.api.concursolutios.com\"}";
	//create update traveller
String params_IdentityService_Signin_Userauthentication_B2C_B2B="{\"username\":\"ns.likhitha@cleartrip.com\",\"password\":\"cleartrip123\",\"companyId\":110340}";
	String params_createUpdateTraveller="{\"update_travellers\":{\"adultId1\":{\"user\":{\"personal_data\":{\"first_name\":\"new\",\"last_name\":\"userz\",\"date_of_birth\":\"\",\"title\":\"Mr\"},\"id\":\"41699808\",\"company_id\":110340,\"travel_profile\":{\"passport_no\":\"\",\"passport_date_of_expiry\":\"\",\"passport_issuing_country_id\":\"\",\"meal_preference\":\"0\",\"frequent_flyer_numbers\":[{\"frequent_flyer_number_value\":\"this is 145"+i+"4dfd10\",\"airline_code\":\"AI\",\"airline\":\"Air India [AI]\"}]}}}}}";
	String params_IdentityService_Signin_Userauthentication_B2C_B2B_b2bUser="{\"username\":\"ns.likhitha@cleartrip.com\",\"password\":\"cleartrip123\",\"companyId\":5266208}";
	String params_createTraveller="{\"create_travellers\":{\"adultId1\":{\"person\":{\"personal_data\":{\"first_name\":\"hahaha\",\"last_name\":\"ThisIsWorking\",\"date_of_birth\":\"\",\"title\":\"Mr\"},\"id\":0,\"company_id\":110340,\"travel_profile\":{\"passport_no\":\"\",\"passport_date_of_expiry\":\"\",\"passport_issuing_country_id\":\"\",\"meal_preference\":\"0\",\"frequent_flyer_numbers\":[]}}}}}";
	String c = generateRandomWord(4);
	String params_createCompanyTags="{\"company_tags\":[ { \"coupon_expiry_date\": \"2018-11-04T23:59:59+05:30\", \"source_type\": \"SYNC\", \"tag_description\": \"Reward program coupon for trip Q1809051040\", \"tag_name\": \"Coupon:CTRP58"+c+"28df\", \"user_id\": 36348 }]}";
	String params_createUpdateTraveller_bookstep2="{\"update_travellers\":{\"adultId1\":{\"user\":{\"personal_data\":{\"first_name\":\"new\",\"last_name\":\"userz\",\"date_of_birth\":\"\",\"title\":\"Mr\"},\"id\":\"41699808\",\"company_id\":110340,\"travel_profile\":{\"passport_no\":\"\",\"passport_date_of_expiry\":\"\",\"passport_issuing_country_id\":\"\",\"meal_preference\":\"0\",\"frequent_flyer_numbers\":[{\"frequent_flyer_number_value\":\"this is 145"+i+"4dfd10\",\"airline_code\":\"AI\",\"airline\":\"Air India [AI]\"}]}}}}}";
	String params_AccountsInfoAPI_BasedonUserId="{ \"people_ids\": [ 123, 14029546 ], \"filters\": { \"status\": [ \"A\",null ], \"exists\": [ \"api_key\" ] } , \"projections\" : [\"id\",\"status\",\"api_key\",\"username\"] }";

	String params_linkdepositaccount="{\"id\":387212750, \"linkable_id\":41654804, \"linkable_type\":\"Person\"}";

	String li = RandomStringUtils.randomAlphabetic(5);
	String params_pwaregister="{\"username\":\"testpwa"+li+"@gmail.com\", \"password\":\"Hello@123\"}";
	String params_pwafetchDAdetails="";				
	String cookie_value="MKdWExw7U5XHoqe5gvgNopvxR5VsdX%2BpbbtylbnbKovhQpnu62WWKv%2BtD0jlCQDW8KL31XDlHVQmZoLGGy3WuRq1V5%2Ff3cyOpY2e6VG%2B%2BEOmq1SZSPf0WwaBL9xsdFkeY8GZx6NCwQFZbnJNIFnBulgIq9NgXMFGIPcWjGvmYQ%2B7UvTyVzquOz%2F1UiyzcmLYG3ErhISsFBA7BHEzpGo4DEDWyymP5FpIOUZNJCY9VHPeH9%2BfEB%2FiE0WBt%2Fw8puA9IuQyIf89aiXKZtgoUuvt2S5NH52%2FqXy5YwY4naN9Fcti8vagSTjEILeaVGDZ9b0juahVCMz9Vt4TUmw5bD1fEhp8aGI0bkbHwvph%2F%2Ft678xfrYbifDim8FL7wHL9GLFX%2FgE5ffoswLeSHRaogy%2BY3VIwd%2BA0HfHap1%2FZKKJCwCp1FSlOYF7EqPdAiqIcu6uoDuIhpL2LD8jpaIgkNQT9G803IMJwTODu%2BN%2BIs%2BffvAOq8MsEeEuvJSbH7PowAwVswaTwsas4StK%2BPgsSD4qhUzenIycPyPqUUz5dsqejPub%2FM95pcbY4SRSdUkjIIF4wvM%2FxxitipKMbF8a57BVyUsQXhrQ8KUs7LfEQJw1bgBTXfF%2BmXV4GdF3cGT4Ijps1%2FBYKFLzqdoorE5DNKwtjZBgaRXctMghyBrbIkk1oVlwcO2XdIRIMLR3MvvwrB7R%2BLpWZgHfDMhEbt%2Bu7TdG8I425Ob4Au8ejc%2BuIvEQXek%2FWb25YYgoaZ3u0i1r%2Fb%2BL8vJHXcEOEUlE82lIxQfU3VpRaGR0GlHLFiGZZTVNEQsc%3D";
	public HashMap<String, Object> headersForms(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("ct-gn-auth", "dc7cfd533f661f92ebf6dceaf9930c3dba977bb8");
		return headers;
	}

	public static int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(10000);
	}


	public String generateRandomWord(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Object> headersForms1(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "text/json");
		return headers;
	}

	public HashMap<String, Object> headersRegister(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("x-ct-caller-app", "mobile");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> headersFK_Redirection(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("caller", "qa2new.cleartrip.com");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Content-Type", "application/json");
		return headers;
	}
	public HashMap<String, Object> verifyperson(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "*/*");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		return headers;
	}

	public HashMap<String, Object> verifyaccount(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "*/*");
		headers.put("domain", "www.cleartrip.com");
		return headers;
	}

	public HashMap<String, Object> UpdateDetails(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Cookie", "ct-dvid =ukp0PdnFTUny19Mk34iKdMMSK79SLAL5WAK2IzoNxgw3TU4I4QePrYkRI%2FxpPPq7ZkeoczqVmtS4hOIm4M5wc5wNQMQNTGrbH5ao6ctGiuo%3D;ct-auth =Ib3dr1MhdZAW26Y54wdeslR7jL8qp4WgMgO%2F6zVePhY2Ok0IIssE3e0Ou96QF%2BK4vdb22kmKGrhj2VAI20Altn9ezK5s7WO23d4GSAZV0veS2HhvYzLx3idoC%2BRd7Ov%2BWbPORESfPe2nxxYElfv8jWpdmFl4wFij%2BcW%2FoXk8spG0%2FHqcwDSGBA5VlAA8MyS5M8tgfBAzcQ1k4f2PK8swlg%3D%3D");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> UpdateTravellerDetails(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Cookie", "ct-auth=5QYJzQPcJTGLL%2FS0Z4NCo9AlRmvYBBom2%2Bss9XrZkmV6Gla6v%2FlmKcBWqoBCZ6z2vdb22kmKGrhj2VAI20Altqj9pfgUXTCZ%2Fu5m77%2Fi1YG4uBAtyOJG2IpCdrj2AIWegAxfZos7ujm7M6O1mmyw0BlkcUqY5HToObZLG4aSVQMEbv2GAEYVYhmwsa3LVZGkVgIeGgvlApD3FwMmnIp0SA%3D%3D");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> UpdateTravellerDetailsWithoutcookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("referer", "qa2new.cleartrip.com");

		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> InvalidCookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Cookie", "ct-dvid=6O71lMcsFN942M%2FhT8afvaHdaTwQTiXi7da7FXIO5ImG3etibRpxjeZ1aCatCs%2FfBp%2BzlAOnxjxOvOCuJk8b5UUJG3wh%2B7OIt9pCPkXSg%3D;ct-auth=CigXXDTZTngTH2Arz8oIPCQddBlBZUdIPUqCmZUsHUabf07V%2FhoDsfXYp4pteeXLvdb22kmKGrhj2VAI20Altvlo45ep4eR7a9mOAYg%2FmuE3ajvTNuAb%2Bn%2FFpOyEvi15Rmw1lz2uzfJKx3gdbD6V5h2zfNaG%2BH1iyQ6g7a79aXDRVOJ61ho6dIOaKB1eF1NqEkocmYRqIc9wFaoCfqQYaA%3D%3D");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> validCookieGST(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Cookie", "ct-dvid =6zZbIR3f1VrcZ8kj0mX3gosNlI56hj0OwodJkQF4yWtjozHGIn%2BwTlq7ftkpjZ84Gx%2Fp193kCXLOdETDzSeGxLoFaRcsYY9%2F%2BB18%2BtAmsjw%3D;ct-auth =qMICmZuE7Q5Z2RAZXBHwuyxOprp22izAzhVjo253NKqSvC79%2F5xapTxvJ1ue4Iww4SA3FzbNJhJHYcQI%2FpWP17AVN5TvbjN74E5L45eSIZot89mt1%2BaNhxx%2B84NLp1L3kfsx09cv5iFyoF%2BlqP6mq20j8vGkUb6O0wuuFkd1Qv5fdDbc4pC5qlhRWl%2FvLbCsfJkgiU1sdHK4%2BvexJlf0VEHvL%2Bv4UF1eS0s%2FBKHslhY%3D");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> UpdateUserData(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> UpdateUserProfile(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "b2c");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R1234");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> Createctauth(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("referer", "https://travel.flipkart.com");
		headers.put("caller", "distribution-service");
		headers.put("app-agent", "AndriodApp");
		headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("Cookie", "ct-dvId=WoZreV%2FRgvO8B3qwpZtTN2WGpnDXjOO67XPb2F31dQyZ4nTg526KE3qBRFMfR123PxdFGW%2BWznAISX2LCKNlRy4bGrt3UQ0R4WAL35%2FIAcs%3D");
		return headers;
	}

	public HashMap<String, Object> CreatectauthWithoutCaller(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("referer", "https://travel.flipkart.com");
		headers.put("app-agent", "AndriodApp");
		headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("Cookie", "ct-dvId=WoZreV%2FRgvO8B3qwpZtTN2WGpnDXjOO67XPb2F31dQyZ4nTg526KE3qBRFMfR123PxdFGW%2BWznAISX2LCKNlRy4bGrt3UQ0R4WAL35%2FIAcs%3D");
		return headers;
	}

	public HashMap<String, Object> UserJsonUpdate(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("caller", "distribution-service");
		headers.put("x-ct-caller-app", "mobile");
		headers.put("referer", "https://travel.flipkart.com");
		headers.put("Content-Type", "application/json");

		return headers;
	}

	public HashMap<String, Object> CreatectauthWithoutKey(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("referer", "https://travel.flipkart.com");
		headers.put("caller", "distribution-service");
		headers.put("app-agent", "AndriodApp");
		headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
		headers.put("Cookie", "ct-dvId=WoZreV%2FRgvO8B3qwpZtTN2WGpnDXjOO67XPb2F31dQyZ4nTg526KE3qBRFMfR123PxdFGW%2BWznAISX2LCKNlRy4bGrt3UQ0R4WAL35%2FIAcs%3D");
		return headers;
	}

	public HashMap<String, Object> AccountMerge(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "application/json");
		headers.put("caller", "https://qa2new.cleartrip.com");
		headers.put("AUTH_KEY", "test");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> WalletMerge(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "application/json");
		headers.put("caller", "https://qa2new.cleartrip.com");
		headers.put("AUTH_KEY", "test");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> JsonUp(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("caller", "distribution-service");
		headers.put("x-ct-caller-app", "mobile");
		headers.put("referer","https://travel.flipkart.com");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> InvalidCookieGST(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Cookie", "ct-dvid =f0Gs3IlQ0lk0zkIvak8FnLCM%2B5aOxVWjwAcEAKVFB4jGVGxmwRlewPsfHDTER5gY7PriSwIiQwSjUG03szIoLW5Vni6rw8ANwtGSxRoZY%3D;ct-auth =ws4jHEgBevSnVBpmMFVyHPmn4uznYeRyvk7623ZaV157mjyswQ7Ox2mJQpt8uq0Q4SA3FzbNJhJHYcQI%2FpWP17AVN5TvbjN74E5L45eSIZqDB%2BAjjQ519FDknWCaH5HwbUbMqyjio8LLuBk1Bx1ICYsqgq9HCFSkRPqEf7skAptPQLaVBu1BssZHli8SBy81aFT6ArZ5rQdwWBdJMsoFzcqcG4eT3FA%2FdO6SDc4SnaY%3D");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> WithOutCookieGST(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Content-Type", "application/json");
		return headers;
	}


	public HashMap<String, Object> WithoutCookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Content-Type", "application/json");
		return headers;
	}
	
	public HashMap<String, Object> IdentityService_UpdatePassword_ForChangePasswordflow(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.cleartrip.com");
		headers.put("Cookie", "ct-auth=xLkcxaKxpIdnhgUZcO%2BWiRjNDKCGySs%2F3qHQWLApkVidb3KV%2F49ubzf1Ekx1NtmzL1YjeWNmu3xY%2FpzUexWQN1w%2Fj5gAPNmv1vpKnDrAx3FoX9evvh5diDC4jtyRjOeZZJtx%2BJ31duZqrcZ2jUdJ6F4ai43jNI5aChVTEmGAfqQahvGkzHhRz5kPpCa%2F7j3utX4un4jpIzA3dx1i9UD1iDhmbaHDtVTELASCTE65iYNDav43rPHfhVjrxuJhRUe9V9J1s9EnvD%2BVObAzErSBUd%2BYomLdDuWrqqdRzGq7%2FdYA0m79Z5nuhvvWgXtLZpphBygb5DF%2BiBArg6EEGJYTRX%2BnhhaYeP8g0CEQkY6Tiy4JTEWCk4w4RPfV8FxcD5fiBiYwxcyF82ssHriGcBPoZbqcwrH37YPhmlmSgDptHRHSU4sbkK%2B1ntNdKiZtuD7S519sHoYJ20LxLarNevMhefLj6wy0K9HoNEZdzP3I6V6sfLCHbaSEDTDVfF6ZO2eL%2BY0HEOXDxFMm4qDR%2FfSwa6%2BHx%2F4do5V1cUolGYLe7LksliKRdHKdB04q2m8OnZXTH2Z4tsAXBZj47Mu0vEuTRiAH0Rp2vtFkuXiol%2Fc%2BBJD4qswYyk0D6GkqDc%2FryiGzrriKvMSxzl8ZjdP0xHKTJjDfE5MjfU2lez8Mc21eeVj4yG9Y5gNNb6MvOPOrwEDI%2FRkVukgyqFl7OJk6DNu3G%2FLNPaqxgHPoG%2Fb4MQRnyZVI9iJH8UXIBBVrkHxP0uq0KBIFqMINY881df17xzwxrP0wDfAjdIJWLC650cfnf3%2BZ8zInGGcv79tFePFr5UA0tMv7Ci9nlUUKOJuJ4P3asT%2F%2Fu6AA%2BWLog2uJ%2FY2YYqgP%2FV7P4M74%2FvZ8fgql9D8g8%2F%2F1HM9Q%2BhZwENf6sKaAU%2FkxX%2BEKCRjKf8O%2BTNUSfsuE8coUcku3YuzCaIBgM2P8Rb8sKLbSBDeyofU70uSSaMEckaUyLeYQbOVx%2F%2B7JUlOisjgFuy%2BxyJIPcX7Yv7eIVOKsnEkZCKNo2VdexAMFzV8jJWCkNJigozPGBBeEcF5L025fFK4zyLlxhOOqSrzgJ%2FV%2BKw55kneImPwOmjjTx8bKaKUlDohE7GDIWcILQ88d%2BXi7A5SMIuz2WcT5ii0Wf%2B8AovNHaAE6ks%2FCbb9HIDfkrt1RUQubPWxQct8F190iQxv9R6IFJ5ykwqipKSTD3By%2BM95FvKgObf5mq7KTh4b8T%2BeFMlESYJHyLIxZIZoHl9lVnkf7P1e8%2FtlB9wGg6ZHy9%2B0obMoFR67KLl5Gf2Fubx9%2Bu6Hxgn%2BXdJPeAfwgbb%2BQmBiXP12zCP6SuogJGXte7YQyF6Em8tznMbrROwtZON8HERSFujfxKGUlphAbOSefgP%2B7S8ROG3IPs9BT1n1utI2bh3BRC5ImSyZhXOG2sznZdCQ79pKhhufWoot4da2aQ5TFdB5HS5I82K%2BNFYkqRWdK4vmOr5j0J6GyQhEu5IsLcsngqwvuBRkhZ%2FI2BlzDhJYXPlwWKqeoicydwftbEFDnNHvr5PmogWHBoxfe612L%2FoZuaHewfiNVtslgbnGnbzo6cVZBOb0MxCSiNyccvTZ6ZeZ3IoYf5mwSBgL53KSTx%2BaaO3PBn83YSeM2dk11dlD76Dw%2Ffwp7gLIb%2F9H19TQBwMECqNmAPkW775ynG45GwhE3BA0pwhTRn%2BF4GSBlk6n2YHWpqXOktV2t3ZZwho5dU%2BaKzPeoMZcLm7nG2qmPwjWvfUgSBhOQRDOcCqRiT2EOGBgmpslREzWOrB3hyHpytZhU0J82K0I1WE%2BjcH8O%2FVdoj0Eb8tJ9rXfllmc8rC%2FXLy3f2oyrfnYDjCw0baLNpGuOehpaIsoMY5Rf5GiTwFvhXvAnYS%2B25eC0UR18ZscFbQ%2FM4rY6jOiEH0NyB%2B2zpVUqHxVKy8EA2q8%2BrZEfuQeptItz1QmCTCrG2zz535KwggZowoP32EtOqBWYhQip1WbhGbMQmAZql3Vy2xcsLuyKfwQVUtJ7iO6HxRDLIO7ZvTGTvHNX1ETbNEpyZpMgLwUjT3Qtd82ubZvhaDf0eBKLoRRS5JmntfEp5NxtVz6UwqLza%2B5jWfqwgqHy3G0T%2Fs2u0M7JwAT2wOh%2B34Xdyjuo9QT9eXMDGw3bKro5pSC2ES2LsRt06iOvAE7642f4Vz1Hu3%2BsavTJotWVhK57A3a1kzrO4fs6W1TZ164WNSXFwHHeNvILewT030Uc1nb9brw8XyF4qV3Bm%2FliftCqilrR7wJMKe%2B0bwL1b3dB19JZyR4PoUorfmRVlKTLRi36%2Fz06Maw86l5ulnZ%2FOYr0x68AzZPVKJIJgL%2FUR%2FFeMT6Z2FQgmkvN9o56uaDqljiH6EZf69ABfV0nq4kc9YcPGPRo5yJqnvzC9EySWebP15u3IQS2mOPTv%2B0EuLDC5z0TR%2FvMndyptkL3JYHxPCZ66Vd%2BVlVBbmE%2B1KNkwuStlsk8fQBPQcJVdWYRuJWwOzK%2Bgj3SRuWRkjCnDKKe8NqjkOHmdGzy1oyQ6RDiX8py1ChHoj4cjWr%2FDiVQVL7HHSTDtaEy7aJ1MyWDl56J5voX6gxsxpwT7eVQfFgWbHbKn8V%2FndnWpk6NfRBwwmzNNBnLHJgaDSiklpxQ%2B%2BOzrxb1Tox7Kq6%2FJBvLlwdghgUnsSVsjHrnbDXWQq4aEuOadeiUW2vyzpBPNOBmJmsFPmS8pOlAUMm1FILo%2B1a4hknTnPfj%2FoblSJLZSMRU95jBcoxcGvfJUFHGpmwaFOusXvBwUQItAVIqX%2B2smxWVqgEUizYO00bx2rlptTMEJwKb%2Bs4Kkul4g7WkvlpxSjq7IYISNrB1lR6oID5dw1I%3D");
		return headers;
	}

	public HashMap<String, Object> LogoutAPI() {
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("cookie", "ct-auth=Adom04s0jWWLpYeJdqQCvSpAXAXfK%2FmItS09lB9PYEG8m%2Fmxya8oyL4s2ROkN98ZMQSQFbQVBxkZathsIXsnSbCrW27PiyVruGbls9pHIkzq7QiGDb7x8BWA5PwDmOdkWeM5kHkfXiKtBH4gyl8vNQfC8%2BU2pv2ChqgCaQM9CXOcIR8vVJAOZtJGpXFnN6KTpgw8mmtlQh%2B7XEmQWV1fBzUEeb5zfEqx82VQlFWkOI8%3D;ct-dvid=a7582pi%2F%2Bu70DqonjQ47Kd99K4dEzqRkfKTWeep2K9wCYb4Je61F8Ri0OER5PA794RDSaM5o%2FKqgCuFT2sjMAGZI6H4S%2FnVEUGthSIGMql0%3D");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("caller", "caller-app");
		return headers;
	}

	public HashMap<String, Object> IdentityService_UpdatePassword_ForResetPasswordflow(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.cleartrip.com");
		return headers;
	}

	public HashMap<String, Object> userclassification(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "*/*");
		headers.put("Cookie", "tkn=1566811020");
		headers.put("ct-auth", "=NOV37K8fIkKrO9UwFQe19R0a5X1JweTyx50XXqKuFtDEYT3NSjEZ4ndP38P9vE5vL1YjeWNmu3xY%2FpzUexWQN1w%2Fj5gAPNmv1vpKnDrAx3FoX9evvh5diDC4jtyRjOeZZJtx%2BJ31duZqrcZ2jUdJ6F4ai43jNI5aChVTEmGAfqQahvGkzHhRz5kPpCa%2F7j3utX4un4jpIzA3dx1i9UD1iDhmbaHDtVTELASCTE65iYNDav43rPHfhVjrxuJhRUe9V9J1s9EnvD%2BVObAzErSBUd%2BYomLdDuWrqqdRzGq7%2FdYA0m79Z5nuhvvWgXtLZpphBygb5DF%2BiBArg6EEGJYTRX%2BnhhaYeP8g0CEQkY6Tiy4JTEWCk4w4RPfV8FxcD5fiBiYwxcyF82ssHriGcBPoZbqcwrH37YPhmlmSgDptHRHSU4sbkK%2B1ntNdKiZtuD7S519sHoYJ20LxLarNevMhefLj6wy0K9HoNEZdzP3I6V6sfLCHbaSEDTDVfF6ZO2eL%2BY0HEOXDxFMm4qDR%2FfSwa6%2BHx%2F4do5V1cUolGYLe7LksliKRdHKdB04q2m8OnZXTH2Z4tsAXBZj47Mu0vEuTRiAH0Rp2vtFkuXiol%2Fc%2BBJD4qswYyk0D6GkqDc%2FryiGzrriKvMSxzl8ZjdP0xHKTJjDfE5MjfU2lez8Mc21eeVj4yG9Y5gNNb6MvOPOrwEDI%2FRkVukgyqFl7OJk6DNu3G%2FLNPaqxgHPoG%2Fb4MQRnyZVI9iJH8UXIBBVrkHxP0uq0KBIFqMINY881df17xzwxrP0wDfAjdIJWLC650cfnf3%2BZ8zInGGcv79tFePFr5UA0tMv7Ci9nlUUKOJuJ4P3asT%2F%2Fu6AA%2BWLog2uJ%2FY2YYqgP%2FV7P4M74%2FvZ8fgql9D8g8%2F%2F1HM9Q%2BhZwENf6sKaAU%2FkxX%2BEKCRjKf8O%2BTNUSfsuE8coUcku3YuzCaIBgM2P8Rb8sKLbSBDeyofU70uSSaMEckaUyLeYQbOVx%2F%2B7JUlOisjgFuy%2BxyJIPcX7Yv7eIVOKsnEkZCKNo2VdexAMFzV8jJWCkNJigozPGBBeEcF5L025fFK4zyLlxhOOqSrzgJ%2FV%2BKw55kneImPwOmjjTx8bKaKUlDohE7GDIWcILQ88d%2BXi7A5SMIuz2WcT5ii0Wf%2B8AovNHaAE6ks%2FCbb9HIDfkrt1RUQubPWxQct8F190iQxv9R6IFJ5ykwqipKSTD3By%2BM95FvKgObf5mq7KTh4b8T%2BeFMlESYJHyLIxZIZoHl9lVnkf7P1e8%2FtlB9wGg6ZHy9%2B0obMoFR67KLl5Gf2Fubx9%2Bu6Hxgn%2BXdJPeAfwgbb%2BQmBiXP12zCP6SuogJGXte7YQyF6Em8tznMbrROwtZON8HERSFujfxKGUlphAbOSefgP%2B7S8ROG3IPs9BT1n1utI2bh3BRC5ImSyZhXOG2sznZdCQ79pKhhufWoot4da2aQ5TFdB5HS5I82K%2BNFYkqRWdK4vmOr5j0J6GyQhEu5IsLcsngqwvuBRkhZ%2FI2BlzDhJYXPlwWKqeoicydwftbEFDnNHvr5PmogWHBoxfe612L%2FoZuaHewfiNVtslgbnGnbzo6cVZBOb0MxCSiNyccvTZ6ZeZ3IoYf5mwSBgL53KSTx%2BaaO3PBn83YSeM2dk11dlD76Dw%2Ffwp7gLIb%2F9H19TQBwMECqNmAPkW775ynG45GwhE3BA0pwhTRn%2BF4GSBlk6n2YHWpqXOktV2t3ZZwho5dU%2BaKzPeoMZcLm18PAfmgcxcaHmOpT1wFnNWYyCeiZznaCO9YTQ3FbGs4nAqkYk9hDhgYJqbJURM1jqwd4ch6crWYVNCfNitCNVhPo3B%2FDv1XaI9BG%2FLSfa135ZZnPKwv1y8t39qMq352A4wsNG2izaRrjnoaWiLKDGOUX%2BRok8Bb4V7wJ2EvtuXgtFEdfGbHBW0PzOK2OozohB9Dcgfts6VVKh8VSsvBANqvPq2RH7kHqbSLc9UJgkwqxts8%2Bd%2BSsIIGaMKD99hLTqgVmIUIqdVm4RmzEJgGapd1ctsXLC7sin8EFVLSe4juh8UQyyDu2b0xk7xzV9RE2zRKcmaTIC8FI090LXfNrm2b4Wg39HgSi6EUUuSZp7XxKeTcbVc%2BlMKi82vuY1n6sIKh8txtE%2F7NrtDOycAE9sDoft%2BF3co7qPUE%2FXlzAxsN2yq6OaUgthEti7EbdOojrwBO%2BuNn%2BFc9R7t%2FrGr0yaLVlYSuewN2tZM6zuH7OltU2deuFjUlxcBx3jbyC3sE9N9FHNZ2%2FW68PF8heKldwZv5Yn7Qqopa0e8CTCnvtG8C9W93QdfSWckeD6FKK35kVZSky0Yt%2Bv89OjGsPOpebpZ2fzmK9MevAM2T1SiSCYC%2F1EfxXjE%2BmdhUIJpLzfaOermg6pY4h%2BhGX%2BvQAX1dJ6uJHPWHDxj0aOciap78wvRMklnmz9ebtyEEtpjj07%2FtBLiwwuc9E0f7zJ3cqbZC9yWB8TwmeulXflZVQW5hPtSjZMLkrZbJPH0AT0HCVXVmEbiVsDsyvoI90kblkZIwpwyinvDao5Dh5nRs8taMkOkQ4l%2FKctQoR6I%2BHI1q%2Fw4lUFS%2Bxx0kw7WhMu2idTMlg5eeieb6F%2BoMbMacE%2B3lUHxYFmx2yp%2FFf53Z1qZOjX0QcMJszTQZyxyYGg0opJacUPvjs68W9U6MeyquvyQby5cHYIYFJ7ElbIx652w11kKuGhLjmnXolFtr8s6QTzTgZiZrBT5kvKTpQFDJtRSC6PtWuIZJ05z34%2F6G5UiS2UjEVH%2FppjO3BF62j1vzKNA%2Bt3dmkILfeJmfA7u%2Brdaf%2BDS9bOBu3BBgJumFzBVdVyGw164B5XcNaiilm88fji2bWSKj0T4l2Adjl0WNmGrNF%2FXkL6xnRPvNfQSi48tKBDCPNQ%3D%3D'");
		headers.put("Connection", "keep-alive");
		return headers;
	}

	public HashMap<String, Object> headersFormsgst(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "text/json");
		headers.put("Cookie","ct-auth=EEEP41EBzbb%2FspcrZ0DsZan7S9VgbRY05xrj0tiyr6JaRedz0yuHHpvmRzXY09I2L1YjeWNmu3xY%2FpzUexWQN9BpkbZ1WOWTcucPHKwGD9XTn%2BkkNg210lHY20IlbLNNKQ25Oq4y%2BYb6rnClxu66WKLZiTdEKkjaPw9yA3jLrcBFPadDhADcu2tIIJKys%2BN5GaqX5VlxYlpbj60QRwfgD9%2BbotR8VhQRNZsocGlIYBOsREV%2Bgk7i%2BsLyHHvOoLlWigT%2FRuA2sldEPaXYwS%2FLuccxTK4Js5b3%2BYQs%2FxoSrzpmS16kH2fz%2BTmE5j4miA3%2FxtULLPwFin4hOTCqCaJMPJNErX3m9tZvweddN1V9ujQJtP%2FHYa6z7Wqo19qt2HEWRkL3KJqy4XWVsFOOftQEhMMZbYvc3lOsgjYjBXwhYOuoXqqvC6b%2BhXU1yveDjCcEzGo9i%2BGpmY138HIU9Jk5aQzWRx9AeBr0QjIRk8WfciZUmDPQERTUo9FrkxEnLpNOUa493i%2FXnYg0UumIXZtVcETv83553ZX8Vc%2Fo8neI3V439H2KuRGFqrBt00bS3ff2kTWA%2FHY8stDnH9Xyfcg%2BBrzTPgZyHAGJtFQ71UNZr3xrb2b8pEuhNy94qMBvVYZSr8NMKaInBbNNsMgTJHTIYXOv4bpNsbqZgBeOnGby%2FQstMGKPLsfTdp4%2FyWvlAwXNcPQ6QAwkIxVQAZ58PvrDkelGTDbmxvVdpf6HPA3P%2BB8%2Ba6%2FY9ZhxHxsnabhnx7gvkbef7%2BklQdxuu%2BWtbYhOaPyUQUlv5UoFz70%2B0Gh1P5UoFonwTB5CRQlF8Tq%2B4jtQhHlObStgXaVzlY5HZNFtynugbAqyG75DWZRzTGmRooE1mXBbVBT1gyk%2FBMG2BhXBMkPMWMeCmOqJvLB5fIkpg5EMmoDaTb789PjWfXaeowNp5NRyk0qrDlMzyf%2BIApdiflrboDrshzAVpm1SJY5O9Xs2DRjRNj8ARa8ajbOgAt5Xy6HWZPlT2qDJLGPe6BXsZoy%2BSIKQTQYOveue7G4EFrtgwTPl0VPWkmdhBDFvMihZqtQ2aalngA9XlDUlkrVUupbsw0zE6l2eQMBoovtm1HQQ0idQggehoOKesKDk73qxMY2EDzgz38t3vnAVX9L%2FTOOCendJZGID%2FUbdKz%2BvVOP8AQaq0LAJkKDea8zNINXEkZZlpPaEl4oHC5pf98YJRKGprLfTMLKTCUTmsWJFerslFcSwMhPO%2BhAD6fI0FwU2SIXJKoeifbwfzbsAT5XpMkWWop8rWhpvZrlMP77AjJ2sDSNUyYcp4F0JoK26%2BtEV6gkOeAPLX52Cx%2FKazqfDPc7NyU%2Bo%2BvBUyYMlhlCd76v8UzesFuBKFIHE3yE1nx%2F%2F04HrXYH4C8JPmFBi1dd4p9tWmJH7mrDgV1%2FmZEXZDXqr7cNOEprGJZuuMcPgRzWtLjdzbOswYQy8g%2BWwKfyXeEHRZW9wnKjTVrTCVFMtqulpugXxvsp2O8Q5e3%2FCLRxpWSKVOBEk7%2BQUlqZFw0tUJQP3mvTJJrADx9xmC1znVl3Z6kdBmCoyqj4EYZRzvNKXzmzxEsLr7tORj44uM2Hx%2FmKJqOnbm1bFxV6qpjULEMmLkNvYFyDKdCVWO2xGJUscdDnZgc%2BJE2nROtWLmNOhT5eJPstXvYSXn8Hg3HwL32ZeR7xxjY7%2Be9n5LyMPjxRoCIDw%2FdzGD73N4VDK5C%2B%2F9FH9OnLv2zs22aWfNz11al4ORA4RuptrckXavcPPIsAup%2FEUb%2FvIVX%2FTN1B73AvPw%2FORl2HeC1ykV07mp2N7DLR1AHZql3LN%2FQ78lcBrW8bBIdc%2F%2BgSb9FwAhiMQzVrzZVMiKeN4bV3%2FXIc9E3B8ZI7sZ60SmMbvUv1p3rVn3CBP3y1haO0pH7%2FqFJhsLsqAFkGo3WhLI%2BIhVOPzTUUR0Dtm09m9iloBDehFzKFes%2BG%2BShYrvXxWDL8d%2FO6DGkHSBHDORxCmQylc6m%2BpUZHfEMxqPYvhqZmNd%2FByFPSZOWkb9e%2BgojN3EeD6HCz4TZgFgkK%2FrICx4Hc5t6V0%2F%2BEiYwXtwx2LRO4XMA0aMbH8ZEFHpdJU20bQcpLBDdJlGUNj6DZJ07eHvNQtSCxBO7QVyF%2BKtm6HlqO9b4THaPdYDlIlFR%2BwmrDk6YXX44L9DrHepWib80zi6h7HHSmwEYtQviGFW%2BJQJAjs1XkBbjPPfULhJ2bj1vB%2FZzaCRZR7Y0mt16IDp8NrDH6X01ID%2FoTkxrz09Z9tSoMKsuqKT%2Fifm2iz3YiusNTuwp28FHrtJMfKD41HScIvPr%2BkvbDVqSmnrrdWgzk0rlr67osSeT2oE2NQUTYGglxSGyJfZL6hUC%2F08FCfz9PvUV1vR4OJAMOwb4LUa8W9Pl94V6G1lsSfG%2B%2BbUUKxi6SDa85LBv0a%2BuTnjG1yJIIursWJWWYL4wcfbdTxv7ngKn21pzhgtIVOMva3KrivJofipyqlrlOmpIFBwhnOLHW8dYOKQ7Yble%2FI6LTJuO6WJW4UMWIja%2ByoGz15v3KoEAgS%2BuBIVDOIJSDROr3a2WLwmNXZv0Qn3ar7XzCZYkcL0SLJH3kkvOqkxY5Gl0rUNwhG%2BJxULoC9eddsTKt%2F70pPhsvDcBVO6RE9clh02h%2BAT7RRleuJZ2bHZTKEcn%2BpCCW9XwLeBgH%2FK0PSxXp6gsxEGXPz20gyKP1mtA%3D%3D");
		return headers;
	}

	public HashMap<String, Object> headersFormsapi_config(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_KEY", "weurimdjfoewpremkcuwpermapi");
		return headers;
	}


	public HashMap<String, Object> headersFormIdentity(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("clientGenAuthKey", "HBhen9VEL7zoTM884F1CycCWCb3o6s3FCynh9lTkU");

		return headers;
	}

	public HashMap<String, Object> headersFormflipkart(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("caller", "automation");
		headers.put("Content-Type", "application/json");

		return headers;
	}

	public HashMap<String, Object> headersFormIdentitysignin(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.cleartrip.com");
		headers.put("X-CT-SOURCETYPE", "mobile");
		headers.put("service", "");


		return headers;
	}
	public HashMap<String, Object> headersFormIdentitysigninflyin(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.flyin.com");
		headers.put("X-CT-SOURCETYPE", "mobile");
		headers.put("service", "");


		return headers;
	}

	public HashMap<String, Object> headersFormroles(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("accept", "*/*");
		headers.put("x-ct-caller-app", "automation");
		headers.put("auth_key", "7GHT#@D65yhgder4R1234");


		return headers;
	}


	public HashMap<String, Object> headersDAlinkcheck(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJhcHBsaWNhdGlvbiI6InRlc3QiLCJST0xFUyI6WyIxMDAxNSJdLCJpc3MiOiJ0ZXN0IiwiYXVkIjoiY3QtY29uZmlnLXVpIiwiaWF0IjoxNTQ1OTAxODI0LCJuYmYiOjE1NDU5MDE4MjQsImV4cCI6MjE3NzA1MzgyNH0.BoTypgsgM0rWgOvzGaseixGz3sq0IwSb4gYrRKUpBb4");
		headers.put("Accept","text/json");
		return headers;
	}


	public HashMap<String, Object> headersFormscfwoptin(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}
	public HashMap<String, Object> headersFormpwa(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		return headers;
	}

	public HashMap<String,Object> headersGSTAutoComplete()
	{
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("accept", "*/*");
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("caller", "b2c");
		return headers;
	}

	public HashMap<String,Object> headersGSTAutoCompleteInvalid()
	{
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("caller", "b2c");
		return headers;
	}

	public HashMap<String, Object> headersFormdepoist(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		return headers;
	}

	public HashMap<String, Object> headersFormAccountExits(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		return headers;
	}


	public HashMap<String, Object> headersFormcachereset(){
		HashMap<String, Object> headers = new HashMap<>();
		
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R1234");
		headers.put("x-ct-caller-app", "automation");	
		return headers;
	}
	public HashMap<String, Object> headersFormgateway(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Cookie", "ct-auth=sbTuCPZ9yEzXX%2BSA555pKda4jfUbXgF94ZK6unK06HZaLPh%2FF6uVOeCbTJQrZzxIXZb27r3UOV1Ev4bGezupkT9NkrM3bjdx950UgAiLoV8S0AggCjlwZfdk%2Bjg1KnyMcbQHip4k08psln12Hs3t5AhSz5Tm3nNmMqN834TxTk0mlTLdQtcneofIN7sZPYNGlKVNg6A8UssolSYFtPQtk3fxj2tZC0kkiOjLYRx4gUteBkTlW4pERzPjBkpSwhJgt0lF%2BdyWypfeXZj9%2B8TMdEnggXuZ5XUsVKDqRk3TP0c5XMXN%2FfUwAaQvdO%2FQJtfy; ct-auth=Z9Qsvxu31QrtFuL%2BZIh%2F%2BsDuBJDZy0eSblQmod1yZKJ7c6rVBubK%2BdJHVFMciSL%2BXZb27r3UOV1Ev4bGezupkTKIW7Ph8auaXeltEIimttWSWebd679fDwPYXdaakyixiDpipnRoFNlVipI%2BI2po%2FBMGjptfaAemLzLHI223cK4a6rZslrcV47Tjzb9c7EYbSu7ZSu%2Baz7wYWabrSTP97AYG0Ny%2B1LR%2BhpT9NU4%2F9g9CbhWX3UMhf28JnJzBlWq88gYU49L8K80L3Mr8UYKXvQ%3D%3D; userid=nakul.goyal%40cleartrip.com%7CNakul%2Bgoyal%7CMale%7C%7C65200719%7C; usermisc=SIGNED_IN|");
		headers.put("caller", "caller");
		headers.put("accept", "*/*");
		return headers;
	}
	
	public HashMap<String, Object> headersFormgatewayref(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Cookie", "ct-auth=sbTuCPZ9yEzXX%2BSA555pKda4jfUbXgF94ZK6unK06HZaLPh%2FF6uVOeCbTJQrZzxIXZb27r3UOV1Ev4bGezupkT9NkrM3bjdx950UgAiLoV8S0AggCjlwZfdk%2Bjg1KnyMcbQHip4k08psln12Hs3t5AhSz5Tm3nNmMqN834TxTk0mlTLdQtcneofIN7sZPYNGlKVNg6A8UssolSYFtPQtk3fxj2tZC0kkiOjLYRx4gUteBkTlW4pERzPjBkpSwhJgt0lF%2BdyWypfeXZj9%2B8TMdEnggXuZ5XUsVKDqRk3TP0c5XMXN%2FfUwAaQvdO%2FQJtfy; ct-auth=Z9Qsvxu31QrtFuL%2BZIh%2F%2BsDuBJDZy0eSblQmod1yZKJ7c6rVBubK%2BdJHVFMciSL%2BXZb27r3UOV1Ev4bGezupkTKIW7Ph8auaXeltEIimttWSWebd679fDwPYXdaakyixiDpipnRoFNlVipI%2BI2po%2FBMGjptfaAemLzLHI223cK4a6rZslrcV47Tjzb9c7EYbSu7ZSu%2Baz7wYWabrSTP97AYG0Ny%2B1LR%2BhpT9NU4%2F9g9CbhWX3UMhf28JnJzBlWq88gYU49L8K80L3Mr8UYKXvQ%3D%3D; userid=nakul.goyal%40cleartrip.com%7CNakul%2Bgoyal%7CMale%7C%7C65200719%7C; usermisc=SIGNED_IN|");
		headers.put("caller", "caller");
		headers.put("accept", "*/*");
		headers.put("Referer", "qa2.cleartrip.com");
		return headers;
	}
	

	

	public HashMap<String, Object> headersFormgetactivationkey(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");

		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}
	public HashMap<String, Object> headersFormpromotioanlhealth(){
		HashMap<String, Object> headers = new HashMap<>();
	
		headers.put("accept", "*/*");
		

		return headers;
	}
	public HashMap<String, Object> headersFormpromotionalvalidate(){
		HashMap<String, Object> headers = new HashMap<>();
	
		headers.put("accept", "*/*");
		headers.put("caller", "b2c");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie","ct-dvId=uOTynOa%2B8J%2BMJMRIFgEIONQQHUa0%2Fi%2FKx8GAunz5KldCfXq%2FIi2yB5oQWYnanIMX9NDc0YIoklz%2BAyQK%2FyB%2F6lNuTFXTg4xxugtQw72wmQg%3D; ct-auth=0BCimsXF7VH%2FYE9fCpumHuiCoUwzrwYnno7wEN9uqrehCB9EU0PZvscAk0CG8hlPFy0UoL5sjLHrNfj5CAB2pWBk1m2aHkPL1QZDSee2HSrBWqTKbGwhQfi4APgTuVPT%2Brx0V%2BNJZHQ7d%2BGE2yyJ5o9aHBF%2B1Ku2%2FKgQVVKoS3WJJCdRMQk6LDPO%2Blo6J0GWS1zzV4031n%2BclFr2JikBuc3gpCp2%2Fv8DEH6mN1qRuQDXCF5KewYSQcx%2FVXCksyc5IkT4ul0jMOpdUAX%2BK6Id3CBuuJkXa9GYYIBdZla7r4YVpAuiM1vW5qwA%2F5TNtOpRVKVKBQqO%2BzJlJlzPRNIfgPVP4feDTis5sWFapOjWXKyq9cD%2FZ74dBJfq3QH14BTT5nCMzuDUfW7T5cGZZw2h%2FV9UcLt0g8iNTuovsi0NObbLcw4U9l72Gufoy4114vYG%2Bk9oH%2Fjc6gwQa23nD4uRjisStTEbYHElo%2BCkg%2FANYh8RM7wK8NkdIp4FM2C3c6E4DCXFgL7tWpFqTMXr%2FPJL9w%3D%3D");

		return headers;
	}
	public HashMap<String, Object> headersFormpromotionalgetreferraldetails(){
		HashMap<String, Object> headers = new HashMap<>();
	
		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie", "ct-dvid=M9MmXqjr7v7kS4xtinjChWXrrZaI85o67GXIxI4PaxkMSoOxDF%2FhmdZybWm734Tz0eskIyTdHpVfC6ur0JFYn3LeLR9Ut0DxqxYncSdb6wA%3D;ct-auth =CJRk95Z11M6Lbw0awJlGJGcpQvvMroPgTRYrO%2FU%2Fz%2FR8O2WMsGATtucBkMcse1jsvdb22kmKGrhj2VAI20AltjbChD%2Fyq8ezocz8t67dClvOOiS1Z4u7hcd5HyDSCcP1aDWtyLL4lRozoAmLLsEzKLdKce3rAtpZHDLb7SP%2FnGXZgZ4J%2BbfmMiB9rYb04RKZVj%2BOdCKf0Wck2wqD%2BcHZjA%3D%3D");

		return headers;
	}

	public HashMap<String, Object> headersFormFKVIPInjestProfile(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("authkey", "692b3754-33c1-4c17-88d1-2339de3ccbec");
		headers.put("Content-Type", "application/json");

		return headers;
	}

	public HashMap<String, Object> headersFormFKVIPDiscoverAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("caller", "hotel-srp,hotel-itineary");
		return headers;
	}

	public HashMap<String, Object> headersFormFloaterAddTemplate(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}
	public HashMap<String, Object> headersFormFloaterGetAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("userId", "sai");
		headers.put("product", "air");
		headers.put("deviceId", "test");
		headers.put("channel", "Desktop");
		headers.put("Cookie", "ct-dvid=fBt2Oj1JZMLr5cCsDHejgsoMrrWh22E5Y9CWe5mdSGrCIqaABaRjww1sU289rqXfiDWLVdoTwGK7QrGrjtMRW0JZj7wwJFDH4KYa%2FUo7d4k%3D;ct-auth =e8Xtn%2Fi5A%2FGkFF9QRFLwMsixzutagL8KSDOKskJ8vP%2FPAC5BnG1VhKqX9iEbXPIdvdb22kmKGrhj2VAI20AltgYWbs0hUeS1dDOVoTv%2FC8oS3xBwBQbHAAgSFMgFCe0tlyhz2jVZSGwnR4Xe68L0aoK2eEoXgM73GXnr6ZXWU%2FuqLI6EfEr5fYarVjfH7mwKJC%2FgkOzzBJNHMAiA1hc6EQ%3D%3D");
		return headers;
	}
	public HashMap<String, Object> headersFormInvalidFloaterGetAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("userId", "sai");
		headers.put("deviceId", "test");
		headers.put("channel", "PWA");
		headers.put("Cookie", "ct-dvid=fBt2Oj1JZMLr5cCsDHejgsoMrrWh22E5Y9CWe5mdSGrCIqaABaRjww1sU289rqXfiDWLVdoTwGK7QrGrjtMRW0JZj7wwJFDH4KYa%2FUo7d4k%3D;ct-auth =e8Xtn%2Fi5A%2FGkFF9QRFLwMsixzutagL8KSDOKskJ8vP%2FPAC5BnG1VhKqX9iEbXPIdvdb22kmKGrhj2VAI20AltgYWbs0hUeS1dDOVoTv%2FC8oS3xBwBQbHAAgSFMgFCe0tlyhz2jVZSGwnR4Xe68L0aoK2eEoXgM73GXnr6ZXWU%2FuqLI6EfEr5fYarVjfH7mwKJC%2FgkOzzBJNHMAiA1hc6EQ%3D%3D");
		return headers;
	}
	public HashMap<String, Object> headersFormFloaterGetAPIWithOutHeader(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("userId", "sai");
		headers.put("product", "air");
		headers.put("deviceId", "test");
		headers.put("Cookie", "ct-dvid=fBt2Oj1JZMLr5cCsDHejgsoMrrWh22E5Y9CWe5mdSGrCIqaABaRjww1sU289rqXfiDWLVdoTwGK7QrGrjtMRW0JZj7wwJFDH4KYa%2FUo7d4k%3D;ct-auth =e8Xtn%2Fi5A%2FGkFF9QRFLwMsixzutagL8KSDOKskJ8vP%2FPAC5BnG1VhKqX9iEbXPIdvdb22kmKGrhj2VAI20AltgYWbs0hUeS1dDOVoTv%2FC8oS3xBwBQbHAAgSFMgFCe0tlyhz2jVZSGwnR4Xe68L0aoK2eEoXgM73GXnr6ZXWU%2FuqLI6EfEr5fYarVjfH7mwKJC%2FgkOzzBJNHMAiA1hc6EQ%3D%3D");
		return headers;
	}

	public HashMap<String, Object> headersFormFKVIPRedeemAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("cookie", "cookieValue");
		headers.put("caller", "air-consumer");

		return headers;
	}
	public HashMap<String, Object> headersFormFKVIPValidRollBackAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("cookie", "cookieValue");
		headers.put("caller", "air-consumer");

		return headers;
	}

	public HashMap<String, Object> headersFormFKVIPInvalidRollBackAPI(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("cookie", "cookieValue");
		headers.put("caller", "air-consumer");

		return headers;
	}

	public HashMap<String, Object> headersFormFKVIPActiveEntity(){

		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("caller", "hotel-srp,hotel-itineary");
		return headers;
	}

	public HashMap<String, Object> headersFormpromotionalgetConfigdetails(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("accept", "*/*");
		headers.put("caller", "test");
		headers.put("referer", "qa2new.cleartrip.com");
		return headers;
	}

	public HashMap<String, Object> headersForFetchdetails(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("accept", "application/json");
		headers.put("caller", "b2c");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie","ct-dvId=3iAabvmskTN2monK2E9Z90rB%2BG0ENKr5Xkt4dyYT4PYTDTdWv8xIufeL2o6HUUx4%2BRsI4pgsvS7%2Bi%2BqgaYOad7AX1H9ENzOipl5A8GUG%2BUM%3D;ct-auth=maxgeOBa83Q0gXVN9ViJh7CeLasHd7PDYNIY3BVKHCa96ZaI5cD1rZaJhxBn7ecuvdb22kmKGrhj2VAI20AltrABAF8SR%2BYjh0LJNisiNwQCMwMYGu%2Bvx3fHDXHnbJtzwh%2FUBkbF9StbS9TM02g%2Fzp29nfHldR7dUIiSF8s0onwEi5u%2BJXnXLue%2FmvX6mHcucPq7k%2FbhYQG%2FoqcwrNkguQ%3D%3D");
		return headers;
	}

	public HashMap<String, Object> headersForSignOutApi(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("app-version-name", "23.10.0");
		headers.put("app-agent", "pwa");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie","ct-auth=LdKv0B%2FenR9%2Bhb8oI0ewjN%2Bk0WH9QMvyQLQQ68XxXtYB27A4%2FGqJ1pp7G9cB8VmKvdb22kmKGrhj2VAI20Altnm0eIoesCBPdeU0zBf2ZUYbQMsYlCtH6RKaDYUzr109kG7CrabwxVYLEwqFmSLxG2MIhWO0XtyAqdRMYhM8nh2oBeJ0QrmzAzUqQDF1tpcyVkB1EffCzVhOLoZykd7e8Q%3D%3D;ct-dvid=5ndkaRA5%2FF%2BlvYkBJYPgtam8QnHgOawEDgaGbkxIKYLWHzvjTUkDRIufuWat3miRylCYFM74vw%2F%2Fd6vpk%2BVgoMGffu15kTn%2BcXeVcDkCCIk%3D");
		headers.put("caller", "test");

		return headers;
	}

	public HashMap<String, Object> headersForSignOutApiInvalid(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("app-version-name", "23.10.0");
		headers.put("app-agent", "pwa");
		headers.put("cookie","ct-auth=LdKv0B%2FenR9%2Bhb8oI0ewjN%2Bk0WH9QMvyQLQQ68XxXtYB27A4%2FGqJ1pp7G9cB8VmKvdb22kmKGrhj2VAI20Altnm0eIoesCBPdeU0zBf2ZUYbQMsYlCtH6RKaDYUzr109kG7CrabwxVYLEwqFmSLxG2MIhWO0XtyAqdRMYhM8nh2oBeJ0QrmzAzUqQDF1tpcyVkB1EffCzVhOLoZykd7e8Q%3D%3D;ct-dvid=5ndkaRA5%2FF%2BlvYkBJYPgtam8QnHgOawEDgaGbkxIKYLWHzvjTUkDRIufuWat3miRylCYFM74vw%2F%2Fd6vpk%2BVgoMGffu15kTn%2BcXeVcDkCCIk%3D");
		return headers;
	}

	public HashMap<String, Object> headersForSessionStatus(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("app-agent", "PWA");
		headers.put("caller", "qa2new.cleartrip.com");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie","ct-dvId=h%2BNh8phQVL%2FqLc5O0feoqo0kH8SasDzoRXr39wGNuYNigfC1B2GlbCStZt1uvRVOD7Bwknligk1vCoUANcXhgvpgoe%2FUeI57Ts4gbNi6450%3D;ct-auth=vRLmtJ%2Bl9%2FYw15mNVgLimRG1dWuG6i3KQ9UJcVO8MYMPB0is2rAP4yl%2ByAszPuB%2Bvdb22kmKGrhj2VAI20Altpv8y01Tkkk58GW2wbxQOnxxWXBjpyFFfe9zb2rFPBn1svLdKlGLkhwOTrrxd5B6HTCWXzLrXpfA64FG9S%2F102bGkvUpMcTGi9lHJoblVzdOB5h9Fax7lZj%2FZAAdKeKUNw%3D%3D");
		headers.put("Auth_key","7GHT#@D65yhgder4R");

		return headers;
	}

	public HashMap<String, Object> headersForActiveSessionStatus(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("app-agent", "PWA");
		headers.put("caller", "qa2new.cleartrip.com");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("cookie","ct-dvId=%2F%2FsslYecWP2MkCsHu%2F6p8syzSjvGM7ZX7b3JDU8xnylpgmCLrPovHxp0U%2BHE3M4Jlf76oKcTDStRfS0a%2FAxEgJ7411RiLp3ANiiGw2srxA0%3D;ct-auth=vzCg4WjzhFqatDfzFfH8b9gdoaCdXEutbJVfg%2BacmapzQCjS1XbvaI2WX2JneWzVvdb22kmKGrhj2VAI20Alti%2Fbaxkqma9hQDZN8MOINPK15T1wsy9nMcxkXQf0AuiUmALcWLgHtupbVfudynIgwv%2BW0oC%2BxZz7i8zIXIILsGszoJSq%2FFDIQhRjYn5qcsVl55mdNiu%2FWTJkaHtgQOhzLQ%3D%3D");
		headers.put("Auth_key","7GHT#@D65yhgder4R");

		return headers;
	}

	public HashMap<String, Object> headersForSessionStatusInvalid(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("app-agent", "PWA");
		headers.put("caller", "qa2new.cleartrip.com");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("Auth_key","7GHT#@D65yhgder4R");

		return headers;
	}

	public HashMap<String, Object> headersForFetchdetailsInvalid(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("accept", "application/json");
		headers.put("caller", "b2c");
		headers.put("referer", "qa2new.cleartrip.com");
		return headers;
	}


	public HashMap<String, Object>headersFormpromotionalgetreferraldetailsinvalid (){
		HashMap<String, Object> headers = new HashMap<>();
	
		headers.put("accept", "*/*");
		headers.put("caller", "b2c");
		headers.put("referer", "www.cleartrip.com");
		headers.put("cookie", "=uOTynOa%2B8J%2BMJMRIFgEIONQQHUa0%2Fi%2FKx8GAunz5KldCfXq%2FIi2yB5oQWYnanIMX9NDc0YIoklz%2BAyQK%2FyB%2F6lNuTFXTg4xxugtQw72wmQg%3D; ct-auth=0BCimsXF7VH%2FYE9fCpumHuiCoUwzrwYnno7wEN9uqrehCB9EU0PZvscAk0CG8hlPFy0UoL5sjLHrNfj5CAB2pWBk1m2aHkPL1QZDSee2HSrBWqTKbGwhQfi4APgTuVPT%2Brx0V%2BNJZHQ7d%2BGE2yyJ5o9aHBF%2B1Ku2%2FKgQVVKoS3WJJCdRMQk6LDPO%2Blo6J0GWS1zzV4031n%2BclFr2JikBuc3gpCp2%2Fv8DEH6mN1qRuQDXCF5KewYSQcx%2FVXCksyc5IkT4ul0jMOpdUAX%2BK6Id3CBuuJkXa9GYYIBdZla7r4YVpAuiM1vW5qwA%2F5TNtOpRVKVKBQqO%2BzJlJlzPRNIfgPVP4feDTis5sWFapOjWXKyq9cD%2FZ74dBJfq3QH14BTT5nCMzuDUfW7T5cGZZw2h%2FV9UcLt0g8iNTuovsi0NObbLcw4U9l72Gufoy4114vYG%2Bk9oH%2Fjc6gwQa23nD4uRjisStTEbYHElo%2BCkg%2FANYh8RM7wK8NkdIp4FM2C3c6E4DCXFgL7tWpFqTMXr%2FPJL9w%3D%3D;");
		return headers;
	}
	
	
	public HashMap<String, Object> headersFormgetuserbycookie(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");

		headers.put("caller", "b2c");
		headers.put("domain", "www.cleartrip.com");
		headers.put("accept", "*/*");
		headers.put("Cookie", "ct-auth=7AcsSFSfLgN5GajmoVqsInqCKNt4eZsoCaxgp8yAxmUXOiPRyBGgmIG44ydRYLzlvdb22kmKGrhj2VAI20Altt4z7IBY6rDdShPSuKtRgvBoDsNFLZhQOFYODNouzut1dCpQFfP5HkgSZKJAhF55hZez68uH%2BW2z7NHurejR9XI%3D");

		return headers;
	}
	public HashMap<String, Object> headersFormgetagencylogo(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R1234");

		return headers;
	}
	
	public HashMap<String, Object> headersFormsoldctusers(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("caller", "b2c");
		headers.put("referer", "www.cleartrip.com");
		headers.put("accept", "*/*");
		headers.put("Cookie", "ct-auth=uLoIXXhl%2FS8iFHevx2yMWqqI143PINYy%2BC7ec7lrluEJpB8MOMTbbI%2BflOqMZgtZmELDRX3UaoE3v8JMnzGuQaz2Mn2XazzUGuVdNS8w5CWY3yut04DHa3RMvoHWuudxb%2BZu19l9IeUrJWL%2B9w0TudxrebwpSAhmtohv2FoWj2fjL3eWDHSdutMSRg5fZUn%2B");
	    return headers;
	}
	
	public HashMap<String, Object> headersFormgetuserbycookieflyin(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");

		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		headers.put("domain", "www.flyin.com");
		headers.put("Cookie", "ct-auth=mkj8MS2%2BTapJE24Ajwku9e8Xq6TcL%2FyGWqlnfqeeTaPzcX1SLH%2F03hAR1UXNy2v6c2e%2BBGsdeZxOJgBsje5fJYVyNCbywxI5ag1Otp408SU6DjET1jbgCiH9PrcmEa%2BNSUdVO8JyTgDwm1ibfyU4aLvAMYjzA1Mz368EugAeJD5JbZQnUHw78LKUbmBcJ3KV");
		return headers;
	}
	public HashMap<String, Object> headersFormguserexistence(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");

		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		return headers;
	}
	
	

	public HashMap<String, Object> headersFormdepoistwithoutlinkedparam(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");
		headers.put("auth_key", "weurimdjfoewpremkcuwpermauthkeyy");
		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}
	public HashMap<String, Object> headersFormgst(){
		HashMap<String, Object> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json");
		headers.put("auth_key", "7GHT#@D65yhgder4R1234");
		headers.put("caller", "b2c");
		headers.put("accept", "*/*");
		headers.put("Content-Type", "application/json");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}


	public HashMap<String, Object> headersFormpwaemail(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("accept", "application/json");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}

	public HashMap<String, Object> Account_Service_AuthorizeAPI_encodingCookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_TYPE", "COOKIE");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("accept", "*/*");
		headers.put("Cookie", "ct-auth=iK9awlY61qdV4QrA5oZe1D7eBdLisHP%2BIN0Ia75KZxqbN7BPDR1WQatqAEu23MdyfNDGUT3e7d7YCOHpHUqxWZjJfVdGhDt6EBXP56tMKTF%2F3cr90Rtklnq90CfYjkCeDp39AmjLqkH5qZECs9cDakpZoj0Q4dHck6%2F9P9TFiIY%3D");
		headers.put("Referer","qa2new.cleartrip.com");
		return headers;
	}

	public HashMap<String, Object> Account_Service_AuthorizeAPI_encodingWithoutCookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_TYPE", "COOKIE");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("accept", "*/*");
		headers.put("Referer","qa2new.cleartrip.com");
		return headers;
	}

	public HashMap<String, Object> AS_Traveller_Details_with_Cookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("caller", "qa2new.cleatrip.com");
		headers.put("domain", "qa2new.cleatrip.com");
		headers.put("accept", "*/*");
		headers.put("Cookie", "ct-auth=fLyx94WilPZ40QFYs8VBDUaWRRGbPaFQmV3QC%2F2bKyaMazMKzeGru7PO0wmMy6Mrvdb22kmKGrhj2VAI20Althjy0PEAubVqQZXFtZmZhSYJfWDgJOB1GntC4jFQk%2FO0lQormqi3QjjzbMqRMvqI4eh%2F5WnHZLB%2BCLVx14VQKcH1xBoV9usYXB9b5gioTVrNPXrDBbm5Ih%2BQBhEj17BdGg%3D%3D");
		return headers;
	}

	public HashMap<String, Object> AS_Traveller_Details_withOut_Cookie(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("caller", "qa2new.cleatrip.com");
		headers.put("domain", "qa2new.cleatrip.com");
		headers.put("accept", "*/*");
		return headers;
	}

	public HashMap<String, Object> headersFormpwaemailverification(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("domain", "www.cleartrip.com");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}

	public HashMap<String, Object> headersFormget_token_for_user(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("referer", "www.cleartrip.com");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}
	public HashMap<String, Object> headersFormget_token_for_user_flyin(){
		HashMap<String, Object> headers = new HashMap<>();

		headers.put("referer", "www.flyin.com");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}




	/*public HashMap<String, Object> headersFormsscreencaptureInitiate(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		return headers;
	}
	 */

	public HashMap<String, Object> headersFormscfwoptinstatus(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R1234");
		headers.put("docRequired","true");

		//GCP --	headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");

		return headers;
	}

	public HashMap<String, Object> headersFormsdepositaccount(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("AUTH_KEY", "weurimdjfoewpremkcuwpermauthkey");

		return headers;
	}


	public HashMap<String, Object> headersFormslinkdepositaccount(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJhcHBsaWNhdGlvbiI6InRlc3QiLCJST0xFUyI6WyIxMDAxNSJdLCJpc3MiOiJ0ZXN0IiwiYXVkIjoiY3QtY29uZmlnLXVpIiwiaWF0IjoxNTQ1OTAxODI0LCJuYmYiOjE1NDU5MDE4MjQsImV4cCI6MjE3NzA1MzgyNH0.BoTypgsgM0rWgOvzGaseixGz3sq0IwSb4gYrRKUpBb4");
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "text/json");
		return headers;
	}

	public HashMap<String, Object> headersFormspwaregister(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("Content-Type", "application/json");
		headers.put("referer", "qa2.cleartrip.com");
		headers.put("x-ct-caller-app", "x-ct-caller-app: my-app-name");
		return headers;
	}

	public HashMap<String, Object> headersFormsendotpmobileno(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("Content-Type", "application/json");
		headers.put("referer", "qa2.cleartrip.com");

		return headers;
	}

	public HashMap<String, Object> headersFormsauthenticate(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("Content-Type", "application/json");
		headers.put("caller", "automation");
		headers.put("Cookie", "ct-dvid =fBt2Oj1JZMLr5cCsDHejgsoMrrWh22E5Y9CWe5mdSGrCIqaABaRjww1sU289rqXfiDWLVdoTwGK7QrGrjtMRW0JZj7wwJFDH4KYa%2FUo7d4k%3D;ct-auth =e8Xtn%2Fi5A%2FGkFF9QRFLwMsixzutagL8KSDOKskJ8vP%2FPAC5BnG1VhKqX9iEbXPIdvdb22kmKGrhj2VAI20AltgYWbs0hUeS1dDOVoTv%2FC8oS3xBwBQbHAAgSFMgFCe0tlyhz2jVZSGwnR4Xe68L0aoK2eEoXgM73GXnr6ZXWU%2FuqLI6EfEr5fYarVjfH7mwKJC%2FgkOzzBJNHMAiA1hc6EQ%3D%3D");

		return headers;
	}





	public HashMap<String, Object> headersForms2(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}





	public HashMap<String, Object> headersFormsapplesignin(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.cleartrip.ae");
		headers.put("X-CT-SOURCETYPE", "mobile");
		headers.put("User-Agent", "Apple");
		headers.put("X-CT-AUTH-TOKEN", "test123");
		headers.put("X-CT-TOKEN-TYPE", "JWT");

		return headers;
	}
	public HashMap<String, Object> headersFormsfetchpersonaldata(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("caller", "mobile");
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		headers.put("accept", "*/*");


		return headers;
	}

	public HashMap<String, Object> headers_Formsapplesigninwrapperapi(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Referer", "www.flyin.com");
		headers.put("X-CT-SOURCETYPE", "mobile");
		headers.put("X-CT-AUTH-TOKEN", "test123");
		headers.put("X-CT-TOKEN-TYPE", "JWT");
		headers.put("auth_key", "7GHT#@D65yhgder4R");
		return headers;
	}

	public HashMap<String, Object> headersForms3(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "text/json");
		headers.put("Content-Type", "application/json");
		return headers;
	}

	public HashMap<String, Object> headersForms4(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "*/*");
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		return headers;
	}
	public HashMap<String, Object> headersForms_flyinsigninV2_CleartripUser(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Accept", "*/*");
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R1234");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		return headers;
	}
	
	public HashMap<String, Object> headersForms_MobileLoginsendotp(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("referer", "www.cleartrip.com");
		headers.put("Accept", "*/*");
		headers.put("caller", "b2c");
		headers.put("Cookie", "ct-auth=7N4nV0tjEqjQu3dlMgh3MU3Ol9jZIneQNnUvBQd3VxV%2FvM2I4sPbV%2BJ9bjBp5CJ%2Bvdb22kmKGrhj2VAI20AlttyqKRn4UhcQ%2FqyXSbT91Ki8I4%2BwlioTKSJ012l6FsRxnCGPVHMOM7%2FE7wSkUdtzaTUWZSFx7mGbDRo%2B0tta5i4%3D");
		return headers;
	}
	public HashMap<String, Object> headersForms_MobileLoginsendotpwithappagent(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("ab-otp", "B");
		headers.put("referer", "qa2new.cleartrip.com");
		headers.put("accept", "*/*");
		headers.put("caller", "b2c");
		headers.put("app-agent", "Android");
		return headers;
	}
	
	
	public HashMap<String, Object> headersFormsupdateuser(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("x-ct-caller-app", "mobile");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		return headers;
	}

	public HashMap<String, Object> headersFormsupdateFlyinuser(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("accept", "*/*");
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("x-ct-caller-app", "test");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		return headers;
	}
	public HashMap<String, Object> headersFormschangepassword(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Referer", "qa2.cleartrip.com");
		headers.put("Cookie", "ct-auth=xLkcxaKxpIdnhgUZcO%2BWiRjNDKCGySs%2F3qHQWLApkVidb3KV%2F49ubzf1Ekx1NtmzL1YjeWNmu3xY%2FpzUexWQN1w%2Fj5gAPNmv1vpKnDrAx3FoX9evvh5diDC4jtyRjOeZZJtx%2BJ31duZqrcZ2jUdJ6F4ai43jNI5aChVTEmGAfqQahvGkzHhRz5kPpCa%2F7j3utX4un4jpIzA3dx1i9UD1iDhmbaHDtVTELASCTE65iYNDav43rPHfhVjrxuJhRUe9V9J1s9EnvD%2BVObAzErSBUd%2BYomLdDuWrqqdRzGq7%2FdYA0m79Z5nuhvvWgXtLZpphBygb5DF%2BiBArg6EEGJYTRX%2BnhhaYeP8g0CEQkY6Tiy4JTEWCk4w4RPfV8FxcD5fiBiYwxcyF82ssHriGcBPoZbqcwrH37YPhmlmSgDptHRHSU4sbkK%2B1ntNdKiZtuD7S519sHoYJ20LxLarNevMhefLj6wy0K9HoNEZdzP3I6V6sfLCHbaSEDTDVfF6ZO2eL%2BY0HEOXDxFMm4qDR%2FfSwa6%2BHx%2F4do5V1cUolGYLe7LksliKRdHKdB04q2m8OnZXTH2Z4tsAXBZj47Mu0vEuTRiAH0Rp2vtFkuXiol%2Fc%2BBJD4qswYyk0D6GkqDc%2FryiGzrriKvMSxzl8ZjdP0xHKTJjDfE5MjfU2lez8Mc21eeVj4yG9Y5gNNb6MvOPOrwEDI%2FRkVukgyqFl7OJk6DNu3G%2FLNPaqxgHPoG%2Fb4MQRnyZVI9iJH8UXIBBVrkHxP0uq0KBIFqMINY881df17xzwxrP0wDfAjdIJWLC650cfnf3%2BZ8zInGGcv79tFePFr5UA0tMv7Ci9nlUUKOJuJ4P3asT%2F%2Fu6AA%2BWLog2uJ%2FY2YYqgP%2FV7P4M74%2FvZ8fgql9D8g8%2F%2F1HM9Q%2BhZwENf6sKaAU%2FkxX%2BEKCRjKf8O%2BTNUSfsuE8coUcku3YuzCaIBgM2P8Rb8sKLbSBDeyofU70uSSaMEckaUyLeYQbOVx%2F%2B7JUlOisjgFuy%2BxyJIPcX7Yv7eIVOKsnEkZCKNo2VdexAMFzV8jJWCkNJigozPGBBeEcF5L025fFK4zyLlxhOOqSrzgJ%2FV%2BKw55kneImPwOmjjTx8bKaKUlDohE7GDIWcILQ88d%2BXi7A5SMIuz2WcT5ii0Wf%2B8AovNHaAE6ks%2FCbb9HIDfkrt1RUQubPWxQct8F190iQxv9R6IFJ5ykwqipKSTD3By%2BM95FvKgObf5mq7KTh4b8T%2BeFMlESYJHyLIxZIZoHl9lVnkf7P1e8%2FtlB9wGg6ZHy9%2B0obMoFR67KLl5Gf2Fubx9%2Bu6Hxgn%2BXdJPeAfwgbb%2BQmBiXP12zCP6SuogJGXte7YQyF6Em8tznMbrROwtZON8HERSFujfxKGUlphAbOSefgP%2B7S8ROG3IPs9BT1n1utI2bh3BRC5ImSyZhXOG2sznZdCQ79pKhhufWoot4da2aQ5TFdB5HS5I82K%2BNFYkqRWdK4vmOr5j0J6GyQhEu5IsLcsngqwvuBRkhZ%2FI2BlzDhJYXPlwWKqeoicydwftbEFDnNHvr5PmogWHBoxfe612L%2FoZuaHewfiNVtslgbnGnbzo6cVZBOb0MxCSiNyccvTZ6ZeZ3IoYf5mwSBgL53KSTx%2BaaO3PBn83YSeM2dk11dlD76Dw%2Ffwp7gLIb%2F9H19TQBwMECqNmAPkW775ynG45GwhE3BA0pwhTRn%2BF4GSBlk6n2YHWpqXOktV2t3ZZwho5dU%2BaKzPeoMZcLm7nG2qmPwjWvfUgSBhOQRDOcCqRiT2EOGBgmpslREzWOrB3hyHpytZhU0J82K0I1WE%2BjcH8O%2FVdoj0Eb8tJ9rXfllmc8rC%2FXLy3f2oyrfnYDjCw0baLNpGuOehpaIsoMY5Rf5GiTwFvhXvAnYS%2B25eC0UR18ZscFbQ%2FM4rY6jOiEH0NyB%2B2zpVUqHxVKy8EA2q8%2BrZEfuQeptItz1QmCTCrG2zz535KwggZowoP32EtOqBWYhQip1WbhGbMQmAZql3Vy2xcsLuyKfwQVUtJ7iO6HxRDLIO7ZvTGTvHNX1ETbNEpyZpMgLwUjT3Qtd82ubZvhaDf0eBKLoRRS5JmntfEp5NxtVz6UwqLza%2B5jWfqwgqHy3G0T%2Fs2u0M7JwAT2wOh%2B34Xdyjuo9QT9eXMDGw3bKro5pSC2ES2LsRt06iOvAE7642f4Vz1Hu3%2BsavTJotWVhK57A3a1kzrO4fs6W1TZ164WNSXFwHHeNvILewT030Uc1nb9brw8XyF4qV3Bm%2FliftCqilrR7wJMKe%2B0bwL1b3dB19JZyR4PoUorfmRVlKTLRi36%2Fz06Maw86l5ulnZ%2FOYr0x68AzZPVKJIJgL%2FUR%2FFeMT6Z2FQgmkvN9o56uaDqljiH6EZf69ABfV0nq4kc9YcPGPRo5yJqnvzC9EySWebP15u3IQS2mOPTv%2B0EuLDC5z0TR%2FvMndyptkL3JYHxPCZ66Vd%2BVlVBbmE%2B1KNkwuStlsk8fQBPQcJVdWYRuJWwOzK%2Bgj3SRuWRkjCnDKKe8NqjkOHmdGzy1oyQ6RDiX8py1ChHoj4cjWr%2FDiVQVL7HHSTDtaEy7aJ1MyWDl56J5voX6gxsxpwT7eVQfFgWbHbKn8V%2FndnWpk6NfRBwwmzNNBnLHJgaDSiklpxQ%2B%2BOzrxb1Tox7Kq6%2FJBvLlwdghgUnsSVsjHrnbDXWQq4aEuOadeiUW2vyzpBPNOBmJmsFPmS8pOlAUMm1FILo%2B1a4hknTnPfj%2FoblSJLZSMRU95jBcoxcGvfJUFHGpmwaFOusXvBwUQItAVIqX%2B2smxWVqgEUizYO00bx2rlptTMEJwKb%2Bs4Kkul4g7WkvlpxSjq7IYISNrB1lR6oID5dw1I%3D");

		return headers;
	}
	public HashMap<String, Object> headersFormsupdateuser_otp(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		headers.put("x-ct-caller-app", "mobile");
		headers.put("OTP", "022546");
		return headers;
	}
	public HashMap<String, Object> headersFormsverifymobilelogin_otp(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("caller", "b2c");
		headers.put("referer", "www.cleartrip.com");
		return headers;
	}
	public HashMap<String, Object> headersFormsverifymobileloginupdatemobile_otp(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("caller", "b2c");
		headers.put("referer", "www.cleartrip.com");
		headers.put("Cookie", "ct-auth=7N4nV0tjEqjQu3dlMgh3MU3Ol9jZIneQNnUvBQd3VxV%2FvM2I4sPbV%2BJ9bjBp5CJ%2Bvdb22kmKGrhj2VAI20AlttyqKRn4UhcQ%2FqyXSbT91Ki8I4%2BwlioTKSJ012l6FsRxnCGPVHMOM7%2FE7wSkUdtzaTUWZSFx7mGbDRo%2B0tta5i4%3D");
		return headers;
	}
	

	public HashMap<String, Object> headersFormspwasignin(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		//headers.put("Content-Type", "text/plain");
		headers.put("X-CT-SOURCETYPE", "mobile");
		headers.put("Referer", "www.cleartrip.com");
		headers.put("cookie","ct-dvid =fBt2Oj1JZMLr5cCsDHejgsoMrrWh22E5Y9CWe5mdSGrCIqaABaRjww1sU289rqXfiDWLVdoTwGK7QrGrjtMRW0JZj7wwJFDH4KYa%2FUo7d4k%3D;ct-auth =e8Xtn%2Fi5A%2FGkFF9QRFLwMsixzutagL8KSDOKskJ8vP%2FPAC5BnG1VhKqX9iEbXPIdvdb22kmKGrhj2VAI20AltgYWbs0hUeS1dDOVoTv%2FC8oS3xBwBQbHAAgSFMgFCe0tlyhz2jVZSGwnR4Xe68L0aoK2eEoXgM73GXnr6ZXWU%2FuqLI6EfEr5fYarVjfH7mwKJC%2FgkOzzBJNHMAiA1hc6EQ%3D%3D");
		return headers;
	}




	public HashMap<String, Object> headersFormsTCupdateTraveller(){
		HashMap<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		//GCP -- headers.put("AUTH_KEY", "H67f$we&HGTR34clQ");
		headers.put("version", "v1");
		return headers;
	}



	public Response ivr(String Type){
		RestAssured.baseURI =url_IVR;
		String urlTrip = url_IVR+url_EndPoint_Trip;
		String urlMobile = url_IVR+url_EndPoint_Mobile;
		String urlDate= url_IVR+url_EndPoint_Date;
		String urlPersonJson = url_PersonJson;
		HashMap<String, Object> headers;
		headers = headersForms();
		Response request = null;							
		if(Type.equals("TripID")) {
			Reporter.log("url  "+urlTrip);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(urlTrip);
		}
		else if(Type.equals("Mobile")) {
			Reporter.log("url  "+urlMobile);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(urlMobile);
		}
		else if(Type.equals("Date")) {
			Reporter.log("url  "+urlDate);
			request = RestAssured.given().
					when().
					log().all().
					headers(headers).
					get(urlDate);
		}

		return request;
	}

	public Response postCallIdentity(String url){
		Response resp;
		resp = RestAssured.given().
				contentType("multipart/form-data").
				multiPart("access_token","rUBn829a8U4nH12Zo4uiHj9CHOSu3H5k44FyRJVERLB2rjdlOy").
				when().
				log().all().
				post(url);
		return resp;

	}

	public Response postCallIdentitygettokenthroughcode(String url){
		Response resp;
		resp = RestAssured.given().
				contentType("multipart/form-data").
				multiPart("code","YHZMrZQmMJaxvPC8uTMt").
				multiPart("grant_type","authorization_code").
				multiPart("redirect_uri","http://localhost:8080/ctauth/authorize").
				multiPart("client_id","test").
				when().
				log().all().
				post(url);
		return resp;
	}

	public Response pwaregisterapi(String url){
		Response resp;
		resp = RestAssured.given().
				headers(headersFormspwaregister()).				
				when().
				log().all().
				body(params_pwaregister).

				post(url);
		return resp;
	}
	public Response pwafetchDAdetails(String url){
		Response resp;
		resp = RestAssured.given().
				//headers(headersFormspwaregister()).				
				when().
				log().all().
				// body(params_pwafetchDAdetails).

				post(url);
		return resp;
	}

	public Response linkdepositaccount(String url){
		Response resp;
		resp = RestAssured.given().
				headers(headersFormslinkdepositaccount()).				
				when().
				log().all().
				body(params_linkdepositaccount).

				post(url);
		return resp;
	}

	public Response postCallIdentitygettokenthroughrefreshtoken(String url){
		Response resp;
		resp = RestAssured.given().
				contentType("multipart/form-data").
				multiPart("grant_type","authorization_code").
				multiPart("refresh_token","oU4il8ohv5PvvY9ZzIHzi36LJ5Yislwch5NLP0YBXl9ipNk7VZ").
				multiPart("redirect_uri","https://www.travelbox99.com/local").
				multiPart("client_id","identitytest").
				when().
				log().all().
				post(url);

		return resp;
	}

	public Response postCall(String Type, String Type1){
		RestAssured.baseURI =url_Acct;
		String url = null;
		String params =null;
		Response request = null;	

		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms1();



		if(Type.equals("CreateWallet")) {
			RestAssured.baseURI =url_Acct;
			url = url_CreateWallet;
			params = params_CreateWallet;					 
		}

		if(Type.equals("AcctRegister")){
			RestAssured.baseURI=url_Acct;
			headers=headersForms1();
			url=url_AcctRegister;
			params=params_Register;
		}

		if(Type.equals("B2B_user_authentication")){
			RestAssured.baseURI=url_Acct;
			headers=headersForms1();
			url=url_B2B_user_authentication;
			params=params_B2B_user_authentication;
		}

		if(Type.equals("Register_API")){
			RestAssured.baseURI=url_Acct_Service;
			headers=headersRegister();
			url=url_Register;
			params=params_Register_api;
		}

		if(Type.equals("Register_Failure")){
			RestAssured.baseURI=url_Acct_Service;
			headers=headersRegister();
			url=url_Register;
			params=param_Register_Failure;
		}

		if(Type.equals("Register_incompete")){
			RestAssured.baseURI=url_Acct_Service;
			headers=headersRegister();
			url=url_Register;
			params=param_Register_Incomplete;
		}

		if(Type.equals("FK_Redirection")){
			RestAssured.baseURI=qaurl;
			headers=headersFK_Redirection();
			url=url_FK_Redirection;
			params=params_FK_Redirection;
		}

		if(Type.equals("FK_Redirection_Invalid_request")){
			RestAssured.baseURI=qaurl;
			headers=headersFK_Redirection();
			url=url_FK_Redirection;
			params=params_FK_Redirection_Incomplete;
		}

		if(Type.equals("Apiconfig_postcall")){
			RestAssured.baseURI=url_Acct;
			headers=headersFormsapi_config();
			url=url_Apiconfig_postcall;
			params=params_Apiconfig_postcall;
		}


		if(Type.equals("Companyconfig_contactdata")){
			RestAssured.baseURI=url_Acct;
			headers=headersForms3();
			url=url_Companyconfig_contactdata;
			params=params_Companyconfig_contactdata;
		}



		if(Type.equals("ForgotPasswordEmail")){
			RestAssured.baseURI=url_Acct;
			headers=headersForms3();
			url=url_ForgotPasswordEmail;
			params=params_ForgotPasswordEmail;
		}
		if(Type.equals("FetchPeople")) {
			headers = headersForms2();

			RestAssured.baseURI =url_Acct;
			url = url_FetchPeople;					
			params = params_FetchPeople;
		}

		if(Type.equals("Feedbackemail")) {
			headers = headersForms2();

			RestAssured.baseURI =url_Acct;
			url = url_Feedbackemail;					
			params = params_Feedbackemail;
		}

		if(Type.equals("signinpostcall")) {
			headers = headersForms3();

			RestAssured.baseURI =url_Acct;
			url = url_signinpostcall;					
			params =params_Signinpostcall ;
		}

		if(Type.equals("userprofile_externalAPI_Mobileapp")) {
			headers = headersForms3();

			RestAssured.baseURI =url_Acct;
			url = url_userprofile_externalAPI_Mobileapp;					
			params =params_userprofile_externalAPI_Mobileapp ;
		}


		if(Type.equals("b2bAddtraveler")) {
			headers = headersForms3();

			RestAssured.baseURI =url_Acct;
			url = url_b2bAddtraveler;					
			params =params_b2bAddtraveler ;
		}



		if(Type.equals("b2csignin")) {
			headers = headersForms3();

			RestAssured.baseURI =url_Acct;
			url = url_b2csignin;					
			params =params_b2csignin ;
		}

		if(Type.equals("b2csignin_prod")) {
			headers = headersForms3();

			RestAssured.baseURI =url_Acct;
			url = url_b2csignin_prod;					
			params =params_b2csignin_prod ;
		}


		if(Type.equals("API_Config_Getcall_APIKey")) {
			headers = headersFormsapi_config();


		}


		if(Type.equals("flyinsignin")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinsignin;					
			params =params_flyinsignin ;
		}

		if(Type.equals("flyinsigninV1")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsignin;					
			params =params_flyinsignin ;
			Reporter.log(url_Acct_Service+url);
		}
		if(Type.equals("Account_Service_CFW_StatusUpdateCall")) {
			headers = headersFormdepoist();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_CFW_StatusUpdateCall;					
			params =params_Account_Service_CFW_StatusUpdateCall ;

			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("Account_Service_PWA_SignIn_API")) {
			headers = headersFormspwasignin();

			RestAssured.baseURI =url_Identitymicro_service;
			url = url_Account_Service_PWA_SignIn_API;					
			params =params_Account_Service_PWA_SignIn_API ;
			Reporter.log(url_Identitymicro_service+url);
		}


		if(Type.equals("flyinsigninV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsigninV2;					
			params =params_flyinsignin;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Promotional_Service_GenerateReferralLink")) {
			headers = headersFormpromotionalgetreferraldetails();

			RestAssured.baseURI =url_Promotional_Service_domain;
			url = url_Promotional_Service_GenerateReferralLink;
			params =params_Promotional_Service_GenerateReferralLink;
			Reporter.log(url_Promotional_Service_domain+url);

		}

		if(Type.equals("FkVIP_Injest_Profile")) {
			headers = headersFormFKVIPInjestProfile();

			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Injest_Profile;
			params =params_FKVIP_injest_profile ;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FK_Injest_ProfileExpiry")) {
			headers = headersFormFKVIPInjestProfile();

			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Injest_Profile;
			params =params_FKVIP_injest_profileEXPIRY ;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FKVIP_Discovery_API")) {
			headers = headersFormFKVIPDiscoverAPI();

			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Discover_API;
			params =params_FKVIP_Discover_API ;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("Floater_Add_Template_API")) {
			headers = headersFormFloaterAddTemplate();
			RestAssured.baseURI =url_monetisation_Service;
			url = url_FLoater_AddTemplate;
			params =params_Floater_AddTemplate ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_Add_Template_DuplicateAPI")) {
			headers = headersFormFloaterAddTemplate();
			RestAssured.baseURI =url_monetisation_Service;
			url = url_FLoater_AddTemplate;
			params =params_Floater_AddDuplicateTemplate ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_Add_Template_InvalidAPI")) {
			headers = headersFormFloaterAddTemplate();
			RestAssured.baseURI =url_monetisation_Service;
			url = url_FLoater_AddTemplate;
			params =params_Floater_InvalidBody ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_Add_Template_WithoutBody")) {
			headers = headersFormFloaterAddTemplate();
			RestAssured.baseURI =url_monetisation_Service;
			url = url_FLoater_AddTemplate;
			params =params_Floater_WithoutTemplateBody ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_Get_FloaterBy_SlotID")) {
			headers = headersFormFloaterGetAPI();
			RestAssured.baseURI =url_monetisation_Service_domain;
			url = url_Floater_Get_API;
			params =params_Floater_Get_API ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_SaveImpression_API")) {
			headers = headersFormFloaterGetAPI();
			RestAssured.baseURI =url_monetisation_Service_domain;
			url = url_Floater_SaveImpression;
			params =params_Floater_SaveImpression ;
			Reporter.log(url_monetisation_Service_domain+url);
		}

		if(Type.equals("Floater_Get_FloaterBy_SlotID_Invalid")) {
			headers = headersFormInvalidFloaterGetAPI();
			RestAssured.baseURI =url_monetisation_Service_domain;
			url = url_Floater_Get_API;
			params =params_Floater_Get_API ;
			Reporter.log(url_monetisation_Service_domain+url);

		}

		if(Type.equals("Floater_Get_FloaterBy_SlotID_WithoutHeader")) {
			headers = headersFormFloaterGetAPIWithOutHeader();
			RestAssured.baseURI =url_monetisation_Service_domain;
			url = url_Floater_Get_API;
			params =params_Floater_Get_API ;
			Reporter.log(url_monetisation_Service_domain+url);

		}

		if(Type.equals("Floater_Get_FloaterBy_SlotID_WithNewbody")) {
			headers = headersFormFloaterGetAPI();
			RestAssured.baseURI =url_monetisation_Service_domain;
			url = url_Floater_Get_API;
			params =params_Floater_Get_API_WithNewbody ;
			Reporter.log(url_monetisation_Service_domain+url);

		}

		if(Type.equals("FKVIP_Discovery_API_WithOutFilter")) {
			headers = headersFormFKVIPDiscoverAPI();

			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Discover_API;
			params =params_FKVIP_Discover_API_WIthOutFilter ;
			Reporter.log(url_monetisation_Service_domain+url);

		}

		if(Type.equals("FKVIP_Valid_RedeemAPI")) {
			headers = headersFormFKVIPRedeemAPI();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Redeem_API;
			params =params_FKVIP_Redeem_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FKVIP_InValid_RedeemAPI")) {
			headers = headersFormFKVIPRedeemAPI();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Redeem_API;
			params =params_FKVIP_InValid_Redeem_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FKVIP_Valid_RollBackAPI")) {
			headers = headersFormFKVIPValidRollBackAPI();
			RestAssured.baseURI =url_ingestion_Service_domain;
			params =params_FKVIP_Valid_RollBack_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FKVIP_InValid_RollBackAPI")) {
			headers = headersFormFKVIPInvalidRollBackAPI();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Invalid_Rollback_API;
			params =params_FKVIP_Invalid_RollBack_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("FKVIP_ActiveEntity_API")) {

			headers = headersFormFKVIPActiveEntity();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Active_Entity;
			params =params_FKVIP_Active_Entity;
			Reporter.log(url_ingestion_Service_domain+url);

		}
		if(Type.equals("FKVIP_ActiveEntity_Invalid_API")) {

			headers = headersFormFKVIPActiveEntity();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_Active_Entity;
			params =params_FKVIP_Active_Entity_Invalid_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		if(Type.equals("Promotional_Service_GenerateReferralLink_InvalidAuth")) {
			headers = headersFormpromotionalgetreferraldetailsinvalid();

			RestAssured.baseURI =url_Promotional_Service_domain;
			url = url_Promotional_Service_GenerateReferralLink;					
			params =params_Promotional_Service_GenerateReferralLink;
			Reporter.log(url_Promotional_Service_domain+url);

		}


		if(Type.equals("AS_update_contact_data")) {
			headers = UpdateUserData();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Update_contact_data;
			params =params_Update_Contact_Data;
			Reporter.log(qaurl+url);
		}

		if(Type.equals("AS_update_company_profile")) {
			headers = UpdateUserProfile();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Update_User_profile;
			params =params_Update_Profile_Data;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_Create_ctauth")) {
			headers = Createctauth();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Create_ct_auth;
			params =params_Create_Ct_auth;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_Create_Ctauth_Invalid")) {
			headers = CreatectauthWithoutKey();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Create_ct_auth;
			params =params_Create_Ct_auth;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_Create_Ctauth_MissingCaller")) {
			headers = CreatectauthWithoutCaller();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Create_ct_auth;
			params =params_Create_Ct_auth;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_Update_UserJson")) {
			//headers = UserJsonUpdate();
			headers = JsonUp();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Update_UserJson;
			params =params_json;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_Update_UserJsonInvalid")) {
			//headers = UserJsonUpdate();
			headers = JsonUp();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Update_UserJson;
			params =params_jsonEmpty;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("AS_AccountMerge_API")) {
			headers = AccountMerge();
			RestAssured.baseURI =url_Acct_service_worker;
			params =params_Account_Wallet_merge;
			url = url_AccountMerge;
			Reporter.log(url_Acct_Service+url);
		}
		if(Type.equals("AS_WalletMerge_API")) {
			headers = WalletMerge();
			RestAssured.baseURI =url_Acct_service_worker;
			params =params_Account_Wallet_merge;
			url = url_WalletMerge;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("Account_Service_Update_GST_Details")) {
			headers = validCookieGST();
			RestAssured.baseURI =qaurl;
			url = url_Update_GST_Details;
			params =params_Update_GST_Details;
			Reporter.log(qaurl+url);
		}

		if(Type.equals("Account_Service_Update_GST_Details_InValidGST")) {
			headers = validCookieGST();

			RestAssured.baseURI =qaurl;
			url = url_Update_GST_Details;
			params =params_Update_Invalid_GST_Details;
			Reporter.log(qaurl+url);
		}

		if(Type.equals("Account_Service_Update_GST_Details_WithoutCookie")) {
			headers = WithOutCookieGST();
			RestAssured.baseURI =qaurl;
			url = url_Update_GST_Details;
			params =params_Update_GST_Details;
			Reporter.log(qaurl+url);
		}

		if(Type.equals("Account_Service_Update_GST_Details_InvalidCookie")) {
			headers = InvalidCookieGST();
			RestAssured.baseURI =qaurl;
			url = url_Update_GST_Details;
			params =params_Update_GST_Details;
			Reporter.log(qaurl+url);
		}


		if(Type.equals("Accounts_Service_FLyinV2_Signin_Unauthorized")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsigninV2;					
			params =params_Accounts_Service_FLyinV2_Signin_Unauthorized;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("AccountsService_FlyinV2Signin_Unauthorized")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsigninV2;					
			params =params_AccountsService_FlyinV2Signin_Unauthorized;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_FlyinV2_Signin_FlyinUser")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsigninV2;					
			params =params_Account_Service_FlyinV2_Signin_FlyinUser;
			Reporter.log(url_Acct_Service+url);

		}


		if(Type.equals("flyinsigninV2_CleartripUser")) {
			headers = headersForms_flyinsigninV2_CleartripUser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsigninV2;					
			params =params_flyinsigninV2_CleartripUser;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_sendOTP_SIGNIN")) {
			headers = headersForms_MobileLoginsendotp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_sendOTP_SIGNIN;					
			params =params_Account_Service_MobileLogin_sendOTP_SIGNIN;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_sendOTP_SIGNIN_withAppAgent")) {
			headers = headersForms_MobileLoginsendotpwithappagent();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_sendOTP_SIGNIN;					
			params =params_Account_Service_MobileLogin_sendOTP_SIGNIN;
			Reporter.log(url_Acct_Service+url);

		}
		
		if(Type.equals("Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE")) {
			headers = headersForms_MobileLoginsendotp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_sendOTP_SIGNIN;					
			params =params_Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE")) {
			headers = headersForms_MobileLoginsendotp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_sendOTP_SIGNIN;					
			params =params_Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE;
			Reporter.log(url_Acct_Service+url);

		}
		
		if(Type.equals("Manage_trips_OTP_API")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_Manage_trips_OTP_API;					
			params =params_Manage_trips_OTP_API;
		}




		if(Type.equals("cfw_active_status")) {
			headers = headersForms2();

			RestAssured.baseURI =url_Acct;
			url = url_cfw_active_status;					
			params =params_cfw_active_status;
		}


		if(Type.equals("identtiyservice_getresource")) {
			headers = headersForms2();

			RestAssured.baseURI =url_identity;
			url = url_identtiyservice_getresource;	


			params = params_identtiyservice_getresource;
			Reporter.log(url_identity+url);


		}

		if(Type.equals("flyinsignup")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinsignup;					
			params =params_flyinsignup ;


		}

		if(Type.equals("flyinsignupV1")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsignup;					
			params =params_flyinsignup ;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("Account_Service_Update_User")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User;					
			params =params_Account_Service_Update_User ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_Update_User_Cleartrip_B2Buser")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User;					
			params =params_Account_Service_Update_User_Cleartrip_B2Buser ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_Cleartrip_confirmedtravlerwithActivestatus")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Cleartrip_confirmedtravlerwithActivestatus;					
			params =params_Account_Service_Cleartrip_confirmedtravlerwithActivestatus ;
		}
		if(Type.equals("Accounts_Service_Cleartrip_MultipleTraveller_Updatecall")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User;					
			params =params_Accounts_Service_Cleartrip_MultipleTraveller_Updatecall ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Accounts_Service_DOCdetailsUpdate_cleartripuser")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User;					
			params =params_Accounts_Service_DOCdetailsUpdate_cleartripuser ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("IdentityService_ChangePassword")) {
			headers = headersFormschangepassword();

			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_ChangePassword;	
			params =params_IdentityService_ChangePassword ;
			Reporter.log(url_Identitymicro_service+url);

		}
		if(Type.equals("IdentityService_RecaptchaAPI")) {
			headers = headersFormgetactivationkey();

			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_RecaptchaAPI;	
			params =params_IdentityService_ChangePassword ;
			Reporter.log(url_Identitymicro_service+url);

		}
		if(Type.equals("IdentityService_ResetPassword")) {
			headers = headersFormschangepassword();

			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_ResetPassword;	
			params =params_IdentityService_ResetPassword ;
			Reporter.log(url_Identitymicro_service+url);

		}
		if(Type.equals("Account_Service_RegisterFLyinUserUpdate_OTPValidation")) {
			headers = headersFormsupdateuser_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_RegisterFLyinUserUpdate_OTPValidation;					
			params =params_Account_Service_RegisterFLyinUserUpdate_OTPValidation ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_RegisterFLyinUserUpdate_WithoutOTP")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_RegisterFLyinUserUpdate_OTPValidation;					
			params =params_Account_Service_RegisterFLyinUserUpdate_OTPValidation ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("Account_Service_FLYIN_User_Update")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FLYIN_User_Update;					
			params =params_Account_Service_FLYIN_User_Update ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("AS_FlyinUserDetails_Update")) {
			headers = headersFormsupdateFlyinuser();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FLYIN_User_Update;
			params =params_Account_Service_FLYINUserDetails_Update ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("Accounts_Service_Flyin_DOCdetails_update")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FLYIN_User_Update;					
			params =params_Accounts_Service_Flyin_DOCdetails_update ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Accounts_Service_FLyinUser_GSTdetailsUpdate")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FLYIN_User_Update;					
			params =params_Accounts_Service_FLyinUser_GSTdetailsUpdate ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("Account_Service_Update_User_MobileNo_OTPValidaion")) {
			headers = headersFormsupdateuser_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User_MobileNo_OTPValidaion;					
			params =params_Account_Service_Update_User_MobileNo_OTPValidaion ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_verifyOTP_SignIn")) {
			headers = headersFormsverifymobilelogin_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_verifyOTP_SignIn;					
			params =params_Account_Service_MobileLogin_verifyOTP_SignIn ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_verifyOTP_UPDATE_MOBILE")) {
			headers = headersFormsverifymobileloginupdatemobile_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_verifyOTP_SignIn;					
			params =params_Account_Service_MobileLogin_verifyOTP_UPDATE_MOBILE ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_NudgePersonaldetails")) {
			headers = headersFormsverifymobileloginupdatemobile_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_NudgePersonaldetails;					
			params =params_Account_Service_MobileLogin_NudgePersonaldetails ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_NudgeUpdateMobile")) {
			headers = headersFormsverifymobileloginupdatemobile_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_NudgeUpdateMobile;					
			params =params_Account_Service_MobileLogin_NudgePersonaldetails ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_MobileLogin_verifyOTP_SIGNUP_MERGE")) {
			headers = headersFormsverifymobileloginupdatemobile_otp();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_MobileLogin_verifyOTP_SignIn;					
			params =params_Account_Service_MobileLogin_verifyOTP_SIGNUP_MERGE ;
			Reporter.log(url_Acct_Service+url);

		}
		if(Type.equals("Account_Service_RegisteredCltp_UserUpdate_WithoutOTP")) {
			headers = headersFormsupdateuser();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Update_User_MobileNo_OTPValidaion;					
			params =params_Account_Service_Update_User_MobileNo_OTPValidaion ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("Userclassification_Parsing_CSV")) {
			headers =userclassification();

			RestAssured.baseURI =url_userclassification;
			url = url_Userclassification_parsingcsv;	
			params ="" ;
			Reporter.log(url_userclassification+url);

		}


		if(Type.equals("flyinsignupV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsignupV2;					
			params =params_flyinsignup ;
			Reporter.log(url_Acct_Service+url);

		}

		if(Type.equals("flyinresetpasswordV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinresetpasswordV2;					
			params =params_flyinresetpasswordV2 ;
			Reporter.log(url_Acct_Service+url);
		}
		if(Type.equals("Account_Service_Cleartrip_ResetPassword")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinresetpasswordV2;					
			params =params_Account_Service_Cleartrip_ResetPassword ;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("flyinresetpassword")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinresetpassword;					
			params =params_flyinresetpassword ;
		}


		if(Type.equals("flyinforgetpassword")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinforgetpassword;					
			params =params_flyinforgetpassword ;
		}

		if(Type.equals("flyinforgetpasswordV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinforgetpasswordV2;					
			params =params_flyinforgetpasswordV2 ;
			Reporter.log(url_Acct_Service+url);
		}


		if(Type.equals("flyinusersearch")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinusersearch;					
			params =params_flyinusersearch ;
		}

		if(Type.equals("flyinusersearchV1")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinusersearch;					
			params =params_flyinusersearch ;
			Reporter.log(url_Acct_Service+url);
		}


		if(Type.equals("flyinusersearchV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinusersearchV2;					
			params =params_flyinusersearchV2 ;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("flyinusersearchV2_Flyinregression")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinusersearchV2;					
			params =params_flyinusersearchV2_regression ;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("partnercontroller_updatetraveller")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_partnercontroller_updatetraveller;					
			params =params_partnercontroller_updatetraveller ;
			Reporter.log(url_Acct_Service+url);
		}


		if(Type.equals("travellercontroller_updatetraveller")) {
			headers = headersFormsTCupdateTraveller();

			RestAssured.baseURI =url_Acct_Service;
			url = url_travellercontroller_updatetraveller;					
			params =params_travellercontroller_updatetraveller ;
			Reporter.log(url_Acct_Service+url);
		}


		if(Type.equals("Account_Service_Travellercontroller_UpdateTraveller_FlyRegression")) {
			headers = headersFormsTCupdateTraveller();

			RestAssured.baseURI =url_Acct_Service;
			url = url_travellercontroller_updatetraveller;					
			params =params_Account_Service_Travellercontroller_UpdateTraveller_FlyRegression ;
			Reporter.log(url_Acct_Service+url);
		}




		if(Type.equals("flyinsocialsignup")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct;
			url = url_flyinsocialsignup;					
			params =params_flyinsocialsignup;
		}

		if(Type.equals("flyinsocialsignupV1")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsocialsignup;					
			params =params_flyinsocialsignup;
			Reporter.log(url_Acct_Service+url);
		}


		if(Type.equals("flyinsocialsignupV2")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsocialsignupV2;					
			params =params_flyinsocialsignupV2 ;
			Reporter.log(url_Acct_Service+url);
		}

		if(Type.equals("flyinsocialsignupV2_flyinregression")) {
			headers = headersForms4();

			RestAssured.baseURI =url_Acct_Service;
			url = url_flyinsocialsignupV2;					
			params =params_flyinsocialsignupV2_flyinregression ;
			Reporter.log(url_Acct_Service+url);
		}





		if(Type.equals("RoleInfo")) {
			headers = headersForms2();
			RestAssured.baseURI =url_Acct;
			url = url_RoleInfo;					
			params = params_RoleInfo;
		}
		if(Type.equals("FetchUserV2")) {
			headers = headersForms2();
			RestAssured.baseURI =url_Acct;
			url = url_FetchUserV2;					
			params = params_FetchUserV2;
		}

		if(Type.equals("createUpdateGST")) {
			headers = headersFormsgst();
			RestAssured.baseURI =url_Acct;
			url = url_createUpdateGST;					
			params = params_createUpdateGST;
		} 

		if(Type.equals("cleartripForWorkOptin")) {
			headers = headersFormscfwoptin();
			RestAssured.baseURI =url_Acct;
			url = url_cleartripForWorkOptin;					
			params = params_cleartripForWorkOptin;
		} 

		/*	if(Type.equals("screencaptureInitiate")) {
			//headers = headersFormsscreencaptureInitiate();
			RestAssured.baseURI =url_identity;
			url = url_screencaptureInitiate;					
			params = params_screencaptureInitiate;
		}*/ 

		if(Type.equals("cfwgstdocstatusupdate")) {
			headers = headersFormscfwoptin();
			RestAssured.baseURI =url_Acct;
			url = url_cfwgstdocstatusupdate;					
			params = params_cfwgstdocstatusupdate;
		} 


		if(Type.equals("identityserviceaddclient")) {
			headers = headersFormIdentity();
			RestAssured.baseURI =url_identity;
			url = url_identityserviceaddclient;					
			params = params_identityserviceaddclient;
			Reporter.log(url_identity+url);
		} 
		if(Type.equals("Flipkart_Accounts_Service_CreateUser")) {
			headers = headersFormflipkart();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Flipkart_Accounts_Service_CreateUser;					
			params = params_Flipkart_Accounts_Service_CreateUser;
			Reporter.log(url_Acct_Service+url);
		} 
		if(Type.equals("Flipkart_Accounts_service_CreateUser_ExistingUser")) {
			headers = headersFormflipkart();
			RestAssured.baseURI =url_Acct_Service;
			url = url_Flipkart_Accounts_service_CreateUser_ExistingUser;					
			params = params_Flipkart_Accounts_service_CreateUser_ExistingUser;
			Reporter.log(url_Acct_Service+url);
		} 


		if(Type.equals("identityservicesignin")) {
			headers = headersFormIdentitysignin();
			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_identityservicesignin;					
			params = params_identityservicesignin;
			Reporter.log(url_Acct_Service_applesgnin+url);
		}
		if(Type.equals("IdentityService_Signin_Userauthentication_B2C_B2B")) {
			headers = headersFormsauthenticate();
			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_Signin_Userauthentication_B2C_B2B;					
			params = params_IdentityService_Signin_Userauthentication_B2C_B2B;
			Reporter.log(url_Identitymicro_service+url);
		}
		if(Type.equals("IdentityService_Signin_Userauthentication_B2C_B2B_b2cUserwithoutParams")) {
			headers = headersFormsauthenticate();
			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_Signin_Userauthentication_B2C_B2B_b2cUserwithoutParams;					
			params = params_IdentityService_Signin_Userauthentication_B2C_B2B;
			Reporter.log(url_Identitymicro_service+url);
		}
		if(Type.equals("IdentityService_Signin_Userauthentication_B2C_B2B_b2bUser")) {
			headers = headersFormsauthenticate();
			RestAssured.baseURI =url_Identitymicro_service;
			url = url_IdentityService_Signin_Userauthentication_B2C_B2B;					
			params = params_IdentityService_Signin_Userauthentication_B2C_B2B_b2bUser;
			Reporter.log(url_Identitymicro_service+url);
		}

		if(Type.equals("IdentityService_Signin_Unauthorized")) {
			headers =headersFormIdentitysigninflyin ();
			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_identityservicesignin;					
			params = params_IdentityService_Signin_Unauthorized;
			Reporter.log(url_Acct_Service_applesgnin+url);
		}
		if(Type.equals("IdentityService_Signin_UsernotPresent")) {
			headers =headersFormIdentitysignin ();
			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_identityservicesignin;					
			params = params_IdentityService_Signin_Unauthorized;
			Reporter.log(url_Acct_Service_applesgnin+url);
		}


		if(Type.equals("IdentityService_Signin_FlyinUser")) {
			headers = headersFormIdentitysigninflyin();
			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_identityservicesignin;					
			params = params_IdentityService_Signin_FlyinUser;
			Reporter.log(url_Acct_Service_applesgnin+url);
		}

		if(Type.equals("registerUser")) {
			RestAssured.baseURI =url_Acct;
			url = url_registerUser;
			headers=headersForms3();
			params = params_registerUser;	
		}
		if(Type.equals("externalApi_Refreshtoken")) {
			RestAssured.baseURI =url_Acct;
			url = url_externalApi_Refreshtoken;
			headers=headersForms2();
			params = params_externalApi_Refreshtoken;	
		}
		if(Type.equals("createUpdateTraveller")) {
			RestAssured.baseURI = url_Acct;
			url = url_createUpdateTraveller;
			headers=headersForms2();
			params = params_createUpdateTraveller;
		}

		if(Type.equals("createTraveller")) {
			RestAssured.baseURI = url_Acct;
			url = url_createTraveller;
			headers=headersForms2();
			params = params_createTraveller;
		}

		if(Type.equals("createCompanyTags")) {
			RestAssured.baseURI = url_Acct;
			url = url_createCompanyTags;
			headers=headersForms2();
			params = params_createCompanyTags;
		}

		if(Type.equals("createUpdateTraveller_bookstep2")) {
			RestAssured.baseURI = url_Acct;
			url = url_createUpdateTraveller_bookstep2;
			headers=headersForms2();
			params = params_createUpdateTraveller_bookstep2;
		}

		if(Type.equals("AccountsInfoAPI_BasedonUserId")) {
			RestAssured.baseURI =url_Acct;
			url = url_AccountsInfoAPI_BasedonUserId;
			headers=headersForms2();
			params = params_AccountsInfoAPI_BasedonUserId;
		}

		if(Type.equals("Account_Service_AppleSignin")) {
			headers = headersFormsapplesignin();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Account_Service_AppleSignin;					
			params =params_Account_Service_AppleSignin ;
		}
		if(Type.equals("Identity_service_RecaptchaAPI")) {
			headers = headersFormgetactivationkey();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Identity_service_RecaptchaAPI;					
			params =params_Identity_service_RecaptchaAPI ;
		}
		if(Type.equals("Account_Service_FetchPersonalData")) {
			headers = headersFormsfetchpersonaldata();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FetchPersonalData;					
			params =params_Account_Service_FetchPersonalData ;
		}
		if(Type.equals("Account_Service_FetchContactData")) {
			headers = headersFormsfetchpersonaldata();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_FetchContactData;					
			params =params_Account_Service_FetchContactData ;
		}
		if(Type.equals("Account_Service_LinkDepositAccount")) {
			headers = headersFormdepoistwithoutlinkedparam();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_LinkDepositAccount;					
			params =params_Account_Service_LinkDepositAccount ;
		}
		if(Type.equals("Account_Service_Company_AddGSTwith_DomainName")) {
			headers = headersFormgst();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Company_AddGSTwith_DomainName;					
			params =params_Account_Service_Company_AddGSTwith_DomainName ;
		}
		if(Type.equals("Account_Service_Express_Checkout")) {
			headers = headersFormdepoist();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Express_Checkout;					
			params =params_Account_Service_LinkDepositAccount ;
		}
		if(Type.equals("Account_Service_CreateWalletAPI")) {
			headers = headersFormgst();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_CreateWalletAPI;					
			params =params_Account_Service_CreateWalletAPI ;
		}
		if(Type.equals("Account_Service_Company_AddGSTwith_CompanyID")) {
			headers = headersFormgst();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Company_AddGSTwith_CompanyID;					
			params =params_Account_Service_Company_AddGSTwith_CompanyID ;
		}
		if(Type.equals("Account_Service_Company_AddGSTwith_CompanyID_DomainName")) {
			headers = headersFormgst();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_Company_AddGSTwith_CompanyID_DomainName;					
			params =params_Account_Service_Company_AddGSTwith_CompanyID_DomainName ;
		}

		if(Type.equals("Accounts_Service_Applesignin_Unauthorized")) {
			headers = headersFormsapplesignin();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Account_Service_AppleSignin;					
			params =params_Accounts_Service_Applesignin_Unauthorized ;
		}
		if(Type.equals("Account_Service_AppleSignin_WrapperAPI")) {
			headers = headers_Formsapplesigninwrapperapi();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_AppleSignin_WrapperAPI;					
			params =params_Account_Service_AppleSignin_WrapperAPI ;
		}

		if(Type.equals("Account_Service_SendOTP_ToUsermobileNo")) {
			headers = headersFormsendotpmobileno();

			RestAssured.baseURI =url_Acct_Service;
			url = url_Account_Service_SendOTP_ToUsermobileNo;					
			params =params_Account_Service_SendOTP_ToUsermobileNo ;
		}


		if(Type.equals("Account_Service_AppleSignin_uniqueId")) {
			headers = headersFormsapplesignin();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Account_Service_AppleSignin_uniqueId;					
			params =params_Account_Service_AppleSignin_uniqueId ;
		}

		if(Type.equals("Account_Service_AppleSignin_Entity")) {
			headers = headersFormsapplesignin();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Account_Service_AppleSignin_uniqueId;					
			params =params_Account_Service_AppleSignin_Entity ;
		}

		if(Type.equals("Account_Service_AppleRegister_NullEmail")) {
			headers = headersFormsapplesignin();

			RestAssured.baseURI =url_Acct_Service_applesgnin;
			url = url_Account_Service_AppleSignin_uniqueId;					
			params =params_Account_Service_AppleRegister_NullEmail ;
		}

		Reporter.log("url  "+url);
		request = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);

		return request;
	}

	public Response deleteCall(String Type, String Type1){

		RestAssured.baseURI =url_Acct;


		String url = null;

		String params =null;
		Response request = null;	
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms1();
		if(Type.equals("AcctSanity")) {
			url = url_acctSanity;
		}



		else if(Type.equals("Accounts_service_Company_DeleteGST"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Accounts_service_Company_DeleteGST;
			params= params_Accounts_service_Company_DeleteGST;
			headers = headersFormdepoist();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_Mongo_CacheReset"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Mongo_CacheReset;
			params= params_Accounts_service_Company_DeleteGST;
			headers = headersFormcachereset();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Accounts_service_Company_DeleteGST_CompanyID_DomainName"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Accounts_service_Company_DeleteGST_CompanyID_DomainName;
			params= params_Accounts_service_Company_DeleteGST;
			headers = headersFormdepoist();
			Reporter.log(url_Acct_Service+url);
		}
		Reporter.log("url  "+url);
		request = RestAssured.given().						
				when().
				log().all().
				body(params).
				headers(headers).
				delete(url);
		return request;
	}


	public Response putCall(String Type, String Type1){

		RestAssured.baseURI =url_Acct;


		String url = null;

		String params =null;
		Response request = null;	
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms1();
		if(Type.equals("AcctSanity")) {
			url = url_acctSanity;
		}


	else if(Type.equals("Account_Service_Update_Personal_Details"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Update_Personal_Details;
			params= params_Accounts_Service_Update_Personal_Details;
			headers = UpdateDetails();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("AS_Update_Traveller_Details"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Traveller_Details_update;
			params= params_AS_Update_Traveller_details;
			headers = UpdateTravellerDetails();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("AS_Update_Traveller_Details_Invalid"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Traveller_Details_update;
			params= params_AS_Update_Traveller_details;
			headers = UpdateTravellerDetailsWithoutcookie();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("Account_Service_Update_Personal_Details_InvalidCookie"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Update_Personal_Details;
			params= params_Accounts_Service_Update_Personal_Details;
			headers = InvalidCookie();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("Account_Service_Update_Personal_Details_WithoutCookie"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Update_Personal_Details;
			params= params_Accounts_Service_Update_Personal_Details;
			headers = WithoutCookie();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_UserController_VerifyAccount"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_UserController_VerifyAccount;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Promotional_Service_RefreshStageConfig")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_RefreshStageConfig;
			params= params_Promotional_service_RefreshStageCinfig;
			headers = headersFormpromotionalgetConfigdetails();
			Reporter.log(url_Promotional_Service_domain+url);
		}
		else if(Type.equals("Promotional_Service_SavenudgeAPI"))
		{
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_SavenudgeAPI;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = headersFormpromotionalgetreferraldetails();
			Reporter.log(url_Promotional_Service_domain+url);
		}
		else if(Type.equals("Promotional_Service_Savenudge_InvalidCookie"))
		{
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_SavenudgeAPI;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = headersFormpromotionalgetreferraldetailsinvalid();
			Reporter.log(url_Promotional_Service_domain+url);
		}
		
		else if(Type.equals("Account_Service_MobileLoginUpdatePersonaldetailsApi"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_MobileLoginUpdatePersonaldetailsApi;
			params= params_Account_Service_MobileLoginUpdatePersonaldetailsApi;
			headers = headersFormsverifymobileloginupdatemobile_otp();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_UserController_VerifyAccount_UsernotPresent"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_UserController_VerifyAccount_UsernotPresent;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_People_UpdateUserRoles"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_People_UpdateUserRoles;
			params= params_Account_Service_People_UpdateUserRoles;
			headers = headersFormroles();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Flipkart_Accounts_service_Updateuser"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Flipkart_Accounts_service_Updateuser;
			params= params_Flipkart_Accounts_service_Updateuser;
			headers = headersFormflipkart();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("Account_Service_AuthforNonLoggedinUser"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthforNonLoggedinUser;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_AuthforNonLoggedinUser_HotelTrip"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthforNonLoggedinUser_HotelTrip;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_AuthforNonLoggedinUser_InvalidTripID"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthforNonLoggedinUser_InvalidTripID;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Account_Service_AuthforNonLoggedinUser_VerifyOTP"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthforNonLoggedinUser_VerifyOTP;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("Accounts_Service_VerifynonLoggedinUser"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Accounts_Service_VerifynonLoggedinUser;
			params= params_Account_Service_UserController_VerifyAccount;
			headers = verifyaccount();
			Reporter.log(url_Acct_Service+url);
		}

		else if(Type.equals("IdentityService_UpdatePassword_ForChangePasswordflow"))
		{
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_UpdatePassword_ForChangePasswordflow;
			params= params_IdentityService_UpdatePassword_ForChangePasswordflow;
			headers = IdentityService_UpdatePassword_ForChangePasswordflow();
			Reporter.log(url_Identitymicro_service+url);
		}

		else if(Type.equals("IdentityService_UpdatePassword_ForResetPasswordflow"))
		{
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_UpdatePassword_ForChangePasswordflow;
			params= params_IdentityService_UpdatePassword_ForResetPasswordflow;
			headers = IdentityService_UpdatePassword_ForResetPasswordflow();
			Reporter.log(url_Identitymicro_service+url);
		}

		Reporter.log("url  "+url);
		request = RestAssured.given().						
				when().
				log().all().
				body(params).
				headers(headers).
				put(url);
		return request;
	}
	public Response getCall(String Type, String Type1){

		RestAssured.baseURI =url_Acct;


		String url = null;

		String params =null;
		Response request = null;	
		HashMap<String, Object> headers = new HashMap<>();
		headers = headersForms1();
		if(Type.equals("AcctSanity")) {
			url = url_acctSanity;
		}


		if(Type.equals("AcctSanity_Prod")) {
			url = url_AcctSanity_Prod ;
		} 
		else if(Type.equals("healthCheck")) {				
			url = url_healthCheck;

		}

		else if(Type.equals("depositAccount_search")) {				
			url = url_depositAccount_search;
			headers=headersFormsdepositaccount();
		}




		else if(Type.equals("depositAccount_walletbalance_check")) {	


			RestAssured.baseURI =url_da;
			url = url_depositAccount_walletbalance_check;

		}
		else if(Type.equals("GstDetails")) {
			url = url_GSTDetails;
		}	

		else if(Type.equals("get_cfwoptinstatus")) {
			url = url_get_cfwoptinstatus;			
			headers = headersFormscfwoptinstatus();	

		}

		else if(Type.equals("peopleautocomplete")) {
			url = url_peopleautocomplete;			
			headers = headersFormscfwoptinstatus();	

		}


		else if(Type.equals("get_cfwgstdocstatus")) {
			url = url_get_cfwgstdocstatus;			
			headers = headersFormscfwoptinstatus();	

		}

		else if(Type.equals("apiConfig_APIkey")) {
			url =url_apiConfig_APIkey ;			
			headers = headersFormsapi_config();	

		}


		else if(Type.equals("CmpProfile")) {
			url = url_CmpProfile;
		}

		else if(Type.equals("CmpProfile_Prod")) {
			url = url_CmpProfile_Prod;
		}
		else if(Type.equals("FetchBank_Prod")) {
			url = url_FetchBank_Prod;
		}

		else if(Type.equals("GstDetails_Prod")) {
			url = url_GstDetails_Prod;
		}
		else if (Type.equals("Account_Service_LogOutAPI")) {
			RestAssured.baseURI = url_Acct_Service;
			url = url_logout;
			headers = LogoutAPI();
			Reporter.log(url_Acct_Service + url);
		}

		else if(Type.equals("AcctHealthtestURL_Prod")) {
			url = url_AcctHealthtestURL_Prod;

		}
		else if(Type.equals("Userclassification_Health_Test_Url"))
		{
			RestAssured.baseURI=url_userclassification;
			url = url_Userclassification_Health_Test_Url;
			headers = userclassification();
			Reporter.log(url_userclassification+url);
		}
		else if(Type.equals("Account_Service_Verify_Person"))
		{
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Verify_Person;
			headers = verifyperson();
			Reporter.log(url_Acct_Service+url);
		}
		else if(Type.equals("Userclassification_Userdetails_emailid"))
		{
			RestAssured.baseURI=url_userclassification;
			url = url_Userclassification_Userdetails_emailid;
			headers = userclassification();
			Reporter.log(url_userclassification+url);
		}

		else if(Type.equals("Userclassification_Gettripdetails_fromtripid"))
		{
			RestAssured.baseURI=url_userclassification;
			url = url_Userclassification_Gettripdetails_fromtripid;
			headers = userclassification();
			Reporter.log(url_userclassification+url);
		}

		else if(Type.equals("UserInfo_Prod")) {
			url = url_UserInfo_Prod;
		}

		else if(Type.equals("People_search_API_prod")) {
			url = url_People_search_API_prod;
		}

		else if(Type.equals("UserProfile_Json_Prod")) {
			url = url_UserProfile_Json_Prod;
		}


		else if(Type.equals("CompanyProfileRefresh_Prod")) {
			url = url_CompanyProfileRefresh_Prod;
		}

		else if(Type.equals("CompanyUsers_Prod")) {
			url = url_CompanyUsers_Prod;
		}
		else if(Type.equals("Company_vendormapping_prod")) {
			url = url_Company_vendormapping_prod;
		}

		else if(Type.equals("autocomplete_prod")) {
			url = url_autocomplete_prod;
			headers.put("AUTH_KEY", "7GHT#@D65yhgder4R");
		}

		else if(Type.equals("deposit_account_search_prod")) {
			url = url_deposit_account_search_prod;
			headers.put("AUTH_KEY", "weurimdjfoewpremkcuwpermauthkey");
		}
		else if(Type.equals("User_activestatus_prod")) {
			url = url_User_activestatus_prod;
		}



		else if(Type.equals("AcctSanity_Prod")) {
			url = url_AcctSanity_Prod;
		}
		else if(Type.equals("CmpConfig")) {
			url = url_CmpConfig;
		}

		else if(Type.equals("Cmpjsonfetch")) {
			url = url_Cmpjsonfetch;
		}
		else if(Type.equals("b2bcmpuserdetails")) {
			url = url_b2bcmpuserdetails;
		}


		else if(Type.equals("UserJson")) {
			url = url_UserJson;
		}
		else if(Type.equals("FetchProfile")) {
			url = url_FetchProfile;
		}
		else if(Type.equals("CmpRefresh")) {
			url = url_CmpRefresh;
		}
		else if(Type.equals("FetchBank")) {
			url = url_FetchBank;
		}
		else if(Type.equals("UserInfo")) {
			url = url_UserInfo;
		}
		else if(Type.equals("FetchCompany")) {
			url = url_FetchCompany;
		}
		else if(Type.equals("CompanyUsers")) {
			url = url_CompanyUsers;
		}
		else if(Type.equals("DepositAcctSearch")) {
			headers.put("AUTH_KEY", "weurimdjfoewpremkcuwpermauthkey");
			url = url_DepositAcctSearch;
		}
		else if(Type.equals("CompanyProfileRefresh")) {
			url = url_CompanyProfileRefresh;
		}
		else if(Type.equals("GenerateAPIKEY")) {
			url = url_GenerateAPIKEY;
		}
		else if(Type.equals("PersonJson")) {
			url = url_PersonJson; 
		}
		else if(Type.equals("PersonJsonID")) {
			url = url_PersonJsonID; 
		}
		else if (Type.equals("fetchWallet")){
			RestAssured.baseURI =url_Acct;
			url = url_fetchWallet;
		}
		else if (Type.equals("AcctHealthtestURL")){
			url = url_AccntHealthtest;
		}

		else if (Type.equals("partnercontroller_usersearch")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_partnercontroller_usersearch;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);

		}

		else if (Type.equals("Account_Service_Caching_Userprofilejson_Email")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Caching_Userprofilejson_Email;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);

		}

		else if (Type.equals("Account_Service_Caching_Userprofilejson_ID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Caching_Userprofilejson_ID;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);

		}

		else if (Type.equals("peoplecontroller_getuserbyemail")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_peoplecontroller_getuserbyemail;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("peoplecontroller_getuserbyid")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_peoplecontroller_getuserbyid;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);

		}
		else if (Type.equals("Account_Service_PWA_GetUserbyID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_PWA_GetUserbyID;
			headers = headersFormpwa();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_GST_AutoComplete")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GST_AutoComplete;
			headers = headersGSTAutoComplete();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_GST_AutoCompleteInvalid")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GST_AutoCompleteInvalid;
			headers = headersGSTAutoCompleteInvalid();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_FetchcompanyBy_depositaccountID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_FetchcompanyBy_depositaccountID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_Depositaccountsearch_WOTlinkedparam")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Depositaccountsearch_WOTlinkedparam;
			headers = headersFormdepoistwithoutlinkedparam();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_Depositaccountsearch_Withlinkedparam")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Depositaccountsearch_Withlinkedparam;
			headers = headersFormdepoistwithoutlinkedparam();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_GSTV2_SearchAPIwithGstNo_ID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GSTV2_SearchAPIwithGstNo_ID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_GSTV2_InvalidSearch")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_AS_GSTV2_InvalidSearch;
			headers = headersFormdepoist();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_GstSearch_WithoutSubString")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GstSearch_WithoutSubString;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPI_withDomainname")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPI_withDomainname;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPI_internalDomainSearch")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPI_internalDomainSearch;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPIwithTagID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPIwithTagID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPIwithTagID_UsersandTravellers")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPIwithTagID_UsersandTravellers;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanyConfig_GSTdetails")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanyConfig_GSTdetails;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanyConfig_GSTdetailswithDomainName")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanyConfig_GSTdetailswithDomainName;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanyConfig_GetCompanybyID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanyConfig_GetCompanybyID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_GetuserdetailsbyAPIKey")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GetuserdetailsbyAPIKey;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_AccountExitsAPI_Valid")){
			RestAssured.baseURI=url_prod;
			url = url_Accounts_Service_AccountExits;
			headers = headersFormAccountExits();
			Reporter.log(url_prod+url);
		}

		else if (Type.equals("Account_Service_AccountExitsAPI_InValid")){
			RestAssured.baseURI=url_prod;
			url = url_Accounts_Service_AccountExits_Invalid;
			headers = headersFormAccountExits();

			Reporter.log(url_prod+url);
		}
		
		else if (Type.equals("Accounts_Service_fetchuserdetails_withoutReferer")){
			RestAssured.baseURI=url_Acct_Service_gateway;
			url = url_Accounts_Service_fetchuserdetails_withoutReferer;
			headers = headersFormgateway();

			Reporter.log(url_Acct_Service+url);
		}
		
		else if (Type.equals("Accounts_Service_fetchuserdetails_withReferer")){
			RestAssured.baseURI=url_Acct_Service_gateway;
			url = url_Accounts_Service_fetchuserdetails_withoutReferer;
			headers = headersFormgatewayref();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanyConfig_GetCompanyConfigsbyID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanyConfig_GetCompanyConfigsbyID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanyVendorMapping")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanyVendorMapping;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CompanySearchAPIwithAPIkey")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CompanySearchAPIwithAPIkey;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_GstSearch_WithSubString")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GstSearch_WithSubString;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_MobileLogin_UserexistenceByMobileNo")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_MobileLogin_UserexistenceByMobileNo;
			headers = headersFormgetactivationkey();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_MobileLogin_FetchOldCTusersApi")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_MobileLogin_FetchOldCTusersApi;
			headers = headersFormsoldctusers();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_FetchCustomer_number")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_FetchCustomer_number;
			headers = headersFormgetactivationkey();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_CFW_GetUserStatus")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_CFW_GetUserStatus;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Flipkart_Accounts_service_GetUserDetails")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Flipkart_Accounts_service_GetUserDetails;
			headers = headersFormflipkart();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Flipkart_Accounts_service_GetUserDetailsBy_UserID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Flipkart_Accounts_service_GetUserDetailsBy_UserID;
			headers = headersFormflipkart();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Flipkart_Accounts_service_GetUserDetailsBy_UserID_withoutparams")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Flipkart_Accounts_service_GetUserDetailsBy_UserID_withoutparams;
			headers = headersFormflipkart();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Flipkart_Accounts_service_JWTtoken_flipkart")){
			RestAssured.baseURI=url_Acct_Service_applesgnin;
			url = url_Flipkart_Accounts_service_JWTtoken_flipkart;
			headers = headersFormgetactivationkey();

			Reporter.log(url_Acct_Service_applesgnin+url);
		}
		else if (Type.equals("Flipkart_Accounts_service_JWTtoken_Cleartrip")){
			RestAssured.baseURI=url_Acct_Service_applesgnin;
			url = url_Flipkart_Accounts_service_JWTtoken_Cleartrip;
			headers = headersFormgetactivationkey();

			Reporter.log(url_Acct_Service_applesgnin+url);
		}
		
		else if (Type.equals("Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams;
			headers = headersFormflipkart();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_Fetchdomain_nameByID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Fetchdomain_nameByID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_Company_DomainName_Autocomplete")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Company_DomainName_Autocomplete;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_GetActivationKey")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GetActivationKey;
			headers = headersFormgetactivationkey();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Promotional_Service_healthTestAPI")){
			RestAssured.baseURI=url_Promotional_Service;
			url = url_Promotional_Service_healthTestAPI;
			headers = headersFormpromotioanlhealth();

			Reporter.log(url_Promotional_Service+url);
		}
		else if (Type.equals("Promotional_Service_ValidatereferralLink")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_ValidatereferralLink;
			headers = headersFormpromotionalvalidate();

			Reporter.log(url_Promotional_Service_domain+url);
		}
		else if (Type.equals("Promotional_Service_ValidateInvalidReferralLink")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_ValidateInvalidReferralLink;
			headers = headersFormpromotionalvalidate();

			Reporter.log(url_Promotional_Service_domain+url);
		}
		else if (Type.equals("Promotional_Service_GetReferradetailsHQ")){
			RestAssured.baseURI=url_Promotional_Service;
			url = url_Promotional_Service_GetReferradetailsHQ;
			headers = headersFormpromotionalvalidate();

			Reporter.log(url_Promotional_Service_domain+url);
		}
		else if (Type.equals("Promotional_Service_GetReferradetailsAPI")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_GetReferradetailsAPI;
			headers = headersFormpromotionalgetreferraldetails();

			Reporter.log(url_Promotional_Service_domain+url);
		}

		else if (Type.equals("Promotional_Service_GetStageConfig")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_GetConfigAPI;
			headers = headersFormpromotionalgetConfigdetails();
			Reporter.log(url_Promotional_Service_domain+url);
		}

		else if (Type.equals("AS_Session_Status_Inactive_API")){

			RestAssured.baseURI=url_Acct_Service;
			url = url_Session_Status;
			headers = headersForSessionStatus();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_Session_Status_active_API")){

			RestAssured.baseURI=url_Acct_Service;
			url = url_Active_session_status;
			headers = headersForActiveSessionStatus();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_Session_Status_Invalid_API")){

			RestAssured.baseURI=url_Acct_Service;
			url = url_Active_session_status;
			headers = headersForSessionStatusInvalid();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_Fetch_details_api")){

			RestAssured.baseURI=qaurl;
			url = url_Fetch_details;
			headers = headersForFetchdetails();
			Reporter.log(qaurl+url);
		}

		else if (Type.equals("AS_SignOutAPI")){

			RestAssured.baseURI=url_Identitymicro_service;
			url = url_SignOut_Api;
			headers = headersForSignOutApi();
			Reporter.log(url_Identitymicro_service+url);
		}

		else if (Type.equals("AS_SignOutAPI_Invalid")){

			RestAssured.baseURI=url_Identitymicro_service;
			url = url_SignOut_Api;
			headers = headersForSignOutApiInvalid();
			Reporter.log(url_Identitymicro_service+url);
		}

		else if (Type.equals("AS_Fetch_details_api_Invalid")){

			RestAssured.baseURI=qaurl;
			url = url_Fetch_details;
			headers = headersForFetchdetailsInvalid();
			Reporter.log(qaurl+url);
		}

		else if (Type.equals("Promotional_Service_GetReferralhistory")){
			RestAssured.baseURI=url_Promotional_Service_domain;
			url = url_Promotional_Service_Getreferralhistory;
			headers = headersFormpromotionalgetConfigdetails();
			Reporter.log(url_Promotional_Service_domain+url);
		}


		else if (Type.equals("Promotional_Service_GetReferradetailsAPIwithRoutes")){
			RestAssured.baseURI=url_identity;
			url = url_Promotional_Service_GetReferradetailsAPI;
			headers = headersFormpromotionalgetreferraldetails();

			Reporter.log(url_identity+url);
		}
		else if (Type.equals("Account_Service_GET_UserbyCookie_CleartripUser")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GET_UserbyCookie_CleartripUser;
			headers = headersFormgetuserbycookie();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_AgencyLogo")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AgencyLogo;
			headers = headersFormgetagencylogo();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_GET_UserbyCookie_FlyinUser")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GET_UserbyCookie_CleartripUser;
			headers = headersFormgetuserbycookieflyin();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_UserExistence_withEmailIDandDomain")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_UserExistence_withEmailIDandDomain;
			headers = headersFormguserexistence();

			Reporter.log(url_Acct_Service+url);
		}
		else if (Type.equals("Account_Service_UserExistence_withID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_UserExistence_withID;
			headers = headersFormguserexistence();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_GSTV2_SearchAPIwithGstNoAndGstID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_GSTV2_SearchAPIwithGstNoAndGstID;
			headers = headersFormdepoist();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_Peoplecontroller_FindByID")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Peoplecontroller_FindByID;
			headers = headersFormpwa();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("Account_Service_AuthorizeAPI_encodingCookie")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthorizeAPI_encodingCookie;
			headers =Account_Service_AuthorizeAPI_encodingCookie();

			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_authorize_API_Invalid")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_AuthorizeAPI_encodingCookie;
			headers =Account_Service_AuthorizeAPI_encodingWithoutCookie();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_Get_Traveller_Details")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Get_Traveller_Details;
			headers =AS_Traveller_Details_with_Cookie();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("AS_Get_Traveller_Details_Invalid")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_Get_Traveller_Details;
			headers =AS_Traveller_Details_withOut_Cookie();
			Reporter.log(url_Acct_Service+url);
		}

		else if (Type.equals("IdentityService_ctAuth_noLoginCookie")){
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_ctAuth_noLoginCookie;
			headers = headersFormget_token_for_user();

			Reporter.log(url_Identitymicro_service+url);
		}


		else if (Type.equals("Account_Service_PWA_GetUser_Byemail")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_PWA_GetUser_Byemail;
			headers = headersFormpwaemail();
			Reporter.log(url_Acct_Service+url);

		}
		else if (Type.equals("Account_Service_EmailVerification_API")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_Account_Service_EmailVerification_API;
			headers = headersFormpwaemailverification ();
			Reporter.log(url_Acct_Service+url);

		}
		else if (Type.equals("IdentityService_PeopleController_gt_token_for_userBy_ID")){
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_PeopleController_gt_token_for_userBy_ID;
			headers = headersFormget_token_for_user();
			Reporter.log(url_Identitymicro_service+url);

		}

		else if (Type.equals("IdentityService_PeopleController_gt_token_for_userBy_Email")){
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_PeopleController_gt_token_for_userBy_Email;
			headers = headersFormget_token_for_user_flyin();
			Reporter.log(url_Identitymicro_service+url);

		}

		else if (Type.equals("IdentityService_PeopleController_gt_token_for_userBy_Private_EmailandID")){
			RestAssured.baseURI=url_Identitymicro_service;
			url = url_IdentityService_PeopleController_gt_token_for_userBy_Private_EmailandID;
			headers = headersFormget_token_for_user_flyin();
			Reporter.log(url_Identitymicro_service+url);

		}


		else if (Type.equals("peoplecontroller_getuserbyid_v2")){
			RestAssured.baseURI=url_Acct_Service;
			url = url_peoplecontroller_getuserbyid_v2;
			headers = headersFormscfwoptinstatus();
			Reporter.log(url_Acct_Service+url);

		}




		else if (Type.equals("apiConfig_APIkey")){
			url = url_apiConfig_APIkey;
		}


		else if (Type.equals("b2bgetTravelerURL")){
			url = url_b2bgetTravelerURL;
		}

		else if(Type.equals("FKVIP_GetBenefitDetails_API")) {
			headers = headersFormFKVIPInvalidRollBackAPI();
			RestAssured.baseURI =url_ingestion_Service_domain;
			url = url_FKVIP_GetBenefitDetails_API;
			Reporter.log(url_ingestion_Service_domain+url);

		}

		Reporter.log("url  "+url);
		request = RestAssured.given().						
				when().
				log().all().
				headers(headers).
				get(url);
		return request;
	}
	public ArrayList<String> db_TripTxn(String id) throws SQLException, ClassNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();
		{
			Class.forName("com.mysql.jdbc.Driver");
			String user = "cleartrip";
			String password = "1nterl3av3";
			String url = "jdbc:mysql:@//172.17.64.165:3306";
			String query =  "select * from person_traveller_details where person_id= '" + id +"'";
			Connection myCon = DriverManager.getConnection(url,user,password);
			if (myCon != null) {
				ResultSet myRes = myCon.createStatement().executeQuery(query);
				while (myRes.next() == true) {
					ResultSetMetaData result = myRes.getMetaData();
					int noOfColumns = result.getColumnCount();
					int noOfRows  = myRes.getRow();
					for (int x = 1; x <= noOfColumns; x++) {

						String colValue = myRes.getString(x);
						data.add(colValue);

					}
				}
				myCon.close();
			} else
				Reporter.log("DB Connection not established");
		}
		return data;
	}

	public void DBValidation_Txn(Response resp, String Status) throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Database validation Started");
		String Host = common.value("host");
		if(Host.equalsIgnoreCase("qa2")) {
			JsonPath jsonPathEvaluator = resp.jsonPath();
			String DBTripID = jsonPathEvaluator.getString("id");
			ArrayList<String> db_TripTxn = db_TripTxn(DBTripID);
			if(!db_TripTxn.get(0).equals(DBTripID)) {
				Reporter.log(" Trip details are not added in DB");
				Assert.assertTrue(false);
			}
			if(!db_TripTxn.get(1).equals(Status)) {
				Reporter.log(" Status is displayed as "+db_TripTxn.get(1));
				Assert.assertTrue(false);
			}
			Reporter.log("Database validation Passed");
		}
	}

	public void validation_user_update_MobileOTP(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=401) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_User_MobileNo_OTPValidaion")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("Wrong otp entered for user otpmobilenotest@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_MobileLogin_verifyOTP_SignIn")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_OTP")) {
				
				Assert.assertTrue(true);						
			}
			
			else if(!message.contains("NO_SAVED_OTP_FOUND"))
			{
				Assert.assertTrue(true);
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Cleartrip_ResetPassword")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("failed")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("IdentityService_Signin_Unauthorized")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("UNAUTHORIZED")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Accounts_Service_CleartripV2_Signin_Unauthorized")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("failed")) {
				Assert.assertTrue(false);						
			}
		}

		if(Type.equalsIgnoreCase("Accounts_Service_FLyinV2_Signin_Unauthorized")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("failed")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_RegisteredCltp_UserUpdate_WithoutOTP")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("Otp not passed for updating mobile number of user otpmobilenotest@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
		
		
		if(Type.equalsIgnoreCase("IdentityService_UpdatePassword_ForChangePasswordflow")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("OTP is not valid for email id : ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("IdentityService_UpdatePassword_ForResetPasswordflow")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("Mailer key is not valid for email id : ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
	}

	public void validation_user_update(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=202) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_User")) {
			String username = jsonPathEvaluator.getString("username");
			if(!username.contains("otpmobilenotest@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
		
		if(Type.equalsIgnoreCase("Account_Service_RegisterFLyinUserUpdate_WithoutOTP")) {
			if(!resp.body().asString().contains("65206329")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("otpmobilenotestfinal@flyin.com")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("11111111111")) {
				Assert.assertTrue(false);						
			}
			
		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_sendOTP_SIGNIN")) {
			String ReponseStr = resp.body().asString();

			String status = jsonPathEvaluator.getString("status");
			String action = jsonPathEvaluator.getString("action");

			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
			if(!action.contains("SIGNIN")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_sendOTP_UPDATE_MOBILE")) {
			String ReponseStr = resp.body().asString();

			String status = jsonPathEvaluator.getString("status");
			String action = jsonPathEvaluator.getString("action");

			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
			if(!action.contains("UPDATE_MOBILE")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_sendEmail_SIGNUP_MERGE")) {
			String ReponseStr = resp.body().asString();

			String status = jsonPathEvaluator.getString("status");
			String action = jsonPathEvaluator.getString("action");

			if(!status.contains("ACCEPTED")) {
				Assert.assertTrue(false);						
			}
			if(!action.contains("SIGNUP_MERGE")) {
				Assert.assertTrue(false);						
			}
		}
		
		if(Type.equalsIgnoreCase("Account_Service_RegisterFLyinUserUpdate_OTPValidation")) {
			if(!resp.body().asString().contains("otpmobilenotestfinal@flyin.com")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("88888888")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("65206329")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Update_User_Cleartrip_B2Buser")) {
			if(!resp.body().asString().contains("qaauto1584674982375@manit.agentbox.com")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("oioioioi")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("zzzzz")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("65199164")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Cleartrip_confirmedtravlerwithActivestatus")) {
			if(!resp.body().asString().contains("jabawi7018@990ys.com")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("ACTIVE_USER")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Mongo_CacheReset")) {
			if(!resp.body().asString().contains("Cache reset done")) {
				Assert.assertTrue(false);						
			}
			
		}
		if(Type.equalsIgnoreCase("Flipkart_Accounts_Service_CreateUser")) {
			String domain = jsonPathEvaluator.getString("domain");
			if(!domain.contains("www.flipkart.com")) {
				Assert.assertTrue(false);						
			}
			if(!resp.body().asString().contains("testingautomate")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("PASSPORTautomate")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("12345automate")) {
				Assert.assertTrue(false);						
			}
			/*String isRegistered = jsonPathEvaluator.getString("isRegistered");
			if(!isRegistered.contains("true")) {
				Assert.assertTrue(false);						
			}
			String docType = jsonPathEvaluator.getString("docType");
			if(!docType.contains("PASSPORT")) {
				Assert.assertTrue(false);						
			}
			String gstNumber = jsonPathEvaluator.getString("gstNumber");
			if(!gstNumber.contains("12345automatetest")) {
				Assert.assertTrue(false);						
			}*/
		}

		if(Type.equalsIgnoreCase("Accounts_Service_Cleartrip_MultipleTraveller_Updatecall")) {
			if(!resp.body().asString().contains("SITEISSUEStestinginqa")) {
				Assert.assertTrue(false);						
			}
			else if(!resp.body().asString().contains("okok")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_FLYIN_User_Update")) {
			String username = jsonPathEvaluator.getString("username");
			if(!username.contains("otpmobilenotestfinal@flyin.com")) {
				Assert.assertTrue(false);						
			}
		}


		else if(Type.equalsIgnoreCase("Accounts_Service_Flyin_DOCdetails_update")) {


			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("AUTOMATEDOC_REG")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("AUTOMATEDOC_NONREG")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Accounts_Service_FLyinUser_GSTdetailsUpdate")) {


			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("28SAILI1234H1Y")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("28SAILI1234H1SO")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Accounts_Service_DOCdetailsUpdate_cleartripuser")) {


			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("28SAILI1234H1SY")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("111111111")){
				Assert.assertTrue(false);
			}

		}
		if(Type.equalsIgnoreCase("Account_Service_ChangePassword")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("change password mail pushed to queue")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("IdentityService_ResetPassword")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("reset password mail pushed to queue")) {
				Assert.assertTrue(false);						
			}
		}
	}
	public void validation_Flipkart_existuser(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=403) {
			Assert.assertTrue(false);
		}
		if(Type.equalsIgnoreCase("Flipkart_Accounts_service_CreateUser_ExistingUser")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("User with referenceId nakultestqa and domain www.flipkart.com already exists")) {
				Assert.assertTrue(false);						
			}
		}

		if(Type.equalsIgnoreCase("Register_Failure")) {
			String message = jsonPathEvaluator.getString("message");
			if (!message.contains("User already exists for email : sessionm781@gmail.com on domain www.cleartrip.com: ")) {
				Assert.assertTrue(false);
			}
		}
	}

	public void validation_AppleRegister_NullEmail(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(Type.equalsIgnoreCase("Promotional_Service_ValidateInvalidReferralLink")||Type.equalsIgnoreCase("Account_Service_AuthforNonLoggedinUser_InvalidTripID")){
			System.out.println(statusCode);
			if (statusCode != 404) {
				Assert.assertTrue(false);
			}
		}
		else{
			if (statusCode != 401) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_AppleRegister_NullEmail")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("No user found with appleId : 1:a:2:b:3:00")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_UserController_VerifyAccount_UsernotPresent")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("User not found with id : 1402954698")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_AuthforNonLoggedinUser_VerifyOTP")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("otp verification failed -> not-found/expired/mismatch")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Promotional_Service_ValidateInvalidReferralLink")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_REFERRAL_LINK")) {
				Assert.assertTrue(false);						
			}
		}
		
		if(Type.equalsIgnoreCase("Accounts_service_Company_DeleteGST")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("GstDetail not found for, gstNumber : 123459898")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_AuthforNonLoggedinUser_InvalidTripID")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("Received status code 404 NOT_FOUND for trip ref Q210318852")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Accounts_service_Company_DeleteGST_CompanyID_DomainName")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("GstDetail not found for id : 123, gstNumber : hihi")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("IdentityService_Signin_UsernotPresent")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("UNAUTHORIZED")) {
				Assert.assertTrue(false);						
			}
		}
		else	if(Type.equalsIgnoreCase("Accounts_Service_VerifynonLoggedinUser")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("otp verification failed -> not-found/expired/mismatch")) {
				Assert.assertTrue(false);						
			}
		}	}


	public void validation_Apple_signin(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=409) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Account_Service_AppleSignin_uniqueId")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("Apple id unique constraint violated for private email : 123@privaterelay.appleid.com")) {
				Assert.assertTrue(false);						
			}
		}

		if(Type.equalsIgnoreCase("Accounts_Service_Applesignin_Unauthorized")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("Apple id unique constraint violated for personal email : hi7@hi.appleid.com")) {
				Assert.assertTrue(false);						
			}
		}
	}
	
	public void validationjwt(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=400) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Flipkart_Accounts_service_JWTtoken_Cleartrip")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("Partner CLEARTRIP not supported")) {
				Assert.assertTrue(false);						
			}
		}

		if(Type.equalsIgnoreCase("FK_Redirection_Invalid_request")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_REQUEST")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Promotional_Service_GenerateReferralLink_InvalidAuth")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_COOKIE_SESSION")) {
				Assert.assertTrue(false);						
			}
		}

		if(Type.equalsIgnoreCase("Promotional_Service_Savenudge_InvalidCookie")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_COOKIE_SESSION")) {
				Assert.assertTrue(false);						
			}
		}
		
		
	}

	public void validation_Linkdepositaccount(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=201) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Account_Service_LinkDepositAccount")) {
			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Company_AddGSTwith_DomainName")) {
			String id = jsonPathEvaluator.getString("id");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");
			String gstHolderName = jsonPathEvaluator.getString("gstHolderName");
			String linkableType = jsonPathEvaluator.getString("linkableType");
			String createdAt = jsonPathEvaluator.getString("createdAt");
			if(!id.contains("12438")) {
				Assert.assertTrue(false);						
			}
			if(!gstNumber.contains("1domainautomat")) {
				Assert.assertTrue(false);						
			}
			if(!gstHolderName.contains("okdomainautomation")) {
				Assert.assertTrue(false);						
			}
			if(!linkableType.contains("Company")) {
				Assert.assertTrue(false);						
			}
			if(!createdAt.contains("1621841696000")) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Company_AddGSTwith_CompanyID")) {
			String id = jsonPathEvaluator.getString("id");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");
			String gstHolderName = jsonPathEvaluator.getString("gstHolderName");
			String linkableType = jsonPathEvaluator.getString("linkableType");
			String createdAt = jsonPathEvaluator.getString("createdAt");
			if(!id.contains("12440")) {
				Assert.assertTrue(false);						
			}
			if(!gstNumber.contains("1domainautomat")) {
				Assert.assertTrue(false);						
			}
			if(!gstHolderName.contains("okdomainautomation")) {
				Assert.assertTrue(false);						
			}
			if(!linkableType.contains("Company")) {
				Assert.assertTrue(false);						
			}
			if(!createdAt.contains("1621846955000")) {
				Assert.assertTrue(false);						
			}
		}



		if(Type.equalsIgnoreCase("Account_Service_Company_AddGSTwith_CompanyID_DomainName")) {
			String id = jsonPathEvaluator.getString("id");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");
			String gstHolderName = jsonPathEvaluator.getString("gstHolderName");
			String linkableType = jsonPathEvaluator.getString("linkableType");
			String createdAt = jsonPathEvaluator.getString("createdAt");
			if(!id.contains("12440")) {
				Assert.assertTrue(false);						
			}
			if(!gstNumber.contains("1domainautomat")) {
				Assert.assertTrue(false);						
			}
			if(!gstHolderName.contains("okdomainautomation")) {
				Assert.assertTrue(false);						
			}
			if(!linkableType.contains("Company")) {
				Assert.assertTrue(false);						
			}
			if(!createdAt.contains("1621846955000")) {
				Assert.assertTrue(false);						
			}
		}


	}
	public void validation_Apple_signin_entity(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if(statusCode!=422) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Account_Service_AppleSignin_Entity")) {
			String username = jsonPathEvaluator.getString("message");
			if(!username.contains("Another entity already exists with private email sai@privaterelay.appleid.com, can't proceed with the request")) {
				Assert.assertTrue(false);						
			}
		}
	}

	public void validation_Register(Response resp, String Type, String Type2) {
		Reporter.log("Response body " + Type + " : " + resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();
		if (statusCode != 500) {
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("Register_incompete")) {

			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("Something went wrong")) {
				Assert.assertTrue(false);
			}
		}
	}
	public Response validation(Response resp, String Type, String Type2){
		Reporter.log("Response body "+Type +" : "+ resp.body().asString());
		//System.out.println("Response body "+Type +" : "+ resp.body().asString());
		int statusCode = resp.getStatusCode();
		//int statusCode1 = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(Type.equals("FKVIP_InValid_RedeemAPI")||Type.equals("FKVIP_ActiveEntity_Invalid_API")||Type.equals("Floater_Get_FloaterBy_SlotID_Invalid")||Type.equals("Floater_Get_FloaterBy_SlotID_WithoutHeader")||Type.equals("Floater_Add_Template_InvalidAPI")||Type.equals("Floater_Add_Template_DuplicateAPI")||Type.equals("Floater_Add_Template_WithoutBody")||Type.equals("Account_Service_Update_Personal_Details_InvalidCookie")||Type.equals("Account_Service_Update_Personal_Details_WithoutCookie")||Type.equals("Account_Service_Update_GST_Details_InValidGST")||Type.equals("Account_Service_Update_GST_Details_WithoutCookie")||Type.equals("Account_Service_Update_GST_Details_InvalidCookie")||Type.equals("AS_Fetch_details_api_Invalid")||Type.equals("AS_Session_Status_Invalid_API")||Type.equals("AS_SignOutAPI_Invalid")||Type.equals("AS_GST_AutoCompleteInvalid")||Type.equals("AS_GSTV2_InvalidSearch")||Type.equals("AS_authorize_API_Invalid")||Type.equals("AS_Get_Traveller_Details_Invalid")||Type.equals("AS_Update_Traveller_Details_Invalid")||Type.equals("AS_Create_Ctauth_MissingCaller")||Type.equals("AS_Update_UserJsonInvalid"))
		{
			 if(statusCode!=400) {
				System.out.println(statusCode);
				Assert.assertTrue(false);
			}

		}
		else if(statusCode!=200){
			System.out.println(statusCode);
			Assert.assertTrue(false);
		}

		if(Type.equalsIgnoreCase("AS_Update_UserJsonInvalid")) {

			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("Neither email id or user id or combination of countryCode and mobile is provided to proceed")) {
				Assert.assertTrue(false);
			}
		}




		if(Type.equalsIgnoreCase("AS_Create_Ctauth_MissingCaller")) {

			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("Required request header 'caller' for method parameter type String is not present")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_update_contact_data")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("userId");
			System.out.println(message);
			if(!message.contains("65214024")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_Update_Traveller_Details")) {
			System.out.println(statusCode);
			String id = jsonPathEvaluator.getString("id");
			System.out.println(id);
			if(!id.contains("65269533")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_Update_Traveller_Details_Invalid")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("COOKIE_NOT_FOUND")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_authorize_API_Invalid")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("Required cookie 'ct-auth' for method parameter type String is not present")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_Get_Traveller_Details_Invalid")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("cookie not found")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_Get_Traveller_Details")) {
			System.out.println(statusCode);
			String id = jsonPathEvaluator.getString("id");
			System.out.println(id);
			if(!id.contains("65236122")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("flyinsigninV2")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("success")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_update_company_profile")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("id");
			System.out.println(message);
			if(!message.contains("131304")) {
				Assert.assertTrue(false);
			}
		}


		if(Type.equalsIgnoreCase("AS_AccountMerge_API")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("enqueued");
			System.out.println(message);
			if(!message.contains("true")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_WalletMerge_API")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("enqueued");
			System.out.println(message);
			if(!message.contains("true")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_GST_Details_InValidGST")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("INVALID_REQUEST")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_AccountExitsAPI_Valid")) {

			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}
		if(Type.equalsIgnoreCase("Account_Service_Update_GST_Details_InvalidCookie")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("INVALID_COOKIE_PASSED")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_GST_Details")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("id");
			String number = jsonPathEvaluator.getString("gstNumber");
			System.out.println(message);
			System.out.println(number);
			if(!message.contains("21257")) {
				Assert.assertTrue(false);
			}
			if(!number.contains("29AAAAA1111A1A0")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_GST_Details_WithoutCookie")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("cookie not found")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FkVIP_Injest_Profile")) {
			System.out.println(statusCode);
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FK_Redirection")) {
			System.out.println(statusCode);
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("success")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_Personal_Details")) {
			System.out.println(statusCode);
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_Personal_Details_WithoutCookie")) {
			System.out.println(statusCode);

			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("cookie not found")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Account_Service_Update_Personal_Details_InvalidCookie")) {
			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("INVALID_COOKIE_PASSED")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FK_Injest_ProfileExpiry")) {
			System.out.println(statusCode);
			if(statusCode!=200) {
				Assert.assertTrue(false);
			}
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Add_Template_API")) {

			String Res = resp.body().asString();
			System.out.println(Res);
			if(!Res.contains("successfully added the template")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Add_Template_DuplicateAPI")) {

			String message = jsonPathEvaluator.getString("message");
			System.out.println(message);
			if(!message.contains("template already present")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Add_Template_InvalidAPI")) {

			String error = jsonPathEvaluator.getString("error");
			System.out.println(error);
			if(!error.contains("Bad Request")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Add_Template_WithoutBody")) {

			String error = jsonPathEvaluator.getString("error");
			System.out.println(error);
			if(!error.contains("Bad Request")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Get_FloaterBy_SlotID_WithoutHeader")) {

			String error = jsonPathEvaluator.getString("error");
			System.out.println(error);
			if(!error.contains("Bad Request")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Get_FloaterBy_SlotID_Invalid")){

			String error = jsonPathEvaluator.getString("error");
			System.out.println(error);
			if(!error.contains("Bad Request")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Get_FloaterBy_SlotID")){

			String slotId = jsonPathEvaluator.getString("slotId");
			System.out.println(slotId);
			if(!slotId.contains("air_pwa_home_page")) {
				Assert.assertTrue(false);
			}
			if(!slotId.contains("air_pwa_home")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_Get_FloaterBy_SlotID_WithNewbody")){

			String slotId = jsonPathEvaluator.getString("slotId");
			System.out.println(slotId);
			if(!slotId.contains("air_pwa_home_page")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("Floater_SaveImpression_API")){

			String ReponseStr = resp.body().asString();
			System.out.println(ReponseStr);
			if(!ReponseStr.contains("successfully added the impression")) {
				Assert.assertTrue(false);
			}
		}



		if(Type.equalsIgnoreCase("FKVIP_Discovery_API")) {

			String message = jsonPathEvaluator.getString("userId");
			String activeCohorts = jsonPathEvaluator.getString("response.activeCohorts");
			String campaignId = jsonPathEvaluator.getString("response.cohortBenefitMap.MYNTRA_ICON_V1.campaignId");
			if(!message.contains("191121006")) {
				Assert.assertTrue(false);
			}
			if(!activeCohorts.contains("MYNTRA_ICON_V1"))
			{
				Assert.assertTrue(false);
			}
			if(!campaignId.contains("CAMPID_MYNTRA_ICON_HOTEL_001"))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_Discovery_API_WithOutFilter")) {

			String message = jsonPathEvaluator.getString("userId");
			String activeCohorts = jsonPathEvaluator.getString("response.activeCohorts");
			if(!message.contains("191121006")) {
				Assert.assertTrue(false);
			}
			if(!activeCohorts.contains("MYNTRA_ICON_V1"))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_Valid_RedeemAPI")) {

			benefitRedemptionId = jsonPathEvaluator.getInt("response.benefitRedemptionId");
			System.out.println(benefitRedemptionId);
			String status = jsonPathEvaluator.getString("response.status");
			if(!status.contains("SUCCESS"))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_Valid_RollBackAPI")) {

			System.out.println(benefitRedemptionId);
			String status = jsonPathEvaluator.getString("response.status");
			if(!status.contains("SUCCESS"))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_InValid_RedeemAPI")) {

		  String errormessage = jsonPathEvaluator.getString("errorResponse.errorMessage");
			if(!errormessage.contains("benefitId must not be blank"))
			{
				Assert.assertTrue(false);
			}
		}



		if(Type.equalsIgnoreCase("FKVIP_InValid_RollBackAPI")) {

			String status = jsonPathEvaluator.getString("response.status");
			System.out.println(status);
			String description = jsonPathEvaluator.getString("response.description");
			System.out.println(description);
			if(!status.contains("FAILURE"))
			{
				Assert.assertTrue(false);
			}
			if(!description.contains("The benefit has already been rolled back."))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_GetBenefitDetails_API")) {
			String cohortName = jsonPathEvaluator.getString("cohortName[0]");
			String status = jsonPathEvaluator.getString("status[0]");
			System.out.println(cohortName);
			System.out.println(status);
			if(!cohortName.contains("FLIPKART_VIP_V1"))
			{
				Assert.assertTrue(false);
			}
			if(!status.contains("SUCCESS"))
			{
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("FKVIP_ActiveEntity_API")) {

			String entityName = jsonPathEvaluator.getString("response.entities.entityName");
			String cohortName1 = jsonPathEvaluator.getString("response.entities.cohortDetails[0].cohortName[0]");
			String cohortName2 = jsonPathEvaluator.getString("response.entities.cohortDetails[0].cohortName[1]");
			System.out.println(entityName);
			System.out.println(cohortName1);
			System.out.println(cohortName2);
			if(!entityName.contains("Myntra"))
			{
				Assert.assertTrue(false);
			}
			if(!cohortName1.contains("MYNTRA_ICON_V1"))
			{
				Assert.assertTrue(false);
			}
			if(!cohortName2.contains("MYNTRA_ELITE_V1"))
			{
				Assert.assertTrue(false);
			}

		}

		if(Type.equalsIgnoreCase("FKVIP_ActiveEntity_Invalid_API")) {

			String errorMessage = jsonPathEvaluator.getString("errorResponse.errorMessage");
			System.out.println(errorMessage);
			if(!errorMessage.contains("requestId must not be blank"))
			{
				Assert.assertTrue(false);
			}

		}

		if(Type.equalsIgnoreCase("TripID")) {
			String trips = jsonPathEvaluator.getString("trips");
			if(!trips.contains("trip_id")) {
				Assert.assertTrue(false);						
			}
		}else if(Type.equalsIgnoreCase("Mobile")) {
			if(!resp.body().asString().contains("trip_id")) {
				Assert.assertTrue(false);						
			}
		}
		else if (Type.equalsIgnoreCase("Account_Service_LogOutAPI")) {
			if (!resp.body().asString().contains("65255898")) {
				Assert.assertTrue(false);
			}
		}else if(Type.equalsIgnoreCase("Date")) {
			if(!resp.body().asString().contains("trip_id")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("IdentityService_RecaptchaAPI")) {
			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("FAILURE")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("depositAccount_search")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("200")) {
				Assert.assertTrue(false);						
			}
			if(!resp.body().asString().contains("deposit_account_details")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("Identity_service_RecaptchaAPI")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("FAILURE")) {
				Assert.assertTrue(false);						
			}
			if(!resp.body().asString().contains("trace")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CFW_StatusUpdateCall")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_Express_Checkout")) {

			String message = jsonPathEvaluator.getString("message");

			if(!message.contains("Express checkout flag changed successfully")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("Account_Service_CreateWalletAPI")) {

			String message = jsonPathEvaluator.getString("message");

			if(!message.contains("Wallet created successfully")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_SendOTP_ToUsermobileNo")) {
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("sms is queued")) {
				Assert.assertTrue(false);						
			}
			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_NudgePersonaldetails")) {
			
			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}

		}
		

		else if(Type.equalsIgnoreCase("Account_Service_AppleSignin")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("appleidt50chars@privaterelay.appleid.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_FetchContactData")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("9748857284")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("2242950001")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("9821050033")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_FetchPersonalData")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("sesidhartestflyinctuser@gmail.com")){
				Assert.assertTrue(false);
			}
			/*if(!ReponseStr.contains("saisains.likhitha@cleartrip.com")){
				Assert.assertTrue(false);
			}*/
			if(!ReponseStr.contains("sai@privaterelay.appleid.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_AppleSignin_WrapperAPI")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("nakul@gmail.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("65206686")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("depositAccount_walletbalance_check")) {

			String credit_limit = jsonPathEvaluator.getString("credit_limit");
			String balance_type= jsonPathEvaluator.getString("balance_type");
			if(!credit_limit.contains("500000.0")) {
				Assert.assertTrue(false);						
			}
			if(!balance_type.contains("DR"))
			{

				Assert.assertTrue(false);
			}
		}


		else if(Type.equalsIgnoreCase("CreateWallet")) {
			String status = jsonPathEvaluator.getString("status");
			String message = jsonPathEvaluator.getString("message");
			if(!status.contains("Successful")) {
				Assert.assertTrue(false);						
			}
			if(!message.contains("Wallet created successfully")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("AcctSanity")) {
			String create_user = jsonPathEvaluator.getString("create_user");
			System.out.println(create_user);
			String signinPassword = jsonPathEvaluator.getString("signin_with_right_password");
			String fetch_user_profile = jsonPathEvaluator.getString("fetch_user_profile");
			//String delete_user = jsonPathEvaluator.getString("delete_user");
			if(!create_user.contains("true")) {
				Assert.assertTrue(false);						
			}
			if(!signinPassword.contains("true")) {
				Assert.assertTrue(false);						
			}
			if(!fetch_user_profile.contains("true")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("AcctSanity_Prod")) {
			String create_user = jsonPathEvaluator.getString("create_user");
			String signinPassword = jsonPathEvaluator.getString("signin_with_right_password");
			String fetch_user_profile = jsonPathEvaluator.getString("fetch_user_profile");
			//String delete_user = jsonPathEvaluator.getString("delete_user");
			if(!create_user.contains("true")) {
				Assert.assertTrue(false);						
			}
			if(!signinPassword.contains("true")) {
				Assert.assertTrue(false);						
			}
			if(!fetch_user_profile.contains("true")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("Userclassification_Gettripdetails_fromtripid")) {
			String id = jsonPathEvaluator.getString("id");
			String tripId = jsonPathEvaluator.getString("tripId");
			String emailId = jsonPathEvaluator.getString("emailId");
			//String delete_user = jsonPathEvaluator.getString("delete_user");
			if(!id.contains("13307715")) {
				Assert.assertTrue(false);						
			}
			if(!tripId.contains("Q200102680486")) {
				Assert.assertTrue(false);						
			}
			if(!emailId.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Userclassification_Userdetails_emailid")) {
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("4962816")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("test@cleartrip.com")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("flyinsigninV2_CleartripUser")) {
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("14029546")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Promotional_Service_GenerateReferralLink")) {
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("referralLink")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("\"https:")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("linkStatus")) {
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Promotional_Service_SavenudgeAPI")) {
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("status")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}

		}
		
		else if(Type.equalsIgnoreCase("Account_Service_FlyinV2_Signin_FlyinUser")) {
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("65180937")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("flyinctuser@gmail.com")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("AcctHealthtestURL")) {
			String app = jsonPathEvaluator.getString("app");
			String db = jsonPathEvaluator.getString("db");
			String redis = jsonPathEvaluator.getString("redis");

			if(!app.contains("200")) {
				Assert.assertTrue(false);						
			}
			if(!db.contains("200")) {
				Assert.assertTrue(false);						
			}
			if(!redis.contains("200")) {
				Assert.assertTrue(false);						
			}

		}


		else if(Type.equalsIgnoreCase("Userclassification_Health_Test_Url")) {
			String status = jsonPathEvaluator.getString("status");


			if(!status.contains("UP")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_Verify_Person")) {
			String verified = jsonPathEvaluator.getString("verified");
			String message = jsonPathEvaluator.getString("message");


			if(!verified.contains("true")) {
				Assert.assertTrue(false);						
			}
			if(!message.contains("person belongs to the given company")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_UserController_VerifyAccount")) {
			String status = jsonPathEvaluator.getString("status");



			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("Account_Service_People_UpdateUserRoles")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("Finance - Refund")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("87321")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("10000")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("3863174")){
				Assert.assertTrue(false);
			}


		}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_Updateuser")) {
			String referenceId = jsonPathEvaluator.getString("referenceId");

			if(!referenceId.contains("me123testing")) {
				Assert.assertTrue(false);						
			}
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("automationtest2")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("automationtest")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("12automation")) {
				Assert.assertTrue(false);						
			}


		}


		else if(Type.equalsIgnoreCase("Account_Service_AuthforNonLoggedinUser")) {
			String emailSent = jsonPathEvaluator.getString("emailSent");

			if(!emailSent.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("sms is queued")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_AuthforNonLoggedinUser_HotelTrip")) {
			String emailSent = jsonPathEvaluator.getString("emailSent");

			if(!emailSent.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}
			String tripRef = jsonPathEvaluator.getString("tripRef");

			if(!tripRef.contains("Q210929161450")) {
				Assert.assertTrue(false);						
			}
			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("sms is queued")) {
				Assert.assertTrue(false);						
			}


		}


		else if(Type.equalsIgnoreCase("partnercontroller_usersearch")) {
			String emailId = jsonPathEvaluator.getString("emailId");
			String id = jsonPathEvaluator.getString("id");
			/*if(!emailId.contains("test@flyin.com")) {
				Assert.assertTrue(false);						
			}*/
			if(!id.contains("65150509")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("Account_Service_Caching_Userprofilejson_Email")) {
			String username = jsonPathEvaluator.getString("username");
			//String id = jsonPathEvaluator.getString("id");
			if(!username.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
			/*if(!id.contains("65150509")) {
				Assert.assertTrue(false);						
			}*/



		}

		else if(Type.equalsIgnoreCase("Account_Service_Caching_Userprofilejson_ID")) {
			String username = jsonPathEvaluator.getString("username");
			//String id = jsonPathEvaluator.getString("id");
			if(!username.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}




		}

		else if(Type.equalsIgnoreCase("peoplecontroller_getuserbyemail")) {

			String emailId = jsonPathEvaluator.getString("emailId");

			if(!emailId.contains("kirti.pandey@cleartrip.com")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("peoplecontroller_getuserbyid")) {

			String emailId = jsonPathEvaluator.getString("emailId");

			if(!emailId.contains("test@flyin.com")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("Account_Service_PWA_GetUserbyID")) {

			String id = jsonPathEvaluator.getString("id");
			if(!id.contains("14029546")) {
				Assert.assertTrue(false);						
			}
		}


		else if(Type.equalsIgnoreCase("AS_GST_AutoComplete")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("12UIOJFEINJU376")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_GST_AutoCompleteInvalid")) {

			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("INVALID_REQUEST")) {
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Account_Service_FetchcompanyBy_depositaccountID")) {

			String domainName = jsonPathEvaluator.getString("domainName");

			if(!domainName.contains("nidhishct.cleartripforbusiness.com")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_Depositaccountsearch_WOTlinkedparam")) {

			String id = jsonPathEvaluator.getString("id");

			if(!id.contains("46207144")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_Depositaccountsearch_Withlinkedparam")) {

			String id = jsonPathEvaluator.getString("id");

			if(!id.contains("44605354")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_GSTV2_SearchAPIwithGstNo_ID")) {

			String id = jsonPathEvaluator.getString("id");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");

			if(!id.contains("20558")) {
				Assert.assertTrue(false);						
			}
			if(!gstNumber.contains("29AAAAA0000A1Z5")) {
				Assert.assertTrue(false);						
			}
		}



		else if(Type.equalsIgnoreCase("AS_GSTV2_InvalidSearch")) {

			String message = jsonPathEvaluator.getString("message");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");
			if(!message.contains("No query criteria matched for fetching gst details")) {
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Account_Service_GstSearch_WithoutSubString")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("26ALOEMXLUGQ991")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("33SAXLXFLEBV762")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPI_withDomainname")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("65211666")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("90608019")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPI_internalDomainSearch")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("21846")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("MOBILE_HOTEL_ENABLE")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("ssfsdf")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPIwithAPIkey_Companyusersandtravelers")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("11033501")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("9972137111")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("nighttrader.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPIwithTagID")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("185784-Test1472454788042")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("44200022")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("AMADEUS_CORP_DEAL_CODE")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("automationqa2ae.cleartripforbusiness.ae")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPIwithTagID_UsersandTravellers")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("41643014")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("44200022")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("41637132")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("automationqa2ae.cleartripforbusiness.ae")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanyConfig_GSTdetails")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("300947")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("COMPANY_SCREEN_NAME")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("11961")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("12378")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("qa2.cleartrip.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanyConfig_GSTdetailswithDomainName")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("5986700")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("PRIVACY_LINK")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("gstDetails")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("Amex.co.in")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("qa.amexindiatravel.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanyConfig_GetCompanybyID")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("110340")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("www.cleartrip.com")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("Finance-Legal")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("ssfsdf")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_GetuserdetailsbyAPIKey")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("14029546")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("65211666")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("1234567890")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("28SAILI1234H1Z1")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("XXXXXXXXXXXX2346")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Accounts_Service_fetchuserdetails_withoutReferer")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("nakul.goyal@cleartrip.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("90639452")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("65200719")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("110340")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("ACTIVE_USER")){
				Assert.assertTrue(false);
			}

		}
		
		else if(Type.equalsIgnoreCase("Account_Service_CompanyConfig_GetCompanyConfigsbyID")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("181")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("stulz.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("RETAIL_DISCOUNT_AMOUNT")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("CORP_PTA_ENABLED")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanyVendorMapping")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("162")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("vendor 2")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("196440")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("10842032")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_CompanySearchAPIwithAPIkey")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("nighttrader")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("9972137111")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("nighttrader.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_GstSearch_WithSubString")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("7GZZMRHXKNT243")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("7UIWVTEXIDT299")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_UserexistenceByMobileNo")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}

			
		}
		else if(Type.equalsIgnoreCase("Account_Service_MobileLogin_FetchOldCTusersApi")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("meetsureshonline@yahoo.com")){
				Assert.assertTrue(false);
			}

			if(!ReponseStr.contains("sudhakarannajirao@yahoo.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("dines.srivastava@target.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_FetchCustomer_number")) {

			String customerNumber = jsonPathEvaluator.getString("customerNumber");

			if(!customerNumber.contains("CUST01090")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_CFW_GetUserStatus")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("ENABLED")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_GetUserDetails")) {
			String ReponseStr = resp.body().asString();
			String referenceId = jsonPathEvaluator.getString("referenceId");

			if(!referenceId.contains("me123testing8")) {
				Assert.assertTrue(false);						
			}


			if(!ReponseStr.contains("testing")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("2345")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("12345")) {
				Assert.assertTrue(false);						
			}



		}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_GetUserDetailsBy_UserID")) {
			String ReponseStr = resp.body().asString();
			String referenceId = jsonPathEvaluator.getString("referenceId");

			if(!referenceId.contains("me123testing8")) {
				Assert.assertTrue(false);						
			}


			if(!ReponseStr.contains("testing")) {
				Assert.assertTrue(false);						
			}

			if(!ReponseStr.contains("PASSPORT")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("12345")) {
				Assert.assertTrue(false);						
			}



		}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_GetUserDetailsBy_UserID_withoutparams")) {
			String ReponseStr = resp.body().asString();
			String referenceId = jsonPathEvaluator.getString("referenceId");

			if(!referenceId.contains("me123testing8")) {
				Assert.assertTrue(false);						
			}

			String travellerDetails = jsonPathEvaluator.getString("travellerDetails");
			if((travellerDetails !=null)) {
				Assert.assertTrue(false);						
			}
			String gstDetails = jsonPathEvaluator.getString("gstDetails");
			if((gstDetails !=null)) {
				Assert.assertTrue(false);						
			}





		}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_JWTtoken_flipkart")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("token")){
				Assert.assertTrue(false);
			}

	}
		else if(Type.equalsIgnoreCase("Flipkart_Accounts_service_GetUserDetailsBy_ReferenceID_withoutparams")) {
			String ReponseStr = resp.body().asString();
			String referenceId = jsonPathEvaluator.getString("referenceId");

			if(!referenceId.contains("me123testing8")) {
				Assert.assertTrue(false);						
			}

			String travellerDetails = jsonPathEvaluator.getString("travellerDetails");
			if((travellerDetails !=null)) {
				Assert.assertTrue(false);						
			}
			String gstDetails = jsonPathEvaluator.getString("gstDetails");
			if((gstDetails !=null)) {
				Assert.assertTrue(false);						
			}





		}
		else if(Type.equalsIgnoreCase("Account_Service_Fetchdomain_nameByID")) {

			String domainName = jsonPathEvaluator.getString("domainName");

			if(!domainName.contains("expedia.travelbox99.com")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_Company_DomainName_Autocomplete")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("test12347653.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("test.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("testcleartrp.cleartripforbusiness.com")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_GetActivationKey")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("key")){
				Assert.assertTrue(false);
			}
			


		}
		else if(Type.equalsIgnoreCase("Promotional_Service_healthTestAPI")) {

			String ReponseStr = resp.body().asString();
			String status = resp.body().asString();
			if(!status.contains("UP")){
				Assert.assertTrue(false);
			}
		
		}
		else if(Type.equalsIgnoreCase("Promotional_Service_ValidatereferralLink")) {

			String ReponseStr = resp.body().asString();
			String linkStatus = resp.body().asString();
			if(!linkStatus.contains("ACTIVE")){
				Assert.assertTrue(false);
			}
		
		}
		else if(Type.equalsIgnoreCase("Promotional_Service_GetReferradetailsHQ")) {

			String ReponseStr = resp.body().asString();
			
			if(!ReponseStr.contains("referralKey")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("signUpCount")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("referralStatus")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("referralStartTime")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("referralEndTime")) {
				Assert.assertTrue(false);						
			}
			/*String referralKey = resp.body().asString();
			if(!referralKey.contains("kJ7ccGMR")){
				Assert.assertTrue(false);
			}
			String signUpCount = resp.body().asString();
			if(!signUpCount.contains("5")){
				Assert.assertTrue(false);
			}
			String referralStatus = resp.body().asString();
			if(!referralStatus.contains("SUCCESS")){
				Assert.assertTrue(false);
			}*/
			
		
		}
		else if(Type.equalsIgnoreCase("Promotional_Service_GetReferradetailsAPI")) {

			String ReponseStr = resp.body().asString();
			String referralSignupRewardAmount = resp.body().asString();
			if(!referralSignupRewardAmount.contains("100")){
				Assert.assertTrue(false);
			}
			String resultViewed = resp.body().asString();
			if(!resultViewed.contains("false")){
				Assert.assertTrue(false);
			}
			String rewardValue = resp.body().asString();
			if(!rewardValue.contains("50.0")){
				Assert.assertTrue(false);
			}
			
		
		}

		else if(Type.equalsIgnoreCase("Promotional_Service_GetStageConfig")) {

			String ReponseStr = resp.body().asString();
			String milestoneType = resp.body().asString();
			if(!milestoneType.contains("REFERRAL")){
				Assert.assertTrue(false);
			}
			String rewardValue = resp.body().asString();
			if(!rewardValue.contains("50.0")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Promotional_Service_GetReferralhistory")) {

			String referralStatus = resp.body().asString();
			if(!referralStatus.contains("SUCCESS")){
				Assert.assertTrue(false);
			}
			String signUpCount = resp.body().asString();
			if(!signUpCount.contains("6")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_Fetch_details_api")) {

			String id = jsonPathEvaluator.getString("id");
			String mobile = jsonPathEvaluator.getString("mobile");
			if(!id.contains("65269377")){
				Assert.assertTrue(false);
			}
			if(!mobile.contains("1324152002"))
			{
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_Session_Status_Inactive_API")) {

			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("false")) {
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_Session_Status_Active_API")) {

			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("true")) {
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_Session_Status_Invalid_API")) {

			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("cookie not found")) {
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_Fetch_details_api_Invalid")) {


			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("cookie not found")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_SignOutAPI")) {

			String message = jsonPathEvaluator.getString("redirectUrl");
			if(!message.contains("https://qa2new.cleartrip.com/")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("AS_SignOutAPI_Invalid")) {

			String message = jsonPathEvaluator.getString("status");
			if(!message.contains("BAD_REQUEST")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Promotional_Service_RefreshStageConfig")) {

			String ReponseStr = resp.body().asString();

			if(!ReponseStr.contains("SUCCESS")) {
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_GET_UserbyCookie_CleartripUser")) {
			String ReponseStr = resp.body().asString();
			String username = resp.body().asString();
			if(!username.contains("sai@cltp.com")){
				Assert.assertTrue(false);
			}
			String id = resp.body().asString();
			if(!id.contains("65240427")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("saisaisai@cltp.com")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_AgencyLogo")) {
			

		}
		else if(Type.equalsIgnoreCase("Account_Service_GET_UserbyCookie_FlyinUser")) {
			String ReponseStr = resp.body().asString();
			String username = resp.body().asString();
			if(!username.contains("sandeep.shivanadhula@cleartrip.com")){
				Assert.assertTrue(false);
			}
			String id = resp.body().asString();
			if(!id.contains("65177529")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("744675567656")){
				Assert.assertTrue(false);
			}

		}
		else if(Type.equalsIgnoreCase("Account_Service_UserExistence_withEmailIDandDomain")) {
			
			String status = resp.body().asString();
			if(!status.contains("SUCCESS")){
				Assert.assertTrue(false);
			}
			

		}



		else if(Type.equalsIgnoreCase("Account_Service_GSTV2_SearchAPIwithGstNoAndGstID")) {

			String id = jsonPathEvaluator.getString("id");
			String gstNumber = jsonPathEvaluator.getString("gstNumber");

			if(!id.contains("203")) {
				Assert.assertTrue(false);						
			}
			if(!gstNumber.contains("29aaaaa0000a1Z5")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("Account_Service_Peoplecontroller_FindByID")) {

			String id = jsonPathEvaluator.getString("id");
			String username = jsonPathEvaluator.getString("username");
			if(!id.contains("65206686")) {
				Assert.assertTrue(false);						
			}
			if(!username.contains("nakul@gmail.com")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_AuthorizeAPI_encodingCookie")) {

			String id = jsonPathEvaluator.getString("id");
			String rolesList = jsonPathEvaluator.getString("rolesList");
			if(!id.contains("65240341")) {
				Assert.assertTrue(false);						
			}
			if(!rolesList.contains("1064")) {
				Assert.assertTrue(false);						
			}



		}
		else if(Type.equalsIgnoreCase("IdentityService_ctAuth_noLoginCookie")) {

			String status = jsonPathEvaluator.getString("status");

			if(!status.contains("SUCCESS")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("Account_Service_PWA_GetUser_Byemail")) {

			String emailId = jsonPathEvaluator.getString("emailId");

			if(!emailId.contains("priyankapukale259@gmail.com")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("Account_Service_EmailVerification_API")) {

			String isVerified = jsonPathEvaluator.getString("isVerified");

			if(!isVerified.contains("true")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("IdentityService_PeopleController_gt_token_for_userBy_ID")) {

			String token = jsonPathEvaluator.getString("token");

			if(!token.contains("1566811020")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("IdentityService_PeopleController_gt_token_for_userBy_Email")) {

			String token = jsonPathEvaluator.getString("token");

			if(!token.contains("1600408390")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("IdentityService_PeopleController_gt_token_for_userBy_Private_EmailandID")) {

			String token = jsonPathEvaluator.getString("token");

			if(!token.contains("1600408422")) {
				Assert.assertTrue(false);						
			}


		}


		else if(Type.equalsIgnoreCase("peoplecontroller_getuserbyid_v2")) {

			String emailId = jsonPathEvaluator.getString("username");

			if(!emailId.contains("sai@cleartrip.com")) {
				Assert.assertTrue(false);						
			}


		}


		else if(Type.equalsIgnoreCase("apiConfig_APIkey")) {
			String id = jsonPathEvaluator.getString("api_product_id");
			String activatedate = jsonPathEvaluator.getString("active_date");
			String apikey = jsonPathEvaluator.getString("api_key");

			if(!id.contains("1042")) {
				Assert.assertTrue(false);						
			}
			if(!activatedate.contains("2016-01-28T12:56:35+05:30")) {
				Assert.assertTrue(false);						
			}
			if(!apikey.contains("d4beada793e93d93fcd432141709400f")) {
				Assert.assertTrue(false);						
			}

		}


		else if(Type.equalsIgnoreCase("GstDetails")) {
			String ReponseStr = resp.body().asString();
			if(common.value("host").equals("QA2")) {
				if(!ReponseStr.contains("Karnataka")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("ENABLED")) {
					Assert.assertTrue(false);						
				}
			}

			else {
				if(!ReponseStr.contains("Karnataka")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("28SAILI1234H1Z1")) {
					Assert.assertTrue(false);						
				}
			}
		}


		else if(Type.equalsIgnoreCase("get_cfwoptinstatus")) {
			String ReponseStr = resp.body().asString();
			if(common.value("host").equals("QA2")) {
				if(!ReponseStr.contains("ENABLED")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("optInStatus")) {
					Assert.assertTrue(false);						
				}
			}
		}


		else if(Type.equalsIgnoreCase("peopleautocomplete")) {
			String ReponseStr = resp.body().asString();
			if(common.value("host").equals("QA2")) {
				if(!ReponseStr.contains("vivek.pareek@cleartrip.com")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("vivek.ojha@kleward.com")) {
					Assert.assertTrue(false);						
				}
			}
		}




		else if(Type.equalsIgnoreCase("get_cfwgstdocstatus")) {
			String ReponseStr = resp.body().asString();
			if(common.value("host").equals("QA2")) {
				if(!ReponseStr.contains("gstDocumentStatus")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("ACCEPTED")) {
					Assert.assertTrue(false);						
				}
			}
		}



		else if(Type.equalsIgnoreCase("b2bgetTravelerURL")) {
			String ReponseStr = resp.body().asString();
			if(common.value("host").equals("QA2")) {
				if(!ReponseStr.contains("company_id")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("travellers")) {
					Assert.assertTrue(false);						
				}
			}

			else {
				if(!ReponseStr.contains("people_id")) {
					Assert.assertTrue(false);						
				}

				if(!ReponseStr.contains("first_name")) {
					Assert.assertTrue(false);						
				}
			}
		}



		else if(Type.equalsIgnoreCase("CmpProfile")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("18342556")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("CORP_PTA_ENABLED")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("COMPANY_SALES_REPRESENTATIVE")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("testcompany.cleartripforbusiness.com")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("CmpProfile_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("5312500")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("corpprod.cleartripforbusiness.com")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("AGENCY_PAYMENT_MODES")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("company_configs")) {
				Assert.assertTrue(false);						
			}
		}


		else if(Type.equalsIgnoreCase("FetchBank_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("Wandertrails Services Pvt Ltd")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("branch_name")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("Indiranagar, Bengaluru")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("016905011423")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("GstDetails_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("28SAILI1234H1Z1")) {
				Assert.assertTrue(false);						
			}	

		}
		else if(Type.equalsIgnoreCase("AcctHealthtestURL_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("app")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("db")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("redis")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("200")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("UserInfo_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("api_key")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("78da1221af9368f00f3ccc64a4dbf927")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("axisdigisupport@reward360.co")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("username")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("People_search_API_prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("www.cleartrip.com")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("sailikhitha")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("7799964888")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("UserProfile_Json_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("cleartrip.com")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("pratikshakatwar")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("Pratiksha")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("travel_profile")) {
				Assert.assertTrue(false);						
			}

		}


		else if(Type.equalsIgnoreCase("CompanyProfileRefresh_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("company")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("address1")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("address2")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("annual_travel_budget")) {
				Assert.assertTrue(false);						
			}
		}


		else if(Type.equalsIgnoreCase("CompanyUsers_Prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("user_ids")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("1876970")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("19974102")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("24140498")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("Company_vendormapping_prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("vendor_id")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("ACTV0000125")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("company_id")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("5231474")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("autocomplete_prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("saini2@hotmail.com")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("12593201")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("deposit_account_search_prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("deposit_account_details")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("85618230")) {
				Assert.assertTrue(false);						
			}

		}
		else if(Type.equalsIgnoreCase("User_activestatus_prod")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("status")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("Active")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("username")) {
				Assert.assertTrue(false);						
			}
		}


		else if(Type.equalsIgnoreCase("UserJson")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("6438960")) {
				Assert.assertTrue(false);						
			}	
			if(!ReponseStr.contains("last_login_date_time")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("activation_date_time")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("bonvoyage_subscription")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("FetchProfile")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("bonvoyage_subscription")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("contact_data_id")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("CmpRefresh")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("company_configs")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("channel_type_name")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("FetchBank")) {
			String account_number = jsonPathEvaluator.getString("account_number");
			String ifsc_code = jsonPathEvaluator.getString("ifsc_code");
			String vendor_id = jsonPathEvaluator.getString("vendor_id");
			if(!account_number.contains("219101500771")) {
				Reporter.log("account_number :"+account_number);
				Assert.assertTrue(false);						
			}
			if(!ifsc_code.contains("ICIC0002191")) {
				Reporter.log("account_number :"+account_number);
				Assert.assertTrue(false);						
			}
			if(!vendor_id.contains("123456")) {
				Reporter.log("account_number :"+account_number);
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("FetchPeople")) {


			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("13957750")) {
				Assert.assertTrue(false);						
			}	if(!ReponseStr.contains("13950360")) {
				Assert.assertTrue(false);						
			}	if(!ReponseStr.contains("13941099")) {
				Assert.assertTrue(false);						
			}

		}

		else if(Type.equalsIgnoreCase("Feedbackemail")) {

			String status = jsonPathEvaluator.getString("status");
			if(!status.contains("Success")) {
				Assert.assertTrue(false);						
			}


		}

		else if(Type.equalsIgnoreCase("signinpostcall")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("redirect")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("userprofile_externalAPI_Mobileapp")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("fault")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("b2bAddtraveler")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("saitest")){
				Assert.assertTrue(false);
			}
		}


		else if(Type.equalsIgnoreCase("b2csignin")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("redirect")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("b2csignin_prod")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("redirect")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinsignin")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ok@cltp.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_PWA_SignIn_API")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Manage_trips_OTP_API")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("We've sent a 6 digit OTP to ns.likhitha@cleartrip.com and 1234xxxxxx90 to verify your email address or mobile number for security reason. Please enter the OTP below to continue with the changes to your trip.")){
				Assert.assertTrue(false);
			}
		}



		else if(Type.equalsIgnoreCase("flyinsignup")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("partner_id")){
				Assert.assertTrue(false);
			}

		}

		else if(Type.equalsIgnoreCase("Userclassification_Parsing_CSV")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("File has been read from the server")){
				Assert.assertTrue(false);
			}

		}



		else if(Type.equalsIgnoreCase("flyinsignupV2")) {


			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("email")){
				Assert.assertTrue(false);


				String email = jsonPathEvaluator.getString("email");
				String new_user = jsonPathEvaluator.getString("new_user");
				if(!email.contains("ok@cltp.com")) {
					Reporter.log("email :"+email);
					Assert.assertTrue(false);						
				}

				if(!new_user.contains("false")) {
					Reporter.log("newuser status :"+new_user);
					Assert.assertTrue(false);						
				}

			}
		}




		else if(Type.equalsIgnoreCase("flyinresetpassword")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("success")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinresetpasswordV2")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("success")){
				Assert.assertTrue(false);
			}
		}


		else if(Type.equalsIgnoreCase("flyinforgetpassword")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("success")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("flyinforgetpasswordV2")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("success")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinusersearch")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("samsung@gmail.com")){
				Assert.assertTrue(false);
			}
		}


		else if(Type.equalsIgnoreCase("flyinusersearchV2")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("sesidhar.nandanampati@cleartrip.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinusersearchV2_Flyinregression")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("hemakanta.sethi@cleartrip.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("partnercontroller_updatetraveller")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("hemakanta@flyin.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("travellercontroller_updatetraveller")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("hemakanta@flyin.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("Account_Service_Travellercontroller_UpdateTraveller_FlyRegression")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("yihinad483@temhuv.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinsocialsignup")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ok@gmail.com")){
				Assert.assertTrue(false);
			}
		}


		else if(Type.equalsIgnoreCase("flyinsocialsignupV1")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ok@gmail.com")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("flyinsocialsignupV2")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("samsung10@gmail.com")){
				Assert.assertTrue(false);
			}
		}
		else if(Type.equalsIgnoreCase("flyinsocialsignupV2_flyinregression")) {

			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("anilkumar9291@gmail.com")){
				Assert.assertTrue(false);
			}
		}



		else if(Type.equalsIgnoreCase("AcctRegister")){
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("username")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("B2B_user_authentication")){
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("activation_date_time")){
				Assert.assertTrue(false);
			}
		}

		else if(Type.equalsIgnoreCase("Apiconfig_postcall")){
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("d4beada793e93d93fcd432141709400f")){
				Assert.assertTrue(false);

			}
			if(!ReponseStr.contains("api_product_id")){
				Assert.assertTrue(false);

			}
		}

		else if(Type.equalsIgnoreCase("Companyconfig_contactdata")){
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("AMADEUS_CORP_AIRLINES_LIKHITHA")){
				Assert.assertTrue(false);

			}
			if(!ReponseStr.contains("1234567890999999")){
				Assert.assertTrue(false);

			}
		}

		else if(Type.equalsIgnoreCase("CompanyUsers")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("10440503")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("DepositAcctSearch")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("7898943")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("RoleInfo")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("1069")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("The company employee who signs up for the corporate account and has all the privileges")) {
				Assert.assertTrue(false);						
			}


		}
		else if(Type.equalsIgnoreCase("FetchUserV2")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("13941098")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("vinay.raj@cleartrip.com")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("FetchCompany")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("200748")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("123456")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("UserInfo")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("13939044")) {
				Assert.assertTrue(false);						
			}
			if(!ReponseStr.contains("alex@zpond.co")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("PersonJson")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("14029546")) {
				Assert.assertTrue(false);						
			}
		}
		else if(Type.equalsIgnoreCase("PersonJsonID")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("41699808")) {
				Assert.assertTrue(false);						
			}
		}

		else if(Type.equalsIgnoreCase("ForgotPasswordEmail")) {
			String ReponseStr = resp.body().asString();
			Reporter.log(ReponseStr);
			if(!(resp.getStatusCode()==200)) {
				Assert.assertTrue(false);						
			}
		}
		if(Type.equalsIgnoreCase("createUpdateGST")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("createdOrUpdated")) {
				Assert.assertTrue(false);						
			}	

		}

		if(Type.equalsIgnoreCase("cleartripForWorkOptin")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("updated status successfully")) {
				Assert.assertTrue(false);						
			}	

		}

		if(Type.equalsIgnoreCase("screencaptureInitiate")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("Invalid input")) {
				Assert.assertTrue(false);						
			}	

		}

		if(Type.equalsIgnoreCase("cfwgstdocstatusupdate")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("updated status successfully")) {
				Assert.assertTrue(false);						
			}	

		}


		if(Type.equalsIgnoreCase("identityserviceaddclient")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("clientSecret")) {
				Assert.assertNotNull("id");
				Assert.assertNotNull("clientSecret");
				Assert.assertTrue(false);						
			}	

		}
		if(Type.equalsIgnoreCase("identityservicesignin")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("automate@test.com")) {
				Assert.assertNotNull("mobileNumber");
				Assert.assertNotNull("isRegistered");
				Assert.assertTrue(false);						
			}	

		}
		if(Type.equalsIgnoreCase("IdentityService_Signin_Userauthentication_B2C_B2B")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertNotNull("1234567890");
				Assert.assertNotNull("no.cleartripforbusiness.com");
				Assert.assertNotNull("340000XXXXXX009");
				Assert.assertNotNull("hq_trips_close_txn_tab");
				Assert.assertNotNull("111test111");
				
				
				Assert.assertTrue(false);						
			}	

		}
		if(Type.equalsIgnoreCase("IdentityService_Signin_Userauthentication_B2C_B2B_b2bUser")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("ns.likhitha@cleartrip.com")) {
				Assert.assertNotNull("1234567890");
				Assert.assertNotNull("no.cleartripforbusiness.com");
				Assert.assertNotNull("340000XXXXXX009");
				Assert.assertNotNull("hq_trips_close_txn_tab");
				Assert.assertNotNull("111test111");
				
				
				Assert.assertTrue(false);						
			}	

		}
		if(Type.equalsIgnoreCase("IdentityService_Signin_FlyinUser")) {
			String ReponseStr = resp.body().asString();
			if(!ReponseStr.contains("sandeep.shivanadhula@cleartrip.com")) {
				Assert.assertNotNull("mobileNumber");
				Assert.assertNotNull("isRegistered");
				Assert.assertTrue(false);						
			}	

		}



		else if(Type.equalsIgnoreCase("registerUser")) {
			String ReponseStr = resp.body().asString();
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("REG_FORM registration done successfully")) {
				Assert.assertTrue(false);						
			}	

		}
		else if(Type.equalsIgnoreCase("externalApi_Refreshtoken")) {
			String ReponseStr = resp.body().asString();
			String message = jsonPathEvaluator.getString("message");
			if(!message.contains("recordUpdated")) {
				Assert.assertTrue(false);						
			}	

		}

		else if(Type.equalsIgnoreCase("createUpdateTraveller")) {

			if(statusCode!=200) {
				Assert.assertTrue(false);						
			}	
			if(Type.equalsIgnoreCase("fetchWallet")) {
				String ResponseStr = resp.body().asString();
				String userId = jsonPathEvaluator.getString("userId");
				String wallet_balance = jsonPathEvaluator.getString("ct_user_wallet_balance");
				Reporter.log("Wallet Balance: " +wallet_balance);
				if(!ResponseStr.contains(userId)) {
					Assert.assertTrue(false);						
				}	
				Assert.assertNotNull(wallet_balance);

			}

		}



		else if(Type.equalsIgnoreCase("createTraveller")) {

			if(statusCode!=200) {
				Assert.assertTrue(false);						
			}	
			if(Type.equalsIgnoreCase("fetchWallet")) {
				String ResponseStr = resp.body().asString();
				String userId = jsonPathEvaluator.getString("userId");
				String wallet_balance = jsonPathEvaluator.getString("ct_user_wallet_balance");
				Reporter.log("Wallet Balance: " +wallet_balance);
				if(!ResponseStr.contains(userId)) {
					Assert.assertTrue(false);						
				}	
				Assert.assertNotNull(wallet_balance);

			}

		}


		else if(Type.equalsIgnoreCase("createCompanyTags")) {

			if(statusCode!=200) {
				Assert.assertTrue(false);						
			}	

		}



		else if(Type.equalsIgnoreCase("createUpdateTraveller_bookstep2")) {

			if(statusCode!=200) {
				Assert.assertTrue(false);						
			}	
			if(Type.equalsIgnoreCase("fetchWallet")) {
				String ResponseStr = resp.body().asString();
				String userId = jsonPathEvaluator.getString("userId");
				String wallet_balance = jsonPathEvaluator.getString("ct_user_wallet_balance");
				Reporter.log("Wallet Balance: " +wallet_balance);
				if(!ResponseStr.contains(userId)) {
					Assert.assertTrue(false);						
				}	
				Assert.assertNotNull(wallet_balance);

			}
		}


		else if(Type.equalsIgnoreCase("AccountsInfoAPI_BasedonUserId")) {

			if(statusCode!=200) {
				Assert.assertTrue(false);						
			}

			else if(Type.equalsIgnoreCase("AccountsInfoAPI_BasedonUserId")) {
				String ReponseStr = resp.body().asString();
				if(!ReponseStr.contains("api_key")) {
					Assert.assertTrue(false);						
				}
				if(!ReponseStr.contains("username")) {
					Assert.assertTrue(false);						
				}
			}

		}

		return resp;
	}


	public Response ErrorValidation(Response resp, String Type) {
		Reporter.log("Response body " + Type + " : " + resp.body().asString());
		int statusCode = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if(Type.equalsIgnoreCase("Account_Service_AccountExitsAPI_InValid")) {

			System.out.println(statusCode);
			String message = jsonPathEvaluator.getString("status");
			System.out.println(message);
			if(!message.contains("FAILURE")) {
				Assert.assertTrue(false);
			}
		}

		return resp;
	}

	public Response Verification(Response resp, String Type, String Type2) {
		Reporter.log("Response body " + Type + " : " + resp.body().asString());
		int statusCode = resp.getStatusCode();
		Reporter.log("statusCode: " + statusCode);
		JsonPath jsonPathEvaluator = resp.jsonPath();

		if (Type.equals("FKVIP_InValid_RedeemAPI")) {
			if (statusCode != 404) {
				System.out.println(statusCode);
				Assert.assertTrue(false);
			}

		} else if (statusCode != 202) {
			System.out.println(statusCode);
			System.out.println(resp.getBody().asString());
			Assert.assertTrue(false);
		}
		if(Type.equalsIgnoreCase("Register_API")) {
			String ReponseStr = resp.getBody().asString();
			System.out.println(ReponseStr);
			if(!ReponseStr.contains("qa2new.cleartrip.com")){
				Assert.assertTrue(false);
			}
			if(!ReponseStr.contains("NEW_USER")){
				Assert.assertTrue(false);
			}
		}
		if(Type.equalsIgnoreCase("AS_Update_UserJson")) {
			String id = jsonPathEvaluator.getString("id");
			if(!id.contains("65270513")) {
				Assert.assertTrue(false);
			}
		}

		if(Type.equalsIgnoreCase("AS_FlyinUserDetails_Update")) {
			String username = jsonPathEvaluator.getString("username");
			if(!username.contains("sabori7535@pidouno.com")) {
				Assert.assertTrue(false);
			}
		}
		return resp;
	}

}