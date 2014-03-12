package textGame;

import static java.lang.System.*;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
	private static Location currentLocation;
	static Scanner kb = new Scanner(in);
	boolean hasBronzeKey;
	boolean hasIronKey;
	boolean hasGoldKey;
	
	private static void showLocation(){
		//Title
		out.println("[" + currentLocation.getTitle() + "]");
		
		//Description
		out.println(currentLocation.getDescription() + "\n");
		
		//Items
		if(!currentLocation.getKeys().isEmpty()) {
			out.print("You see a ");
			for(Iterator<Key> k = currentLocation.getKeys().iterator(); k.hasNext();) {
				Key key = (Key)k.next();
				out.println(key.getKeyName().toLowerCase() + " key.");
			}
		}
		
		//Exits
		out.print("Available exits: ");
		for(Enumeration<Exit> e = currentLocation.getExits().elements(); e.hasMoreElements();) {
			Exit exit = (Exit)e.nextElement();
			if(e.hasMoreElements())
				out.print(exit + ", ");
			else
				out.print(exit);
		}
	}
	
	public static boolean command() {
		out.println();
		String input = kb.nextLine();
		
		//Convert to uppercase for comparison
		input = input.toUpperCase();
		
		//Search for an item match
		for(Iterator<Key> k = currentLocation.getKeys().iterator(); k.hasNext();) {
			Key key = (Key)k.next();
			
			if( (key.getKeyName().compareTo(input)== 0) || (key.getShortKeyName().compareTo(input) == 0) ) {
				//Unlock the corresponding Exit
				Setup.unlock(key);
				
				//Notify the user
				out.println("You have picked up the " + key.getKeyName().toLowerCase() + " key. You hear a door somewhere unlock.");
				
				//Event handled
				return true;
				
			}
		}
		
		//Search for an exit match
		for(Enumeration<Exit> e = currentLocation.getExits().elements(); e.hasMoreElements();) {
			Exit exit = (Exit)e.nextElement();
			
			if( (exit.getDirectionName().compareTo(input) == 0) || (exit.getShortDirectionName().compareTo(input) == 0) ) {
				//Set currentLocation to the location pointed to by the exit
				currentLocation = exit.getLeadsTo();
				
				//Notify the user
				out.println("You go " + exit.getDirectionName().toLowerCase() + ".");
				
				//Event handled
				return true;
			}
		}
		
		//If the code gets here, it's invalid
		out.println("\nInvalid command.");
		return false;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		Setup.initialize();
		currentLocation = Setup.loc0;
		Boolean more = true;
		
		showLocation();
		
		while(more) {
			if(command()) {
				out.println("\n");
				showLocation();
			}
			else {
				more = false;
			}
		}
	}
}