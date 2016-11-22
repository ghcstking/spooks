package jasonAndVicki;

public class JasonGenerateField {
	public static String[][] mine;
	// ACTUAL ARRAY
	public static boolean mine2[][];
	// BOOLEAN ARRAY
	public static String[][] mine3;
	// FAKE ARRAY
	public static String map;
	
	public static void play() {
		generateField();
		createMines();
		matchValues();
		printField();
		for (int i = 0; i < mine.length; i++){ 
			for (int j = 0; j < mine[0].length; j++) {
				System.out.print(mine[i][j]);
			}
			System.out.println();
		}
		VickiCheckField.play();
	}
	
	
	public static void generateField() {
		mine = new String[9][9];
		mine2 = new boolean[9][9];
		mine3 = new String[9][9];
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
		fakeMap();
	}

	public static void fakeMap() {
		for (int row = 0; row < mine3.length; row++) {
			for (int col = 0; col < mine3[row].length; col++) {
				mine3[row][col] = "?";
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
		count+= validAndTrue(minefield, r+1, c+1);
		count+= validAndTrue(minefield, r-1, c-1);
		count+= validAndTrue(minefield, r+1, c-1);
		count+= validAndTrue(minefield, r-1, c+1);
		
		return count + "";
	}
	
	public static int validAndTrue(boolean[][] minefield, int i, int j) {
		if (i >= 0 && i < mine2.length && j >= 0 && j < mine2[0].length && mine2[i][j]) {
			return 1;
		}
		return 0;
	}
	
	public static void printField() {
		map = "";
        for(int i = 0; i < mine[0].length - 1; i++){
            map += "__";
        }
        map += "___\n";

        for(int row = 0; row <mine.length; row++){
            for(int row2 = 0; row2 < 1; row2++){
                for(int col = 0; col < mine[row].length; col++){
                    if(row2 == 0){
                        map+="|" + getContents(mine3, row, col);
                    } else{
                    	map+="|   ";
                    }
                }
                map += "|  Row " + row + "\n";               
            }
        }
        System.out.println(map);
        System.out.println(" 0 1 2 3 4 5 6 7 8");
	}
	
	public static String getContents(String[][] arr, int r, int c) {
		return arr[r][c];
	}
}
