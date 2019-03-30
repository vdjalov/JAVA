package systemSplit.softwareComponents;

import systemSplit.interfaces.Softwarable;

public abstract class BaseSoftware implements Softwarable {

	private String name;
	private int capacityConsumption;
	private int memoryConsumption;
	private String type;
	
		public BaseSoftware(String name, int capacityConsumption, int memoryConsumption) {
			this.name = name;
			this.setCapacityConsumtion(capacityConsumption);
			this.setMemoryConsumption(memoryConsumption);
			this.setType(null);
		}

		@Override
		public int getCapacityConsumption() {
			return capacityConsumption;
		}

		@Override
		public void setCapacityConsumtion(int capacityConsumption) {
			this.capacityConsumption = capacityConsumption;
		}

		public int getMemoryConsumption() {
			return memoryConsumption;
		}

		@Override
		public void setMemoryConsumption(int memoryConsumption) {
			this.memoryConsumption = memoryConsumption;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) {
			this.type = type;
		}

		
}
