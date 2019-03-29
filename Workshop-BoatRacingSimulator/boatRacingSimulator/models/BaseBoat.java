package boatRacingSimulator.models;

import boatRacingSimulator.interfaces.Boat;

public abstract class BaseBoat implements Boat {

	private String model;
	private double weight;
	
		protected BaseBoat(String model, double weight) {
			this.setModel(model);
			this.setWeight(weight);
		}

		@Override
		public String getModel() {
			return model;
		}

		private void setModel(String model) {
			this.model = model;
		}

		@Override
		public double getWeight() {
			return weight;
		}

		private void setWeight(double weight) {
			this.weight = weight;
		}
	
		public abstract double calculateSpeed(double oceanCurrentSpeed, double raceWindSpeed);
		
		
}
