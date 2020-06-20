package details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static io.restassured.config.HeaderConfig.headerConfig;

public class Config {
	
	// OPTIONS method returns info about API (methods/content type)

	// HEAD method returns info about resource (version/length/type)
	
	@Test
	public void getIncidents() {
		
		// Step 1: End Point ( server, port, resources)
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";		
		
		// Step 2:  (Authentication -> Basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		/*RestAssured.config = RestAssured.config().redirect(redirectConfig().followRedirects(false));
		RestAssured.config().headerConfig(headerConfig().overwriteHeadersWithName("accept"));*/
		
		// Step 3:  (Request -> get)
		Response response = RestAssured
				.given()
				/*.config(RestAssured.config().)*/
	            .log().all()
	        .when()
	            .get();
		
		// Step 4:  (Response -> status code, body)
		response.prettyPrint();
		
		int statusCode = response.getStatusCode();
		System.out.println("The stats code is "+statusCode);
	
		
	}
	

}
