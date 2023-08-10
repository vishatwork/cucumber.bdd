package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class roverHooks {
	
	@Before()
	public void beforeScenario(Scenario scenario) {
//		System.out.println("Scenario: " +scenario.getName());
	}
	
	@After()
	public void afterScenario(Scenario scenario) {
//		System.out.println("Scenario Completed: " +scenario.getName());
	}

}
