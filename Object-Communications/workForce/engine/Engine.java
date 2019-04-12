package workForce.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import workForce.commandFactory.CommandFactory;

public class Engine {

	BufferedReader bf;
	CommandFactory cf;
	
	
	public Engine() {
		this.cf = new CommandFactory();
		this.bf = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public void run() throws IOException {
		String input[] = bf.readLine().split("[ ]+");
		
			while(!input[0].equalsIgnoreCase("end")) {
				cf.parseCommand(input);
				input = bf.readLine().split("[ ]+");
			}
		
	}
}
