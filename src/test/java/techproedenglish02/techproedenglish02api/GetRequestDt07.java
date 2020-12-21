package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import TestBaseDtUrls.TestBaseHerOkuApp;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequestDt07 extends TestBaseHerOkuApp {
	
	/*
		 Among the data there should be someone whose first name is Jim
		 URL: https://restful-booker.herokuapp.com/booking 
	*/
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec02.pathParam("bookingPath", "booking").
		       queryParam("firstname", "Jim");
		
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request
		Response response = given().
								spec(spec02).
							when().
							    get("/{bookingPath}");  
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		response.
			then().
			assertThat().
			statusCode(200);
		
		assertTrue(response.asString().contains("bookingid"));
		
	}
}
