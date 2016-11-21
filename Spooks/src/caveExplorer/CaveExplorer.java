package caveExplorer;

import java.util.Scanner;

import alamAndSharon.EventAlamAndSharon;
import jasonAndVicki.EventJasonAndVicki;
import packageEdwinAndAlex.EventEdwinAndAlex;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		caves = new CaveRoom[5][8];
		for (int row = 0; row < caves.length; row++) {
			for (int col = 0; col < caves[row].length; col++) {
				caves[row][col] = new CaveRoom("This cave has coordinates (" + row +", " + col + ").");
			}
		}
		caves[0][2] = new EventRoom("This is the room where the old guy met you", new GameStartEvent());

		caves[2][2] = new EventRoom("This is the room where you were challenged by Asher", new EventEdwinAndAlex());
		caves[1][2] = new EventRoom("You avoid joining the legion of skulls", new EventJasonAndVicki());
//		caves[3][2] = new EventRoom("You've escaped", new EventAlamAndSharon());

		caves[1][2] = new EventRoom("This is the room where you were challenged by Asher", new EventEdwinAndAlex());
		caves[2][2] = new EventRoom("You avoid joining the legion of skulls", new EventJasonAndVicki());
		caves[3][2] = new EventRoom("You've escaped", new EventAlamAndSharon());

		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][1].setConnection(CaveRoom.EAST, caves[0][2], new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH, caves[1][2], new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH, caves[2][2], new Door());
		inventory = new Inventory();
		startExploring(true);
	}
	public static void startExploring(boolean var) { 
		while(var) {
			System.out.print(inventory.getDescription());
			System.out.println(currentRoom.getDescription());
			System.out.println("What would you like to do next?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	public static void print(String string) {
		System.out.println(string);		
	}
}
