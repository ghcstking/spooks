package packageEdwinAndAlex;

import caveExplorer.CaveExplorer;

public class AlexFieldGenerator {

	public AlexFieldGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public static void startGame(boolean [][] board){
		int turnsLeft = 40;
		generateBoard(board);
		printBoard(board);
		CaveExplorer.print("Turns left: "+turnsLeft);
		while(turnsLeft>0){
			CaveExplorer.print("Enter row coordinate.");
			String rowCord = CaveExplorer.in.nextLine();
			CaveExplorer.print("Enter column coordinate.");
			String colCord = CaveExplorer.in.nextLine();
		
		}
	}

	private static void generateBoard(boolean [][] board){
		for(int i = 0; i < 11; i ++){
			int randRow = (int)Math.random()*board.length;
			int randCol = (int)Math.random()*board[0].length;
			
			//while random light is turned off (true is off)
			while(board[randRow][randCol]){
				randRow = (int)Math.random()*board.length;
				randCol = (int)Math.random()*board[0].length;
			}
			board[randRow][randCol] = !board[randRow][randCol];
		}
	//testing	dasda
	}
	
	private static void printBoard(boolean [][] board){
		String boardImage = " ";
		for(int i = 0; i < board[0].length-1;i++){
			boardImage+="____";
		}
		boardImage+="___\n";
		for(boolean[] row : board ){
			for(int i = 0; i < 3; i++){
				String text = "";
				for(boolean light: row){
					text+="|";
					if(i == 0){
						text+="   ";
					}
					else if (i == 1){
						if(light){
							text+="+";
						}
						else{
							text+="-";
						}

					}
					else if (i == 2){
						text+= "___";
					}
				}
				text+="|";
				boardImage+=text+"\n";
			}
		}
		CaveExplorer.print(boardImage);
	}
	
	public static boolean cheatCodeEntered(String input){
		return(input.equals(EventEdwinAndAlex.cheatCode));
	}

}
