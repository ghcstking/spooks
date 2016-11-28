package alamAndSharon;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

import java.util.Scanner;

public class SharonInput extends EventAlamAndSharon{
	
	public static Scanner in = new Scanner(System.in);
	public static String txtInput;
	public static int inputInt;
	
	public static int playerColCurrent = 5; //fake pos
	public static int playerRowCurrent = 5;
	//official position !=current position. If out of bounds/ spot taken, playerCurrent is changed back to original position
	public static int playerCol = 5;
	public static int playerRow = 5;
	
	public static void beginPlayer(){
		while(true){
			Items.cheatMap();
			System.out.println("Where would you like to go?.");
			
			String response=in.nextLine();
			interpretInput(response);
		}
		
	}
	public static void interpretInput(String input) {
		input=input.toLowerCase();
		while(!isValid(input)){
			System.out.println("You can only enter " + "'w','a','s', or 'd'");
			input = CaveExplorer.in.nextLine();
		}
		//move ghost then players
		AlamAI.moveDaGhost();
		moveThePlayer(input);
		playerCheckRoom(playerRow,playerCol);
	}

	
	private static void moveThePlayer(String dir) {
		
		// "w" move row up
		if(dir.equals("w")){
			playerRowCurrent+=1;
		}
		// "a" move col left
		if(dir.equals("a")){
			playerColCurrent-=1;
		}
		// "s" move row down
		if(dir.equals("s")){
			playerRowCurrent-=1;
		}
		// "d" move col right
		if(dir.equals("d")){
			playerColCurrent+=1;
		}
		//cheat codes activate here
		if(dir.equals("cheat end")){
			Items.cheatCodes(1);
		}
		if(dir.equals("cheat cloak")){
			Items.cheatCodes(2);
		}
		if(dir.equals("cheat flash")){
			Items.cheatCodes(3);
		}
		if(dir.equals("cheat map")){
			Items.cheatCodes(4);
		}
		
		
		
	}
	//checks to see if player is able to go to that room & sets the coordinates of the destination.
	//move player to room given direction.
	public static void playerCheckRoom(int row,int col) {	
		//remove player from 2D array	
		ghostMap[playerRow][playerCol] = null;
		
		//checks for items first
		//this way you can get a cloak and save yourself if a ghost happens to walk in the room
		Items.checkForItem();
		
		
		if(isAvail(playerRowCurrent,EventAlamAndSharon.playerMap.length-1)
		   && isAvail(playerColCurrent,EventAlamAndSharon.playerMap[0].length-1)){
			playerRow=playerRowCurrent;
			playerCol=playerColCurrent;
			// removes a turn from the items class
			if(isRoomFull()){
				//checks to see if you have a cloak
				if(Items.invisibilityCloak > 0){
					System.out.println("A loud bang can be heard behind you, you quickly put on your invisibility cloak and stand still.");
					System.out.println("A blonde man with very small hands walks by you, mumbling something about the game being rigged");
					System.out.println("You have lost a cloak");
					Items.invisibilityCloak --;
				// if not game ends
				}else{
					System.out.println("Game Over. You've run into the ghost.");
					System.out.println("'I will eat you alive' as teh ghost swallow you whole");
					System.out.println("-----You Died.-----");
					System.exit(1);
				}
			}
			Items.turns --;
			if(Items.turns == 3){
				System.out.println("I will find you, and I will eat you alive!");
				System.out.println("This is gonna hurt real bad!");
			}
			if(Items.turns <= 0){
				System.out.println("The ghost got bored so he started watching Nexflix");
				System.out.println("Be more fun next time");
				// win game here
				CaveRoom.event3done = true;
				CaveExplorer.inventory.updateMap();
				if(Inventory.mapBefore == false){
					CaveExplorer.startExploring(true);
				}
				else{
					CaveExplorer.inventory.setMap(true);
					caveExplorer.CaveExplorer.startExploring(true);
				}
			}	
		}else{
			playerRowCurrent = playerRow;
			playerColCurrent = playerCol;
			System.out.println("You are restricted from leaving this map.");
		}
		//checks for nearby ghost and alerts player
		Items.sensor();
		//adds player back in array
		ghostMap[playerRowCurrent][playerColCurrent] = "player";
	}


//check if ghost are active before then checking if they over lap
	private static boolean isRoomFull() {
		//System.out.println(ghostMap[playerRowCurrent][playerColCurrent]);
		if (ghostMap[playerRowCurrent][playerColCurrent] != null){
			return true;
		}	 
			return false;
	}
	private static boolean isValid(String input) {
		//check to see if valid direction
		String[] keys = {"w", "a", "s", "d","cheat end","cheat cloak","cheat flash","cheat map"};
		for (String key: keys) {
			if (input.equals(key)) {
				return true;
			}
		}
		return false;
	}
	public static boolean isAvail(int input, int max){
		//Check to see if within bound of board
		//int num = Integer.parseInt(input);
		int num=input;
		if(num < 0 || num > max){
			return false;
		}
		return true;
	}
	
	
}





