package boatRacingSimulator.interfaces;


import java.util.Map;

public interface Race {

	public void add(String model, Boat boat);
	public Map<String, Boat> getBoatParticipants();
	public String getAllowedMotorboats();
	public double getWindSpeed();
	public double getOceanCurrentSpeed();
	public double getDistance();
}
