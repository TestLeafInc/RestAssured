package basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncident {
	
	@Test
	public void createNewIncident() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		
		// Step 3: Request type - Post wth Content Type -> Response
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
				
				
		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well
		System.out.println(response.getTime());
		
		// Check what is the response format
		System.out.println(response.getContentType());
		
		// print the response
		response.prettyPrint();
		
		// Convert the response as JSON
		JsonPath jsonResponse = response.jsonPath();
		
		// it is get -> Single record
		String sys_id = jsonResponse.get("result.sys_id");
		System.out.println(sys_id);
			
	}
	

}
