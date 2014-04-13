package textGame;

public class Item {
	private String placeDescription; //Description of where the item is found
	private String itemDescription; //Description of the item itself
	private String onPickup; //Contains a command to be carried out when the item is picked up
	private String onUse; //Contains a command to be carried out when the item is used
	private boolean infinite; //Whether the item can be used an infinite number of times
	private int itemUses;
	
	//Empty constructor
	public Item() {
		
	}
	
	//Full constructor
	public Item(String place, String item, String pickup, String use, int uses) {
		placeDescription = place;
		itemDescription = item;
		onPickup = pickup;
		onUse = use;
		if(uses < 0) {
			infinite = true;
		}
		else {
			infinite = false;
			itemUses = uses;
		}
	}
	
	//Set the place description
	public void setPlaceDescription(String place) {
		placeDescription = place;
	}
	
	//Return the place description
	public String getPlaceDescription() {
		return placeDescription;
	}
	
	//Set the item description
	public void setItemDescription(String item) {
		itemDescription = item;
	}
	
	//Return the item description
	public String getItemDescription() {
		return itemDescription;
	}
	
	//Set the item to be infinite
	public void setInfiniteUses() {
		infinite = true;
	}
	
	//Set the item to be finite
	public void setFiniteUses(int uses) {
		infinite = false;
		itemUses = uses;
	}
	
	//Return the number of uses
	public int getUses() {
		return itemUses;
	}
	
	//Return whether the item is infinite
	public boolean isInfinite() {
		return infinite;
	}
	
	//Set the onPickup command
	public void setOnPickup(String pick) {
		onPickup = pick;
	}
	
	//Perform the onPickup command
	public void doPickup() {
		Background.doCommand(onPickup);
	}
	
	//Set the onUse command
	public void setOnUse(String use) {
		onUse = use;
	}
	
	//Perform the onUse command
	public void doUse() {
		Background.doCommand(onUse);
		if(!this.isInfinite())
			itemUses--;
	}
}