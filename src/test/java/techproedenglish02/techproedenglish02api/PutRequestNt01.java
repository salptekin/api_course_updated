package techproedenglish02.techproedenglish02api;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequestNt01 extends TestBaseJsonPlaceHolder {
	
	/*
	   When
	 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "userId": 21,
										    "title": "Wash the dishes",
										    "completed": false
										   }
	   Then 
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false,
									    "id": 198
									   }
	 */
	
	@Test
	public void put01() {
		
		//1) Set the URL
		spec.pathParams("todosPath", "todos",
				        "id", 198);
		
		//2) Set the expected data
		JsonPlaceHolderTestData putReqObj = new JsonPlaceHolderTestData();
		Map<String, Object> putReqDataMap = putReqObj.setUpPutDataByUsingMap();
		
		
		//3) Send the request
		Response response = given().
				                contentType(ContentType.JSON).
								spec(spec).
								body(putReqDataMap).
							when().
								put("/{todosPath}/{id}");
		response.prettyPrint();
		
		
		//4) Assert the things which are given in the test case
		//1.Way: body() + putReqDataMap ==> Homework
		//2.Way: JsonPath + putReqDataMap ==> Homework
		//3.Way: GSON + putReqDataMap + Soft Assertion
		
		Map<String, Object> actualDataMap = response.as(HashMap.class);
		System.out.println(actualDataMap);
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(actualDataMap.get("completed"), putReqDataMap.get("completed"));
		softAssert.assertEquals(actualDataMap.get("userId"), putReqDataMap.get("userId"));
		softAssert.assertEquals(actualDataMap.get("title"), putReqDataMap.get("title"));

		softAssert.assertAll();
	
	}
}
