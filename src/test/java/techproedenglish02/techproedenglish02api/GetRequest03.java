package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest03 {

	/*
	  When 
	  	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001   
	  Then 
		 HTTP Status code should be 404
	  And
		 Status Line should be HTTP/1.1 404 Not Found
	  And 
	     Response body contains "Not Found"
	  And 
	     Response body does not contain "TechProEd" 
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/1001";
		
		//2) Set the expected data (We will learn it later)
				
		//3) Send the request
		Response response = given().
								accept(ContentType.JSON).
							when().
								get(url);
		response.prettyPrint();
				
		//4) Assert the things which are given in the test case
		//1.Way: Hard Assertion 
		response.
			then().
			assertThat().
			statusCode(404).
			statusLine("HTTP/1.1 404 Not Found");
		
		//2.Way: Hard Assertion ==> We have 3 methods a)assertEquals(Expected, Actual) 
		//                                            b)assertTrue(boolean)
		//                                            c)assertFalse(boolean)
		
		//Assert status code by using 2. way
		//assertEquals() compares the first and second parameters, if they match the test passes
		assertEquals(404, response.getStatusCode());
		assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
		
		//If the parameter is true assertTrue() passes, otherwise it fails
		assertTrue(response.asString().contains("Not Found"));
		
		//If the parameter is false assertFalse() passes, otherwise it fails
		assertFalse(response.asString().contains("TechProEd"));
		
		//3.Way: Soft Assertion ==> There are 3 steps in Soft Assertion
		//                          a)Create SoftAssert class object ==> SoftAssert softAssert = new SoftAssert();
		//                          b)Type assertions by using assertEquals(actual, expected), 
		//                                                     assertTrue(boolean) 
		//                                                     assertFalse(boolean)
		//                      *** c)Use assertAll(), if you forget to use assertAll(), you will get passed but it 
		//                            is not meaningful. ==> softAssert.assertAll();
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(response.getStatusCode(), 404);
		softAssert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");
		
		softAssert.assertTrue(response.asString().contains("Not Found"));
		softAssert.assertFalse(response.asString().contains("TechProEd"));

		softAssert.assertAll();

	}
}
