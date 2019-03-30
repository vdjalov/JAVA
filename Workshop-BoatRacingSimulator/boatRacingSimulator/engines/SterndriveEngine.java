package boatRacingSimulator.engines;

import boatRacingSimulator.exceptions.ArgumentException;

public class SterndriveEngine extends BaseEngine {

	private double output;
	
	public SterndriveEngine(String model, int horsepower, int displacement) throws ArgumentException {
		super(model, horsepower, displacement);
		this.output = calculateOuput(horsepower, displacement);
	}

	private double calculateOuput(int horsepower, double displacement) {
		return (horsepower * 7) + displacement;
	}

	@Override
	public double getOutput() {
		return this.output;
	}

	

}
