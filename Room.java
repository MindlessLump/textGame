package textGame;

public class Room {
	String basicDesc = "";
	
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
		return "";
	}
}