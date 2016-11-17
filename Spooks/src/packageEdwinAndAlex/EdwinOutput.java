package packageEdwinAndAlex;

public class EdwinOutput {

	public EdwinOutput() {
		// TODO Auto-generated constructor stub
	}
	public static void printBoard(String [][] boardImage,boolean [][] board){
		for(int row = 0; row < board.length;row++){
			if(row%2==0){
				for(int col = 0; col < board[row].length;col++){
					boardImage[row][col] = "_";
					if(row!=0&&col%2==0){
						boardImage[row][col] = "|";
					}
				}
			}
			else{
				for(int col = 0; col < board[row].length;col++){
					if(col%2==0){
						boardImage[row][col] = "|";
					}
					else if (board[(row-1)/2][(col-1)/2]){
						boardImage[row][col] = "+";
					}
					else{
						boardImage[row][col] = "-";
					}
				}
			}

		}
		printPic(boardImage);
	}

	private static void printPic(String[][] arr) {
		for(String[] a : arr){
			for( String b: a){
				System.out.print(b);
			}
			System.out.println();
		}
	}
	
}
