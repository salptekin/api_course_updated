package techproedenglish02.techproedenglish02api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import TestBaseNtUrls.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class GetRequestNt09 extends TestBaseDummy {
	
	/*
	 	Use JsonPath Class and Soft Assertion to do;
	    
	 	When 
	 		I send Get Request to http://dummy.restapiexample.com/api/v1/employees
	 	Then
	 		The Status code is 200
	 		And The name of 3rd employee is "Ashton Cox"
	 		And The Salary of 6th employee is 372000
	 		And The age of the last employee is 23
	 		And 21, 23, 61 are among the ages
	*/
	
	@Test
	public void get01() {
		
		spec.pathParam("employees", "employees");
		
		Response response = given().spec(spec).when().get("/{employees}");
		
		response.prettyPrint();
		
		JsonPath json = response.jsonPath();
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox", "Name did not match!");
		softAssert.assertEquals(json.getString("data[5].employee_salary"), "372000", "Salary did not match!");
		softAssert.assertEquals(json.getString("data[-1].employee_age"), "23", "Age did not match!");
		
								//How to assert multiple data by using JsonPath Class
		
		//21, 23, 61 are among the ages
			//Create a list and store test data into the list
			List<String> ageList = new ArrayList<String>();
			ageList.add("21");
			ageList.add("23");
			ageList.add("61");
			//Use containsAll() method
			softAssert.assertTrue(json.getList("data.employee_age").containsAll(ageList), "At least one of the ages does not exist");
		
		softAssert.assertAll();

	}

}
