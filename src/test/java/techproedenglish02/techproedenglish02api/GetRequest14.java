package techproedenglish02.techproedenglish02api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import TestBaseNtUrls.TestBaseDummy;
import TestData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest14 extends TestBaseDummy {

	/*
	 	When 
	 		I send a request to http://dummy.restapiexample.com/api/v1/employees
	 	Then 
	 		Status code is 200
	 		And the highest salary is 725000
	 		And the minimum age is 19
	 		And the second lowest salary is 675000
	*/
	
	@Test
	public void get01() {
		
		//1) Set the URL
		spec.pathParam("employeesPath", "employees");
			
		//2) Set the expected data
		DummyTestData expectedObj = new DummyTestData();
		Map<String, Integer> expectedDataMap = expectedObj.setUpData2();
		
		//3) Send the request
		Response response = given().spec(spec).when().get("/{employeesPath}");
		
		response.prettyPrint();

		//4) Assert the things which are given in the test case
		assertEquals(expectedDataMap.get("StatusCode"), (Integer)response.getStatusCode());
		
			//1.Way:Use JsonPath
			JsonPath json = response.jsonPath();
			
			//Assertion of highest salary
			List<String> salaryList = json.getList("data.employee_salary");
			
			List<Integer> salaryListInt = new ArrayList<Integer>();
			salaryList.stream().forEach(t->salaryListInt.add(Integer.valueOf(t)));
						
			Collections.sort(salaryListInt);
			
			assertEquals(expectedDataMap.get("HighestSalary"), salaryListInt.get(salaryListInt.size()-1));
		
			//Assertion of minimum age
			List<String> ageList = json.getList("data.employee_age");
			
			List<Integer> ageListInt = new ArrayList<Integer>();
			ageList.stream().forEach(t->ageListInt.add(Integer.valueOf(t)));
			
			Collections.sort(ageListInt);
			
			assertEquals(expectedDataMap.get("MinAge"), ageListInt.get(0));
		
			//Assertion of the second lowest salary is 675000
			assertEquals(expectedDataMap.get("SecondHighestSalary"), salaryListInt.get(salaryListInt.size()-2));
		
			//2.Way:GSON
			Map<String, Object> actualDataMap = response.as(HashMap.class);
			System.out.println(actualDataMap);
		
			//Assertion of Highest Salary
			List<String> salaryListGson = new ArrayList<String>();
			
			for(int i=0; i<((List)actualDataMap.get("data")).size(); i++) {
				salaryListGson.add((String) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_salary"));
			}
			
			List<Integer> salaryListGsonInt = new ArrayList<Integer>();
			salaryListGson.stream().forEach(t->salaryListGsonInt.add(Integer.valueOf(t)));
			
			Collections.sort(salaryListGsonInt);
			
			assertEquals(expectedDataMap.get("HighestSalary"),salaryListGsonInt.get(salaryListGsonInt.size()-1) );
		
			//Assertion of minimum age
			List<String> ageListGson = new ArrayList<String>();
			
			for(int i=0; i<((List)actualDataMap.get("data")).size(); i++) {
				ageListGson.add((String) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));
			}
			
			List<Integer> ageListGsonInt = new ArrayList<Integer>();
			ageListGson.stream().forEach(t->ageListGsonInt.add(Integer.valueOf(t)));
			
			Collections.sort(ageListGsonInt);
		
			assertEquals(expectedDataMap.get("MinAge"), ageListGsonInt.get(0));
			
			//Assertion of second highest salary
			assertEquals(expectedDataMap.get("SecondHighestSalary"), salaryListGsonInt.get(salaryListGsonInt.size()-2));

	}
	
}
