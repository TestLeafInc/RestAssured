package chaining;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification request;
	public static String sys_id;
	
	@BeforeSuite
	public void initialize() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		request = RestAssured.given().log().all().contentType(ContentType.JSON);
		
	}

}
