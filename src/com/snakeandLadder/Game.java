package com.snakeandLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Game {
	Board board;
	List<Player> players;

	Game(int size) {
		board = new Board(size);
		players = new ArrayList<>();
	}

	void addPlayer(Player player) {
		players.add(player);
	}

	void start() {
		
		
		boolean gameEnded = false;

		int sum=0;
		
		while (!gameEnded) {
			for (Player player : players) {
				int newPosition = rollDice();
				System.err.println(newPosition);
				sum+=newPosition;
				
				gameEnded = move(board, newPosition,player);
				if (gameEnded) {
					System.out.println(player.name + " wins");
					break;
				}
			}
		}
		System.out.println(sum);
		
	}
	 boolean move(Board board, int number, Player player) {
	        int newPosition = player.position + number;
	        if (newPosition > board.boardSize) {
	            return false;
	        }

	        Cell cell = board.get(newPosition);
	        if (cell.getType().equals("TARGET")) {
	            return true;
	        } else if (cell.getType().equals("SNAKE") || cell.getType().equals("LADDER")) {
	            player.position = cell.getTarget();
	        } else {
	            player.position = newPosition;
	        }
	        return false;
	    }

	int rollDice() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}

}
