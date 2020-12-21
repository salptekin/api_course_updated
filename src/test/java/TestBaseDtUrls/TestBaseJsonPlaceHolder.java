package TestBaseDtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseJsonPlaceHolder {
	
	//When we want to specify our request we use RequestSpecification as data type
	protected RequestSpecification spec01;
	
	//If you use @Before annotation, it means the method which you created after @Before
	//will be executed before every test method.
	@Before
	public void setUp01() {
		
		spec01 = new RequestSpecBuilder().
								setBaseUri("https://jsonplaceholder.typicode.com").
								build();
		
	}

}
