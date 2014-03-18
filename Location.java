package textGame;

import java.util.ArrayList;
import java.util.Vector;

public class Location {
	private String roomTitle;
	private String roomDescription;
	private Vector<Exit> vecExits = new Vector<Exit>();
	private ArrayList<Key> listKeys = new ArrayList<Key>();

	/*
	 * Blank constructor
	 */
	public Location() {
		//Blank title and description
		roomTitle = "";
		roomDescription = "";
	}

	/*
	 * Partial constructor
	 */
	public Location(String title) {
		//Assign title
		roomTitle = title;

		//Blank description
		roomDescription = "";
	}

	/*
	 * Full constructor
	 */
	public Location(String title, String description) {
		//Assign title and description
		roomTitle = title;
		roomDescription = description;

		//Blank exits
		vecExits = new Vector<Exit>();
	}

	/*
	 * toString method
	 */
	public String toString() {
		return roomTitle;
	}

	/*
	 * Adds a key to this location
	 */
	public void addKey(Key key) {
		listKeys.add(key);
	}

	/*
	 * Removes a key from this location
	 */
	public void removeKey(Key key) {
		if(listKeys.contains(key)) {
			listKeys.remove(key);
		}
	}

	/*
	 * Returns an ArrayList of Keys
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Key> getKeys() {
		return (ArrayList<Key>)listKeys.clone();
	}

	/*
	 * Adds an exit to this location
	 */
	public void addExit(Exit exit) {
		vecExits.addElement(exit);
	}

	/*
	 * Removes an exit from this location
	 */
	public void removeExit(Exit exit) {
		if(vecExits.contains(exit)) {
			vecExits.removeElement(exit);
		}
	}

	/*
	 * Returns a Vector of Exits
	 */
	@SuppressWarnings("unchecked")
	public Vector<Exit> getExits() {
		return (Vector<Exit>)vecExits.clone();
	}

	/*
	 * Returns location title
	 */
	public String getTitle() {
		return roomTitle;
	}

	/*
	 * Assigns location title
	 */
	public void setTitle(String title) {
		roomTitle = title;
	}

	/*
	 * Returns location description
	 */
	public String getDescription() {
		return roomDescription;
	}

	/*
	 * Assigns location description
	 */
	public void setDescription(String description) {
		roomDescription = description;
	}
}