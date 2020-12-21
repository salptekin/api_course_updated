package techproedenglish02.techproedenglish02api;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import TestBaseDtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequestDt01 extends TestBaseJsonPlaceHolder {
	
	/*
	 	When
	 		I send PUT Requst to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "userId": 21,
										    "title": "Wash the dishes",
										    "completed": false
										   }
	   Then 
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false,
									    "id": 198
									  }
	 */
	
	@Test
	public void put01() {
		
		//1) Set the URL
		spec01.pathParams("todosPath", "todos",
				          "id", 198);
		
		//2) Set the expected data
		JsonPlaceHolderTestData putReqBodyObj = new  JsonPlaceHolderTestData();
		Map<String, Object> putReqBodyMap = putReqBodyObj.setUpPutDataByUsingMap();
		
		//3) Send the request
		Response response = given().
								contentType(ContentType.JSON).
								spec(spec01).
								body(putReqBodyMap).
							when().
								put("/{todosPath}/{id}");
		response.prettyPrint();
		
		//4) Assert the things in Put Request body
		//1.Way: body() + putReqBodyMap() + Hard Assert ==> Homework
		
		//2.Way: JsonPath + putReqBodyMap() + Hard Assert ==> Homework
		
		//3.Way: GSON + putReqBodyMap() + Soft Assert
		Map<String, Object> actualDataMap = response.as(HashMap.class);
		System.out.println(actualDataMap);
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(actualDataMap.get("completed"), putReqBodyMap.get("completed"));
		softAssert.assertEquals(actualDataMap.get("title"), putReqBodyMap.get("title"));
		softAssert.assertEquals(actualDataMap.get("userId"), putReqBodyMap.get("userId"));

		softAssert.assertAll();

	}

}



























