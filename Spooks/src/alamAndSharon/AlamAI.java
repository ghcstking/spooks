package alamAndSharon;

import caveExplorer.CaveExplorer;

public class AlamAI extends EventAlamAndSharon{
	
	public static boolean ghost1 = true;
	public static boolean ghost2 = true;
	public static boolean ghost3 = false;
	public static boolean ghost4 = true;
	
	private static boolean ghostArray[] = {ghost1,ghost2,ghost3,ghost4};
	
	public static int locationCol1 = 1;
	public static int locationRow1 = 1;
	public static int locationCol2 = 8;
	public static int locationRow2 = 8;
	public static int locationCol3 = 1;
	public static int locationRow3 = 8;
	public static int locationCol4 = 8;
	public static int locationRow4 = 1;
	
	
	public static void begin(){
		if(ghost1){
			ghostMap[locationCol1][locationRow1] = "1";
		}
		if(ghost2){
			ghostMap[locationCol2][locationRow2] = "2";
		}
		if(ghost3){
			ghostMap[locationCol3][locationRow3] = "3";
		}
		if(ghost4){
			ghostMap[locationCol4][locationRow4] = "4";	
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
					ghostMap[locationCol1][locationRow1] = null;
					if(move.equals("w") && locationCol1 > 0 && ghostMap[locationCol1 - 1][locationRow1] == null) locationCol1--;
					else if(move.equals("a") && locationRow1 > 0 && ghostMap[locationCol1][locationRow1 - 1] == null) locationRow1--;
					else if(move.equals("s") && locationCol1 < ghostMap.length-1 && ghostMap[locationCol1 + 1][locationRow1] == null) locationCol1++;
					else if(move.equals("d") && locationRow1 < ghostMap[locationCol1].length-1 && ghostMap[locationCol1][locationRow1 + 1] == null) locationRow1++;
					ghostMap[locationCol1][locationRow1] = "1";
				}
				if(x == 1){
					ghostMap[locationCol2][locationRow2] = null;
					if(move.equals("w") && locationCol2 > 0 && ghostMap[locationCol2 - 1][locationRow2] == null) locationCol2--;
					else if(move.equals("a") && locationRow2 > 0 && ghostMap[locationCol2][locationRow2 - 1] == null) locationRow2--;
					else if(move.equals("s") && locationCol2 < ghostMap.length-1 && ghostMap[locationCol2 + 1][locationRow2] == null) locationCol2++;
					else if(move.equals("d") && locationRow2 < ghostMap[locationCol2].length-1 && ghostMap[locationCol2][locationRow2 + 1] == null) locationRow2++;
					ghostMap[locationCol2][locationRow2] = "2";
				}
				if(x == 2){
					ghostMap[locationCol3][locationRow3] = null;
					if(move.equals("w") && locationCol3 > 0 && ghostMap[locationCol3 - 1][locationRow3] == null) locationCol3--;
					else if(move.equals("a") && locationRow3 > 0 && ghostMap[locationCol3][locationRow3 - 1] == null) locationRow3--;
					else if(move.equals("s") && locationCol3 < ghostMap.length-1 && ghostMap[locationCol3 + 1][locationRow3] == null) locationCol3++;
					else if(move.equals("d") && locationRow3 < ghostMap[locationCol3].length-1 && ghostMap[locationCol3][locationRow3 + 1] == null) locationRow3++;
					ghostMap[locationCol3][locationRow3] = "3";
				}
				if(x == 3){
					ghostMap[locationCol4][locationRow4] = null;
					if(move.equals("w") && locationCol4 > 0 && ghostMap[locationCol4 - 1][locationRow4] == null) locationCol4--;
					else if(move.equals("a") && locationRow4 > 0 && ghostMap[locationCol4][locationRow4 - 1] == null) locationRow4--;
					else if(move.equals("s") && locationCol4 < ghostMap.length-1 && ghostMap[locationCol4 + 1][locationRow4] == null) locationCol4++;
					else if(move.equals("d") && locationRow4 < ghostMap[locationCol4].length-1 && ghostMap[locationCol4][locationRow4 + 1] == null) locationRow4++;
					ghostMap[locationCol4][locationRow4] = "4";
					
				}
			}
		}
	}
	
	
	
}
