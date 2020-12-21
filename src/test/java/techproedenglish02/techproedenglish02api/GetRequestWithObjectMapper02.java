package techproedenglish02.techproedenglish02api;

import java.util.Map;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import TestBaseNtUrls.TestBaseHerOkuApp;
import Utilities.JsonUtil;
import io.restassured.response.Response;

public class GetRequestWithObjectMapper02 extends TestBaseHerOkuApp {

		/*
		 	When 
		 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
		 		
		 	Then 
		 		Status code is 200
		 		And response body is like {
										    "firstname": "Mark",
										    "lastname": "Ericsson",
										    "totalprice": 726,
										    "depositpaid": true,
										    "bookingdates": {
										        "checkin": "2015-08-07",
										        "checkout": "2020-10-25"
										     }
										  }
		 	
		 */
	
	@Test
	public void get01() {
		
		//Set the URL
		spec.pathParams("bookingPath", "booking",
				        "id", 2);
		
		//Set the Expected Data
		String expectedJson = "{\n"
								+ "\"firstname\": \"Sally\",\n"
								+ "\"lastname\": \"Jones\",\n"
								+ "\"totalprice\": 725,\n"
								+ "\"depositpaid\": false,\n"
								+ "\"bookingdates\": {\n"
								+ "\"checkin\": \"2019-08-04\",\n"
								+ "\"checkout\": \"2020-09-25\"\n"
								+ "}\n"
								+ "}";
		Map<String, Object> expectedMap = JsonUtil.convertJsonToJava(expectedJson, Map.class);
		System.out.println(expectedMap);
		
		//Send the Request
		Response response = given().spec(spec).when().get("/{bookingPath}/{id}");
		response.prettyPrint();
		
		//Set the actual data by using ObjectMapper Class
		Map<String, Object> actualMap = JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(actualMap);
		
		//Assert
//		SoftAssert softAssert = new SoftAssert();
//		
//		softAssert.assertEquals(actualMap.get("firstname"), expectedMap.get("firstname"));
//		softAssert.assertEquals(actualMap.get("lastname"), expectedMap.get("lastname"));
//		softAssert.assertEquals(actualMap.get("totalprice"), expectedMap.get("totalprice"));
//		softAssert.assertEquals(actualMap.get("depositpaid"), expectedMap.get("depositpaid"));
//		softAssert.assertEquals(((Map)actualMap.get("bookingdates")).get("checkin"), ((Map)expectedMap.get("bookingdates")).get("checkin"));
//		softAssert.assertEquals(((Map)actualMap.get("bookingdates")).get("checkout"), ((Map)expectedMap.get("bookingdates")).get("checkout"));
//
//		softAssert.assertAll();
		
		//To practice Serialization Method convert expectedMap and actualMap to Json Data
		String JsonFromExpectedMap = JsonUtil.convertJavaToJson(expectedMap);
		System.out.println("===> " + JsonFromExpectedMap);
		
		String JsonFromActualMap = JsonUtil.convertJavaToJson(actualMap);
		System.out.println("****> " + JsonFromActualMap);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
