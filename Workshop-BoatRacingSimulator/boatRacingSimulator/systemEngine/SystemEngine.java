package boatRacingSimulator.systemEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import boatRacingSimulator.controller.Controller;
import boatRacingSimulator.exceptions.ArgumentException;
import boatRacingSimulator.exceptions.InsufficientContestantsException;
import boatRacingSimulator.exceptions.NoSetRaceException;
import boatRacingSimulator.exceptions.RaceAlreadyExistsException;


public class SystemEngine {

	private BufferedReader bf;
	private Controller controller;
		public SystemEngine() {
			this.bf = new BufferedReader(new InputStreamReader(System.in));
			this.controller = new Controller();
		}
		
		public void start() throws IOException {
			
			while(true) {
				String input[] = this.bf.readLine().split("[\\\\]+");
					if(input[0].equals("End")) {
						break;
					}
				commandHandler(input);
					
			}
		}

		private void commandHandler(String[] input) {
			if(input[0].equals("CreateBoatEngine")) {
				String result = this.controller.createEngine(input);
				System.out.println(result);
			} else if (input[0].equals("OpenRace")) {
				try{
				String result = controller.addRace(input);
				System.out.println(result);
				} catch (RaceAlreadyExistsException ex){
					System.out.println(ex.getMessage());
				}
			} else if (input[0].equals("CreatePowerBoat")) {
				String result = controller.createPowerBoat(input);
				System.out.println(result);
			} else if (input[0].equals("CreateRowBoat")) {
				String result = controller.createRowBoat(input);
				System.out.println(result);
			} else if (input[0].equals("CreateSailBoat")) {
				String result = controller.createSailBoat(input);
				System.out.println(result);
			} else if (input[0].equals("CreateYacht")) {
				String result = controller.createYacht(input);
				System.out.println(result);
			} else if (input[0].equals("SignUpBoat")) {
				try{
				String result = controller.signUp(input);
				System.out.println(result);
				} catch (NoSetRaceException | ArgumentException ex) {
					System.out.println(ex.getMessage());
				}
			} else if (input[0].equals("StartRace")) {
				try{
				String result = controller.startRace(input);
				System.out.println(result);
				} catch (NoSetRaceException | InsufficientContestantsException ex) {
					System.out.println(ex.getMessage());
				}
			} else if (input[0].equals("GetStatistic")) {
				String result = controller.getRaceStatistics();
				System.out.println(result);
			}
			
		}
	
}































