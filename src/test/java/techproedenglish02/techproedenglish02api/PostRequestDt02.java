package techproedenglish02.techproedenglish02api;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import TestBaseDtUrls.TestBaseHerOkuApp;
import TestData.HerOkuAppTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestDt02 extends TestBaseHerOkuApp {
	/*
	 	When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Selim",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2020-09-09",
								        "checkout": "2020-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }	
	 */
	@Test
	public void post02(){
		//1) Set the URL
		spec02.pathParam("bookingPath", "booking");
		
		//2) Set the expected data
		HerOkuAppTestData reqBodyObj = new HerOkuAppTestData();
		JSONObject expectedReqBodyData = reqBodyObj.setUpDataJSONObject();
		
		//3) Send the request
		Response response = given().
								contentType(ContentType.JSON).
								spec(spec02).
								auth().
								basic("admin", "password123").
								body(expectedReqBodyData.toString()).//When you use JSONObject, use toString()
							when().
								post("/{bookingPath}");
		response.prettyPrint();
				
		//4) Assert the things which are given in the test case
		//1.Way:
		response.
			then().
			assertThat().
			statusCode(200).
			body("booking.firstname", equalTo(expectedReqBodyData.getString("firstname")),
				 "booking.lastname",equalTo(expectedReqBodyData.getString("lastname")),
				 "booking.totalprice",equalTo(expectedReqBodyData.getInt("totalprice")),
				 "booking.depositpaid",equalTo(expectedReqBodyData.getBoolean("depositpaid")),
				 "booking.bookingdates.checkin",equalTo(expectedReqBodyData.getJSONObject("bookingdates").getString("checkin")),
				 "booking.bookingdates.checkout",equalTo(expectedReqBodyData.getJSONObject("bookingdates").getString("checkout")));
		
		//2.Way: Hard Assertion with JSONObject and JsonPath
		JsonPath json = response.jsonPath();
		
		assertEquals(expectedReqBodyData.getString("firstname"), json.getString("booking.firstname"));
		assertEquals(expectedReqBodyData.getString("lastname"), json.getString("booking.lastname"));
		assertEquals(expectedReqBodyData.getInt("totalprice"), json.getInt("booking.totalprice"));
		assertEquals(expectedReqBodyData.getBoolean("depositpaid"), json.getBoolean("booking.depositpaid"));
		assertEquals(expectedReqBodyData.getJSONObject("bookingdates").getString("checkin"), json.getString("booking.bookingdates.checkin"));
		assertEquals(expectedReqBodyData.getJSONObject("bookingdates").getString("checkout"), json.getString("booking.bookingdates.checkout"));
		
		//3.Way: Soft Assertion with JSONObject and GSON
		Map<String, Object> actualDataMap = response.as(HashMap.class); 
		System.out.println(actualDataMap);
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(((Map)actualDataMap.get("booking")).get("firstname"), expectedReqBodyData.getString("firstname"));
		softAssert.assertEquals(((Map)actualDataMap.get("booking")).get("lastname"), expectedReqBodyData.getString("lastname"));
		softAssert.assertEquals(((Map)actualDataMap.get("booking")).get("totalprice"), expectedReqBodyData.getInt("totalprice"));
		
		softAssert.assertEquals(((Map)actualDataMap.get("booking")).get("depositpaid"), expectedReqBodyData.getBoolean("depositpaid"));
		softAssert.assertEquals(((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"), 
				                expectedReqBodyData.getJSONObject("bookingdates").getString("checkin"));
		
		softAssert.assertEquals(((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"), 
                                expectedReqBodyData.getJSONObject("bookingdates").getString("checkout"));
		
		softAssert.assertAll();
	}

}
