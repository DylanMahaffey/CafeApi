package com.revature;

import java.util.HashSet;
import java.util.Set;

import com.revature.models.FoodItem;

public class Cafe {
	
	private Set<String> menu = new HashSet<String>();
	
	private static Cafe cafe;
	
	private Cafe() {
		menu.add("Apple");
		menu.add("Hotdog");
		menu.add("Hamburger");
		menu.add("Fries");
		menu.add("Cheesebuger");
		menu.add("Coke");
		menu.add("Water");
	}
	
	public static Cafe getCafe() {
		if (cafe == null) {
			cafe = new Cafe();
		}
		
		return cafe;
	}
	
	public Set<String> getMenuItems() {
		return this.menu;
	}
	
	public void addFood(FoodItem food) {
		menu.add(food.getFood());
	}
	public void upgradeFood(FoodItem food) {
		if (menu.contains(food.getFood())) {
			menu.remove(food.getFood());
			menu.add("Super " + food.getFood());
		}
	}
	public void deleteFood(FoodItem food) {
		if (menu.contains(food.getFood())) {
			menu.remove(food.getFood());
		}
	}

}