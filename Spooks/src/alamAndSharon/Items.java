package alamAndSharon;


import caveExplorer.CaveExplorer;

// Code by Alam
public class Items extends EventAlamAndSharon{
	//checks to see how many turns are available
	public static int turns = 20;
	
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
			System.out.println("you found a cloak");
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol == 7 && invisibilityCloak2){
			invisibilityCloak ++;
			invisibilityCloak2 = false;
			System.out.println("you found a cloak");
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol== 7 && flashlight1){
			flashlight ++;
			flashlight1 = false;
			System.out.println("you found a flash");
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerCol == 7 && flashlight2){
			flashlight ++;
			flashlight2 = false;
			System.out.println("you found a flash");
		}
	}
	
	//uses flash light and calls print map
	public static void useFlashLight(){
		if(flashlight > 0 && cheatMap == false){
			//calls map printer
			printDaMap();
			System.out.println("You get scared and pull out your flashlight");
			System.out.println("You have lost a flash light");
			flashlight --;
		}
	}
	//prints map
	private static void printDaMap(){
		String pic[][] = ghostMap;
		for(int y = ghostMap.length-1; y >= 0; y--){
			for(int x = 0; x < ghostMap[y].length; x++){
				if(ghostMap[y][x] == "player"){
					pic[y][x] = " X ";
				}else if(ghostMap[y][x] == "1" || 
						 ghostMap[y][x] == "2" || 
						 ghostMap[y][x] == "3" || 
						 ghostMap[y][x] == "4"){
					pic[y][x] = " O ";	
				}else{
					pic[y][x] = "   ";						
				}
				System.out.print(pic[y][x]);
			}
			System.out.println();	
		}
		// fail safe for global being changed
		for(int i = ghostMap.length-1; i >= 0; i--){
			for(int j = 0; j < ghostMap[i].length; j++){
				ghostMap[i][j] = null;
			}
		}
		
		System.out.println("You are the X and the O are the Ghost");
		
	}

	//check to see if ghost are near by
	public static void sensor(){
		String ints[] ={"1","2","3","4"};
		int sensorGhost = 0;
		//System.out.println("method runs");
		for(int x = 0; x<4; x++){
			if (AlamAI.ghostArray[x]){
				String xString = ints[x];
				if((SharonInput.playerRow-1 >= 0 && ghostMap[SharonInput.playerRow-1][SharonInput.playerCol] == xString) || 
				   (SharonInput.playerRow+1 < ghostMap.length && ghostMap[SharonInput.playerRow+1][SharonInput.playerCol] == xString) ||
				   (SharonInput.playerCol-1 >= 0 && ghostMap[SharonInput.playerRow][SharonInput.playerCol-1] == xString) ||
				   (SharonInput.playerCol+1 < ghostMap[SharonInput.playerRow].length) && ghostMap[SharonInput.playerRow][SharonInput.playerCol+1] == xString){
					sensorGhost++;
				}
			}
		}
		//check to see if flash light is needed
		if(sensorGhost == 1 || sensorGhost == 2){
			System.out.println("You feel something is lurking nearby");
			useFlashLight();
		}
		if(sensorGhost >= 3){
			System.out.println("You feel surrounded");
			useFlashLight();
		}
	}
	// cheat code activator
	public static void cheatCodes(int cheat){
		turns ++;
		if(cheat == 1){
			turns = 0;
			System.out.println("Your is now over ... \n  >:( cheater");
		}else if(cheat == 2){
			invisibilityCloak += 10;
			System.out.println("You gave yourself 10 invisibliity cloaks \n Sooner or later you'll run out");
		}else if(cheat == 3){
			flashlight += 10;
			System.out.println("You gave yourself 10 flashlights \n Oh so you're scared huh?");
		}else if(cheat == 4){
			cheatMap = true;
			System.out.println("You gave yourself a map \n I hate cheaters just play the game >:(");
		}
	}
	//Calls every round if cheat code is active then player can see the map
	public static void cheatMap() {
		if(cheatMap){
			printDaMap();
			System.out.println("You get scared and pull out your perma flashlight");
		}
	}
}



