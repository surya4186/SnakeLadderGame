package com.snakeandLadder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the board size");
		int size=scan.nextInt();
		Game game = new Game(size);
		
		System.out.println("Enter the no of players");
		int playerCount=scan.nextInt();
		for(int i=0;i<playerCount;i++) {
			System.out.println("Enter the player name");
			String name=scan.next();
			game.addPlayer(new Player(name));
		}
		
		game.start();

	}

}
