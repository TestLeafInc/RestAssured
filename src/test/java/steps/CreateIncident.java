package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {
	
	public static RequestSpecification request;
	public static String sys_id;
	public static Response response;

	
	@Given("Request URL is Initiated")
	public void initiateRequestEndPoint() {
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
	}
	
	@And("Authorization is performed")
	public void authorize() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	@When("Body is posted with Json file (.*)$")
	public void postRequest(String fileName) {
		response = RestAssured.given().log().all().contentType(ContentType.JSON)
				.body(new File(fileName))
				.post();
	}
	
	@Then("Status code should be (.*)$")
	public void verifyStatusCode(int code) {
		if(response.getStatusCode() == code) {
			System.out.println("Matches");
		}else {
			System.err.println("Do not match");
		}
	}
	
	
	@And("Response time within (.*) seconds$")
	public void verifyTime(int time) {
		System.out.println(response.getTime());
		if(response.getTime() < (time*1000)) {
			System.out.println("Response is great");
		}else {
			System.err.println("Response is bad");
		}
	}
	
	
	
	
	
	
	

}
