package com.mart.vibe.userTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mart.vibe.api.Pojoclass.CreateAccountPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class PostUserAccountTest{
	
	
	@Test
	public void createAccTest() {
		String expmsg ="user added successfully";
		
		CreateAccountPojo cobj =new CreateAccountPojo("User", "User@gmail.com","9876543210", "User", "User");
//		JSONObject jobj =new JSONObject();
//		jobj.put("fullName", "Admin");
//		jobj.put("email", "Admin@gmail.com");
//		jobj.put("password", "Admin");
//		jobj.put("password", "Admin");
		
		Response resp =given()
		.contentType(ContentType.JSON)
		.body(cobj)
		.when()
		.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users");
		resp.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		String actmsg = resp.jsonPath().get("msg");
		Assert.assertEquals(expmsg, actmsg);
		
	}

	
}
