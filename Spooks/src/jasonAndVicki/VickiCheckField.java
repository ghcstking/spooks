package jasonAndVicki;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class VickiCheckField {
	
	public static Scanner input;
	public static String row;
	public static String col;
	public static boolean ongoing = true;
	public static int turned = 0;
	public static String empty = " ";
	
	public static void play() {
		input = new Scanner(System.in);
		while(ongoing) {
			converse();
		}
		CaveExplorer.inventory.setMap(true);
	}
	
	public static String getInput() {
		return input.nextLine();
	}
	
	
	public static void converse() {
		print("Please enter a row");
		row = getInput();
		print("Please enter a column");
		col = getInput();
		if (validateInput(row, col)) {
			checkMines(row, col);
		}
	}
	
	public static boolean validateInput(String r, String c) {
		boolean rFound = false;
		boolean cFound = false;
		boolean check = false;
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].equals(r)) {
				rFound = true;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].equals(c)) {
				cFound = true;
			}
		}
		if (r.equals("exit") && c.equals(("exit"))) {
			ongoing = false;
		}
		if (rFound && cFound) {
			check = true;
		}
		return check;
	}
	
	public static void checkMines(String r, String c) {
		int trunRow = Integer.parseInt(r);
		int trunCol = Integer.parseInt(c);
		if (JasonGenerateField.mine[trunRow][trunCol] == "X") {
			printFinalField();
		}
		else {
			updateMap(trunRow, trunCol);
		}
	}
	
	public static void updateMap(int r, int c) {
		if (JasonGenerateField.mine3[r][c] == JasonGenerateField.mine[r][c] ||
				JasonGenerateField.mine3[r][c].equals(" ")) {
			print("You've already entered those coordinates.");
		}
		else {
			if (JasonGenerateField.mine[r][c].equals("0")) {
				checkSurrounding(r, c);
				JasonGenerateField.mine3[r][c] = empty;
			}
			else {
				JasonGenerateField.mine3[r][c] = JasonGenerateField.mine[r][c];
			}
		}
		JasonGenerateField.printField();
		System.out.println(turned);
	}
	
	public static void checkUp(int r, int c) {
		int rowUp = r--;
		if (rowUp >= 0) {
			for (int row = rowUp; row >= 0; row--) {
				if(JasonGenerateField.mine[row][c].equals("0")) {
					JasonGenerateField.mine3[row][c] = empty;
				}
				else {
					break;
				}
				checkLeft(row, c);
				checkRight(row, c);
			}
		}
	}
	
	public static void checkDown(int r, int c) {
		int rowDown = r++;
		if (rowDown <= 8) {
			for(int row = rowDown; row <= 8; row++) {
				if(JasonGenerateField.mine[row][c].equals("0")) {
					JasonGenerateField.mine3[row][c] = empty;
				}
				else {
					break;
				}
				checkLeft(row, c);
				checkRight(row, c);
			}
		}
	}
	
	public static void checkLeft(int r, int c) {
		int colLeft = c--;
		if (colLeft > 0) {
			for (int col = colLeft; col >= 0; col--) {
				if(JasonGenerateField.mine[r][col].equals("0")) {
					JasonGenerateField.mine3[r][col] = empty;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void checkRight(int r, int c) {
		int colRight = c++;
		if (colRight <= 8) {
			for (int col = colRight; col <= 8; col++) {
				if(JasonGenerateField.mine[r][col].equals("0")) {
					JasonGenerateField.mine3[r][col] = empty;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void checkSurrounding(int r1, int c1) {
		checkUp(r1, c1);	
		checkDown(r1, c1);
		checkLeft(r1, c1);
		checkRight(r1, c1);
	//	updateSweepMap();
	}
	
//	public static void updateSweepMap() {
//		for (int row = 0; row < JasonGenerateField.mine3.length; row++) {
//			for (int col = 0; col < JasonGenerateField.mine3[row].length; col++) {
//				if(JasonGenerateField.mine3[row][col].equals(empty)) {
//						surroundingNums(row, col);				
//				}
//			}
//		}
//	}
	
//	public static void surroundingNums(int r, int c) {
//		if (r-1 >= 0 && c-1 >= 0) {
//			updateMap(r-1, c-1);
//		}
//	}
	
	public static void printFinalField() {
		for (int row = 0; row < JasonGenerateField.mine.length; row++) {
			for (int col = 0; col < JasonGenerateField.mine[row].length; col++) {
				JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
			}
		}
		JasonGenerateField.printField();
		print("You have died. You are now part of this lovely shrine.");
		ongoing = false;
	}
	
	public static void print(String input) {
		System.out.println(input);
	}

}
