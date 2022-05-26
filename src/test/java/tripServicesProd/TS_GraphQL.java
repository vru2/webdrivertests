package test.java.tripServicesProd;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TS_GraphQL extends TripserviceCommon{
	@Test(groups={"Regression"})
	public void postGraphQL() throws IOException{
		Response resp;
		String url =  "http://trip-service.cltp.com:9001/graphql";
			resp=TripserviceGraphQL(graphql_prod,headersForTripservicepostgraphql(),url);
			System.out.println(resp.asString());
			validationforgraphql(resp);
	}
}
