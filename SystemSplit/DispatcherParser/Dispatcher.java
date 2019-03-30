package systemSplit.DispatcherParser;

import systemSplit.commandFactory.CommandFactory;


public class Dispatcher {

	CommandFactory cf;
	
	
	public Dispatcher() {
		cf = new CommandFactory();
	}
	
	
	public void executeHardware(String command,String name, int maximumCapacity, int maximumMemory) {
		if(command.equals("RegisterPowerHardware")) {
			cf.registerPowerHardware(name, maximumCapacity, maximumMemory);
		}else if (command.equals("RegisterHeavyHardware")) {
			cf.registerHeavyHardware(name, maximumCapacity, maximumMemory);
		}
	}


	public void registerSoftware(String command, String hardwareName, 
			String softwareName, int diskCapacity, int memoryCapacity) {	
		if(command.equals("RegisterLightSoftware")) {
			cf.registerLightSoftware(hardwareName, softwareName, diskCapacity, memoryCapacity);
		} else if (command.equals("RegisterExpressSoftware")) {
			cf.registerExpressSoftware(hardwareName, softwareName, diskCapacity, memoryCapacity);
		}
		
	}


	public void releaseSoftware(String hardwareName, String softwareName) {
		cf.releaseSoftwareComponent(hardwareName, softwareName);
		
	}


	public String analyze() {
		return cf.printStatistics();
	}


	public String systemSplit() {
		return cf.systemSplit();
	}


	public void dumpHardwareComponent(String hardwareName) {
		cf.dumpComponent(hardwareName);
		
	}


	public void restoreHardwareComponent(String hardwareName) {
		cf.restoreDumpedFile(hardwareName);
		
	}


	public void removeFromDump(String hardwareName) {
		cf.completelyRemoveComponentFromDump(hardwareName);
		
	}


	public String dumpAnalyze() {
		return cf.printDumpStatistics();
		
	}
	
	
	
	
}
