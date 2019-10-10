package testScriptsSalesForce;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonServices.APIUtils;
import domainServices.APIServices;

public class Post_case_archival extends APIServices
{
	@Test
	public void ivrCheck() throws Exception, IOException
	{
		Reporter.log("Test case " + this.getClass() + " started");
		System.out.println("Test case " + this.getClass() + " started");
		
		HashMap<String, String> headers = APIUtils.gettSalesforceHeaders();
		String pay="{    \"data\":[       {          \"case_data\":{             \"CaseNotes\":[                {                   \"attributes\":{                      \"type\":\"CaseFeed\",                      \"url\":\"/services/data/v38.0/sobjects/CaseFeed/0D5N000000JeRiwKAF\"                   },                   \"Id\":\"0D5N000000JeRiwKAF\",                   \"ParentId\":\"500N0000005CuJSIA0\",                   \"Body\":\"Hello,\r\n\r\nLorem Ipsum,Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum.\nref:_00DN0AgXh._500N05CuJS:ref\",                   \"IsRichText\":false                },                {                   \"attributes\":{                      \"type\":\"CaseFeed\",                      \"url\":\"/services/data/v38.0/sobjects/CaseFeed/0D5N000000JeRitKAF\"                   },                   \"Id\":\"0D5N000000JeRitKAF\",                   \"ParentId\":\"500N0000005CuJSIA0\",                   \"Body\":\"Additional To: chincholisachin@gmail.com; sachin.chincholi@etmarlabs.com\nCC: \nBCC: sachin.chincholi@etmarlabs.com\nAttachment: CT.jpg, CT.jpg\n\nSubject: Test Contact Email\nBody:\nHello,\r\n\r\nLorem Ipsum,Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum.\nref:_00DN0AgXh._500N05CuJS:ref\",                   \"IsRichText\":false                }             ],             \"Trip__r\":{                \"PaxAndSegInfoList__c\":[                   {                      \"a_agent_pcc\":null,                      \"a_airline_pnr\":\"JXG0F\",                      \"a_gds_pnr\":\"YKLNLE\",                      \"a_ticket_number\":null,                      \"airline\":\"AI\",                      \"airlineType\":\"GDS\",                      \"arrival_airport\":\"Bangalore\",                      \"arrival_date_time\":\"2016-04-21T18:25:00+05:30\",                      \"book_pcc\":\"CLEARTRIP\",                      \"departure_airport\":\"Hyderabad\",                      \"departure_date_time\":\"2016-08-12T17:20:00+05:30\",                      \"flight_number\":\"AI-514\",                      \"flight_seq_no\":null,                      \"fullName\":\"Jivan Kotian\",                      \"Gender\":\"M\",                      \"PaxType\":\"Adult\",                      \"segment_seq_no\":\"4\",                      \"trip_id\":null                   }                ],                \"Trip_Id__c\":\"Q16070100260\",                \"Id\":\"a0ON0000004ZLbxMAG\"             },             \"Contact\":{                \"attributes\":{                   \"type\":\"Contact\",                   \"url\":\"/services/data/v38.0/sobjects/Contact/003N000000opnEVIAY\"                },                \"Id\":\"003N000000opnEVIAY\",                \"Email\":\"ns.likhitha@cleartrip.com\",                \"FirstName\":\"Chincholi\",                \"LastName\":\"Test\"             },             \"Tasks\":[                {                   \"attributes\":{                      \"type\":\"Task\",                      \"url\":\"/services/data/v38.0/sobjects/Task/00TN000000AR9xLMAT\"                   },                   \"WhatId\":\"500N0000005CuJSIA0\",                   \"Id\":\"00TN000000AR9xLMAT\",                   \"WhoId\":\"003N000000opnEVIAY\",                   \"WhoCount\":1,                   \"WhatCount\":1,                   \"Subject\":\"Email: Test Contact Email\",                   \"ActivityDate\":\"2016-12-19\",                   \"Status\":\"Completed\",                   \"Priority\":\"Normal\",                   \"IsHighPriority\":false,                   \"OwnerId\":\"005N0000002maTxIAI\",                   \"Description\":\"Additional To: chincholisachin@gmail.com; sachin.chincholi@etmarlabs.com\nCC: \nBCC: sachin.chincholi@etmarlabs.com\nAttachment: CT.jpg, CT.jpg\n\nSubject: Test Contact Email\nBody:\nHello,\r\n\r\nLorem Ipsum,Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum.\nref:_00DN0AgXh._500N05CuJS:ref\",                   \"CurrencyIsoCode\":\"INR\",                   \"IsDeleted\":false,                   \"AccountId\":\"001N000000t38ZEIAY\",                   \"IsClosed\":true,                   \"CreatedDate\":\"2016-12-19T09:09:23.000+0000\",                   \"CreatedById\":\"005N0000002maTxIAI\",                   \"LastModifiedDate\":\"2016-12-19T09:09:23.000+0000\",                   \"LastModifiedById\":\"005N0000002maTxIAI\",                   \"SystemModstamp\":\"2016-12-19T09:11:05.000+0000\",                   \"IsArchived\":false,                   \"IsReminderSet\":false,                   \"IsRecurrence\":false,                   \"Duration__c\":0,                   \"Created_Date_Time__c\":\"2016-12-19T09:09:23.000+0000\",                   \"Created_By__c\":\"Sachin C\"                }             ],             \"EmailMessages\":[                {                   \"Archival_Status__c\":\"Ready For Archival\",                   \"Attachments_JSON__c\":{                      \"attachments\":[                         {                            \"ct_url\":\"qa2.cleartrip.com/salesforce/archival/attachments/qltoVe/CT.jpg\",                            \"id\":\"00PN0000004SrJ0MAK\",                            \"name\":\"CT.jpg\",                            \"parent_id\":\"02sN0000000Qrr6IAC\"                         },                         {                            \"ct_url\":\"qa2.cleartrip.com/salesforce/archival/attachments/qltoVf/CT.jpg\",                            \"id\":\"00PN0000004SrJ1MAK\",                            \"name\":\"CT.jpg\",                            \"parent_id\":\"02sN0000000Qrr6IAC\"                         }                      ]                   },                   \"IsExternallyVisible\":true,                   \"IsDeleted\":false,                   \"MessageDate\":\"2017-05-25T09:09:24.000Z\",                   \"Status\":\"3\",                   \"HasAttachment\":true,                   \"Incoming\":false,                   \"BccAddress\":\"sachin.chincholi@etmarlabs.com\",                   \"ToAddress\":\"chincholisachin@gmail.com; sachin.chincholi@etmarlabs.com\",                   \"FromAddress\":\"ns.likhitha@cleartrip.com\",                   \"FromName\":\"Sachin C\",                   \"Subject\":\"Test Contact Email\",                   \"TextBody\":\"Hello,\r\n\r\nLorem Ipsum,Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum.\nref:_00DN0AgXh._500N05CuJS:ref\",                   \"SystemModstamp\":\"2016-12-19T09:11:05.000Z\",                   \"LastModifiedById\":\"005N0000002maTxIAI\",                   \"LastModifiedDate\":\"2016-12-19T09:11:05.000Z\",                   \"CreatedDate\":\"2016-12-19T09:09:24.000Z\",                   \"CreatedById\":\"005N0000002maTxIAI\",                   \"ActivityId\":\"00TN000000AR9xLMAT\",                   \"Id\":\"02sN0000000Qrr6IAC\",                   \"ParentId\":\"500N0000005CuJSIA0\"                }             ],             \"MilestoneStatus\":\"\",             \"Trip_Booking_Country__c\":\"India\",             \"Archival_Status__c\":\"Ready For Archival\",             \"Ticketing_System__c\":\"GDS\",             \"Product_Booking_Type__c\":\"Airline-Domestic\",             \"Call_Center_Connectivity__c\":false,             \"Cloned_Case__c\":false,             \"Open_In_Current_Queue__c\":0,             \"Case_Owner_department__c\":\"Agate_CS_Air\",             \"Amendment_Done__c\":false,             \"Created_By_User_Email__c\":\"sachin.chincholi@etmarlabs.com\",             \"Segment_Departure_Dates__c\":\"2016-11-25T07:17:00.000Z\",             \"isReopen__c\":false,             \"isAssigned__c\":true,             \"Wallet_Booking__c\":false,             \"Urgent_Travel__c\":false,             \"Trip__c\":\"a0ON0000004ZLbxMAG\",             \"Trip_Depart_On__c\":\"2016-11-25T07:17:00.000Z\",             \"Trip_Cancelled_On__c\":\"2016-08-12T18:28:57.000Z\",             \"Trip_Booked_On__c\":\"2016-08-12T11:22:52.000Z\",             \"Trip_Airline_Code__c\":\"A1\",             \"Thread_Id__c\":\"[ ref:_00DN0AgXh._500N05CuJS:ref ]\",             \"TAT_for_Case__c\":258.00,             \"TAT_for_Case_In_Hours__c\":0.00,             \"TAT_for_Case_HH_MM_SS__c\":\"0:4:18\",             \"Sub_Cause__c\":\"Wants to change Sector/Airline\",             \"Special_Requests__c\":false,             \"Resolutions__c\":\"Amendment Done\",             \"RA__c\":false,             \"Queue_Id__c\":\"00G28000001h4uSEAQ\",             \"Queue_Change_Date_Time__c\":\"2016-12-19T09:07:41.000Z\",             \"Product__c\":\"Airline\",             \"Offline_Conversation__c\":false,             \"Milestone3__c\":false,             \"Milestone2__c\":false,             \"Milestone1__c\":true,             \"Market__c\":\"India\",             \"Last_Minute_Booking__c\":false,             \"IsChecked__c\":true,             \"Infant_Adding__c\":false,             \"HQ_Trip_Id__c\":\"Q16070100260\",             \"Dependency_Time_Limit_Crossed__c\":false,             \"Customer_Record_Type__c\":\"B2B\",             \"Current_Team_Name__c\":\"E-Care\",             \"Current_Queue_Name__c\":\"Customer Support Queue\",             \"Coupon_Conversation__c\":false,             \"Confirm_Sector_Hotel_Travel_Dates__c\":false,             \"Closed_Date__c\":\"2016-12-19T09:11:58.000Z\",             \"Cleartrip_Charges_Waived_Off__c\":false,             \"Cause__c\":\"Air Amendments\",             \"Cash_Booking__c\":false,             \"Case_Type__c\":\"Customer Support\",             \"Case_Status__c\":\"Closed\",             \"Case_Record_Type__c\":\"Customer Support\",             \"Case_Owner__c\":\"Khan\",             \"Case_History_record_Queue_ID__c\":\"a0JN0000006BAyjMAG\",             \"Case_History_record_Agent_ID__c\":\"a0JN0000006BAqzMAG\",             \"Bounced_Back__c\":false,             \"Booking_type__c\":\"Domestic\",             \"Booked_before_Travel_in_Hour__c\":2515.90,             \"Auto_Close__c\":false,             \"Amended_Passenger_Number__c\":0,             \"Am_I_creator__c\":1.00,             \"ACM__c\":false,             \"LastReferencedDate\":\"2016-12-19T09:18:49.000Z\",             \"LastViewedDate\":\"2016-12-19T09:18:49.000Z\",             \"SystemModstamp\":\"2016-12-19T09:11:58.000Z\",             \"LastModifiedById\":\"005N0000002maTxIAI\",             \"LastModifiedDate\":\"2016-12-19T09:11:58.000Z\",             \"CreatedById\":\"005N0000002maTxIAI\",             \"CreatedDate\":\"2016-12-19T09:07:40.000Z\",             \"IsStopped\":false,             \"SlaExitDate\":\"2016-12-19T09:10:22.000Z\",             \"SlaStartDate\":\"2016-12-19T06:40:00.000Z\",             \"IsClosedOnCreate\":false,             \"OwnerId\":\"00528000002x4sEAAQ\",             \"CurrencyIsoCode\":\"INR\",             \"IsEscalated\":false,             \"ClosedDate\":\"2016-12-19T09:10:21.000Z\",             \"IsClosed\":true,             \"Priority\":\"Low\",             \"Origin\":\"Email\",             \"Status\":\"Closed\",             \"RecordTypeId\":\"01228000000lbPqAAI\",             \"BusinessHoursId\":\"01m28000000aNNfAAM\",             \"EntitlementId\":\"550N0000000DRXHIA4\",             \"AccountId\":\"001N000000t38ZEIAY\",             \"ContactId\":\"003N000000opnEVIAY\",             \"CaseNumber\":\"65234515\",             \"IsDeleted\":false,             \"Id\":\"500N0000005CuJSIA0\"          }       }    ] }";
		HttpResponse response = APIUtils.postApi(getBaseUrl() + "/salesforce/archival/cases", headers,pay, 200);
		int hitStatus = response.getStatusLine().getStatusCode();
		
		Reporter.log("Http Staus for Get Request"+hitStatus,true);
		System.out.println(response);
		String responseString = APIUtils.returnResponseAsString(response);
		System.out.println(responseString);
		Reporter.log(responseString, true);
		
		Assert.assertEquals(hitStatus,200,"Response code is="+hitStatus);
	}

}
