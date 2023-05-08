// Framework - Cleartrip Automation
// Author - Kiran Kumar

package test.java.paymentsAPI;

import io.restassured.response.Response;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class API_GV_SCLP extends API_PaymentCommon1
{
	@Test
	public void API_GVGet_SCLP_Genric_DOMAIR() throws ClassNotFoundException, SQLException  {
		Response resp ;		
		resp = rearchGV1("GETSCLPGENDOM","");
		validation_SCLP_GV("GENERIC", resp);
		}

	@Test
	public void API_GVGet_SCLP_Genric_DOMINTL() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPGENINTL","");
		validation_SCLP_GV("GENERIC", resp);
	}

	@Test
	public void API_GVGet_SCLP_Genric_HOTELS() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPGENHOTEL","");
		validation_SCLP_GV("GENERIC", resp);
	}

	@Test
	public void API_GVGet_SCLP_DomAir() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPDOMAIR","");
		validation_SCLP_GV("ONLY_DOMAIR", resp);
	}

	@Test
	public void API_GVGet_SCLP_IntlAir() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPINTLAIR","");
		validation_SCLP_GV("ONLY_INTLAIR", resp);
	}

	@Test
	public void API_GVGet_SCLP_Hotel() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPHOTEL","");
		validation_SCLP_GV("ONLY_HOTEL", resp);
	}

	@Test
	public void API_GVGet_SCLP_Error_DOMAir() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPDOMAIRERR","");
		validation_SCLP_GV("ERROR", resp);
	}

	@Test
	public void API_GVGet_SCLP_Error_INTLAir() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPINTLAIRERR","");
		validation_SCLP_GV("ERROR", resp);
	}

	@Test
	public void API_GVGet_SCLP_Error_Hotel() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPHOTELERR","");
		validation_SCLP_GV("ERROR", resp);
	}

/*	@Test
	public void API_GVGet_SCLP_Error_BUS() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GETSCLPBUSERR","");
		validation_SCLP_GV("ERRORPRODUCT", resp);
	}*/

	@Test
	public void API_GV_SCLP_CAPTURE_Pay() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("CAPTURESCLPGV","");
		validation_SCLP_GV("CAPTURESCLPGV", resp);
	}

	@Test
	public void API_GV_SCLP_VALIDATE() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("VALIDATESCLPGV","");
		validation_SCLP_GV("VALIDATESCLPGV", resp);
	}

	@Test
	public void API_GV_SCLP_VALIDATE_UI() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV_UI("VALIDATESCLPGV_UI","5004000019142061", "111755");
		validation_SCLP_GV("VALIDATESCLPGV_UI", resp);
	}

	@Test
	public void API_GV_SCLP_VALIDATE_InsufficentBalance() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("VALIDATEINSUFFSCLPGV","");
		validation_SCLP_GV("VALIDATEINSUFFSCLPGV", resp);
	}
	@Test
	public void API_GV_SCLP_VALIDATE_LIST() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("VALIDATELISTGVSCLP","");
		validation_SCLP_GV("VALIDATELISTGVSCLP", resp);
	}
	@Test
	public void API_GV_SCLP_GET_EXPIRY() throws ClassNotFoundException, SQLException  {
		Response resp ;
		resp = rearchGV1("GVSCLPGETEXPIRY","");
		validation_SCLP_GV("GVSCLPGETEXPIRY", resp);
	}



}