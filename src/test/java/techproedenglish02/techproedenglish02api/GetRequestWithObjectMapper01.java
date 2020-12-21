package techproedenglish02.techproedenglish02api;

import java.util.Map;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import Utilities.JsonUtil;
import io.restassured.response.Response;

public class GetRequestWithObjectMapper01 extends TestBaseJsonPlaceHolder {
	
	/*
	 	When 
	 		I send GET Request to the URL https://jsonplaceholder.typicode.com/todos/198
	 		
	 	Then 
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
	 	
     */
	
	@Test
	public void get01() {
		
		//Set the URL
		spec.pathParams("todosPath", "todos",
				        "id", 198);
		
		//Set the Expected Data
		String expectedJson = "{\n"
								+ "\"userId\": 10,\n"
								+ "\"id\": 198,\n"
								+ "\"title\": \"quis eius est sint explicabo\",\n"
								+ "\"completed\": true\n"
								+ "}";
		
		
		Map<String, Object> expectedMap = JsonUtil.convertJsonToJava(expectedJson, Map.class);
		System.out.println(expectedMap);
		
		//Send the Request
		Response response = given().spec(spec).when().get("/{todosPath}/{id}");
		response.prettyPrint();
		
		//Convert response body to a map by using convertJsonToJava() method 
		//Instead of using "toString()" use "asString()"
		Map<String, Object> actualMap = JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(actualMap);
		
		//Assert
		assertEquals(expectedMap.get("userId"), actualMap.get("userId"));
		assertEquals(expectedMap.get("id"), actualMap.get("id"));
		assertEquals(expectedMap.get("title"), actualMap.get("title"));
		assertEquals(expectedMap.get("completed"), actualMap.get("completed"));

	}

}
