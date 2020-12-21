package techproedenglish02.techproedenglish02api;

import org.junit.Test;
import TestBaseNtUrls.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetRequestNt10 extends TestBaseDummy {
	
	/*
		 When 
			 I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
		 Then
			 Status code is 200
			 1)Print all ids greater than 10 on the console
			   Assert that there are 14 ids greater than 10
			 2)Print all ages less than 30 on the console
			   Assert that maximum age less than 30 is 23
			 3)Print all employee names whose salaries are greater than 350,000 
			   Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
	 */
	
	@Test
	public void get01() {
		
		spec.pathParam("employees", "employees");
		
		Response response = given().spec(spec).when().get("/{employees}");
		
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);
		
		JsonPath json = response.jsonPath();
		
		//Print all ids greater than 10 on the console
		//To filter the outputs we need to use "Groovy Language"
		List<String> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
		System.out.println(idList);
		//Assert that there are 14 ids greater than 10
		assertEquals(14, idList.size());
		
		//2)Print all ages less than 30 on the console
		List<String> ageList = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);
        
        List<Integer> ageListInt = new ArrayList<Integer>();
        
        for(String w : ageList) {
        	ageListInt.add(Integer.valueOf(w));
        }
		
		//Assert that maximum age less than 30 is 23
		Collections.sort(ageListInt);
		System.out.println(ageListInt);
		
		assertEquals(Integer.valueOf("23"), ageListInt.get(ageListInt.size()-1));
		
											//Homework
//		3)Print all employee names whose salaries are greater than 350,000 
//		Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000

	}


}
