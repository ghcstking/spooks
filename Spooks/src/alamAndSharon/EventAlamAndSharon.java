package alamAndSharon;

import java.util.Scanner;


import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Event;

public class EventAlamAndSharon implements Event {

	public boolean[][] maze = new boolean[10][10];
	public static final String[] Begin = { "--Enter dramatic scene--" };
	public static final String[] Win = {"Horrayyy!!You have escaped alive!!"};
	public static final String[] Lost = {"Game Over. You've been found."};
	public static Scanner in;
	/*
	public static String[][]arr2D;
	public static String[][]pic;
	
	public static int i;
	public static int j;
	*/
	
	//Both ghost and player need a map to compare locations.
	public static String[][] playerMap= new String[10][10];
	public static String[][] ghostMap= new String[10][10];
	
	public void play() {
		
		readSequence(Begin);
		CaveExplorer.print("Ghost are hunting you down surive for 10 rounds");
		CaveExplorer.print(" - - - Press enter - - - ");
		CaveExplorer.in.nextLine();
		CaveExplorer.print("SURIVE!");
		
	}
	// ********* In this class, we will only generate the map. *********
	//******The input class will take in the user input to move the person and update the map.********
	

	
/*
	private static void printGrid(String[][] picArray) {
		// TODO Auto-generated method stub
		String[][] array = new String[((picArray.length*3)+1)][((picArray[0].length*4)+1)];
		for(int y = 0; y < array.length; y++){

			for(int x = 0; x < array[y].length; x++){
				array[y][x] = " ";
				if(y%3 == 0)array[y][x] = "_";
				if(x%4 == 0)array[y][x] = "|";
				
			}
		}
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
	}

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
	
		private static void matchValue(String[][] field, boolean[][] mines) {
			
			for(int row = 0; row < field.length; row++){
				for(int col = 0; col < field[0].length; col++){
					if(mines[row][col]){
						field[row][col] = "X";
					}else{
						field[row][col] = countAdjacent(mines, row, col);
					}
				}
			}
		}
	//we can use something like this countAdacent func to warn player of nearby ghost
	 //and also to check if the player can move in that direction.
	  
		private static String countAdjacent(boolean[][] mines, int r, int c) {
			
			int count = 0;
			count += vaildAndTrue(mines, r-1, c); 	//top
			count += vaildAndTrue(mines, r+1, c); 	//bottom
			count += vaildAndTrue(mines, r, c-1);	//left
			count += vaildAndTrue(mines, r, c+1);	//right
			
			
			return count + "";
		}
	
	
*/
	
	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
	}
}



//outline of event
	
	
	
	


