package boatRacingSimulator.models;

import boatRacingSimulator.interfaces.Engine;

public class PowerBoat extends BaseBoat {

	private Engine engineOne;
	private Engine engineTwo;
	
	public PowerBoat(String model, double weight, Engine engineOne, Engine engineTwo) {
		super(model, weight);
		this.engineOne = engineOne;
		this.engineTwo = engineTwo;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {
		return (this.engineOne.getOutput() + this.engineTwo.getOutput()) - 
				super.getWeight() + (oceanCurrentSpeed / 5);
	}

}
