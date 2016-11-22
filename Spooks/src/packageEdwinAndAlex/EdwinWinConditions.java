package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;

public class EdwinWinConditions {

	public EdwinWinConditions() {
		// TODO Auto-generated constructor stubsdasd
	}

	public static boolean isCleared(boolean [][] board){
		for(boolean [] row: board){
			for(boolean light:row){
				if(!light){
					return false;
				}
			}
		}
		return true;
	}

	public static void changeBoard(boolean [][] board,String rowCord,String colCord){
		if(cheatCodeEntered(rowCord)||(cheatCodeEntered(colCord))){
			
		}
			int r = Integer.parseInt(rowCord);
			int c = Integer.parseInt(colCord);
			while(!isValidPoint(r,c,board)){
				CaveExplorer.print("Are you braindead? There's no lightbulb at that point.");
				CaveExplorer.print("Enter row coordinate.");
				r = Integer.parseInt(CaveExplorer.in.nextLine());
				CaveExplorer.print("Enter column coordinate.");
				c = Integer.parseInt(CaveExplorer.in.nextLine());
			}
			changeLights(r,c,board);
		}

	private static void changeLights(int r, int c, boolean[][] board) {
		// TODO Auto-generated method stub
		//have to first establish special cases
		board[r][c] = !board[r][c];
		if(c==0){
			if(r==0){
				board[r+1][c] = !board[r+1][c];
				board[r][c+1] = !board[r][c+1];
			}
		}

	}

	private static boolean isValidPoint(int rowCord, int colCord, boolean [][] board){
		boolean validRow = false;
		boolean validCol = false;
		for(int r = 0; r < board.length-1;r++){
			if(rowCord==r)validRow=true;
		}
		for(int c = 0; c < board[0].length-1;c++){
			if(colCord==c)validCol=true;
		}
		return (validRow&&validCol);
	}

	private static boolean cheatCodeEntered(String input){
		return(input.equals(AlexFieldGenerator.cheatCode));
	}
}
