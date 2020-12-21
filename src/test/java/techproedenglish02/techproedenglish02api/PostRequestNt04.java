package techproedenglish02.techproedenglish02api;

import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import TestBaseNtUrls.TestBaseAgroMonitoring;
import TestData.AgroMonitoringTestDataNt;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestNt04 extends TestBaseAgroMonitoring {
	
	/*
	 When 
		 I send POST Request to the Url "http://api.agromonitoring.com/agro/1.0/polygons?appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0"
		 with the Request Body like  {
										   "name":"Polygon Sample",
										   "geo_json":{
										      "type":"Feature",
										      "properties":{},
										      "geometry":{
										         "type":"Polygon",
										         "coordinates":[
										            [
										               [-121.1958,37.6683],
										               [-121.1779,37.6687],
										               [-121.1773,37.6792],
										               [-121.1958,37.6792],
										               [-121.1958,37.6683]
										            ]
										         ]
										      }
										   }
										}
	Then
		Assert Status Code (201) 
		And Response Body should be like {
										    "id": "5fd8c383714b523b2ce1f154",
										    "geo_json": {
										        "geometry": {
										            "coordinates": [
										                [
										                    [
										                        -121.1958,
										                        37.6683
										                    ],
										                    [
										                        -121.1779,
										                        37.6687
										                    ],
										                    [
										                        -121.1773,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6683
										                    ]
										                ]
										            ],
										            "type": "Polygon"
										        },
										        "type": "Feature",
										        "properties": {
										            
										        }
										    },
										    "name": "Polygon Sample",
										    "center": [
										        -121.1867,
										        37.67385
										    ],
										    "area": 190.9484,
										    "user_id": "5fd8c02a3da20c000759e0f8",
										    "created_at": 1608041347
										}
	 */
	@Test
	public void post01() {
		
		//1) Set the URL
		spec.pathParams("agroPath", "agro",
				        "id", 1.0,
				        "polygonsPath", "polygons").
		     queryParam("appid", "f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

		//2) Set the expected data
		AgroMonitoringTestDataNt postReqObj = new AgroMonitoringTestDataNt();
		Map<String, Object> postReqBodyMap = postReqObj.postReqBodySetUp();
			
		//3) Send the request
		Response response = given().
								contentType(ContentType.JSON).
								spec(spec).
								body(postReqBodyMap).
							when().
								post("/{agroPath}/{id}/{polygonsPath}");
		
		response.prettyPrint();
		
		//4) Assert the things which are given in the test case
		//body() and postReqBodyMap
		response.
			then().
			assertThat().
			statusCode(201).
			body("geo_json.geometry.coordinates[0][1][0]", 
					Matchers.equalTo(postReqObj.coordinates[0][1][0]),
				 "geo_json.geometry.coordinates[0][1][1]", 
					Matchers.equalTo(postReqObj.coordinates[0][1][1]),
				 "geo_json.geometry.type",
				    Matchers.equalTo(postReqObj.geometrySetUp().get("type")),
				 "geo_json.properties",
				    Matchers.equalTo(postReqObj.geoJsonSetUp().get("properties")),
				 "geo_json.type",
				    Matchers.equalTo(postReqObj.geoJsonSetUp().get("type")),
				 "name",
				    Matchers.equalTo(postReqBodyMap.get("name")),
				 "center[0]", 
				    Matchers.equalTo(postReqObj.center[0]),
				 "center[1]", 
				    Matchers.equalTo(postReqObj.center[1]),
				 "area",
				    Matchers.equalTo(postReqObj.extraDataSetUp().get("area")),
				 "userId",
				    Matchers.equalTo(postReqObj.extraDataSetUp().get("userId")));
		
		//JsonPath and postReqBodyMap

	}
	
}
