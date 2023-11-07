package test.java.  domains;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.Reporter;

import test.java.common.CommonUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PlatformCommonUtil extends CommonUtil {
	public String Service_Url (String Service) throws IOException {
		String url = "";
		String environment = common.value("host");

		if(Service.equals("SMS")) {
			if(environment.equals("www")) {
				url = platform.value("sms_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("sms_qa2");
			}
		}
		if(Service.equals("WHATSAPP_CC")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_checkcontacts_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_checkcontacts_qa2");
			}
		}

		if(Service.equals("WHATSAPP_OPTIN")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_optin_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_optin_qa2");
			}
		}

		if(Service.equals("WHATSAPP_OPTIN_STATUS")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_optinstatus_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_optinstatus_qa2");
			}
		}

		if(Service.equals("WHATSAPP_MESSAGE")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_message_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_message_qa2");
			}

		}

		if(Service.equals("WHATSAPP_ATTACHMENTS_MESSAGE")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_attachments_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_attachments_qa2");

			}
		}
		
		if(Service.equals("WHATSAPP_WEBHOOK_MESSAGE")) {
			if(environment.equals("www")) {
				url = platform.value("whatsapp_attachments_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("whatsapp_attachments_qa2");

			}
		}
		
		if(Service.equals("EMAILS_POST_CALL")) {
			if(environment.equals("www")) {
				url = platform.value("emailservice_post_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("emailservice_post_qa2");

			}
		}
		
		if(Service.equals("EMAIL_ATTACHMENTS")) {
			if(environment.equals("www")) {
				url = platform.value("emailservice_attachemnts_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("emailservice_attachemnts_qa2");

			}
		}if(Service.equals("EMAIL_GENERATEPKPASS")) {
			if(environment.equals("www")) {
				url = platform.value("emailservice_generatepkpass_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("emailservice_generatepkpass_qa2");

			}
		}if(Service.equals("EMAIL_GENERATEPDF")) {
			if(environment.equals("www")) {
				url = platform.value("emailservice_generatepdf_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("emailservice_generatepdf_qa2");

			}
		}
		
		if(Service.equals("EMAIL_SPAMSCORE")) {
			if(environment.equals("www")) {
				url = platform.value("emailservice_spamscore_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("emailservice_spamscore_qa2");

			}
		}
		
		if(Service.equals("TRIPSERVICE_PUT_CALL")) {
			if(environment.equals("www")) {
				//url = platform.value("tripservice_putcall_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("tripservice_putcall_qa2");
            } else if(environment.equals("dev")){
            	url = platform.value("tripservice_putcall_dev");
            }
		}
		
		if(Service.equals("TRIPSERVICE_POST_CALL")) {
			if(environment.equals("www")) {
			url = platform.value("tripservice_postcall_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("tripservice_postcall_qa2");

			}else if (environment.equals("dev")) {
				url = platform.value("tripservice_postcall_dev");
			}
			
		}		
		
		if(Service.equals("TRIPSERVICE_PUT_TRIPS")) {
			if(environment.equals("www")) {
			url = platform.value("Tripservice_puttrips_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("Tripservice_puttrips_qa2");

			}else if (environment.equals("dev")) {
				url = platform.value("Tripservice_puttrips_dev");
			}
			
		}		
		if(Service.equals("TRIPSERVICE_UPDATE_CALL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_Update_Prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_Update_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_Update_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETFINANCE_AIR_CALL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinance_air_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinance_air_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinance_air_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETFINANCE_HOTEL_CALL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinance_hotel_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinance_hotel_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinance_hotel_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETFINANCE_LOCAL_CALL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinance_local_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinance_local_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinance_local_dev");
			}
		}
		
		if(Service.equals("TRIPSERVICE_GETFINANCEALLTRIPS_AIR")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinancealltrips_air_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinancealltrips_air_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinancealltrips_air_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETFINANCEALLTRIPS_HOTEL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinancealltrips_hotel_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinancealltrips_hotel_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinancealltrips_hotel_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETFINANCEALLTRIPS_LOCAL")){
			if(environment.equals("www")){
			url=platform.value("Tripservice_getfinancealltrips_local_prod");
				
			}else if(environment.equals("qa2")){
				url=platform.value("Tripservice_getfinancealltrips_local_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getfinancealltrips_local_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETCOMMU_CALL")){
		 if(environment.equals("qa2")){
				url=platform.value("Tripservice_getcomm_qa2");
			}else if(environment.equals("dev")){
				url=platform.value("Tripservice_getcomm_dev");
			}
		}
		if(Service.equals("TRIPSERVICE_GETCOMPANYBOOKSTAT_CALL")){
			 if(environment.equals("qa2")){
					url=platform.value("Tripservice_getcompanybookstat_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_getcompanybookstat_dev");
				}
			}
		if(Service.equals("TRIPSERVICE_GETTRIPCOUNT_CALL")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_gettripcount_prod");
			}
			else if(environment.equals("qa2")){
					url=platform.value("Tripservice_gettripcount_qa2");
				} else if(environment.equals("dev")){
				url=platform.value("Tripservice_gettripcount_dev");
			}
			
			} 
		if(Service.equals("TRIPSERVICE_GETPRODUCTTYPE-BOOKTYPE_CALL")){
				 if(environment.equals("qa2")){
						url=platform.value("Tripservice_getproducttype-booktype_qa2");
					} else if(environment.equals("dev")){
						url=platform.value("Tripservice_getproducttype-booktype_dev");
					}
				}
       if(Service.equals("TRIPSERVICE_GETALL_TRIPS")){
					if(environment.equals("www")){
						url=platform.value("Tripservice_getalltrips_prod");
					} else if(environment.equals("qa2")){
							url=platform.value("Tripservice_getalltrips_qa2");
						} else if(environment.equals("dev")){
							url=platform.value("Tripservice_getalltrips_dev");
						}
					}
       if(Service.equals("TRIPSERVICE_GETARCHIVED_TRIPS")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_getarchived_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_getarchived_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_getarchived_dev");
				}
			}
       if(Service.equals("TRIPSERVICE_POST_GRAPHQL")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_post_graphql_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_post_graphql_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_post_graphql_dev");
				}
			}
       if(Service.equals("TRIPSERVICE_POST_TRIPQUERY")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_post_tripquery_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_post_tripquery_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_post_tripquery_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_GETTRIPS_ITINERARYID")){
						if(environment.equals("www")){
							url=platform.value("Tripservice_gettrips_itineraryid_prod");
						} else if(environment.equals("qa2")){
								url=platform.value("Tripservice_gettrips_itineraryid_qa2");
							} else if(environment.equals("dev")){
								url=platform.value("Tripservice_gettrips_itineraryid_dev");
							}
						}
	    if(Service.equals("TRIPSERVICE_FINANCE_SCRAPERS")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_finance_scrapers_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_finance_scrapers_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_finance_scrapers_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_GET_SUPPLIER")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_get_supplier_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_get_supplier_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_get_supplier_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_GET_TRIPCOUNT")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_get_tripcount_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_get_tripcount_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_get_tripcount_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_GET_EMAIL")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_get_email_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_get_email_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_get_email_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_GET_PAHCOMMQUEUE")){
			if(environment.equals("www")){
				url=platform.value("Tripservice_post_pahcommqueue_prod");
			} else if(environment.equals("qa2")){
					url=platform.value("Tripservice_post_pahcommqueue_qa2");
				} else if(environment.equals("dev")){
					url=platform.value("Tripservice_post_pahcommqueuel_dev");
				}
			}
	    if(Service.equals("TRIPSERVICE_MF_MFILTER")){
			if(environment.equals("qa2")){
				url=platform.value("Tripservice_MF_MFilter");
			}
	    }
	    
		
		if(Service.equals("PAYMENT")) {
			if(environment.equals("www")) {
				url = platform.value("PAYMENT_prod");
			}else if (environment.equals("qa2")) {
				url = platform.value("PAYMENT_qa2");
			}
		}
		
		if(Service.equals("Selfcare_createChat")){
			if(environment.equals("www"))
				url=platform.value("Selfcare_createChat_qa2");
			if(environment.equals("qa2")){
				url=platform.value("Selfcare_createChat_qa2");
			}
		}
		
		if(Service.equals("Selfcare_gatewayChat")){
			if(environment.equals("www"))
				url=platform.value("Selcare_GatewaycreateChat_Prod");
			if(environment.equals("qa2")){
				url=platform.value("Selcare_GatewaycreateChat_qa2");
			}
		}
		
		if(Service.equals("Resource_Fetch")){
			if(environment.equals("qa2")){
				url=platform.value("Ct-config_resource_fetch");
			}
		}


		Reporter.log("Service URL : "+url);
		return url;
	}
	
	
	public Response whatsAppRestApi(ArrayList params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	
	
	public Response WhatsappOptinStatus(HashMap<String, Object> params,HashMap<String, Object> headers, String url )
	{
		Response resp;
		resp=RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	

	public Response whatsAppRestApiMessage(HashMap<String, Object> params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	public Response paramsForwebHookMesages(String params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	

	public Response whatsAppRestApi(Map<String,List<String>> params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}
	
	
	public Response paramsForMesagesWithAttachments(String params, HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				body(params).
				headers(headers).
				post(url);
		return resp;
	}

	
	public Response paramsForwhatsappfeliveryfeedback(HashMap<String, Object> headers, String url){
		Response resp;
		resp = RestAssured.given().
				when().
				log().all().
				headers(headers).
				get(url);
		return resp;
	}


	public static int getRandomNumber(){
		Random random = new Random();
		return random.nextInt(900000);
	}
	
	public String generateRandomWord(int wordLength) {
		java.util.Random r= new java.util.Random();
		StringBuilder sb = new StringBuilder(wordLength);
		for(int i = 0; i < wordLength; i++) { // For each letter in the word
			char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
			sb.append(tmp); // Add it to the String
		}
		return sb.toString();
	}
	
	
	public static int generatePaymentID(){
		int pid= PlatformCommonUtil.getRandomNumber();
		return pid;
	}
	
	public static String generateTrackID(){
		int tid= PlatformCommonUtil.getRandomNumber();
		String tid_new = Integer.toString(tid);
		return tid_new;
	}
	
	public String getDateTime(int day, String format) throws Exception {
		Calendar calender = new GregorianCalendar();
		calender.add(Calendar.DATE, +day);
		java.util.Date date = calender.getTime();
		String dateTime = new SimpleDateFormat(format).format(date);
		return dateTime;
	}

	

	public String getRandomNos(int number) throws Exception {
		int randomInventory = ThreadLocalRandom.current().nextInt(number);
		randomInventory = (int) (Math.random() * number);
		String Str_randomInventory = Integer.toString(randomInventory);
		return Str_randomInventory;
	}
}
