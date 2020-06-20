package details;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.FailureConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.config.FailureConfig.failureConfig;

public class FailureListeners {
	
	
	
	// Step 2: Received the data provider -> data as argument
	@Test
	public void deleteIncident() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		List<Header> headersList = new ArrayList<Header>();
		headersList.add(new Header("content-type", "application/json"));
		headersList.add(new Header("accept", "application/xml"));
		
		ResponseValidationFailureListener emailOnFailure = 
				(reqSpec, respSpec, resp) -> 
				EmailService.sendEmail("babu@testleaf.com", "Important test failed! Status code was: " + resp.statusCode());
				
		// Step 3: Request type - Post wth Content Type -> Response
		RestAssured
				 .given()
				 	.config(RestAssured.config().failureConfig(failureConfig().with().failureListeners(emailOnFailure)))
				 .when()
				  	.get()
				  .then()
					.statusCode(201);
				
			
	}
	

}
