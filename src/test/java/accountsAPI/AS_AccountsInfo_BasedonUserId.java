package test.java.  accountsAPI;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AS_AccountsInfo_BasedonUserId  extends AccountsCommon_API {

	@Test
	public void AccountsInfoAPI_BasedonUserId() throws IOException, JSONException {

		Response resp;
		resp = postCall("AccountsInfoAPI_BasedonUserId", "");
		validation(resp, "AccountsInfoAPI_BasedonUserId", "");

	}
}
