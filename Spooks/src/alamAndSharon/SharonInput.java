package alamAndSharon;

import caveExplorer.CaveExplorer;
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
			Items.cheatMap(ghostMap);
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
		
		moveThePlayer(input);
		
		AlamAI.moveDaGhost();
		playerCheckRoom(playerRow,playerCol);
	}

	
	private static void moveThePlayer(String dir) {
		ghostMap[playerRow][playerCol] = null;
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
		
		if(dir.equals("cheat end")){
			Items.cheatCodes(1);
		}
		if(dir.equals("cheat cloak")){
			Items.cheatCodes(2);
		}
		if(dir.equals("cheat flash")){
			Items.cheatCodes(3);
		}
		if(dir.equals("1")){
			Items.cheatCodes(4);
		}
		
		
	}
	//checks to see if player is able to go to that room & sets the coordinates of the destination.
	//move player to room given direction.
	public static void playerCheckRoom(int row,int col) {
		//checks for items first
		//this way you can get a cloak and save yourself if a ghost happens to walk in the room
		Items.checkForItem();
		if(isRoomFull()){
			//checks to see if you have a cloak
			if(Items.invisibilityCloak > 0){
				System.out.println("A loud bang can be heard behind you, you quickly put on your invisibility cloak and stand still.");
				System.out.println("A blonde man with very small hands walks by you, mumbling something about the game being rigged");
				System.out.println("You have lost a cloak");
				Items.invisibilityCloak --;
			// if not game ends
			}else{
				System.out.println("Game Over. You've run into Donald Trump.");
				System.out.println("'I will deport you from this game' he cries as he kickes you out");
				System.out.println("'It's time to make haunted houses great again!'");
				
				//loose game here
				caveExplorer.CaveExplorer.startExploring(true);
			}
		}
		if(isAvail(playerRowCurrent,EventAlamAndSharon.playerMap.length-1)&& isAvail(playerColCurrent,EventAlamAndSharon.playerMap[0].length-1)){
			playerRow=playerRowCurrent;
			playerCol=playerColCurrent;
			// removes a turn from the items class
			Items.turns --;
			if(Items.turns == 3){
				System.out.println("I will find you, and I will deport you out of this game!");
				System.out.println("This is gonna be bigly folks, No one tells me I have small hands!");
			}
			if(Items.turns <= 0){
				System.out.println("Trump got bored so he went to play golf");
				
				// win game here
				caveExplorer.CaveExplorer.startExploring(true);
			}	
		}else{
			System.out.println("You are restricted from leaving this map.");
		}
		//checks for nearby ghost
		ghostMap[playerRow][playerCol] = "player";
		Items.sensor();
		
	}


//check if ghost are active before then checking if they over lap
	private static boolean isRoomFull() {
		if(AlamAI.ghost1){
			if(AlamAI.locationCol1 == playerCol && AlamAI.locationRow1 == playerRow){
				return true;
			}
		}
		if(AlamAI.ghost2){
			if(AlamAI.locationCol2 == playerCol && AlamAI.locationRow2 == playerRow){
				return true;
			}
		}
		if(AlamAI.ghost3){
			if(AlamAI.locationCol3 == playerCol && AlamAI.locationRow3 == playerRow){
				return true;
			}
		}
		if(AlamAI.ghost1){
			if(AlamAI.locationCol1 == playerCol && AlamAI.locationRow1 == playerRow){
				return true;
			}
		}
		 
			return false;
	}
	private static boolean isValid(String input) {
		//check to see if valid direction
		String[] keys = {"w", "a", "s", "d","cheat end","cheat cloak","cheat flash"};
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





