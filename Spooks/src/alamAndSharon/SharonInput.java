package alamAndSharon;

import caveExplorer.CaveExplorer;
import java.util.Scanner;

public class SharonInput{
	
	public static Scanner in = new Scanner(System.in);
	public static String txtInput;
	public static int inputInt;
	
	public static void play(){
		
		CaveExplorer.print("Where would you like to go?.");
		
		String response=in.nextLine();
		interpretInput(response);
		
	}
	public static void interpretInput(String input) {
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
		AlamAI.moveDaGhost();
		goToRoom(indexFound);
	}

	
	//move player to room given direction.
	public static void goToRoom(int direction) {
		
	}
	
	
	
	private static boolean isValid(String input) {
		String[] keys = {"w", "a", "s", "d"};
		for (String key: keys) {
			if (input.equals(key)) {
				return true;
			}
		}
		return false;
	}
	/*
	public static void printPic(String[][] pic){
			for(int y = 0; y < pic.length; y++){
				for(int x = 0; x < pic[y].length; x++){
					if(y == i && x ==j){
						pic[y][x] = "X";
					}else{
						pic[y][x] = " ";						
					}
					System.out.print(pic[y][x]);
				}
				System.out.println();
			}
		}
	 */

	
}





