package alamAndSharon;

import caveExplorer.CaveExplorer;

public class AlamAI extends EventAlamAndSharon{
	
	public static boolean ghost1 = true;
	public static boolean ghost2 = true;
	public static boolean ghost3 = true;
	public static boolean ghost4 = true;
	
	private static boolean ghostArray[] = {ghost1,ghost2,ghost3,ghost4};
	
	public static int locationRow1 = 1;
	public static int locationCol1 = 1;
	public static int locationRow2 = 8;
	public static int locationCol2 = 8;
	public static int locationRow3 = 1;
	public static int locationCol3 = 8;
	public static int locationRow4 = 8;
	public static int locationCol4 = 1;
	
	
	public static void begin(){
		// marks down where ghost are in hidden array
		if(ghost1){
			ghostMap[locationRow1][locationCol1] = "1";
		}
		if(ghost2){
			ghostMap[locationRow2][locationCol2] = "2";
		}
		if(ghost3){
			ghostMap[locationRow3][locationCol3] = "3";
		}
		if(ghost4){
			ghostMap[locationRow4][locationCol4] = "4";	
		}
		
		//activates the ghost based on how many are active
	}
	
	public static void moveDaGhost(){
		//Moves each ghost that is true
		String[] keys = {"w","a","s","d"};
		for(int x = 0; x < ghostArray.length; x++){
			int dir = (int) (4 * Math.random());
			String move = keys[dir];
			if(ghostArray[x]){
				if(x == 0){
					ghostMap[locationRow1][locationCol1] = null;
					if(move.equals("w") && locationRow1 > 0 && ghostMap[locationRow1 - 1][locationCol1] == null) locationRow1--;
					else if(move.equals("a") && locationCol1 > 0 && ghostMap[locationRow1][locationCol1 - 1] == null) locationCol1--;
					else if(move.equals("s") && locationRow1 < ghostMap.length-1 && ghostMap[locationRow1 + 1][locationCol1] == null) locationRow1++;
					else if(move.equals("d") && locationCol1 < ghostMap[locationRow1].length-1 && ghostMap[locationRow1][locationCol1 + 1] == null) locationCol1++;
					ghostMap[locationRow1][locationCol1] = "1";
				}
				if(x == 1){
					ghostMap[locationRow2][locationCol2] = null;
					if(move.equals("w") && locationRow2 > 0 && ghostMap[locationRow2 - 1][locationCol2] == null) locationRow2--;
					else if(move.equals("a") && locationCol2 > 0 && ghostMap[locationRow2][locationCol2 - 1] == null) locationCol2--;
					else if(move.equals("s") && locationRow2 < ghostMap.length-1 && ghostMap[locationRow2 + 1][locationCol2] == null) locationRow2++;
					else if(move.equals("d") && locationCol2 < ghostMap[locationRow2].length-1 && ghostMap[locationRow2][locationCol2 + 1] == null) locationCol2++;
					ghostMap[locationRow2][locationCol2] = "2";
				}
				if(x == 2){
					ghostMap[locationRow3][locationCol3] = null;
					if(move.equals("w") && locationRow3 > 0 && ghostMap[locationRow3 - 1][locationCol3] == null) locationRow3--;
					else if(move.equals("a") && locationCol3 > 0 && ghostMap[locationRow3][locationCol3 - 1] == null) locationCol3--;
					else if(move.equals("s") && locationRow3 < ghostMap.length-1 && ghostMap[locationRow3 + 1][locationCol3] == null) locationRow3++;
					else if(move.equals("d") && locationCol3 < ghostMap[locationRow3].length-1 && ghostMap[locationRow3][locationCol3 + 1] == null) locationCol3++;
					ghostMap[locationRow3][locationCol3] = "3";
				}
				if(x == 3){
					ghostMap[locationRow4][locationCol4] = null;
					if(move.equals("w") && locationRow4 > 0 && ghostMap[locationRow4 - 1][locationCol4] == null) locationRow4--;
					else if(move.equals("a") && locationCol4 > 0 && ghostMap[locationRow4][locationCol4 - 1] == null) locationCol4--;
					else if(move.equals("s") && locationRow4 < ghostMap.length-1 && ghostMap[locationRow4 + 1][locationCol4] == null) locationRow4++;
					else if(move.equals("d") && locationCol4 < ghostMap[locationRow4].length-1 && ghostMap[locationRow4][locationCol4 + 1] == null) locationCol4++;
					ghostMap[locationRow4][locationCol4] = "4";
					
				}
			}
		}
	}
	
}
