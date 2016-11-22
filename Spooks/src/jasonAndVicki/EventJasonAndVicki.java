package jasonAndVicki;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventJasonAndVicki implements Event {
  
        public static final String[] SEQ = {
        		"The room is lined with shelves of skulls.",
        		"Not the mention the huge, very angry skull statue amidst the shelves...",
                "- - - - - - - The skull statue awakes - - - - - - -",
                "Maybe at this point, you're wishing you stayed out of this godforsake house.",
                "'It's so very rare that we get a visitor down in the minefield.'",
                "'The rules are as follows: my 9x9 board is filled with 10 of my friends.'",
                "'Each tile you turn over tells you how many of my friends are currently next to you.'",
                "'Your job is to clear the entire board. If you kill one of my friends, you die.", 
                "'Good luck, or else your head will become part of this shrine.'"
        };
  
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

