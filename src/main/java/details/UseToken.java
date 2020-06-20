package details;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UseToken {
	
	@Test
	public void confirmTokenWorks() {
		
		RestAssured.baseURI = "https://api.zoom.us/v2/users/";
		
		RestAssured.authentication = RestAssured.oauth2("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6ImZXX3duS281UWotb01Da09BNkg4bXciLCJleHAiOjE1OTI2MzA0NDksImlhdCI6MTU5MjYyNTA2MH0.IUfIqMfOYx_CTbgSN-YKXwLWqPV1AeF1WL47Go015to");
		
	}

}
