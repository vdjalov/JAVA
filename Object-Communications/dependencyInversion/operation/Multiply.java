package dependencyInversion.operation;

import dependencyInversion.interfaces.Operation;

public class Multiply implements Operation {

	@Override
	public int execute(int firstOperand, int secondOperand) {
		return firstOperand * secondOperand;
	}

}
