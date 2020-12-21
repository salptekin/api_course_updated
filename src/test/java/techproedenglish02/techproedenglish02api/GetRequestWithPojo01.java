package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

import static io.restassured.RestAssured.*;
import Pojos.Data;
import Pojos.EmployeesExpectedPojo;
import TestBaseNtUrls.TestBaseDummy;
import io.restassured.response.Response;

public class GetRequestWithPojo01 extends TestBaseDummy {
	
		/*
		 	When 
		 		I send GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
		 	Then 
		 		Status code is 200
		 		And response body is like {
										    "status": "success",
										    "data": {
										        "id": 1,
										        "employee_name": "Tiger Nixon",
										        "employee_salary": 320800,
										        "employee_age": 61,
										        "profile_image": ""
										    },
										    "message": "Successfully! Record has been fetched."
										   }
		 	
		 */
	@Test
	public void get01() {
		
		//Set the URL
		spec.pathParams("employeePath", "employee",
				        "id", 1);
		
		//Set the Expected data
		Data data = new Data(1, "Tiger Nixon", 320800, 61, "");
		EmployeesExpectedPojo expectedDataPojo = new EmployeesExpectedPojo("success", data, "Successfully! Record has been fetched.");
		
		//Send Request
		Response response = given().spec(spec).when().get("/{employeePath}/{id}");
		response.prettyPrint();
		
		//Assert
		EmployeesExpectedPojo actualDataPojo = response.as(EmployeesExpectedPojo.class);

		assertEquals(expectedDataPojo.getStatus(), actualDataPojo.getStatus());
		assertEquals(expectedDataPojo.getData().getId(), actualDataPojo.getData().getId());
		assertEquals(expectedDataPojo.getData().getEmployee_name(), actualDataPojo.getData().getEmployee_name());
		assertEquals(expectedDataPojo.getData().getEmployee_salary(), actualDataPojo.getData().getEmployee_salary());
		assertEquals(expectedDataPojo.getData().getEmployee_age(), actualDataPojo.getData().getEmployee_age());
		assertEquals(expectedDataPojo.getData().getProfile_image(), actualDataPojo.getData().getProfile_image());
		assertEquals(expectedDataPojo.getMessage(), actualDataPojo.getMessage());
		
		System.out.println("==============================");
		
		//How to Serialize by using GSON
		
		//Convert expectedDataPojo to JSON Data
		
		//1.Step: Create Gson Object
		Gson gson = new Gson();
		
		//2.Step: Access to "toJson()" by using "gson" object
		String jsonFromJavaObject = gson.toJson(expectedDataPojo);
		System.out.println(jsonFromJavaObject);

	}

}
