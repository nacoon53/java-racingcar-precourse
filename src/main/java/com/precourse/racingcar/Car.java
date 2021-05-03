package com.precourse.racingcar;

public class Car {

	private String name;
	private int goCount;
	
	public Car(String name){
		this.name = name;
		this.goCount = 0;
	}
	
	public void goCountPlus() {
		this.goCount++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGoCount() {
		return goCount;
	}
	public void setGoCount(int goCount) {
		this.goCount = goCount;
	}
	
	
}
