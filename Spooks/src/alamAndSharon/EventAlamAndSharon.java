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
		/*
		arr2D = new String[5][5];
		pic = new String[5][5];
		for(int row = 0; row < arr2D.length; row++){
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col] = "(" + row + "," + col + ")";
			}
			
		}
		//HOMEWORK FUNCTION
		printGrid(pic);
		// start position
		i = 2;
		j = 3;
		in = new Scanner(System.in);
		startExploring();
		*/
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

	private static void startExploring() {
		// TODO Auto-generated method stub
		while(true){
			//printPic(pic);
			System.out.println("You are in room " + arr2D[i][j]);
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("Please enter W, A, S, or D.");
				input = in.nextLine();
			}
			interpretInput(input.toLowerCase());
			
		}
	}

		private static void interpretInput(String input) {
			int iOrig = i;
			int jOrig = j;
			if(input.equals("w") && i > 0) i--;
			else if(input.equals("a") && j > 0) j--;
			else if(input.equals("s") && i < arr2D.length-1) i++;
			else if(input.equals("d") && j < arr2D[i].length-1) j++;
			
			if(iOrig == i && jOrig == j){
				System.out.println("There is a wall in your path");
			}
	}

		private static boolean isValid(String input) {
			String lc = input.toLowerCase().trim();
			String[] keys = {"w","a","s","d"};
			for(String key:keys){
				if(key.equals(lc))return true;
			}
			return false;
	}

		
		private static void mines() {
			// Lesson 2 on the mines
			boolean [][] mines = new boolean[100][100];
			createMines(mines, 5000);
			String[][] field =	new String[mines.length][mines[0].length];
			matchValue(field,mines);	
			printPic(field);	
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
	
		private static String countAdjacent(boolean[][] mines, int r, int c) {
			
			int count = 0;
			count += vaildAndTrue(mines, r-1, c); 	//top
			count += vaildAndTrue(mines, r+1, c); 	//bottom
			count += vaildAndTrue(mines, r, c-1);	//left
			count += vaildAndTrue(mines, r, c+1);	//right
			
			
			return count + "";
		}
	
		private static int vaildAndTrue(boolean[][] mines, int i, int j) {
			
			
			if(i>0 && i <mines.length && j>=0 && j <mines[1].length && mines[i][j]){
				return 1;
			}
			return 0;
		}
	
		private static void createMines(boolean[][] mines, int numberOfMines) {
			
			while(numberOfMines > 0){
				int row = (int)(Math.random()*mines.length);
				int col = (int)(Math.random()*mines[0].length);
				if(!mines[row][col]){
					mines[row][col]= true;
					numberOfMines --;
				}
			}	
		}
		

	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - - ");
			CaveExplorer.in.nextLine();
		}
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
	
	
	
	


