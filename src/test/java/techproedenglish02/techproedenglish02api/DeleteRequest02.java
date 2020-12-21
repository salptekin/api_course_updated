package techproedenglish02.techproedenglish02api;

import org.json.JSONObject;
import org.junit.Test;
import TestBaseNtUrls.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest02 extends TestBaseJsonPlaceHolder {

	/*
	 	When
	 		I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 	Then 
		 	Status code is 200
		 	And Response body is {"msg" = "Good"}	   
	*/
	
	@Test
	public void delete02() {
		//Set the URL
		spec.pathParams("todosPath", "todos",
				        "id", 198);
		//Set the Expected Data
		JsonPlaceHolderTestData expectedJSONObjectObj = new JsonPlaceHolderTestData();
		JSONObject expectedDataJSONObject = expectedJSONObjectObj.setUpDeleteDataByUsinJSONObject();
		
		//Send the Delete Request
		Response response = given().spec(spec).when().delete("/{todosPath}/{id}");
		response.prettyPrint();
		
		//Assert 
		response.
			then().
			assertThat().
			statusCode(expectedDataJSONObject.getInt("statuscode"));
		
		Map<String, Object> actualDataMap = response.as(HashMap.class);
		assertEquals(expectedDataJSONObject.length()-1, actualDataMap.size());

	}
}
