package boatRacingSimulator.races;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import boatRacingSimulator.interfaces.Boat;
import boatRacingSimulator.interfaces.Race;

public class BaseRace implements Race {

	private double distance;
	private double windSpeed;
	private double oceanCurrentSpeed;
	private Map<String, Boat> boatParticipants;
	private String allowedMotorboats;
		
		public BaseRace(double distance, double windSpeed, 
				double oceanCurrentSpeed, String allowedMotorboats) {
			this.distance = distance;
			this.windSpeed = windSpeed;
			this.oceanCurrentSpeed = oceanCurrentSpeed;
			this.boatParticipants = new HashMap<String ,Boat>();
			this.allowedMotorboats = allowedMotorboats;
		}

		@Override
		public void add(String model, Boat boat) {
			this.boatParticipants.put(model, boat);
		}

		@Override
		public Map<String, Boat> getBoatParticipants() {
			return Collections.unmodifiableMap(this.boatParticipants);
		}

		@Override
		public String getAllowedMotorboats() {
			return allowedMotorboats;
		}

		@Override
		public double getWindSpeed() {
			return windSpeed;
		}

		@Override
		public double getOceanCurrentSpeed() {
			return oceanCurrentSpeed;
		}

		@Override
		public double getDistance() {
			return distance;
		}

		
		

		


		
		
		
		
}
