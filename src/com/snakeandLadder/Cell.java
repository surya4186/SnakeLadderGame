package com.snakeandLadder;

class Cell {
    private int position;
    private String type;
    private int target;

    Cell(int position, String type) {
        this.position = position;
        this.type = type;
    }

    Cell(int position, String type, int target) {
        this.position = position;
        this.type = type;
        this.target = target;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}
}
