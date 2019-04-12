package kingsGambit.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kingsGambit.units.King;

public class Engine {

	BufferedReader bf;
	
		public Engine() {
			this.bf = new BufferedReader(new InputStreamReader(System.in));
		}
		
		
		public void run() throws IOException {
			String input = this.bf.readLine();
			int count = 0;
			King king = null;
			
			while(!input.equalsIgnoreCase("END")) {
				if(count == 0) {
					king = new King(input);
				} else if(count == 1) {
					king.addRoyalGuard(input);
				} else if(count == 2) {
					king.addFootmen(input);
				} else if (input.equals("Attack King")){
					String result = king.attackKing();
					System.out.print(result);
				} else {
					String name = input.split("[ ]+")[1];
					king.killUnit(name);
				}
				
				count++;
				input = bf.readLine();
			}
		}
}
