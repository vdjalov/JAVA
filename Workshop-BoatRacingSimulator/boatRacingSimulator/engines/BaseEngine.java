package boatRacingSimulator.engines;

import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.interfaces.Engine;

public abstract class BaseEngine implements Engine {
	
	private String model;
	private int horsepower;
	private int displacement;
	
	
		protected BaseEngine(String model,int horsepower, int displacement) throws ArgumentException {
			this.setModel(model);
			this.setHorsepower(horsepower);
			this.setDisplacement(displacement);
		}


		@Override
		public int getHorsepower() {
			return horsepower;
		}

		private void setHorsepower(int horsePower) throws ArgumentException {
			if(horsePower <= 0) {
				throw new ArgumentException("Horsepower must be a positive integer.");
			}
			this.horsepower = horsePower;
		}

		@Override
		public double getDisplacement() {
			return displacement;
		}

		private void setDisplacement(int displacement) throws ArgumentException {
			if(displacement <= 0) {
				throw new ArgumentException("Displacement must be a positive integer.");
			}
			this.displacement = displacement;
		}
	
		
		private void setModel(String model) throws ArgumentException {
			if(model.length() < 3) {
				throw new ArgumentException("Model name must be at least 3 symbols long.");
			}
			this.model = model;
		}

}
