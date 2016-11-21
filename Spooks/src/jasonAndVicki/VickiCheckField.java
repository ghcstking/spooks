package jasonAndVicki;

import java.util.Arrays;
import java.util.Scanner;

public class VickiCheckField {

	public static Scanner input;
	public static String row;
	public static String col;
	public static String[][] mineMap = new String[18][18];
	public static String map;
	public static boolean ongoing;
	
	public static boolean validate(String r, String c) {
		boolean found = false;
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == r) {
				found = true;
			}
		}
		return found;
	}
	
	public static void checkMines(String r, String c) {
		int row = Integer.parseInt(r);
		int col = Integer.parseInt(c);
		if (JasonGenerateField.mine[row][col] == "X") {
			// printFinalField() where it shows all the mines
			System.out.println("yasss");
		}
		else {
			// updateMap(r, c)
			updateMap(row,col);
		}
	}
	
	public static void makeMap(){
		map = "_";
		for(int r = 0; r < mineMap.length; r++){
			for(int c = 0; c < mineMap[0].length; c++){
				if(mineMap[r][c] == null){
					mineMap[r][c] = " ";
				}
				if(r % 2 == 0){
					mineMap[r][c] = "_";
					mineMap[0][mineMap[0].length - 1] = " ";
					map += mineMap[r][c];
				}
				else{
					if(c % 2 == 0 && r % 2 == 1){
						mineMap[r][c] = "|";
						map+= mineMap[r][c];
					}
					else{
						map += mineMap[r][c];
					}
				}
			}
			
			map += "\n";
		}
		
		for(int z = 0; z < mineMap.length; z++){
			System.out.print(Arrays.toString(mineMap[z]));
			System.out.println("/n");
		}
		
		System.out.println(" 0 1 2 3 4 5 6 7 8 ");
		System.out.println(map);
	}
	
	public static void updateMap(int r, int c) {
		// where it checks the r+1, c-1 combo (check for full list of combos in JasonGenerateField)
		// for mines AND also display the NUMBERS (which you can get from JasonGenerateField.mine[row][col]
		int surroundMineCount = 0;
		int rowdifference = (8 - r) * 2;
		if(r % 2 == 1 && c % 2 == 0){
			mineMap[r+(2 * r) - rowdifference + 2][c+1] = "" + surroundMineCount;
		}
		else{
			if(r % 2 == 0 && c % 2 == 1){
				mineMap[r+1][c+2] = "" + surroundMineCount;
			}
			else{
				if(r % 2 == 1 && c % 2 == 1){
					mineMap[r+2][c+2] = "" + surroundMineCount;
				}
				else{
					if(r > 1 && c > 1 && r % 2 == 0 && c % 2 == 0){
						mineMap[r+3][c+1] = "" + surroundMineCount;
					}
					else{
						mineMap[r+1][c+1] = "" + surroundMineCount;
					}
				}
			}
		}
		makeMap();
		play();
	}
	
	public static void printFinalField() {
		for (int row = 0; row < JasonGenerateField.mine.length; row++) {
			for (int col = 0; col < JasonGenerateField.mine[0].length; col++) {
				if (JasonGenerateField.mine2[row][col]) {
					// UH WHAT TO DO 
				}
			}
		}
	}
	
	public static String getInput() {
		return input.nextLine();
	}
	
	public static void play() {
		input = new Scanner(System.in);
		print("Please enter a row");
		row = getInput();
		print("Please enter a column");
		col = getInput();
		makeMap();
		checkMines(row, col);
		
	}
	
	public static void print(String input) {
		System.out.println(input);
	}

}
