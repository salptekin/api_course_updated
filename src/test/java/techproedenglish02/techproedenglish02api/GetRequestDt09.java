package techproedenglish02.techproedenglish02api;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import TestBaseDtUrls.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class GetRequestDt09 extends TestBaseDummy {
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
		spec03.pathParam("employees", "employees");
		
		Response response = given().
								spec(spec03).
							when().
								get("/{employees}");
		
		response.prettyPrint();
		
		//1.Way: Hard Assertion
		response.
			then().
			assertThat().
			statusCode(200).
			body("data[2].employee_name", Matchers.equalTo("Ashton Cox"),
				 "data[5].employee_salary", Matchers.equalTo("372000"),
				 "data[-1].employee_age", Matchers.equalTo("23"),
				 "data.employee_age", Matchers.hasItems("21", "23", "61"));//Important!!!
		
		JsonPath json = response.jsonPath();
		
		//2.Way: Soft Assertion
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox", "The name is not matching!");
		softAssert.assertTrue(json.getString("data[5].employee_salary").equals("372000"), "The salary is not matching!");
		softAssert.assertTrue(json.getString("data[-1].employee_age").equals("23"), "The age is not matching!");
		
		//How to make assertion for multiple data by using JsonPath Class
			//1.Step: Create a list and store the multiple data into the list
			List<String> ages = new ArrayList<String>();
			ages.add("21");
			ages.add("23");
			ages.add("61");
			System.out.println(ages);
			
			//2.Step: Assert by using getList() from JsonPath Class
			softAssert.assertTrue(json.getList("data.employee_age").containsAll(ages), "At least one of the ages does not exist!");
		
		softAssert.assertAll();

	}
}
