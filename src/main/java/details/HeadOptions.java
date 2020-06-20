package details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeadOptions {
	
	// OPTIONS method returns info about API (methods/content type)

	// HEAD method returns info about resource (version/length/type)
	
	@Test
	public void getIncidents() {
		
		// Step 1: End Point ( server, port, resources)
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";		
		
		// Step 2:  (Authentication -> Basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Step 3:  (Request -> get)
		Response response = RestAssured.options();
		
		// Step 4:  (Response -> status code, body)
		response.prettyPrint();
		
		int statusCode = response.getStatusCode();
		System.out.println("The stats code is "+statusCode);
	
		
	}
	

}
