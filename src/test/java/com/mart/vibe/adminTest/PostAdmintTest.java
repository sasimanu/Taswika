package com.mart.vibe.adminTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mart.vibe.api.Pojoclass.LoginPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAdmintTest {

	@Test
	public void postTest() {
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
							
	}
}
