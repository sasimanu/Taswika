package com.mart.vibe.userTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteProductReviewTest {

	@Test
	public void deleteTest() {
	//API-1 capture ProductId
			Response resp = given().auth().oauth2("gatvyu4hy81u89lk")
						.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/products");
					resp.then()
					.contentType(ContentType.JSON)
						.statusCode(200)
						.log().all();
						String proId =resp.jsonPath().get("productId");
						
	//API-2 capture reviewId
		Response respo = given()
					.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/reviews/"+proId);
			respo.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
		String reviewId =resp.jsonPath().get("reviewId");
		
		
	//API-3 delete review
		given().queryParam("productId", proId)
		.when().delete("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/reviews/"+reviewId)
		.then().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
}
}
