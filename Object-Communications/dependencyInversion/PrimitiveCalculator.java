package dependencyInversion;

import dependencyInversion.interfaces.Calculator;
import dependencyInversion.interfaces.Operation;
import dependencyInversion.operation.Divide;
import dependencyInversion.operation.Multiply;
import dependencyInversion.operation.Subtract;
import dependencyInversion.operation.Sum;

public class PrimitiveCalculator implements Calculator {

		private Operation operation;
		
		
		public PrimitiveCalculator(){
			this.operation = new Sum();;
			
		}
		
		
		public int performCalculation(int firstOperand, int secondOperand) {
				return operation.execute(firstOperand, secondOperand);
				
		}
		
		public void changeStrategy(Operation operation) {
			 this.operation = operation;
		}


		
		
}
