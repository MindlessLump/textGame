package textGame;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Location {
	private Vector<Exit> exits = new Vector<Exit>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private String placeName;
	private String basicDescription;
	
	//Empty constructor - Sets the description to a blank String
	public Location() {
		basicDescription = "";
	}
	
	//Full constructor - Sets the description to the given String
	public Location(String name, String desc) {
		placeName = name;
		basicDescription = desc;
	}
	
	//Adds an exit to the list of exits
	public void addExit(Exit e) {
		exits.add(e);
	}
	
	//Removes an exit from the list of exits
	public void removeExit(Exit e) {
		if(exits.contains(e))
			exits.remove(e);
	}
	
	//Returns the list of exits
	public Vector<Exit> getExits() {
		return exits;
	}
	
	//Tests for an exit facing the given direction
	public boolean hasExit(String direction) {
		boolean output = false;
		for(Enumeration<Exit> e = this.getExits().elements(); e.hasMoreElements();) {
			Exit ex = e.nextElement();
			if(ex.getDirectionName().equalsIgnoreCase(direction) || ex.getShortDirectionName().equalsIgnoreCase(direction))
				output = true;
		}
		return output;
	}
	
	//Adds an item to the list of items
	public void addItem(Item i) {
		items.add(i);
	}
	
	//Removes an item from the list of items
	public void removeItem(Item i) {
		if(items.contains(i))
			items.remove(i);
	}
	
	//Returns the list of items
	public ArrayList<Item> getItems() {
		return items;
	}
	
	//Sets the basic location description to a given String
	public void setDescription(String desc) {
		basicDescription = desc;
	}
	
	//Returns the basic location description
	public String getDescription() {
		return basicDescription;
	}
	
	//Prints out the location description, along with any items, characters, and exits
	public String toString() {
		//Place name
		String output = placeName + "\n";
		//Basic description
		output += basicDescription;
		//Items
		if(!items.isEmpty()) {
			output += "\nYou notice:\n";
			for(Iterator<Item> iter = this.getItems().iterator(); iter.hasNext();) {
				Item i = iter.next();
				output += "\t" + i.getPlaceDescription();
				if(iter.hasNext())
					output += "\n";
			}
		}
		//Exits
		if(!exits.isEmpty()) {
			output += "You see:\n";
			for(Enumeration<Exit> e = this.getExits().elements(); e.hasMoreElements();) {
				Exit exit = e.nextElement();
				output += "\t" + exit.getDescription();
				if(e.hasMoreElements())
					output += "\n";
			}
		}
		return output;
	}
}