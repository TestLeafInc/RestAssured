package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getAllIncidents() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Step 3: Request type - Get -> Response
		Response response = RestAssured.get();
		
		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well 
		
		// Check what is the response format
		System.out.println(response.getContentType());
		
		// print the response
		response.prettyPrint();
		
	}
	

}
