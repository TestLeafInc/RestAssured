package basics;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ChangeIncident {
	
	
	
	// Step 2: Received the data provider -> data as argument
	@Test
	public void deleteIncident() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");		
		//RestAssured.authentication = RestAssured.oauth2("SErF-P065h2JubgaAX_qSXqijx2m0SMfgZyvn7gxvm1H3z96jDLM0Ng84mfeW_i9vf5CPxVCBYjBa3JpdH50PA");
		//RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.g@testleaf.com", "API-key");	
		
		Response getResponse = RestAssured.get();
		String sys_id = (String) getResponse.jsonPath().getList("result.sys_id").get(0);
		
		
		// Step 3: Request type - Post wth Content Type -> Response
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body("{\"short_description\" : \"Updated by RA using OAuth 2\"}")
				.put(sys_id);
				
				
		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well
		System.out.println(response.getTime());
		
		// Check what is the response format
		System.out.println(response.getContentType());
		
		// print the response
		response.prettyPrint();
		
	
			
	}
	

}
