package jasonAndVicki;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventJasonAndVicki implements Event {
  
	public boolean[][] field = new boolean[9][9];
        public static final String[] SEQ = {
        		"There's a loud BANG! and the doors shut on you... again...", 
        		"The room is lined with shelves of skulls.",
        		"Not the mention the huge, very ugly, very angry skull statue amidst the shelves...",
        		"The bang caused another skull to roll off and BANG! It explodes.",
                "- - - - - - - The skull statue awakes - - - - - - -",
                "Maybe at this point, you're wishing you stayed out of this godforsake house.",
                "'It's so very rare that we get a visitor down in the minefield.'",
                "'They usually die so... let's see if you can survive.'",
                "'The rules are as follows: my 9x9 board is filled with 10 of my friends.'",
                "'Each tile you turn over tells you how many of my friends are currently next to you.'",
                "'Your job is to clear the entire board. If you kill one of my friends, you die. Simple enough.'", 
                "'Good luck, or else your head will become part of this shrine.'"
        };
  
        public void play() {
                readSequence(SEQ);
                CaveExplorer.print("Are you ready?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0) {
			CaveExplorer.print("I mean... you have to say yes. Or die here.");
		}
                CaveExplorer.print("Let us begin.");
        }
  
        public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
                        CaveExplorer.print(" - - - Press enter - - - ");
                        CaveExplorer.in.nextLine();
                }
	}
}

