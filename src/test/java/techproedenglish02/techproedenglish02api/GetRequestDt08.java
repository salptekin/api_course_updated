package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import TestBaseDtUrls.TestBaseHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestDt08 extends TestBaseHerOkuApp {
	
	/*
	  When 
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5 
	  Then 
		  HTTP Status Code should be 200
		  And response content type is “application/JSON” 
		  And response body should be like; 
		  { "firstname": "Sally", 
		    "lastname": "Ericsson", 
		    "totalprice": 111,
		    "depositpaid": false, 
		    "bookingdates": { "checkin": "2017-05-23", 
		                      "checkout":"2019-07-02" }
		  }
	 */
	
	/*
	 	Note: There is a class "JsonPath" class, it is used to navigate in Json Data
	*/
	
	@Test
	public void get01() {
		spec02.pathParams("bookingPath", "booking",
				          "id", 5);
		
		Response response = given().
								spec(spec02).
							when().
							    get("/{bookingPath}/{id}");
		response.prettyPrint();
		
		//How to use JsonPath Class to navigate in Json Data
		JsonPath json = response.jsonPath();
		
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON);
		
		assertEquals("First name is not matching!", "Susan",json.getString("firstname"));
		assertEquals("Last name is not matching!", "Ericsson", json.getString("lastname"));
		assertEquals("Total price is not matching", 385, json.getInt("totalprice"));
		assertEquals("Deposit paid is not matching", true, json.getBoolean("depositpaid"));
		assertEquals("Checkin date is not matching", "2017-03-24", json.getString("bookingdates.checkin"));
		assertEquals("Checkout date is not matching", "2018-11-01", json.getString("bookingdates.checkout"));
		assertEquals("Additional need is not matching", "Breakfast", json.getString("additionalneeds"));

	}

}
