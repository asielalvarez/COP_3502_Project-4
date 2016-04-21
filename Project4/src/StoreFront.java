import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * V2 - 4/19/2016 - Repairs a parameter ordering problem in the constructor
 * calls as described in Piazza @709. This is a skeleton code provided for
 * students' convenience. The public methods specified here are required. The
 * private methods are optional. Do not change names of member variables for
 * this class. Do not change public method signatures. All of those items will
 * be tested by the teaching staff's JUnit testing. The private methods here (or
 * ones that you create as part of your own design) will not be JUnit tested.
 * 
 * @author Dr. Boyer
 *
 */
public class StoreFront {
	private Queue<Record> repairQueue;
	private RecordStack inventory45s;
	private RecordStack inventoryLPs;

	/**
	 * This main method takes two command-line arguments. First it takes a
	 * string of the full path to a file from which Lucy's repair queue should
	 * be initialized. Second it takes a string of the full path to a file from
	 * which Lucy's inventory stacks be initialized. That file has LPs and 45s
	 * interleaved. The main method deals with that to create the two inventory
	 * stacks.
	 * 
	 * @param args
	 *            The full path to a file for the repair queue and a file for
	 *            inventory
	 */
	public static void main(String[] args) {

		// You can name this whatever you want, but this line of code is left
		// here
		// to help you see that you'll instantiate a StoreFront object inside
		// this main method
		StoreFront lucysStore = new StoreFront();

		// Here's a helpful hint of how to initialize the repair queue.
		// You call the methods for this class from the instantiated StoreFront
		// object
		// whether you call it lucysStore or something else is up to you.
		//lucysStore.repairQueue = InventoryPopulator.getInitialRepairQueue(args[0]);

		// TODO: Code to initialize both inventory stacks.
		RecordStack bothStacks = InventoryPopulator.getInitialInventory(args[1]);
		Record r;	
		int size = bothStacks.size();
		for (int i = 0; i < size; i++) {
			r = bothStacks.pop();			
			if (r instanceof FortyFive) {
				lucysStore.inventory45s.push(r);
			} 
			else {
				lucysStore.inventoryLPs.push(r);
			}
			
		}		
		
		System.out.println(lucysStore.inventory45s.size());
		System.out.println(lucysStore.inventoryLPs.size());
		
		size = lucysStore.inventory45s.size();
		for(int i = 0; i < size; i++){
			System.out.println("45s");
			r = lucysStore.inventory45s.pop();
			System.out.println(r.toString());
		}
		size = lucysStore.inventoryLPs.size();
		for(int i = 0; i < size; i++){
			System.out.println("LPs");
			r = lucysStore.inventoryLPs.pop();
			System.out.println(r.toString());
		}
		
	
		// TODO: Code that displays the menu and gets Lucy's response until she
		// wants to quit

	}

	/**
	 * StoreFront constructor. Initializes the repairQueue, inventory45s, and
	 * inventoryLPs to empty structures.
	 */
	public StoreFront() {
		repairQueue = new LinkedList<Record>();
		inventory45s = new RecordStack();
		inventoryLPs = new RecordStack();
	}

	/**
	 * Adds the specified album to the end of the repair queue. Since there is
	 * no limit to the size of the repair queue this method just adds the
	 * record.
	 * 
	 * @param r
	 *            The record to add to the repair queue
	 */
	public void addAlbumToRepair(Record r) {

	}

	/**
	 * Removes the album at the head of the repair queue. If the repair queue
	 * was already empty, this does nothing.
	 */
	public void repairAlbum() {

	}

	/**
	 * Displays the repair queue, as a list of single albums per line. Each
	 * album is displayed precisely as mandated for the Record.toString method.
	 * There is no new line at the end of the returned String but there is a
	 * newline between each displayed album.
	 * 
	 * @return
	 */
	public String printRepairQueue() {
		return null;
	}

	/**
	 * Adds a new album to the top of the appropriate inventory stack.
	 * 
	 * @param r
	 *            The LP or 45 to add to the inventory.
	 */
	public void addAlbumToSell(Record r) {

	}

	/**
	 * Removes the topmost item from the inventory of LPs. If the inventory is
	 * empty, calling this method will cause a runtime exception. Your code must
	 * check for empty before calling this method.
	 */
	public void sellLP() {

	}

	/**
	 * Sells a 45. Removes the topmost 45 from the inventory stack.
	 */
	public void sell45() {

	}

	/**
	 * This method displays the inventory. It is PROVIDED to students to avoid
	 * annoying test case failure due to small formatting problems. :) It is
	 * JUnit testable for precise, correct output.
	 * 
	 * @return a String representation of the inventory. First LPs then 45s.
	 *         Does not include a new line at the end of this string
	 *         representation.
	 */
	public String displayInventory() {
		String LPs = (this.inventoryLPs.size() == 1) ? " LP " : " LPs ";
		String FortyFives = (this.inventory45s.size() == 1) ? " 45." : " 45s.";
		return "You have " + this.inventoryLPs.size() + LPs + "and " + this.inventory45s.size() + FortyFives;
	}

	/*
	 * This method displays the storefront menu. Dr. Boyer thinks it is
	 * convenient to display the menu to Lucy, get her choice, and then return
	 * that choice from this method. If your menu items are not ints then you
	 * would change the return type. You can also just delete this method if it
	 * doesn't fit your design.
	 * 
	 * @return the selection that Lucy made, as an integer
	 */
	private int displayMenu() {
		return 0;
	}

	/*
	 * This is a service method within this class, provided only for your
	 * convenience. You do not have to use it (you can delete this method and
	 * structure your code however you like, including the ways in which you get
	 * the info for the new Record that Lucy wants to either add to inventory or
	 * add to the repair queue). It is up to your discretion how to ask Lucy for
	 * each new record's information This method will NOT be JUnit tested.
	 * 
	 * @return a new Record which will either be added to a queue or a stack,
	 * depending on context
	 */
	private Record getRecordInfoFromLucy() {
		Scanner s = new Scanner(System.in);
		System.out.println("Ok! What is the title of the album?");
		String title = s.nextLine();
		System.out.println("What is the artist name?");
		String artist = s.nextLine();
		System.out.println("What is the album's year?");
		int year = Integer.parseInt(s.nextLine().trim());
		System.out.println("Is it an LP or a 45? Type 'LP' or '45'.");
		String type = s.nextLine();
		// The lines below are REPAIRED (as of Tues 4/19).
		// They had parameters in the incorrect order previously.
		if (type.equals("LP"))
			return new LP(artist, title, year);
		else if (type.equals("45"))
			return new FortyFive(artist, title, year);
		else
			return null;
	}

}// class
