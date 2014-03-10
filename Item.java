package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {
	public Item(String name) {
		
	}
	
	public ArrayList<Item> getItems(int num) throws FileNotFoundException {
		ArrayList<Item> output = new ArrayList<Item>();
		Scanner file = new Scanner(new File("Items.txt"));
		while(file.hasNext()) {
			String s = file.nextLine();
			output.add(new Item(s.substring(2, s.length())));
		}
		file.close();
		return output;
	}
}