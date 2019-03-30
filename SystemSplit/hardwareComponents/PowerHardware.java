package systemSplit.hardwareComponents;

;

public class PowerHardware extends BaseHardware {

	public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
		super(name, maximumCapacity, maximumMemory);
	}

	
	@Override
	public void setMaximumCapacity(int maximumCapacity) {
		super.setMaximumCapacity(maximumCapacity);
	}
	
	
	@Override
	public void setMaximumMemory(int maximumMemory) {
		super.setMaximumMemory(maximumMemory);
		
	}


	@Override
	public void setType(String type) {
		super.setType("Power");
	}


	




	
	
	
	
}
