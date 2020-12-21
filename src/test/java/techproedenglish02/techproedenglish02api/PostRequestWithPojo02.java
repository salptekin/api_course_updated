package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import Pojos.BookingDatesPojo;
import Pojos.BookingPojo;
import Pojos.BookingResponsePojo;
import TestBaseNtUrls.TestBaseHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestWithPojo02 extends TestBaseHerOkuApp {
	/*
 	When 
 		I send POST Request to the URL https://restful-booker.herokuapp.com/booking
 		with Post Request body  {
								    "firstname": "Alp",
								    "lastname": "Sun",
								    "totalprice": 888,
								    "depositpaid": false,
								    "bookingdates": {
								        "checkin": "2021-01-07",
								        "checkout": "2021-01-25"
								    }
								}
 	Then 
 		Status code is 200
 		And response body is like {
								    "bookingid": 13,
								    "booking": {
								        "firstname": "Alp",
								        "lastname": "Sun",
								        "totalprice": 888,
								        "depositpaid": false,
								        "bookingdates": {
								            "checkin": "2021-01-07",
								            "checkout": "2021-01-25"
								        }
								     }
								  }
 	
	 */
	
	@Test
	public void postPojo01() {
		//Set the URL
		spec.pathParam("bookingPath", "booking");
		
		//Set the Expected Data
		BookingDatesPojo bookingdates =  new BookingDatesPojo("2021-01-07", "2021-01-25");
		BookingPojo ExpectedBooking = new BookingPojo("Alp", "Sun", 888, false, bookingdates);
		
		//Send Request
		Response response = given().
								contentType(ContentType.JSON). //"applications/json"
								spec(spec).
								body(ExpectedBooking).
							when().
								post("/{bookingPath}");
		
		response.prettyPrint();
		
		//Assert
		//1.Way: body() + booking Pojo  ==> Homework
		//2.Way: JsonPath + booking Pojo ==> Homework
		
		//3.Way: GSON + booking Pojo
		
		//Following code gives error, because BookingPojo format is different from response body format.
		//If you see that kind of issue, you have 2 options 1)Stop using Pojo+GSON, proceed with JsonPath
		//                                                  2)Create new Pojo Classes for the response body
//		BookingPojo actualBooking = response.as(BookingPojo.class);
//		System.out.println(actualBooking);
		
		BookingResponsePojo actualBooking = response.as(BookingResponsePojo.class);
		System.out.println(actualBooking);
		
		assertEquals(ExpectedBooking.getFirstname(), actualBooking.getBooking().getFirstname());
		assertEquals(ExpectedBooking.getLastname(), actualBooking.getBooking().getLastname());
		assertEquals(ExpectedBooking.getTotalprice(), actualBooking.getBooking().getTotalprice());
		assertEquals(ExpectedBooking.isDepositpaid(), actualBooking.getBooking().isDepositpaid());
		assertEquals(ExpectedBooking.getBookingdates().getCheckin(), actualBooking.getBooking().getBookingdates().getCheckin());
		assertEquals(ExpectedBooking.getBookingdates().getCheckout(), actualBooking.getBooking().getBookingdates().getCheckout());

	}

}
