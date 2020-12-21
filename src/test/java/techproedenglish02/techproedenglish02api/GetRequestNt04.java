package techproedenglish02.techproedenglish02api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestNt04 {
	
	/*
		 When 
		 	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1   
		    And Accept type is “application/JSON”
		 Then 
		    HTTP Status Code should be 200
		    And Response format should be "application/JSON"
		    And "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
		    And "completed" is false
		    And "userId" is 2
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		String url = "https://jsonplaceholder.typicode.com/todos/23";
		
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request
		Response response = given().
								//accept(ContentType.JSON).//"application/json" and ContentType.JSON are same
							when().
							    get(url);
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		//1.Way:
			//1.Way of 1.Way
//			response.
//				then().
//				assertThat().
//				statusCode(200).
//				contentType(ContentType.JSON).
//				body("title", Matchers.equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//				body("completed", Matchers.equalTo(false)).
//				body("userId", Matchers.equalTo(2));
			
			//2.Way of 1.Way:Recommended
			response.
				then().
				assertThat().
				statusCode(200).
				contentType(ContentType.JSON).
				body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
					 "completed", equalTo(false),
					 "userId", equalTo(2));
		//2.Way:
			//In that test case, using this way is not good because your assertions are not specific
			//You are just checking if a large String containing a word, but in the 2.Way of 1.Way 
			//we are asserting everything with details like completed is false, user id is 2 etc.
			assertEquals(200,response.getStatusCode());
			assertEquals("application/json; charset=utf-8", response.getContentType());
			assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
			assertTrue(response.asString().contains("false"));
			assertTrue(response.asString().contains("2"));
			
		//3.Way:
			SoftAssert softAssert = new SoftAssert();
			
			softAssert.assertEquals(response.getStatusCode(), 200);
			softAssert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
			
			softAssert.assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
			softAssert.assertTrue(response.asString().contains("false"));
			softAssert.assertTrue(response.asString().contains("2"));

			softAssert.assertAll();
	}
}
