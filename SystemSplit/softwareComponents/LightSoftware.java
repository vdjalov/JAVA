package systemSplit.softwareComponents;

public class LightSoftware extends BaseSoftware{

	public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
		super(name, capacityConsumption, memoryConsumption);
	}

	
	@Override
	public void setMemoryConsumption(int memoryConsumption) {
		super.setMemoryConsumption((int) (memoryConsumption * 0.5));
	}
	
	
	@Override
	public void setCapacityConsumtion(int capacityConsumption) {
		super.setCapacityConsumtion((int) (capacityConsumption + (capacityConsumption * 0.5)));
	}
	
	
	@Override
	public void setType(String type) {
		super.setType("Light");;
	}
}
