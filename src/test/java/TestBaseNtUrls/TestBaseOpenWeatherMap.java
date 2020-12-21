package TestBaseNtUrls;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseOpenWeatherMap {
	
	protected RequestSpecification spec;
	
	@Before
	public void setUp() {
		spec = new RequestSpecBuilder().
				            setBaseUri("https://api.openweathermap.org").
				            build();
	}

}
