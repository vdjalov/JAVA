package boatRacingSimulator.models;

import boatRacingSimulator.exceptions.ArgumentException;

public class SailBoat extends BaseBoat {

	private double sailEfficiency;
	
	public SailBoat(String model, int weight, double sailEfficiency) throws ArgumentException {
		super(model, weight);
		this.sailEfficiency = sailEfficiency;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {
		
		return (raceWindSpeed *(this.sailEfficiency / 100) - super.getWeight()
				+ (oceanCurrentSpeed / 2));
	}

}
