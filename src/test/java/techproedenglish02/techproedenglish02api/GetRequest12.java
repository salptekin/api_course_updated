package techproedenglish02.techproedenglish02api;

import org.hamcrest.Matchers;
import org.junit.Test;
import TestBaseNtUrls.TestBaseDummy;
import TestData.DummyTestData;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRequest12 extends TestBaseDummy {
	
	/*
	 	When
	 		I send GET Request to the Url http://dummy.restapiexample.com/api/v1/employees
	 	Then
	 		Status code is 200
	 		And 5th employee name is Airi Satou
	 		And the number of employees is 24
	 		And the salary of 2nd last employee is 106450
	 		And 40, 21, and 19 are among the ages
	 		And 11th employee is like {
							            "id": "11",
							            "employee_name": "Jena Gaines",
							            "employee_salary": "90560",
							            "employee_age": "30",
							            "profile_image": ""
        							  }
	 */
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec.pathParam("employeesPath", "employees");
		
		//2) Set the expected data
		DummyTestData expectedObj = new DummyTestData();
		List<Map<String, Object>> expectedDataList = expectedObj.setUpData();
		System.out.println(expectedDataList);
		
		//3) Send the request
		Response response = given().spec(spec).when().get("/{employeesPath}");
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		//1.Way:
		response.
			then().
			assertThat().
			statusCode((Integer)expectedDataList.get(0).get("StatusCode")).
			body("data[4].employee_name", Matchers.equalTo(expectedDataList.get(1).get("SelectedEmployeeName")),
				 "data.id", Matchers.hasSize((Integer)expectedDataList.get(2).get("NumOfEmployees")),
				 "data[1].employee_salary", Matchers.equalTo(expectedDataList.get(3).get("SelectedEmpSalary")),
				 "data.employee_age", Matchers.hasItems(((List)expectedDataList.get(4).get("MultipleAges")).get(0),
				 										((List)expectedDataList.get(4).get("MultipleAges")).get(1),
														((List)expectedDataList.get(4).get("MultipleAges")).get(2)),
				 "data[10].employee_name", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_name")),
				 "data[10].employee_salary", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_salary")),
				 "data[10].employee_age", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_age")),
				 "data[10].profile_image", Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("profile_image")));
		
		//2.Way:
		assertEquals(expectedDataList.get(0).get("StatusCode"), response.getStatusCode());
		
		//GSON for De-Serialization
		
		Map<String, Object> actualDataMap = response.as(HashMap.class);
		System.out.println(actualDataMap);
		
		assertEquals(expectedDataList.get(0).get("StatusCode"), response.getStatusCode());
		
		assertEquals(expectedDataList.get(1).get("SelectedEmployeeName"), ((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name") );
		
		assertEquals(expectedDataList.get(2).get("NumOfEmployees"), ((List)actualDataMap.get("data")).size());
		
		assertEquals(expectedDataList.get(3).get("SelectedEmpSalary"), ((Map)((List)actualDataMap.get("data")).get(1)).get("employee_salary"));
		
		//Get the number of employees from the response body to use in the loop
		int numOfEmp = ((List)actualDataMap.get("data")).size();
		//Create a list to store employee ages
		List<String> ageList = new ArrayList<String>();
		//Create a loop to add all employee ages into the lis
		for(int i=0; i<numOfEmp; i++) {
			ageList.add((String) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));
		}
		//Use containsAll() to check if all ages are in the age list
		assertTrue(ageList.containsAll((List) expectedDataList.get(4).get("MultipleAges")));
		
		assertEquals(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_name"),((Map)((List)actualDataMap.get("data")).get(10)).get("employee_name"));
		
		assertEquals(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_salary"),((Map)((List)actualDataMap.get("data")).get(10)).get("employee_salary"));

		assertEquals(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("employee_age"),((Map)((List)actualDataMap.get("data")).get(10)).get("employee_age"));

		assertEquals(((Map)expectedDataList.get(5).get("AllDetailsAboutAnEmployee")).get("profile_image"),((Map)((List)actualDataMap.get("data")).get(10)).get("profile_image"));

	}

}
