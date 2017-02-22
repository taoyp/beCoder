package com.taoyp.prac.containers;

import java.util.ArrayList;
import java.util.Iterator;

public class ContainerPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This class is used for Container!");
		
		showList();
		animalSays();
	}
	
	public static void showList(){
		ArrayList<Integer> ai = new ArrayList<Integer>();
		ai.add(123);
		ai.add(234);
		ai.add(345);
		
		for(int i=0;i<ai.size();i++){
			System.out.print(ai.get(i) + " ");
		}
		System.out.println();
		
		for(Integer i:ai){
			System.out.print(i + " ");
		}
		System.out.println();
		
		Iterator it = ai.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	public static void animalSays(){
		ArrayList<Animal> aa = new ArrayList<Animal>();
		aa.add(new Animal());
		aa.add(new Dog());
		aa.add(new Cat());
		
		Iterator it = aa.iterator();
		while(it.hasNext()){
			((Animal)it.next()).say();
		}
	}
}

class Animal{
	public void say(){
		System.out.println("An animal!");
	}
}
class Dog extends Animal{
	public void say(){
		System.out.println("A dog!");
	}
}
class Cat extends Animal{
	public void say(){
		System.out.println("A cat!");
	}
}
