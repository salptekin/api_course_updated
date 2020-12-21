package techproedenglish02.techproedenglish02api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestDt04 {
	/*
	 When 
	 	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1   
	    And Accept type is “application/JSON”
	 Then 
	    HTTP Status Code should be 200
	    And Response format should be "application/JSON"
	    And first name should be "Susan"
	    And last name should be "Brown"
	    And checkin date should be "2015-02-16"
	    And checkout date should be "2017-06-20"
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/1";
		
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request
		Response response = given().
				                //accept(ContentType.JSON).
				            when().
				            	get(url);
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		//1.Way:
			//1.Way of 1.Way:Not recommended
//			response.
//				then().
//				assertThat().
//				statusCode(200).
//				contentType(ContentType.JSON).
//				body("firstname", Matchers.equalTo("Mark")).
//				body("lastname", Matchers.equalTo("Smith")).
//				body("totalprice", Matchers.equalTo(976)).
//				body("depositpaid", Matchers.equalTo(false)).
//				body("bookingdates.checkin", Matchers.equalTo("2019-11-09")).
//				body("bookingdates.checkout", Matchers.equalTo("2020-09-24"));
			//2.Way of 1.Way: Recommended
//			response.
//				then().
//				assertThat().
//				statusCode(200).
//				contentType(ContentType.JSON).
//				body("firstname", equalTo("Mark"),
//					 "lastname",equalTo("Smith"),
//					 "totalprice", equalTo(976),
//					 "depositpaid", equalTo(false),
//					 "bookingdates.checkin", equalTo("2019-11-09"),
//					 "bookingdates.checkout", equalTo("2020-09-24"));
			
		//2.Way:
		//In that test case, using this way is not good because your assertions are not specific
		//You are just checking if a large String containing a word, but above we are asserting
		//everything with details like firstname is Mark, last name is Smith etc.
			assertEquals(200, response.getStatusCode());
//			assertEquals("application/json; charset=utf-8", response.getContentType());
//			assertTrue(response.asString().contains("Susan"));
//			assertTrue(response.asString().contains("Smith"));
			
	    //3.Way:
		//In that test case, using this way is not good because your assertions are not specific
		//You are just checking if a large String containing a word, but in the 2.Way of 1.Way 
		//we are asserting everything with details like firstname is Mark, last name is Smith etc.
		SoftAssert softAssert = new SoftAssert();	
			
		softAssert.assertEquals(response.getStatusCode(), 200);	
		softAssert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
		
		softAssert.assertTrue(response.asString().contains("2020-02-01"));
		softAssert.assertTrue(response.asString().contains("2020-11-07"));
			
			
		softAssert.assertAll();	

	}
}
