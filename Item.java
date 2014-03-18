package textGame;

public class Item {
	//Numerical item codes
	public static final int UNDEFINED = 0;
	public static final int KEY = 1;
	
	//String item codes
	public static final String[] itemName = {"UNDEFINED","METAL KEY"};
	public static final String[] shortItemName = {"NULL","KEY"};
	
	//Other variables
	private Location place;
	private int item;
	private String name;
	private String shortName;
	
	/*
	 * Empty constructor
	 */
	public Item() {
		place = null;
		item = Item.UNDEFINED;
		name = itemName[UNDEFINED];
		shortName = shortItemName[UNDEFINED];
	}
	
	/*
	 * Full constructor
	 */
	public Item(int it, Location origin) {
		place = origin;
		item = it;
		if(item <= itemName.length) {
			name = itemName[item];
		}
		if(item <= shortItemName.length) {
			shortName = shortItemName[item];
		}
	}
	
	/*
	 * Returns item name
	 */
	public String getItemName() {
		return name;
	}
	
	/*
	 * Sets item name
	 */
	public void setItemName(String n) {
		name = n;
	}
	
	/*
	 * Returns short item name
	 */
	public String getShortItemName() {
		return shortName;
	}
	
	/*
	 * Sets short item name
	 */
	public void setShortItemName(String n) {
		shortName = n;
	}
	
	/*
	 * Returns the location of the item
	 */
	public Location getLocation() {
		return place;
	}
	
	/*
	 * Sets the location of the item
	 */
	public void setLocation(Location loc) {
		place = loc;
	}
}