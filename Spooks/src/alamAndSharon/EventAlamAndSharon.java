package alamAndSharon;

import java.util.Scanner;


import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Event;

public class EventAlamAndSharon implements Event {

	public boolean[][] maze = new boolean[10][10];
	public static final String[] Begin = { "Unfortunately for you, You have entered a pitch black room.",
			"It's too late to turn back now.","You must pass this test to prove you're worthy of moving to the next round.",
			"Navigate this this room with your moral compass." ,"You will be given a map when you are within proximity of a ghost",
			"May the forces be with you."};
	public static final String[] Win = {"Horrayyy!!You have escaped alive!!"};
	public static final String[] Lost = {"Game Over. You've been found."};
	public static Scanner in;
	
	
	//Both ghost and player need a map to compare locations.
	public static String[][] playerMap= new String[10][10];
	public static String[][] ghostMap= new String[10][10];
	
	public void play() {
		
		readSequence(Begin);
		CaveExplorer.print("Ghost are hunting you down surive for 10 rounds");
		CaveExplorer.print(" - - - Press enter - - - ");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("SURIVE!");
		CaveExplorer.inventory.setMap(false);
        CaveExplorer.startExploring(false);
		//printGrid();
        AlamAI.begin();
        SharonInput.play();
        
	}
	
	
	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
	public static void moveGhost(){
		 AlamAI.moveDaGhost();
	}
}



//outline of event
	
	
	
	


