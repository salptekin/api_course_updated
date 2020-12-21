package techproedenglish02.techproedenglish02api;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import TestBaseDtUrls.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestDt10 extends TestBaseDummy {
	
	/*
	 	When 
		 I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350,000 
		   Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
	 */
	
	@Test
	public void get01() {
		
		spec03.pathParam("employees", "employees");
		
		Response response = given().
								spec(spec03).
							when().
							 	get("/{employees}");
		response.prettyPrint();
		
		response.
			then().
			assertThat().
			statusCode(200);
		
		//Create JsonPath Object
		JsonPath json = response.jsonPath();
		
		//How to get ids greater than 10 from response body
		//Use Groovy Language to filter ids
		List<String> idsGreaterThan10 = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
		System.out.println(idsGreaterThan10);
		//Assert that there are 14 ids greater than 10
		assertEquals(14, idsGreaterThan10.size());
		
		//Print all ages less than 30 on the console
		List<String> agesLessThan30 = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		Collections.sort(agesLessThan30);
		System.out.println(agesLessThan30);
		
		//Assert that maximum age less than 30 is 23
		assertEquals("23", agesLessThan30.get(agesLessThan30.size()-1));
		
		
									//Homework
		//3)Print all employee names whose salaries are greater than 350,000 
		//Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
		
		
	}

}
