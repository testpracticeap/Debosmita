package com.demo.restAssured;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deserialization {
	
	@Test
	public void getJson() throws IOException {
		RestAssured.baseURI= "http://restapi.adequateshop.com/api/Tourist";
		RequestSpecification httpreq= RestAssured.given();
		Response response= httpreq.request(Method.GET);
		String responseBody= response.getBody().asString();
		System.out.println(responseBody);
		
//		io.restassured.path.json.JsonPath jsonPath= response.jsonPath();
//		String touristName= jsonPath.getString("data[0].tourist_name");
//		System.out.println(touristName);
		
		
		Object name= com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[0]");
		System.out.println(name.toString());
		
		ObjectMapper mapper= new ObjectMapper();
		String json= mapper.writeValueAsString(name);
		
		TypeReference<HashMap<String, Object>> typeref= new TypeReference<HashMap<String, Object>>(){
		
		};
		
		HashMap<String, Object> entry= mapper.readValue(json, typeref);
		for(Entry<String, Object> data: entry.entrySet()) {
			System.out.println(data.getKey()+":"+data.getValue());	
		}
		//assert.assertEquals("Lia22", response.jsonPath().getString("tourist_name"));
		
	}
}