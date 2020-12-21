package techproedenglish02.techproedenglish02api;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest02 {
	
	/*
				 			Negative Scenario
			When 
			    I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/1001
			Then 
				HTTP Status code should be 404
			And  
				Status Line should be HTTP/1.1 404 Not Found
	*/
	
	@Test
	public void get01() {
		
		//1) Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/1001";
		
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request
		// ContentType.JSON and "application/json" have same meaning but use ContentType.JSON 
		Response response = given().
								accept(ContentType.JSON).
							when().
								get(url);
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		response.
				then().
				assertThat().
				statusCode(404).
				statusLine("HTTP/1.1 404 Not Found");

	}
}
