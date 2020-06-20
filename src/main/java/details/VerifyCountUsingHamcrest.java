package details;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class VerifyCountUsingHamcrest {
	
	@Test
	public void getIssues() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/search?jql=project='MAR'";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
		
		List<Header> headersList = new ArrayList<Header>();
		headersList.add(new Header("content-type", "application/json"));
		headersList.add(new Header("accept", "*/*"));
		Headers headersMap = new Headers(headersList);				

		RestAssured
				.given()
				.log()
				.all()
				.headers(headersMap)
				.get()
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.assertThat()
				.body("total", equalTo(879),"","");
			
	}
}
