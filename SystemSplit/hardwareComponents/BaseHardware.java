package systemSplit.hardwareComponents;

import java.util.ArrayList;
import java.util.List;
import systemSplit.interfaces.Hardwarable;
import systemSplit.softwareComponents.BaseSoftware;

public abstract class BaseHardware implements Hardwarable {

	private String name;
	private int maximumCapacity;
	private int maximumMemory;
	private String type;
	private List<BaseSoftware> allSoftware;
	
		public BaseHardware (String name, int maximumCapacity, int maximumMemory) {
			this.name = name;
			this.setMaximumCapacity(maximumCapacity);
			this.setMaximumMemory(maximumMemory);
			this.setType(null);
			this.allSoftware = new ArrayList<BaseSoftware>();
		}

		@Override
		public int getMaximumCapacity() {
			return this.maximumCapacity;
		}

		@Override
		public void setMaximumCapacity(int maximumCapacity) {
			this.maximumCapacity = maximumCapacity;
		}

		@Override
		public int getMaximumMemory() {
			return this.maximumMemory;
		}

		@Override
		public void setMaximumMemory(int maximumMemory) {
			this.maximumMemory = maximumMemory;
		}


		@Override
		public List<BaseSoftware> getAllSoftware() {
			return allSoftware;
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
