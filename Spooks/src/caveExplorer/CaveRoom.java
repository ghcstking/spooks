package caveExplorer;

import java.util.Arrays;

import jasonAndVicki.EventJasonAndVicki;

public class CaveRoom {
	
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	

	public static final String[] SEQ = {
		"You start to move forward to open the next door and continue on ur path.",
		"When you reach the center however...THE DOORS ALL SIMULTANEOUSLY LOCK SHUT.",
		"'help me pls i is stuck in dis room' you cry as you bang on all the doors. ",
		"Too bad there's no one in this house but you. Living that is."
	};
	
	public static boolean event1done = false;
	public static boolean event2done = false;
	public static  boolean event3done = false;
	
	private boolean key1 = false;
	private boolean key2 = false;
	private boolean key3 = false;


	private CaveRoom[] borderingRooms;
	private Door[] doors; 

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;


	public CaveRoom(String description){
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		for(int i = 0 ; i < borderingRooms.length; i++){
			borderingRooms[i] = null;
			doors[i] = null;
		}
		setDirections();
	}

	protected void setDirections() {
		directions	= "";
		if(doors[NORTH] == null && 
				doors[EAST] == null &&
				doors[SOUTH] == null &&
				doors[WEST] == null){
			directions = "\n\nThis is a room with no exit. You will die here.";		
		}else{
			for(int dir = 0; dir < doors.length; dir++){
				if(doors[dir] != null){
					directions += "\n   There is a "+doors[dir].getDescription()+" to "+toDirection(dir)+". "+doors[dir].getDetails();
				}
			}
		}
	
	}

	public static String toDirection(int dir) {
		String[] directions = {"the North","the East","the South","the West"};
		return directions[dir];
		
 	}

	public String getContents(){
		return contents;
	}
	
	public void enter(){
		contents = "X";
	}
	
	public void leave(){
		contents = defaultContents;
	}
	
	public void setDefaultContents(String symbol){
		defaultContents = symbol;
	}
	

	public void addRoom(int direction, CaveRoom anotherRoom, Door door){
		borderingRooms[direction] = anotherRoom;
		doors[direction] = door;
		setDirections();
	}
	
	/**
	 * Gives this room access to anotherRoom (and vice-versa) and
	 * sets a door between them, and updates the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	/**
	 * 
	 * @param dir
	 * @return opposite direction of dir (NORTH returns SOUTH...)
	 */
	public static int oppositeDirection(int dir){
		return (dir+2)%4;
	}

	
	public String getDescription(){
		return description+directions;
	}

	

	
	public Door getDoor(int dir){
		return doors[dir];
	}


	public void setDescription(String string) {
		description = string;
	}

	public void interpretInput(String input) {
		while(!isValid(input)){
			System.out.println("You can only enter " + "'w','a','s', or 'd'");
			input = CaveExplorer.in.nextLine();
		}
		
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		
		if(doors[indexFound] == null){
			System.out.println("Thats a wall you dummy.");
		}
		else{
			makeLocks();
			if(doors[indexFound].isLocked() == true){
				if(CaveExplorer.currentRoom == CaveExplorer.caves[3][6]){
					openFinalDoor(EAST);
				}
				else{
					CaveExplorer.print("You need a key to gain access to this room.");
					if(checkKeys()){
						CaveExplorer.print("You pull out a key and you open the door. You're in.");
						Inventory.keycount--;
						doors[indexFound].setLock(false);
						goToRoom(indexFound);
					}
				}
			}
			else{
				goToRoom(indexFound);
			}
		}
		
		
	}
	
	public void makeLocks(){
		if(CaveExplorer.currentRoom == CaveExplorer.caves[0][2] && !event1done){
			CaveExplorer.currentRoom.doors[2].setLock(true);
		}
		
		if(CaveExplorer.currentRoom == CaveExplorer.caves[4][0] && !event2done){
			CaveExplorer.currentRoom.doors[1].setLock(true);
		}
		if(CaveExplorer.currentRoom == CaveExplorer.caves[4][4] && !event3done){
			CaveExplorer.currentRoom.doors[1].setLock(true);
		}
		
		if(CaveExplorer.currentRoom == CaveExplorer.caves[0][4]){
			CaveExplorer.currentRoom.doors[1].setLock(true);
			CaveExplorer.currentRoom.doors[2].setLock(true);
			CaveExplorer.currentRoom.doors[3].setLock(true);
			Inventory.keycount = 0;
			EventJasonAndVicki.readSequence(SEQ);
			CaveExplorer.print("-----You Died.-----");
			System.exit(1);
		}
		
		if(CaveExplorer.currentRoom == CaveExplorer.caves[3][6]){
			CaveExplorer.currentRoom.doors[1].setLock(true);
		}
			
	}
	
	public boolean checkKeys(){
		if(Inventory.keycount > 0){
			Inventory.hasKey = true;
			return true;
		}
		return false;
	}

	public void goToRoom(int direction) {
		CaveExplorer.currentRoom.doors[direction].setOpen(true);
		CaveExplorer.currentRoom.leave();
		CaveExplorer.currentRoom = borderingRooms[direction];
		CaveExplorer.currentRoom.enter();
		CaveExplorer.inventory.updateMap();
		gainKey();
	
	}
	
	public void gainKey(){
		if(CaveExplorer.currentRoom == CaveExplorer.caves[3][0] && !key1){
			Inventory.keycount++;
			CaveExplorer.currentRoom.setDescription("You found a key here yay");
			key1 = true;
		}
		
		if(CaveExplorer.currentRoom == CaveExplorer.caves[3][1] && !key2){
			Inventory.keycount++;
			CaveExplorer.currentRoom.setDescription("You found a key here yay");
			key2 = true;
		}
		
		if(CaveExplorer.currentRoom == CaveExplorer.caves[4][7] && !key3){
			Inventory.keycount++;
			CaveExplorer.currentRoom.setDescription("You found a key here yay");
			key3 = true;
		}
		
	}
	
	public void openFinalDoor(int dir){
		if(event1done || event2done || event3done){
			Inventory.encounteredFinalDoor = true;
			if(event1done){
				Inventory.exitKey++;
				event1done = false;
			}
			if(event2done){
				Inventory.exitKey++;
				event3done = false;
			}
			if(event3done){
				Inventory.exitKey++;
				event3done = false;
			}
			
		}
		
		CaveExplorer.print("A gigantic door stands before you. It is locked, and there are three enormous keyholes visible on the door. "
				+ "\n Maybe you need three special keys to open this door..." );
		Inventory.encounteredFinalDoor = true;
		if(dir == EAST && Inventory.exitKey == 3){
			CaveExplorer.print("You insert the three special keys you obtained through your ordeals." 
					+ "You have finally escaped the spooky house, and the dawn of day is now coming."
					+ "Congratulations, you've won. Today, at least."
					+"-----You Live!!!!!!-----");		
			System.exit(1);
		}
	}
	
	
	private boolean isValid(String input) {
		String[] keys = {"w", "a", "s", "d"};
		for (String key: keys) {
			if (input.equals(key)) {
				return true;
			}
		}
		return false;
	}
}
