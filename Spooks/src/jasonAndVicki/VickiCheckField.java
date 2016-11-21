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
		if (validate(r,c)) {
			int row = Integer.parseInt(r);
			int col = Integer.parseInt(c);
			if (JasonGenerateField.mine[row][col] == "X") {
				// printFinalField() where it shows all the mines
				System.out.println("yasss");
			}
			else {
				updateMap(r, c);
			}
		}
		else {
			print("Please enter a valid input");
			converse();
		}
	}
	
	public static void updateMap(String row, String col) {
		
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
	
	public static void converse() {
		input = new Scanner(System.in);
		print("Please enter a row");
		row = getInput();
		print("Please enter a column");
		col = getInput();
	}
	
	public static void play() {
		converse();
		checkMines(row, col);
	}
	
	public static void print(String input) {
		System.out.println(input);
	}

}
