package techproedenglish02.techproedenglish02api;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetRequest01 {
	
	/*
	 	If you use "Given", "When", "Then", "And" to create scenarios, it means you are using "Gherkin Language"
	 	
	 	"Given": It declares prerequisites
	 	"When": It defines the action which user will perform
	 	"Then":Talk about outputs
	 	"And":In any part if you have multiple things use "And" between them
	 */
	
	/*
		 								Positive Scenario 							
		 When 
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3    
		 Then 
		     HTTP Status Code should be 200
		 And  
		     Content Type should be JSON
		 And  
		     Status Line should be HTTP/1.1 200 OK
	*/
	
	@Test
	public void get01() {
		
		//1) Set the URL
		String url = "https://restful-booker.herokuapp.com/booking/3";
		
		//2) Set the expected data (We will learn it later)
		
		//3) Send the request (Like clicking on "Send" button on Postman)
		Response response = given().
				                //If you use accept("application/json"), it means you want the response in JSON Format
								accept("application/json"). 
							when().
							    get(url);
		
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case (Like checking status code, response body etc. on Postman)
		//Note: If execution stops after first error, it is called "Hard Assertion"
		//Note: If execution does not stop for any error, it is called "Soft Assertion". I
		//      If you use "Soft Assertion", all assertion code will be executed then you will get report 
		//      for all errors
		
		//Following syntax is "Hard Assertion" everytime
		response.
				then().
				assertThat().
				statusCode(200).
				contentType("application/json").
				statusLine("HTTP/1.1 200 OK");
		
		//How to print content-type, statuss code, status line, etc. on the console...
		System.out.println(response.getContentType());//application/json; charset=utf-8
		System.out.println(response.getStatusLine());//HTTP/1.1 200 OK
		System.out.println(response.getStatusCode());//200
		System.out.println(response.getTime());//676
		System.out.println(response.getHeaders());

	}
}
