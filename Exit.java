package textGame;

public class Exit {
	//Numerical codes
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 3;
	public static final int WEST = 4;

	//String codes
	public static final String[] dirName = {"UNDEFINED","NORTH","SOUTH","EAST","WEST"};
	public static final String[] shortDirName = {"NULL","N","S","E","W"};

	//Other variables
	private Location leadsTo = null;
	private int direction;
	private String directionName;
	private String shortDirectionName;
	private String description;
	private boolean locked;

	//Empty constructor - Sets everything blank
	public Exit() {
		direction = Exit.UNDEFINED;
		leadsTo = null;
		directionName = dirName[UNDEFINED];
		shortDirectionName = shortDirName[UNDEFINED];
	}

	//Full constructor - Sets the direction and names, target location, and description
	public Exit(int dir, Location leads, String desc, boolean lock) {
		direction = dir;
		if(dir <= dirName.length) {
			directionName = dirName[direction];
		}
		if(dir <= shortDirName.length) {
			shortDirectionName = shortDirName[direction];
		}
		leadsTo = leads;
		description = desc;
		locked = lock;
	}

	//Sets the direction name
	public void setDirectionName(String dirname)
	{
		directionName = dirname;
	}

	//Returns the direction name
	public String getDirectionName()
	{
		return directionName;
	}

	//Sets the short direction name
	public void setShortDirectionName(String shortName)
	{
		shortDirectionName = shortName;
	}

	//Returns the short direction name
	public String getShortDirectionName()
	{
		return shortDirectionName;
	}

	//Sets the target location
	public void setLeadsTo(Location leads)
	{
		leadsTo = leads;
	}

	//Returns the target location
	public Location getLeadsTo()
	{
		return leadsTo;
	}
	
	//Sets the description
	public void setDescription(String s) {
		description = s;
	}
	
	//Returns the description
	public String getDescription() {
		return description;
	}
	
	//Locks the door
	public void setLocked() {
		locked = true;
	}
	
	//Unlocks the door
	public void setUnlocked() {
		locked = false;
	}
	
	//Return whether the door is locked
	public boolean isLocked() {
		return locked;
	}
}