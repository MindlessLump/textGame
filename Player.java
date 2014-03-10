package textGame;

import java.util.ArrayList;

public class Player {
	public ArrayList<Item> inventory = new ArrayList<Item>();
	public Room location;
	
	public Player(ArrayList<Item> inv, Room loc) {
		inventory = inv;
		location = loc;
	}
	
	public Room getLocation() {
		return location;
	}
}