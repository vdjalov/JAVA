package boatRacingSimulator.models;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.interfaces.Engine;

public class Yacht extends BaseBoat {

	private Engine engine;
	int cargoWeight;
	
	public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
		super(model, weight);
		this.engine = engine;
		setCargoWeight(cargoWeight);
	}

	private void setCargoWeight(int cargoWeight) throws ArgumentException {
		if(cargoWeight <= 0) {
			throw new ArgumentException("Cargo Weight must be a positive integer.");
		}
		this.cargoWeight = cargoWeight;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {

		return this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + 
				(oceanCurrentSpeed / 2);
	}

}
