package techproedenglish02.techproedenglish02api;

import java.util.Map;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PatchRequestNt01 extends TestBaseJsonPlaceHolder {
	
	/*
	   When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room"
										  
										   }
	   Then 
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
	 */
	
	@Test
	public void patch01() {
		
		//1) Set the URL
		spec.pathParams("todosPath", "todos",
				        "id", 198);
				
		//2) Set the expected data
		JsonPlaceHolderTestData patchReqObj = new JsonPlaceHolderTestData();
		Map<String, Object> patchReqDataMap = patchReqObj.setUpPatchDataByUsingMap();

		//3) Send the request
		Response response = given().
								contentType(ContentType.JSON).
								spec(spec).
								body(patchReqDataMap).
							when().
								patch("/{todosPath}/{id}");
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		//1.Way: body() + patchReqMap() ==> Homework
		//2.Way: GSON + patchReqMap() ==> Homework
		//3.Way: JsonPath + patchReqMap() + Hard Assertion
		JsonPath json = response.jsonPath();
		
		assertEquals(patchReqObj.statusCode, response.getStatusCode());
		assertEquals(patchReqDataMap.get("title"), json.getString("title"));
		assertEquals(patchReqObj.userId, json.getInt("userId"));
		assertEquals(patchReqObj.completed, json.getBoolean("completed"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
