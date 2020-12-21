package TestData;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class JsonPlaceHolderTestData {
	
	public int statusCode = 200;
	public int userId = 10;
	public boolean completed = true;

	public HashMap<String, Object> expectedDataMap;
	
	public HashMap<String, Object> setUpData() {
		
		expectedDataMap = new HashMap<String, Object>();
		expectedDataMap.put("StatusCode", 200);
		expectedDataMap.put("completed", true);
		expectedDataMap.put("userId", 10);
		expectedDataMap.put("title", "quis eius est sint explicabo");
		expectedDataMap.put("headerVia", "1.1 vegur");
		expectedDataMap.put("Server", "cloudflare");
		
		return expectedDataMap;
	}
	
	public JSONObject setUpPostReqDataByUsinJSONObject() {
		
		JSONObject reqBodyJSONObject = new JSONObject();
		reqBodyJSONObject.put("userId", 55);
		reqBodyJSONObject.put("title", "Tidy your room");
		reqBodyJSONObject.put("completed", false);
		
		return reqBodyJSONObject;
    }
	
	public Map<String, Object> setUpPutDataByUsingMap(){
		
		Map<String, Object> putReqBodyMap = new HashMap<String, Object>();
		
		putReqBodyMap.put("userId", 21);
		putReqBodyMap.put("title", "Wash the dishes");
		putReqBodyMap.put("completed", false);
		
		return putReqBodyMap;
	}
	
	public Map<String, Object> setUpPatchDataByUsingMap(){
		
		Map<String, Object> patchReqBodyMap = new HashMap<String, Object>();
		
		patchReqBodyMap.put("title", "Tidy your room");
		
		return patchReqBodyMap;
	}
	
	public JSONObject setUpDeleteDataByUsinJSONObject() {
		JSONObject expectedDataJSONObject = new JSONObject();
		expectedDataJSONObject.put("statuscode", 200);
		return expectedDataJSONObject;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
