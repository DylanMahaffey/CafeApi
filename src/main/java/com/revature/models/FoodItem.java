package com.revature.models;

public class FoodItem {
	private String food;
	public FoodItem(String food) {
		this.food = food;
	}
	public FoodItem() {
		super();
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "FoodItem [food=" + food + "]";
	}
	
}
