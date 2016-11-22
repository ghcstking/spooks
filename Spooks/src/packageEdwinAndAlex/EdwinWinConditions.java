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

	public static void changeBoard(String rowCord,String colCord){
//		if(cheatCodeEntered(rowCord)||(cheatCodeEntered(colCord))){
//			
//		}
			int r = Integer.parseInt(rowCord);
			int c = Integer.parseInt(colCord);
			while(!isValidPoint(r,c)){
				CaveExplorer.print("Are you braindead? There's no lightbulb at that point.");
				CaveExplorer.print("Enter row coordinate.");
				r = Integer.parseInt(CaveExplorer.in.nextLine());
				CaveExplorer.print("Enter column coordinate.");
				c = Integer.parseInt(CaveExplorer.in.nextLine());
			}
			changeLights(r,c);
		}

	private static void changeLights(int r, int c) {
		// TODO Auto-generated method stub
		//have to first establish special cases
		AlexFieldGenerator.board[r][c] = !AlexFieldGenerator.board[r][c];
		if(c==0){
			AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
			if(r==0){
				AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			}
			else if(r==AlexFieldGenerator.board.length-1){
				AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
			}
			else{
				AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
				AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			}
		}
		else if(c==AlexFieldGenerator.board[0].length-1){
			AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			if(r==0){
				AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			}
			else if (r==AlexFieldGenerator.board.length-1){
				AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
			}
			else{
				AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
				AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			}
		}
		else if (r==0){
			AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			if(c==0){
				AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
			}
			else if (c==AlexFieldGenerator.board[0].length-1){
				AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			}
			else{
				AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
				AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			}
		}
		else if (r==AlexFieldGenerator.board.length-1){
			AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
			if(c==0){
				AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
			}
			else if (c==AlexFieldGenerator.board[0].length-1){
				AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			}
			else{
				AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
				AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			}
		}
		else{
			AlexFieldGenerator.board[r-1][c] = !AlexFieldGenerator.board[r-1][c];
			AlexFieldGenerator.board[r+1][c] = !AlexFieldGenerator.board[r+1][c];
			AlexFieldGenerator.board[r][c+1] = !AlexFieldGenerator.board[r][c+1];
			AlexFieldGenerator.board[r][c-1] = !AlexFieldGenerator.board[r][c-1];
			
		}

	}

	private static boolean isValidPoint(int rowCord, int colCord){
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

	private static boolean cheatCodeEntered(String input){
		return(input.equals(AlexFieldGenerator.cheatCode));
	}
}
