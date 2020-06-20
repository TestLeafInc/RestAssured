package details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class SessionFilters {

	@Test
	public void verifyFilters() {

		// Step 1: End Point ( server, port, resources)
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";		

		//RestAssured.authentication = RestAssured.basic("", "");
		// SessionFilter
		
		SessionFilter filter = new SessionFilter();		
		
		// Step 3:  (Request -> get)
		RestAssured
			.given()
			.auth()
			.basic("admin", "Tuna@123")
			.filter(filter)
			.get()
			.then()
			.statusCode(200);
		
		// getSessionId
		String sessionId = filter.getSessionId();
		System.out.println(sessionId);

		// Step 4: Using session
		RestAssured
			.given()
			.filter(filter)
			.get()
			.then()
			.statusCode(200);
		


	}
}
