package boatRacingSimulator.models;

import boatRacingSimulator.interfaces.Engine;

public class Yacht extends BaseBoat {

	private Engine engine;
	private double cargoWeight;
	
	public Yacht(String model, double weight, Engine engine, double cargoWeight) {
		super(model, weight);
		this.engine = engine;
		this.cargoWeight = cargoWeight;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {

		return this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + 
				(oceanCurrentSpeed / 2);
	}

}
