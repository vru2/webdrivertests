package test.java.  tripServices;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_GraphQL extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void postGraphQL() throws IOException{
		Response resp;
		String url =  Service_Url("TRIPSERVICE_POST_GRAPHQL");
			Reporter.log(url);
			resp=TripserviceGraphQL(graphql_qa,headersForTripservicepostgraphql(),url);
			System.out.println(resp.asString());
			validationforgraphql(resp);
	}
}
