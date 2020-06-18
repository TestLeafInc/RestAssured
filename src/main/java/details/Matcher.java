package details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class Matcher {
	
	@Test
	public void createNewIncident() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		
		// Step 3: Request type - Post wth Content Type -> Response
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\" : \"Good Start\",\"description\" : \"Babu\",\"category\" : \"software\"}")
				.post()
				.then()
				.assertThat()
				.body("result.short_description", equalTo("Good Start"));
				
				
		
	}
	

}
