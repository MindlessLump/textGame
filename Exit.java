package textGame;

public class Exit {
	//Numerical codes
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 3;
	public static final int WEST = 4;
	public static final int OUT = 12;
	
	//String codes
	public static final String[] dirName = {"UNDEFINED","NORTH","SOUTH","EAST","WEST"};
	public static final String[] shortDirName = {"NULL","N","S","E","W"};
	
	//Other variables
	private Location leadsTo = null;
	private int direction;
	private String directionName;
	private String shortDirectionName;
	
	/*
	 * Empty constructor
	 */
	public Exit() {
		direction = Exit.UNDEFINED;
		leadsTo = null;
		directionName = dirName[UNDEFINED];
		shortDirectionName = shortDirName[UNDEFINED];
	}
	
	/*
	 * Full constructor
	 */
	public Exit(int dir, Location leads) {
		direction = dir;
		if(dir <= dirName.length) {
			directionName = dirName[direction];
		}
		if(dir <= shortDirName.length) {
			shortDirectionName = shortDirName[direction];
		}
		leadsTo = leads;
	}
	
	/*
	 * toString method
	 */
	public String toString() {
		return directionName;
	}
	
	/*
	 * Assigns direction name
	 */
	public void setDirectionName(String dirname)
	{
		directionName = dirname;
	}

	/*
	 * Returns direction name
	 */
	public String getDirectionName()
	{
		return directionName;
	}

	/*
	 * Assigns short direction name
	 */
	public void setShortDirectionName (String shortName)
	{
		shortDirectionName = shortName;
	}

	/*
	 * Returns short direction name
	 */
	public String getShortDirectionName ()
	{
		return shortDirectionName;
	}

	/*
	 * Assigns location
	 */
	public void setLeadsTo (Location leads)
	{
		leadsTo = leads;
	}

	/*
	 * Returns location
	 */
	public Location getLeadsTo ()
	{
		return leadsTo;
	}
}