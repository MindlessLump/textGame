package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import static java.lang.System.*;

public class Background {
	//List of map locations, sorted by a given number
	private Map<Integer,Location> map = new HashMap<Integer,Location>();
	
	//Player variables
	private Location currentLocation;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	//Empty constructor
	public Background() {
		
	}
	
	//Creates map-specific Locations, Exits, and Items from individual text files
	public void initialize() throws FileNotFoundException {
		//Get Location information from the text file
		File f = new File("src/textGame/Locations.dat");
		Scanner file = new Scanner(f);
		String tempName = "", tempDescription = "", notUsed = "";
		int j = 0;
		while(file.hasNext()) {
			tempName = file.nextLine();
			tempDescription = file.nextLine();
			map.put(j, new Location(tempName, tempDescription));
			j++;
			notUsed = file.nextLine(); //Skip a line for file readability
		}
		file.close();
		
		//Get Exit information from the text file
		f = new File("src/textGame/Exits.dat");
		file = new Scanner(f);
		String tempStart = "", tempLeads = "", tempDirection = "", tempExitDescription = "", tempLocked = "";
		int start, leads, direction;
		boolean locked;
		while(file.hasNext()) {
			tempStart = file.nextLine();
			tempLeads = file.nextLine();
			tempDirection = file.nextLine();
			tempExitDescription = file.nextLine();
			tempLocked = file.nextLine();
			start = Integer.parseInt(tempStart);
			leads = Integer.parseInt(tempLeads);
			direction = Integer.parseInt(tempDirection);
			locked = tempLocked.equalsIgnoreCase("locked");
			map.get(start).addExit(new Exit(direction, map.get(leads), tempExitDescription, locked));
			notUsed = file.nextLine(); //Skip a line for file readability
		}
		file.close();
		
		//Get Item information from the text file
		f = new File("src/textGame/Items.dat");
		file = new Scanner(f);
		String tempItemName, tempPlace, tempPlaceDescription, tempItemDescription, tempPickup, tempUse, tempUses;
		int place, uses;
		while(file.hasNext()) {
			tempItemName = file.nextLine();
			tempPlace = file.nextLine();
			tempPlaceDescription = file.nextLine();
			tempItemDescription = file.nextLine();
			tempPickup = file.nextLine();
			tempUse = file.nextLine();
			tempUses = file.nextLine();
			place = Integer.parseInt(tempPlace);
			uses = Integer.parseInt(tempUses);
			map.get(place).addItem(new Item(tempItemName, tempPlaceDescription, tempItemDescription, tempPickup, tempUse, uses));
			notUsed = file.nextLine(); //Skip a line for file readability
		}
		file.close();
		
		this.doNothingString(notUsed); //Make warnings about unused variables go away
	}
	
	//Handle a String command
	public void doCommand(String input) {
		//Handle picking up items
		if(input.substring(0,3).equalsIgnoreCase("get")) {
			for(Iterator<Item> iter = currentLocation.getItems().iterator(); iter.hasNext();) {
				Item i = iter.next();
				if(input.substring(4).equalsIgnoreCase(i.getItemName())) {
					this.addInventory(i);
					currentLocation.removeItem(i);
					i.doPickup();
					out.println("You pick up the " + i.getItemName() + ".");
				}
			}
		}
		else if(input.substring(0,4).equalsIgnoreCase("grab")) {
			for(Iterator<Item> iter = currentLocation.getItems().iterator(); iter.hasNext();) {
				Item i = iter.next();
				if(input.substring(5).equalsIgnoreCase(i.getItemName())) {
					this.addInventory(i);
					currentLocation.removeItem(i);
					i.doPickup();
					out.println("You pick up the " + i.getItemName() + ".");
				}
			}
		}
		else if(input.substring(0,7).equalsIgnoreCase("pick up")) {
			for(Iterator<Item> iter = currentLocation.getItems().iterator(); iter.hasNext();) {
				Item i = iter.next();
				if(input.substring(8).equalsIgnoreCase(i.getItemName())) {
					this.addInventory(i);
					currentLocation.removeItem(i);
					i.doPickup();
					out.println("You pick up the " + i.getItemName() + ".");
				}
			}
		}
		
		//Handle looking at the player inventory
		//Handle looking at an item in the inventory/in the location
		//Handle using an item
		//Handle an onPickup command
		//Handle an onUse command
		//Handle dropping an item
		//Handle going through an exit
	}
	
	//Add a location to the map
	public void addLocation(int key, Location value) {
		map.put(key, value);
	}
	
	//Remove a location from the map
	public void removeLocation(int key) {
		map.remove(key);
	}
	
	//Return the HashMap of locations
	public Map<Integer,Location> getLocations() {
		return map;
	}
	
	//Add an exit to the map
	public void addExit(int origin, Exit e) {
		map.get(origin).addExit(e);
	}
	
	//Remove an exit from the map
	public void removeExit(int origin, Exit e) {
		map.get(origin).removeExit(e);
	}
	
	//Return the list of exits from a location
	public Vector<Exit> getExits(int loc) {
		return map.get(loc).getExits();
	}
	
	//Add an item to the map
	public void addItem(int location, Item i) {
		map.get(location).addItem(i);
	}
	
	//Remove an item from the map
	public void removeItem(int location, Item i) {
		map.get(location).removeItem(i);
	}
	
	//Return the list of items in a location
	public ArrayList<Item> getItems(int loc) {
		return map.get(loc).getItems();
	}
	
	//Set the current location
	public void setCurrentLocation(int loc) {
		currentLocation = map.get(loc);
	}
	
	//Return the current location
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	//Add an item to the inventory
	public void addInventory(Item i) {
		inventory.add(i);
	}
	
	//Remove an item from the inventory
	public void removeInventory(Item i) {
		if(inventory.contains(i))
			inventory.remove(i);
	}
	
	//Return the inventory
	public ArrayList<Item> getInventory(Item i) {
		return inventory;
	}
	
	//Empty method to make warnings about unused variables go away
	public void doNothingString(String nothing) {
		
	}
}