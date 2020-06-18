package chaining;

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

public class DeleteIncident extends BaseRequest {	
	
	
	@Test(dependsOnMethods="chaining.CreateIncidentWithBody.createNewIncident")
	public void deleteIncident() {
				
		// Step 3: Request type - Post wth Content Type -> Response
		Response response = 
				request
				.delete(sys_id);
				
				
		// Step 4: Validate (Response -> Status Code : 204)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well
		System.out.println(response.getTime());
		
		// Check what is the response format
		System.out.println(response.getContentType());
		
		// print the response
		response.prettyPrint();
		
	
			
	}
	

}
