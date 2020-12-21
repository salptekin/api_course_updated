package techproedenglish02.techproedenglish02api;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import TestBaseNtUrls.TestBaseDummy;
import TestData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class DeleteRequest01 extends TestBaseDummy {
	
	/*
	 	When
	 		I send DELETE Request to the Url http://dummy.restapiexample.com/api/v1/delete/2	 		
	 	Then 
		 	Status code is 200
		 	And Response body is {
								    "status": "success",
								    "data": "2",
								    "message": "Successfully! Record has been deleted"
								 }		   
	*/
	
	@Test
	public void delete01() {
		
		//Set the URL
		spec.pathParams("deletePath", "delete",
				        "id", 2);
		
		//Set the Expected Data
		DummyTestData expDataObj = new DummyTestData();
		Map<String, Object> expectedDataMap = expDataObj.setUpExpectedDeleteDataByUsingMap();
		
		//Create Delete Request
		Response response = given().
								spec(spec).
							when().
								delete("/{deletePath}/{id}");
		response.prettyPrint();
		
		//Do Assertions
		//1.Way: body() + expectedDataMap + Hard Assert
		response.
			then().
			assertThat().
			statusCode(200).
			body("status", Matchers.equalTo(expectedDataMap.get("status")),
				 "data", Matchers.equalTo(expectedDataMap.get("data")),
				 "message", Matchers.equalTo(expectedDataMap.get("message")));
		
		//2.Way: JsonPath + expectedDataMap + Hard Assert
		JsonPath json = response.jsonPath();
		
		assertEquals(expectedDataMap.get("statuscode"), response.getStatusCode());
		assertEquals(expectedDataMap.get("status"), json.getString("status"));
		assertEquals(expectedDataMap.get("data"), json.getString("data"));
		assertEquals(expectedDataMap.get("message"), json.getString("message"));
		
		//3.Way: GSON + expectedDataMap + Soft Assert
		Map<String, String> actualDataMap = response.as(HashMap.class);
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(response.getStatusCode(), expectedDataMap.get("statuscode"));
		softAssert.assertEquals(actualDataMap.get("status"), expectedDataMap.get("status"));
		softAssert.assertEquals(actualDataMap.get("data"), expectedDataMap.get("data"));
		softAssert.assertEquals(actualDataMap.get("message"), expectedDataMap.get("message"));
				
		softAssert.assertAll();

	}
	

}
