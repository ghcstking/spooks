package alamAndSharon;

import caveExplorer.CaveExplorer;

public class AlamAI extends EventAlamAndSharon{
	
	public static boolean ghost1 = true;
	public static boolean ghost2 = true;
	public static boolean ghost3 = true;
	public static boolean ghost4 = true;
	
	public static boolean ghostArray[] = {ghost1,ghost2,ghost3,ghost4};
	
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
				//System.out.println("ghost " + (x+1) + " is :" + keys[dir]);
			String move = keys[dir];
			if(ghostArray[x]){
				//move ghost 1
				if(x == 0){
					//System.out.println("ghost 1 location value was:" + ghostMap[locationRow1][locationCol1] + " Row: " + locationRow1 + " Col: " + locationCol1);
					ghostMap[locationRow1][locationCol1] = null;
					if(move == "w" || move == "s"){
						locationRow1 = moveCoord(move, locationRow1);
					}
					if(move == "a" || move == "d"){
						locationCol1 = moveCoord(move, locationCol1);
					}
					ghostMap[locationRow1][locationCol1] = "1";
					//System.out.println("ghost 1 location value is:" + ghostMap[locationRow1][locationCol1] + " Row: " + locationRow1 + " Col: " + locationCol1);
				}
				//move ghost 2
				if(x == 1){
					//System.out.println("ghost 2 location value was:" + ghostMap[locationRow2][locationCol2] + " Row: " + locationRow2 + " Col: " + locationCol2);
					ghostMap[locationRow2][locationCol2] = null;
					if(move == "w" || move == "s"){
						locationRow2 = moveCoord(move, locationRow2);
					}
					if(move == "a" || move == "d"){
						locationCol2 = moveCoord(move, locationCol2);
					}
					ghostMap[locationRow2][locationCol2] = "2";
					//System.out.println("ghost 2 location value is:" + ghostMap[locationRow2][locationCol2] + " Row: " + locationRow2 + " Col: " + locationCol2);
				}
				// move ghost 3
				if(x == 2){
					//System.out.println("ghost 3 location value was:" + ghostMap[locationRow3][locationCol3] + " Row: " + locationRow3 + " Col: " + locationCol3);
					ghostMap[locationRow3][locationCol3] = null;
					if(move == "w" || move == "s"){
						locationRow3 = moveCoord(move, locationRow3);
					}
					if(move == "a" || move == "d"){
						locationCol3 = moveCoord(move, locationCol3);
					}
					ghostMap[locationRow3][locationCol3] = "3";
					//System.out.println("ghost 3 location value is:" + ghostMap[locationRow3][locationCol3] + " Row: " + locationRow3 + " Col: " + locationCol3);
				}
				//move ghost 4
				if(x == 3){
					//System.out.println("ghost 4 location value was:" + ghostMap[locationRow4][locationCol4] + " Row: " + locationRow4 + " Col: " + locationCol4);
					ghostMap[locationRow4][locationCol4] = null;
					if(move == "w" || move == "s"){
						locationRow4 = moveCoord(move, locationRow4);
					}
					if(move == "a" || move == "d"){
						locationCol4 = moveCoord(move, locationCol4);
					}
					ghostMap[locationRow4][locationCol4] = "4";
					//System.out.println("ghost 4 location value is:" + ghostMap[locationRow4][locationCol4] + " Row: " + locationRow4 + " Col: " + locationCol4);
				}
				
			}
		}
	}

	private static int moveCoord(String move, int location) {
		if((move.equals("s") || move.equals("a")) && location > 0){
			location--;
		}
		if((move.equals("w") || move.equals("d")) && location < ghostMap.length-1){
			location++;
		}
		return location;
	}
	
}
