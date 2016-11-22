package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;

public class AlexFieldGenerator {

	public static boolean [][] board = new boolean [5][5];
	public static String cheatCode = "spookyturkey";
	public boolean gameWon;

	public static void startGame(){
		int turnsLeft = 40;
		generateBoard();
		printBoard();
		CaveExplorer.print("Turns left: "+turnsLeft);
		while(turnsLeft>0){
			CaveExplorer.print("Enter row coordinate.");
			String rowCord = CaveExplorer.in.nextLine();
			CaveExplorer.print("Enter column coordinate.");
			String colCord = CaveExplorer.in.nextLine();
			EdwinWinConditions.changeBoard(rowCord,colCord);
			if(EdwinWinConditions.isCleared(board)){
				
			}
		}
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
