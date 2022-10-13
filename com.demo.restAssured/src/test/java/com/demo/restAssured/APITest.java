package com.demo.restAssured;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matcher;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	
	//post request
	//@Test
	public void postRequestUsingStaticFile() {
		File jsonData= new 
				File ("C:\\Users\\7000032453\\eclipse-workspace"
						+ "\\com.demo.restAssured"
						+ "\\src\\main\\resources\\Json\\JsonData.json");
		RestAssured.given()
		.baseUri("http://restapi.adequateshop.com/api/Tourist")
		.contentType(ContentType.JSON).body(jsonData)
		.when().post("/Tourist").then().log().all().assertThat().statusCode(201);

}
	//get request
	//@Test
	public void getRequest() {
		RestAssured.given()
		.baseUri("http://restapi.adequateshop.com/api/Tourist")
		.contentType(ContentType.JSON).when().get().then().log().all().
		assertThat().body(containsStringIgnoringCase("Lia22")).and().assertThat()
		.body(containsStringIgnoringCase("Cloae Hier Machaila"))
		.and().assertThat().body(containsStringIgnoringCase("HiercloaeM@gmail.com"));
}
	//get header
	@Test
	public void GetTouristHeaderDetails() {
		RestAssured.baseURI= "http://restapi.adequateshop.com/api/Tourist";
		RequestSpecification httpreq= RestAssured.given();
		Response response= httpreq.request(Method.GET,"");
		response= httpreq.get("");
		Headers header= response.headers();
		for(Header headersec:header) {
			System.out.println(headersec.getName()+":"+ headersec.getValue());	
		}
	}
	
	//put request
	//@Test
	public void putRequest() throws IOException {
		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/JsonDataPut.json"));
	      //convert byte array to string
	      String bdy = new String(b);
	      //base URL
	      RestAssured.given()      
			.baseUri("http://restapi.adequateshop.com/api").contentType(ContentType.JSON).body(bdy)
	      .when().put("/Tourist/165948").then().log().all()
	      .assertThat().statusCode(201);
		
	}
	
	//Delete Request
	//@Test
	public void deleteRequest() throws IOException {		
		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/JsonDataPut.json"));
	      String bdy = new String(b);
	      RestAssured.given() 
			.baseUri("http://restapi.adequateshop.com/api/Tourist").contentType(ContentType.JSON).body(bdy)
	      .when().delete("/Tourist/165826").then().log().all()
	      .assertThat().statusCode(201);
	}
}