package params;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FormParam {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control/login";
		
		// Step 2: Request type - Post + form param
		Response post = RestAssured
			.given()
			.contentType(ContentType.URLENC)
			.when()
			.formParam("USERNAME", "DemoCSR2")
			.formParam("PASSWORD", "crmsfa")
//			.body("")
			.post();
			
		post.prettyPrint();
		
	}
	

}
