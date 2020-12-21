package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import TestBaseNtUrls.TestBaseHerOkuApp;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequestNt07 extends TestBaseHerOkuApp {
	
	/*
		 When 
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  		Among the data there should be someone whose first name is "Mark" and last name is "Ericsson"  
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec.pathParam("bookingPath", "booking").
		     queryParams("firstname", "Susan",
		    		     "lastname", "Brown");	
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request
		Response response = given().
								spec(spec).
							when().
							    get("/{bookingPath}");
		response.prettyPrint();

		//4) Assert the things which are given in the test case
		response.then().assertThat().statusCode(200);
		
		assertTrue(response.asString().contains("bookingid"));

	}
}
