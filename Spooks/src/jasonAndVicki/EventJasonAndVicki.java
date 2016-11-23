package jasonAndVicki;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventJasonAndVicki implements Event {
  
	public boolean[][] field = new boolean[9][9];
        public static final String[] SEQ = {
        		"You enter a room full of skulls",
        		"At this point, you're wishing you stayed out of this godforsake house.",
                "- - - - - - - The skull statue awakes - - - - - - -",
                "'Welcome to the minefield. The rules are as follows: ",
                "'My 9x9 board is filled with 10 of my friends.'",
                "'Each tile you turn over tells you how many of my friends are currently next to you.'",
                "'Your job is to clear the entire board. If you kill one of my friends, you die.",
        };
        
        public static final String[] SEQ1 = {
        		"How do you know the secret code?!",
        		"You manage to evade us... for now...",
        };
        
        public static void endGame() {
        	readSequence(SEQ1);
        }
        
        public void play() {
            readSequence(SEQ);
            CaveExplorer.print("Are you ready?");
            while(CaveExplorer.in.nextLine().indexOf("yes") < 0) {
            	CaveExplorer.print("I mean... you have to say yes. Or die here.");
            }
            CaveExplorer.print("Let us begin.");
            CaveExplorer.inventory.setMap(false);
            CaveExplorer.startExploring(false);
            JasonGenerateField.play();
        }
  
        public static void readSequence(String[] seq) {
			for (int i = 0; i < seq.length; i++) {
				CaveExplorer.print(seq[i]);
	            CaveExplorer.print(" - - - Press enter - - - ");
	            CaveExplorer.in.nextLine();
	        }
        }
        
}

