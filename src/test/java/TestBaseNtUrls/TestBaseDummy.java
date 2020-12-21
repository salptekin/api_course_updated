package TestBaseNtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseDummy {
	
	protected RequestSpecification spec;
	
	@Before
	public void setUp() {
		
		spec = new RequestSpecBuilder().
								setBaseUri("http://dummy.restapiexample.com/api/v1").
								build();		
	}

}
