package alamAndSharon;

import caveExplorer.CaveExplorer;
import caveExplorer.Event;

public class EventAlamAndSharon implements Event {

	public boolean[][] maze = new boolean[10][10];
	public static final String[] Begin = { "--Enter dramatic scene--" };

	public void play() {
		readSequence(Begin);
		CaveExplorer.print("Are you ready?");
		while (CaveExplorer.in.nextLine().indexOf("yes") < 0) {
			CaveExplorer.print("I mean... you have to say yes. Or die here.");
		}
		CaveExplorer.print("You have entered the game.");
	}

	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}

}



//outline of event


