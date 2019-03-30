package systemSplit.softwareComponents;

public class ExpressSoftware extends BaseSoftware {

	public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
		super(name, capacityConsumption, memoryConsumption);
	}

	
	@Override
	public void setMemoryConsumption(int memoryConsumption) {
			super.setMemoryConsumption(memoryConsumption * 2);
	}


	@Override
	public void setType(String type) {
		super.setType("Express");;
	}
	
	
}
