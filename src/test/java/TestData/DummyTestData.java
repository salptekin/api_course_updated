package TestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DummyTestData {
	
	public List<Map<String, Object>> expectedDataList = new ArrayList<Map<String, Object>>();
	
	public List<Map<String, Object>> setUpData(){
		
		HashMap<String, Object> expectedMap1 = new HashMap<String, Object>();
		HashMap<String, Object> expectedMap2 = new HashMap<String, Object>();
		HashMap<String, Object> expectedMap3 = new HashMap<String, Object>();
		HashMap<String, Object> expectedMap4 = new HashMap<String, Object>();
		HashMap<String, Object> expectedMap5 = new HashMap<String, Object>();
		HashMap<String, Object> expectedMap6 = new HashMap<String, Object>();
		
		expectedMap1.put("StatusCode", 200);
		expectedDataList.add(expectedMap1);	
		
		expectedMap2.put("SelectedEmployeeName", "Airi Satou");
		expectedDataList.add(expectedMap2);

		
		expectedMap3.put("NumOfEmployees", 24);
		expectedDataList.add(expectedMap3);
		
		expectedMap4.put("SelectedEmpSalary", "170750");
		expectedDataList.add(expectedMap4);
		
		List<String> ageList = new ArrayList<String>();
		ageList.add("40");
		ageList.add("19");
		ageList.add("23");
		
		expectedMap5.put("MultipleAges", ageList);
		expectedDataList.add(expectedMap5);
		
		Map<String, String> empDetailsMap = new HashMap<String, String>();
		empDetailsMap.put("id", "11");
		empDetailsMap.put("employee_name", "Jena Gaines");
		empDetailsMap.put("employee_salary", "90560");
		empDetailsMap.put("employee_age", "30");
		empDetailsMap.put("profile_image", "");
		
		expectedMap6.put("AllDetailsAboutAnEmployee", empDetailsMap);
		expectedDataList.add(expectedMap6);
		
		return expectedDataList;
	}
	
	public Map<String, Integer> setUpData2(){
		
		Map<String, Integer> expectedDataMap = new HashMap<String, Integer>();
		expectedDataMap.put("StatusCode", 200);
		expectedDataMap.put("HighestSalary", 725000);
		expectedDataMap.put("MinAge", 19);
		expectedDataMap.put("SecondHighestSalary", 675000);
		
		return expectedDataMap;
	}
	
	public Map<String, String> setUpPostReqBodyByUsingMap(){
		
		Map<String, String> reqBodyMap = new HashMap<String, String>();
		reqBodyMap.put("name","SULEYMAN ALP");
		reqBodyMap.put("salary","1000");
		reqBodyMap.put("age","18");
		reqBodyMap.put("profile_image","");
		return reqBodyMap;
		
	}
	
	public Map<String, String> setUpMessageDataByUsingMap(){
		
		Map<String, String> massageMap = new HashMap<String, String>();
		massageMap.put("status","success");
		massageMap.put("message","Successfully! Record has been added.");

		return massageMap;
		
	}
	
	public JSONObject setUpPostReqBodyByUsingJSONObject() {
		
		JSONObject reqBodyJSONObject = new JSONObject();
		reqBodyJSONObject.put("name","SULEYMAN ALP");
		reqBodyJSONObject.put("salary","1000");
		reqBodyJSONObject.put("age","18");
		reqBodyJSONObject.put("profile_image","");
		
		return reqBodyJSONObject;
		
	}
	
	public JSONObject setUpMessageDataByUsingJSONObject() {		
		JSONObject messageJSONObject = new JSONObject();
		messageJSONObject.put("status", "success");
		messageJSONObject.put("message", "Successfully! Record has been added.");
		
		return messageJSONObject;		
	}
	
	public Map<String, Object> setUpExpectedDeleteDataByUsingMap(){
		
		Map<String, Object> expectedDataMap = new HashMap<String, Object>();
		expectedDataMap.put("statuscode", 200);
		expectedDataMap.put("status", "success");
		expectedDataMap.put("data", "2");
		expectedDataMap.put("message", "Successfully! Record has been deleted");
		return expectedDataMap;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
