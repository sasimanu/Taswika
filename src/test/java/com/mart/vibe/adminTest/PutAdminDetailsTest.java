package com.mart.vibe.adminTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutAdminDetailsTest {

	
	@Test
	public void putTest() {
		//API-1 capture adminId
		JSONObject jobj =new JSONObject();
		jobj.put("fullName", "Admin");
		jobj.put("email", "Admin@gmail.com");
		jobj.put("password", "Admin");
		jobj.put("password", "Admin");
		
		Response resp =given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin");
		resp.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		String adminId =resp.jsonPath().get("adminId");
		
		//API-2 update admin Details
		JSONObject job =new JSONObject();
		jobj.put("fullName", "Admin");
		jobj.put("email", "Admin123@gmail.com");
		jobj.put("password", "Admin123");
		jobj.put("password", "Admin123");
		
		Response res =given()
		.contentType(ContentType.JSON)
		.body(job)
		.when()
		.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin"+adminId);
		res.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}
}
