package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Background {
	//List of map locations, sorted by a given number
	private Map<Integer,Location> map = new HashMap<Integer,Location>();
	
	//Empty constructor
	public Background() {
		
	}
	
	//Creates the map and sets up the game
	public void initialize() throws FileNotFoundException {
		//Get Location information from the text file
		File f = new File("src/textGame/Locations.dat");
		Scanner file = new Scanner(f);
		String tempName = "", tempDescription = "";
		int j = 0;
		while(file.hasNext()) {
			tempName = file.nextLine();
			tempDescription = file.nextLine();
			
			map.put(j, new Location(tempName, tempDescription));
			j++;
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
		}
		file.close();
		
		//Get Item information from the text file
		f = new File("src/textGame/Items.dat");
		file = new Scanner(f);
		String tempPlace, tempPlaceDescription, tempItemDescription, tempPickup, tempUse, tempUses;
		int place, uses;
		while(file.hasNext()) {
			tempPlace = file.nextLine();
			tempPlaceDescription = file.nextLine();
			tempItemDescription = file.nextLine();
			tempPickup = file.nextLine();
			tempUse = file.nextLine();
			tempUses = file.nextLine();
			
			place = Integer.parseInt(tempPlace);
			uses = Integer.parseInt(tempUses);
			
			map.get(place).addItem(new Item(tempPlaceDescription, tempItemDescription, tempPickup, tempUse, uses));
		}
		file.close();
	}
}