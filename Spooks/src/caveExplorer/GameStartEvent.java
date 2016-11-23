package caveExplorer;

public class GameStartEvent implements Event { 
	public static final String[] SEQ_1 = {
			"Upon entering the room, an old, white-haired man approaches you.",
			"What are you doing here? It is not safe...",
			"This place has been abandoned and HAS SPOOKY SKELETONS.",
			"You cannot leave this floor until you have eluded the spooks."
	};
	public static final String[] SEQ_2 = {
			"Great! Not like you have another choice anyway... unless your wish is death...",
			"Here's a map to help you navigate the floor."
	};
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}
	public void play() {
		readSequence(SEQ_1);
		CaveExplorer.print("Are you ready?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0) {
			CaveExplorer.print("I mean... you have to say yes. Or die here.");
		}
		readSequence(SEQ_2);
		Inventory.mapBefore = true;
		CaveExplorer.inventory.setMap(true);
	}

	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}

}
