package details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.hasXPath;

public class BodyhasXPath {
	
	@Test
	public void getIncidents() {
		
		// Step 1: End Point ( server, port, resources)
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/change_request";		
		
		// Step 2:  (Authentication -> Basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Add Map
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("type", "emergency");
		parametersMap.put("sysparm_fields", "sys_id, type, number");		
		
		// Step 3:  (Request -> get)
		Response response = 
				RestAssured
				.given()
				.params(parametersMap)
				.accept(ContentType.XML)
				.get()
				.then()
				.body(hasXPath("/response/result/type[text()='normal']"))
				.extract()
				.response();
		
		// Step 4:  (Response -> status code, body)
		response.prettyPrint();
		
		
	}
	

}
