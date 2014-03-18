package textGame;

import static java.lang.System.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Location currentLocation;
	static Scanner kb = new Scanner(in);
	private static String[] riddles = new String[8];
	private static String[] answers = new String[8];
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
				out.println(key.getKeyName().toLowerCase());
			}
		}

		//Exits
		if(!currentLocation.getExits().isEmpty()) {
			out.print("Available exits: ");
			for(Enumeration<Exit> e = currentLocation.getExits().elements(); e.hasMoreElements();) {
				Exit exit = (Exit)e.nextElement();
				if(e.hasMoreElements())
					out.print(exit + ", ");
				else
					out.print(exit);
			}
		}
	}

	//The riddle game with the sphynx
	public static Boolean sphynx() throws FileNotFoundException {
		out.println("\nShe - You assume it's a she, because of her smooth voice - addresses you: \"To pass, you must answer three riddles. Are you ready to begin?\"\nYou know that you don't have a choice, so you agree.");
		Scanner file = new Scanner(new File("src/textGame/Riddles.txt"));
		int j = 0;
		boolean even = true;
		while(file.hasNext()) {
			if(even) {
				riddles[j] = file.nextLine();
				even = false;
			}
			else {
				answers[j] = file.nextLine();
				even = true;
				j++;
			}
		}
		file.close();
		Random rand = new Random();
		int i = 0, r = 0;

		while(i < 3) {
			r = rand.nextInt(8);
			out.println("\n\"" + riddles[r] + "\"");
			String ans = kb.nextLine();
			if(ans.equalsIgnoreCase(answers[r]) || ans.equalsIgnoreCase("a " + answers[r])) {
				out.println("\"Very good.\"");
				i++;
			}
			else {
				out.println("\"You fail. Better luck next time. Or not.\"");
				i = 3;
				return false;
			}
		}
		return true;
	}

	public static void victory() {
		out.println("\n\nYou win, sucker!\n\n");
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
				Setup.remove(currentLocation, key);

				//Notify the user
				out.println("You have picked up the " + key.getKeyName().toLowerCase() + ". You hear a door somewhere unlock.");

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
		return true;
	}

	public static void main(String args[]) throws FileNotFoundException {
		Setup.initialize();
		currentLocation = Setup.loc0;
		Boolean more = true;

		showLocation();

		while(more) {
			if(command()) {
				out.println("\n");
				if(currentLocation.getTitle().equalsIgnoreCase("Throne Room")) {
					victory();
					more = false;
				}
				else if(currentLocation.getTitle().equalsIgnoreCase("Porch")) {
					showLocation();
					if(sphynx()) {
						Setup.loc1.addExit(new Exit(1, Setup.loc2));
						Setup.loc1.addExit(new Exit(2, Setup.loc0));
						out.println("\nAvailable Exits:\nNORTH, SOUTH");
					}
					else {
						more = false;
					}
				}
				else {
					showLocation();
				}
			}
			else {
				more = false;
			}
		}
	}
}