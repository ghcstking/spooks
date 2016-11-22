package alamAndSharon;


import caveExplorer.CaveExplorer;

// Code by Alam
public class Items extends EventAlamAndSharon{
	//checks to see how many turns are available
	public static int turns = 10;
	
	//items player can have
	public static int invisibilityCloak = 0;
	public static int flashlight = 0;
	
	//checks to see if the are available
	public static boolean invisibilityCloak1 = true;
	public static boolean invisibilityCloak2 = true;
	public static boolean flashlight1 = true;
	public static boolean flashlight2 = true;
	
	//adds map for player
	public static boolean cheatMap = false;
	
	//check to see if item is in room and awards it to player before marking the item as false
	public static void checkForItem(){
		if(SharonInput.playerRow == 0 && SharonInput.playerCol == 4 && invisibilityCloak1){
			invisibilityCloak ++;
			invisibilityCloak1 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol == 7 && invisibilityCloak2){
			invisibilityCloak ++;
			invisibilityCloak2 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol== 7 && flashlight1){
			flashlight ++;
			flashlight1 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol == 7 && flashlight2){
			flashlight ++;
			flashlight2 = false;
		}
	}
	
	//uses flash light this function prints the map
	public static void useFlashLight(String[][] pic){
		if(flashlight > 0){
			for(int y = 0; y < pic.length; y++){
				for(int x = 0; x < pic[y].length; x++){
					if(y == SharonInput.playerRow && x == SharonInput.playerCol){
						pic[y][x] = "|X|";
					}else if((AlamAI.ghost1 && (y == AlamAI.locationRow1 && x == AlamAI.locationCol1)) ||
							 (AlamAI.ghost2 && (y == AlamAI.locationRow2 && x == AlamAI.locationCol2)) ||
							 (AlamAI.ghost3 && (y == AlamAI.locationRow3 && x == AlamAI.locationCol3)) ||
							 (AlamAI.ghost4 && (y == AlamAI.locationRow4 && x == AlamAI.locationCol4))
							){
						pic[y][x] = "|O|";	
					}else{
						pic[y][x] = "|_|";						
					}
					System.out.print(pic[y][x]);
				}
				System.out.println();	
			}
			System.out.println("You get scared and pull out your flashlight");
			System.out.println("You are the X and the O are the Trumplings");
			System.out.println("You have lost a flash light");
			flashlight --;
		}
	}
	//check to see if ghost are near by
	public static void sensor(){
		int sensor = 0;
		if(AlamAI.ghost1 && (AlamAI.locationRow1 >= SharonInput.playerRow-1 && AlamAI.locationRow1 <= SharonInput.playerRow+1)){
			if(AlamAI.locationCol1 >= SharonInput.playerCol-1 && AlamAI.locationCol1 <= SharonInput.playerCol+1){
				sensor++;
			}
		}
		if(AlamAI.ghost2 && (AlamAI.locationRow2 >= SharonInput.playerRow-1 && AlamAI.locationRow2 <= SharonInput.playerRow+1)){
			if(AlamAI.locationCol2 >= SharonInput.playerCol-1 && AlamAI.locationCol2 <= SharonInput.playerCol+1){
				sensor++;
			}
		}
		if(AlamAI.ghost3 && (AlamAI.locationRow3 >= SharonInput.playerRow-1 && AlamAI.locationRow3 <= SharonInput.playerRow+1)){
			if(AlamAI.locationCol3 >= SharonInput.playerCol-1 && AlamAI.locationCol3 <= SharonInput.playerCol+1){
				sensor++;
			}
		}
		if(AlamAI.ghost4 && (AlamAI.locationRow4 >= SharonInput.playerRow-1 && AlamAI.locationRow4 <= SharonInput.playerRow+1)){
			if(AlamAI.locationCol4 >= SharonInput.playerCol-1 && AlamAI.locationCol4 <= SharonInput.playerCol+1){
				sensor++;
			}
		}
		//check to see if flash light is needed
		if(sensor == 1 || sensor == 2){
			System.out.println("You feel something is lurking nearby");
			useFlashLight(ghostMap);
		}
		if(sensor >= 3){
			System.out.println("You feel surrounded");
			useFlashLight(ghostMap);
		}
	}
	public static void cheatCodes(int cheat){
		turns ++;
		if(cheat == 1){
			turns = 0;
			System.out.println("Your game will end next turn ... \n hopefully a ghost hits you >:( \n cheater");
		}else if(cheat == 2){
			invisibilityCloak = 10;
		}else if(cheat == 3){
			flashlight = 10;
		}else if(cheat == 4){
			cheatMap = true;
		}
	}
	
	public static void cheatMap(String[][] pic){
		for(int y = 0; y < pic.length; y++){
			for(int x = 0; x < pic[y].length; x++){
				if(y == SharonInput.playerRow && x == SharonInput.playerCol){
					pic[y][x] = "|X|";
				}else if((AlamAI.ghost1 && (y == AlamAI.locationRow1 && x == AlamAI.locationCol1)) ||
						 (AlamAI.ghost2 && (y == AlamAI.locationRow2 && x == AlamAI.locationCol2)) ||
						 (AlamAI.ghost3 && (y == AlamAI.locationRow3 && x == AlamAI.locationCol3)) ||
						 (AlamAI.ghost4 && (y == AlamAI.locationRow4 && x == AlamAI.locationCol4))
						){
					pic[y][x] = "|O|";	
				}else{
					pic[y][x] = "|_|";						
				}
				System.out.print(pic[y][x]);
			}
			System.out.println();	
		}
	}
}

