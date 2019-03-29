package boatRacingSimulator.models;

public class SailBoat extends BaseBoat {

	private double sailEfficiency;
	
	public SailBoat(String model, double weight, double sailEfficiency) {
		super(model, weight);
		this.sailEfficiency = sailEfficiency;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {
		
		return (raceWindSpeed *(this.sailEfficiency / 100) - super.getWeight()
				+ (oceanCurrentSpeed / 2));
	}

}
