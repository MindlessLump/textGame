package textGame;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;

public class Runner {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner kb = new Scanner(in);
		Background.initialize();
		boolean more = true;
		
		Background.showLocation();
		
		while(more) {
			String command = kb.nextLine();
			Background.doCommand(command);
		}
		kb.close();
	}
}