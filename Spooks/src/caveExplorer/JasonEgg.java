package caveExplorer;

public class JasonEgg implements Event {
	
	public static String answer;

	public static final String[] SEQ = {
    		"Opening the door to this dead end, you enter a relatively messy room.",
    		"It seems like it was a dining room of sorts...",
            "The chairs are broken, the table crooked, and the curtains rotten",
            "However, on the dusty crooked table, there sits an black oval",
            "Upon closer inspection, you realize its an egg.",
            "An black egg? That's very strange...",
            "Besides, why is there a perfect,intact egg in this haunted house anyways?",
            "Who knows, perhaps this bizarre egg will prove useful in your exploration of this house..."
    };
	
	public static final String[] SEQ2 = {
    		"Once you put the egg inside your bag, the world warps.",
    		"The floor crumbles underneath you, and you fall into a void.",
            "You keep falling until you land harshly on your back.",
            "You struggle to return on your feet.",
            "You look all around you, and its all pitch black.",
            "The egg is brought out from your pocket, and suddenly, it starts crack!",
            "The cracking continues suspensefully, until theres just only a bit left to crack.",
            "However...,", 
            "THE EGG TALKS!",
            "'Yooooo, what's up my eggo broooooo' ",
            "'What's crackingggggg?",
            "'Wait, why are you looking at me with such a bad egg-spression?'",
            "'Yo I'm an talking egg bro how many talkings do you see in a lifetime? Hm? TELL ME. '",
            "'I wonder if  you're starting to get the hen-g of my jokes!'",
            "'But like ya know...being a talking egg is tough work you don't even know...blah blah blah blah blah..'",
            "This egg just keeps blubbering on an on, but then you realized: you pick up an Egg-cellent Pun Egg",
            "Now you're doomed to listen to horrible egg puns in this void for eternity..."
    };
	
	public void play() {
		 readSequence(SEQ);
         CaveExplorer.print("- - - - - - - Take the Black Egg? - - - - - - -");
         answer = CaveExplorer.in.nextLine();
         if(answer.toLowerCase() == "yes"){
             CaveExplorer.inventory.setMap(false);
             CaveExplorer.startExploring(false);
             readSequence(SEQ2);
             CaveExplorer.print("- - - - - - - You Died. - - - - - - -");
         }
         else{
        	 CaveExplorer.print("Your gut tells you to leave the egg alone.\n You place it back where you found it.");
         }
         
	}
	
	public static void readSequence(String[] seq) {
		for (int i = 0; i < seq.length; i++) {
			CaveExplorer.print(seq[i]);
            CaveExplorer.print(" - - - Press enter - - - ");
            CaveExplorer.in.nextLine();
        }
    }

}
