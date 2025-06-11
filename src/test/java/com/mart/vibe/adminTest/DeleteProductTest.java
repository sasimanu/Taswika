package com.mart.vibe.adminTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteProductTest {

	@Test
	public void postTest() {
		
		//API-1 get productId
		Response resp =given()
		.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin/products");
		resp.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	String proId =resp.jsonPath().get("productId");

	
	//API-2 delete product
	given()
	.delete("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin/products"+proId);
	resp.then()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	
	}
}