package com.snakeandLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Board {
	public int boardSize;
	private Map<Integer, Cell> cells;

	Board(int size) {
		boardSize = size;
		cells = new HashMap<>();
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 1; i <= boardSize; i++) {
			cells.put(i, new Cell(i, "NORMAL"));
		}

		cells.put(boardSize, new Cell(boardSize, "TARGET"));
		Scanner scan = new Scanner(System.in);
		System.out.println("enter snake count");
		int snake = scan.nextInt();
		for (int i = 0; i < snake; i++) {
			System.out.println("Enter the head:");
			int head = scan.nextInt();
			System.out.println("Enter the tail:");
			int tail = scan.nextInt();
			addSnake(head, tail);

		}
		System.out.println("enter ladder count");
		int ladder = scan.nextInt();

		for (int i = 0; i < ladder; i++) {
			System.out.println("Enter the start:");
			int start = scan.nextInt();
			System.out.println("Enter the end:");
			int end = scan.nextInt();
			addLadder(start, end);

		}

	}

	void addSnake(int start, int end) {
//        validateCellRange(start, end);
		cells.put(start, new Cell(start, "SNAKE", end));
	}

	void addLadder(int start, int end) {
//        validateCellRange(start, end);
		cells.put(start, new Cell(start, "LADDER", end));
	}

	private void validateCellRange(int start, int end) {
		if (start < 1 || end > boardSize || start >= end) {
			throw new IllegalArgumentException("Invalid snake or ladder position");
		}
	}

	Cell get(int position) {
		return cells.get(position);
	}
}
