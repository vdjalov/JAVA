package dependencyInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dependencyInversion.interfaces.Calculator;
import dependencyInversion.interfaces.Operation;

public class Engine {

	private BufferedReader bf;
	private Calculator primitiveCalculator;
	private CommandFactory cf;
	
		public Engine() {
			this.bf = new BufferedReader(new InputStreamReader(System.in));
			this.primitiveCalculator = new PrimitiveCalculator();
			cf = new CommandFactory();
		}
	
	
		public void run() throws IOException {
		
			String input[] = this.bf.readLine().split("[ ]+");
				while(!input[0].equalsIgnoreCase("end")) {
					if(input[0].equals("mode")) {
						Operation operation = cf.getOperation(input[1].charAt(0));
						primitiveCalculator.changeStrategy(operation);
					} else {
						int firstOperand = Integer.valueOf(input[0]);
						int secondOperand = Integer.valueOf(input[1]);
						System.out.println(primitiveCalculator
								.performCalculation(firstOperand, secondOperand));
					}
					input = bf.readLine().split("[ ]+");
				}
				
		}
}
