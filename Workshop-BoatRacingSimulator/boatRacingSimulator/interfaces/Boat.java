package boatRacingSimulator.interfaces;

public interface Boat {

	public String getModel();
	public double getWeight();
	public abstract double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed);
	
}
