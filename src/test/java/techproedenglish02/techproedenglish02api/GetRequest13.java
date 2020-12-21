package techproedenglish02.techproedenglish02api;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import TestBaseNtUrls.TestBaseHerOkuApp;
import TestData.HerOkuAppTestData;
import io.restassured.response.Response;

public class GetRequest13 extends TestBaseHerOkuApp {
	
	/*
	 	When 
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then 
	 		Response body should be like that;
	 		{
			    "firstname": "Eric",
			    "lastname": "Smith",
			    "totalprice": 555,
			    "depositpaid": false,
			    "bookingdates": {
			        "checkin": "2016-09-09",
			        "checkout": "2017-09-21"
			     }
			}
	*/
	
	@Test
	public void get01() {
		//1) Set the URL
		spec.pathParams("bookingPath", "booking",
						"id", 1);
		
		//2) Set the expected data
		HerOkuAppTestData expectedObj = new HerOkuAppTestData();
		Map<String, Object> expectedDataMap = expectedObj.setUpData();
		
		
		//3) Send the request
		Response response = given().spec(spec).when().get("/{bookingPath}/{id}");
		
		response.prettyPrint();

		//4) Assert the things which are given in the test case
		
		//GSON for De-Serialization
		Map<String, Object> actualDataMap = response.as(HashMap.class);
		System.out.println(actualDataMap);
		
		//assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
		//assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
		//assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
		//assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
		//assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
		assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
