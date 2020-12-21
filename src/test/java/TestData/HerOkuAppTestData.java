package TestData;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class HerOkuAppTestData {
	
	Map<String, String> bookingDatesMap = new HashMap<String, String>();
	Map<String, Object> bookingDetailsMap = new HashMap<String, Object>();
	
	public Map<String, Object> setUpData(){
		
		bookingDatesMap.put("checkin", "2019-01-06");
		bookingDatesMap.put("checkout", "2020-03-21");
		
		bookingDetailsMap.put("firstname", "Mark");
		bookingDetailsMap.put("lastname", "Jackson");
		bookingDetailsMap.put("totalprice", 819);
		bookingDetailsMap.put("depositpaid", true);
		bookingDetailsMap.put("bookingdates", bookingDatesMap);
		
		return bookingDetailsMap;
		
	}

	public JSONObject setUpDataJSONObject() {
		
		JSONObject bookingDatesJSONObject = new JSONObject();
		bookingDatesJSONObject.put("checkin", "2020-09-09");
		bookingDatesJSONObject.put("checkout", "2020-09-21");
		
		JSONObject bookingDetailsJSONObject = new JSONObject();
		bookingDetailsJSONObject.put("firstname", "Selim");
		bookingDetailsJSONObject.put("lastname", "Ak");
		bookingDetailsJSONObject.put("totalprice", 11111);
		bookingDetailsJSONObject.put("depositpaid", true);
		
		bookingDetailsJSONObject.put("bookingdates", bookingDatesJSONObject);
		
		return bookingDetailsJSONObject;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
