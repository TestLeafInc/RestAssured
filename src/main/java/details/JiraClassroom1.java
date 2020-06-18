package details;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class JiraClassroom1 {
	
	@Test
	public void getIssues() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/search?jql=project='MAR'";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
		
		//RestAssured.proxy("url");
		//RestAssured.useRelaxedHTTPSValidation();
		
		// Step 3: Request type - Post wth Content Type -> Response
		RestAssured
				.given()
				.log()
				.all()
				.param("maxResults", "1")
				.get()
				.then()
				.statusCode(200)
				.log()
				.ifValidationFails();
		
		/*response.prettyPrint();
				
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> eachCookie : cookies.entrySet()) {
			System.out.println(eachCookie.getKey());
			System.out.println(eachCookie.getValue());
		}
		*/
	
			
	}
}
