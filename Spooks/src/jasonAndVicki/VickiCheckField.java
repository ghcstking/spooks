package jasonAndVicki;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class VickiCheckField {

	public static Scanner input;
	public static String row;
	public static String col;
	public static String fRow;
	public static String fCol;
	public static boolean ongoing = true;
	public static String empty = " ";
	public static int flags = 0;
	public static int flagCount = 10;
	public static boolean flag;
	
	public static void play() {
		input = new Scanner(System.in);
		while(ongoing) {
			converse();
		}
	}
	
	public static boolean win() {
		if (flags == 10) {
			print("You avoid joining the legion of skulls.");
			ongoing = false;
			CaveExplorer.inventory.setMap(true);
		}
		else {
			if (!ongoing) {
				EventJasonAndVicki.endGame();
				CaveExplorer.inventory.setMap(true);
			}
		}
		CaveRoom.event1done = true;
		return ongoing;
	}
	
	public static boolean flag() {
		return flag;
	}
	
	public static void runFlag() {
		print("Please enter a row");
		fRow = getInput();
		print("Please enter a column");
		fCol = getInput();
		if(validateInput(fRow, fCol)) {
			int trunRow = Integer.parseInt(fRow);
			int trunCol = Integer.parseInt(fCol);
			updateFlagCount(trunRow, trunCol);
			if(flagCount < 0) {
				print("You are at " + flagCount + " flags. You must've made a flagging mistake.");
			}
		}
	}
	
	public static int updateFlagCount(int r, int c) {
		if(JasonGenerateField.mine4[r][c]) {
			if(unflag(r, c)) {
				unflagCoord(r,c);
				flagCount++;
				if(checkIfMine(r,c)) {
					flags--;
				}
			}
		}
		else {
			if(!JasonGenerateField.mine4[r][c]) {
				JasonGenerateField.mine4[r][c] = true;
				flagCount--;
				flags++;
			}
		}
		JasonGenerateField.updateMap(r, c);
		return flagCount;
	}
	
	public static boolean checkIfMine(int r, int c) {
		if (JasonGenerateField.mine3[r][c].equals("$") && JasonGenerateField.mine[r][c].equals("X")) {
			return true;
		}
		return false;
	}
	
	public static boolean unflag(int r, int c) {
		print("Already flagged. Would you like to unflag?");
		if (getInput().toLowerCase().equals("yes")) {
			return true;
		}
		return false;
	}
	
	public static void unflagCoord(int r, int c) {
		JasonGenerateField.mine4[r][c] = false;
	}

	
	public static void converse() {
		if (win()) {
			print("Flag? Yes or no");
			String res = getInput();
			if (res.toLowerCase().equals("yes")) {
				flag = true;
				runFlag();
			}
			else {
				if (res.toLowerCase().equals("egg")) {
					ongoing = false;
					win();
				}
				else {
					print("Please enter a row");
					row = getInput();
					print("Please enter a column");
					col = getInput();
					if (validateInput(row, col)) {
						checkMines(row, col);
					}
				}
			}
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
		if (rFound && cFound) {
			check = true;
		}
		return check;
	}
	
	public static void checkMines(String r, String c) {
		int trunRow = Integer.parseInt(r);
		int trunCol = Integer.parseInt(c);
		if (JasonGenerateField.mine[trunRow][trunCol] == "X") {
			JasonGenerateField.printFinalField();
		}
		else {
			JasonGenerateField.updateMap(trunRow, trunCol);
		}
	}
	
	public static void checkUp(int r, int c) {
		int rowUp = r--;
		if (rowUp >= 0) {
			for (int row = rowUp; row >= 0; row--) {
				if(JasonGenerateField.mine[row][c].equals("0")) {
					JasonGenerateField.mine3[row][c] = empty;
				}
				else {
					checkLeft(row, c);
					checkRight(row, c);
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
					checkLeft(row, c);
					checkRight(row, c);
					break;
				}
				checkLeft(row, c);
				checkRight(row, c);
			}
		}
	}
	
	public static void checkLeft(int r, int c) {
		int colLeft = c--;
		if (colLeft >= 0) {
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
		printBlankAdjacents();
	}
	
	public static void printBlankAdjacents() {
		for (int row = 0; row < JasonGenerateField.mine3.length - 1; row++) {
			for (int col = 0; col < JasonGenerateField.mine3[row].length - 1; col++) {
				if (row - 1 >= 0) {
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row-1][col].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row-1][col+1].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
				}
				if (col - 1 >= 0) {
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row][col-1].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row][col+1].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row+1][col+1].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
				}
				if (row - 1 >= 0 && col - 1 >= 0) {
					if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row-1][col-1].equals(empty)) {
						JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
					}
				}
				if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row+1][col].equals(empty)) {
					JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
				}
				if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row][col+1].equals(empty)) {
					JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
				}
				if (JasonGenerateField.mine3[row][col].equals("?") && JasonGenerateField.mine3[row+1][col+1].equals(empty)) {
					JasonGenerateField.mine3[row][col] = JasonGenerateField.mine[row][col];
				}
			}
		}
		for (int row = 0; row < JasonGenerateField.mine3.length; row++) {
			for (int col = 0; col < JasonGenerateField.mine3[row].length; col++) {
				if (JasonGenerateField.mine3[row][col].equals("0")) {
					JasonGenerateField.mine3[row][col] = empty;
				}
			}
		}
	}
	
	public static void print(String input) {
		System.out.println(input);
	}
	
	public static String getInput() {
		return input.nextLine();
	}
}
