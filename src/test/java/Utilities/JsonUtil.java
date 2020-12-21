package Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/*
	 	 Utilities package is created to store useful methods in it.
	 	 For Example; If you are using ObjectMapper Class in Serialization and De-Serialization you need to 
	 	 			  create 2 methods, one is for Serialization, the other one is for De-Serialization.
	 	 			  When you create the once, you may use them again and again. It is very beneficial to make
	 	 			  code shorter, to prevent duplication, and to increase re-usability.
	 */

public class JsonUtil {

	//How to create De-Serialization Method by using ObjectMapper Class
	
	//1.Step: Create ObjectMapper Class object and make assignment by using static block.
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
	}
	
	//2.Step: Create a method to convert Json Data to Java Object
	public static <T> T convertJsonToJava(String json, Class<T> cls){
		
		T javaResult = null;
		
		try {			
			javaResult = mapper.readValue(json, cls);			
		} catch (JsonParseException e) {			
			System.err.println("Could not convert Json data to Java object " + e.getMessage());			
		} catch (JsonMappingException e) {			
			System.err.println("Could not convert Json data to Java object " + e.getMessage());		
		} catch (IOException e) {		
			System.err.println("Could not convert Json data to Java object " + e.getMessage());			
		}
		return javaResult;
	}
	
	//How to create Serialization Method by using ObjectMapper Class
	public static String convertJavaToJson(Object obj) {
		
		String jsonResult = null;
		
		try {
			jsonResult = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			System.out.println("Java object could not converted to Json Data " + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Java object could not converted to Json Data " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Java object could not converted to Json Data " + e.getMessage());
		}
		
		return jsonResult;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
