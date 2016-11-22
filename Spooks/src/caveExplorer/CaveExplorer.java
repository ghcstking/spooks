package caveExplorer;

import java.util.Arrays;
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
		caves[2][2] = new EventRoom("You avoid joining the legion of skulls", new EventJasonAndVicki());
		caves[3][2] = new EventRoom("You've escaped", new EventAlamAndSharon());
		caves[2][2] = new EventRoom("This is the room where you were challenged by Asher", new EventEdwinAndAlex());
		caves[0][7] = new EventRoom("This is where you found the black egg, but never took it. \n It disappeared mysteriously.", new Egg());
		

		currentRoom = caves[0][1];
		currentRoom.enter();
		caves[0][0].setConnection(CaveRoom.EAST, caves[0][1], new Door());
		caves[0][0].setConnection(CaveRoom.SOUTH, caves[1][0], new Door());
		caves[0][1].setConnection(CaveRoom.EAST, caves[0][2], new Door());
		caves[0][1].setConnection(CaveRoom.SOUTH, caves[1][1], new Door());
		caves[0][2].setConnection(CaveRoom.EAST, caves[0][3], new Door());
		caves[0][2].setConnection(CaveRoom.SOUTH, caves[1][2], new Door());
		caves[0][3].setConnection(CaveRoom.EAST, caves[0][4], new Door());
		caves[0][3].setConnection(CaveRoom.SOUTH, caves[1][3], new Door());
		caves[0][4].setConnection(CaveRoom.EAST, caves[0][5], new Door());
		caves[0][4].setConnection(CaveRoom.SOUTH, caves[1][4], new Door());
		caves[0][5].setConnection(CaveRoom.EAST, caves[0][6], new Door());
		caves[0][5].setConnection(CaveRoom.SOUTH, caves[1][5], new Door());
		caves[0][6].setConnection(CaveRoom.EAST, caves[0][7], new Door());
		caves[0][6].setConnection(CaveRoom.SOUTH, caves[1][6], new Door());
		caves[0][7].setConnection(CaveRoom.SOUTH, caves[1][7], new Door());
		caves[1][0].setConnection(CaveRoom.EAST, caves[1][1], new Door());
		caves[1][0].setConnection(CaveRoom.SOUTH, caves[2][0], new Door());
		caves[1][1].setConnection(CaveRoom.EAST, caves[1][2], new Door());
		caves[1][1].setConnection(CaveRoom.SOUTH, caves[2][1], new Door());
		caves[1][2].setConnection(CaveRoom.EAST, caves[1][3], new Door());
		caves[1][2].setConnection(CaveRoom.SOUTH, caves[2][2], new Door());
		caves[1][3].setConnection(CaveRoom.EAST, caves[1][4], new Door());
		caves[1][3].setConnection(CaveRoom.SOUTH, caves[2][3], new Door());
		caves[1][4].setConnection(CaveRoom.EAST, caves[1][5], new Door());
		caves[1][4].setConnection(CaveRoom.SOUTH, caves[2][4], new Door());
		caves[1][5].setConnection(CaveRoom.EAST, caves[1][6], new Door());
		caves[1][5].setConnection(CaveRoom.SOUTH, caves[2][5], new Door());
		caves[1][6].setConnection(CaveRoom.EAST, caves[1][7], new Door());
		caves[1][6].setConnection(CaveRoom.SOUTH, caves[2][6], new Door());
		caves[1][7].setConnection(CaveRoom.SOUTH, caves[2][7], new Door());
		caves[2][0].setConnection(CaveRoom.EAST, caves[2][1], new Door());
		caves[2][0].setConnection(CaveRoom.SOUTH, caves[3][0], new Door());
		caves[2][1].setConnection(CaveRoom.EAST, caves[2][2], new Door());
		caves[2][1].setConnection(CaveRoom.SOUTH, caves[3][1], new Door());
		caves[2][2].setConnection(CaveRoom.EAST, caves[2][3], new Door());
		caves[2][2].setConnection(CaveRoom.SOUTH, caves[3][2], new Door());
		caves[2][3].setConnection(CaveRoom.EAST, caves[2][4], new Door());
		caves[2][3].setConnection(CaveRoom.SOUTH, caves[3][3], new Door());
		caves[2][4].setConnection(CaveRoom.EAST, caves[2][5], new Door());
		caves[2][4].setConnection(CaveRoom.SOUTH, caves[3][4], new Door());
		caves[2][5].setConnection(CaveRoom.EAST, caves[2][6], new Door());
		caves[2][5].setConnection(CaveRoom.SOUTH, caves[3][5], new Door());
		caves[2][6].setConnection(CaveRoom.EAST, caves[2][7], new Door());
		caves[2][6].setConnection(CaveRoom.SOUTH, caves[3][6], new Door());
		caves[2][7].setConnection(CaveRoom.SOUTH, caves[3][7], new Door());
		caves[3][0].setConnection(CaveRoom.EAST, caves[3][1], new Door());
		caves[3][0].setConnection(CaveRoom.SOUTH, caves[4][0], new Door());
		caves[3][1].setConnection(CaveRoom.EAST, caves[3][2], new Door());
		caves[3][1].setConnection(CaveRoom.SOUTH, caves[4][1], new Door());
		caves[3][2].setConnection(CaveRoom.EAST, caves[3][3], new Door());
		caves[3][2].setConnection(CaveRoom.SOUTH, caves[4][2], new Door());
		caves[3][3].setConnection(CaveRoom.EAST, caves[3][4], new Door());
		caves[3][3].setConnection(CaveRoom.SOUTH, caves[4][3], new Door());
		caves[3][4].setConnection(CaveRoom.EAST, caves[3][5], new Door());
		caves[3][4].setConnection(CaveRoom.SOUTH, caves[4][4], new Door());
		caves[3][5].setConnection(CaveRoom.EAST, caves[3][6], new Door());
		caves[3][5].setConnection(CaveRoom.SOUTH, caves[4][5], new Door());
		caves[3][6].setConnection(CaveRoom.EAST, caves[3][7], new Door());
		caves[3][6].setConnection(CaveRoom.SOUTH, caves[4][6], new Door());
		caves[3][7].setConnection(CaveRoom.SOUTH, caves[4][7], new Door());
		caves[4][0].setConnection(CaveRoom.EAST, caves[4][1], new Door());
		caves[4][1].setConnection(CaveRoom.EAST, caves[4][2], new Door());
		caves[4][2].setConnection(CaveRoom.EAST, caves[4][3], new Door());
		caves[4][3].setConnection(CaveRoom.EAST, caves[4][4], new Door());
		caves[4][4].setConnection(CaveRoom.EAST, caves[4][5], new Door());
		caves[4][5].setConnection(CaveRoom.EAST, caves[4][6], new Door());
		caves[4][6].setConnection(CaveRoom.EAST, caves[4][7], new Door());
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
