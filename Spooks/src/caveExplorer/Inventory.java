package caveExplorer;

public class Inventory {

	public static boolean hasMap;
	public static boolean mapBefore = false;

	private String map;
	public static boolean hasKey = false;
	public static boolean encounteredFinalDoor = false;
	public static int keycount = 0;
	public static int exitKey = 0;
	
	
	public Inventory(){
		hasMap = false;
		updateMap();
	}
	
	public void updateMap() {
		map = "  ";
		for(int i = 0; i < CaveExplorer.caves[0].length - 1; i++){
			map += "____"; //4 underscores
		}
		
		map += "___\n";//3 underscores
		
		for(CaveRoom[] row: CaveExplorer.caves){
			
			for(int i = 0; i < 3; i++){
				String text = " ";
				for(CaveRoom cr: row){
					if(cr.getDoor(CaveRoom.WEST) != null 
							&& cr.getDoor(CaveRoom.WEST).isOpen()){
						text += " ";				
					}
					else {
						text += "|";
					}
					if(i == 0){
						text += "   "; // 3 spaces
					}else if(i == 1){
						text += " " + cr.getContents()+ " ";
					}
					else if(i == 2){
						if(cr.getDoor(CaveRoom.SOUTH) != null 
								&& cr.getDoor(CaveRoom.SOUTH).isOpen()){
							text += "   ";
						}
						else{
							text += "___";
						}
					}
				}
				text += "|";
				map += text + "\n";
			}
		}
	}

	public String getDescription() {
		if(encounteredFinalDoor || exitKey < 0){
			encounteredFinalDoor = true;
			CaveExplorer.print("You currently have " + keycount + " room keys and " + exitKey + " final door keys.");
		}
		else if(keycount > 0){
				CaveExplorer.print("You currently have " + keycount + " room keys.");
		}
		
		
		if(hasMap){
			return map;
		}
		else{
			return "There is nothing in your inventory.\n";
		}
		
	}
	
	
	
	public static boolean HasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}
	

	public void setMap(boolean b){
		hasMap = b;
	}
	
}