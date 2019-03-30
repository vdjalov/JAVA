package systemSplit.DispatcherParser;



public class CommandParser {
	Dispatcher dispatcher;
	
	public CommandParser() {
		dispatcher = new Dispatcher();
	}
		
		
		public void parse(String input[]) {
			String command = input[0];
				if(command.equals("RegisterPowerHardware")) {
					String name = input[1];
					int maximumCapacity = Integer.valueOf(input[2]);
					int maximumMemory = Integer.valueOf(input[3]);
					dispatcher.executeHardware(command , name, maximumCapacity, maximumMemory);
				} else if (command.equals("RegisterHeavyHardware")) {
					String name = input[1];
					int maximumCapacity = Integer.valueOf(input[2]);
					int maximumMemory = Integer.valueOf(input[3]);
					dispatcher.executeHardware(command, name, maximumCapacity, maximumMemory);
				} else if (command.equals("RegisterLightSoftware")) {
					String hardwareName = input[1];
					String softwareName = input[2];
					int diskCapacity = Integer.valueOf(input[3]);
					int memoryCapacity = Integer.valueOf(input[4]);
					dispatcher.registerSoftware(command ,hardwareName, softwareName, 
							diskCapacity, memoryCapacity);
				} else if (command.equals("RegisterExpressSoftware")) {
					String hardwareName = input[1];
					String softwareName = input[2];
					int diskCapacity = Integer.valueOf(input[3]);
					int memoryCapacity = Integer.valueOf(input[4]);
					dispatcher.registerSoftware(command ,hardwareName, softwareName, 
							diskCapacity, memoryCapacity);
				} else if (command.equals("ReleaseSoftwareComponent")) {
					String hardwareName = input[1];
					String softwareName = input[2];
					dispatcher.releaseSoftware(hardwareName, softwareName);
				} else if (command.equals("Analyze")) {
					String result = dispatcher.analyze();
					System.out.println(result);
				} else if (command.equals("System")) {
					String result = dispatcher.systemSplit();
					System.out.print(result);
				} else if (command.equals("Dump")) {
					String hardwareName = input[1];
					dispatcher.dumpHardwareComponent(hardwareName);
				} else if (command.equals("Restore")) {
					String hardwareName = input[1];
					dispatcher.restoreHardwareComponent(hardwareName);
				} else if (command.equals("Destroy")) {
					String hardwareName = input[1];
					dispatcher.removeFromDump(hardwareName);
				} else if (command.equals("DumpAnalyze")) {
					String result = dispatcher.dumpAnalyze();
					System.out.println(result);
				}
					
				
				
		}
}
