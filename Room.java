package textGame;

import java.util.ArrayList;

public class Room {
	String basicDesc = "";
	ArrayList<Item> items = new ArrayList<Item>();
	
	/**
	 * Sets the basic description of the room based upon the room number.
	 * Basic description omits items.
	 * @param num: The room number, based on a map.
	 */
	public Room(int num) {
		basicDesc = this.getDesc(num);
	}
	
	/**
	 * The method called by the constructor to set the basic room description.
	 * @param num: The room number, based on a map.
	 * @return
	 */
	public String getDesc(int num) {
		return "";
	}
	
	public String toString() {
		String output = basicDesc;
		if(!items.isEmpty()) {
			output = output + "You see the following items: " + items.toString();
		}
		else {
			output = output + "You see nothing else of interest.";
		}
		return output;
	}
}