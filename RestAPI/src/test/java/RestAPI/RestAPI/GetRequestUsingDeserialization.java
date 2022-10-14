package RestAPI.RestAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequestUsingDeserialization {
	
	@Test
	public void GetRequest() {

	RestAssured.baseURI= "https://demoqa.com/BookStore/v1/Books";
	RequestSpecification httpreq= RestAssured.given();
	Response response= httpreq.request(Method.GET);
	String responseBody= response.getBody().asString();
	System.out.println(responseBody);
	//Assert.assertEquals("Richard E. Silverman", response.jsonPath().getString("author"));
	
	Object json= com.jayway.jsonpath.JsonPath.read(response.asString(), "$.books[1].author");
	String author= json.toString();
	Object jsondes= com.jayway.jsonpath.JsonPath.read(response.asString(), "$.books[1].description");
	String description= jsondes.toString();
	
	Assert.assertEquals("Addy Osmani", author);	
	String desc= "With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language. If you want to keep your code efficient, more manageable, and up-to-da";
	Assert.assertEquals(desc, description);
	
	//ObjectMapper mapper= new ObjectMapper();
}
}
