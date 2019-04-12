package dependencyInversion.operation;

import dependencyInversion.interfaces.Operation;

public class Sum implements Operation {

	@Override
	public int execute(int firstOperand, int secondOperand) {
		return firstOperand + secondOperand;
	}

}
