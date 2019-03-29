package boatRacingSimulator.engines;

public class JetEngine extends BaseEngine {

	private double output;
	
	public JetEngine(String model, int horsepower, double displacement) {
		super(model, horsepower, displacement);
		this.output = calculateOutput(horsepower, displacement);
	}

	
	private double calculateOutput(int horsepower, double displacement) {
		return (horsepower * 5) + displacement;
	}


	@Override
	public double getOutput() {
		return this.output;
	}

	

}
