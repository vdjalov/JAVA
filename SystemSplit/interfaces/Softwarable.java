package systemSplit.interfaces;

public interface Softwarable {

	public void setCapacityConsumtion(int capacityConsumtion);
	public void setMemoryConsumption(int memoryConsumption);
	public int getCapacityConsumption();
	public int getMemoryConsumption();
	public String getName();
	public String getType();
	public void setType(String type);
}
