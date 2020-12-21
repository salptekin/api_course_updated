package TestBaseDtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseHerOkuApp {
	
	protected RequestSpecification spec02;
	
	@Before
	public void setUp02() {
		
		spec02 = new RequestSpecBuilder().
								setBaseUri("https://restful-booker.herokuapp.com").
								build();
		
	}

}
