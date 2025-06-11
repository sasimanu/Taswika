package com.mart.vibe.adminTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostProductTest {

	@Test
	public void postTest() {
		JSONObject jobj =new JSONObject();
		jobj.put("Category", "MakeUpProducts");
		jobj.put("subCategory", "Lipstick");
		jobj.put("productName", "LakmeeLiptick");
		jobj.put("Price", "360");
		jobj.put("Availability", "InStock");
		
		Response resp =given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin/products");
		resp.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
	}
}
