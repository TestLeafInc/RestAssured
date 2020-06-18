package jira.chaining;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	public static RequestSpecification request;
	public static String issue_id;

	@BeforeSuite
	public void initialize() {

		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");


		request = RestAssured.given().log().all().contentType(ContentType.JSON);

	}

}
