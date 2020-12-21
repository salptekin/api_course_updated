package techproedenglish02.techproedenglish02api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import TestBaseNtUrls.TestBaseOpenWeatherMap;
import TestData.OpenWeatherMapTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest15 extends TestBaseOpenWeatherMap {
	
	/*
	 	When 
	 		I send GET Request to the Url https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
	 	Then 
	 		Status code is 200
	 		And Response body is like {
										    "coord": {
										        "lon": -0.13,
										        "lat": 51.51
										    },
										    "weather": [
										        {
										            "id": 801,
										            "main": "Clouds",
										            "description": "few clouds",
										            "icon": "02n"
										        }
										    ],
										    "base": "stations",
										    "main": {
										        "temp": 284.57,
										        "feels_like": 280.6,
										        "temp_min": 283.71,
										        "temp_max": 285.37,
										        "pressure": 1007,
										        "humidity": 81
										    },
										    "visibility": 10000,
										    "wind": {
										        "speed": 5.1,
										        "deg": 160
										    },
										    "clouds": {
										        "all": 20
										    },
										    "dt": 1608329611,
										    "sys": {
										        "type": 1,
										        "id": 1414,
										        "country": "GB",
										        "sunrise": 1608278540,
										        "sunset": 1608306738
										    },
										    "timezone": 0,
										    "id": 2643743,
										    "name": "London",
										    "cod": 200
										}
	 */
	
	@Test
	public void get01() {
		//Set the URL
		spec.pathParams("dataPath", "data", 
				        "numPath", 2.5,
				        "weatherPath", "weather").
		     queryParams("q", "London",
		    		     "appid", "f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");
		//Expected Test Data
		OpenWeatherMapTestData expectedDataObj = new OpenWeatherMapTestData();
		
		//Set the GET Request
		Response response = given().
								spec(spec).
							when().
								get("/{dataPath}/{numPath}/{weatherPath}");
		response.prettyPrint();
		
		//Assert JsonPath + ExpectedDataMap
		JsonPath json = response.jsonPath();
		
		assertEquals(expectedDataObj.statusCode, response.getStatusCode());
		
		assertEquals((Float)expectedDataObj.coordSetUp().get("lon"),(Float)json.getFloat("coord.lon"));
		assertEquals((Float)expectedDataObj.coordSetUp().get("lat"),(Float)json.getFloat("coord.lat"));
		
		assertEquals(expectedDataObj.weatherSetUp().get("id"),json.getInt("weather[0].id"));
		assertEquals(expectedDataObj.weatherSetUp().get("main"),json.getString("weather[0].main"));
		assertEquals(expectedDataObj.weatherSetUp().get("description"),json.getString("weather[0].description"));
		assertEquals(expectedDataObj.weatherSetUp().get("icon"),json.getString("weather[0].icon"));
		
		assertEquals(expectedDataObj.expectedDataSetUp().get("base"),json.getString("base"));
	}
}
