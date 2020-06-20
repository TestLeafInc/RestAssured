package details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class SchemaValidation {

	@Test
	public void verifyJsonSchema() {
		
		// Step 1: End Point ( server, port, resources)
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";		
		
		// Step 2:  (Authentication -> Basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Step 3:  (Request -> get)
		Response response = RestAssured
				.get()
				.then()
				.body(matchesJsonSchemaInClasspath("response.json"))
				.extract()
				.response();
	
		
	}
}
