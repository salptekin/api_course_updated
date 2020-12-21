package techproedenglish02.techproedenglish02api;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest11 extends TestBaseJsonPlaceHolder {
	
	/*
	  *** De-Serialization: Converting JSON Data to Java Object is called De-Serialization
	  Serialization: Converting Java Object to JSON Data is called Serialization
	  
	  For De-Serialization and Serialization we can use 1)GSON and 2)Object Mapper
	  
	  1)GSON is a Java Library: It is easy to use because of that it is popular
	  2)Object Mapper is a Library: It is new and being popular.
	*/
	
	/*
	  When 
	  		I send GET Request to https://jsonplaceholder.typicode.com/todos/2
	  Then 
	  		Status code is 200
	  		And "completed" is false
	  		And "userId" is 1
	  		And "title" is "quis ut nam facilis et officia qui"
	  		And header "Via" is "1.1 Vegur"
	  		And header "Server" is "cloudflare"
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec.pathParams("todoPath", "todos", 
				        "id", 198);

		//2) Set the expected data
		JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();
		HashMap<String, Object> expectedDataMap = expectedObj.setUpData();
		
		
		//3) Send the request
		Response response = given().
								spec(spec).
							when().
								get("/{todoPath}/{id}"); 
		
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
			//1.Way:
			response.
				then().
				assertThat().
				statusCode((Integer) expectedDataMap.get("StatusCode")).
				body("completed", equalTo(expectedDataMap.get("completed")),
					 "userId", equalTo(expectedDataMap.get("userId")),
					 "title", equalTo(expectedDataMap.get("title"))).
				headers("Via", expectedDataMap.get("headerVia"), 
						"Server", expectedDataMap.get("Server"));
			
			//2.Way:
			//We will use De-Serialization to convert response body JSON Data to JAVA Object
			HashMap<String, Object> actualDataMap = response.as(HashMap.class);
			System.out.println(actualDataMap);
						
			assertEquals(expectedDataMap.get("StatusCode"), response.getStatusCode());
			
			assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
			assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
			assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
			
			assertEquals(expectedDataMap.get("headerVia"), response.getHeader("Via"));
			assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));
			
			//3.Way:
			SoftAssert softAssert = new SoftAssert();
			
			softAssert.assertEquals(actualDataMap.get("completed"), expectedDataMap.get("completed"));
			softAssert.assertEquals(actualDataMap.get("userId"), expectedDataMap.get("userId"));
			softAssert.assertEquals(actualDataMap.get("title"), expectedDataMap.get("title"));
			
			softAssert.assertEquals(response.getHeader("Via"), expectedDataMap.get("headerVia"));
			softAssert.assertEquals(response.getHeader("Server"), expectedDataMap.get("Server"));

			softAssert.assertAll();
	
	}

}
