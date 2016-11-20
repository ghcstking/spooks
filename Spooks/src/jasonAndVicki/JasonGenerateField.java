package jasonAndVicki;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class JasonGenerateField {
	public static String[][] mine;
	public static boolean mine2[][];
	private static String map;
	
	public static void generateField() {
		mine = new String[9][9];
		mine2 = new boolean[9][9];
	}
	public static void createMines() {
		int num = 10;
		while (num > 0) {
			int row = (int)(Math.random() * mine2.length);
			int col = (int)(Math.random() * mine2[0].length);
			if (!mine2[row][col]) { 
				mine2[row][col] = true;
				num--;
			}
		}
	}
	public static void matchValues() {
		for (int row = 0; row < mine.length; row++) {
			for (int col = 0; col < mine[0].length; col++) {
				if (mine2[row][col]) {
					mine[row][col] = "X";
				}
				else {
					mine[row][col] = countAdjacent(mine2, row, col);
				}
			}
		}
	}
	public static String countAdjacent(boolean[][] minefield, int r, int c) {
		int count = 0;
		count+= validAndTrue(minefield, r-1, c);
		count+= validAndTrue(minefield, r+1, c);
		count+= validAndTrue(minefield, r, c-1);
		count+= validAndTrue(minefield, r, c+1);
		return count + "";
	}
	public static int validAndTrue(boolean[][] minefield, int i, int j) {
		if (i >= 0 && i < mine2.length && j >= 0 && j < mine2[0].length && mine2[i][j]) {
			return 1;
		}
		return 0;
	}
	public static String printMap() {
		map = "  ";
		for(int i = 0; i < mine[0].length - 1; i++){
			map += "____";
		}
		map += "___\n";
		for(String[] row: mine){
			for(int i = 0; i < 3; i++){
				String text = " ";
				for(String cr: row){
					text += "|";
					if(i == 0){
						text += "   "; // 3 spaces
					}else if(i == 1){
						text += " X ";
					}
					else {
						text += "   ";
					}
					text += "___";
				}
				text += "|";
				map += text + "\n";
			}
		}
		return map;
	}
	public static void play() {
		generateField();
		createMines();
		matchValues();
//		printPic();
		for (int i = 0; i < mine.length; i++){ 
			for (int j = 0; j < mine[0].length; j++) {
				System.out.print(mine[i][j]);
			}
			System.out.println();
		}
	}
	
}
