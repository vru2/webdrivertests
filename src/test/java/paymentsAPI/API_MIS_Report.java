// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class API_MIS_Report extends API_PaymentCommon1
{

	@Test
	public void MIS_report_CC()  {
		Response resp ;
		resp = payGet("MIS_Report","CC");
		validation_MIS("CC", resp);
	}
	@Test
	public void MIS_report_DC()  {
		Response resp ;
		resp = payGet("MIS_Report","DC");
		validation_MIS("DC", resp);
	}
	@Test
	public void MIS_report_NB()  {
		Response resp ;
		resp = payGet("MIS_Report","NB");
		validation_MIS("NB", resp);
	}
	@Test
	public void MIS_report_RP_SC()  {
		Response resp ;
		resp = payGet("MIS_Report","RP_SC");
		validation_MIS("RP_SC", resp);
	}
	@Test
	public void MIS_report_RP_ADCB()  {
		Response resp ;
		resp = payGet("MIS_Report","RP_ADCB");
		validation_MIS("RP_ADCB", resp);
	}
	@Test
	public void MIS_report_WT_Rewards()  {
		Response resp ;
		resp = payGet("MIS_Report","WT_Rewards");
		validation_MIS("WT_Rewards", resp);
	}
	@Test
	public void MIS_report_WT_Credit()  {
		Response resp ;
		resp = payGet("MIS_Report","WT_Credit");
		validation_MIS("WT_Credit", resp);
	}
	@Test
	public void MIS_report_GV()  {
		Response resp ;
		resp = payGet("MIS_Report","GV");
		validation_MIS("GV", resp);
	}

	@Test
	public void MIS_report_PL()  {
		Response resp ;
		resp = payGet("MIS_Report","PL");
		validation_MIS("PL", resp);
	}

	@Test
	public void MIS_report_CL_EMI()  {
		Response resp ;
		resp = payGet("MIS_Report","CL_EMI");
		validation_MIS("CL_EMI", resp);
	}

	@Test
	public void MIS_report_EMI()  {
		Response resp ;
		resp = payGet("MIS_Report","EMI");
		validation_MIS("EMI", resp);
	}

	@Test
	public void MIS_report_UP()  {
		Response resp ;
		resp = payGet("MIS_Report","UP");
		validation_MIS("UP", resp);
	}
	@Test
	public void MIS_report_TW()  {
		Response resp ;
		resp = payGet("MIS_Report","TW");
		validation_MIS("TW", resp);
	}
	@Test
	public void MIS_report_DA()  {
		Response resp ;
		resp = payGet("MIS_Report","DA");
		validation_MIS("DA", resp);
	}
	@Test
	public void MIS_report_PL_Refund()  {
		Response resp ;
		resp = payGet("MIS_Report","PL_Refund");
		validation_MIS("PL_Refund", resp);
	}

	@Test
	public void MIS_report_COD()  {
		Response resp ;
		resp = payGet("MIS_Report","COD");
		validation_MIS("COD", resp);
	}
}