// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.  paymentsAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_IR_Get_Eligibility extends API_PaymentCommon1
{
	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_NB()  {
		Response resp ;		
		resp = payGet("IR_Eligibility_NB","");	
		validation("IR_Eligibility_NB", resp);
	}
	
	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_DC()  {
		Response resp ;		
		resp = payGet("IR_Eligibility_DC","");	
		validation("IR_Eligibility_DC", resp);
	}
	
	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_CC()  {
		Response resp ;		
		resp = payGet("IR_Eligibility_CC","");	
		validation("IR_Eligibility_CC", resp);
	}
	
	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_GV()  {
		Response resp ;		
		resp = payGet("IR_Eligibility_GV","");	
		validation("IR_Eligibility_GV", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_WALLET()  {
		Response resp ;
		resp = payGet("IR_Eligibility_WALLET","");
		validation("IR_Eligibility_GV", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_EMI()  {
		Response resp ;
		resp = payGet("IR_Eligibility_EMI","");
		validation("IR_Eligibility_GV", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_TW()  {
		Response resp ;
		resp = payGet("IR_Eligibility_TW","");
		validation("IR_Eligibility_TW", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_UPI()  {
		Response resp ;
		resp = payGet("IR_Eligibility_UPI","");
		validation("IR_Eligibility_TW", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_RP()  {
		Response resp ;
		resp = payGet("IR_Eligibility_RP","");
		validation("IR_Eligibility_TW", resp);
	}

	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_CC_Non()  {
		Response resp ;
		resp = payGet("IR_Eligibility_CC_Non","");
		validation("IR_Eligibility_CC_Non", resp);
	}


	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_PayLater()  {
		Response resp ;
		resp = payGet("IR_Eligibility_PayLater","");
		validation("IR_Eligibility_NB", resp);
	}


	@Test(alwaysRun = true)
	public void InstantRefund_geteligibility_Cardless_EMI()  {
		Response resp ;
		resp = payGet("IR_Eligibility_Cardless_EMI","");
		validation("IR_Eligibility_NB", resp);
	}
}