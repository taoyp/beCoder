package com.taoyp.prac.dept2;

public class Animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog spot = new Dog();
		spot.name = "spot";
		spot.says("Ruff!");
		
		Dog scruffy = new Dog();
		scruffy.name = "scruffy";
		scruffy.says("Wurf!");
		
		Dog newSpot = new Dog();
		newSpot.name = "spot";
		newSpot.says("Ruff!");
		System.out.println("newSpot==spot"+(spot==newSpot));
		System.out.println("newSpot==spot"+(spot.equals(newSpot)));
		
		newSpot = spot;
		System.out.println("newSpot==spot"+(spot==newSpot));
		System.out.println("newSpot==spot"+(spot.equals(newSpot)));
		
		System.out.println(true&false);
		System.out.println(true|false);
		System.out.println(true^false);
		
		float f = 0.01f;
		System.out.println(f);
		System.out.println(++f);
		
	}

}

class Dog{
	public String name;
	
	public void says(String voice){
		System.out.println("my name is "+ this.name + ", my voice is" + voice);
	}
}