package boatRacingSimulator.races;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.interfaces.Boat;
import boatRacingSimulator.interfaces.Race;

public class BaseRace implements Race {

	private int distance;
	private double windSpeed;
	private double oceanCurrentSpeed;
	private Map<String, Boat> boatParticipants;
	private String allowedMotorboats;
		
		public BaseRace(int distance, double windSpeed, 
				double oceanCurrentSpeed, String allowedMotorboats) throws ArgumentException {
			this.setDistance(distance);
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

		private void setDistance(int distance) throws ArgumentException {
			if(distance <= 0) {
				throw new ArgumentException("Distance must be a positive integer.");
			}
			this.distance = distance;
		}
		
		
		


		
		
		
		
}
