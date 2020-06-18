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

public class UrlEncoding {
	
	@Test
	public void getAllIncidents() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident?sysparm_fields=Babu%20Manickam";
		
		// RestAssured with automatically perform URL encoding
		RestAssured.urlEncodingEnabled = false;
		
		// Step 2: Authentication (basic)
		//RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Add the parameters
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "software");
		parametersMap.put("sysparm_fields", "number, sys_id");
		
		Cookie session = new Cookie.Builder("JSESSIONID","5B6B38E26AC2DCADACC7F614B506D9BB").build();
		
		// Step 3: Request type - Get + query param -> Response
		Response response = RestAssured
				.given()
				.cookie(session)
				.params(parametersMap)
				.get();
		
		/*Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> eachCookie : cookies.entrySet()) {
			System.out.println(eachCookie.getKey());
			System.out.println(eachCookie.getValue());
		}*/
		
		/*String session = response.getCookie("JSESSIONID");
		System.out.println(session);*/
		
	}
	

}
