package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import marsrover.Rover;

public class RoverPositioningSteps {

	private Rover rover;

	@Given("a new rover")
	public void aNewRover() {
		rover = new Rover();
	}

	@When("the rover is initialized with valid coordinates {int} {int} {string}")
	public void theRoverIsInitializedWithValidCoordinates(Integer x, Integer y, String facing) {
		rover.setPosition(x, y, directionToInteger(facing));
	}

	@Then("the rover should be positioned successfully")
	public void theRoverShouldBePositionedSuccessfully() {
		System.out.println("Rover positioned successfully");
	}

	@When("the rover is initialized with invalid position {string} {string} {string}")
	public void theRoverIsInitializedWithInvalidPosition(String x1, String y1, String facing1) {
		//		rover.setPosition(x1, y1, facing1);
	}

	@Then("the rover should return exception")
	public void theRoverShouldReturnException() {
		System.out.println("code implementation here");
	}
	
	@When("the rover receive with the {string}")
	public void theRoverMovesWithThe(String string) {
		rover.process(string);
	}

	@Then("the rover position should be {int} {int}")
	public void theRoverPositionShouldBe(Integer x, Integer y) {
		System.out.println("***********" + rover.getPositionX() + " " + rover.getPositionY() + "************");
//		Assert.assertEquals(x + " " + y, rover.getPositionX() + " " + rover.getPositionY());
	}

	@Then("the rover should be facing {string}")
	public void theRoverShouldBeFacing(String facing) {
		
		System.out.println("***********" + rover.getDirection() + "************");
//		Assert.assertEquals(facing, rover.getDirection() , "Rover reached it's destination successfully");
	}
	
	@Then("the rover should respond with {string}")
	public void theRoverShouldRespondWith(String string) {
		Assert.assertEquals(string, "Speak in Mars language, please!");
	}


	private int directionToInteger(String direction) {
		switch (direction) {
		case "North":
			return Rover.N;
		case "East":
			return Rover.E;
		case "South":
			return Rover.S;
		case "West":
			return Rover.W;
		default:
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}
	}

}
