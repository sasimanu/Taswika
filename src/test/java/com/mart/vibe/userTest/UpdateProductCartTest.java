package com.mart.vibe.userTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mart.vibe.api.Pojoclass.LoginPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProductCartTest {

	@Test
	public void putTest() {
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
		
							
		//API-2 get ProductId
		Response respo = given().auth().oauth2("gatvyu4hy81u89lk")
		              .get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/products");
					resp.then()
						.contentType(ContentType.JSON)
						.statusCode(200)
						.log().all();
			String proId =resp.jsonPath().get("productId");
									
		//API-3 add to cart
									
		JSONObject jobj =new JSONObject();
		jobj.put("productId", proId);
		jobj.put("quantity", "1");
		Response response =given()
		            .contentType(ContentType.JSON)
					.body(jobj)
					.when()
					.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users/"+userId+"/carts");
			response.then()
					.contentType(ContentType.JSON)
					.statusCode(201)
					.log().all();
			String itemId=response.jsonPath().get("itemId");
						
		//API-4 update order
						
			JSONObject jsobj =new JSONObject();
			jobj.put("productId", proId);
			jobj.put("quantity", "2");
			      given()
						.contentType(ContentType.JSON)
						.body(jsobj)
						.when()
						.put("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users/"+userId+"/carts"+itemId)
						.then()
						.contentType(ContentType.JSON)
						.statusCode(200)
						.log().all();
	}
}
