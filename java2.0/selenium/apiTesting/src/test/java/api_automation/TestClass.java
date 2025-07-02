package api_automation;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class TestClass {

	@Test(priority=1,enabled=true)
	private void createUser() {
		 RestAssured.baseURI = "https://reqres.in";
		
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("morpheus"));
}
	
	@Test(priority=2,enabled=true)
	public void getUser() {
		
		given()
		.baseUri("https://reqres.in")
		.when()
		.get("/api/users/2")
		.then()
		.assertThat()
		.statusCode(200)
		.body("data.id",equalTo(2));
	}

	
}
