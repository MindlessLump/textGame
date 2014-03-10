package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
	String basicDesc = "";
	private ArrayList<Item> items = new ArrayList<Item>();
	
	/*
	 * Sets the basic description of the room based upon the room number.
	 * Basic description omits items.
	 * @param num: The room number, based on a map.
	 */
	public Room(int num) throws FileNotFoundException {
		basicDesc = this.getDesc(num);
		Item i = new Item("");
		items = i.getItems(num);
	}
	
	/*
	 * The method called by the constructor to set the basic room description.
	 * @param num: The room number, based on a map.
	 * @return
	 */
	public String getDesc(int num) throws FileNotFoundException {
		Scanner file = new Scanner(new File("Descriptions.txt"));
		ArrayList<String> descriptions = new ArrayList<String>();
		while(file.hasNext()) {
			//Add each description to the ArrayList numerically, keeping their order from the file.
			String s = file.nextLine();
			descriptions.add(s.substring(2, s.length()));
		}
		file.close();
		String output = descriptions.get(num);
		return output;
	}
	
	
	/*
	 * @return a description of the room, and the items therein.
	 */
	public String toString() {
		String output = basicDesc;
		if(!items.isEmpty()) {
			output = output + "\nYou see the following items: " + items.toString();
		}
		else {
			output = output + "\nYou see nothing else of interest.";
		}
		return output;
	}
}