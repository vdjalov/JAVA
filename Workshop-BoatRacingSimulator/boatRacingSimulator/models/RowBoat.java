package boatRacingSimulator.models;

public class RowBoat extends BaseBoat{
	
	private int oars;
	
	public RowBoat(String model, double weight, int oars) {
		super(model, weight);
		this.oars = oars;
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {
		return (this.oars * 100) - super.getWeight() + oceanCurrentSpeed ;
	}

}
