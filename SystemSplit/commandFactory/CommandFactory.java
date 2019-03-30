package systemSplit.commandFactory;

import java.util.ArrayList;
import java.util.List;

import systemSplit.dump.Dump;
import systemSplit.hardwareComponents.BaseHardware;
import systemSplit.hardwareComponents.HeavyHardware;
import systemSplit.hardwareComponents.PowerHardware;
import systemSplit.repository.Repository;
import systemSplit.softwareComponents.BaseSoftware;
import systemSplit.softwareComponents.ExpressSoftware;
import systemSplit.softwareComponents.LightSoftware;

public class CommandFactory {

	private Repository repository;
	private Dump dump;
	
		public CommandFactory() {
			this.repository = new Repository();
			dump = new Dump();
		}
	
	public void registerPowerHardware(String name, int maximumCapacity, int maximumMemory) {
		maximumCapacity = (int) Math.ceil((maximumCapacity * 0.25));
		maximumMemory = (maximumMemory  + (maximumMemory * 75) /100);
		PowerHardware ph = new PowerHardware(name, maximumCapacity, maximumMemory);
		this.repository.addHardware(name, ph);
	}

	public void registerHeavyHardware(String name, int maximumCapacity, int maximumMemory) {
		maximumCapacity = maximumCapacity * 2;
		maximumMemory = (int) Math.ceil((maximumMemory * 0.75));
		HeavyHardware hh = new HeavyHardware(name, maximumCapacity, maximumMemory);
		this.repository.addHardware(name, hh);
	}

	public void registerLightSoftware(String hardwareName, 
			String softwareName, int diskCapacity, int memoryCapacity) {
		
		BaseSoftware ls = new LightSoftware(softwareName,  diskCapacity, memoryCapacity);
			this.repository.addSoftware(hardwareName, ls);
	}

	public void registerExpressSoftware(String hardwareName, 
			String softwareName, int diskCapacity, int memoryCapacity) {
		
		BaseSoftware es = new ExpressSoftware(softwareName,  diskCapacity, memoryCapacity);
		this.repository.addSoftware(hardwareName, es);
		
	}

	public void releaseSoftwareComponent(String hardwareName, String softwareName) {
		this.repository.destroyComponent(hardwareName, softwareName);
		
	}

	public String printStatistics() {
		StringBuilder sb = new StringBuilder();
		int countOfHardwareComponents = this.repository.getRepository().size();
		int countOfSoftwareComponents = this.repository.getSoftwareComponentsCount();
		int totalOperationalMemoryInUse = this.repository.getTotalOperationalMemoryInUse();
		int totalOperationalMemoryLeft = this.repository.getToatalOperationalMemoryLeft();
		int totalOperationalMemory = totalOperationalMemoryInUse + totalOperationalMemoryLeft;
		int totalCapacityTaken = this.repository.getTotalCapacityTaken();
		int totalCapacityLeft = this.repository.getTotalCapacityLeft();
		int totalDiskCapacity = totalCapacityTaken + totalCapacityLeft;
		sb.append("System Analysis")
		  .append(System.lineSeparator())
		  .append("Hardware Components: ").append(countOfHardwareComponents)
		  .append(System.lineSeparator())
		  .append("Software Components: ").append(countOfSoftwareComponents)
		  .append(System.lineSeparator())
		  .append("Total Operational Memory: ").append(totalOperationalMemoryInUse).append(" / ")
		  .append(totalOperationalMemory)
		  .append(System.lineSeparator())
		  .append("Total Capacity Taken: ").append(totalCapacityTaken).append(" / ")
		  .append(totalDiskCapacity);
		
		return sb.toString();
	}

	
	public String systemSplit() {
		StringBuilder sb = new StringBuilder();
			for(String value: this.repository.getRepository().keySet()) {
				String type = this.repository.getRepository().get(value).getType();
				if(type.equals("Power")) {
					int countExpressSoftwareComponents = this.repository.countExpressComponenst(value);
					int countLightSoftwareComponents = this.repository.countLightComponents(value);
					int totalMemoryUsage = this.repository.getUsedMemory(value);
					int totalMemoryUnused = this.repository.getRepository().get(value).getMaximumMemory();
					int overallMemory = totalMemoryUsage + totalMemoryUnused;
					int capacityUsed = this.repository.getUsedCapacity(value);
					int capacityLeft = this.repository.getRepository().get(value).getMaximumCapacity();
					int overallCapacity = capacityUsed + capacityLeft;
					List<String> listComponents = new ArrayList<String>();
					this.repository.getRepository().get(value).getAllSoftware().stream()
					 	.forEach(a -> listComponents.add(a.getName()));
					String softwareComponents = String.join(", ", listComponents);
						if(softwareComponents.trim().isEmpty()) {
							softwareComponents = "None";
						}
					fillStringBuilder(sb, value, countExpressSoftwareComponents,
							countLightSoftwareComponents, totalMemoryUsage, overallMemory, 
							capacityUsed, overallCapacity, type, softwareComponents);
				}
			} 
			
			for(String value: this.repository.getRepository().keySet()) {
				String type = this.repository.getRepository().get(value).getType();
				if(type.equals("Heavy")) {
					int countExpressSoftwareComponents = this.repository.countExpressComponenst(value);
					int countLightSoftwareComponents = this.repository.countLightComponents(value);
					int totalMemoryUsage = this.repository.getUsedMemory(value);
					int totalMemoryUnused = this.repository.getRepository().get(value).getMaximumMemory();
					int overallMemory = totalMemoryUsage + totalMemoryUnused;
					int capacityUsed = this.repository.getUsedCapacity(value);
					int capacityLeft = this.repository.getRepository().get(value).getMaximumCapacity();
					int overallCapacity = capacityUsed + capacityLeft;
					List<String> listComponents = new ArrayList<String>();
					this.repository.getRepository().get(value).getAllSoftware().stream()
					 	.forEach(a -> listComponents.add(a.getName()));
					String softwareComponents = String.join(", ", listComponents);
						if(softwareComponents.trim().isEmpty()) {
							softwareComponents = "None";
						}
					fillStringBuilder(sb, value, countExpressSoftwareComponents,
							countLightSoftwareComponents, totalMemoryUsage, overallMemory, 
							capacityUsed, overallCapacity, type, softwareComponents);
				}
			} 
		return sb.toString();
	}

	
	
	private void fillStringBuilder(StringBuilder sb, String value, int countExpressSoftwareComponents,
			int countLightSoftwareComponents, int totalMemoryUsage, int overallMemory, int capacityUsed,
			int overallCapacity, String type, String softwareComponents) {
		sb.append("Hardware Component - ").append(value)
		  .append(System.lineSeparator())
		  .append("Express Software Components - ").append(countExpressSoftwareComponents)
		  .append(System.lineSeparator())
		  .append("Light Software Components - ").append(countLightSoftwareComponents)
		  .append(System.lineSeparator())
		  .append("Memory Usage: ").append(totalMemoryUsage).append(" / ")
		  .append(overallMemory).append(System.lineSeparator())
		  .append("Capacity Usage: ").append(capacityUsed).append(" / ")
		  .append(overallCapacity).append(System.lineSeparator())
		  .append("Type: ").append(type).append(System.lineSeparator())
		  .append("Software Components: ").append(softwareComponents)
		  .append(System.lineSeparator());
		
	}

	public void dumpComponent(String hardwareName) {
		if(this.repository.getRepository().containsKey(hardwareName)) {
			BaseHardware bh = this.repository.getRepository().get(hardwareName);
			this.dump.addHardwareComponent(hardwareName, bh);
			this.repository.removeHardwareComponent(hardwareName);	
		}
	}

	public void restoreDumpedFile(String hardwareName) {
		if(this.dump.getDumpRepository().containsKey(hardwareName)) {
			BaseHardware bh = this.dump.getDumpRepository().get(hardwareName);
			this.repository.addHardware(hardwareName, bh);
			this.dump.removehardwareComponent(hardwareName);
		}
		
	}

	public void completelyRemoveComponentFromDump(String hardwareName) {
		if(this.dump.getDumpRepository().containsKey(hardwareName)) {
			this.dump.removehardwareComponent(hardwareName);
		}
		
	}

	public String printDumpStatistics() {
		int dumpRepositorySize = this.dump.getDumpRepository().size();
		int hardwarePowerComponentsSize = this.dump.getPowerHardwareComponents();
		int hardwareHeavyComponetsSize = dumpRepositorySize - hardwarePowerComponentsSize;
		int expressSoftwareComponents = this.dump.getExpressSoftwareComponents();
		int lightSoftwareComponents = this.dump.getLightSoftwareComponents();
		int totalDumpedMemory = this.dump.getDumpedMemory();
		int totalDumpedCapacity = this.dump.getDumpedCapacity();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dump Analysis")
		  .append(System.lineSeparator())
		  .append("Power Hardware Components: ").append(hardwarePowerComponentsSize)
		  .append(System.lineSeparator())
		  .append("Heavy Hardware Components: ").append(hardwareHeavyComponetsSize)
		  .append(System.lineSeparator())
		  .append("Express Software Components: ").append(expressSoftwareComponents)
		  .append(System.lineSeparator())
		  .append("Light Software Components: ").append(lightSoftwareComponents)
		  .append(System.lineSeparator())
		  .append("Total Dumped Memory: ").append(totalDumpedMemory)
		  .append(System.lineSeparator())
		  .append("Total Dumped Capacity: ").append(totalDumpedCapacity);
		
		return sb.toString();
		
	}

	
	
	
	
}













