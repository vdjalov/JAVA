package boatRacingSimulator.models;

import boatRacingSimulator.exceptions.ArgumentException;

public class RowBoat extends BaseBoat{
	
	private int oars;
	
	public RowBoat(String model, int weight, int oars) throws ArgumentException {
		super(model, weight);
		this.setOars(oars);
	}

	@Override
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed) {
		return (this.oars * 100) - super.getWeight() + oceanCurrentSpeed ;
	}
	
	private void setOars(int oars) throws ArgumentException {
			if(oars <= 0) {
				throw new ArgumentException("Oars must be a positive integer.");
			}
		this.oars = oars;
	}

}
