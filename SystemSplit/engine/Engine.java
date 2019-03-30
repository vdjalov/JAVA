package systemSplit.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import systemSplit.DispatcherParser.CommandParser;


public class Engine {

		BufferedReader bf;
		CommandParser commandParser;
			public Engine() {
				bf = new BufferedReader(new InputStreamReader(System.in));
				this.commandParser = new CommandParser();
			}
			
			
			public void run() throws IOException {
				while(true) {
					String input[] = bf.readLine().split("[(, )]+");
					this.commandParser.parse(input);
					
					if(input[0].equals("System")) {
						break;
					}
				}
				
			}
}
