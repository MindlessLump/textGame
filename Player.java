package textGame;

import java.util.ArrayList;

public class Player {
	private Location currentLocation = new Location();
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	//Empty constructor
	public Player() {
		
	}
	
	//Set the current location
	public void setCurrentLocation(Location loc) {
		currentLocation = loc;
	}
	
	//Return the current location
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	//Add an item to the inventory
	public void addItem(Item i) {
		inventory.add(i);
	}
	
	//Remove an item from the inventory
	public void removeItem(Item i) {
		if(inventory.contains(i))
			inventory.remove(i);
	}
	
	//Return the list of items
	public ArrayList<Item> getInventory() {
		return inventory;
	}
}