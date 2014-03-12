package textGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Setup {
	public static Location loc0;
	public static Location loc1;
	public static Location loc2;
	public static Location loc3;
	public static Location loc4;
	public static Location loc5;
	public static Location loc6;
	public static Location loc7;
	public static Location loc8;
	public static Location loc9;
	public static Location loc10;
	public static Location loc11;
	public static Location loc12;
	public static Location loc13;
	public static Location loc14;
	public static Location loc15;
	
	public static Key bronze;
	public static Key iron;
	public static Key gold;
	
	public Setup() {
		
	}
	
	//Creates ("Unlocks") the assigned Exit for a key
	public static void unlock(Key key) {
		key.getReference().addExit(key.getUnlocks());
	}
	
	//Removes a key from a location
	public static void remove(Location loc, Key key) {
		loc.removeKey(key);
	}
	
	public static void initialize() throws FileNotFoundException {
		//Input Location descriptions from file
		File f = new File("src/textGame/Locations.txt");
		Scanner file = new Scanner(f);
		String[] names = new String[16];
		String[] descriptions = new String[16];
		int j = 0;
		boolean even = true;
		while(file.hasNext()) {
			if(even) {
				names[j] = file.nextLine();
				even = false;
			}
			else {
				descriptions[j] = file.nextLine();
				even = true;
				j++;
			}
		}
		file.close();
		
		//Initialize all Locations
		loc0 = new Location(names[0], descriptions[0]);
		loc1 = new Location(names[1], descriptions[1]);
		loc2 = new Location(names[2], descriptions[2]);
		loc3 = new Location(names[3], descriptions[3]);
		loc4 = new Location(names[4], descriptions[4]);
		loc5 = new Location(names[5], descriptions[5]);
		loc6 = new Location(names[6], descriptions[6]);
		loc7 = new Location(names[7], descriptions[7]);
		loc8 = new Location(names[8], descriptions[8]);
		loc9 = new Location(names[9], descriptions[9]);
		loc10 = new Location(names[10], descriptions[10]);
		loc11 = new Location(names[11], descriptions[11]);
		loc12 = new Location(names[12], descriptions[12]);
		loc13 = new Location(names[13], descriptions[13]);
		loc14 = new Location(names[14], descriptions[14]);
		loc15 = new Location(names[15], descriptions[15]);
		
		//Assign Exit Vectors for each Location
		loc0.addExit(new Exit(1, loc1));
		
		loc1.addExit(new Exit(1, loc2));
		loc1.addExit(new Exit(2, loc0));
		
		loc2.addExit(new Exit(2, loc1));
		loc2.addExit(new Exit(4, loc3));
		loc2.addExit(new Exit(3, loc9));
		
		loc3.addExit(new Exit(3, loc2));
		loc3.addExit(new Exit(1, loc4));
		loc3.addExit(new Exit(2, loc5));
		
		loc4.addExit(new Exit(2, loc3));
		
		loc5.addExit(new Exit(1, loc3));
		
		loc6.addExit(new Exit(3, loc3));
		loc6.addExit(new Exit(2, loc7));
		loc6.addExit(new Exit(1, loc8));
		
		loc7.addExit(new Exit(1, loc6));
		
		loc8.addExit(new Exit(2, loc6));
		
		loc9.addExit(new Exit(4, loc2));
		loc9.addExit(new Exit(2, loc10));
		loc9.addExit(new Exit(1, loc11));
		loc9.addExit(new Exit(3, loc12));
		
		loc10.addExit(new Exit(1, loc9));
		
		loc11.addExit(new Exit(2, loc9));
		
		loc12.addExit(new Exit(4, loc9));
		loc12.addExit(new Exit(1, loc13));
		
		loc13.addExit(new Exit(2, loc12));
		
		loc14.addExit(new Exit(4, loc13));
		
		loc15.addExit(new Exit(2, loc2));
		
		//Initialize all keys
		bronze = new Key(1, loc3, new Exit(4, loc6));
		iron = new Key(2, loc13, new Exit(3, loc14));
		gold = new Key(3, loc2, new Exit(1, loc15));
		
		//Put the keys into their finding locations
		loc10.addKey(bronze);
		loc7.addKey(iron);
		loc14.addKey(gold);
	}
}