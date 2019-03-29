package boatRacingSimulator.engines;

public class SterndriveEngine extends BaseEngine {

	private double output;
	
	public SterndriveEngine(String model, int horsepower, double displacement) {
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
