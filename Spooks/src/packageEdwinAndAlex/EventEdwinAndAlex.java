package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Event;

public class EventEdwinAndAlex implements Event {
	
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
	public static final String[]WIN = {
			"*chokes on his doughnut*.",
			"'How did you solve the impossible puzzle!?'",
			"You hear a chicken's cuckoo",
			"'No...it can't be...THIS CAN'T BE HAPPENING!'",
			"A black egg appears out of thin air, smashing into Asher.",
			"NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
			"Asher disintegrates into thin air.",
			"The door opens ... it seems you can now proceed."
	};
	
	public static final String[]LOSE = {
			"'What a pity.'",
			"A crevice opens, filled with chicken eggs.",
	};
	//
	public void play() {
		readSequence(INTRO);
		CaveExplorer.print("Are you ready?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0) {
			CaveExplorer.print("I mean... you have to say yes. Or die here.");
		}
		CaveExplorer.print("Let the games begin.");
		CaveExplorer.inventory.setMap(false);
		CaveExplorer.startExploring(false);
		if(AlexFieldGenerator.startGame()){
			CaveRoom.event2done = true;
			//
			readSequence(WIN);
			CaveExplorer.inventory.setMap(true);
			CaveExplorer.inventory.updateMap();
			CaveExplorer.startExploring(true);
		}
		else{
			readSequence(LOSE);
			CaveExplorer.print("You fall through to your untimely demise.");
			CaveExplorer.startExploring(false);
			System.exit(1);
		}
	}

	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
