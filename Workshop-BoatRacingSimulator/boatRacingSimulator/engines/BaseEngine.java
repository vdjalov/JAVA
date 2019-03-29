package boatRacingSimulator.engines;

import boatRacingSimulator.interfaces.Engine;

public abstract class BaseEngine implements Engine {
	
	private String model;
	private int horsepower;
	private double displacement;
	
	
		protected BaseEngine(String model,int horsepower, double displacement) {
			this.setHorsepower(horsepower);
			this.setDisplacement(displacement);
		}


		@Override
		public int getHorsepower() {
			return horsepower;
		}

		private void setHorsepower(int horsePower) {
			this.horsepower = horsePower;
		}

		@Override
		public double getDisplacement() {
			return displacement;
		}

		private void setDisplacement(double displacement) {
			this.displacement = displacement;
		}
	
}
