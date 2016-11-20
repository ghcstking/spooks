package alamAndSharon;

import caveExplorer.CaveExplorer;

public class SharonInput {
	
	/*
	 * In the main event class(EventAlamAndSharon), the function for generating map
	 * is made. In this function, it is called.
	 * 
	private static void printGameMap() {
		EventAlamAndSharon.;
	}
	
	*/
	public void interpretInput(String input) {
		while(!isValid(input)){
			System.out.println("You can only enter " + "'w','a','s', or 'd'");
			input = CaveExplorer.in.nextLine();
		}
		
		String[] keys = {"w","d","s","a"};
		int indexFound = -1;
		
		for(int i = 0; i < keys.length; i++){
			if(input.equals(keys[i])){
				indexFound = i;
				break;
			}
		}
		goToRoom(indexFound);
	}

	public void goToRoom(int direction) {
		
	}
	
	
	private boolean isValid(String input) {
		String[] keys = {"w", "a", "s", "d"};
		for (String key: keys) {
			if (input.equals(key)) {
				return true;
			}
		}
		return false;
	}

	
}





