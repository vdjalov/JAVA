package eventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Handler handler = new Handler();
		Dispatcher dispatcher = new Dispatcher("Suzi", handler);

		
		String input = bf.readLine();
			while(!input.equalsIgnoreCase("end")) {
				dispatcher.changeName(input);
				input = bf.readLine();
			}
			
		
	}

}
