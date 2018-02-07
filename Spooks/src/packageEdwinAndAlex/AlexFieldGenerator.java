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
			CaveExplorer.print("Enter coordinates in (a,b) format.");
			String coord = CaveExplorer.in.nextLine();
			if(EdwinWinConditions.cheatCodeEntered(coord)){
				gameWon = true;
				break;
			}
			while(coord.length()!=5){
				CaveExplorer.print("Are you braindead? There's no lightbulb at that point.");
				CaveExplorer.print("Enter coordinates in (a,b) format.");
				coord = CaveExplorer.in.nextLine();
			}
			while(!EdwinWinConditions.isValidPoint(coord.substring(1, 2),coord.substring(3, 4))){
				CaveExplorer.print("Are you braindead? There's no lightbulb at that point.");
				CaveExplorer.print("Enter coordinates in (a,b) format.");
				coord = CaveExplorer.in.nextLine();
			}
			EdwinWinConditions.changeLights(Integer.parseInt(coord.substring(1, 2)),Integer.parseInt(coord.substring(3, 4)));
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
