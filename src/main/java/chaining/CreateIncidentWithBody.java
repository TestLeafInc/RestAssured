package chaining;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody extends BaseRequest {
	
	@Test
	public void createNewIncident() {
		
		// Step 1: Request type - Post wth Content Type -> Response
		Response response = 
				request
				.body("{\"short_description\" : \"Good Start\",\"description\" : \"Babu\",\"category\" : \"software\"}")
				.post();
				
				
		// Convert the response as JSON
		JsonPath jsonResponse = response.jsonPath();
		
		// it is get -> Single record
		sys_id = jsonResponse.get("result.sys_id");
		System.out.println(sys_id);
			
	}
	

}
