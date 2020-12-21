package TestData;

import java.util.HashMap;
import java.util.Map;

public class AgroMonitoringTestDataNt {

	public float coordinates[][][] = { { {-121.1958f,37.6683f}, 
								  {-121.1779f,37.6687f}, 
								  {-121.1773f,37.6792f}, 
								  {-121.1958f,37.6792f}, 
								  {-121.1958f,37.6683f} } };
	
	public Map<String, Object> geometrySetUp(){
		
		Map<String, Object> geometry = new HashMap<String, Object>();
		geometry.put("type", "Polygon");
		geometry.put("coordinates", coordinates);
		
		return geometry;
	}
	
	public Map<String, Object> properties = new HashMap<String, Object>();
	
	public Map<String, Object> geoJsonSetUp(){
		
		Map<String, Object> geoJson = new HashMap<String, Object>();
		geoJson.put("type", "Feature");
		geoJson.put("properties", properties);
		geoJson.put("geometry", geometrySetUp());
		
		return geoJson;
	}
	
	public Map<String, Object> postReqBodySetUp(){
		
		Map<String, Object> postReqBodyMap = new HashMap<String, Object>();
		postReqBodyMap.put("name", "Polygon Sample");
		postReqBodyMap.put("geo_json", geoJsonSetUp());
		
		return postReqBodyMap;
	}
	
	public float center[] = {-121.1867f, 37.67385f};
	
	public Map<String, Object> extraDataSetUp(){
		
		Map<String, Object> extraDataMap = new HashMap<String, Object>();
		
		extraDataMap.put("area", 190.9484f);
		extraDataMap.put("user_id", "5fd8c02a3da20c000759e0f8");
		
		return extraDataMap;
	}

}
