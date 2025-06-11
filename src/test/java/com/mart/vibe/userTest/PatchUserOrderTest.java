package com.mart.vibe.userTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.mart.vibe.api.Pojoclass.LoginPojo;
import com.mart.vibe.api.Pojoclass.ProductPojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchUserOrderTest {

	@Test
	public void patchTest() {
		
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
							
		//API-2 add product to order
			ProductPojo pobj = new ProductPojo(1, "No:1","Bengalore", "India", "Tekpyramid", "Admin", "9087654321", "5640009", "Karnataka", "3rd Phase", "Office", "COD");
			Response respo= given()
					.contentType(ContentType.JSON)
					.body(pobj)
					.when()
					.post("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users/"+userId+"orders");
					respo.then()
					.contentType(ContentType.JSON)
					.statusCode(201)
					.log().all();
					String orderId =resp.jsonPath().get("orderId");
					
		//API-3 Update order Status
					given().queryParam("status","OUT_FOR_DELIVERY")
							.contentType(ContentType.JSON)
							.body(pobj)
							.when()
							.patch("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/users/"+userId+"orders"+orderId)
							.then()
							.contentType(ContentType.JSON)
							.statusCode(200)
							.log().all();
				
			
			
	}
}
