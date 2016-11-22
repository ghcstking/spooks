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


	public static boolean isValidPoint(String rowCord, String colCord){
		boolean validRow = false;
		boolean validCol = false;
		try{
			Integer.parseInt(rowCord);
			
		}
		catch(NumberFormatException e){
			return false;
		}
		try{
			Integer.parseInt(colCord);
			
		}
		catch(NumberFormatException e){
			return false;
		}

		int ro = Integer.parseInt(rowCord);
		int co = Integer.parseInt(colCord);
		for(int r = 0; r < AlexFieldGenerator.board.length;r++){
			if(ro==r)validRow=true;
		}
		for(int c = 0; c < AlexFieldGenerator.board[0].length;c++){
			if(co==c)validCol=true;
		}
		return (validRow&&validCol);
	}

	public static boolean cheatCodeEntered(String input){
		return(input.equals(AlexFieldGenerator.cheatCode));
	}
}
