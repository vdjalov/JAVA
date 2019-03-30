package boatRacingSimulator.models;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.interfaces.Boat;

public abstract class BaseBoat implements Boat {

	private String model;
	private int weight;
	
		protected BaseBoat(String model, int weight) throws ArgumentException {
			this.setModel(model);
			this.setWeight(weight);
		}

		@Override
		public String getModel() {
			return model;
		}

		private void setModel(String model) throws ArgumentException {
			if(model.length() < 5) {
				throw new ArgumentException("Model's name must be at least 5 symbols long.");
			}
			this.model = model;
		}

		@Override
		public double getWeight() {
			return weight;
		}

		private void setWeight(int weight) throws ArgumentException {
			if((weight <= 0)) {
				throw new ArgumentException("Weight must be a positive integer.");
			}
			this.weight = weight;
		}
	
		@Override
		public abstract double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed);
		
		
}
