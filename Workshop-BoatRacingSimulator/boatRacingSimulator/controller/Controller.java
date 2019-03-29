package boatRacingSimulator.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import boatRacingSimulator.engines.JetEngine;
import boatRacingSimulator.engines.SterndriveEngine;
import boatRacingSimulator.exceptions.InsufficientContestantsException;
import boatRacingSimulator.exceptions.NoSetRaceException;
import boatRacingSimulator.exceptions.RaceAlreadyExistsException;
import boatRacingSimulator.interfaces.Boat;
import boatRacingSimulator.interfaces.Engine;
import boatRacingSimulator.interfaces.Race;
import boatRacingSimulator.models.PowerBoat;
import boatRacingSimulator.models.RowBoat;
import boatRacingSimulator.models.SailBoat;
import boatRacingSimulator.models.Yacht;
import boatRacingSimulator.races.BaseRace;
import boatRacingSimulator.repositories.Repositories;

public class Controller {
	
	private Repositories repository;
	
		public Controller() {
			this.repository = new Repositories();
		}

		
		public String createEngine(String input[]) {
			String model = input[1];
			int horsepower = Integer.valueOf(input[2]);
			double displacement = Double.valueOf(input[3]);
			String type = input[4];
			if(type.equals("Jet")) {
				Engine jetEngine = new JetEngine(model, horsepower, displacement);
				this.repository.addEngine(model, jetEngine);
			} else if (type.equals("Sterndrive")) {
				Engine sternEngine = new SterndriveEngine(model, horsepower, displacement);
				this.repository.addEngine(model, sternEngine);
			}
	return String.format("Engine model %s with %d HP and displacement %.0f cm3 created successfully."
				, model, horsepower, displacement);
		}

		
		public String addRace(String input[]) throws RaceAlreadyExistsException {
				if(this.repository.getAvailableRace() != null){
					throw new RaceAlreadyExistsException("The current race is already set.");
				}
				
			double distance = Double.valueOf(input[1]);
			double windSpeed = Double.valueOf(input[2]);
			double oceanCurrentSpeed = Double.valueOf(input[3]);
			String allowedMotorboats = input[4];
			Race race = new BaseRace(distance, windSpeed, oceanCurrentSpeed, allowedMotorboats);
			this.repository.setRace(race);
			
			return String.format("A new race with distance %.0f, wind speed %.0f m/s and "
					+ "ocean current speed %.0f has been set.", 
					distance, windSpeed, oceanCurrentSpeed);
		}

		
		public String createPowerBoat(String[] input) {
			String model = input[1];
			double weight = Double.valueOf(input[2]);
			Engine engineOne = this.repository.getAvailableEngines().get(input[3]);
			Engine engineTwo = this.repository.getAvailableEngines().get(input[4]);
			Boat powerBoat = new PowerBoat(model, weight, engineOne, engineTwo);
			this.repository.addBoat(model, powerBoat);
			return String.format("Power boat with model %s registered succsessfully.",model);
		}

		
		public String createRowBoat(String[] input) {
			String model = input[1];
			double weight = Double.valueOf(input[2]);
			int oars = Integer.valueOf(input[3]);
			Boat rowBoat = new RowBoat(model, weight, oars);
			this.repository.addBoat(model, rowBoat);
			return String.format("Row boat with model %s registered succsessfully.",model);
		}

		
		public String createSailBoat(String[] input) {
			String model = input[1];
			double weight = Double.valueOf(input[2]);
			double sailEfficiency = Double.valueOf(input[3]);
			Boat sailBoat = new SailBoat(model, weight, sailEfficiency);
			this.repository.addBoat(model, sailBoat);
			return String.format("Sail boat with model %s registered succsessfully.",model);
		}

		
		public String createYacht(String[] input) {
			String model = input[1];
			double weight = Double.valueOf(input[2]);
			Engine engine = this.repository.getAvailableEngines().get(input[3]);
			double cargoWeight = Double.valueOf(input[4]);
			Boat yacht = new Yacht(model, weight, engine, cargoWeight);
			this.repository.addBoat(model, yacht);
			return String.format("Yacht boat with model %s registered succsessfully.",model);
		}

		
		public String signUp(String[] input) throws NoSetRaceException {
			if(this.repository.getAvailableRace() == null) {
				throw new NoSetRaceException("There is currently no race set.");
			}
			String model = input[1];
			Boat boat = this.repository.getAvailableBoats().get(model);
				if(this.repository.getAvailableRace().getAllowedMotorboats().equals("false")) {
					if(boat.getClass().getSimpleName().equals("PowerBoat") || 
							boat.getClass().getSimpleName().equals("Yacht")) {
						throw new IllegalArgumentException("The specified boat does not meet "
								+ "the race constraints.");
					}
				}
				
				this.repository.getAvailableRace().add(model, boat);
				return String.format("Boat with model %s has signed up for the current Race."
						, model);
			
		}

		
		public String startRace(String[] input) throws NoSetRaceException, InsufficientContestantsException {
			if(this.repository.getAvailableRace() == null) {
				throw new NoSetRaceException("There is currently no race set.");
			}
			
			if(this.repository.getAvailableRace().getBoatParticipants().size() < 3) {
				throw new InsufficientContestantsException("Not enough contestants for the race.");
			}
		
			double oceanCurrentSpeed = this.repository.getAvailableRace().getOceanCurrentSpeed();
			double raceWindSpeed = this.repository.getAvailableRace().getWindSpeed();
			Map<Boat, Double> sortedBoats = new HashMap<Boat, Double>();
			
			for(String value: this.repository.getAvailableRace().getBoatParticipants().keySet()) {
				double speed = this.repository.getAvailableRace()
						.getBoatParticipants().get(value)
						.calculateSpeed(oceanCurrentSpeed, raceWindSpeed);
				sortedBoats.put(this.repository.getAvailableRace()
						.getBoatParticipants().get(value), speed);
			}
			
			LinkedHashMap<Boat, Double> finalSortedBoats = new LinkedHashMap<Boat, Double>();
			sortedBoats.entrySet().stream()	
				.sorted((a, b) -> {
					if(a.getValue() == b.getValue()) {
						return Double.compare(a.getValue(), b.getValue());
					}
					return Double.compare(b.getValue(), a.getValue());
				})
				.limit(3)
				.forEach(a -> {
					finalSortedBoats.put(a.getKey(), a.getValue());
				});
			Boat firstBoat = null;
			Boat secondBoat = null;
			Boat thirdBoat = null;
			int count = 1;
			String firstBoatRaceTime = "";
			String secondBoatRaceTime = "";
			String thirdBoatRaceTime = "";
			
			double distance = this.repository.getAvailableRace().getDistance();
				for(Boat value: finalSortedBoats.keySet()) {
					if(count == 1) {
						firstBoat = value;
						firstBoatRaceTime = checkPrintValue(distance / finalSortedBoats.get(value));
					} else if(count == 2) {
						secondBoat = value;
						secondBoatRaceTime = checkPrintValue(distance / finalSortedBoats.get(value));
					} else if(count == 3) {
						thirdBoat = value;
						thirdBoatRaceTime = checkPrintValue(distance / finalSortedBoats.get(value));
					} 
					count++;
				}
				
			StringBuilder sb = new StringBuilder();
			sb.append("First place: ").append(firstBoat.getClass().getSimpleName())
			  .append("Model: ").append(firstBoat.getModel())
			  .append(System.lineSeparator())
			  .append("Time: ").append(firstBoatRaceTime)
			  .append(System.lineSeparator())
			  .append("Second place: ").append(secondBoat.getClass().getSimpleName())
			  .append("Model: ").append(secondBoat.getModel())
			  .append(System.lineSeparator())
			  .append("Time: ").append(secondBoatRaceTime)
			  .append(System.lineSeparator())
			  .append("Third place: ").append(thirdBoat.getClass().getSimpleName())
			  .append("Model: ").append(thirdBoat.getModel())
			  .append(System.lineSeparator())
			  .append("Time: ").append(thirdBoatRaceTime)
			  .append(System.lineSeparator());
			
			this.repository.setRace(null);
			return sb.toString();
		}

		// Formatting the final output
		private String checkPrintValue(double output) {
			if(output < 0) {
				return "Did not finish";
			}
			return String.format("%.2f sec", output);
		}


		public String getRaceStatistics() {
			double oneShare = 100 / this.repository.getAvailableRace().getBoatParticipants().size();
			double powerBoat = 0;
			double rowBoat = 0;
			double sailBoat = 0;
			double yacht = 0;
				
				for(String value: this.repository.getAvailableRace().getBoatParticipants().keySet()) {
					String className = this.repository.getAvailableRace().getBoatParticipants()
							.get(value).getClass().getSimpleName();
					
					switch(className) {
					case "PowerBoat":
						powerBoat++;
						break;
					case "RowBoat":
						rowBoat++;
						break;
					case "SailBoat":
						sailBoat++;
						break;
					case "Yacht":
						yacht++;
						break;
					}
				}
			
			StringBuilder sb = new StringBuilder();
			sb.append("PowerBoat -> ").append(String.format("%.2f%%", powerBoat * oneShare))
			  .append(System.lineSeparator())
			  .append("RowBoat -> ").append(String.format("%.2f%%", rowBoat * oneShare))
			  .append(System.lineSeparator())
			  .append("SailBoat -> ").append(String.format("%.2f%%", sailBoat * oneShare))
			  .append(System.lineSeparator())
			  .append("YachtBoat -> ").append(String.format("%.2f%%", yacht * oneShare))
			  .append(System.lineSeparator());
			
			return sb.toString();
		}	
}














