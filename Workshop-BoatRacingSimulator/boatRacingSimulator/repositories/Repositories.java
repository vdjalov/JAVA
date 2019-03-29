package boatRacingSimulator.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import boatRacingSimulator.interfaces.Boat;
import boatRacingSimulator.interfaces.Engine;
import boatRacingSimulator.interfaces.Race;

public class Repositories {

	private Map<String, Boat> availableBoats;
	private Map<String, Engine> availableEngines;
	private Race availableRace;
	
		public Repositories() {
			this.availableBoats = new HashMap<String, Boat>();
			this.availableEngines = new HashMap<String, Engine>();
			this.availableRace = null;
		}

		public Map<String, Boat> getAvailableBoats() {
			return Collections.unmodifiableMap(this.availableBoats);
		}

		public Map<String, Engine> getAvailableEngines() {
			return Collections.unmodifiableMap(this.availableEngines);
		}

		public Race getAvailableRace() {
			return this.availableRace;
		}
		
		public void setRace(Race race) {
			this.availableRace = race;
		}
		// Adding an engine!
		public void addEngine(String model, Engine engine) {
			this.availableEngines.put(model, engine);
		}

		// Adding an engine!
			public void addBoat(String model, Boat boat) {
				this.availableBoats.put(model, boat);
			}
		

		

		
		
		
		
		
		
}
