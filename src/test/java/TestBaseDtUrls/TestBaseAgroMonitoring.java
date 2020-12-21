package TestBaseDtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseAgroMonitoring {
	
	protected RequestSpecification spec04;
	
	@Before
	public void setUp04() {
		
		spec04 = new RequestSpecBuilder().
									setBaseUri("http://api.agromonitoring.com").
									build();
	}

}
