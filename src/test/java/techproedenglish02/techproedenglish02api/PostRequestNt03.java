package techproedenglish02.techproedenglish02api;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Test;

import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestNt03 extends TestBaseJsonPlaceHolder {
	/*
	 	When 
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then 
			Status code is 200
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									   }  	
	 */
	
	@Test
	public void post01() {
		//1) Set the URL
		spec.pathParam("todosPath", "todos");
		
		//2) Set the Request Body(JSONObject Class)
		JsonPlaceHolderTestData reqBodyObj = new JsonPlaceHolderTestData();
		JSONObject expectedDataJSONObject = reqBodyObj.setUpPostReqDataByUsinJSONObject();
		System.out.println(expectedDataJSONObject);

		//3) Send the request
		Response response = given().
				contentType(ContentType.JSON).
				spec(spec).
				auth().
				basic("admin", "password123").
				body(expectedDataJSONObject.toString()).
			when().
				post("/{todosPath}");
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case(GSON)

		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
