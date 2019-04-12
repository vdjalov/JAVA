package dependencyInversion.interfaces;

public interface Calculator {

	public int performCalculation(int firstOperand, int secondOperand);
	public void changeStrategy(Operation operation);
}
