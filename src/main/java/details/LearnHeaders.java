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
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class LearnHeaders {
	
	
	
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
		
		Headers headersMap = new Headers(headersList);
				
		// Step 3: Request type - Post wth Content Type -> Response
		Response response = RestAssured
				.given()
				.log()
				.all()
				.param("sysparm_limit", "1")
				.headers(headersMap)
			/*	.contentType(ContentType.JSON)
				.accept(ContentType.XML)*/
				.get()/*
				.then()
				.statusCode(200)
				.assertThat()
				.body("result.number", equalTo("INC0000011"))
				.body("result.severity", equalTo("INC0000011"))*/;
				
		response.prettyPrint();
				
		/*// Step 4: Validate (Response -> Status Code : 204)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well
		System.out.println(response.getTime());
		
		// Check what is the response format
		System.out.println(response.getContentType());*/
		
		// print the response
		//response.prettyPrint();
		
	
			
	}
	

}
