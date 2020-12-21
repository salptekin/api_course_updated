package TestData;

import java.util.HashMap;
import java.util.Map;

public class OpenWeatherMapTestData {
	
	public int statusCode = 200; 
	
	public Map<String, Float> coordSetUp(){
		Map<String, Float> coord = new HashMap<String, Float>();
		coord.put("lon", -0.13f);
		coord.put("lat", 51.51f);
		return coord;
	}
	
	Map weather[] = {weatherSetUp()};
	
	public Map<String, Object> weatherSetUp(){
		Map<String, Object> weather = new HashMap<String, Object>();
		weather.put("id", 501);
		weather.put("main", "Rain");
		weather.put("description", "moderate rain");
		weather.put("icon", "10n");
		return weather;
	}
	
	public Map<String, Float> mainSetUp(){
		Map<String, Float> main = new HashMap<String, Float>();
		main.put("temp", 282.92f);
		main.put("feels_like", 276.91f);
		main.put("temp_min", 282.59f);
		main.put("temp_max", 283.71f);
		main.put("pressure", 1006f);
		main.put("humidity", 76f);
		return main;
		
	}
	
	public Map<String, Float> windSetUp(){
		Map<String, Float> wind = new HashMap<String, Float>();
		wind.put("speed", 7.2f);
		wind.put("deg", 200f);
		wind.put("gust", 12.3f);
		return wind;
	}
	
	public Map<String, Float> rainSetUp(){
		Map<String, Float> rain = new HashMap<String, Float>();
		rain.put("1h", 1.06f);
		return rain;
	}
	
	public Map<String, Float> cloudsSetUp(){
		Map<String, Float> clouds = new HashMap<String, Float>();
		clouds.put("all", 27f);
		return clouds;
	}
	
	public Map<String, Object> sysSetUp(){
		Map<String, Object> sys = new HashMap<String, Object>();
		sys.put("type", 1);
		sys.put("id", 1414);
		sys.put("country", "GB");
		sys.put("sunrise", 1608364978);
		sys.put("sunset", 1608393157);
		return sys;
	}
	
	public Map<String, Object> expectedDataSetUp(){
		Map<String, Object> expectedDataMap = new HashMap<String, Object>();
		expectedDataMap.put("coord", coordSetUp());
		expectedDataMap.put("weather", weather);
		expectedDataMap.put("base", "stations");
		expectedDataMap.put("main", mainSetUp());
		expectedDataMap.put("visibility", 8000);
		expectedDataMap.put("wind", windSetUp());
		expectedDataMap.put("rain", rainSetUp());
		expectedDataMap.put("clouds", cloudsSetUp());
		expectedDataMap.put("dt", 1608396099);
		expectedDataMap.put("sys", sysSetUp());
		expectedDataMap.put("timezone", 0);
		expectedDataMap.put("id", 2643743);
		expectedDataMap.put("name", "London");
		expectedDataMap.put("cod", 200);
		return expectedDataMap;
	}

}
