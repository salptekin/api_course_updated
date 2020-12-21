package TestBaseNtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseJsonPlaceHolder {
	
	protected RequestSpecification spec;
	
	//When you use @Before at the beginning of any method, it means you want that method to run
	//before every test method starts to run
	@Before
	public void setUp01() {		
		spec = new RequestSpecBuilder().
				              setBaseUri("https://jsonplaceholder.typicode.com").
				              build();
	}

}
