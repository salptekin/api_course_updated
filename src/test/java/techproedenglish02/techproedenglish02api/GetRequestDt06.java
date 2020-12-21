package techproedenglish02.techproedenglish02api;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import TestBaseDtUrls.TestBaseJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequestDt06 extends TestBaseJsonPlaceHolder{
	
	/*
	   When 
	   		I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/123
	   Then 
	   		HTTP Status Code should be 200
		    And "Server" in Headers should be "cloudflare"
		    And response content type is “application/JSON”
		    And "userId" should be 7,
		    And "title" should be "esse et quis iste est earum aut impedit"
			And "completed" should be false
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec01.pathParams("name", "todos",
				          "id",123);
		
		//2) Set the expected data (We will learn it later)

		//3) Send the request
		Response response = given().
								accept(ContentType.JSON).
								spec(spec01).
							when().
								get("/{name}/{id}");
		
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		response.
			then().
			assertThat().
			statusCode(200).
			header("Server", "cloudflare").
			contentType(ContentType.JSON).
			body("userId", equalTo(7),
				 "title", equalTo("esse et quis iste est earum aut impedit"),
				 "completed", equalTo(false));

	}

}
