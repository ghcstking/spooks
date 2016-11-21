package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventEdwinAndAlex implements Event {

	public boolean [][] board = new boolean [5][5];
	public static String cheatCode = "spookyturkey";
	
	public static final String[]INTRO = {
			"You enter a room with flickering lights.",
			"Cautiously, you walk towards the center.",
			"----------------BANG!-------------------",
			"The doors have been slammed shut.",
			"------------*Cue Saw Theme*------------",
			"-----------Enter Asher----------",
			"'I want to play a game with you.'",
			"Before you are a series of lights, some turned off and some turned on.",
			"The rules are simple: enter the coordinates of the switch you want to click.",
			"The light at that coordinate and the adjacent lights will invert.",
			"You must turn off all the lights or else the consequences....",
			"will be severe.",
			"You have forty turns to complete your assignment.",
			"Make your choice."
	};
	public void play() {
		readSequence(INTRO);
		CaveExplorer.print("Are you ready?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0) {
			CaveExplorer.print("I mean... you have to say yes. Or die here.");
		}
		CaveExplorer.print("Let the games begin.");
		CaveExplorer.inventory.setMap(false);
		CaveExplorer.startExploring(false);
		AlexFieldGenerator.startGame(board);
		//TODO FIX THIS SHIT
	}

	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
