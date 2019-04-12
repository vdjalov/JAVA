package dependencyInversion;

import dependencyInversion.interfaces.Operation;
import dependencyInversion.operation.Divide;
import dependencyInversion.operation.Multiply;
import dependencyInversion.operation.Subtract;
import dependencyInversion.operation.Sum;

public class CommandFactory {

	public Operation getOperation(char operator) {
		
	Operation operation = null;
		if(operator == '-') {
			 operation = new Subtract();
		 } else if(operator == '/') {
			 operation = new Divide();
		 } else if(operator == '*') {
			 operation = new Multiply();
		 } else if(operator == '+') {
			 operation = new Sum();
		 }
		
		return operation;
	}

}
