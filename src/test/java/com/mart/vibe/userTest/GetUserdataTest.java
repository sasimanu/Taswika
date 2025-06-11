package com.mart.vibe.userTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.mart.vibe.api.Pojoclass.LoginPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserdataTest{
	
	@Test
	public void Userdatatest() {
		
		//API-1 capture UserId
		LoginPojo lobj =new LoginPojo("admin@gmail.com", "admin");
		Response resp = given()
					.contentType(ContentType.JSON)
					.body(lobj)
					.when()
					.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users/login");
					resp.then()
					.contentType(ContentType.JSON)
					.statusCode(200)
					.log().all();
					String userId =resp.jsonPath().get("userId");
					
		//API-2 get UserData			
		given()
		.pathParam("userId",userId)
		.contentType(ContentType.JSON)
		.when()
		.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users")
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
