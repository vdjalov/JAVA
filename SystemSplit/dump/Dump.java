package systemSplit.dump;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import systemSplit.hardwareComponents.BaseHardware;
import systemSplit.softwareComponents.BaseSoftware;

public class Dump {

	
	private Map<String, BaseHardware> dumpRepository;
	
		public Dump() {
			this.dumpRepository = new LinkedHashMap<String, BaseHardware>();
		}

		public Map<String, BaseHardware> getDumpRepository() {
			return Collections.unmodifiableMap(this.dumpRepository);
		}

		
		public void addHardwareComponent(String hardwareName, BaseHardware bh) {
			this.dumpRepository.put(hardwareName, bh);
		}
		
		public void removehardwareComponent(String hardwareName) {
			this.dumpRepository.remove(hardwareName);
		}

		
		public int getPowerHardwareComponents() {
			int totalHardwareComponents = 0;
				for(String value: this.dumpRepository.keySet()) {
					if(this.getDumpRepository().get(value).getType().equals("Power")) {
						totalHardwareComponents++;
					}
				}
			return totalHardwareComponents;
		}

		
		public int getExpressSoftwareComponents() {
			int expressComponentsCount = 0;
			for(String value: this.dumpRepository.keySet()) {
				List<BaseSoftware> currentSoftware = this.getDumpRepository().get(value).getAllSoftware();
					for(int i = 0; i < currentSoftware.size(); i++) {
						if(currentSoftware.get(i).getType().equals("Express")) {
							expressComponentsCount++;
						}
					}
			}
			return expressComponentsCount;
		}

		
		public int getLightSoftwareComponents() {
			int lightComponentsCount = 0;
			for(String value: this.dumpRepository.keySet()) {
				List<BaseSoftware> currentSoftware = this.getDumpRepository().get(value).getAllSoftware();
					for(int i = 0; i < currentSoftware.size(); i++) {
						if(currentSoftware.get(i).getType().equals("Light")) {
							lightComponentsCount++;
						}
					}
			}
			return lightComponentsCount;
		}

		public int getDumpedMemory() {
			int totalDumpedMemory = 0;
			for(String value: this.dumpRepository.keySet()) {
				List<BaseSoftware> currentSoftware = this.getDumpRepository().get(value).getAllSoftware();
					for(int i = 0; i < currentSoftware.size(); i++) {
						totalDumpedMemory+=currentSoftware.get(i).getMemoryConsumption();
					}
			}
			return totalDumpedMemory;
		}

		public int getDumpedCapacity() {
			int totalDumpedCapacity = 0;
			for(String value: this.dumpRepository.keySet()) {
				List<BaseSoftware> currentSoftware = this.getDumpRepository().get(value).getAllSoftware();
					for(int i = 0; i < currentSoftware.size(); i++) {
						totalDumpedCapacity+=currentSoftware.get(i).getCapacityConsumption();
					}
			}
			return totalDumpedCapacity;
		}
		
		
		
}














