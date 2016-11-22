package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;

public class AlexFieldGenerator {

	public static boolean [][] board = new boolean [5][5];
	public static String cheatCode = "spookyturkey";
	public static boolean gameWon = false;

	public static boolean startGame(){
		int turnsLeft = 40;
		generateBoard();
		printBoard();
		CaveExplorer.print("Turns left: "+turnsLeft);
		while(turnsLeft>0){
			CaveExplorer.print("Enter row coordinate.");
			String rowCord = CaveExplorer.in.nextLine();
			CaveExplorer.print("Enter column coordinate.");
			String colCord = CaveExplorer.in.nextLine();
			if(EdwinWinConditions.cheatCodeEntered(rowCord)||EdwinWinConditions.cheatCodeEntered(colCord)){
				gameWon = true;
				break;
			}
			else{
				while(!EdwinWinConditions.isValidPoint(Integer.parseInt(rowCord),Integer.parseInt(colCord))){
					CaveExplorer.print("Are you braindead? There's no lightbulb at that point.");
					CaveExplorer.print("Enter row coordinate.");
					rowCord = CaveExplorer.in.nextLine();
					CaveExplorer.print("Enter column coordinate.");
					colCord = CaveExplorer.in.nextLine();
				}
				changeLights(Integer.parseInt(rowCord),Integer.parseInt(colCord));
				if(EdwinWinConditions.isCleared(board)){
					gameWon = true;
					break;
				}
				else{
					turnsLeft--;
					printBoard();
					CaveExplorer.print("Turns left: "+turnsLeft);
				}
			}

		}
		return gameWon;
	}

	private static void generateBoard(){
		int lightsToTurnOff = 12;
		while(lightsToTurnOff>0){
			int randRow = (int)(Math.random()*board.length);
			int randCol = (int)(Math.random()*board[0].length);

			while(board[randRow][randCol]){
				randRow = (int)(Math.random()*board.length);
				randCol = (int)(Math.random()*board[0].length);
			}
			board[randRow][randCol] = !board[randRow][randCol];
			lightsToTurnOff--;
		}
	}
	public static void changeLights(int r, int c) {
		board[r][c] = !board[r][c];
		if(c==0){
			board[r][c+1] = !board[r][c+1];
			if(r==0){
				board[r+1][c] = !board[r+1][c];
			}
			else if(r==board.length-1){
				board[r-1][c] = !board[r-1][c];
			}
			else{
				board[r-1][c] = !board[r-1][c];
				board[r+1][c] = !board[r+1][c];
			}
		}
		else if(c==board[0].length-1){
			board[r][c-1] = !board[r][c-1];
			if(r==0){
				board[r+1][c] = !board[r+1][c];
			}
			else if (r==board.length-1){
				board[r-1][c] = !board[r-1][c];
			}
			else{
				board[r-1][c] = !board[r-1][c];
				board[r+1][c] = !board[r+1][c];
			}
		}
		else if (r==0){
			board[r+1][c] = !board[r+1][c];
			if(c==0){
				board[r][c+1] = !board[r][c+1];
			}
			else if (c==board[0].length-1){
				board[r][c-1] = !board[r][c-1];
			}
			else{
				board[r][c+1] = !board[r][c+1];
				board[r][c-1] = !board[r][c-1];
			}
		}
		else if (r==board.length-1){
			board[r-1][c] = !board[r-1][c];
			if(c==0){
				board[r][c+1] = !board[r][c+1];
			}
			else if (c==board[0].length-1){
				board[r][c-1] = !board[r][c-1];
			}
			else{
				board[r][c+1] = !board[r][c+1];
				board[r][c-1] = !board[r][c-1];
			}
		}
		else{
			board[r-1][c] = !board[r-1][c];
			board[r+1][c] = !board[r+1][c];
			board[r][c+1] = !board[r][c+1];
			board[r][c-1] = !board[r][c-1];

		}

	}
	private static void printBoard(){
		String boardImage = " ";
		for(int i = 0; i < board[0].length-1;i++){
			boardImage+="____";
		}
		boardImage+="___\n";
		for(boolean[] row : board ){
			for(int i = 0; i < 3; i ++){
				String text = "";
				for(boolean lightOff : row){
					text += "|";
					if(i == 0){
						text+="   ";
					}
					else if (i == 1){
						if(lightOff){
							text+=" - ";
						}
						else{
							text+=" O ";
						}
					}
					else if (i == 2){
						text+="___";
					}
				}
				text+="|";
				boardImage+=text+"\n";
			}
		}
		CaveExplorer.print(boardImage);
	}

}
