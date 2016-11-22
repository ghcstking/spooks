package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;

public class EdwinWinConditions {

	public EdwinWinConditions() {
		// TODO Auto-generated constructor stubsdasd
	}

	public static boolean isCleared(boolean [][] board){
		for(boolean [] row: board){
			for(boolean lightOff:row){
				if(!lightOff){
					return false;
				}
			}
		}
		return true;
	}


	public static boolean isValidPoint(int rowCord, int colCord){
		boolean validRow = false;
		boolean validCol = false;
		for(int r = 0; r < AlexFieldGenerator.board.length-1;r++){
			if(rowCord==r)validRow=true;
		}
		for(int c = 0; c < AlexFieldGenerator.board[0].length-1;c++){
			if(colCord==c)validCol=true;
		}
		return (validRow&&validCol);
	}

	public static boolean cheatCodeEntered(String input){
		return(input.equals(AlexFieldGenerator.cheatCode));
	}
}
