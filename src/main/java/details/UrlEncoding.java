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
import static io.restassured.config.SSLConfig.sslConfig;

public class UrlEncoding {
	
	@Test
	public void getAllIncidents() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident?sysparm_fields=Babu%20Manickam";
		
		// RestAssured with automatically perform URL encoding
		RestAssured.urlEncodingEnabled = true;
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		//RestAssured.proxy = RestAssured.proxy.withHost("192.168.1.14").withPort(8083);
		//RestAssured.proxy = RestAssured.proxy.withScheme("");
		
		/*RestAssured.useRelaxedHTTPSValidation();
		
		RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation());*/
		
		// Add the parameters
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "software");
		parametersMap.put("sysparm_fields", "number, sys_id");
		
		
		// Step 3: Request type - Get + query param -> Response
		Response response = RestAssured
				.given()
				.params(parametersMap)
				.log().all()
				.get();
		
		
		
	}
	

}
