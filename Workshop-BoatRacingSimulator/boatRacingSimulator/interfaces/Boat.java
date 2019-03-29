package boatRacingSimulator.interfaces;

public interface Boat {

	public String getModel();
	public double getWeight();
	public double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed);
	
}
