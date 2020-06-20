package details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetCookies {
	
	@Test
	public void getAllIncidents() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		//RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Add the parameters
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "software");
				
		// Step 3: Request type - Get + query param -> Response
		Response response = RestAssured
				.given()
				.queryParams(parametersMap)
				.cookie(new Cookie.Builder("JSESSIONID").build())
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		
		response.prettyPrint();
		
		// Print the cookies
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> eachCookie : cookies.entrySet()) {
			System.out.println(eachCookie.getKey());
			System.out.println(eachCookie.getValue());
			System.out.println();
		}
		
		
	}
	

}
