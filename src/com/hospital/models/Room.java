package com.hospital.models;

public class Room {

	private int number;
	private int stage;
	private boolean available;
	
	public Room(int number,int stage) {
		this.number = number;
		this.stage = stage;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Room [number=" + number + ", stage=" + stage + "]";
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
