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
	
	
	//check to see if item is in room and awards it to player before marking the item as false
	public static void checkForItem(){
		if(SharonInput.playerRow == 0 && SharonInput.playerRow == 4 && invisibilityCloak1){
			invisibilityCloak ++;
			invisibilityCloak1 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerRow == 7 && invisibilityCloak2){
			invisibilityCloak ++;
			invisibilityCloak2 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerRow == 7 && flashlight1){
			flashlight ++;
			flashlight1 = false;
		}
		if(SharonInput.playerRow == 8 && SharonInput.playerRow == 7 && flashlight2){
			flashlight ++;
			flashlight2 = false;
		}
	}
	
	//uses flash light this function prints the map
	
}

