package systemSplit.repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import systemSplit.hardwareComponents.BaseHardware;
import systemSplit.softwareComponents.BaseSoftware;


public class Repository {

	private Map<String, BaseHardware> repository;
	
		public Repository() {
			this.repository = new LinkedHashMap<String, BaseHardware>();
		}
	
	
		public void addHardware(String name, BaseHardware bh) {
			this.repository.put(name, bh);
		}
		
		public Map <String, BaseHardware> getRepository() {
			return Collections.unmodifiableMap(this.repository);
		}


		public void addSoftware(String hardwareName, BaseSoftware bs) {
			if(this.repository.containsKey(hardwareName)) {
				int currentAvailableDiskCapacity = this.repository.get(hardwareName).getMaximumCapacity();
				int necessaryDiskCapacity = bs.getCapacityConsumption();
				int availableDiskCapacity = currentAvailableDiskCapacity - necessaryDiskCapacity;
				
				int currentAvailableMemoryCapacity = this.getRepository().get(hardwareName).getMaximumMemory();
				int necessaryMemory = bs.getMemoryConsumption();
				int availableMemory = currentAvailableMemoryCapacity - necessaryMemory;
					if(availableDiskCapacity >= 0 && availableMemory >= 0) {
						this.repository.get(hardwareName).setMaximumCapacity(availableDiskCapacity);
						this.repository.get(hardwareName).setMaximumMemory(availableMemory);
						this.repository.get(hardwareName).getAllSoftware().add(bs);
					}
			}
		}


		public void destroyComponent(String hardwareName, String softwareName) {
			if(this.repository.containsKey(hardwareName)) {
				for(int i = 0; i < this.repository.get(hardwareName).getAllSoftware().size(); i++) {
					String name = this.repository.get(hardwareName).getAllSoftware().get(i).getName();
					int memory = this.repository.get(hardwareName).getAllSoftware().get(i).getMemoryConsumption();
					int capacity = this.repository.get(hardwareName).getAllSoftware().get(i).getCapacityConsumption();
						if(name.equals(softwareName)) {
							int currentComponentMemory = this.repository.get(hardwareName).getMaximumMemory();
							int currentComponentCapacity = this.repository.get(hardwareName).getMaximumCapacity();
							this.repository.get(hardwareName).getAllSoftware().remove(i);
							this.repository.get(hardwareName).setMaximumMemory(memory + currentComponentMemory);
							this.repository.get(hardwareName).setMaximumCapacity(capacity + currentComponentCapacity);
						}
				}
			}
			
		}


		public int getSoftwareComponentsCount() {
			int totalComponents = 0;
			for(String value: this.repository.keySet()) {
				int currentSoftware = this.repository.get(value).getAllSoftware().size();
				totalComponents = totalComponents + currentSoftware;
			}
			return totalComponents;
		}


		public int getTotalOperationalMemoryInUse() {
			int totalMemoryInUse = 0;
			for(String value: this.repository.keySet()) {
				List<BaseSoftware> currentList = this.repository.get(value).getAllSoftware();
					for(int i = 0; i < currentList.size(); i++) {
						totalMemoryInUse = totalMemoryInUse + currentList.get(i).getMemoryConsumption();
					}
			}
			return totalMemoryInUse;
		}


		public int getToatalOperationalMemoryLeft() {
			int totalMemoryLeft = 0;
			for(String value: this.repository.keySet()) {
				totalMemoryLeft = totalMemoryLeft + this.repository.get(value).getMaximumMemory();
			}
			return totalMemoryLeft;
		}


		public int getTotalCapacityTaken() {
			int totalCapacityTaken = 0;
			for(String value: this.repository.keySet()) {
				List<BaseSoftware> currentList = this.repository.get(value).getAllSoftware();
					for(int i = 0; i < currentList.size(); i++) {
						totalCapacityTaken = totalCapacityTaken + currentList.get(i).getCapacityConsumption();
					}
			}
			return totalCapacityTaken;
		}


		public int getTotalCapacityLeft() {
			int totalCapacityLeft = 0;
			for(String value: this.repository.keySet()) {
				totalCapacityLeft = totalCapacityLeft + this.repository.get(value).getMaximumCapacity();
			}
			return totalCapacityLeft;
		}


		public int countExpressComponenst(String key) {
			AtomicInteger countExpressComponents = new AtomicInteger();
			this.repository.get(key).getAllSoftware().forEach(a -> {
				if(a.getType().equals("Express")) {
					countExpressComponents.incrementAndGet();
				}
			});
			return countExpressComponents.get();
		}


		public int countLightComponents(String key) {
			AtomicInteger countLightComponents = new AtomicInteger();
			this.repository.get(key).getAllSoftware().forEach(a -> {
				if(a.getType().equals("Light")) {
					countLightComponents.incrementAndGet();
				}
			});
			return countLightComponents.get();
		}


		public int getUsedMemory(String key) {
			int totalMemoryUsed = 0;
			List<BaseSoftware> bs = this.repository.get(key).getAllSoftware();	
				for(int i = 0; i < bs.size(); i++) {
					totalMemoryUsed+=bs.get(i).getMemoryConsumption();
				}
			return totalMemoryUsed;	
			
		}


		public int getUsedCapacity(String key) {
			int totalCapacityUsed = 0;
			List<BaseSoftware> bs = this.repository.get(key).getAllSoftware();	
				for(int i = 0; i < bs.size(); i++) {
					totalCapacityUsed+=bs.get(i).getCapacityConsumption();
				}
			return totalCapacityUsed;	
		}


		public void removeHardwareComponent(String key) {
			this.repository.remove(key);
			
		}
		
		
}


















