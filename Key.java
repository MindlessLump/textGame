package textGame;

public class Key {
	//Numerical key codes
	public static final int UNDEFINED = 0;
	public static final int BRONZE = 1;
	public static final int IRON = 2;
	public static final int GOLD = 3;
	
	//String key codes
	public static final String[] keyName = {"UNDEFINED","BRONZE KEY","IRON KEY","GOLD KEY"};
	public static final String[] shortKeyName = {"NULL","BRONZE","IRON","GOLD"};
	
	//Other variables
	private Location reference = null;
	private Exit unlocks = null;
	private int key;
	private String name;
	private String shortName;
	
	/*
	 * Empty constructor
	 */
	public Key() {
		reference = null;
		unlocks = null;
		key = Key.UNDEFINED;
		name = keyName[UNDEFINED];
		shortName = shortKeyName[UNDEFINED];
	}
	
	/*
	 * Full constructor
	 */
	public Key(int it, Location origin, Exit unlock) {
		key = it;
		if(it <= keyName.length) {
			name = keyName[key];
		}
		if(it <= shortKeyName.length) {
			shortName = shortKeyName[key];
		}
		reference = origin;
		unlocks = unlock;
	}
	
	/*
	 * toString method
	 */
	public String toString() {
		return name;
	}
	
	/*
	 * Returns key name
	 */
	public String getKeyName() {
		return name;
	}
	
	/*
	 * Returns short key name
	 */
	public String getShortKeyName() {
		return shortName;
	}
	
	/*
	 * Assigns unlock exit
	 */
	public void setUnlocks(Location origin, Exit lock) {
		reference = origin;
		unlocks = lock;
	}
	
	/*
	 * Returns unlock exit
	 */
	public Exit getUnlocks() {
		return unlocks;
	}
	
	/*
	 * Assigns reference Location
	 */
	public void setReference(Location loc) {
		reference = loc;
	}
	
	/*
	 * Returns reference Location
	 */
	public Location getReference() {
		return reference;
	}
}